// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.contacts;

import com.pinterest.activity.sendapin.providers.ContactsProvider;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.AccountApi;
import com.pinterest.base.Application;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.contacts:
//            InvitabilityContact

public class UploadContactsUtil
{

    private static final int CONTACT_MAX_NUM = 400;
    private static final String KEY = "PREF_ACCOUNTS_STORED_CONTACTS";

    public UploadContactsUtil()
    {
    }

    private static Date getLastShownDate()
    {
        return new Date(Preferences.user().getLong("PREF_UPLOAD_CONTACTS_DIALOG_LAST_SHOWN", 0L));
    }

    private static int getLastShownTimes()
    {
        return Preferences.user().getInt("PREF_UPLOAD_CONTACTS_DIALOG_SHOWN_TIMES", 0);
    }

    public static boolean isAccountStoredContacts()
    {
        Set set = Preferences.persisted().getStringSet("PREF_ACCOUNTS_STORED_CONTACTS", null);
        return set != null && set.contains(MyUser.getUid());
    }

    public static void onDialogShown()
    {
        saveLastShownDate();
    }

    private static void saveLastShownDate()
    {
        Preferences.user().set("PREF_UPLOAD_CONTACTS_DIALOG_LAST_SHOWN", (new Date()).getTime());
        Preferences.user().set("PREF_UPLOAD_CONTACTS_DIALOG_SHOWN_TIMES", getLastShownTimes() + 1);
    }

    public static void setAccountsStoredContacts()
    {
        Set set = Preferences.persisted().getStringSet("PREF_ACCOUNTS_STORED_CONTACTS", null);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet(1);
        }
        ((Set) (obj)).add(MyUser.getUid());
        Preferences.persisted().set("PREF_ACCOUNTS_STORED_CONTACTS", ((Set) (obj)));
    }

    public static void setStoreContacts(boolean flag)
    {
        if (flag)
        {
            uploadContacts();
            setAccountsStoredContacts();
            return;
        } else
        {
            AccountApi.c();
            unsetAccountsStoredContacts();
            unsetContactDialogShown();
            return;
        }
    }

    public static boolean shouldShowDialog()
    {
        if (getLastShownTimes() < 2)
        {
            Date date = getLastShownDate();
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -2);
            if (calendar.getTime().compareTo(date) > 0)
            {
                return true;
            }
        }
        return false;
    }

    public static void unsetAccountsStoredContacts()
    {
        Set set = Preferences.persisted().getStringSet("PREF_ACCOUNTS_STORED_CONTACTS", null);
        if (set != null)
        {
            if (set.contains(MyUser.getUid()))
            {
                set.remove(MyUser.getUid());
            }
            Preferences.persisted().set("PREF_ACCOUNTS_STORED_CONTACTS", set);
        }
    }

    public static void unsetContactDialogShown()
    {
        Preferences.user().set("PREF_UPLOAD_CONTACTS_DIALOG_SHOWN_TIMES", 0);
        Preferences.user().set("PREF_UPLOAD_CONTACTS_DIALOG_LAST_SHOWN", 0L);
    }

    private static void uploadContacts()
    {
        HashMap hashmap = new HashMap();
        ContactsProvider.fillInvitabilityContactsWithEmail(Application.context(), hashmap, 400);
        ContactsProvider.fillInvitabilityContactsWithPhone(Application.context(), hashmap);
        ContactsProvider.fillInvitabilityContactsWithName(Application.context(), hashmap);
        ContactsProvider.fillInvitabilityContactsWithCloseFriend(Application.context(), hashmap);
        ContactsProvider.fillInvitabilityContactsWithPostal(Application.context(), hashmap);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('[');
        for (Iterator iterator = hashmap.values().iterator(); iterator.hasNext(); stringbuilder.append(','))
        {
            stringbuilder.append((InvitabilityContact)iterator.next());
        }

        if (hashmap.size() > 0)
        {
            stringbuilder.setCharAt(stringbuilder.length() - 1, ']');
        } else
        {
            stringbuilder.append(']');
        }
        PLog.a("Try upload %d contacts.", new Object[] {
            Integer.valueOf(hashmap.size())
        });
        AccountApi.c(stringbuilder.toString(), new _cls1(true));
    }

    private class _cls1 extends ApiResponseHandler
    {

        public final void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            UploadContactsUtil.unsetAccountsStoredContacts();
            Events.post(new UploadContactsCancelledEvent());
        }

        public final void onSuccess(ApiResponse apiresponse)
        {
            Application.showToast(0x7f0e011c);
        }

        _cls1(boolean flag)
        {
            super(flag);
        }

        private class UploadContactsCancelledEvent
        {

            public UploadContactsCancelledEvent()
            {
            }
        }

    }

}
