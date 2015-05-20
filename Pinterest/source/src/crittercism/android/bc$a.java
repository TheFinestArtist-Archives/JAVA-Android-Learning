// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class d extends Enum
{

    public static final b a;
    public static final b b;
    private static final b f[];
    private String c;
    private String d;
    private String e;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(crittercism/android/bc$a, s);
    }

    public static d[] values()
    {
        return (d[])f.clone();
    }

    public final String a()
    {
        return e;
    }

    public final String b()
    {
        return c;
    }

    public final String c()
    {
        return d;
    }

    static 
    {
        a = new <init>("SDK", 0, "uhe", "crashed_session", "previous_session");
        b = new <init>("EXC", 1, "he", "current_session", "previous_session");
        f = (new f[] {
            a, b
        });
    }

    private (String s, int i, String s1, String s2, String s3)
    {
        super(s, i);
        e = s1;
        c = s2;
        d = s3;
    }
}
