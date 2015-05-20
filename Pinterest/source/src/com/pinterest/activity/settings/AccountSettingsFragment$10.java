// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.view.View;
import android.widget.CheckedTextView;
import com.pinterest.activity.task.dialog.SimpleTextDialog;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class val.dialog
    implements android.view.ettingsFragment._cls10
{

    final AccountSettingsFragment this$0;
    final CheckedTextView val$cb;
    final SimpleTextDialog val$dialog;

    public void onClick(View view)
    {
        val$cb.setChecked(true);
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_accountsettingsfragment;
        val$cb = checkedtextview;
        val$dialog = SimpleTextDialog.this;
        super();
    }
}
