// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiClient;
import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.Batch;
import com.pinterest.api.model.BatchRequest;
import com.pinterest.base.Device;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class BoardApi extends BaseApi
{

    private static RequestParams a(String s, String s1, String s2, Boolean boolean1, String s3, Boolean boolean2)
    {
        RequestParams requestparams = new RequestParams();
        if (s != null && s.length() > 0)
        {
            requestparams.a("name", s);
        }
        if (s1 != null && s1.length() > 0)
        {
            requestparams.a("category", s1);
        }
        if (s2 != null && s2.length() > 0)
        {
            requestparams.a("description", s2);
        }
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                s = "secret";
            } else
            {
                s = "public";
            }
            requestparams.a("privacy", s);
        }
        if (s3 != null)
        {
            requestparams.a("layout", s3);
        }
        if (boolean2 != null)
        {
            requestparams.a("collaborator_invites_enabled", boolean2);
        }
        return requestparams;
    }

    public static void a(String s, BoardApiResponse boardapiresponse, String s1)
    {
        a(s, true, boardapiresponse, s1);
    }

    public static void a(String s, BoardFeedApiResponse boardfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.k);
        requestparams.a("page_size", Device.getPageSizeString());
        a(String.format("boards/%s/related/board/", new Object[] {
            s
        }), requestparams, ((BaseApiResponseHandler) (boardfeedapiresponse)), s1);
    }

    public static void a(String s, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        a(s, true, pinfeedapiresponse, s1);
    }

    public static void a(String s, String s1, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("emails", s1);
        b((new StringBuilder("boards/")).append(s).append("/collaborators/invite/email/").toString(), requestparams, baseapiresponsehandler, null);
    }

    public static void a(String s, String s1, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("invite_code", s1);
        c((new StringBuilder("boards/")).append(s).append("/collaborators/invite/facebook/").toString(), requestparams, null, s2);
    }

    public static void a(String s, String s1, String s2, Boolean boolean1, String s3, BaseApiResponseHandler baseapiresponsehandler)
    {
        b("boards/", a(s, s1, s2, boolean1, s3, ((Boolean) (null))), baseapiresponsehandler, null);
    }

    public static void a(String s, String s1, String s2, String s3, Boolean boolean1, String s4, Boolean boolean2, BaseApiResponseHandler baseapiresponsehandler, 
            String s5)
    {
        a("boards/%s/", s, a(s1, s2, s3, boolean1, s4, boolean2), baseapiresponsehandler, s5);
    }

    public static void a(String s, String s1, boolean flag, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("boards/%s/collaborators/%s/?ban=");
        String s3;
        if (flag)
        {
            s3 = "1";
        } else
        {
            s3 = "0";
        }
        c(String.format(stringbuilder.append(s3).toString(), new Object[] {
            s, s1
        }), baseapiresponsehandler, s2);
    }

    public static void a(String s, boolean flag, BoardApiResponse boardapiresponse, String s1)
    {
        s = String.format("boards/%s/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.l);
        a(s, flag, ((Map) (treemap)), ((BaseApiResponseHandler) (boardapiresponse)), s1);
    }

    public static void a(String s, boolean flag, BoardFollowApiResponse boardfollowapiresponse, String s1)
    {
        if (flag)
        {
            b("boards/%s/follow/", s, boardfollowapiresponse, s1);
            return;
        } else
        {
            c("boards/%s/follow/", s, boardfollowapiresponse, s1);
            return;
        }
    }

    public static void a(String s, boolean flag, PinApi.PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        s = String.format("boards/%s/pins/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.u);
        treemap.put("page_size", Device.getPageSizeString());
        a(s, flag, ((Map) (treemap)), ((BaseApiResponseHandler) (pinfeedapiresponse)), s1);
    }

    public static void a(String s, boolean flag, UserApi.UserFeedApiResponse userfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.i);
        String s2;
        if (flag)
        {
            s2 = "6";
        } else
        {
            s2 = "30";
        }
        requestparams.a("page_size", s2);
        a((new StringBuilder("boards/")).append(s).append("/collaborators/").toString(), requestparams, ((BaseApiResponseHandler) (userfeedapiresponse)), s1);
    }

    public static void a(List list, PinApi.PinFeedApiResponse pinfeedapiresponse)
    {
        Batch batch = new Batch();
        BatchRequest batchrequest;
        for (list = list.iterator(); list.hasNext(); batch.add(batchrequest.toRequest()))
        {
            batchrequest = new BatchRequest("GET", String.format("/v3/boards/%s/pins/", new Object[] {
                (String)list.next()
            }));
            batchrequest.setParams("fields", new String[] {
                (new StringBuilder()).append(ApiFields.a).append(",pin.place_summary()").toString()
            });
            batchrequest.setParams("page_size", new String[] {
                Device.getPageSizeString()
            });
        }

        c("batch/", batch.toRequestParam(), pinfeedapiresponse, null);
    }

    public static void d(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        Batch batch = new Batch();
        BatchRequest batchrequest = new BatchRequest("GET", String.format("/v3/boards/%s/", new Object[] {
            s1
        }));
        BatchRequest batchrequest1 = new BatchRequest("GET", String.format("/v3/boards/%s/collaborators/invites/me/", new Object[] {
            s1
        }));
        BatchRequest batchrequest2 = new BatchRequest("GET", String.format("/v3/boards/%s/pins/", new Object[] {
            s1
        }));
        BatchRequest batchrequest3 = new BatchRequest("GET", "/v3/experiences/");
        batchrequest.setParams("fields", new String[] {
            ApiFields.l
        });
        batchrequest2.setParams("page_size", new String[] {
            Device.getPageSizeString()
        });
        batchrequest2.setParams("fields", new String[] {
            ApiFields.u
        });
        batchrequest3.setParams("placement_ids", new String[] {
            s
        });
        batchrequest3.setParams("extra_context", new String[] {
            (new StringBuilder("{\"board_id\":")).append(s1).append("}").toString()
        });
        batch.add(batchrequest.toRequest());
        batch.add(batchrequest1.toRequest());
        batch.add(batchrequest2.toRequest());
        batch.add(batchrequest3.toRequest());
        c("batch/", batch.toRequestParam(), baseapiresponsehandler, s2);
    }

    public static void e(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("collaborator_ids", s1);
        c((new StringBuilder("boards/")).append(s).append("/collaborators/invite/").toString(), requestparams, baseapiresponsehandler, s2);
    }

    public static void f(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("add_fields", ApiFields.n);
        requestparams.a("sort", "viewer_first");
        a(String.format("boards/%s/invites/", new Object[] {
            s
        }), requestparams, baseapiresponsehandler, s1);
    }

    public static void g(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        a((new StringBuilder("boards/")).append(s).append("/collaborators/invite/facebook/").toString(), baseapiresponsehandler, s1);
    }

    public static void h(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        if (ApiClient.d())
        {
            ApiHttpClient.post(String.format("boards/%s/collaborators/invite/accept/", new Object[] {
                s
            }), baseapiresponsehandler, s1);
        }
    }

    public static void i(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        c("boards/%s/collaborators/invite/me/", s, baseapiresponsehandler, s1);
    }

    public static void j(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        c("boards/%s/", s, baseapiresponsehandler, s1);
    }
}
