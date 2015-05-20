// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


public final class _cls9 extends Enum
{

    private static final CLIENT $VALUES[];
    public static final CLIENT CLIENT;
    public static final CLIENT SERVER;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(org/apache/thrift/transport/TSaslTransport$SaslRole, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        SERVER = new <init>("SERVER", 0);
        CLIENT = new <init>("CLIENT", 1);
        $VALUES = (new .VALUES[] {
            SERVER, CLIENT
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
