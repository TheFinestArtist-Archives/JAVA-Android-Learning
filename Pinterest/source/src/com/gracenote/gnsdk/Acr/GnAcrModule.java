// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.IGnModule;
import jni.acr.GnsdkAcr;
import jni.manager.GnsdkHandle;

final class GnAcrModule
    implements IGnModule
{

    public com.gracenote.gnsdk.Metadata.GnTypes.SDK a;

    GnAcrModule()
    {
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.l;
    }

    public final com.gracenote.gnsdk.Metadata.GnTypes.SDK getSDK()
    {
        return a;
    }

    public final void initialize()
    {
        GnException.a(GnsdkAcr.gnsdk_acr_initialize(GnSdk.d().a));
    }

    public final void shutdown()
    {
        GnException.a(GnsdkAcr.gnsdk_acr_shutdown());
    }
}
