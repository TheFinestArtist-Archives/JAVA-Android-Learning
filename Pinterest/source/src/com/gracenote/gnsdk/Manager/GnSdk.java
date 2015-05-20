// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;

import com.gracenote.gnsdk.Manager.Android.GnApplicationContext;
import jni.manager.GnsdkHandle;
import jni.manager.GnsdkManager;

// Referenced classes of package com.gracenote.gnsdk.Manager:
//            GnSdkVersion, GnException, GnLogs, IGnModule, 
//            GnUser, GnLocale

public class GnSdk
{

    private static GnsdkHandle a = new GnsdkHandle();
    private static GnUser b = null;
    private static long c = 0L;
    private static com.gracenote.gnsdk.Metadata.GnTypes.SDK d;
    private static GnLogs e = null;
    private static Object f = new Object();
    private static GnLocale g;
    private static GnLocale h;
    private static GnLocale i;
    private static boolean j;
    private static GnApplicationContext k;

    private static Boolean a(com.gracenote.gnsdk.Metadata.GnTypes.SDK sdk)
    {
        boolean flag;
        if ((d.a() & sdk.a()) == sdk.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    static void a()
    {
        com/gracenote/gnsdk/Manager/GnSdk;
        JVM INSTR monitorenter ;
        c++;
        com/gracenote/gnsdk/Manager/GnSdk;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(GnApplicationContext gnapplicationcontext, String s, int l)
    {
        if (!a(com.gracenote.gnsdk.Metadata.GnTypes.SDK.b).booleanValue())
        {
            System.loadLibrary("gabi++_shared");
            if (System.getProperty("java.runtime.name").toLowerCase().indexOf("android runtime") >= 0)
            {
                System.loadLibrary((new StringBuilder("gnsdk_manager.")).append(GnSdkVersion.a).toString());
                j = true;
            } else
            {
                j = false;
            }
            System.loadLibrary("gnsdk_manager_jni");
            GnException.a(GnsdkManager.gnsdk_manager_initialize(a, s, l));
            d.a(d.a() | com.gracenote.gnsdk.Metadata.GnTypes.SDK.b.a());
            e = new GnLogs();
            k = new GnApplicationContext(null);
        }
        a();
        k = gnapplicationcontext;
    }

    public static void a(GnUser gnuser)
    {
        b = gnuser;
    }

    public static void a(IGnModule ignmodule)
    {
        com.gracenote.gnsdk.Metadata.GnTypes.SDK sdk;
        sdk = ignmodule.getSDK();
        if (a(sdk).booleanValue())
        {
            return;
        }
        _cls1.a[sdk.ordinal()];
        JVM INSTR tableswitch 1 14: default 96
    //                   1 124
    //                   2 159
    //                   3 194
    //                   4 229
    //                   5 264
    //                   6 299
    //                   7 334
    //                   8 369
    //                   9 404
    //                   10 439
    //                   11 474
    //                   12 509
    //                   13 544
    //                   14 579;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        ignmodule.initialize();
        ignmodule = d;
        int l = d.a();
        ignmodule.a(sdk.a() | l);
        return;
_L2:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_musicid.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_musicid_jni");
        continue; /* Loop/switch isn't completed */
_L3:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_musicid_file.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_musicid_file_jni");
        continue; /* Loop/switch isn't completed */
_L4:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_video.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_video_jni");
        continue; /* Loop/switch isn't completed */
_L5:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_epg.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_epg_jni");
        continue; /* Loop/switch isn't completed */
_L6:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_acr.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_acr_jni");
        continue; /* Loop/switch isn't completed */
_L7:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_storage_sqlite.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_storage_sqlite_jni");
        continue; /* Loop/switch isn't completed */
_L8:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_submit.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_submit_jni");
        continue; /* Loop/switch isn't completed */
_L9:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_link.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_link_jni");
        continue; /* Loop/switch isn't completed */
_L10:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_playlist.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_playlist_jni");
        continue; /* Loop/switch isn't completed */
_L11:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_musicid_match.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_musicid_match_jni");
        continue; /* Loop/switch isn't completed */
_L12:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_dsp.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_dsp_jni");
        continue; /* Loop/switch isn't completed */
_L13:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_moodgrid.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_moodgrid_jni");
        continue; /* Loop/switch isn't completed */
_L14:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_lookup_local.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_lookup_local_jni");
        continue; /* Loop/switch isn't completed */
_L15:
        if (j)
        {
            System.loadLibrary((new StringBuilder("gnsdk_lookup_fplocal.")).append(GnSdkVersion.a).toString());
        }
        System.loadLibrary("gnsdk_lookup_fplocal_jni");
        if (true) goto _L1; else goto _L16
_L16:
    }

    static void b()
    {
        com/gracenote/gnsdk/Manager/GnSdk;
        JVM INSTR monitorenter ;
        long l = c;
        if (l != 0L) goto _L2; else goto _L1
_L1:
        com/gracenote/gnsdk/Manager/GnSdk;
        JVM INSTR monitorexit ;
        return;
_L2:
        c--;
        if (0L == c)
        {
            d.b();
            GnException.a(GnsdkManager.gnsdk_manager_shutdown());
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static void c()
    {
        synchronized (f)
        {
            GnException.a(GnsdkManager.gnsdk_manager_locale_unset_group_default("gnsdk_locale_music"));
            h = null;
        }
        synchronized (f)
        {
            GnException.a(GnsdkManager.gnsdk_manager_locale_unset_group_default("gnsdk_locale_video"));
            g = null;
        }
        synchronized (f)
        {
            GnException.a(GnsdkManager.gnsdk_manager_locale_unset_group_default("gnsdk_locale_playlist"));
            i = null;
        }
        b = null;
        GnException.a(GnsdkManager.gnsdk_manager_release_callback());
        b();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public static GnsdkHandle d()
    {
        return a;
    }

    public static String e()
    {
        return GnsdkManager.gnsdk_manager_get_product_version();
    }

    public static GnApplicationContext f()
    {
        return k;
    }

    static 
    {
        d = com.gracenote.gnsdk.Metadata.GnTypes.SDK.a;
    }

    private class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[com.gracenote.gnsdk.Metadata.GnTypes.SDK.values().length];
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.d.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.e.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.f.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.k.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.l.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.m.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.g.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.h.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.i.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.j.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.c.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.n.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.o.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.gracenote.gnsdk.Metadata.GnTypes.SDK.p.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
