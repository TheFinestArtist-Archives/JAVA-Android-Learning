// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.time;

import com.pinterest.kit.application.Resources;
import java.util.HashMap;

public class FuzzyDateMessages
{

    private static HashMap a = new _cls1();

    public static String a()
    {
        return Resources.string(0x7f0e02ad);
    }

    public static String a(int i)
    {
        return a(0x7f0d000e, i);
    }

    private static String a(int i, int j)
    {
        return Resources.stringPlural(i, Integer.valueOf(j), new Object[] {
            Integer.valueOf(j)
        });
    }

    public static String b(int i)
    {
        return a(0x7f0d000a, i);
    }

    public static String c(int i)
    {
        return a(0x7f0d0006, i);
    }

    public static String d(int i)
    {
        return a(0x7f0d0026, i);
    }

    public static String e(int i)
    {
        return a(0x7f0d000f, i);
    }

    public static String f(int i)
    {
        return a(0x7f0d0027, i);
    }


    private class _cls1 extends HashMap
    {

        _cls1()
        {
            put(Integer.valueOf(0x7f0e02ad), Integer.valueOf(0x7f0e02ad));
            put(Integer.valueOf(0x7f0d0025), Integer.valueOf(0x7f0e048a));
            put(Integer.valueOf(0x7f0d000e), Integer.valueOf(0x7f0e0488));
            put(Integer.valueOf(0x7f0d000a), Integer.valueOf(0x7f0e0487));
            put(Integer.valueOf(0x7f0d0006), Integer.valueOf(0x7f0e0486));
            put(Integer.valueOf(0x7f0d0026), Integer.valueOf(0x7f0e048b));
            put(Integer.valueOf(0x7f0d000f), Integer.valueOf(0x7f0e0489));
            put(Integer.valueOf(0x7f0d0027), Integer.valueOf(0x7f0e048c));
        }
    }

}
