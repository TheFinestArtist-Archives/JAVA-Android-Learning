// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.dialog;

import android.widget.EditText;
import com.pinterest.ui.text.BevelTitleDivider;

// Referenced classes of package com.pinterest.activity.user.dialog:
//            EditUserDialog

public class 
{

    public static void inject(butterknife.erDialog erdialog, EditUserDialog edituserdialog, Object obj)
    {
        edituserdialog._aboutEt = (EditText)erdialog._aboutEt(obj, 0x7f0b00c3, "field '_aboutEt'");
        edituserdialog._locationEt = (EditText)erdialog._locationEt(obj, 0x7f0b00c4, "field '_locationEt'");
        edituserdialog._divider = (BevelTitleDivider)erdialog._divider(obj, 0x7f0b0056, "field '_divider'");
    }

    public static void reset(EditUserDialog edituserdialog)
    {
        edituserdialog._aboutEt = null;
        edituserdialog._locationEt = null;
        edituserdialog._divider = null;
    }

    public ()
    {
    }
}
