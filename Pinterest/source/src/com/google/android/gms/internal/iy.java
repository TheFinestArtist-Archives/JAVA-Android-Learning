// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

public abstract class iy
{

    private static a KO = null;
    private static final Object mH = new Object();
    protected final String KP;
    protected final Object KQ;
    private Object KR;

    protected iy(String s, Object obj)
    {
        KR = null;
        KP = s;
        KQ = obj;
    }

    public static void H(Context context)
    {
        synchronized (mH)
        {
            if (KO == null)
            {
                KO = new b(context.getContentResolver());
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static iy a(String s, Integer integer)
    {
        return new _cls2(s, integer);
    }

    public static iy h(String s, boolean flag)
    {
        return new _cls1(s, Boolean.valueOf(flag));
    }

    public static iy l(String s, String s1)
    {
        return new _cls3(s, s1);
    }

    public String getKey()
    {
        return KP;
    }


    private class b
        implements a
    {

        private final ContentResolver mContentResolver;

        public b(ContentResolver contentresolver)
        {
            mContentResolver = contentresolver;
        }
    }


    private class _cls2 extends iy
    {

        _cls2(String s, Integer integer)
        {
            super(s, integer);
        }
    }


    private class _cls1 extends iy
    {

        _cls1(String s, Boolean boolean1)
        {
            super(s, boolean1);
        }
    }


    private class _cls3 extends iy
    {

        _cls3(String s, String s1)
        {
            super(s, s1);
        }
    }

}
