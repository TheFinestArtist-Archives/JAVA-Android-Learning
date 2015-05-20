// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            VisualObjectData, VisualObject

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, VisualObjectData visualobjectdata)
    {
        tprotocol.readStructBegin();
_L6:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 163
    //                   3 199;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_199;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            visualobjectdata.objects = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                VisualObject visualobject = new VisualObject();
                visualobject.read(tprotocol);
                visualobjectdata.objects.add(visualobject);
            }

            tprotocol.readListEnd();
            visualobjectdata.setObjectsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
_L3:
        if (((TField) (obj)).type == 11)
        {
            visualobjectdata.simlistVersion = tprotocol.readString();
            visualobjectdata.setSimlistVersionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        if (((TField) (obj)).type == 6)
        {
            visualobjectdata.selectedObjectIndex = tprotocol.readI16();
            visualobjectdata.setSelectedObjectIndexIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        tprotocol.readStructEnd();
        visualobjectdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (VisualObjectData)tbase);
    }

    public void write(TProtocol tprotocol, VisualObjectData visualobjectdata)
    {
        visualobjectdata.validate();
        tprotocol.writeStructBegin(VisualObjectData.access$300());
        if (visualobjectdata.objects != null && visualobjectdata.isSetObjects())
        {
            tprotocol.writeFieldBegin(VisualObjectData.access$400());
            tprotocol.writeListBegin(new TList((byte)12, visualobjectdata.objects.size()));
            for (Iterator iterator = visualobjectdata.objects.iterator(); iterator.hasNext(); ((VisualObject)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (visualobjectdata.simlistVersion != null && visualobjectdata.isSetSimlistVersion())
        {
            tprotocol.writeFieldBegin(VisualObjectData.access$500());
            tprotocol.writeString(visualobjectdata.simlistVersion);
            tprotocol.writeFieldEnd();
        }
        if (visualobjectdata.isSetSelectedObjectIndex())
        {
            tprotocol.writeFieldBegin(VisualObjectData.access$600());
            tprotocol.writeI16(visualobjectdata.selectedObjectIndex);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (VisualObjectData)tbase);
    }

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }
}
