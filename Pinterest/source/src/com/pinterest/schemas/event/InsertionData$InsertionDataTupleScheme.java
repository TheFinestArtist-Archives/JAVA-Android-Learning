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
//            InsertionData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, InsertionData insertiondata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        insertiondata.requestId = tprotocol.readBinary();
        insertiondata.setRequestIdIsSet(true);
        insertiondata.pinId = tprotocol.readI64();
        insertiondata.setPinIdIsSet(true);
        if (tprotocol.readBitSet(1).get(0))
        {
            insertiondata.adsInsertionId = tprotocol.readBinary();
            insertiondata.setAdsInsertionIdIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InsertionData)tbase);
    }

    public void write(TProtocol tprotocol, InsertionData insertiondata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        tprotocol.writeBinary(insertiondata.requestId);
        tprotocol.writeI64(insertiondata.pinId);
        BitSet bitset = new BitSet();
        if (insertiondata.isSetAdsInsertionId())
        {
            bitset.set(0);
        }
        tprotocol.writeBitSet(bitset, 1);
        if (insertiondata.isSetAdsInsertionId())
        {
            tprotocol.writeBinary(insertiondata.adsInsertionId);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InsertionData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
