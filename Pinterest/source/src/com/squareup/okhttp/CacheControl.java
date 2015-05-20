// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;

// Referenced classes of package com.squareup.okhttp:
//            Headers

public final class CacheControl
{

    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private final int h;
    private final boolean i;

    private CacheControl(boolean flag, boolean flag1, int j, int k, boolean flag2, boolean flag3, int l, 
            int i1, boolean flag4)
    {
        a = flag;
        b = flag1;
        c = j;
        d = k;
        e = flag2;
        f = flag3;
        g = l;
        h = i1;
        i = flag4;
    }

    public static CacheControl a(Headers headers)
    {
        boolean flag4 = false;
        boolean flag = false;
        int k = -1;
        int l = -1;
        boolean flag1 = false;
        boolean flag2 = false;
        int i1 = -1;
        int j1 = -1;
        boolean flag3 = false;
        for (int k1 = 0; k1 < headers.a();)
        {
            int j;
            int l1;
            int i2;
            int j2;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            boolean flag8;
            boolean flag9;
label0:
            {
                if (!headers.a(k1).equalsIgnoreCase("Cache-Control"))
                {
                    flag9 = flag4;
                    flag8 = flag;
                    j2 = k;
                    i2 = l;
                    flag7 = flag1;
                    flag6 = flag2;
                    l1 = i1;
                    j = j1;
                    flag5 = flag3;
                    if (!headers.a(k1).equalsIgnoreCase("Pragma"))
                    {
                        break label0;
                    }
                }
                String s1 = headers.b(k1);
                l1 = 0;
                do
                {
                    if (l1 >= s1.length())
                    {
                        break;
                    }
                    j = HeaderParser.a(s1, l1, "=,;");
                    String s2 = s1.substring(l1, j).trim();
                    String s;
                    if (j == s1.length() || s1.charAt(j) == ',' || s1.charAt(j) == ';')
                    {
                        j++;
                        s = null;
                    } else
                    {
                        l1 = HeaderParser.a(s1, j + 1);
                        if (l1 < s1.length() && s1.charAt(l1) == '"')
                        {
                            j = l1 + 1;
                            l1 = HeaderParser.a(s1, j, "\"");
                            s = s1.substring(j, l1);
                            j = l1 + 1;
                        } else
                        {
                            j = HeaderParser.a(s1, l1, ",;");
                            s = s1.substring(l1, j).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(s2))
                    {
                        flag4 = true;
                        l1 = j;
                    } else
                    if ("no-store".equalsIgnoreCase(s2))
                    {
                        flag = true;
                        l1 = j;
                    } else
                    if ("max-age".equalsIgnoreCase(s2))
                    {
                        k = HeaderParser.a(s);
                        l1 = j;
                    } else
                    if ("s-maxage".equalsIgnoreCase(s2))
                    {
                        l = HeaderParser.a(s);
                        l1 = j;
                    } else
                    if ("public".equalsIgnoreCase(s2))
                    {
                        flag1 = true;
                        l1 = j;
                    } else
                    if ("must-revalidate".equalsIgnoreCase(s2))
                    {
                        flag2 = true;
                        l1 = j;
                    } else
                    if ("max-stale".equalsIgnoreCase(s2))
                    {
                        i1 = HeaderParser.a(s);
                        l1 = j;
                    } else
                    if ("min-fresh".equalsIgnoreCase(s2))
                    {
                        j1 = HeaderParser.a(s);
                        l1 = j;
                    } else
                    {
                        l1 = j;
                        if ("only-if-cached".equalsIgnoreCase(s2))
                        {
                            flag3 = true;
                            l1 = j;
                        }
                    }
                } while (true);
                flag5 = flag3;
                j = j1;
                l1 = i1;
                flag6 = flag2;
                flag7 = flag1;
                i2 = l;
                j2 = k;
                flag8 = flag;
                flag9 = flag4;
            }
            k1++;
            flag4 = flag9;
            flag = flag8;
            k = j2;
            l = i2;
            flag1 = flag7;
            flag2 = flag6;
            i1 = l1;
            j1 = j;
            flag3 = flag5;
        }

        return new CacheControl(flag4, flag, k, l, flag1, flag2, i1, j1, flag3);
    }

    public final boolean a()
    {
        return a;
    }

    public final boolean b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final int d()
    {
        return d;
    }

    public final boolean e()
    {
        return e;
    }

    public final boolean f()
    {
        return f;
    }

    public final int g()
    {
        return g;
    }

    public final int h()
    {
        return h;
    }

    public final boolean i()
    {
        return i;
    }
}
