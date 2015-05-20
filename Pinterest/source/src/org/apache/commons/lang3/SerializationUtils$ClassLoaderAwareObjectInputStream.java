// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class classLoader extends ObjectInputStream
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

    public (InputStream inputstream, ClassLoader classloader)
    {
        super(inputstream);
        classLoader = classloader;
    }
}
