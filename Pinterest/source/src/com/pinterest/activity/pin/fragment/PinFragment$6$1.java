// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.ui.text.BevelTitleDivider;

// Referenced classes of package com.pinterest.activity.pin.fragment:
//            PinFragment

class init> extends com.pinterest.api.remote.iResponse
{

    final y this$1;

    public void onSuccess(Feed feed)
    {
label0:
        {
            super.onSuccess(feed);
            if (PinFragment.access$1000(_fld0) != null)
            {
                if (feed == null || feed.getCount() <= 0 || PinFragment.access$1100(_fld0) == null)
                {
                    break label0;
                }
                PinFragment.access$1000(_fld0).setVisibility(0);
            }
            return;
        }
        PinFragment.access$1000(_fld0).setVisibility(8);
    }

    _cls9(FeedApiResponseHandler feedapiresponsehandler)
    {
        this$1 = this._cls1.this;
        super(feedapiresponsehandler);
    }
}
