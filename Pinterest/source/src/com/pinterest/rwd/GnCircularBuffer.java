// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.rwd;


public class GnCircularBuffer
{

    private byte a[];
    private int b;
    private int c;
    private int d;
    private int e;

    public GnCircularBuffer(int i)
    {
        a = new byte[i];
        b = i;
        c = 0;
        d = 0;
        e = 0;
    }

    public final void a(byte abyte0[], int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i > 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int k = (c + i) - b;
        int j;
        j = i;
        if (k > 0)
        {
            j = i - k;
        }
        break MISSING_BLOCK_LABEL_94;
_L3:
        i++;
        for (; i >= j; i = 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }

        e = (e + 1) % b;
        a[e] = abyte0[i];
          goto _L3
        c = c + j;
        if (true) goto _L1; else goto _L4
_L4:
        abyte0;
        throw abyte0;
    }
}
