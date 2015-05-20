// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import java.util.List;

// Referenced classes of package de.greenrobot.dao:
//            WhereCondition

public abstract class values
    implements WhereCondition
{

    protected final boolean hasSingleValue;
    protected final Object value;
    protected final Object values[];

    public void appendValuesTo(List list)
    {
        if (hasSingleValue)
        {
            list.add(value);
        }
        if (values == null) goto _L2; else goto _L1
_L1:
        Object aobj[];
        int i;
        int j;
        aobj = values;
        j = aobj.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        list.add(aobj[i]);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public ()
    {
        hasSingleValue = false;
        value = null;
        values = null;
    }

    public values(Object obj)
    {
        value = obj;
        hasSingleValue = true;
        values = null;
    }

    public values(Object aobj[])
    {
        value = null;
        hasSingleValue = false;
        values = aobj;
    }
}
