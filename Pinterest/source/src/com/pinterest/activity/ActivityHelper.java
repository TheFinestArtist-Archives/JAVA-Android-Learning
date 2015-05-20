// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.pinterest.activity.create.CreateActivity;
import com.pinterest.activity.create.PinEditActivity;
import com.pinterest.activity.create.RepinActivity;
import com.pinterest.activity.create.fragment.BoardPickerFragment;
import com.pinterest.activity.create.helper.CreateImageHelper;
import com.pinterest.activity.nux.NUXActivity;
import com.pinterest.activity.pin.PinActivity;
import com.pinterest.activity.signin.RakutenAuthActivity;
import com.pinterest.activity.signin.TwitterAuthActivity;
import com.pinterest.activity.signin.dialog.LoginDialog;
import com.pinterest.activity.signin.dialog.SignupDialog;
import com.pinterest.activity.task.activity.MainActivity;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.unauth.UnauthWallActivity;
import com.pinterest.activity.user.UserSetImageActivity;
import com.pinterest.activity.web.WebViewActivity;
import com.pinterest.activity.webhook.WebhookActivity;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Place;
import com.pinterest.api.remote.AccountApi;
import com.pinterest.appwidget.PWidgetHelper;
import com.pinterest.base.Application;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Social;
import com.pinterest.experience.Experiences;
import com.pinterest.experiment.Experiments;
import com.pinterest.gcm.GcmRegistrar;
import com.pinterest.kit.application.PApplication;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.notification.NotificationHelper;
import com.pinterest.kit.utils.AppUtils;
import com.pinterest.receiver.GlobalDataUpdateReceiver;
import com.pinterest.sdk.PinterestOauthActivity;
import com.pinterest.ui.notify.PinterestDialog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity:
//            PinterestActivity

public class ActivityHelper
{

    public static final int REQUEST_ACCOUNT_PICKER = 105;
    public static final int REQUEST_EDIT = 10300;
    public static final int REQUEST_GPLUS = 103;
    public static final int REQUEST_GPLUS_USER = 104;
    public static final int REQUEST_RAKUTEN = 102;
    public static final int REQUEST_SEND_SMS = 106;
    public static final int REQUEST_TWITTER = 101;
    public static final int RESULT_DELETE = 10400;
    private static final String TEST_ACCESS_TOKEN = "MTQzMTU5ODoxMTA0NzkxMzQ1MTczNjg1Njk6MnwxMzQ2OTY5MjY5OjAtLWRiNTg3NWE2MjQ2ZDgyMGUwNDU1OThkNDA5ZDk5ZDU5MTc4Yjg0ZjY=";

    public ActivityHelper()
    {
    }

    private static void doCustomShare(final Context context, final Intent intent, final String toShare)
    {
        final PackageManager pm = Application.context().getPackageManager();
        final List apps = pm.queryIntentActivities(intent, 0x10000);
        filterApps(apps);
        CreateImageHelper.showAppListDialog(context, pm, apps, new _cls1());
    }

    public static void doLogout(Activity activity)
    {
        doLogout(activity, true);
    }

    public static void doLogout(Activity activity, boolean flag)
    {
        AccountApi.a();
        if (flag)
        {
            try
            {
                GcmRegistrar.a();
            }
            catch (Exception exception) { }
        }
        GlobalDataUpdateReceiver.b();
        DiskCache.clean();
        Social.init();
        MyUser.onLogout();
        Experiences.b();
        Experiments.s();
        BoardPickerFragment.clear();
        NotificationHelper.cancelAll();
        goRoot(activity);
        activity.finish();
        PWidgetHelper.notifyWidgetStateChange(activity);
        ModelHelper.removeAllData();
        if (flag)
        {
            MyUser.clearAccessToken();
        }
        MyUser.setGPlusAccount(null);
        ApiHttpClient.clearUserCookies(activity);
    }

    public static void doLogoutSimple()
    {
        AccountApi.a();
        MyUser.clearAccessToken();
    }

    public static void doShare(Context context, String s)
    {
        doShare(context, s, context.getString(0x7f0e0456));
    }

    public static void doShare(Context context, String s, Bundle bundle, String s1)
    {
        doShare(context, s, context.getString(0x7f0e0456), bundle, s1);
    }

    public static void doShare(Context context, String s, String s1)
    {
        doShare(context, s, s1, null, null);
    }

    public static void doShare(Context context, String s, String s1, Bundle bundle, String s2)
    {
        s1 = new Intent("android.intent.action.SEND");
        s1.setType("text/plain");
        s1.putExtra("android.intent.extra.TEXT", s);
        s1.putExtra("android.intent.extra.SUBJECT", Resources.string(0x7f0e049f));
        if (bundle != null)
        {
            s1.putExtras(bundle);
        }
        if (s2 == null)
        {
            doCustomShare(context, s1, s);
            return;
        }
        s1.setPackage(s2);
        try
        {
            context.startActivity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Application.showToast(Resources.string(0x7f0e0090, new Object[] {
                AppUtils.getApplicationName(s2)
            }));
        }
    }

    private static void filterApps(List list)
    {
        if (list != null)
        {
            list = list.listIterator();
            while (list.hasNext()) 
            {
                String s = ((ResolveInfo)list.next()).activityInfo.packageName;
                if (s == null || "com.pinterest".contains(s) || s.contains("com.pinterest"))
                {
                    list.remove();
                }
            }
        }
    }

    public static Intent getBoardIntent(Context context, String s)
    {
        return getTaskIntent(context, new Navigation(Location.BOARD, s));
    }

    public static Intent getCreatePinIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/create/CreateActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Intent getHomeIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/task/activity/MainActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Intent getNUXIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/nux/NUXActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Intent getPinEditIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/create/PinEditActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Intent getPinIntent(Context context, String s)
    {
        return getTaskIntent(context, new Navigation(Location.PIN, s));
    }

    public static PinterestDialog getPinterestDialog(Context context)
    {
        return new PinterestDialog(context, 0x7f0f013b);
    }

    public static PinterestDialog getPinterestDialogCancelable(Context context)
    {
        context = new PinterestDialog(context, 0x7f0f013b);
        context.setCanceledOnTouchOutside(true);
        context.setDismissKbWhenTouchOutside(true);
        return context;
    }

    public static Intent getRepinDialogIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/create/RepinActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Intent getRootIntent()
    {
        Intent intent = new Intent(Application.context(), com/pinterest/activity/PinterestActivity);
        setSingleClearTop(intent);
        return intent;
    }

    public static Intent getSDKModeIntent()
    {
        Intent intent = new Intent(Application.context(), com/pinterest/sdk/PinterestOauthActivity);
        intent.addFlags(0x20000);
        return intent;
    }

    public static Intent getTaskIntent(Context context, Navigation navigation)
    {
        context = getHomeIntent(context);
        context.putExtra("com.pinterest.EXTRA_PENDING_TASK", navigation);
        return context;
    }

    public static Intent getUserIntent(Context context, String s)
    {
        return getTaskIntent(context, new Navigation(Location.USER, s));
    }

    public static Intent getUserSetImageIntent(Context context)
    {
        context = new Intent(context, com/pinterest/activity/user/UserSetImageActivity);
        setSingleClearTop(context);
        return context;
    }

    public static Uri getValidUri(String s)
    {
        Uri uri1 = Uri.parse(s);
        Uri uri = uri1;
        if (uri1.getScheme() == null)
        {
            uri = Uri.parse((new StringBuilder("http://")).append(s).toString());
        }
        return uri;
    }

    public static Intent getWebhook(Context context)
    {
        context = new Intent(context, com/pinterest/activity/webhook/WebhookActivity);
        setSingleClearTop(context);
        return context;
    }

    public static void goHome(Context context)
    {
        Intent intent;
        if (MyUser.hasAccessToken())
        {
            intent = getHomeIntent(context);
        } else
        {
            intent = getRootIntent();
        }
        context.startActivity(intent);
    }

    public static void goIntentPlace(Context context, Place place)
    {
        goIntentView(context, (new StringBuilder("http://maps.google.com/maps?daddr=")).append(place.getAddress()).toString());
    }

    public static void goIntentView(Context context, Uri uri)
    {
        if (uri == null)
        {
            return;
        }
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            CrashReporting.logHandledException(context);
        }
    }

    public static void goIntentView(Context context, String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            goIntentView(context, Uri.parse(s));
            return;
        }
    }

    public static void goNUXExperience(Context context)
    {
        context.startActivity(getNUXIntent(context));
    }

    public static void goPostSignup(Activity activity)
    {
        goRoot(activity);
    }

    public static void goRakutenAuth(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, com/pinterest/activity/signin/RakutenAuthActivity), 102);
    }

    public static void goRoot(Context context)
    {
        if (((Activity)context).getIntent() != null && ((Activity)context).getIntent().getStringExtra("com.pinterest.EXTRA_SDK_MODE") != null)
        {
            context.startActivity(getSDKModeIntent());
            return;
        } else
        {
            context.startActivity(getRootIntent());
            return;
        }
    }

    public static void goSplash(Activity activity)
    {
        goSplash(activity, null);
    }

    public static void goSplash(Activity activity, Map map)
    {
        Intent intent = new Intent(Application.context(), com/pinterest/activity/unauth/UnauthWallActivity);
        if (map != null && !map.isEmpty())
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); intent.putExtra((String)entry.getKey(), (Serializable)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        setSingleClearTop(intent);
        activity.startActivity(intent);
    }

    public static void goSplashLogin(Activity activity)
    {
        goSplashLogin(activity, null, null, "com.pinterest.EXTRA_APP_MODE");
    }

    public static void goSplashLogin(Activity activity, String s)
    {
        goSplashLogin(activity, null, null, s);
    }

    public static void goSplashLogin(Activity activity, String s, String s1, String s2)
    {
        Intent intent = new Intent(Application.context(), com/pinterest/activity/unauth/UnauthWallActivity);
        intent.putExtra("com.pinterest.EXTRA_PENDING_DIALOG", com/pinterest/activity/signin/dialog/LoginDialog);
        boolean flag;
        if (s2 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag & s2.equalsIgnoreCase("com.pinterest.EXTRA_SDK_MODE"))
        {
            intent.putExtra("com.pinterest.EXTRA_SDK_MODE", s2);
        }
        if (s != null && s1 != null)
        {
            intent.putExtra("com.pinterest.EXTRA_USER_NAME", s);
            intent.putExtra("com.pinterest.EXTRA_PASSWORD", s1);
        }
        setSingleClearTop(intent);
        activity.startActivity(intent);
    }

    public static void goSplashSignup(Activity activity)
    {
        goSplashSignup(activity, true, null);
    }

    public static void goSplashSignup(Activity activity, boolean flag, String s)
    {
        Intent intent = new Intent(Application.context(), com/pinterest/activity/unauth/UnauthWallActivity);
        if (flag)
        {
            intent.putExtra("com.pinterest.EXTRA_PENDING_DIALOG", com/pinterest/activity/signin/dialog/SignupDialog);
        }
        if (s != null)
        {
            intent.putExtra("com.pinterest.EXTRA_SIGNUP_INVITE_URL", s);
        }
        setSingleClearTop(intent);
        activity.startActivity(intent);
    }

    public static void goTask(Context context, Navigation navigation)
    {
        context.startActivity(getTaskIntent(context, navigation));
    }

    public static void goTermsOfService(Context context)
    {
        goWebView(context, getValidUri(Resources.string(0x7f0e04e3)), Resources.string(0x7f0e04b5));
    }

    public static void goTwitterAuth(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, com/pinterest/activity/signin/TwitterAuthActivity), 101);
    }

    public static void goUnauthPage(Context context)
    {
        goUnauthPage(context, false);
    }

    public static void goUnauthPage(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/pinterest/activity/unauth/UnauthWallActivity);
        if (flag)
        {
            intent.putExtra("com.pinterest.EXTRA_FINISH_ONSTOP", true);
        }
        setSingleClearTop(intent);
        context.startActivity(intent);
    }

    public static void goUnauthPin(Context context, String s)
    {
        Intent intent = new Intent(context, com/pinterest/activity/pin/PinActivity);
        intent.putExtra("com.pinterest.EXTRA_PENDING_TASK", new Navigation(Location.PIN, s));
        setSingleClearTop(intent);
        context.startActivity(intent);
    }

    public static void goWebView(Context context, Uri uri, String s)
    {
        Intent intent = new Intent(context, com/pinterest/activity/web/WebViewActivity);
        intent.setData(uri);
        intent.putExtra("com.pinterest.EXTRA_HAS_URL", true);
        intent.putExtra("com.pinterest.EXTRA_ALLOW_REDIRECT_BACK", true);
        if (!StringUtils.isEmpty(s))
        {
            intent.putExtra("com.pinterest.EXTRA_WEB_TITLE_STRING", s);
        }
        context.startActivity(intent);
    }

    public static void gotoBrowser(Activity activity, Uri uri)
    {
        gotoBrowser(activity, uri.toString(), false);
    }

    public static void gotoBrowser(Activity activity, String s)
    {
        gotoBrowser(activity, s, false);
    }

    public static void gotoBrowser(Activity activity, String s, boolean flag)
    {
        s = new Navigation(Location.BROWSER, s);
        Intent intent = getHomeIntent(activity);
        intent.putExtra("com.pinterest.EXTRA_PENDING_TASK", s);
        if (flag)
        {
            intent.putExtra("com.pinterest.EXTRA_ALLOW_REDIRECT_BACK", true);
        }
        activity.startActivity(intent);
        activity.finish();
    }

    public static void setPostSignup(boolean flag)
    {
        Preferences.user().set("PREF_POST_SINGUP", flag);
    }

    public static void setSingleClearTop(Intent intent)
    {
        intent.setFlags(0x24000000);
    }

    public static void useTestingCredential()
    {
        MyUser.setAccessToken("MTQzMTU5ODoxMTA0NzkxMzQ1MTczNjg1Njk6MnwxMzQ2OTY5MjY5OjAtLWRiNTg3NWE2MjQ2ZDgyMGUwNDU1OThkNDA5ZDk5ZDU5MTc4Yjg0ZjY=");
    }

    private class _cls1
        implements com.pinterest.activity.task.dialog.BaseDialog.OnDialogClickListener
    {

        final List val$apps;
        final Context val$context;
        final Intent val$intent;
        final PackageManager val$pm;
        final String val$toShare;

        public final void onClick(BaseDialog basedialog, int i)
        {
            Object obj = ((ResolveInfo)apps.get(i)).activityInfo;
            String s = ((ActivityInfo) (obj)).packageName;
            Pinalytics.a(ElementType.SHARE_SOCIAL_BUTTON, ComponentType.MODAL_DIALOG, s);
            obj = (String)pm.getApplicationLabel(((ActivityInfo) (obj)).applicationInfo);
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(toShare).append(SocialUtils.getMedium(((String) (obj)))).toString());
            intent.setPackage(s);
            context.startActivity(intent);
            basedialog.dismiss();
        }

        _cls1()
        {
            apps = list;
            pm = packagemanager;
            intent = intent1;
            toShare = s;
            context = context1;
            super();
        }
    }

}
