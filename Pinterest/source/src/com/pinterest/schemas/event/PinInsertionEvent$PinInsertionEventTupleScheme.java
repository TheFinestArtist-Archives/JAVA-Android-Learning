// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            PinInsertionEvent, PinInsertion, PinViewType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        pininsertionevent.timestamp = tprotocol.readI64();
        pininsertionevent.setTimestampIsSet(true);
        pininsertionevent.requestId = tprotocol.readBinary();
        pininsertionevent.setRequestIdIsSet(true);
        Object obj = new TList((byte)12, tprotocol.readI32());
        pininsertionevent.insertions = new ArrayList(((TList) (obj)).size);
        for (int i = 0; i < ((TList) (obj)).size; i++)
        {
            PinInsertion pininsertion = new PinInsertion();
            pininsertion.read(tprotocol);
            pininsertionevent.insertions.add(pininsertion);
        }

        pininsertionevent.setInsertionsIsSet(true);
        obj = tprotocol.readBitSet(3);
        if (((BitSet) (obj)).get(0))
        {
            pininsertionevent.userId = tprotocol.readI64();
            pininsertionevent.setUserIdIsSet(true);
        }
        if (((BitSet) (obj)).get(1))
        {
            pininsertionevent.viewType = PinViewType.findByValue(tprotocol.readI32());
            pininsertionevent.setViewTypeIsSet(true);
        }
        if (((BitSet) (obj)).get(2))
        {
            pininsertionevent.term = tprotocol.readString();
            pininsertionevent.setTermIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinInsertionEvent)tbase);
    }

    public void write(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        tprotocol.writeI64(pininsertionevent.timestamp);
        tprotocol.writeBinary(pininsertionevent.requestId);
        tprotocol.writeI32(pininsertionevent.insertions.size());
        for (Iterator iterator = pininsertionevent.insertions.iterator(); iterator.hasNext(); ((PinInsertion)iterator.next()).write(tprotocol)) { }
        BitSet bitset = new BitSet();
        if (pininsertionevent.isSetUserId())
        {
            bitset.set(0);
        }
        if (pininsertionevent.isSetViewType())
        {
            bitset.set(1);
        }
        if (pininsertionevent.isSetTerm())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (pininsertionevent.isSetUserId())
        {
            tprotocol.writeI64(pininsertionevent.userId);
        }
        if (pininsertionevent.isSetViewType())
        {
            tprotocol.writeI32(pininsertionevent.viewType.getValue());
        }
        if (pininsertionevent.isSetTerm())
        {
            tprotocol.writeString(pininsertionevent.term);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PinInsertionEvent)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
