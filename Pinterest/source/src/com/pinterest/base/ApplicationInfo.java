// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.receiver.SignupNotificationReceiver;
import com.yozio.android.Yozio;
import java.security.MessageDigest;
import java.util.Timer;
import java.util.UUID;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

public class ApplicationInfo
{

    private static final int REPORT_INSTALL_DELAY = 15000;
    private static final long STALE_THRESHOLD_HOURS = 0xa4cb80L;
    private static final long TIME_OUT_MS = 1000L;
    private static final String VERSION_NAME_FORMAT = "%s.%s.%s";
    private static State _appState;
    private static Timer _appStateTimer;
    private static Handler _handler = new Handler(Looper.getMainLooper());
    private static String _installId;
    private static Runnable _reportInstall = new _cls2();
    private static String _versionName;

    public ApplicationInfo()
    {
    }

    public static void ensureInstallId()
    {
        if (!TextUtils.isEmpty(getInstallId()))
        {
            return;
        }
        try
        {
            String s = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "").substring(0, 26);
            String s1 = (new StringBuilder()).append(s).append("user").toString();
            s1 = new String(Hex.encodeHex(MessageDigest.getInstance("MD5").digest(s1.getBytes("UTF-8"))));
            s = (new StringBuilder()).append(s).append(s1.substring(27)).toString();
            Preferences.persisted().set("PREF_INSTALL_ID", s);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static final String getClientSecret()
    {
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj = Resources.bitmap(0x7f0200db, ((android.graphics.BitmapFactory.Options) (obj)));
        if (obj == null)
        {
            return null;
        }
        char ac[] = new char[56];
        for (int i = 0; i < 56; i++)
        {
            ac[i] = (char)(((Bitmap) (obj)).getPixel(0, i) & 0xff);
        }

        return StringUtils.reverse(new String(Base64.decode(String.valueOf(ac), 0)));
    }

    public static String getInstallId()
    {
        if (StringUtils.isBlank(_installId))
        {
            _installId = Preferences.persisted().getString("PREF_INSTALL_ID", "");
        }
        return _installId;
    }

    public static State getState()
    {
        return _appState;
    }

    public static int getVersionCode()
    {
        return 461;
    }

    public static String getVersionName()
    {
        if (_versionName != null) goto _L2; else goto _L1
_L1:
        if (!isNonProduction()) goto _L4; else goto _L3
_L3:
        _versionName = "4.6.1";
_L2:
        return _versionName;
_L4:
        int i = getVersionCode();
        if (i != -1)
        {
            String s = String.valueOf(i);
            int j = s.length();
            char c;
            char c1;
            if (j == 2)
            {
                c = '0';
            } else
            {
                c = s.charAt(j - 1);
            }
            if (j == 2)
            {
                i = j - 1;
            } else
            {
                i = j - 2;
            }
            c1 = s.charAt(i);
            if (j == 2)
            {
                i = 1;
            } else
            {
                i = j - 2;
            }
            _versionName = String.format("%s.%s.%s", new Object[] {
                s.substring(0, i), Character.valueOf(c1), Character.valueOf(c)
            });
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static boolean isNonProduction()
    {
        return isPrerelease();
    }

    public static boolean isOta()
    {
        return "production".contains("ota");
    }

    public static boolean isPreinstalled()
    {
        return "production".toLowerCase().contains("preinstall");
    }

    public static boolean isPrerelease()
    {
        return !"production".contains("production") && !"production".contains("preinstall");
    }

    public static boolean isRealWorldDiscover()
    {
        return "production".contains("rwd");
    }

    public static boolean isStale(Bundle bundle)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (bundle != null)
        {
            long l = SystemClock.elapsedRealtime();
            flag = flag1;
            if (l - bundle.getLong("PREF_LAST_SAVED_INSTANCE_TIME", l) > 0xa4cb80L)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void onBackground()
    {
        if (_appStateTimer != null)
        {
            _appStateTimer.cancel();
            _appStateTimer = null;
        }
        Timer timer = new Timer();
        _appStateTimer = timer;
        timer.schedule(new _cls1(), 1000L);
    }

    public static void onForeground()
    {
        if (_appStateTimer != null)
        {
            _appStateTimer.cancel();
            _appStateTimer = null;
        }
        _appState = State.FOREGROUND;
    }

    public static void reportInstall(Activity activity)
    {
        Yozio.initialize(activity);
        if (!isNonProduction())
        {
            Yozio.YOZIO_ENABLE_LOGGING = false;
        }
        if (Preferences.persisted().getBoolean("PREF_FIRST_LAUNCH", true))
        {
            SignupNotificationReceiver.a(0x36ee80L);
            _handler.removeCallbacks(_reportInstall);
            _handler.postDelayed(_reportInstall, 15000L);
        }
    }

    static 
    {
        _appState = State.BACKGROUND;
    }


/*
    static State access$002(State state)
    {
        _appState = state;
        return state;
    }

*/

    private class _cls1 extends TimerTask
    {

        public final void run()
        {
            ApplicationInfo._appState = State.BACKGROUND;
        }

        _cls1()
        {
        }
    }


    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State BACKGROUND;
        public static final State FOREGROUND;
        private final String _apiHeader;
        private final EventAppState _contextEnum;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/pinterest/base/ApplicationInfo$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        public final String getApiHeader()
        {
            return _apiHeader;
        }

        public final EventAppState getContextEnum()
        {
            return _contextEnum;
        }

        static 
        {
            FOREGROUND = new State("FOREGROUND", 0, "active", EventAppState.ACTIVE);
            BACKGROUND = new State("BACKGROUND", 1, "background", EventAppState.BACKGROUND);
            $VALUES = (new State[] {
                FOREGROUND, BACKGROUND
            });
        }

        private State(String s, int i, String s1, EventAppState eventappstate)
        {
            super(s, i);
            _apiHeader = s1;
            _contextEnum = eventappstate;
        }
    }


    private class _cls2
        implements Runnable
    {

        public final void run()
        {
            TreeMap treemap = new TreeMap();
            String s = Preferences.persisted().getString("PREF_YOZIO_DATA", null);
            if (s != null)
            {
                treemap.put("data", s);
                PLog.a("YOZIO_METADATA submitting: %s", new Object[] {
                    s
                });
            }
            class _cls1 extends BaseApiResponseHandler
            {

                final _cls2 this$0;

                public void onSuccess(PinterestJsonObject pinterestjsonobject)
                {
                    super.onSuccess(pinterestjsonobject);
                    PLog.a("Report install successful", new Object[0]);
                    AnalyticsApi.a("yozio_submit");
                    Preferences.persisted().set("PREF_FIRST_LAUNCH", false);
                }

                _cls1()
                {
                    this$0 = _cls2.this;
                    super();
                }
            }

            AnalyticsApi.a(treemap, new _cls1());
        }

        _cls2()
        {
        }
    }

}
