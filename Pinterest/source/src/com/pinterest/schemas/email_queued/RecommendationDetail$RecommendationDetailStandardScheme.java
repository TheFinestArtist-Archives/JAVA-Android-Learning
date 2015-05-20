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
//            RecommendationDetail

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, RecommendationDetail recommendationdetail)
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
            recommendationdetail.idString = tprotocol.readString();
            recommendationdetail.setIdStringIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            recommendationdetail.algoTag = tprotocol.readString();
            recommendationdetail.setAlgoTagIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 11)
        {
            recommendationdetail.source = tprotocol.readString();
            recommendationdetail.setSourceIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        recommendationdetail.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RecommendationDetail)tbase);
    }

    public void write(TProtocol tprotocol, RecommendationDetail recommendationdetail)
    {
        recommendationdetail.validate();
        tprotocol.writeStructBegin(RecommendationDetail.access$300());
        if (recommendationdetail.idString != null && recommendationdetail.isSetIdString())
        {
            tprotocol.writeFieldBegin(RecommendationDetail.access$400());
            tprotocol.writeString(recommendationdetail.idString);
            tprotocol.writeFieldEnd();
        }
        if (recommendationdetail.algoTag != null && recommendationdetail.isSetAlgoTag())
        {
            tprotocol.writeFieldBegin(RecommendationDetail.access$500());
            tprotocol.writeString(recommendationdetail.algoTag);
            tprotocol.writeFieldEnd();
        }
        if (recommendationdetail.source != null && recommendationdetail.isSetSource())
        {
            tprotocol.writeFieldBegin(RecommendationDetail.access$600());
            tprotocol.writeString(recommendationdetail.source);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RecommendationDetail)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
