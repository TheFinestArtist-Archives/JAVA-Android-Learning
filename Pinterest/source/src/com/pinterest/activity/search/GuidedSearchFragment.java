// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.search.event.GuidedSearchEvent;
import com.pinterest.activity.search.event.SearchSuggestionEvent;
import com.pinterest.activity.search.fragment.GuidedBoardSearchFragment;
import com.pinterest.activity.search.fragment.GuidedMyPinSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPeopleSearchFragment;
import com.pinterest.activity.search.fragment.GuidedPinFragment;
import com.pinterest.activity.search.fragment.GuidedPinSearchFragment;
import com.pinterest.activity.search.fragment.SearchTypeaheadFragment;
import com.pinterest.activity.search.fragment.addpin.AddPinTapFragment;
import com.pinterest.activity.search.model.QueryMetaData;
import com.pinterest.activity.search.ui.GuidedSearchBar;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.ui.text.IconView;
import org.apache.commons.lang3.StringUtils;

public class GuidedSearchFragment extends BaseFragment
{

    private IconView _backBt;
    private Fragment _currentFragment;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private String _searchMode;
    private GuidedSearchBar _searchView;
    private User _user;

    public GuidedSearchFragment()
    {
        _eventsSubscriber = new _cls3();
    }

    private void addQueryMetaData(GuidedSearchEvent guidedsearchevent, String s, com.pinterest.activity.search.model.QueryMetaData.ContextType contexttype)
    {
        s = new QueryMetaData(s, contexttype);
        s.setCategory("word");
        s.setPosition(guidedsearchevent.getFilterIndex());
        s.setFilters(_searchView.getActionFilterList());
        _searchView.addQueryMetaData(s);
        _searchView.setLastQueryData(s);
        _searchView.setLastQueryState(com.pinterest.activity.search.model.QueryMetaData.FilterState.ADDED);
    }

    private void loadBoardSearchFragment(GuidedSearchEvent guidedsearchevent)
    {
        if (!(_currentFragment instanceof GuidedBoardSearchFragment))
        {
            GuidedBoardSearchFragment guidedboardsearchfragment = new GuidedBoardSearchFragment();
            guidedboardsearchfragment.setLastQuery(guidedsearchevent.getQuery());
            _currentFragment = guidedboardsearchfragment;
            loadFragment(guidedboardsearchfragment);
            return;
        } else
        {
            ((GuidedBoardSearchFragment)_currentFragment).reload(guidedsearchevent.getQuery());
            return;
        }
    }

    private void loadPinSearchFragment(GuidedSearchEvent guidedsearchevent)
    {
        if (!(_currentFragment instanceof GuidedPinSearchFragment) && !(_currentFragment instanceof GuidedMyPinSearchFragment))
        {
            Object obj;
            if (_navigation.getExtra("com.pinterest.EXTRA_CONVERSATION_ID") != null)
            {
                obj = new AddPinTapFragment();
            } else
            if (StringUtils.equals(_searchMode, "VALUE_SEARCH_GLOBAL"))
            {
                obj = new GuidedPinSearchFragment();
            } else
            {
                obj = new GuidedMyPinSearchFragment();
            }
            ((GuidedPinFragment) (obj)).setNavigation(_navigation);
            ((GuidedPinFragment) (obj)).setLastQuery(guidedsearchevent.getQuery());
            ((GuidedPinFragment) (obj)).setQueryMetaList(guidedsearchevent.getQueryMetaList());
            ((GuidedPinFragment) (obj)).setLastQueryData(guidedsearchevent.getLastQueryData());
            ((GuidedPinFragment) (obj)).setLastQueryState(guidedsearchevent.getLastQueryState());
            _currentFragment = ((Fragment) (obj));
            loadFragment(((Fragment) (obj)));
            return;
        } else
        {
            ((GuidedPinFragment)_currentFragment).reload(guidedsearchevent.getQuery(), guidedsearchevent.getQueryMetaList(), guidedsearchevent.getLastQueryData(), guidedsearchevent.getLastQueryState());
            return;
        }
    }

    private void loadSearchFragment(GuidedSearchEvent guidedsearchevent)
    {
        switch (_cls4..SwitchMap.com.pinterest.activity.search.event.GuidedSearchEvent.SearchType[guidedsearchevent.getType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            loadPinSearchFragment(guidedsearchevent);
            return;

        case 2: // '\002'
            loadBoardSearchFragment(guidedsearchevent);
            return;

        case 3: // '\003'
            loadUserSearchFragment(guidedsearchevent);
            break;
        }
    }

    private void loadTypeaheadFragment(String s, com.pinterest.api.remote.SearchApi.Scope scope)
    {
        if (!(_currentFragment instanceof SearchTypeaheadFragment))
        {
            SearchTypeaheadFragment searchtypeaheadfragment = new SearchTypeaheadFragment();
            searchtypeaheadfragment.setSearchView(_searchView);
            searchtypeaheadfragment.setSearchMode(_searchMode);
            searchtypeaheadfragment.setSearchScope(scope);
            searchtypeaheadfragment.setNavigation(_navigation);
            searchtypeaheadfragment.setQuery(s);
            _currentFragment = searchtypeaheadfragment;
            loadFragment(searchtypeaheadfragment);
            return;
        } else
        {
            ((SearchTypeaheadFragment)_currentFragment).reload(s, scope);
            return;
        }
    }

    private void loadUserSearchFragment(GuidedSearchEvent guidedsearchevent)
    {
        if (!(_currentFragment instanceof GuidedPeopleSearchFragment))
        {
            GuidedPeopleSearchFragment guidedpeoplesearchfragment = new GuidedPeopleSearchFragment();
            guidedpeoplesearchfragment.setLastQuery(guidedsearchevent.getQuery());
            _currentFragment = guidedpeoplesearchfragment;
            loadFragment(guidedpeoplesearchfragment);
            return;
        } else
        {
            ((GuidedPeopleSearchFragment)_currentFragment).reload(guidedsearchevent.getQuery());
            return;
        }
    }

    public void getFocus()
    {
        if (_searchView != null && _searchView.searchHintEnabled())
        {
            _searchView.getFocus();
        }
    }

    protected void getInitialFocus()
    {
        if (_searchView == null)
        {
            return;
        } else
        {
            _searchView.post(new _cls2());
            return;
        }
    }

    protected void loadFragment(Fragment fragment)
    {
        FragmentHelper.replaceFragment(this, fragment, false);
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber);
        getInitialFocus();
        if (_currentFragment != null)
        {
            Pinalytics.a(_currentFragment);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030085;
        if (bundle != null)
        {
            _searchMode = bundle.getString("com.pinterest.EXTRA_SEARCH_MODE");
            if (StringUtils.equals(_searchMode, "VALUE_SEARCH_LOCAL"))
            {
                _user = MyUser.get();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    protected void onDeactivate()
    {
        _searchView.clearFocus();
        Events.unregister(_eventsSubscriber);
        super.onDeactivate();
    }

    public void onDestroyView()
    {
        Events.unregister(_eventsSubscriber);
        _searchView = null;
        if (_backBt != null)
        {
            _backBt.setOnClickListener(null);
            _backBt = null;
        }
        _currentFragment = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("com.pinterest.EXTRA_SEARCH_MODE", _searchMode);
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        Events.register(_eventsSubscriber, com/pinterest/activity/search/event/GuidedSearchEvent, new Class[] {
            com/pinterest/activity/search/event/SearchSuggestionEvent
        });
        _searchView = (GuidedSearchBar)view.findViewById(0x7f0b0059);
        _searchView.setApiTag(getApiTag());
        _searchView.setUser(_user);
        _backBt = (IconView)view.findViewById(0x7f0b0058);
        _backBt.setOnClickListener(new _cls1());
    }

    public void setActive(boolean flag)
    {
        super.setActive(flag);
        if (_currentFragment instanceof BaseFragment)
        {
            ((BaseFragment)_currentFragment).setActive(flag);
        }
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _searchMode = (String)navigation.getExtra("com.pinterest.EXTRA_SEARCH_MODE");
        if (StringUtils.equals(_searchMode, "VALUE_SEARCH_LOCAL"))
        {
            _user = MyUser.get();
        }
    }







    private class _cls3 extends com.pinterest.base.Events.EventsSubscriber
    {

        final GuidedSearchFragment this$0;

        public void onEventMainThread(GuidedSearchEvent guidedsearchevent)
        {
            boolean flag = false;
            if (TextUtils.isEmpty(guidedsearchevent.getQuery()) && !guidedsearchevent.getForceRefresh()) goto _L2; else goto _L1
_L1:
            _searchView.loseFocus();
            Device.hideSoftKeyboard(_searchView);
            if (!guidedsearchevent.isTokenFilter()) goto _L4; else goto _L3
_L3:
            if (_searchView.addTokenFilter(guidedsearchevent.getQuery(), guidedsearchevent.getDominantColor(), guidedsearchevent.isTokenFront(), false)) goto _L5; else goto _L2
_L2:
            return;
_L5:
            addQueryMetaData(guidedsearchevent, guidedsearchevent.getQuery(), com.pinterest.activity.search.model.QueryMetaData.ContextType.FILTER);
            guidedsearchevent.setQuery(_searchView.getCurrentTokenQuery(false));
_L7:
            guidedsearchevent.setQueryMetaList(_searchView.getQueryMetaDataList());
            guidedsearchevent.setLastQueryData(_searchView.getLastQueryDataWithFilters());
            guidedsearchevent.setLastQueryState(_searchView.getLastQueryState());
            loadSearchFragment(guidedsearchevent);
            return;
_L4:
            if (guidedsearchevent.getActionFilter() != null)
            {
                Object obj = guidedsearchevent.getActionFilter();
                boolean flag1 = com.pinterest.api.model.SearchFilter.FilterType.MODE.getValue().equals(((SearchFilter) (obj)).getType());
                Object obj1 = _searchView;
                String s = guidedsearchevent.getDominantColor();
                if (flag1 || guidedsearchevent.isTokenFront())
                {
                    flag = true;
                }
                if (!((GuidedSearchBar) (obj1)).addSearchFilter(((SearchFilter) (obj)), s, flag, flag1))
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj1 = GuidedSearchFragment.this;
                s = ((SearchFilter) (obj)).getTypeValue();
                if (flag1)
                {
                    obj = com.pinterest.activity.search.model.QueryMetaData.ContextType.MODE;
                } else
                {
                    obj = com.pinterest.activity.search.model.QueryMetaData.ContextType.ACTION_FILTER;
                }
                ((GuidedSearchFragment) (obj1)).addQueryMetaData(guidedsearchevent, s, ((com.pinterest.activity.search.model.QueryMetaData.ContextType) (obj)));
            }
            if (true) goto _L7; else goto _L6
_L6:
            if (true) goto _L2; else goto _L8
_L8:
        }

        public void onEventMainThread(SearchSuggestionEvent searchsuggestionevent)
        {
            com.pinterest.api.remote.SearchApi.Scope scope = com.pinterest.api.remote.SearchApi.Scope.d;
            if (searchsuggestionevent.getType() == com.pinterest.activity.search.event.SearchSuggestionEvent.SuggestionType.RECENT_QUERY)
            {
                if ("VALUE_SEARCH_GLOBAL".equals(_searchMode))
                {
                    scope = com.pinterest.api.remote.SearchApi.Scope.d;
                } else
                {
                    scope = com.pinterest.api.remote.SearchApi.Scope.e;
                }
            } else
            if ("VALUE_SEARCH_GLOBAL".equals(_searchMode))
            {
                scope = com.pinterest.api.remote.SearchApi.Scope.b;
            } else
            {
                scope = com.pinterest.api.remote.SearchApi.Scope.c;
            }
            loadTypeaheadFragment(searchsuggestionevent.getQuery(), scope);
        }

        _cls3()
        {
            this$0 = GuidedSearchFragment.this;
            super();
        }
    }


    private class _cls4
    {

        static final int $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType = new int[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.BOARD.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$event$GuidedSearchEvent$SearchType[com.pinterest.activity.search.event.GuidedSearchEvent.SearchType.PINNER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls2
        implements Runnable
    {

        final GuidedSearchFragment this$0;

        public void run()
        {
            if (_searchView != null && _searchView.searchHintEnabled())
            {
                _searchView.getFocus();
            }
        }

        _cls2()
        {
            this$0 = GuidedSearchFragment.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final GuidedSearchFragment this$0;

        public void onClick(View view)
        {
            pressBackButton();
        }

        _cls1()
        {
            this$0 = GuidedSearchFragment.this;
            super();
        }
    }

}
