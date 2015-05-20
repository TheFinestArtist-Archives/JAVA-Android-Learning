// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationTriggerType, RecommendationTriggerEvent, RecommendationObjectType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
    {
        tprotocol.readStructBegin();
_L6:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 102
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
        if (tfield.type == 8)
        {
            recommendationtriggerevent.triggerType = RecommendationTriggerType.findByValue(tprotocol.readI32());
            recommendationtriggerevent.setTriggerTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            recommendationtriggerevent.triggerObjectIdStr = tprotocol.readString();
            recommendationtriggerevent.setTriggerObjectIdStrIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 8)
        {
            recommendationtriggerevent.triggerObjectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            recommendationtriggerevent.setTriggerObjectTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        recommendationtriggerevent.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationTriggerEvent)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
    {
        recommendationtriggerevent.validate();
        tprotocol.writeStructBegin(RecommendationTriggerEvent.access$300());
        if (recommendationtriggerevent.triggerType != null && recommendationtriggerevent.isSetTriggerType())
        {
            tprotocol.writeFieldBegin(RecommendationTriggerEvent.access$400());
            tprotocol.writeI32(recommendationtriggerevent.triggerType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (recommendationtriggerevent.triggerObjectIdStr != null && recommendationtriggerevent.isSetTriggerObjectIdStr())
        {
            tprotocol.writeFieldBegin(RecommendationTriggerEvent.access$500());
            tprotocol.writeString(recommendationtriggerevent.triggerObjectIdStr);
            tprotocol.writeFieldEnd();
        }
        if (recommendationtriggerevent.triggerObjectType != null && recommendationtriggerevent.isSetTriggerObjectType())
        {
            tprotocol.writeFieldBegin(RecommendationTriggerEvent.access$600());
            tprotocol.writeI32(recommendationtriggerevent.triggerObjectType.getValue());
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationTriggerEvent)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
