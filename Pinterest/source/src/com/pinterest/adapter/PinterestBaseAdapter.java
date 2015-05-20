// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.Model;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Device;
import com.pinterest.ui.ViewHelper;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.pinterest.adapter:
//            LoadMoreListener

public abstract class PinterestBaseAdapter extends BaseAdapter
{

    private static final int LOAD_MORE_INDEX;
    public static final int PADDING_NONE = 0;
    public static final int PADDING_REGULAR = 1;
    protected String _apiTag;
    protected HashMap _cachedItemHeights;
    protected com.pinterest.api.model.Feed.DataListener _dataListener;
    protected Feed _dataSource;
    protected LoadMoreListener _listener;
    protected boolean _loading;
    protected View _measureView;

    public PinterestBaseAdapter()
    {
        _cachedItemHeights = new HashMap();
    }

    private boolean shouldLoadMore(int i)
    {
        int j;
        if (!_loading)
        {
            if ((j = getCount()) > LOAD_MORE_INDEX && i >= j - LOAD_MORE_INDEX)
            {
                return true;
            }
        }
        return false;
    }

    public int getCount()
    {
        if (_dataSource == null)
        {
            return 0;
        } else
        {
            return _dataSource.getCount();
        }
    }

    public Feed getDataSource()
    {
        return _dataSource;
    }

    protected LayoutInflater getInflater(View view, View view1)
    {
        return LayoutInflater.from(ViewHelper.getContext(view, view1));
    }

    public Model getItem(int i)
    {
        if (_dataSource != null && i < _dataSource.getCount())
        {
            return _dataSource.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public int getItemHeight(int i, int j)
    {
        return getItemHeight(i, j, true);
    }

    public int getItemHeight(int i, int j, boolean flag)
    {
        if (_cachedItemHeights.get(Integer.valueOf(i)) == null || !flag)
        {
            int k = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            int l = android.view.View.MeasureSpec.makeMeasureSpec(-2, 0);
            _measureView = getView(i, _measureView, null, true);
            _measureView.setLayoutParams(new com.pinterest.ui.grid.PinterestAdapterView.LayoutParams(j, -2));
            _measureView.measure(k, l);
            _cachedItemHeights.put(Integer.valueOf(i), Integer.valueOf(_measureView.getMeasuredHeight()));
        }
        return ((Integer)_cachedItemHeights.get(Integer.valueOf(i))).intValue();
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemPaddingMode(int i)
    {
        return 1;
    }

    public int getItemSpan(int i)
    {
        return 1;
    }

    public LoadMoreListener getListener()
    {
        return _listener;
    }

    public View getSectionBackground(int i, ViewGroup viewgroup)
    {
        return null;
    }

    public int getSectionCount()
    {
        return getSectionIndicies().size();
    }

    public List getSectionIndicies()
    {
        return Collections.emptyList();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return getView(i, view, viewgroup, false);
    }

    public View getView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        return view;
    }

    public boolean isLoading()
    {
        return _loading;
    }

    public boolean isSectionHeader(int i)
    {
        return false;
    }

    protected void loadMore(int i)
    {
        if (_listener != null && shouldLoadMore(i))
        {
            _listener.loadMore();
            setLoading(true);
        }
    }

    public void onStart()
    {
        if (_dataSource != null && _dataSource.getAbsCount() > 0)
        {
            _dataSource.onStart();
        }
    }

    public void onStop()
    {
        if (_dataSource != null && _dataSource.getAbsCount() > 0)
        {
            _dataSource.onStop();
        }
    }

    public void resetCachedItemHeights()
    {
        _cachedItemHeights.clear();
    }

    public boolean restoreInstanceState(Bundle bundle)
    {
        if (bundle != null && (_dataSource == null || _dataSource.getAbsCount() <= 0))
        {
            if (ModelHelper.isValid(bundle = Feed.restoreInstanceState(bundle)))
            {
                CrashReporting.leaveBreadcrumb("PinterestBaseAdapter.restoreInstanceState: restored");
                setDataSource(bundle);
                return true;
            }
        }
        return false;
    }

    public Bundle saveInstanceState(Bundle bundle)
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        if (_dataSource != null && _dataSource.getAbsCount() > 0)
        {
            _dataSource.saveInstanceState(bundle1);
        }
        return bundle1;
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void setDataListener(final com.pinterest.api.model.Feed.DataListener dataListener)
    {
        if (dataListener == null)
        {
            _dataListener = null;
            return;
        } else
        {
            _dataListener = new _cls1();
            return;
        }
    }

    public void setDataSource(Feed feed)
    {
        _dataSource = feed;
        notifyDataSetChanged();
    }

    public void setListener(LoadMoreListener loadmorelistener)
    {
        _listener = loadmorelistener;
    }

    public void setLoading(boolean flag)
    {
        _loading = flag;
    }

    static 
    {
        int i;
        if (Device.isTablet())
        {
            i = 12;
        } else
        {
            i = 6;
        }
        LOAD_MORE_INDEX = i;
    }

    private class _cls1 extends com.pinterest.api.model.Feed.DataListener
    {

        final PinterestBaseAdapter this$0;
        final com.pinterest.api.model.Feed.DataListener val$dataListener;

        public void onChange(int i, boolean flag)
        {
            _cachedItemHeights.put(Integer.valueOf(i), null);
            dataListener.onChange(i, flag);
            notifyDataSetChanged();
        }

        public void onStart(boolean flag)
        {
            dataListener.onStart(flag);
        }

        public void onStop()
        {
            dataListener.onStop();
        }

        _cls1()
        {
            this$0 = PinterestBaseAdapter.this;
            dataListener = datalistener;
            super();
        }
    }

}
