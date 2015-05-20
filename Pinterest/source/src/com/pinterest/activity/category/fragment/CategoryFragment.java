// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.category.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.activity.interest.view.RelatedInterestsView;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.model.Category;
import com.pinterest.api.model.Model;
import com.pinterest.api.remote.CategoryApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.experiment.Experiments;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.grid.PinterestGridView;

public class CategoryFragment extends PinGridFragment
{

    protected boolean _addRelatedInterests;
    private Category _category;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    protected RelatedInterestsView _relatedView;

    public CategoryFragment()
    {
        _addRelatedInterests = true;
        _eventsSubscriber = new _cls2();
        _layoutId = 0x7f030072;
        ((PinGridAdapter)_adapter).setRenderCompactUser(true);
        ((PinGridAdapter)_adapter).setRenderUser(false);
        ((PinGridAdapter)_adapter).setRenderOnto(false);
        ((PinGridAdapter)_adapter).setRenderSource(false);
        _swipeOffsetEnd = Constants.SWIPE_OFFSET_LENGTH + (int)Resources.dimension(0x7f0a008a);
    }

    protected void addRelatedInterestsHeader(View view)
    {
        initializeRelatedInterestsView(view);
        int i;
        if (Experiments.e())
        {
            i = (int)Resources.dimension(0x7f0a0086) + (int)Resources.dimension(0x7f0a0099);
        } else
        {
            i = (int)Resources.dimension(0x7f0a008a);
        }
        _gridVw.addHeaderView(_relatedView, -1, i);
    }

    protected String getContentId()
    {
        if (_category != null)
        {
            return _category.getKey();
        } else
        {
            return null;
        }
    }

    protected Model getContentModel()
    {
        return _category;
    }

    protected String getContentTitle()
    {
        if (_category != null)
        {
            return _category.getName();
        } else
        {
            return null;
        }
    }

    protected String getStopwatchKey()
    {
        return "category_ttrfp";
    }

    protected void initializeRelatedInterestsView(View view)
    {
        _relatedView = new RelatedInterestsView(view.getContext());
        _relatedView.setApiTag(getApiTag());
        _relatedView.setOverScrollMode(2);
        _relatedView.setContentId(getContentId());
        int i = (int)Resources.dimension(0x7f0a0098);
        _relatedView.setPadding(0, i, 0, i);
        _relatedView.setBackgroundColor(-1);
        _relatedView.setVisibility(8);
    }

    protected void loadData()
    {
        CategoryApi.a(_navigation.getId(), new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler), getApiTag());
    }

    public void onDestroyView()
    {
        _relatedView = null;
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onPause()
    {
        StopWatch.get().invalidate(getStopwatchKey());
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
        });
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (StopWatch.get().isActive(getStopwatchKey()))
        {
            Events.register(_eventsSubscriber, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, new Class[0]);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _actionBar.setTitle(getContentTitle());
        _actionBarWrapper.setShadowVisibility(8);
        _gridVw.addListener(new _cls1());
        bundle = new View(view.getContext());
        bundle.setBackgroundColor(Resources.color(0x7f090047));
        _gridVw.addHeaderView(bundle, -1, (int)Resources.dimension(0x7f0a008c));
        if (_addRelatedInterests)
        {
            addRelatedInterestsHeader(view);
        }
        if (this instanceof CategoryFragment)
        {
            _gridVw.addHeaderView(0x7f03013f);
        }
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _category = navigation.getModelAsCategory();
    }

    protected void stopStopwatch()
    {
        StopWatch.get().complete(getStopwatchKey());
    }




    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final CategoryFragment this$0;

        public void onEventMainThread(com.pinterest.ui.grid.PinGridCell.ImageLoadEvent imageloadevent)
        {
            stopStopwatch();
            Events.unregister(_eventsSubscriber, new Class[] {
                com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
            });
        }

        _cls2()
        {
            this$0 = CategoryFragment.this;
            super();
        }
    }


}
