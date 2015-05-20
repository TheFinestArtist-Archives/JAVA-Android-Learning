// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.webkit.WebView;
import java.util.TimerTask;

final class val.webVw extends TimerTask
{

    final WebView val$webVw;

    public final void run()
    {
        try
        {
            val$webVw.destroy();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        val$webVw = webview;
        super();
    }
}
