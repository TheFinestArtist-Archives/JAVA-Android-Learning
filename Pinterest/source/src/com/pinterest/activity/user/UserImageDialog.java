// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import android.os.Bundle;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.user:
//            UserImageView

public class UserImageDialog extends BaseDialog
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private User _user;

    public UserImageDialog()
    {
        _eventsSubscriber = new _cls1();
    }

    public UserImageDialog(User user)
    {
        _eventsSubscriber = new _cls1();
        _user = user;
    }

    public void onCreate(Bundle bundle)
    {
        if (bundle != null && _user == null)
        {
            _user = ModelHelper.getUser(bundle.getString("userUid"));
        }
        super.onCreate(bundle);
        bundle = new UserImageView(getContext());
        bundle.setUser(_user);
        setContent(bundle, 0);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (_user != null)
        {
            bundle.putString("userUid", _user.getUid());
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart()
    {
        super.onStart();
        Events.register(_eventsSubscriber, com/pinterest/api/model/User$UpdateEvent, new Class[0]);
    }

    public void onStop()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/User$UpdateEvent
        });
        super.onStop();
    }


    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final UserImageDialog this$0;

        public void onEventMainThread(com.pinterest.api.model.User.UpdateEvent updateevent)
        {
            updateevent = updateevent.getUser();
            if (updateevent == null || _user != null && !_user.equals(updateevent))
            {
                return;
            } else
            {
                dismiss();
                return;
            }
        }

        _cls1()
        {
            this$0 = UserImageDialog.this;
            super();
        }
    }

}
