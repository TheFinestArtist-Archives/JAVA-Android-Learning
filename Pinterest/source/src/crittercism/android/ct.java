// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.net.URL;
import java.util.Map;

// Referenced classes of package crittercism.android:
//            cv, bj, cj, be, 
//            cx, cp, au, cl

final class ct extends cv
{

    private bj a;
    private bj b;
    private au c;
    private URL d;
    private String e;
    private cl f;

    ct(bj bj1, bj bj2, au au, URL url, cl cl)
    {
        bj1.e();
        b = bj1;
        a = bj2;
        c = au;
        d = url;
        e = bj1.e();
        f = cl;
    }

    public final void a()
    {
        a.a(b);
        cj cj1 = new cj(c);
        String s = e;
        bj bj1 = b;
        cj1.a.put(s, (new be(bj1)).a);
        (new cx(cj1, new cp(d), true, f)).run();
    }
}
