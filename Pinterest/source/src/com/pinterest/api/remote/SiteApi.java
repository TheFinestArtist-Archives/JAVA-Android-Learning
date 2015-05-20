// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiFields;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.base.Device;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class SiteApi extends BaseApi
{

    public static void a(String s, BaseApiResponseHandler baseapiresponsehandler)
    {
        d(s, null, baseapiresponsehandler, null);
    }

    public static void a(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.t);
        requestparams.a("page_size", Device.getPageSizeString());
        a((new StringBuilder("domains/")).append(s).append("/pins/").toString(), requestparams, ((BaseApiResponseHandler) (pinfeedapiresponse)), s1);
    }

    public static void d(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("url", s);
        if (s1 != null)
        {
            treemap.put("pin_id", s1);
        }
        a("offsite/", treemap, baseapiresponsehandler, s2);
    }

    public static void f(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        String s2 = URLEncoder.encode(s, "utf-8");
        s = s2;
_L2:
        a("offsite/check/?url=%s", s, baseapiresponsehandler, s1);
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
