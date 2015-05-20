// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;


public final class  extends Enum
{

    private static final FAST_ACCEPT $VALUES[];
    public static final FAST_ACCEPT FAIR_ACCEPT;
    public static final FAST_ACCEPT FAST_ACCEPT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/apache/thrift/server/TThreadedSelectorServer$Args$AcceptPolicy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FAIR_ACCEPT = new <init>("FAIR_ACCEPT", 0);
        FAST_ACCEPT = new <init>("FAST_ACCEPT", 1);
        $VALUES = (new .VALUES[] {
            FAIR_ACCEPT, FAST_ACCEPT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
