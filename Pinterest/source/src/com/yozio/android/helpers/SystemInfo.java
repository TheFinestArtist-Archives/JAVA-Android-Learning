// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.yozio.android.YozioService;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class SystemInfo
{

    private static SystemInfo _instance = new SystemInfo();
    private HashMap _systemDictionary;

    private SystemInfo()
    {
    }

    public static SystemInfo getInstance()
    {
        return _instance;
    }

    public long getCurrentTimeLong()
    {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
    }

    public String getDeviceType(Context context)
    {
        if (((TelephonyManager)context.getSystemService("phone")).getPhoneType() == 0)
        {
            return "tablet";
        } else
        {
            return "phone";
        }
    }

    public String getMacAddress(Context context)
    {
        context = (WifiManager)context.getSystemService("wifi");
        if (context != null)
        {
            context = context.getConnectionInfo();
            if (context != null)
            {
                return context.getMacAddress();
            }
        }
        return null;
    }

    public PackageInfo getPackageInfo(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "failed to get PackageInfo!");
            return null;
        }
        return context;
    }

    public HashMap getSystemDictionary(Context context)
    {
        if (_systemDictionary != null)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "_systemDictionary already initialized");
            return _systemDictionary;
        }
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "initializing new _systemDictionary");
        _systemDictionary = new HashMap();
        _systemDictionary.put("fingerprint", Build.FINGERPRINT);
        _systemDictionary.put("product", Build.PRODUCT);
        _systemDictionary.put("model", Build.MODEL);
        _systemDictionary.put("board", Build.BOARD);
        _systemDictionary.put("brand", Build.BRAND);
        _systemDictionary.put("device", Build.DEVICE);
        _systemDictionary.put("device_type", getDeviceType(context));
        _systemDictionary.put("display", Build.DISPLAY);
        _systemDictionary.put("time", String.valueOf(Build.TIME));
        _systemDictionary.put("cpu_abi", Build.CPU_ABI);
        _systemDictionary.put("manufacturer", Build.MANUFACTURER);
        _systemDictionary.put("hardware", Build.MODEL);
        _systemDictionary.put("os", "android");
        _systemDictionary.put("os_version", android.os.Build.VERSION.RELEASE);
        _systemDictionary.put("country", Locale.getDefault().getDisplayCountry());
        _systemDictionary.put("country_code", Locale.getDefault().getCountry());
        _systemDictionary.put("language", Locale.getDefault().getLanguage());
        PackageInfo packageinfo = getPackageInfo(context);
        if (packageinfo != null)
        {
            _systemDictionary.put("app_name", packageinfo.packageName);
            _systemDictionary.put("app_version", packageinfo.versionName);
        }
        _systemDictionary.put("time_zone_abbr", TimeZone.getDefault().getDisplayName(false, 0, Locale.getDefault()));
        _systemDictionary.put("android_id", android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
        _systemDictionary.put("yozio_udid", getYozioUDID(context));
        context = getMacAddress(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        _systemDictionary.put("mac_address", context);
_L2:
        _systemDictionary.put("yozio_sdk_version", "yozio-android-1.1.10");
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("_systemDictionary: ")).append(_systemDictionary.toString()).toString());
        return _systemDictionary;
        context;
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.WARN, context.getMessage());
        if (context.getMessage().indexOf("ACCESS_WIFI_STATE") > 0)
        {
            _systemDictionary.put("mac_address", "N/A");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getUserAgent(Context context)
    {
        context = getPackageInfo(context);
        if (context != null)
        {
            return (new StringBuilder(String.valueOf(((PackageInfo) (context)).packageName))).append(' ').append(((PackageInfo) (context)).versionName).toString();
        } else
        {
            return "Yozio Android SDK";
        }
    }

    public String getYozioUDID(Context context)
    {
        Object obj;
label0:
        {
            Object obj1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (obj1 != null && !((String) (obj1)).equals("9774d56d682e549c"))
            {
                obj = obj1;
                if (((String) (obj1)).length() >= 15)
                {
                    break label0;
                }
            }
            obj1 = context.getSharedPreferences("come.yozio.android.PREFERENCES", 0);
            context = ((SharedPreferences) (obj1)).getString("yozioudid", null);
            obj = context;
            if (context == null)
            {
                obj = (new BigInteger(64, new SecureRandom())).toString(16);
                context = ((SharedPreferences) (obj1)).edit();
                context.putString("yozioudid", ((String) (obj)));
                context.commit();
            }
        }
        return ((String) (obj));
    }

}
