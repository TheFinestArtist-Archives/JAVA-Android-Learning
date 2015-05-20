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
//            RecommendationDetail

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, RecommendationDetail recommendationdetail)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            recommendationdetail.idString = tprotocol.readString();
            recommendationdetail.setIdStringIsSet(true);
        }
        if (bitset.get(1))
        {
            recommendationdetail.algoTag = tprotocol.readString();
            recommendationdetail.setAlgoTagIsSet(true);
        }
        if (bitset.get(2))
        {
            recommendationdetail.source = tprotocol.readString();
            recommendationdetail.setSourceIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationDetail)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationDetail recommendationdetail)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (recommendationdetail.isSetIdString())
        {
            bitset.set(0);
        }
        if (recommendationdetail.isSetAlgoTag())
        {
            bitset.set(1);
        }
        if (recommendationdetail.isSetSource())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (recommendationdetail.isSetIdString())
        {
            tprotocol.writeString(recommendationdetail.idString);
        }
        if (recommendationdetail.isSetAlgoTag())
        {
            tprotocol.writeString(recommendationdetail.algoTag);
        }
        if (recommendationdetail.isSetSource())
        {
            tprotocol.writeString(recommendationdetail.source);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationDetail)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
