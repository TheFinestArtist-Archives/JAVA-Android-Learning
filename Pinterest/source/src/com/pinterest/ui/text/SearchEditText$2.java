// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.pinterest.ui.text:
//            SearchEditText

class this._cls0
    implements TextWatcher
{

    final SearchEditText this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.length() > 0)
        {
            setCompoundDrawablesWithIntrinsicBounds(null, null, SearchEditText.access$000(SearchEditText.this), null);
            SearchEditText.access$102(SearchEditText.this, true);
            return;
        } else
        {
            setCompoundDrawablesWithIntrinsicBounds(null, null, SearchEditText.access$200(SearchEditText.this), null);
            SearchEditText.access$102(SearchEditText.this, false);
            return;
        }
    }

    ()
    {
        this$0 = SearchEditText.this;
        super();
    }
}
