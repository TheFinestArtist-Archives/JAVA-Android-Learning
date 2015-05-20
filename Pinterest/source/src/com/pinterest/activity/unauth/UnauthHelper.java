// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.unauth;

import android.content.Context;
import android.view.View;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.DialogHelper;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

public class UnauthHelper
{

    public UnauthHelper()
    {
    }

    public static void onClick(View view, Context context)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131427540: 
            Pinalytics.a(ElementType.LOGIN_BUTTON, ComponentType.NAVIGATION);
            DialogHelper.goLogin();
            return;

        case 2131427503: 
            Pinalytics.a(ElementType.SIGNUP_BUTTON, ComponentType.NAVIGATION);
            DialogHelper.goSignup();
            return;

        case 2131427432: 
            Pinalytics.a(ElementType.FACEBOOK_CONNECT);
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.FACEBOOK, true));
            return;

        case 2131427541: 
            Pinalytics.a(ElementType.GPLUS_CONNECT);
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.GPLUS, true));
            return;

        case 2131427433: 
            Pinalytics.a(ElementType.TWITTER_CONNECT);
            Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.TWITTER, true));
            return;

        case 2131427581: 
            Pinalytics.a(ElementType.TOS_BUTTON);
            break;
        }
        ActivityHelper.goIntentView(context, Resources.string(0x7f0e04e3));
    }
}
