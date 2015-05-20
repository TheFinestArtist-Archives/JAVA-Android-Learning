// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cv, cp, cj, cl

public final class cx extends cv
{

    private cj a;
    private cp b;
    private boolean c;
    private cl d;

    public cx(cj cj1, cp cp1)
    {
        this(cj1, cp1, false, null);
    }

    public cx(cj cj1, cp cp1, boolean flag, cl cl1)
    {
        a = cj1;
        b = cp1;
        c = flag;
        d = cl1;
    }

    private static JSONObject a(URLConnection urlconnection)
    {
        StringBuilder stringbuilder = new StringBuilder();
        urlconnection = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
        do
        {
            int i = urlconnection.read();
            if (i != -1)
            {
                stringbuilder.append((char)i);
            } else
            {
                urlconnection.close();
                return new JSONObject(stringbuilder.toString());
            }
        } while (true);
    }

    public final void a()
    {
        Object obj1 = null;
        Object obj;
        HttpURLConnection httpurlconnection;
        obj = b;
        httpurlconnection = (HttpURLConnection)((cp) (obj)).a.openConnection();
        for (Iterator iterator = ((cp) (obj)).b.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                httpurlconnection.addRequestProperty((String)entry.getKey(), s);
            }
        }

        httpurlconnection.setConnectTimeout(((cp) (obj)).h);
        httpurlconnection.setReadTimeout(((cp) (obj)).h);
        httpurlconnection.setDoInput(((cp) (obj)).d);
        httpurlconnection.setDoOutput(((cp) (obj)).e);
        if (((cp) (obj)).g)
        {
            httpurlconnection.setChunkedStreamingMode(((cp) (obj)).c);
        }
        httpurlconnection.setRequestMethod(((cp) (obj)).f);
        if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
        int i;
        obj = a;
        httpurlconnection.getOutputStream().write((new JSONObject(((cj) (obj)).a)).toString().getBytes("UTF8"));
        i = httpurlconnection.getResponseCode();
        if (!c) goto _L4; else goto _L3
_L3:
        obj = a(((URLConnection) (httpurlconnection)));
_L10:
        boolean flag = false;
_L5:
        httpurlconnection.disconnect();
        if (i >= 200 && i < 300 && obj != null)
        {
            (new StringBuilder("resp = ")).append(((JSONObject) (obj)).toString());
        }
        if (d != null)
        {
            d.a(flag, i, ((JSONObject) (obj)));
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        i = -1;
_L9:
        (new StringBuilder("UnsupportedEncodingException in proceed(): ")).append(((UnsupportedEncodingException) (obj)).getMessage());
        flag = false;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L8:
        (new StringBuilder("SocketTimeoutException in proceed(): ")).append(((SocketTimeoutException) (obj)).getMessage());
        flag = true;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L7:
        (new StringBuilder("IOException in proceed(): ")).append(((IOException) (obj)).getMessage());
        flag = false;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L6:
        (new StringBuilder("JSONException in proceed(): ")).append(((JSONException) (obj)).getMessage());
        flag = false;
        obj = obj1;
          goto _L5
        obj;
          goto _L6
        obj;
          goto _L7
        obj;
          goto _L8
        obj;
          goto _L9
_L4:
        obj = null;
        if (true) goto _L10; else goto _L2
        IOException ioexception;
        ioexception;
_L2:
    }
}
