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
//            PinImpression, PinImpressionType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PinImpression pinimpression)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(15);
        if (bitset.get(0))
        {
            pinimpression.pinId = tprotocol.readI64();
            pinimpression.setPinIdIsSet(true);
        }
        if (bitset.get(1))
        {
            pinimpression.time = tprotocol.readI64();
            pinimpression.setTimeIsSet(true);
        }
        if (bitset.get(2))
        {
            pinimpression.pinIdStr = tprotocol.readString();
            pinimpression.setPinIdStrIsSet(true);
        }
        if (bitset.get(3))
        {
            pinimpression.insertionId = tprotocol.readString();
            pinimpression.setInsertionIdIsSet(true);
        }
        if (bitset.get(4))
        {
            pinimpression.endTime = tprotocol.readI64();
            pinimpression.setEndTimeIsSet(true);
        }
        if (bitset.get(5))
        {
            pinimpression.yPosition = tprotocol.readI32();
            pinimpression.setYPositionIsSet(true);
        }
        if (bitset.get(6))
        {
            pinimpression.columnIndex = tprotocol.readI16();
            pinimpression.setColumnIndexIsSet(true);
        }
        if (bitset.get(7))
        {
            pinimpression.slotIndex = tprotocol.readI16();
            pinimpression.setSlotIndexIsSet(true);
        }
        if (bitset.get(8))
        {
            pinimpression.requestId = tprotocol.readString();
            pinimpression.setRequestIdIsSet(true);
        }
        if (bitset.get(9))
        {
            pinimpression.type = PinImpressionType.findByValue(tprotocol.readI32());
            pinimpression.setTypeIsSet(true);
        }
        if (bitset.get(10))
        {
            pinimpression.renderDuration = tprotocol.readDouble();
            pinimpression.setRenderDurationIsSet(true);
        }
        if (bitset.get(11))
        {
            pinimpression.imageURL = tprotocol.readString();
            pinimpression.setImageURLIsSet(true);
        }
        if (bitset.get(12))
        {
            pinimpression.imageSignature = tprotocol.readString();
            pinimpression.setImageSignatureIsSet(true);
        }
        if (bitset.get(13))
        {
            pinimpression.cached = tprotocol.readBool();
            pinimpression.setCachedIsSet(true);
        }
        if (bitset.get(14))
        {
            pinimpression.loops = tprotocol.readDouble();
            pinimpression.setLoopsIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinImpression)tbase);
    }

    public void write(TProtocol tprotocol, PinImpression pinimpression)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (pinimpression.isSetPinId())
        {
            bitset.set(0);
        }
        if (pinimpression.isSetTime())
        {
            bitset.set(1);
        }
        if (pinimpression.isSetPinIdStr())
        {
            bitset.set(2);
        }
        if (pinimpression.isSetInsertionId())
        {
            bitset.set(3);
        }
        if (pinimpression.isSetEndTime())
        {
            bitset.set(4);
        }
        if (pinimpression.isSetYPosition())
        {
            bitset.set(5);
        }
        if (pinimpression.isSetColumnIndex())
        {
            bitset.set(6);
        }
        if (pinimpression.isSetSlotIndex())
        {
            bitset.set(7);
        }
        if (pinimpression.isSetRequestId())
        {
            bitset.set(8);
        }
        if (pinimpression.isSetType())
        {
            bitset.set(9);
        }
        if (pinimpression.isSetRenderDuration())
        {
            bitset.set(10);
        }
        if (pinimpression.isSetImageURL())
        {
            bitset.set(11);
        }
        if (pinimpression.isSetImageSignature())
        {
            bitset.set(12);
        }
        if (pinimpression.isSetCached())
        {
            bitset.set(13);
        }
        if (pinimpression.isSetLoops())
        {
            bitset.set(14);
        }
        tprotocol.writeBitSet(bitset, 15);
        if (pinimpression.isSetPinId())
        {
            tprotocol.writeI64(pinimpression.pinId);
        }
        if (pinimpression.isSetTime())
        {
            tprotocol.writeI64(pinimpression.time);
        }
        if (pinimpression.isSetPinIdStr())
        {
            tprotocol.writeString(pinimpression.pinIdStr);
        }
        if (pinimpression.isSetInsertionId())
        {
            tprotocol.writeString(pinimpression.insertionId);
        }
        if (pinimpression.isSetEndTime())
        {
            tprotocol.writeI64(pinimpression.endTime);
        }
        if (pinimpression.isSetYPosition())
        {
            tprotocol.writeI32(pinimpression.yPosition);
        }
        if (pinimpression.isSetColumnIndex())
        {
            tprotocol.writeI16(pinimpression.columnIndex);
        }
        if (pinimpression.isSetSlotIndex())
        {
            tprotocol.writeI16(pinimpression.slotIndex);
        }
        if (pinimpression.isSetRequestId())
        {
            tprotocol.writeString(pinimpression.requestId);
        }
        if (pinimpression.isSetType())
        {
            tprotocol.writeI32(pinimpression.type.getValue());
        }
        if (pinimpression.isSetRenderDuration())
        {
            tprotocol.writeDouble(pinimpression.renderDuration);
        }
        if (pinimpression.isSetImageURL())
        {
            tprotocol.writeString(pinimpression.imageURL);
        }
        if (pinimpression.isSetImageSignature())
        {
            tprotocol.writeString(pinimpression.imageSignature);
        }
        if (pinimpression.isSetCached())
        {
            tprotocol.writeBool(pinimpression.cached);
        }
        if (pinimpression.isSetLoops())
        {
            tprotocol.writeDouble(pinimpression.loops);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PinImpression)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
