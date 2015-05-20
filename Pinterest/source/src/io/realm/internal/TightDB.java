// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package io.realm.internal:
//            Version

public class TightDB
{

    private static final String BINARIES_PATH;
    private static final String FILE_SEP;
    private static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final String PATH_SEP;
    private static AtomicBoolean libraryIsLoaded = new AtomicBoolean(false);

    public TightDB()
    {
    }

    public static void addNativeLibraryPath(String s)
    {
        try
        {
            System.setProperty("java.library.path", (new StringBuilder()).append(System.getProperty("java.library.path")).append(PATH_SEP).append(s).append(PATH_SEP).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Cannot set the library path!", s);
        }
    }

    public static Serializable deserialize(ByteBuffer bytebuffer)
    {
        return deserialize(bytebuffer.array());
    }

    public static Serializable deserialize(byte abyte0[])
    {
        try
        {
            abyte0 = new ObjectInputStream(new ByteArrayInputStream(abyte0));
            Object obj = abyte0.readObject();
            abyte0.close();
            abyte0 = (Serializable)obj;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Cannot deserialize the object!", abyte0);
        }
        return abyte0;
    }

    public static void gcGuaranteed()
    {
        for (WeakReference weakreference = new WeakReference(new Object()); weakreference.get() != null; System.gc()) { }
    }

    public static void gcOnExit()
    {
        Runtime.getRuntime().addShutdownHook(new _cls1());
    }

    private static void initTightDB()
    {
        gcOnExit();
    }

    private static transient String loadCorrectLibrary(String as[])
    {
        int i;
        int j;
        j = as.length;
        i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i];
        System.loadLibrary(s);
        return s;
        Throwable throwable;
        throwable;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    public static void loadLibrary()
    {
        if (libraryIsLoaded.get())
        {
            return;
        }
        initTightDB();
        if (osIsWindows())
        {
            loadLibraryWindows();
        } else
        {
            String s = System.getenv("TIGHTDB_JAVA_DEBUG");
            if (s == null || s.isEmpty())
            {
                s = "tightdb-jni";
            } else
            {
                s = "tightdb-jni-dbg";
            }
            System.loadLibrary(s);
        }
        libraryIsLoaded.set(true);
        Version.coreLibVersionCompatible(true);
    }

    private static String loadLibraryWindows()
    {
        String s;
        try
        {
            addNativeLibraryPath(BINARIES_PATH);
            resetLibraryPath();
        }
        catch (Throwable throwable) { }
        s = loadCorrectLibrary(new String[] {
            "tightdb_jni32d", "tightdb_jni64d"
        });
        if (s != null)
        {
            System.out.println("!!! TightDB debug version loaded. !!!\n");
        } else
        {
            String s1 = loadCorrectLibrary(new String[] {
                "tightdb_jni32", "tightdb_jni64"
            });
            s = s1;
            if (s1 == null)
            {
                System.err.println((new StringBuilder("Searched java.library.path=")).append(System.getProperty("java.library.path")).toString());
                throw new RuntimeException("Couldn't load the TightDB JNI library 'tightdb_jni32.dll or tightdb_jni64.dll'. Please include the directory to the library in java.library.path.");
            }
        }
        return s;
    }

    public static boolean osIsWindows()
    {
        return System.getProperty("os.name").toLowerCase(Locale.getDefault()).indexOf("win") >= 0;
    }

    private static void resetLibraryPath()
    {
        try
        {
            Field field = java/lang/ClassLoader.getDeclaredField("sys_paths");
            field.setAccessible(true);
            field.set(null, null);
            return;
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Cannot reset the library path!", exception);
        }
    }

    public static byte[] serialize(Serializable serializable)
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(serializable);
            objectoutputstream.close();
            serializable = bytearrayoutputstream.toByteArray();
        }
        // Misplaced declaration of an exception variable
        catch (Serializable serializable)
        {
            throw new RuntimeException("Cannot serialize the object!", serializable);
        }
        return serializable;
    }

    static 
    {
        FILE_SEP = File.separator;
        PATH_SEP = File.pathSeparator;
        BINARIES_PATH = (new StringBuilder("lib")).append(PATH_SEP).append("..").append(FILE_SEP).append("lib").toString();
    }

    private class _cls1 extends Thread
    {

        public final void run()
        {
            TightDB.gcGuaranteed();
        }

        _cls1()
        {
        }
    }

}
