// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.util.Log;

// Referenced classes of package crittercism.android:
//            ay, dk, de, cs, 
//            bc, bj, cr, az

public final class ax
    implements Thread.UncaughtExceptionHandler
{

    private Thread.UncaughtExceptionHandler a;

    public ax(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        a = uncaughtexceptionhandler;
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        thread = ay.r();
        try
        {
            dk dk1 = ((ay) (thread)).f;
            dk1.a().a = true;
            dk1.a(thread);
        }
        catch (Exception exception)
        {
            (new StringBuilder("Did not log error to Crittercism.  EXCEPTION: ")).append(exception.getClass().getName());
        }
        if (((ay) (thread)).o == null)
        {
            Log.e("Crittercism", "Unable to handle application crash. Crittercism not yet initialized");
        } else
        {
            ((ay) (thread)).o.b();
            if (!((ay) (thread)).f.d())
            {
                Object obj = new bc(throwable, Thread.currentThread().getId(), bc.a.a, ((ay) (thread)).k, ((ay) (thread)).l, ((ay) (thread)).m);
                ((ay) (thread)).j.a(((bk) (obj)));
                obj = new cr(((ay) (thread)).c, thread);
                ((cr) (obj)).a(((ay) (thread)).g, new cn.a(), ((ay) (thread)).v.a());
                ((cr) (obj)).a(((ay) (thread)).h, new cn.a(), ((ay) (thread)).v.a());
                ((cr) (obj)).a(((ay) (thread)).i, new cn.a(), ((ay) (thread)).v.a());
                ((cr) (obj)).a(((ay) (thread)).j, new cn.a(), ((ay) (thread)).v.a());
                try
                {
                    ((cr) (obj)).a();
                }
                catch (InterruptedException interruptedexception)
                {
                    (new StringBuilder("InterruptedException in logCrashException: ")).append(interruptedexception.getMessage());
                }
                catch (Throwable throwable1)
                {
                    (new StringBuilder("Unexpected throwable in logCrashException: ")).append(throwable1.getMessage());
                }
            }
            if (((ay) (thread)).e != null && !(((ay) (thread)).e instanceof ax))
            {
                ((ay) (thread)).e.uncaughtException(Thread.currentThread(), throwable);
                return;
            }
        }
    }
}
