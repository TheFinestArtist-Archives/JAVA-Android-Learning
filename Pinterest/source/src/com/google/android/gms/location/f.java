// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.location:
//            e

public class f
    implements android.os.Parcelable.Creator
{

    public f()
    {
    }

    static void a(e e1, Parcel parcel, int i)
    {
        i = b.H(parcel);
        b.c(parcel, 1, e1.agw);
        b.c(parcel, 1000, e1.getVersionCode());
        b.c(parcel, 2, e1.agx);
        b.a(parcel, 3, e1.agy);
        b.H(parcel, i);
    }

    public e cK(Parcel parcel)
    {
        int i = 1;
        int l = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int k = 0;
        long l1 = 0L;
        int j = 1;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aH(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 1000: 
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new e(k, j, i, l1);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return cK(parcel);
    }

    public e[] eE(int i)
    {
        return new e[i];
    }

    public Object[] newArray(int i)
    {
        return eE(i);
    }
}
