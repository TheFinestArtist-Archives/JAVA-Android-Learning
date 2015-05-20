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
//            PhantomRawResult, PhantomRedirectResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomRawResult phantomrawresult)
    {
        tprotocol.readStructBegin();
_L8:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 71
    //                   2 107
    //                   3 207
    //                   4 243
    //                   5 278;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_278;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L9:
        tprotocol.readFieldEnd();
        if (true) goto _L8; else goto _L7
_L7:
        if (((TField) (obj)).type == 11)
        {
            phantomrawresult.baseUrl = tprotocol.readString();
            phantomrawresult.setBaseUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L9
_L3:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            phantomrawresult.redirectList = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                PhantomRedirectResult phantomredirectresult = new PhantomRedirectResult();
                phantomredirectresult.read(tprotocol);
                phantomrawresult.redirectList.add(phantomredirectresult);
            }

            tprotocol.readListEnd();
            phantomrawresult.setRedirectListIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L9
_L4:
        if (((TField) (obj)).type == 11)
        {
            phantomrawresult.base64Image = tprotocol.readString();
            phantomrawresult.setBase64ImageIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L9
_L5:
        if (((TField) (obj)).type == 2)
        {
            phantomrawresult.completed = tprotocol.readBool();
            phantomrawresult.setCompletedIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L9
        if (((TField) (obj)).type == 11)
        {
            phantomrawresult.message = tprotocol.readString();
            phantomrawresult.setMessageIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L9
        tprotocol.readStructEnd();
        phantomrawresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRawResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRawResult phantomrawresult)
    {
        phantomrawresult.validate();
        tprotocol.writeStructBegin(PhantomRawResult.access$300());
        if (phantomrawresult.baseUrl != null)
        {
            tprotocol.writeFieldBegin(PhantomRawResult.access$400());
            tprotocol.writeString(phantomrawresult.baseUrl);
            tprotocol.writeFieldEnd();
        }
        if (phantomrawresult.redirectList != null && phantomrawresult.isSetRedirectList())
        {
            tprotocol.writeFieldBegin(PhantomRawResult.access$500());
            tprotocol.writeListBegin(new TList((byte)12, phantomrawresult.redirectList.size()));
            for (Iterator iterator = phantomrawresult.redirectList.iterator(); iterator.hasNext(); ((PhantomRedirectResult)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (phantomrawresult.base64Image != null && phantomrawresult.isSetBase64Image())
        {
            tprotocol.writeFieldBegin(PhantomRawResult.access$600());
            tprotocol.writeString(phantomrawresult.base64Image);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(PhantomRawResult.access$700());
        tprotocol.writeBool(phantomrawresult.completed);
        tprotocol.writeFieldEnd();
        if (phantomrawresult.message != null)
        {
            tprotocol.writeFieldBegin(PhantomRawResult.access$800());
            tprotocol.writeString(phantomrawresult.message);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRawResult)tbase);
    }

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }
}
