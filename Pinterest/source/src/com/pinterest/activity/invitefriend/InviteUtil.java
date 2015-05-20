// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.app.Activity;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.remote.UserApi;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.ArrayList;
import java.util.Iterator;

public class InviteUtil
{

    public static final int CONTACTS_INDEX = 0;
    public static final int EMAIL_INDEX = 0;
    public static final int FACEBOOK_INDEX = 1;
    public static final int MORE_INDEX = 3;
    public static final int SMS_INDEX = 1;
    public static final String SOURCE_NAG_PREFIX = "nag_";
    public static final String SOURCE_USER_PROFILE_FIND_FRIENDS = "user_profile_find_friends";
    public static final String SOURCE_USER_PROFILE_INVITE_FRIENDS = "user_profile_invite_friends";
    public static final int TWITTER_INDEX = 2;
    private static String _inviteSource;

    public InviteUtil()
    {
    }

    public static String getInviteSource()
    {
        return _inviteSource;
    }

    public static void inviteUserSMS(final Activity activity, String s, final String phoneNumber, final String tag)
    {
        Pinalytics.a(ElementType.USER_FEED_INVITE_SMS, ComponentType.USER_FEED);
        UserApi.k(s, new _cls1(), tag);
    }

    public static String joinEmails(ArrayList arraylist)
    {
        StringBuffer stringbuffer = new StringBuffer();
        Iterator iterator = arraylist.iterator();
        for (arraylist = ""; iterator.hasNext(); arraylist = ",")
        {
            String s = (String)iterator.next();
            stringbuffer.append(arraylist).append(s);
        }

        return stringbuffer.toString();
    }

    public static void setInviteSource(String s)
    {
        _inviteSource = s;
    }

    private class _cls1 extends BaseApiResponseHandler
    {

        final Activity val$activity;
        final String val$phoneNumber;
        final String val$tag;

        private Intent getSMSIntent(String s, String s1)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse((new StringBuilder("sms:")).append(s).toString()));
            intent.putExtra("sms_body", s1);
            intent.putExtra("exit_on_sent", true);
            return intent;
        }

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            Application.showToast(apiresponse.getMessage());
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            apiresponse = ((ApiResponse) (apiresponse.getData()));
            if (!(apiresponse instanceof PinterestJsonObject))
            {
                break MISSING_BLOCK_LABEL_80;
            }
            Object obj = (PinterestJsonObject)apiresponse;
            apiresponse = ((PinterestJsonObject) (obj)).a("message", "");
            obj = ((PinterestJsonObject) (obj)).a("invite_code", "");
            class _cls1 extends BaseApiResponseHandler
            {

                final _cls1 this$0;

                public volatile void onResponse(Object obj1)
                {
                    onResponse((String)obj1);
                }

                public void onResponse(String s)
                {
                    super.onResponse(s);
                    s = new Navigation(Location.INVITE_FRIENDS_CONFIRM);
                    s.putStringArrayListParcelable("invitees", new ArrayList());
                    Events.post(s);
                }

                _cls1()
                {
                    this$0 = _cls1.this;
                    super();
                }
            }

            if (Experiments.g())
            {
                UserApi.a("pinvitational_register_invite_sms", ((String) (obj)), InviteUtil.getInviteSource(), new _cls1(), tag);
            } else
            {
                UserApi.a("register_invite_sms", ((String) (obj)), InviteUtil.getInviteSource(), null, tag);
            }
            activity.startActivityForResult(getSMSIntent(phoneNumber, apiresponse), 106);
            return;
            apiresponse;
            Application.showToast(0x7f0e0494);
            return;
        }

        _cls1()
        {
            tag = s;
            activity = activity1;
            phoneNumber = s1;
            super();
        }
    }

}
