// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import java.util.HashMap;
import org.xml.sax.Attributes;

// Referenced classes of package com.larvalabs.svgandroid:
//            SVGParser, SVGColors

class <init>
{

    a a;
    Attributes b;

    private static int d(String s)
    {
        if (s.endsWith("%"))
        {
            return Math.round((Float.parseFloat(s.substring(0, s.length() - 1)) / 100F) * 255F);
        } else
        {
            return Integer.parseInt(s);
        }
    }

    public final Float a(String s, float f)
    {
        Float float1 = c(s);
        s = float1;
        if (float1 == null)
        {
            s = Float.valueOf(f);
        }
        return s;
    }

    public final String a(String s)
    {
        String s1 = null;
        if (a != null)
        {
            s1 = (String)a.a.get(s);
        }
        String s2 = s1;
        if (s1 == null)
        {
            s2 = SVGParser.a(s, b);
        }
        return s2;
    }

    public final Integer b(String s)
    {
        s = a(s);
        if (s == null)
        {
            return null;
        }
        if (!s.startsWith("#"))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        int i;
        int j;
        int k;
        try
        {
            j = Integer.parseInt(s.substring(1), 16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        i = j;
        if (s.length() == 4)
        {
            i = j & 0xf | ((j & 0xf00) << 8 | (j & 0xf00) << 12 | (j & 0xf0) << 4 | (j & 0xf0) << 8 | (j & 0xf) << 4);
        }
        return Integer.valueOf(i);
        if (s.startsWith("rgb(") && s.endsWith(")"))
        {
            s = s.substring(4, s.length() - 1).split(",");
            try
            {
                i = d(s[0]);
                j = d(s[1]);
                k = d(s[2]);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return Integer.valueOf(k & 0xff | ((i & 0xff) << 16 | (j & 0xff) << 8));
        } else
        {
            return SVGColors.a(s);
        }
    }

    public final Float c(String s)
    {
        s = a(s);
        if (s == null)
        {
            return null;
        }
        float f;
        try
        {
            f = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return Float.valueOf(f);
    }

    private (Attributes attributes)
    {
        a = null;
        b = attributes;
        attributes = SVGParser.a("style", attributes);
        if (attributes != null)
        {
            a = new nit>(attributes, (byte)0);
        }
    }

    nit>(Attributes attributes, byte byte0)
    {
        this(attributes);
    }
}
