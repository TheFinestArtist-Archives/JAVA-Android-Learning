// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0
    implements android.view.SettingsFragment._cls2
{

    final AccountSettingsFragment this$0;

    public void onClick(View view)
    {
        if (view == _nameBt)
        {
            Pinalytics.a(ElementType.NAME_BUTTON);
            AccountSettingsFragment.access$100(AccountSettingsFragment.this);
        } else
        {
            if (view == _businessNameBt)
            {
                Pinalytics.a(ElementType.NAME_BUTTON);
                AccountSettingsFragment.access$200(AccountSettingsFragment.this);
                return;
            }
            if (view == _contactNameBt)
            {
                Pinalytics.a(ElementType.NAME_BUTTON);
                AccountSettingsFragment.access$300(AccountSettingsFragment.this);
                return;
            }
            if (view == _usernameBt)
            {
                Pinalytics.a(ElementType.USERNAME_BUTTON);
                AccountSettingsFragment.access$400(AccountSettingsFragment.this);
                return;
            }
            if (view == _emailBt)
            {
                Pinalytics.a(ElementType.EMAIL_BUTTON);
                AccountSettingsFragment.access$500(AccountSettingsFragment.this);
                return;
            }
            if (view == _countryBt)
            {
                Pinalytics.a(ElementType.COUNTRY_BUTTON);
                AccountSettingsFragment.access$600(AccountSettingsFragment.this);
                AccountSettingsFragment.access$700(AccountSettingsFragment.this);
                return;
            }
            if (view == _languageBt)
            {
                Pinalytics.a(ElementType.LANGUAGE_BUTTON);
                AccountSettingsFragment.access$800(AccountSettingsFragment.this);
                return;
            }
            if (view == _changePwdBt)
            {
                Pinalytics.a(ElementType.CHANGE_PASSWORD_BUTTON);
                AccountSettingsFragment.access$900(AccountSettingsFragment.this);
                return;
            }
            if (view == _genderBt)
            {
                Pinalytics.a(ElementType.GENDER_BUTTON);
                AccountSettingsFragment.access$1000(AccountSettingsFragment.this);
                return;
            }
            if (view == _personalRecBt)
            {
                Pinalytics.a(ElementType.PERSONALIZED_RECOMMENDATIONS_BUTTON);
                AccountSettingsFragment.access$1100(AccountSettingsFragment.this);
                return;
            }
            if (view == _searchPrivacyBt)
            {
                Pinalytics.a(ElementType.SEARCH_PRIVACY_BUTTON);
                AccountSettingsFragment.access$1200(AccountSettingsFragment.this);
                return;
            }
            if (view == _newsPrivacyBt)
            {
                Pinalytics.a(ElementType.SEARCH_PRIVACY_BUTTON);
                AccountSettingsFragment.access$1300(AccountSettingsFragment.this);
                return;
            }
        }
    }

    ()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
