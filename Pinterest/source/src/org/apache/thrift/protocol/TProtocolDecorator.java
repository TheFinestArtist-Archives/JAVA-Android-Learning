// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.nio.ByteBuffer;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TField, TList, TMap, 
//            TMessage, TSet, TStruct

public abstract class TProtocolDecorator extends TProtocol
{

    private final TProtocol concreteProtocol;

    public TProtocolDecorator(TProtocol tprotocol)
    {
        super(tprotocol.getTransport());
        concreteProtocol = tprotocol;
    }

    public ByteBuffer readBinary()
    {
        return concreteProtocol.readBinary();
    }

    public boolean readBool()
    {
        return concreteProtocol.readBool();
    }

    public byte readByte()
    {
        return concreteProtocol.readByte();
    }

    public double readDouble()
    {
        return concreteProtocol.readDouble();
    }

    public TField readFieldBegin()
    {
        return concreteProtocol.readFieldBegin();
    }

    public void readFieldEnd()
    {
        concreteProtocol.readFieldEnd();
    }

    public short readI16()
    {
        return concreteProtocol.readI16();
    }

    public int readI32()
    {
        return concreteProtocol.readI32();
    }

    public long readI64()
    {
        return concreteProtocol.readI64();
    }

    public TList readListBegin()
    {
        return concreteProtocol.readListBegin();
    }

    public void readListEnd()
    {
        concreteProtocol.readListEnd();
    }

    public TMap readMapBegin()
    {
        return concreteProtocol.readMapBegin();
    }

    public void readMapEnd()
    {
        concreteProtocol.readMapEnd();
    }

    public TMessage readMessageBegin()
    {
        return concreteProtocol.readMessageBegin();
    }

    public void readMessageEnd()
    {
        concreteProtocol.readMessageEnd();
    }

    public TSet readSetBegin()
    {
        return concreteProtocol.readSetBegin();
    }

    public void readSetEnd()
    {
        concreteProtocol.readSetEnd();
    }

    public String readString()
    {
        return concreteProtocol.readString();
    }

    public TStruct readStructBegin()
    {
        return concreteProtocol.readStructBegin();
    }

    public void readStructEnd()
    {
        concreteProtocol.readStructEnd();
    }

    public void writeBinary(ByteBuffer bytebuffer)
    {
        concreteProtocol.writeBinary(bytebuffer);
    }

    public void writeBool(boolean flag)
    {
        concreteProtocol.writeBool(flag);
    }

    public void writeByte(byte byte0)
    {
        concreteProtocol.writeByte(byte0);
    }

    public void writeDouble(double d)
    {
        concreteProtocol.writeDouble(d);
    }

    public void writeFieldBegin(TField tfield)
    {
        concreteProtocol.writeFieldBegin(tfield);
    }

    public void writeFieldEnd()
    {
        concreteProtocol.writeFieldEnd();
    }

    public void writeFieldStop()
    {
        concreteProtocol.writeFieldStop();
    }

    public void writeI16(short word0)
    {
        concreteProtocol.writeI16(word0);
    }

    public void writeI32(int i)
    {
        concreteProtocol.writeI32(i);
    }

    public void writeI64(long l)
    {
        concreteProtocol.writeI64(l);
    }

    public void writeListBegin(TList tlist)
    {
        concreteProtocol.writeListBegin(tlist);
    }

    public void writeListEnd()
    {
        concreteProtocol.writeListEnd();
    }

    public void writeMapBegin(TMap tmap)
    {
        concreteProtocol.writeMapBegin(tmap);
    }

    public void writeMapEnd()
    {
        concreteProtocol.writeMapEnd();
    }

    public void writeMessageBegin(TMessage tmessage)
    {
        concreteProtocol.writeMessageBegin(tmessage);
    }

    public void writeMessageEnd()
    {
        concreteProtocol.writeMessageEnd();
    }

    public void writeSetBegin(TSet tset)
    {
        concreteProtocol.writeSetBegin(tset);
    }

    public void writeSetEnd()
    {
        concreteProtocol.writeSetEnd();
    }

    public void writeString(String s)
    {
        concreteProtocol.writeString(s);
    }

    public void writeStructBegin(TStruct tstruct)
    {
        concreteProtocol.writeStructBegin(tstruct);
    }

    public void writeStructEnd()
    {
        concreteProtocol.writeStructEnd();
    }
}
