// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            by, bn, bg, bv, 
//            bo, bz

public final class bi extends Enum
{

    public static final bi a;
    public static final bi b;
    public static final bi c;
    public static final bi d;
    public static final bi e;
    public static final bi f;
    public static final bi g;
    private static final bi p[];
    private String h;
    private int i;
    private int j;
    private bv k;
    private bo l;
    private bz m;
    private String n;
    private String o;

    private bi(String s, int i1, String s1, int j1, int k1, bv bv, bo bo, 
            bz bz, String s2, String s3)
    {
        super(s, i1);
        h = s1;
        i = j1;
        j = k1;
        k = bv;
        l = bo;
        m = bz;
        n = s2;
        o = s3;
    }

    public static bi valueOf(String s)
    {
        return (bi)Enum.valueOf(crittercism/android/bi, s);
    }

    public static bi[] values()
    {
        return (bi[])p.clone();
    }

    public final String a()
    {
        return h;
    }

    public final int b()
    {
        return i;
    }

    public final bv c()
    {
        return k;
    }

    public final bo d()
    {
        return l;
    }

    public final bz e()
    {
        return m;
    }

    public final String f()
    {
        return n;
    }

    public final int g()
    {
        return j;
    }

    public final String h()
    {
        return o;
    }

    static 
    {
        a = new bi("APP_LOADS", 0, "app_loads", 10, 0x7fffffff, new by(), null, new bs.a(), "/android_v2/handle_app_loads", "app_loads");
        b = new bi("HAND_EXCS", 1, "exceptions", 5, 50, new by(), new bn(), new bs.a(), "/android_v2/handle_exceptions", "exceptions");
        c = new bi("NDK_CRASHES", 2, "ndk_crashes", 0x7fffffff, 0x7fffffff, new by(), null, new bs.a(), "/android_v2/handle_ndk_crashes", "crashes");
        d = new bi("SDK_CRASHES", 3, "sdk_crashes", 0x7fffffff, 0x7fffffff, new by(), null, new bs.a(), "/android_v2/handle_crashes", "crashes");
        e = new bi("CURR_BCS", 4, "current_bcs", 50, 0x7fffffff, new by(), new bg(true), new br.a(), null, null);
        f = new bi("NW_BCS", 5, "network_bcs", 10, 0x7fffffff, new by(), new bg(false), new br.a(), null, null);
        g = new bi("PREV_BCS", 6, "previous_bcs", 50, 0x7fffffff, new by(), new bg(false), new br.a(), null, null);
        p = (new bi[] {
            a, b, c, d, e, f, g
        });
    }
}
