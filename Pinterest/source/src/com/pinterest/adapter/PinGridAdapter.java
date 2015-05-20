// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinFeed;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.grid.PinGridCell;
import com.pinterest.ui.grid.PinGridCellHidden;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.adapter:
//            PinterestBaseAdapter

public class PinGridAdapter extends PinterestBaseAdapter
{

    private boolean _cropPinImage;
    private boolean _disableClicks;
    private boolean _forceShowInterest;
    private ArrayList _impressions;
    private boolean _isRelatedContent;
    private boolean _overrideClicks;
    private boolean _renderCompactUser;
    private boolean _renderDomain;
    private boolean _renderOnto;
    private boolean _renderSource;
    private boolean _renderThrough;
    private boolean _renderUser;

    public PinGridAdapter()
    {
        _impressions = new ArrayList();
        _renderCompactUser = false;
        _renderUser = true;
        _renderSource = true;
        _renderOnto = true;
        _renderThrough = false;
        _renderDomain = false;
        _overrideClicks = false;
        _cropPinImage = true;
        _forceShowInterest = false;
    }

    public List dumpPinImpressions()
    {
        ArrayList arraylist = new ArrayList(_impressions);
        _impressions.clear();
        return arraylist;
    }

    public View getView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        Pin pin = (Pin)getItem(i);
        if (pin != null && ModelHelper.isValid(pin.getHiddenState()) && pin.getHiddenState().intValue() > 0)
        {
            if (view == null || !(view instanceof PinGridCellHidden))
            {
                view = new PinGridCellHidden(ViewHelper.getContext(view, viewgroup));
                view.setBackgroundColor(Resources.color(0x7f090012));
            } else
            {
                view = (PinGridCellHidden)view;
            }
            view.setPin(pin, flag);
            return view;
        }
        boolean flag1;
        if (view == null || !(view instanceof PinGridCell))
        {
            viewgroup = new PinGridCell(ViewHelper.getContext(view, viewgroup));
        } else
        {
            viewgroup = (PinGridCell)view;
        }
        if (!flag)
        {
            loadMore(i);
            if (view != null)
            {
                view = viewgroup.markImpressionEnd();
                if (view != null)
                {
                    _impressions.add(view);
                }
            }
            viewgroup.markImpressionStart();
        }
        viewgroup.setRenderLargePin(isLargePin(i));
        if (!_disableClicks)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        viewgroup.setEnabled(flag1);
        viewgroup.setRenderCompactUser(_renderCompactUser);
        viewgroup.setRenderUser(_renderUser);
        viewgroup.setRenderSource(_renderSource);
        viewgroup.setRenderOnto(_renderOnto);
        viewgroup.setRenderThrough(_renderThrough);
        viewgroup.setRenderDomain(_renderDomain);
        viewgroup.setOverrideClicks(_overrideClicks);
        viewgroup.setCropPinImage(_cropPinImage);
        viewgroup.setIsRelatedPin(_isRelatedContent);
        viewgroup.setPinPosition(i);
        if (pin != null && pin.getRecommendationReason() != null && pin.getRecommendationReason().equals("FOLLOWED_INTEREST") || _forceShowInterest)
        {
            viewgroup.setRenderInterest(true);
        } else
        {
            viewgroup.setRenderInterest(false);
        }
        if (_forceShowInterest)
        {
            viewgroup.setPopularInTitle(Resources.string(0x7f0e003a));
        } else
        {
            viewgroup.setPopularInTitle(null);
        }
        if (pin != null && pin.getRecommendationReason() != null)
        {
            if (ModelHelper.isValid(pin.getRecommendationBoardUid()))
            {
                viewgroup.setRenderThrough(true);
                viewgroup.setRenderCompactUser(false);
            }
            if (pin.getRecommendationReason().equals("RECOMMENDED_INTEREST") || pin.getRecommendationReason().equals("REALTIME_P2B"))
            {
                viewgroup.setRenderCompactUser(false);
            }
        }
        viewgroup.setPin(pin, flag);
        return viewgroup;
    }

    public boolean isLargePin(int i)
    {
        return false;
    }

    public void onStart()
    {
        if (_dataSource != null)
        {
            if (_dataSource instanceof PinFeed)
            {
                ((PinFeed)_dataSource).registerForUpdateEvents();
            }
            _dataSource.setDataListener(_dataListener);
        }
    }

    public void onStop()
    {
        if (_dataSource != null)
        {
            if (_dataSource instanceof PinFeed)
            {
                ((PinFeed)_dataSource).unregisterForUpdateEvents();
            }
            _dataSource.setDataListener(null);
        }
        super.onStop();
    }

    public boolean restoreInstanceState(Bundle bundle)
    {
        boolean flag = super.restoreInstanceState(bundle);
        if (flag && !(_dataSource instanceof PinFeed))
        {
            _dataSource = null;
            CrashReporting.leaveBreadcrumb("PinGridAdapter.restoreInstanceState: not a PinFeed");
            CrashReporting.logHandledException(new RuntimeException("PinGridAdapter.restoreInstanceState: not a PinFeed"));
        }
        return flag;
    }

    public void setCropPinImage(boolean flag)
    {
        _cropPinImage = flag;
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
        super.setDataSource(feed);
        if (_dataSource != null)
        {
            if (_dataSource instanceof PinFeed)
            {
                ((PinFeed)_dataSource).registerForUpdateEvents();
            }
            _dataSource.setDataListener(_dataListener);
        }
    }

    public void setDisableClicks(boolean flag)
    {
        _disableClicks = flag;
    }

    public void setForceShowInterest(boolean flag)
    {
        _forceShowInterest = flag;
    }

    public void setIsRelatedContent(boolean flag)
    {
        _isRelatedContent = flag;
    }

    public void setOverrideClicks(boolean flag)
    {
        _overrideClicks = flag;
    }

    public void setRelatedContent(boolean flag)
    {
        _isRelatedContent = flag;
    }

    public void setRenderCompactUser(boolean flag)
    {
        _renderCompactUser = flag;
    }

    public void setRenderCompactUserOnly(boolean flag)
    {
        if (flag)
        {
            _renderCompactUser = true;
            _renderUser = false;
            _renderSource = false;
            _renderOnto = false;
            _renderThrough = false;
            _renderDomain = false;
            return;
        } else
        {
            _renderUser = true;
            _renderSource = true;
            _renderOnto = true;
            return;
        }
    }

    public void setRenderDomain(boolean flag)
    {
        _renderDomain = flag;
    }

    public void setRenderOnto(boolean flag)
    {
        _renderOnto = flag;
    }

    public void setRenderSource(boolean flag)
    {
        _renderSource = flag;
    }

    public void setRenderUser(boolean flag)
    {
        _renderUser = flag;
    }
}
