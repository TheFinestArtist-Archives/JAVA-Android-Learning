// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TField, TMap, TSet, 
//            TList, TProtocolFactory

public class TProtocolUtil
{

    private static int maxSkipDepth = 0x7fffffff;

    public TProtocolUtil()
    {
    }

    public static TProtocolFactory guessProtocolFactory(byte abyte0[], TProtocolFactory tprotocolfactory)
    {
        Object obj;
        if (123 == abyte0[0] && 125 == abyte0[abyte0.length - 1])
        {
            obj = new TJSONProtocol.Factory();
        } else
        {
            if (abyte0[abyte0.length - 1] != 0)
            {
                return new TBinaryProtocol.Factory();
            }
            if (abyte0[0] > 16)
            {
                return new TCompactProtocol.Factory();
            }
            if (abyte0.length > 1 && abyte0[1] == 0)
            {
                return new TBinaryProtocol.Factory();
            }
            obj = tprotocolfactory;
            if (abyte0.length > 1)
            {
                obj = tprotocolfactory;
                if ((abyte0[1] & 0x80) != 0)
                {
                    return new TCompactProtocol.Factory();
                }
            }
        }
        return ((TProtocolFactory) (obj));
    }

    public static void setMaxSkipDepth(int i)
    {
        maxSkipDepth = i;
    }

    public static void skip(TProtocol tprotocol, byte byte0)
    {
        skip(tprotocol, byte0, maxSkipDepth);
    }

    public static void skip(TProtocol tprotocol, byte byte0, int i)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        if (i <= 0)
        {
            throw new TException("Maximum skip depth exceeded");
        }
        TList tlist;
        switch (byte0)
        {
        case 5: // '\005'
        case 7: // '\007'
        case 9: // '\t'
        default:
            return;

        case 2: // '\002'
            tprotocol.readBool();
            return;

        case 3: // '\003'
            tprotocol.readByte();
            return;

        case 6: // '\006'
            tprotocol.readI16();
            return;

        case 8: // '\b'
            tprotocol.readI32();
            return;

        case 10: // '\n'
            tprotocol.readI64();
            return;

        case 4: // '\004'
            tprotocol.readDouble();
            return;

        case 11: // '\013'
            tprotocol.readBinary();
            return;

        case 12: // '\f'
            tprotocol.readStructBegin();
            do
            {
                TField tfield = tprotocol.readFieldBegin();
                if (tfield.type != 0)
                {
                    skip(tprotocol, tfield.type, i - 1);
                    tprotocol.readFieldEnd();
                } else
                {
                    tprotocol.readStructEnd();
                    return;
                }
            } while (true);

        case 13: // '\r'
            TMap tmap = tprotocol.readMapBegin();
            for (byte0 = flag; byte0 < tmap.size; byte0++)
            {
                skip(tprotocol, tmap.keyType, i - 1);
                skip(tprotocol, tmap.valueType, i - 1);
            }

            tprotocol.readMapEnd();
            return;

        case 14: // '\016'
            TSet tset = tprotocol.readSetBegin();
            for (byte0 = flag1; byte0 < tset.size; byte0++)
            {
                skip(tprotocol, tset.elemType, i - 1);
            }

            tprotocol.readSetEnd();
            return;

        case 15: // '\017'
            tlist = tprotocol.readListBegin();
            byte0 = flag2;
            break;
        }
        for (; byte0 < tlist.size; byte0++)
        {
            skip(tprotocol, tlist.elemType, i - 1);
        }

        tprotocol.readListEnd();
    }

}
