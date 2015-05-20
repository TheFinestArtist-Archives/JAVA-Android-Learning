// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.home;

import android.support.v4.widget.SwipeRefreshLayout;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.log.PLog;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;
import com.pinterest.ui.megaphone.HomeNagEvent;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagHideAndUpdateEvent;
import com.pinterest.ui.megaphone.NagUtils;

// Referenced classes of package com.pinterest.activity.home:
//            HomeFragment

class <init> extends com.pinterest.base.bscriber
{

    final HomeFragment this$0;

    public void onEventMainThread(com.pinterest.activity.nux.fragment.gment.NUXCompletedEvent nuxcompletedevent)
    {
        PLog.a("NUXCompletedEvent", new Object[0]);
        refresh();
    }

    public void onEventMainThread(com.pinterest.activity.nux.fragment.gment.UndoRebuildFeedEvent undorebuildfeedevent)
    {
        HomeFragment.access$1100(HomeFragment.this).setRefreshing(true);
        class _cls3 extends ApiResponseHandler
        {

            final HomeFragment._cls1 this$1;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                super.onFailure(throwable, apiresponse);
                Application.showToast(apiresponse.getMessageDisplay());
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                super.onSuccess(apiresponse);
                HomeFragment.access$1200(this$0).hide();
                HomeFragment.access$1300(this$0);
            }

            _cls3()
            {
                this$1 = HomeFragment._cls1.this;
                super();
            }
        }

        InterestsApi.b(new _cls3(), HomeFragment.access$1400(HomeFragment.this));
    }

    public void onEventMainThread(com.pinterest.api.model.t t)
    {
    }

    public void onEventMainThread(com.pinterest.ui.grid.geLoadEvent geloadevent)
    {
        StopWatch.get().complete("ttrfp", ((PinGridAdapter)HomeFragment.access$900(HomeFragment.this)).getDataSource().isCached(), null).complete("login_email").complete("signup_email");
        Events.unregister(HomeFragment.access$1000(HomeFragment.this), new Class[] {
            com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
        });
    }

    public void onEventMainThread(HomeFeedMegaphoneEvent homefeedmegaphoneevent)
    {
        if (HomeFragment.access$000(HomeFragment.this).getVisibility() != 0)
        {
            Events.removeStickyEvent(homefeedmegaphoneevent);
            if (homefeedmegaphoneevent.getType() == com.pinterest.ui.megaphone.neEvent.EventType.UPDATE)
            {
                HomeFragment.access$100(HomeFragment.this).setTitle(homefeedmegaphoneevent.getTitle());
                HomeFragment.access$200(HomeFragment.this).setDesc(homefeedmegaphoneevent.getDesc());
                HomeFragment.access$300(HomeFragment.this).addSvgBackground(0x7f06000a);
                class _cls1
                    implements android.view.View.OnClickListener
                {

                    final HomeFragment._cls1 this$1;

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
                this$1 = HomeFragment._cls1.this;
                super();
            }
                }

                HomeFragment.access$400(HomeFragment.this).setPositiveButton(homefeedmegaphoneevent.getPositiveBtnText(), new _cls1());
                class _cls2
                    implements android.view.View.OnClickListener
                {

                    final HomeFragment._cls1 this$1;

                    public void onClick(View view)
                    {
                        Pinalytics.a(ElementType.CANCEL_BUTTON, ComponentType.NAG);
                    }

            _cls2()
            {
                this$1 = HomeFragment._cls1.this;
                super();
            }
                }

                HomeFragment.access$500(HomeFragment.this).setNegativeButton(homefeedmegaphoneevent.getNegativeBtnText(), new _cls2());
                HomeFragment.access$600(HomeFragment.this).show();
                return;
            }
        }
    }

    public void onEventMainThread(HomeNagEvent homenagevent)
    {
        NagUtils.showNagFromEvent(HomeFragment.this, HomeFragment.access$700(HomeFragment.this), homenagevent);
    }

    public void onEventMainThread(NagHideAndUpdateEvent naghideandupdateevent)
    {
        HomeFragment.access$800(HomeFragment.this).hideAndUpdate(naghideandupdateevent.updateOnly);
    }

    Event()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
