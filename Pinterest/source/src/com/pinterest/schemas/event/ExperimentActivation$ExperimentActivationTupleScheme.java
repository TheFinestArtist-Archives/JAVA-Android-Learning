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
//            ExperimentActivation, AppType

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, ExperimentActivation experimentactivation)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(14);
        if (bitset.get(0))
        {
            experimentactivation.time = tprotocol.readI64();
            experimentactivation.setTimeIsSet(true);
        }
        if (bitset.get(1))
        {
            experimentactivation.experimentHash = tprotocol.readString();
            experimentactivation.setExperimentHashIsSet(true);
        }
        if (bitset.get(2))
        {
            experimentactivation.experimentName = tprotocol.readString();
            experimentactivation.setExperimentNameIsSet(true);
        }
        if (bitset.get(3))
        {
            experimentactivation.experimentVersion = tprotocol.readI32();
            experimentactivation.setExperimentVersionIsSet(true);
        }
        if (bitset.get(4))
        {
            experimentactivation.experimentGroup = tprotocol.readString();
            experimentactivation.setExperimentGroupIsSet(true);
        }
        if (bitset.get(5))
        {
            experimentactivation.appType = AppType.findByValue(tprotocol.readI32());
            experimentactivation.setAppTypeIsSet(true);
        }
        if (bitset.get(6))
        {
            experimentactivation.requestId = tprotocol.readString();
            experimentactivation.setRequestIdIsSet(true);
        }
        if (bitset.get(7))
        {
            experimentactivation.userId = tprotocol.readI64();
            experimentactivation.setUserIdIsSet(true);
        }
        if (bitset.get(8))
        {
            experimentactivation.sessionId = tprotocol.readString();
            experimentactivation.setSessionIdIsSet(true);
        }
        if (bitset.get(9))
        {
            experimentactivation.country = tprotocol.readString();
            experimentactivation.setCountryIsSet(true);
        }
        if (bitset.get(10))
        {
            experimentactivation.ipAddress = tprotocol.readString();
            experimentactivation.setIpAddressIsSet(true);
        }
        if (bitset.get(11))
        {
            experimentactivation.uniqueId = tprotocol.readString();
            experimentactivation.setUniqueIdIsSet(true);
        }
        if (bitset.get(12))
        {
            experimentactivation.experimentInfo = tprotocol.readString();
            experimentactivation.setExperimentInfoIsSet(true);
        }
        if (bitset.get(13))
        {
            experimentactivation.contextInfo = tprotocol.readString();
            experimentactivation.setContextInfoIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (ExperimentActivation)tbase);
    }

    public void write(TProtocol tprotocol, ExperimentActivation experimentactivation)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (experimentactivation.isSetTime())
        {
            bitset.set(0);
        }
        if (experimentactivation.isSetExperimentHash())
        {
            bitset.set(1);
        }
        if (experimentactivation.isSetExperimentName())
        {
            bitset.set(2);
        }
        if (experimentactivation.isSetExperimentVersion())
        {
            bitset.set(3);
        }
        if (experimentactivation.isSetExperimentGroup())
        {
            bitset.set(4);
        }
        if (experimentactivation.isSetAppType())
        {
            bitset.set(5);
        }
        if (experimentactivation.isSetRequestId())
        {
            bitset.set(6);
        }
        if (experimentactivation.isSetUserId())
        {
            bitset.set(7);
        }
        if (experimentactivation.isSetSessionId())
        {
            bitset.set(8);
        }
        if (experimentactivation.isSetCountry())
        {
            bitset.set(9);
        }
        if (experimentactivation.isSetIpAddress())
        {
            bitset.set(10);
        }
        if (experimentactivation.isSetUniqueId())
        {
            bitset.set(11);
        }
        if (experimentactivation.isSetExperimentInfo())
        {
            bitset.set(12);
        }
        if (experimentactivation.isSetContextInfo())
        {
            bitset.set(13);
        }
        tprotocol.writeBitSet(bitset, 14);
        if (experimentactivation.isSetTime())
        {
            tprotocol.writeI64(experimentactivation.time);
        }
        if (experimentactivation.isSetExperimentHash())
        {
            tprotocol.writeString(experimentactivation.experimentHash);
        }
        if (experimentactivation.isSetExperimentName())
        {
            tprotocol.writeString(experimentactivation.experimentName);
        }
        if (experimentactivation.isSetExperimentVersion())
        {
            tprotocol.writeI32(experimentactivation.experimentVersion);
        }
        if (experimentactivation.isSetExperimentGroup())
        {
            tprotocol.writeString(experimentactivation.experimentGroup);
        }
        if (experimentactivation.isSetAppType())
        {
            tprotocol.writeI32(experimentactivation.appType.getValue());
        }
        if (experimentactivation.isSetRequestId())
        {
            tprotocol.writeString(experimentactivation.requestId);
        }
        if (experimentactivation.isSetUserId())
        {
            tprotocol.writeI64(experimentactivation.userId);
        }
        if (experimentactivation.isSetSessionId())
        {
            tprotocol.writeString(experimentactivation.sessionId);
        }
        if (experimentactivation.isSetCountry())
        {
            tprotocol.writeString(experimentactivation.country);
        }
        if (experimentactivation.isSetIpAddress())
        {
            tprotocol.writeString(experimentactivation.ipAddress);
        }
        if (experimentactivation.isSetUniqueId())
        {
            tprotocol.writeString(experimentactivation.uniqueId);
        }
        if (experimentactivation.isSetExperimentInfo())
        {
            tprotocol.writeString(experimentactivation.experimentInfo);
        }
        if (experimentactivation.isSetContextInfo())
        {
            tprotocol.writeString(experimentactivation.contextInfo);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (ExperimentActivation)tbase);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
