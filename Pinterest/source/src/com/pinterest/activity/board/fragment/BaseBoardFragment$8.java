// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import com.pinterest.education.EducationHelper;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.activity.board.fragment:
//            BaseBoardFragment

class Handler extends com.pinterest.api.remote.ienceResponseHandler
{

    final BaseBoardFragment this$0;

    public void onSuccess()
    {
        if (isActive())
        {
            BaseBoardFragment.access$802(BaseBoardFragment.this, EducationHelper.a(Placement.ANDROID_BOARD_TAKEOVER, BaseBoardFragment.this));
        }
    }

    Handler()
    {
        this$0 = BaseBoardFragment.this;
        super();
    }
}
