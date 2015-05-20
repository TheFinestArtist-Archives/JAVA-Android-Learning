// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HeaderParser

public final class OkHeaders
{

    static final String a = Platform.b();
    public static final String b = (new StringBuilder()).append(a).append("-Sent-Millis").toString();
    public static final String c = (new StringBuilder()).append(a).append("-Received-Millis").toString();
    public static final String d = (new StringBuilder()).append(a).append("-Selected-Protocol").toString();
    private static final Comparator e = new _cls1();

    private static long a(Headers headers)
    {
        return b(headers.a("Content-Length"));
    }

    public static long a(Request request)
    {
        return a(request.e());
    }

    public static long a(Response response)
    {
        return a(response.f());
    }

    public static Request a(Authenticator authenticator, Response response, Proxy proxy)
    {
        if (response.c() == 407)
        {
            return authenticator.authenticateProxy(proxy, response);
        } else
        {
            return authenticator.authenticate(proxy, response);
        }
    }

    public static Map a(Headers headers, String s)
    {
        TreeMap treemap = new TreeMap(e);
        for (int i = 0; i < headers.a(); i++)
        {
            String s1 = headers.a(i);
            String s2 = headers.b(i);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s1);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s2);
            treemap.put(s1, Collections.unmodifiableList(arraylist));
        }

        if (s != null)
        {
            treemap.put(null, Collections.unmodifiableList(Collections.singletonList(s)));
        }
        return Collections.unmodifiableMap(treemap);
    }

    public static void a(com.squareup.okhttp.Request.Builder builder, Map map)
    {
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            map = (java.util.Map.Entry)iterator.next();
            String s = (String)map.getKey();
            if (("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s)) && !((List)map.getValue()).isEmpty())
            {
                map = (List)map.getValue();
                if (map.size() == 1)
                {
                    map = (String)map.get(0);
                } else
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    for (int i = 0; i < map.size(); i++)
                    {
                        if (i > 0)
                        {
                            stringbuilder.append("; ");
                        }
                        stringbuilder.append((String)map.get(i));
                    }

                    map = stringbuilder.toString();
                }
                builder.b(s, map);
            }
        } while (true);
    }

    public static boolean a(Response response, Headers headers, Request request)
    {
        for (response = d(response).iterator(); response.hasNext();)
        {
            String s = (String)response.next();
            if (!Util.a(headers.c(s), request.b(s)))
            {
                return false;
            }
        }

        return true;
    }

    static boolean a(String s)
    {
        return !"Connection".equalsIgnoreCase(s) && !"Keep-Alive".equalsIgnoreCase(s) && !"Proxy-Authenticate".equalsIgnoreCase(s) && !"Proxy-Authorization".equalsIgnoreCase(s) && !"TE".equalsIgnoreCase(s) && !"Trailers".equalsIgnoreCase(s) && !"Transfer-Encoding".equalsIgnoreCase(s) && !"Upgrade".equalsIgnoreCase(s);
    }

    private static long b(String s)
    {
        if (s == null)
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    public static List b(Headers headers, String s)
    {
        ArrayList arraylist = new ArrayList();
label0:
        for (int i = 0; i < headers.a(); i++)
        {
            if (!s.equalsIgnoreCase(headers.a(i)))
            {
                continue;
            }
            String s1 = headers.b(i);
            int j = 0;
            do
            {
                if (j >= s1.length())
                {
                    continue label0;
                }
                int k = HeaderParser.a(s1, j, " ");
                String s2 = s1.substring(j, k).trim();
                j = HeaderParser.a(s1, k);
                if (!s1.regionMatches(true, j, "realm=\"", 0, 7))
                {
                    continue label0;
                }
                j += 7;
                k = HeaderParser.a(s1, j, "\"");
                String s3 = s1.substring(j, k);
                j = HeaderParser.a(s1, HeaderParser.a(s1, k + 1, ",") + 1);
                arraylist.add(new Challenge(s2, s3));
            } while (true);
        }

        return arraylist;
    }

    public static boolean b(Response response)
    {
        return d(response).contains("*");
    }

    public static Headers c(Response response)
    {
        Set set = d(response);
        if (set.isEmpty())
        {
            return (new com.squareup.okhttp.Headers.Builder()).a();
        }
        response = response.j().a().e();
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        for (int i = 0; i < response.a(); i++)
        {
            String s = response.a(i);
            if (set.contains(s))
            {
                builder.a(s, response.b(i));
            }
        }

        return builder.a();
    }

    private static Set d(Response response)
    {
        Object obj = Collections.emptySet();
        Headers headers = response.f();
        for (int i = 0; i < headers.a();)
        {
            Object obj1 = obj;
            if ("Vary".equalsIgnoreCase(headers.a(i)))
            {
                obj1 = headers.b(i);
                response = ((Response) (obj));
                if (((Set) (obj)).isEmpty())
                {
                    response = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                obj = ((String) (obj1)).split(",");
                int k = obj.length;
                int j = 0;
                do
                {
                    obj1 = response;
                    if (j >= k)
                    {
                        break;
                    }
                    response.add(obj[j].trim());
                    j++;
                } while (true);
            }
            i++;
            obj = obj1;
        }

        return ((Set) (obj));
    }

    static 
    {
        Platform.a();
    }

    private class _cls1
        implements Comparator
    {

        public final volatile int compare(Object obj, Object obj1)
        {
            obj = (String)obj;
            obj1 = (String)obj1;
            if (obj == obj1)
            {
                return 0;
            }
            if (obj == null)
            {
                return -1;
            }
            if (obj1 == null)
            {
                return 1;
            } else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(obj, obj1);
            }
        }

        _cls1()
        {
        }
    }

}
