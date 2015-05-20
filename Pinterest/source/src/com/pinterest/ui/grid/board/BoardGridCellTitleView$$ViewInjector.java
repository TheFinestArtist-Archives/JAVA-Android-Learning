// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.board;

import android.widget.TextView;

// Referenced classes of package com.pinterest.ui.grid.board:
//            BoardGridCellTitleView

public class 
{

    public static void inject(butterknife.w w, BoardGridCellTitleView boardgridcelltitleview, Object obj)
    {
        boardgridcelltitleview._titleTv = (TextView)w._titleTv(obj, 0x7f0b0065, "field '_titleTv'");
        boardgridcelltitleview._placeIv = w._placeIv(obj, 0x7f0b01e5, "field '_placeIv'");
        boardgridcelltitleview._secretIv = w._secretIv(obj, 0x7f0b01e7, "field '_secretIv'");
        boardgridcelltitleview._collabIv = w._collabIv(obj, 0x7f0b01e6, "field '_collabIv'");
    }

    public static void reset(BoardGridCellTitleView boardgridcelltitleview)
    {
        boardgridcelltitleview._titleTv = null;
        boardgridcelltitleview._placeIv = null;
        boardgridcelltitleview._secretIv = null;
        boardgridcelltitleview._collabIv = null;
    }

    public ()
    {
    }
}
