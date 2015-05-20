// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.report.ReportHelper;
import com.pinterest.activity.report.ReportUserDialog;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.user.view:
//            UserAboutFlagView

class val.dialog
    implements android.widget.ickListener
{

    final UserAboutFlagView this$0;
    final Context val$context;
    final BaseDialog val$dialog;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 32
    //                   1 59;
           goto _L1 _L2 _L3
_L1:
        val$dialog.dismiss();
        return;
_L2:
        Events.post(new DialogEvent(new ReportUserDialog(UserAboutFlagView.access$100(UserAboutFlagView.this))));
        continue; /* Loop/switch isn't completed */
_L3:
        ReportHelper.showBlockDialog((Activity)val$context, UserAboutFlagView.access$100(UserAboutFlagView.this));
        if (true) goto _L1; else goto _L4
_L4:
    }

    ()
    {
        this$0 = final_useraboutflagview;
        val$context = context1;
        val$dialog = BaseDialog.this;
        super();
    }
}
