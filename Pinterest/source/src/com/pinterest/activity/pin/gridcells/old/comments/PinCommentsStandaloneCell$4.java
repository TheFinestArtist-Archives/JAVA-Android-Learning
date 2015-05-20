// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.comments;

import com.pinterest.api.ApiResponse;
import com.pinterest.base.Application;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.comments:
//            PinCommentsStandaloneCell

class this._cls0 extends com.pinterest.api.remote.nse
{

    final PinCommentsStandaloneCell this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        Application.showToast(0x7f0e0358);
    }

    (boolean flag)
    {
        this$0 = PinCommentsStandaloneCell.this;
        super(flag);
    }
}
