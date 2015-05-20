// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import java.util.BitSet;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationTriggerType, RecommendationTriggerEvent, RecommendationObjectType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            recommendationtriggerevent.triggerType = RecommendationTriggerType.findByValue(tprotocol.readI32());
            recommendationtriggerevent.setTriggerTypeIsSet(true);
        }
        if (bitset.get(1))
        {
            recommendationtriggerevent.triggerObjectIdStr = tprotocol.readString();
            recommendationtriggerevent.setTriggerObjectIdStrIsSet(true);
        }
        if (bitset.get(2))
        {
            recommendationtriggerevent.triggerObjectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            recommendationtriggerevent.setTriggerObjectTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationTriggerEvent)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (recommendationtriggerevent.isSetTriggerType())
        {
            bitset.set(0);
        }
        if (recommendationtriggerevent.isSetTriggerObjectIdStr())
        {
            bitset.set(1);
        }
        if (recommendationtriggerevent.isSetTriggerObjectType())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (recommendationtriggerevent.isSetTriggerType())
        {
            tprotocol.writeI32(recommendationtriggerevent.triggerType.getValue());
        }
        if (recommendationtriggerevent.isSetTriggerObjectIdStr())
        {
            tprotocol.writeString(recommendationtriggerevent.triggerObjectIdStr);
        }
        if (recommendationtriggerevent.isSetTriggerObjectType())
        {
            tprotocol.writeI32(recommendationtriggerevent.triggerObjectType.getValue());
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationTriggerEvent)tbase);
    }

    private i()
    {
    }

    i(i i)
    {
        this();
    }
}
