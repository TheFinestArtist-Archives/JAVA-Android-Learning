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
//            ComponentData, ToastType, NagType, EducationType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, ComponentData componentdata)
    {
        tprotocol.readStructBegin();
_L8:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        tfield.id;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 71
    //                   2 107
    //                   3 146
    //                   4 185
    //                   5 224;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_224;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
        tprotocol.readFieldEnd();
        if (true) goto _L8; else goto _L7
_L7:
        if (tfield.type == 8)
        {
            componentdata.stub = tprotocol.readI32();
            componentdata.setStubIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L3:
        if (tfield.type == 8)
        {
            componentdata.toastType = ToastType.findByValue(tprotocol.readI32());
            componentdata.setToastTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L4:
        if (tfield.type == 8)
        {
            componentdata.nagType = NagType.findByValue(tprotocol.readI32());
            componentdata.setNagTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L5:
        if (tfield.type == 8)
        {
            componentdata.educationType = EducationType.findByValue(tprotocol.readI32());
            componentdata.setEducationTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        if (tfield.type == 11)
        {
            componentdata.digestStoryType = tprotocol.readString();
            componentdata.setDigestStoryTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        tprotocol.readStructEnd();
        componentdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ComponentData)tbase);
    }

    public void write(TProtocol tprotocol, ComponentData componentdata)
    {
        componentdata.validate();
        tprotocol.writeStructBegin(ComponentData.access$300());
        if (componentdata.isSetStub())
        {
            tprotocol.writeFieldBegin(ComponentData.access$400());
            tprotocol.writeI32(componentdata.stub);
            tprotocol.writeFieldEnd();
        }
        if (componentdata.toastType != null && componentdata.isSetToastType())
        {
            tprotocol.writeFieldBegin(ComponentData.access$500());
            tprotocol.writeI32(componentdata.toastType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (componentdata.nagType != null && componentdata.isSetNagType())
        {
            tprotocol.writeFieldBegin(ComponentData.access$600());
            tprotocol.writeI32(componentdata.nagType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (componentdata.educationType != null && componentdata.isSetEducationType())
        {
            tprotocol.writeFieldBegin(ComponentData.access$700());
            tprotocol.writeI32(componentdata.educationType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (componentdata.digestStoryType != null && componentdata.isSetDigestStoryType())
        {
            tprotocol.writeFieldBegin(ComponentData.access$800());
            tprotocol.writeString(componentdata.digestStoryType);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ComponentData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
