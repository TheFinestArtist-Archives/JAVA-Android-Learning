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
//            PinterestGridFragment

class this._cls0
    implements LoadMoreListener
{

    final PinterestGridFragment this$0;

    public void loadMore()
    {
        if (_adapter != null && _adapter.getCount() != 0) goto _L2; else goto _L1
_L1:
        String s;
        return;
_L2:
        if ((s = _adapter.getDataSource().getNextUrl()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        FeedApiResponseHandler feedapiresponsehandler = _adapter.getDataSource().newApiHandler();
        if (feedapiresponsehandler != null)
        {
            try
            {
                feedapiresponsehandler.setHandler(gridResponseHandler);
                BaseApi.e(s, feedapiresponsehandler, PinterestGridFragment.access$1200(PinterestGridFragment.this));
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$0 = PinterestGridFragment.this;
        super();
    }
}
