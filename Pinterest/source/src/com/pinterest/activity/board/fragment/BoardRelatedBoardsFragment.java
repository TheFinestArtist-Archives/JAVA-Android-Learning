// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.fragment.BoardGridFragment;
import com.pinterest.kit.application.Resources;

public class BoardRelatedBoardsFragment extends BoardGridFragment
{

    public BoardRelatedBoardsFragment()
    {
        _layoutId = 0x7f030071;
    }

    protected void loadData()
    {
        BoardApi.a(_navigation.getId(), new com.pinterest.api.remote.BoardApi.BoardFeedApiResponse(gridResponseHandler), getApiTag());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setTitle(0x7f0e007e);
        updateEmptyContent();
    }

    protected void updateEmptyContent()
    {
        _emptyLeftImage = 0x7f02015c;
        _emptyCenterImage = 0x7f02015b;
        _emptyRightImage = 0x7f02015a;
        _emptyMessage = Resources.string(0x7f0e0201);
    }
}
