// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;


// Referenced classes of package com.pinterest.activity.create.fragment:
//            BoardPickerFragment

class this._cls0 extends com.pinterest.base.r
{

    final BoardPickerFragment this$0;

    public void onEventMainThread(com.pinterest.events.alidated alidated)
    {
        if (_adapter != null)
        {
            loadCachedBoards();
        }
    }

    ()
    {
        this$0 = BoardPickerFragment.this;
        super();
    }
}
