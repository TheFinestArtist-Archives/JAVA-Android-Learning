// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.squareup.picasso:
//            ResourceRequestHandler, ContactsPhotoRequestHandler, MediaStoreRequestHandler, ContentStreamRequestHandler, 
//            AssetRequestHandler, FileRequestHandler, NetworkRequestHandler, Dispatcher, 
//            Action, Request, Utils, DeferredRequestCreator, 
//            RequestCreator, BitmapHunter, Cache, Stats, 
//            Target

public class Picasso
{

    static final Handler a = new _cls1(Looper.getMainLooper());
    static Picasso b = null;
    final Context c;
    final Dispatcher d;
    final Cache e;
    final Stats f;
    final Map g = new WeakHashMap();
    final Map h = new WeakHashMap();
    final ReferenceQueue i = new ReferenceQueue();
    boolean j;
    volatile boolean k;
    boolean l;
    private final Listener m;
    private final RequestTransformer n;
    private final CleanupThread o;
    private final List p;

    Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requesttransformer, List list, Stats stats, 
            boolean flag, boolean flag1)
    {
        c = context;
        d = dispatcher;
        e = cache;
        m = listener;
        n = requesttransformer;
        int i1;
        if (list != null)
        {
            i1 = list.size();
        } else
        {
            i1 = 0;
        }
        cache = new ArrayList(i1 + 7);
        cache.add(new ResourceRequestHandler(context));
        if (list != null)
        {
            cache.addAll(list);
        }
        cache.add(new ContactsPhotoRequestHandler(context));
        cache.add(new MediaStoreRequestHandler(context));
        cache.add(new ContentStreamRequestHandler(context));
        cache.add(new AssetRequestHandler(context));
        cache.add(new FileRequestHandler(context));
        cache.add(new NetworkRequestHandler(dispatcher.d, stats));
        p = Collections.unmodifiableList(cache);
        f = stats;
        j = flag;
        k = flag1;
        o = new CleanupThread(i, a);
        o.start();
    }

    public static Picasso a(Context context)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        com/squareup/picasso/Picasso;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = (new Builder(context)).a();
        }
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
_L2:
        return b;
        context;
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(Bitmap bitmap, LoadedFrom loadedfrom, Action action)
    {
        if (!action.k) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!action.j)
        {
            g.remove(action.c());
        }
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (loadedfrom == null)
        {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        action.a(bitmap, loadedfrom);
        if (k)
        {
            Utils.a("Main", "completed", action.b.a(), (new StringBuilder("from ")).append(loadedfrom).toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        action.a();
        if (k)
        {
            Utils.a("Main", "errored", action.b.a());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static void a(Picasso picasso, Object obj)
    {
        picasso.c(obj);
    }

    private void c(Object obj)
    {
        Utils.b();
        Action action = (Action)g.remove(obj);
        if (action != null)
        {
            action.b();
            Dispatcher dispatcher = d;
            dispatcher.i.sendMessage(dispatcher.i.obtainMessage(2, action));
        }
        if (obj instanceof ImageView)
        {
            obj = (ImageView)obj;
            obj = (DeferredRequestCreator)h.remove(obj);
            if (obj != null)
            {
                obj.c = null;
                Object obj1 = (ImageView)((DeferredRequestCreator) (obj)).b.get();
                if (obj1 != null)
                {
                    obj1 = ((ImageView) (obj1)).getViewTreeObserver();
                    if (((ViewTreeObserver) (obj1)).isAlive())
                    {
                        ((ViewTreeObserver) (obj1)).removeOnPreDrawListener(((android.view.ViewTreeObserver.OnPreDrawListener) (obj)));
                    }
                }
            }
        }
    }

    final Request a(Request request)
    {
        Request request1 = n.transformRequest(request);
        if (request1 == null)
        {
            throw new IllegalStateException((new StringBuilder("Request transformer ")).append(n.getClass().getCanonicalName()).append(" returned null for ").append(request).toString());
        } else
        {
            return request1;
        }
    }

    public final RequestCreator a(String s)
    {
        if (s == null)
        {
            return new RequestCreator(this, null);
        }
        if (s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Path must not be empty.");
        } else
        {
            return new RequestCreator(this, Uri.parse(s));
        }
    }

    final List a()
    {
        return p;
    }

    public final void a(ImageView imageview)
    {
        c(imageview);
    }

    final void a(Action action)
    {
        Object obj = action.c();
        if (obj != null && g.get(obj) != action)
        {
            c(obj);
            g.put(obj, action);
        }
        b(action);
    }

    final void a(BitmapHunter bitmaphunter)
    {
        boolean flag2 = true;
        Action action = bitmaphunter.j;
        List list = bitmaphunter.k;
        boolean flag;
        boolean flag1;
        if (list != null && !list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (action == null)
        {
            if (flag)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            Uri uri = bitmaphunter.g.d;
            Exception exception = bitmaphunter.o;
            Bitmap bitmap = bitmaphunter.l;
            bitmaphunter = bitmaphunter.n;
            if (action != null)
            {
                a(bitmap, ((LoadedFrom) (bitmaphunter)), action);
            }
            if (flag)
            {
                int j1 = list.size();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    a(bitmap, ((LoadedFrom) (bitmaphunter)), (Action)list.get(i1));
                }

            }
            if (m != null && exception != null)
            {
                m.onImageLoadFailed(this, uri, exception);
                return;
            }
        }
    }

    public final void a(Target target)
    {
        c(target);
    }

    public final void a(Object obj)
    {
        Dispatcher dispatcher = d;
        dispatcher.i.sendMessage(dispatcher.i.obtainMessage(11, obj));
    }

    final Bitmap b(String s)
    {
        s = e.get(s);
        if (s != null)
        {
            f.a();
            return s;
        } else
        {
            f.c.sendEmptyMessage(1);
            return s;
        }
    }

    final void b(Action action)
    {
        Dispatcher dispatcher = d;
        dispatcher.i.sendMessage(dispatcher.i.obtainMessage(1, action));
    }

    public final void b(Object obj)
    {
        Dispatcher dispatcher = d;
        dispatcher.i.sendMessage(dispatcher.i.obtainMessage(12, obj));
    }

    final void c(Action action)
    {
        Bitmap bitmap = null;
        if (!action.d)
        {
            bitmap = b(action.h);
        }
        if (bitmap != null)
        {
            a(bitmap, LoadedFrom.a, action);
            if (k)
            {
                Utils.a("Main", "completed", action.b.a(), (new StringBuilder("from ")).append(LoadedFrom.a).toString());
            }
        } else
        {
            a(action);
            if (k)
            {
                Utils.a("Main", "resumed", action.b.a());
                return;
            }
        }
    }


    private class CleanupThread extends Thread
    {

        private final ReferenceQueue a;
        private final Handler b;

        public void run()
        {
            Process.setThreadPriority(10);
            class _cls1
                implements Runnable
            {

                final Exception a;
                final CleanupThread b;

                public void run()
                {
                    throw new RuntimeException(a);
                }

                _cls1(Exception exception)
                {
                    b = CleanupThread.this;
                    a = exception;
                    super();
                }
            }

            try
            {
                do
                {
                    Action.RequestWeakReference requestweakreference = (Action.RequestWeakReference)a.remove();
                    b.sendMessage(b.obtainMessage(3, requestweakreference.a));
                } while (true);
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
            catch (Exception exception)
            {
                b.post(new _cls1(exception));
            }
        }

        CleanupThread(ReferenceQueue referencequeue, Handler handler)
        {
            a = referencequeue;
            b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }
    }


    private class Builder
    {

        private final Context a;
        private Downloader b;
        private ExecutorService c;
        private Cache d;
        private Listener e;
        private RequestTransformer f;
        private List g;
        private boolean h;
        private boolean i;

        public final Picasso a()
        {
            Context context = a;
            if (b == null)
            {
                b = Utils.a(context);
            }
            if (d == null)
            {
                d = new LruCache(context);
            }
            if (c == null)
            {
                c = new PicassoExecutorService();
            }
            if (f == null)
            {
                f = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(d);
            return new Picasso(context, new Dispatcher(context, c, Picasso.a, b, d, stats), d, e, f, g, stats, h, i);
        }

        public Builder(Context context)
        {
            if (context == null)
            {
                throw new IllegalArgumentException("Context must not be null.");
            } else
            {
                a = context.getApplicationContext();
                return;
            }
        }
    }


    private class RequestTransformer
    {

        public static final RequestTransformer IDENTITY = new _cls1();

        public abstract Request transformRequest(Request request);


        class _cls1
            implements RequestTransformer
        {

            public final Request transformRequest(Request request)
            {
                return request;
            }

                _cls1()
                {
                }
        }

    }


    private class Listener
    {

        public abstract void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception);
    }


    private class LoadedFrom extends Enum
    {

        public static final LoadedFrom a;
        public static final LoadedFrom b;
        public static final LoadedFrom c;
        private static final LoadedFrom e[];
        final int d;

        public static LoadedFrom valueOf(String s)
        {
            return (LoadedFrom)Enum.valueOf(com/squareup/picasso/Picasso$LoadedFrom, s);
        }

        public static LoadedFrom[] values()
        {
            return (LoadedFrom[])e.clone();
        }

        static 
        {
            a = new LoadedFrom("MEMORY", 0, 0xff00ff00);
            b = new LoadedFrom("DISK", 1, -256);
            c = new LoadedFrom("NETWORK", 2, 0xffff0000);
            e = (new LoadedFrom[] {
                a, b, c
            });
        }

        private LoadedFrom(String s, int i1, int j1)
        {
            super(s, i1);
            d = j1;
        }
    }


    private class _cls1 extends Handler
    {

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       3: 117
        //                       8: 67
        //                       13: 163;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(message.what).toString());
_L3:
            message = (List)message.obj;
            int k1 = message.size();
            for (int i1 = 0; i1 < k1; i1++)
            {
                BitmapHunter bitmaphunter = (BitmapHunter)message.get(i1);
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
            int l1 = message.size();
            int j1 = 0;
            while (j1 < l1) 
            {
                Action action = (Action)message.get(j1);
                action.a.c(action);
                j1++;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls1(Looper looper)
        {
            super(looper);
        }
    }

}
