// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;


public class FindFriendEvent
{

    private String _email;
    private String _imageUri;
    private String _name;

    public FindFriendEvent(String s, String s1, String s2)
    {
        _name = s;
        _email = s1;
        _imageUri = s2;
    }

    public String getEmail()
    {
        return _email;
    }

    public String getImageUri()
    {
        return _imageUri;
    }

    public String getName()
    {
        return _name;
    }
}
