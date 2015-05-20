// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import com.pinterest.activity.interest.view.FollowInterestButton;
import com.pinterest.ui.imageview.GrayWebImageView;
import com.pinterest.ui.text.IconView;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.digest.ui:
//            DigestHeaderView

public class 
{

    public static void inject(butterknife.erView erview, DigestHeaderView digestheaderview, Object obj)
    {
        digestheaderview._titleVw = (PTextView)erview._titleVw(obj, 0x7f0b003d, "field '_titleVw'");
        digestheaderview._coverImage = (GrayWebImageView)erview.(obj, 0x7f0b01b4, "field '_coverImage'");
        digestheaderview._removeBtn = (IconView)erview._removeBtn(obj, 0x7f0b01b5, "field '_removeBtn'");
        digestheaderview._followBtn = (FollowInterestButton)erview.InterestButton(obj, 0x7f0b01b6, "field '_followBtn'");
        digestheaderview._separator = erview._separator(obj, 0x7f0b01b3, "field '_separator'");
    }

    public static void reset(DigestHeaderView digestheaderview)
    {
        digestheaderview._titleVw = null;
        digestheaderview._coverImage = null;
        digestheaderview._removeBtn = null;
        digestheaderview._followBtn = null;
        digestheaderview._separator = null;
    }

    public ()
    {
    }
}
