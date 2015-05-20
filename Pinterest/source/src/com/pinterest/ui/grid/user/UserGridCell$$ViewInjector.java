// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.widget.TextView;

// Referenced classes of package com.pinterest.ui.grid.user:
//            UserGridCellTitleView, UserGridCell, UserGridCellImageView

public class 
{

    public static void inject(butterknife. , UserGridCell usergridcell, Object obj)
    {
        usergridcell._title = (UserGridCellTitleView).TitleView(obj, 0x7f0b003d, "field '_title'");
        usergridcell._cover = (UserGridCellImageView).ImageView(obj, 0x7f0b01e1, "field '_cover'");
        usergridcell._followTv = (TextView)._followTv(obj, 0x7f0b01e2, "field '_followTv'");
    }

    public static void reset(UserGridCell usergridcell)
    {
        usergridcell._title = null;
        usergridcell._cover = null;
        usergridcell._followTv = null;
    }

    public ()
    {
    }
}
