// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.actionsheet;


// Referenced classes of package com.pinterest.ui.actionsheet:
//            ActionSheetFragment

class onClickListener
{

    public android.view.ActionSheetItem onClickListener;
    public String text;
    final ActionSheetFragment this$0;

    public (String s, android.view.ActionSheetItem actionsheetitem)
    {
        this$0 = ActionSheetFragment.this;
        super();
        text = s;
        onClickListener = actionsheetitem;
    }
}
