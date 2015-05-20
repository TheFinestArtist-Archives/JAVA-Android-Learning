// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.actionsheet;

import android.widget.LinearLayout;

// Referenced classes of package com.pinterest.ui.actionsheet:
//            ActionSheetFragment

public class 
{

    public static void inject(butterknife.nt nt, ActionSheetFragment actionsheetfragment, Object obj)
    {
        actionsheetfragment._sheetContainer = (LinearLayout)nt._sheetContainer(obj, 0x7f0b0123, "field '_sheetContainer'");
    }

    public static void reset(ActionSheetFragment actionsheetfragment)
    {
        actionsheetfragment._sheetContainer = null;
    }

    public ()
    {
    }
}
