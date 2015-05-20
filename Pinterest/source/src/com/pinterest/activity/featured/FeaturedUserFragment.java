// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.UserApi;
import com.pinterest.fragment.UserGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.featured:
//            FeaturedHeaderView

public class FeaturedUserFragment extends UserGridFragment
{

    protected FeaturedHeaderView _headerView;

    public FeaturedUserFragment()
    {
    }

    protected void loadData()
    {
        UserApi.b(MyUser.getUid(), new com.pinterest.api.remote.UserApi.UserFeedApiResponse(gridResponseHandler), getApiTag());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _headerView = new FeaturedHeaderView(view.getContext());
        _gridVw.addHeaderView(_headerView, -1, (int)Resources.dimension(0x7f0a0085));
    }
}
