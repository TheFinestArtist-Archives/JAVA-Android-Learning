// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.developer;

import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.EditText;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.base.Application;

// Referenced classes of package com.pinterest.developer:
//            DeveloperHelper

final class c
    implements android.content.lickListener
{

    final EditText a;
    final EditText b;
    final CheckBox c;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        String s = a.getText().toString();
        if (s.lastIndexOf("%s") != s.length() - 2)
        {
            Application.showToast("API URL must contain AND end with '%s'");
            return;
        }
        ApiHttpClient.setBaseApiUrl(s);
        s = b.getText().toString();
        if (s.lastIndexOf("%s") != s.length() - 2)
        {
            Application.showToast("Logging API URL must contain AND end with '%s'");
            return;
        } else
        {
            ApiHttpClient.setBaseLoggingApiUrl(s);
            DeveloperHelper.a(c.isChecked());
            dialoginterface.dismiss();
            return;
        }
    }

    ener(EditText edittext, EditText edittext1, CheckBox checkbox)
    {
        a = edittext;
        b = edittext1;
        c = checkbox;
        super();
    }
}
