// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.adapter.LoadMoreListener;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.adapter.Refreshable;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.base.Device;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.grid.PinterestAdapterView;
import com.pinterest.ui.scrollview.ObservableScrollView;

public abstract class PinterestAdapterViewFragment extends BaseFragment
    implements Refreshable
{

    protected PinterestBaseAdapter _adapter;
    protected LoadMoreListener _adapterListener;
    protected PinterestAdapterView _adapterView;
    com.pinterest.ui.grid.PinterestAdapterView.PinterAdapterViewListener _adapterViewListener;
    private boolean _didAutoScroll;
    protected AdapterEmptyView _emptyView;
    protected AdapterFooterView _footerView;
    protected boolean _forceEmpty;
    protected boolean _needsLayout;
    protected long _resetDiff;
    protected Bundle _savedInstanceState;
    protected ScrollListener _scrollListener;
    protected ObservableScrollView _scrollView;
    protected float _toYScroll;
    protected FeedApiResponseHandler onGridLoad;
    protected com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener scrollListener;

    public PinterestAdapterViewFragment()
    {
        _forceEmpty = false;
        _toYScroll = -1F;
        _needsLayout = false;
        _resetDiff = 0x1b7740L;
        _adapterViewListener = new _cls2();
        onGridLoad = new _cls3();
        scrollListener = new _cls4();
        _adapterListener = new _cls5();
    }

    protected abstract void createAdapter();

    public PinterestBaseAdapter getAdapter()
    {
        return _adapter;
    }

    protected abstract Class getApiHandlerClass();

    protected abstract android.widget.AdapterView.OnItemClickListener getClickHandler();

    protected String getEmptyDynamicText()
    {
        return null;
    }

    protected int getEmptyIcon()
    {
        return 0x7f020134;
    }

    protected int getEmptyMessage()
    {
        return 0x7f0e01ff;
    }

    protected android.widget.AdapterView.OnItemLongClickListener getLongClickHandler()
    {
        return null;
    }

    protected void init()
    {
        Feed feed1;
        boolean flag;
        flag = false;
        if (_savedInstanceState != null)
        {
            _forceEmpty = _savedInstanceState.getBoolean("_forceEmpty");
        }
        feed1 = Feed.restoreInstanceState(_savedInstanceState);
        if (!ModelHelper.isValid(feed1)) goto _L2; else goto _L1
_L1:
        Feed feed;
        _adapter.setDataSource(feed1);
        feed = feed1;
_L4:
        if (flag)
        {
            loadData();
            return;
        } else
        {
            reset(feed);
            return;
        }
_L2:
        feed = feed1;
        if (_adapter != null)
        {
            feed = feed1;
            if (_adapter.getDataSource() != null)
            {
                Feed feed2 = _adapter.getDataSource();
                feed = feed2;
                if (feed2.getAbsCount() > 0)
                {
                    feed2.onStart();
                    feed = feed2;
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected abstract void loadData();

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030084;
        _savedInstanceState = bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        _savedInstanceState = bundle;
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        if (_adapter != null)
        {
            _adapter.setListener(null);
            _adapter.setDataListener(null);
        }
        _adapter = null;
        scrollListener = null;
        _adapterViewListener = null;
        _adapterListener = null;
        _scrollListener = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (_adapter != null)
        {
            _adapter.onStop();
        }
        _savedInstanceState = null;
        if (_adapterView != null && _scrollView != null)
        {
            _toYScroll = (float)_scrollView.scrollY / (float)_adapterView.getMeasuredHeight();
        }
        if (_adapterView != null)
        {
            _adapterView.setAdapter(null);
            _adapterView.setContainingScrollView(null);
            _adapterView.setOnItemClickListener(null);
            _adapterView.destroy();
            _adapterView = null;
        }
        if (_scrollView != null)
        {
            _scrollView.resetViewListener();
            _scrollView = null;
        }
        if (_emptyView != null)
        {
            _emptyView.setRefreshAction(null);
        }
        _emptyView = null;
        _footerView = null;
        super.onDestroyView();
    }

    protected void onGridLoadFinish()
    {
    }

    public void onGridLoaded(boolean flag)
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (_adapter != null)
        {
            Feed feed = _adapter.getDataSource();
            if (feed != null && feed.getAbsCount() > 0)
            {
                feed.saveInstanceState(bundle);
            }
        }
        bundle.remove("yOffset");
        if (_scrollView != null)
        {
            bundle.putFloat("yOffset", (float)_scrollView.scrollY / (float)_adapterView.getMeasuredHeight());
        }
        bundle.putBoolean("_forceEmpty", _forceEmpty);
        super.onSaveInstanceState(bundle);
    }

    public void onScrolled()
    {
        if (_scrollListener != null)
        {
            _scrollListener.onScroll(_adapterView, 0, _scrollView.scrollY);
        }
    }

    public void onStart()
    {
        super.onStart();
        boolean flag1 = false;
        boolean flag = flag1;
        if (_adapter != null)
        {
            flag = flag1;
            if (_adapter.getDataSource() != null)
            {
                boolean flag2 = _adapter.getDataSource().onStart();
                flag = flag2;
                if (flag2)
                {
                    updateStates(null);
                    flag = flag2;
                    if (_scrollView != null)
                    {
                        flag = flag2;
                        if (_adapterView != null)
                        {
                            reset(_adapter.getDataSource(), (float)_scrollView.scrollY / (float)_adapterView.getMeasuredHeight());
                            flag = flag2;
                        }
                    }
                }
            }
        }
        if (_adapterView != null && (_adapterView.getChildCount() == 0 || _needsLayout) && _savedInstanceState != null)
        {
            _needsLayout = true;
        }
        if (_adapter != null && flag)
        {
            _adapter.notifyDataSetChanged();
        }
    }

    public void onStop()
    {
        _savedInstanceState = null;
        if (_adapter != null && _adapter.getDataSource() != null)
        {
            _adapter.getDataSource().onStop();
        }
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _emptyView = (AdapterEmptyView)view.findViewById(0x7f0b0140);
        if (_emptyView != null)
        {
            _emptyView.setRefreshAction(new _cls1());
        }
        _scrollView = (ObservableScrollView)view.findViewById(0x7f0b0160);
        _scrollView.addListener(scrollListener);
        if (_adapter == null)
        {
            createAdapter();
        }
        _adapterView = (PinterestAdapterView)view.findViewById(0x7f0b01ba);
        _adapterView.setContainingScrollView(_scrollView);
        _adapterView.setOnItemClickListener(getClickHandler());
        _adapterView.setOnItemLongClickListener(getLongClickHandler());
        _adapterView.setListener(_adapterViewListener);
        _adapterView.setAdapter(_adapter);
        _footerView = (AdapterFooterView)view.findViewById(0x7f0b0122);
        if (_footerView != null)
        {
            _footerView.setShadowVisibility(4);
        }
        init();
        if (_adapter != null)
        {
            _adapter.onStart();
        }
    }

    public void refresh()
    {
        loadData();
    }

    protected void requestLayoutAll()
    {
        if (_adapterView == null || _scrollView == null)
        {
            return;
        } else
        {
            _adapterView.requestLayout();
            _scrollView.invalidate();
            _scrollView.requestLayout();
            getView().requestLayout();
            return;
        }
    }

    public void reset(Feed feed)
    {
        if (_adapterView == null)
        {
            return;
        } else
        {
            _didAutoScroll = false;
            _adapter.resetCachedItemHeights();
            _adapter.setDataSource(feed);
            _adapterView.reset();
            return;
        }
    }

    public void reset(Feed feed, float f)
    {
        if (_scrollView == null)
        {
            return;
        } else
        {
            _toYScroll = f;
            reset(feed);
            return;
        }
    }

    public void scrollTo(int i, int j)
    {
        if (_scrollView != null)
        {
            _scrollView.smoothScrollTo(i, j);
        }
    }

    public void setEmptyViewState(int i)
    {
        if (_emptyView != null && _scrollView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        _emptyView.setState(i);
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        _emptyView.setVisibility(8);
        View view = _scrollView.findViewById(0x7f0b015d);
        if (view != null)
        {
            view.setVisibility(0);
        }
        view = _scrollView.findViewById(0x7f0b01ba);
        if (view != null)
        {
            view.setVisibility(0);
        }
        view = _scrollView.findViewById(0x7f0b0122);
        if (view != null)
        {
            view.setVisibility(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (_adapter != null && _adapter.getCount() != 0 && !_forceEmpty) goto _L1; else goto _L3
_L3:
        _emptyView.setVisibility(0);
        View view1 = _scrollView.findViewById(0x7f0b015d);
        if (view1 != null)
        {
            view1.setVisibility(8);
        }
        view1 = _scrollView.findViewById(0x7f0b01ba);
        if (view1 != null)
        {
            view1.setVisibility(8);
        }
        view1 = _scrollView.findViewById(0x7f0b0122);
        if (view1 != null)
        {
            view1.setVisibility(8);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setListener(ScrollListener scrolllistener)
    {
        _scrollListener = scrolllistener;
    }

    protected boolean timeNeedsRefresh(long l)
    {
        while (l == 0L || System.currentTimeMillis() - l <= _resetDiff) 
        {
            return false;
        }
        return true;
    }

    protected void updateEmptyDisplay()
    {
        if (_adapterView != null && _emptyView != null)
        {
            String s;
            try
            {
                s = String.format(getString(getEmptyMessage()), new Object[] {
                    getEmptyDynamicText()
                });
            }
            catch (Exception exception)
            {
                exception = getString(getEmptyMessage());
            }
            _emptyView.setMessage(s);
            _emptyView.setCenterIcon(getEmptyIcon());
        }
    }

    protected void updateStates(ApiResponse apiresponse)
    {
        if (_adapterView == null || _emptyView == null)
        {
            return;
        }
        if (!Device.hasInternet())
        {
            setEmptyViewState(1);
        } else
        if (apiresponse != null)
        {
            String s = apiresponse.getMessageDisplay();
            apiresponse = s;
            if (s == null)
            {
                apiresponse = getString(0x7f0e02cb);
            }
            _emptyView.setMessage(apiresponse);
        } else
        {
            updateEmptyDisplay();
        }
        if (_adapter == null || _adapter.getCount() == 0 || _forceEmpty)
        {
            setEmptyViewState(1);
            AdapterFooterView.setState(_footerView, 2);
            return;
        } else
        {
            setEmptyViewState(2);
            AdapterFooterView.setState(_footerView, 1);
            return;
        }
    }



/*
    static boolean access$002(PinterestAdapterViewFragment pinterestadapterviewfragment, boolean flag)
    {
        pinterestadapterviewfragment._didAutoScroll = flag;
        return flag;
    }

*/


    private class _cls2
        implements com.pinterest.ui.grid.PinterestAdapterView.PinterAdapterViewListener
    {

        final PinterestAdapterViewFragment this$0;

        public void onConfigurationChanged(Configuration configuration)
        {
        }

        public void onLayout()
        {
        }

        public void onMeasure()
        {
            if (!_didAutoScroll && _toYScroll > 0.0F)
            {
                _didAutoScroll = true;
                class _cls1
                    implements Runnable
                {

                    final _cls2 this$1;

                    public void run()
                    {
                        if (_adapterView != null)
                        {
                            _adapterView.requestLayout();
                        }
                        if (_scrollView != null)
                        {
                            _scrollView.scrollTo(0, (int)(_toYScroll * (float)_adapterView.getMeasuredHeight()));
                        }
                        _toYScroll = 0.0F;
                    }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
                }

                if (_adapterView != null)
                {
                    _adapterView.post(new _cls1());
                }
            }
        }

        _cls2()
        {
            this$0 = PinterestAdapterViewFragment.this;
            super();
        }
    }


    private class _cls3 extends FeedApiResponseHandler
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

        _cls3()
        {
            this$0 = PinterestAdapterViewFragment.this;
            super();
        }
    }


    private class _cls4 extends com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener
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

        _cls4()
        {
            this$0 = PinterestAdapterViewFragment.this;
            super();
        }
    }


    private class _cls5
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
                BaseApi.e(s, ((com.pinterest.api.BaseApiResponseHandler) (obj)), getApiTag());
            }
            return;
            Exception exception;
            exception;
            exception.printStackTrace();
            return;
        }

        _cls5()
        {
            this$0 = PinterestAdapterViewFragment.this;
            super();
        }
    }


    private class ScrollListener
    {

        public abstract void onScroll(PinterestAdapterView pinterestadapterview, int i, int j);
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PinterestAdapterViewFragment this$0;

        public void onClick(View view)
        {
            refresh();
        }

        _cls1()
        {
            this$0 = PinterestAdapterViewFragment.this;
            super();
        }
    }

}
