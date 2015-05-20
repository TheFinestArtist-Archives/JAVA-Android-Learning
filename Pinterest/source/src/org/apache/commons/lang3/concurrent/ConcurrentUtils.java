// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package org.apache.commons.lang3.concurrent:
//            ConcurrentInitializer, ConcurrentException, ConcurrentRuntimeException

public class ConcurrentUtils
{

    private ConcurrentUtils()
    {
    }

    static Throwable checkedException(Throwable throwable)
    {
        if (throwable != null && !(throwable instanceof RuntimeException) && !(throwable instanceof Error))
        {
            return throwable;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Not a checked exception: ")).append(throwable).toString());
        }
    }

    public static Future constantFuture(Object obj)
    {
        return new ConstantFuture(obj);
    }

    public static Object createIfAbsent(ConcurrentMap concurrentmap, Object obj, ConcurrentInitializer concurrentinitializer)
    {
        Object obj1;
        if (concurrentmap == null || concurrentinitializer == null)
        {
            obj1 = null;
        } else
        {
            Object obj2 = concurrentmap.get(obj);
            obj1 = obj2;
            if (obj2 == null)
            {
                return putIfAbsent(concurrentmap, obj, concurrentinitializer.get());
            }
        }
        return obj1;
    }

    public static Object createIfAbsentUnchecked(ConcurrentMap concurrentmap, Object obj, ConcurrentInitializer concurrentinitializer)
    {
        try
        {
            concurrentmap = ((ConcurrentMap) (createIfAbsent(concurrentmap, obj, concurrentinitializer)));
        }
        // Misplaced declaration of an exception variable
        catch (ConcurrentMap concurrentmap)
        {
            throw new ConcurrentRuntimeException(concurrentmap.getCause());
        }
        return concurrentmap;
    }

    public static ConcurrentException extractCause(ExecutionException executionexception)
    {
        if (executionexception == null || executionexception.getCause() == null)
        {
            return null;
        } else
        {
            throwCause(executionexception);
            return new ConcurrentException(executionexception.getMessage(), executionexception.getCause());
        }
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionexception)
    {
        if (executionexception == null || executionexception.getCause() == null)
        {
            return null;
        } else
        {
            throwCause(executionexception);
            return new ConcurrentRuntimeException(executionexception.getMessage(), executionexception.getCause());
        }
    }

    public static void handleCause(ExecutionException executionexception)
    {
        executionexception = extractCause(executionexception);
        if (executionexception != null)
        {
            throw executionexception;
        } else
        {
            return;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionexception)
    {
        executionexception = extractCauseUnchecked(executionexception);
        if (executionexception != null)
        {
            throw executionexception;
        } else
        {
            return;
        }
    }

    public static Object initialize(ConcurrentInitializer concurrentinitializer)
    {
        if (concurrentinitializer != null)
        {
            return concurrentinitializer.get();
        } else
        {
            return null;
        }
    }

    public static Object initializeUnchecked(ConcurrentInitializer concurrentinitializer)
    {
        try
        {
            concurrentinitializer = ((ConcurrentInitializer) (initialize(concurrentinitializer)));
        }
        // Misplaced declaration of an exception variable
        catch (ConcurrentInitializer concurrentinitializer)
        {
            throw new ConcurrentRuntimeException(concurrentinitializer.getCause());
        }
        return concurrentinitializer;
    }

    public static Object putIfAbsent(ConcurrentMap concurrentmap, Object obj, Object obj1)
    {
        if (concurrentmap == null)
        {
            obj1 = null;
        } else
        {
            concurrentmap = ((ConcurrentMap) (concurrentmap.putIfAbsent(obj, obj1)));
            if (concurrentmap != null)
            {
                return concurrentmap;
            }
        }
        return obj1;
    }

    private static void throwCause(ExecutionException executionexception)
    {
        if (executionexception.getCause() instanceof RuntimeException)
        {
            throw (RuntimeException)executionexception.getCause();
        }
        if (executionexception.getCause() instanceof Error)
        {
            throw (Error)executionexception.getCause();
        } else
        {
            return;
        }
    }

    private class ConstantFuture
        implements Future
    {

        private final Object value;

        public final boolean cancel(boolean flag)
        {
            return false;
        }

        public final Object get()
        {
            return value;
        }

        public final Object get(long l, TimeUnit timeunit)
        {
            return value;
        }

        public final boolean isCancelled()
        {
            return false;
        }

        public final boolean isDone()
        {
            return true;
        }

        ConstantFuture(Object obj)
        {
            value = obj;
        }
    }

}
