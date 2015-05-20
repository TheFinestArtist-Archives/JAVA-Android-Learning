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
//            PinInsertion

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PinInsertion pininsertion)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        pininsertion.pinId = tprotocol.readI64();
        pininsertion.setPinIdIsSet(true);
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            pininsertion.adsInsertionId = tprotocol.readBinary();
            pininsertion.setAdsInsertionIdIsSet(true);
        }
        if (bitset.get(1))
        {
            pininsertion.slot = tprotocol.readI16();
            pininsertion.setSlotIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinInsertion)tbase);
    }

    public void write(TProtocol tprotocol, PinInsertion pininsertion)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        tprotocol.writeI64(pininsertion.pinId);
        BitSet bitset = new BitSet();
        if (pininsertion.isSetAdsInsertionId())
        {
            bitset.set(0);
        }
        if (pininsertion.isSetSlot())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (pininsertion.isSetAdsInsertionId())
        {
            tprotocol.writeBinary(pininsertion.adsInsertionId);
        }
        if (pininsertion.isSetSlot())
        {
            tprotocol.writeI16(pininsertion.slot);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PinInsertion)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
