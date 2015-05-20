// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            OnApplyWindowInsetsListener

class ViewCompatApi21
{

    ViewCompatApi21()
    {
    }

    public static float getElevation(View view)
    {
        return view.getElevation();
    }

    public static String getTransitionName(View view)
    {
        return view.getTransitionName();
    }

    public static float getTranslationZ(View view)
    {
        return view.getTranslationZ();
    }

    public static void requestApplyInsets(View view)
    {
        view.requestApplyInsets();
    }

    public static void setElevation(View view, float f)
    {
        view.setElevation(f);
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener listener)
    {
        view.setOnApplyWindowInsetsListener(new _cls1());
    }

    public static void setTransitionName(View view, String s)
    {
        view.setTransitionName(s);
    }

    public static void setTranslationZ(View view, float f)
    {
        view.setTranslationZ(f);
    }

    private class _cls1
        implements android.view.View.OnApplyWindowInsetsListener
    {

        final OnApplyWindowInsetsListener val$listener;

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
        {
            windowinsets = new WindowInsetsCompatApi21(windowinsets);
            return ((WindowInsetsCompatApi21)listener.onApplyWindowInsets(view, windowinsets)).unwrap();
        }

        _cls1()
        {
            listener = onapplywindowinsetslistener;
            super();
        }
    }

}
