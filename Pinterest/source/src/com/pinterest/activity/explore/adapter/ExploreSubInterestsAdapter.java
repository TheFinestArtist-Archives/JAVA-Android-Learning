// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.explore.view.LargeInterestGridCell;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.Interest;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.text.PTextView;
import java.util.ArrayList;

public class ExploreSubInterestsAdapter extends PinterestBaseAdapter
{

    private boolean _isLarge;
    protected boolean _loading;
    protected Interest _parentInterest;

    public ExploreSubInterestsAdapter()
    {
    }

    private String getNameForAllTile(Interest interest)
    {
        interest = interest.getName();
        if (interest == null)
        {
            return null;
        }
        int i = 0;
        int j;
        int k;
        for (j = 0; i < interest.length(); j = k)
        {
            k = j;
            if (Character.isUpperCase(interest.charAt(i)))
            {
                k = j + 1;
            }
            i++;
        }

        if (j == 1)
        {
            interest = interest.toLowerCase();
        }
        return Resources.string(0x7f0e0032, new Object[] {
            interest
        });
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = (int)Resources.dimension(0x7f0a0098);
        int i1 = (int)Resources.dimension(0x7f0a009b);
        Interest interest = (Interest)getItem(i);
        viewgroup = LargeInterestGridCell.from(view, viewgroup.getContext());
        int l;
        if (_isLarge)
        {
            int k = (int)Resources.dimension(0x7f0a0089);
            int j1 = (int)Resources.dimension(0x7f0a0087);
            view = new android.widget.FrameLayout.LayoutParams(k, j1);
            viewgroup.setImageDimensions(k, j1);
            viewgroup.setTitleTextSize((int)Resources.dimension(0x7f0a00fb));
            k = (int)Resources.dimension(0x7f0a00f6) - (int)Resources.dimension(0x7f0a009a);
            j1 = (int)Resources.dimension(0x7f0a00f6);
            viewgroup.getTitleTV().setPadding(k, 0, k, j1);
        } else
        {
            view = new android.widget.FrameLayout.LayoutParams((int)Resources.dimension(0x7f0a0088), (int)Resources.dimension(0x7f0a0086));
        }
        if (i == 0)
        {
            l = j;
        } else
        {
            l = 0;
        }
        if (i != getCount() - 1)
        {
            j = i1;
        }
        view.setMargins(l, 0, j, 0);
        viewgroup.setWrapperLayoutParams(view);
        viewgroup.setImageBackgroundResource(null);
        if (_parentInterest != null && interest.getName().equals(_parentInterest.getName()))
        {
            viewgroup.setHideImage(true);
            viewgroup.setInterest(interest, null, false);
            viewgroup.setTitleText(getNameForAllTile(_parentInterest));
        } else
        {
            viewgroup.setHideImage(false);
            viewgroup.setInterest(interest, null, false);
        }
        if ("3".equals(interest.getUid()))
        {
            viewgroup.setImageBackgroundResource(Integer.valueOf(0x7f0201c0));
        }
        return viewgroup;
    }

    public void setDataSource(ArrayList arraylist)
    {
        setDataSource(arraylist, null);
    }

    public void setDataSource(ArrayList arraylist, Interest interest)
    {
        _loading = false;
        if (_dataSource == null)
        {
            _dataSource = new _cls1();
        }
        _dataSource.setItems(arraylist);
        _parentInterest = interest;
        notifyDataSetChanged();
    }

    public void setLarge(boolean flag)
    {
        _isLarge = flag;
    }

    private class _cls1 extends Feed
    {

        final ExploreSubInterestsAdapter this$0;

        protected List getPersistedItems()
        {
            return null;
        }

        _cls1()
        {
            this$0 = ExploreSubInterestsAdapter.this;
            super();
        }
    }

}
