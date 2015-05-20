// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.squareup.picasso:
//            Picasso, Request

abstract class Action
{

    final Picasso a;
    final Request b;
    final WeakReference c;
    final boolean d;
    final boolean e;
    final int f;
    final Drawable g;
    final String h;
    final Object i;
    boolean j;
    boolean k;

    Action(Picasso picasso, Object obj, Request request, boolean flag, boolean flag1, int l, Drawable drawable, 
            String s, Object obj1)
    {
        a = picasso;
        b = request;
        if (obj == null)
        {
            picasso = null;
        } else
        {
            picasso = new RequestWeakReference(obj, picasso.i);
        }
        c = picasso;
        d = flag;
        e = flag1;
        f = l;
        g = drawable;
        h = s;
        if (obj1 == null)
        {
            obj1 = this;
        }
        i = obj1;
    }

    abstract void a();

    abstract void a(Bitmap bitmap, Picasso.LoadedFrom loadedfrom);

    void b()
    {
        k = true;
    }

    Object c()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.get();
        }
    }

    private class RequestWeakReference extends WeakReference
    {

        final Action a;

        public RequestWeakReference(Object obj, ReferenceQueue referencequeue)
        {
            super(obj, referencequeue);
            a = Action.this;
        }
    }

}
