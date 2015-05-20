// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.squareup.picasso:
//            Cache, Utils

public class LruCache
    implements Cache
{

    final LinkedHashMap a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    private LruCache(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max size must be positive.");
        } else
        {
            b = i;
            a = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    public LruCache(Context context)
    {
        this(Utils.c(context));
    }

    private void a(int i)
    {
_L1:
        this;
        JVM INSTR monitorenter ;
        if (c < 0 || a.isEmpty() && c != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c > i && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj = (java.util.Map.Entry)a.entrySet().iterator().next();
        String s = (String)((java.util.Map.Entry) (obj)).getKey();
        obj = (Bitmap)((java.util.Map.Entry) (obj)).getValue();
        a.remove(s);
        c = c - Utils.a(((Bitmap) (obj)));
        e = e + 1;
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public final void clear()
    {
        this;
        JVM INSTR monitorenter ;
        a(-1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Bitmap get(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        s = (Bitmap)a.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        f = f + 1;
        this;
        JVM INSTR monitorexit ;
        return s;
        g = g + 1;
        this;
        JVM INSTR monitorexit ;
        return null;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final int maxSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i = b;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void set(String s, Bitmap bitmap)
    {
        if (s == null || bitmap == null)
        {
            throw new NullPointerException("key == null || bitmap == null");
        }
        this;
        JVM INSTR monitorenter ;
        d = d + 1;
        c = c + Utils.a(bitmap);
        s = (Bitmap)a.put(s, bitmap);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        c = c - Utils.a(s);
        this;
        JVM INSTR monitorexit ;
        a(b);
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i = c;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }
}
