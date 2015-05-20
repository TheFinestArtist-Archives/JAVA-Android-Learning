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
//            ElementData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, ElementData elementdata)
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
        if (tfield.type == 8)
        {
            elementdata.stub = tprotocol.readI32();
            elementdata.setStubIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 11)
        {
            elementdata.repinButtonGroup = tprotocol.readString();
            elementdata.setRepinButtonGroupIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 11)
        {
            elementdata.networkStoryType = tprotocol.readString();
            elementdata.setNetworkStoryTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 11)
        {
            elementdata.networkStoryCellType = tprotocol.readString();
            elementdata.setNetworkStoryCellTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        elementdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ElementData)tbase);
    }

    public void write(TProtocol tprotocol, ElementData elementdata)
    {
        elementdata.validate();
        tprotocol.writeStructBegin(ElementData.access$300());
        if (elementdata.isSetStub())
        {
            tprotocol.writeFieldBegin(ElementData.access$400());
            tprotocol.writeI32(elementdata.stub);
            tprotocol.writeFieldEnd();
        }
        if (elementdata.repinButtonGroup != null && elementdata.isSetRepinButtonGroup())
        {
            tprotocol.writeFieldBegin(ElementData.access$500());
            tprotocol.writeString(elementdata.repinButtonGroup);
            tprotocol.writeFieldEnd();
        }
        if (elementdata.networkStoryType != null && elementdata.isSetNetworkStoryType())
        {
            tprotocol.writeFieldBegin(ElementData.access$600());
            tprotocol.writeString(elementdata.networkStoryType);
            tprotocol.writeFieldEnd();
        }
        if (elementdata.networkStoryCellType != null && elementdata.isSetNetworkStoryCellType())
        {
            tprotocol.writeFieldBegin(ElementData.access$700());
            tprotocol.writeString(elementdata.networkStoryCellType);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ElementData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
