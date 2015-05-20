// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android;


public final class  extends Enum
{

    public static final ERROR DEBUG;
    private static final ERROR ENUM$VALUES[];
    public static final ERROR ERROR;
    public static final ERROR INFO;
    public static final ERROR VERBOSE;
    public static final ERROR WARN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/yozio/android/Constants$LOG_LEVEL, s);
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
        VERBOSE = new <init>("VERBOSE", 0);
        DEBUG = new <init>("DEBUG", 1);
        INFO = new <init>("INFO", 2);
        WARN = new <init>("WARN", 3);
        ERROR = new <init>("ERROR", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            VERBOSE, DEBUG, INFO, WARN, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
