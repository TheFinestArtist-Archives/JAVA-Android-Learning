// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.conversation;

import android.view.View;
import com.pinterest.activity.task.toast.BaseToast;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.api.model.ConversationMessage;
import com.pinterest.api.model.User;
import com.pinterest.kit.application.Resources;
import org.apache.commons.lang3.StringUtils;

public class ConversationMessageToast extends BaseToast
{

    private ConversationMessage _lastMessage;
    private User _sender;
    private android.view.View.OnClickListener onToastClickListener;

    public ConversationMessageToast(ConversationMessage conversationmessage, User user)
    {
        onToastClickListener = new _cls1();
        _lastMessage = conversationmessage;
        _sender = user;
        setToastOnClickListener(onToastClickListener);
    }

    private String getSecondaryText()
    {
        if (StringUtils.isNotBlank(_lastMessage.getText()))
        {
            return _lastMessage.getText();
        }
        if (_lastMessage.getPinId() != null)
        {
            return Resources.string(0x7f0e044d);
        }
        if (_lastMessage.getBoardId() != null)
        {
            return Resources.string(0x7f0e044c);
        }
        if (_lastMessage.getUserId() != null)
        {
            return Resources.string(0x7f0e044e);
        } else
        {
            return null;
        }
    }

    public View getView(ToastContainer toastcontainer)
    {
        setLayoutGravity(81);
        if (_sender != null && _lastMessage != null)
        {
            setMessage(_sender.getFullName());
            setImageUrl(_sender.getImageMediumUrl());
            setSecondaryMessage(getSecondaryText());
        }
        return super.getView(toastcontainer);
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final ConversationMessageToast this$0;

        public void onClick(View view)
        {
            Events.post(new Navigation(Location.CONVERSATION, _lastMessage.getConversationId()));
        }

        _cls1()
        {
            this$0 = ConversationMessageToast.this;
            super();
        }
    }

}
