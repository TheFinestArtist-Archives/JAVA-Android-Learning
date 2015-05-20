// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.util.BitSet;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TCompactProtocol

public final class TTupleProtocol extends TCompactProtocol
{

    public TTupleProtocol(TTransport ttransport)
    {
        super(ttransport);
    }

    public static BitSet fromByteArray(byte abyte0[])
    {
        BitSet bitset = new BitSet();
        for (int i = 0; i < abyte0.length * 8; i++)
        {
            if ((abyte0[abyte0.length - i / 8 - 1] & 1 << i % 8) > 0)
            {
                bitset.set(i);
            }
        }

        return bitset;
    }

    public static byte[] toByteArray(BitSet bitset, int i)
    {
        byte abyte0[] = new byte[(int)Math.ceil((double)i / 8D)];
        for (i = 0; i < bitset.length(); i++)
        {
            if (bitset.get(i))
            {
                int j = abyte0.length - i / 8 - 1;
                abyte0[j] = (byte)(abyte0[j] | 1 << i % 8);
            }
        }

        return abyte0;
    }

    public final Class getScheme()
    {
        return org/apache/thrift/scheme/TupleScheme;
    }

    public final BitSet readBitSet(int i)
    {
        int j = (int)Math.ceil((double)i / 8D);
        byte abyte0[] = new byte[j];
        for (i = 0; i < j; i++)
        {
            abyte0[i] = readByte();
        }

        return fromByteArray(abyte0);
    }

    public final void writeBitSet(BitSet bitset, int i)
    {
        bitset = toByteArray(bitset, i);
        int j = bitset.length;
        for (i = 0; i < j; i++)
        {
            writeByte(bitset[i]);
        }

    }
}
