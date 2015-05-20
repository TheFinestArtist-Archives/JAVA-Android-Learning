// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.contacts;

import android.view.LayoutInflater;
import android.widget.Button;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.Colors;

public class UploadContactsDialog extends BaseDialog
{

    public static final String KEY = "upload_contact";
    private boolean shouldShowFbDialogNext;

    public UploadContactsDialog()
    {
        shouldShowFbDialogNext = false;
        _key = "upload_contact";
    }

    public UploadContactsDialog(boolean flag)
    {
        shouldShowFbDialogNext = false;
        _key = "upload_contact";
        shouldShowFbDialogNext = flag;
    }

    private boolean isNextFBDialog()
    {
        return !shouldShowFbDialogNext && !MyUser.isConnectedToFacebook();
    }

    public void make(LayoutInflater layoutinflater)
    {
        setTitle(0x7f0e04f6);
        setMessage(0x7f0e04d6);
        setCancelable(false);
        setNegativeButton(0x7f0e0315, new _cls1());
        setPositiveButton(0x7f0e049d, new _cls2());
        super.make(layoutinflater);
        positiveBt.setTextColor(Colors.RED);
        AnalyticsApi.b("permissions_contact_popup");
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UploadContactsDialog this$0;

        public void onClick(View view)
        {
            if (isNextFBDialog())
            {
                Events.post(new DialogEvent(new UploadFacebookFriendsDialog()));
            }
            Events.post(new UploadContactsUtil.UploadContactsCancelledEvent());
            AnalyticsApi.b("permissions_contact_reject");
            dismiss();
        }

        _cls1()
        {
            this$0 = UploadContactsDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final UploadContactsDialog this$0;

        public void onClick(View view)
        {
            AnalyticsApi.b("permissions_contact_accept");
            UploadContactsUtil.setStoreContacts(true);
            if (isNextFBDialog())
            {
                Events.post(new DialogEvent(new UploadFacebookFriendsDialog()));
            }
            dismiss();
        }

        _cls2()
        {
            this$0 = UploadContactsDialog.this;
            super();
        }
    }

}
