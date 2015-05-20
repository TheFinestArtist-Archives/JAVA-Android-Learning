// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.location.GeofencingEvent;
import com.pinterest.base.Events;

public class GeofenceReceiver extends BroadcastReceiver
{

    public GeofenceReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
label0:
        {
            context = GeofencingEvent.fromIntent(intent);
            if (context != null)
            {
                if (!context.hasError())
                {
                    break label0;
                }
                (new StringBuilder("Location Services error: ")).append(context.getErrorCode());
            }
            return;
        }
        Events.post(new UpdateEvent(context.getTriggeringGeofences()));
    }

    private class UpdateEvent
    {

        private List a;

        public final List a()
        {
            return a;
        }

        public UpdateEvent(List list)
        {
            a = list;
        }
    }

}
