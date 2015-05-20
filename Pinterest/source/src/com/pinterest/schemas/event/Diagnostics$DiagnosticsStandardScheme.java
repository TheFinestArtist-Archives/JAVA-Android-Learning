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
//            Diagnostics

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, Diagnostics diagnostics)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0) goto _L2; else goto _L1
_L1:
        tfield.id;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 55;
           goto _L3 _L4
_L3:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L5:
        tprotocol.readFieldEnd();
        continue; /* Loop/switch isn't completed */
_L4:
        if (tfield.type == 11)
        {
            diagnostics.hostname = tprotocol.readString();
            diagnostics.setHostnameIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
        if (true) goto _L5; else goto _L2
_L2:
        tprotocol.readStructEnd();
        diagnostics.validate();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (Diagnostics)tbase);
    }

    public void write(TProtocol tprotocol, Diagnostics diagnostics)
    {
        diagnostics.validate();
        tprotocol.writeStructBegin(Diagnostics.access$300());
        if (diagnostics.hostname != null && diagnostics.isSetHostname())
        {
            tprotocol.writeFieldBegin(Diagnostics.access$400());
            tprotocol.writeString(diagnostics.hostname);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (Diagnostics)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
