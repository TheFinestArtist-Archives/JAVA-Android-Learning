// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;

// Referenced classes of package com.squareup.picasso:
//            Dispatcher, Utils

class a extends BroadcastReceiver
{

    private final Dispatcher a;

    final void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (a.o)
        {
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        a.b.registerReceiver(this, intentfilter);
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = intent.getAction();
        if (!"android.intent.action.AIRPLANE_MODE".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.hasExtra("state")) goto _L1; else goto _L3
_L3:
        context = a;
        boolean flag = intent.getBooleanExtra("state", false);
        intent = ((Dispatcher) (context)).i;
        context = ((Dispatcher) (context)).i;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        intent.sendMessage(context.obtainMessage(10, i, 0));
        return;
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
        intent = (ConnectivityManager)Utils.a(context, "connectivity");
        context = a;
        intent = intent.getActiveNetworkInfo();
        ((Dispatcher) (context)).i.sendMessage(((Dispatcher) (context)).i.obtainMessage(9, intent));
        return;
    }

    (Dispatcher dispatcher)
    {
        a = dispatcher;
    }
}
