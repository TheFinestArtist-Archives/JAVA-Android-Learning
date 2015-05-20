// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.os.Bundle;
import android.view.View;
import com.pinterest.api.remote.UserApi;
import com.pinterest.fragment.UserGridFragment;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.featured:
//            SectionHeaderView

public class UserSectionFragment extends UserGridFragment
{

    SectionHeaderView _header;

    public UserSectionFragment()
    {
    }

    protected void loadData()
    {
        UserApi.a("jiam03", "4", new com.pinterest.api.remote.UserApi.UserFeedApiResponse(gridResponseHandler), getApiTag());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _gridVw.setHideFooter(true);
        _header = new SectionHeaderView(view.getContext());
        _header.setTitle("More outdoorsy pros");
        _header.setSubtitle("Trip ideas and tips from experienced roadies");
        _gridVw.addHeaderView(_header, -1, -2);
    }
}
