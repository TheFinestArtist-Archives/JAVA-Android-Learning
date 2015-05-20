// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            StreetViewPanoramaCamera, StreetViewPanoramaOrientation

public final class tilt
{

    public float bearing;
    public float tilt;
    public float zoom;

    public final tilt bearing(float f)
    {
        bearing = f;
        return this;
    }

    public final StreetViewPanoramaCamera build()
    {
        return new StreetViewPanoramaCamera(zoom, tilt, bearing);
    }

    public final bearing orientation(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        tilt = streetviewpanoramaorientation.tilt;
        bearing = streetviewpanoramaorientation.bearing;
        return this;
    }

    public final ring tilt(float f)
    {
        tilt = f;
        return this;
    }

    public final tilt zoom(float f)
    {
        zoom = f;
        return this;
    }

    public ()
    {
    }

    public (StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        zoom = streetviewpanoramacamera.zoom;
        bearing = streetviewpanoramacamera.bearing;
        tilt = streetviewpanoramacamera.tilt;
    }
}
