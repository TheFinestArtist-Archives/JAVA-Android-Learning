// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.yozio.android.async.Async;
import com.yozio.android.async.MetaDataCallbackTask;
import com.yozio.android.async.TrackAndroidAppInsallWithReferrerTask;

// Referenced classes of package com.yozio.android:
//            YozioService

public class YozioReferrerReceiver extends BroadcastReceiver
{

    public YozioReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        YozioService.log(Constants.LOG_LEVEL.INFO, (new StringBuilder("YozioReferrerReceiver - Intent:")).append(intent.toString()).toString());
        intent = intent.getStringExtra("referrer");
        Async.getInstance().runTrackAppInstallWithReferrerTask(new TrackAndroidAppInsallWithReferrerTask(context, intent));
        Async.getInstance().runMetaDataCallbackTask(new MetaDataCallbackTask(context, intent));
    }
}
