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
//            VisualObject

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, VisualObject visualobject)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(6);
        if (bitset.get(0))
        {
            visualobject.objectType = tprotocol.readString();
            visualobject.setObjectTypeIsSet(true);
        }
        if (bitset.get(1))
        {
            visualobject.objectIndex = tprotocol.readI16();
            visualobject.setObjectIndexIsSet(true);
        }
        if (bitset.get(2))
        {
            visualobject.x = tprotocol.readDouble();
            visualobject.setXIsSet(true);
        }
        if (bitset.get(3))
        {
            visualobject.y = tprotocol.readDouble();
            visualobject.setYIsSet(true);
        }
        if (bitset.get(4))
        {
            visualobject.w = tprotocol.readDouble();
            visualobject.setWIsSet(true);
        }
        if (bitset.get(5))
        {
            visualobject.h = tprotocol.readDouble();
            visualobject.setHIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (VisualObject)tbase);
    }

    public void write(TProtocol tprotocol, VisualObject visualobject)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (visualobject.isSetObjectType())
        {
            bitset.set(0);
        }
        if (visualobject.isSetObjectIndex())
        {
            bitset.set(1);
        }
        if (visualobject.isSetX())
        {
            bitset.set(2);
        }
        if (visualobject.isSetY())
        {
            bitset.set(3);
        }
        if (visualobject.isSetW())
        {
            bitset.set(4);
        }
        if (visualobject.isSetH())
        {
            bitset.set(5);
        }
        tprotocol.writeBitSet(bitset, 6);
        if (visualobject.isSetObjectType())
        {
            tprotocol.writeString(visualobject.objectType);
        }
        if (visualobject.isSetObjectIndex())
        {
            tprotocol.writeI16(visualobject.objectIndex);
        }
        if (visualobject.isSetX())
        {
            tprotocol.writeDouble(visualobject.x);
        }
        if (visualobject.isSetY())
        {
            tprotocol.writeDouble(visualobject.y);
        }
        if (visualobject.isSetW())
        {
            tprotocol.writeDouble(visualobject.w);
        }
        if (visualobject.isSetH())
        {
            tprotocol.writeDouble(visualobject.h);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (VisualObject)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
