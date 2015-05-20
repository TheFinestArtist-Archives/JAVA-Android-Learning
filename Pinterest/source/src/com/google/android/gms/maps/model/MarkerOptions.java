// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.internal.aa;

// Referenced classes of package com.google.android.gms.maps.model:
//            k, BitmapDescriptor, l, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final k CREATOR = new k();
    private final int CK;
    private String OH;
    private boolean alY;
    private LatLng alt;
    private float amg;
    private float amh;
    private String amp;
    private BitmapDescriptor amq;
    private boolean amr;
    private boolean ams;
    private float amt;
    private float amu;
    private float amv;
    private float mAlpha;

    public MarkerOptions()
    {
        amg = 0.5F;
        amh = 1.0F;
        alY = true;
        ams = false;
        amt = 0.0F;
        amu = 0.5F;
        amv = 0.0F;
        mAlpha = 1.0F;
        CK = 1;
    }

    MarkerOptions(int i, LatLng latlng, String s, String s1, IBinder ibinder, float f, float f1, 
            boolean flag, boolean flag1, boolean flag2, float f2, float f3, float f4, float f5)
    {
        amg = 0.5F;
        amh = 1.0F;
        alY = true;
        ams = false;
        amt = 0.0F;
        amu = 0.5F;
        amv = 0.0F;
        mAlpha = 1.0F;
        CK = i;
        alt = latlng;
        OH = s;
        amp = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new BitmapDescriptor(com.google.android.gms.dynamic.d.a.ap(ibinder));
        }
        amq = latlng;
        amg = f;
        amh = f1;
        amr = flag;
        alY = flag1;
        ams = flag2;
        amt = f2;
        amu = f3;
        amv = f4;
        mAlpha = f5;
    }

    public final MarkerOptions alpha(float f)
    {
        mAlpha = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f1)
    {
        amg = f;
        amh = f1;
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final MarkerOptions draggable(boolean flag)
    {
        amr = flag;
        return this;
    }

    public final MarkerOptions flat(boolean flag)
    {
        ams = flag;
        return this;
    }

    public final float getAlpha()
    {
        return mAlpha;
    }

    public final float getAnchorU()
    {
        return amg;
    }

    public final float getAnchorV()
    {
        return amh;
    }

    public final BitmapDescriptor getIcon()
    {
        return amq;
    }

    public final float getInfoWindowAnchorU()
    {
        return amu;
    }

    public final float getInfoWindowAnchorV()
    {
        return amv;
    }

    public final LatLng getPosition()
    {
        return alt;
    }

    public final float getRotation()
    {
        return amt;
    }

    public final String getSnippet()
    {
        return amp;
    }

    public final String getTitle()
    {
        return OH;
    }

    final int getVersionCode()
    {
        return CK;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapdescriptor)
    {
        amq = bitmapdescriptor;
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float f, float f1)
    {
        amu = f;
        amv = f1;
        return this;
    }

    public final boolean isDraggable()
    {
        return amr;
    }

    public final boolean isFlat()
    {
        return ams;
    }

    public final boolean isVisible()
    {
        return alY;
    }

    final IBinder oe()
    {
        if (amq == null)
        {
            return null;
        } else
        {
            return amq.nA().asBinder();
        }
    }

    public final MarkerOptions position(LatLng latlng)
    {
        alt = latlng;
        return this;
    }

    public final MarkerOptions rotation(float f)
    {
        amt = f;
        return this;
    }

    public final MarkerOptions snippet(String s)
    {
        amp = s;
        return this;
    }

    public final MarkerOptions title(String s)
    {
        OH = s;
        return this;
    }

    public final MarkerOptions visible(boolean flag)
    {
        alY = flag;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (aa.ob())
        {
            l.a(this, parcel, i);
            return;
        } else
        {
            k.a(this, parcel, i);
            return;
        }
    }

}
