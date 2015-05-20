// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import com.pinterest.activity.digest.adapter.DigestPinGridAdapter;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestPinFragment

class nit> extends FeedApiResponseHandler
{

    final DigestPinFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        if (DigestPinFragment.access$1300(DigestPinFragment.this) != null)
        {
            throwable = Resources.string(0x7f0e02cb);
            if (!Device.hasInternet())
            {
                DigestPinFragment.access$1400(DigestPinFragment.this).setState(com.pinterest.ui.grid.ate.ERROR);
                return;
            }
            if (apiresponse != null)
            {
                throwable = apiresponse.getMessageDetailIfExist();
            }
            DigestPinFragment.access$1500(DigestPinFragment.this).setState(com.pinterest.ui.grid.ate.ERROR);
            DigestPinFragment.access$1600(DigestPinFragment.this).setEmptyMessage(throwable);
        }
        DigestPinFragment.access$1702(DigestPinFragment.this, false);
        if (DigestPinFragment.access$1800(DigestPinFragment.this) != null)
        {
            ((PinGridAdapter)DigestPinFragment.access$1900(DigestPinFragment.this)).setLoading(false);
        }
        DigestPinFragment.access$2100(DigestPinFragment.this, DigestPinFragment.access$2000(DigestPinFragment.this));
    }

    public void onStart()
    {
        super.onStart();
        if (DigestPinFragment.access$2200(DigestPinFragment.this) != null)
        {
            DigestPinFragment.access$2300(DigestPinFragment.this).setState(com.pinterest.ui.grid.ate.LOADING);
        }
        if (DigestPinFragment.access$2400(DigestPinFragment.this) != null)
        {
            ((PinGridAdapter)DigestPinFragment.access$2500(DigestPinFragment.this)).setLoading(true);
        }
    }

    public void onSuccess(Feed feed)
    {
        feed = ((DigestPinGridAdapter)DigestPinFragment.access$000(DigestPinFragment.this)).resetDataFeed(feed);
        super.onSuccess(feed);
        if (DigestPinFragment.access$100(DigestPinFragment.this) != null)
        {
            if (DigestPinFragment.access$200(DigestPinFragment.this))
            {
                DigestPinFragment.access$300(DigestPinFragment.this).setDataSource(feed);
                DigestPinFragment.access$400(DigestPinFragment.this, false);
            } else
            {
                DigestPinFragment.access$500(DigestPinFragment.this).appendDataSource(feed);
                DigestPinFragment.access$600(DigestPinFragment.this, false);
            }
            DigestPinFragment.access$700(DigestPinFragment.this).setState(com.pinterest.ui.grid.ate.LOADED);
        }
        DigestPinFragment.access$802(DigestPinFragment.this, false);
        if (DigestPinFragment.access$900(DigestPinFragment.this) != null)
        {
            ((PinGridAdapter)DigestPinFragment.access$1000(DigestPinFragment.this)).setLoading(false);
        }
        DigestPinFragment.access$1200(DigestPinFragment.this, DigestPinFragment.access$1100(DigestPinFragment.this));
    }

    dAdapter()
    {
        this$0 = DigestPinFragment.this;
        super();
    }
}
