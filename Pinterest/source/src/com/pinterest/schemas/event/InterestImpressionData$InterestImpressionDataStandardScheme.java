// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            InterestImpressionData, InterestImpression

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
    {
        tprotocol.readStructBegin();
_L6:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 163
    //                   3 199;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_199;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            interestimpressiondata.interestImpressions = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                InterestImpression interestimpression = new InterestImpression();
                interestimpression.read(tprotocol);
                interestimpressiondata.interestImpressions.add(interestimpression);
            }

            tprotocol.readListEnd();
            interestimpressiondata.setInterestImpressionsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
_L3:
        if (((TField) (obj)).type == 11)
        {
            interestimpressiondata.orderType = tprotocol.readString();
            interestimpressiondata.setOrderTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        if (((TField) (obj)).type == 11)
        {
            interestimpressiondata.blendType = tprotocol.readString();
            interestimpressiondata.setBlendTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        tprotocol.readStructEnd();
        interestimpressiondata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InterestImpressionData)tbase);
    }

    public void write(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
    {
        interestimpressiondata.validate();
        tprotocol.writeStructBegin(InterestImpressionData.access$300());
        if (interestimpressiondata.interestImpressions != null && interestimpressiondata.isSetInterestImpressions())
        {
            tprotocol.writeFieldBegin(InterestImpressionData.access$400());
            tprotocol.writeListBegin(new TList((byte)12, interestimpressiondata.interestImpressions.size()));
            for (Iterator iterator = interestimpressiondata.interestImpressions.iterator(); iterator.hasNext(); ((InterestImpression)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (interestimpressiondata.orderType != null && interestimpressiondata.isSetOrderType())
        {
            tprotocol.writeFieldBegin(InterestImpressionData.access$500());
            tprotocol.writeString(interestimpressiondata.orderType);
            tprotocol.writeFieldEnd();
        }
        if (interestimpressiondata.blendType != null && interestimpressiondata.isSetBlendType())
        {
            tprotocol.writeFieldBegin(InterestImpressionData.access$600());
            tprotocol.writeString(interestimpressiondata.blendType);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InterestImpressionData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
