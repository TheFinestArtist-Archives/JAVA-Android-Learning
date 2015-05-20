// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            Headers

public class 
{

    private final List a = new ArrayList(20);

    static List a( )
    {
        return .a;
    }

    private a c(String s, String s1)
    {
        a.add(s);
        a.add(s1.trim());
        return this;
    }

    final a a(String s)
    {
        int i = s.indexOf(":", 1);
        if (i != -1)
        {
            return c(s.substring(0, i), s.substring(i + 1));
        }
        if (s.startsWith(":"))
        {
            return c("", s.substring(1));
        } else
        {
            return c("", s);
        }
    }

    public final c a(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("name == null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("value == null");
        }
        if (s.length() == 0 || s.indexOf('\0') != -1 || s1.indexOf('\0') != -1)
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected header: ")).append(s).append(": ").append(s1).toString());
        } else
        {
            return c(s, s1);
        }
    }

    public final Headers a()
    {
        return new Headers(this, (byte)0);
    }

    public final c b(String s)
    {
        int j;
        for (int i = 0; i < a.size(); i = j + 2)
        {
            j = i;
            if (s.equalsIgnoreCase((String)a.get(i)))
            {
                a.remove(i);
                a.remove(i);
                j = i - 2;
            }
        }

        return this;
    }

    public final a b(String s, String s1)
    {
        b(s);
        a(s, s1);
        return this;
    }

    public final String c(String s)
    {
        for (int i = a.size() - 2; i >= 0; i -= 2)
        {
            if (s.equalsIgnoreCase((String)a.get(i)))
            {
                return (String)a.get(i + 1);
            }
        }

        return null;
    }

    public ()
    {
    }
}
