// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux.fragment;

import com.pinterest.activity.nux.view.NUXContinueBar;

// Referenced classes of package com.pinterest.activity.nux.fragment:
//            NUXInterestsPickerFragment

public class 
{

    public static void inject(butterknife.rFragment rfragment, NUXInterestsPickerFragment nuxinterestspickerfragment, Object obj)
    {
        com.pinterest.fragment.t(rfragment, nuxinterestspickerfragment, obj);
        nuxinterestspickerfragment._continueBar = (NUXContinueBar)rfragment._continueBar(obj, 0x7f0b017c, "field '_continueBar'");
    }

    public static void reset(NUXInterestsPickerFragment nuxinterestspickerfragment)
    {
        com.pinterest.fragment.(nuxinterestspickerfragment);
        nuxinterestspickerfragment._continueBar = null;
    }

    public ()
    {
    }
}
