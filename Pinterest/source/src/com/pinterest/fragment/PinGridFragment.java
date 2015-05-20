// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Handler;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.schemas.event.EventType;
import com.pinterest.ui.grid.PinGridCell;
import com.pinterest.ui.grid.PinterestAdapterView;
import com.pinterest.ui.grid.PinterestGridView;
import java.util.List;

// Referenced classes of package com.pinterest.fragment:
//            PinterestGridFragment

public class PinGridFragment extends PinterestGridFragment
{

    private static final int IMPRESSION_DUMP_TIMEOUT = 30000;
    private Handler _handler;
    private Runnable dumpImpressionInterval;

    public PinGridFragment()
    {
        dumpImpressionInterval = new _cls1();
        _adapter = new PinGridAdapter();
        _handler = new Handler();
    }

    private List gatherAllImpressions()
    {
        int i = 0;
        List list = ((PinGridAdapter)_adapter).dumpPinImpressions();
        list.size();
        if (_gridVw != null)
        {
            for (PinterestAdapterView pinterestadapterview = _gridVw.getAdapterView(); i < pinterestadapterview.getChildCount(); i++)
            {
                Object obj = pinterestadapterview.getChildAt(i);
                if (!(obj instanceof PinGridCell))
                {
                    continue;
                }
                obj = ((PinGridCell)obj).markImpressionEnd();
                if (obj != null)
                {
                    list.add(obj);
                }
            }

        }
        return list;
    }

    private void reportImpressions()
    {
        List list = gatherAllImpressions();
        Pinalytics.a(EventType.PIN_IMPRESSION_ONE_PIXEL, list);
        list.size();
    }

    protected void onActivate()
    {
        super.onActivate();
    }

    protected void onDeactivate()
    {
        super.onDeactivate();
    }

    public void setActive(boolean flag)
    {
        boolean flag1;
        if (_active != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            _handler.removeCallbacksAndMessages(null);
            if (_active)
            {
                reportImpressions();
            } else
            {
                _handler.postDelayed(dumpImpressionInterval, 30000L);
            }
        }
        super.setActive(flag);
    }

    protected void setCompactCells(boolean flag)
    {
        ((PinGridAdapter)_adapter).setRenderCompactUserOnly(flag);
    }



    private class _cls1
        implements Runnable
    {

        final PinGridFragment this$0;

        public void run()
        {
            reportImpressions();
            if (isAdded() && isActive() && _handler != null)
            {
                _handler.postDelayed(this, 30000L);
            }
        }

        _cls1()
        {
            this$0 = PinGridFragment.this;
            super();
        }
    }

}
