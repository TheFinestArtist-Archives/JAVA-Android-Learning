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
//            LimitResult, UrlCheckResult, UrlTimingResult

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, UrlCheckResult urlcheckresult)
    {
        tprotocol.readStructBegin();
_L9:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 6: default 60
    //                   1 75
    //                   2 122
    //                   3 158
    //                   4 194
    //                   5 230
    //                   6 330;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_330;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
        tprotocol.readFieldEnd();
        if (true) goto _L9; else goto _L8
_L8:
        if (((TField) (obj)).type == 12)
        {
            urlcheckresult.result = new LimitResult();
            urlcheckresult.result.read(tprotocol);
            urlcheckresult.setResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L3:
        if (((TField) (obj)).type == 11)
        {
            urlcheckresult.sanitizedUrl = tprotocol.readString();
            urlcheckresult.setSanitizedUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L4:
        if (((TField) (obj)).type == 11)
        {
            urlcheckresult.url = tprotocol.readString();
            urlcheckresult.setUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L5:
        if (((TField) (obj)).type == 6)
        {
            urlcheckresult.statusCode = tprotocol.readI16();
            urlcheckresult.setStatusCodeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L6:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            urlcheckresult.redirectTimings = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                UrlTimingResult urltimingresult = new UrlTimingResult();
                urltimingresult.read(tprotocol);
                urlcheckresult.redirectTimings.add(urltimingresult);
            }

            tprotocol.readListEnd();
            urlcheckresult.setRedirectTimingsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        if (((TField) (obj)).type == 11)
        {
            urlcheckresult.blockReason = tprotocol.readString();
            urlcheckresult.setBlockReasonIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        tprotocol.readStructEnd();
        urlcheckresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (UrlCheckResult)tbase);
    }

    public void write(TProtocol tprotocol, UrlCheckResult urlcheckresult)
    {
        urlcheckresult.validate();
        tprotocol.writeStructBegin(UrlCheckResult.access$300());
        if (urlcheckresult.result != null)
        {
            tprotocol.writeFieldBegin(UrlCheckResult.access$400());
            urlcheckresult.result.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (urlcheckresult.sanitizedUrl != null)
        {
            tprotocol.writeFieldBegin(UrlCheckResult.access$500());
            tprotocol.writeString(urlcheckresult.sanitizedUrl);
            tprotocol.writeFieldEnd();
        }
        if (urlcheckresult.url != null)
        {
            tprotocol.writeFieldBegin(UrlCheckResult.access$600());
            tprotocol.writeString(urlcheckresult.url);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(UrlCheckResult.access$700());
        tprotocol.writeI16(urlcheckresult.statusCode);
        tprotocol.writeFieldEnd();
        if (urlcheckresult.redirectTimings != null)
        {
            tprotocol.writeFieldBegin(UrlCheckResult.access$800());
            tprotocol.writeListBegin(new TList((byte)12, urlcheckresult.redirectTimings.size()));
            for (Iterator iterator = urlcheckresult.redirectTimings.iterator(); iterator.hasNext(); ((UrlTimingResult)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (urlcheckresult.blockReason != null)
        {
            tprotocol.writeFieldBegin(UrlCheckResult.access$900());
            tprotocol.writeString(urlcheckresult.blockReason);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (UrlCheckResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
