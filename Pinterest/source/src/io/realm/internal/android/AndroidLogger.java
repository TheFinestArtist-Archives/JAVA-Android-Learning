// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal.android;

import android.util.Log;
import io.realm.internal.log.Logger;

public class AndroidLogger
    implements Logger
{

    private static final int LOG_ENTRY_MAX_LENGTH = 4000;
    private String logTag;
    private int minimumLogLevel;

    public AndroidLogger()
    {
        minimumLogLevel = 2;
        logTag = "REALM";
    }

    private void log(int j, String s, Throwable throwable)
    {
        if (j >= minimumLogLevel) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (s != null && s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (throwable == null) goto _L1; else goto _L3
_L3:
        String s1 = Log.getStackTraceString(throwable);
_L4:
        if (s1.length() < 4000)
        {
            Log.println(j, logTag, s1);
            return;
        } else
        {
            logMessageIgnoringLimit(j, logTag, s1);
            return;
        }
        s1 = s;
        if (throwable != null)
        {
            s1 = (new StringBuilder()).append(s).append("\n").append(Log.getStackTraceString(throwable)).toString();
        }
          goto _L4
    }

    private void logMessageIgnoringLimit(int j, String s, String s1)
    {
        while (s1.length() != 0) 
        {
            int l = s1.indexOf('\n');
            int k;
            if (l != -1)
            {
                k = l;
            } else
            {
                k = s1.length();
            }
            k = Math.min(k, 4000);
            Log.println(j, s, s1.substring(0, k));
            if (l != -1 && l == k)
            {
                s1 = s1.substring(k + 1);
            } else
            {
                s1 = s1.substring(k);
            }
        }
    }

    public void d(String s)
    {
        log(3, s, null);
    }

    public void d(String s, Throwable throwable)
    {
        log(3, s, throwable);
    }

    public void e(String s)
    {
        log(6, s, null);
    }

    public void e(String s, Throwable throwable)
    {
        log(6, s, throwable);
    }

    public void i(String s)
    {
        log(4, s, null);
    }

    public void i(String s, Throwable throwable)
    {
        log(4, s, throwable);
    }

    public void setMinimumLogLevel(int j)
    {
        minimumLogLevel = j;
    }

    public void setTag(String s)
    {
        logTag = s;
    }

    public void v(String s)
    {
        log(2, s, null);
    }

    public void v(String s, Throwable throwable)
    {
        log(2, s, throwable);
    }

    public void w(String s)
    {
        log(5, s, null);
    }

    public void w(String s, Throwable throwable)
    {
        log(5, s, throwable);
    }
}
