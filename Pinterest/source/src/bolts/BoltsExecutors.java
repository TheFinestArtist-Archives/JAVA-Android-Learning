// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package bolts:
//            AndroidExecutors

final class BoltsExecutors
{

    private static final BoltsExecutors a = new BoltsExecutors();
    private final ExecutorService b;
    private final Executor c = new ImmediateExecutor((byte)0);

    private BoltsExecutors()
    {
        Object obj = System.getProperty("java.runtime.name");
        boolean flag;
        if (obj == null)
        {
            flag = false;
        } else
        {
            flag = ((String) (obj)).toLowerCase(Locale.US).contains("android");
        }
        if (!flag)
        {
            obj = Executors.newCachedThreadPool();
        } else
        {
            obj = AndroidExecutors.a();
        }
        b = ((ExecutorService) (obj));
    }

    public static ExecutorService a()
    {
        return a.b;
    }

    static Executor b()
    {
        return a.c;
    }


    private class ImmediateExecutor
        implements Executor
    {

        private ThreadLocal a;

        private int a()
        {
            Integer integer1 = (Integer)a.get();
            Integer integer = integer1;
            if (integer1 == null)
            {
                integer = Integer.valueOf(0);
            }
            int i = integer.intValue() - 1;
            if (i == 0)
            {
                a.remove();
                return i;
            } else
            {
                a.set(Integer.valueOf(i));
                return i;
            }
        }

        public void execute(Runnable runnable)
        {
            int i;
            Integer integer1 = (Integer)a.get();
            Integer integer = integer1;
            if (integer1 == null)
            {
                integer = Integer.valueOf(0);
            }
            i = integer.intValue() + 1;
            a.set(Integer.valueOf(i));
            if (i > 15) goto _L2; else goto _L1
_L1:
            runnable.run();
_L4:
            a();
            return;
_L2:
            BoltsExecutors.a().execute(runnable);
            if (true) goto _L4; else goto _L3
_L3:
            runnable;
            a();
            throw runnable;
        }

        private ImmediateExecutor()
        {
            a = new ThreadLocal();
        }

        ImmediateExecutor(byte byte0)
        {
            this();
        }
    }

}
