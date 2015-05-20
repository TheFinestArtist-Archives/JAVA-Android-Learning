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
//            InterestImpressionData, InterestImpression

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            interestimpressiondata.interestImpressions = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                InterestImpression interestimpression = new InterestImpression();
                interestimpression.read(tprotocol);
                interestimpressiondata.interestImpressions.add(interestimpression);
            }

            interestimpressiondata.setInterestImpressionsIsSet(true);
        }
        if (bitset.get(1))
        {
            interestimpressiondata.orderType = tprotocol.readString();
            interestimpressiondata.setOrderTypeIsSet(true);
        }
        if (bitset.get(2))
        {
            interestimpressiondata.blendType = tprotocol.readString();
            interestimpressiondata.setBlendTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InterestImpressionData)tbase);
    }

    public void write(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (interestimpressiondata.isSetInterestImpressions())
        {
            bitset.set(0);
        }
        if (interestimpressiondata.isSetOrderType())
        {
            bitset.set(1);
        }
        if (interestimpressiondata.isSetBlendType())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (interestimpressiondata.isSetInterestImpressions())
        {
            tprotocol.writeI32(interestimpressiondata.interestImpressions.size());
            for (Iterator iterator = interestimpressiondata.interestImpressions.iterator(); iterator.hasNext(); ((InterestImpression)iterator.next()).write(tprotocol)) { }
        }
        if (interestimpressiondata.isSetOrderType())
        {
            tprotocol.writeString(interestimpressiondata.orderType);
        }
        if (interestimpressiondata.isSetBlendType())
        {
            tprotocol.writeString(interestimpressiondata.blendType);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InterestImpressionData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
