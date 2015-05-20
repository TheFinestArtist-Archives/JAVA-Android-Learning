// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestGridFragment

class  extends FeedApiResponseHandler
{

    final PinterestGridFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        if (_gridVw != null)
        {
            throwable = Resources.string(0x7f0e02cb);
            if (!Device.hasInternet())
            {
                _gridVw.setState(com.pinterest.ui.grid.ERROR);
                return;
            }
            if (apiresponse != null)
            {
                throwable = apiresponse.getMessageDetailIfExist();
            }
            _gridVw.setState(com.pinterest.ui.grid.ERROR);
            _gridVw.setEmptyMessage(throwable);
        }
        PinterestGridFragment.access$1002(PinterestGridFragment.this, false);
        if (_adapter != null)
        {
            _adapter.setLoading(false);
        }
        PinterestGridFragment.access$1100(PinterestGridFragment.this, _adapter);
    }

    public void onFinish()
    {
        super.onFinish();
        if (_swipeVw != null)
        {
            _swipeVw.setRefreshing(false);
        }
    }

    public void onStart()
    {
        super.onStart();
        if (_gridVw != null)
        {
            _gridVw.setState(com.pinterest.ui.grid.LOADING);
        }
        if (_adapter != null)
        {
            _adapter.setLoading(true);
        }
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (_gridVw != null)
        {
            if (PinterestGridFragment.access$700(PinterestGridFragment.this))
            {
                _gridVw.setDataSource(feed);
                onDataSourceChanged(false);
            } else
            {
                _gridVw.appendDataSource(feed);
                onDataSourceChanged(false);
            }
            _gridVw.setState(com.pinterest.ui.grid.LOADED);
        }
        PinterestGridFragment.access$802(PinterestGridFragment.this, false);
        if (_adapter != null)
        {
            _adapter.setLoading(false);
        }
        PinterestGridFragment.access$900(PinterestGridFragment.this, _adapter);
    }

    ()
    {
        this$0 = PinterestGridFragment.this;
        super();
    }
}
