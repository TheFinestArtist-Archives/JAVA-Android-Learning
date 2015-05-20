// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.net.Uri;
import com.pinterest.api.ApiFields;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.SearchFilter;
import com.pinterest.base.Device;
import com.pinterest.kit.utils.PStringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi

public class SearchApi extends BaseApi
{

    private static final List a = Arrays.asList(new String[] {
        "facebook_pinner", "mutual_follow", "follower", "twitter_pinner", "google_pinner", "yahoo_pinner", "gplus_pinner", "address_book_pinner", "second_degree_follower"
    });
    private static final List b = Arrays.asList(new String[] {
        "google_non_pinner", "yahoo_non_pinner"
    });
    private static final List c = Arrays.asList(new String[] {
        "board_follower"
    });

    public static void a(BaseApiResponseHandler baseapiresponsehandler, String s)
    {
        c("search/recent/", baseapiresponsehandler, s);
    }

    private static void a(RequestParams requestparams, String s)
    {
        requestparams.a("query", s);
        requestparams.a("asterix", Boolean.valueOf(true));
        requestparams.a("fields", ApiFields.t);
        requestparams.a("page_size", Device.getPageSizeString());
    }

    public static void a(String s)
    {
        a("search/typeahead/prepare/", ((BaseApiResponseHandler) (null)), s);
    }

    public static void a(String s, InterestsApi.InterestsFeedApiResponse interestsfeedapiresponse)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("query", s);
        requestparams.a("fields", ApiFields.o);
        requestparams.a("page_size", Device.getPageSizeString());
        a("search/interests/", requestparams, ((BaseApiResponseHandler) (interestsfeedapiresponse)), null);
    }

    public static void a(String s, PinApi.GuidedPinFeedApiResponse guidedpinfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        a(requestparams, s);
        a("search/user_pins/me/", requestparams, ((BaseApiResponseHandler) (guidedpinfeedapiresponse)), s1);
    }

    public static void a(String s, Scope scope, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        String s2;
        RequestParams requestparams;
        requestparams = new RequestParams();
        s2 = "user.tag, user.website_url, user.location, user.domain_verified";
        _cls1.a[scope.ordinal()];
        JVM INSTR tableswitch 1 6: default 60
    //                   1 98
    //                   2 108
    //                   3 155
    //                   4 161
    //                   5 176
    //                   6 186;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        scope = "board, board_suggestion, facebook_non_pinner, facebook_pinner, followee, mutual_follow, owner_and_commenter, pin_suggestion, twitter_non_pinner, twitter_pinner, recent_queries";
_L9:
        requestparams.a("q", s);
        requestparams.a("tags", scope);
        requestparams.a("add_fields", s2);
        a("search/typeahead/", requestparams, baseapiresponsehandler, s1);
        return;
_L2:
        scope = "geocoded_places";
        s2 = "";
        continue; /* Loop/switch isn't completed */
_L3:
        scope = new ArrayList();
        scope.addAll(a);
        scope.addAll(b);
        scope = PStringUtils.concatStringArray(scope, ",");
        requestparams.a("num_people", "50");
        continue; /* Loop/switch isn't completed */
_L4:
        scope = "recent_queries";
        continue; /* Loop/switch isn't completed */
_L5:
        scope = "facebook_pinner, second_degree_follower, second_degree_followee, mutual_follow, owner_and_commenter, pin_suggestion, twitter_pinner";
        requestparams.a("num_people", "2");
        continue; /* Loop/switch isn't completed */
_L6:
        scope = "board";
        s2 = "";
        continue; /* Loop/switch isn't completed */
_L7:
        scope = "facebook_pinner";
        s2 = (new StringBuilder()).append("user.tag, user.website_url, user.location, user.domain_verified").append(", user.followed_by_me").toString();
        requestparams.a("num_people", "50");
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void a(String s, UserApi.UserFeedApiResponse userfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("query", s);
        requestparams.a("fields", ApiFields.i);
        requestparams.a("page_size", Device.getPageSizeString());
        a("search/users/", requestparams, ((BaseApiResponseHandler) (userfeedapiresponse)), s1);
    }

    public static void a(String s, String s1, ApiResponseHandler apiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("tags", "followee,mutual_follow,owner_and_commenter");
        requestparams.a("q", s);
        if (ModelHelper.isValid(s1))
        {
            requestparams.a("pin", String.valueOf(s1));
        }
        a("search/typeahead/", requestparams, ((BaseApiResponseHandler) (apiresponsehandler)), null);
    }

    public static void a(String s, String s1, boolean flag, BoardApi.GuidedBoardFeedApiResponse guidedboardfeedapiresponse, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("query", s);
        requestparams.a("layout", s1);
        requestparams.a("fields", ApiFields.k);
        requestparams.a("page_size", Device.getPageSizeString());
        if (flag)
        {
            s = "search/me/boards/";
        } else
        {
            s = "search/boards/";
        }
        a(s, requestparams, ((BaseApiResponseHandler) (guidedboardfeedapiresponse)), s2);
    }

    public static void a(String s, List list, Map map, List list1, PinApi.GuidedPinFeedApiResponse guidedpinfeedapiresponse, String s1)
    {
        RequestParams requestparams = new RequestParams();
        a(requestparams, s);
        requestparams.a("term_meta[]", StringUtils.join(list, ","));
        for (s = map.entrySet().iterator(); s.hasNext(); requestparams.a((String)list.getKey(), (String)list.getValue()))
        {
            list = (java.util.Map.Entry)s.next();
        }

        if (list1 != null && list1.size() > 0)
        {
            s = new StringBuilder();
            for (list = list1.iterator(); list.hasNext(); s.append(String.format("%s:%s,", new Object[] {
    map.getType(), map.getTypeValueOrOption()
})))
            {
                map = (SearchFilter)list.next();
            }

            requestparams.a("filters", s.toString());
        }
        a("search/pins/", requestparams, ((BaseApiResponseHandler) (guidedpinfeedapiresponse)), s1);
    }

    public static void b(String s, Scope scope, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        RequestParams requestparams;
        requestparams = new RequestParams();
        requestparams.a("q", s);
        requestparams.a("num_boards", "10");
        requestparams.a("num_people", "10");
        requestparams.a("num_recent_queries", "8");
        requestparams.a("num_autocompletes", "10");
        requestparams.a("add_fields", "user.follower_count,user.pin_count,board.owner(),board.pin_count");
        if (!StringUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        if (scope != Scope.d) goto _L4; else goto _L3
_L3:
        requestparams.a("recent_queries_tags", "recent_pin_searches,recent_user_searches,recent_board_searches");
_L2:
        a("search/autocomplete/", requestparams, baseapiresponsehandler, s1);
        return;
_L4:
        if (scope == Scope.e)
        {
            requestparams.a("recent_queries_tags", "recent_personal_searches");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static void d(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        s = Uri.encode(s);
        String s3 = (new StringBuilder("search/recent/?query=")).append(s).toString();
        s = s3;
        if (StringUtils.isNotEmpty(s1))
        {
            s = (new StringBuilder()).append(s3).append("&vertical=").append(s1).toString();
        }
        c(s, baseapiresponsehandler, s2);
    }

    public static void e(String s, String s1, BaseApiResponseHandler baseapiresponsehandler, String s2)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("q", s);
        requestparams.a("board", s1);
        s = new ArrayList();
        s.addAll(a);
        s.addAll(c);
        requestparams.a("tags", PStringUtils.concatStringArray(s, ","));
        a("search/typeahead/", requestparams, baseapiresponsehandler, s2);
    }


    private class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[Scope.values().length];
            try
            {
                a[Scope.g.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                a[Scope.f.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[Scope.d.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[Scope.b.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[Scope.c.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[Scope.h.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[Scope.a.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Scope extends Enum
    {

        public static final Scope a;
        public static final Scope b;
        public static final Scope c;
        public static final Scope d;
        public static final Scope e;
        public static final Scope f;
        public static final Scope g;
        public static final Scope h;
        public static final Scope i;
        private static final Scope j[];

        public static Scope valueOf(String s)
        {
            return (Scope)Enum.valueOf(com/pinterest/api/remote/SearchApi$Scope, s);
        }

        public static Scope[] values()
        {
            return (Scope[])j.clone();
        }

        static 
        {
            a = new Scope("ALL", 0);
            b = new Scope("TYPEAHEAD", 1);
            c = new Scope("TYPEAHEAD_MY_BOARD", 2);
            d = new Scope("RECENT_QUERIES", 3);
            e = new Scope("RECENT_MY_QUERIES", 4);
            f = new Scope("PEOPLE_PICKER", 5);
            g = new Scope("PLACES", 6);
            h = new Scope("INVITE_FRIENDS", 7);
            i = new Scope("BOARD_COLLABORATORS", 8);
            j = (new Scope[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private Scope(String s, int k)
        {
            super(s, k);
        }
    }

}
