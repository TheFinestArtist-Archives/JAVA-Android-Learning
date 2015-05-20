// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.squareup.picasso:
//            Picasso, Request, Utils, PicassoDrawable, 
//            DeferredRequestCreator, Callback, ImageViewAction, Target, 
//            TargetAction, GetAction, BitmapHunter, FetchAction, 
//            Transformation

public class RequestCreator
{

    private static int a = 0;
    private final Picasso b;
    private final Request.Builder c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private Object l;

    RequestCreator()
    {
        g = true;
        b = null;
        c = new Request.Builder(null, (byte)0);
    }

    RequestCreator(Picasso picasso, Uri uri)
    {
        g = true;
        if (picasso.l)
        {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        } else
        {
            b = picasso;
            c = new Request.Builder(uri, (byte)0);
            return;
        }
    }

    private Request a(long l1)
    {
        int i1 = f();
        Request request = c.e();
        request.a = i1;
        request.b = l1;
        boolean flag = b.k;
        if (flag)
        {
            Utils.a("Main", "created", request.b(), request.toString());
        }
        Request request1 = b.a(request);
        if (request1 != request)
        {
            request1.a = i1;
            request1.b = l1;
            if (flag)
            {
                Utils.a("Main", "changed", request1.a(), (new StringBuilder("into ")).append(request1).toString());
            }
        }
        return request1;
    }

    static int e()
    {
        return f();
    }

    private static int f()
    {
        if (Utils.c())
        {
            int i1 = a;
            a = i1 + 1;
            return i1;
        }
        CountDownLatch countdownlatch = new CountDownLatch(1);
        AtomicInteger atomicinteger = new AtomicInteger();
        Picasso.a.post(new _cls1(atomicinteger, countdownlatch));
        try
        {
            countdownlatch.await();
        }
        catch (InterruptedException interruptedexception)
        {
            Utils.a(interruptedexception);
        }
        return atomicinteger.get();
    }

    private Drawable g()
    {
        if (h != 0)
        {
            return b.c.getResources().getDrawable(h);
        } else
        {
            return j;
        }
    }

    final RequestCreator a()
    {
        f = false;
        return this;
    }

    public final RequestCreator a(int i1, int j1)
    {
        c.a(i1, j1);
        return this;
    }

    public final RequestCreator a(Transformation transformation)
    {
        c.a(transformation);
        return this;
    }

    public final RequestCreator a(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Tag invalid.");
        }
        if (l != null)
        {
            throw new IllegalStateException("Tag already set.");
        } else
        {
            l = obj;
            return this;
        }
    }

    public final void a(ImageView imageview, Callback callback)
    {
        long l1;
        l1 = System.nanoTime();
        Utils.b();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (c.a()) goto _L2; else goto _L1
_L1:
        b.a(imageview);
        if (g)
        {
            PicassoDrawable.a(imageview, g());
        }
_L4:
        return;
_L2:
        Request request;
        String s;
        if (f)
        {
            if (c.b())
            {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int i1 = imageview.getWidth();
            int j1 = imageview.getHeight();
            if (i1 == 0 || j1 == 0)
            {
                if (g)
                {
                    PicassoDrawable.a(imageview, g());
                }
                Picasso picasso = b;
                callback = new DeferredRequestCreator(this, imageview, callback);
                picasso.h.put(imageview, callback);
                return;
            }
            c.a(i1, j1);
        }
        request = a(l1);
        s = Utils.a(request);
        if (d)
        {
            break; /* Loop/switch isn't completed */
        }
        Bitmap bitmap = b.b(s);
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        b.a(imageview);
        PicassoDrawable.a(imageview, b.c, bitmap, Picasso.LoadedFrom.a, e, b.j);
        if (b.k)
        {
            Utils.a("Main", "completed", request.b(), (new StringBuilder("from ")).append(Picasso.LoadedFrom.a).toString());
        }
        if (callback != null)
        {
            callback.onSuccess();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (g)
        {
            PicassoDrawable.a(imageview, g());
        }
        imageview = new ImageViewAction(b, imageview, request, d, e, i, k, s, l, callback);
        b.a(imageview);
        return;
    }

    public final void a(Target target)
    {
        Drawable drawable = null;
        Request request = null;
        long l1 = System.nanoTime();
        Utils.b();
        if (target == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (f)
        {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!c.a())
        {
            b.a(target);
            drawable = request;
            if (g)
            {
                drawable = g();
            }
            target.onPrepareLoad(drawable);
            return;
        }
        request = a(l1);
        String s = Utils.a(request);
        if (!d)
        {
            Bitmap bitmap = b.b(s);
            if (bitmap != null)
            {
                b.a(target);
                target.onBitmapLoaded(bitmap, Picasso.LoadedFrom.a);
                return;
            }
        }
        if (g)
        {
            drawable = g();
        }
        target.onPrepareLoad(drawable);
        target = new TargetAction(b, target, request, d, i, k, s, l);
        b.a(target);
    }

    public final RequestCreator b()
    {
        c.d();
        return this;
    }

    public final Bitmap c()
    {
        long l1 = System.nanoTime();
        Utils.a();
        if (f)
        {
            throw new IllegalStateException("Fit cannot be used with get.");
        }
        if (!c.a())
        {
            return null;
        } else
        {
            Object obj = a(l1);
            String s = Utils.a(((Request) (obj)), new StringBuilder());
            obj = new GetAction(b, ((Request) (obj)), d, s, l);
            return BitmapHunter.a(b, b.d, b.e, b.f, ((Action) (obj))).a();
        }
    }

    public final void d()
    {
        long l1 = System.nanoTime();
        if (f)
        {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        }
        if (c.a())
        {
            if (!c.c())
            {
                c.a(Picasso.Priority.a);
            }
            Object obj = a(l1);
            String s = Utils.a(((Request) (obj)), new StringBuilder());
            obj = new FetchAction(b, ((Request) (obj)), d, s, l);
            b.b(((Action) (obj)));
        }
    }


    private class _cls1
        implements Runnable
    {

        final AtomicInteger a;
        final CountDownLatch b;

        public final void run()
        {
            a.set(RequestCreator.e());
            b.countDown();
        }

        _cls1(AtomicInteger atomicinteger, CountDownLatch countdownlatch)
        {
            a = atomicinteger;
            b = countdownlatch;
            super();
        }
    }

}
