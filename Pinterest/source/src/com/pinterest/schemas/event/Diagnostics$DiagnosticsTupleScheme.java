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
//            Diagnostics

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, Diagnostics diagnostics)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        if (tprotocol.readBitSet(1).get(0))
        {
            diagnostics.hostname = tprotocol.readString();
            diagnostics.setHostnameIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (Diagnostics)tbase);
    }

    public void write(TProtocol tprotocol, Diagnostics diagnostics)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (diagnostics.isSetHostname())
        {
            bitset.set(0);
        }
        tprotocol.writeBitSet(bitset, 1);
        if (diagnostics.isSetHostname())
        {
            tprotocol.writeString(diagnostics.hostname);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (Diagnostics)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
