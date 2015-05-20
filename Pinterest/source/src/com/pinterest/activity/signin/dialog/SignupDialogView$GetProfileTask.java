// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.util.Pair;
import com.pinterest.kit.tasks.BackgroundTask;
import com.pinterest.ui.text.PEditText;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            SignupDialogView

public class this._cls0 extends BackgroundTask
{

    String names[];
    final SignupDialogView this$0;

    public void onFinish()
    {
        if (names != null && _firstnameEt != null && _lastnameEt != null)
        {
            _firstnameEt.setText(names[0]);
            if (names.length > 1)
            {
                _lastnameEt.setText(names[1]);
                return;
            }
        }
    }

    public void run()
    {
        Cursor cursor;
        if (getContext() != null)
        {
            if ((cursor = getContext().getContentResolver().query(android.provider._URI, null, null, null, null)) != null)
            {
                if (cursor.getCount() > 0 && cursor.moveToFirst())
                {
                    Pair pair = new Pair("display_name", cursor.getString(cursor.getColumnIndex("display_name")));
                    if ("display_name".equals(pair.first) && pair.second != null && (pair.second instanceof String))
                    {
                        names = ((String)pair.second).split(" ");
                    }
                }
                cursor.close();
                return;
            }
        }
    }

    public ()
    {
        this$0 = SignupDialogView.this;
        super();
    }
}
