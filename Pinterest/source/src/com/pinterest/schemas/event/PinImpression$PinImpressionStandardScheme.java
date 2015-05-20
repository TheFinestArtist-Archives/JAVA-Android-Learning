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
//            PinImpression, PinImpressionType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PinImpression pinimpression)
    {
        tprotocol.readStructBegin();
_L18:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        tfield.id;
        JVM INSTR tableswitch 1 15: default 96
    //                   1 111
    //                   2 147
    //                   3 183
    //                   4 219
    //                   5 255
    //                   6 291
    //                   7 327
    //                   8 363
    //                   9 399
    //                   10 435
    //                   11 474
    //                   12 509
    //                   13 545
    //                   14 581
    //                   15 616;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L16:
        break MISSING_BLOCK_LABEL_616;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L19:
        tprotocol.readFieldEnd();
        if (true) goto _L18; else goto _L17
_L17:
        if (tfield.type == 10)
        {
            pinimpression.pinId = tprotocol.readI64();
            pinimpression.setPinIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L3:
        if (tfield.type == 10)
        {
            pinimpression.time = tprotocol.readI64();
            pinimpression.setTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L4:
        if (tfield.type == 11)
        {
            pinimpression.pinIdStr = tprotocol.readString();
            pinimpression.setPinIdStrIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L5:
        if (tfield.type == 11)
        {
            pinimpression.insertionId = tprotocol.readString();
            pinimpression.setInsertionIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L6:
        if (tfield.type == 10)
        {
            pinimpression.endTime = tprotocol.readI64();
            pinimpression.setEndTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L7:
        if (tfield.type == 8)
        {
            pinimpression.yPosition = tprotocol.readI32();
            pinimpression.setYPositionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L8:
        if (tfield.type == 6)
        {
            pinimpression.columnIndex = tprotocol.readI16();
            pinimpression.setColumnIndexIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L9:
        if (tfield.type == 6)
        {
            pinimpression.slotIndex = tprotocol.readI16();
            pinimpression.setSlotIndexIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L10:
        if (tfield.type == 11)
        {
            pinimpression.requestId = tprotocol.readString();
            pinimpression.setRequestIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L11:
        if (tfield.type == 8)
        {
            pinimpression.type = PinImpressionType.findByValue(tprotocol.readI32());
            pinimpression.setTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L12:
        if (tfield.type == 4)
        {
            pinimpression.renderDuration = tprotocol.readDouble();
            pinimpression.setRenderDurationIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L13:
        if (tfield.type == 11)
        {
            pinimpression.imageURL = tprotocol.readString();
            pinimpression.setImageURLIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L14:
        if (tfield.type == 11)
        {
            pinimpression.imageSignature = tprotocol.readString();
            pinimpression.setImageSignatureIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
_L15:
        if (tfield.type == 2)
        {
            pinimpression.cached = tprotocol.readBool();
            pinimpression.setCachedIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
        if (tfield.type == 4)
        {
            pinimpression.loops = tprotocol.readDouble();
            pinimpression.setLoopsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L19
        tprotocol.readStructEnd();
        pinimpression.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinImpression)tbase);
    }

    public void write(TProtocol tprotocol, PinImpression pinimpression)
    {
        pinimpression.validate();
        tprotocol.writeStructBegin(PinImpression.access$300());
        tprotocol.writeFieldBegin(PinImpression.access$400());
        tprotocol.writeI64(pinimpression.pinId);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(PinImpression.access$500());
        tprotocol.writeI64(pinimpression.time);
        tprotocol.writeFieldEnd();
        if (pinimpression.pinIdStr != null && pinimpression.isSetPinIdStr())
        {
            tprotocol.writeFieldBegin(PinImpression.access$600());
            tprotocol.writeString(pinimpression.pinIdStr);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.insertionId != null && pinimpression.isSetInsertionId())
        {
            tprotocol.writeFieldBegin(PinImpression.access$700());
            tprotocol.writeString(pinimpression.insertionId);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetEndTime())
        {
            tprotocol.writeFieldBegin(PinImpression.access$800());
            tprotocol.writeI64(pinimpression.endTime);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetYPosition())
        {
            tprotocol.writeFieldBegin(PinImpression.access$900());
            tprotocol.writeI32(pinimpression.yPosition);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetColumnIndex())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1000());
            tprotocol.writeI16(pinimpression.columnIndex);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetSlotIndex())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1100());
            tprotocol.writeI16(pinimpression.slotIndex);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.requestId != null && pinimpression.isSetRequestId())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1200());
            tprotocol.writeString(pinimpression.requestId);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.type != null && pinimpression.isSetType())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1300());
            tprotocol.writeI32(pinimpression.type.getValue());
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetRenderDuration())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1400());
            tprotocol.writeDouble(pinimpression.renderDuration);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.imageURL != null && pinimpression.isSetImageURL())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1500());
            tprotocol.writeString(pinimpression.imageURL);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.imageSignature != null && pinimpression.isSetImageSignature())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1600());
            tprotocol.writeString(pinimpression.imageSignature);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetCached())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1700());
            tprotocol.writeBool(pinimpression.cached);
            tprotocol.writeFieldEnd();
        }
        if (pinimpression.isSetLoops())
        {
            tprotocol.writeFieldBegin(PinImpression.access$1800());
            tprotocol.writeDouble(pinimpression.loops);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
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
