// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

// Referenced classes of package org.apache.commons.lang3:
//            SerializationException

public class SerializationUtils
{

    public SerializationUtils()
    {
    }

    public static Serializable clone(Serializable serializable)
    {
        Object obj;
        if (serializable == null)
        {
            return null;
        }
        obj = new ByteArrayInputStream(serialize(serializable));
        obj = new ClassLoaderAwareObjectInputStream(((InputStream) (obj)), serializable.getClass().getClassLoader());
        serializable = ((Serializable) (obj));
        Serializable serializable1 = (Serializable)((ClassLoaderAwareObjectInputStream) (obj)).readObject();
        try
        {
            ((ClassLoaderAwareObjectInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Serializable serializable)
        {
            throw new SerializationException("IOException on closing cloned object data InputStream.", serializable);
        }
        return serializable1;
        Object obj1;
        obj1;
        serializable = null;
_L4:
        throw new SerializationException("ClassNotFoundException while reading cloned object data", ((Throwable) (obj1)));
        obj1;
        obj = serializable;
        serializable = ((Serializable) (obj1));
_L1:
        if (obj != null)
        {
            try
            {
                ((ClassLoaderAwareObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Serializable serializable)
            {
                throw new SerializationException("IOException on closing cloned object data InputStream.", serializable);
            }
        }
        throw serializable;
        obj1;
        serializable = null;
_L2:
        throw new SerializationException("IOException while reading cloned object data", ((Throwable) (obj1)));
        serializable;
        obj = null;
          goto _L1
        obj1;
        serializable = ((Serializable) (obj));
          goto _L2
        obj1;
        serializable = ((Serializable) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Object deserialize(InputStream inputstream)
    {
        Object obj;
        Object obj1;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        obj = null;
        obj1 = null;
        inputstream = new ObjectInputStream(inputstream);
        obj = inputstream;
        obj1 = inputstream.readObject();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return obj1;
        }
        return obj1;
        obj1;
        inputstream = null;
_L4:
        obj = inputstream;
        throw new SerializationException(((Throwable) (obj1)));
        inputstream;
_L1:
        if (obj != null)
        {
            try
            {
                ((ObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw inputstream;
        inputstream;
        obj = obj1;
_L2:
        throw new SerializationException(inputstream);
        inputstream;
          goto _L1
        obj1;
        obj = inputstream;
        inputstream = ((InputStream) (obj1));
          goto _L2
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Object deserialize(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("The byte[] must not be null");
        } else
        {
            return deserialize(((InputStream) (new ByteArrayInputStream(abyte0))));
        }
    }

    public static void serialize(Serializable serializable, OutputStream outputstream)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(outputstream);
        outputstream = objectoutputstream;
        objectoutputstream.writeObject(serializable);
        try
        {
            objectoutputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Serializable serializable)
        {
            return;
        }
        serializable;
        outputstream = null;
_L4:
        throw new SerializationException(serializable);
        serializable;
_L2:
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream) { }
        }
        throw serializable;
        serializable;
        outputstream = null;
        if (true) goto _L2; else goto _L1
_L1:
        serializable;
        outputstream = objectoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static byte[] serialize(Serializable serializable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(512);
        serialize(serializable, ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }

    private class ClassLoaderAwareObjectInputStream extends ObjectInputStream
    {

        private ClassLoader classLoader;

        protected Class resolveClass(ObjectStreamClass objectstreamclass)
        {
            objectstreamclass = objectstreamclass.getName();
            Class class1;
            try
            {
                class1 = Class.forName(objectstreamclass, false, classLoader);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                return Class.forName(objectstreamclass, false, Thread.currentThread().getContextClassLoader());
            }
            return class1;
        }

        public ClassLoaderAwareObjectInputStream(InputStream inputstream, ClassLoader classloader)
        {
            super(inputstream);
            classLoader = classloader;
        }
    }

}
