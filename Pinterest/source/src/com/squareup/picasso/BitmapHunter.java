// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.squareup.picasso:
//            Action, Request, RequestHandler, Transformation, 
//            Picasso, Cache, Stats, Utils, 
//            Dispatcher, StatsSnapshot

class BitmapHunter
    implements Runnable
{

    private static final Object s = new Object();
    private static final ThreadLocal t = new _cls1();
    private static final AtomicInteger u = new AtomicInteger();
    private static final RequestHandler v = new _cls2();
    final int a;
    final Picasso b;
    final Dispatcher c;
    final Cache d;
    final Stats e;
    final String f;
    final Request g;
    final boolean h;
    final RequestHandler i;
    Action j;
    List k;
    Bitmap l;
    Future m;
    Picasso.LoadedFrom n;
    Exception o;
    int p;
    int q;
    Picasso.Priority r;

    private BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requesthandler)
    {
        a = u.incrementAndGet();
        b = picasso;
        c = dispatcher;
        d = cache;
        e = stats;
        j = action;
        f = action.h;
        g = action.b;
        r = action.b.q;
        h = action.d;
        i = requesthandler;
        q = requesthandler.a();
    }

    private static Bitmap a(List list, Bitmap bitmap)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1;)
        {
            Transformation transformation = (Transformation)list.get(i1);
            Bitmap bitmap1;
            try
            {
                bitmap1 = transformation.transform(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                Picasso.a.post(new _cls3(transformation, list));
                return null;
            }
            if (bitmap1 == null)
            {
                bitmap = (new StringBuilder("Transformation ")).append(transformation.key()).append(" returned null after ").append(i1).append(" previous transformation(s).\n\nTransformation list:\n");
                for (list = list.iterator(); list.hasNext(); bitmap.append(((Transformation)list.next()).key()).append('\n')) { }
                Picasso.a.post(new _cls4(bitmap));
                return null;
            }
            if (bitmap1 == bitmap && bitmap.isRecycled())
            {
                Picasso.a.post(new _cls5(transformation));
                return null;
            }
            if (bitmap1 != bitmap && !bitmap.isRecycled())
            {
                Picasso.a.post(new _cls6(transformation));
                return null;
            }
            i1++;
            bitmap = bitmap1;
        }

        return bitmap;
    }

    static BitmapHunter a(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        Request request = action.b;
        List list = picasso.a();
        int i1 = 0;
        for (int j1 = list.size(); i1 < j1; i1++)
        {
            RequestHandler requesthandler = (RequestHandler)list.get(i1);
            if (requesthandler.a(request))
            {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requesthandler);
            }
        }

        return new BitmapHunter(picasso, dispatcher, cache, stats, action, v);
    }

    final Bitmap a()
    {
        Object obj;
        int j1;
        j1 = 1;
        obj = null;
        if (h) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj2 = d.get(f);
        obj = obj2;
        if (obj2 == null) goto _L2; else goto _L3
_L3:
        Object obj1;
        e.a();
        n = Picasso.LoadedFrom.a;
        obj1 = obj2;
        if (b.k)
        {
            Utils.a("Hunter", "decoded", g.a(), "from cache");
            obj1 = obj2;
        }
_L5:
        return ((Bitmap) (obj1));
_L2:
        float f1;
        float f2;
        Object obj3;
        int i1;
        int k1;
        int l1;
        obj1 = g;
        float f3;
        boolean flag;
        int i2;
        boolean flag3;
        if (q == 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        obj1.c = flag3;
        obj1 = i.b(g);
        if (obj1 != null)
        {
            obj = ((RequestHandler.Result) (obj1)).a();
            n = ((RequestHandler.Result) (obj1)).b();
            p = ((RequestHandler.Result) (obj1)).c();
        }
        obj1 = obj;
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (b.k)
        {
            Utils.a("Hunter", "decoded", g.a());
        }
        e.a(((Bitmap) (obj)));
        obj1 = g;
        i1 = j1;
        if (!((Request) (obj1)).d())
        {
            if (((Request) (obj1)).e())
            {
                i1 = j1;
            } else
            {
                i1 = 0;
            }
        }
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        if (p == 0) goto _L5; else goto _L6
_L6:
        obj3 = s;
        obj3;
        JVM INSTR monitorenter ;
        if (g.d()) goto _L8; else goto _L7
_L7:
        obj2 = obj;
        if (p == 0) goto _L9; else goto _L8
_L8:
        obj1 = g;
        i2 = p;
        i1 = ((Bitmap) (obj)).getWidth();
        l1 = ((Bitmap) (obj)).getHeight();
        obj2 = new Matrix();
        if (!((Request) (obj1)).d()) goto _L11; else goto _L10
_L10:
        j1 = ((Request) (obj1)).h;
        k1 = ((Request) (obj1)).i;
        f1 = ((Request) (obj1)).l;
        if (f1 == 0.0F) goto _L13; else goto _L12
_L12:
        if (!((Request) (obj1)).o) goto _L15; else goto _L14
_L14:
        ((Matrix) (obj2)).setRotate(f1, ((Request) (obj1)).m, ((Request) (obj1)).n);
_L13:
        if (!((Request) (obj1)).j) goto _L17; else goto _L16
_L16:
        f1 = (float)j1 / (float)i1;
        f2 = (float)k1 / (float)l1;
        if (f1 <= f2) goto _L19; else goto _L18
_L18:
        f3 = l1;
        k1 = (int)Math.ceil((f2 / f1) * f3);
        j1 = (l1 - k1) / 2;
        l1 = k1;
        flag = false;
        k1 = i1;
        i1 = ((flag) ? 1 : 0);
_L22:
        ((Matrix) (obj2)).preScale(f1, f1);
_L25:
        if (i2 == 0)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        ((Matrix) (obj2)).preRotate(i2);
        obj2 = Bitmap.createBitmap(((Bitmap) (obj)), i1, j1, k1, l1, ((Matrix) (obj2)), true);
        obj1 = obj;
        if (obj2 == obj)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        ((Bitmap) (obj)).recycle();
        obj1 = obj2;
        obj2 = obj1;
        if (!b.k) goto _L9; else goto _L20
_L20:
        Utils.a("Hunter", "transformed", g.a());
        obj2 = obj1;
_L9:
        obj = obj2;
        if (!g.e())
        {
            break MISSING_BLOCK_LABEL_596;
        }
        obj1 = a(g.g, ((Bitmap) (obj2)));
        obj = obj1;
        if (!b.k)
        {
            break MISSING_BLOCK_LABEL_596;
        }
        Utils.a("Hunter", "transformed", g.a(), "from custom transformations");
        obj = obj1;
        obj3;
        JVM INSTR monitorexit ;
        obj1 = obj;
        if (obj == null) goto _L5; else goto _L21
_L21:
        e.b(((Bitmap) (obj)));
        return ((Bitmap) (obj));
_L15:
        ((Matrix) (obj2)).setRotate(f1);
          goto _L13
        Exception exception;
        exception;
        obj3;
        JVM INSTR monitorexit ;
        throw exception;
_L19:
        double d1;
        float f4 = i1;
        d1 = (f1 / f2) * f4;
        k1 = (int)Math.ceil(d1);
        i1 = (i1 - k1) / 2;
        j1 = 0;
        f1 = f2;
          goto _L22
_L17:
        if (!((Request) (obj1)).k) goto _L24; else goto _L23
_L23:
        f1 = (float)j1 / (float)i1;
        f2 = (float)k1 / (float)l1;
        if (f1 >= f2)
        {
            f1 = f2;
        }
        ((Matrix) (obj2)).preScale(f1, f1);
        j1 = 0;
        boolean flag1 = false;
        k1 = i1;
        i1 = ((flag1) ? 1 : 0);
          goto _L25
_L32:
        if (j1 == 0) goto _L27; else goto _L26
_L26:
        f1 = (float)j1 / (float)i1;
_L30:
        if (k1 == 0) goto _L29; else goto _L28
_L28:
        f2 = (float)k1 / (float)l1;
_L31:
        ((Matrix) (obj2)).preScale(f1, f2);
_L11:
        j1 = 0;
        boolean flag2 = false;
        k1 = i1;
        i1 = ((flag2) ? 1 : 0);
          goto _L25
_L27:
        f1 = (float)k1 / (float)l1;
          goto _L30
_L29:
        f2 = (float)j1 / (float)i1;
          goto _L31
_L24:
        if (j1 == 0 && k1 == 0 || j1 == i1 && k1 == l1) goto _L11; else goto _L32
    }

    final void a(Action action)
    {
        boolean flag1 = true;
        boolean flag = false;
        boolean flag2;
        if (j == action)
        {
            j = null;
            flag2 = true;
        } else
        if (k != null)
        {
            flag2 = k.remove(action);
        } else
        {
            flag2 = false;
        }
        if (flag2 && action.b.q == r)
        {
            Picasso.Priority priority = Picasso.Priority.a;
            Picasso.Priority priority1;
            int i1;
            int j1;
            if (k != null && !k.isEmpty())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            j1 = ((flag1) ? 1 : 0);
            if (j == null)
            {
                if (i1 != 0)
                {
                    j1 = ((flag1) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
            }
            if (j1 != 0)
            {
                if (j != null)
                {
                    priority = j.b.q;
                }
                priority1 = priority;
                if (i1 != 0)
                {
                    j1 = k.size();
                    i1 = ((flag) ? 1 : 0);
                    do
                    {
                        priority1 = priority;
                        if (i1 >= j1)
                        {
                            break;
                        }
                        priority1 = ((Action)k.get(i1)).b.q;
                        if (priority1.ordinal() > priority.ordinal())
                        {
                            priority = priority1;
                        }
                        i1++;
                    } while (true);
                }
            } else
            {
                priority1 = priority;
            }
            r = priority1;
        }
        if (b.k)
        {
            Utils.a("Hunter", "removed", action.b.a(), Utils.a(this, "from "));
        }
    }

    final boolean b()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (j != null)
            {
                break label0;
            }
            if (k != null)
            {
                flag = flag1;
                if (!k.isEmpty())
                {
                    break label0;
                }
            }
            flag = flag1;
            if (m != null)
            {
                flag = flag1;
                if (m.cancel(false))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    final boolean c()
    {
        return m != null && m.isCancelled();
    }

    public void run()
    {
        Object obj = g;
        if (((Request) (obj)).d == null) goto _L2; else goto _L1
_L1:
        obj = String.valueOf(((Request) (obj)).d.getPath());
_L5:
        StringBuilder stringbuilder = (StringBuilder)t.get();
        stringbuilder.ensureCapacity(((String) (obj)).length() + 8);
        stringbuilder.replace(8, stringbuilder.length(), ((String) (obj)));
        Thread.currentThread().setName(stringbuilder.toString());
        if (b.k)
        {
            Utils.a("Hunter", "executing", Utils.a(this));
        }
        l = a();
        if (l != null) goto _L4; else goto _L3
_L3:
        c.a(this);
_L6:
        Thread.currentThread().setName("Picasso-Idle");
        return;
_L2:
        obj = Integer.toHexString(((Request) (obj)).e);
          goto _L5
_L4:
        Dispatcher dispatcher = c;
        dispatcher.i.sendMessage(dispatcher.i.obtainMessage(4, this));
          goto _L6
        Object obj1;
        obj1;
        o = ((Exception) (obj1));
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        o = ((Exception) (obj1));
        Dispatcher dispatcher1 = c;
        dispatcher1.i.sendMessageDelayed(dispatcher1.i.obtainMessage(5, this), 500L);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        dispatcher1;
        StringWriter stringwriter = new StringWriter();
        Object obj2 = e;
        obj2 = new StatsSnapshot(((Stats) (obj2)).b.maxSize(), ((Stats) (obj2)).b.size(), ((Stats) (obj2)).d, ((Stats) (obj2)).e, ((Stats) (obj2)).f, ((Stats) (obj2)).g, ((Stats) (obj2)).h, ((Stats) (obj2)).i, ((Stats) (obj2)).j, ((Stats) (obj2)).k, ((Stats) (obj2)).l, ((Stats) (obj2)).m, ((Stats) (obj2)).n, System.currentTimeMillis());
        PrintWriter printwriter = new PrintWriter(stringwriter);
        printwriter.println("===============BEGIN PICASSO STATS ===============");
        printwriter.println("Memory Cache Stats");
        printwriter.print("  Max Cache Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).a);
        printwriter.print("  Cache Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).b);
        printwriter.print("  Cache % Full: ");
        printwriter.println((int)Math.ceil(((float)((StatsSnapshot) (obj2)).b / (float)((StatsSnapshot) (obj2)).a) * 100F));
        printwriter.print("  Cache Hits: ");
        printwriter.println(((StatsSnapshot) (obj2)).c);
        printwriter.print("  Cache Misses: ");
        printwriter.println(((StatsSnapshot) (obj2)).d);
        printwriter.println("Network Stats");
        printwriter.print("  Download Count: ");
        printwriter.println(((StatsSnapshot) (obj2)).k);
        printwriter.print("  Total Download Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).e);
        printwriter.print("  Average Download Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).h);
        printwriter.println("Bitmap Stats");
        printwriter.print("  Total Bitmaps Decoded: ");
        printwriter.println(((StatsSnapshot) (obj2)).l);
        printwriter.print("  Total Bitmap Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).f);
        printwriter.print("  Total Transformed Bitmaps: ");
        printwriter.println(((StatsSnapshot) (obj2)).m);
        printwriter.print("  Total Transformed Bitmap Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).g);
        printwriter.print("  Average Bitmap Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).i);
        printwriter.print("  Average Transformed Bitmap Size: ");
        printwriter.println(((StatsSnapshot) (obj2)).j);
        printwriter.println("===============END PICASSO STATS ===============");
        printwriter.flush();
        o = new RuntimeException(stringwriter.toString(), dispatcher1);
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        dispatcher1;
        o = dispatcher1;
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        dispatcher1;
        Thread.currentThread().setName("Picasso-Idle");
        throw dispatcher1;
          goto _L5
    }


    private class _cls3
        implements Runnable
    {

        final Transformation a;
        final RuntimeException b;

        public final void run()
        {
            throw new RuntimeException((new StringBuilder("Transformation ")).append(a.key()).append(" crashed with exception.").toString(), b);
        }

        _cls3(Transformation transformation, RuntimeException runtimeexception)
        {
            a = transformation;
            b = runtimeexception;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final StringBuilder a;

        public final void run()
        {
            throw new NullPointerException(a.toString());
        }

        _cls4(StringBuilder stringbuilder)
        {
            a = stringbuilder;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final Transformation a;

        public final void run()
        {
            throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.key()).append(" returned input Bitmap but recycled it.").toString());
        }

        _cls5(Transformation transformation)
        {
            a = transformation;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final Transformation a;

        public final void run()
        {
            throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.key()).append(" mutated input Bitmap but failed to recycle the original.").toString());
        }

        _cls6(Transformation transformation)
        {
            a = transformation;
            super();
        }
    }


    private class _cls1 extends ThreadLocal
    {

        protected final Object initialValue()
        {
            return new StringBuilder("Picasso-");
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends RequestHandler
    {

        public final boolean a(Request request)
        {
            return true;
        }

        public final RequestHandler.Result b(Request request)
        {
            throw new IllegalStateException((new StringBuilder("Unrecognized type of request: ")).append(request).toString());
        }

        _cls2()
        {
        }
    }

}
