// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupPlaceView

class this._cls0
    implements com.google.android.gms.maps.kListener
{

    final PinCloseupPlaceView this$0;

    public boolean onMarkerClick(Marker marker)
    {
        (new com.pinterest.activity.board.fragment.oseupMarkerClickListener(_pin)).onClick();
        return true;
    }

    loseupMarkerClickListener()
    {
        this$0 = PinCloseupPlaceView.this;
        super();
    }
}
