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
//            PhantomRedirectHeaders

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            phantomredirectheaders.name = tprotocol.readString();
            phantomredirectheaders.setNameIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomredirectheaders.value = tprotocol.readString();
            phantomredirectheaders.setValueIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRedirectHeaders)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomredirectheaders.isSetName())
        {
            bitset.set(0);
        }
        if (phantomredirectheaders.isSetValue())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (phantomredirectheaders.isSetName())
        {
            tprotocol.writeString(phantomredirectheaders.name);
        }
        if (phantomredirectheaders.isSetValue())
        {
            tprotocol.writeString(phantomredirectheaders.value);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRedirectHeaders)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
