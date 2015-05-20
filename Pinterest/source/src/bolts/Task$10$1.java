// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            Continuation, Task

class 
    implements Continuation
{

    final  a;

    public Object then(Task task)
    {
        if (task.b())
        {
            a.a.b();
        } else
        if (task.c())
        {
            a.a.a(task.e());
        } else
        {
            a.a.a(task.d());
        }
        return null;
    }

    ( )
    {
        a = ;
        super();
    }
}
