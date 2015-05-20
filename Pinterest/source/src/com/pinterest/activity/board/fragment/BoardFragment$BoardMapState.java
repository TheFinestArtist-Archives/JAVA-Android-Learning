// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;


public final class  extends Enum
{

    private static final CLOSED $VALUES[];
    public static final CLOSED CLOSED;
    public static final CLOSED OPEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pinterest/activity/board/fragment/BoardFragment$BoardMapState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OPEN = new <init>("OPEN", 0);
        CLOSED = new <init>("CLOSED", 1);
        $VALUES = (new .VALUES[] {
            OPEN, CLOSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
