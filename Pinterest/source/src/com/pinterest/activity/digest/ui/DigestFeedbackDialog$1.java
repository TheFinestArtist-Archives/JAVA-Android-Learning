// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.digest.adapter.DigestFeedbackAdapter;

// Referenced classes of package com.pinterest.activity.digest.ui:
//            DigestFeedbackDialog

class this._cls0
    implements android.widget.Listener
{

    final DigestFeedbackDialog this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (DigestFeedbackDialog.access$000(DigestFeedbackDialog.this) != null)
        {
            DigestFeedbackDialog.access$000(DigestFeedbackDialog.this).unFollow(i, DigestFeedbackDialog.access$100(DigestFeedbackDialog.this));
        }
        dismiss();
    }

    ter()
    {
        this$0 = DigestFeedbackDialog.this;
        super();
    }
}
