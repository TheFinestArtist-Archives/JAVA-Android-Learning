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
//            RecommendationObjectType, TypedRecommendationList, RecommendationDetail

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
    {
        boolean flag = false;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            typedrecommendationlist.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            typedrecommendationlist.setObjectTypeIsSet(true);
        }
        if (bitset.get(1))
        {
            TList tlist1 = new TList((byte)11, tprotocol.readI32());
            typedrecommendationlist.recommendations = new ArrayList(tlist1.size);
            for (int i = 0; i < tlist1.size; i++)
            {
                String s = tprotocol.readString();
                typedrecommendationlist.recommendations.add(s);
            }

            typedrecommendationlist.setRecommendationsIsSet(true);
        }
        if (bitset.get(2))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            typedrecommendationlist.recommendationDetails = new ArrayList(tlist.size);
            for (int j = ((flag) ? 1 : 0); j < tlist.size; j++)
            {
                RecommendationDetail recommendationdetail = new RecommendationDetail();
                recommendationdetail.read(tprotocol);
                typedrecommendationlist.recommendationDetails.add(recommendationdetail);
            }

            typedrecommendationlist.setRecommendationDetailsIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TypedRecommendationList)tbase);
    }

    public void write(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (typedrecommendationlist.isSetObjectType())
        {
            bitset.set(0);
        }
        if (typedrecommendationlist.isSetRecommendations())
        {
            bitset.set(1);
        }
        if (typedrecommendationlist.isSetRecommendationDetails())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (typedrecommendationlist.isSetObjectType())
        {
            tprotocol.writeI32(typedrecommendationlist.objectType.getValue());
        }
        if (typedrecommendationlist.isSetRecommendations())
        {
            tprotocol.writeI32(typedrecommendationlist.recommendations.size());
            for (Iterator iterator = typedrecommendationlist.recommendations.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
        }
        if (typedrecommendationlist.isSetRecommendationDetails())
        {
            tprotocol.writeI32(typedrecommendationlist.recommendationDetails.size());
            for (typedrecommendationlist = typedrecommendationlist.recommendationDetails.iterator(); typedrecommendationlist.hasNext(); ((RecommendationDetail)typedrecommendationlist.next()).write(tprotocol)) { }
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TypedRecommendationList)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
