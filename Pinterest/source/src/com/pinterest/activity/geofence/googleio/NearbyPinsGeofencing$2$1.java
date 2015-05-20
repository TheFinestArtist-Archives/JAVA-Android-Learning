// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import android.graphics.Bitmap;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.kit.tasks.BackgroundTask;
import java.util.List;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsGeofencing

class val.finalRequestId extends BackgroundTask
{

    private List _bitmaps;
    private Pin _pin;
    final _pin this$1;
    final String val$finalRequestId;

    public void onFinish()
    {
        if (_pin != null && _bitmaps != null && _bitmaps.size() >= 2)
        {
            NearbyPinsGeofencing.access$300(_pin, (Bitmap)_bitmaps.get(0), (Bitmap)_bitmaps.get(1));
        }
    }

    public void run()
    {
        _pin = ModelHelper.getPinFromPlace(val$finalRequestId);
        if (_pin != null)
        {
            _bitmaps = NearbyPinsGeofencing.access$200(_fld0, _pin);
        }
    }

    ()
    {
        this$1 = final_;
        val$finalRequestId = String.this;
        super();
    }
}
