// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.time;

import org.apache.commons.lang3.StringUtils;

class count
{

    private int count;
    private final Object value;

    static boolean containsTokenWithValue(count acount[], Object obj)
    {
        boolean flag1 = false;
        int j = acount.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (acount[i].getValue() != obj)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof getValue)
        {
            obj = (getValue)obj;
            break MISSING_BLOCK_LABEL_12;
        }
_L1:
        return false;
        if (value.getClass() == ((value) (obj)).value.getClass() && count == ((count) (obj)).count)
        {
            if (value instanceof StringBuffer)
            {
                return value.toString().equals(((value) (obj)).value.toString());
            }
            if (value instanceof Number)
            {
                return value.equals(((value) (obj)).value);
            }
            if (value == ((value) (obj)).value)
            {
                return true;
            }
        }
          goto _L1
    }

    int getCount()
    {
        return count;
    }

    Object getValue()
    {
        return value;
    }

    public int hashCode()
    {
        return value.hashCode();
    }

    void increment()
    {
        count = count + 1;
    }

    public String toString()
    {
        return StringUtils.repeat(value.toString(), count);
    }

    (Object obj)
    {
        value = obj;
        count = 1;
    }

    count(Object obj, int i)
    {
        value = obj;
        count = i;
    }
}
