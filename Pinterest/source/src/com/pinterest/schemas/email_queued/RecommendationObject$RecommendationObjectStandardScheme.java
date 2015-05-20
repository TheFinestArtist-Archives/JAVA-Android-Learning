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
//            RecommendationObject, RecommendationObjectType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, RecommendationObject recommendationobject)
    {
        tprotocol.readStructBegin();
_L2:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        switch (tfield.id)
        {
        default:
            TProtocolUtil.skip(tprotocol, tfield.type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_95;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (tfield.type == 10)
        {
            recommendationobject.objectId = tprotocol.readI64();
            recommendationobject.setObjectIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 8)
        {
            recommendationobject.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            recommendationobject.setObjectTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        recommendationobject.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationObject)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationObject recommendationobject)
    {
        recommendationobject.validate();
        tprotocol.writeStructBegin(RecommendationObject.access$300());
        tprotocol.writeFieldBegin(RecommendationObject.access$400());
        tprotocol.writeI64(recommendationobject.objectId);
        tprotocol.writeFieldEnd();
        if (recommendationobject.objectType != null)
        {
            tprotocol.writeFieldBegin(RecommendationObject.access$500());
            tprotocol.writeI32(recommendationobject.objectType.getValue());
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationObject)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
