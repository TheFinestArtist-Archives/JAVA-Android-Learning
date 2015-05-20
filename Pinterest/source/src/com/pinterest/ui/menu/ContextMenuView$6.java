// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;


// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuView, PinContextMenu

class this._cls0
    implements Runnable
{

    final ContextMenuView this$0;

    public void run()
    {
        if (!ContextMenuView.access$900(ContextMenuView.this))
        {
            ContextMenuView.access$902(ContextMenuView.this, true);
            (new PinContextMenu()).show(ContextMenuView.this, null);
            ContextMenuView.access$1600(ContextMenuView.this);
            ContextMenuView.access$1700(ContextMenuView.this);
        }
    }

    ()
    {
        this$0 = ContextMenuView.this;
        super();
    }
}
