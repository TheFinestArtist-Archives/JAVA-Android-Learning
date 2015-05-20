// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

// Referenced classes of package com.google.android.gms.maps.model:
//            g, LatLng, h

public final class LatLngBounds
    implements SafeParcelable
{

    public static final g CREATOR = new g();
    private final int CK;
    public final LatLng northeast;
    public final LatLng southwest;

    LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        jx.b(latlng, "null southwest");
        jx.b(latlng1, "null northeast");
        boolean flag;
        if (latlng1.latitude >= latlng.latitude)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.b(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.latitude), Double.valueOf(latlng1.latitude)
        });
        CK = i;
        southwest = latlng;
        northeast = latlng1;
    }

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        this(1, latlng, latlng1);
    }

    private static double b(double d1, double d2)
    {
        return ((d1 - d2) + 360D) % 360D;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static double c(double d1, double d2)
    {
        return ((d2 - d1) + 360D) % 360D;
    }

    private boolean c(double d1)
    {
        return southwest.latitude <= d1 && d1 <= northeast.latitude;
    }

    static double d(double d1, double d2)
    {
        return b(d1, d2);
    }

    private boolean d(double d1)
    {
        if (southwest.longitude > northeast.longitude) goto _L2; else goto _L1
_L1:
        if (southwest.longitude > d1 || d1 > northeast.longitude) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (southwest.longitude > d1 && d1 > northeast.longitude)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    static double e(double d1, double d2)
    {
        return c(d1, d2);
    }

    public final boolean contains(LatLng latlng)
    {
        return c(latlng.latitude) && d(latlng.longitude);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!southwest.equals(((LatLngBounds) (obj)).southwest) || !northeast.equals(((LatLngBounds) (obj)).northeast))
            {
                return false;
            }
        }
        return true;
    }

    public final LatLng getCenter()
    {
        double d2 = (southwest.latitude + northeast.latitude) / 2D;
        double d1 = northeast.longitude;
        double d3 = southwest.longitude;
        if (d3 <= d1)
        {
            d1 = (d1 + d3) / 2D;
        } else
        {
            d1 = (d1 + 360D + d3) / 2D;
        }
        return new LatLng(d2, d1);
    }

    final int getVersionCode()
    {
        return CK;
    }

    public final int hashCode()
    {
        return jv.hashCode(new Object[] {
            southwest, northeast
        });
    }

    public final LatLngBounds including(LatLng latlng)
    {
        double d4 = Math.min(southwest.latitude, latlng.latitude);
        double d5 = Math.max(northeast.latitude, latlng.latitude);
        double d2 = northeast.longitude;
        double d3 = southwest.longitude;
        double d1 = latlng.longitude;
        if (!d(d1))
        {
            if (b(d3, d1) >= c(d2, d1))
            {
                d2 = d1;
                d1 = d3;
            }
        } else
        {
            d1 = d3;
        }
        return new LatLngBounds(new LatLng(d4, d1), new LatLng(d5, d2));
    }

    public final String toString()
    {
        return jv.h(this).a("southwest", southwest).a("northeast", northeast).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (aa.ob())
        {
            h.a(this, parcel, i);
            return;
        } else
        {
            g.a(this, parcel, i);
            return;
        }
    }


    private class Builder
    {

        private double amk;
        private double aml;
        private double amm;
        private double amn;

        private boolean d(double d1)
        {
            if (amm > amn) goto _L2; else goto _L1
_L1:
            if (amm > d1 || d1 > amn) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            return false;
_L2:
            if (amm > d1 && d1 > amn)
            {
                return false;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public final LatLngBounds build()
        {
            boolean flag;
            if (!Double.isNaN(amm))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            jx.a(flag, "no included points");
            return new LatLngBounds(new LatLng(amk, amm), new LatLng(aml, amn));
        }

        public final Builder include(LatLng latlng)
        {
            double d1;
            amk = Math.min(amk, latlng.latitude);
            aml = Math.max(aml, latlng.latitude);
            d1 = latlng.longitude;
            if (!Double.isNaN(amm)) goto _L2; else goto _L1
_L1:
            amm = d1;
_L6:
            amn = d1;
_L4:
            return this;
_L2:
            if (d(d1)) goto _L4; else goto _L3
_L3:
            if (LatLngBounds.d(amm, d1) < LatLngBounds.e(amn, d1))
            {
                amm = d1;
                return this;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public Builder()
        {
            amk = (1.0D / 0.0D);
            aml = (-1.0D / 0.0D);
            amm = (0.0D / 0.0D);
            amn = (0.0D / 0.0D);
        }
    }

}
