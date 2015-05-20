// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.network.image;

import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import com.makeramen.RoundedDrawable;
import java.lang.ref.WeakReference;

class val.bitmap
    implements Runnable
{

    final val.bitmap this$0;
    final Bitmap val$bitmap;

    public void run()
    {
        Toolbar toolbar = (Toolbar)weakToolBar.get();
        if (toolbar != null)
        {
            RoundedDrawable roundeddrawable = new RoundedDrawable(val$bitmap, 0.0F);
            roundeddrawable.a(true);
            toolbar.setLogo(roundeddrawable);
        }
    }

    ()
    {
        this$0 = final_;
        val$bitmap = Bitmap.this;
        super();
    }
}
