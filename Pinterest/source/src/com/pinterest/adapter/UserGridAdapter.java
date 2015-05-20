// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.pinterest.api.model.User;
import com.pinterest.ui.grid.user.UserGridCell;

// Referenced classes of package com.pinterest.adapter:
//            PinterestBaseAdapter

public class UserGridAdapter extends PinterestBaseAdapter
{

    public UserGridAdapter()
    {
    }

    protected View getGridCell(View view, ViewGroup viewgroup, User user, boolean flag)
    {
        view = UserGridCell.get(view, viewgroup);
        view.setUser(user, flag);
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        if (!flag)
        {
            loadMore(i);
        }
        return getGridCell(view, viewgroup, (User)getItem(i), flag);
    }
}
