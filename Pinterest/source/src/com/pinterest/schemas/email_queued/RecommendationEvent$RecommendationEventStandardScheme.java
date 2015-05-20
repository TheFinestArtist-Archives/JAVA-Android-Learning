// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationEvent, RecommendationTriggerEvent, TypedRecommendationList

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, RecommendationEvent recommendationevent)
    {
        tprotocol.readStructBegin();
_L6:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 99
    //                   3 146;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_146;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (((TField) (obj)).type == 11)
        {
            recommendationevent.recommendationEventId = tprotocol.readString();
            recommendationevent.setRecommendationEventIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
_L3:
        if (((TField) (obj)).type == 12)
        {
            recommendationevent.triggerEvent = new RecommendationTriggerEvent();
            recommendationevent.triggerEvent.read(tprotocol);
            recommendationevent.setTriggerEventIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            recommendationevent.recommendations = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                TypedRecommendationList typedrecommendationlist = new TypedRecommendationList();
                typedrecommendationlist.read(tprotocol);
                recommendationevent.recommendations.add(typedrecommendationlist);
            }

            tprotocol.readListEnd();
            recommendationevent.setRecommendationsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        tprotocol.readStructEnd();
        recommendationevent.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationEvent)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationEvent recommendationevent)
    {
        recommendationevent.validate();
        tprotocol.writeStructBegin(RecommendationEvent.access$300());
        if (recommendationevent.recommendationEventId != null && recommendationevent.isSetRecommendationEventId())
        {
            tprotocol.writeFieldBegin(RecommendationEvent.access$400());
            tprotocol.writeString(recommendationevent.recommendationEventId);
            tprotocol.writeFieldEnd();
        }
        if (recommendationevent.triggerEvent != null && recommendationevent.isSetTriggerEvent())
        {
            tprotocol.writeFieldBegin(RecommendationEvent.access$500());
            recommendationevent.triggerEvent.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (recommendationevent.recommendations != null && recommendationevent.isSetRecommendations())
        {
            tprotocol.writeFieldBegin(RecommendationEvent.access$600());
            tprotocol.writeListBegin(new TList((byte)12, recommendationevent.recommendations.size()));
            for (recommendationevent = recommendationevent.recommendations.iterator(); recommendationevent.hasNext(); ((TypedRecommendationList)recommendationevent.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationEvent)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
