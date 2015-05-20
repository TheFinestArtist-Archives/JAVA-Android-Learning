// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import android.os.SystemClock;
import com.google.android.gms.location.Geofence;
import com.pinterest.base.Application;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsGeofencing, NearbyPinsData

class this._cls0 extends com.pinterest.base.
{

    final NearbyPinsGeofencing this$0;

    public void onEventMainThread(final com.pinterest.receiver.Event finalRequestId)
    {
        Object obj;
        obj = finalRequestId.a();
        break MISSING_BLOCK_LABEL_5;
label0:
        while ("com.pinterest.MY_BUBBLE".equals(finalRequestId)) 
        {
            do
            {
                return;
            } while (obj == null || ((List) (obj)).size() == 0 || SystemClock.uptimeMillis() - NearbyPinsGeofencing.access$100() < 0x1b7740L);
            NearbyPinsGeofencing.access$102(SystemClock.uptimeMillis());
            finalRequestId = ((Geofence)((List) (obj)).get(0)).getRequestId();
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                obj = ((Geofence)iterator.next()).getRequestId();
                finalRequestId = ((com.pinterest.receiver.Event) (obj));
            } while (NearbyPinsData.wasPlaceNotified(((String) (obj))));
            finalRequestId = ((com.pinterest.receiver.Event) (obj));
        }
        Application.showDebugToast(String.format("Received geofence for place %s", new Object[] {
            finalRequestId
        }));
        class _cls1 extends BackgroundTask
        {

            private List _bitmaps;
            private Pin _pin;
            final NearbyPinsGeofencing._cls2 this$1;
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
                _pin = ModelHelper.getPinFromPlace(finalRequestId);
                if (_pin != null)
                {
                    _bitmaps = NearbyPinsGeofencing.access$200(this$0, _pin);
                }
            }

            _cls1()
            {
                this$1 = NearbyPinsGeofencing._cls2.this;
                finalRequestId = s;
                super();
            }
        }

        (new _cls1()).execute();
        return;
    }

    _cls1()
    {
        this$0 = NearbyPinsGeofencing.this;
        super();
    }
}
