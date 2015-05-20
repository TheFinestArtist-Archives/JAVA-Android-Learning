// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;


final class A
{

    private static final String a[] = {
        "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION", 
        "ALTSVC", "BLOCKED"
    };
    private static final String b[];
    private static final String c[];

    static String a(boolean flag, int i, int j, byte byte0, byte byte1)
    {
        String s;
        String s2;
        if (byte0 < a.length)
        {
            s2 = a[byte0];
        } else
        {
            s2 = String.format("0x%02x", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (byte1 != 0) goto _L2; else goto _L1
_L1:
        s = "";
_L4:
        String s1;
        if (flag)
        {
            s1 = "<<";
        } else
        {
            s1 = ">>";
        }
        return String.format("%s 0x%08x %5d %-13s %s", new Object[] {
            s1, Integer.valueOf(i), Integer.valueOf(j), s2, s
        });
_L2:
        switch (byte0)
        {
        case 5: // '\005'
        case 9: // '\t'
        default:
            if (byte1 < b.length)
            {
                s1 = b[byte1];
            } else
            {
                s1 = c[byte1];
            }
            if (byte0 == 5 && (byte1 & 4) != 0)
            {
                s = s1.replace("HEADERS", "PUSH_PROMISE");
            } else
            {
                s = s1;
                if (byte0 == 0)
                {
                    s = s1;
                    if ((byte1 & 0x20) != 0)
                    {
                        s = s1.replace("PRIORITY", "COMPRESSED");
                    }
                }
            }
            break;

        case 4: // '\004'
        case 6: // '\006'
            if (byte1 == 1)
            {
                s = "ACK";
            } else
            {
                s = c[byte1];
            }
            break;

        case 2: // '\002'
        case 3: // '\003'
        case 7: // '\007'
        case 8: // '\b'
        case 10: // '\n'
        case 11: // '\013'
            s = c[byte1];
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        b = new String[64];
        c = new String[256];
        for (int i = 0; i < c.length; i++)
        {
            c[i] = String.format("%8s", new Object[] {
                Integer.toBinaryString(i)
            }).replace(' ', '0');
        }

        b[0] = "";
        b[1] = "END_STREAM";
        b[2] = "END_SEGMENT";
        b[3] = "END_STREAM|END_SEGMENT";
        int ai[] = new int[3];
        int[] _tmp = ai;
        ai[0] = 1;
        ai[1] = 2;
        ai[2] = 3;
        b[8] = "PAD_LOW";
        b[24] = "PAD_LOW|PAD_HIGH";
        int ai1[] = new int[2];
        int[] _tmp1 = ai1;
        ai1[0] = 8;
        ai1[1] = 24;
        for (int j = 0; j < 3; j++)
        {
            int k1 = ai[j];
            for (int i1 = 0; i1 < 2; i1++)
            {
                int i2 = ai1[i1];
                b[k1 | i2] = (new StringBuilder()).append(b[k1]).append('|').append(b[i2]).toString();
            }

        }

        b[4] = "END_HEADERS";
        b[32] = "PRIORITY";
        b[36] = "END_HEADERS|PRIORITY";
        for (int k = 0; k < 3; k++)
        {
            int j2 = (new int[] {
                4, 32, 36
            })[k];
            for (int j1 = 0; j1 < 3; j1++)
            {
                int k2 = ai[j1];
                b[k2 | j2] = (new StringBuilder()).append(b[k2]).append('|').append(b[j2]).toString();
                for (int l1 = 0; l1 < 2; l1++)
                {
                    int l2 = ai1[l1];
                    b[k2 | j2 | l2] = (new StringBuilder()).append(b[k2]).append('|').append(b[j2]).append('|').append(b[l2]).toString();
                }

            }

        }

        for (int l = 0; l < b.length; l++)
        {
            if (b[l] == null)
            {
                b[l] = c[l];
            }
        }

    }
}
