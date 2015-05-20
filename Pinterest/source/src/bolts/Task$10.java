// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            Continuation, Task

final class ct
    implements Runnable
{

    final Continuation a;
    final Task b;
    final kCompletionSource c;

    public final void run()
    {
        Task task = (Task)a.then(b);
        if (task == null)
        {
            class _cls1
                implements Continuation
            {

                final Task._cls10 a;

                public Object then(Task task1)
                {
                    if (task1.b())
                    {
                        a.c.b();
                    } else
                    if (task1.c())
                    {
                        a.c.a(task1.e());
                    } else
                    {
                        a.c.a(task1.d());
                    }
                    return null;
                }

            _cls1()
            {
                a = Task._cls10.this;
                super();
            }
            }

            try
            {
                c.a(null);
                return;
            }
            catch (Exception exception)
            {
                c.a(exception);
            }
            break MISSING_BLOCK_LABEL_53;
        }
        task.a(new _cls1());
        return;
    }

    rce(Continuation continuation, Task task, kCompletionSource kcompletionsource)
    {
        a = continuation;
        b = task;
        c = kcompletionsource;
        super();
    }
}
