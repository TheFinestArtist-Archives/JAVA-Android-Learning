// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public final class mInner
    implements Parcelable
{

    public static final android.os.iaSessionCompat.Token._cls1 CREATOR = new _cls1();
    private final Parcelable mInner;

    public final int describeContents()
    {
        return mInner.describeContents();
    }

    public final Object getToken()
    {
        return mInner;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mInner, i);
    }


    _cls1(Parcelable parcelable)
    {
        mInner = parcelable;
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final MediaSessionCompat.Token createFromParcel(Parcel parcel)
        {
            return new MediaSessionCompat.Token(parcel.readParcelable(null));
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final MediaSessionCompat.Token[] newArray(int i)
        {
            return new MediaSessionCompat.Token[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            _cls1()
            {
            }
    }

}
