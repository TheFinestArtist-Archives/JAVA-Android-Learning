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
//            PhantomRedirectHeaders

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
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
            phantomredirectheaders.name = tprotocol.readString();
            phantomredirectheaders.setNameIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 11)
        {
            phantomredirectheaders.value = tprotocol.readString();
            phantomredirectheaders.setValueIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        phantomredirectheaders.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRedirectHeaders)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
    {
        phantomredirectheaders.validate();
        tprotocol.writeStructBegin(PhantomRedirectHeaders.access$300());
        if (phantomredirectheaders.name != null)
        {
            tprotocol.writeFieldBegin(PhantomRedirectHeaders.access$400());
            tprotocol.writeString(phantomredirectheaders.name);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectheaders.value != null)
        {
            tprotocol.writeFieldBegin(PhantomRedirectHeaders.access$500());
            tprotocol.writeString(phantomredirectheaders.value);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRedirectHeaders)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
