// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.squareup.picasso:
//            Utils, LruCache, PicassoExecutorService, Stats, 
//            Picasso, Dispatcher, Downloader, Cache

public class nContext
{

    private final Context a;
    private Downloader b;
    private ExecutorService c;
    private Cache d;
    private  e;
    private ransformer f;
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
            f = ransformer.IDENTITY;
        }
        Stats stats = new Stats(d);
        return new Picasso(context, new Dispatcher(context, c, Picasso.a, b, d, stats), d, e, f, g, stats, h, i);
    }

    public ransformer(Context context)
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
