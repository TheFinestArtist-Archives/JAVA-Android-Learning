// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

// Referenced classes of package android.support.v4.view:
//            WindowInsetsCompatApi21, OnApplyWindowInsetsListener

final class val.listener
    implements android.view.InsetsListener
{

    final OnApplyWindowInsetsListener val$listener;

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
    {
        windowinsets = new WindowInsetsCompatApi21(windowinsets);
        return ((WindowInsetsCompatApi21)val$listener.onApplyWindowInsets(view, windowinsets)).unwrap();
    }

    sListener()
    {
        val$listener = onapplywindowinsetslistener;
        super();
    }
}
