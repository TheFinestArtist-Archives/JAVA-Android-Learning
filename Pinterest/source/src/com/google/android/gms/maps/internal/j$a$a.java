// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package com.google.android.gms.maps.internal:
//            j

class le
    implements j
{

    private IBinder le;

    public IBinder asBinder()
    {
        return le;
    }

    public void onMapClick(LatLng latlng)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapClickListener");
        if (latlng == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L1:
        le.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        latlng;
        parcel1.recycle();
        parcel.recycle();
        throw latlng;
    }

    (IBinder ibinder)
    {
        le = ibinder;
    }
}
