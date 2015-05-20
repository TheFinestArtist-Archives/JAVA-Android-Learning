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
//            PhantomServiceResult, PhantomScraperResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            phantomserviceresult.phantomResult = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                PhantomScraperResult phantomscraperresult = new PhantomScraperResult();
                phantomscraperresult.read(tprotocol);
                phantomserviceresult.phantomResult.add(phantomscraperresult);
            }

            phantomserviceresult.setPhantomResultIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomserviceresult.host = tprotocol.readString();
            phantomserviceresult.setHostIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomserviceresult.time = tprotocol.readI64();
            phantomserviceresult.setTimeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomServiceResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomserviceresult.isSetPhantomResult())
        {
            bitset.set(0);
        }
        if (phantomserviceresult.isSetHost())
        {
            bitset.set(1);
        }
        if (phantomserviceresult.isSetTime())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (phantomserviceresult.isSetPhantomResult())
        {
            tprotocol.writeI32(phantomserviceresult.phantomResult.size());
            for (Iterator iterator = phantomserviceresult.phantomResult.iterator(); iterator.hasNext(); ((PhantomScraperResult)iterator.next()).write(tprotocol)) { }
        }
        if (phantomserviceresult.isSetHost())
        {
            tprotocol.writeString(phantomserviceresult.host);
        }
        if (phantomserviceresult.isSetTime())
        {
            tprotocol.writeI64(phantomserviceresult.time);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomServiceResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
