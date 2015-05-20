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
//            OffsiteServiceResult, UrlCheckResult, UrlCheckLevel

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
    {
        tprotocol.readStructBegin();
_L7:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 167
    //                   3 203
    //                   4 239;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_239;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            offsiteserviceresult.results = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                UrlCheckResult urlcheckresult = new UrlCheckResult();
                urlcheckresult.read(tprotocol);
                offsiteserviceresult.results.add(urlcheckresult);
            }

            tprotocol.readListEnd();
            offsiteserviceresult.setResultsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L8
_L3:
        if (((TField) (obj)).type == 11)
        {
            offsiteserviceresult.host = tprotocol.readString();
            offsiteserviceresult.setHostIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L8
_L4:
        if (((TField) (obj)).type == 10)
        {
            offsiteserviceresult.time = tprotocol.readI64();
            offsiteserviceresult.setTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L8
        if (((TField) (obj)).type == 8)
        {
            offsiteserviceresult.checkLevel = UrlCheckLevel.findByValue(tprotocol.readI32());
            offsiteserviceresult.setCheckLevelIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L8
        tprotocol.readStructEnd();
        offsiteserviceresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (OffsiteServiceResult)tbase);
    }

    public void write(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
    {
        offsiteserviceresult.validate();
        tprotocol.writeStructBegin(OffsiteServiceResult.access$300());
        if (offsiteserviceresult.results != null)
        {
            tprotocol.writeFieldBegin(OffsiteServiceResult.access$400());
            tprotocol.writeListBegin(new TList((byte)12, offsiteserviceresult.results.size()));
            for (Iterator iterator = offsiteserviceresult.results.iterator(); iterator.hasNext(); ((UrlCheckResult)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (offsiteserviceresult.host != null)
        {
            tprotocol.writeFieldBegin(OffsiteServiceResult.access$500());
            tprotocol.writeString(offsiteserviceresult.host);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(OffsiteServiceResult.access$600());
        tprotocol.writeI64(offsiteserviceresult.time);
        tprotocol.writeFieldEnd();
        if (offsiteserviceresult.checkLevel != null)
        {
            tprotocol.writeFieldBegin(OffsiteServiceResult.access$700());
            tprotocol.writeI32(offsiteserviceresult.checkLevel.getValue());
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (OffsiteServiceResult)tbase);
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
