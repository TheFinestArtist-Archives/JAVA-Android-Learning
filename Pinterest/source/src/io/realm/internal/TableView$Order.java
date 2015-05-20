// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


public final class  extends Enum
{

    private static final descending $VALUES[];
    public static final descending ascending;
    public static final descending descending;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/realm/internal/TableView$Order, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ascending = new <init>("ascending", 0);
        descending = new <init>("descending", 1);
        $VALUES = (new .VALUES[] {
            ascending, descending
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
