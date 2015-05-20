// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import android.view.View;
import com.pinterest.base.Events;
import com.pinterest.ui.menu.ShowPinContextMenuEvent;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseupView

class this._cls0
    implements android.view.istener
{

    final PinCloseupView this$0;

    public boolean onLongClick(View view)
    {
        Events.post(new ShowPinContextMenuEvent(PinCloseupView.access$100(PinCloseupView.this)));
        return true;
    }

    ()
    {
        this$0 = PinCloseupView.this;
        super();
    }
}
