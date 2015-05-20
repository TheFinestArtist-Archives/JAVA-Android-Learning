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
//            PhantomServiceSettings, PhantomImageSettings

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
    {
        tprotocol.readStructBegin();
_L10:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        tfield.id;
        JVM INSTR tableswitch 1 7: default 64
    //                   1 79
    //                   2 114
    //                   3 161
    //                   4 196
    //                   5 231
    //                   6 266
    //                   7 302;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_302;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L11:
        tprotocol.readFieldEnd();
        if (true) goto _L10; else goto _L9
_L9:
        if (tfield.type == 2)
        {
            phantomservicesettings.image = tprotocol.readBool();
            phantomservicesettings.setImageIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L3:
        if (tfield.type == 12)
        {
            phantomservicesettings.imageSettings = new PhantomImageSettings();
            phantomservicesettings.imageSettings.read(tprotocol);
            phantomservicesettings.setImageSettingsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L4:
        if (tfield.type == 2)
        {
            phantomservicesettings.redirectUrl = tprotocol.readBool();
            phantomservicesettings.setRedirectUrlIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L5:
        if (tfield.type == 2)
        {
            phantomservicesettings.redirectHeaders = tprotocol.readBool();
            phantomservicesettings.setRedirectHeadersIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L6:
        if (tfield.type == 2)
        {
            phantomservicesettings.redirectBody = tprotocol.readBool();
            phantomservicesettings.setRedirectBodyIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
_L7:
        if (tfield.type == 6)
        {
            phantomservicesettings.maxTimeOut = tprotocol.readI16();
            phantomservicesettings.setMaxTimeOutIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        if (tfield.type == 2)
        {
            phantomservicesettings.rawResult = tprotocol.readBool();
            phantomservicesettings.setRawResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L11
        tprotocol.readStructEnd();
        phantomservicesettings.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PhantomServiceSettings)tbase);
    }

    public void write(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
    {
        phantomservicesettings.validate();
        tprotocol.writeStructBegin(PhantomServiceSettings.access$300());
        if (phantomservicesettings.isSetImage())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$400());
            tprotocol.writeBool(phantomservicesettings.image);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.imageSettings != null && phantomservicesettings.isSetImageSettings())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$500());
            phantomservicesettings.imageSettings.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.isSetRedirectUrl())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$600());
            tprotocol.writeBool(phantomservicesettings.redirectUrl);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.isSetRedirectHeaders())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$700());
            tprotocol.writeBool(phantomservicesettings.redirectHeaders);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.isSetRedirectBody())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$800());
            tprotocol.writeBool(phantomservicesettings.redirectBody);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.isSetMaxTimeOut())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$900());
            tprotocol.writeI16(phantomservicesettings.maxTimeOut);
            tprotocol.writeFieldEnd();
        }
        if (phantomservicesettings.isSetRawResult())
        {
            tprotocol.writeFieldBegin(PhantomServiceSettings.access$1000());
            tprotocol.writeBool(phantomservicesettings.rawResult);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
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
