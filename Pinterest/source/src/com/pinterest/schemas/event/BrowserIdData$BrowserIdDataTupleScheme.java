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
//            BrowserIdData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, BrowserIdData browseriddata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            browseriddata.browserId = tprotocol.readString();
            browseriddata.setBrowserIdIsSet(true);
        }
        if (bitset.get(1))
        {
            browseriddata.encodedBrowserId = tprotocol.readString();
            browseriddata.setEncodedBrowserIdIsSet(true);
        }
        if (bitset.get(2))
        {
            browseriddata.state = tprotocol.readI32();
            browseriddata.setStateIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (BrowserIdData)tbase);
    }

    public void write(TProtocol tprotocol, BrowserIdData browseriddata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (browseriddata.isSetBrowserId())
        {
            bitset.set(0);
        }
        if (browseriddata.isSetEncodedBrowserId())
        {
            bitset.set(1);
        }
        if (browseriddata.isSetState())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (browseriddata.isSetBrowserId())
        {
            tprotocol.writeString(browseriddata.browserId);
        }
        if (browseriddata.isSetEncodedBrowserId())
        {
            tprotocol.writeString(browseriddata.encodedBrowserId);
        }
        if (browseriddata.isSetState())
        {
            tprotocol.writeI32(browseriddata.state);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (BrowserIdData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
