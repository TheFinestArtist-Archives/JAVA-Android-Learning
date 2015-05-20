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
//            PhantomServiceResult, PhantomScraperResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
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
            phantomserviceresult.phantomResult = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                PhantomScraperResult phantomscraperresult = new PhantomScraperResult();
                phantomscraperresult.read(tprotocol);
                phantomserviceresult.phantomResult.add(phantomscraperresult);
            }

            tprotocol.readListEnd();
            phantomserviceresult.setPhantomResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
_L3:
        if (((TField) (obj)).type == 11)
        {
            phantomserviceresult.host = tprotocol.readString();
            phantomserviceresult.setHostIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        if (((TField) (obj)).type == 10)
        {
            phantomserviceresult.time = tprotocol.readI64();
            phantomserviceresult.setTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L7
        tprotocol.readStructEnd();
        phantomserviceresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomServiceResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
    {
        phantomserviceresult.validate();
        tprotocol.writeStructBegin(PhantomServiceResult.access$300());
        if (phantomserviceresult.phantomResult != null)
        {
            tprotocol.writeFieldBegin(PhantomServiceResult.access$400());
            tprotocol.writeListBegin(new TList((byte)12, phantomserviceresult.phantomResult.size()));
            for (Iterator iterator = phantomserviceresult.phantomResult.iterator(); iterator.hasNext(); ((PhantomScraperResult)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (phantomserviceresult.host != null)
        {
            tprotocol.writeFieldBegin(PhantomServiceResult.access$500());
            tprotocol.writeString(phantomserviceresult.host);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(PhantomServiceResult.access$600());
        tprotocol.writeI64(phantomserviceresult.time);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomServiceResult)tbase);
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
