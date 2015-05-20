// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class NagType extends Enum
    implements TEnum
{

    private static final NagType $VALUES[];
    public static final NagType CREATE_PLACE_BOARD;
    public static final NagType EMAIL_CONFIRMATION;
    public static final NagType FRIEND_INVITER;
    public static final NagType REBUILD_FEED;
    public static final NagType UNDO_REBUILD_FEED;
    public static final NagType UPDATE_APP_HELPER;
    public static final NagType WRITE_BANNED;
    private final int value;

    private NagType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static NagType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return EMAIL_CONFIRMATION;

        case 1: // '\001'
            return CREATE_PLACE_BOARD;

        case 2: // '\002'
            return FRIEND_INVITER;

        case 3: // '\003'
            return REBUILD_FEED;

        case 4: // '\004'
            return UNDO_REBUILD_FEED;

        case 5: // '\005'
            return WRITE_BANNED;

        case 6: // '\006'
            return UPDATE_APP_HELPER;
        }
    }

    public static NagType valueOf(String s)
    {
        return (NagType)Enum.valueOf(com/pinterest/schemas/event/NagType, s);
    }

    public static NagType[] values()
    {
        return (NagType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        EMAIL_CONFIRMATION = new NagType("EMAIL_CONFIRMATION", 0, 0);
        CREATE_PLACE_BOARD = new NagType("CREATE_PLACE_BOARD", 1, 1);
        FRIEND_INVITER = new NagType("FRIEND_INVITER", 2, 2);
        REBUILD_FEED = new NagType("REBUILD_FEED", 3, 3);
        UNDO_REBUILD_FEED = new NagType("UNDO_REBUILD_FEED", 4, 4);
        WRITE_BANNED = new NagType("WRITE_BANNED", 5, 5);
        UPDATE_APP_HELPER = new NagType("UPDATE_APP_HELPER", 6, 6);
        $VALUES = (new NagType[] {
            EMAIL_CONFIRMATION, CREATE_PLACE_BOARD, FRIEND_INVITER, REBUILD_FEED, UNDO_REBUILD_FEED, WRITE_BANNED, UPDATE_APP_HELPER
        });
    }
}
