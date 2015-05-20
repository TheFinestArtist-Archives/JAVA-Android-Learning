// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.app.Activity;
import android.view.View;
import com.pinterest.activity.invitefriend.InviteUtil;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.base.Device;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendAdapter

class this._cls0
    implements android.view.
{

    final FindFriendAdapter this$0;

    public void onClick(View view)
    {
        Device.hideSoftKeyboard(view);
        Object obj = view.getTag();
        if (obj instanceof TypeAheadItem)
        {
            obj = (TypeAheadItem)obj;
            if (((TypeAheadItem) (obj)).getItemType() == com.pinterest.activity.search.model.pe.PHONE_CONTACT)
            {
                InviteUtil.inviteUserSMS((Activity)FindFriendAdapter.access$300(FindFriendAdapter.this), ((TypeAheadItem) (obj)).getTitle(), ((TypeAheadItem) (obj)).getIdentifier(), FindFriendAdapter.access$400(FindFriendAdapter.this));
            } else
            if (((TypeAheadItem) (obj)).getItemType() == com.pinterest.activity.search.model.pe.EMAIL_CONTACT && inviteUserEmail(((TypeAheadItem) (obj)).getTitle(), ((TypeAheadItem) (obj)).getIdentifier(), ((TypeAheadItem) (obj)).getImageUri()))
            {
                FindFriendAdapter.access$000(FindFriendAdapter.this).add(((TypeAheadItem) (obj)).getUid());
                view.setVisibility(8);
                return;
            }
        }
    }

    Type()
    {
        this$0 = FindFriendAdapter.this;
        super();
    }
}
