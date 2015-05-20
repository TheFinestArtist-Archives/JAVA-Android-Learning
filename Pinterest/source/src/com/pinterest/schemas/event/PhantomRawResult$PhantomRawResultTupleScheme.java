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
//            PhantomRawResult, PhantomRedirectResult

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PhantomRawResult phantomrawresult)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(5);
        if (bitset.get(0))
        {
            phantomrawresult.baseUrl = tprotocol.readString();
            phantomrawresult.setBaseUrlIsSet(true);
        }
        if (bitset.get(1))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            phantomrawresult.redirectList = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                PhantomRedirectResult phantomredirectresult = new PhantomRedirectResult();
                phantomredirectresult.read(tprotocol);
                phantomrawresult.redirectList.add(phantomredirectresult);
            }

            phantomrawresult.setRedirectListIsSet(true);
        }
        if (bitset.get(2))
        {
            phantomrawresult.base64Image = tprotocol.readString();
            phantomrawresult.setBase64ImageIsSet(true);
        }
        if (bitset.get(3))
        {
            phantomrawresult.completed = tprotocol.readBool();
            phantomrawresult.setCompletedIsSet(true);
        }
        if (bitset.get(4))
        {
            phantomrawresult.message = tprotocol.readString();
            phantomrawresult.setMessageIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomRawResult)tbase);
    }

    public void write(TProtocol tprotocol, PhantomRawResult phantomrawresult)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (phantomrawresult.isSetBaseUrl())
        {
            bitset.set(0);
        }
        if (phantomrawresult.isSetRedirectList())
        {
            bitset.set(1);
        }
        if (phantomrawresult.isSetBase64Image())
        {
            bitset.set(2);
        }
        if (phantomrawresult.isSetCompleted())
        {
            bitset.set(3);
        }
        if (phantomrawresult.isSetMessage())
        {
            bitset.set(4);
        }
        tprotocol.writeBitSet(bitset, 5);
        if (phantomrawresult.isSetBaseUrl())
        {
            tprotocol.writeString(phantomrawresult.baseUrl);
        }
        if (phantomrawresult.isSetRedirectList())
        {
            tprotocol.writeI32(phantomrawresult.redirectList.size());
            for (Iterator iterator = phantomrawresult.redirectList.iterator(); iterator.hasNext(); ((PhantomRedirectResult)iterator.next()).write(tprotocol)) { }
        }
        if (phantomrawresult.isSetBase64Image())
        {
            tprotocol.writeString(phantomrawresult.base64Image);
        }
        if (phantomrawresult.isSetCompleted())
        {
            tprotocol.writeBool(phantomrawresult.completed);
        }
        if (phantomrawresult.isSetMessage())
        {
            tprotocol.writeString(phantomrawresult.message);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PhantomRawResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
