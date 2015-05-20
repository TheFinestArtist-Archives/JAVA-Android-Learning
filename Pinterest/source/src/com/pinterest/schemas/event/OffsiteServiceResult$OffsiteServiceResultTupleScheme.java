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
//            OffsiteServiceResult, UrlCheckResult, UrlCheckLevel

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            offsiteserviceresult.results = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                UrlCheckResult urlcheckresult = new UrlCheckResult();
                urlcheckresult.read(tprotocol);
                offsiteserviceresult.results.add(urlcheckresult);
            }

            offsiteserviceresult.setResultsIsSet(true);
        }
        if (bitset.get(1))
        {
            offsiteserviceresult.host = tprotocol.readString();
            offsiteserviceresult.setHostIsSet(true);
        }
        if (bitset.get(2))
        {
            offsiteserviceresult.time = tprotocol.readI64();
            offsiteserviceresult.setTimeIsSet(true);
        }
        if (bitset.get(3))
        {
            offsiteserviceresult.checkLevel = UrlCheckLevel.findByValue(tprotocol.readI32());
            offsiteserviceresult.setCheckLevelIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (OffsiteServiceResult)tbase);
    }

    public void write(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (offsiteserviceresult.isSetResults())
        {
            bitset.set(0);
        }
        if (offsiteserviceresult.isSetHost())
        {
            bitset.set(1);
        }
        if (offsiteserviceresult.isSetTime())
        {
            bitset.set(2);
        }
        if (offsiteserviceresult.isSetCheckLevel())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (offsiteserviceresult.isSetResults())
        {
            tprotocol.writeI32(offsiteserviceresult.results.size());
            for (Iterator iterator = offsiteserviceresult.results.iterator(); iterator.hasNext(); ((UrlCheckResult)iterator.next()).write(tprotocol)) { }
        }
        if (offsiteserviceresult.isSetHost())
        {
            tprotocol.writeString(offsiteserviceresult.host);
        }
        if (offsiteserviceresult.isSetTime())
        {
            tprotocol.writeI64(offsiteserviceresult.time);
        }
        if (offsiteserviceresult.isSetCheckLevel())
        {
            tprotocol.writeI32(offsiteserviceresult.checkLevel.getValue());
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (OffsiteServiceResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
