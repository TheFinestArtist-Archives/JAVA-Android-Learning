// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IStreetViewPanoramaFragmentDelegate, u, IStreetViewPanoramaDelegate

class le
    implements IStreetViewPanoramaFragmentDelegate
{

    private IBinder le;

    public IBinder asBinder()
    {
        return le;
    }

    public IStreetViewPanoramaDelegate getStreetViewPanorama()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        IStreetViewPanoramaDelegate istreetviewpanoramadelegate;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        istreetviewpanoramadelegate = le(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return istreetviewpanoramadelegate;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void getStreetViewPanoramaAsync(u u1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        u1 = u1.asBinder();
_L1:
        parcel.writeStrongBinder(u1);
        le.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        u1 = null;
          goto _L1
        u1;
        parcel1.recycle();
        parcel.recycle();
        throw u1;
    }

    public boolean isReady()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onCreate(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        le.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public d onCreateView(d d1, d d2, Bundle bundle)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (d1 == null) goto _L2; else goto _L1
_L1:
        d1 = d1.asBinder();
_L5:
        parcel.writeStrongBinder(d1);
        d1 = obj;
        if (d2 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        d1 = d2.asBinder();
        parcel.writeStrongBinder(d1);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        le.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        d1 = com.google.android.gms.dynamic.e.a.a.le(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d1;
_L2:
        d1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
          goto _L5
    }

    public void onDestroy()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onDestroyView()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onInflate(d d1, StreetViewPanoramaOptions streetviewpanoramaoptions, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (d1 == null) goto _L2; else goto _L1
_L1:
        d1 = d1.asBinder();
_L5:
        parcel.writeStrongBinder(d1);
        if (streetviewpanoramaoptions == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        streetviewpanoramaoptions.writeToParcel(parcel, 0);
_L6:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L7:
        le.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        d1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
        parcel.writeInt(0);
          goto _L7
    }

    public void onLowMemory()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onPause()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onResume()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        le.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        le.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() != 0)
        {
            bundle.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    (IBinder ibinder)
    {
        le = ibinder;
    }
}
