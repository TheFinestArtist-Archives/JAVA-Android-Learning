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
//            VisualObject

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, VisualObject visualobject)
    {
        tprotocol.readStructBegin();
_L9:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        tfield.id;
        JVM INSTR tableswitch 1 6: default 60
    //                   1 75
    //                   2 111
    //                   3 147
    //                   4 182
    //                   5 217
    //                   6 252;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_252;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L10:
        tprotocol.readFieldEnd();
        if (true) goto _L9; else goto _L8
_L8:
        if (tfield.type == 11)
        {
            visualobject.objectType = tprotocol.readString();
            visualobject.setObjectTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
_L3:
        if (tfield.type == 6)
        {
            visualobject.objectIndex = tprotocol.readI16();
            visualobject.setObjectIndexIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
_L4:
        if (tfield.type == 4)
        {
            visualobject.x = tprotocol.readDouble();
            visualobject.setXIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
_L5:
        if (tfield.type == 4)
        {
            visualobject.y = tprotocol.readDouble();
            visualobject.setYIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
_L6:
        if (tfield.type == 4)
        {
            visualobject.w = tprotocol.readDouble();
            visualobject.setWIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
        if (tfield.type == 4)
        {
            visualobject.h = tprotocol.readDouble();
            visualobject.setHIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L10
        tprotocol.readStructEnd();
        visualobject.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (VisualObject)tbase);
    }

    public void write(TProtocol tprotocol, VisualObject visualobject)
    {
        visualobject.validate();
        tprotocol.writeStructBegin(VisualObject.access$300());
        if (visualobject.objectType != null && visualobject.isSetObjectType())
        {
            tprotocol.writeFieldBegin(VisualObject.access$400());
            tprotocol.writeString(visualobject.objectType);
            tprotocol.writeFieldEnd();
        }
        if (visualobject.isSetObjectIndex())
        {
            tprotocol.writeFieldBegin(VisualObject.access$500());
            tprotocol.writeI16(visualobject.objectIndex);
            tprotocol.writeFieldEnd();
        }
        if (visualobject.isSetX())
        {
            tprotocol.writeFieldBegin(VisualObject.access$600());
            tprotocol.writeDouble(visualobject.x);
            tprotocol.writeFieldEnd();
        }
        if (visualobject.isSetY())
        {
            tprotocol.writeFieldBegin(VisualObject.access$700());
            tprotocol.writeDouble(visualobject.y);
            tprotocol.writeFieldEnd();
        }
        if (visualobject.isSetW())
        {
            tprotocol.writeFieldBegin(VisualObject.access$800());
            tprotocol.writeDouble(visualobject.w);
            tprotocol.writeFieldEnd();
        }
        if (visualobject.isSetH())
        {
            tprotocol.writeFieldBegin(VisualObject.access$900());
            tprotocol.writeDouble(visualobject.h);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (VisualObject)tbase);
    }

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
