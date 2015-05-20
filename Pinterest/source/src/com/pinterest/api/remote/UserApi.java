// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.net.Uri;
import com.pinterest.api.ApiFields;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.Batch;
import com.pinterest.api.model.BatchRequest;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi, ExperiencesApi

public class UserApi extends BaseApi
{

    public static void a(String s, BoardApi.BoardFeedApiResponse boardfeedapiresponse, String s1)
    {
        s = String.format("users/%s/boards/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.k);
        treemap.put("page_size", Device.getPageSizeString());
        treemap.put("long_request", "");
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (boardfeedapiresponse)), s1);
    }

    public static void a(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        s = String.format("users/%s/pins/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.t);
        treemap.put("page_size", Device.getPageSizeString());
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (pinfeedapiresponse)), s1);
    }

    public static void a(String s, UserApiResponse userapiresponse, String s1)
    {
        s = String.format("users/%s/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("add_fields", "user.partner()");
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (userapiresponse)), s1);
    }

    public static void a(String s, UserFeedApiResponse userfeedapiresponse, String s1)
    {
        s = String.format("users/%s/following/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.i);
        treemap.put("page_size", Device.getPageSizeString());
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (userfeedapiresponse)), s1);
    }

    public static void a(String s, String s1, BoardApi.BoardFeedApiResponse boardfeedapiresponse, String s2)
    {
        s = String.format("users/%s/boards/following/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.k);
        treemap.put("explicit_following", "true");
        treemap.put("page_size", s1);
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (boardfeedapiresponse)), s2);
    }

    public static void a(String s, String s1, ExperiencesApi.ExperienceResponseHandler experienceresponsehandler, String s2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("user_id", s1);
        ExperiencesApi.a(s, hashmap, experienceresponsehandler, s2);
    }

    public static void a(String s, String s1, UserFeedApiResponse userfeedapiresponse, String s2)
    {
        s = String.format("users/%s/followers/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.i);
        treemap.put("page_size", s1);
        a(s, ((Map) (treemap)), ((BaseApiResponseHandler) (userfeedapiresponse)), s2);
    }

    public static void a(String s, String s1, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("email", s);
        if (s1 != null)
        {
            requestparams.a("invite_source", s1);
        }
        c("users/invite/email/", requestparams, null, s2);
    }

    public static void a(String s, String s1, String s2, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("reason", s1);
        requestparams.a("explanation", s2);
        a("users/%s/report/", s, requestparams, baseapiresponsehandler);
    }

    public static void a(String s, String s1, String s2, BaseApiResponseHandler baseapiresponsehandler, String s3)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("invite_code", s1);
        if (s2 != null)
        {
            requestparams.a("invite_source", s2);
        }
        c(String.format("callback/invite_sent/%s/", new Object[] {
            s
        }), requestparams, baseapiresponsehandler, s3);
    }

    public static void a(String s, boolean flag, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        if (flag)
        {
            b("users/%s/follow/", s, baseapiresponsehandler, s1);
            return;
        } else
        {
            c("users/%s/follow/", s, baseapiresponsehandler, s1);
            return;
        }
    }

    public static void a(String s, boolean flag, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("emails", s);
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        requestparams.a("invite_all", s);
        if (s1 != null)
        {
            requestparams.a("invite_source", s1);
        }
        c("users/invite/", requestparams, baseapiresponsehandler, s2);
    }

    public static void a(byte abyte0[], BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("profile_image", new ByteArrayInputStream(abyte0), "profilepicture.jpg", "image/jpeg");
        c("users/settings/", requestparams, baseapiresponsehandler, s);
    }

    public static void b(String s, BoardApi.BoardFeedApiResponse boardfeedapiresponse, String s1)
    {
        a(s, Device.getPageSizeString(), boardfeedapiresponse, s1);
    }

    public static void b(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        s = String.format("users/%s/pins/liked/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.t);
        treemap.put("page_size", Device.getPageSizeString());
        a(s, treemap, pinfeedapiresponse, s1);
    }

    public static void b(String s, UserFeedApiResponse userfeedapiresponse, String s1)
    {
        a(s, Device.getPageSizeString(), userfeedapiresponse, s1);
    }

    public static void h(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        Batch batch = new Batch();
        BatchRequest batchrequest = new BatchRequest("GET", String.format("/v3/users/%s/boards/following/", new Object[] {
            s
        }));
        BatchRequest batchrequest1 = new BatchRequest("GET", String.format("/v3/users/%s/interests/favorited/", new Object[] {
            s
        }));
        s = new BatchRequest("GET", String.format("/v3/users/%s/following/", new Object[] {
            s
        }));
        batchrequest.setParams("fields", new String[] {
            ApiFields.k
        });
        batchrequest.setParams("page_size", new String[] {
            "5"
        });
        batchrequest1.setParams("fields", new String[] {
            ApiFields.q
        });
        batchrequest1.setParams("page_size", new String[] {
            Integer.toString(8)
        });
        s.setParams("fields", new String[] {
            ApiFields.i
        });
        s.setParams("page_size", new String[] {
            String.valueOf(Resources.integer(0x7f0c001b))
        });
        batch.add(batchrequest.toRequest());
        batch.add(batchrequest1.toRequest());
        batch.add(s.toRequest());
        b("batch/", batch.toRequestParam().a(), baseapiresponsehandler, s1);
    }

    public static void i(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        b("users/%s/block/", s, baseapiresponsehandler, s1);
    }

    public static void j(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        c("users/%s/block/", s, baseapiresponsehandler, s1);
    }

    public static void k(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        s = Uri.encode(s);
        a((new StringBuilder("users/invite/sms/?name=")).append(s).toString(), baseapiresponsehandler, s1);
    }
}
