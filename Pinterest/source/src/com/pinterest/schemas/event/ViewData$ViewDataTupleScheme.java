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
//            ViewData, VisualObjectData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, ViewData viewdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(7);
        if (bitset.get(0))
        {
            viewdata.stub = tprotocol.readI32();
            viewdata.setStubIsSet(true);
        }
        if (bitset.get(1))
        {
            viewdata.interestName = tprotocol.readString();
            viewdata.setInterestNameIsSet(true);
        }
        if (bitset.get(2))
        {
            viewdata.viewObjectId = tprotocol.readI64();
            viewdata.setViewObjectIdIsSet(true);
        }
        if (bitset.get(3))
        {
            viewdata.objectData = new VisualObjectData();
            viewdata.objectData.read(tprotocol);
            viewdata.setObjectDataIsSet(true);
        }
        if (bitset.get(4))
        {
            viewdata.searchQuery = tprotocol.readString();
            viewdata.setSearchQueryIsSet(true);
        }
        if (bitset.get(5))
        {
            viewdata.analyticsSelectedApplication = tprotocol.readString();
            viewdata.setAnalyticsSelectedApplicationIsSet(true);
        }
        if (bitset.get(6))
        {
            viewdata.viewObjectIdStr = tprotocol.readString();
            viewdata.setViewObjectIdStrIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ViewData)tbase);
    }

    public void write(TProtocol tprotocol, ViewData viewdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (viewdata.isSetStub())
        {
            bitset.set(0);
        }
        if (viewdata.isSetInterestName())
        {
            bitset.set(1);
        }
        if (viewdata.isSetViewObjectId())
        {
            bitset.set(2);
        }
        if (viewdata.isSetObjectData())
        {
            bitset.set(3);
        }
        if (viewdata.isSetSearchQuery())
        {
            bitset.set(4);
        }
        if (viewdata.isSetAnalyticsSelectedApplication())
        {
            bitset.set(5);
        }
        if (viewdata.isSetViewObjectIdStr())
        {
            bitset.set(6);
        }
        tprotocol.writeBitSet(bitset, 7);
        if (viewdata.isSetStub())
        {
            tprotocol.writeI32(viewdata.stub);
        }
        if (viewdata.isSetInterestName())
        {
            tprotocol.writeString(viewdata.interestName);
        }
        if (viewdata.isSetViewObjectId())
        {
            tprotocol.writeI64(viewdata.viewObjectId);
        }
        if (viewdata.isSetObjectData())
        {
            viewdata.objectData.write(tprotocol);
        }
        if (viewdata.isSetSearchQuery())
        {
            tprotocol.writeString(viewdata.searchQuery);
        }
        if (viewdata.isSetAnalyticsSelectedApplication())
        {
            tprotocol.writeString(viewdata.analyticsSelectedApplication);
        }
        if (viewdata.isSetViewObjectIdStr())
        {
            tprotocol.writeString(viewdata.viewObjectIdStr);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ViewData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
