// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            Continuation, Task

class ect
    implements Continuation
{

    final Continuation a;
    final Task b;

    public Object then(Task task)
    {
        if (task.c())
        {
            return Task.a(task.e());
        }
        if (task.b())
        {
            return Task.f();
        } else
        {
            return task.a(a);
        }
    }

    ation(Task task, Continuation continuation)
    {
        b = task;
        a = continuation;
        super();
    }
}
