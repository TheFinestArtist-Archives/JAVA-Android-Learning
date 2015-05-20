// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.pinterest.adapter.Refreshable;
import com.pinterest.ui.actions.Scrollable;
import com.pinterest.ui.grid.AdapterFooterView;

// Referenced classes of package com.pinterest.activity.task.fragment:
//            AdapterViewFragment

public class ListFragment extends AdapterViewFragment
    implements Refreshable, Scrollable
{

    protected BaseAdapter _adapter;
    protected AdapterFooterView _footerView;
    protected ListView _listView;

    public ListFragment()
    {
    }

    public boolean isDataNonEmpty()
    {
        return _adapter != null && !_adapter.isEmpty();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300ae;
        _footerView = new AdapterFooterView(getActivity());
        _footerView.setState(1);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        loadData();
    }

    public void scrollTo(int i, int j)
    {
        if (_listView != null)
        {
            _listView.setSelectionFromTop(0, j);
        }
    }
}
