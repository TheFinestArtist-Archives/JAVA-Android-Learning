// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.pinterest.activity.task.dialog.view.ReportBugView;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.kit.utils.ImageUtils;

// Referenced classes of package com.pinterest.activity.task.dialog:
//            ReportBugDialog

class 
    implements android.view.er
{

    final ReportBugDialog this$0;
    final Activity val$activity;
    final ReportBugView val$reportForm;

    public void onClick(View view)
    {
        view = ReportBugDialog.access$000(ReportBugDialog.this);
        android.graphics.Bitmap bitmap = ImageUtils.bitmapFromView(val$activity.getWindow().getDecorView());
        class _cls1 extends BaseApiResponseHandler
        {

            final ReportBugDialog._cls1 this$1;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                Application.showToast("Report failed, try again.");
                super.onFailure(throwable, apiresponse);
            }

            public void onStart()
            {
                Application.showToast("Sending report...");
                super.onStart();
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                Application.showToast("Report sent!");
                super.onSuccess(apiresponse);
            }

            _cls1()
            {
                this$1 = ReportBugDialog._cls1.this;
                super();
            }
        }

        AnalyticsApi.a(val$reportForm.getTitleText(), (new StringBuilder()).append(val$reportForm.getMessageText()).append("\n\n---\n\n").append(view).toString(), bitmap, new _cls1());
        dismiss();
    }

    ()
    {
        this$0 = final_reportbugdialog;
        val$activity = activity1;
        val$reportForm = ReportBugView.this;
        super();
    }
}
