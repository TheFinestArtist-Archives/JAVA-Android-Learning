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
//            EventBatch, Event

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, EventBatch eventbatch)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            eventbatch.events = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                Event event = new Event();
                event.read(tprotocol);
                eventbatch.events.add(event);
            }

            eventbatch.setEventsIsSet(true);
        }
        if (bitset.get(1))
        {
            eventbatch.reportTime = tprotocol.readI64();
            eventbatch.setReportTimeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (EventBatch)tbase);
    }

    public void write(TProtocol tprotocol, EventBatch eventbatch)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (eventbatch.isSetEvents())
        {
            bitset.set(0);
        }
        if (eventbatch.isSetReportTime())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (eventbatch.isSetEvents())
        {
            tprotocol.writeI32(eventbatch.events.size());
            for (Iterator iterator = eventbatch.events.iterator(); iterator.hasNext(); ((Event)iterator.next()).write(tprotocol)) { }
        }
        if (eventbatch.isSetReportTime())
        {
            tprotocol.writeI64(eventbatch.reportTime);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (EventBatch)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
