// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;

// Referenced classes of package crittercism.android:
//            cv, au, dk, cf, 
//            aw, di, dj

public final class cu extends cv
{

    private Context a;
    private aw b;
    private dk c;

    public cu(Context context, au au1, aw aw1)
    {
        a = context;
        b = aw1;
        c = au1.i();
    }

    public final void a()
    {
        c.b(b);
        b.a(cf.i.a(), cf.i.b(), false);
        if (c.d())
        {
            return;
        } else
        {
            c.b().a(b, cf.h.a(), cf.h.b());
            c.c().a(b, cf.k.a(), cf.k.b());
            return;
        }
    }
}
