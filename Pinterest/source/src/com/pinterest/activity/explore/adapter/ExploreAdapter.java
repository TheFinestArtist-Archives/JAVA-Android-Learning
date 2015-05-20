// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.pinterest.activity.explore.view.ExploreListCell;
import com.pinterest.api.model.Category;
import com.pinterest.api.model.Feed;
import com.pinterest.base.Device;
import com.pinterest.kit.utils.CollectionUtils;
import com.pinterest.ui.listview.SolidTitleDivider;
import java.util.List;

public class ExploreAdapter extends BaseAdapter
{

    public static final int TYPE_CATEGORY = 0;
    public static final int TYPE_COUNT = 3;
    public static final int TYPE_DIVIDER_ALL = 1;
    public static final int TYPE_DIVIDER_RECENT = 2;
    protected Feed _dataSource;
    protected boolean _loading;
    private List _recentCategories;

    public ExploreAdapter()
    {
    }

    private int getBaseAdapterOffset()
    {
        if (CollectionUtils.isEmpty(_recentCategories))
        {
            return 1;
        } else
        {
            return _recentCategories.size() + 2;
        }
    }

    protected static String getCategoryImageUrl(Category category)
    {
        float f = Device.getDensity();
        if (f <= 1.0F)
        {
            return category.getImageSmallUrl();
        }
        if (f >= 2.0F)
        {
            return category.getImageLargeUrl();
        } else
        {
            return category.getImageMediumUrl();
        }
    }

    public final void finishedLoading()
    {
        _loading = false;
    }

    public int getCount()
    {
        int i;
        int j;
        if (_dataSource == null)
        {
            i = 0;
        } else
        {
            i = _dataSource.getCount();
        }
        j = i;
        if (i > 0)
        {
            j = i;
            if (CollectionUtils.isNotEmpty(_recentCategories))
            {
                j = i + 1 + _recentCategories.size();
            }
            j++;
        }
        return j;
    }

    public Category getItem(int i)
    {
        if (getItemViewType(i) != 0)
        {
            return null;
        }
        if (isRecentCell(i))
        {
            return (Category)_recentCategories.get(i - 1);
        } else
        {
            return (Category)_dataSource.getItems().get(i - getBaseAdapterOffset());
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (isAllDivider(i))
        {
            return 1;
        }
        return !isRecentDivider(i) ? 0 : 2;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getItemViewType(i);
        j;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 66
    //                   1 38
    //                   2 38;
           goto _L1 _L2 _L3 _L3
_L1:
        return view;
_L3:
        view = SolidTitleDivider.from(view, viewgroup);
        if (j == 1)
        {
            i = 0x7f0e002f;
        } else
        {
            i = 0x7f0e03ce;
        }
        view.setText(i);
        return view;
_L2:
        Category category = getItem(i);
        viewgroup = ExploreListCell.from(view, viewgroup);
        view = viewgroup;
        if (category != null)
        {
            viewgroup.setText(category.getName());
            viewgroup.setTitleOnly(true);
            return viewgroup;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public boolean isAllDivider(int i)
    {
        boolean flag = CollectionUtils.isEmpty(_recentCategories);
        return flag && i == 0 || !flag && i == _recentCategories.size() + 1;
    }

    public boolean isRecentCell(int i)
    {
        return CollectionUtils.isNotEmpty(_recentCategories) && i <= _recentCategories.size();
    }

    public boolean isRecentDivider(int i)
    {
        return i == 0 && CollectionUtils.isNotEmpty(_recentCategories);
    }

    public void setDataSource(Feed feed)
    {
        _loading = false;
        _dataSource = feed;
        notifyDataSetChanged();
    }

    public void setRecentCategories(List list)
    {
        _recentCategories = list;
        notifyDataSetChanged();
    }
}
