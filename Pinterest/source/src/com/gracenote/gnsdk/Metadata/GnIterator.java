// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;

import com.gracenote.gnsdk.Manager.GnException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.NoSuchElementException;
import jni.manager.GnsdkErrors;
import jni.manager.GnsdkHandle;
import jni.manager.GnsdkInt;
import jni.manager.GnsdkManager;

// Referenced classes of package com.gracenote.gnsdk.Metadata:
//            GnMetadataObject

public class GnIterator extends GnMetadataObject
    implements Iterator
{

    int a;
    private Class d;
    private int e;
    private String f;
    private boolean g;

    public GnIterator(GnMetadataObject gnmetadataobject, String s, String s1)
    {
        super(gnmetadataobject);
        e = 0;
        a = -1;
        try
        {
            f = s1;
            gnmetadataobject = new GnsdkInt();
            GnException.a(GnsdkManager.gnsdk_manager_gdo_child_count(super.b.a, s1, gnmetadataobject));
            a = ((GnsdkInt) (gnmetadataobject)).a[0];
            d = Class.forName(s);
            if (a > e)
            {
                g = true;
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GnMetadataObject gnmetadataobject)
        {
            System.out.println((new StringBuilder("Exception : ")).append(gnmetadataobject.getMessage()).toString());
        }
        g = false;
    }

    public boolean hasNext()
    {
        boolean flag;
        if (a > e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
        return flag;
    }

    public Object next()
    {
        Object obj;
        obj = null;
        e = e + 1;
        GnsdkHandle gnsdkhandle;
        int i;
        String s = f;
        i = e;
        gnsdkhandle = new GnsdkHandle();
        i = GnsdkManager.gnsdk_manager_gdo_child_get(super.b.a, s, i, gnsdkhandle);
        GnMetadataObject gnmetadataobject = ((GnMetadataObject) (obj));
        if (i == GnsdkErrors.bz) goto _L2; else goto _L1
_L1:
        int j = GnsdkErrors.by;
        if (i != j) goto _L4; else goto _L3
_L3:
        gnmetadataobject = ((GnMetadataObject) (obj));
_L2:
        if (gnmetadataobject != null) goto _L6; else goto _L5
_L5:
        throw new NoSuchElementException();
        obj;
_L7:
        System.out.println((new StringBuilder("Exception : ")).append(((Exception) (obj)).getMessage()).toString());
        return gnmetadataobject;
_L4:
        gnmetadataobject = new GnMetadataObject(gnsdkhandle);
          goto _L2
_L6:
        obj = (GnMetadataObject)d.getConstructor(new Class[] {
            com/gracenote/gnsdk/Metadata/GnMetadataObject
        }).newInstance(new Object[] {
            gnmetadataobject
        });
        return obj;
        obj;
        gnmetadataobject = null;
          goto _L7
    }

    public void remove()
    {
    }
}
