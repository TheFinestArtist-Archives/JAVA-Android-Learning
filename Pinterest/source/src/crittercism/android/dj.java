// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            bm, aw

public final class dj
    implements bm
{

    public int a;

    public dj(int i)
    {
        a = i;
    }

    public final void a(aw aw1, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aw1.a(s, s1, Integer.valueOf(a).intValue());
        this;
        JVM INSTR monitorexit ;
        return;
        aw1;
        throw aw1;
    }

    public final Object b()
    {
        return Integer.valueOf(a);
    }
}
