// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.BitSet;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            UrlTimingResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, UrlTimingResult urltimingresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            urltimingresult.url = tprotocol.readString();
            urltimingresult.setUrlIsSet(true);
        }
        if (bitset.get(1))
        {
            urltimingresult.timing = tprotocol.readI64();
            urltimingresult.setTimingIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (UrlTimingResult)tbase);
    }

    public void write(TProtocol tprotocol, UrlTimingResult urltimingresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (urltimingresult.isSetUrl())
        {
            bitset.set(0);
        }
        if (urltimingresult.isSetTiming())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (urltimingresult.isSetUrl())
        {
            tprotocol.writeString(urltimingresult.url);
        }
        if (urltimingresult.isSetTiming())
        {
            tprotocol.writeI64(urltimingresult.timing);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (UrlTimingResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
