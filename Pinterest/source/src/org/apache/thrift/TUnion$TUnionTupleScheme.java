// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package org.apache.thrift:
//            TUnion, TFieldIdEnum, TBase

class <init> extends TupleScheme
{

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TUnion)tbase);
    }

    public void read(TProtocol tprotocol, TUnion tunion)
    {
        tunion.setField_ = null;
        tunion.value_ = null;
        short word0 = tprotocol.readI16();
        tunion.value_ = tunion.tupleSchemeReadValue(tprotocol, word0);
        if (tunion.value_ != null)
        {
            tunion.setField_ = tunion.enumForId(word0);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TUnion)tbase);
    }

    public void write(TProtocol tprotocol, TUnion tunion)
    {
        if (tunion.getSetField() == null || tunion.getFieldValue() == null)
        {
            throw new TProtocolException("Cannot write a TUnion with no set value!");
        } else
        {
            tprotocol.writeI16(tunion.setField_.getThriftFieldId());
            tunion.tupleSchemeWriteValue(tprotocol);
            return;
        }
    }

    private on()
    {
    }

    on(on on)
    {
        this();
    }
}
