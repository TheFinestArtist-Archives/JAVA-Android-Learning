// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;


public class EncodingUtils
{

    public EncodingUtils()
    {
    }

    public static final byte clearBit(byte byte0, int i)
    {
        return (byte)clearBit(byte0, i);
    }

    public static final int clearBit(int i, int j)
    {
        return ~(1 << j) & i;
    }

    public static final long clearBit(long l, int i)
    {
        return ~(1L << i) & l;
    }

    public static final short clearBit(short word0, int i)
    {
        return (short)clearBit(word0, i);
    }

    public static final int decodeBigEndian(byte abyte0[])
    {
        return decodeBigEndian(abyte0, 0);
    }

    public static final int decodeBigEndian(byte abyte0[], int i)
    {
        return (abyte0[i] & 0xff) << 24 | (abyte0[i + 1] & 0xff) << 16 | (abyte0[i + 2] & 0xff) << 8 | abyte0[i + 3] & 0xff;
    }

    public static final void encodeBigEndian(int i, byte abyte0[])
    {
        encodeBigEndian(i, abyte0, 0);
    }

    public static final void encodeBigEndian(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)(i >> 24 & 0xff);
        abyte0[j + 1] = (byte)(i >> 16 & 0xff);
        abyte0[j + 2] = (byte)(i >> 8 & 0xff);
        abyte0[j + 3] = (byte)(i & 0xff);
    }

    public static final byte setBit(byte byte0, int i, boolean flag)
    {
        return (byte)setBit(byte0, i, flag);
    }

    public static final int setBit(int i, int j, boolean flag)
    {
        if (flag)
        {
            return 1 << j | i;
        } else
        {
            return clearBit(i, j);
        }
    }

    public static final long setBit(long l, int i, boolean flag)
    {
        if (flag)
        {
            return 1L << i | l;
        } else
        {
            return clearBit(l, i);
        }
    }

    public static final short setBit(short word0, int i, boolean flag)
    {
        return (short)setBit(word0, i, flag);
    }

    public static final boolean testBit(byte byte0, int i)
    {
        return testBit(byte0, i);
    }

    public static final boolean testBit(int i, int j)
    {
        return (1 << j & i) != 0;
    }

    public static final boolean testBit(long l, int i)
    {
        return (1L << i & l) != 0L;
    }

    public static final boolean testBit(short word0, int i)
    {
        return testBit(word0, i);
    }
}
