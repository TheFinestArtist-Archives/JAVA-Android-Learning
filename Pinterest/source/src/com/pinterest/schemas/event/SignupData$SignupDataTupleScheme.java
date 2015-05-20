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
//            SignupData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, SignupData signupdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(5);
        if (bitset.get(0))
        {
            signupdata.via = tprotocol.readString();
            signupdata.setViaIsSet(true);
        }
        if (bitset.get(1))
        {
            signupdata.medium = tprotocol.readString();
            signupdata.setMediumIsSet(true);
        }
        if (bitset.get(2))
        {
            signupdata.socialId = tprotocol.readString();
            signupdata.setSocialIdIsSet(true);
        }
        if (bitset.get(3))
        {
            signupdata.userAgent = tprotocol.readString();
            signupdata.setUserAgentIsSet(true);
        }
        if (bitset.get(4))
        {
            signupdata.referrerType = tprotocol.readString();
            signupdata.setReferrerTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (SignupData)tbase);
    }

    public void write(TProtocol tprotocol, SignupData signupdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (signupdata.isSetVia())
        {
            bitset.set(0);
        }
        if (signupdata.isSetMedium())
        {
            bitset.set(1);
        }
        if (signupdata.isSetSocialId())
        {
            bitset.set(2);
        }
        if (signupdata.isSetUserAgent())
        {
            bitset.set(3);
        }
        if (signupdata.isSetReferrerType())
        {
            bitset.set(4);
        }
        tprotocol.writeBitSet(bitset, 5);
        if (signupdata.isSetVia())
        {
            tprotocol.writeString(signupdata.via);
        }
        if (signupdata.isSetMedium())
        {
            tprotocol.writeString(signupdata.medium);
        }
        if (signupdata.isSetSocialId())
        {
            tprotocol.writeString(signupdata.socialId);
        }
        if (signupdata.isSetUserAgent())
        {
            tprotocol.writeString(signupdata.userAgent);
        }
        if (signupdata.isSetReferrerType())
        {
            tprotocol.writeString(signupdata.referrerType);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (SignupData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
