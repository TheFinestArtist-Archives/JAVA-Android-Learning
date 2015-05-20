// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.model;


public final class _value extends Enum
{

    private static final ACTION_FILTER $VALUES[];
    public static final ACTION_FILTER ACTION_FILTER;
    public static final ACTION_FILTER AUTO_COMPLETE;
    public static final ACTION_FILTER EDUCATION;
    public static final ACTION_FILTER FILTER;
    public static final ACTION_FILTER MODE;
    public static final ACTION_FILTER RECENT_HISTORY;
    public static final ACTION_FILTER TYPED;
    private final String _value;

    public static _value valueOf(String s)
    {
        return (_value)Enum.valueOf(com/pinterest/activity/search/model/QueryMetaData$ContextType, s);
    }

    public static _value[] values()
    {
        return (_value[])$VALUES.clone();
    }

    public final String getValue()
    {
        return _value;
    }

    static 
    {
        TYPED = new <init>("TYPED", 0, "typed");
        RECENT_HISTORY = new <init>("RECENT_HISTORY", 1, "rs");
        AUTO_COMPLETE = new <init>("AUTO_COMPLETE", 2, "autocomplete");
        EDUCATION = new <init>("EDUCATION", 3, "education");
        FILTER = new <init>("FILTER", 4, "guide");
        MODE = new <init>("MODE", 5, "mode");
        ACTION_FILTER = new <init>("ACTION_FILTER", 6, "filter");
        $VALUES = (new .VALUES[] {
            TYPED, RECENT_HISTORY, AUTO_COMPLETE, EDUCATION, FILTER, MODE, ACTION_FILTER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        _value = s1;
    }
}
