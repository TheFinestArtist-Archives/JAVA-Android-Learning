// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


// Referenced classes of package org.apache.thrift.protocol:
//            TList

public final class TSet
{

    public final byte elemType;
    public final int size;

    public TSet()
    {
        this((byte)0, 0);
    }

    public TSet(byte byte0, int i)
    {
        elemType = byte0;
        size = i;
    }

    public TSet(TList tlist)
    {
        this(tlist.elemType, tlist.size);
    }
}
