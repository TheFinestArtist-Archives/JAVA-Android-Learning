// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            LimitData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, LimitData limitdata)
    {
        tprotocol.readStructBegin();
_L8:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        tfield.id;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 71
    //                   2 106
    //                   3 141
    //                   4 176
    //                   5 212;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_212;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
        tprotocol.readFieldEnd();
        if (true) goto _L8; else goto _L7
_L7:
        if (tfield.type == 4)
        {
            limitdata.signup_score_v2 = tprotocol.readDouble();
            limitdata.setSignup_score_v2IsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L3:
        if (tfield.type == 4)
        {
            limitdata.signup_score_v1 = tprotocol.readDouble();
            limitdata.setSignup_score_v1IsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L4:
        if (tfield.type == 4)
        {
            limitdata.offsite_score = tprotocol.readDouble();
            limitdata.setOffsite_scoreIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L5:
        if (tfield.type == 11)
        {
            limitdata.sanitized_url = tprotocol.readString();
            limitdata.setSanitized_urlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        if (tfield.type == 4)
        {
            limitdata.signup_score_v3 = tprotocol.readDouble();
            limitdata.setSignup_score_v3IsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        tprotocol.readStructEnd();
        limitdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (LimitData)tbase);
    }

    public void write(TProtocol tprotocol, LimitData limitdata)
    {
        limitdata.validate();
        tprotocol.writeStructBegin(LimitData.access$300());
        if (limitdata.isSetSignup_score_v2())
        {
            tprotocol.writeFieldBegin(LimitData.access$400());
            tprotocol.writeDouble(limitdata.signup_score_v2);
            tprotocol.writeFieldEnd();
        }
        if (limitdata.isSetSignup_score_v1())
        {
            tprotocol.writeFieldBegin(LimitData.access$500());
            tprotocol.writeDouble(limitdata.signup_score_v1);
            tprotocol.writeFieldEnd();
        }
        if (limitdata.isSetOffsite_score())
        {
            tprotocol.writeFieldBegin(LimitData.access$600());
            tprotocol.writeDouble(limitdata.offsite_score);
            tprotocol.writeFieldEnd();
        }
        if (limitdata.sanitized_url != null && limitdata.isSetSanitized_url())
        {
            tprotocol.writeFieldBegin(LimitData.access$700());
            tprotocol.writeString(limitdata.sanitized_url);
            tprotocol.writeFieldEnd();
        }
        if (limitdata.isSetSignup_score_v3())
        {
            tprotocol.writeFieldBegin(LimitData.access$800());
            tprotocol.writeDouble(limitdata.signup_score_v3);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
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
