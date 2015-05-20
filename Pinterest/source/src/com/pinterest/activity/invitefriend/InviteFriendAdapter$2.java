// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import android.widget.CheckBox;
import com.pinterest.activity.invitefriend.events.SingleCheckEvent;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendAdapter, PinvitationalData

class this._cls0
    implements android.view..InviteFriendAdapter._cls2
{

    final InviteFriendAdapter this$0;

    public void onClick(View view)
    {
        Object obj;
        Device.hideSoftKeyboard(view);
        obj = view.getTag();
        if (!(obj instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
        obj = (TypeAheadItem)obj;
        view = (CheckBox)view;
        if (!Experiments.g() || !view.isChecked() || InviteFriendAdapter.access$100(InviteFriendAdapter.this).size() != PinvitationalData.getQuota()) goto _L4; else goto _L3
_L3:
        view.setChecked(false);
_L2:
        return;
_L4:
        if (!view.isChecked())
        {
            break; /* Loop/switch isn't completed */
        }
        addToInviteList(((TypeAheadItem) (obj)));
        if (InviteFriendAdapter.access$100(InviteFriendAdapter.this).size() == getCount())
        {
            Events.post(new SingleCheckEvent(true));
        }
_L6:
        if (Experiments.g())
        {
            PinvitationalData.setFriendsSelected(InviteFriendAdapter.access$100(InviteFriendAdapter.this).size());
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        removeFromInviteList(((TypeAheadItem) (obj)));
        if (InviteFriendAdapter.access$100(InviteFriendAdapter.this).size() == getCount() - 1)
        {
            Events.post(new SingleCheckEvent(false));
        }
          goto _L6
        if (true) goto _L2; else goto _L7
_L7:
    }

    t()
    {
        this$0 = InviteFriendAdapter.this;
        super();
    }
}
