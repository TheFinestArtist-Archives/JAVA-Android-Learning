// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.widget.TextView;

// Referenced classes of package com.pinterest.ui.grid.user:
//            UserGridCellTitleView

public class 
{

    public static void inject(butterknife. , UserGridCellTitleView usergridcelltitleview, Object obj)
    {
        usergridcelltitleview._titleTv = (TextView)._titleTv(obj, 0x7f0b0065, "field '_titleTv'");
        usergridcelltitleview._subtitleTv = (TextView)._subtitleTv(obj, 0x7f0b0201, "field '_subtitleTv'");
        usergridcelltitleview._verifiedIv = ._verifiedIv(obj, 0x7f0b0231, "field '_verifiedIv'");
    }

    public static void reset(UserGridCellTitleView usergridcelltitleview)
    {
        usergridcelltitleview._titleTv = null;
        usergridcelltitleview._subtitleTv = null;
        usergridcelltitleview._verifiedIv = null;
    }

    public ()
    {
    }
}
