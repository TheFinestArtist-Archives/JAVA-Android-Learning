// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            cv, ay, dk, df, 
//            cx, cj, cp, co, 
//            az

public final class nit> extends cv
{

    final String a;
    final ay b;

    public final void a()
    {
        Object obj = ay.a.f;
        if (((dk) (obj)).d())
        {
            return;
        } else
        {
            obj = ((dk) (obj)).e();
            ((df) (obj)).a("username", a);
            (new cx((new cj(ay.a)).a("metadata", ((df) (obj)).a()), new cp((new co(b.v.a(), "/android_v2/update_user_metadata")).a()))).run();
            return;
        }
    }

    public (ay ay1, String s)
    {
        b = ay1;
        a = s;
        super();
    }
}
