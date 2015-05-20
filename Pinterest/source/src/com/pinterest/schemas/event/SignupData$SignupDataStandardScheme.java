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
//            SignupData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, SignupData signupdata)
    {
        tprotocol.readStructBegin();
_L8:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        tfield.id;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 71
    //                   2 107
    //                   3 143
    //                   4 179
    //                   5 215;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_215;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
        tprotocol.readFieldEnd();
        if (true) goto _L8; else goto _L7
_L7:
        if (tfield.type == 11)
        {
            signupdata.via = tprotocol.readString();
            signupdata.setViaIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L3:
        if (tfield.type == 11)
        {
            signupdata.medium = tprotocol.readString();
            signupdata.setMediumIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L4:
        if (tfield.type == 11)
        {
            signupdata.socialId = tprotocol.readString();
            signupdata.setSocialIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
_L5:
        if (tfield.type == 11)
        {
            signupdata.userAgent = tprotocol.readString();
            signupdata.setUserAgentIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        if (tfield.type == 11)
        {
            signupdata.referrerType = tprotocol.readString();
            signupdata.setReferrerTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L9
        tprotocol.readStructEnd();
        signupdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (SignupData)tbase);
    }

    public void write(TProtocol tprotocol, SignupData signupdata)
    {
        signupdata.validate();
        tprotocol.writeStructBegin(SignupData.access$300());
        if (signupdata.via != null)
        {
            tprotocol.writeFieldBegin(SignupData.access$400());
            tprotocol.writeString(signupdata.via);
            tprotocol.writeFieldEnd();
        }
        if (signupdata.medium != null)
        {
            tprotocol.writeFieldBegin(SignupData.access$500());
            tprotocol.writeString(signupdata.medium);
            tprotocol.writeFieldEnd();
        }
        if (signupdata.socialId != null)
        {
            tprotocol.writeFieldBegin(SignupData.access$600());
            tprotocol.writeString(signupdata.socialId);
            tprotocol.writeFieldEnd();
        }
        if (signupdata.userAgent != null)
        {
            tprotocol.writeFieldBegin(SignupData.access$700());
            tprotocol.writeString(signupdata.userAgent);
            tprotocol.writeFieldEnd();
        }
        if (signupdata.referrerType != null)
        {
            tprotocol.writeFieldBegin(SignupData.access$800());
            tprotocol.writeString(signupdata.referrerType);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
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
