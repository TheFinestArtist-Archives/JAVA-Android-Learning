// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


public final class  extends Enum
{

    public static final arX arV;
    public static final arX arW;
    public static final arX arX;
    private static final arX arY[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/bg$a, s);
    }

    public static [] values()
    {
        return ([])arY.clone();
    }

    static 
    {
        arV = new <init>("NOT_AVAILABLE", 0);
        arW = new <init>("IO_ERROR", 1);
        arX = new <init>("SERVER_ERROR", 2);
        arY = (new arY[] {
            arV, arW, arX
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
