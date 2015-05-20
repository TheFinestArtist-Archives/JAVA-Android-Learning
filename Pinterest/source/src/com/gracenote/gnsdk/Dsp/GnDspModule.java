// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Dsp;

import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.IGnModule;
import jni.dsp.GnsdkDsp;
import jni.manager.GnsdkHandle;

public final class GnDspModule
    implements IGnModule
{

    public com.gracenote.gnsdk.Metadata.GnTypes.SDK a;

    public GnDspModule()
    {
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.a;
        a = com.gracenote.gnsdk.Metadata.GnTypes.SDK.c;
    }

    public final com.gracenote.gnsdk.Metadata.GnTypes.SDK getSDK()
    {
        return a;
    }

    public final void initialize()
    {
        GnException.a(GnsdkDsp.gnsdk_dsp_initialize(GnSdk.d().a));
    }

    public final void shutdown()
    {
        GnException.a(GnsdkDsp.gnsdk_dsp_shutdown());
    }
}
