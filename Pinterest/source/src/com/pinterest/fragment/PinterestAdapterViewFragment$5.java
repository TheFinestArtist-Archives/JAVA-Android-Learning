// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import com.pinterest.adapter.LoadMoreListener;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.BaseApi;
import com.pinterest.api.remote.FeedApiResponseHandler;

// Referenced classes of package com.pinterest.fragment:
//            PinterestAdapterViewFragment

class this._cls0
    implements LoadMoreListener
{

    final PinterestAdapterViewFragment this$0;

    public void loadMore()
    {
        String s;
        if (_adapter == null || _adapter.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s = _adapter.getDataSource().getNextUrl();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        Object obj = getApiHandlerClass().newInstance();
        if (obj instanceof FeedApiResponseHandler)
        {
            obj = (FeedApiResponseHandler)obj;
            ((FeedApiResponseHandler) (obj)).setHandler(onGridLoad);
            BaseApi.e(s, ((com.pinterest.api.BaseApiResponseHandler) (obj)), PinterestAdapterViewFragment.access$100(PinterestAdapterViewFragment.this));
        }
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    ()
    {
        this$0 = PinterestAdapterViewFragment.this;
        super();
    }
}
