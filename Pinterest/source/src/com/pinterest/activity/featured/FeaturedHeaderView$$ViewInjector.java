// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import com.pinterest.ui.grid.user.UserGridCell;
import com.pinterest.ui.imageview.NonRoundWebImageView;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.featured:
//            FeaturedHeaderView

public class 
{

    public static void inject(butterknife.rView rview, FeaturedHeaderView featuredheaderview, Object obj)
    {
        featuredheaderview._image = (NonRoundWebImageView)rview.ew(obj, 0x7f0b0039, "field '_image'");
        featuredheaderview._title = (PTextView)rview._title(obj, 0x7f0b003d, "field '_title'");
        featuredheaderview._subTitle = (PTextView)rview._subTitle(obj, 0x7f0b02b4, "field '_subTitle'");
        featuredheaderview._userCell = (UserGridCell)rview._userCell(obj, 0x7f0b02b6, "field '_userCell'");
    }

    public static void reset(FeaturedHeaderView featuredheaderview)
    {
        featuredheaderview._image = null;
        featuredheaderview._title = null;
        featuredheaderview._subTitle = null;
        featuredheaderview._userCell = null;
    }

    public ()
    {
    }
}
