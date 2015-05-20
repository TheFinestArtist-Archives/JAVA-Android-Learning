// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


public final class value extends Enum
{

    private static final MAX $VALUES[];
    public static final MAX AVG;
    public static final MAX COUNT;
    public static final MAX MAX;
    public static final MAX MIN;
    public static final MAX SUM;
    final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(io/realm/internal/TableOrView$PivotType, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        COUNT = new <init>("COUNT", 0, 0);
        SUM = new <init>("SUM", 1, 1);
        AVG = new <init>("AVG", 2, 2);
        MIN = new <init>("MIN", 3, 3);
        MAX = new <init>("MAX", 4, 4);
        $VALUES = (new .VALUES[] {
            COUNT, SUM, AVG, MIN, MAX
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
