// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Application;
import com.pinterest.experiment.Experiments;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteUtil

final class val.phoneNumber extends BaseApiResponseHandler
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

            final InviteUtil._cls1 this$0;

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
                this$0 = InviteUtil._cls1.this;
                super();
            }
        }

        if (Experiments.g())
        {
            UserApi.a("pinvitational_register_invite_sms", ((String) (obj)), InviteUtil.getInviteSource(), new _cls1(), val$tag);
        } else
        {
            UserApi.a("register_invite_sms", ((String) (obj)), InviteUtil.getInviteSource(), null, val$tag);
        }
        val$activity.startActivityForResult(getSMSIntent(val$phoneNumber, apiresponse), 106);
        return;
        apiresponse;
        Application.showToast(0x7f0e0494);
        return;
    }

    _cls1()
    {
        val$tag = s;
        val$activity = activity1;
        val$phoneNumber = s1;
        super();
    }
}
