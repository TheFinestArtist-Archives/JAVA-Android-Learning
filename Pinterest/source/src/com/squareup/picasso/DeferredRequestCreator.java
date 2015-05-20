// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.squareup.picasso:
//            RequestCreator, Callback

class DeferredRequestCreator
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final RequestCreator a;
    final WeakReference b;
    Callback c;

    DeferredRequestCreator(RequestCreator requestcreator, ImageView imageview, Callback callback)
    {
        a = requestcreator;
        b = new WeakReference(imageview);
        c = callback;
        imageview.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw()
    {
        ImageView imageview = (ImageView)b.get();
        ViewTreeObserver viewtreeobserver;
        if (imageview != null)
        {
            if ((viewtreeobserver = imageview.getViewTreeObserver()).isAlive())
            {
                int i = imageview.getWidth();
                int j = imageview.getHeight();
                if (i > 0 && j > 0)
                {
                    viewtreeobserver.removeOnPreDrawListener(this);
                    a.a().a(i, j).a(imageview, c);
                    return true;
                }
            }
        }
        return true;
    }
}
