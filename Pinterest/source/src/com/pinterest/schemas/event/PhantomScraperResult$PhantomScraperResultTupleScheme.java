// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.BitSet;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            PhantomScraperResult, PhantomRawResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            phantomscraperresult.baseUrl = tprotocol.readString();
            phantomscraperresult.setBaseUrlIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomscraperresult.amzUrl = tprotocol.readString();
            phantomscraperresult.setAmzUrlIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomscraperresult.rawResult = new PhantomRawResult();
            phantomscraperresult.rawResult.read(tprotocol);
            phantomscraperresult.setRawResultIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomScraperResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomscraperresult.isSetBaseUrl())
        {
            bitset.set(0);
        }
        if (phantomscraperresult.isSetAmzUrl())
        {
            bitset.set(1);
        }
        if (phantomscraperresult.isSetRawResult())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (phantomscraperresult.isSetBaseUrl())
        {
            tprotocol.writeString(phantomscraperresult.baseUrl);
        }
        if (phantomscraperresult.isSetAmzUrl())
        {
            tprotocol.writeString(phantomscraperresult.amzUrl);
        }
        if (phantomscraperresult.isSetRawResult())
        {
            phantomscraperresult.rawResult.write(tprotocol);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomScraperResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
