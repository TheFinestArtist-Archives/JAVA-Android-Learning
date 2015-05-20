// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import com.pinterest.schemas.email_queued.QueuedEmailEvent;
import com.pinterest.schemas.push_notification.PushNotificationEventData;
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
//            TestData, EventData, SpamServiceRequest, SignupData, 
//            OffsiteServiceResult, PhantomServiceResult, TripwireData, PinImpression, 
//            InterestImpressionData, BrowserIdData, InsertionData

class <init> extends TupleScheme
{

    public void read(TProtocol tprotocol, EventData eventdata)
    {
        int i = 0;
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = tprotocol.readBitSet(16);
        if (bitset.get(0))
        {
            eventdata.testData = new TestData();
            eventdata.testData.read(tprotocol);
            eventdata.setTestDataIsSet(true);
        }
        if (bitset.get(1))
        {
            eventdata.email = new QueuedEmailEvent();
            eventdata.email.read(tprotocol);
            eventdata.setEmailIsSet(true);
        }
        if (bitset.get(2))
        {
            eventdata.json = tprotocol.readString();
            eventdata.setJsonIsSet(true);
        }
        if (bitset.get(3))
        {
            eventdata.spamRequest = new SpamServiceRequest();
            eventdata.spamRequest.read(tprotocol);
            eventdata.setSpamRequestIsSet(true);
        }
        if (bitset.get(4))
        {
            eventdata.push = new PushNotificationEventData();
            eventdata.push.read(tprotocol);
            eventdata.setPushIsSet(true);
        }
        if (bitset.get(5))
        {
            eventdata.signup = new SignupData();
            eventdata.signup.read(tprotocol);
            eventdata.setSignupIsSet(true);
        }
        if (bitset.get(6))
        {
            eventdata.offsiteResult = new OffsiteServiceResult();
            eventdata.offsiteResult.read(tprotocol);
            eventdata.setOffsiteResultIsSet(true);
        }
        if (bitset.get(7))
        {
            eventdata.phantomResult = new PhantomServiceResult();
            eventdata.phantomResult.read(tprotocol);
            eventdata.setPhantomResultIsSet(true);
        }
        if (bitset.get(8))
        {
            eventdata.completedCaptcha = tprotocol.readBool();
            eventdata.setCompletedCaptchaIsSet(true);
        }
        if (bitset.get(9))
        {
            eventdata.tripwireData = new TripwireData();
            eventdata.tripwireData.read(tprotocol);
            eventdata.setTripwireDataIsSet(true);
        }
        if (bitset.get(10))
        {
            TList tlist = new TList((byte)12, tprotocol.readI32());
            eventdata.pinImpressions = new ArrayList(tlist.size);
            for (; i < tlist.size; i++)
            {
                PinImpression pinimpression = new PinImpression();
                pinimpression.read(tprotocol);
                eventdata.pinImpressions.add(pinimpression);
            }

            eventdata.setPinImpressionsIsSet(true);
        }
        if (bitset.get(11))
        {
            eventdata.enforceSpamRules = tprotocol.readBool();
            eventdata.setEnforceSpamRulesIsSet(true);
        }
        if (bitset.get(12))
        {
            eventdata.adminOverride = tprotocol.readBool();
            eventdata.setAdminOverrideIsSet(true);
        }
        if (bitset.get(13))
        {
            eventdata.interestImpressionData = new InterestImpressionData();
            eventdata.interestImpressionData.read(tprotocol);
            eventdata.setInterestImpressionDataIsSet(true);
        }
        if (bitset.get(14))
        {
            eventdata.browserIdData = new BrowserIdData();
            eventdata.browserIdData.read(tprotocol);
            eventdata.setBrowserIdDataIsSet(true);
        }
        if (bitset.get(15))
        {
            eventdata.insertion = new InsertionData();
            eventdata.insertion.read(tprotocol);
            eventdata.setInsertionIsSet(true);
        }
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (EventData)tbase);
    }

    public void write(TProtocol tprotocol, EventData eventdata)
    {
        tprotocol = (TTupleProtocol)tprotocol;
        BitSet bitset = new BitSet();
        if (eventdata.isSetTestData())
        {
            bitset.set(0);
        }
        if (eventdata.isSetEmail())
        {
            bitset.set(1);
        }
        if (eventdata.isSetJson())
        {
            bitset.set(2);
        }
        if (eventdata.isSetSpamRequest())
        {
            bitset.set(3);
        }
        if (eventdata.isSetPush())
        {
            bitset.set(4);
        }
        if (eventdata.isSetSignup())
        {
            bitset.set(5);
        }
        if (eventdata.isSetOffsiteResult())
        {
            bitset.set(6);
        }
        if (eventdata.isSetPhantomResult())
        {
            bitset.set(7);
        }
        if (eventdata.isSetCompletedCaptcha())
        {
            bitset.set(8);
        }
        if (eventdata.isSetTripwireData())
        {
            bitset.set(9);
        }
        if (eventdata.isSetPinImpressions())
        {
            bitset.set(10);
        }
        if (eventdata.isSetEnforceSpamRules())
        {
            bitset.set(11);
        }
        if (eventdata.isSetAdminOverride())
        {
            bitset.set(12);
        }
        if (eventdata.isSetInterestImpressionData())
        {
            bitset.set(13);
        }
        if (eventdata.isSetBrowserIdData())
        {
            bitset.set(14);
        }
        if (eventdata.isSetInsertion())
        {
            bitset.set(15);
        }
        tprotocol.writeBitSet(bitset, 16);
        if (eventdata.isSetTestData())
        {
            eventdata.testData.write(tprotocol);
        }
        if (eventdata.isSetEmail())
        {
            eventdata.email.write(tprotocol);
        }
        if (eventdata.isSetJson())
        {
            tprotocol.writeString(eventdata.json);
        }
        if (eventdata.isSetSpamRequest())
        {
            eventdata.spamRequest.write(tprotocol);
        }
        if (eventdata.isSetPush())
        {
            eventdata.push.write(tprotocol);
        }
        if (eventdata.isSetSignup())
        {
            eventdata.signup.write(tprotocol);
        }
        if (eventdata.isSetOffsiteResult())
        {
            eventdata.offsiteResult.write(tprotocol);
        }
        if (eventdata.isSetPhantomResult())
        {
            eventdata.phantomResult.write(tprotocol);
        }
        if (eventdata.isSetCompletedCaptcha())
        {
            tprotocol.writeBool(eventdata.completedCaptcha);
        }
        if (eventdata.isSetTripwireData())
        {
            eventdata.tripwireData.write(tprotocol);
        }
        if (eventdata.isSetPinImpressions())
        {
            tprotocol.writeI32(eventdata.pinImpressions.size());
            for (Iterator iterator = eventdata.pinImpressions.iterator(); iterator.hasNext(); ((PinImpression)iterator.next()).write(tprotocol)) { }
        }
        if (eventdata.isSetEnforceSpamRules())
        {
            tprotocol.writeBool(eventdata.enforceSpamRules);
        }
        if (eventdata.isSetAdminOverride())
        {
            tprotocol.writeBool(eventdata.adminOverride);
        }
        if (eventdata.isSetInterestImpressionData())
        {
            eventdata.interestImpressionData.write(tprotocol);
        }
        if (eventdata.isSetBrowserIdData())
        {
            eventdata.browserIdData.write(tprotocol);
        }
        if (eventdata.isSetInsertion())
        {
            eventdata.insertion.write(tprotocol);
        }
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (EventData)tbase);
    }

    private ntData()
    {
    }

    ntData(ntData ntdata)
    {
        this();
    }
}
