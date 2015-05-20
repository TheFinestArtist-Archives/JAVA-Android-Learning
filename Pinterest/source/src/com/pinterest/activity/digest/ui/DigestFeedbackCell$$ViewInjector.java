// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import com.pinterest.ui.imageview.GrayWebImageView;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.digest.ui:
//            DigestFeedbackCell

public class 
{

    public static void inject(butterknife.ckCell ckcell, DigestFeedbackCell digestfeedbackcell, Object obj)
    {
        digestfeedbackcell._titleVw = (PTextView)ckcell._titleVw(obj, 0x7f0b003d, "field '_titleVw'");
        digestfeedbackcell._coverImage = (GrayWebImageView)ckcell._coverImage(obj, 0x7f0b01b4, "field '_coverImage'");
    }

    public static void reset(DigestFeedbackCell digestfeedbackcell)
    {
        digestfeedbackcell._titleVw = null;
        digestfeedbackcell._coverImage = null;
    }

    public ()
    {
    }
}
