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
//            RecommendationObject, RecommendationObjectType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, RecommendationObject recommendationobject)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            recommendationobject.objectId = tprotocol.readI64();
            recommendationobject.setObjectIdIsSet(true);
        }
        if (bitset.get(1))
        {
            recommendationobject.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            recommendationobject.setObjectTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationObject)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationObject recommendationobject)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (recommendationobject.isSetObjectId())
        {
            bitset.set(0);
        }
        if (recommendationobject.isSetObjectType())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (recommendationobject.isSetObjectId())
        {
            tprotocol.writeI64(recommendationobject.objectId);
        }
        if (recommendationobject.isSetObjectType())
        {
            tprotocol.writeI32(recommendationobject.objectType.getValue());
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationObject)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
