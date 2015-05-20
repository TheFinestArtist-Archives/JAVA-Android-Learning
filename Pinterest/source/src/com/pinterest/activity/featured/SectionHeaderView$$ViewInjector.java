// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import com.pinterest.ui.imageview.NonRoundWebImageView;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.featured:
//            SectionHeaderView

public class 
{

    public static void inject(butterknife.rView rview, SectionHeaderView sectionheaderview, Object obj)
    {
        sectionheaderview._image = (NonRoundWebImageView)rview.iew(obj, 0x7f0b0039, "field '_image'");
        sectionheaderview._title = (PTextView)rview._title(obj, 0x7f0b003d, "field '_title'");
        sectionheaderview._subTitle = (PTextView)rview._subTitle(obj, 0x7f0b02b4, "field '_subTitle'");
    }

    public static void reset(SectionHeaderView sectionheaderview)
    {
        sectionheaderview._image = null;
        sectionheaderview._title = null;
        sectionheaderview._subTitle = null;
    }

    public ()
    {
    }
}
