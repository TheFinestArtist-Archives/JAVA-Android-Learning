// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.content.Context;
import com.facebook.NativeAppCallAttachmentStore;
import java.util.HashMap;

// Referenced classes of package com.facebook.widget:
//            FacebookDialog

class this._cls0
    implements allback
{

    final diaAttachmentFiles this$0;

    public void onPresent(Context context)
    {
        if (ageAttachments != null && ageAttachments.size() > 0)
        {
            FacebookDialog.access$900().addAttachmentsForCall(context, pCall.getCallId(), ageAttachments);
        }
        if (diaAttachmentFiles != null && diaAttachmentFiles.size() > 0)
        {
            FacebookDialog.access$900().addAttachmentFilesForCall(context, pCall.getCallId(), diaAttachmentFiles);
        }
    }

    l()
    {
        this$0 = this._cls0.this;
        super();
    }
}
