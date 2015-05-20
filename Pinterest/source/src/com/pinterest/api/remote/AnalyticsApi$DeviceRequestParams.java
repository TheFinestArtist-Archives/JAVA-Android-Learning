// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.os.Build;
import com.pinterest.api.RequestParams;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Device;

public class a extends RequestParams
{

    public ()
    {
        a("app", String.valueOf(Device.getAppTypeInt()));
        a("app_version", ApplicationInfo.getVersionName());
        String s;
        if (Device.isOnWifi())
        {
            s = "Wifi";
        } else
        {
            s = Device.getCarrierName();
        }
        a("carrier", s);
        a("device_type", String.format("%s; %s", new Object[] {
            Build.DEVICE, android.os.RequestParams.a
        }));
    }
}
