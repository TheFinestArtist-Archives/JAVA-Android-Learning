// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;

// Referenced classes of package com.google.android.gms.plus.internal:
//            c

class le
    implements c
{

    private IBinder le;

    public d a(d d1, int i, int j, String s, int k)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeInt(k);
        le.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        d1 = com.google.android.gms.dynamic.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d1;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public d a(d d1, int i, int j, String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        d1 = d1.asBinder();
_L1:
        parcel.writeStrongBinder(d1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeString(s1);
        le.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        d1 = com.google.android.gms.dynamic.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return d1;
        d1 = null;
          goto _L1
        d1;
        parcel1.recycle();
        parcel.recycle();
        throw d1;
    }

    public IBinder asBinder()
    {
        return le;
    }

    (IBinder ibinder)
    {
        le = ibinder;
    }
}
