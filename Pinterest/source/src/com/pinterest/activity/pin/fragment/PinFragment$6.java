// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.remote.PinApi;

// Referenced classes of package com.pinterest.activity.pin.fragment:
//            PinFragment

class this._cls0
    implements Runnable
{

    final PinFragment this$0;

    public void run()
    {
        class _cls1 extends com.pinterest.api.remote.PinApi.PinFeedApiResponse
        {

            final PinFragment._cls6 this$1;

            public void onSuccess(Feed feed)
            {
label0:
                {
                    super.onSuccess(feed);
                    if (PinFragment.access$1000(this$0) != null)
                    {
                        if (feed == null || feed.getCount() <= 0 || PinFragment.access$1100(this$0) == null)
                        {
                            break label0;
                        }
                        PinFragment.access$1000(this$0).setVisibility(0);
                    }
                    return;
                }
                PinFragment.access$1000(this$0).setVisibility(8);
            }

            _cls1(FeedApiResponseHandler feedapiresponsehandler)
            {
                this$1 = PinFragment._cls6.this;
                super(feedapiresponsehandler);
            }
        }

        PinApi.a(PinFragment.access$800(PinFragment.this).getId(), new _cls1(PinFragment.access$900(PinFragment.this)), PinFragment.access$1200(PinFragment.this));
        PinFragment.access$1302(PinFragment.this, false);
    }

    _cls1()
    {
        this$0 = PinFragment.this;
        super();
    }
}
