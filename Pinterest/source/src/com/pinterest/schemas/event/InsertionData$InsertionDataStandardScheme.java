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
//            InsertionData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, InsertionData insertiondata)
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
        if (tfield.type == 11)
        {
            insertiondata.requestId = tprotocol.readBinary();
            insertiondata.setRequestIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 10)
        {
            insertiondata.pinId = tprotocol.readI64();
            insertiondata.setPinIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 11)
        {
            insertiondata.adsInsertionId = tprotocol.readBinary();
            insertiondata.setAdsInsertionIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        if (!insertiondata.isSetPinId())
        {
            throw new TProtocolException((new StringBuilder("Required field 'pinId' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            insertiondata.validate();
            return;
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InsertionData)tbase);
    }

    public void write(TProtocol tprotocol, InsertionData insertiondata)
    {
        insertiondata.validate();
        tprotocol.writeStructBegin(InsertionData.access$300());
        if (insertiondata.requestId != null)
        {
            tprotocol.writeFieldBegin(InsertionData.access$400());
            tprotocol.writeBinary(insertiondata.requestId);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(InsertionData.access$500());
        tprotocol.writeI64(insertiondata.pinId);
        tprotocol.writeFieldEnd();
        if (insertiondata.adsInsertionId != null && insertiondata.isSetAdsInsertionId())
        {
            tprotocol.writeFieldBegin(InsertionData.access$600());
            tprotocol.writeBinary(insertiondata.adsInsertionId);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InsertionData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
