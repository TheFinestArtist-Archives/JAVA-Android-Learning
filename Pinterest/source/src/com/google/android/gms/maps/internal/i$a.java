// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.maps.internal:
//            i

public abstract class a extends Binder
    implements i
{

    public static i bc(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
        class a
            implements i
        {

            private IBinder le;

            public IBinder asBinder()
            {
                return le;
            }

            public void d(Location location)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                if (location == null)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
_L1:
                le.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                location;
                parcel1.recycle();
                parcel.recycle();
                throw location;
            }

            public void l(d d1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                if (d1 == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                d1 = d1.asBinder();
_L1:
                parcel.writeStrongBinder(d1);
                le.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                d1 = null;
                  goto _L1
                d1;
                parcel1.recycle();
                parcel.recycle();
                throw d1;
            }

            a(IBinder ibinder)
            {
                le = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof i))
        {
            return (i)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int k)
    {
        switch (j)
        {
        default:
            return super.onTransact(j, parcel, parcel1, k);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            l(com.google.android.gms.dynamic.ap(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Location)Location.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        d(parcel);
        parcel1.writeNoException();
        return true;
    }
}
