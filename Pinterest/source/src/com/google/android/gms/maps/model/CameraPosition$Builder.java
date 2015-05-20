// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPosition, LatLng

public final class alQ
{

    private LatLng alN;
    private float alO;
    private float alP;
    private float alQ;

    public final alQ bearing(float f)
    {
        alQ = f;
        return this;
    }

    public final CameraPosition build()
    {
        return new CameraPosition(alN, alO, alP, alQ);
    }

    public final alQ target(LatLng latlng)
    {
        alN = latlng;
        return this;
    }

    public final alN tilt(float f)
    {
        alP = f;
        return this;
    }

    public final alP zoom(float f)
    {
        alO = f;
        return this;
    }

    public ()
    {
    }

    public (CameraPosition cameraposition)
    {
        alN = cameraposition.target;
        alO = cameraposition.zoom;
        alP = cameraposition.tilt;
        alQ = cameraposition.bearing;
    }
}
