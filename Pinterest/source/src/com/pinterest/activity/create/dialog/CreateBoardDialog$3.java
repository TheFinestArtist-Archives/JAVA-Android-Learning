// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.dialog;

import android.app.Activity;
import com.pinterest.activity.create.PinEditActivity;
import com.pinterest.activity.create.PinItActivity;
import com.pinterest.api.ApiResponse;

// Referenced classes of package com.pinterest.activity.create.dialog:
//            CreateBoardDialog

class ardResponseHandler extends com.pinterest.activity.create.helper.ardResponseHandler
{

    final CreateBoardDialog this$0;
    final Activity val$activity;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        if ((val$activity instanceof PinEditActivity) || (val$activity instanceof PinItActivity))
        {
            val$activity.onBackPressed();
        }
    }

    ardResponseHandler(Activity activity1)
    {
        this$0 = final_createboarddialog;
        val$activity = activity1;
        super(Boolean.this);
    }
}
