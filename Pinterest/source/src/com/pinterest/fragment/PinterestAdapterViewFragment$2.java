// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.content.res.Configuration;
import com.pinterest.ui.grid.PinterestAdapterView;

// Referenced classes of package com.pinterest.fragment:
//            PinterestAdapterViewFragment

class this._cls0
    implements com.pinterest.ui.grid.terViewListener
{

    final PinterestAdapterViewFragment this$0;

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLayout()
    {
    }

    public void onMeasure()
    {
        if (!PinterestAdapterViewFragment.access$000(PinterestAdapterViewFragment.this) && _toYScroll > 0.0F)
        {
            PinterestAdapterViewFragment.access$002(PinterestAdapterViewFragment.this, true);
            class _cls1
                implements Runnable
            {

                final PinterestAdapterViewFragment._cls2 this$1;

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

            _cls1()
            {
                this$1 = PinterestAdapterViewFragment._cls2.this;
                super();
            }
            }

            if (_adapterView != null)
            {
                _adapterView.post(new _cls1());
            }
        }
    }

    _cls1()
    {
        this$0 = PinterestAdapterViewFragment.this;
        super();
    }
}
