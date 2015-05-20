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
//            LimitData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, LimitData limitdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(5);
        if (bitset.get(0))
        {
            limitdata.signup_score_v2 = tprotocol.readDouble();
            limitdata.setSignup_score_v2IsSet(true);
        }
        if (bitset.get(1))
        {
            limitdata.signup_score_v1 = tprotocol.readDouble();
            limitdata.setSignup_score_v1IsSet(true);
        }
        if (bitset.get(2))
        {
            limitdata.offsite_score = tprotocol.readDouble();
            limitdata.setOffsite_scoreIsSet(true);
        }
        if (bitset.get(3))
        {
            limitdata.sanitized_url = tprotocol.readString();
            limitdata.setSanitized_urlIsSet(true);
        }
        if (bitset.get(4))
        {
            limitdata.signup_score_v3 = tprotocol.readDouble();
            limitdata.setSignup_score_v3IsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (LimitData)tbase);
    }

    public void write(TProtocol tprotocol, LimitData limitdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (limitdata.isSetSignup_score_v2())
        {
            bitset.set(0);
        }
        if (limitdata.isSetSignup_score_v1())
        {
            bitset.set(1);
        }
        if (limitdata.isSetOffsite_score())
        {
            bitset.set(2);
        }
        if (limitdata.isSetSanitized_url())
        {
            bitset.set(3);
        }
        if (limitdata.isSetSignup_score_v3())
        {
            bitset.set(4);
        }
        tprotocol.writeBitSet(bitset, 5);
        if (limitdata.isSetSignup_score_v2())
        {
            tprotocol.writeDouble(limitdata.signup_score_v2);
        }
        if (limitdata.isSetSignup_score_v1())
        {
            tprotocol.writeDouble(limitdata.signup_score_v1);
        }
        if (limitdata.isSetOffsite_score())
        {
            tprotocol.writeDouble(limitdata.offsite_score);
        }
        if (limitdata.isSetSanitized_url())
        {
            tprotocol.writeString(limitdata.sanitized_url);
        }
        if (limitdata.isSetSignup_score_v3())
        {
            tprotocol.writeDouble(limitdata.signup_score_v3);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (LimitData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
