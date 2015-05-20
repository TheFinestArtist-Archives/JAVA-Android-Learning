// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import java.net.URL;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PStringUtils
{

    public static final String COMMA = ",";

    public PStringUtils()
    {
    }

    public static String concatStringArray(List list, String s)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((String) (obj));
_L2:
        String s1 = s;
        if (s == null)
        {
            s1 = ",";
        }
        s = "";
        int i = 0;
        do
        {
            obj = s;
            if (i >= list.size())
            {
                continue;
            }
            obj = (new StringBuilder()).append(s);
            if (i == 0)
            {
                s = "";
            } else
            {
                s = s1;
            }
            s = ((StringBuilder) (obj)).append(s).append((String)list.get(i)).toString();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String extractUrlFromString(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i;
        int j;
        s = s.split("\\s");
        j = s.length;
        i = 0;
_L4:
        String s1;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s[i];
        new URL(s1);
        return s1;
        Exception exception;
        exception;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static String getAbsoluteHtmlString(String s)
    {
        return getAbsoluteHtmlString(s, false);
    }

    public static String getAbsoluteHtmlString(String s, boolean flag)
    {
        if (StringUtils.isEmpty(s))
        {
            return s;
        }
        String s1 = s.replace("href=\"/", "href=\"pinterest://pinterest.com/").replace("href='/", "href='pinterest://pinterest.com/");
        s = s1;
        if (flag)
        {
            s = getBoldLinksHtmlString(s1);
        }
        return s;
    }

    public static String getBoldLinksHtmlString(String s)
    {
        if (StringUtils.isEmpty(s))
        {
            return s;
        } else
        {
            return s.replace("<a ", "<b><a ").replace("</a>", "</a></b>");
        }
    }

    public static String getHtmlLineBreaksString(String s)
    {
        if (StringUtils.isEmpty(s))
        {
            return s;
        } else
        {
            return s.replaceAll("\\r|\\n", "<br>");
        }
    }
}
