// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Acr;

import com.gracenote.gnsdk.Manager.GnUser;

// Referenced classes of package com.gracenote.gnsdk.Acr:
//            GnAcrQueryHandle, GnAcrAudioConfig, IGnAcrDelegate

public class GnAcr
{

    private GnAcrQueryHandle a;
    private GnAcrAudioConfig b;

    public GnAcr(GnUser gnuser, IGnAcrDelegate ignacrdelegate)
    {
        a = null;
        b = null;
        a = new GnAcrQueryHandle(gnuser, ignacrdelegate);
    }

    public final void a()
    {
        a.a();
    }

    public final void a(GnAcrAudioConfig gnacraudioconfig)
    {
        b = gnacraudioconfig;
        a.a(gnacraudioconfig);
    }

    public final void a(String s)
    {
        a.a("gnsdk_acr_optimize", s);
    }

    public final void a(byte abyte0[], int i)
    {
        a.a(abyte0, i);
    }

    public final String b()
    {
        return a.a("gnsdk_acr_optimize");
    }

    public final void c()
    {
        a.a("gnsdk_acr_option_enable_xids", Integer.toString(1));
    }
}
