// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// Referenced classes of package com.google.android.gms.maps.internal:
//            r, s, t

public interface IStreetViewPanoramaDelegate
    extends IInterface
{

    public abstract void animateTo(StreetViewPanoramaCamera streetviewpanoramacamera, long l);

    public abstract void enablePanning(boolean flag);

    public abstract void enableStreetNames(boolean flag);

    public abstract void enableUserNavigation(boolean flag);

    public abstract void enableZoom(boolean flag);

    public abstract StreetViewPanoramaCamera getPanoramaCamera();

    public abstract StreetViewPanoramaLocation getStreetViewPanoramaLocation();

    public abstract boolean isPanningGesturesEnabled();

    public abstract boolean isStreetNamesEnabled();

    public abstract boolean isUserNavigationEnabled();

    public abstract boolean isZoomGesturesEnabled();

    public abstract d orientationToPoint(StreetViewPanoramaOrientation streetviewpanoramaorientation);

    public abstract StreetViewPanoramaOrientation pointToOrientation(d d);

    public abstract void setOnStreetViewPanoramaCameraChangeListener(r r);

    public abstract void setOnStreetViewPanoramaChangeListener(s s);

    public abstract void setOnStreetViewPanoramaClickListener(t t);

    public abstract void setPosition(LatLng latlng);

    public abstract void setPositionWithID(String s);

    public abstract void setPositionWithRadius(LatLng latlng, int i);
}
