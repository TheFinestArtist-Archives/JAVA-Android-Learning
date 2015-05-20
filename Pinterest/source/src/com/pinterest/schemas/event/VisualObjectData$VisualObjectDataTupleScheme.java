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
//            VisualObjectData, VisualObject

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, VisualObjectData visualobjectdata)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            visualobjectdata.objects = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                VisualObject visualobject = new VisualObject();
                visualobject.read(tprotocol);
                visualobjectdata.objects.add(visualobject);
            }

            visualobjectdata.setObjectsIsSet(true);
        }
        if (bitset.get(1))
        {
            visualobjectdata.simlistVersion = tprotocol.readString();
            visualobjectdata.setSimlistVersionIsSet(true);
        }
        if (bitset.get(2))
        {
            visualobjectdata.selectedObjectIndex = tprotocol.readI16();
            visualobjectdata.setSelectedObjectIndexIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (VisualObjectData)tbase);
    }

    public void write(TProtocol tprotocol, VisualObjectData visualobjectdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (visualobjectdata.isSetObjects())
        {
            bitset.set(0);
        }
        if (visualobjectdata.isSetSimlistVersion())
        {
            bitset.set(1);
        }
        if (visualobjectdata.isSetSelectedObjectIndex())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (visualobjectdata.isSetObjects())
        {
            tprotocol.writeI32(visualobjectdata.objects.size());
            for (Iterator iterator = visualobjectdata.objects.iterator(); iterator.hasNext(); ((VisualObject)iterator.next()).write(tprotocol)) { }
        }
        if (visualobjectdata.isSetSimlistVersion())
        {
            tprotocol.writeString(visualobjectdata.simlistVersion);
        }
        if (visualobjectdata.isSetSelectedObjectIndex())
        {
            tprotocol.writeI16(visualobjectdata.selectedObjectIndex);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (VisualObjectData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
