// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

class <init> extends android.view.avedState
{

    public static final android.os..SavedState._cls1 CREATOR = new _cls1();
    String curTab;

    public String toString()
    {
        return (new StringBuilder("FragmentTabHost.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(curTab).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.Parcel(parcel, i);
        parcel.writeString(curTab);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        curTab = parcel.readString();
    }

    curTab(Parcel parcel, curTab curtab)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public final FragmentTabHost.SavedState createFromParcel(Parcel parcel)
        {
            return new FragmentTabHost.SavedState(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final FragmentTabHost.SavedState[] newArray(int i)
        {
            return new FragmentTabHost.SavedState[i];
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
