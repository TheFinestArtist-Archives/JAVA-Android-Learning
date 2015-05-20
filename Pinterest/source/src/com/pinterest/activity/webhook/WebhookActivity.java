// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.webhook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.create.PinItActivity;
import com.pinterest.activity.settings.dialog.CreateNewPasswordDialog;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.task.model.Sitemap;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Category;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.AccountApi;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.CategoryApi;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.api.remote.NetworkStoryApi;
import com.pinterest.api.remote.PinApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.activity.BaseActivity;
import com.pinterest.kit.log.PLog;
import com.pinterest.schemas.event.EventType;
import com.pinterest.schemas.event.ViewParameterType;
import com.pinterest.schemas.event.ViewType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

public class WebhookActivity extends BaseActivity
{

    private static Set ALLOWED_SHORTCUT = new _cls1();
    public static final String SOURCE_CLIENT_NOTIF = "CLIENT_NOTIF";
    public static final String SOURCE_OTHERS = "OTHERS";
    public static final String SOURCE_PULL_NOTIF = "PULL_NOTIF";
    public static final String SOURCE_PUSH_NOTIF = "PUSH_NOTIF";
    public static final String SOURCE_WIDGET = "HOME_WIDGET";
    public static final String URL_PREFIX_ACTION_NOTIFICATION = "http://www.pinterest.com";
    private EventType _deepLinkScheme;
    private boolean _isOcf;

    public WebhookActivity()
    {
        _deepLinkScheme = EventType.DEEP_LINK_HTTP;
        _isOcf = false;
    }

    private void doAutoLogin(final Uri uri)
    {
        AccountApi.a(uri, new _cls8());
    }

    private String getInterestNameOrId(String s)
    {
        String as[] = s.split("-");
        if (as.length >= 2) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        String s1;
        s1 = as[as.length - 1];
        int j = s1.length();
        if (j >= 12)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    if (!Character.isDigit(s1.charAt(i)))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return s1;
    }

    private void getScheme(Uri uri)
    {
        if ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()))
        {
            _deepLinkScheme = EventType.DEEP_LINK_HTTP;
            return;
        }
        if ("pinterest".equalsIgnoreCase(uri.getScheme()))
        {
            _deepLinkScheme = EventType.DEEP_LINK_PINTEREST;
            return;
        } else
        {
            _deepLinkScheme = EventType.DEEP_LINK_OTHER;
            return;
        }
    }

    private void goHomeAndFinish()
    {
        trackAction("home");
        ActivityHelper.goHome(this);
        finish();
    }

    private void goNavigationAndFinish(Navigation navigation)
    {
        startActivity(ActivityHelper.getTaskIntent(this, navigation));
        finish();
    }

    private void goSplash()
    {
        ActivityHelper.goSplash(this);
        finish();
    }

    private boolean handleConversation(ArrayList arraylist)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (arraylist.size() >= 2)
        {
            flag = flag1;
            if ("conversation".equals(arraylist.get(0)))
            {
                arraylist = (String)arraylist.get(1);
                if (ModelHelper.isValid(arraylist))
                {
                    goNavigationAndFinish(new Navigation(Location.CONVERSATION, arraylist));
                }
                finish();
                flag = true;
            }
        }
        return flag;
    }

    private boolean handleInterestAndCategory(ArrayList arraylist)
    {
        String s;
        if (arraylist == null || arraylist.size() < 2 || !"explore".equals(arraylist.get(0)) && !"categories".equals(arraylist.get(0)))
        {
            return false;
        }
        s = (String)arraylist.get(1);
        if (!"explore".equals(arraylist.get(0))) goto _L2; else goto _L1
_L1:
        InterestsApi.a(getInterestNameOrId(s), new _cls3(true), getApiTag());
_L4:
        return true;
_L2:
        if ("categories".equals(arraylist.get(0)))
        {
            arraylist = ModelHelper.getCategory(s);
            if (arraylist != null)
            {
                showCategory(arraylist);
            } else
            {
                CategoryApi.a(new _cls4(true, s), getApiTag());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean handleInvite(List list, Uri uri)
    {
        if (list.size() <= 0 || !((String)list.get(0)).equals("invited"))
        {
            return false;
        } else
        {
            Experiments.r();
            AccountApi.b(uri.getQueryParameter("invite_code"));
            ActivityHelper.goSplashSignup(this, false, uri.toString());
            finish();
            return true;
        }
    }

    private boolean handleNewPassword(List list, Uri uri)
    {
        if (list.size() < 2 || !((String)list.get(0)).equals("pw"))
        {
            return false;
        } else
        {
            TreeMap treemap = new TreeMap();
            treemap.put("username", list.get(1));
            treemap.put("expiration", uri.getQueryParameter("e"));
            treemap.put("token", uri.getQueryParameter("t"));
            CreateNewPasswordDialog.show(treemap);
            return true;
        }
    }

    private boolean handleNews(ArrayList arraylist)
    {
        if (arraylist.size() >= 2 && "news".equals(arraylist.get(0)))
        {
            if (!MyUser.hasAccessToken())
            {
                goHomeAndFinish();
                return true;
            }
            arraylist = (String)arraylist.get(1);
            if (!ModelHelper.isValid(arraylist))
            {
                return false;
            } else
            {
                NetworkStoryApi.a(arraylist, new _cls2(), getApiTag());
                return true;
            }
        } else
        {
            return false;
        }
    }

    private boolean handlePinPick(Uri uri, ArrayList arraylist)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (arraylist.size() >= 2)
        {
            flag = flag1;
            if ("pinpicks".equals(arraylist.get(0)))
            {
                goNavigationAndFinish(new Navigation(Location.PIN_PICKS, uri.getPath()));
                flag = true;
            }
        }
        return flag;
    }

    private boolean handleSearch(Uri uri, ArrayList arraylist)
    {
        if (arraylist.size() == 1 && "search".equals(arraylist.get(0)) && uri.getQueryParameter("q") != null)
        {
            goNavigationAndFinish(new Navigation(Location.SEARCH_PIN, uri.getQueryParameter("q")));
            return true;
        } else
        {
            return false;
        }
    }

    private boolean handleSitemapLink(ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() != 1)
        {
            return false;
        }
        arraylist = Sitemap.getLocation((String)arraylist.get(0));
        if (arraylist == null)
        {
            return false;
        } else
        {
            ActivityHelper.goTask(this, new Navigation(arraylist));
            finish();
            return true;
        }
    }

    public static boolean isAllowedHost(String s)
    {
        return s != null && (s.equalsIgnoreCase("pinterest.com") || s.endsWith(".pinterest.com") || s.endsWith(".pinterdev.com"));
    }

    private boolean isAllowedLink(Uri uri)
    {
        String s;
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if (uri == null)
        {
            return false;
        }
        s = uri.getScheme();
        uri = uri.getHost();
        if (!"pinit".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if ("pinterest".equalsIgnoreCase(s))
        {
            if (!isAllowedShortCut(uri))
            {
                flag = flag1;
                if (!isAllowedHost(uri))
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            flag = true;
        } else
        {
            flag = isAllowedHost(uri);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isAllowedShortCut(String s)
    {
        return s != null && !s.contains(".");
    }

    private void loadBoard(Uri uri, List list)
    {
        String s;
        if (list.size() == 1)
        {
            s = (String)list.get(0);
        } else
        {
            s = String.format("%s/%s", new Object[] {
                list.get(0), list.get(1)
            });
        }
        BoardApi.a(s, MyUser.hasAccessToken(), new _cls7(list), getApiTag());
    }

    private void loadPin(Uri uri, List list, boolean flag)
    {
        try
        {
            list = new ArrayList(list);
            if (TextUtils.equals((CharSequence)list.get(0), "pin"))
            {
                list.remove(0);
            }
            String s = (String)list.get(0);
            trackShareRef(uri);
            Pinalytics.a(_deepLinkScheme, s);
            PinApi.a(s, flag, new _cls5(list), getApiTag());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            Application.showToast(0x7f0e0363);
        }
        finish();
    }

    private void loadUser(Uri uri, List list)
    {
        UserApi.a((String)list.get(0), new _cls6(uri), getApiTag());
    }

    public static void openLink(Context context, String s)
    {
        String s1 = "";
        if (!StringUtils.isEmpty(s))
        {
            if (s.charAt(0) == '/')
            {
                s1 = (new StringBuilder("http://www.pinterest.com")).append(s).toString();
            } else
            {
                s1 = (new StringBuilder("http://www.pinterest.com/")).append(s).toString();
            }
        }
        s = ActivityHelper.getWebhook(context);
        s.setData(Uri.parse(s1));
        context.startActivity(s);
    }

    private void setDeepLinkSource()
    {
        Object obj;
        String s;
        try
        {
            obj = getIntent().getStringExtra("com.pinterest.EXTRA_SOURCE");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashReporting.logHandledException(((Throwable) (obj)));
            obj = null;
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = "OTHERS";
        }
        if (s == "PULL_NOTIF")
        {
            obj = EventType.PULL_NOTIFICATION_OPENED_BY;
        } else
        {
            obj = EventType.PUSH_NOTIFICATION_OPENED_BY;
        }
        Pinalytics.a(((EventType) (obj)), ApplicationInfo.getInstallId());
        if ("PUSH_NOTIF".equals(s))
        {
            AnalyticsApi.a("opened", getIntent().getExtras());
        }
    }

    public static boolean shouldHandleInWebView(String s)
    {
        if (isAllowedHost(s) && !s.equalsIgnoreCase("pinterest.com"))
        {
            s = s.split("\\.");
            if (s.length != 3 || !s[0].equalsIgnoreCase("www") && s[0].length() != 2)
            {
                trackAction("webview");
                return true;
            }
        }
        return false;
    }

    private void showCategory(Category category)
    {
        goNavigationAndFinish(new Navigation(Location.CATEGORY, category));
    }

    private static void trackAction(String s)
    {
        AnalyticsApi.a((new StringBuilder("DL_")).append(s).toString());
    }

    private void trackShareRef(Uri uri)
    {
        String s1 = uri.getQueryParameter("fb_ref");
        String s = s1;
        if (s1 == null)
        {
            uri = uri.getQueryParameter("target_url");
            s = s1;
            if (uri != null)
            {
                uri = uri.split("fb_ref=");
                s = s1;
                if (uri.length > 1)
                {
                    s = uri[1].split("&")[0].replace("%3A", ":");
                }
            }
        }
        if (s != null)
        {
            AccountApi.a(s);
        }
    }

    protected void init(Uri uri)
    {
        ArrayList arraylist;
        Object obj3;
        boolean flag1;
        setDeepLinkSource();
        showWaitDialog(0x7f0e02c4);
        trackAction("start");
        if (!isAllowedLink(uri))
        {
            finish();
            return;
        }
        PLog.a("WebhookActivity: %s", new Object[] {
            uri
        });
        getScheme(uri);
        flag1 = MyUser.hasAccessTokenAndUser();
        arraylist = new ArrayList(uri.getPathSegments());
        obj3 = uri.getQueryParameterNames();
        if (obj3 == null || !((Set) (obj3)).contains("utm_source") || !((Set) (obj3)).contains("utm_medium")) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s;
        s = uri.getQueryParameter("utm_content");
        obj = uri.getQueryParameter("utm_source");
        obj1 = uri.getQueryParameter("utm_medium");
        obj = ViewType.findByValue(Integer.parseInt(((String) (obj))));
        Object obj2 = ViewParameterType.findByValue(Integer.parseInt(((String) (obj1))));
        obj1 = obj;
        obj = obj2;
_L9:
        if (obj1 == null || obj == null) goto _L2; else goto _L3
_L3:
        obj2 = new HashMap();
        obj3 = ((Set) (obj3)).iterator();
_L8:
        if (!((Iterator) (obj3)).hasNext()) goto _L5; else goto _L4
_L4:
        String s1 = (String)((Iterator) (obj3)).next();
        if (!s1.startsWith("cl_")) goto _L7; else goto _L6
_L6:
        ((HashMap) (obj2)).put(s1.replaceFirst("cl_", ""), uri.getQueryParameter(s1));
          goto _L8
        obj;
        obj = null;
_L17:
        obj2 = null;
        obj1 = obj;
        obj = obj2;
          goto _L9
_L7:
        if (!s1.startsWith("utm_")) goto _L8; else goto _L10
_L10:
        ((HashMap) (obj2)).put(s1, uri.getQueryParameter(s1));
          goto _L8
_L5:
        try
        {
            Pinalytics.a(EventType.SERVICE_ENTRY, s, ((ViewType) (obj1)), ((ViewParameterType) (obj)), ((HashMap) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashReporting.logHandledException(((Throwable) (obj)));
        }
_L2:
        if (arraylist.contains("secure"))
        {
            if (arraylist.contains("login"))
            {
                if (!flag1)
                {
                    try
                    {
                        doAutoLogin(uri);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        uri.printStackTrace();
                        goHomeAndFinish();
                    }
                } else
                {
                    obj = uri.getQueryParameter("next");
                    if (StringUtils.isNotEmpty(((CharSequence) (obj))))
                    {
                        uri = ((Uri) (obj));
                        if (!((String) (obj)).contains("//pinterest.com"))
                        {
                            uri = (new StringBuilder("http://pinterest.com")).append(((String) (obj))).toString();
                        }
                        uri = Uri.parse(uri);
                        if (uri != null)
                        {
                            init(uri);
                            return;
                        }
                    }
                    goHomeAndFinish();
                }
            } else
            {
                ActivityHelper.goWebView(this, uri, null);
                finish();
            }
            trackAction("secure");
            return;
        }
        if (handleNewPassword(arraylist, uri))
        {
            trackAction("pw");
            return;
        }
        if (handleSitemapLink(arraylist))
        {
            trackAction("sitemap");
            return;
        }
        if (handleInvite(arraylist, uri))
        {
            trackAction("invited");
            return;
        }
        obj2 = uri.getHost();
        if (shouldHandleInWebView(((String) (obj2))))
        {
            ActivityHelper.goWebView(this, uri, null);
            finish();
            return;
        }
        obj1 = obj2;
        obj = uri;
        if ("pinterest".equals(uri.getScheme())) goto _L12; else goto _L11
_L11:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_626;
        }
        if (!((String) (obj2)).equals("http")) goto _L14; else goto _L13
_L13:
        obj = Uri.parse(uri.toString().replace("http://", ""));
        obj1 = ((Uri) (obj)).getHost();
_L12:
        if (((String) (obj1)).contains("facebook"))
        {
            trackAction("facebook");
            if (!flag1)
            {
                goSplash();
                finish();
                return;
            } else
            {
                goHomeAndFinish();
                return;
            }
        }
        break MISSING_BLOCK_LABEL_636;
_L14:
        obj1 = obj2;
        obj = uri;
        if (((String) (obj2)).length() <= 0) goto _L12; else goto _L15
_L15:
        obj1 = obj2;
        obj = uri;
        if (((String) (obj2)).contains("pinterest")) goto _L12; else goto _L16
_L16:
        goHomeAndFinish();
        ActivityHelper.goIntentView(this, uri);
        return;
        goHomeAndFinish();
        return;
        uri = ((Uri) (obj)).getQueryParameter("url");
        if (ModelHelper.isValid(uri))
        {
            trackAction("redirect");
            if (!flag1)
            {
                goSplash();
                return;
            }
            if (((String) (obj1)).contains("pinit") || arraylist.contains("pinit") || arraylist.contains("pin"))
            {
                obj1 = ((Uri) (obj)).getQueryParameter("description");
                obj = ((Uri) (obj)).getQueryParameter("media");
                Intent intent = new Intent(this, com/pinterest/activity/create/PinItActivity);
                intent.putExtra("android.intent.extra.TEXT", uri);
                if (ModelHelper.isValid(obj1))
                {
                    intent.putExtra("com.pinterest.EXTRA_DESCRIPTION", ((String) (obj1)));
                }
                if (ModelHelper.isValid(obj))
                {
                    intent.putExtra("com.pinterest.EXTRA_IMAGE", ((String) (obj)));
                }
                startActivity(intent);
                finish();
                return;
            }
            if (arraylist.contains("offsite"))
            {
                ActivityHelper.gotoBrowser(this, uri);
                return;
            }
        }
        if (((String) (obj1)).equalsIgnoreCase("board") && arraylist.size() == 1)
        {
            loadBoard(((Uri) (obj)), arraylist);
            trackAction("board");
            return;
        }
        if (((String) (obj1)).equalsIgnoreCase("user") && arraylist.size() == 1)
        {
            loadUser(((Uri) (obj)), arraylist);
            trackAction("user");
            return;
        }
        if (((String) (obj1)).equalsIgnoreCase("pin") && arraylist.size() > 0)
        {
            loadPin(((Uri) (obj)), arraylist, flag1);
            trackAction("pin");
            return;
        }
        if (handleSearch(((Uri) (obj)), arraylist))
        {
            trackAction("search");
            return;
        }
        if (handlePinPick(((Uri) (obj)), arraylist))
        {
            trackAction("pinpick");
            return;
        }
        if (handleConversation(arraylist))
        {
            trackAction("conversation");
            return;
        }
        if (handleNews(arraylist))
        {
            trackAction("news");
            return;
        }
        if (handleInterestAndCategory(arraylist))
        {
            trackAction("categories");
            return;
        }
        NumberFormatException numberformatexception;
        boolean flag;
        if (arraylist.size() >= 2 && "follow".equalsIgnoreCase((String)arraylist.get(0)))
        {
            arraylist.remove(0);
            flag = true;
        } else
        {
            flag = false;
        }
        if (arraylist.contains("pin"))
        {
            trackAction("pin");
            if (arraylist.size() >= 2)
            {
                loadPin(((Uri) (obj)), arraylist, flag1);
                return;
            } else
            {
                goHomeAndFinish();
                return;
            }
        }
        if (arraylist.size() == 1 && ((String)arraylist.get(0)).equalsIgnoreCase("about"))
        {
            ActivityHelper.gotoBrowser(this, ((Uri) (obj)));
            trackAction("about");
            return;
        }
        if (arraylist.size() == 1)
        {
            _isOcf = flag;
            loadUser(((Uri) (obj)), arraylist);
            trackAction("user");
            return;
        }
        if (arraylist.size() == 2)
        {
            _isOcf = flag;
            loadBoard(((Uri) (obj)), arraylist);
            if (!flag1)
            {
                MyUserApi.a(new com.pinterest.api.remote.MyUserApi.BoardInviteFeedResponse(), getApiTag());
            }
            trackAction("board");
            return;
        } else
        {
            ActivityHelper.gotoBrowser(this, ((Uri) (obj)));
            trackAction("others");
            return;
        }
        numberformatexception;
          goto _L17
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        init(getIntent().getData());
    }







/*
    static boolean access$402(WebhookActivity webhookactivity, boolean flag)
    {
        webhookactivity._isOcf = flag;
        return flag;
    }

*/



    private class _cls8 extends BaseApiResponseHandler
    {

        final WebhookActivity this$0;
        final Uri val$uri;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            CrashReporting.logHandledException(throwable);
            goHomeAndFinish();
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            apiresponse = (PinterestJsonObject)apiresponse.getData();
            if (apiresponse == null)
            {
                class _cls1 extends com.pinterest.api.remote.MyUserApi.MyUserApiResponse
                {

                    final _cls8 this$1;

                    public void onFailure(Throwable throwable, ApiResponse apiresponse1)
                    {
                        super.onFailure(throwable, apiresponse1);
                        goHomeAndFinish();
                    }

                    public void onSuccess(User user)
                    {
                        super.onSuccess(user);
                        user = uri.getQueryParameter("next");
                        if (StringUtils.isNotEmpty(user))
                        {
                            user = Uri.parse(user);
                            if (user != null)
                            {
                                init(user);
                                return;
                            }
                        }
                        goHomeAndFinish();
                    }

                _cls1()
                {
                    this$1 = _cls8.this;
                    super();
                }
                }

                try
                {
                    onFailure(new Throwable(""), new PinterestJsonObject());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ApiResponse apiresponse)
                {
                    onFailure(new Throwable(""), new PinterestJsonObject());
                }
                break MISSING_BLOCK_LABEL_96;
            }
            MyUser.setAccessToken(apiresponse.a("access_token", ""));
            MyUserApi.a(new _cls1(), getApiTag());
            PWidgetHelper.notifyWidgetStateChange(WebhookActivity.this);
            return;
        }

        _cls8()
        {
            this$0 = WebhookActivity.this;
            uri = uri1;
            super();
        }
    }


    private class _cls3 extends com.pinterest.api.remote.InterestsApi.InterestApiResponseHandler
    {

        final WebhookActivity this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            goHomeAndFinish();
        }

        public void onSuccess(Interest interest)
        {
            if (interest != null)
            {
                interest = new Navigation(Location.INTEREST, interest);
                goNavigationAndFinish(interest);
            }
            finish();
        }

        _cls3(boolean flag)
        {
            this$0 = WebhookActivity.this;
            super(flag);
        }
    }


    private class _cls4 extends com.pinterest.api.remote.CategoryApi.CategoriesFeedApiResponse
    {

        final WebhookActivity this$0;
        final String val$name;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            goHomeAndFinish();
        }

        public void onSuccess(Feed feed)
        {
            super.onSuccess(feed);
            feed = ModelHelper.getCategory(name);
            if (feed != null)
            {
                showCategory(feed);
            }
            finish();
        }

        _cls4(boolean flag1, String s)
        {
            this$0 = WebhookActivity.this;
            name = s;
            super(final_flag, flag1);
        }
    }


    private class _cls2 extends ApiResponseHandler
    {

        final WebhookActivity this$0;

        private void doOnError()
        {
            goHomeAndFinish();
        }

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            doOnError();
        }

        public void onSuccess(final PinterestJsonObject response)
        {
            super.onSuccess(response);
            class _cls1 extends BackgroundTask
            {

                final _cls2 this$1;
                final PinterestJsonObject val$response;

                public void run()
                {
                    Object obj;
                    obj = response.c("data");
                    if (obj == null)
                    {
                        doOnError();
                        return;
                    }
                    obj = Story.make(((PinterestJsonObject) (obj)));
                    int i;
                    if (obj == null)
                    {
                        i = -1;
                    } else
                    {
                        i = ((Story) (obj)).getMainObjectType().intValue();
                    }
                    i;
                    JVM INSTR tableswitch 0 2: default 60
                //                               0 79
                //                               1 103
                //                               2 118;
                       goto _L1 _L2 _L3 _L4
_L1:
                    doOnError();
                    return;
_L2:
                    obj = new Navigation(Location.STORY_PINS, ((com.pinterest.api.model.Model) (obj)));
_L6:
                    goNavigationAndFinish(((Navigation) (obj)));
                    return;
_L3:
                    obj = new Navigation(Location.STORY_BOARDS, ((com.pinterest.api.model.Model) (obj)));
                    continue; /* Loop/switch isn't completed */
_L4:
                    obj = new Navigation(Location.STORY_USERS, ((com.pinterest.api.model.Model) (obj)));
                    if (true) goto _L6; else goto _L5
_L5:
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    response = pinterestjsonobject;
                    super();
                }
            }

            (new _cls1()).execute();
        }


        _cls2()
        {
            this$0 = WebhookActivity.this;
            super();
        }
    }


    private class _cls7 extends com.pinterest.api.remote.BoardApi.BoardApiResponse
    {

        final WebhookActivity this$0;
        final List val$segments;
        final Uri val$uri;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            if (!Device.hasInternet())
            {
                super.onFailure(throwable, apiresponse);
                finish();
                return;
            } else
            {
                loadUser(uri, segments);
                return;
            }
        }

        public void onFinish()
        {
        }

        public void onSuccess(Board board)
        {
            super.onSuccess(board);
            if (board != null)
            {
                board = new Navigation(Location.BOARD, board);
                Intent intent = ActivityHelper.getHomeIntent(WebhookActivity.this);
                intent.putExtra("com.pinterest.EXTRA_PENDING_TASK", board);
                OcfUtils.addOcfFlag(intent, _isOcf);
                _isOcf = false;
                startActivity(intent);
            }
            finish();
        }

        _cls7(List list)
        {
            this$0 = WebhookActivity.this;
            uri = uri1;
            segments = list;
            super(final_flag);
        }
    }


    private class _cls5 extends com.pinterest.api.remote.PinApi.PinApiResponse
    {

        final WebhookActivity this$0;
        final boolean val$isAuthenticated;
        final List val$segmentsCopy;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            finish();
        }

        public void onSuccess(Pin pin)
        {
            super.onSuccess(pin);
            if (isAuthenticated && segmentsCopy.contains("repin"))
            {
                Intent intent = ActivityHelper.getRepinDialogIntent(WebhookActivity.this);
                intent.putExtra("com.pinterest.EXTRA_PIN_ID", pin.getUid());
                pin = intent;
            } else
            {
                pin = new Navigation(Location.PIN, pin);
                pin = ActivityHelper.getTaskIntent(WebhookActivity.this, pin);
            }
            startActivity(pin);
            finish();
        }

        _cls5(List list)
        {
            this$0 = WebhookActivity.this;
            isAuthenticated = flag1;
            segmentsCopy = list;
            super(final_flag);
        }
    }


    private class _cls6 extends com.pinterest.api.remote.UserApi.UserApiResponse
    {

        final WebhookActivity this$0;
        final Uri val$uri;

        public void onFailure(Throwable throwable, PinterestJsonObject pinterestjsonobject)
        {
            if (!Device.hasInternet())
            {
                super.onFailure(throwable, pinterestjsonobject);
                finish();
                return;
            }
            throwable = uri;
            if (uri.getScheme().equalsIgnoreCase("pinterest"))
            {
                throwable = Uri.parse(uri.toString().replaceFirst("pinterest", "https"));
            }
            ActivityHelper.gotoBrowser(WebhookActivity.this, throwable);
        }

        public void onSuccess(User user)
        {
            super.onSuccess(user);
            user = new Navigation(Location.USER, user);
            Intent intent = ActivityHelper.getHomeIntent(WebhookActivity.this);
            intent.putExtra("com.pinterest.EXTRA_PENDING_TASK", user);
            OcfUtils.addOcfFlag(intent, _isOcf);
            _isOcf = false;
            startActivity(intent);
            finish();
        }

        _cls6(Uri uri1)
        {
            this$0 = WebhookActivity.this;
            uri = uri1;
            super(final_flag);
        }
    }


    private class _cls1 extends HashSet
    {

        _cls1()
        {
            add("user");
            add("board");
            add("pin");
            add("conversation");
        }
    }

}
