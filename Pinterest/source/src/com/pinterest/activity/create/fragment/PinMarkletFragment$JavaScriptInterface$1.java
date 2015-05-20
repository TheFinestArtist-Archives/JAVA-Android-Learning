// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import com.pinterest.activity.create.model.PinnableImageFeed;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.webview.PWebView;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class val.feed
    implements Runnable
{

    final is._cls0 this$1;
    final PinnableImageFeed val$feed;

    public void run()
    {
        hideWaitDialog();
        PinMarkletFragment.access$500(_fld0).setVisibility(8);
        if (PinMarkletFragment.access$600(_fld0) != null && val$feed.getCount() > 0)
        {
            AdapterFooterView.setState(PinMarkletFragment.access$700(_fld0), 1);
            PinMarkletFragment.access$800(_fld0).setDataSource(val$feed);
            return;
        } else
        {
            PinMarkletFragment.access$900(_fld0);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$feed = PinnableImageFeed.this;
        super();
    }
}
