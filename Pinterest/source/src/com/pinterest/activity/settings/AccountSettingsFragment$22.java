// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.widget.CheckedTextView;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.kit.utils.LocaleUtils;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0 extends com.pinterest.base.sFragment._cls22
{

    final AccountSettingsFragment this$0;

    public void onEventMainThread(com.pinterest.activity.contacts.ntactsCancelledEvent ntactscancelledevent)
    {
        storeContactsCb.setChecked(false);
    }

    public void onEventMainThread(ountSettingsEvent ountsettingsevent)
    {
        setCountryText(LocaleUtils.getCountry());
        ountsettingsevent = MyUser.get();
        setEmail(ountsettingsevent.getEmail());
    }

    public void onEventMainThread(com.pinterest.api.model.ment._cls22 _pcls22)
    {
        AccountSettingsFragment.access$000(AccountSettingsFragment.this);
    }

    public void onEventMainThread(com.pinterest.base.sFragment._cls22 _pcls22)
    {
        switch (.SwitchMap.com.pinterest.base.Social.Network[_pcls22.rk().rk()])
        {
        default:
            return;

        case 1: // '\001'
            AccountSettingsFragment.access$2100(AccountSettingsFragment.this);
            return;

        case 3: // '\003'
            AccountSettingsFragment.access$2000(AccountSettingsFragment.this);
            return;

        case 2: // '\002'
            AccountSettingsFragment.access$2300(AccountSettingsFragment.this);
            return;

        case 4: // '\004'
            AccountSettingsFragment.access$1900(AccountSettingsFragment.this);
            break;
        }
    }

    ountSettingsEvent()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
