// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.appwidget;


public class MccMnc
{

    private static final String TEMPLATE = " MCC: %d, MNC: %d";
    public int mcc;
    public int mnc;

    public MccMnc(int i, int j)
    {
        mcc = i;
        mnc = j;
    }

    public boolean equals(MccMnc mccmnc)
    {
        return mcc == mccmnc.mcc && mnc == mccmnc.mnc;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MccMnc)) 
        {
            return false;
        }
        return equals((MccMnc)obj);
    }

    public int hashCode()
    {
        return mcc * 1000 + mnc;
    }

    public boolean isValid()
    {
        return mcc > 0;
    }

    public String toString()
    {
        return String.format(" MCC: %d, MNC: %d", new Object[] {
            Integer.valueOf(mcc), Integer.valueOf(mnc)
        });
    }
}
