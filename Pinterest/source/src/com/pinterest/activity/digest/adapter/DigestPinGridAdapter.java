// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DigestPinGridAdapter extends PinGridAdapter
{

    private List _headItems;

    public DigestPinGridAdapter()
    {
        _headItems = new ArrayList();
    }

    private boolean existOnTop(Pin pin)
    {
        for (Iterator iterator = _headItems.iterator(); iterator.hasNext();)
        {
            if (((DigestItem)iterator.next()).getUid().equals(pin.getUid()))
            {
                return true;
            }
        }

        return false;
    }

    public int getItemSpan(int i)
    {
        Pin pin = (Pin)getItem(i);
        for (Iterator iterator = _headItems.iterator(); iterator.hasNext();)
        {
            DigestItem digestitem = (DigestItem)iterator.next();
            if (digestitem.getUid().equals(pin.getUid()) && digestitem.getLargePin().booleanValue())
            {
                return 2;
            }
        }

        return 1;
    }

    public boolean isLargePin(int i)
    {
        return getItemSpan(i) > 1;
    }

    public Feed resetDataFeed(Feed feed)
    {
        Object obj = feed.getItems();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = _headItems.iterator(); iterator.hasNext(); arraylist.add(ModelHelper.getPin(((DigestItem)iterator.next()).getUid()))) { }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Pin pin = (Pin)((Iterator) (obj)).next();
            if (!existOnTop(pin))
            {
                arraylist.add(pin);
            }
        } while (true);
        feed.setItems(arraylist);
        return feed;
    }

    public void setDataSource(Feed feed)
    {
        if (_dataSource != null)
        {
            if (_dataSource instanceof PinFeed)
            {
                ((PinFeed)_dataSource).unregisterForUpdateEvents();
            }
            _dataSource.setDataListener(null);
        }
        _dataSource = resetDataFeed(feed);
        notifyDataSetChanged();
        if (_dataSource != null)
        {
            if (_dataSource instanceof PinFeed)
            {
                ((PinFeed)_dataSource).registerForUpdateEvents();
            }
            _dataSource.setDataListener(_dataListener);
        }
    }

    public void setHeadItems(List list)
    {
        _headItems = list;
    }
}
