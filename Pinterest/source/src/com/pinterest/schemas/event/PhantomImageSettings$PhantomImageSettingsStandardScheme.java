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
//            PhantomClipRect, PhantomImageSettings

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
    {
        tprotocol.readStructBegin();
_L2:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        switch (tfield.id)
        {
        default:
            TProtocolUtil.skip(tprotocol, tfield.type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_106;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (tfield.type == 12)
        {
            phantomimagesettings.clipRect = new PhantomClipRect();
            phantomimagesettings.clipRect.read(tprotocol);
            phantomimagesettings.setClipRectIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 2)
        {
            phantomimagesettings.loadImages = tprotocol.readBool();
            phantomimagesettings.setLoadImagesIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        phantomimagesettings.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomImageSettings)tbase);
    }

    public void write(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
    {
        phantomimagesettings.validate();
        tprotocol.writeStructBegin(PhantomImageSettings.access$300());
        if (phantomimagesettings.clipRect != null && phantomimagesettings.isSetClipRect())
        {
            tprotocol.writeFieldBegin(PhantomImageSettings.access$400());
            phantomimagesettings.clipRect.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (phantomimagesettings.isSetLoadImages())
        {
            tprotocol.writeFieldBegin(PhantomImageSettings.access$500());
            tprotocol.writeBool(phantomimagesettings.loadImages);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomImageSettings)tbase);
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
