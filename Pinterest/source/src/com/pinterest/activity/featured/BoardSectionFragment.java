// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.os.Bundle;
import android.view.View;
import com.pinterest.api.remote.UserApi;
import com.pinterest.fragment.BoardGridFragment;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.featured:
//            SectionHeaderView

public class BoardSectionFragment extends BoardGridFragment
{

    SectionHeaderView _header;

    public BoardSectionFragment()
    {
    }

    protected void loadData()
    {
        UserApi.a("me", "4", new com.pinterest.api.remote.BoardApi.BoardFeedApiResponse(gridResponseHandler), getApiTag());
        super.loadData();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _gridVw.setHideFooter(true);
        _header = new SectionHeaderView(view.getContext());
        _header.setTitle("Kick into high gear");
        _header.setSubtitle("The best routes and activities to keep the kids (and you) happy");
        _gridVw.addHeaderView(_header, -1, -2);
    }
}
