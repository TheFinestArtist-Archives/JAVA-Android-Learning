// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.push_notification;

import java.util.BitSet;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package com.pinterest.schemas.push_notification:
//            PushNetworkType, PushNotificationEventData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(8);
        if (bitset.get(0))
        {
            pushnotificationeventdata.pushNetworkType = PushNetworkType.findByValue(tprotocol.readI32());
            pushnotificationeventdata.setPushNetworkTypeIsSet(true);
        }
        if (bitset.get(1))
        {
            pushnotificationeventdata.pushId = tprotocol.readString();
            pushnotificationeventdata.setPushIdIsSet(true);
        }
        if (bitset.get(2))
        {
            pushnotificationeventdata.body = tprotocol.readString();
            pushnotificationeventdata.setBodyIsSet(true);
        }
        if (bitset.get(3))
        {
            pushnotificationeventdata.link = tprotocol.readString();
            pushnotificationeventdata.setLinkIsSet(true);
        }
        if (bitset.get(4))
        {
            pushnotificationeventdata.actorId = tprotocol.readI64();
            pushnotificationeventdata.setActorIdIsSet(true);
        }
        if (bitset.get(5))
        {
            pushnotificationeventdata.deviceId = tprotocol.readString();
            pushnotificationeventdata.setDeviceIdIsSet(true);
        }
        if (bitset.get(6))
        {
            pushnotificationeventdata.pushToken = tprotocol.readString();
            pushnotificationeventdata.setPushTokenIsSet(true);
        }
        if (bitset.get(7))
        {
            pushnotificationeventdata.actionType = tprotocol.readI32();
            pushnotificationeventdata.setActionTypeIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (PushNotificationEventData)tbase);
    }

    public void write(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (pushnotificationeventdata.isSetPushNetworkType())
        {
            bitset.set(0);
        }
        if (pushnotificationeventdata.isSetPushId())
        {
            bitset.set(1);
        }
        if (pushnotificationeventdata.isSetBody())
        {
            bitset.set(2);
        }
        if (pushnotificationeventdata.isSetLink())
        {
            bitset.set(3);
        }
        if (pushnotificationeventdata.isSetActorId())
        {
            bitset.set(4);
        }
        if (pushnotificationeventdata.isSetDeviceId())
        {
            bitset.set(5);
        }
        if (pushnotificationeventdata.isSetPushToken())
        {
            bitset.set(6);
        }
        if (pushnotificationeventdata.isSetActionType())
        {
            bitset.set(7);
        }
        tprotocol.writeBitSet(bitset, 8);
        if (pushnotificationeventdata.isSetPushNetworkType())
        {
            tprotocol.writeI32(pushnotificationeventdata.pushNetworkType.getValue());
        }
        if (pushnotificationeventdata.isSetPushId())
        {
            tprotocol.writeString(pushnotificationeventdata.pushId);
        }
        if (pushnotificationeventdata.isSetBody())
        {
            tprotocol.writeString(pushnotificationeventdata.body);
        }
        if (pushnotificationeventdata.isSetLink())
        {
            tprotocol.writeString(pushnotificationeventdata.link);
        }
        if (pushnotificationeventdata.isSetActorId())
        {
            tprotocol.writeI64(pushnotificationeventdata.actorId);
        }
        if (pushnotificationeventdata.isSetDeviceId())
        {
            tprotocol.writeString(pushnotificationeventdata.deviceId);
        }
        if (pushnotificationeventdata.isSetPushToken())
        {
            tprotocol.writeString(pushnotificationeventdata.pushToken);
        }
        if (pushnotificationeventdata.isSetActionType())
        {
            tprotocol.writeI32(pushnotificationeventdata.actionType);
        }
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
