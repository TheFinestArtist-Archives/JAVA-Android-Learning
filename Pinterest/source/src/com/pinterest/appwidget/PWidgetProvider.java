// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.kit.log.PLog;
import com.pinterest.schemas.event.EventType;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.appwidget:
//            PWidgetHelper, PWidgetService, StackRemoteViewsFactory, WidgetValidator

public class PWidgetProvider extends AppWidgetProvider
{

    public static final int LOADING_FAILED = 1;
    public static final int LOADING_IN_PROGRESS = 0;
    private static boolean _isFullUpdate = true;
    private static int _notifCount = 0;
    private static boolean _onlyUpdateNotif = false;
    private static int _updateLoading = -1;
    public static boolean sShouldCreateFeed = false;
    private Bundle _extra;
    private Context mContext;
    private com.pinterest.api.remote.MyUserApi.NotificationUnseenCountResponseHandler onUnseenCountLoaded;

    public PWidgetProvider()
    {
        onUnseenCountLoaded = new _cls1();
    }

    public static int getNotifCount()
    {
        return _notifCount;
    }

    private void initListWidget(AppWidgetManager appwidgetmanager, int ai[])
    {
        int j = ai.length;
        int i = 0;
        while (i < j) 
        {
            int k = ai[i];
            RemoteViews remoteviews = new RemoteViews(mContext.getPackageName(), 0x7f030154);
            initViewCommon(remoteviews, k);
            if (MyUser.hasAccessTokenAndUser())
            {
                initViewAuth(remoteviews);
            } else
            {
                initViewUnauth(remoteviews);
            }
            if (isFullUpdate())
            {
                mContext.startService(PWidgetHelper.getServiceIntent(mContext, k));
                appwidgetmanager.updateAppWidget(k, remoteviews);
            } else
            {
                appwidgetmanager.partiallyUpdateAppWidget(k, remoteviews);
            }
            i++;
        }
    }

    private void initViewAuth(RemoteViews remoteviews)
    {
        remoteviews.setOnClickPendingIntent(0x7f0b01ce, PWidgetHelper.getHomePending(mContext));
        remoteviews.setViewVisibility(0x7f0b02ec, 0);
        if (getNotifCount() > 0)
        {
            remoteviews.setViewVisibility(0x7f0b02ed, 8);
            remoteviews.setViewVisibility(0x7f0b02ee, 0);
            remoteviews.setOnClickPendingIntent(0x7f0b02ee, PWidgetHelper.getProfilePending(mContext));
            String s = String.valueOf(getNotifCount());
            if (getNotifCount() > 9)
            {
                s = "9+";
            }
            remoteviews.setTextViewText(0x7f0b02ef, s);
        } else
        {
            remoteviews.setViewVisibility(0x7f0b02ed, 0);
            remoteviews.setViewVisibility(0x7f0b02ee, 8);
            remoteviews.setOnClickPendingIntent(0x7f0b02ed, PWidgetHelper.getProfilePending(mContext));
        }
        remoteviews.setOnClickPendingIntent(0x7f0b02ec, PWidgetHelper.getSearchPending(mContext));
        remoteviews.setViewVisibility(0x7f0b02f6, 8);
        remoteviews.setViewVisibility(0x7f0b02f4, 0);
        remoteviews.setOnClickPendingIntent(0x7f0b02f5, PWidgetHelper.getHomePending(mContext));
        if (onlyUpdateNotif())
        {
            return;
        } else
        {
            MyUserApi.a(onUnseenCountLoaded);
            return;
        }
    }

    private void initViewCommon(RemoteViews remoteviews, int i)
    {
        Intent intent = new Intent(mContext, com/pinterest/appwidget/PWidgetService);
        intent.putExtra("appWidgetId", i);
        intent.setData(Uri.parse(intent.toUri(1)));
        remoteviews.setRemoteAdapter(i, 0x7f0b00f3, intent);
        remoteviews.setEmptyView(0x7f0b00f3, 0x7f0b02f8);
        remoteviews.setOnClickPendingIntent(0x7f0b0301, PWidgetHelper.getServicePending(mContext, i));
        if (_updateLoading == 1)
        {
            remoteviews.setViewVisibility(0x7f0b0233, 8);
            remoteviews.setViewVisibility(0x7f0b02f0, 0);
            remoteviews.setOnClickPendingIntent(0x7f0b02f2, PWidgetHelper.getServicePending(mContext, i));
        }
        remoteviews.setPendingIntentTemplate(0x7f0b00f3, PWidgetHelper.getSwitcherPending(mContext));
    }

    private void initViewUnauth(RemoteViews remoteviews)
    {
        _notifCount = -1;
        remoteviews.setOnClickPendingIntent(0x7f0b01ce, PWidgetHelper.getWelcomePending(mContext));
        remoteviews.setViewVisibility(0x7f0b02ec, 8);
        remoteviews.setViewVisibility(0x7f0b02ed, 8);
        remoteviews.setViewVisibility(0x7f0b02ee, 8);
        remoteviews.setViewVisibility(0x7f0b02f6, 0);
        remoteviews.setViewVisibility(0x7f0b02f4, 8);
        remoteviews.setOnClickPendingIntent(0x7f0b00d4, PWidgetHelper.getLoginPending(mContext));
        remoteviews.setOnClickPendingIntent(0x7f0b00af, PWidgetHelper.getSignupPending(mContext));
    }

    public static boolean isLoadingFailed()
    {
        return _updateLoading == 1;
    }

    public static boolean onlyUpdateLoading()
    {
        return _updateLoading != -1;
    }

    public static boolean onlyUpdateNotif()
    {
        return _onlyUpdateNotif;
    }

    public boolean isFullUpdate()
    {
        return _isFullUpdate;
    }

    public void onDeleted(Context context, int ai[])
    {
        super.onDeleted(context, ai);
        StackRemoteViewsFactory.loading = false;
    }

    public void onDisabled(Context context)
    {
        super.onDisabled(context);
        StackRemoteViewsFactory.loading = false;
        Pinalytics.a(EventType.ANDROID_WIDGET_DISABLE, null);
    }

    public void onEnabled(Context context)
    {
        super.onEnabled(context);
        PLog.a("PWidgetProvider.onEnabled", new Object[0]);
        StackRemoteViewsFactory.loading = false;
        Pinalytics.a(EventType.ANDROID_WIDGET_ENABLE, null, Pinalytics.a());
    }

    public void onReceive(Context context, Intent intent)
    {
        _extra = intent.getExtras();
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        mContext = context;
        _onlyUpdateNotif = false;
        Object obj = _extra.getParcelableArrayList("customExtras");
        if (obj != null && ((ArrayList) (obj)).size() > 0)
        {
            _isFullUpdate = false;
            obj = (Bundle)((ArrayList) (obj)).get(0);
            _onlyUpdateNotif = ((Bundle) (obj)).getBoolean("com.pinterest.EXTRA_ONLY_UPDATE_NOTIF", false);
            _notifCount = ((Bundle) (obj)).getInt("com.pinterest.EXTRA_NOTIF_COUNT", 0);
            _updateLoading = ((Bundle) (obj)).getInt("com.pinterest.EXTRA_UPDATE_WIDGET_LOADING", -1);
        } else
        {
            _isFullUpdate = true;
            Pinalytics.a(EventType.ANDROID_WIDGET_UPDATE, null);
        }
        PLog.a("PWidgetProvider.onUpdate: %d, notif count: %d", new Object[] {
            Integer.valueOf(ai[0]), Integer.valueOf(_notifCount)
        });
        if (isFullUpdate())
        {
            WidgetValidator.tryEnableWidget(context, true);
        }
        initListWidget(appwidgetmanager, ai);
        super.onUpdate(context, appwidgetmanager, ai);
    }




/*
    static int access$002(int i)
    {
        _notifCount = i;
        return i;
    }

*/


    private class _cls1 extends com.pinterest.api.remote.MyUserApi.NotificationUnseenCountResponseHandler
    {

        final PWidgetProvider this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            try
            {
                int i = NotificationCount.getTotalUnseenCount();
                if (i != PWidgetProvider._notifCount)
                {
                    PWidgetProvider._notifCount = i;
                    PWidgetHelper.notifyWidgetStateChange(mContext, PWidgetProvider._notifCount);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ApiResponse apiresponse)
            {
                CrashReporting.logHandledException(apiresponse);
            }
        }

        _cls1()
        {
            this$0 = PWidgetProvider.this;
            super();
        }
    }

}
