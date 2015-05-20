// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            TestData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, TestData testdata)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0) goto _L2; else goto _L1
_L1:
        tfield.id;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 55;
           goto _L3 _L4
_L3:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L5:
        tprotocol.readFieldEnd();
        continue; /* Loop/switch isn't completed */
_L4:
        if (tfield.type == 11)
        {
            testdata.key = tprotocol.readString();
            testdata.setKeyIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
        if (true) goto _L5; else goto _L2
_L2:
        tprotocol.readStructEnd();
        testdata.validate();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TestData)tbase);
    }

    public void write(TProtocol tprotocol, TestData testdata)
    {
        testdata.validate();
        tprotocol.writeStructBegin(TestData.access$300());
        if (testdata.key != null)
        {
            tprotocol.writeFieldBegin(TestData.access$400());
            tprotocol.writeString(testdata.key);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TestData)tbase);
    }

    private A()
    {
    }

    A(A a)
    {
        this();
    }
}
