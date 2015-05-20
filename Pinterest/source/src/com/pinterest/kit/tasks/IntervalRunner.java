// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class IntervalRunner
{

    private static final int DEFAULT_DORMANT_INTERVAL = 1;
    private static final int DEFAULT_UPDATE_INTERVAL = 10;
    private static IntervalRunner instance;
    private final Map callbacks;
    private int dormantInterval;
    private Timer dormantTimer;
    private int updateInterval;
    private Timer updateTimer;

    public IntervalRunner()
    {
        this(10);
    }

    public IntervalRunner(int i)
    {
        updateInterval = 10000;
        dormantInterval = 1000;
        callbacks = Collections.synchronizedMap(new HashMap());
        setUpdateInterval(i);
    }

    private final void callbackInterval()
    {
        ArrayList arraylist = new ArrayList(callbacks.values());
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((IntervalCallback)iterator.next()).onInterval()) { }
        arraylist.clear();
    }

    private final void callbackStart()
    {
        ArrayList arraylist = new ArrayList(callbacks.values());
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((IntervalCallback)iterator.next()).onStart()) { }
        arraylist.clear();
    }

    private final void callbackStop()
    {
        ArrayList arraylist = new ArrayList(callbacks.values());
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((IntervalCallback)iterator.next()).onStop()) { }
        arraylist.clear();
    }

    public static IntervalRunner instance()
    {
        if (instance == null)
        {
            IntervalRunner intervalrunner = new IntervalRunner();
            instance = intervalrunner;
            intervalrunner.start();
        }
        return instance;
    }

    public void addCallback(IntervalCallback intervalcallback)
    {
        callbacks.put(String.valueOf(intervalcallback.hashCode()), intervalcallback);
    }

    public int getUpdateInterval()
    {
        return updateInterval;
    }

    public final void onBackground()
    {
        if (dormantTimer != null)
        {
            dormantTimer.cancel();
        }
        dormantTimer = new Timer();
        dormantTimer.schedule(new _cls2(), dormantInterval);
    }

    public final void onForeground()
    {
        if (dormantTimer != null)
        {
            dormantTimer.cancel();
            dormantTimer = null;
        }
        start();
    }

    public void removeCallback(IntervalCallback intervalcallback)
    {
        callbacks.remove(String.valueOf(intervalcallback.hashCode()));
    }

    public void setDormantInterval(int i)
    {
        dormantInterval = i * 1000;
    }

    public void setUpdateInterval(int i)
    {
        updateInterval = i * 1000;
        if (updateTimer != null)
        {
            stop();
            start();
        }
    }

    public final void start()
    {
        if (updateTimer != null)
        {
            return;
        } else
        {
            updateTimer = new Timer();
            updateTimer.scheduleAtFixedRate(new _cls1(), updateInterval, updateInterval);
            callbackStart();
            return;
        }
    }

    public final void stop()
    {
        if (updateTimer == null)
        {
            return;
        } else
        {
            updateTimer.cancel();
            updateTimer = null;
            callbackStop();
            return;
        }
    }


    private class IntervalCallback
    {

        public abstract void onInterval();

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public IntervalCallback()
        {
        }
    }


    private class _cls2 extends TimerTask
    {

        final IntervalRunner this$0;

        public void run()
        {
            stop();
        }

        _cls2()
        {
            this$0 = IntervalRunner.this;
            super();
        }
    }


    private class _cls1 extends TimerTask
    {

        final IntervalRunner this$0;

        public void run()
        {
            callbackInterval();
        }

        _cls1()
        {
            this$0 = IntervalRunner.this;
            super();
        }
    }

}
