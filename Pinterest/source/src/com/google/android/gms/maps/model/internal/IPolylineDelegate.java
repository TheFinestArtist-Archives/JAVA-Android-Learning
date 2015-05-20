// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import java.util.List;

public interface IPolylineDelegate
    extends IInterface
{

    public abstract boolean equalsRemote(IPolylineDelegate ipolylinedelegate);

    public abstract int getColor();

    public abstract String getId();

    public abstract List getPoints();

    public abstract float getWidth();

    public abstract float getZIndex();

    public abstract int hashCodeRemote();

    public abstract boolean isGeodesic();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setColor(int i);

    public abstract void setGeodesic(boolean flag);

    public abstract void setPoints(List list);

    public abstract void setVisible(boolean flag);

    public abstract void setWidth(float f);

    public abstract void setZIndex(float f);
}
