// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.webhook;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.ModelHelper;

// Referenced classes of package com.pinterest.activity.webhook:
//            WebhookActivity

class edApiResponse extends com.pinterest.api.remote.riesFeedApiResponse
{

    final WebhookActivity this$0;
    final String val$name;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        WebhookActivity.access$200(WebhookActivity.this);
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        feed = ModelHelper.getCategory(val$name);
        if (feed != null)
        {
            WebhookActivity.access$300(WebhookActivity.this, feed);
        }
        finish();
    }

    edApiResponse(boolean flag1, String s)
    {
        this$0 = final_webhookactivity;
        val$name = s;
        super(Z.this, flag1);
    }
}
