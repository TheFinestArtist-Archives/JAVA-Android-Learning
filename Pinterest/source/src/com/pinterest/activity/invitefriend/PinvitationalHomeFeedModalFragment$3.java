// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.experience.ExperienceValue;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModalFragment, PinvitationalHomeFeedModal

class this._cls0
    implements android.view.omeFeedModalFragment._cls3
{

    final PinvitationalHomeFeedModalFragment this$0;

    public void onClick(View view)
    {
        PinvitationalHomeFeedModalFragment.access$300(PinvitationalHomeFeedModalFragment.this).dismiss();
        PinvitationalHomeFeedModalFragment.access$600(PinvitationalHomeFeedModalFragment.this);
        view = PinvitationalHomeFeedModalFragment.access$300(PinvitationalHomeFeedModalFragment.this).getExperienceValue();
        AnalyticsApi.b(String.format("%s_%s_%d_step%d_dismiss_btn", new Object[] {
            "MODAL", ((ExperienceValue) (view)).e, Integer.valueOf(((ExperienceValue) (view)).b), Integer.valueOf(PinvitationalHomeFeedModalFragment.access$400(PinvitationalHomeFeedModalFragment.this))
        }));
    }

    ()
    {
        this$0 = PinvitationalHomeFeedModalFragment.this;
        super();
    }
}
