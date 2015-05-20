// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.kit.log.PLog;
import com.yozio.android.YozioReferrerReceiver;

public class MasterInstallReferrerReceiver extends BroadcastReceiver
{

    public MasterInstallReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        AnalyticsApi.a("install_referrer");
        PLog.a((new StringBuilder("MasterInstallReferrerReceiver installed: ")).append(intent.getStringExtra("referrer")).toString(), new Object[0]);
        (new YozioReferrerReceiver()).onReceive(context, intent);
    }
}
