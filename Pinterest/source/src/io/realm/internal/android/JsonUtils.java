// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal.android;

import android.util.Base64;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils
{

    private static Pattern jsonDate = Pattern.compile("/Date\\((\\d*)\\)/");

    public JsonUtils()
    {
    }

    public static byte[] stringToBytes(String s)
    {
        if (s == null || s.length() == 0)
        {
            return new byte[0];
        } else
        {
            return Base64.decode(s, 0);
        }
    }

    public static Date stringToDate(String s)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        }
        Matcher matcher = jsonDate.matcher(s);
        if (matcher.matches())
        {
            return new Date(Long.parseLong(matcher.group(1)));
        } else
        {
            return new Date(Long.parseLong(s));
        }
    }

}
