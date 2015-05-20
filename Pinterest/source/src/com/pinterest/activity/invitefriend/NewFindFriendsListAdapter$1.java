// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actionsheet.ActionSheetFragment;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsListAdapter

class this._cls0
    implements android.view.ndFriendsListAdapter._cls1
{

    final NewFindFriendsListAdapter this$0;

    public void onClick(final View item)
    {
        Device.hideSoftKeyboard(item);
        item = ((View) (item.getTag()));
        if (!(item instanceof TypeAheadItem))
        {
            return;
        }
        item = (TypeAheadItem)item;
        NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).clear();
        NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).addHeader(Resources.string(0x7f0e02a0));
        NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).addFooter(Resources.string(0x7f0e02a1));
        class _cls1
            implements android.view.View.OnClickListener
        {

            final NewFindFriendsListAdapter._cls1 this$1;
            final TypeAheadItem val$item;

            public void onClick(View view)
            {
                NewFindFriendsListAdapter.access$000(this$0).dismiss();
                Events.post(new ToastEvent(new BulkInviteSendToast(new InviteFriendEvent(item.getIdentifier()), false)));
            }

            _cls1()
            {
                this$1 = NewFindFriendsListAdapter._cls1.this;
                item = typeaheaditem;
                super();
            }
        }

        String s;
        for (Iterator iterator = item.getEmails().iterator(); iterator.hasNext(); NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).addItem(s, new _cls1()))
        {
            s = (String)iterator.next();
        }

        class _cls2
            implements android.view.View.OnClickListener
        {

            final NewFindFriendsListAdapter._cls1 this$1;
            final TypeAheadItem val$item;

            public void onClick(View view)
            {
                NewFindFriendsListAdapter.access$000(this$0).dismiss();
                InviteUtil.inviteUserSMS((Activity)NewFindFriendsListAdapter.access$100(this$0), item.getTitle(), item.getIdentifier(), NewFindFriendsListAdapter.access$200(this$0));
            }

            _cls2()
            {
                this$1 = NewFindFriendsListAdapter._cls1.this;
                item = typeaheaditem;
                super();
            }
        }

        String s1;
        for (Iterator iterator1 = item.getPhoneNumbers().iterator(); iterator1.hasNext(); NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).addItem(s1, new _cls2()))
        {
            s1 = (String)iterator1.next();
        }

        NewFindFriendsListAdapter.access$000(NewFindFriendsListAdapter.this).show();
    }

    _cls2()
    {
        this$0 = NewFindFriendsListAdapter.this;
        super();
    }
}
