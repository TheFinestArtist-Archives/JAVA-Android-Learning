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
//            ViewType, Context, ViewParameterType, ViewData, 
//            ComponentType, ComponentData, ElementType, ElementData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, Context context)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(7);
        if (bitset.get(0))
        {
            context.viewType = ViewType.findByValue(tprotocol.readI32());
            context.setViewTypeIsSet(true);
        }
        if (bitset.get(1))
        {
            context.viewParameter = ViewParameterType.findByValue(tprotocol.readI32());
            context.setViewParameterIsSet(true);
        }
        if (bitset.get(2))
        {
            context.viewData = new ViewData();
            context.viewData.read(tprotocol);
            context.setViewDataIsSet(true);
        }
        if (bitset.get(3))
        {
            context.component = ComponentType.findByValue(tprotocol.readI32());
            context.setComponentIsSet(true);
        }
        if (bitset.get(4))
        {
            context.componentData = new ComponentData();
            context.componentData.read(tprotocol);
            context.setComponentDataIsSet(true);
        }
        if (bitset.get(5))
        {
            context.element = ElementType.findByValue(tprotocol.readI32());
            context.setElementIsSet(true);
        }
        if (bitset.get(6))
        {
            context.elementData = new ElementData();
            context.elementData.read(tprotocol);
            context.setElementDataIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (Context)tbase);
    }

    public void write(TProtocol tprotocol, Context context)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (context.isSetViewType())
        {
            bitset.set(0);
        }
        if (context.isSetViewParameter())
        {
            bitset.set(1);
        }
        if (context.isSetViewData())
        {
            bitset.set(2);
        }
        if (context.isSetComponent())
        {
            bitset.set(3);
        }
        if (context.isSetComponentData())
        {
            bitset.set(4);
        }
        if (context.isSetElement())
        {
            bitset.set(5);
        }
        if (context.isSetElementData())
        {
            bitset.set(6);
        }
        tprotocol.writeBitSet(bitset, 7);
        if (context.isSetViewType())
        {
            tprotocol.writeI32(context.viewType.getValue());
        }
        if (context.isSetViewParameter())
        {
            tprotocol.writeI32(context.viewParameter.getValue());
        }
        if (context.isSetViewData())
        {
            context.viewData.write(tprotocol);
        }
        if (context.isSetComponent())
        {
            tprotocol.writeI32(context.component.getValue());
        }
        if (context.isSetComponentData())
        {
            context.componentData.write(tprotocol);
        }
        if (context.isSetElement())
        {
            tprotocol.writeI32(context.element.getValue());
        }
        if (context.isSetElementData())
        {
            context.elementData.write(tprotocol);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (Context)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
