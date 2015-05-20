// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.squareup.picasso:
//            Action, Callback, Picasso, PicassoDrawable, 
//            Request

class ImageViewAction extends Action
{

    Callback l;

    ImageViewAction(Picasso picasso, ImageView imageview, Request request, boolean flag, boolean flag1, int i, Drawable drawable, 
            String s, Object obj, Callback callback)
    {
        super(picasso, imageview, request, flag, flag1, i, drawable, s, obj);
        l = callback;
    }

    public final void a()
    {
        ImageView imageview = (ImageView)c.get();
        if (imageview != null)
        {
            if (f != 0)
            {
                imageview.setImageResource(f);
            } else
            if (g != null)
            {
                imageview.setImageDrawable(g);
            }
            if (l != null)
            {
                l.onError();
                return;
            }
        }
    }

    public final void a(Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
        if (bitmap == null)
        {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] {
                this
            }));
        }
        ImageView imageview = (ImageView)c.get();
        if (imageview != null)
        {
            android.content.Context context = a.c;
            boolean flag = a.j;
            PicassoDrawable.a(imageview, context, bitmap, loadedfrom, e, flag);
            if (l != null)
            {
                l.onSuccess();
                return;
            }
        }
    }

    final void b()
    {
        super.b();
        if (l != null)
        {
            l = null;
        }
    }
}
