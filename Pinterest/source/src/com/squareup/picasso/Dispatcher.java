// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.squareup.picasso:
//            Utils, Action, BitmapHunter, Picasso, 
//            PicassoExecutorService, Request, RequestHandler, Cache, 
//            Downloader, Stats

class Dispatcher
{

    final DispatcherThread a = new DispatcherThread();
    final Context b;
    final ExecutorService c;
    final Downloader d;
    final Map e = new LinkedHashMap();
    final Map f = new WeakHashMap();
    final Map g = new WeakHashMap();
    final Set h = new HashSet();
    final Handler i;
    final Handler j;
    final Cache k;
    final Stats l;
    final List m = new ArrayList(4);
    final NetworkBroadcastReceiver n = new NetworkBroadcastReceiver();
    final boolean o;
    boolean p;

    Dispatcher(Context context, ExecutorService executorservice, Handler handler, Downloader downloader, Cache cache, Stats stats)
    {
        a.start();
        b = context;
        c = executorservice;
        i = new DispatcherHandler(a.getLooper(), this);
        d = downloader;
        j = handler;
        k = cache;
        l = stats;
        p = Utils.d(b);
        o = Utils.b(context, "android.permission.ACCESS_NETWORK_STATE");
        n.a();
    }

    private void a(Action action)
    {
        Object obj = action.c();
        if (obj != null)
        {
            action.j = true;
            f.put(obj, action);
        }
    }

    private static void a(List list)
    {
        while (list.isEmpty() || !((BitmapHunter)list.get(0)).b.k) 
        {
            return;
        }
        StringBuilder stringbuilder = new StringBuilder();
        BitmapHunter bitmaphunter;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(Utils.a(bitmaphunter)))
        {
            bitmaphunter = (BitmapHunter)list.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
        }

        Utils.a("Dispatcher", "delivered", stringbuilder.toString());
    }

    private void d(BitmapHunter bitmaphunter)
    {
        Action action = bitmaphunter.j;
        if (action != null)
        {
            a(action);
        }
        bitmaphunter = bitmaphunter.k;
        if (bitmaphunter != null)
        {
            int j1 = bitmaphunter.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                a((Action)bitmaphunter.get(i1));
            }

        }
    }

    private void e(BitmapHunter bitmaphunter)
    {
        if (!bitmaphunter.c())
        {
            m.add(bitmaphunter);
            if (!i.hasMessages(7))
            {
                i.sendEmptyMessageDelayed(7, 200L);
                return;
            }
        }
    }

    final void a()
    {
        ArrayList arraylist = new ArrayList(m);
        m.clear();
        j.sendMessage(j.obtainMessage(8, arraylist));
        a(((List) (arraylist)));
    }

    final void a(NetworkInfo networkinfo)
    {
        if (c instanceof PicassoExecutorService)
        {
            ((PicassoExecutorService)c).a(networkinfo);
        }
        if (networkinfo != null && networkinfo.isConnected() && !f.isEmpty())
        {
            Action action;
            for (networkinfo = f.values().iterator(); networkinfo.hasNext(); a(action, false))
            {
                action = (Action)networkinfo.next();
                networkinfo.remove();
                if (action.a.k)
                {
                    Utils.a("Dispatcher", "replaying", action.b.a());
                }
            }

        }
    }

    final void a(Action action, boolean flag)
    {
        if (!h.contains(action.i)) goto _L2; else goto _L1
_L1:
        g.put(action.c(), action);
        if (action.a.k)
        {
            Utils.a("Dispatcher", "paused", action.b.a(), (new StringBuilder("because tag '")).append(action.i).append("' is paused").toString());
        }
_L4:
        return;
_L2:
        BitmapHunter bitmaphunter = (BitmapHunter)e.get(action.h);
        if (bitmaphunter == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = bitmaphunter.b.k;
        Request request = action.b;
        if (bitmaphunter.j == null)
        {
            bitmaphunter.j = action;
            if (flag)
            {
                if (bitmaphunter.k == null || bitmaphunter.k.isEmpty())
                {
                    Utils.a("Hunter", "joined", request.a(), "to empty hunter");
                    return;
                } else
                {
                    Utils.a("Hunter", "joined", request.a(), Utils.a(bitmaphunter, "to "));
                    return;
                }
            }
        } else
        {
            if (bitmaphunter.k == null)
            {
                bitmaphunter.k = new ArrayList(3);
            }
            bitmaphunter.k.add(action);
            if (flag)
            {
                Utils.a("Hunter", "joined", request.a(), Utils.a(bitmaphunter, "to "));
            }
            action = action.b.q;
            if (action.ordinal() > bitmaphunter.r.ordinal())
            {
                bitmaphunter.r = action;
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!c.isShutdown())
        {
            break; /* Loop/switch isn't completed */
        }
        if (action.a.k)
        {
            Utils.a("Dispatcher", "ignored", action.b.a(), "because shut down");
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        BitmapHunter bitmaphunter1 = BitmapHunter.a(action.a, this, k, l, action);
        bitmaphunter1.m = c.submit(bitmaphunter1);
        e.put(action.h, bitmaphunter1);
        if (flag)
        {
            f.remove(action.c());
        }
        if (action.a.k)
        {
            Utils.a("Dispatcher", "enqueued", action.b.a());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    final void a(BitmapHunter bitmaphunter)
    {
        i.sendMessage(i.obtainMessage(6, bitmaphunter));
    }

    final void a(BitmapHunter bitmaphunter, boolean flag)
    {
        if (bitmaphunter.b.k)
        {
            String s1 = Utils.a(bitmaphunter);
            StringBuilder stringbuilder = new StringBuilder("for error");
            String s;
            if (flag)
            {
                s = " (will replay)";
            } else
            {
                s = "";
            }
            Utils.a("Dispatcher", "batched", s1, stringbuilder.append(s).toString());
        }
        e.remove(bitmaphunter.f);
        e(bitmaphunter);
    }

    final void a(Object obj)
    {
        if (h.remove(obj))
        {
            ArrayList arraylist = null;
            Iterator iterator = g.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Action action = (Action)iterator.next();
                if (action.i.equals(obj))
                {
                    ArrayList arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList();
                    }
                    arraylist1.add(action);
                    iterator.remove();
                    arraylist = arraylist1;
                }
            } while (true);
            if (arraylist != null)
            {
                j.sendMessage(j.obtainMessage(13, arraylist));
                return;
            }
        }
    }

    final void b(BitmapHunter bitmaphunter)
    {
        boolean flag3 = true;
        if (!bitmaphunter.c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (c.isShutdown())
        {
            a(bitmaphunter, false);
            return;
        }
        NetworkInfo networkinfo;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag4;
        if (o)
        {
            networkinfo = ((ConnectivityManager)Utils.a(b, "connectivity")).getActiveNetworkInfo();
        } else
        {
            networkinfo = null;
        }
        if (networkinfo != null && networkinfo.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (bitmaphunter.q > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            flag2 = false;
        } else
        {
            bitmaphunter.q = bitmaphunter.q - 1;
            flag2 = bitmaphunter.i.a(networkinfo);
        }
        flag4 = bitmaphunter.i.b();
        if (flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (o && flag4)
        {
            flag2 = flag3;
        } else
        {
            flag2 = false;
        }
        a(bitmaphunter, flag2);
        if (flag2)
        {
            d(bitmaphunter);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!o || flag)
        {
            if (bitmaphunter.b.k)
            {
                Utils.a("Dispatcher", "retrying", Utils.a(bitmaphunter));
            }
            bitmaphunter.m = c.submit(bitmaphunter);
            return;
        }
        a(bitmaphunter, flag4);
        if (flag4)
        {
            d(bitmaphunter);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    final void c(BitmapHunter bitmaphunter)
    {
        if (!bitmaphunter.h)
        {
            k.set(bitmaphunter.f, bitmaphunter.l);
        }
        e.remove(bitmaphunter.f);
        e(bitmaphunter);
        if (bitmaphunter.b.k)
        {
            Utils.a("Dispatcher", "batched", Utils.a(bitmaphunter), "for completion");
        }
    }

    private class DispatcherThread extends HandlerThread
    {

        DispatcherThread()
        {
            super("Picasso-Dispatcher", 10);
        }
    }


    private class DispatcherHandler extends Handler
    {

        private final Dispatcher a;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 12: default 68
        //                       1 85
        //                       2 103
        //                       3 68
        //                       4 663
        //                       5 680
        //                       6 697
        //                       7 715
        //                       8 68
        //                       9 723
        //                       10 740
        //                       11 294
        //                       12 649;
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
                final DispatcherHandler b;

                public void run()
                {
                    throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
                }

                _cls1(Message message)
                {
                    b = DispatcherHandler.this;
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
                    int i1;
                    if (list != null && !list.isEmpty())
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    if (action != null || i1 != 0)
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
                        if (i1 != 0)
                        {
                            for (i1 = list.size() - 1; i1 >= 0; i1--)
                            {
                                Action action1 = (Action)list.get(i1);
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

        public DispatcherHandler(Looper looper, Dispatcher dispatcher)
        {
            super(looper);
            a = dispatcher;
        }
    }


    private class NetworkBroadcastReceiver extends BroadcastReceiver
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
            int i1;
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            intent.sendMessage(context.obtainMessage(10, i1, 0));
            return;
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(s)) goto _L1; else goto _L4
_L4:
            intent = (ConnectivityManager)Utils.a(context, "connectivity");
            context = a;
            intent = intent.getActiveNetworkInfo();
            ((Dispatcher) (context)).i.sendMessage(((Dispatcher) (context)).i.obtainMessage(9, intent));
            return;
        }

        NetworkBroadcastReceiver()
        {
            a = Dispatcher.this;
        }
    }

}
