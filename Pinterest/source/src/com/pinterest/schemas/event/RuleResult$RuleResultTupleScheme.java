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
//            RuleResult, LimitAction

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, RuleResult ruleresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            ruleresult.rule = tprotocol.readString();
            ruleresult.setRuleIsSet(true);
        }
        if (bitset.get(1))
        {
            ruleresult.action = LimitAction.findByValue(tprotocol.readI32());
            ruleresult.setActionIsSet(true);
        }
        if (bitset.get(2))
        {
            ruleresult.message = tprotocol.readString();
            ruleresult.setMessageIsSet(true);
        }
        if (bitset.get(3))
        {
            ruleresult.data = tprotocol.readString();
            ruleresult.setDataIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RuleResult)tbase);
    }

    public void write(TProtocol tprotocol, RuleResult ruleresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (ruleresult.isSetRule())
        {
            bitset.set(0);
        }
        if (ruleresult.isSetAction())
        {
            bitset.set(1);
        }
        if (ruleresult.isSetMessage())
        {
            bitset.set(2);
        }
        if (ruleresult.isSetData())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (ruleresult.isSetRule())
        {
            tprotocol.writeString(ruleresult.rule);
        }
        if (ruleresult.isSetAction())
        {
            tprotocol.writeI32(ruleresult.action.getValue());
        }
        if (ruleresult.isSetMessage())
        {
            tprotocol.writeString(ruleresult.message);
        }
        if (ruleresult.isSetData())
        {
            tprotocol.writeString(ruleresult.data);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RuleResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
