// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate
    extends IInterface
{

    public abstract d newCameraPosition(CameraPosition cameraposition);

    public abstract d newLatLng(LatLng latlng);

    public abstract d newLatLngBounds(LatLngBounds latlngbounds, int i);

    public abstract d newLatLngBoundsWithSize(LatLngBounds latlngbounds, int i, int j, int k);

    public abstract d newLatLngZoom(LatLng latlng, float f);

    public abstract d scrollBy(float f, float f1);

    public abstract d zoomBy(float f);

    public abstract d zoomByWithFocus(float f, int i, int j);

    public abstract d zoomIn();

    public abstract d zoomOut();

    public abstract d zoomTo(float f);
}
