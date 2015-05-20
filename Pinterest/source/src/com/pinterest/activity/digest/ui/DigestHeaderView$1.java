// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import android.view.View;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.List;

// Referenced classes of package com.pinterest.activity.digest.ui:
//            DigestFeedbackDialog, DigestHeaderView

class this._cls0
    implements android.view.r
{

    final DigestHeaderView this$0;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.DIGEST_STORY_FEEDBACK_BUTTON, ComponentType.DIGEST_STORY_HEADER);
        view = new DigestFeedbackDialog(DigestHeaderView.access$000(DigestHeaderView.this));
        view.setFirstIncludedPin(ModelHelper.getPin(((DigestItem)DigestHeaderView.access$100(DigestHeaderView.this).get(0)).getUid()));
        Events.post(new DialogEvent(view));
    }

    g()
    {
        this$0 = DigestHeaderView.this;
        super();
    }
}
