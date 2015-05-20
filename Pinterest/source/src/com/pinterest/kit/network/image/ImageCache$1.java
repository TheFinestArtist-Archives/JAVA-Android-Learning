// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

final class arIcon.Listener extends arIcon.Listener
{

    final WeakReference val$weakToolBar;

    public final void onBitmapLoaded(final Bitmap bitmap)
    {
        class _cls1
            implements Runnable
        {

            final ImageCache._cls1 this$0;
            final Bitmap val$bitmap;

            public void run()
            {
                Toolbar toolbar = (Toolbar)weakToolBar.get();
                if (toolbar != null)
                {
                    RoundedDrawable roundeddrawable = new RoundedDrawable(bitmap, 0.0F);
                    roundeddrawable.a(true);
                    toolbar.setLogo(roundeddrawable);
                }
            }

            _cls1()
            {
                this$0 = ImageCache._cls1.this;
                bitmap = bitmap1;
                super();
            }
        }

        if (bitmap != null)
        {
            (new Handler(Looper.getMainLooper())).post(new _cls1());
        }
    }

    _cls1()
    {
        val$weakToolBar = weakreference;
        super();
    }
}
