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
//            ComponentData, ToastType, NagType, EducationType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, ComponentData componentdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(5);
        if (bitset.get(0))
        {
            componentdata.stub = tprotocol.readI32();
            componentdata.setStubIsSet(true);
        }
        if (bitset.get(1))
        {
            componentdata.toastType = ToastType.findByValue(tprotocol.readI32());
            componentdata.setToastTypeIsSet(true);
        }
        if (bitset.get(2))
        {
            componentdata.nagType = NagType.findByValue(tprotocol.readI32());
            componentdata.setNagTypeIsSet(true);
        }
        if (bitset.get(3))
        {
            componentdata.educationType = EducationType.findByValue(tprotocol.readI32());
            componentdata.setEducationTypeIsSet(true);
        }
        if (bitset.get(4))
        {
            componentdata.digestStoryType = tprotocol.readString();
            componentdata.setDigestStoryTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ComponentData)tbase);
    }

    public void write(TProtocol tprotocol, ComponentData componentdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (componentdata.isSetStub())
        {
            bitset.set(0);
        }
        if (componentdata.isSetToastType())
        {
            bitset.set(1);
        }
        if (componentdata.isSetNagType())
        {
            bitset.set(2);
        }
        if (componentdata.isSetEducationType())
        {
            bitset.set(3);
        }
        if (componentdata.isSetDigestStoryType())
        {
            bitset.set(4);
        }
        tprotocol.writeBitSet(bitset, 5);
        if (componentdata.isSetStub())
        {
            tprotocol.writeI32(componentdata.stub);
        }
        if (componentdata.isSetToastType())
        {
            tprotocol.writeI32(componentdata.toastType.getValue());
        }
        if (componentdata.isSetNagType())
        {
            tprotocol.writeI32(componentdata.nagType.getValue());
        }
        if (componentdata.isSetEducationType())
        {
            tprotocol.writeI32(componentdata.educationType.getValue());
        }
        if (componentdata.isSetDigestStoryType())
        {
            tprotocol.writeString(componentdata.digestStoryType);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ComponentData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
