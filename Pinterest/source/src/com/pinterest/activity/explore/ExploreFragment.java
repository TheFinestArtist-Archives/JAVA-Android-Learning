// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.pinterest.activity.explore.adapter.ExploreAdapter;
import com.pinterest.activity.explore.adapter.ExploreInterestsAdapter;
import com.pinterest.activity.notifications.view.MaxWidthListView;
import com.pinterest.activity.task.fragment.ListFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Category;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.CategoryApi;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.experiment.Experiments;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;

public class ExploreFragment extends ListFragment
    implements android.widget.AdapterView.OnItemClickListener
{

    private ExploreInterestsAdapter _exploreInterestsAdapter;
    private View _searchBar;
    private com.pinterest.api.remote.CategoryApi.CategoriesFeedApiResponse onFeedLoaded;
    private com.pinterest.activity.explore.util.ExploreInterestsData.ExploreInterestsResponseHandler onInterestExploreLoaded;
    private com.pinterest.api.remote.InterestsApi.InterestsFeedApiResponse onTrendingInterestsLoaded;

    public ExploreFragment()
    {
        onFeedLoaded = new _cls7(true, true);
        onInterestExploreLoaded = new _cls8();
        onTrendingInterestsLoaded = new _cls9();
    }

    protected void loadData()
    {
        if (Experiments.e())
        {
            InterestsApi.c(onInterestExploreLoaded, getApiTag());
            InterestsApi.a(onTrendingInterestsLoaded, getApiTag());
            (new _cls6()).schedule(Constants.ANIM_SPEED_SLOW);
            return;
        } else
        {
            CategoryApi.a(new com.pinterest.api.remote.CategoryApi.CategoriesFeedApiResponse(onFeedLoaded), getApiTag());
            return;
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (Experiments.e())
        {
            MyUser.getLastUsedInterests(new _cls4());
            return;
        } else
        {
            MyUser.getLastUsedCategories(new _cls5());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030081;
        _menuId = 0x7f100002;
        _adapter = new ExploreAdapter();
        _exploreInterestsAdapter = new ExploreInterestsAdapter();
    }

    public void onDestroyView()
    {
        if (_searchBar != null)
        {
            _searchBar.setOnClickListener(null);
            _searchBar.setOnLongClickListener(null);
            _searchBar = null;
        }
        super.onDestroyView();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((ExploreAdapter)_adapter).getItem(i);
        if (adapterview == null)
        {
            return;
        }
        view = adapterview.getUid();
        Pinalytics.a(ElementType.CATEGORY_ICON, ComponentType.FLOWED_CATEGORY, view);
        if ("1002".equals(view))
        {
            Events.post(new Navigation(Location.FEATURED_BOARD, adapterview));
        } else
        {
            StopWatch.get().start("category_ttrfp");
            Events.post(new Navigation(Location.CATEGORY, adapterview));
        }
        MyUser.setLastSelectedCategoryKey(adapterview.getKey());
        MyUser.addLastUsedCategory(adapterview.getKey());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _listView = (MaxWidthListView)view.findViewById(0x7f0b015c);
        _listView.addFooterView(_footerView, null, false);
        Experiments.a("topical_feeds_android");
        if (Experiments.e())
        {
            _listView.setAdapter(_exploreInterestsAdapter);
            _listView.setOnScrollListener(new _cls1());
        } else
        {
            _listView.setAdapter(_adapter);
            _listView.setOnItemClickListener(this);
        }
        _searchBar = LayoutInflater.from(view.getContext()).inflate(0x7f030119, _actionBar, false);
        _actionBar.addView(_searchBar);
        _searchBar.setOnClickListener(new _cls2());
        if (ApplicationInfo.isNonProduction())
        {
            _searchBar.setOnLongClickListener(new _cls3());
        }
    }
































    private class _cls7 extends com.pinterest.api.remote.CategoryApi.CategoriesFeedApiResponse
    {

        final ExploreFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            AdapterEmptyView.setState(, 1);
            setEmptyContent(
// JavaClassFileOutputException: get_constant: invalid tag

        public void onStart()
        {
            onStart();
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public void onSuccess(Feed feed)
        {
            onSuccess(feed);
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        _cls7(boolean flag, boolean flag1)
        {
            this$0 = ExploreFragment.this;
            super(flag, flag1);
        }
    }


    private class _cls8 extends com.pinterest.activity.explore.util.ExploreInterestsData.ExploreInterestsResponseHandler
    {

        final ExploreFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            onFailure(throwable, apiresponse);
            AdapterEmptyView.setState(
// JavaClassFileOutputException: get_constant: invalid tag

        public void onStart()
        {
            onStart();
            if (_exploreInterestsAdapter != null && _exploreInterestsAdapter.getCount() > 0)
            {
                AdapterFooterView.setState(ExploreFragment.this.onSuccess, 0);
                AdapterEmptyView.setState(
// JavaClassFileOutputException: get_constant: invalid tag

        public void onSuccess(ArrayList arraylist)
        {
            onSuccess(arraylist);
            if (_exploreInterestsAdapter != null)
            {
                _exploreInterestsAdapter.setDataSource(arraylist);
            }
            AdapterFooterView.setState(ExploreFragment.this.onSuccess, 1);
            setEmptyContent(_exploreInterestsAdapter);
        }

        _cls8()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    private class _cls9 extends com.pinterest.api.remote.InterestsApi.InterestsFeedApiResponse
    {

        final ExploreFragment this$0;

        public void onSuccess(Feed feed)
        {
            feed = (ArrayList)((InterestsFeed)feed).getItems();
            if (_exploreInterestsAdapter != null)
            {
                _exploreInterestsAdapter.setTrendingInterests(feed);
            }
        }

        _cls9()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    private class _cls6 extends BackgroundTask
    {

        ArrayList interests;
        final ExploreFragment this$0;

        public void onFinish()
        {
            if (interests != null && interests.size() > 0 && _exploreInterestsAdapter != null)
            {
                _exploreInterestsAdapter.setDataSource(interests);
            }
        }

        public void run()
        {
            interests = ExploreInterestsData.getExploreDataBlocking();
        }

        _cls6()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    private class _cls4 extends BackgroundResult
    {

        final ExploreFragment this$0;

        public void onFinish(Object obj)
        {
            if ((obj instanceof List) && _exploreInterestsAdapter != null)
            {
                _exploreInterestsAdapter.setRecentInterests((ArrayList)obj);
            }
        }

        _cls4()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }



    private class _cls1
        implements android.widget.AbsListView.OnScrollListener
    {

        final ExploreFragment this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (i == 0 || i == 1)
            {
                ImageCache.resumeTag("ExploreSubInterestImage");
                return;
            } else
            {
                ImageCache.pauseTag("ExploreSubInterestImage");
                return;
            }
        }

        _cls1()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final ExploreFragment this$0;

        public void onClick(View view)
        {
            view = new Navigation(Location.SEARCH, "");
            view.putExtra("com.pinterest.EXTRA_SEARCH_MODE", "VALUE_SEARCH_GLOBAL");
            Events.post(view);
        }

        _cls2()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnLongClickListener
    {

        final ExploreFragment this$0;

        public boolean onLongClick(View view)
        {
            DeveloperHelper.a(getActivity());
            return true;
        }

        _cls3()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }

}
