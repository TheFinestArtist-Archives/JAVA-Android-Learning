// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.internal:
//            y

public class z
    implements android.os.Parcelable.Creator
{

    public z()
    {
    }

    static void a(y y1, Parcel parcel, int i)
    {
        int j = b.H(parcel);
        b.c(parcel, 1, y1.getVersionCode());
        b.a(parcel, 2, y1.oa(), i, false);
        b.H(parcel, j);
    }

    public y cZ(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.G(parcel);
        int i = 0;
        Point point = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.F(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    point = (Point)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Point.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new y(i, point);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return cZ(parcel);
    }

    public y[] eV(int i)
    {
        return new y[i];
    }

    public Object[] newArray(int i)
    {
        return eV(i);
    }
}
