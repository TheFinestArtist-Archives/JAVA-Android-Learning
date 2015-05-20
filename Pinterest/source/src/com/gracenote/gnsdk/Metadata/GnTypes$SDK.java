// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;


public final class q extends Enum
{

    public static final p a;
    public static final p b;
    public static final p c;
    public static final p d;
    public static final p e;
    public static final p f;
    public static final p g;
    public static final p h;
    public static final p i;
    public static final p j;
    public static final p k;
    public static final p l;
    public static final p m;
    public static final p n;
    public static final p o;
    public static final p p;
    private static final p r[];
    private int q;

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/gracenote/gnsdk/Metadata/GnTypes$SDK, s);
    }

    public static q[] values()
    {
        return (q[])r.clone();
    }

    public final int a()
    {
        return q;
    }

    public final void a(int i1)
    {
        q = i1;
    }

    public final void b()
    {
        q = 0;
    }

    static 
    {
        a = new <init>("NONE", 0, 0);
        b = new <init>("MANAGER", 1, 1);
        c = new <init>("DSP", 2, 2);
        d = new <init>("MUSICID", 3, 4);
        e = new <init>("MUSICID_FILE", 4, 8);
        f = new <init>("VIDEO", 5, 16);
        g = new <init>("SUBMIT", 6, 32);
        h = new <init>("LINK", 7, 64);
        i = new <init>("PLAYLIST", 8, 128);
        j = new <init>("MUSICID_MATCH", 9, 256);
        k = new <init>("EPG", 10, 512);
        l = new <init>("ACR", 11, 1024);
        m = new <init>("STORAGE_SQLITE", 12, 2048);
        n = new <init>("MOODGRID", 13, 4096);
        o = new <init>("LOOKUP_LOCAL", 14, 8192);
        p = new <init>("LOOKUP_FPLOCAL", 15, 16384);
        r = (new r[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p
        });
    }

    private (String s, int i1, int j1)
    {
        super(s, i1);
        q = j1;
    }
}
