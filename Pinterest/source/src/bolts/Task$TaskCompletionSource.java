// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            Task

public class <init>
{

    final Task a;

    private boolean b(Exception exception)
    {
label0:
        {
            synchronized (Task.a(a))
            {
                if (!Task.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        Task.c(a);
        Task.a(a, exception);
        Task.a(a).notifyAll();
        Task.e(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean b(Object obj)
    {
label0:
        {
            synchronized (Task.a(a))
            {
                if (!Task.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        Task.c(a);
        Task.a(a, obj);
        Task.a(a).notifyAll();
        Task.e(a);
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private boolean c()
    {
label0:
        {
            synchronized (Task.a(a))
            {
                if (!Task.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        Task.c(a);
        Task.d(a);
        Task.a(a).notifyAll();
        Task.e(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Task a()
    {
        return a;
    }

    public final void a(Exception exception)
    {
        if (!b(exception))
        {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        } else
        {
            return;
        }
    }

    public final void a(Object obj)
    {
        if (!b(obj))
        {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        } else
        {
            return;
        }
    }

    public final void b()
    {
        if (!c())
        {
            throw new IllegalStateException("Cannot cancel a completed task.");
        } else
        {
            return;
        }
    }

    private (Task task)
    {
        a = task;
        super();
    }

    a(Task task, byte byte0)
    {
        this(task);
    }
}
