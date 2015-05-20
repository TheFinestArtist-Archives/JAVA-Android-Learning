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
//            PhantomClipRect

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomClipRect phantomcliprect)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            phantomcliprect.top = tprotocol.readI16();
            phantomcliprect.setTopIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomcliprect.left = tprotocol.readI16();
            phantomcliprect.setLeftIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomcliprect.height = tprotocol.readI16();
            phantomcliprect.setHeightIsSet(true);
        }
        if (bitset.get(3))
        {
            phantomcliprect.width = tprotocol.readI16();
            phantomcliprect.setWidthIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomClipRect)tbase);
    }

    public void write(TProtocol tprotocol, PhantomClipRect phantomcliprect)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomcliprect.isSetTop())
        {
            bitset.set(0);
        }
        if (phantomcliprect.isSetLeft())
        {
            bitset.set(1);
        }
        if (phantomcliprect.isSetHeight())
        {
            bitset.set(2);
        }
        if (phantomcliprect.isSetWidth())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (phantomcliprect.isSetTop())
        {
            tprotocol.writeI16(phantomcliprect.top);
        }
        if (phantomcliprect.isSetLeft())
        {
            tprotocol.writeI16(phantomcliprect.left);
        }
        if (phantomcliprect.isSetHeight())
        {
            tprotocol.writeI16(phantomcliprect.height);
        }
        if (phantomcliprect.isSetWidth())
        {
            tprotocol.writeI16(phantomcliprect.width);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomClipRect)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
