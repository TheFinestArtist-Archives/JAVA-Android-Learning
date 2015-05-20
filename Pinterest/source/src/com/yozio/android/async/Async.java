// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.async;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Async
{

    private static Async _instance = new Async();
    private final ThreadPoolExecutor _yozio_events_executor;
    private final ThreadPoolExecutor _yozio_meta_data_callback_executor;
    private final ThreadPoolExecutor _yozio_track_app_install_executor;
    private final ThreadPoolExecutor _yozio_track_app_install_with_referer_executor;
    private final ThreadPoolExecutor _yozio_track_yozio_deeplink_with_meta_data_executor;

    private Async()
    {
        _yozio_track_app_install_with_referer_executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        _yozio_meta_data_callback_executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        _yozio_track_app_install_executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        _yozio_track_yozio_deeplink_with_meta_data_executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        _yozio_events_executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static Async getInstance()
    {
        return _instance;
    }

    public void runEventsTask(Runnable runnable)
    {
        _yozio_events_executor.submit(runnable);
    }

    public void runMetaDataCallbackTask(Runnable runnable)
    {
        _yozio_meta_data_callback_executor.submit(runnable);
    }

    public void runTrackAppInstallTask(Runnable runnable)
    {
        _yozio_track_app_install_executor.submit(runnable);
    }

    public void runTrackAppInstallWithReferrerTask(Runnable runnable)
    {
        _yozio_track_app_install_with_referer_executor.submit(runnable);
    }

    public void runTrackYozioDeeplinkWithMetaDataTask(Runnable runnable)
    {
        _yozio_track_yozio_deeplink_with_meta_data_executor.submit(runnable);
    }

}
