// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.transport.TMemoryInputTransport;

// Referenced classes of package org.apache.thrift:
//            TFieldIdEnum, TException, TBase

public class TDeserializer
{

    private final TProtocol protocol_;
    private final TMemoryInputTransport trans_;

    public TDeserializer()
    {
        this(((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TDeserializer(TProtocolFactory tprotocolfactory)
    {
        trans_ = new TMemoryInputTransport();
        protocol_ = tprotocolfactory.getProtocol(trans_);
    }

    private transient TField locateField(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        boolean flag = false;
        trans_.reset(abyte0);
        TFieldIdEnum atfieldidenum1[] = new TFieldIdEnum[atfieldidenum.length + 1];
        atfieldidenum1[0] = tfieldidenum;
        for (int i = 0; i < atfieldidenum.length; i++)
        {
            atfieldidenum1[i + 1] = atfieldidenum[i];
        }

        protocol_.readStructBegin();
        abyte0 = null;
        int j = ((flag) ? 1 : 0);
        do
        {
            if (j >= atfieldidenum1.length)
            {
                break;
            }
            tfieldidenum = protocol_.readFieldBegin();
            if (((TField) (tfieldidenum)).type == 0 || ((TField) (tfieldidenum)).id > atfieldidenum1[j].getThriftFieldId())
            {
                return null;
            }
            if (((TField) (tfieldidenum)).id != atfieldidenum1[j].getThriftFieldId())
            {
                TProtocolUtil.skip(protocol_, ((TField) (tfieldidenum)).type);
                protocol_.readFieldEnd();
                abyte0 = tfieldidenum;
            } else
            {
                int k = j + 1;
                abyte0 = tfieldidenum;
                j = k;
                if (k < atfieldidenum1.length)
                {
                    protocol_.readStructBegin();
                    abyte0 = tfieldidenum;
                    j = k;
                }
            }
        } while (true);
        return abyte0;
    }

    private transient Object partialDeserializeField(byte byte0, byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        abyte0 = locateField(abyte0, tfieldidenum, atfieldidenum);
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        byte0;
        JVM INSTR lookupswitch 8: default 88
    //                   2: 104
    //                   3: 141
    //                   4: 178
    //                   6: 215
    //                   8: 253
    //                   10: 289
    //                   11: 327
    //                   100: 360;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        trans_.clear();
        protocol_.reset();
        return null;
_L3:
        if (((TField) (abyte0)).type != 2) goto _L2; else goto _L11
_L11:
        boolean flag = protocol_.readBool();
        trans_.clear();
        protocol_.reset();
        return Boolean.valueOf(flag);
_L4:
        if (((TField) (abyte0)).type != 3) goto _L2; else goto _L12
_L12:
        byte byte1 = protocol_.readByte();
        trans_.clear();
        protocol_.reset();
        return Byte.valueOf(byte1);
_L5:
        if (((TField) (abyte0)).type != 4) goto _L2; else goto _L13
_L13:
        double d = protocol_.readDouble();
        trans_.clear();
        protocol_.reset();
        return Double.valueOf(d);
_L6:
        if (((TField) (abyte0)).type != 6) goto _L2; else goto _L14
_L14:
        short word0 = protocol_.readI16();
        trans_.clear();
        protocol_.reset();
        return Short.valueOf(word0);
_L7:
        if (((TField) (abyte0)).type != 8) goto _L2; else goto _L15
_L15:
        byte0 = protocol_.readI32();
        trans_.clear();
        protocol_.reset();
        return Integer.valueOf(byte0);
_L8:
        if (((TField) (abyte0)).type != 10) goto _L2; else goto _L16
_L16:
        long l = protocol_.readI64();
        trans_.clear();
        protocol_.reset();
        return Long.valueOf(l);
_L9:
        if (((TField) (abyte0)).type != 11) goto _L2; else goto _L17
_L17:
        abyte0 = protocol_.readString();
        trans_.clear();
        protocol_.reset();
        return abyte0;
_L10:
        if (((TField) (abyte0)).type != 11) goto _L2; else goto _L18
_L18:
        abyte0 = protocol_.readBinary();
        trans_.clear();
        protocol_.reset();
        return abyte0;
        abyte0;
        throw new TException(abyte0);
        abyte0;
        trans_.clear();
        protocol_.reset();
        throw abyte0;
    }

    public void deserialize(TBase tbase, String s, String s1)
    {
        deserialize(tbase, s.getBytes(s1));
        protocol_.reset();
        return;
        tbase;
        throw new TException((new StringBuilder("JVM DOES NOT SUPPORT ENCODING: ")).append(s1).toString());
        tbase;
        protocol_.reset();
        throw tbase;
    }

    public void deserialize(TBase tbase, byte abyte0[])
    {
        trans_.reset(abyte0);
        tbase.read(protocol_);
        trans_.clear();
        protocol_.reset();
        return;
        tbase;
        trans_.clear();
        protocol_.reset();
        throw tbase;
    }

    public void fromString(TBase tbase, String s)
    {
        deserialize(tbase, s.getBytes());
    }

    public transient void partialDeserialize(TBase tbase, byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        if (locateField(abyte0, tfieldidenum, atfieldidenum) != null)
        {
            tbase.read(protocol_);
        }
        trans_.clear();
        protocol_.reset();
        return;
        tbase;
        throw new TException(tbase);
        tbase;
        trans_.clear();
        protocol_.reset();
        throw tbase;
    }

    public transient Boolean partialDeserializeBool(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Boolean)partialDeserializeField((byte)2, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Byte partialDeserializeByte(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Byte)partialDeserializeField((byte)3, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient ByteBuffer partialDeserializeByteArray(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (ByteBuffer)partialDeserializeField((byte)100, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Double partialDeserializeDouble(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Double)partialDeserializeField((byte)4, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Short partialDeserializeI16(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Short)partialDeserializeField((byte)6, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Integer partialDeserializeI32(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Integer)partialDeserializeField((byte)8, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Long partialDeserializeI64(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (Long)partialDeserializeField((byte)10, abyte0, tfieldidenum, atfieldidenum);
    }

    public transient Short partialDeserializeSetFieldIdInUnion(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        short word0;
        if (locateField(abyte0, tfieldidenum, atfieldidenum) == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        protocol_.readStructBegin();
        word0 = protocol_.readFieldBegin().id;
        trans_.clear();
        protocol_.reset();
        return Short.valueOf(word0);
        trans_.clear();
        protocol_.reset();
        return null;
        abyte0;
        throw new TException(abyte0);
        abyte0;
        trans_.clear();
        protocol_.reset();
        throw abyte0;
    }

    public transient String partialDeserializeString(byte abyte0[], TFieldIdEnum tfieldidenum, TFieldIdEnum atfieldidenum[])
    {
        return (String)partialDeserializeField((byte)11, abyte0, tfieldidenum, atfieldidenum);
    }
}
