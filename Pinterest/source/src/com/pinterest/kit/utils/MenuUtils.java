// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.app.Activity;
import android.view.MenuItem;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.create.helper.CreateImageHelper;
import com.pinterest.activity.invitefriend.InviteUtil;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.rwd.RwdManager;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

public class MenuUtils
{

    public MenuUtils()
    {
    }

    public static boolean onOptionsItemSelected(int i, Activity activity)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 2131428103 2131428113: default 60
    //                   2131428103 121
    //                   2131428104 64
    //                   2131428105 297
    //                   2131428106 97
    //                   2131428107 282
    //                   2131428108 145
    //                   2131428109 169
    //                   2131428110 198
    //                   2131428111 227
    //                   2131428112 247
    //                   2131428113 267;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        flag = false;
_L14:
        return flag;
_L3:
        if (MyUser.get() == null) goto _L14; else goto _L13
_L13:
        Pinalytics.a(ElementType.PROFILE_BUTTON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.USER, MyUser.get()));
        return true;
_L5:
        Pinalytics.a(ElementType.EXPLORE_BUTTON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.EXPLORE));
        return true;
_L2:
        Pinalytics.a(ElementType.NOTIFICATIONS_ICON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.NOTIFICATIONS));
        return true;
_L7:
        Pinalytics.a(ElementType.SETTINGS_BUTTON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.ACCOUNT_SETTINGS));
        return true;
_L8:
        Pinalytics.a(ElementType.INVITE_BUTTON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.INVITE_FRIENDS));
        InviteUtil.setInviteSource("user_profile_invite_friends");
        return true;
_L9:
        Pinalytics.a(ElementType.FINDFRIENDS_BUTTON, ComponentType.NAVIGATION);
        Events.post(new Navigation(Location.FIND_FRIENDS));
        InviteUtil.setInviteSource("user_profile_find_friends");
        return true;
_L10:
        Pinalytics.a(ElementType.SUPPORT_BUTTON, ComponentType.NAVIGATION);
        ActivityHelper.goIntentView(activity, Resources.string(0x7f0e04e2));
        return true;
_L11:
        Pinalytics.a(ElementType.TOS_BUTTON, ComponentType.NAVIGATION);
        ActivityHelper.goIntentView(activity, Resources.string(0x7f0e04e3));
        return true;
_L12:
        Pinalytics.a(ElementType.LOGOUT_BUTTON, ComponentType.NAVIGATION);
        ActivityHelper.doLogout(activity);
        return true;
_L6:
        Pinalytics.a(ElementType.CREATE_BUTTON, ComponentType.NAVIGATION);
        CreateImageHelper.showImageSourceDialog(activity);
        return true;
_L4:
        RwdManager.a().c();
        return true;
    }

    public static boolean onOptionsItemSelected(MenuItem menuitem, Activity activity)
    {
        return onOptionsItemSelected(menuitem.getItemId(), activity);
    }
}
