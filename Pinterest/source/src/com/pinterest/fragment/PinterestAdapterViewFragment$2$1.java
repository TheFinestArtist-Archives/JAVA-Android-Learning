// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import com.pinterest.ui.grid.PinterestAdapterView;
import com.pinterest.ui.scrollview.ObservableScrollView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestAdapterViewFragment

class this._cls1
    implements Runnable
{

    final Scroll this$1;

    public void run()
    {
        if (_adapterView != null)
        {
            _adapterView.requestLayout();
        }
        if (_scrollView != null)
        {
            _scrollView.scrollTo(0, (int)(_toYScroll * (float)_adapterView.getMeasuredHeight()));
        }
        _toYScroll = 0.0F;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
