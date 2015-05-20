// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preconditions
{

    private static final String DEFAULT_MESSAGE = "Received an invalid parameter";
    private static final Pattern URL_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    private Preconditions()
    {
    }

    private static void check(boolean flag, String s)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (s.trim().length() > 0)
                {
                    break label0;
                }
            }
            s1 = "Received an invalid parameter";
        }
        if (!flag)
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }

    public static void checkEmptyString(String s, String s1)
    {
        boolean flag;
        if (s != null && !s.trim().equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        check(flag, s1);
    }

    public static void checkNotNull(Object obj, String s)
    {
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        check(flag, s);
    }

    public static void checkValidOAuthCallback(String s, String s1)
    {
        checkEmptyString(s, s1);
        if (s.compareToIgnoreCase("oob") != 0)
        {
            check(isUrl(s), s1);
        }
    }

    public static void checkValidUrl(String s, String s1)
    {
        checkEmptyString(s, s1);
        check(isUrl(s), s1);
    }

    private static boolean isUrl(String s)
    {
        return URL_PATTERN.matcher(s).matches();
    }

}
