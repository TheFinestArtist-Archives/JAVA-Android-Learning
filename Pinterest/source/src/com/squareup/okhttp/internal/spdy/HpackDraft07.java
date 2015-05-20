// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header

final class HpackDraft07
{

    private static final Header a[];
    private static final Map b;

    static ByteString a(ByteString bytestring)
    {
        int i = 0;
        for (int j = bytestring.e(); i < j; i++)
        {
            byte byte0 = bytestring.a(i);
            if (byte0 >= 65 && byte0 <= 90)
            {
                throw new IOException((new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ")).append(bytestring.a()).toString());
            }
        }

        return bytestring;
    }

    static Header[] a()
    {
        return a;
    }

    static Map b()
    {
        return b;
    }

    static 
    {
        int i = 0;
        a = (new Header[] {
            new Header(Header.e, ""), new Header(Header.b, "GET"), new Header(Header.b, "POST"), new Header(Header.c, "/"), new Header(Header.c, "/index.html"), new Header(Header.d, "http"), new Header(Header.d, "https"), new Header(Header.a, "200"), new Header(Header.a, "204"), new Header(Header.a, "206"), 
            new Header(Header.a, "304"), new Header(Header.a, "400"), new Header(Header.a, "404"), new Header(Header.a, "500"), new Header("accept-charset", ""), new Header("accept-encoding", ""), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), 
            new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), 
            new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), 
            new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), 
            new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), 
            new Header("www-authenticate", "")
        });
        LinkedHashMap linkedhashmap = new LinkedHashMap(a.length);
        for (; i < a.length; i++)
        {
            if (!linkedhashmap.containsKey(a[i].h))
            {
                linkedhashmap.put(a[i].h, Integer.valueOf(i));
            }
        }

        b = Collections.unmodifiableMap(linkedhashmap);
    }
}
