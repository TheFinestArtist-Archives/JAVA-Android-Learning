// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.actionbar;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.ui.actionbar:
//            MetadataBar

public class 
{

    public static void inject(butterknife. , MetadataBar metadatabar, Object obj)
    {
        metadatabar._iconIv = (ImageView)._iconIv(obj, 0x7f0b0064, "field '_iconIv'");
        metadatabar._titleTv = (PTextView)._titleTv(obj, 0x7f0b0065, "field '_titleTv'");
        metadatabar._addonsLl = (LinearLayout)._addonsLl(obj, 0x7f0b0066, "field '_addonsLl'");
        metadatabar._shadowUp = ._shadowUp(obj, 0x7f0b0063, "field '_shadowUp'");
        metadatabar._shadowDown = ._shadowDown(obj, 0x7f0b0067, "field '_shadowDown'");
    }

    public static void reset(MetadataBar metadatabar)
    {
        metadatabar._iconIv = null;
        metadatabar._titleTv = null;
        metadatabar._addonsLl = null;
        metadatabar._shadowUp = null;
        metadatabar._shadowDown = null;
    }

    public ()
    {
    }
}
