// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.experience.ExperienceValue;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModalFragment, PinvitationalHomeFeedModalStep, PinvitationalHomeFeedModal

class this._cls0
    implements android.view.omeFeedModalFragment._cls2
{

    final PinvitationalHomeFeedModalFragment this$0;

    public void onClick(View view)
    {
        if (!TextUtils.isEmpty(PinvitationalHomeFeedModalFragment.access$200(PinvitationalHomeFeedModalFragment.this).getCompleteButtonUrl()))
        {
            getActivity().getSupportFragmentManager().popBackStack();
            Location.navigateUri(getActivity(), PinvitationalHomeFeedModalFragment.access$200(PinvitationalHomeFeedModalFragment.this).getCompleteButtonUrl());
            view = PinvitationalHomeFeedModalFragment.access$300(PinvitationalHomeFeedModalFragment.this).getExperienceValue();
            AnalyticsApi.b(String.format("%s_%s_%d_step%d_complete_btn", new Object[] {
                "MODAL", ((ExperienceValue) (view)).e, Integer.valueOf(((ExperienceValue) (view)).b), Integer.valueOf(PinvitationalHomeFeedModalFragment.access$400(PinvitationalHomeFeedModalFragment.this))
            }));
            return;
        }
        if (PinvitationalHomeFeedModalFragment.access$400(PinvitationalHomeFeedModalFragment.this) == 0)
        {
            PinvitationalHomeFeedModalFragment.access$300(PinvitationalHomeFeedModalFragment.this).complete();
        }
        PinvitationalHomeFeedModalFragment.access$500(PinvitationalHomeFeedModalFragment.this);
    }

    ()
    {
        this$0 = PinvitationalHomeFeedModalFragment.this;
        super();
    }
}
