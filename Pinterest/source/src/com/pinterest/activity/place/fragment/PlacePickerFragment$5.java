// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.place.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.pinterest.activity.place.adapter.PlacePickerAdapter;

// Referenced classes of package com.pinterest.activity.place.fragment:
//            PlacePickerFragment

class this._cls0
    implements TextWatcher
{

    final PlacePickerFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        PlacePickerFragment.access$100(PlacePickerFragment.this).onLocationTextChanged(charsequence.toString());
        PlacePickerFragment.access$500(PlacePickerFragment.this);
    }

    A()
    {
        this$0 = PlacePickerFragment.this;
        super();
    }
}
