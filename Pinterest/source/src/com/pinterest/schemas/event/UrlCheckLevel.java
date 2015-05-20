// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class UrlCheckLevel extends Enum
    implements TEnum
{

    private static final UrlCheckLevel $VALUES[];
    public static final UrlCheckLevel DOMAIN;
    public static final UrlCheckLevel PAGE_CONTENTS;
    public static final UrlCheckLevel REDIRECT;
    private final int value;

    private UrlCheckLevel(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static UrlCheckLevel findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return DOMAIN;

        case 1: // '\001'
            return REDIRECT;

        case 2: // '\002'
            return PAGE_CONTENTS;
        }
    }

    public static UrlCheckLevel valueOf(String s)
    {
        return (UrlCheckLevel)Enum.valueOf(com/pinterest/schemas/event/UrlCheckLevel, s);
    }

    public static UrlCheckLevel[] values()
    {
        return (UrlCheckLevel[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        DOMAIN = new UrlCheckLevel("DOMAIN", 0, 0);
        REDIRECT = new UrlCheckLevel("REDIRECT", 1, 1);
        PAGE_CONTENTS = new UrlCheckLevel("PAGE_CONTENTS", 2, 2);
        $VALUES = (new UrlCheckLevel[] {
            DOMAIN, REDIRECT, PAGE_CONTENTS
        });
    }
}
