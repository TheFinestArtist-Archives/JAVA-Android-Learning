// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gracenote.gnsdk.Metadata;


public final class s extends Enum
{

    public static final r a;
    public static final r b;
    public static final r c;
    public static final r d;
    public static final r e;
    public static final r f;
    public static final r g;
    public static final r h;
    public static final r i;
    public static final r j;
    public static final r k;
    public static final r l;
    public static final r m;
    public static final r n;
    public static final r o;
    public static final r p;
    public static final r q;
    public static final r r;
    private static final r t[];
    private String s;

    public static s valueOf(String s1)
    {
        return (s)Enum.valueOf(com/gracenote/gnsdk/Metadata/GnTypes$GnLanguageCode, s1);
    }

    public static s[] values()
    {
        return (s[])t.clone();
    }

    static 
    {
        a = new <init>("ChineseSimplified", 0, "qtb");
        b = new <init>("ChineseTraditional", 1, "qtd");
        c = new <init>("Dutch", 2, "dut");
        d = new <init>("English", 3, "eng");
        e = new <init>("French", 4, "fre");
        f = new <init>("German", 5, "ger");
        g = new <init>("Italian", 6, "ita");
        h = new <init>("Japanese", 7, "jpn");
        i = new <init>("Korean", 8, "kor");
        j = new <init>("Polish", 9, "pol");
        k = new <init>("PortugueseBrazil", 10, "por");
        l = new <init>("Russian", 11, "rus");
        m = new <init>("Spanish", 12, "spa");
        n = new <init>("Swedish", 13, "swe");
        o = new <init>("Thai", 14, "tha");
        p = new <init>("Turkish", 15, "tur");
        q = new <init>("BahasaIndonesia", 16, "ind");
        r = new <init>("Serbian", 17, "srp");
        t = (new t[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r
        });
    }

    private _cls9(String s1, int i1, String s2)
    {
        super(s1, i1);
        s = s2;
    }
}
