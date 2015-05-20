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
//            TripwireData, LimitAction

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, TripwireData tripwiredata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(3);
        if (bitset.get(0))
        {
            tripwiredata.ruleName = tprotocol.readString();
            tripwiredata.setRuleNameIsSet(true);
        }
        if (bitset.get(1))
        {
            tripwiredata.action = LimitAction.findByValue(tprotocol.readI32());
            tripwiredata.setActionIsSet(true);
        }
        if (bitset.get(2))
        {
            tripwiredata.userId = tprotocol.readI64();
            tripwiredata.setUserIdIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TripwireData)tbase);
    }

    public void write(TProtocol tprotocol, TripwireData tripwiredata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (tripwiredata.isSetRuleName())
        {
            bitset.set(0);
        }
        if (tripwiredata.isSetAction())
        {
            bitset.set(1);
        }
        if (tripwiredata.isSetUserId())
        {
            bitset.set(2);
        }
        tprotocol.writeBitSet(bitset, 3);
        if (tripwiredata.isSetRuleName())
        {
            tprotocol.writeString(tripwiredata.ruleName);
        }
        if (tripwiredata.isSetAction())
        {
            tprotocol.writeI32(tripwiredata.action.getValue());
        }
        if (tripwiredata.isSetUserId())
        {
            tprotocol.writeI64(tripwiredata.userId);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TripwireData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
