// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import android.os.SystemClock;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.experiment.Experiments;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StopWatch
{

    public static final String CATEGORY_TTRFP = "category_ttrfp";
    public static final String CLICKTHROUGH_VERIFY = "clickthrough_verify";
    private static final String DEFAULT_STOPWATCH = "__DEFAULT_STOPWATCH__";
    public static final String INTEREST_TTRFP = "interest_ttrfp";
    public static final String LOGIN_EMAIL = "login_email";
    private static final Set NEW_PERF_METRICS;
    public static final String PIN_CLOSEUP = "pin_closeup";
    public static final String REPIN_DIALOG = "repin_dialog";
    public static final String REPIN_SUBMIT = "repin_submit";
    public static final String SEARCH_TTRFP = "search_ttrfp";
    public static final String SIGNUP_EMAIL = "signup_email";
    private static final String TAG = "StopWatch";
    public static final String TTRFP = "ttrfp";
    private static final HashMap _stopWatches = new HashMap();
    private final HashMap _markers = new HashMap();

    public StopWatch()
    {
    }

    public static StopWatch get()
    {
        return get("__DEFAULT_STOPWATCH__");
    }

    public static StopWatch get(String s)
    {
        StopWatch stopwatch1 = (StopWatch)_stopWatches.get(s);
        StopWatch stopwatch = stopwatch1;
        if (stopwatch1 == null)
        {
            stopwatch = new StopWatch();
            _stopWatches.put(s, stopwatch);
        }
        return stopwatch;
    }

    private static transient void log(String s, Object aobj[])
    {
    }

    public StopWatch complete(String s)
    {
        return complete(s, false, null);
    }

    public StopWatch complete(String s, boolean flag, String s1)
    {
        long l = stop(s);
        if (l != -1L && (Experiments.i() || !NEW_PERF_METRICS.contains(s)))
        {
            AnalyticsApi.a(s, l, flag, s1);
        }
        return this;
    }

    public StopWatch invalidate(String s)
    {
        _markers.remove(s);
        return this;
    }

    public StopWatch invalidateAll()
    {
        for (Iterator iterator = (new HashSet(_markers.keySet())).iterator(); iterator.hasNext(); invalidate((String)iterator.next())) { }
        return this;
    }

    public boolean isActive(String s)
    {
        return _markers.containsKey(s);
    }

    public StopWatch start(String s)
    {
        _markers.put(s, Long.valueOf(SystemClock.elapsedRealtime()));
        return this;
    }

    public long stop(String s)
    {
        long l = SystemClock.elapsedRealtime();
        s = (Long)_markers.remove(s);
        if (s == null || s.longValue() == -1L)
        {
            return -1L;
        } else
        {
            return l - s.longValue();
        }
    }

    static 
    {
        HashSet hashset = new HashSet();
        NEW_PERF_METRICS = hashset;
        hashset.add("pin_closeup");
        NEW_PERF_METRICS.add("category_ttrfp");
        NEW_PERF_METRICS.add("interest_ttrfp");
        NEW_PERF_METRICS.add("clickthrough_verify");
        NEW_PERF_METRICS.add("repin_submit");
        NEW_PERF_METRICS.add("repin_dialog");
        NEW_PERF_METRICS.add("search_ttrfp");
        NEW_PERF_METRICS.add("login_email");
        NEW_PERF_METRICS.add("signup_email");
    }
}
