// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import android.net.Uri;
import com.pinterest.activity.pin.events.SocialShareEvent;
import com.pinterest.analytics.FunnelActions;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.schemas.event.EventType;
import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.remote:
//            BaseApi, AnalyticsApi

public class AccountApi extends BaseApi
{

    public static void a()
    {
        b("logout/", null, null);
    }

    public static void a(Uri uri, BaseApiResponseHandler baseapiresponsehandler)
    {
        if (uri == null)
        {
            return;
        }
        Object obj = Uri.parse(uri.getQueryParameter("next"));
        uri = ((Uri) (obj)).getQueryParameter("token");
        String s = ((Uri) (obj)).getQueryParameter("expiration");
        String s1 = ((Uri) (obj)).getQueryParameter("user_id");
        if (StringUtils.isNotEmpty(uri) && StringUtils.isNotEmpty(s) && StringUtils.isNotEmpty(s1))
        {
            obj = new TreeMap();
            ((Map) (obj)).put("token", uri);
            ((Map) (obj)).put("expiration", s);
            ((Map) (obj)).put("user_id", s1);
            ApiHttpClient.signedCall("login/secure/", "POST", ((Map) (obj)), new LoginResponseHandler(baseapiresponsehandler, (byte)0), null, null);
            return;
        } else
        {
            baseapiresponsehandler.onFailure(new InvalidParameterException(((Uri) (obj)).toString()), "");
            return;
        }
    }

    public static void a(SocialShareEvent socialshareevent, boolean flag)
    {
        String s = String.format("log/facebook/feed_share/%s/%s/%s", new Object[] {
            socialshareevent.getStrType(), socialshareevent.id, socialshareevent.fbRef
        });
        socialshareevent = s;
        if (!flag)
        {
            socialshareevent = (new StringBuilder()).append(s).append("?completed=0").toString();
        }
        b(socialshareevent, null, null);
    }

    public static void a(LoginParams loginparams, LoginApiResponse loginapiresponse)
    {
        String s;
        TreeMap treemap;
        s = "";
        treemap = new TreeMap();
        AnalyticsApi.a("login_attempt");
        Pinalytics.a(EventType.USER_LOGIN_ATTEMPT, null);
        loginparams.a();
        JVM INSTR tableswitch 0 5: default 68
    //                   0 101
    //                   1 120
    //                   2 151
    //                   3 241
    //                   4 196
    //                   5 310;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        loginparams = s;
_L9:
        ApiHttpClient.signedCall(String.format("login/%s", new Object[] {
            loginparams
        }), "POST", treemap, new LoginResponseHandler(loginapiresponse, (byte)0), null, null);
        return;
_L2:
        treemap.put("login_token", loginparams.a);
        loginparams = "token/";
        continue; /* Loop/switch isn't completed */
_L3:
        treemap.put("username_or_email", loginparams.b);
        treemap.put("password", loginparams.c);
        loginparams = s;
        continue; /* Loop/switch isn't completed */
_L4:
        treemap.put("twitter_id", loginparams.g);
        treemap.put("twitter_token", loginparams.d);
        treemap.put("twitter_token_secret", loginparams.e);
        loginparams = "twitter/";
        continue; /* Loop/switch isn't completed */
_L6:
        treemap.put("rakuten_id", loginparams.h);
        treemap.put("rakuten_token", loginparams.d);
        treemap.put("rakuten_refresh_token", loginparams.f);
        loginparams = "rakuten/";
        continue; /* Loop/switch isn't completed */
_L5:
        treemap.put("facebook_id", loginparams.k);
        treemap.put("facebook_token", loginparams.l);
        if (ModelHelper.isValid(loginparams.m))
        {
            treemap.put("facebook_scope", loginparams.m);
        } else
        {
            treemap.put("facebook_scope", "");
        }
        loginparams = "facebook/";
        continue; /* Loop/switch isn't completed */
_L7:
        treemap.put("gplus_id_token", loginparams.j);
        loginparams = "gplus/";
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void a(SignupParams signupparams, BaseApiResponseHandler baseapiresponsehandler)
    {
        String s;
        TreeMap treemap;
        s = "";
        treemap = new TreeMap();
        treemap.put("first_name", signupparams.o);
        if (StringUtils.isNotEmpty(signupparams.p))
        {
            treemap.put("last_name", signupparams.p);
        }
        treemap.put("gender", signupparams.r);
        treemap.put("email", signupparams.q);
        treemap.put("locale", Locale.getDefault().toString());
        if (signupparams.b != null)
        {
            treemap.put("username", signupparams.b);
        }
        if (signupparams.c != null)
        {
            treemap.put("password", signupparams.c);
        }
        if (signupparams.s != null)
        {
            treemap.put("invite_code", signupparams.s);
        }
        AnalyticsApi.a(FunnelActions.a(signupparams.a()));
        signupparams.a();
        JVM INSTR tableswitch 1 5: default 196
    //                   1 381
    //                   2 291
    //                   3 222
    //                   4 336
    //                   5 271;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        signupparams = s;
_L8:
        ApiHttpClient.signedCall(String.format("register/%s", new Object[] {
            signupparams
        }), "POST", treemap, baseapiresponsehandler, null, null);
        return;
_L4:
        treemap.put("facebook_id", signupparams.k);
        treemap.put("facebook_token", signupparams.l);
        treemap.put("facebook_timeline_enabled", a(signupparams.n));
        signupparams = "facebook/";
        continue; /* Loop/switch isn't completed */
_L6:
        treemap.put("one_time_code", signupparams.i);
        signupparams = "gplus/";
        continue; /* Loop/switch isn't completed */
_L3:
        treemap.put("twitter_id", signupparams.g);
        treemap.put("twitter_token", signupparams.d);
        treemap.put("twitter_token_secret", signupparams.e);
        signupparams = "twitter/";
        continue; /* Loop/switch isn't completed */
_L5:
        treemap.put("rakuten_id", signupparams.h);
        treemap.put("rakuten_token", signupparams.d);
        treemap.put("rakuten_refresh_token", signupparams.f);
        signupparams = "rakuten/";
        continue; /* Loop/switch isn't completed */
_L2:
        signupparams = "email/";
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void a(String s)
    {
        b(String.format("log/facebook/clickthrough/%s", new Object[] {
            s
        }), null, null);
    }

    public static void a(String s, ApiResponseHandler apiresponsehandler)
    {
        b("users/devices/%s/", s, apiresponsehandler, null);
    }

    public static void a(String s, BaseApiResponseHandler baseapiresponsehandler)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("email", s);
        ApiHttpClient.signedCall("login/email/suggestions/", "GET", treemap, baseapiresponsehandler, null, null);
    }

    public static void a(String s, String s1, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("old", s);
        requestparams.a("new", s1);
        requestparams.a("new_confirm", s1);
        c("users/password/", requestparams, baseapiresponsehandler, null);
    }

    public static void a(Map map, BaseApiResponseHandler baseapiresponsehandler)
    {
        ApiHttpClient.signedCall("users/password_reset/", "POST", map, baseapiresponsehandler, null, null);
    }

    public static String b()
    {
        String s1 = MyUser.getUid();
        String s = s1;
        if (s1 == null)
        {
            s = "0";
        }
        s1 = RandomStringUtils.randomAlphanumeric(20);
        return (new StringBuilder()).append(s).append(":").append(s1).toString();
    }

    public static void b(String s)
    {
        a(String.format("invite_code/%s/", new Object[] {
            s
        }), null, new _cls1(), null);
    }

    public static void b(String s, ApiResponseHandler apiresponsehandler)
    {
        c("users/devices/%s/", s, apiresponsehandler, null);
    }

    public static void b(String s, BaseApiResponseHandler baseapiresponsehandler)
    {
        TreeMap treemap = new TreeMap();
        treemap.put("username_or_email", s);
        try
        {
            ApiHttpClient.signedCall(String.format("users/forgot_password/", new Object[0]), "POST", treemap, baseapiresponsehandler, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static void c()
    {
        c("address_book/%s/", ApplicationInfo.getInstallId(), null, null);
    }

    public static void c(String s, BaseApiResponseHandler baseapiresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.a("contacts", s);
        a("address_book/%s/", ApplicationInfo.getInstallId(), requestparams, baseapiresponsehandler, null);
    }

    private class LoginResponseHandler extends BaseApiResponseHandler
    {

        private BaseApiResponseHandler a;

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            if (a != null)
            {
                a.onFailure(throwable, apiresponse);
            }
            a = null;
        }

        public final void onFinish()
        {
            if (a != null)
            {
                a.onFinish();
            }
        }

        public final void onStart()
        {
            if (a != null)
            {
                a.onStart();
            }
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            try
            {
                if (apiresponse.getData() != null)
                {
                    ApiClient.a(((PinterestJsonObject)apiresponse.getData()).a("access_token", ""));
                }
            }
            catch (Exception exception) { }
            if (a != null)
            {
                a.onSuccess(apiresponse);
            }
            a = null;
        }

        private LoginResponseHandler(BaseApiResponseHandler baseapiresponsehandler)
        {
            a = baseapiresponsehandler;
        }

        LoginResponseHandler(BaseApiResponseHandler baseapiresponsehandler, byte byte0)
        {
            this(baseapiresponsehandler);
        }
    }


    private class LoginParams
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public boolean n;

        public final int a()
        {
            if (g != null)
            {
                return 2;
            }
            if (h != null)
            {
                return 4;
            }
            if (k != null || m != null)
            {
                return 3;
            }
            if (i != null || j != null)
            {
                return 5;
            }
            return a == null ? 1 : 0;
        }

        public LoginParams()
        {
            n = false;
        }
    }


    private class SignupParams extends SocialConnectParams
    {
        private class SocialConnectParams extends LoginParams
        {

            public String u;
            public String v;

            public SocialConnectParams()
            {
            }
        }


        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public int t;

        public SignupParams()
        {
        }
    }


    private class _cls1 extends ApiResponseHandler
    {

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            if (apiresponse.getCode() == 820)
            {
                Events.post(new InviteCodeValidationResult(false));
            }
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            apiresponse = ((ApiResponse) (apiresponse.getData()));
            if (!(apiresponse instanceof PinterestJsonObject))
            {
                return;
            }
            boolean flag;
            if (!((PinterestJsonObject)apiresponse).a("is_accepted", Boolean.valueOf(false)).booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Events.post(new InviteCodeValidationResult(flag));
        }

        _cls1()
        {
        }

        private class InviteCodeValidationResult
        {

            private boolean a;

            public final boolean a()
            {
                return a;
            }

            public InviteCodeValidationResult(boolean flag)
            {
                a = flag;
            }
        }

    }

}
