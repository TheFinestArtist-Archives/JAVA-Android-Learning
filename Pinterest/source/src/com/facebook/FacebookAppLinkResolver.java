// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import bolts.AppLink;
import bolts.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            Request

public class FacebookAppLinkResolver
{

    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap cachedAppLinks = new HashMap();

    public FacebookAppLinkResolver()
    {
    }

    private static bolts.AppLink.Target getAndroidTargetFromJson(JSONObject jsonobject)
    {
        Object obj = null;
        String s = tryGetStringFromJson(jsonobject, "package", null);
        if (s == null)
        {
            return null;
        }
        String s1 = tryGetStringFromJson(jsonobject, "class", null);
        String s2 = tryGetStringFromJson(jsonobject, "app_name", null);
        String s3 = tryGetStringFromJson(jsonobject, "url", null);
        jsonobject = obj;
        if (s3 != null)
        {
            jsonobject = Uri.parse(s3);
        }
        return new bolts.AppLink.Target(s, s1, jsonobject, s2);
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jsonobject)
    {
        Object obj = null;
        jsonobject = jsonobject.getJSONObject("web");
        if (!tryGetBooleanFromJson(jsonobject, "should_fallback", true))
        {
            return null;
        }
        String s;
        try
        {
            s = tryGetStringFromJson(jsonobject, "url", null);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return uri;
        }
        jsonobject = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        jsonobject = Uri.parse(s);
label0:
        {
            if (jsonobject != null)
            {
                return jsonobject;
            }
            break label0;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jsonobject, String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = jsonobject.getBoolean(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return flag;
        }
        return flag1;
    }

    private static String tryGetStringFromJson(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return s1;
        }
        return jsonobject;
    }

    public Task getAppLinkFromUrlInBackground(final Uri uri)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(uri);
        return getAppLinkFromUrlsInBackground(arraylist).b(new _cls1());
    }

    public Task getAppLinkFromUrlsInBackground(final List taskCompletionSource)
    {
        final HashSet urisToRequest;
        StringBuilder stringbuilder;
        appLinkResults = new HashMap();
        urisToRequest = new HashSet();
        stringbuilder = new StringBuilder();
        for (Iterator iterator = taskCompletionSource.iterator(); iterator.hasNext();)
        {
            Uri uri = (Uri)iterator.next();
            AppLink applink;
            synchronized (cachedAppLinks)
            {
                applink = (AppLink)cachedAppLinks.get(uri);
            }
            if (applink != null)
            {
                ((Map) (appLinkResults)).put(uri, applink);
            } else
            {
                if (!urisToRequest.isEmpty())
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append(uri.toString());
                urisToRequest.add(uri);
            }
        }

        break MISSING_BLOCK_LABEL_138;
        appLinkResults;
        taskCompletionSource;
        JVM INSTR monitorexit ;
        throw appLinkResults;
        if (urisToRequest.isEmpty())
        {
            return Task.a(appLinkResults);
        } else
        {
            taskCompletionSource = Task.a();
            Bundle bundle = new Bundle();
            bundle.putString("ids", stringbuilder.toString());
            bundle.putString("fields", String.format("%s.fields(%s,%s)", new Object[] {
                "app_links", "android", "web"
            }));
            (new Request(null, "", bundle, null, new _cls2())).executeAsync();
            return taskCompletionSource.a();
        }
    }




    private class _cls1
        implements Continuation
    {

        final FacebookAppLinkResolver this$0;
        final Uri val$uri;

        public AppLink then(Task task)
        {
            return (AppLink)((Map)task.d()).get(uri);
        }

        public volatile Object then(Task task)
        {
            return then(task);
        }

        _cls1()
        {
            this$0 = FacebookAppLinkResolver.this;
            uri = uri1;
            super();
        }
    }


    private class _cls2
        implements Request.Callback
    {

        final FacebookAppLinkResolver this$0;
        final Map val$appLinkResults;
        final bolts.Task.TaskCompletionSource val$taskCompletionSource;
        final HashSet val$urisToRequest;

        public void onCompleted(Response response)
        {
            Object obj;
            obj = response.getError();
            if (obj != null)
            {
                taskCompletionSource.a(((FacebookRequestError) (obj)).getException());
                return;
            }
            response = response.getGraphObject();
            if (response != null)
            {
                response = response.getInnerJSONObject();
            } else
            {
                response = null;
            }
            if (response == null)
            {
                taskCompletionSource.a(appLinkResults);
                return;
            }
            obj = urisToRequest.iterator();
_L2:
            Uri uri;
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            uri = (Uri)((Iterator) (obj)).next();
            if (!response.has(uri.toString()))
            {
                continue; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject;
            Object obj1;
            ArrayList arraylist;
            int j;
            jsonobject = response.getJSONObject(uri.toString()).getJSONObject("app_links");
            obj1 = jsonobject.getJSONArray("android");
            j = ((JSONArray) (obj1)).length();
            arraylist = new ArrayList(j);
            JSONException jsonexception;
            bolts.AppLink.Target target;
            for (int i = 0; i >= j; i++)
            {
                break MISSING_BLOCK_LABEL_178;
            }

            target = FacebookAppLinkResolver.getAndroidTargetFromJson(((JSONArray) (obj1)).getJSONObject(i));
            if (target == null)
            {
                break MISSING_BLOCK_LABEL_263;
            }
            arraylist.add(target);
            break MISSING_BLOCK_LABEL_263;
            obj1 = new AppLink(uri, arraylist, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jsonobject));
            appLinkResults.put(uri, obj1);
            synchronized (cachedAppLinks)
            {
                cachedAppLinks.put(uri, obj1);
            }
            continue; /* Loop/switch isn't completed */
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (JSONException jsonexception) { }
            if (true) goto _L2; else goto _L1
_L1:
            taskCompletionSource.a(appLinkResults);
            return;
        }

        _cls2()
        {
            this$0 = FacebookAppLinkResolver.this;
            taskCompletionSource = taskcompletionsource;
            appLinkResults = map;
            urisToRequest = hashset;
            super();
        }
    }

}
