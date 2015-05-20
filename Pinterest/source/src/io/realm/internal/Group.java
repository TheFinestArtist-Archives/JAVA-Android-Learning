// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;

// Referenced classes of package io.realm.internal:
//            TightDB, Context, OutOfMemoryError, Table

public class Group
    implements Closeable
{

    private final Context context;
    protected boolean immutable;
    protected long nativePtr;

    public Group()
    {
        immutable = false;
        context = new Context();
        nativePtr = createNative();
        checkNativePtrNotZero();
    }

    Group(Context context1, long l, boolean flag)
    {
        context = context1;
        nativePtr = l;
        immutable = flag;
    }

    public Group(File file)
    {
        String s = file.getAbsolutePath();
        if (file.canWrite())
        {
            file = OpenMode.READ_WRITE;
        } else
        {
            file = OpenMode.READ_ONLY;
        }
        this(s, ((OpenMode) (file)));
    }

    public Group(String s)
    {
        this(s, OpenMode.READ_ONLY);
    }

    public Group(String s, OpenMode openmode)
    {
        if (openmode.equals(OpenMode.READ_ONLY))
        {
            immutable = true;
        } else
        {
            immutable = false;
        }
        context = new Context();
        nativePtr = createNative(s, openmode.value);
        checkNativePtrNotZero();
    }

    public Group(ByteBuffer bytebuffer)
    {
        immutable = false;
        context = new Context();
        if (bytebuffer != null)
        {
            nativePtr = createNative(bytebuffer);
            checkNativePtrNotZero();
            return;
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Group(byte abyte0[])
    {
        immutable = false;
        context = new Context();
        if (abyte0 != null)
        {
            nativePtr = createNative(abyte0);
            checkNativePtrNotZero();
            return;
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    private void checkNativePtrNotZero()
    {
        if (nativePtr == 0L)
        {
            throw new OutOfMemoryError("Out of native memory.");
        } else
        {
            return;
        }
    }

    protected static native void nativeClose(long l);

    protected static native long nativeLoadFromMem(byte abyte0[]);

    private void throwImmutable()
    {
        throw new IllegalStateException("Objects cannot be changed outside a transaction; see beginTransaction() for details.");
    }

    private void verifyGroupIsValid()
    {
        if (nativePtr == 0L)
        {
            throw new IllegalStateException("Illegal to call methods on a closed Group.");
        } else
        {
            return;
        }
    }

    public void close()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                nativeClose(nativePtr);
                nativePtr = 0L;
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void commit()
    {
        verifyGroupIsValid();
        nativeCommit(nativePtr);
    }

    protected native long createNative();

    protected native long createNative(String s, int i);

    protected native long createNative(ByteBuffer bytebuffer);

    protected native long createNative(byte abyte0[]);

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof Group)
            {
                obj = (Group)obj;
                return nativeEquals(nativePtr, ((Group) (obj)).nativePtr);
            }
        }
        return false;
    }

    protected void finalize()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                context.asyncDisposeGroup(nativePtr);
                nativePtr = 0L;
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Table getTable(String s)
    {
        verifyGroupIsValid();
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Invalid name. Name must be a non-empty String.");
        }
        if (immutable && !hasTable(s))
        {
            throw new IllegalStateException((new StringBuilder("Requested table is not in this Realm. Creating it requires a transaction: ")).append(s).toString());
        }
        context.executeDelayedDisposal();
        long l = nativeGetTableNativePtr(nativePtr, s);
        try
        {
            s = new Table(context, this, l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Table.nativeClose(l);
            throw s;
        }
        return s;
    }

    public String getTableName(int i)
    {
        verifyGroupIsValid();
        long l = size();
        if (i < 0 || (long)i >= l)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Table index argument is out of range. possible range is [0, ")).append(l - 1L).append("]").toString());
        } else
        {
            return nativeGetTableName(nativePtr, i);
        }
    }

    public boolean hasTable(String s)
    {
        verifyGroupIsValid();
        if (s == null)
        {
            return false;
        } else
        {
            return nativeHasTable(nativePtr, s);
        }
    }

    boolean isClosed()
    {
        return nativePtr == 0L;
    }

    public boolean isEmpty()
    {
        return size() == 0L;
    }

    protected native void nativeCommit(long l);

    protected native boolean nativeEquals(long l, long l1);

    protected native String nativeGetTableName(long l, int i);

    protected native long nativeGetTableNativePtr(long l, String s);

    protected native boolean nativeHasTable(long l, String s);

    protected native long nativeSize(long l);

    protected native String nativeToJson(long l);

    protected native String nativeToString(long l);

    protected native void nativeWriteToFile(long l, String s, byte abyte0[]);

    protected native byte[] nativeWriteToMem(long l);

    public long size()
    {
        verifyGroupIsValid();
        return nativeSize(nativePtr);
    }

    public String toJson()
    {
        return nativeToJson(nativePtr);
    }

    public String toString()
    {
        return nativeToString(nativePtr);
    }

    public void writeToFile(File file, byte abyte0[])
    {
        verifyGroupIsValid();
        if (file.isFile() && file.exists())
        {
            throw new IllegalArgumentException("The destination file must not exist");
        }
        if (abyte0 != null && abyte0.length != 64)
        {
            throw new IllegalArgumentException("Realm AES keys must be 64 bytes long");
        } else
        {
            nativeWriteToFile(nativePtr, file.getAbsolutePath(), abyte0);
            return;
        }
    }

    public byte[] writeToMem()
    {
        verifyGroupIsValid();
        return nativeWriteToMem(nativePtr);
    }

    static 
    {
        TightDB.loadLibrary();
    }

    private class OpenMode extends Enum
    {

        private static final OpenMode $VALUES[];
        public static final OpenMode READ_ONLY;
        public static final OpenMode READ_WRITE;
        public static final OpenMode READ_WRITE_NO_CREATE;
        private int value;

        public static OpenMode valueOf(String s)
        {
            return (OpenMode)Enum.valueOf(io/realm/internal/Group$OpenMode, s);
        }

        public static OpenMode[] values()
        {
            return (OpenMode[])$VALUES.clone();
        }

        static 
        {
            READ_ONLY = new OpenMode("READ_ONLY", 0, 0);
            READ_WRITE = new OpenMode("READ_WRITE", 1, 1);
            READ_WRITE_NO_CREATE = new OpenMode("READ_WRITE_NO_CREATE", 2, 2);
            $VALUES = (new OpenMode[] {
                READ_ONLY, READ_WRITE, READ_WRITE_NO_CREATE
            });
        }


        private OpenMode(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

}
