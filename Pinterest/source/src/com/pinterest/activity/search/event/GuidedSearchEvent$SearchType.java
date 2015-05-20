// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.event;


public final class  extends Enum
{

    private static final BOARD $VALUES[];
    public static final BOARD BOARD;
    public static final BOARD PIN;
    public static final BOARD PINNER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pinterest/activity/search/event/GuidedSearchEvent$SearchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PIN = new <init>("PIN", 0);
        PINNER = new <init>("PINNER", 1);
        BOARD = new <init>("BOARD", 2);
        $VALUES = (new .VALUES[] {
            PIN, PINNER, BOARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
