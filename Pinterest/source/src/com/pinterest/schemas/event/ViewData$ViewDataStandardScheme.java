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
//            ViewData, VisualObjectData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, ViewData viewdata)
    {
        tprotocol.readStructBegin();
_L10:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        tfield.id;
        JVM INSTR tableswitch 1 7: default 64
    //                   1 79
    //                   2 115
    //                   3 151
    //                   4 187
    //                   5 234
    //                   6 270
    //                   7 306;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_306;
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
            viewdata.stub = tprotocol.readI32();
            viewdata.setStubIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L3:
        if (tfield.type == 11)
        {
            viewdata.interestName = tprotocol.readString();
            viewdata.setInterestNameIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L4:
        if (tfield.type == 10)
        {
            viewdata.viewObjectId = tprotocol.readI64();
            viewdata.setViewObjectIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L5:
        if (tfield.type == 12)
        {
            viewdata.objectData = new VisualObjectData();
            viewdata.objectData.read(tprotocol);
            viewdata.setObjectDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L6:
        if (tfield.type == 11)
        {
            viewdata.searchQuery = tprotocol.readString();
            viewdata.setSearchQueryIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L7:
        if (tfield.type == 11)
        {
            viewdata.analyticsSelectedApplication = tprotocol.readString();
            viewdata.setAnalyticsSelectedApplicationIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        if (tfield.type == 11)
        {
            viewdata.viewObjectIdStr = tprotocol.readString();
            viewdata.setViewObjectIdStrIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        tprotocol.readStructEnd();
        viewdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ViewData)tbase);
    }

    public void write(TProtocol tprotocol, ViewData viewdata)
    {
        viewdata.validate();
        tprotocol.writeStructBegin(ViewData.access$300());
        if (viewdata.isSetStub())
        {
            tprotocol.writeFieldBegin(ViewData.access$400());
            tprotocol.writeI32(viewdata.stub);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.interestName != null && viewdata.isSetInterestName())
        {
            tprotocol.writeFieldBegin(ViewData.access$500());
            tprotocol.writeString(viewdata.interestName);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.isSetViewObjectId())
        {
            tprotocol.writeFieldBegin(ViewData.access$600());
            tprotocol.writeI64(viewdata.viewObjectId);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.objectData != null && viewdata.isSetObjectData())
        {
            tprotocol.writeFieldBegin(ViewData.access$700());
            viewdata.objectData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.searchQuery != null && viewdata.isSetSearchQuery())
        {
            tprotocol.writeFieldBegin(ViewData.access$800());
            tprotocol.writeString(viewdata.searchQuery);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.analyticsSelectedApplication != null && viewdata.isSetAnalyticsSelectedApplication())
        {
            tprotocol.writeFieldBegin(ViewData.access$900());
            tprotocol.writeString(viewdata.analyticsSelectedApplication);
            tprotocol.writeFieldEnd();
        }
        if (viewdata.viewObjectIdStr != null && viewdata.isSetViewObjectIdStr())
        {
            tprotocol.writeFieldBegin(ViewData.access$1000());
            tprotocol.writeString(viewdata.viewObjectIdStr);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ViewData)tbase);
    }

    private A()
    {
    }

    A(A a)
    {
        this();
    }
}
