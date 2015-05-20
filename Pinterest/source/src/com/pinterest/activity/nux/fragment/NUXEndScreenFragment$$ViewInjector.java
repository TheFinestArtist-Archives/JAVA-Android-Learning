// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux.fragment;

import com.pinterest.activity.nux.view.NUXAnimatedPinView;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.nux.fragment:
//            NUXEndScreenFragment

public class 
{

    public static void inject(butterknife.nFragment nfragment, NUXEndScreenFragment nuxendscreenfragment, Object obj)
    {
        nuxendscreenfragment._illustrationsView = (NUXAnimatedPinView)nfragment.iew(obj, 0x7f0b0179, "field '_illustrationsView'");
        nuxendscreenfragment._title = (PTextView)nfragment._title(obj, 0x7f0b003d, "field '_title'");
        nuxendscreenfragment._desc = (PTextView)nfragment._desc(obj, 0x7f0b017a, "field '_desc'");
    }

    public static void reset(NUXEndScreenFragment nuxendscreenfragment)
    {
        nuxendscreenfragment._illustrationsView = null;
        nuxendscreenfragment._title = null;
        nuxendscreenfragment._desc = null;
    }

    public ()
    {
    }
}
