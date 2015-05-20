// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.app.Activity;
import android.view.View;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.base.Device;
import com.pinterest.experiment.Experiments;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalData, InviteFriendAdapter, InviteUtil

class this._cls0
    implements android.view..InviteFriendAdapter._cls1
{

    final InviteFriendAdapter this$0;

    public void onClick(View view)
    {
label0:
        {
            Device.hideSoftKeyboard(view);
            view = ((View) (view.getTag()));
            if (view instanceof TypeAheadItem)
            {
                view = (TypeAheadItem)view;
                if (view.getItemType() == com.pinterest.activity.search.model..PHONE_CONTACT && (!Experiments.g() || PinvitationalData.getQuotaLeft() > 0))
                {
                    break label0;
                }
            }
            return;
        }
        InviteUtil.inviteUserSMS((Activity)_context, view.getTitle(), view.getIdentifier(), InviteFriendAdapter.access$000(InviteFriendAdapter.this));
    }

    ()
    {
        this$0 = InviteFriendAdapter.this;
        super();
    }
}
