// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.pinterest.activity.search.SearchNagView;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.GuidedPinFeed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.schemas.event.EventType;
import com.pinterest.ui.ViewHelper;
import java.util.HashMap;
import org.lucasr.twowayview.TwoWayView;

// Referenced classes of package com.pinterest.activity.search.fragment:
//            GuidedPinSearchFragment

class _tabIndex extends com.pinterest.api.remote.hFeedResponse
{

    int _tabIndex;
    final GuidedPinSearchFragment this$0;

    private boolean isValidFeedState()
    {
        return GuidedPinSearchFragment.access$900(GuidedPinSearchFragment.this) == _tabIndex;
    }

    public void onStart()
    {
        super.hFeedResponse();
        if (_categoryListView != null)
        {
            _categoryListView.setEnabled(false);
        }
        ViewHelper.setVisibility(_nagView, 8);
    }

    public void onSuccess(PinterestJsonObject pinterestjsonobject)
    {
        if (isValidFeedState())
        {
            super.isValidFeedState(pinterestjsonobject);
        }
    }

    public void onSuccess(Feed feed)
    {
        if (isValidFeedState())
        {
            super.isValidFeedState(feed);
            Object obj = new HashMap();
            ((HashMap) (obj)).put("query", _lastQuery);
            Pinalytics.a(EventType.SEARCH_PINS, "0", ((HashMap) (obj)));
            obj = (GuidedPinFeed)feed;
            GuidedPinSearchFragment.access$1000(GuidedPinSearchFragment.this, ((GuidedPinFeed) (obj)).getRelatedQueries(), ((GuidedPinFeed) (obj)).getSearchFilters());
            SearchNagView.showSearchNag(_nagView, feed);
            if (_categoryListView != null)
            {
                _categoryListView.setEnabled(true);
                feed = AnimationUtils.loadAnimation(getView().getContext(), 0x7f040014);
                feed.setFillAfter(true);
                _categoryListView.startAnimation(feed);
            }
        }
    }

    public ()
    {
        this$0 = GuidedPinSearchFragment.this;
        super();
        _tabIndex = -1;
    }

    public _tabIndex(FeedApiResponseHandler feedapiresponsehandler, int i)
    {
        this$0 = GuidedPinSearchFragment.this;
        super(feedapiresponsehandler);
        _tabIndex = -1;
        _tabIndex = i;
    }
}
