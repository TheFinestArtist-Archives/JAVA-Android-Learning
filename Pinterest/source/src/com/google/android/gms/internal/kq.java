// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kq
    implements android.os.Parcelable.Creator
{

    public kq()
    {
    }

    static void a(ko.a a1, Parcel parcel, int i)
    {
        i = b.H(parcel);
        b.c(parcel, 1, a1.versionCode);
        b.a(parcel, 2, a1.NJ, false);
        b.c(parcel, 3, a1.NK);
        b.H(parcel, i);
    }

    public ko.a L(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        String s = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aH(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new ko.a(i, s, j);
            }
        } while (true);
    }

    public ko.a[] aM(int i)
    {
        return new ko.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return L(parcel);
    }

    public Object[] newArray(int i)
    {
        return aM(i);
    }
}
