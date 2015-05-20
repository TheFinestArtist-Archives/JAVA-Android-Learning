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
//            PhantomServiceSettings, PhantomImageSettings

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(7);
        if (bitset.get(0))
        {
            phantomservicesettings.image = tprotocol.readBool();
            phantomservicesettings.setImageIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomservicesettings.imageSettings = new PhantomImageSettings();
            phantomservicesettings.imageSettings.read(tprotocol);
            phantomservicesettings.setImageSettingsIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomservicesettings.redirectUrl = tprotocol.readBool();
            phantomservicesettings.setRedirectUrlIsSet(true);
        }
        if (bitset.get(3))
        {
            phantomservicesettings.redirectHeaders = tprotocol.readBool();
            phantomservicesettings.setRedirectHeadersIsSet(true);
        }
        if (bitset.get(4))
        {
            phantomservicesettings.redirectBody = tprotocol.readBool();
            phantomservicesettings.setRedirectBodyIsSet(true);
        }
        if (bitset.get(5))
        {
            phantomservicesettings.maxTimeOut = tprotocol.readI16();
            phantomservicesettings.setMaxTimeOutIsSet(true);
        }
        if (bitset.get(6))
        {
            phantomservicesettings.rawResult = tprotocol.readBool();
            phantomservicesettings.setRawResultIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomServiceSettings)tbase);
    }

    public void write(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomservicesettings.isSetImage())
        {
            bitset.set(0);
        }
        if (phantomservicesettings.isSetImageSettings())
        {
            bitset.set(1);
        }
        if (phantomservicesettings.isSetRedirectUrl())
        {
            bitset.set(2);
        }
        if (phantomservicesettings.isSetRedirectHeaders())
        {
            bitset.set(3);
        }
        if (phantomservicesettings.isSetRedirectBody())
        {
            bitset.set(4);
        }
        if (phantomservicesettings.isSetMaxTimeOut())
        {
            bitset.set(5);
        }
        if (phantomservicesettings.isSetRawResult())
        {
            bitset.set(6);
        }
        tprotocol.writeBitSet(bitset, 7);
        if (phantomservicesettings.isSetImage())
        {
            tprotocol.writeBool(phantomservicesettings.image);
        }
        if (phantomservicesettings.isSetImageSettings())
        {
            phantomservicesettings.imageSettings.write(tprotocol);
        }
        if (phantomservicesettings.isSetRedirectUrl())
        {
            tprotocol.writeBool(phantomservicesettings.redirectUrl);
        }
        if (phantomservicesettings.isSetRedirectHeaders())
        {
            tprotocol.writeBool(phantomservicesettings.redirectHeaders);
        }
        if (phantomservicesettings.isSetRedirectBody())
        {
            tprotocol.writeBool(phantomservicesettings.redirectBody);
        }
        if (phantomservicesettings.isSetMaxTimeOut())
        {
            tprotocol.writeI16(phantomservicesettings.maxTimeOut);
        }
        if (phantomservicesettings.isSetRawResult())
        {
            tprotocol.writeBool(phantomservicesettings.rawResult);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomServiceSettings)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
