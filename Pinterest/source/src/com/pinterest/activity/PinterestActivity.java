// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.pinterest.activity.notifications.util.RecentConversations;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Services;
import com.pinterest.base.Social;
import com.pinterest.base.StopWatch;
import com.pinterest.experience.Experiences;
import com.pinterest.experiment.Experiments;
import com.pinterest.experiment.LongPressEducation;
import com.pinterest.kit.autoupdate.AutoUpdateManager;
import com.pinterest.kit.notification.AppRater;
import com.pinterest.receiver.GlobalDataUpdateReceiver;
import com.pinterest.schemas.event.EventType;
import com.pinterest.ui.badge.AppBadgeUtils;

// Referenced classes of package com.pinterest.activity:
//            ActivityHelper

public class PinterestActivity extends Activity
{

    public PinterestActivity()
    {
        StopWatch.get().start("ttrfp");
    }

    private void authedUserStartup()
    {
        GlobalDataUpdateReceiver.a();
        AppRater.registerLaunch(this);
        Experiences.a();
        RecentConversations.load();
        AppBadgeUtils.removeBadge(Application.context());
    }

    private boolean isValidInstance()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        if (!isTaskRoot())
        {
            Intent intent = getIntent();
            String s = intent.getAction();
            flag = flag1;
            if (intent.hasCategory("android.intent.category.LAUNCHER"))
            {
                flag = flag1;
                if (s != null)
                {
                    flag = flag1;
                    if (s.equals("android.intent.action.MAIN"))
                    {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    private void reportClientNotif()
    {
        if ("CLIENT_NOTIF".equals(getIntent().getStringExtra("com.pinterest.EXTRA_SOURCE")))
        {
            Pinalytics.a(EventType.CLIENT_NOTIFICATION_OPENED_BY, ApplicationInfo.getInstallId());
            AnalyticsApi.a("client_notif_clicked");
        }
    }

    protected void init()
    {
        Experiments.r();
        reportClientNotif();
        Services.startNotificationService();
        if (MyUser.hasAccessTokenAndUser())
        {
            MyUser.setLoggedIn(true);
            authedUserStartup();
            Intent intent = ActivityHelper.getHomeIntent(this);
            if (LongPressEducation.a())
            {
                intent.putExtra("com.pinterest.EXTRA_PENDING_TASK", new Navigation(Location.CONTEXTMENU_EDUCATION));
                intent.setFlags(0x24000000);
            }
            startActivity(intent);
        } else
        {
            MyUser.setLoggedIn(false);
            ActivityHelper.goSplash(this);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        Services.startBackgroundService();
        Social.init();
        super.onCreate(bundle);
        AutoUpdateManager.a().checkForUpdate();
        ApplicationInfo.reportInstall(this);
        CrashReporting.sendAppLoad();
        Pinalytics.a(EventType.APP_START, null, Pinalytics.a());
    }

    protected void onStart()
    {
        super.onStart();
        if (isValidInstance())
        {
            init();
            return;
        } else
        {
            finish();
            return;
        }
    }
}
