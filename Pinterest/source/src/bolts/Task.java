// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package bolts:
//            BoltsExecutors, AndroidExecutors, Continuation

public class Task
{

    public static final ExecutorService a = BoltsExecutors.a();
    public static final Executor b = AndroidExecutors.b();
    private static final Executor c = BoltsExecutors.b();
    private final Object d = new Object();
    private boolean e;
    private boolean f;
    private Object g;
    private Exception h;
    private List i;

    private Task()
    {
        i = new ArrayList();
    }

    public static TaskCompletionSource a()
    {
        Task task = new Task();
        task.getClass();
        return task. new TaskCompletionSource((byte)0);
    }

    private Task a(Continuation continuation, Executor executor)
    {
        TaskCompletionSource taskcompletionsource = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i.add(new _cls5(taskcompletionsource, continuation, executor));
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            c(taskcompletionsource, continuation, this, executor);
        }
        return taskcompletionsource.a;
        continuation;
        obj;
        JVM INSTR monitorexit ;
        throw continuation;
    }

    public static Task a(Exception exception)
    {
        TaskCompletionSource taskcompletionsource = a();
        taskcompletionsource.a(exception);
        return taskcompletionsource.a;
    }

    public static Task a(Object obj)
    {
        TaskCompletionSource taskcompletionsource = a();
        taskcompletionsource.a(obj);
        return taskcompletionsource.a;
    }

    static Exception a(Task task, Exception exception)
    {
        task.h = exception;
        return exception;
    }

    static Object a(Task task)
    {
        return task.d;
    }

    static Object a(Task task, Object obj)
    {
        task.g = obj;
        return obj;
    }

    static void a(TaskCompletionSource taskcompletionsource, Continuation continuation, Task task, Executor executor)
    {
        c(taskcompletionsource, continuation, task, executor);
    }

    private Task b(Continuation continuation, Executor executor)
    {
        TaskCompletionSource taskcompletionsource = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i.add(new _cls6(taskcompletionsource, continuation, executor));
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            d(taskcompletionsource, continuation, this, executor);
        }
        return taskcompletionsource.a;
        continuation;
        obj;
        JVM INSTR monitorexit ;
        throw continuation;
    }

    static void b(TaskCompletionSource taskcompletionsource, Continuation continuation, Task task, Executor executor)
    {
        d(taskcompletionsource, continuation, task, executor);
    }

    static boolean b(Task task)
    {
        return task.e;
    }

    private static void c(TaskCompletionSource taskcompletionsource, Continuation continuation, Task task, Executor executor)
    {
        executor.execute(new _cls9(continuation, task, taskcompletionsource));
    }

    static boolean c(Task task)
    {
        task.e = true;
        return true;
    }

    private static void d(TaskCompletionSource taskcompletionsource, Continuation continuation, Task task, Executor executor)
    {
        executor.execute(new _cls10(continuation, task, taskcompletionsource));
    }

    static boolean d(Task task)
    {
        task.f = true;
        return true;
    }

    static void e(Task task)
    {
        Object obj = task.d;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = task.i.iterator();
_L1:
        Continuation continuation;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        continuation = (Continuation)iterator.next();
        continuation.then(task);
          goto _L1
        task;
        throw task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
        task;
        throw new RuntimeException(task);
        task.i = null;
        obj;
        JVM INSTR monitorexit ;
    }

    public static Task f()
    {
        TaskCompletionSource taskcompletionsource = a();
        taskcompletionsource.b();
        return taskcompletionsource.a;
    }

    private boolean g()
    {
        boolean flag;
        synchronized (d)
        {
            flag = e;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Task a(Continuation continuation)
    {
        return a(continuation, c);
    }

    public final Task b(Continuation continuation)
    {
        Executor executor = c;
        return b(((Continuation) (new _cls7(continuation))), executor);
    }

    public final boolean b()
    {
        boolean flag;
        synchronized (d)
        {
            flag = f;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean c()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (h != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object d()
    {
        Object obj1;
        synchronized (d)
        {
            obj1 = g;
        }
        return obj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Exception e()
    {
        Exception exception;
        synchronized (d)
        {
            exception = h;
        }
        return exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }


    private class TaskCompletionSource
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

        private TaskCompletionSource()
        {
            a = Task.this;
            super();
        }

        TaskCompletionSource(byte byte0)
        {
            this();
        }
    }


    private class _cls5
        implements Continuation
    {

        final TaskCompletionSource a;
        final Continuation b;
        final Executor c;
        final Task d;

        public Object then(Task task)
        {
            Task.a(a, b, task, c);
            return null;
        }

        _cls5(TaskCompletionSource taskcompletionsource, Continuation continuation, Executor executor)
        {
            d = Task.this;
            a = taskcompletionsource;
            b = continuation;
            c = executor;
            super();
        }
    }


    private class _cls6
        implements Continuation
    {

        final TaskCompletionSource a;
        final Continuation b;
        final Executor c;
        final Task d;

        public Object then(Task task)
        {
            Task.b(a, b, task, c);
            return null;
        }

        _cls6(TaskCompletionSource taskcompletionsource, Continuation continuation, Executor executor)
        {
            d = Task.this;
            a = taskcompletionsource;
            b = continuation;
            c = executor;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final Continuation a;
        final Task b;
        final TaskCompletionSource c;

        public final void run()
        {
            try
            {
                Object obj = a.then(b);
                c.a(obj);
                return;
            }
            catch (Exception exception)
            {
                c.a(exception);
            }
        }

        _cls9(Continuation continuation, Task task, TaskCompletionSource taskcompletionsource)
        {
            a = continuation;
            b = task;
            c = taskcompletionsource;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final Continuation a;
        final Task b;
        final TaskCompletionSource c;

        public final void run()
        {
            Task task = (Task)a.then(b);
            if (task == null)
            {
                class _cls1
                    implements Continuation
                {

                    final _cls10 a;

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
                    a = _cls10.this;
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

        _cls10(Continuation continuation, Task task, TaskCompletionSource taskcompletionsource)
        {
            a = continuation;
            b = task;
            c = taskcompletionsource;
            super();
        }
    }


    private class _cls7
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

        _cls7(Continuation continuation)
        {
            b = Task.this;
            a = continuation;
            super();
        }
    }

}
