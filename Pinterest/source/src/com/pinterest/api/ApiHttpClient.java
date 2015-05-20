// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.pinterest.api:
//            OkHttpStack, HttpClientCookieStore, BaseApiResponseHandler, RequestParams, 
//            ByteApiResponseHandler, ByteRequest, ApiClientHelper, ImageApiResponseHandler, 
//            ApiClient, MultipartRequest, ApiResponseHandler

public class ApiHttpClient
{

    private static final String DEFAULT_DEV_BASE_API_URL = "https://api-ming.pinterdev.com/v3/%s";
    private static final String DEFAULT_DEV_BASE_LOGGING_API_URL = "https://api-ming.pinterdev.com/v3/%s";
    public static final String DELETE = "DELETE";
    public static final String GET = "GET";
    public static final String LONG_REQUEST_KEY = "long_request";
    public static final int MAX_REQUEST_TIMEOUT_IN_MS = 5000;
    private static String PINTEREST_DEV_DOMAIN = ".pinterdev.com";
    private static String PINTEREST_DOMAIN = ".pinterest.com";
    public static final String POST = "POST";
    public static final String PROD_BASE_API_URL = "https://api.pinterest.com/v3/%s";
    public static final String PROD_BASE_LOGGING_API_URL = "https://trk.pinterest.com/v3/%s";
    public static final String PUT = "PUT";
    public static final String TAG = "ApiHttpClient";
    public static final String VOLLEY_TAG = "VolleyRequestQueue";
    private static CookieManager _cookieManager;
    private static Map _headers;
    private static RequestQueue _requestQueue = Volley.newRequestQueue(Application.context(), new OkHttpStack());
    private static String baseApiUrl = "https://api.pinterest.com/v3/%s";
    private static String baseLoggingApiUrl = "https://trk.pinterest.com/v3/%s";

    public ApiHttpClient()
    {
    }

    public static void addHeader(String s, String s1)
    {
        Map map = getHeaders();
        String s2 = s1;
        if (StringUtils.isEmpty(s1))
        {
            s2 = "";
        }
        map.put(s, s2);
    }

    public static void addToRequestQueue(Request request, String s)
    {
        String s1 = s;
        if (StringUtils.isEmpty(s))
        {
            s1 = "VolleyRequestQueue";
        }
        request.setTag(s1);
        _requestQueue.add(request);
    }

    public static void cancelPendingRequests(Object obj)
    {
        _requestQueue.cancelAll(obj);
    }

    public static void clearUserCookies(Context context)
    {
        (new HttpClientCookieStore(context)).a();
    }

    public static Request delete(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return delete(s, baseapiresponsehandler, true, s1);
    }

    public static Request delete(String s, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "DELETE", getUrlWithQueryString(s, null));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        baseapiresponsehandler = new _cls5(baseapiresponsehandler, baseapiresponsehandler1, baseapiresponsehandler1, baseapiresponsehandler);
        baseapiresponsehandler.setShouldCache(false);
        addToRequestQueue(baseapiresponsehandler, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("DELETE ")).append(s).toString());
        return baseapiresponsehandler;
    }

    public static Request get(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return get(s, baseapiresponsehandler, true, s1);
    }

    public static Request get(String s, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        return get(s, baseapiresponsehandler, flag, false, false, null, s1);
    }

    public static Request get(String s, BaseApiResponseHandler baseapiresponsehandler, boolean flag, boolean flag1, boolean flag2, Map map, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "GET", getUrlWithQueryString(s, null));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        baseapiresponsehandler = new _cls1(baseapiresponsehandler, baseapiresponsehandler1, baseapiresponsehandler1, flag1, baseapiresponsehandler, map);
        if (flag2)
        {
            baseapiresponsehandler.setRetryPolicy(new DefaultRetryPolicy(5000, 1, 1.0F));
        }
        baseapiresponsehandler.setShouldCache(false);
        addToRequestQueue(baseapiresponsehandler, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("GET ")).append(s).toString());
        return baseapiresponsehandler;
    }

    public static Request get(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return get(s, requestparams, baseapiresponsehandler, true, null, s1);
    }

    public static Request get(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, boolean flag, Map map, String s1)
    {
        boolean flag1;
        if (requestparams != null && requestparams.b("long_request"))
        {
            requestparams.a("long_request");
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return get(getUrlWithQueryString(s, requestparams), baseapiresponsehandler, flag, false, flag1, map, s1);
    }

    public static String getAbsoluteApiUrl(String s)
    {
        return String.format(baseApiUrl, new Object[] {
            s
        });
    }

    public static String getAbsoluteLoggingApiUrl(String s)
    {
        return String.format(baseLoggingApiUrl, new Object[] {
            s
        });
    }

    private static Header[] getAppStateHeaders()
    {
        return (new Header[] {
            new BasicHeader("X-Pinterest-AppState", ApplicationInfo.getState().getApiHeader())
        });
    }

    public static String getBaseApiUrl()
    {
        return baseApiUrl;
    }

    public static String getBaseLoggingApiUrl()
    {
        return baseLoggingApiUrl;
    }

    public static Request getBinaryData(String s, ByteApiResponseHandler byteapiresponsehandler, boolean flag, boolean flag1, String s1)
    {
        ByteApiResponseHandler byteapiresponsehandler1 = byteapiresponsehandler;
        if (byteapiresponsehandler == null)
        {
            byteapiresponsehandler1 = new ByteApiResponseHandler();
        }
        byteapiresponsehandler1.b("GET");
        byteapiresponsehandler1.a(getUrlWithQueryString(s, null));
        Object obj;
        if (flag)
        {
            byteapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            byteapiresponsehandler = s;
        }
        if (flag1)
        {
            obj = new HashMap();
        } else
        {
            obj = getRequestHeaders(byteapiresponsehandler);
        }
        byteapiresponsehandler = new ByteRequest(byteapiresponsehandler, ((Map) (obj)), byteapiresponsehandler1);
        byteapiresponsehandler.setShouldCache(false);
        addToRequestQueue(byteapiresponsehandler, s1);
        byteapiresponsehandler1.a();
        log((new StringBuilder("GET ")).append(s).toString());
        return byteapiresponsehandler;
    }

    public static String getDevBaseApiUrl()
    {
        return Preferences.persisted().getString("PREF_DEV_BASE_API_URL", "https://api-ming.pinterdev.com/v3/%s");
    }

    public static String getDevBaseLoggingApiUrl()
    {
        return Preferences.persisted().getString("PREF_DEV_BASE_LOGGING_API_URL", "https://api-ming.pinterdev.com/v3/%s");
    }

    public static Map getHeaders()
    {
        if (_headers == null)
        {
            HashMap hashmap = new HashMap();
            _headers = hashmap;
            hashmap.put("User-Agent", ApiClientHelper.a());
            _headers.put("X-Pinterest-Device", Build.MODEL);
            _headers.put("X-Pinterest-InstallId", ApplicationInfo.getInstallId());
            if (ApplicationInfo.isNonProduction())
            {
                _headers.put("X-Pinterest-Enterprise", "1");
            }
        }
        _headers.put("Accept-Language", Locale.getDefault().toString());
        return _headers;
    }

    public static Request getImageData(String s, ImageApiResponseHandler imageapiresponsehandler, boolean flag, String s1)
    {
        ImageApiResponseHandler imageapiresponsehandler1 = imageapiresponsehandler;
        if (imageapiresponsehandler == null)
        {
            imageapiresponsehandler1 = new ImageApiResponseHandler();
        }
        imageapiresponsehandler1.setMethod("GET");
        imageapiresponsehandler1.setBaseUrl(getUrlWithQueryString(s, null));
        if (flag)
        {
            imageapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            imageapiresponsehandler = s;
        }
        imageapiresponsehandler = new _cls2(imageapiresponsehandler, imageapiresponsehandler1, imageapiresponsehandler1, imageapiresponsehandler);
        imageapiresponsehandler.setShouldCache(false);
        addToRequestQueue(imageapiresponsehandler, s1);
        log((new StringBuilder("GET ")).append(s).toString());
        return imageapiresponsehandler;
    }

    public static Map getRequestHeaders(String s)
    {
        Map map = getHeaders();
        map.put("X-Pinterest-AppState", ApplicationInfo.getState().getApiHeader());
        if (_cookieManager != null)
        {
            s = getValidSubDomain(s);
            if (StringUtils.isNotEmpty(s))
            {
                s = ((HttpClientCookieStore)_cookieManager.getCookieStore()).a(s);
                if (StringUtils.isNotEmpty(s))
                {
                    map.put("Cookie", s);
                }
            }
        }
        return map;
    }

    public static RequestQueue getRequestQueue()
    {
        return _requestQueue;
    }

    public static String getUrlWithQueryString(String s, RequestParams requestparams)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            String s1 = s.replace(" ", "%20");
            s = s1;
            if (requestparams != null)
            {
                requestparams = requestparams.c().trim();
                s = s1;
                if (!requestparams.equals(""))
                {
                    s = s1;
                    if (!requestparams.equals("?"))
                    {
                        StringBuilder stringbuilder = (new StringBuilder()).append(s1);
                        if (s1.contains("?"))
                        {
                            s = "&";
                        } else
                        {
                            s = "?";
                        }
                        s = stringbuilder.append(s).toString();
                        return (new StringBuilder()).append(s).append(requestparams).toString();
                    }
                }
            }
        }
        return s;
    }

    private static String getValidSubDomain(String s)
    {
        s = (new URI(s)).getHost();
        if (s.endsWith(PINTEREST_DOMAIN))
        {
            return PINTEREST_DOMAIN;
        }
        if (!s.endsWith(PINTEREST_DEV_DOMAIN))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s = PINTEREST_DEV_DOMAIN;
        return s;
        s;
        s.printStackTrace();
        return null;
    }

    public static void initCookieStore(Context context)
    {
        context = new HttpClientCookieStore(context);
        if (_cookieManager == null)
        {
            _cookieManager = new CookieManager(context, CookiePolicy.ACCEPT_ALL);
        }
        CookieHandler.setDefault(_cookieManager);
    }

    public static void log(String s)
    {
        if (ApiClient.a())
        {
            Log.i("BaseApi", s);
        }
    }

    public static void log(String s, String s1, RequestParams requestparams)
    {
        if (ApiClient.a())
        {
            String.format("Request{%s:%s&%s}", new Object[] {
                s, s1, String.valueOf(requestparams)
            });
        }
    }

    public static Request post(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return post(s, baseapiresponsehandler, true, s1);
    }

    public static Request post(String s, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "POST", getUrlWithQueryString(s, null));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        baseapiresponsehandler = new _cls3(baseapiresponsehandler, baseapiresponsehandler1, baseapiresponsehandler1, baseapiresponsehandler);
        baseapiresponsehandler.setShouldCache(false);
        addToRequestQueue(baseapiresponsehandler, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("POST ")).append(s).toString());
        return baseapiresponsehandler;
    }

    public static Request post(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return post(s, requestparams, baseapiresponsehandler, true, s1);
    }

    public static Request post(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "POST", getUrlWithQueryString(s, requestparams));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        requestparams = new MultipartRequest(1, baseapiresponsehandler, requestparams, getRequestHeaders(baseapiresponsehandler), baseapiresponsehandler1);
        requestparams.setShouldCache(false);
        addToRequestQueue(requestparams, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("POST ")).append(s).toString());
        return requestparams;
    }

    public static Request put(String s, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return put(s, baseapiresponsehandler, true, s1);
    }

    public static Request put(String s, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "PUT", getUrlWithQueryString(s, null));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        baseapiresponsehandler = new _cls4(baseapiresponsehandler, baseapiresponsehandler1, baseapiresponsehandler1, baseapiresponsehandler);
        baseapiresponsehandler.setShouldCache(false);
        addToRequestQueue(baseapiresponsehandler, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("PUT ")).append(s).toString());
        return baseapiresponsehandler;
    }

    public static Request put(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, String s1)
    {
        return put(s, requestparams, baseapiresponsehandler, true, s1);
    }

    public static Request put(String s, RequestParams requestparams, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s1)
    {
        BaseApiResponseHandler baseapiresponsehandler1 = setResponseHandler(baseapiresponsehandler, "PUT", getUrlWithQueryString(s, requestparams));
        if (flag)
        {
            baseapiresponsehandler = getAbsoluteApiUrl(s);
        } else
        {
            baseapiresponsehandler = s;
        }
        baseapiresponsehandler = new MultipartRequest(2, baseapiresponsehandler, requestparams, getRequestHeaders(baseapiresponsehandler), baseapiresponsehandler1);
        baseapiresponsehandler.setShouldCache(false);
        addToRequestQueue(baseapiresponsehandler, s1);
        baseapiresponsehandler1.onStart();
        log((new StringBuilder("PUT ")).append(s).append("&").append(requestparams).toString());
        return baseapiresponsehandler;
    }

    public static void setBaseApiUrl(String s)
    {
        baseApiUrl = s;
        if ("https://api.pinterest.com/v3/%s".equals(s))
        {
            return;
        } else
        {
            Preferences.persisted().set("PREF_DEV_BASE_API_URL", s);
            return;
        }
    }

    public static void setBaseLoggingApiUrl(String s)
    {
        baseLoggingApiUrl = s;
    }

    public static BaseApiResponseHandler setResponseHandler(BaseApiResponseHandler baseapiresponsehandler, String s, String s1)
    {
        Object obj = baseapiresponsehandler;
        if (baseapiresponsehandler == null)
        {
            obj = new ApiResponseHandler();
        }
        ((BaseApiResponseHandler) (obj)).setMethod(s);
        ((BaseApiResponseHandler) (obj)).setBaseUrl(s1);
        return ((BaseApiResponseHandler) (obj));
    }

    public static void signedCall(String s, String s1, Map map, BaseApiResponseHandler baseapiresponsehandler, Map map1, String s2)
    {
        signedCall(s, map1, s1, map, baseapiresponsehandler, true, s2);
    }

    public static void signedCall(String s, Map map, String s1, Map map1, BaseApiResponseHandler baseapiresponsehandler, boolean flag, String s2)
    {
        if (ApiClient.f() != null)
        {
            String s3 = s;
            if (flag)
            {
                s3 = getAbsoluteApiUrl(s);
            }
            String s4 = Long.toString(System.currentTimeMillis() / 1000L);
            s3 = String.format("%s?client_id=%s&timestamp=%s", new Object[] {
                s3, ApiClient.e(), s4
            });
            s = null;
            if (map1 != null)
            {
                s = new RequestParams(map1);
            } else
            {
                map1 = new TreeMap();
            }
            map1.put("timestamp", s4);
            map1.put("client_id", ApiClient.e());
            map1 = signedUrl(s1, s3, map1);
            if (s1.equals("POST"))
            {
                post(map1, s, baseapiresponsehandler, false, s2);
                return;
            }
            if (s1.equals("PUT"))
            {
                put(map1, s, baseapiresponsehandler, false, s2);
                return;
            }
            if (s1.equals("GET"))
            {
                get(map1, s, baseapiresponsehandler, false, map, s2);
                return;
            }
        }
    }

    private static String signedEncodeString(String s)
    {
        return URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("{", "%7B").replace("}", "%7D").replace("%7E", "~");
    }

    private static String signedUrl(String s, String s1, Map map)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s2;
        try
        {
            obj = URLEncoder.encode(s1.split("\\?")[0], "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception = s1;
        }
        obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(s).append("&");
        ((StringBuilder) (obj1)).append(((String) (obj))).append("&");
        s = map.keySet().iterator();
        if (!s.hasNext()) goto _L2; else goto _L1
_L1:
        obj = s.next();
        obj2 = map.get(obj);
        if (!(obj2 instanceof List)) goto _L4; else goto _L3
_L3:
        obj2 = ((List)obj2).iterator();
        while (((Iterator) (obj2)).hasNext()) 
        {
            s2 = (String)((Iterator) (obj2)).next();
            ((StringBuilder) (obj1)).append(obj).append("=").append(signedEncodeString(s2)).append("&");
        }
          goto _L5
_L4:
        try
        {
            ((StringBuilder) (obj1)).append(obj).append("=").append(signedEncodeString((String)obj2)).append("&");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashReporting.logHandledException(((Throwable) (obj)));
        }
_L5:
        if (false)
        {
            break MISSING_BLOCK_LABEL_201;
        } else
        {
            break MISSING_BLOCK_LABEL_63;
        }
_L2:
        map = ((StringBuilder) (obj1)).toString().substring(0, ((StringBuilder) (obj1)).length() - 1);
        s = "";
        obj = new SecretKeySpec(ApiClient.f().getBytes("UTF-8"), "HMACSHA256");
        obj1 = Mac.getInstance("HMACSHA256");
        ((Mac) (obj1)).init(((java.security.Key) (obj)));
        map = (new String(Hex.encodeHex(((Mac) (obj1)).doFinal(map.getBytes("UTF-8"))))).replace(" ", "").replace("<", "").replace(">", "");
        s = map;
_L7:
        return String.format("%s&%s", new Object[] {
            s1, String.format("oauth_signature=%s", new Object[] {
                s
            })
        });
        map;
        map.printStackTrace();
        if (true) goto _L7; else goto _L6
_L6:
    }


    private class _cls5 extends StringRequest
    {

        final String a;

        public final Map getHeaders()
        {
            return ApiHttpClient.getRequestHeaders(a);
        }

        public final Map getParams()
        {
            return new HashMap();
        }

        _cls5(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, String s1)
        {
            a = s1;
            super(3, s, listener, errorlistener);
        }
    }


    private class _cls1 extends StringRequest
    {

        final boolean a;
        final String b;
        final Map c;

        public final Map getHeaders()
        {
            Object obj;
            if (a)
            {
                obj = new HashMap();
            } else
            {
                obj = ApiHttpClient.getRequestHeaders(b);
            }
            if (c != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); ((Map) (obj)).put((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            return ((Map) (obj));
        }

        _cls1(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, boolean flag, String s1, Map map)
        {
            a = flag;
            b = s1;
            c = map;
            super(s, listener, errorlistener);
        }
    }


    private class _cls2 extends ImageRequest
    {

        final String a;

        public final Map getHeaders()
        {
            return ApiHttpClient.getRequestHeaders(a);
        }

        _cls2(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, String s1)
        {
            a = s1;
            super(s, listener, 0, 0, null, errorlistener);
        }
    }


    private class _cls3 extends StringRequest
    {

        final String a;

        public final Map getHeaders()
        {
            return ApiHttpClient.getRequestHeaders(a);
        }

        public final Map getParams()
        {
            return new HashMap();
        }

        _cls3(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, String s1)
        {
            a = s1;
            super(1, s, listener, errorlistener);
        }
    }


    private class _cls4 extends StringRequest
    {

        final String a;

        public final Map getHeaders()
        {
            return ApiHttpClient.getRequestHeaders(a);
        }

        public final Map getParams()
        {
            return new HashMap();
        }

        _cls4(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, String s1)
        {
            a = s1;
            super(2, s, listener, errorlistener);
        }
    }

}
