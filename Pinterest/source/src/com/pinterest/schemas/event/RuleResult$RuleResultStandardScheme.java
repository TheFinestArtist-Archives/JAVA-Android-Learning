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
//            RuleResult, LimitAction

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, RuleResult ruleresult)
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 103
    //                   3 142
    //                   4 178;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_178;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 11)
        {
            ruleresult.rule = tprotocol.readString();
            ruleresult.setRuleIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 8)
        {
            ruleresult.action = LimitAction.findByValue(tprotocol.readI32());
            ruleresult.setActionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 11)
        {
            ruleresult.message = tprotocol.readString();
            ruleresult.setMessageIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 11)
        {
            ruleresult.data = tprotocol.readString();
            ruleresult.setDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        ruleresult.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (RuleResult)tbase);
    }

    public void write(TProtocol tprotocol, RuleResult ruleresult)
    {
        ruleresult.validate();
        tprotocol.writeStructBegin(RuleResult.access$300());
        if (ruleresult.rule != null)
        {
            tprotocol.writeFieldBegin(RuleResult.access$400());
            tprotocol.writeString(ruleresult.rule);
            tprotocol.writeFieldEnd();
        }
        if (ruleresult.action != null)
        {
            tprotocol.writeFieldBegin(RuleResult.access$500());
            tprotocol.writeI32(ruleresult.action.getValue());
            tprotocol.writeFieldEnd();
        }
        if (ruleresult.message != null)
        {
            tprotocol.writeFieldBegin(RuleResult.access$600());
            tprotocol.writeString(ruleresult.message);
            tprotocol.writeFieldEnd();
        }
        if (ruleresult.data != null)
        {
            tprotocol.writeFieldBegin(RuleResult.access$700());
            tprotocol.writeString(ruleresult.data);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (RuleResult)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
