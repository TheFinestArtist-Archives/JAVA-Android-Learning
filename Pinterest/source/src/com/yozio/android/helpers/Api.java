// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.helpers;

import android.content.Context;
import com.yozio.android.Yozio;
import com.yozio.android.YozioService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.yozio.android.helpers:
//            SystemInfo

public class Api
{

    private static Api _yozioApi = new Api();
    protected HttpClient _httpClient;

    private Api()
    {
    }

    public static Api getInstance()
    {
        return _yozioApi;
    }

    protected String doPostRequest(Context context, String s, List list, String s1)
    {
        HashMap hashmap = SystemInfo.getInstance().getSystemDictionary(context);
        Iterator iterator = hashmap.keySet().iterator();
_L5:
        boolean flag = iterator.hasNext();
        if (flag) goto _L2; else goto _L1
_L1:
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("YozioApi - ")).append(s1).append(": ").append(s).append(" - ").append(list.toString()).toString());
        s = new HttpPost(s);
        s.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        s.setHeader("User-Agent", SystemInfo.getInstance().getUserAgent(context));
        s = getHttpClient().execute(s);
        list = s.getEntity();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        context = EntityUtils.toString(list, "UTF-8");
        list.consumeContent();
_L8:
        int i = s.getStatusLine().getStatusCode();
        if (i < 400) goto _L4; else goto _L3
_L3:
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("YozioApi - ")).append(s1).append(" - Post http status: ").append(Integer.toString(i)).toString());
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("YozioApi - ")).append(s1).append(" - Post response: ").append(context).toString());
        return null;
_L2:
        String s2 = (String)iterator.next();
        list.add(new BasicNameValuePair(s2, String.valueOf(hashmap.get(s2))));
          goto _L5
        Exception exception;
        exception;
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, exception.getMessage());
          goto _L1
        context;
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("YozioApi - ")).append(s1).append(" - Post request: HttpException ").append(context.toString()).toString());
_L7:
        return null;
_L4:
        if (context == null) goto _L7; else goto _L6
_L6:
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("YozioApi - ")).append(s1).append(" - Post response: ").append(context).toString());
        return context;
        context = null;
          goto _L8
    }

    protected HttpClient getHttpClient()
    {
        if (_httpClient != null)
        {
            return _httpClient;
        } else
        {
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, Yozio.YOZIO_CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(basichttpparams, Yozio.YOZIO_SOCKET_TIMEOUT);
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            _httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
            return _httpClient;
        }
    }

    public boolean postEvents(Context context, JSONArray jsonarray)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("app_key", YozioService.getInstance().getAppKey(context)));
        linkedlist.add(new BasicNameValuePair("device_id", YozioService.getInstance().getDeviceId(context)));
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("system", new JSONObject(SystemInfo.getInstance().getSystemDictionary(context)));
            jsonobject.put("events", jsonarray);
            linkedlist.add(new BasicNameValuePair("body", jsonobject.toString()));
            context = doPostRequest(context, "http://e.yoz.io/", linkedlist, "postEvents");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("YozioApi - postEvents: json parse error - ")).append(context.toString()).toString());
            context.printStackTrace();
            return false;
        }
        if (context == null)
        {
            return false;
        }
        context = new JSONObject(context);
        if ("ok".equals(context.getString("status")))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("YozioApi - postEvents: response status - ")).append(context.getString("status")).toString());
        return false;
        return true;
    }

    public void trackAndroidAppInstallApi(Context context)
    {
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "YozioApi - trackAndroidAppInstallApi");
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("method", "sdk.app.install.android"));
        linkedlist.add(new BasicNameValuePair("app_key", YozioService.getInstance().getAppKey(context)));
        linkedlist.add(new BasicNameValuePair("device_id", YozioService.getInstance().getDeviceId(context)));
        doPostRequest(context, "http://api.yoz.io/", linkedlist, "sdkAppInstallAndroidApi");
    }

    public void trackAndroidAppInstallWithReferrerApi(Context context, String s)
    {
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "YozioApi - trackAndroidAppInstallWithReferrerApi");
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("method", "sdk.app.install.android.with.referrer"));
        linkedlist.add(new BasicNameValuePair("app_key", YozioService.getInstance().getAppKey(context)));
        linkedlist.add(new BasicNameValuePair("device_id", YozioService.getInstance().getDeviceId(context)));
        linkedlist.add(new BasicNameValuePair("referrer", s));
        doPostRequest(context, "http://api.yoz.io/", linkedlist, "sdkAppInstallAndroidWithReferrerApi");
    }

    public void trackYozioDeeplinkWithMetaDataApi(Context context, HashMap hashmap)
    {
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "YozioApi - trackYozioDeeplinkWithMetaDataApi");
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicNameValuePair("method", "sdk.app.deeplink.android"));
        linkedlist.add(new BasicNameValuePair("app_key", YozioService.getInstance().getAppKey(context)));
        linkedlist.add(new BasicNameValuePair("device_id", YozioService.getInstance().getDeviceId(context)));
        linkedlist.add(new BasicNameValuePair("__ymd", (new JSONObject(hashmap)).toString()));
        doPostRequest(context, "http://api.yoz.io/", linkedlist, "sdkAppDeeplinkAndroidApi");
    }

}
