// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.log;

import android.util.Log;
import com.pinterest.base.Constants;
import com.pinterest.base.CrashReporting;
import java.util.MissingFormatArgumentException;

public class PLog
{

    public static transient void a(String s, Object aobj[])
    {
        if (!Constants.DEBUG_OR_OTA)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        Log.i("PLog", String.format(s, aobj));
        return;
        aobj;
        Log.i("PLog", s);
        return;
        s;
        CrashReporting.logHandledException(s);
        return;
    }
}
