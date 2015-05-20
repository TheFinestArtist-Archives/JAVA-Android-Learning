// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            PinInsertion

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PinInsertion pininsertion)
    {
        tprotocol.readStructBegin();
_L6:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 99
    //                   3 135;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_135;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (tfield.type == 10)
        {
            pininsertion.pinId = tprotocol.readI64();
            pininsertion.setPinIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            pininsertion.adsInsertionId = tprotocol.readBinary();
            pininsertion.setAdsInsertionIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 6)
        {
            pininsertion.slot = tprotocol.readI16();
            pininsertion.setSlotIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        if (!pininsertion.isSetPinId())
        {
            throw new TProtocolException((new StringBuilder("Required field 'pinId' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            pininsertion.validate();
            return;
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinInsertion)tbase);
    }

    public void write(TProtocol tprotocol, PinInsertion pininsertion)
    {
        pininsertion.validate();
        tprotocol.writeStructBegin(PinInsertion.access$300());
        tprotocol.writeFieldBegin(PinInsertion.access$400());
        tprotocol.writeI64(pininsertion.pinId);
        tprotocol.writeFieldEnd();
        if (pininsertion.adsInsertionId != null && pininsertion.isSetAdsInsertionId())
        {
            tprotocol.writeFieldBegin(PinInsertion.access$500());
            tprotocol.writeBinary(pininsertion.adsInsertionId);
            tprotocol.writeFieldEnd();
        }
        if (pininsertion.isSetSlot())
        {
            tprotocol.writeFieldBegin(PinInsertion.access$600());
            tprotocol.writeI16(pininsertion.slot);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PinInsertion)tbase);
    }

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
