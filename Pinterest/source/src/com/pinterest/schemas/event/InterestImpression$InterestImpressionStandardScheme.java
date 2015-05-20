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
//            InterestImpression

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, InterestImpression interestimpression)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 103
    //                   3 138
    //                   4 174;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_174;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 11)
        {
            interestimpression.key = tprotocol.readString();
            interestimpression.setKeyIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 3)
        {
            interestimpression.interestSize = tprotocol.readByte();
            interestimpression.setInterestSizeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 11)
        {
            interestimpression.imageSignature = tprotocol.readString();
            interestimpression.setImageSignatureIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 6)
        {
            interestimpression.listPosition = tprotocol.readI16();
            interestimpression.setListPositionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        interestimpression.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InterestImpression)tbase);
    }

    public void write(TProtocol tprotocol, InterestImpression interestimpression)
    {
        interestimpression.validate();
        tprotocol.writeStructBegin(InterestImpression.access$300());
        if (interestimpression.key != null && interestimpression.isSetKey())
        {
            tprotocol.writeFieldBegin(InterestImpression.access$400());
            tprotocol.writeString(interestimpression.key);
            tprotocol.writeFieldEnd();
        }
        if (interestimpression.isSetInterestSize())
        {
            tprotocol.writeFieldBegin(InterestImpression.access$500());
            tprotocol.writeByte(interestimpression.interestSize);
            tprotocol.writeFieldEnd();
        }
        if (interestimpression.imageSignature != null && interestimpression.isSetImageSignature())
        {
            tprotocol.writeFieldBegin(InterestImpression.access$600());
            tprotocol.writeString(interestimpression.imageSignature);
            tprotocol.writeFieldEnd();
        }
        if (interestimpression.isSetListPosition())
        {
            tprotocol.writeFieldBegin(InterestImpression.access$700());
            tprotocol.writeI16(interestimpression.listPosition);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InterestImpression)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
