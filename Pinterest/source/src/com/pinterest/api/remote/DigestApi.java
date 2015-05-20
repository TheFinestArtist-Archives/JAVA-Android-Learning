// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiFields;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class DigestApi extends BaseApi
{

    public static void a(BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("add_fields", ApiFields.A);
        requestparams.a("page_size", "25");
        requestparams.a("format_version", 1);
        a("feeds/storyfeed/", requestparams, baseapiresponsehandler, s);
    }
}
