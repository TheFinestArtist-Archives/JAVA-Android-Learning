// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.support.v4.widget.SwipeRefreshLayout;
import com.pinterest.activity.digest.adapter.DigestGridAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.log.PLog;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;
import com.pinterest.ui.megaphone.HomeNagEvent;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagUtils;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class t> extends com.pinterest.base.criber
{

    final DigestFragment this$0;

    public void onEventMainThread(com.pinterest.activity.nux.fragment.ent.NUXCompletedEvent nuxcompletedevent)
    {
        PLog.a("NUXCompletedEvent", new Object[0]);
        refresh();
    }

    public void onEventMainThread(com.pinterest.activity.nux.fragment.ent.UndoRebuildFeedEvent undorebuildfeedevent)
    {
        DigestFragment.access$2500(DigestFragment.this).setRefreshing(true);
        class _cls3 extends ApiResponseHandler
        {

            final DigestFragment._cls6 this$1;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                super.onFailure(throwable, apiresponse);
                Application.showToast(apiresponse.getMessageDisplay());
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                super.onSuccess(apiresponse);
                DigestFragment.access$2600(this$0).hide();
                DigestFragment.access$2700(this$0);
            }

            _cls3()
            {
                this$1 = DigestFragment._cls6.this;
                super();
            }
        }

        InterestsApi.b(new _cls3(), DigestFragment.access$2800(DigestFragment.this));
    }

    public void onEventMainThread(com.pinterest.api.model.ent._cls6 _pcls6)
    {
    }

    public void onEventMainThread(com.pinterest.api.remote.dEvent devent)
    {
        DigestFragment.access$2900(DigestFragment.this);
    }

    public void onEventMainThread(com.pinterest.api.remote.wStoryEvent wstoryevent)
    {
        ((DigestGridAdapter)DigestFragment.access$3000(DigestFragment.this)).removeStory(wstoryevent.a(), wstoryevent.b());
        reset();
    }

    public void onEventMainThread(com.pinterest.ui.grid.LoadEvent loadevent)
    {
        StopWatch.get().complete("ttrfp", ((DigestGridAdapter)DigestFragment.access$2300(DigestFragment.this)).getDataSource().isCached(), null).complete("login_email").complete("signup_email");
        Events.unregister(DigestFragment.access$2400(DigestFragment.this), new Class[] {
            com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
        });
    }

    public void onEventMainThread(HomeFeedMegaphoneEvent homefeedmegaphoneevent)
    {
        if (DigestFragment.access$1500(DigestFragment.this).getVisibility() != 0)
        {
            Events.removeStickyEvent(homefeedmegaphoneevent);
            if (homefeedmegaphoneevent.getType() == com.pinterest.ui.megaphone.Event.EventType.UPDATE)
            {
                DigestFragment.access$1600(DigestFragment.this).setTitle(homefeedmegaphoneevent.getTitle());
                DigestFragment.access$1700(DigestFragment.this).setDesc(homefeedmegaphoneevent.getDesc());
                DigestFragment.access$1800(DigestFragment.this).addSvgBackground(0x7f06000a);
                class _cls1
                    implements android.view.View.OnClickListener
                {

                    final DigestFragment._cls6 this$1;

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
                this$1 = DigestFragment._cls6.this;
                super();
            }
                }

                DigestFragment.access$1900(DigestFragment.this).setPositiveButton(homefeedmegaphoneevent.getPositiveBtnText(), new _cls1());
                class _cls2
                    implements android.view.View.OnClickListener
                {

                    final DigestFragment._cls6 this$1;

                    public void onClick(View view)
                    {
                        Pinalytics.a(ElementType.CANCEL_BUTTON, ComponentType.NAG);
                    }

            _cls2()
            {
                this$1 = DigestFragment._cls6.this;
                super();
            }
                }

                DigestFragment.access$2000(DigestFragment.this).setNegativeButton(homefeedmegaphoneevent.getNegativeBtnText(), new _cls2());
                DigestFragment.access$2100(DigestFragment.this).show();
                return;
            }
        }
    }

    public void onEventMainThread(HomeNagEvent homenagevent)
    {
        NagUtils.showNagFromEvent(DigestFragment.this, DigestFragment.access$2200(DigestFragment.this), homenagevent);
    }

    nt()
    {
        this$0 = DigestFragment.this;
        super();
    }
}
