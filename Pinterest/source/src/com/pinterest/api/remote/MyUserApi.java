// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.Batch;
import com.pinterest.api.model.BatchRequest;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.Device;
import com.pinterest.kit.utils.PStringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pinterest.api.remote:
//            UserApi, FeedApiResponseHandler

public class MyUserApi extends UserApi
{

    public static void a(int i, BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        String s1 = "";
        i;
        JVM INSTR tableswitch 2 5: default 36
    //                   2 45
    //                   3 51
    //                   4 57
    //                   5 63;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        c("connect/%s", s1, baseapiresponsehandler, s);
        return;
_L2:
        s1 = "twitter/";
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = "facebook/";
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = "rakuten/";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "gplus/";
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static void a(ApiResponseHandler apiresponsehandler, String s)
    {
        a("pinvitational/quota/", ((BaseApiResponseHandler) (apiresponsehandler)), s);
    }

    public static void a(BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        d("users/confirmation_email/", baseapiresponsehandler, s);
    }

    public static void a(RequestParams requestparams, SettingsApiResponse settingsapiresponse, String s)
    {
        c("users/settings/", requestparams, settingsapiresponse, s);
    }

    public static void a(AccountApi.SocialConnectParams socialconnectparams, BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        String s1;
        RequestParams requestparams;
        s1 = "";
        requestparams = new RequestParams();
        socialconnectparams.a();
        JVM INSTR tableswitch 2 5: default 48
    //                   2 71
    //                   3 121
    //                   4 171
    //                   5 210;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        socialconnectparams = s1;
_L7:
        b(String.format("connect/%s", new Object[] {
            socialconnectparams
        }), requestparams, baseapiresponsehandler, s);
        return;
_L2:
        requestparams.a("twitter_id", socialconnectparams.g);
        requestparams.a("twitter_screen_name", socialconnectparams.u);
        requestparams.a("twitter_token", socialconnectparams.d);
        requestparams.a("twitter_token_secret", socialconnectparams.e);
        socialconnectparams = "twitter/";
        continue; /* Loop/switch isn't completed */
_L3:
        requestparams.a("facebook_id", socialconnectparams.k);
        requestparams.a("facebook_link", socialconnectparams.v);
        requestparams.a("facebook_token", socialconnectparams.l);
        requestparams.a("facebook_scope", socialconnectparams.m);
        socialconnectparams = "facebook/";
        continue; /* Loop/switch isn't completed */
_L4:
        requestparams.a("rakuten_id", socialconnectparams.h);
        requestparams.a("rakuten_access_token", socialconnectparams.d);
        requestparams.a("rakuten_refresh_token", socialconnectparams.f);
        socialconnectparams = "rakuten/";
        continue; /* Loop/switch isn't completed */
_L5:
        requestparams.a("one_time_code", socialconnectparams.i);
        socialconnectparams = "gplus/";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void a(BoardApi.BoardFeedApiResponse boardfeedapiresponse, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("filter", "secret");
        requestparams.a("fields", ApiFields.k);
        requestparams.a("page_size", Device.getPageSizeString());
        a("users/me/boards/", requestparams, ((BaseApiResponseHandler) (boardfeedapiresponse)), s);
    }

    public static void a(FeedApiResponseHandler feedapiresponsehandler, Map map, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.t);
        requestparams.a("page_size", Device.getPageSizeString());
        if (MyUser.hasAccessToken())
        {
            ApiHttpClient.get("feeds/home/", requestparams, feedapiresponsehandler, true, map, s);
        }
    }

    public static void a(BoardInviteFeedResponse boardinvitefeedresponse, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.k);
        requestparams.a("page_size", Device.getPageSizeString());
        a("users/boards/collaborator_invites/", requestparams, ((BaseApiResponseHandler) (boardinvitefeedresponse)), s);
    }

    public static void a(BoardPickerApiResponse boardpickerapiresponse, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("filter", "all");
        requestparams.a("sort", "alphabetical");
        requestparams.a("fields", ApiFields.m);
        a("users/me/boards/", requestparams, ((BaseApiResponseHandler) (boardpickerapiresponse)), s);
    }

    public static void a(MyUserApiResponse myuserapiresponse, String s)
    {
        a((new StringBuilder("users/me/?fields=")).append(ApiFields.h).toString(), ((BaseApiResponseHandler) (myuserapiresponse)), s);
    }

    public static void a(NotificationFeedApiResponse notificationfeedapiresponse, String s)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.x);
        requestparams.a("styles", com.pinterest.api.model.Notification.Style.requestString());
        a("maia/notifications/", requestparams, ((BaseApiResponseHandler) (notificationfeedapiresponse)), s);
    }

    public static void a(NotificationUnseenCountResponseHandler notificationunseencountresponsehandler)
    {
        a("maia/notifications/counts/", ((BaseApiResponseHandler) (notificationunseencountresponsehandler)), null);
    }

    public static void a(PinApi.PinFeedApiResponse pinfeedapiresponse)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("fields", ApiFields.v);
        requestparams.a("page_size", "200");
        a("feeds/home/", requestparams, ((BaseApiResponseHandler) (pinfeedapiresponse)), null);
    }

    public static void a(com.pinterest.base.Social.Network network, BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        switch (_cls2.a[network.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            d("users/friends/facebook/follow/", baseapiresponsehandler, s);
            return;

        case 2: // '\002'
            d("users/friends/twitter/follow/", baseapiresponsehandler, s);
            break;
        }
    }

    public static void a(String s)
    {
        a("maia/notifications/counts/", ((BaseApiResponseHandler) (new NotificationUnseenCountResponseHandler())), s);
    }

    public static void a(String s, SuggestedBoardPickerApiResponse suggestedboardpickerapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("pin", s);
        requestparams.a("max_num_suggestions", 2);
        requestparams.a("count", 3);
        a("users/boards/board_picker_shortlist", requestparams, ((BaseApiResponseHandler) (suggestedboardpickerapiresponse)), s1);
    }

    public static void a(String s, String s1)
    {
        d((new StringBuilder("connect/facebook/?facebook_token=")).append(s).toString(), null, s1);
    }

    public static void a(ArrayList arraylist, BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        ArrayList arraylist1 = new ArrayList(arraylist.size());
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(((User)arraylist.next()).getUid())) { }
        arraylist = new RequestParams();
        arraylist.a("followee_ids", PStringUtils.concatStringArray(arraylist1, ","));
        b("users/follow/", arraylist, baseapiresponsehandler, s);
    }

    public static void b(BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        d("users/request_delete/", baseapiresponsehandler, s);
    }

    public static void b(String s)
    {
        _cls1 _lcls1 = new _cls1(s);
        Batch batch = new Batch();
        BatchRequest batchrequest = new BatchRequest("DELETE", "/v3/maia/notifications/counts/user/");
        BatchRequest batchrequest1 = new BatchRequest("DELETE", "/v3/maia/notifications/counts/network/");
        batch.add(batchrequest.toRequest());
        batch.add(batchrequest1.toRequest());
        c("batch/", batch.toRequestParam(), _lcls1, s);
    }

    public static void d(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        RequestParams requestparams = new RequestParams();
        if (s != null)
        {
            requestparams.a("self_deactivation_reason", s);
        }
        if (s1 != null)
        {
            requestparams.a("self_deactivation_explanation", s1);
        }
        c("users/me/", requestparams, baseapiresponsehandler, s2);
    }

    public static void f(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("filter", s);
        requestparams.a("exclude_following", Boolean.toString(true));
        requestparams.a("page_size", String.valueOf(Math.min(250, Device.getPageSize() * 6)));
        a("users/me/friends/facebook/", requestparams, baseapiresponsehandler, s1);
    }

    public static void g(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("filter", s);
        requestparams.a("exclude_following", Boolean.toString(true));
        requestparams.a("page_size", String.valueOf(Math.min(250, Device.getPageSize() * 6)));
        a("users/me/friends/twitter/", requestparams, baseapiresponsehandler, s1);
    }

    private class _cls2
    {

        static final int a[];

        static 
        {
            a = new int[com.pinterest.base.Social.Network.values().length];
            try
            {
                a[com.pinterest.base.Social.Network.FACEBOOK.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.pinterest.base.Social.Network.TWITTER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class NotificationUnseenCountResponseHandler extends ApiResponseHandler
    {

        public void onSuccess(ApiResponse apiresponse)
        {
            apiresponse = ((ApiResponse) (apiresponse.getData()));
            if (apiresponse instanceof PinterestJsonObject)
            {
                apiresponse = (PinterestJsonObject)apiresponse;
                int i = apiresponse.a("network", 0);
                int j = apiresponse.a("user", 0);
                int k = apiresponse.a("messages", 0);
                PLog.a("unseenNetworkStory %d unseenNotifications %d unseenConversations %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
                });
                NotificationCount.setCounts(i, j, k);
            }
        }

        public NotificationUnseenCountResponseHandler()
        {
        }
    }


    private class _cls1 extends BaseApiResponseHandler
    {

        final String a;

        public final void onSuccess(PinterestJsonObject pinterestjsonobject)
        {
            super.onSuccess(pinterestjsonobject);
            MyUserApi.a(a);
        }

        _cls1(String s)
        {
            a = s;
            super();
        }
    }

}
