// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event.util;

import android.util.Log;
import de.greenrobot.event.EventBus;
import java.lang.reflect.Constructor;

// Referenced classes of package de.greenrobot.event.util:
//            AsyncExecutor, HasExecutionScope

class nnableEx
    implements Runnable
{

    final AsyncExecutor this$0;
    final nnableEx val$runnable;

    public void run()
    {
        Object obj;
        try
        {
            val$runnable.run();
            return;
        }
        catch (Exception exception)
        {
            try
            {
                obj = AsyncExecutor.access$200(AsyncExecutor.this).newInstance(new Object[] {
                    exception
                });
            }
            catch (Exception exception1)
            {
                Log.e(EventBus.TAG, "Original exception:", exception);
                throw new RuntimeException("Could not create failure event", exception1);
            }
        }
        if (exception instanceof HasExecutionScope)
        {
            ((HasExecutionScope)exception).setExecutionScope(AsyncExecutor.access$300(AsyncExecutor.this));
        }
        AsyncExecutor.access$400(AsyncExecutor.this).post(obj);
    }

    nnableEx()
    {
        this$0 = final_asyncexecutor;
        val$runnable = nnableEx.this;
        super();
    }
}
