// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.kit.log.PLog;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class SendApi extends BaseApi
{

    public static void a(String s, String s1, String s2, BaseApiResponseHandler baseapiresponsehandler)
    {
        String s3 = (new StringBuilder("pins/")).append(s).append("/share/user/").toString();
        RequestParams requestparams = new RequestParams();
        requestparams.a("user", s1);
        requestparams.a("message", s2);
        PLog.a("sendPin pin %s, user %s", new Object[] {
            s, s1
        });
        b(s3, requestparams, baseapiresponsehandler, null);
    }

    public static void a(String s, String s1, String s2, String s3, String s4, BaseApiResponseHandler baseapiresponsehandler)
    {
        s = (new StringBuilder("pins/")).append(s).append("/share/email/").toString();
        RequestParams requestparams = new RequestParams();
        requestparams.a("email", s1);
        requestparams.a("recipient_name", s2);
        requestparams.a("recipient_image", s3);
        requestparams.a("message", s4);
        b(s, requestparams, baseapiresponsehandler, null);
    }

    public static void b(String s, String s1, String s2, BaseApiResponseHandler baseapiresponsehandler)
    {
        s = (new StringBuilder("boards/")).append(s).append("/share/user/").toString();
        RequestParams requestparams = new RequestParams();
        requestparams.a("user", s1);
        requestparams.a("message", s2);
        b(s, requestparams, baseapiresponsehandler, null);
    }

    public static void b(String s, String s1, String s2, String s3, String s4, BaseApiResponseHandler baseapiresponsehandler)
    {
        s = (new StringBuilder("boards/")).append(s).append("/share/email/").toString();
        RequestParams requestparams = new RequestParams();
        requestparams.a("email", s1);
        requestparams.a("recipient_name", s2);
        requestparams.a("recipient_image", s3);
        requestparams.a("message", s4);
        b(s, requestparams, baseapiresponsehandler, null);
    }
}
