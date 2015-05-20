// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.UserGridAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestGridFragment

public class UserGridFragment extends PinterestGridFragment
{

    public UserGridFragment()
    {
        _adapter = new UserGridAdapter();
    }

    protected void onUserClicked(AdapterView adapterview, View view, int i, long l)
    {
        if (_adapter != null)
        {
            if ((adapterview = ((UserGridAdapter)_adapter).getItem(i)) instanceof User)
            {
                adapterview = (User)adapterview;
                Pinalytics.a(ElementType.USER_ICON, ComponentType.FLOWED_BOARD, adapterview.getUid());
                Events.post(new Navigation(Location.USER, adapterview));
                return;
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _gridVw.setOnItemClickListener(new _cls1());
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final UserGridFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            onUserClicked(adapterview, view, i, l);
        }

        _cls1()
        {
            this$0 = UserGridFragment.this;
            super();
        }
    }

}
