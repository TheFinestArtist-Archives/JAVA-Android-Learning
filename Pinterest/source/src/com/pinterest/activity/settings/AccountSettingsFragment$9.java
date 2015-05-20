// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.view.View;
import com.pinterest.activity.task.dialog.SimpleTextDialog;
import com.pinterest.base.CrashReporting;
import java.lang.reflect.Method;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class val.dialog
    implements android.view.SettingsFragment._cls9
{

    final AccountSettingsFragment this$0;
    final SimpleTextDialog val$dialog;
    final String val$methodName;

    public void onClick(View view)
    {
        try
        {
            com/pinterest/activity/settings/AccountSettingsFragment.getDeclaredMethod(val$methodName, null).invoke(AccountSettingsFragment.this, null);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            CrashReporting.logHandledException(view);
        }
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_accountsettingsfragment;
        val$methodName = s;
        val$dialog = SimpleTextDialog.this;
        super();
    }
}
