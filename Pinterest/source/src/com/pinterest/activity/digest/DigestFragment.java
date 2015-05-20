// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.activity.digest.adapter.DigestGridAdapter;
import com.pinterest.activity.digest.ui.DigestHeaderView;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.DigestApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;
import com.pinterest.fragment.PinterestGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.schemas.event.EventType;
import com.pinterest.ui.grid.PinGridCell;
import com.pinterest.ui.grid.PinterestAdapterView;
import com.pinterest.ui.grid.PinterestGridView;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;
import com.pinterest.ui.megaphone.HomeNagEvent;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class DigestFragment extends PinterestGridFragment
{

    private static final int IMPRESSION_DUMP_TIMEOUT = 30000;
    private static int STORY_HEADER_HEIGHT = (int)Resources.dimension(0x7f0a00ee);
    private com.pinterest.api.remote.DigestApi.DigestStoryFeedApiResponseHandler _digestFeedHandler;
    private Runnable _eduRunnable;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    Runnable _finishFeedRunnable;
    private String _firstItemId;
    private boolean _firstLoad;
    private Handler _handler;
    private List _headerItemIds;
    private Map _headerMap;
    DigestHeaderView _headerView;
    private int _lastCheckPos;
    private com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener _scrollViewListener;
    private Runnable dumpImpressionInterval;

    public DigestFragment()
    {
        _headerMap = new HashMap();
        _headerItemIds = new ArrayList();
        _lastCheckPos = 0;
        _firstLoad = true;
        _firstItemId = null;
        dumpImpressionInterval = new _cls2();
        _scrollViewListener = new _cls4();
        _digestFeedHandler = new _cls5(gridResponseHandler);
        _eventsSubscriber = new _cls6();
        _finishFeedRunnable = new _cls7();
        _layoutId = 0x7f03007c;
        _adapter = new DigestGridAdapter();
        _handler = new Handler(Looper.getMainLooper());
    }

    private void checkHeaderPosition()
    {
        PinterestAdapterView pinterestadapterview = _gridVw.getAdapterView();
        if (_lastCheckPos != pinterestadapterview.getChildCount())
        {
            for (int i = 0; i < pinterestadapterview.getChildCount(); i++)
            {
                Object obj = pinterestadapterview.getChildAt(i);
                if (!(obj instanceof DigestHeaderView))
                {
                    continue;
                }
                DigestHeaderView digestheaderview = (DigestHeaderView)obj;
                obj = (DigestHeader)_headerMap.get(((DigestHeaderView)obj).getItem().getUid());
                if (obj != null)
                {
                    obj.height = Integer.valueOf((int)digestheaderview.getY());
                }
            }

            _lastCheckPos = pinterestadapterview.getChildCount();
        }
    }

    private List gatherAllImpressions()
    {
        int i = 0;
        List list = ((DigestGridAdapter)_adapter).dumpPinImpressions();
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

    private String getNextHeaderItemId(String s)
    {
        if (StringUtils.isEmpty(s))
        {
            if (_headerItemIds.size() > 0)
            {
                return (String)_headerItemIds.get(0);
            } else
            {
                return null;
            }
        }
        for (int i = 0; i < _headerItemIds.size() - 1; i++)
        {
            if (((String)_headerItemIds.get(i)).equals(s))
            {
                return (String)_headerItemIds.get(i + 1);
            }
        }

        return null;
    }

    private String getPrevHeaderItemId(String s)
    {
        if (StringUtils.isEmpty(s))
        {
            return null;
        }
        for (int i = 1; i <= _headerItemIds.size() - 1; i++)
        {
            if (((String)_headerItemIds.get(i)).equals(s))
            {
                return (String)_headerItemIds.get(i - 1);
            }
        }

        return null;
    }

    private void initDigestHeaderView(DigestItem digestitem)
    {
        _headerView.setVisibility(0);
        _headerView.setDigestPin(digestitem);
    }

    private void loadDigestHeaderData()
    {
        Object obj = ((DigestGridAdapter)_adapter).getDataSource().getItems();
        _headerMap.clear();
        _headerItemIds.clear();
        obj = ((List) (obj)).iterator();
        int j = 0;
        int i = 0;
        while (((Iterator) (obj)).hasNext()) 
        {
            DigestItem digestitem = (DigestItem)((Iterator) (obj)).next();
            int l;
            if (digestitem.getEnumType().intValue() == 0)
            {
                int k = i;
                if (j == 0)
                {
                    k = i;
                    if (!digestitem.getUid().equals(_firstItemId))
                    {
                        k = 1;
                        _firstItemId = digestitem.getUid();
                    }
                }
                _headerMap.put(digestitem.getUid(), new DigestHeader(digestitem, Integer.valueOf(0)));
                _headerItemIds.add(digestitem.getUid());
                i = j + 1;
                j = k;
            } else
            {
                int i1 = i;
                i = j;
                j = i1;
            }
            l = j;
            j = i;
            i = l;
        }
        if (i != 0 && _headerView.getVisibility() != 8)
        {
            initDigestHeaderView(((DigestHeader)_headerMap.get(_firstItemId)).item);
            _headerView.setTranslationY(Constants.ACTIONBAR_HEIGHT);
        }
    }

    private void loadNetworkData()
    {
        DigestApi.a(new com.pinterest.api.remote.DigestApi.DigestStoryFeedApiResponseHandler(gridResponseHandler), getApiTag());
    }

    private void pollDigestFeedReady()
    {
        if (isActive())
        {
            _handler.postDelayed(_finishFeedRunnable, 1500L);
        }
    }

    private void reportImpressions()
    {
        List list = gatherAllImpressions();
        Pinalytics.a(EventType.PIN_IMPRESSION_ONE_PIXEL, list);
        list.size();
    }

    protected void loadData()
    {
        super.loadData();
        if (!_firstLoad)
        {
            loadNetworkData();
            return;
        }
        final PinterestJsonObject cachedFeedData = DiskCache.getJsonObject("MY_DIGEST_FEED");
        if (cachedFeedData == null)
        {
            loadNetworkData();
            return;
        } else
        {
            (new _cls3()).execute();
            return;
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (_gridVw != null && (float)_gridVw.getScrollY() <= Resources.dimension(0x7f0a0034) && _adapter != null && ((DigestGridAdapter)_adapter).getCount() > 0 && !_refreshing && !((DigestGridAdapter)_adapter).isLoading())
        {
            refresh();
        }
    }

    protected void onDeactivate()
    {
        EducationHelper.a(_eduRunnable);
        super.onDeactivate();
    }

    public void onDestroyView()
    {
        _nagView = null;
        ButterKnife.a(this);
        super.onDestroyView();
        Events.unregister(_eventsSubscriber);
    }

    public void onPause()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/User$UpdateEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$NUXCompletedEvent, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, com/pinterest/ui/megaphone/HomeNagEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$UndoRebuildFeedEvent, com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent, com/pinterest/api/remote/DigestApi$FeedLoadEvent, com/pinterest/api/remote/DigestApi$UnfollowStoryEvent
        });
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Events.register(_eventsSubscriber, com/pinterest/api/model/User$UpdateEvent, new Class[] {
            com/pinterest/activity/nux/fragment/NUXEndScreenFragment$NUXCompletedEvent, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, com/pinterest/ui/megaphone/HomeNagEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$UndoRebuildFeedEvent, com/pinterest/api/remote/DigestApi$FeedLoadEvent, com/pinterest/api/remote/DigestApi$UnfollowStoryEvent
        });
        Events.registerSticky(_eventsSubscriber, com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent, new Class[0]);
        NagUtils.showNag(getPlacementId(), new HomeNagEvent(), 0x7f060009);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        ButterKnife.a(this, view);
        super.onViewCreated(view, bundle);
        _actionBar.setLogo(DrawableUtils.tintIcon(0x7f020119, 0x7f090061));
        _actionBar.setNavigationIcon(null);
        _nagView = (MegaphoneView)_gridVw.addHeaderView(0x7f030100);
        _headerView.setVisibility(8);
        _gridVw.getAdapterView().setOnExpandClickListener(new _cls1());
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









/*
    static Runnable access$1402(DigestFragment digestfragment, Runnable runnable)
    {
        digestfragment._eduRunnable = runnable;
        return runnable;
    }

*/






















/*
    static boolean access$402(DigestFragment digestfragment, boolean flag)
    {
        digestfragment._firstLoad = flag;
        return flag;
    }

*/






    private class _cls2
        implements Runnable
    {

        final DigestFragment this$0;

        public void run()
        {
            reportImpressions();
            if (isAdded() && isActive() && _handler != null)
            {
                _handler.postDelayed(this, 30000L);
            }
        }

        _cls2()
        {
            this$0 = DigestFragment.this;
            super();
        }
    }



    private class _cls5 extends com.pinterest.api.remote.DigestApi.DigestStoryFeedApiResponseHandler
    {

        final DigestFragment this$0;

        public void onSuccess(Feed feed)
        {
            if ( != null)
            {
                ((DigestGridAdapter)).setDataSource(null);
            }
            super.onSuccess(feed);
            feed = feed.getNags();
            if (feed == null || feed.a() <= 0) goto _L2; else goto _L1
_L1:
            feed = feed.c(0).a("nag_type", "");
            if (!feed.equals("write_banned")) goto _L4; else goto _L3
_L3:
            HomeHelper.showWriteBannedMegaphone();
_L6:
            if (isActive())
            {
                SurveyHelper.a(getActivity(), Placement.ANDROID_GLOBAL_SURVEY);
                _eduRunnable = EducationHelper.a(Placement.ANDROID_HOME_FEED_TAKEOVER, DigestFragment.this);
            }
            return;
_L4:
            if (feed.equals("email_verification"))
            {
                HomeHelper.showEmailVerificationMegaphone();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            feed = MyUser.get();
            if (feed != null && (feed.getFollowingCount() == null || feed.getFollowingCount().intValue() == 0))
            {
                HomeHelper.showEmptyFollowingMegaphone();
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls5(FeedApiResponseHandler feedapiresponsehandler)
        {
            this$0 = DigestFragment.this;
            super(feedapiresponsehandler);
        }
    }


    private class _cls6 extends com.pinterest.base.Events.EventsSubscriber
    {

        final DigestFragment this$0;

        public void onEventMainThread(com.pinterest.activity.nux.fragment.NUXEndScreenFragment.NUXCompletedEvent nuxcompletedevent)
        {
            PLog.a("NUXCompletedEvent", new Object[0]);
            refresh();
        }

        public void onEventMainThread(com.pinterest.activity.nux.fragment.NUXEndScreenFragment.UndoRebuildFeedEvent undorebuildfeedevent)
        {
            getTitle.setRefreshing(true);
            InterestsApi.b(new _cls3(), getApiTag());
        }

        public void onEventMainThread(com.pinterest.api.model.User.UpdateEvent updateevent)
        {
        }

        public void onEventMainThread(com.pinterest.api.remote.DigestApi.FeedLoadEvent feedloadevent)
        {
            loadDigestHeaderData();
        }

        public void onEventMainThread(com.pinterest.api.remote.DigestApi.UnfollowStoryEvent unfollowstoryevent)
        {
            ((DigestGridAdapter)complete).removeStory(unfollowstoryevent.a(), unfollowstoryevent.b());
            reset();
        }

        public void onEventMainThread(com.pinterest.ui.grid.PinGridCell.ImageLoadEvent imageloadevent)
        {
            StopWatch.get().complete("ttrfp", ((DigestGridAdapter)complete).getDataSource().isCached(), null).complete("login_email").complete("signup_email");
            Events.unregister(_eventsSubscriber, new Class[] {
                com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
            });
        }

        public void onEventMainThread(HomeFeedMegaphoneEvent homefeedmegaphoneevent)
        {
            if (removeStickyEvent.getVisibility() != 0)
            {
                Events.removeStickyEvent(homefeedmegaphoneevent);
                if (homefeedmegaphoneevent.getType() == com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent.EventType.UPDATE)
                {
                    removeStickyEvent.setTitle(homefeedmegaphoneevent.getTitle());
                    removeStickyEvent.setDesc(homefeedmegaphoneevent.getDesc());
                    removeStickyEvent.addSvgBackground(0x7f06000a);
                    class _cls1
                        implements android.view.View.OnClickListener
                    {

                        final _cls6 this$1;

                        public void onClick(View view)
                        {
                            Pinalytics.a(ElementType.UPDATE_BUTTON, ComponentType.NAG);
                            if (getActivity() != null)
                            {
                                AutoUpdateManager.a().startUpdate(getActivity());
                            }
                        }

                _cls1()
                {
                    this$1 = _cls6.this;
                    super();
                }
                    }

                    removeStickyEvent.setPositiveButton(homefeedmegaphoneevent.getPositiveBtnText(), new _cls1());
                    class _cls2
                        implements android.view.View.OnClickListener
                    {

                        final _cls6 this$1;

                        public void onClick(View view)
                        {
                            Pinalytics.a(ElementType.CANCEL_BUTTON, ComponentType.NAG);
                        }

                _cls2()
                {
                    this$1 = _cls6.this;
                    super();
                }
                    }

                    removeStickyEvent.setNegativeButton(homefeedmegaphoneevent.getNegativeBtnText(), new _cls2());
                    removeStickyEvent.show();
                    return;
                }
            }
        }

        public void onEventMainThread(HomeNagEvent homenagevent)
        {
            NagUtils.showNagFromEvent(DigestFragment.this, removeStickyEvent, homenagevent);
        }

        _cls6()
        {
            this$0 = DigestFragment.this;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final DigestFragment this$0;

        public void run()
        {
            InterestsApi.a(new _cls1(), getApiTag());
        }

        _cls7()
        {
            this$0 = DigestFragment.this;
            super();
        }
    }


    private class DigestHeader
    {

        public Integer height;
        public DigestItem item;

        public DigestHeader(DigestItem digestitem, Integer integer)
        {
            item = digestitem;
            height = integer;
        }
    }


    private class _cls3 extends BackgroundTask
    {

        DigestFeed _cachedFeed;
        final DigestFragment this$0;
        final PinterestJsonObject val$cachedFeedData;

        public void onFinish()
        {
            _firstLoad = false;
            _digestFeedHandler.onSuccess(_cachedFeed);
            refresh();
        }

        public void run()
        {
            _cachedFeed = new DigestFeed(cachedFeedData, null);
            _cachedFeed.setCached(true);
        }

        _cls3()
        {
            this$0 = DigestFragment.this;
            cachedFeedData = pinterestjsonobject;
            super();
        }
    }


}
