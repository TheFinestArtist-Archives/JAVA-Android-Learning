// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;

import jni.manager.GnsdkHandle;
import jni.manager.GnsdkManager;

// Referenced classes of package com.gracenote.gnsdk.Manager:
//            GnObject, GnException

public class GnUserHandle extends GnObject
{

    private GnsdkHandle a;
    private String b;

    protected GnUserHandle()
    {
        a = null;
        b = null;
    }

    GnUserHandle(com.gracenote.gnsdk.Metadata.GnTypes.GnUserRegisterMode gnuserregistermode, String s, String s1, String s2)
    {
        a = null;
        b = null;
        a = new GnsdkHandle();
        String as[] = new String[1];
        GnException.a(GnsdkManager.gnsdk_manager_user_register(gnuserregistermode.a(), s, s1, s2, as));
        b = as[0];
        GnException.a(GnsdkManager.gnsdk_manager_user_create(b, s, a));
    }

    GnUserHandle(String s)
    {
        a = null;
        b = null;
        a = new GnsdkHandle();
        b = s;
        GnException.a(GnsdkManager.gnsdk_manager_user_create(b, null, a));
    }

    protected static void a(String s, String s1)
    {
        GnException.a(GnsdkManager.gnsdk_manager_user_option_set(null, s, s1));
    }

    public final String a()
    {
        return b;
    }

    protected final void b()
    {
        GnsdkManager.gnsdk_manager_user_release(a.a);
    }

    public final GnsdkHandle c()
    {
        return a;
    }
}
