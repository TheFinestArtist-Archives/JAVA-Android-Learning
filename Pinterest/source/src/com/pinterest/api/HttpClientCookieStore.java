// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import android.content.Context;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.api:
//            PersistentCookieStore, ApiHttpClient

public class HttpClientCookieStore
    implements CookieStore
{

    private PersistentCookieStore a;

    public HttpClientCookieStore(Context context)
    {
        a = new PersistentCookieStore(context);
    }

    private static String b()
    {
        String s = ApiHttpClient.getBaseApiUrl().replace("%s", "");
        String s1;
        try
        {
            s1 = (new URI(s)).getHost();
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            return null;
        }
        s = s1;
        if (s1.startsWith("www."))
        {
            s = s1.substring(4);
        }
        return s;
    }

    public final String a(String s)
    {
        return a.a(s);
    }

    public final boolean a()
    {
        (new StringBuilder("#clearAllUserCookies size: ")).append(getCookies().size());
        Object obj = new ArrayList();
        String s = b();
        Iterator iterator = getCookies().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            HttpCookie httpcookie = (HttpCookie)iterator.next();
            String s1 = httpcookie.getName();
            String s2 = httpcookie.getDomain();
            (new StringBuilder("Iterating through cookie: ")).append(s1).append(" ").append(s2).append(" baseApi: ").append(s);
            if (s1.equals("_b") && s.endsWith(s2) && !httpcookie.hasExpired())
            {
                ((List) (obj)).add(httpcookie);
            } else
            {
                flag = true;
            }
        }
        a.removeAll();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); add(null, (HttpCookie)((Iterator) (obj)).next())) { }
        return flag;
    }

    public void add(URI uri, HttpCookie httpcookie)
    {
        a.add(uri, httpcookie);
    }

    public List get(URI uri)
    {
        return a.get(uri);
    }

    public List getCookies()
    {
        return a.getCookies();
    }

    public List getURIs()
    {
        return a.getURIs();
    }

    public boolean remove(URI uri, HttpCookie httpcookie)
    {
        return a.remove(uri, httpcookie);
    }

    public boolean removeAll()
    {
        return a();
    }
}
