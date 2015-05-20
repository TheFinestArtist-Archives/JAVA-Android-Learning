// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationEvent, RecommendationTriggerEvent, TypedRecommendationList

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, RecommendationEvent recommendationevent)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            recommendationevent.recommendationEventId = tprotocol.readString();
            recommendationevent.setRecommendationEventIdIsSet(true);
        }
        if (bitset.get(1))
        {
            recommendationevent.triggerEvent = new RecommendationTriggerEvent();
            recommendationevent.triggerEvent.read(tprotocol);
            recommendationevent.setTriggerEventIsSet(true);
        }
        if (bitset.get(2))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            recommendationevent.recommendations = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                TypedRecommendationList typedrecommendationlist = new TypedRecommendationList();
                typedrecommendationlist.read(tprotocol);
                recommendationevent.recommendations.add(typedrecommendationlist);
            }

            recommendationevent.setRecommendationsIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationEvent)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationEvent recommendationevent)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (recommendationevent.isSetRecommendationEventId())
        {
            bitset.set(0);
        }
        if (recommendationevent.isSetTriggerEvent())
        {
            bitset.set(1);
        }
        if (recommendationevent.isSetRecommendations())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (recommendationevent.isSetRecommendationEventId())
        {
            tprotocol.writeString(recommendationevent.recommendationEventId);
        }
        if (recommendationevent.isSetTriggerEvent())
        {
            recommendationevent.triggerEvent.write(tprotocol);
        }
        if (recommendationevent.isSetRecommendations())
        {
            tprotocol.writeI32(recommendationevent.recommendations.size());
            for (recommendationevent = recommendationevent.recommendations.iterator(); recommendationevent.hasNext(); ((TypedRecommendationList)recommendationevent.next()).write(tprotocol)) { }
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationEvent)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
