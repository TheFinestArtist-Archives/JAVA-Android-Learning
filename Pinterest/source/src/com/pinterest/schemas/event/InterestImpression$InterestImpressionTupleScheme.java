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
//            InterestImpression

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, InterestImpression interestimpression)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(4);
        if (bitset.get(0))
        {
            interestimpression.key = tprotocol.readString();
            interestimpression.setKeyIsSet(true);
        }
        if (bitset.get(1))
        {
            interestimpression.interestSize = tprotocol.readByte();
            interestimpression.setInterestSizeIsSet(true);
        }
        if (bitset.get(2))
        {
            interestimpression.imageSignature = tprotocol.readString();
            interestimpression.setImageSignatureIsSet(true);
        }
        if (bitset.get(3))
        {
            interestimpression.listPosition = tprotocol.readI16();
            interestimpression.setListPositionIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (InterestImpression)tbase);
    }

    public void write(TProtocol tprotocol, InterestImpression interestimpression)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (interestimpression.isSetKey())
        {
            bitset.set(0);
        }
        if (interestimpression.isSetInterestSize())
        {
            bitset.set(1);
        }
        if (interestimpression.isSetImageSignature())
        {
            bitset.set(2);
        }
        if (interestimpression.isSetListPosition())
        {
            bitset.set(3);
        }
        tprotocol.writeBitSet(bitset, 4);
        if (interestimpression.isSetKey())
        {
            tprotocol.writeString(interestimpression.key);
        }
        if (interestimpression.isSetInterestSize())
        {
            tprotocol.writeByte(interestimpression.interestSize);
        }
        if (interestimpression.isSetImageSignature())
        {
            tprotocol.writeString(interestimpression.imageSignature);
        }
        if (interestimpression.isSetListPosition())
        {
            tprotocol.writeI16(interestimpression.listPosition);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (InterestImpression)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
