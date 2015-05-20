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
//            PhantomClipRect

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomClipRect phantomcliprect)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 103
    //                   3 139
    //                   4 175;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_175;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 6)
        {
            phantomcliprect.top = tprotocol.readI16();
            phantomcliprect.setTopIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 6)
        {
            phantomcliprect.left = tprotocol.readI16();
            phantomcliprect.setLeftIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 6)
        {
            phantomcliprect.height = tprotocol.readI16();
            phantomcliprect.setHeightIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 6)
        {
            phantomcliprect.width = tprotocol.readI16();
            phantomcliprect.setWidthIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        phantomcliprect.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomClipRect)tbase);
    }

    public void write(TProtocol tprotocol, PhantomClipRect phantomcliprect)
    {
        phantomcliprect.validate();
        tprotocol.writeStructBegin(PhantomClipRect.access$300());
        if (phantomcliprect.isSetTop())
        {
            tprotocol.writeFieldBegin(PhantomClipRect.access$400());
            tprotocol.writeI16(phantomcliprect.top);
            tprotocol.writeFieldEnd();
        }
        if (phantomcliprect.isSetLeft())
        {
            tprotocol.writeFieldBegin(PhantomClipRect.access$500());
            tprotocol.writeI16(phantomcliprect.left);
            tprotocol.writeFieldEnd();
        }
        if (phantomcliprect.isSetHeight())
        {
            tprotocol.writeFieldBegin(PhantomClipRect.access$600());
            tprotocol.writeI16(phantomcliprect.height);
            tprotocol.writeFieldEnd();
        }
        if (phantomcliprect.isSetWidth())
        {
            tprotocol.writeFieldBegin(PhantomClipRect.access$700());
            tprotocol.writeI16(phantomcliprect.width);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomClipRect)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
