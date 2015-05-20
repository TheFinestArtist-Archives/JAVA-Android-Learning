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
//            RequestInfo, SpamServiceRequest, LimitResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 114
    //                   3 161
    //                   4 197;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_197;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 12)
        {
            spamservicerequest.request = new RequestInfo();
            spamservicerequest.request.read(tprotocol);
            spamservicerequest.setRequestIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 12)
        {
            spamservicerequest.result = new LimitResult();
            spamservicerequest.result.read(tprotocol);
            spamservicerequest.setResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 11)
        {
            spamservicerequest.host = tprotocol.readString();
            spamservicerequest.setHostIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 10)
        {
            spamservicerequest.time = tprotocol.readI64();
            spamservicerequest.setTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        spamservicerequest.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (SpamServiceRequest)tbase);
    }

    public void write(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
    {
        spamservicerequest.validate();
        tprotocol.writeStructBegin(SpamServiceRequest.access$300());
        if (spamservicerequest.request != null)
        {
            tprotocol.writeFieldBegin(SpamServiceRequest.access$400());
            spamservicerequest.request.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (spamservicerequest.result != null)
        {
            tprotocol.writeFieldBegin(SpamServiceRequest.access$500());
            spamservicerequest.result.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (spamservicerequest.host != null)
        {
            tprotocol.writeFieldBegin(SpamServiceRequest.access$600());
            tprotocol.writeString(spamservicerequest.host);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(SpamServiceRequest.access$700());
        tprotocol.writeI64(spamservicerequest.time);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (SpamServiceRequest)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
