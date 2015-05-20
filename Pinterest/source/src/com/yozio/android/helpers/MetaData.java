// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.yozio.android.YozioService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MetaData
{

    private static MetaData _yozioMetaData = new MetaData();

    private MetaData()
    {
    }

    public static MetaData getInstance()
    {
        return _yozioMetaData;
    }

    private HashMap getMetaDataFromAndroidDeeLinkRedirectUrl(Uri uri)
    {
        uri = uri.getQueryParameter("__ymd");
        if (uri == null)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "getMetaData from getMetaDataFromAndroidDeeLinkRedirectUrl - metaDataStr is null");
            return new HashMap();
        }
        uri = uri.trim();
        if (uri.length() == 0)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "getMetaData from getMetaDataFromAndroidDeeLinkRedirectUrl - metaDataStr is empty");
            return new HashMap();
        } else
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("getMetaData from getMetaDataFromAndroidDeeLinkRedirectUrl - metaDataStr is ")).append(uri).toString());
            return parseQueryStringToHashMap(uri);
        }
    }

    private HashMap getMetaDataFromCustomUrlScheme(Uri uri)
    {
        uri = uri.getFragment();
        if (uri == null)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "getMetaData from Custom Url Scheme - deeplinkFragment is null");
            return new HashMap();
        }
        String s = uri.trim();
        if (s.length() == 0)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "getMetaData from Custom Url Scheme - deeplinkFragment is empty");
            return new HashMap();
        }
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("getMetaData from Custom Url Scheme - deeplinkFragment is [")).append(s).append("]").toString());
        uri = new HashMap();
        String as[] = s.split(";");
        int j = as.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("getMetaData from Custom Url Scheme - metaData is ")).append(uri.toString()).toString());
                return uri;
            }
            String s1 = as[i];
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("getMetaData from Custom Url Scheme - pair is [")).append(s1).append("]").toString());
            if (s1.startsWith("S.") && !s1.startsWith("S.=") && s1.contains("="))
            {
                s1 = s1.replace("S.", "");
                int k = s1.indexOf("=");
                uri.put(s1.substring(0, k), s1.substring(k + 1));
            }
            i++;
        } while (true);
    }

    private HashMap parseQueryStringToHashMap(String s)
    {
        HashMap hashmap = new HashMap();
        if (s == null)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "parseQueryStringToHashMap - queryString is null.");
        } else
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("parseQueryStringToHashMap - queryString is ")).append(s).toString());
            s = s.trim();
            if (s.length() != 0)
            {
                s = s.split("&");
                int j = s.length;
                int i = 0;
                do
                {
                    if (i >= j)
                    {
                        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("parseQueryStringToHashMap - keyValuePairs is ")).append(hashmap.toString()).toString());
                        return hashmap;
                    }
                    String s1 = s[i];
                    int k = s1.indexOf("=");
                    if (k > 0)
                    {
                        hashmap.put(s1.substring(0, k), s1.substring(k + 1));
                    }
                    i++;
                } while (true);
            }
        }
        return hashmap;
    }

    public HashMap filterYozioSpecificParams(HashMap hashmap)
    {
        hashmap = new HashMap(hashmap);
        hashmap.remove("__ydl");
        hashmap.remove("__y");
        hashmap.remove("__yta");
        hashmap.remove("__ysurl");
        return hashmap;
    }

    public HashMap getInstallMetaDataAsHash(Context context)
    {
        HashMap hashmap = new HashMap();
        context = new File((new StringBuilder()).append(context.getFilesDir()).append(File.separator).append("Yozio").append(File.separator).append("MetaData.data").toString());
        if (!context.exists())
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "Meta data - no meta data file, start with empty meta data.");
            return hashmap;
        }
        try
        {
            context = new ObjectInputStream(new FileInputStream(context));
            hashmap = (HashMap)context.readObject();
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "Meta data - failed to read local meta data. Return empty hash.");
            context.printStackTrace();
            return new HashMap();
        }
        return hashmap;
    }

    public String getInstallMetaDataAsUrlParameterString(Context context)
    {
        HashMap hashmap;
        Iterator iterator;
        hashmap = getInstallMetaDataAsHash(context);
        iterator = hashmap.keySet().iterator();
        context = "";
_L2:
        String s;
        String s1;
        if (!iterator.hasNext())
        {
            return context;
        }
        s = (String)iterator.next();
        s1 = String.valueOf(hashmap.get(s));
        if (context.length() == 0)
        {
            context = (new StringBuilder(String.valueOf(URLEncoder.encode(s, "UTF-8")))).append("=").append(URLEncoder.encode(s1, "UTF-8")).toString();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            context = (new StringBuilder(String.valueOf(context))).append("&").append(URLEncoder.encode(s, "UTF-8")).append("=").append(URLEncoder.encode(s1, "UTF-8")).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("Meta data - error encode meta data into string: ")).append(context.getMessage()).toString());
            return "";
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public HashMap getMetaDataFromDeeplinkUrl(Intent intent)
    {
        intent = intent.getData();
        if (intent == null)
        {
            return new HashMap();
        }
        if (intent.getEncodedQuery() == null)
        {
            intent = getMetaDataFromCustomUrlScheme(intent);
        } else
        {
            intent = getMetaDataFromAndroidDeeLinkRedirectUrl(intent);
        }
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, (new StringBuilder("getMetaData from Deeplink Uri - metaData is ")).append(intent.toString()).toString());
        return intent;
    }

    public HashMap getMetaDataFromIntent(Intent intent)
    {
        HashMap hashmap = new HashMap();
        hashmap.putAll(getMetaDataFromIntentExtra(intent));
        hashmap.putAll(getMetaDataFromDeeplinkUrl(intent));
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.WARN, (new StringBuilder("getMetaDataFromIntent - metaData - ")).append(filterYozioSpecificParams(hashmap).toString()).toString());
        return filterYozioSpecificParams(hashmap);
    }

    public HashMap getMetaDataFromIntentExtra(Intent intent)
    {
        HashMap hashmap = new HashMap();
        intent = intent.getExtras();
        if (intent == null)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.WARN, "getMetaDataFromIntent - metaData is empty");
            return hashmap;
        }
        Iterator iterator = intent.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return hashmap;
            }
            String s = (String)iterator.next();
            hashmap.put(s, intent.getString(s));
        } while (true);
    }

    public HashMap getMetaDataFromNewInstallReferrerString(String s)
    {
        try
        {
            s = URLDecoder.decode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, (new StringBuilder("Unabled to decode referrer:")).append(s.getMessage()).toString());
            return new HashMap();
        }
        return parseQueryStringToHashMap(s);
    }

    public void persistInstallMetaData(Context context, HashMap hashmap)
    {
        YozioService.log(com.yozio.android.Constants.LOG_LEVEL.INFO, "MetaData - persist meta data locally.");
        context = new File((new StringBuilder()).append(context.getFilesDir()).append(File.separator).append("Yozio").append(File.separator).append("MetaData.data").toString());
        try
        {
            context = new ObjectOutputStream(new FileOutputStream(context));
            context.writeObject(hashmap);
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            YozioService.log(com.yozio.android.Constants.LOG_LEVEL.ERROR, "Meta data - failed to persist meta data locally.");
        }
        context.printStackTrace();
    }

}
