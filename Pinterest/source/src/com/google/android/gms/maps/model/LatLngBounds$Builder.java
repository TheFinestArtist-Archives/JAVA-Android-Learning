// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.internal.jx;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public final class amn
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

    public final amn include(LatLng latlng)
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

    public ()
    {
        amk = (1.0D / 0.0D);
        aml = (-1.0D / 0.0D);
        amm = (0.0D / 0.0D);
        amn = (0.0D / 0.0D);
    }
}
