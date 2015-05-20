// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;


public final class value extends Enum
{

    private static final HOME $VALUES[];
    public static final HOME HOME;
    public final int value;

    public static value fromValue(int i)
    {
        value avalue[] = values();
        int k = avalue.length;
        for (int j = 0; j < k; j++)
        {
            value value1 = avalue[j];
            if (value1.value == i)
            {
                return value1;
            }
        }

        return null;
    }

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/pinterest/api/model/Memos$Placement, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        HOME = new <init>("HOME", 0, 4);
        $VALUES = (new .VALUES[] {
            HOME
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
