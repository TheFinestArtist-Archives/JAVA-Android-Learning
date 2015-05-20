// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


public final class TMap
{

    public final byte keyType;
    public final int size;
    public final byte valueType;

    public TMap()
    {
        this((byte)0, (byte)0, 0);
    }

    public TMap(byte byte0, byte byte1, int i)
    {
        keyType = byte0;
        valueType = byte1;
        size = i;
    }
}
