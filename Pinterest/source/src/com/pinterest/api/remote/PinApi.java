// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.util.Base64;
import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.Batch;
import com.pinterest.api.model.BatchRequest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Device;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class PinApi extends BaseApi
{

    public static final String a;
    public static final String b;

    public static void a(PinDetailParams pindetailparams, ApiResponseHandler apiresponsehandler, String s)
    {
        Batch batch = new Batch();
        String s1 = String.format("/v3/pins/%s/repin/", new Object[] {
            pindetailparams.a
        });
        HashMap hashmap = new HashMap();
        hashmap.put("board_id", pindetailparams.b);
        hashmap.put("description", pindetailparams.d);
        hashmap.put("place", pindetailparams.c);
        if (pindetailparams.e)
        {
            hashmap.put("share_facebook", "1");
        }
        if (pindetailparams.f)
        {
            pindetailparams = "1";
        } else
        {
            pindetailparams = "0";
        }
        hashmap.put("share_twitter", pindetailparams);
        batch.add((new BatchRequest("POST", s1, hashmap)).toRequest());
        c("batch/", batch.toRequestParam(), apiresponsehandler, s);
    }

    public static void a(PinDetailParams pindetailparams, BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("board_id", pindetailparams.b);
        requestparams.a("description", pindetailparams.d);
        requestparams.a("place", pindetailparams.c);
        if (pindetailparams.e)
        {
            requestparams.a("share_facebook", "1");
        }
        String s1;
        if (pindetailparams.f)
        {
            s1 = "1";
        } else
        {
            s1 = "0";
        }
        requestparams.a("share_twitter", s1);
        requestparams.a("add_fields", "pin.place(),place.access");
        a("pins/%s/", pindetailparams.a, requestparams, baseapiresponsehandler, s);
    }

    public static void a(PinSubmitParams pinsubmitparams, BaseApiResponseHandler baseapiresponsehandler)
    {
        byte abyte0[] = Base64.decode(pinsubmitparams.h, 0);
        RequestParams requestparams = new RequestParams();
        if (pinsubmitparams.j != null && pinsubmitparams.j.length() > 0)
        {
            requestparams.a("sdk_client_id", pinsubmitparams.j);
        }
        if (pinsubmitparams.i != null && pinsubmitparams.i.length() > 0)
        {
            requestparams.a("sdk_package_id", pinsubmitparams.i);
        }
        requestparams.a("board_id", pinsubmitparams.a);
        requestparams.a("description", pinsubmitparams.b);
        requestparams.a("share_twitter", String.valueOf(pinsubmitparams.f));
        if (ModelHelper.isValid(pinsubmitparams.d))
        {
            requestparams.a("image_url", pinsubmitparams.d);
        } else
        {
            requestparams.a("image", new ByteArrayInputStream(abyte0), "myphoto.jpg", "image/jpeg");
        }
        if (ModelHelper.isValidString(pinsubmitparams.c))
        {
            requestparams.a("source_url", pinsubmitparams.c);
        }
        if (ModelHelper.isValidString(pinsubmitparams.k))
        {
            requestparams.a("place", pinsubmitparams.k);
        }
        requestparams.a("add_fields", a);
        b("pins/", requestparams, baseapiresponsehandler, null);
    }

    public static void a(String s, int i, int j, ApiResponseHandler apiresponsehandler)
    {
        s = String.format("promoted/%s/feedback/reason/", new Object[] {
            s
        });
        RequestParams requestparams = new RequestParams();
        if (ModelHelper.isValid(Integer.valueOf(j)))
        {
            requestparams.a("complaint_reason", j);
        }
        if (ModelHelper.isValid(Integer.valueOf(i)))
        {
            requestparams.a("feedback_type", i);
        }
        b(s, requestparams, apiresponsehandler, null);
    }

    public static void a(String s, int i, ApiResponseHandler apiresponsehandler)
    {
        s = String.format("promoted/%s/feedback/", new Object[] {
            s, Integer.valueOf(i)
        });
        RequestParams requestparams = new RequestParams();
        if (ModelHelper.isValid(Integer.valueOf(i)))
        {
            requestparams.a("feedback_type", i);
        }
        b(s, requestparams, apiresponsehandler, null);
    }

    public static void a(String s, int i, String s1, int j, int k, ApiResponseHandler apiresponsehandler)
    {
        s = String.format("pfy/%s/feedback/reason/", new Object[] {
            s
        });
        RequestParams requestparams = new RequestParams();
        if (ModelHelper.isValid(s1))
        {
            requestparams.a("through_id", s1);
        }
        if (ModelHelper.isValid(Integer.valueOf(j)))
        {
            requestparams.a("rec_reason_id", j);
        }
        if (ModelHelper.isValid(Integer.valueOf(k)))
        {
            requestparams.a("complaint_reason", k);
        }
        if (ModelHelper.isValid(Integer.valueOf(i)))
        {
            requestparams.a("feedback_type", i);
        }
        b(s, requestparams, apiresponsehandler, null);
    }

    public static void a(String s, int i, String s1, ApiResponseHandler apiresponsehandler, String s2)
    {
        s = String.format("pfy/%s/feedback/", new Object[] {
            s
        });
        RequestParams requestparams = new RequestParams();
        if (ModelHelper.isValid(s1))
        {
            requestparams.a("through_id", s1);
        }
        if (ModelHelper.isValid(Integer.valueOf(i)))
        {
            requestparams.a("feedback_type", i);
        }
        b(s, requestparams, apiresponsehandler, s2);
    }

    public static void a(String s, BoardApi.BoardFeedApiResponse boardfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.k);
        requestparams.a("page_size", Device.getPageSizeString());
        a(String.format("pins/%s/repinned_onto/", new Object[] {
            s
        }), requestparams, ((BaseApiResponseHandler) (boardfeedapiresponse)), s1);
    }

    public static void a(String s, PinApiResponse pinapiresponse, String s1)
    {
        a(s, true, pinapiresponse, s1);
    }

    public static void a(String s, PinFeedApiResponse pinfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.t);
        requestparams.a("page_size", Device.getPageSizeString());
        a((new StringBuilder("pins/")).append(s).append("/related/pin/").toString(), requestparams, ((BaseApiResponseHandler) (pinfeedapiresponse)), s1);
    }

    public static void a(String s, UserApi.UserFeedApiResponse userfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.i);
        requestparams.a("page_size", Device.getPageSizeString());
        a(String.format("pins/%s/likes/", new Object[] {
            s
        }), requestparams, ((BaseApiResponseHandler) (userfeedapiresponse)), s1);
    }

    public static void a(String s, String s1, CommentApiResponse commentapiresponse)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("text", s1);
        a("pins/%s/comment/", s, requestparams, ((BaseApiResponseHandler) (commentapiresponse)), null);
    }

    public static void a(String s, String s1, CommentDeleteApiResponse commentdeleteapiresponse)
    {
        if (commentdeleteapiresponse != null)
        {
            commentdeleteapiresponse.setCommentUid(s1);
        }
        c((new StringBuilder("pins/%s/comments/")).append(s1).append("/").toString(), s, commentdeleteapiresponse, null);
    }

    public static void a(String s, String s1, String s2, int i, int j, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("reason", s1);
        requestparams.a("explanation", s2);
        if (i != -1)
        {
            requestparams.a("view_type", String.valueOf(i));
        }
        if (j != -1)
        {
            requestparams.a("view_paramter_type", String.valueOf(j));
        }
        a("pins/%s/mark/", s, requestparams, baseapiresponsehandler);
    }

    public static void a(String s, boolean flag, PinApiResponse pinapiresponse, String s1)
    {
        s = String.format("pins/%s/", new Object[] {
            s
        });
        TreeMap treemap = new TreeMap();
        treemap.put("fields", ApiFields.r);
        a(s, flag, ((Map) (treemap)), ((BaseApiResponseHandler) (pinapiresponse)), s1);
    }

    public static void a(String s, boolean flag, PinLikeApiResponse pinlikeapiresponse)
    {
        if (flag)
        {
            b("pins/%s/like/", s, pinlikeapiresponse, null);
            return;
        } else
        {
            c("pins/%s/like/", s, pinlikeapiresponse, null);
            return;
        }
    }

    public static void f(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        a("pins/%s/comments/", s, baseapiresponsehandler, s1);
    }

    public static void g(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        c("pins/%s/", s, baseapiresponsehandler, s1);
    }

    static 
    {
        String s;
        if (Device.shouldLoadBigImages())
        {
            s = "pin.images[236x,736x,136x136]";
        } else
        {
            s = "pin.images[550x,90x90]";
        }
        a = s;
        b = (new StringBuilder(",")).append(a).toString();
    }

    private class PinDetailParams
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public boolean f;

        public PinDetailParams()
        {
        }
    }


    private class PinSubmitParams
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
        public Bitmap g;
        public String h;
        public String i;
        public String j;
        public String k;

        public static PinSubmitParams a(PinterestJsonObject pinterestjsonobject)
        {
            PinSubmitParams pinsubmitparams = new PinSubmitParams();
            try
            {
                pinsubmitparams.i = pinterestjsonobject.a("sdk_package_id", "");
                pinsubmitparams.j = pinterestjsonobject.a("sdk_client_id", "");
                pinsubmitparams.a = pinterestjsonobject.a("board_id", "");
                pinsubmitparams.b = pinterestjsonobject.a("summary", "");
                pinsubmitparams.e = pinterestjsonobject.a("share_facebook", 0);
                pinsubmitparams.f = pinterestjsonobject.a("share_twitter", 0);
                pinsubmitparams.c = pinterestjsonobject.a("source_url", "");
                pinsubmitparams.d = pinterestjsonobject.a("image_url", "");
                pinsubmitparams.k = pinterestjsonobject.a("place", "");
                pinsubmitparams.h = pinterestjsonobject.a("imageData", "");
            }
            // Misplaced declaration of an exception variable
            catch (PinterestJsonObject pinterestjsonobject)
            {
                return pinsubmitparams;
            }
            return pinsubmitparams;
        }

        public final PinterestJsonObject a()
        {
            PinterestJsonObject pinterestjsonobject = new PinterestJsonObject();
            try
            {
                pinterestjsonobject.b("sdk_client_id", j);
                pinterestjsonobject.b("sdk_package_id", i);
                pinterestjsonobject.b("board_id", a);
                pinterestjsonobject.b("summary", b);
                pinterestjsonobject.b("source_url", c);
                pinterestjsonobject.b("image_url", d);
                pinterestjsonobject.b("share_facebook", String.valueOf(e));
                pinterestjsonobject.b("share_twitter", String.valueOf(f));
                pinterestjsonobject.b("place", k);
                if (g != null)
                {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    g.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, bytearrayoutputstream);
                    bytearrayoutputstream.flush();
                    byte abyte0[] = bytearrayoutputstream.toByteArray();
                    bytearrayoutputstream.close();
                    pinterestjsonobject.b("imageData", Base64.encodeToString(abyte0, 0));
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return pinterestjsonobject;
            }
            return pinterestjsonobject;
        }

        public PinSubmitParams()
        {
            a = "";
            b = "";
            c = "";
            d = "";
            e = 0;
            f = 0;
            g = null;
            h = "";
            i = "";
            j = "";
            k = "";
        }
    }


    private class CommentDeleteApiResponse extends ApiResponseHandler
    {

        protected String _commentUid;

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            class _cls1 extends BackgroundTask
            {

                final CommentDeleteApiResponse a;

                public void run()
                {
                    com.pinterest.api.model.Comment comment = ModelHelper.getComment(a._commentUid);
                    ModelHelper.deletePinComment(a._commentUid);
                    Pinalytics.a(EventType.PIN_DELETE_COMMENT, a._commentUid);
                    Events.post(new com.pinterest.api.model.Comment.UpdateEvent(comment, true));
                }

                _cls1()
                {
                    a = CommentDeleteApiResponse.this;
                    super();
                }
            }

            (new _cls1()).execute();
        }

        public void setCommentUid(String s)
        {
            _commentUid = s;
        }

        protected CommentDeleteApiResponse()
        {
        }

        protected CommentDeleteApiResponse(int i)
        {
            super(i);
        }

        protected CommentDeleteApiResponse(boolean flag)
        {
            super(flag);
        }
    }

}
