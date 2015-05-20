// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Device;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendFragment

class this._cls0
    implements android.widget.Listener
{

    final InviteFriendFragment this$0;

    private Intent getContactViewIntent(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.withAppendedPath(android.provider.ts.CONTENT_URI, s));
        return intent;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (_listView.getItemAtPosition(i)));
        if (!(adapterview instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
        adapterview = (TypeAheadItem)adapterview;
        .SwitchMap.com.pinterest.activity.search.model.TypeAheadItem.ItemType[adapterview.getItemType().ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 65
    //                   2 65
    //                   3 65
    //                   4 96;
           goto _L2 _L3 _L3 _L3 _L4
_L2:
        return;
_L3:
        Pinalytics.a(ElementType.USER_LIST_CONTACT, ComponentType.USER_FEED);
        adapterview = getContactViewIntent(adapterview.getUid());
        Device.hideSoftKeyboard(view);
        startActivity(adapterview);
        return;
_L4:
        Pinalytics.a(ElementType.EMAIL_BUTTON, ComponentType.USER_FEED);
        return;
    }

    ()
    {
        this$0 = InviteFriendFragment.this;
        super();
    }
}
