// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast;

import android.content.Context;
import android.view.View;
import com.pinterest.activity.invitefriend.InviteUtil;
import com.pinterest.activity.invitefriend.events.InviteFriendEvent;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.log.PLog;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.task.toast:
//            BaseToast

public class BulkInviteSendToast extends BaseToast
{

    private final boolean _inviteAll;
    private final Set _inviteList;
    private final String _message;
    private final int _noOfInviteSent;

    public BulkInviteSendToast(InviteFriendEvent invitefriendevent, boolean flag)
    {
        _inviteList = invitefriendevent.getInviteList();
        _message = invitefriendevent.getMessage();
        _noOfInviteSent = invitefriendevent.getNoOfInviteSent();
        _inviteAll = flag;
    }

    private void actuallyInviteSend()
    {
        Iterator iterator = _inviteList.iterator();
        PLog.a((new StringBuilder("INVITER _inviteList size ")).append(_inviteList.size()).toString(), new Object[0]);
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (; iterator.hasNext(); stringbuilder.append(s).append(","))
        {
            s = (String)iterator.next();
            PLog.a((new StringBuilder("INVITER inviting..")).append(s).toString(), new Object[0]);
        }

        UserApi.a(stringbuilder.toString(), _inviteAll, InviteUtil.getInviteSource(), new BaseApiResponseHandler(), null);
        Events.post(new InviteSendEvent(true, _inviteList));
    }

    public View getView(ToastContainer toastcontainer)
    {
        setLayoutGravity(81);
        setMessage(Resources.stringPlural(0x7f0d000c, Integer.valueOf(_inviteList.size())));
        if (!Experiments.o())
        {
            setButtonText(Resources.string(0x7f0e04c7));
        }
        return super.getView(toastcontainer);
    }

    public void onToastCancelled(Context context)
    {
        super.onToastCancelled(context);
        Pinalytics.a(ElementType.UNDO_BUTTON, ComponentType.TOAST);
        Application.forceShowToast(Resources.string(0x7f0e0446));
        Events.post(new InviteSendEvent(false, _inviteList));
    }

    public void onToastCompleted(Context context)
    {
        super.onToastCompleted(context);
        actuallyInviteSend();
    }
}
