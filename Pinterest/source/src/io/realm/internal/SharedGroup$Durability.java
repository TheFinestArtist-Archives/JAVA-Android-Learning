// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


public final class value extends Enum
{

    private static final MEM_ONLY $VALUES[];
    public static final MEM_ONLY FULL;
    public static final MEM_ONLY MEM_ONLY;
    final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(io/realm/internal/SharedGroup$Durability, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        FULL = new <init>("FULL", 0, 0);
        MEM_ONLY = new <init>("MEM_ONLY", 1, 1);
        $VALUES = (new .VALUES[] {
            FULL, MEM_ONLY
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
