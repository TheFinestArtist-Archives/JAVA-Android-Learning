// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Iterator;

// Referenced classes of package com.gracenote.gnsdk.Metadata:
//            GnMetadataObject

public class GnValueIterator extends GnMetadataObject
    implements Iterator
{

    private Class a;
    private GnMetadataObject d;
    private int e;
    private int f;

    public boolean hasNext()
    {
        return e < f;
    }

    public Object next()
    {
        e = e + 1;
        GnMetadataObject gnmetadataobject;
        try
        {
            gnmetadataobject = d;
            int i = e;
            gnmetadataobject = (GnMetadataObject)a.getConstructor(new Class[] {
                com/gracenote/gnsdk/Metadata/GnMetadataObject, java/lang/Integer
            }).newInstance(new Object[] {
                gnmetadataobject, Integer.valueOf(i)
            });
        }
        catch (Exception exception)
        {
            System.out.println((new StringBuilder("Exception :")).append(exception.getMessage()).toString());
            return null;
        }
        return gnmetadataobject;
    }

    public void remove()
    {
    }
}
