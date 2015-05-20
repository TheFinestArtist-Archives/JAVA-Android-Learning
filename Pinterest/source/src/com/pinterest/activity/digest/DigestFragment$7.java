// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import com.pinterest.api.remote.InterestsApi;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class this._cls0
    implements Runnable
{

    final DigestFragment this$0;

    public void run()
    {
        class _cls1 extends ApiResponseHandler
        {

            final DigestFragment._cls7 this$1;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                super.onFailure(throwable, apiresponse);
                DigestFragment.access$2700(this$0);
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                if (apiresponse.getCode() != 220)
                {
                    super.onSuccess(apiresponse);
                    DigestFragment.access$3100(this$0).setRefreshing(false);
                    Experiences.c();
                    Experiences.a(Experiences.a).d();
                    Experiences.c().d(Experiences.a);
                    refresh();
                    return;
                } else
                {
                    DigestFragment.access$2700(this$0);
                    return;
                }
            }

            _cls1()
            {
                this$1 = DigestFragment._cls7.this;
                super();
            }
        }

        InterestsApi.a(new _cls1(), DigestFragment.access$3200(DigestFragment.this));
    }

    _cls1()
    {
        this$0 = DigestFragment.this;
        super();
    }
}
