// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import java.lang.reflect.Field;

public class ParserHelper
{

    private static final Field b;
    private static final double f[];
    public int a;
    private final char c[];
    private final int d;
    private char e;

    public ParserHelper(String s)
    {
        try
        {
            c = (char[])b.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        a = 0;
        d = c.length;
        e = c[0];
    }

    private static void a(char c1)
    {
        throw new RuntimeException((new StringBuilder("Unexpected char '")).append(c1).append("'.").toString());
    }

    private char e()
    {
        if (a < d)
        {
            a = a + 1;
        }
        if (a == d)
        {
            return '\0';
        } else
        {
            return c[a];
        }
    }

    private void f()
    {
_L5:
        if (a >= d) goto _L2; else goto _L1
_L1:
        c[a];
        JVM INSTR lookupswitch 4: default 64
    //                   9: 65
    //                   10: 65
    //                   32: 65
    //                   44: 65;
           goto _L2 _L3 _L3 _L3 _L3
_L2:
        return;
_L3:
        b();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a()
    {
        for (; a < d && Character.isWhitespace(c[a]); b()) { }
    }

    public final void b()
    {
        e = e();
    }

    public final float c()
    {
        int l1;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = true;
        flag2 = true;
        flag3 = true;
        l1 = 0;
        flag1 = false;
        a();
        e;
        JVM INSTR tableswitch 43 45: default 48
    //                   43 1452
    //                   44 48
    //                   45 125;
           goto _L1 _L2 _L1 _L3
_L1:
        boolean flag = true;
_L8:
        e;
        JVM INSTR tableswitch 46 57: default 116
    //                   46 143
    //                   47 116
    //                   48 265
    //                   49 412
    //                   50 412
    //                   51 412
    //                   52 412
    //                   53 412
    //                   54 412
    //                   55 412
    //                   56 412
    //                   57 412;
           goto _L4 _L5 _L4 _L6 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7
_L4:
        float f1 = (0.0F / 0.0F);
_L15:
        f();
        return f1;
_L3:
        int i = 0;
_L38:
        e = e();
        flag = i;
          goto _L8
_L5:
        int j;
        int k;
        int k1;
        i = 0;
        k1 = 0;
        k = 0;
        j = 0;
_L18:
        int i1;
        int j1;
        j1 = i;
        i1 = j;
        if (e != '.') goto _L10; else goto _L9
_L9:
        e = e();
        e;
        JVM INSTR tableswitch 48 57: default 240
    //                   48 567
    //                   49 1449
    //                   50 1449
    //                   51 1449
    //                   52 1449
    //                   53 1449
    //                   54 1449
    //                   55 1449
    //                   56 1449
    //                   57 1449;
           goto _L11 _L12 _L13 _L13 _L13 _L13 _L13 _L13 _L13 _L13 _L13
_L11:
        j1 = i;
        i1 = j;
        if (k1 != 0) goto _L10; else goto _L14
_L14:
        a(e);
        f1 = 0.0F;
          goto _L15
_L6:
        e = e();
        e;
        JVM INSTR lookupswitch 13: default 392
    //                   46: 397
    //                   48: 265
    //                   49: 412
    //                   50: 412
    //                   51: 412
    //                   52: 412
    //                   53: 412
    //                   54: 412
    //                   55: 412
    //                   56: 412
    //                   57: 412
    //                   69: 397
    //                   101: 397;
           goto _L16 _L17 _L6 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L17 _L17
_L16:
        f1 = 0.0F;
          goto _L15
_L17:
        i = 0;
        k1 = 1;
        k = 0;
        j = 0;
          goto _L18
_L7:
        j1 = 0;
        k1 = 0;
        i1 = 0;
label0:
        do
        {
            if (k1 < 9)
            {
                j = k1 + 1;
                k = i1 * 10 + (e - 48);
                i = j1;
            } else
            {
                i = j1 + 1;
                j = k1;
                k = i1;
            }
            e = e();
            j1 = i;
            k1 = j;
            i1 = k;
            switch (e)
            {
            default:
                i1 = k;
                break label0;

            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
                break;
            }
        } while (true);
        k1 = 1;
        k = j;
        j = i1;
          goto _L18
_L12:
        if (k != 0) goto _L13; else goto _L19
_L19:
        i1 = i;
_L21:
        e = e();
        i = i1 - 1;
        i1 = i;
        e;
        JVM INSTR tableswitch 48 57: default 652
    //                   48 576
    //                   49 670
    //                   50 670
    //                   51 670
    //                   52 670
    //                   53 670
    //                   54 670
    //                   55 670
    //                   56 670
    //                   57 670;
           goto _L20 _L21 _L13 _L13 _L13 _L13 _L13 _L13 _L13 _L13 _L13
_L20:
        j1 = i;
        i1 = j;
        if (k1 != 0) goto _L10; else goto _L22
_L22:
        f1 = 0.0F;
          goto _L15
_L13:
label1:
        while (true) 
        {
            j1 = i;
            k1 = k;
            i1 = j;
            if (k < 9)
            {
                k1 = k + 1;
                i1 = j * 10 + (e - 48);
                j1 = i - 1;
            }
            e = e();
            i = j1;
            k = k1;
            j = i1;
            switch (e)
            {
            default:
                break label1;

            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
                break;
            }
        }
_L10:
        e;
        JVM INSTR lookupswitch 2: default 828
    //                   69: 884
    //                   101: 884;
           goto _L23 _L24 _L24
_L23:
        i = ((flag3) ? 1 : 0);
        j = ((flag1) ? 1 : 0);
_L32:
        int l = j;
        if (i == 0)
        {
            l = -j;
        }
        l += j1;
        if (!flag)
        {
            i = -i1;
        } else
        {
            i = i1;
        }
        if (l < -125 || i == 0)
        {
            f1 = 0.0F;
        } else
        {
            if (l >= 128)
            {
                if (i > 0)
                {
                    f1 = (1.0F / 0.0F);
                } else
                {
                    f1 = (-1.0F / 0.0F);
                }
            } else
            if (l == 0)
            {
                f1 = i;
            } else
            {
                j = i;
                if (i >= 0x4000000)
                {
                    j = i + 1;
                }
                double d1;
                if (l > 0)
                {
                    d1 = j;
                    d1 = f[l] * d1;
                } else
                {
                    d1 = (double)j / f[-l];
                }
                f1 = (float)d1;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L15
_L24:
        e = e();
        j = ((flag4) ? 1 : 0);
        i = ((flag2) ? 1 : 0);
        e;
        JVM INSTR tableswitch 43 57: default 980
    //                   43 995
    //                   44 980
    //                   45 992
    //                   46 980
    //                   47 980
    //                   48 1076
    //                   49 1076
    //                   50 1076
    //                   51 1076
    //                   52 1076
    //                   53 1076
    //                   54 1076
    //                   55 1076
    //                   56 1076
    //                   57 1076;
           goto _L25 _L26 _L25 _L27 _L25 _L25 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28
_L25:
        a(e);
        f1 = 0.0F;
          goto _L15
_L27:
        j = 0;
_L26:
        e = e();
        i = j;
        switch (e)
        {
        default:
            a(e);
            f1 = 0.0F;
            continue; /* Loop/switch isn't completed */

        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            break;
        }
_L28:
        e;
        JVM INSTR tableswitch 48 57: default 1136
    //                   48 1143
    //                   49 1439
    //                   50 1439
    //                   51 1439
    //                   52 1439
    //                   53 1439
    //                   54 1439
    //                   55 1439
    //                   56 1439
    //                   57 1439;
           goto _L29 _L30 _L31 _L31 _L31 _L31 _L31 _L31 _L31 _L31 _L31
_L29:
        j = ((flag1) ? 1 : 0);
          goto _L32
_L30:
        e = e();
        e;
        JVM INSTR tableswitch 48 57: default 1208
    //                   48 1143
    //                   49 1215
    //                   50 1215
    //                   51 1215
    //                   52 1215
    //                   53 1215
    //                   54 1215
    //                   55 1215
    //                   56 1215
    //                   57 1215;
           goto _L33 _L30 _L34 _L34 _L34 _L34 _L34 _L34 _L34 _L34 _L34
_L33:
        j = ((flag1) ? 1 : 0);
          goto _L32
_L34:
        j = 0;
        k1 = l1;
_L36:
        l1 = k1;
        l = j;
        if (k1 < 3)
        {
            l1 = k1 + 1;
            l = j * 10 + (e - 48);
        }
        e = e();
        k1 = l1;
        j = l;
        e;
        JVM INSTR tableswitch 48 57: default 1332
    //                   48 1222
    //                   49 1222
    //                   50 1222
    //                   51 1222
    //                   52 1222
    //                   53 1222
    //                   54 1222
    //                   55 1222
    //                   56 1222
    //                   57 1222;
           goto _L35 _L36 _L36 _L36 _L36 _L36 _L36 _L36 _L36 _L36 _L36
_L35:
        j = l;
          goto _L32
_L31:
        j = 0;
        k1 = l1;
          goto _L36
        if (true) goto _L15; else goto _L37
_L37:
_L2:
        i = 1;
          goto _L38
    }

    public final int d()
    {
        a();
        char c1 = e;
        e = e();
        f();
        return c1 - 48;
    }

    static 
    {
        try
        {
            Field field = java/lang/String.getDeclaredField("value");
            b = field;
            field.setAccessible(true);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        f = new double[128];
        for (int i = 0; i < f.length; i++)
        {
            f[i] = Math.pow(10D, i);
        }

    }
}
