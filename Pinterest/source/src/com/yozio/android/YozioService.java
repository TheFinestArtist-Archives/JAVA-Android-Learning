// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.yozio.android.async.Async;
import com.yozio.android.async.TrackAndroidAppInsallTask;
import com.yozio.android.async.TrackEventTask;
import com.yozio.android.async.TrackYozioDeeplinkWithMetaDataTask;
import com.yozio.android.helpers.MetaData;
import com.yozio.android.helpers.SystemInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.yozio.android:
//            Yozio

public class YozioService
{

    private static int $SWITCH_TABLE$com$yozio$android$Constants$LOG_LEVEL[];
    private static YozioService _instance = new YozioService();
    private String _appKey;
    private String _deviceId;
    private String _secretKey;

    static int[] $SWITCH_TABLE$com$yozio$android$Constants$LOG_LEVEL()
    {
        int ai[] = $SWITCH_TABLE$com$yozio$android$Constants$LOG_LEVEL;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[Constants.LOG_LEVEL.values().length];
        try
        {
            ai[Constants.LOG_LEVEL.DEBUG.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[Constants.LOG_LEVEL.ERROR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[Constants.LOG_LEVEL.INFO.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[Constants.LOG_LEVEL.VERBOSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[Constants.LOG_LEVEL.WARN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$yozio$android$Constants$LOG_LEVEL = ai;
        return ai;
    }

    private YozioService()
    {
    }

    public static YozioService getInstance()
    {
        return _instance;
    }

    public static void log(Constants.LOG_LEVEL log_level, String s)
    {
        getInstance().logToConsole(log_level, s);
    }

    public String getAppKey(Context context)
    {
        if (_appKey != null)
        {
            return _appKey;
        }
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            _appKey = context.getString("YozioAppKey");
            _secretKey = context.getString("YozioSecretKey");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Failed to get Yozio APP_KEY or SECREY_KEY from manifest.");
        }
        return _appKey;
    }

    public String getDeviceId(Context context)
    {
        if (_deviceId != null)
        {
            return _deviceId;
        } else
        {
            _deviceId = SystemInfo.getInstance().getYozioUDID(context);
            return _deviceId;
        }
    }

    protected void handleYozioDeeplink(Context context)
    {
        Object obj = ((Activity)context).getIntent();
        obj = MetaData.getInstance().getMetaDataFromDeeplinkUrl(((Intent) (obj)));
        if (((HashMap) (obj)).get("__ydl") != null)
        {
            trackYozioDeeplinkWithMetaData(context, ((HashMap) (obj)));
            String s = (String)((HashMap) (obj)).get("__yta");
            if (s != null)
            {
                startActivityWithMetaData(context, s, MetaData.getInstance().filterYozioSpecificParams(((HashMap) (obj))));
                return;
            }
        }
    }

    protected void initYozioDirectory(Context context)
    {
        context = new File((new StringBuilder()).append(context.getFilesDir()).append(File.separator).append("Yozio").toString());
        if (!context.exists())
        {
            context.mkdir();
        }
    }

    public void initialize(Context context)
    {
        validateKeys(context);
        initYozioDirectory(context);
        trackAllInstalls(context);
        handleYozioDeeplink(context);
    }

    protected void logToConsole(Constants.LOG_LEVEL log_level, String s)
    {
        if (!Yozio.YOZIO_ENABLE_LOGGING)
        {
            return;
        }
        switch ($SWITCH_TABLE$com$yozio$android$Constants$LOG_LEVEL()[log_level.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Log.v("YOZIO", s);
            return;

        case 2: // '\002'
            Log.d("YOZIO", s);
            return;

        case 3: // '\003'
            Log.i("YOZIO", s);
            return;

        case 4: // '\004'
            Log.w("YOZIO", s);
            return;

        case 5: // '\005'
            Log.e("YOZIO", s);
            break;
        }
    }

    protected void startActivityWithMetaData(Context context, String s, HashMap hashmap)
    {
        if (s == null)
        {
            log(Constants.LOG_LEVEL.ERROR, "startActivityWithMetaData, but activityClassName is null.");
            return;
        }
        String s1 = s.trim();
        if (s1.length() == 0)
        {
            log(Constants.LOG_LEVEL.ERROR, "startActivityWithMetaData, but activityClassName is empty.");
            return;
        }
        Iterator iterator;
        if (hashmap == null)
        {
            s = new HashMap();
        } else
        {
            s = hashmap;
        }
        hashmap = new Intent();
        hashmap.setAction("android.intent.action.VIEW");
        hashmap.setClassName(context.getPackageName(), s1);
        hashmap.addFlags(0x10000000);
        iterator = s.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                s.put("__yta", s1);
                try
                {
                    context.startActivity(hashmap);
                    trackEvent(context, "started_activity_with_meta_data", 1.0D, s);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (HashMap hashmap)
                {
                    log(Constants.LOG_LEVEL.ERROR, (new StringBuilder("Invalid activity name:[")).append(s1).append("]. Please check your configuration.").toString());
                }
                trackEvent(context, "started_activity_with_meta_data", 0.0D, s);
                return;
            }
            String s2 = (String)iterator.next();
            hashmap.putExtra(s2, (String)s.get(s2));
        } while (true);
    }

    protected void trackAllInstalls(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("come.yozio.android.PREFERENCES", 0);
        if (sharedpreferences.getBoolean("installTracked", false))
        {
            log(Constants.LOG_LEVEL.INFO, "installTracked already exists.");
            return;
        } else
        {
            log(Constants.LOG_LEVEL.INFO, "tracking new app install.");
            Async.getInstance().runTrackAppInstallTask(new TrackAndroidAppInsallTask(context));
            context = sharedpreferences.edit();
            context.putBoolean("installTracked", true);
            context.commit();
            return;
        }
    }

    public void trackEvent(Context context, String s, double d, HashMap hashmap)
    {
        Async.getInstance().runEventsTask(new TrackEventTask(context, s, d, hashmap));
    }

    protected void trackYozioDeeplinkWithMetaData(Context context, HashMap hashmap)
    {
        log(Constants.LOG_LEVEL.INFO, "tracking yozio deeplink with meta data");
        Async.getInstance().runTrackYozioDeeplinkWithMetaDataTask(new TrackYozioDeeplinkWithMetaDataTask(context, hashmap));
    }

    protected void validateKeys(Context context)
    {
        getAppKey(context);
        if (_appKey == null)
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Yozio APP_KEY cannot be nil. You can find your APP_KEY on the app overview page (Your App > Overview) on Yozio website.");
        }
        if (_appKey.contains("APP_KEY"))
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Please replace the APP_KEY with your own APP_KEY. You can find your APP_KEY on the app overview page (Your App > Overview) on Yozio website.");
        }
        if (_secretKey == null)
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Yozio SECRET_KEY cannot be nil. You can find your SECRET_KEY on the app overview page (Your App > Overview) on Yozio website.");
        }
        if (_secretKey.contains("SECRET_KEY"))
        {
            throw new IllegalArgumentException("!!!!!!!!!!!!!!!!!! Please replace the SECRET_KEY with your own SECRET_KEY. You can find your SECRET_KEY on the app overview page (Your App > Overview) on Yozio website.");
        } else
        {
            return;
        }
    }

}
