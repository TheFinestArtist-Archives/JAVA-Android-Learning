// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            EventBatch, Event

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, EventBatch eventbatch)
    {
        tprotocol.readStructBegin();
_L2:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        switch (((TField) (obj)).id)
        {
        default:
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_159;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            eventbatch.events = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                Event event = new Event();
                event.read(tprotocol);
                eventbatch.events.add(event);
            }

            tprotocol.readListEnd();
            eventbatch.setEventsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L3
        if (((TField) (obj)).type == 10)
        {
            eventbatch.reportTime = tprotocol.readI64();
            eventbatch.setReportTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L3
        tprotocol.readStructEnd();
        eventbatch.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (EventBatch)tbase);
    }

    public void write(TProtocol tprotocol, EventBatch eventbatch)
    {
        eventbatch.validate();
        tprotocol.writeStructBegin(EventBatch.access$300());
        if (eventbatch.events != null)
        {
            tprotocol.writeFieldBegin(EventBatch.access$400());
            tprotocol.writeListBegin(new TList((byte)12, eventbatch.events.size()));
            for (Iterator iterator = eventbatch.events.iterator(); iterator.hasNext(); ((Event)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(EventBatch.access$500());
        tprotocol.writeI64(eventbatch.reportTime);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
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
