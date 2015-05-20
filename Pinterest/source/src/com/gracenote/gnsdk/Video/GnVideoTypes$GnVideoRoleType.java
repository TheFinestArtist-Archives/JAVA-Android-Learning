// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Video;


public final class G extends Enum
{

    public static final F A;
    public static final F B;
    public static final F C;
    public static final F D;
    public static final F E;
    public static final F F;
    private static final F H[];
    public static final F a;
    public static final F b;
    public static final F c;
    public static final F d;
    public static final F e;
    public static final F f;
    public static final F g;
    public static final F h;
    public static final F i;
    public static final F j;
    public static final F k;
    public static final F l;
    public static final F m;
    public static final F n;
    public static final F o;
    public static final F p;
    public static final F q;
    public static final F r;
    public static final F s;
    public static final F t;
    public static final F u;
    public static final F v;
    public static final F w;
    public static final F x;
    public static final F y;
    public static final F z;
    private String G;

    public static G valueOf(String s1)
    {
        return (G)Enum.valueOf(com/gracenote/gnsdk/Video/GnVideoTypes$GnVideoRoleType, s1);
    }

    public static G[] values()
    {
        return (G[])H.clone();
    }

    static 
    {
        a = new <init>("Cast", 0, "gnsdk_ctx_credit!15941");
        b = new <init>("Actor", 1, "gnsdk_ctx_credit!actor");
        c = new <init>("Dancer", 2, "gnsdk_ctx_credit!15943");
        d = new <init>("Guest", 3, "gnsdk_ctx_credit!15944");
        e = new <init>("Host", 4, "gnsdk_ctx_credit!15945");
        f = new <init>("Narrator", 5, "gnsdk_ctx_credit!narrator");
        g = new <init>("Puppeteer", 6, "gnsdk_ctx_credit!15947");
        h = new <init>("VoiceOf", 7, "gnsdk_ctx_credit!15948");
        i = new <init>("Crew", 8, "gnsdk_ctx_credit!15949");
        j = new <init>("CameraPerson", 9, "gnsdk_ctx_credit!15950");
        k = new <init>("Gopher", 10, "gnsdk_ctx_credit!15951");
        l = new <init>("StuntPerson", 11, "gnsdk_ctx_credit!15952");
        m = new <init>("Music", 12, "gnsdk_ctx_credit!15953");
        n = new <init>("MusicDirector", 13, "gnsdk_ctx_credit!15954");
        o = new <init>("OriginalScore", 14, "gnsdk_ctx_credit!15955");
        p = new <init>("Production", 15, "gnsdk_ctx_credit!15956");
        q = new <init>("Director", 16, "gnsdk_ctx_credit!director");
        r = new <init>("Producer", 17, "gnsdk_ctx_credit!producer");
        s = new <init>("AssociateProducer", 18, "gnsdk_ctx_credit!15959");
        t = new <init>("ExecutiveProducer", 19, "gnsdk_ctx_credit!executiveproduder");
        u = new <init>("ScreenWriter", 20, "gnsdk_ctx_credit!15961");
        v = new <init>("Author", 21, "gnsdk_ctx_credit!author");
        w = new <init>("Art", 22, "gnsdk_ctx_credit!15963");
        x = new <init>("ArtDirection", 23, "gnsdk_ctx_credit!15964");
        y = new <init>("Casting", 24, "gnsdk_ctx_credit!15965");
        z = new <init>("Cinemathography", 25, "gnsdk_ctx_credit!15966");
        A = new <init>("CostumeDesign", 26, "gnsdk_ctx_credit!15967");
        B = new <init>("Editor", 27, "gnsdk_ctx_credit!15968");
        C = new <init>("Makeup", 28, "gnsdk_ctx_credit!15969");
        D = new <init>("ProductionDesign", 29, "gnsdk_ctx_credit!15970");
        E = new <init>("ProductionManagement", 30, "gnsdk_ctx_credit!15971");
        F = new <init>("SpecialEffects", 31, "gnsdk_ctx_credit!15972");
        H = (new H[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F
        });
    }

    private (String s1, int i1, String s2)
    {
        super(s1, i1);
        G = s2;
    }
}
