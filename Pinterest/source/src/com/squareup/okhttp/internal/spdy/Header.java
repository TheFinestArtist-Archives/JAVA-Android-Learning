// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import okio.ByteString;

public final class Header
{

    public static final ByteString a = ByteString.a(":status");
    public static final ByteString b = ByteString.a(":method");
    public static final ByteString c = ByteString.a(":path");
    public static final ByteString d = ByteString.a(":scheme");
    public static final ByteString e = ByteString.a(":authority");
    public static final ByteString f = ByteString.a(":host");
    public static final ByteString g = ByteString.a(":version");
    public final ByteString h;
    public final ByteString i;
    final int j;

    public Header(String s, String s1)
    {
        this(ByteString.a(s), ByteString.a(s1));
    }

    public Header(ByteString bytestring, String s)
    {
        this(bytestring, ByteString.a(s));
    }

    public Header(ByteString bytestring, ByteString bytestring1)
    {
        h = bytestring;
        i = bytestring1;
        j = bytestring.e() + 32 + bytestring1.e();
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Header)
        {
            obj = (Header)obj;
            flag = flag1;
            if (h.equals(((Header) (obj)).h))
            {
                flag = flag1;
                if (i.equals(((Header) (obj)).i))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (h.hashCode() + 527) * 31 + i.hashCode();
    }

    public final String toString()
    {
        return String.format("%s: %s", new Object[] {
            h.a(), i.a()
        });
    }

}
