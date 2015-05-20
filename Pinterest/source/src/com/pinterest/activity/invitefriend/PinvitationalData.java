// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.graphics.Bitmap;

public class PinvitationalData
{

    private static int _friendsSelected;
    private static int _quota;
    private Bitmap _pinImage;

    public PinvitationalData()
    {
    }

    public static int getQuota()
    {
        return _quota;
    }

    public static int getQuotaLeft()
    {
        return _quota - _friendsSelected;
    }

    public static void setFriendsSelected(int i)
    {
        _friendsSelected = i;
    }

    public static void setQuota(int i)
    {
        _quota = i;
    }
}
