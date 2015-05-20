// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.fragment;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.pinterest.activity.search.fragment:
//            GuidedPinSearchFragment

class er extends com.pinterest.ui.scrollview.lViewListener
{

    final GuidedPinSearchFragment this$0;

    public void onScroll(View view, int i, int j, int k, int l)
    {
        if (_focusView != null)
        {
            _focusView.requestFocus();
        }
        if (_categoryListView != null)
        {
            i = _categoryListWrapper.getMeasuredHeight();
            k = (int)_categoryListWrapper.getY();
            int i1 = (l - j) + k;
            if (j < l)
            {
                if (k < 0)
                {
                    _categoryListWrapper.setTranslationY(Math.min(0, i1));
                }
            } else
            if (j > l && k > -i)
            {
                _categoryListWrapper.setTranslationY(Math.max(-i, i1));
            }
            if (j == 0)
            {
                GuidedPinSearchFragment.access$200(GuidedPinSearchFragment.this, 0);
                return;
            }
        }
    }

    er()
    {
        this$0 = GuidedPinSearchFragment.this;
        super();
    }
}
