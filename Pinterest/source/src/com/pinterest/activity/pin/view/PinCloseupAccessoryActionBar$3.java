// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.pin.adapter.IconTextListAdapter;

// Referenced classes of package com.pinterest.activity.pin.view:
//            PinCloseupAccessoryActionBar

class val.adapter
    implements android.widget.
{

    final PinCloseupAccessoryActionBar this$0;
    final IconTextListAdapter val$adapter;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < 0 || i >= val$adapter.getCount()) goto _L2; else goto _L1
_L1:
        (int)l;
        JVM INSTR tableswitch 2131428114 2131428115: default 40
    //                   2131428114 71
    //                   2131428115 61;
           goto _L2 _L3 _L4
_L2:
        if (PinCloseupAccessoryActionBar.access$500(PinCloseupAccessoryActionBar.this) != null)
        {
            PinCloseupAccessoryActionBar.access$500(PinCloseupAccessoryActionBar.this).dismiss();
        }
        return;
_L4:
        PinCloseupAccessoryActionBar.access$300(PinCloseupAccessoryActionBar.this);
        continue; /* Loop/switch isn't completed */
_L3:
        PinCloseupAccessoryActionBar.access$400(PinCloseupAccessoryActionBar.this);
        if (true) goto _L2; else goto _L5
_L5:
    }

    ()
    {
        this$0 = final_pincloseupaccessoryactionbar;
        val$adapter = IconTextListAdapter.this;
        super();
    }
}
