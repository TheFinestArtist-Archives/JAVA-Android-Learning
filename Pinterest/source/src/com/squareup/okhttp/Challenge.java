// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;

public final class Challenge
{

    private final String a;
    private final String b;

    public Challenge(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final String a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof Challenge) && Util.a(a, ((Challenge)obj).a) && Util.a(b, ((Challenge)obj).b);
    }

    public final int hashCode()
    {
        int j = 0;
        int i;
        if (b != null)
        {
            i = b.hashCode();
        } else
        {
            i = 0;
        }
        if (a != null)
        {
            j = a.hashCode();
        }
        return (i + 899) * 31 + j;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(" realm=\"").append(b).append("\"").toString();
    }
}
