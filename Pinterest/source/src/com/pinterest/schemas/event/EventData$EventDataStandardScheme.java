// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import com.pinterest.schemas.email_queued.QueuedEmailEvent;
import com.pinterest.schemas.push_notification.PushNotificationEventData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.scheme.StandardScheme;

// Referenced classes of package com.pinterest.schemas.event:
//            TestData, EventData, SpamServiceRequest, SignupData, 
//            OffsiteServiceResult, PhantomServiceResult, TripwireData, PinImpression, 
//            InterestImpressionData, BrowserIdData, InsertionData

class <init> extends StandardScheme
{

    public void read(TProtocol tprotocol, EventData eventdata)
    {
        tprotocol.readStructBegin();
_L19:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 16: default 100
    //                   1 115
    //                   2 162
    //                   3 209
    //                   4 245
    //                   5 292
    //                   6 339
    //                   7 386
    //                   8 433
    //                   9 480
    //                   10 515
    //                   11 562
    //                   12 662
    //                   13 697
    //                   14 732
    //                   15 779
    //                   16 826;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_826;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L20:
        tprotocol.readFieldEnd();
        if (true) goto _L19; else goto _L18
_L18:
        if (((TField) (obj)).type == 12)
        {
            eventdata.testData = new TestData();
            eventdata.testData.read(tprotocol);
            eventdata.setTestDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L3:
        if (((TField) (obj)).type == 12)
        {
            eventdata.email = new QueuedEmailEvent();
            eventdata.email.read(tprotocol);
            eventdata.setEmailIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L4:
        if (((TField) (obj)).type == 11)
        {
            eventdata.json = tprotocol.readString();
            eventdata.setJsonIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L5:
        if (((TField) (obj)).type == 12)
        {
            eventdata.spamRequest = new SpamServiceRequest();
            eventdata.spamRequest.read(tprotocol);
            eventdata.setSpamRequestIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L6:
        if (((TField) (obj)).type == 12)
        {
            eventdata.push = new PushNotificationEventData();
            eventdata.push.read(tprotocol);
            eventdata.setPushIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L7:
        if (((TField) (obj)).type == 12)
        {
            eventdata.signup = new SignupData();
            eventdata.signup.read(tprotocol);
            eventdata.setSignupIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L8:
        if (((TField) (obj)).type == 12)
        {
            eventdata.offsiteResult = new OffsiteServiceResult();
            eventdata.offsiteResult.read(tprotocol);
            eventdata.setOffsiteResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L9:
        if (((TField) (obj)).type == 12)
        {
            eventdata.phantomResult = new PhantomServiceResult();
            eventdata.phantomResult.read(tprotocol);
            eventdata.setPhantomResultIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L10:
        if (((TField) (obj)).type == 2)
        {
            eventdata.completedCaptcha = tprotocol.readBool();
            eventdata.setCompletedCaptchaIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L11:
        if (((TField) (obj)).type == 12)
        {
            eventdata.tripwireData = new TripwireData();
            eventdata.tripwireData.read(tprotocol);
            eventdata.setTripwireDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L12:
        if (((TField) (obj)).type == 15)
        {
            obj = tprotocol.readListBegin();
            eventdata.pinImpressions = new ArrayList(((TList) (obj)).size);
            for (int i = 0; i < ((TList) (obj)).size; i++)
            {
                PinImpression pinimpression = new PinImpression();
                pinimpression.read(tprotocol);
                eventdata.pinImpressions.add(pinimpression);
            }

            tprotocol.readListEnd();
            eventdata.setPinImpressionsIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L13:
        if (((TField) (obj)).type == 2)
        {
            eventdata.enforceSpamRules = tprotocol.readBool();
            eventdata.setEnforceSpamRulesIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L14:
        if (((TField) (obj)).type == 2)
        {
            eventdata.adminOverride = tprotocol.readBool();
            eventdata.setAdminOverrideIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L15:
        if (((TField) (obj)).type == 12)
        {
            eventdata.interestImpressionData = new InterestImpressionData();
            eventdata.interestImpressionData.read(tprotocol);
            eventdata.setInterestImpressionDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L16:
        if (((TField) (obj)).type == 12)
        {
            eventdata.browserIdData = new BrowserIdData();
            eventdata.browserIdData.read(tprotocol);
            eventdata.setBrowserIdDataIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
        if (((TField) (obj)).type == 12)
        {
            eventdata.insertion = new InsertionData();
            eventdata.insertion.read(tprotocol);
            eventdata.setInsertionIsSet(true);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
        tprotocol.readStructEnd();
        eventdata.validate();
        return;
    }

    public volatile void read(TProtocol tprotocol, TBase tbase)
    {
        read(tprotocol, (EventData)tbase);
    }

    public void write(TProtocol tprotocol, EventData eventdata)
    {
        eventdata.validate();
        tprotocol.writeStructBegin(EventData.access$300());
        if (eventdata.testData != null && eventdata.isSetTestData())
        {
            tprotocol.writeFieldBegin(EventData.access$400());
            eventdata.testData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.email != null && eventdata.isSetEmail())
        {
            tprotocol.writeFieldBegin(EventData.access$500());
            eventdata.email.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.json != null && eventdata.isSetJson())
        {
            tprotocol.writeFieldBegin(EventData.access$600());
            tprotocol.writeString(eventdata.json);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.spamRequest != null && eventdata.isSetSpamRequest())
        {
            tprotocol.writeFieldBegin(EventData.access$700());
            eventdata.spamRequest.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.push != null && eventdata.isSetPush())
        {
            tprotocol.writeFieldBegin(EventData.access$800());
            eventdata.push.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.signup != null && eventdata.isSetSignup())
        {
            tprotocol.writeFieldBegin(EventData.access$900());
            eventdata.signup.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.offsiteResult != null && eventdata.isSetOffsiteResult())
        {
            tprotocol.writeFieldBegin(EventData.access$1000());
            eventdata.offsiteResult.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.phantomResult != null && eventdata.isSetPhantomResult())
        {
            tprotocol.writeFieldBegin(EventData.access$1100());
            eventdata.phantomResult.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.isSetCompletedCaptcha())
        {
            tprotocol.writeFieldBegin(EventData.access$1200());
            tprotocol.writeBool(eventdata.completedCaptcha);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.tripwireData != null && eventdata.isSetTripwireData())
        {
            tprotocol.writeFieldBegin(EventData.access$1300());
            eventdata.tripwireData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.pinImpressions != null && eventdata.isSetPinImpressions())
        {
            tprotocol.writeFieldBegin(EventData.access$1400());
            tprotocol.writeListBegin(new TList((byte)12, eventdata.pinImpressions.size()));
            for (Iterator iterator = eventdata.pinImpressions.iterator(); iterator.hasNext(); ((PinImpression)iterator.next()).write(tprotocol)) { }
            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (eventdata.isSetEnforceSpamRules())
        {
            tprotocol.writeFieldBegin(EventData.access$1500());
            tprotocol.writeBool(eventdata.enforceSpamRules);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.isSetAdminOverride())
        {
            tprotocol.writeFieldBegin(EventData.access$1600());
            tprotocol.writeBool(eventdata.adminOverride);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.interestImpressionData != null && eventdata.isSetInterestImpressionData())
        {
            tprotocol.writeFieldBegin(EventData.access$1700());
            eventdata.interestImpressionData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.browserIdData != null && eventdata.isSetBrowserIdData())
        {
            tprotocol.writeFieldBegin(EventData.access$1800());
            eventdata.browserIdData.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (eventdata.insertion != null && eventdata.isSetInsertion())
        {
            tprotocol.writeFieldBegin(EventData.access$1900());
            eventdata.insertion.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    public volatile void write(TProtocol tprotocol, TBase tbase)
    {
        write(tprotocol, (EventData)tbase);
    }

    private ata()
    {
    }

    ata(ata ata)
    {
        this();
    }
}
