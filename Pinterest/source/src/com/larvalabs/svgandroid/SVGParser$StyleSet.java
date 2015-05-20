// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import java.util.HashMap;

class <init>
{

    HashMap a;

    private (String s)
    {
        a = new HashMap();
        s = s.split(";");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = s[i].split(":");
            if (as.length == 2)
            {
                a.put(as[0], as[1]);
            }
        }

    }

    a(String s, byte byte0)
    {
        this(s);
    }
}
