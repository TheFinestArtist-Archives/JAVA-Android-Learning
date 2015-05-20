// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, Picasso, Action, Request, 
//            Utils

final class er extends Handler
{

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 3: default 40
    //                   3: 117
    //                   8: 67
    //                   13: 163;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(message.what).toString());
_L3:
        message = (List)message.obj;
        int k = message.size();
        for (int i = 0; i < k; i++)
        {
            BitmapHunter bitmaphunter = (BitmapHunter)message.get(i);
            bitmaphunter.b.a(bitmaphunter);
        }

        break; /* Loop/switch isn't completed */
_L2:
        message = (Action)message.obj;
        if (((Action) (message)).a.k)
        {
            Utils.a("Main", "canceled", ((Action) (message)).b.a(), "target got garbage collected");
        }
        Picasso.a(((Action) (message)).a, message.c());
_L6:
        return;
_L4:
        message = (List)message.obj;
        int l = message.size();
        int j = 0;
        while (j < l) 
        {
            Action action = (Action)message.get(j);
            action.a.c(action);
            j++;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    er(Looper looper)
    {
        super(looper);
    }
}
