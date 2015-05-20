// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.pinterest.api.model.Feed;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.grid.PinterestAdapterView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestAdapterViewFragment

class lViewListener extends com.pinterest.ui.scrollview.Listener
{

    final PinterestAdapterViewFragment this$0;

    public void onMeasure()
    {
        if (_savedInstanceState == null || !_needsLayout)
        {
            return;
        }
        _needsLayout = false;
        Feed feed = Feed.restoreInstanceState(_savedInstanceState);
        if (feed == null)
        {
            loadData();
            return;
        }
        if (feed.getCount() == 0)
        {
            setEmptyViewState(0);
            AdapterFooterView.setState(_footerView, 0);
            return;
        } else
        {
            reset(feed, _savedInstanceState.getFloat("yOffset"));
            setEmptyViewState(2);
            AdapterFooterView.setState(_footerView, 1);
            return;
        }
    }

    public void onScroll(View view, int i, int j, int k, int l)
    {
        if (_adapterView != null)
        {
            _adapterView.onScroll((ScrollView)view, j, l);
        }
        onScrolled();
    }

    lViewListener()
    {
        this$0 = PinterestAdapterViewFragment.this;
        super();
    }
}
