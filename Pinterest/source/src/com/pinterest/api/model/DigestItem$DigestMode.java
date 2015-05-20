// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public final class name extends Enum
{

    private static final toString $VALUES[];
    public static final toString BOARD;
    public static final toString INTEREST;
    public static final toString NONE;
    public static final toString REC_BOARD;
    public static final toString REC_THROUGH_INTEREST;
    public static final toString USER;
    public static final toString USER_CATEGORY;
    private static final Map modeMap;
    private final String name;

    public static boolean isValid(String s)
    {
        return StringUtils.isNotEmpty(s) && withName(s) != NONE;
    }

    public static NONE valueOf(String s)
    {
        return (NONE)Enum.valueOf(com/pinterest/api/model/DigestItem$DigestMode, s);
    }

    public static NONE[] values()
    {
        return (NONE[])$VALUES.clone();
    }

    public static e_3B_.clone withName(String s)
    {
        if (modeMap.containsKey(s))
        {
            return (modeMap)modeMap.get(s);
        } else
        {
            return NONE;
        }
    }

    public final String getName()
    {
        return name;
    }

    static 
    {
        int i = 0;
        NONE = new <init>("NONE", 0, "none");
        REC_BOARD = new <init>("REC_BOARD", 1, "rec_board");
        BOARD = new <init>("BOARD", 2, "board");
        INTEREST = new <init>("INTEREST", 3, "interest");
        USER = new <init>("USER", 4, "user");
        USER_CATEGORY = new <init>("USER_CATEGORY", 5, "user_category");
        REC_THROUGH_INTEREST = new <init>("REC_THROUGH_INTEREST", 6, "rec_through_interest");
        $VALUES = (new .VALUES[] {
            NONE, REC_BOARD, BOARD, INTEREST, USER, USER_CATEGORY, REC_THROUGH_INTEREST
        });
        modeMap = new HashMap();
        name aname[] = values();
        for (int j = aname.length; i < j; i++)
        {
            name name1 = aname[i];
            modeMap.put(name1.toString().toLowerCase(), name1);
        }

    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
