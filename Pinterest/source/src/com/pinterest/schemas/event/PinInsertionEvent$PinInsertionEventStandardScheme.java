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
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            PinInsertionEvent, PinInsertion, PinViewType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
    {
        tprotocol.readStructBegin();
_L9:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 6: default 60
    //                   1 75
    //                   2 111
    //                   3 147
    //                   4 247
    //                   5 283
    //                   6 322;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_322;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
        tprotocol.readFieldEnd();
        if (true) goto _L9; else goto _L8
_L8:
        if (((TField) (obj)).type == 10)
        {
            pininsertionevent.timestamp = tprotocol.readI64();
            pininsertionevent.setTimestampIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L3:
        if (((TField) (obj)).type == 11)
        {
            pininsertionevent.requestId = tprotocol.readBinary();
            pininsertionevent.setRequestIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L4:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            pininsertionevent.insertions = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                PinInsertion pininsertion = new PinInsertion();
                pininsertion.read(tprotocol);
                pininsertionevent.insertions.add(pininsertion);
            }

            tprotocol.readListEnd();
            pininsertionevent.setInsertionsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L5:
        if (((TField) (obj)).type == 10)
        {
            pininsertionevent.userId = tprotocol.readI64();
            pininsertionevent.setUserIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L6:
        if (((TField) (obj)).type == 8)
        {
            pininsertionevent.viewType = PinViewType.findByValue(tprotocol.readI32());
            pininsertionevent.setViewTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        if (((TField) (obj)).type == 11)
        {
            pininsertionevent.term = tprotocol.readString();
            pininsertionevent.setTermIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        tprotocol.readStructEnd();
        if (!pininsertionevent.isSetTimestamp())
        {
            throw new TProtocolException((new StringBuilder("Required field 'timestamp' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            pininsertionevent.validate();
            return;
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PinInsertionEvent)tbase);
    }

    public void write(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
    {
        pininsertionevent.validate();
        tprotocol.writeStructBegin(PinInsertionEvent.access$300());
        tprotocol.writeFieldBegin(PinInsertionEvent.access$400());
        tprotocol.writeI64(pininsertionevent.timestamp);
        tprotocol.writeFieldEnd();
        if (pininsertionevent.requestId != null)
        {
            tprotocol.writeFieldBegin(PinInsertionEvent.access$500());
            tprotocol.writeBinary(pininsertionevent.requestId);
            tprotocol.writeFieldEnd();
        }
        if (pininsertionevent.insertions != null)
        {
            tprotocol.writeFieldBegin(PinInsertionEvent.access$600());
            tprotocol.writeListBegin(new TList((byte)12, pininsertionevent.insertions.size()));
            for (Iterator iterator = pininsertionevent.insertions.iterator(); iterator.hasNext(); ((PinInsertion)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (pininsertionevent.isSetUserId())
        {
            tprotocol.writeFieldBegin(PinInsertionEvent.access$700());
            tprotocol.writeI64(pininsertionevent.userId);
            tprotocol.writeFieldEnd();
        }
        if (pininsertionevent.viewType != null && pininsertionevent.isSetViewType())
        {
            tprotocol.writeFieldBegin(PinInsertionEvent.access$800());
            tprotocol.writeI32(pininsertionevent.viewType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (pininsertionevent.term != null && pininsertionevent.isSetTerm())
        {
            tprotocol.writeFieldBegin(PinInsertionEvent.access$900());
            tprotocol.writeString(pininsertionevent.term);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PinInsertionEvent)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
