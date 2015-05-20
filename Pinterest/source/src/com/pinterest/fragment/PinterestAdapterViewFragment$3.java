// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.ui.grid.AdapterFooterView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestAdapterViewFragment

class  extends FeedApiResponseHandler
{

    final PinterestAdapterViewFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        updateStates(apiresponse);
    }

    public void onFinish()
    {
        onGridLoadFinish();
    }

    public void onStart()
    {
        if (_adapter == null || _adapter.getCount() == 0 || _forceEmpty)
        {
            AdapterFooterView.setState(_footerView, 2);
        } else
        {
            AdapterFooterView.setState(_footerView, 0);
        }
        setEmptyViewState(0);
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        while (_adapterView == null || _scrollView == null) 
        {
            return;
        }
        if (_adapter == null)
        {
            createAdapter();
        }
        boolean flag;
        if (_adapter.getDataSource() == null)
        {
            flag = true;
            reset(feed);
        } else
        {
            _adapter.getDataSource().appendItems(feed);
            flag = false;
        }
        updateStates(null);
        requestLayoutAll();
        _adapter.notifyDataSetChanged();
        _adapter.setLoading(false);
        onGridLoaded(flag);
    }

    ()
    {
        this$0 = PinterestAdapterViewFragment.this;
        super();
    }
}
