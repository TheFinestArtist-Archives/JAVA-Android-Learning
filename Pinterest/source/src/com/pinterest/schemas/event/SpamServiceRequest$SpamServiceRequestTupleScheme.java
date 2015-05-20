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
//            RequestInfo, SpamServiceRequest, LimitResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            spamservicerequest.request = new RequestInfo();
            spamservicerequest.request.read(tprotocol);
            spamservicerequest.setRequestIsSet(true);
        }
        if (bitset.get(1))
        {
            spamservicerequest.result = new LimitResult();
            spamservicerequest.result.read(tprotocol);
            spamservicerequest.setResultIsSet(true);
        }
        if (bitset.get(2))
        {
            spamservicerequest.host = tprotocol.readString();
            spamservicerequest.setHostIsSet(true);
        }
        if (bitset.get(3))
        {
            spamservicerequest.time = tprotocol.readI64();
            spamservicerequest.setTimeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (SpamServiceRequest)tbase);
    }

    public void write(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (spamservicerequest.isSetRequest())
        {
            bitset.set(0);
        }
        if (spamservicerequest.isSetResult())
        {
            bitset.set(1);
        }
        if (spamservicerequest.isSetHost())
        {
            bitset.set(2);
        }
        if (spamservicerequest.isSetTime())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (spamservicerequest.isSetRequest())
        {
            spamservicerequest.request.write(tprotocol);
        }
        if (spamservicerequest.isSetResult())
        {
            spamservicerequest.result.write(tprotocol);
        }
        if (spamservicerequest.isSetHost())
        {
            tprotocol.writeString(spamservicerequest.host);
        }
        if (spamservicerequest.isSetTime())
        {
            tprotocol.writeI64(spamservicerequest.time);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (SpamServiceRequest)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
