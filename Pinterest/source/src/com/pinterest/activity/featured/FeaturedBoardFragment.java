// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.board.fragment.BaseBoardFragment;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.featured:
//            FeaturedHeaderView, UserSectionFragment, BoardSectionFragment, SectionHeaderView

public class FeaturedBoardFragment extends BaseBoardFragment
{

    protected BoardSectionFragment _boardSection;
    protected FeaturedHeaderView _headerView;
    protected SectionHeaderView _sectionHeader;
    protected UserSectionFragment _userSection;

    public FeaturedBoardFragment()
    {
        _layoutId = 0x7f030082;
    }

    protected void loadData()
    {
        BoardApi.a("240590873782407111", new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler), getApiTag());
        UserApi.a("reicoop", new _cls1(), getApiTag());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _headerView = (FeaturedHeaderView)view.findViewById(0x7f0b015d);
        _userSection = new UserSectionFragment();
        FragmentHelper.replaceFragment(this, 0x7f0b015e, _userSection, false);
        _boardSection = new BoardSectionFragment();
        FragmentHelper.replaceFragment(this, 0x7f0b015f, _boardSection, false);
        _sectionHeader = new SectionHeaderView(view.getContext());
        _sectionHeader.setTitle("If you've got more time");
        _sectionHeader.setSubtitle("The best routes and activies to keep the kids (and you) happy");
        _gridVw.addHeaderView(_sectionHeader, -1, -2);
    }

    private class _cls1 extends com.pinterest.api.remote.UserApi.UserApiResponse
    {

        final FeaturedBoardFragment this$0;

        public void onSuccess(User user)
        {
            super.onSuccess(user);
            _headerView.setUser(user);
        }

        _cls1()
        {
            this$0 = FeaturedBoardFragment.this;
            super();
        }
    }

}
