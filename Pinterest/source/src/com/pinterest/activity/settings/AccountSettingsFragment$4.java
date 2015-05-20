// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import com.pinterest.api.remote.SettingsApi;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0
    implements android.widget.tener
{

    final AccountSettingsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view != null)
        {
            if ((adapterview = (CheckedTextView)view.findViewById(0x7f0b01f1)) != null)
            {
                boolean flag;
                if (!adapterview.isChecked())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                adapterview.setChecked(flag);
                if (AccountSettingsFragment.access$1600() != null)
                {
                    view = (String)AccountSettingsFragment.access$1600().get(i);
                    if (adapterview.isChecked())
                    {
                        adapterview = "anyone";
                    } else
                    {
                        adapterview = "none";
                    }
                    SettingsApi.d(view, adapterview, AccountSettingsFragment.access$1700(AccountSettingsFragment.this), AccountSettingsFragment.access$1800(AccountSettingsFragment.this));
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
