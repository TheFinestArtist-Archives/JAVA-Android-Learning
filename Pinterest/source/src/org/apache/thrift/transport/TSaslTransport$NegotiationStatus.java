// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.util.HashMap;
import java.util.Map;

public final class value extends Enum
{

    private static final getValue $VALUES[];
    public static final getValue BAD;
    public static final getValue COMPLETE;
    public static final getValue ERROR;
    public static final getValue OK;
    public static final getValue START;
    private static final Map reverseMap;
    private final byte value;

    public static value byValue(byte byte0)
    {
        return (value)reverseMap.get(Byte.valueOf(byte0));
    }

    public static reverseMap valueOf(String s)
    {
        return (reverseMap)Enum.valueOf(org/apache/thrift/transport/TSaslTransport$NegotiationStatus, s);
    }

    public static reverseMap[] values()
    {
        return (reverseMap[])$VALUES.clone();
    }

    public final byte getValue()
    {
        return value;
    }

    static 
    {
        int i = 0;
        START = new <init>("START", 0, (byte)1);
        OK = new <init>("OK", 1, (byte)2);
        BAD = new <init>("BAD", 2, (byte)3);
        ERROR = new <init>("ERROR", 3, (byte)4);
        COMPLETE = new <init>("COMPLETE", 4, (byte)5);
        $VALUES = (new .VALUES[] {
            START, OK, BAD, ERROR, COMPLETE
        });
        reverseMap = new HashMap();
        value avalue[] = (reverseMap[])org/apache/thrift/transport/TSaslTransport$NegotiationStatus.getEnumConstants();
        for (int j = avalue.length; i < j; i++)
        {
            value value1 = avalue[i];
            reverseMap.put(Byte.valueOf(value1.getValue()), value1);
        }

    }

    private (String s, int i, byte byte0)
    {
        super(s, i);
        value = byte0;
    }
}
