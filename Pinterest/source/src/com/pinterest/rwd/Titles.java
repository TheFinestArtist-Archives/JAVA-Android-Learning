// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.rwd;

import java.util.HashMap;

public class Titles
{

    public static final HashMap a = new _cls1();

    public static String a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (String)a.get(s);
        }
    }


    private class _cls1 extends HashMap
    {

        _cls1()
        {
            put("Today", "26810697690120674");
            put("The Chew", "224476500085183601");
            put("Scandal", "86061180287718605");
        }
    }

}
