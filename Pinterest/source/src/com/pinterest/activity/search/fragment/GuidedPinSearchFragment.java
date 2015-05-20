// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.pinterest.activity.search.SearchNagView;
import com.pinterest.activity.search.adapter.SearchCategoryAdapter;
import com.pinterest.activity.search.model.QueryMetaData;
import com.pinterest.api.remote.SearchApi;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.grid.PinterestGridView;
import com.pinterest.ui.tab.Tab;
import com.pinterest.ui.tab.TabBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.lucasr.twowayview.TwoWayView;

// Referenced classes of package com.pinterest.activity.search.fragment:
//            GuidedPinFragment

public class GuidedPinSearchFragment extends GuidedPinFragment
{

    private static final int ALL_PINS = 0;
    private static final long FADE_OUT_ANIMATION_OFFSET = 100L;
    private static final int MY_PINS = 1;
    protected boolean _addPinToMessages;
    private SearchCategoryAdapter _categoryAdapter;
    TwoWayView _categoryListView;
    LinearLayout _categoryListWrapper;
    View _dummyPaddingView;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    View _focusView;
    private int _lastTabIndex;
    private Map _optFields;
    TabBar _tabBar;
    View _tabs;
    private android.view.View.OnClickListener onMyPinsClickListener;
    private PinSearchFeedResponse onPinsLoaded;
    private com.pinterest.ui.tab.TabBar.Listener onTabChangedListener;
    private PinSearchFeedResponse onUserPinsLoaded;

    public GuidedPinSearchFragment()
    {
        _addPinToMessages = false;
        _optFields = new HashMap();
        _eventsSubscriber = new _cls3();
        onMyPinsClickListener = new _cls4();
        onTabChangedListener = new _cls5();
        onPinsLoaded = new PinSearchFeedResponse(gridResponseHandler, 0);
        onUserPinsLoaded = new PinSearchFeedResponse(gridResponseHandler, 1);
        _layoutId = 0x7f030087;
    }

    private void addTabs()
    {
        _tabs = _gridVw.addHeaderView(0x7f030129);
        _tabs.setVisibility(8);
        _tabBar = (TabBar)_tabs.findViewById(0x7f0b02b9);
        Tab tab = (Tab)_tabBar.findViewById(0x7f0b02ba);
        Tab tab1 = (Tab)_tabBar.findViewById(0x7f0b02bb);
        tab.setText(Resources.string(0x7f0e0031));
        tab1.setText(Resources.string(0x7f0e0520));
        _tabBar.setCurrentIndex(_lastTabIndex);
        _tabBar.setListener(onTabChangedListener);
        _tabBar.disableUnderline();
    }

    private int getGuideXOffset(View view)
    {
        int ai[] = new int[2];
        view.getLocationInWindow(ai);
        return ai[0];
    }

    private List getMetaTermList()
    {
        ArrayList arraylist = new ArrayList();
        if (_queryMetaList != null)
        {
            for (Iterator iterator = _queryMetaList.iterator(); iterator.hasNext(); arraylist.add(((QueryMetaData)iterator.next()).toString())) { }
        }
        return arraylist;
    }

    private void setTabVisibility(int i)
    {
        _tabs.setVisibility(i);
    }

    private void updateRelatedQueries(List list, List list1)
    {
        if (_dummyPaddingView == null || _categoryListView == null)
        {
            return;
        }
        if ((list.size() > 0 || list1.size() > 0) && !_addPinToMessages)
        {
            ViewHelper.setVisibility(_dummyPaddingView, 0);
            ViewHelper.setVisibility(_categoryListView, 0);
            _categoryListView.setSelection(0);
        } else
        {
            ViewHelper.setVisibility(_dummyPaddingView, 8);
            ViewHelper.setVisibility(_categoryListView, 8);
        }
        _categoryAdapter.updateData(list, list1);
    }

    protected void loadData()
    {
        if (_lastQuery == null) goto _L2; else goto _L1
_L1:
        updateEmptyContent();
        _lastTabIndex;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 37
    //                   1 217;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        _optFields.clear();
        if (_lastQueryState == null || _lastQueryData == null) goto _L6; else goto _L5
_L5:
        _cls6..SwitchMap.com.pinterest.activity.search.model.QueryMetaData.FilterState[_lastQueryState.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 166
    //                   2 189;
           goto _L6 _L7 _L8
_L6:
        Object obj = AnimationUtils.loadAnimation(getView().getContext(), 0x7f04000f);
        ((Animation) (obj)).setStartOffset(100L);
        ((Animation) (obj)).setFillAfter(true);
        _categoryListView.startAnimation(((Animation) (obj)));
        if (_lastQueryData != null)
        {
            obj = _lastQueryData.getFilters();
        } else
        {
            obj = null;
        }
        SearchApi.a(_lastQuery, getMetaTermList(), _optFields, ((List) (obj)), onPinsLoaded, getApiTag());
        return;
_L7:
        _optFields.put("add_refine[]", _lastQueryData.toString());
          goto _L6
_L8:
        _optFields.put("remove_refine[]", _lastQueryData.toString());
          goto _L6
_L4:
        SearchApi.a(_lastQuery, onUserPinsLoaded, getApiTag());
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _categoryAdapter = new SearchCategoryAdapter(getActivity());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (bundle != null)
        {
            _lastQuery = bundle.getString("_lastQuery");
        }
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroyView()
    {
        _dummyPaddingView = null;
        _tabBar = null;
        _nagView = null;
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onPause()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
        });
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Events.register(_eventsSubscriber, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, new Class[0]);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (_tabBar != null)
        {
            bundle.putInt("tabIndex", _tabBar.getSelectedIndex());
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        if (bundle != null)
        {
            _lastTabIndex = bundle.getInt("tabIndex", 0);
        }
        ButterKnife.a(this, view);
        super.onViewCreated(view, bundle);
        Experiments.a("android_action_filter");
        _dummyPaddingView = new View(view.getContext());
        _dummyPaddingView.setVisibility(8);
        _gridVw.addHeaderView(_dummyPaddingView, -1, (int)Resources.dimension(0x7f0a00d9));
        _nagView = new SearchNagView(view.getContext());
        _nagView.setVisibility(8);
        _gridVw.addHeaderView(_nagView, -1, -2);
        addTabs();
        _categoryListView.setVisibility(8);
        _categoryListView.setOrientation(org.lucasr.twowayview.TwoWayView.Orientation.HORIZONTAL);
        _categoryListView.setLongClickable(true);
        _categoryListView.setAdapter(_categoryAdapter);
        _categoryListView.setHorizontalScrollBarEnabled(false);
        _categoryListView.setItemMargin((int)Device.dpToPixel(8F));
        _categoryListView.setOverScrollMode(2);
        _categoryListView.setOnItemClickListener(new _cls1());
        _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADING);
        _gridVw.addListener(new _cls2());
    }

    public void refresh()
    {
        super.refresh();
        Events.register(_eventsSubscriber, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, new Class[0]);
    }

    protected void updateEmptyContent()
    {
        _lastTabIndex;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 50;
           goto _L1 _L2
_L1:
        _emptyMessage = Resources.string(0x7f0e0207, new Object[] {
            _lastQuery
        });
_L4:
        super.updateEmptyContent();
        return;
_L2:
        _emptyMessage = Resources.string(0x7f0e0209, new Object[] {
            _lastQuery
        });
        if (true) goto _L4; else goto _L3
_L3:
    }













/*
    static int access$902(GuidedPinSearchFragment guidedpinsearchfragment, int i)
    {
        guidedpinsearchfragment._lastTabIndex = i;
        return i;
    }

*/

    private class _cls3 extends com.pinterest.base.Events.EventsSubscriber
    {

        final GuidedPinSearchFragment this$0;

        public void onEventMainThread(com.pinterest.ui.grid.PinGridCell.ImageLoadEvent imageloadevent)
        {
            StopWatch.get().complete("search_ttrfp");
            Events.unregister(_eventsSubscriber, new Class[] {
                com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
            });
        }

        _cls3()
        {
            this$0 = GuidedPinSearchFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final GuidedPinSearchFragment this$0;

        public void onClick(View view)
        {
            Events.post(new Navigation(Location.USER_PINS, MyUser.getUid()));
        }

        _cls4()
        {
            this$0 = GuidedPinSearchFragment.this;
            super();
        }
    }



    private class PinSearchFeedResponse extends com.pinterest.api.remote.PinApi.GuidedPinFeedApiResponse
    {

        int _tabIndex;
        final GuidedPinSearchFragment this$0;

        private boolean isValidFeedState()
        {
            return _lastTabIndex == _tabIndex;
        }

        public void onStart()
        {
            onStart();
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
                onSuccess(pinterestjsonobject);
            }
        }

        public void onSuccess(Feed feed)
        {
            if (isValidFeedState())
            {
                onSuccess(feed);
                Object obj = new HashMap();
                ((HashMap) (obj)).put("query", _lastQuery);
                Pinalytics.a(EventType.SEARCH_PINS, "0", ((HashMap) (obj)));
                obj = (GuidedPinFeed)feed;
                updateRelatedQueries(((GuidedPinFeed) (obj)).getRelatedQueries(), ((GuidedPinFeed) (obj)).getSearchFilters());
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

        public PinSearchFeedResponse()
        {
            this$0 = GuidedPinSearchFragment.this;
            super();
            _tabIndex = -1;
        }

        public PinSearchFeedResponse(FeedApiResponseHandler feedapiresponsehandler, int i)
        {
            this$0 = GuidedPinSearchFragment.this;
            super(feedapiresponsehandler);
            _tabIndex = -1;
            _tabIndex = i;
        }
    }


    private class _cls6
    {

        static final int $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$FilterState[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$FilterState = new int[com.pinterest.activity.search.model.QueryMetaData.FilterState.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$FilterState[com.pinterest.activity.search.model.QueryMetaData.FilterState.ADDED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$FilterState[com.pinterest.activity.search.model.QueryMetaData.FilterState.REMOVED.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$FilterState[com.pinterest.activity.search.model.QueryMetaData.FilterState.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final GuidedPinSearchFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            int j = _categoryAdapter.getItemViewType(i);
            adapterview = new HashMap();
            if (j == 1)
            {
                view = (SearchFilter)_categoryAdapter.getItem(i);
                GuidedSearchEvent guidedsearchevent = new GuidedSearchEvent(null, com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN);
                guidedsearchevent.setActionFilter(view);
                guidedsearchevent.setDominantColor(view.getDominantColorWithDefault());
                guidedsearchevent.setForceRefresh(true);
                adapterview.put("filter_type", view.getType());
                adapterview.put("label", view.getTypeValue());
                Pinalytics.a(ElementType.SEARCH_ACTION_SUGGESTION, adapterview);
                StopWatch.get().start("search_ttrfp");
                Events.post(guidedsearchevent);
                return;
            }
            if (j == 2)
            {
                SearchFilter searchfilter = (SearchFilter)_categoryAdapter.getItem(i);
                view = FilterDialog.newInstance(searchfilter, i, _categoryListView.getMeasuredHeight(), getGuideXOffset(view));
                view.setForceFullWidthOnTablet(true);
                adapterview.put("filter_type", searchfilter.getType());
                adapterview.put("label", searchfilter.getTypeValue());
                Pinalytics.a(ElementType.SEARCH_FILTER_DROPDOWNBUTTON, adapterview);
                Events.post(new DialogEvent(view));
                return;
            }
            view = (RelatedQueryItem)_categoryAdapter.getItem(i);
            adapterview.put("result_index", String.valueOf(i));
            adapterview.put("label", view.getTerm());
            Pinalytics.a(ElementType.SEARCH_GUIDE_SUGGESTION, adapterview);
            boolean flag;
            if (view.getPosition() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            adapterview = new GuidedSearchEvent(view.getTerm(), com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN);
            adapterview.setTokenFilter(true);
            adapterview.setTokenFront(flag);
            adapterview.setDominantColor(view.getDominantColor());
            adapterview.setFilterIndex(i);
            StopWatch.get().start("search_ttrfp");
            Events.post(adapterview);
        }

        _cls1()
        {
            this$0 = GuidedPinSearchFragment.this;
            super();
        }
    }


    private class _cls2 extends com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener
    {

        final GuidedPinSearchFragment this$0;

        public void onScroll(View view, int i, int j, int k, int l)
        {
            if (_focusView != null)
            {
                _focusView.requestFocus();
            }
            if (_categoryListView != null)
            {
                i = _categoryListWrapper.getMeasuredHeight();
                k = (int)_categoryListWrapper.getY();
                int i1 = (l - j) + k;
                if (j < l)
                {
                    if (k < 0)
                    {
                        _categoryListWrapper.setTranslationY(Math.min(0, i1));
                    }
                } else
                if (j > l && k > -i)
                {
                    _categoryListWrapper.setTranslationY(Math.max(-i, i1));
                }
                if (j == 0)
                {
                    setTabVisibility(0);
                    return;
                }
            }
        }

        _cls2()
        {
            this$0 = GuidedPinSearchFragment.this;
            super();
        }
    }

}
