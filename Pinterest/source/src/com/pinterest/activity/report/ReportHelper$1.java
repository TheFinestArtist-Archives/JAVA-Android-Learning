// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.report;

import com.pinterest.activity.task.dialog.LoadingDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.event.DialogHideEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.EventType;

final class val.user extends ApiResponseHandler
{

    final User val$user;

    public final void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        if (apiresponse != null)
        {
            Application.showToast(apiresponse.getMessageDisplay());
        } else
        if (val$user.getFullName() != null)
        {
            Application.showToast(Resources.string(0x7f0e005f, new Object[] {
                val$user.getFullName()
            }));
            return;
        }
    }

    public final void onFinish()
    {
        super.onFinish();
        Events.post(new DialogHideEvent(true));
    }

    public final void onStart()
    {
        if (val$user.getFullName() != null)
        {
            Events.post(new DialogEvent(new LoadingDialog(Resources.string(0x7f0e0062, new Object[] {
                val$user.getFullName()
            }))));
        }
    }

    public final void onSuccess(ApiResponse apiresponse)
    {
        Pinalytics.a(EventType.USER_BLOCK, val$user.getUid());
        if (val$user.getFullName() != null)
        {
            Application.showToastShort(Resources.string(0x7f0e0063, new Object[] {
                val$user.getFullName()
            }));
        }
        val$user.setBlocked(Boolean.valueOf(true));
        val$user.setFollowing(false);
        ModelHelper.setUser(val$user);
        Events.post(new com.pinterest.api.model.t(val$user));
        Events.postSticky(new com.pinterest.api.model.Event(val$user));
    }

    log()
    {
        val$user = user1;
        super();
    }
}
