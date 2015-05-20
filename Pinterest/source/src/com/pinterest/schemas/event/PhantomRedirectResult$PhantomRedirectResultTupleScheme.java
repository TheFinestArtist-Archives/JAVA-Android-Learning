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
//            PhantomRedirectResult, PhantomRedirectHeaders

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(7);
        if (bitset.get(0))
        {
            phantomredirectresult.url = tprotocol.readString();
            phantomredirectresult.setUrlIsSet(true);
        }
        if (bitset.get(1))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            phantomredirectresult.headers = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                PhantomRedirectHeaders phantomredirectheaders = new PhantomRedirectHeaders();
                phantomredirectheaders.read(tprotocol);
                phantomredirectresult.headers.add(phantomredirectheaders);
            }

            phantomredirectresult.setHeadersIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomredirectresult.body = tprotocol.readString();
            phantomredirectresult.setBodyIsSet(true);
        }
        if (bitset.get(3))
        {
            phantomredirectresult.requestTime = tprotocol.readString();
            phantomredirectresult.setRequestTimeIsSet(true);
        }
        if (bitset.get(4))
        {
            phantomredirectresult.responseTime = tprotocol.readString();
            phantomredirectresult.setResponseTimeIsSet(true);
        }
        if (bitset.get(5))
        {
            phantomredirectresult.status = tprotocol.readI16();
            phantomredirectresult.setStatusIsSet(true);
        }
        if (bitset.get(6))
        {
            phantomredirectresult.statusText = tprotocol.readString();
            phantomredirectresult.setStatusTextIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRedirectResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomredirectresult.isSetUrl())
        {
            bitset.set(0);
        }
        if (phantomredirectresult.isSetHeaders())
        {
            bitset.set(1);
        }
        if (phantomredirectresult.isSetBody())
        {
            bitset.set(2);
        }
        if (phantomredirectresult.isSetRequestTime())
        {
            bitset.set(3);
        }
        if (phantomredirectresult.isSetResponseTime())
        {
            bitset.set(4);
        }
        if (phantomredirectresult.isSetStatus())
        {
            bitset.set(5);
        }
        if (phantomredirectresult.isSetStatusText())
        {
            bitset.set(6);
        }
        tprotocol.writeBitSet(bitset, 7);
        if (phantomredirectresult.isSetUrl())
        {
            tprotocol.writeString(phantomredirectresult.url);
        }
        if (phantomredirectresult.isSetHeaders())
        {
            tprotocol.writeI32(phantomredirectresult.headers.size());
            for (Iterator iterator = phantomredirectresult.headers.iterator(); iterator.hasNext(); ((PhantomRedirectHeaders)iterator.next()).write(tprotocol)) { }
        }
        if (phantomredirectresult.isSetBody())
        {
            tprotocol.writeString(phantomredirectresult.body);
        }
        if (phantomredirectresult.isSetRequestTime())
        {
            tprotocol.writeString(phantomredirectresult.requestTime);
        }
        if (phantomredirectresult.isSetResponseTime())
        {
            tprotocol.writeString(phantomredirectresult.responseTime);
        }
        if (phantomredirectresult.isSetStatus())
        {
            tprotocol.writeI16(phantomredirectresult.status);
        }
        if (phantomredirectresult.isSetStatusText())
        {
            tprotocol.writeString(phantomredirectresult.statusText);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRedirectResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
