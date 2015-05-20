// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import java.util.List;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsGeofencing

final class 
    implements 
{

    public final void onPlacesLoaded(List list)
    {
        NearbyPinsGeofencing.access$000().createGeofences(list);
    }

    ()
    {
    }
}
