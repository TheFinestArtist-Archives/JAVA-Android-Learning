// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AppEventsLogger;
import com.facebook.RequestBatch;

// Referenced classes of package com.facebook.internal:
//            LikeActionController

class val.analyticsParameters
    implements com.facebook.roller._cls7
{

    final LikeActionController this$0;
    final Activity val$activity;
    final Bundle val$analyticsParameters;
    final blishUnlikeRequestWrapper val$unlikeRequest;

    public void onBatchCompleted(RequestBatch requestbatch)
    {
        LikeActionController.access$2002(LikeActionController.this, false);
        if (val$unlikeRequest.error != null)
        {
            LikeActionController.access$2100(LikeActionController.this, val$activity, val$analyticsParameters, true);
            return;
        } else
        {
            LikeActionController.access$1202(LikeActionController.this, null);
            LikeActionController.access$2202(LikeActionController.this, false);
            LikeActionController.access$1300(LikeActionController.this).logSdkEvent("fb_like_control_did_unlike", null, val$analyticsParameters);
            LikeActionController.access$2300(LikeActionController.this, val$activity, val$analyticsParameters);
            return;
        }
    }

    blishUnlikeRequestWrapper()
    {
        this$0 = final_likeactioncontroller;
        val$unlikeRequest = blishunlikerequestwrapper;
        val$activity = activity1;
        val$analyticsParameters = Bundle.this;
        super();
    }
}
