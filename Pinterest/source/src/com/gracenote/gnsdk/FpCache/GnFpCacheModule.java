// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.FpCache;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.IGnModule;
import jni.lookup_fplocal.GnsdkLookupFpLocal;
import jni.manager.GnsdkHandle;

public final class GnFpCacheModule
    implements IGnModule
{

    public com.gracenote.gnsdk.Metadata.GnTypes.SDK a;

    public GnFpCacheModule()
    {
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.p;
    }

    public final com.gracenote.gnsdk.Metadata.GnTypes.SDK getSDK()
    {
        return a;
    }

    public final void initialize()
    {
        GnException.a(GnsdkLookupFpLocal.gnsdk_lookup_fplocal_initialize(GnSdk.d().a));
    }

    public final void shutdown()
    {
        GnException.a(GnsdkLookupFpLocal.gnsdk_lookup_fplocal_shutdown());
    }
}
