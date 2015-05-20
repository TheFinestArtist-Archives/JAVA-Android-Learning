// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.List;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuView, ContextMenuItemView

class this._cls0
    implements android.view.er
{

    final ContextMenuView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        MotionEventCompat.getActionMasked(motionevent);
        JVM INSTR tableswitch 0 2: default 32
    //                   0 200
    //                   1 218
    //                   2 295;
           goto _L1 _L2 _L3 _L4
_L1:
        if (ContextMenuView.access$900(ContextMenuView.this) || ContextMenuView.access$1800(ContextMenuView.this).isEmpty()) goto _L6; else goto _L5
_L5:
        view = (ContextMenuItemView)ContextMenuView.access$1800(ContextMenuView.this).get(0);
        int i = (int)view.getX();
        int j = (int)view.getY();
        int k = (int)((float)i + (float)ContextMenuView.access$1900(ContextMenuView.this) / 0.79F);
        int l = (int)((float)j + (float)ContextMenuView.access$2000(ContextMenuView.this) / 0.79F);
        ContextMenuView.access$2100(ContextMenuView.this).set(i, j, k, l);
        if (!ContextMenuView.access$2100(ContextMenuView.this).contains((int)motionevent.getX(), (int)motionevent.getY())) goto _L8; else goto _L7
_L7:
        if (motionevent.getAction() != 0) goto _L10; else goto _L9
_L9:
        ContextMenuView.access$2200(ContextMenuView.this);
        ContextMenuView.access$2400(ContextMenuView.this).postDelayed(ContextMenuView.access$2300(ContextMenuView.this), ViewConfiguration.getLongPressTimeout());
_L11:
        return true;
_L2:
        ContextMenuView.access$800(ContextMenuView.this).onTouch(view, motionevent);
        continue; /* Loop/switch isn't completed */
_L3:
        if (ContextMenuView.access$900(ContextMenuView.this))
        {
            if (ContextMenuView.access$700(ContextMenuView.this, (int)motionevent.getX(), (int)motionevent.getY()) != null)
            {
                ContextMenuView.access$1000(ContextMenuView.this);
                return true;
            }
            ContextMenuView.access$600(ContextMenuView.this);
            startEducation(ContextMenuView.access$1100(ContextMenuView.this), ContextMenuView.access$1200(ContextMenuView.this), ContextMenuView.access$1300(ContextMenuView.this));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (ContextMenuView.access$900(ContextMenuView.this) && ContextMenuView.access$000(ContextMenuView.this))
        {
            view = ContextMenuView.access$700(ContextMenuView.this, (int)motionevent.getX(), (int)motionevent.getY());
            if (view != null)
            {
                ContextMenuView.access$1400(ContextMenuView.this, view);
                ContextMenuView.access$1500(ContextMenuView.this);
            } else
            {
                ContextMenuView.access$1600(ContextMenuView.this);
                ContextMenuView.access$1700(ContextMenuView.this);
            }
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (motionevent.getAction() == 1)
        {
            ContextMenuView.access$2500(ContextMenuView.this);
        }
        if (true) goto _L11; else goto _L8
_L8:
        ContextMenuView.access$2500(ContextMenuView.this);
_L6:
        return false;
        if (true) goto _L1; else goto _L12
_L12:
    }

    w()
    {
        this$0 = ContextMenuView.this;
        super();
    }
}
