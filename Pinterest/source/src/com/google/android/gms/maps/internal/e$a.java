// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.maps.internal:
//            e

public abstract class l.l.a extends Binder
    implements e
{

    public static e aV(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
        class a
            implements e
        {

            private IBinder le;

            public Bitmap a(l l1, int i, int j)
            {
                Object obj;
                Parcel parcel;
                Parcel parcel1;
                obj = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                if (l1 == null)
                {
                    break MISSING_BLOCK_LABEL_107;
                }
                l1 = l1.asBinder();
_L1:
                parcel.writeStrongBinder(l1);
                parcel.writeInt(i);
                parcel.writeInt(j);
                le.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                l1 = obj;
                if (parcel1.readInt() != 0)
                {
                    l1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
                }
                parcel1.recycle();
                parcel.recycle();
                return l1;
                l1 = null;
                  goto _L1
                l1;
                parcel1.recycle();
                parcel.recycle();
                throw l1;
            }

            public IBinder asBinder()
            {
                return le;
            }

            a(IBinder ibinder)
            {
                le = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof e))
        {
            return (e)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            parcel = a(com.google.android.gms.maps.model.internal.bA(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            break;
        }
        if (parcel != null)
        {
            parcel1.writeInt(1);
            parcel.writeToParcel(parcel1, 1);
            return true;
        } else
        {
            parcel1.writeInt(0);
            return true;
        }
    }
}
