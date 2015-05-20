// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.widget.CheckedTextView;
import com.pinterest.activity.task.dialog.BaseDialog;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0
    implements com.pinterest.activity.task.dialog.r
{

    final AccountSettingsFragment this$0;

    public void onDismiss(BaseDialog basedialog)
    {
        gplusCb.setChecked(true);
    }

    ener()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
