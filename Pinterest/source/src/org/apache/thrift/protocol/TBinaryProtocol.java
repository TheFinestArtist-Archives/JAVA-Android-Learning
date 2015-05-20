// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TField, TList, 
//            TMap, TProtocolException, TMessage, TSet

public class TBinaryProtocol extends TProtocol
{

    private static final TStruct ANONYMOUS_STRUCT = new TStruct();
    protected static final int VERSION_1 = 0x80010000;
    protected static final int VERSION_MASK = 0xffff0000;
    private byte bin[];
    private byte bout[];
    private byte i16out[];
    private byte i16rd[];
    private byte i32out[];
    private byte i32rd[];
    private byte i64out[];
    private byte i64rd[];
    protected boolean strictRead_;
    protected boolean strictWrite_;

    public TBinaryProtocol(TTransport ttransport)
    {
        this(ttransport, false, true);
    }

    public TBinaryProtocol(TTransport ttransport, boolean flag, boolean flag1)
    {
        super(ttransport);
        strictRead_ = false;
        strictWrite_ = true;
        bout = new byte[1];
        i16out = new byte[2];
        i32out = new byte[4];
        i64out = new byte[8];
        bin = new byte[1];
        i16rd = new byte[2];
        i32rd = new byte[4];
        i64rd = new byte[8];
        strictRead_ = flag;
        strictWrite_ = flag1;
    }

    private int readAll(byte abyte0[], int i, int j)
    {
        return trans_.readAll(abyte0, i, j);
    }

    public ByteBuffer readBinary()
    {
        int i = readI32();
        if (trans_.getBytesRemainingInBuffer() >= i)
        {
            ByteBuffer bytebuffer = ByteBuffer.wrap(trans_.getBuffer(), trans_.getBufferPosition(), i);
            trans_.consumeBuffer(i);
            return bytebuffer;
        } else
        {
            byte abyte0[] = new byte[i];
            trans_.readAll(abyte0, 0, i);
            return ByteBuffer.wrap(abyte0);
        }
    }

    public boolean readBool()
    {
        return readByte() == 1;
    }

    public byte readByte()
    {
        if (trans_.getBytesRemainingInBuffer() > 0)
        {
            byte byte0 = trans_.getBuffer()[trans_.getBufferPosition()];
            trans_.consumeBuffer(1);
            return byte0;
        } else
        {
            readAll(bin, 0, 1);
            return bin[0];
        }
    }

    public double readDouble()
    {
        return Double.longBitsToDouble(readI64());
    }

    public TField readFieldBegin()
    {
        byte byte0 = readByte();
        short word0;
        if (byte0 == 0)
        {
            word0 = 0;
        } else
        {
            word0 = readI16();
        }
        return new TField("", byte0, word0);
    }

    public void readFieldEnd()
    {
    }

    public short readI16()
    {
        int i = 0;
        byte abyte0[] = i16rd;
        byte byte0;
        if (trans_.getBytesRemainingInBuffer() >= 2)
        {
            abyte0 = trans_.getBuffer();
            i = trans_.getBufferPosition();
            trans_.consumeBuffer(2);
        } else
        {
            readAll(i16rd, 0, 2);
        }
        byte0 = abyte0[i];
        return (short)(abyte0[i + 1] & 0xff | (byte0 & 0xff) << 8);
    }

    public int readI32()
    {
        int i = 0;
        byte abyte0[] = i32rd;
        byte byte0;
        byte byte1;
        byte byte2;
        if (trans_.getBytesRemainingInBuffer() >= 4)
        {
            abyte0 = trans_.getBuffer();
            i = trans_.getBufferPosition();
            trans_.consumeBuffer(4);
        } else
        {
            readAll(i32rd, 0, 4);
        }
        byte0 = abyte0[i];
        byte1 = abyte0[i + 1];
        byte2 = abyte0[i + 2];
        return abyte0[i + 3] & 0xff | ((byte0 & 0xff) << 24 | (byte1 & 0xff) << 16 | (byte2 & 0xff) << 8);
    }

    public long readI64()
    {
        int i = 0;
        byte abyte0[] = i64rd;
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        if (trans_.getBytesRemainingInBuffer() >= 8)
        {
            abyte0 = trans_.getBuffer();
            i = trans_.getBufferPosition();
            trans_.consumeBuffer(8);
        } else
        {
            readAll(i64rd, 0, 8);
        }
        l = abyte0[i] & 0xff;
        l1 = abyte0[i + 1] & 0xff;
        l2 = abyte0[i + 2] & 0xff;
        l3 = abyte0[i + 3] & 0xff;
        l4 = abyte0[i + 4] & 0xff;
        l5 = abyte0[i + 5] & 0xff;
        l6 = abyte0[i + 6] & 0xff;
        return (long)(abyte0[i + 7] & 0xff) | (l << 56 | l1 << 48 | l2 << 40 | l3 << 32 | l4 << 24 | l5 << 16 | l6 << 8);
    }

    public TList readListBegin()
    {
        return new TList(readByte(), readI32());
    }

    public void readListEnd()
    {
    }

    public TMap readMapBegin()
    {
        return new TMap(readByte(), readByte(), readI32());
    }

    public void readMapEnd()
    {
    }

    public TMessage readMessageBegin()
    {
        int i = readI32();
        if (i < 0)
        {
            if ((0xffff0000 & i) != 0x80010000)
            {
                throw new TProtocolException(4, "Bad version in readMessageBegin");
            } else
            {
                return new TMessage(readString(), (byte)(i & 0xff), readI32());
            }
        }
        if (strictRead_)
        {
            throw new TProtocolException(4, "Missing version in readMessageBegin, old client?");
        } else
        {
            return new TMessage(readStringBody(i), readByte(), readI32());
        }
    }

    public void readMessageEnd()
    {
    }

    public TSet readSetBegin()
    {
        return new TSet(readByte(), readI32());
    }

    public void readSetEnd()
    {
    }

    public String readString()
    {
        int i = readI32();
        if (trans_.getBytesRemainingInBuffer() >= i)
        {
            String s;
            try
            {
                s = new String(trans_.getBuffer(), trans_.getBufferPosition(), i, "UTF-8");
                trans_.consumeBuffer(i);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new TException("JVM DOES NOT SUPPORT UTF-8");
            }
            return s;
        } else
        {
            return readStringBody(i);
        }
    }

    public String readStringBody(int i)
    {
        String s;
        try
        {
            byte abyte0[] = new byte[i];
            trans_.readAll(abyte0, 0, i);
            s = new String(abyte0, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return s;
    }

    public TStruct readStructBegin()
    {
        return ANONYMOUS_STRUCT;
    }

    public void readStructEnd()
    {
    }

    public void writeBinary(ByteBuffer bytebuffer)
    {
        int i = bytebuffer.limit() - bytebuffer.position();
        writeI32(i);
        trans_.write(bytebuffer.array(), bytebuffer.position() + bytebuffer.arrayOffset(), i);
    }

    public void writeBool(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        writeByte(byte0);
    }

    public void writeByte(byte byte0)
    {
        bout[0] = byte0;
        trans_.write(bout, 0, 1);
    }

    public void writeDouble(double d)
    {
        writeI64(Double.doubleToLongBits(d));
    }

    public void writeFieldBegin(TField tfield)
    {
        writeByte(tfield.type);
        writeI16(tfield.id);
    }

    public void writeFieldEnd()
    {
    }

    public void writeFieldStop()
    {
        writeByte((byte)0);
    }

    public void writeI16(short word0)
    {
        i16out[0] = (byte)(word0 >> 8 & 0xff);
        i16out[1] = (byte)(word0 & 0xff);
        trans_.write(i16out, 0, 2);
    }

    public void writeI32(int i)
    {
        i32out[0] = (byte)(i >> 24 & 0xff);
        i32out[1] = (byte)(i >> 16 & 0xff);
        i32out[2] = (byte)(i >> 8 & 0xff);
        i32out[3] = (byte)(i & 0xff);
        trans_.write(i32out, 0, 4);
    }

    public void writeI64(long l)
    {
        i64out[0] = (byte)(int)(l >> 56 & 255L);
        i64out[1] = (byte)(int)(l >> 48 & 255L);
        i64out[2] = (byte)(int)(l >> 40 & 255L);
        i64out[3] = (byte)(int)(l >> 32 & 255L);
        i64out[4] = (byte)(int)(l >> 24 & 255L);
        i64out[5] = (byte)(int)(l >> 16 & 255L);
        i64out[6] = (byte)(int)(l >> 8 & 255L);
        i64out[7] = (byte)(int)(255L & l);
        trans_.write(i64out, 0, 8);
    }

    public void writeListBegin(TList tlist)
    {
        writeByte(tlist.elemType);
        writeI32(tlist.size);
    }

    public void writeListEnd()
    {
    }

    public void writeMapBegin(TMap tmap)
    {
        writeByte(tmap.keyType);
        writeByte(tmap.valueType);
        writeI32(tmap.size);
    }

    public void writeMapEnd()
    {
    }

    public void writeMessageBegin(TMessage tmessage)
    {
        if (strictWrite_)
        {
            writeI32(0x80010000 | tmessage.type);
            writeString(tmessage.name);
            writeI32(tmessage.seqid);
            return;
        } else
        {
            writeString(tmessage.name);
            writeByte(tmessage.type);
            writeI32(tmessage.seqid);
            return;
        }
    }

    public void writeMessageEnd()
    {
    }

    public void writeSetBegin(TSet tset)
    {
        writeByte(tset.elemType);
        writeI32(tset.size);
    }

    public void writeSetEnd()
    {
    }

    public void writeString(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
            writeI32(s.length);
            trans_.write(s, 0, s.length);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void writeStructBegin(TStruct tstruct)
    {
    }

    public void writeStructEnd()
    {
    }

}
