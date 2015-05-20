// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.squareup.picasso:
//            Picasso, Action, Dispatcher, BitmapHunter, 
//            Request, Utils

class a extends Handler
{

    private final Dispatcher a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 12: default 68
    //                   1 85
    //                   2 103
    //                   3 68
    //                   4 663
    //                   5 680
    //                   6 697
    //                   7 715
    //                   8 68
    //                   9 723
    //                   10 740
    //                   11 294
    //                   12 649;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L7 _L1 _L8 _L9 _L10 _L11
_L4:
        break MISSING_BLOCK_LABEL_663;
_L5:
        break MISSING_BLOCK_LABEL_680;
_L6:
        break MISSING_BLOCK_LABEL_697;
_L7:
        break MISSING_BLOCK_LABEL_715;
_L8:
        break MISSING_BLOCK_LABEL_723;
_L9:
        break MISSING_BLOCK_LABEL_740;
_L1:
        class _cls1
            implements Runnable
        {

            final Message a;
            final Dispatcher.DispatcherHandler b;

            public void run()
            {
                throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
            }

            _cls1(Message message)
            {
                b = Dispatcher.DispatcherHandler.this;
                a = message;
                super();
            }
        }

        Picasso.a.post(new _cls1(message));
_L12:
        return;
_L2:
        message = (Action)message.obj;
        a.a(message, true);
        return;
_L3:
        message = (Action)message.obj;
        Dispatcher dispatcher = a;
        String s = ((Action) (message)).h;
        BitmapHunter bitmaphunter = (BitmapHunter)dispatcher.e.get(s);
        if (bitmaphunter != null)
        {
            bitmaphunter.a(message);
            if (bitmaphunter.b())
            {
                dispatcher.e.remove(s);
                if (((Action) (message)).a.k)
                {
                    Utils.a("Dispatcher", "canceled", ((Action) (message)).b.a());
                }
            }
        }
        if (dispatcher.h.contains(((Action) (message)).i))
        {
            dispatcher.g.remove(message.c());
            if (((Action) (message)).a.k)
            {
                Utils.a("Dispatcher", "canceled", ((Action) (message)).b.a(), "because paused request got canceled");
            }
        }
        message = (Action)dispatcher.f.remove(message.c());
        if (message != null && ((Action) (message)).a.k)
        {
            Utils.a("Dispatcher", "canceled", ((Action) (message)).b.a(), "from replaying");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        message = ((Message) (message.obj));
        Dispatcher dispatcher1 = a;
        if (dispatcher1.h.add(message))
        {
            Iterator iterator = dispatcher1.e.values().iterator();
            while (iterator.hasNext()) 
            {
                BitmapHunter bitmaphunter1 = (BitmapHunter)iterator.next();
                boolean flag = bitmaphunter1.b.k;
                Action action = bitmaphunter1.j;
                List list = bitmaphunter1.k;
                int i;
                if (list != null && !list.isEmpty())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (action != null || i != 0)
                {
                    if (action != null && action.i.equals(message))
                    {
                        bitmaphunter1.a(action);
                        dispatcher1.g.put(action.c(), action);
                        if (flag)
                        {
                            Utils.a("Dispatcher", "paused", action.b.a(), (new StringBuilder("because tag '")).append(message).append("' was paused").toString());
                        }
                    }
                    if (i != 0)
                    {
                        for (i = list.size() - 1; i >= 0; i--)
                        {
                            Action action1 = (Action)list.get(i);
                            if (!action1.i.equals(message))
                            {
                                continue;
                            }
                            bitmaphunter1.a(action1);
                            dispatcher1.g.put(action1.c(), action1);
                            if (flag)
                            {
                                Utils.a("Dispatcher", "paused", action1.b.a(), (new StringBuilder("because tag '")).append(message).append("' was paused").toString());
                            }
                        }

                    }
                    if (bitmaphunter1.b())
                    {
                        iterator.remove();
                        if (flag)
                        {
                            Utils.a("Dispatcher", "canceled", Utils.a(bitmaphunter1), "all actions paused");
                        }
                    }
                }
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
        message = ((Message) (message.obj));
        a.a(message);
        return;
        message = (BitmapHunter)message.obj;
        a.c(message);
        return;
        message = (BitmapHunter)message.obj;
        a.b(message);
        return;
        message = (BitmapHunter)message.obj;
        a.a(message, false);
        return;
        a.a();
        return;
        message = (NetworkInfo)message.obj;
        a.a(message);
        return;
        Dispatcher dispatcher2 = a;
        boolean flag1;
        if (message.arg1 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        dispatcher2.p = flag1;
        return;
    }

    public _cls1(Looper looper, Dispatcher dispatcher)
    {
        super(looper);
        a = dispatcher;
    }
}
