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
//            ViewType, Context, ViewParameterType, ViewData, 
//            ComponentType, ComponentData, ElementType, ElementData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, Context context)
    {
        tprotocol.readStructBegin();
_L10:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        tfield.id;
        JVM INSTR tableswitch 1 7: default 64
    //                   1 79
    //                   2 118
    //                   3 157
    //                   4 204
    //                   5 243
    //                   6 290
    //                   7 329;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_329;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L11:
        tprotocol.readFieldEnd();
        if (true) goto _L10; else goto _L9
_L9:
        if (tfield.type == 8)
        {
            context.viewType = ViewType.findByValue(tprotocol.readI32());
            context.setViewTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L3:
        if (tfield.type == 8)
        {
            context.viewParameter = ViewParameterType.findByValue(tprotocol.readI32());
            context.setViewParameterIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L4:
        if (tfield.type == 12)
        {
            context.viewData = new ViewData();
            context.viewData.read(tprotocol);
            context.setViewDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L5:
        if (tfield.type == 8)
        {
            context.component = ComponentType.findByValue(tprotocol.readI32());
            context.setComponentIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L6:
        if (tfield.type == 12)
        {
            context.componentData = new ComponentData();
            context.componentData.read(tprotocol);
            context.setComponentDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L7:
        if (tfield.type == 8)
        {
            context.element = ElementType.findByValue(tprotocol.readI32());
            context.setElementIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        if (tfield.type == 12)
        {
            context.elementData = new ElementData();
            context.elementData.read(tprotocol);
            context.setElementDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        tprotocol.readStructEnd();
        context.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (Context)tbase);
    }

    public void write(TProtocol tprotocol, Context context)
    {
        context.validate();
        tprotocol.writeStructBegin(Context.access$300());
        if (context.viewType != null)
        {
            tprotocol.writeFieldBegin(Context.access$400());
            tprotocol.writeI32(context.viewType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (context.viewParameter != null && context.isSetViewParameter())
        {
            tprotocol.writeFieldBegin(Context.access$500());
            tprotocol.writeI32(context.viewParameter.getValue());
            tprotocol.writeFieldEnd();
        }
        if (context.viewData != null && context.isSetViewData())
        {
            tprotocol.writeFieldBegin(Context.access$600());
            context.viewData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (context.component != null && context.isSetComponent())
        {
            tprotocol.writeFieldBegin(Context.access$700());
            tprotocol.writeI32(context.component.getValue());
            tprotocol.writeFieldEnd();
        }
        if (context.componentData != null && context.isSetComponentData())
        {
            tprotocol.writeFieldBegin(Context.access$800());
            context.componentData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (context.element != null && context.isSetElement())
        {
            tprotocol.writeFieldBegin(Context.access$900());
            tprotocol.writeI32(context.element.getValue());
            tprotocol.writeFieldEnd();
        }
        if (context.elementData != null && context.isSetElementData())
        {
            tprotocol.writeFieldBegin(Context.access$1000());
            context.elementData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (Context)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
