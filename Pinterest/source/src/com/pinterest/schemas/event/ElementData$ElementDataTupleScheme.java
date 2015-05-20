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
//            ElementData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, ElementData elementdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            elementdata.stub = tprotocol.readI32();
            elementdata.setStubIsSet(true);
        }
        if (bitset.get(1))
        {
            elementdata.repinButtonGroup = tprotocol.readString();
            elementdata.setRepinButtonGroupIsSet(true);
        }
        if (bitset.get(2))
        {
            elementdata.networkStoryType = tprotocol.readString();
            elementdata.setNetworkStoryTypeIsSet(true);
        }
        if (bitset.get(3))
        {
            elementdata.networkStoryCellType = tprotocol.readString();
            elementdata.setNetworkStoryCellTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ElementData)tbase);
    }

    public void write(TProtocol tprotocol, ElementData elementdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (elementdata.isSetStub())
        {
            bitset.set(0);
        }
        if (elementdata.isSetRepinButtonGroup())
        {
            bitset.set(1);
        }
        if (elementdata.isSetNetworkStoryType())
        {
            bitset.set(2);
        }
        if (elementdata.isSetNetworkStoryCellType())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (elementdata.isSetStub())
        {
            tprotocol.writeI32(elementdata.stub);
        }
        if (elementdata.isSetRepinButtonGroup())
        {
            tprotocol.writeString(elementdata.repinButtonGroup);
        }
        if (elementdata.isSetNetworkStoryType())
        {
            tprotocol.writeString(elementdata.networkStoryType);
        }
        if (elementdata.isSetNetworkStoryCellType())
        {
            tprotocol.writeString(elementdata.networkStoryCellType);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ElementData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
