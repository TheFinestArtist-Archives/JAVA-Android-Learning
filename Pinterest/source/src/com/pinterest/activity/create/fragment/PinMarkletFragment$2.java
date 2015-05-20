// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.create.model.PinnableImage;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.kit.activity.BaseActivity;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment, CreatePinFragment

class this._cls0
    implements android.widget.ckListener
{

    final PinMarkletFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (PinnableImage)PinMarkletFragment.access$200(PinMarkletFragment.this).getItem(i);
        if (adapterview != null && isAdded())
        {
            view = (BaseActivity)getActivity();
            CreatePinFragment createpinfragment = new CreatePinFragment();
            createpinfragment.setPinnableImage(adapterview);
            FragmentHelper.replaceFragment(view, createpinfragment, true);
        }
    }

    A()
    {
        this$0 = PinMarkletFragment.this;
        super();
    }
}
