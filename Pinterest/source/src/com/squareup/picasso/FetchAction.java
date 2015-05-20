// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;

// Referenced classes of package com.squareup.picasso:
//            Action, Picasso, Request

class FetchAction extends Action
{

    private final Object l = new Object();

    FetchAction(Picasso picasso, Request request, boolean flag, String s, Object obj)
    {
        super(picasso, null, request, flag, false, 0, null, s, obj);
    }

    public final void a()
    {
    }

    final void a(Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
    }

    final Object c()
    {
        return l;
    }
}
