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
//            PhantomScraperResult, PhantomRawResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
    {
        tprotocol.readStructBegin();
_L6:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 99
    //                   3 135;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_135;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (tfield.type == 11)
        {
            phantomscraperresult.baseUrl = tprotocol.readString();
            phantomscraperresult.setBaseUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            phantomscraperresult.amzUrl = tprotocol.readString();
            phantomscraperresult.setAmzUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 12)
        {
            phantomscraperresult.rawResult = new PhantomRawResult();
            phantomscraperresult.rawResult.read(tprotocol);
            phantomscraperresult.setRawResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        phantomscraperresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomScraperResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
    {
        phantomscraperresult.validate();
        tprotocol.writeStructBegin(PhantomScraperResult.access$300());
        if (phantomscraperresult.baseUrl != null)
        {
            tprotocol.writeFieldBegin(PhantomScraperResult.access$400());
            tprotocol.writeString(phantomscraperresult.baseUrl);
            tprotocol.writeFieldEnd();
        }
        if (phantomscraperresult.amzUrl != null)
        {
            tprotocol.writeFieldBegin(PhantomScraperResult.access$500());
            tprotocol.writeString(phantomscraperresult.amzUrl);
            tprotocol.writeFieldEnd();
        }
        if (phantomscraperresult.rawResult != null)
        {
            tprotocol.writeFieldBegin(PhantomScraperResult.access$600());
            phantomscraperresult.rawResult.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomScraperResult)tbase);
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
