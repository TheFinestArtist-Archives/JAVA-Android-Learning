// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package org.apache.thrift:
//            TUnion, TBase

class <init> extends StandardScheme
{

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TUnion)tbase);
    }

    public void read(TProtocol tprotocol, TUnion tunion)
    {
        tunion.setField_ = null;
        tunion.value_ = null;
        tprotocol.readStructBegin();
        TField tfield = tprotocol.readFieldBegin();
        tunion.value_ = tunion.standardSchemeReadValue(tprotocol, tfield);
        if (tunion.value_ != null)
        {
            tunion.setField_ = tunion.enumForId(tfield.id);
        }
        tprotocol.readFieldEnd();
        tprotocol.readFieldBegin();
        tprotocol.readStructEnd();
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
            tprotocol.writeStructBegin(tunion.getStructDesc());
            tprotocol.writeFieldBegin(tunion.getFieldDesc(tunion.setField_));
            tunion.standardSchemeWriteValue(tprotocol);
            tprotocol.writeFieldEnd();
            tprotocol.writeFieldStop();
            tprotocol.writeStructEnd();
            return;
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
