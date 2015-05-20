// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.badge;

import android.content.Context;
import com.pinterest.activity.PinterestActivity;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.ui.badge:
//            AppBadge

public class AppBadgeUtils
{

    public AppBadgeUtils()
    {
    }

    public static int isBadgingSupported()
    {
        return Preferences.persisted().getInt("isBadgingSupported", -1);
    }

    public static void removeBadge(Context context)
    {
        AppBadge appbadge = AppBadge.getBadge(context);
        if (appbadge != null)
        {
            appbadge.badgeCount = 0;
            appbadge.update(context);
        }
    }

    public static void setBadgingSupported(boolean flag)
    {
        PreferencesManager preferencesmanager = Preferences.persisted();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        preferencesmanager.set("isBadgingSupported", i);
    }

    public static void updateBadge(Context context, int i)
    {
        AppBadge appbadge;
        if (context == null)
        {
            return;
        }
        appbadge = AppBadge.getBadge(context);
        if (appbadge != null) goto _L2; else goto _L1
_L1:
        appbadge = new AppBadge();
        appbadge.packageName = context.getPackageName();
        appbadge.className = com/pinterest/activity/PinterestActivity.getName();
        appbadge.badgeCount = i;
        appbadge.save(context);
_L4:
        Pinalytics.a(EventType.MOBILE_BADGE_SHOWN, String.valueOf(i));
        return;
_L2:
        if (appbadge.badgeCount != i)
        {
            appbadge.badgeCount = i;
            appbadge.update(context);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
