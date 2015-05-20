// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.pinterest.analytics.PerfBatcher;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Device;
import com.pinterest.gcm.GcmRegistrar;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsApi
{

    public static void a(BaseApiResponseHandler baseapiresponsehandler)
    {
        if (MyUser.hasAccessToken())
        {
            ApiHttpClient.get(ApiHttpClient.getAbsoluteLoggingApiUrl("callback/ping/"), baseapiresponsehandler, false, null);
        }
    }

    public static void a(String s)
    {
        try
        {
            ApiHttpClient.signedCall(ApiHttpClient.getAbsoluteLoggingApiUrl(String.format("register/track_action/%s/", new Object[] {
                s
            })), null, "POST", new TreeMap(), null, false, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static void a(String s, long l, boolean flag, String s1)
    {
        DeviceRequestParams devicerequestparams = new DeviceRequestParams();
        devicerequestparams.a("timing", String.valueOf(l));
        devicerequestparams.a("cached", String.valueOf(flag));
        if (s1 != null)
        {
            devicerequestparams.a("aux", s1);
        }
        if (Device.isOnWifi())
        {
            s1 = "wifi";
        } else
        {
            s1 = Device.getCarrierName();
        }
        devicerequestparams.a("carrier", s1);
        s = String.format("/v3/log/performance/%s/", new Object[] {
            s
        });
        PerfBatcher.a().a(s, devicerequestparams);
    }

    public static void a(String s, Bundle bundle)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("device_id", GcmRegistrar.b());
        if (bundle != null)
        {
            requestparams.a("push_id", bundle.getString("push_id"));
            requestparams.a("body", bundle.getString("payload"));
            requestparams.a("link", bundle.getString("link"));
        }
        ApiHttpClient.post(ApiHttpClient.getAbsoluteLoggingApiUrl(String.format("callback/push_notification/%s/", new Object[] {
            s
        })), requestparams, null, false, null);
    }

    public static void a(String s, String s1, Bitmap bitmap, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("title", s);
        requestparams.a("description", s1);
        requestparams.a("platform", "android");
        if (bitmap != null)
        {
            try
            {
                s = new ByteArrayOutputStream();
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, s);
                requestparams.a("image", new ByteArrayInputStream(s.toByteArray()), "screenshot.jpg", "image/jpeg");
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        ApiHttpClient.post(ApiHttpClient.getAbsoluteLoggingApiUrl("error/report/"), requestparams, baseapiresponsehandler, false, null);
    }

    public static void a(Map map, BaseApiResponseHandler baseapiresponsehandler)
    {
        try
        {
            ApiHttpClient.signedCall(ApiHttpClient.getAbsoluteLoggingApiUrl("callback/post_install/"), null, "POST", map, baseapiresponsehandler, false, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            CrashReporting.logHandledException(map);
        }
        map.printStackTrace();
    }

    public static void a(byte abyte0[], BaseApiResponseHandler baseapiresponsehandler)
    {
        try
        {
            String s = ApiHttpClient.getAbsoluteLoggingApiUrl("callback/event/");
            TreeMap treemap = new TreeMap();
            treemap.put("data", Base64.encodeToString(abyte0, 0));
            ApiHttpClient.signedCall(s, null, "POST", treemap, baseapiresponsehandler, false, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    public static void b(String s)
    {
        ApiHttpClient.post(ApiHttpClient.getAbsoluteLoggingApiUrl(String.format("callback/track_funnel/%s/", new Object[] {
            s
        })), null, false, null);
    }

    public static void c(String s)
    {
        a(String.format("%s%s", new Object[] {
            "pv_ph_", s
        }));
    }

    private class DeviceRequestParams extends RequestParams
    {

        public DeviceRequestParams()
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
                Build.DEVICE, android.os.Build.VERSION.RELEASE
            }));
        }
    }

}
