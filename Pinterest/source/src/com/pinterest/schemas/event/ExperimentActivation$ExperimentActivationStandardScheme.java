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
//            ExperimentActivation, AppType

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, ExperimentActivation experimentactivation)
    {
        tprotocol.readStructBegin();
_L17:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        tfield.id;
        JVM INSTR tableswitch 1 14: default 92
    //                   1 107
    //                   2 143
    //                   3 179
    //                   4 215
    //                   5 251
    //                   6 287
    //                   7 326
    //                   8 362
    //                   9 398
    //                   10 434
    //                   11 470
    //                   12 506
    //                   13 542
    //                   14 578;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L15:
        break MISSING_BLOCK_LABEL_578;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L18:
        tprotocol.readFieldEnd();
        if (true) goto _L17; else goto _L16
_L16:
        if (tfield.type == 10)
        {
            experimentactivation.time = tprotocol.readI64();
            experimentactivation.setTimeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L3:
        if (tfield.type == 11)
        {
            experimentactivation.experimentHash = tprotocol.readString();
            experimentactivation.setExperimentHashIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L4:
        if (tfield.type == 11)
        {
            experimentactivation.experimentName = tprotocol.readString();
            experimentactivation.setExperimentNameIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L5:
        if (tfield.type == 8)
        {
            experimentactivation.experimentVersion = tprotocol.readI32();
            experimentactivation.setExperimentVersionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L6:
        if (tfield.type == 11)
        {
            experimentactivation.experimentGroup = tprotocol.readString();
            experimentactivation.setExperimentGroupIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L7:
        if (tfield.type == 8)
        {
            experimentactivation.appType = AppType.findByValue(tprotocol.readI32());
            experimentactivation.setAppTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L8:
        if (tfield.type == 11)
        {
            experimentactivation.requestId = tprotocol.readString();
            experimentactivation.setRequestIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L9:
        if (tfield.type == 10)
        {
            experimentactivation.userId = tprotocol.readI64();
            experimentactivation.setUserIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L10:
        if (tfield.type == 11)
        {
            experimentactivation.sessionId = tprotocol.readString();
            experimentactivation.setSessionIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L11:
        if (tfield.type == 11)
        {
            experimentactivation.country = tprotocol.readString();
            experimentactivation.setCountryIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L12:
        if (tfield.type == 11)
        {
            experimentactivation.ipAddress = tprotocol.readString();
            experimentactivation.setIpAddressIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L13:
        if (tfield.type == 11)
        {
            experimentactivation.uniqueId = tprotocol.readString();
            experimentactivation.setUniqueIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
_L14:
        if (tfield.type == 11)
        {
            experimentactivation.experimentInfo = tprotocol.readString();
            experimentactivation.setExperimentInfoIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
        if (tfield.type == 11)
        {
            experimentactivation.contextInfo = tprotocol.readString();
            experimentactivation.setContextInfoIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L18
        tprotocol.readStructEnd();
        experimentactivation.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ExperimentActivation)tbase);
    }

    public void write(TProtocol tprotocol, ExperimentActivation experimentactivation)
    {
        experimentactivation.validate();
        tprotocol.writeStructBegin(ExperimentActivation.access$300());
        tprotocol.writeFieldBegin(ExperimentActivation.access$400());
        tprotocol.writeI64(experimentactivation.time);
        tprotocol.writeFieldEnd();
        if (experimentactivation.experimentHash != null)
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$500());
            tprotocol.writeString(experimentactivation.experimentHash);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.experimentName != null)
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$600());
            tprotocol.writeString(experimentactivation.experimentName);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(ExperimentActivation.access$700());
        tprotocol.writeI32(experimentactivation.experimentVersion);
        tprotocol.writeFieldEnd();
        if (experimentactivation.experimentGroup != null)
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$800());
            tprotocol.writeString(experimentactivation.experimentGroup);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.appType != null && experimentactivation.isSetAppType())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$900());
            tprotocol.writeI32(experimentactivation.appType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.requestId != null && experimentactivation.isSetRequestId())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1000());
            tprotocol.writeString(experimentactivation.requestId);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.isSetUserId())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1100());
            tprotocol.writeI64(experimentactivation.userId);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.sessionId != null && experimentactivation.isSetSessionId())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1200());
            tprotocol.writeString(experimentactivation.sessionId);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.country != null && experimentactivation.isSetCountry())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1300());
            tprotocol.writeString(experimentactivation.country);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.ipAddress != null && experimentactivation.isSetIpAddress())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1400());
            tprotocol.writeString(experimentactivation.ipAddress);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.uniqueId != null && experimentactivation.isSetUniqueId())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1500());
            tprotocol.writeString(experimentactivation.uniqueId);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.experimentInfo != null && experimentactivation.isSetExperimentInfo())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1600());
            tprotocol.writeString(experimentactivation.experimentInfo);
            tprotocol.writeFieldEnd();
        }
        if (experimentactivation.contextInfo != null && experimentactivation.isSetContextInfo())
        {
            tprotocol.writeFieldBegin(ExperimentActivation.access$1700());
            tprotocol.writeString(experimentactivation.contextInfo);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ExperimentActivation)tbase);
    }

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }
}
