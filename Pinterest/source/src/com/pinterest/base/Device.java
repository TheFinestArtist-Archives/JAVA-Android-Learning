// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.util.Pair;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.pinterest.appwidget.MccMnc;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.schemas.event.AppType;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.base:
//            Application, CrashReporting, Events

public class Device
{

    public static final boolean GTE_KK;
    public static final boolean GTE_LP;
    private static final String STR_UNKNOWN = "Unknown";
    private static Boolean _hasBigScreen = null;
    private static Boolean _hasCamera = null;
    private static Boolean _isTablet = null;
    private static Boolean _loadBigImages = null;
    private static Integer _loadFactor = null;
    private static int _pageSize = -1;
    private static String _pageSizeString = "";
    private static float _screenDensity = 0.0F;
    private static int _screenDensityDpi = 0;
    private static int _screenHeightPixels = 0;
    private static int _screenWidthPixels = 0;
    private static MccMnc sMccMnc = null;
    public static int statusBarHeight;

    public Device()
    {
    }

    public static void copyToClipboard(Context context, String s)
    {
        ((ClipboardManager)context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(s, s));
    }

    public static float dpToPixel(float f)
    {
        return ((float)_screenDensityDpi / 160F) * f;
    }

    public static void forceSoftKeyboard(Activity activity, boolean flag)
    {
        activity = activity.getWindow();
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 2;
        }
        activity.setSoftInputMode(byte0);
    }

    public static AppType getAppType()
    {
        if (isTablet())
        {
            return AppType.ANDROID_TABLET;
        } else
        {
            return AppType.ANDROID_MOBILE;
        }
    }

    public static int getAppTypeInt()
    {
        return getAppType().getValue();
    }

    public static String getCarrierName()
    {
        TelephonyManager telephonymanager = (TelephonyManager)Application.context().getSystemService("phone");
        if (telephonymanager != null)
        {
            return telephonymanager.getNetworkOperatorName();
        } else
        {
            return "Unknown";
        }
    }

    public static String getClipboard()
    {
        android.text.ClipboardManager clipboardmanager = (android.text.ClipboardManager)PApplication.context().getSystemService("clipboard");
        if (clipboardmanager != null && clipboardmanager.getText() != null)
        {
            return clipboardmanager.getText().toString();
        } else
        {
            return "";
        }
    }

    public static String getDefaultEmailAddress()
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Account aaccount[] = AccountManager.get(Application.context()).getAccounts();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            if (pattern.matcher(account.name).matches())
            {
                return account.name;
            }
        }

        return null;
    }

    public static int getDefaultLoadFactor()
    {
        if (_loadFactor == null)
        {
            Integer integer = Integer.valueOf(Resources.configuration().screenLayout & 0xf);
            _loadFactor = integer;
            _loadFactor = Integer.valueOf(Math.max(integer.intValue(), 1));
        }
        return _loadFactor.intValue();
    }

    public static float getDensity()
    {
        return _screenDensity;
    }

    public static int getDensityDpi()
    {
        return _screenDensityDpi;
    }

    public static DisplayMetrics getDisplayMetrics()
    {
        return Application.context().getResources().getDisplayMetrics();
    }

    public static String getMemoryInfo()
    {
        Object obj = Runtime.getRuntime();
        long l = (((Runtime) (obj)).totalMemory() - ((Runtime) (obj)).freeMemory()) / 0x100000L;
        long l1 = ((Runtime) (obj)).maxMemory() / 0x100000L;
        obj = new StringBuilder("Memory usage ");
        ((StringBuilder) (obj)).append((float)l / (float)l1);
        ((StringBuilder) (obj)).append(" ");
        ((StringBuilder) (obj)).append("(");
        ((StringBuilder) (obj)).append("Used:").append(l).append("Mb");
        ((StringBuilder) (obj)).append(" ");
        ((StringBuilder) (obj)).append("Heap: ").append(l1).append("Mb");
        ((StringBuilder) (obj)).append(")");
        return ((StringBuilder) (obj)).toString();
    }

    public static String getNetworkOperator()
    {
        return ((TelephonyManager)Application.context().getSystemService("phone")).getNetworkOperator();
    }

    public static MccMnc getNetworkOperatorFromConfig()
    {
        if (sMccMnc == null)
        {
            Configuration configuration = Resources.configuration();
            sMccMnc = new MccMnc(configuration.mcc, configuration.mnc);
        }
        return sMccMnc;
    }

    public static int getPageSize()
    {
        if (_pageSize == -1)
        {
            initPageSize();
        }
        return _pageSize;
    }

    public static String getPageSizeString()
    {
        if (_pageSizeString.equals(""))
        {
            initPageSize();
        }
        return _pageSizeString;
    }

    public static float getScreenHeight()
    {
        return (float)_screenHeightPixels;
    }

    public static float getScreenWidth()
    {
        return (float)_screenWidthPixels;
    }

    public static int getStatusBarHeight()
    {
        if (statusBarHeight == 0)
        {
            int i = Application.context().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (i > 0)
            {
                statusBarHeight = Application.context().getResources().getDimensionPixelSize(i);
            }
        }
        return statusBarHeight;
    }

    public static String getUdid()
    {
        String s1 = Preferences.user().getString("udid", "");
        String s = s1;
        if (s1.length() == 0)
        {
            s = String.format("%s", new Object[] {
                UUID.randomUUID()
            });
            Preferences.user().set("udid", s);
        }
        return s;
    }

    public static boolean getUserProfile(Context context)
    {
        String s = getDefaultEmailAddress();
        context = context.getContentResolver().query(android.provider.ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        if (context == null)
        {
            return false;
        }
        if (context.getCount() > 0 && context.moveToFirst())
        {
            Pair pair = new Pair("display_name", context.getString(context.getColumnIndex("display_name")));
            if ("display_name".equals(pair.first) && pair.second != null && (pair.second instanceof String))
            {
                return !StringUtils.isNumeric(((String)pair.second).split(" ")[0]) && !StringUtils.isEmpty(s);
            }
        }
        context.close();
        return false;
    }

    public static boolean hasBigScreen()
    {
        if (_hasBigScreen == null)
        {
            Boolean boolean1 = Boolean.valueOf(isTablet());
            _hasBigScreen = boolean1;
            if (boolean1 == Boolean.FALSE)
            {
                boolean flag;
                if (getDensity() > 1.5F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                _hasBigScreen = Boolean.valueOf(flag);
            }
        }
        return _hasBigScreen.booleanValue();
    }

    public static final boolean hasCamera()
    {
        if (_hasCamera == null)
        {
            PackageManager packagemanager = PApplication.context().getPackageManager();
            boolean flag = packagemanager.hasSystemFeature("android.hardware.camera.front");
            boolean flag1 = packagemanager.hasSystemFeature("android.hardware.camera");
            if (flag || flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _hasCamera = Boolean.valueOf(flag);
        }
        return _hasCamera.booleanValue();
    }

    public static boolean hasHardwareMenuKey(Context context)
    {
        return ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean hasInternet()
    {
        return ((ConnectivityManager)Application.context().getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static void hideSoftKeyboard(View view)
    {
        if (view != null)
        {
            ((InputMethodManager)Application.context().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void init()
    {
        onConfigurationChanged(null);
        initPageSize();
    }

    public static void initPageSize()
    {
        if (isTablet())
        {
            _pageSize = 50;
        } else
        {
            _pageSize = 25;
        }
        _pageSizeString = String.valueOf(_pageSize);
    }

    public static boolean isLandscape()
    {
        return Resources.configuration().orientation == 2;
    }

    public static boolean isOnWifi()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)Application.context().getSystemService("connectivity")).getNetworkInfo(1);
        return networkinfo != null && networkinfo.isConnected();
    }

    public static boolean isPortrait()
    {
        return Resources.configuration().orientation == 1;
    }

    public static boolean isTablet()
    {
        if (_isTablet == null)
        {
            boolean flag;
            if ((Resources.configuration().screenLayout & 0xf) >= 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _isTablet = Boolean.valueOf(flag);
        }
        return _isTablet.booleanValue();
    }

    public static void lockToCurrentOrientation(Activity activity)
    {
        int i = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (isLandscape())
        {
            if (i == 0 || i == 1)
            {
                activity.setRequestedOrientation(0);
                return;
            } else
            {
                activity.setRequestedOrientation(8);
                return;
            }
        }
        if (i == 1 || i == 2)
        {
            activity.setRequestedOrientation(9);
            return;
        } else
        {
            activity.setRequestedOrientation(1);
            return;
        }
    }

    public static void logMemoryInfo()
    {
        CrashReporting.leaveBreadcrumb(getMemoryInfo());
    }

    public static void onConfigurationChanged(Configuration configuration)
    {
        configuration = getDisplayMetrics();
        _screenDensity = ((DisplayMetrics) (configuration)).density;
        _screenDensityDpi = ((DisplayMetrics) (configuration)).densityDpi;
        _screenWidthPixels = ((DisplayMetrics) (configuration)).widthPixels;
        _screenHeightPixels = ((DisplayMetrics) (configuration)).heightPixels;
        Events.post(new MetricsUpdateEvent());
    }

    public static float pixelsToDp(float f)
    {
        return f / ((float)_screenDensityDpi / 160F);
    }

    public static void resetToDefaultOrientation(Activity activity)
    {
        if (activity != null)
        {
            activity.setRequestedOrientation(-1);
        }
    }

    public static boolean shouldLoadBigImages()
    {
        if (_loadBigImages == null)
        {
            Boolean boolean1 = Boolean.valueOf(isTablet());
            _loadBigImages = boolean1;
            if (boolean1 == Boolean.FALSE)
            {
                boolean flag;
                if (getDensity() > 1.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                _loadBigImages = Boolean.valueOf(flag);
            }
        }
        return _loadBigImages.booleanValue();
    }

    public static void showSoftKeyboard(Dialog dialog)
    {
        dialog.getWindow().setSoftInputMode(4);
    }

    public static void showSoftKeyboard(View view)
    {
        ((InputMethodManager)Application.context().getSystemService("input_method")).showSoftInput(view, 1);
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        GTE_KK = flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        GTE_LP = flag;
    }

    private class MetricsUpdateEvent
    {

        public MetricsUpdateEvent()
        {
        }
    }

}
