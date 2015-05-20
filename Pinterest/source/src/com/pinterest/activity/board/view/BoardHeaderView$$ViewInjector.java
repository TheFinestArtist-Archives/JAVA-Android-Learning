// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.pinterest.activity.board.view:
//            BoardHeaderView

public class 
{

    public static void inject(butterknife.derView derview, BoardHeaderView boardheaderview, Object obj)
    {
        boardheaderview._infoTv = (TextView)derview._infoTv(obj, 0x7f0b01bc, "field '_infoTv'");
        boardheaderview._descTv = (TextView)derview._descTv(obj, 0x7f0b018f, "field '_descTv'");
        boardheaderview._collabWrapper = (ViewGroup)derview._collabWrapper(obj, 0x7f0b01bb, "field '_collabWrapper'");
        boardheaderview._userContainer = (LinearLayout)derview._userContainer(obj, 0x7f0b01bd, "field '_userContainer'");
    }

    public static void reset(BoardHeaderView boardheaderview)
    {
        boardheaderview._infoTv = null;
        boardheaderview._descTv = null;
        boardheaderview._collabWrapper = null;
        boardheaderview._userContainer = null;
    }

    public ()
    {
    }
}
