// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.pinterest.service:
//            PinUploader

public class PinterestWorkerService extends Service
{

    private boolean _running;

    public PinterestWorkerService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        (new PinUploader(this)).startContinuousUpload();
    }

    public void onDestroy()
    {
        _running = false;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (_running)
        {
            return 2;
        } else
        {
            _running = true;
            return 2;
        }
    }
}
