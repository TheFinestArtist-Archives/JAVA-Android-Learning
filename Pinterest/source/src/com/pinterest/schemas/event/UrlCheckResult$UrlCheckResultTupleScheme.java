// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            LimitResult, UrlCheckResult, UrlTimingResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, UrlCheckResult urlcheckresult)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(6);
        if (bitset.get(0))
        {
            urlcheckresult.result = new LimitResult();
            urlcheckresult.result.read(tprotocol);
            urlcheckresult.setResultIsSet(true);
        }
        if (bitset.get(1))
        {
            urlcheckresult.sanitizedUrl = tprotocol.readString();
            urlcheckresult.setSanitizedUrlIsSet(true);
        }
        if (bitset.get(2))
        {
            urlcheckresult.url = tprotocol.readString();
            urlcheckresult.setUrlIsSet(true);
        }
        if (bitset.get(3))
        {
            urlcheckresult.statusCode = tprotocol.readI16();
            urlcheckresult.setStatusCodeIsSet(true);
        }
        if (bitset.get(4))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            urlcheckresult.redirectTimings = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                UrlTimingResult urltimingresult = new UrlTimingResult();
                urltimingresult.read(tprotocol);
                urlcheckresult.redirectTimings.add(urltimingresult);
            }

            urlcheckresult.setRedirectTimingsIsSet(true);
        }
        if (bitset.get(5))
        {
            urlcheckresult.blockReason = tprotocol.readString();
            urlcheckresult.setBlockReasonIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (UrlCheckResult)tbase);
    }

    public void write(TProtocol tprotocol, UrlCheckResult urlcheckresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (urlcheckresult.isSetResult())
        {
            bitset.set(0);
        }
        if (urlcheckresult.isSetSanitizedUrl())
        {
            bitset.set(1);
        }
        if (urlcheckresult.isSetUrl())
        {
            bitset.set(2);
        }
        if (urlcheckresult.isSetStatusCode())
        {
            bitset.set(3);
        }
        if (urlcheckresult.isSetRedirectTimings())
        {
            bitset.set(4);
        }
        if (urlcheckresult.isSetBlockReason())
        {
            bitset.set(5);
        }
        tprotocol.writeBitSet(bitset, 6);
        if (urlcheckresult.isSetResult())
        {
            urlcheckresult.result.write(tprotocol);
        }
        if (urlcheckresult.isSetSanitizedUrl())
        {
            tprotocol.writeString(urlcheckresult.sanitizedUrl);
        }
        if (urlcheckresult.isSetUrl())
        {
            tprotocol.writeString(urlcheckresult.url);
        }
        if (urlcheckresult.isSetStatusCode())
        {
            tprotocol.writeI16(urlcheckresult.statusCode);
        }
        if (urlcheckresult.isSetRedirectTimings())
        {
            tprotocol.writeI32(urlcheckresult.redirectTimings.size());
            for (Iterator iterator = urlcheckresult.redirectTimings.iterator(); iterator.hasNext(); ((UrlTimingResult)iterator.next()).write(tprotocol)) { }
        }
        if (urlcheckresult.isSetBlockReason())
        {
            tprotocol.writeString(urlcheckresult.blockReason);
        }
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
