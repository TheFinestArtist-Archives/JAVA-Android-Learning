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
//            RecommendationObjectType, TypedRecommendationList, RecommendationDetail

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
    {
        tprotocol.readStructBegin();
_L6:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 102
    //                   3 193;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_193;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (((TField) (obj)).type == 8)
        {
            typedrecommendationlist.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
            typedrecommendationlist.setObjectTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
_L3:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            typedrecommendationlist.recommendations = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                String s = tprotocol.readString();
                typedrecommendationlist.recommendations.add(s);
            }

            tprotocol.readListEnd();
            typedrecommendationlist.setRecommendationsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            typedrecommendationlist.recommendationDetails = new ArrayList(((TList) (obj)).size);
            for (int j = 0; j < ((TList) (obj)).size; j++)
            {
                RecommendationDetail recommendationdetail = new RecommendationDetail();
                recommendationdetail.read(tprotocol);
                typedrecommendationlist.recommendationDetails.add(recommendationdetail);
            }

            tprotocol.readListEnd();
            typedrecommendationlist.setRecommendationDetailsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        tprotocol.readStructEnd();
        typedrecommendationlist.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (TypedRecommendationList)tbase);
    }

    public void write(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
    {
        typedrecommendationlist.validate();
        tprotocol.writeStructBegin(TypedRecommendationList.access$300());
        if (typedrecommendationlist.objectType != null && typedrecommendationlist.isSetObjectType())
        {
            tprotocol.writeFieldBegin(TypedRecommendationList.access$400());
            tprotocol.writeI32(typedrecommendationlist.objectType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (typedrecommendationlist.recommendations != null && typedrecommendationlist.isSetRecommendations())
        {
            tprotocol.writeFieldBegin(TypedRecommendationList.access$500());
            tprotocol.writeListBegin(new TList((byte)11, typedrecommendationlist.recommendations.size()));
            for (Iterator iterator = typedrecommendationlist.recommendations.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (typedrecommendationlist.recommendationDetails != null && typedrecommendationlist.isSetRecommendationDetails())
        {
            tprotocol.writeFieldBegin(TypedRecommendationList.access$600());
            tprotocol.writeListBegin(new TList((byte)12, typedrecommendationlist.recommendationDetails.size()));
            for (typedrecommendationlist = typedrecommendationlist.recommendationDetails.iterator(); typedrecommendationlist.hasNext(); ((RecommendationDetail)typedrecommendationlist.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (TypedRecommendationList)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
