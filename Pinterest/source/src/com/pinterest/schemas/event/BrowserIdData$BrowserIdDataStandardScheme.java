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
//            BrowserIdData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, BrowserIdData browseriddata)
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
            browseriddata.browserId = tprotocol.readString();
            browseriddata.setBrowserIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            browseriddata.encodedBrowserId = tprotocol.readString();
            browseriddata.setEncodedBrowserIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 8)
        {
            browseriddata.state = tprotocol.readI32();
            browseriddata.setStateIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        browseriddata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (BrowserIdData)tbase);
    }

    public void write(TProtocol tprotocol, BrowserIdData browseriddata)
    {
        browseriddata.validate();
        tprotocol.writeStructBegin(BrowserIdData.access$300());
        if (browseriddata.browserId != null)
        {
            tprotocol.writeFieldBegin(BrowserIdData.access$400());
            tprotocol.writeString(browseriddata.browserId);
            tprotocol.writeFieldEnd();
        }
        if (browseriddata.encodedBrowserId != null)
        {
            tprotocol.writeFieldBegin(BrowserIdData.access$500());
            tprotocol.writeString(browseriddata.encodedBrowserId);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(BrowserIdData.access$600());
        tprotocol.writeI32(browseriddata.state);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (BrowserIdData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
