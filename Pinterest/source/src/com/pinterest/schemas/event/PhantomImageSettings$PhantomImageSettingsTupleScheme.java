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
//            PhantomClipRect, PhantomImageSettings

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(2);
        if (bitset.get(0))
        {
            phantomimagesettings.clipRect = new PhantomClipRect();
            phantomimagesettings.clipRect.read(tprotocol);
            phantomimagesettings.setClipRectIsSet(true);
        }
        if (bitset.get(1))
        {
            phantomimagesettings.loadImages = tprotocol.readBool();
            phantomimagesettings.setLoadImagesIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomImageSettings)tbase);
    }

    public void write(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomimagesettings.isSetClipRect())
        {
            bitset.set(0);
        }
        if (phantomimagesettings.isSetLoadImages())
        {
            bitset.set(1);
        }
        tprotocol.writeBitSet(bitset, 2);
        if (phantomimagesettings.isSetClipRect())
        {
            phantomimagesettings.clipRect.write(tprotocol);
        }
        if (phantomimagesettings.isSetLoadImages())
        {
            tprotocol.writeBool(phantomimagesettings.loadImages);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomImageSettings)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
