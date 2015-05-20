// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.model;

import java.util.List;

public class QueryMetaData
{

    private static final String CONTEXT_SEPARATOR = "|";
    private String _category;
    private List _filters;
    private int _position;
    private String _query;
    private ContextType _type;

    public QueryMetaData()
    {
    }

    public QueryMetaData(String s)
    {
        _query = s;
    }

    public QueryMetaData(String s, ContextType contexttype)
    {
        _query = s;
        _type = contexttype;
    }

    public List getFilters()
    {
        return _filters;
    }

    public int getPosition()
    {
        return _position;
    }

    public String getQuery()
    {
        return _query;
    }

    public ContextType getType()
    {
        return _type;
    }

    public void setCategory(String s)
    {
        _category = s;
    }

    public void setFilters(List list)
    {
        _filters = list;
    }

    public void setPosition(int i)
    {
        _position = i;
    }

    public void setQuery(String s)
    {
        _query = s;
    }

    public void setType(ContextType contexttype)
    {
        _type = contexttype;
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        String s;
        stringbuilder = new StringBuilder();
        s = _query.replace('|', ' ');
        _cls1..SwitchMap.com.pinterest.activity.search.model.QueryMetaData.ContextType[_type.ordinal()];
        JVM INSTR tableswitch 1 6: default 68
    //                   1 73
    //                   2 97
    //                   3 133
    //                   4 169
    //                   5 169
    //                   6 169;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L5
_L1:
        return stringbuilder.toString();
_L2:
        stringbuilder.append(s).append("|").append(_type.getValue());
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append(s).append("|").append(_type.getValue()).append("|").append(_position);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(s).append("|").append(_type.getValue()).append("|word|").append(_position);
        continue; /* Loop/switch isn't completed */
_L5:
        stringbuilder.append(s).append("|").append(_type.getValue()).append("|").append(_category).append("|").append(_position);
        if (true) goto _L1; else goto _L6
_L6:
    }

    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType = new int[ContextType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.TYPED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.RECENT_HISTORY.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.AUTO_COMPLETE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.FILTER.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.MODE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$QueryMetaData$ContextType[ContextType.ACTION_FILTER.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ContextType extends Enum
    {

        private static final ContextType $VALUES[];
        public static final ContextType ACTION_FILTER;
        public static final ContextType AUTO_COMPLETE;
        public static final ContextType EDUCATION;
        public static final ContextType FILTER;
        public static final ContextType MODE;
        public static final ContextType RECENT_HISTORY;
        public static final ContextType TYPED;
        private final String _value;

        public static ContextType valueOf(String s)
        {
            return (ContextType)Enum.valueOf(com/pinterest/activity/search/model/QueryMetaData$ContextType, s);
        }

        public static ContextType[] values()
        {
            return (ContextType[])$VALUES.clone();
        }

        public final String getValue()
        {
            return _value;
        }

        static 
        {
            TYPED = new ContextType("TYPED", 0, "typed");
            RECENT_HISTORY = new ContextType("RECENT_HISTORY", 1, "rs");
            AUTO_COMPLETE = new ContextType("AUTO_COMPLETE", 2, "autocomplete");
            EDUCATION = new ContextType("EDUCATION", 3, "education");
            FILTER = new ContextType("FILTER", 4, "guide");
            MODE = new ContextType("MODE", 5, "mode");
            ACTION_FILTER = new ContextType("ACTION_FILTER", 6, "filter");
            $VALUES = (new ContextType[] {
                TYPED, RECENT_HISTORY, AUTO_COMPLETE, EDUCATION, FILTER, MODE, ACTION_FILTER
            });
        }

        private ContextType(String s, int i, String s1)
        {
            super(s, i);
            _value = s1;
        }
    }

}
