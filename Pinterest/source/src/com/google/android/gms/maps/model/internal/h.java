// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import com.google.android.gms.maps.model.LatLng;

public interface h
    extends IInterface
{

    public abstract boolean a(h h1);

    public abstract LatLng getCenter();

    public abstract int getFillColor();

    public abstract String getId();

    public abstract double getRadius();

    public abstract int getStrokeColor();

    public abstract float getStrokeWidth();

    public abstract float getZIndex();

    public abstract int hashCodeRemote();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setCenter(LatLng latlng);

    public abstract void setFillColor(int i);

    public abstract void setRadius(double d);

    public abstract void setStrokeColor(int i);

    public abstract void setStrokeWidth(float f);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
