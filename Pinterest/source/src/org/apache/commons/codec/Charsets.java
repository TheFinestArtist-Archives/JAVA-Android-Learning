// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.codec;

import java.nio.charset.Charset;

public class Charsets
{

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public Charsets()
    {
    }

    public static Charset toCharset(String s)
    {
        if (s == null)
        {
            return Charset.defaultCharset();
        } else
        {
            return Charset.forName(s);
        }
    }

    public static Charset toCharset(Charset charset)
    {
        Charset charset1 = charset;
        if (charset == null)
        {
            charset1 = Charset.defaultCharset();
        }
        return charset1;
    }

}
