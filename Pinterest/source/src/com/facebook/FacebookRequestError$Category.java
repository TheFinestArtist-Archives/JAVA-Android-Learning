// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


public final class  extends Enum
{

    private static final CLIENT $VALUES[];
    public static final CLIENT AUTHENTICATION_REOPEN_SESSION;
    public static final CLIENT AUTHENTICATION_RETRY;
    public static final CLIENT BAD_REQUEST;
    public static final CLIENT CLIENT;
    public static final CLIENT OTHER;
    public static final CLIENT PERMISSION;
    public static final CLIENT SERVER;
    public static final CLIENT THROTTLING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/FacebookRequestError$Category, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUTHENTICATION_RETRY = new <init>("AUTHENTICATION_RETRY", 0);
        AUTHENTICATION_REOPEN_SESSION = new <init>("AUTHENTICATION_REOPEN_SESSION", 1);
        PERMISSION = new <init>("PERMISSION", 2);
        SERVER = new <init>("SERVER", 3);
        THROTTLING = new <init>("THROTTLING", 4);
        OTHER = new <init>("OTHER", 5);
        BAD_REQUEST = new <init>("BAD_REQUEST", 6);
        CLIENT = new <init>("CLIENT", 7);
        $VALUES = (new .VALUES[] {
            AUTHENTICATION_RETRY, AUTHENTICATION_REOPEN_SESSION, PERMISSION, SERVER, THROTTLING, OTHER, BAD_REQUEST, CLIENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
