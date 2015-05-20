// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.sendapin.model;


public class SendableObject
{

    public static final int TYPE_BOARD = 1;
    public static final int TYPE_PIN = 0;
    public static final int TYPE_USER = 2;
    private int type;
    private String uid;

    public SendableObject(String s, int i)
    {
        uid = s;
        type = i;
    }

    public int getType()
    {
        return type;
    }

    public String getUid()
    {
        return uid;
    }

    public boolean isBoard()
    {
        return type == 1;
    }

    public boolean isPin()
    {
        return type == 0;
    }

    public boolean isUser()
    {
        return type == 2;
    }
}
