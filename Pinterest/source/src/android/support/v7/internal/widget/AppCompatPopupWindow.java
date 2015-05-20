// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package android.support.v7.internal.widget:
//            TintTypedArray

public class AppCompatPopupWindow extends PopupWindow
{

    private final boolean mOverlapAnchor;

    public AppCompatPopupWindow(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = TintTypedArray.obtainStyledAttributes(context, attributeset, android.support.v7.appcompat.R.styleable.PopupWindow, i, 0);
        mOverlapAnchor = context.getBoolean(android.support.v7.appcompat.R.styleable.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(context.getDrawable(android.support.v7.appcompat.R.styleable.PopupWindow_android_popupBackground));
        context.recycle();
    }

    public void showAsDropDown(View view, int i, int j)
    {
        int k = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            k = j;
            if (mOverlapAnchor)
            {
                k = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, k);
    }

    public void showAsDropDown(View view, int i, int j, int k)
    {
        int l = j;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            l = j;
            if (mOverlapAnchor)
            {
                l = j - view.getHeight();
            }
        }
        super.showAsDropDown(view, i, l, k);
    }

    public void update(View view, int i, int j, int k, int l)
    {
        if (android.os.Build.VERSION.SDK_INT < 21 && mOverlapAnchor)
        {
            j -= view.getHeight();
        }
        super.update(view, i, j, k, l);
    }
}
