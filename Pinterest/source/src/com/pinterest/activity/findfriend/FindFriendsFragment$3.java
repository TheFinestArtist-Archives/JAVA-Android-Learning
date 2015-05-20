// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.text.Editable;
import android.text.TextWatcher;
import com.pinterest.activity.sendapin.ui.EmptySearchCell;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendsFragment, FindFriendAdapter

class this._cls0
    implements TextWatcher
{

    final FindFriendsFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        EmptySearchCell emptysearchcell = FindFriendsFragment.access$100(FindFriendsFragment.this);
        if (charsequence.length() <= 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        emptysearchcell.setVisibility(i);
        FindFriendsFragment.access$200(FindFriendsFragment.this).onSearchQueryChanged(charsequence.toString());
    }

    ()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
