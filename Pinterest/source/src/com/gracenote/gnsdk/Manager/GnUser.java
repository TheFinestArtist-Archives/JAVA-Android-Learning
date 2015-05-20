// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Manager;


// Referenced classes of package com.gracenote.gnsdk.Manager:
//            GnUserHandle, IGnSdkInfo

public class GnUser
{

    GnUserHandle a;

    public GnUser(com.gracenote.gnsdk.Metadata.GnTypes.GnUserRegisterMode gnuserregistermode, String s, String s1, String s2)
    {
        a = null;
        a = new GnUserHandle(gnuserregistermode, s, s1, s2);
        c();
    }

    public GnUser(String s)
    {
        a = null;
        a = new GnUserHandle(s);
        c();
    }

    private static void c()
    {
        if (!d())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        IGnSdkInfo ignsdkinfo = (IGnSdkInfo)Class.forName("com.gracenote.gnsdk.Manager.Android.GnAndroidSdkInfo").newInstance();
        GnUserHandle.a("gnsdk_useroption_info_uid", ignsdkinfo.getUID());
        GnUserHandle.a("gnsdk_useroption_info_os", ignsdkinfo.getOS());
        GnUserHandle.a("gnsdk_useroption_info_mfg", ignsdkinfo.getMFG());
        GnUserHandle.a("gnsdk_useroption_info_sdk", ignsdkinfo.getSDK());
        return;
        Exception exception;
        exception;
    }

    private static boolean d()
    {
        try
        {
            Class.forName("com.gracenote.gnsdk.Manager.Android.GnAndroidSdkInfo");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public final String a()
    {
        return a.a();
    }

    public final GnUserHandle b()
    {
        return a;
    }
}
