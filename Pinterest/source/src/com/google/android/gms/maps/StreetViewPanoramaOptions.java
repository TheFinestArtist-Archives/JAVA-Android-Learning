// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// Referenced classes of package com.google.android.gms.maps:
//            c

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final c CREATOR = new c();
    private final int CK;
    private Boolean akG;
    private Boolean akM;
    private StreetViewPanoramaCamera alr;
    private String als;
    private LatLng alt;
    private Integer alu;
    private Boolean alv;
    private Boolean alw;
    private Boolean alx;

    public StreetViewPanoramaOptions()
    {
        alv = Boolean.valueOf(true);
        akM = Boolean.valueOf(true);
        alw = Boolean.valueOf(true);
        alx = Boolean.valueOf(true);
        CK = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        alv = Boolean.valueOf(true);
        akM = Boolean.valueOf(true);
        alw = Boolean.valueOf(true);
        alx = Boolean.valueOf(true);
        CK = i;
        alr = streetviewpanoramacamera;
        alt = latlng;
        alu = integer;
        als = s;
        alv = a.a(byte0);
        akM = a.a(byte1);
        alw = a.a(byte2);
        alx = a.a(byte3);
        akG = a.a(byte4);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Boolean getPanningGesturesEnabled()
    {
        return alw;
    }

    public final String getPanoramaId()
    {
        return als;
    }

    public final LatLng getPosition()
    {
        return alt;
    }

    public final Integer getRadius()
    {
        return alu;
    }

    public final Boolean getStreetNamesEnabled()
    {
        return alx;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera()
    {
        return alr;
    }

    public final Boolean getUseViewLifecycleInFragment()
    {
        return akG;
    }

    public final Boolean getUserNavigationEnabled()
    {
        return alv;
    }

    final int getVersionCode()
    {
        return CK;
    }

    public final Boolean getZoomGesturesEnabled()
    {
        return akM;
    }

    final byte nE()
    {
        return a.c(akG);
    }

    final byte nI()
    {
        return a.c(akM);
    }

    final byte nS()
    {
        return a.c(alv);
    }

    final byte nT()
    {
        return a.c(alw);
    }

    final byte nU()
    {
        return a.c(alx);
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean flag)
    {
        alw = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        alr = streetviewpanoramacamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String s)
    {
        als = s;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng)
    {
        alt = latlng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latlng, Integer integer)
    {
        alt = latlng;
        alu = integer;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean flag)
    {
        alx = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean flag)
    {
        akG = Boolean.valueOf(flag);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean flag)
    {
        alv = Boolean.valueOf(flag);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.c.a(this, parcel, i);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean flag)
    {
        akM = Boolean.valueOf(flag);
        return this;
    }

}
