// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


public final class TList
{

    public final byte elemType;
    public final int size;

    public TList()
    {
        this((byte)0, 0);
    }

    public TList(byte byte0, int i)
    {
        elemType = byte0;
        size = i;
    }
}
