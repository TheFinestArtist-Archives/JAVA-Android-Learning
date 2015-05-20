// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;


public final class  extends Enum
{

    private static final OTHER_BOARD $VALUES[];
    public static final OTHER_BOARD INTEREST;
    public static final OTHER_BOARD MY_BOARD;
    public static final OTHER_BOARD OTHER_BOARD;
    public static final OTHER_BOARD USER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pinterest/activity/digest/adapter/DigestFeedbackAdapter$UnFollowItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INTEREST = new <init>("INTEREST", 0);
        USER = new <init>("USER", 1);
        MY_BOARD = new <init>("MY_BOARD", 2);
        OTHER_BOARD = new <init>("OTHER_BOARD", 3);
        $VALUES = (new .VALUES[] {
            INTEREST, USER, MY_BOARD, OTHER_BOARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
