// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


// Referenced classes of package crittercism.android:
//            bm, aw

public final class de
    implements bm
{

    public boolean a;

    public de(boolean flag)
    {
        a = flag;
    }

    public final void a(aw aw1, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aw1.a(s, s1, Boolean.valueOf(a).booleanValue());
        this;
        JVM INSTR monitorexit ;
        return;
        aw1;
        throw aw1;
    }

    public final Object b()
    {
        return Boolean.valueOf(a);
    }
}
