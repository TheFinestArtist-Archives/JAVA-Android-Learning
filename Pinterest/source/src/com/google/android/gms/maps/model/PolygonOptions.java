// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            m, LatLng, n

public final class PolygonOptions
    implements SafeParcelable
{

    public static final m CREATOR = new m();
    private final int CK;
    private float alU;
    private int alV;
    private int alW;
    private float alX;
    private boolean alY;
    private final List amx;
    private final List amy;
    private boolean amz;

    public PolygonOptions()
    {
        alU = 10F;
        alV = 0xff000000;
        alW = 0;
        alX = 0.0F;
        alY = true;
        amz = false;
        CK = 1;
        amx = new ArrayList();
        amy = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        alU = 10F;
        alV = 0xff000000;
        alW = 0;
        alX = 0.0F;
        alY = true;
        amz = false;
        CK = i;
        amx = list;
        amy = list1;
        alU = f;
        alV = j;
        alW = k;
        alX = f1;
        alY = flag;
        amz = flag1;
    }

    public final PolygonOptions add(LatLng latlng)
    {
        amx.add(latlng);
        return this;
    }

    public final transient PolygonOptions add(LatLng alatlng[])
    {
        amx.addAll(Arrays.asList(alatlng));
        return this;
    }

    public final PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); amx.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public final PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((LatLng)iterable.next())) { }
        amy.add(arraylist);
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final PolygonOptions fillColor(int i)
    {
        alW = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean flag)
    {
        amz = flag;
        return this;
    }

    public final int getFillColor()
    {
        return alW;
    }

    public final List getHoles()
    {
        return amy;
    }

    public final List getPoints()
    {
        return amx;
    }

    public final int getStrokeColor()
    {
        return alV;
    }

    public final float getStrokeWidth()
    {
        return alU;
    }

    final int getVersionCode()
    {
        return CK;
    }

    public final float getZIndex()
    {
        return alX;
    }

    public final boolean isGeodesic()
    {
        return amz;
    }

    public final boolean isVisible()
    {
        return alY;
    }

    final List of()
    {
        return amy;
    }

    public final PolygonOptions strokeColor(int i)
    {
        alV = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f)
    {
        alU = f;
        return this;
    }

    public final PolygonOptions visible(boolean flag)
    {
        alY = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (aa.ob())
        {
            n.a(this, parcel, i);
            return;
        } else
        {
            m.a(this, parcel, i);
            return;
        }
    }

    public final PolygonOptions zIndex(float f)
    {
        alX = f;
        return this;
    }

}
