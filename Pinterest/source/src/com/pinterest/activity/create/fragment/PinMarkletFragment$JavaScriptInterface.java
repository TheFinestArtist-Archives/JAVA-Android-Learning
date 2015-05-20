// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.os.Handler;
import com.pinterest.activity.create.model.PinnableImageFeed;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.CrashReporting;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls0
{

    final PinMarkletFragment this$0;

    public void onFailure(Throwable throwable)
    {
        PinMarkletFragment.access$402(PinMarkletFragment.this, Boolean.TRUE);
        class _cls2
            implements Runnable
        {

            final PinMarkletFragment.JavaScriptInterface this$1;

            public void run()
            {
                if (isAdded())
                {
                    Application.showToast(0x7f0e0215);
                    hideWaitDialog();
                    getActivity().finish();
                }
            }

            _cls2()
            {
                this$1 = PinMarkletFragment.JavaScriptInterface.this;
                super();
            }
        }

        PinMarkletFragment.access$1000(PinMarkletFragment.this).post(new _cls2());
    }

    public void onPinsLoaded(String s)
    {
        if (!StringUtils.isNotEmpty(s))
        {
            break MISSING_BLOCK_LABEL_49;
        }
        s = new PinnableImageFeed((new PinterestJsonObject(s)).e("thumb"));
        PinMarkletFragment.access$302(PinMarkletFragment.this, new PinnableImageFeed(s));
        onSuccess(s);
        return;
        s;
        CrashReporting.logHandledException(s);
        onFailure(s);
        return;
    }

    public void onSuccess(final PinnableImageFeed feed)
    {
        PinMarkletFragment.access$402(PinMarkletFragment.this, Boolean.TRUE);
        class _cls1
            implements Runnable
        {

            final PinMarkletFragment.JavaScriptInterface this$1;
            final PinnableImageFeed val$feed;

            public void run()
            {
                hideWaitDialog();
                PinMarkletFragment.access$500(this$0).setVisibility(8);
                if (PinMarkletFragment.access$600(this$0) != null && feed.getCount() > 0)
                {
                    AdapterFooterView.setState(PinMarkletFragment.access$700(this$0), 1);
                    PinMarkletFragment.access$800(this$0).setDataSource(feed);
                    return;
                } else
                {
                    PinMarkletFragment.access$900(this$0);
                    return;
                }
            }

            _cls1()
            {
                this$1 = PinMarkletFragment.JavaScriptInterface.this;
                feed = pinnableimagefeed;
                super();
            }
        }

        PinMarkletFragment.access$1000(PinMarkletFragment.this).post(new _cls1());
    }

    _cls1()
    {
        this$0 = PinMarkletFragment.this;
        super();
    }
}
