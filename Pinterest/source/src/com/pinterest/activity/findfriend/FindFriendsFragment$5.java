// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendsFragment, FindFriendAdapter

class this._cls0
    implements android.widget.kListener
{

    final FindFriendsFragment this$0;

    private Intent getContactViewIntent(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.withAppendedPath(android.provider.cts.CONTENT_URI, s));
        return intent;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (FindFriendsFragment.access$200(FindFriendsFragment.this).getItem(i)));
        if (!(adapterview instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
        adapterview = (TypeAheadItem)adapterview;
        .SwitchMap.com.pinterest.activity.search.model.TypeAheadItem.ItemType[adapterview.getItemType().ordinal()];
        JVM INSTR tableswitch 1 6: default 72
    //                   1 73
    //                   2 73
    //                   3 100
    //                   4 100
    //                   5 137
    //                   6 189;
           goto _L2 _L3 _L3 _L4 _L4 _L5 _L6
_L2:
        return;
_L3:
        Pinalytics.a(ElementType.USER_LIST_USER, ComponentType.USER_FEED);
        Events.post(new Navigation(Location.USER, adapterview.getUid()));
        return;
_L4:
        Pinalytics.a(ElementType.USER_LIST_CONTACT, ComponentType.USER_FEED);
        adapterview = getContactViewIntent(adapterview.getUid());
        Device.hideSoftKeyboard(FindFriendsFragment.access$000(FindFriendsFragment.this));
        startActivity(adapterview);
        return;
_L5:
        Pinalytics.a(ElementType.EMAIL_BUTTON, ComponentType.USER_FEED);
        adapterview = FindFriendsFragment.access$000(FindFriendsFragment.this).getText().toString();
        if (FindFriendsFragment.access$200(FindFriendsFragment.this).inviteUserEmail(adapterview, adapterview, null))
        {
            FindFriendsFragment.access$000(FindFriendsFragment.this).setText("");
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        Pinalytics.a(ElementType.FACEBOOK_CONNECT, ComponentType.USER_FEED);
        if (getActivity() != null)
        {
            Events.post(new com.pinterest.base.vent(com.pinterest.base.K));
            FindFriendsFragment.access$302(FindFriendsFragment.this, true);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    pe()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
