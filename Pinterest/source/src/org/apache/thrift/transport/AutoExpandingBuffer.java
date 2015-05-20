// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


public class AutoExpandingBuffer
{

    private byte array[];
    private final double growthCoefficient;

    public AutoExpandingBuffer(int i, double d)
    {
        if (d < 1.0D)
        {
            throw new IllegalArgumentException("Growth coefficient must be >= 1.0");
        } else
        {
            array = new byte[i];
            growthCoefficient = d;
            return;
        }
    }

    public byte[] array()
    {
        return array;
    }

    public void resizeIfNecessary(int i)
    {
        if (array.length < i)
        {
            byte abyte0[] = new byte[(int)((double)i * growthCoefficient)];
            System.arraycopy(array, 0, abyte0, 0, array.length);
            array = abyte0;
        }
    }
}
