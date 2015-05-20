// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;

public interface IUiSettingsDelegate
    extends IInterface
{

    public abstract boolean isCompassEnabled();

    public abstract boolean isIndoorLevelPickerEnabled();

    public abstract boolean isMapToolbarEnabled();

    public abstract boolean isMyLocationButtonEnabled();

    public abstract boolean isRotateGesturesEnabled();

    public abstract boolean isScrollGesturesEnabled();

    public abstract boolean isTiltGesturesEnabled();

    public abstract boolean isZoomControlsEnabled();

    public abstract boolean isZoomGesturesEnabled();

    public abstract void setAllGesturesEnabled(boolean flag);

    public abstract void setCompassEnabled(boolean flag);

    public abstract void setIndoorLevelPickerEnabled(boolean flag);

    public abstract void setMapToolbarEnabled(boolean flag);

    public abstract void setMyLocationButtonEnabled(boolean flag);

    public abstract void setRotateGesturesEnabled(boolean flag);

    public abstract void setScrollGesturesEnabled(boolean flag);

    public abstract void setTiltGesturesEnabled(boolean flag);

    public abstract void setZoomControlsEnabled(boolean flag);

    public abstract void setZoomGesturesEnabled(boolean flag);
}
