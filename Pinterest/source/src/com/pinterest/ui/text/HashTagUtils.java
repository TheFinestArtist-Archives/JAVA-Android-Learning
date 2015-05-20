// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTagUtils
{

    public HashTagUtils()
    {
    }

    public static ArrayList getSpans(String s, char c)
    {
        ArrayList arraylist = new ArrayList();
        for (s = Pattern.compile((new StringBuilder()).append(c).append("\\w+").toString()).matcher(s); s.find(); arraylist.add(new int[] {
    s.start(), s.end()
})) { }
        return arraylist;
    }
}
