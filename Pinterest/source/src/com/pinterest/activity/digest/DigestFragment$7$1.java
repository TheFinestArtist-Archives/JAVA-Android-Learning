// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.support.v4.widget.SwipeRefreshLayout;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class this._cls1 extends ApiResponseHandler
{

    final is._cls0 this$1;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        DigestFragment.access$2700(_fld0);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        if (apiresponse.getCode() != 220)
        {
            super.onSuccess(apiresponse);
            DigestFragment.access$3100(_fld0).setRefreshing(false);
            Experiences.c();
            Experiences.a(Experiences.a).d();
            Experiences.c().d(Experiences.a);
            refresh();
            return;
        } else
        {
            DigestFragment.access$2700(_fld0);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}