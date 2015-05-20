// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.nio.ByteBuffer;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TField, TList, TMap, TMessage, 
//            TSet, TStruct

public abstract class TProtocol
{

    protected TTransport trans_;

    private TProtocol()
    {
    }

    protected TProtocol(TTransport ttransport)
    {
        trans_ = ttransport;
    }

    public Class getScheme()
    {
        return org/apache/thrift/scheme/StandardScheme;
    }

    public TTransport getTransport()
    {
        return trans_;
    }

    public abstract ByteBuffer readBinary();

    public abstract boolean readBool();

    public abstract byte readByte();

    public abstract double readDouble();

    public abstract TField readFieldBegin();

    public abstract void readFieldEnd();

    public abstract short readI16();

    public abstract int readI32();

    public abstract long readI64();

    public abstract TList readListBegin();

    public abstract void readListEnd();

    public abstract TMap readMapBegin();

    public abstract void readMapEnd();

    public abstract TMessage readMessageBegin();

    public abstract void readMessageEnd();

    public abstract TSet readSetBegin();

    public abstract void readSetEnd();

    public abstract String readString();

    public abstract TStruct readStructBegin();

    public abstract void readStructEnd();

    public void reset()
    {
    }

    public abstract void writeBinary(ByteBuffer bytebuffer);

    public abstract void writeBool(boolean flag);

    public abstract void writeByte(byte byte0);

    public abstract void writeDouble(double d);

    public abstract void writeFieldBegin(TField tfield);

    public abstract void writeFieldEnd();

    public abstract void writeFieldStop();

    public abstract void writeI16(short word0);

    public abstract void writeI32(int i);

    public abstract void writeI64(long l);

    public abstract void writeListBegin(TList tlist);

    public abstract void writeListEnd();

    public abstract void writeMapBegin(TMap tmap);

    public abstract void writeMapEnd();

    public abstract void writeMessageBegin(TMessage tmessage);

    public abstract void writeMessageEnd();

    public abstract void writeSetBegin(TSet tset);

    public abstract void writeSetEnd();

    public abstract void writeString(String s);

    public abstract void writeStructBegin(TStruct tstruct);

    public abstract void writeStructEnd();
}
