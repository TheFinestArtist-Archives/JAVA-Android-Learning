// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFragment, InviteFriendFragment

class this._cls0
    implements TextWatcher
{

    final InviteFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (InviteFragment.access$400(InviteFragment.this) != null)
        {
            android.support.v4.app.Fragment fragment = InviteFragment.access$500(InviteFragment.this).getCurrentPrimaryItem();
            if (fragment instanceof InviteFriendFragment)
            {
                ((InviteFriendFragment)fragment).searchQueryUpdated(charsequence);
            }
        }
    }

    ent()
    {
        this$0 = InviteFragment.this;
        super();
    }
}
