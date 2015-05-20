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
//            PhantomRedirectResult, PhantomRedirectHeaders

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
    {
        tprotocol.readStructBegin();
_L10:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 7: default 64
    //                   1 79
    //                   2 115
    //                   3 215
    //                   4 251
    //                   5 287
    //                   6 323
    //                   7 359;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_359;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L11:
        tprotocol.readFieldEnd();
        if (true) goto _L10; else goto _L9
_L9:
        if (((TField) (obj)).type == 11)
        {
            phantomredirectresult.url = tprotocol.readString();
            phantomredirectresult.setUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
_L3:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            phantomredirectresult.headers = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                PhantomRedirectHeaders phantomredirectheaders = new PhantomRedirectHeaders();
                phantomredirectheaders.read(tprotocol);
                phantomredirectresult.headers.add(phantomredirectheaders);
            }

            tprotocol.readListEnd();
            phantomredirectresult.setHeadersIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
_L4:
        if (((TField) (obj)).type == 11)
        {
            phantomredirectresult.body = tprotocol.readString();
            phantomredirectresult.setBodyIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
_L5:
        if (((TField) (obj)).type == 11)
        {
            phantomredirectresult.requestTime = tprotocol.readString();
            phantomredirectresult.setRequestTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
_L6:
        if (((TField) (obj)).type == 11)
        {
            phantomredirectresult.responseTime = tprotocol.readString();
            phantomredirectresult.setResponseTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
_L7:
        if (((TField) (obj)).type == 6)
        {
            phantomredirectresult.status = tprotocol.readI16();
            phantomredirectresult.setStatusIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
        if (((TField) (obj)).type == 11)
        {
            phantomredirectresult.statusText = tprotocol.readString();
            phantomredirectresult.setStatusTextIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L11
        tprotocol.readStructEnd();
        phantomredirectresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRedirectResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
    {
        phantomredirectresult.validate();
        tprotocol.writeStructBegin(PhantomRedirectResult.access$300());
        if (phantomredirectresult.url != null && phantomredirectresult.isSetUrl())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$400());
            tprotocol.writeString(phantomredirectresult.url);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.headers != null && phantomredirectresult.isSetHeaders())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$500());
            tprotocol.writeListBegin(new TList((byte)12, phantomredirectresult.headers.size()));
            for (Iterator iterator = phantomredirectresult.headers.iterator(); iterator.hasNext(); ((PhantomRedirectHeaders)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.body != null && phantomredirectresult.isSetBody())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$600());
            tprotocol.writeString(phantomredirectresult.body);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.requestTime != null && phantomredirectresult.isSetRequestTime())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$700());
            tprotocol.writeString(phantomredirectresult.requestTime);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.responseTime != null && phantomredirectresult.isSetResponseTime())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$800());
            tprotocol.writeString(phantomredirectresult.responseTime);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.isSetStatus())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$900());
            tprotocol.writeI16(phantomredirectresult.status);
            tprotocol.writeFieldEnd();
        }
        if (phantomredirectresult.statusText != null && phantomredirectresult.isSetStatusText())
        {
            tprotocol.writeFieldBegin(PhantomRedirectResult.access$1000());
            tprotocol.writeString(phantomredirectresult.statusText);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRedirectResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
