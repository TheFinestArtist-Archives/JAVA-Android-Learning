// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Parcel;

final class A
    implements android.os.SessionCompat.Token._cls1
{

    public final A createFromParcel(Parcel parcel)
    {
        return new nit>(parcel.readParcelable(null));
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    A()
    {
    }
}
