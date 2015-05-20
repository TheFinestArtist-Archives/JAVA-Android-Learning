// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog;

import android.app.Activity;
import android.os.Build;
import com.pinterest.activity.task.dialog.view.ReportBugView;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.activity.task.dialog:
//            BaseDialog

public class ReportBugDialog extends BaseDialog
{

    public ReportBugDialog()
    {
    }

    public ReportBugDialog(final Activity activity)
    {
        final ReportBugView reportForm = new ReportBugView(activity);
        setTitle(0x7f0e03eb);
        setContent(reportForm);
        setPositiveButton(0x7f0e0443, new _cls1());
        setNegativeButton(0x7f0e008f, null);
    }

    private String getDeviceInfo()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Full name: ").append(MyUser.get().getFullName()).append("\n");
        stringbuilder.append("User: ").append(MyUser.get().getUsername()).append("\n");
        StringBuilder stringbuilder1 = stringbuilder.append("Form factor: ");
        String s;
        boolean flag;
        if (Device.isTablet())
        {
            s = "Tablet";
        } else
        {
            s = "Phone";
        }
        stringbuilder1.append(s).append("\n");
        stringbuilder.append("Version: ").append(ApplicationInfo.getVersionName()).append("\n");
        flag = Device.isOnWifi();
        stringbuilder1 = stringbuilder.append("Carrier: ");
        if (flag)
        {
            s = "Wifi";
        } else
        {
            s = Device.getCarrierName();
        }
        stringbuilder1.append(s).append("\n");
        stringbuilder.append("Device: ").append(Build.DEVICE).append(";").append(android.os.Build.VERSION.RELEASE).append("\n");
        return stringbuilder.toString();
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final ReportBugDialog this$0;
        final Activity val$activity;
        final ReportBugView val$reportForm;

        public void onClick(View view)
        {
            view = getDeviceInfo();
            android.graphics.Bitmap bitmap = ImageUtils.bitmapFromView(activity.getWindow().getDecorView());
            class _cls1 extends BaseApiResponseHandler
            {

                final _cls1 this$1;

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
                    this$1 = _cls1.this;
                    super();
                }
            }

            AnalyticsApi.a(reportForm.getTitleText(), (new StringBuilder()).append(reportForm.getMessageText()).append("\n\n---\n\n").append(view).toString(), bitmap, new _cls1());
            dismiss();
        }

        _cls1()
        {
            this$0 = ReportBugDialog.this;
            activity = activity1;
            reportForm = reportbugview;
            super();
        }
    }

}
