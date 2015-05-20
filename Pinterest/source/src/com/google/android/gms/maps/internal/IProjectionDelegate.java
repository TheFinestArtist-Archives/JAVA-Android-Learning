// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

// Referenced classes of package com.google.android.gms.maps.internal:
//            y

public interface IProjectionDelegate
    extends IInterface
{

    public abstract LatLng fromScreenLocation(d d);

    public abstract LatLng fromScreenLocation2(y y);

    public abstract VisibleRegion getVisibleRegion();

    public abstract d toScreenLocation(LatLng latlng);

    public abstract y toScreenLocation2(LatLng latlng);
}
