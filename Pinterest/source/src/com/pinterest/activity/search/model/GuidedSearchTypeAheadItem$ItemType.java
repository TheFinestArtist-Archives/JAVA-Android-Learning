// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.model;


public final class  extends Enum
{

    private static final BOARD $VALUES[];
    public static final BOARD BOARD;
    public static final BOARD BOARD_SEARCH_ALL;
    public static final BOARD HEADER_DIVIDER;
    public static final BOARD NONE;
    public static final BOARD PIN;
    public static final BOARD PINNER;
    public static final BOARD PINNER_SEARCH_ALL;
    public static final BOARD PIN_LOCAL_CACHE;
    public static final BOARD PIN_SEARCH_ALL;
    public static final BOARD RECENT_HISTORY_BOARD;
    public static final BOARD RECENT_HISTORY_BOARD_HEADER;
    public static final BOARD RECENT_HISTORY_MY_PIN;
    public static final BOARD RECENT_HISTORY_PIN;
    public static final BOARD RECENT_HISTORY_PINNER;
    public static final BOARD RECENT_HISTORY_PINNER_HEADER;
    public static final BOARD RECENT_HISTORY_PIN_HEADER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pinterest/activity/search/model/GuidedSearchTypeAheadItem$ItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        HEADER_DIVIDER = new <init>("HEADER_DIVIDER", 1);
        RECENT_HISTORY_PIN_HEADER = new <init>("RECENT_HISTORY_PIN_HEADER", 2);
        RECENT_HISTORY_PINNER_HEADER = new <init>("RECENT_HISTORY_PINNER_HEADER", 3);
        RECENT_HISTORY_BOARD_HEADER = new <init>("RECENT_HISTORY_BOARD_HEADER", 4);
        RECENT_HISTORY_PIN = new <init>("RECENT_HISTORY_PIN", 5);
        RECENT_HISTORY_PINNER = new <init>("RECENT_HISTORY_PINNER", 6);
        RECENT_HISTORY_BOARD = new <init>("RECENT_HISTORY_BOARD", 7);
        RECENT_HISTORY_MY_PIN = new <init>("RECENT_HISTORY_MY_PIN", 8);
        PIN_SEARCH_ALL = new <init>("PIN_SEARCH_ALL", 9);
        PIN_LOCAL_CACHE = new <init>("PIN_LOCAL_CACHE", 10);
        PINNER_SEARCH_ALL = new <init>("PINNER_SEARCH_ALL", 11);
        BOARD_SEARCH_ALL = new <init>("BOARD_SEARCH_ALL", 12);
        PIN = new <init>("PIN", 13);
        PINNER = new <init>("PINNER", 14);
        BOARD = new <init>("BOARD", 15);
        $VALUES = (new .VALUES[] {
            NONE, HEADER_DIVIDER, RECENT_HISTORY_PIN_HEADER, RECENT_HISTORY_PINNER_HEADER, RECENT_HISTORY_BOARD_HEADER, RECENT_HISTORY_PIN, RECENT_HISTORY_PINNER, RECENT_HISTORY_BOARD, RECENT_HISTORY_MY_PIN, PIN_SEARCH_ALL, 
            PIN_LOCAL_CACHE, PINNER_SEARCH_ALL, BOARD_SEARCH_ALL, PIN, PINNER, BOARD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
