// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;


public final class  extends Enum
{

    private static final BOLD $VALUES[];
    public static final BOLD BOLD;
    public static final BOLD LIGHT;
    public static final BOLD MEDIUM;
    public static final BOLD REGULAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pinterest/kit/utils/FontUtils$TypefaceId, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LIGHT = new <init>("LIGHT", 0);
        REGULAR = new <init>("REGULAR", 1);
        MEDIUM = new <init>("MEDIUM", 2);
        BOLD = new <init>("BOLD", 3);
        $VALUES = (new .VALUES[] {
            LIGHT, REGULAR, MEDIUM, BOLD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
