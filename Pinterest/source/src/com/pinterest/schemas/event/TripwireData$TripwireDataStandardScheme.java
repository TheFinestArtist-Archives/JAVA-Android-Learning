// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            TripwireData, LimitAction

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, TripwireData tripwiredata)
    {
        tprotocol.readStructBegin();
_L6:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 99
    //                   3 138;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_138;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (tfield.type == 11)
        {
            tripwiredata.ruleName = tprotocol.readString();
            tripwiredata.setRuleNameIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 8)
        {
            tripwiredata.action = LimitAction.findByValue(tprotocol.readI32());
            tripwiredata.setActionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 10)
        {
            tripwiredata.userId = tprotocol.readI64();
            tripwiredata.setUserIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        tripwiredata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TripwireData)tbase);
    }

    public void write(TProtocol tprotocol, TripwireData tripwiredata)
    {
        tripwiredata.validate();
        tprotocol.writeStructBegin(TripwireData.access$300());
        if (tripwiredata.ruleName != null)
        {
            tprotocol.writeFieldBegin(TripwireData.access$400());
            tprotocol.writeString(tripwiredata.ruleName);
            tprotocol.writeFieldEnd();
        }
        if (tripwiredata.action != null)
        {
            tprotocol.writeFieldBegin(TripwireData.access$500());
            tprotocol.writeI32(tripwiredata.action.getValue());
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(TripwireData.access$600());
        tprotocol.writeI64(tripwiredata.userId);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TripwireData)tbase);
    }

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
