// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsContactFragment, NewFindFriendsListAdapter

class this._cls0
    implements TextWatcher
{

    final NewFindFriendsContactFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        NewFindFriendsContactFragment.access$100(NewFindFriendsContactFragment.this).onSearchQueryChanged(charsequence.toString());
    }

    I()
    {
        this$0 = NewFindFriendsContactFragment.this;
        super();
    }
}
