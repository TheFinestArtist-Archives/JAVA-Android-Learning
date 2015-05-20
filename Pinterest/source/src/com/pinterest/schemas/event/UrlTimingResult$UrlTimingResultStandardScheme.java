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
//            UrlTimingResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, UrlTimingResult urltimingresult)
    {
        tprotocol.readStructBegin();
_L2:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_131;
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
        if (tfield.type == 11)
        {
            urltimingresult.url = tprotocol.readString();
            urltimingresult.setUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 10)
        {
            urltimingresult.timing = tprotocol.readI64();
            urltimingresult.setTimingIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        urltimingresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (UrlTimingResult)tbase);
    }

    public void write(TProtocol tprotocol, UrlTimingResult urltimingresult)
    {
        urltimingresult.validate();
        tprotocol.writeStructBegin(UrlTimingResult.access$300());
        if (urltimingresult.url != null)
        {
            tprotocol.writeFieldBegin(UrlTimingResult.access$400());
            tprotocol.writeString(urltimingresult.url);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(UrlTimingResult.access$500());
        tprotocol.writeI64(urltimingresult.timing);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (UrlTimingResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
