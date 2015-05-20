// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import butterknife.ButterKnife;
import com.pinterest.activity.task.fragment.AdapterViewFragment;
import com.pinterest.adapter.LoadMoreListener;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.adapter.Refreshable;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.actions.ScrollableListener;
import com.pinterest.ui.grid.PinterestGridView;

public class PinterestGridFragment extends AdapterViewFragment
    implements Refreshable
{

    private static final int ACTIONBAR_HEIGHT = (int)Resources.dimension(0x7f0a0025);
    private static final int METADATABAR_HEIGHT = (int)Resources.dimension(0x7f0a009f);
    protected PinterestBaseAdapter _adapter;
    protected PinterestGridView _gridVw;
    protected float _movingSpeed;
    protected int _swipeOffsetEnd;
    protected int _swipeOffsetStart;
    protected SwipeRefreshLayout _swipeVw;
    protected LoadMoreListener adapterListener;
    protected FeedApiResponseHandler gridResponseHandler;

    public PinterestGridFragment()
    {
        _movingSpeed = 1.0F;
        _swipeOffsetStart = 0;
        _swipeOffsetEnd = Constants.SWIPE_OFFSET_LENGTH;
        gridResponseHandler = new _cls3();
        adapterListener = new _cls4();
        _layoutId = 0x7f0300a3;
    }

    public Pair getScrollPosition()
    {
        if (_gridVw != null)
        {
            return new Pair(Integer.valueOf(_gridVw.getScrolledX()), Integer.valueOf(_gridVw.getScrolledY()));
        } else
        {
            return super.getScrollPosition();
        }
    }

    public boolean isDataNonEmpty()
    {
        return _adapter != null && !_adapter.isEmpty();
    }

    protected void onActivate()
    {
        super.onActivate();
        if (_gridVw != null)
        {
            _gridVw.forceMakeCurrent();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        _adapter.setListener(adapterListener);
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        ButterKnife.a(this, layoutinflater);
        _gridVw.setAdapter(_adapter);
        if (_scrollListener != null)
        {
            _gridVw.addListener(_scrollListener);
        }
        if (_adapter.restoreInstanceState(bundle))
        {
            _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADED);
        }
        _gridVw.addListener(new _cls1());
        if (_swipeVw != null)
        {
            _swipeVw.setColorSchemeResources(new int[] {
                0x7f090061
            });
            _swipeVw.setOnRefreshListener(new _cls2());
        }
        return layoutinflater;
    }

    protected void onDataSourceChanged(boolean flag)
    {
    }

    public void onDestroyView()
    {
        if (_adapter != null)
        {
            _adapter.setListener(null);
        }
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(_adapter.saveInstanceState(bundle));
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (_swipeVw != null)
        {
            _swipeVw.setProgressViewOffset(false, _swipeOffsetStart, _swipeOffsetEnd);
        }
        if (_adapter.getCount() == 0)
        {
            loadData();
        }
    }

    public void reset()
    {
        Feed feed;
        if (_adapter == null)
        {
            feed = null;
        } else
        {
            feed = _adapter.getDataSource();
        }
        reset(feed);
    }

    public void reset(Feed feed)
    {
        if (_adapter != null && feed != null)
        {
            _adapter.resetCachedItemHeights();
            _adapter.setDataSource(feed);
            if (_gridVw != null)
            {
                _gridVw.requestLayout();
                _gridVw.reset();
            }
        }
    }

    public void scrollTo(int i, int j)
    {
        scrollTo(i, j, false);
    }

    public void scrollTo(int i, int j, boolean flag)
    {
        if (_gridVw == null)
        {
            return;
        }
        if (flag)
        {
            _gridVw.scrollTo(i, j);
            return;
        } else
        {
            _gridVw.smoothScrollTo(i, j);
            return;
        }
    }

    public void setMovingSpeed(float f)
    {
        _movingSpeed = f;
    }

    public void setScrollListener(ScrollableListener scrollablelistener)
    {
        super.setScrollListener(scrollablelistener);
        if (_gridVw != null)
        {
            _gridVw.addListener(scrollablelistener);
        }
    }





/*
    static boolean access$1002(PinterestGridFragment pinterestgridfragment, boolean flag)
    {
        pinterestgridfragment._refreshing = flag;
        return flag;
    }

*/










/*
    static boolean access$802(PinterestGridFragment pinterestgridfragment, boolean flag)
    {
        pinterestgridfragment._refreshing = flag;
        return flag;
    }

*/


    private class _cls3 extends FeedApiResponseHandler
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
                    _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.ERROR);
                    return;
                }
                if (apiresponse != null)
                {
                    throwable = apiresponse.getMessageDetailIfExist();
                }
                _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.ERROR);
                _gridVw.setEmptyMessage(throwable);
            }
            false._swipeVw = throwable;
            if (_adapter != null)
            {
                _adapter.setLoading(false);
            }
            setEmptyContent(_adapter);
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
                _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADING);
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
                if (_swipeVw)
                {
                    _gridVw.setDataSource(feed);
                    onDataSourceChanged(false);
                } else
                {
                    _gridVw.appendDataSource(feed);
                    onDataSourceChanged(false);
                }
                _gridVw.setState(com.pinterest.ui.grid.PinterestGridView.State.LOADED);
            }
            false._swipeVw = feed;
            if (_adapter != null)
            {
                _adapter.setLoading(false);
            }
            setEmptyContent(_adapter);
        }

        _cls3()
        {
            this$0 = PinterestGridFragment.this;
            super();
        }
    }


    private class _cls4
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
                    BaseApi.e(s, feedapiresponsehandler, getApiTag());
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

        _cls4()
        {
            this$0 = PinterestGridFragment.this;
            super();
        }
    }



}
