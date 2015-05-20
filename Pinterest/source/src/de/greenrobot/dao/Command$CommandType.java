// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;


public final class  extends Enum
{

    public static final AndSoOn AndSoOn;
    private static final AndSoOn ENUM$VALUES[];
    public static final AndSoOn Insert;
    public static final AndSoOn InsertInTx;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(de/greenrobot/dao/Command$CommandType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        Insert = new <init>("Insert", 0);
        InsertInTx = new <init>("InsertInTx", 1);
        AndSoOn = new <init>("AndSoOn", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Insert, InsertInTx, AndSoOn
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
