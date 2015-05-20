// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.tasks;


// Referenced classes of package com.pinterest.kit.tasks:
//            BackgroundTask

class <init>
    implements Runnable
{

    private BackgroundTask _task;

    public void run()
    {
        if (_task != null)
        {
            _task.onFinish();
        }
    }

    private (BackgroundTask backgroundtask)
    {
        _task = backgroundtask;
    }

    _task(BackgroundTask backgroundtask, _task _ptask)
    {
        this(backgroundtask);
    }
}
