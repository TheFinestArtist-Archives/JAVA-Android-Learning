// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnObject;
import jni.manager.GnsdkErrors;
import jni.manager.GnsdkHandle;
import jni.manager.GnsdkManager;

// Referenced classes of package com.gracenote.gnsdk.Metadata:
//            IGnMetadataObject

public class GnMetadataObject extends GnObject
    implements IGnMetadataObject
{

    static final boolean c;
    private String a;
    public GnsdkHandle b;

    protected GnMetadataObject()
    {
        a = null;
    }

    protected GnMetadataObject(GnMetadataObject gnmetadataobject)
    {
        a = null;
        GnException.a(GnsdkManager.gnsdk_manager_gdo_addref(gnmetadataobject.b.a));
        b = gnmetadataobject.b;
    }

    public GnMetadataObject(GnsdkHandle gnsdkhandle)
    {
        a = null;
        b = new GnsdkHandle(gnsdkhandle.a);
    }

    protected final String a(String s)
    {
        String as[] = new String[1];
        int i = GnsdkManager.gnsdk_manager_gdo_value_get(b.a, s, 1, as);
        if (i == GnsdkErrors.bz || i == GnsdkErrors.by)
        {
            return null;
        } else
        {
            GnException.a(i);
            return as[0];
        }
    }

    protected final void b()
    {
        int i = GnsdkManager.gnsdk_manager_gdo_release(b.a);
        if (!c && i != 0)
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    public GnTypes.GnMetadataObjectType getType()
    {
        String as[] = new String[1];
        GnException.a(GnsdkManager.gnsdk_manager_gdo_get_type(b.a, as));
        return GnTypes.GnMetadataObjectType.a(as[0]);
    }

    public String getValue(String s)
    {
        return a(s);
    }

    static 
    {
        boolean flag;
        if (!com/gracenote/gnsdk/Metadata/GnMetadataObject.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
