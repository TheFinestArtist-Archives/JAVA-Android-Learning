// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.UserApi;
import com.pinterest.fragment.PinGridFragment;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalPinSummaryAdapter

public class PinvitationalPinSummaryFragment extends PinGridFragment
{

    public PinvitationalPinSummaryFragment()
    {
        _adapter = new PinvitationalPinSummaryAdapter();
    }

    public void loadData()
    {
        UserApi.a(MyUser.getUid(), new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler), getApiTag());
        super.loadData();
    }
}
