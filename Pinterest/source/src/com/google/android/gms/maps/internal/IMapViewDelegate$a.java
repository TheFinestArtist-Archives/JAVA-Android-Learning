// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IMapViewDelegate, IGoogleMapDelegate

public abstract class a extends Binder
    implements IMapViewDelegate
{

    public static IMapViewDelegate aY(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        class a
            implements IMapViewDelegate
        {

            private IBinder le;

            public IBinder asBinder()
            {
                return le;
            }

            public IGoogleMapDelegate getMap()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IGoogleMapDelegate igooglemapdelegate;
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                le.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                igooglemapdelegate = IGoogleMapDelegate.a.aT(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return igooglemapdelegate;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getMapAsync(m m1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (m1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                m1 = m1.asBinder();
_L1:
                parcel.writeStrongBinder(m1);
                le.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                m1 = null;
                  goto _L1
                m1;
                parcel1.recycle();
                parcel.recycle();
                throw m1;
            }

            public d getView()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                d d1;
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                le.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                d1 = com.google.android.gms.dynamic.d.a.ap(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return d1;
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
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                le.transact(2, parcel, parcel1, 0);
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

            public void onDestroy()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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

            public void onLowMemory()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
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

            public void onPause()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                le.transact(4, parcel, parcel1, 0);
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
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                le.transact(3, parcel, parcel1, 0);
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
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_69;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                le.transact(7, parcel, parcel1, 0);
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

            a(IBinder ibinder)
            {
                le = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof IMapViewDelegate))
        {
            return (IMapViewDelegate)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj2 = null;
        IGoogleMapDelegate igooglemapdelegate = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            igooglemapdelegate = getMap();
            parcel1.writeNoException();
            parcel = obj;
            if (igooglemapdelegate != null)
            {
                parcel = igooglemapdelegate.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            Bundle bundle = obj1;
            if (parcel.readInt() != 0)
            {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            onCreate(bundle);
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            onResume();
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            onPause();
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            onDestroy();
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            onLowMemory();
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            Bundle bundle1 = obj2;
            if (parcel.readInt() != 0)
            {
                bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            onSaveInstanceState(bundle1);
            parcel1.writeNoException();
            if (bundle1 != null)
            {
                parcel1.writeInt(1);
                bundle1.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            d d1 = getView();
            parcel1.writeNoException();
            parcel = igooglemapdelegate;
            if (d1 != null)
            {
                parcel = d1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            getMapAsync(getMapAsync(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
