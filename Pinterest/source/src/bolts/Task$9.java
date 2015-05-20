// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            Continuation, Task

final class ect
    implements Runnable
{

    final Continuation a;
    final Task b;
    final skCompletionSource c;

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

    ource(Continuation continuation, Task task, skCompletionSource skcompletionsource)
    {
        a = continuation;
        b = task;
        c = skcompletionsource;
        super();
    }
}
