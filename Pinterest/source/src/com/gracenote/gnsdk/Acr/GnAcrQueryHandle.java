// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;

import com.gracenote.gnsdk.Dsp.GnDspModule;
import com.gracenote.gnsdk.FpCache.GnFpCacheModule;
import com.gracenote.gnsdk.Manager.GnException;
import com.gracenote.gnsdk.Manager.GnObject;
import com.gracenote.gnsdk.Manager.GnSdk;
import com.gracenote.gnsdk.Manager.GnUser;
import com.gracenote.gnsdk.Manager.GnUserHandle;
import com.gracenote.gnsdk.StorageSqlite.GnStorageSqliteModule;
import jni.acr.GnsdkAcr;
import jni.manager.GnsdkHandle;

// Referenced classes of package com.gracenote.gnsdk.Acr:
//            GnAcrModule, GnAcrAudioConfig, IGnAcrDelegate

public class GnAcrQueryHandle extends GnObject
{

    private GnsdkHandle a;
    private jni.acr.GnsdkAcr.gnsdk_acr_callbacks_t b;

    protected GnAcrQueryHandle(GnUser gnuser, IGnAcrDelegate ignacrdelegate)
    {
        GnSdk.a(new GnDspModule());
        GnSdk.a(new GnStorageSqliteModule());
        GnSdk.a(new GnFpCacheModule());
        GnSdk.a(new GnAcrModule());
        gnuser = gnuser.b().c();
        a = new GnsdkHandle();
        if (ignacrdelegate != null)
        {
            b = new _cls1(ignacrdelegate);
            GnException.a(GnsdkAcr.gnsdk_acr_query_create(((GnsdkHandle) (gnuser)).a, b, null, a));
            return;
        } else
        {
            throw new GnException("Exception in IGnAcrDelegate");
        }
    }

    protected final String a(String s)
    {
        String as[] = new String[1];
        GnException.a(GnsdkAcr.gnsdk_acr_query_option_get(a.a, s, as));
        return as[0];
    }

    protected final void a()
    {
        GnException.a(GnsdkAcr.gnsdk_acr_query_release(a.a, b));
    }

    protected final void a(GnAcrAudioConfig gnacraudioconfig)
    {
        GnException.a(GnsdkAcr.gnsdk_acr_query_init_audio_stream(a.a, gnacraudioconfig.a(), gnacraudioconfig.c(), gnacraudioconfig.b(), gnacraudioconfig.d()));
    }

    protected final void a(String s, String s1)
    {
        GnException.a(GnsdkAcr.gnsdk_acr_query_option_set(a.a, s, s1));
    }

    protected final void a(byte abyte0[], int i)
    {
        GnException.a(GnsdkAcr.gnsdk_acr_query_write_audio_data(a.a, abyte0, i, 0L));
    }

    protected final void b()
    {
    }

    private class _cls1
        implements jni.acr.GnsdkAcr.gnsdk_acr_callbacks_t
    {

        final IGnAcrDelegate a;
        final GnAcrQueryHandle b;

        _cls1(IGnAcrDelegate ignacrdelegate)
        {
            b = GnAcrQueryHandle.this;
            a = ignacrdelegate;
            super();
        }
    }

}
