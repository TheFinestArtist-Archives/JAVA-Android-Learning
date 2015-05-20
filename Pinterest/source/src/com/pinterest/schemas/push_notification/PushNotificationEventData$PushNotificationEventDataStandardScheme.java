// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.push_notification;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.push_notification:
//            PushNetworkType, PushNotificationEventData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
    {
        tprotocol.readStructBegin();
_L11:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        tfield.id;
        JVM INSTR tableswitch 1 8: default 68
    //                   1 83
    //                   2 122
    //                   3 158
    //                   4 194
    //                   5 230
    //                   6 266
    //                   7 302
    //                   8 338;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_338;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L12:
        tprotocol.readFieldEnd();
        if (true) goto _L11; else goto _L10
_L10:
        if (tfield.type == 8)
        {
            pushnotificationeventdata.pushNetworkType = PushNetworkType.findByValue(tprotocol.readI32());
            pushnotificationeventdata.setPushNetworkTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L3:
        if (tfield.type == 11)
        {
            pushnotificationeventdata.pushId = tprotocol.readString();
            pushnotificationeventdata.setPushIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L4:
        if (tfield.type == 11)
        {
            pushnotificationeventdata.body = tprotocol.readString();
            pushnotificationeventdata.setBodyIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L5:
        if (tfield.type == 11)
        {
            pushnotificationeventdata.link = tprotocol.readString();
            pushnotificationeventdata.setLinkIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L6:
        if (tfield.type == 10)
        {
            pushnotificationeventdata.actorId = tprotocol.readI64();
            pushnotificationeventdata.setActorIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L7:
        if (tfield.type == 11)
        {
            pushnotificationeventdata.deviceId = tprotocol.readString();
            pushnotificationeventdata.setDeviceIdIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
_L8:
        if (tfield.type == 11)
        {
            pushnotificationeventdata.pushToken = tprotocol.readString();
            pushnotificationeventdata.setPushTokenIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
        if (tfield.type == 8)
        {
            pushnotificationeventdata.actionType = tprotocol.readI32();
            pushnotificationeventdata.setActionTypeIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L12
        tprotocol.readStructEnd();
        pushnotificationeventdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PushNotificationEventData)tbase);
    }

    public void write(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
    {
        pushnotificationeventdata.validate();
        tprotocol.writeStructBegin(PushNotificationEventData.access$300());
        if (pushnotificationeventdata.pushNetworkType != null)
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$400());
            tprotocol.writeI32(pushnotificationeventdata.pushNetworkType.getValue());
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.pushId != null)
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$500());
            tprotocol.writeString(pushnotificationeventdata.pushId);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.body != null)
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$600());
            tprotocol.writeString(pushnotificationeventdata.body);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.link != null)
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$700());
            tprotocol.writeString(pushnotificationeventdata.link);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.isSetActorId())
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$800());
            tprotocol.writeI64(pushnotificationeventdata.actorId);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.deviceId != null && pushnotificationeventdata.isSetDeviceId())
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$900());
            tprotocol.writeString(pushnotificationeventdata.deviceId);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.pushToken != null && pushnotificationeventdata.isSetPushToken())
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$1000());
            tprotocol.writeString(pushnotificationeventdata.pushToken);
            tprotocol.writeFieldEnd();
        }
        if (pushnotificationeventdata.isSetActionType())
        {
            tprotocol.writeFieldBegin(PushNotificationEventData.access$1100());
            tprotocol.writeI32(pushnotificationeventdata.actionType);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (PushNotificationEventData)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
