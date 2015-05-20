// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.BitSet;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            TestData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, TestData testdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        if (tprotocol.readBitSet(1).get(0))
        {
            testdata.key = tprotocol.readString();
            testdata.setKeyIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TestData)tbase);
    }

    public void write(TProtocol tprotocol, TestData testdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (testdata.isSetKey())
        {
            bitset.set(0);
        }
        tprotocol.writeBitSet(bitset, 1);
        if (testdata.isSetKey())
        {
            tprotocol.writeString(testdata.key);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TestData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
