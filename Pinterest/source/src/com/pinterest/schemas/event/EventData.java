// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import com.pinterest.schemas.email_queued.QueuedEmailEvent;
import com.pinterest.schemas.push_notification.PushNotificationEventData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package com.pinterest.schemas.event:
//            TestData, SpamServiceRequest, SignupData, OffsiteServiceResult, 
//            PhantomServiceResult, TripwireData, PinImpression, InterestImpressionData, 
//            BrowserIdData, InsertionData

public class EventData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ADMIN_OVERRIDE_FIELD_DESC = new TField("adminOverride", (byte)2, (short)13);
    private static final TField BROWSER_ID_DATA_FIELD_DESC = new TField("browserIdData", (byte)12, (short)15);
    private static final TField COMPLETED_CAPTCHA_FIELD_DESC = new TField("completedCaptcha", (byte)2, (short)9);
    private static final TField EMAIL_FIELD_DESC = new TField("email", (byte)12, (short)2);
    private static final TField ENFORCE_SPAM_RULES_FIELD_DESC = new TField("enforceSpamRules", (byte)2, (short)12);
    private static final TField INSERTION_FIELD_DESC = new TField("insertion", (byte)12, (short)16);
    private static final TField INTEREST_IMPRESSION_DATA_FIELD_DESC = new TField("interestImpressionData", (byte)12, (short)14);
    private static final TField JSON_FIELD_DESC = new TField("json", (byte)11, (short)3);
    private static final TField OFFSITE_RESULT_FIELD_DESC = new TField("offsiteResult", (byte)12, (short)7);
    private static final TField PHANTOM_RESULT_FIELD_DESC = new TField("phantomResult", (byte)12, (short)8);
    private static final TField PIN_IMPRESSIONS_FIELD_DESC = new TField("pinImpressions", (byte)15, (short)11);
    private static final TField PUSH_FIELD_DESC = new TField("push", (byte)12, (short)5);
    private static final TField SIGNUP_FIELD_DESC = new TField("signup", (byte)12, (short)6);
    private static final TField SPAM_REQUEST_FIELD_DESC = new TField("spamRequest", (byte)12, (short)4);
    private static final TStruct STRUCT_DESC = new TStruct("EventData");
    private static final TField TEST_DATA_FIELD_DESC = new TField("testData", (byte)12, (short)1);
    private static final TField TRIPWIRE_DATA_FIELD_DESC = new TField("tripwireData", (byte)12, (short)10);
    private static final int __ADMINOVERRIDE_ISSET_ID = 2;
    private static final int __COMPLETEDCAPTCHA_ISSET_ID = 0;
    private static final int __ENFORCESPAMRULES_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public boolean adminOverride;
    public BrowserIdData browserIdData;
    public boolean completedCaptcha;
    public QueuedEmailEvent email;
    public boolean enforceSpamRules;
    public InsertionData insertion;
    public InterestImpressionData interestImpressionData;
    public String json;
    public OffsiteServiceResult offsiteResult;
    public PhantomServiceResult phantomResult;
    public List pinImpressions;
    public PushNotificationEventData push;
    public SignupData signup;
    public SpamServiceRequest spamRequest;
    public TestData testData;
    public TripwireData tripwireData;

    public EventData()
    {
        __isset_bitfield = 0;
        completedCaptcha = false;
        enforceSpamRules = true;
        adminOverride = false;
    }

    public EventData(EventData eventdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = eventdata.__isset_bitfield;
        if (eventdata.isSetTestData())
        {
            testData = new TestData(eventdata.testData);
        }
        if (eventdata.isSetEmail())
        {
            email = new QueuedEmailEvent(eventdata.email);
        }
        if (eventdata.isSetJson())
        {
            json = eventdata.json;
        }
        if (eventdata.isSetSpamRequest())
        {
            spamRequest = new SpamServiceRequest(eventdata.spamRequest);
        }
        if (eventdata.isSetPush())
        {
            push = new PushNotificationEventData(eventdata.push);
        }
        if (eventdata.isSetSignup())
        {
            signup = new SignupData(eventdata.signup);
        }
        if (eventdata.isSetOffsiteResult())
        {
            offsiteResult = new OffsiteServiceResult(eventdata.offsiteResult);
        }
        if (eventdata.isSetPhantomResult())
        {
            phantomResult = new PhantomServiceResult(eventdata.phantomResult);
        }
        completedCaptcha = eventdata.completedCaptcha;
        if (eventdata.isSetTripwireData())
        {
            tripwireData = new TripwireData(eventdata.tripwireData);
        }
        if (eventdata.isSetPinImpressions())
        {
            ArrayList arraylist = new ArrayList(eventdata.pinImpressions.size());
            for (Iterator iterator = eventdata.pinImpressions.iterator(); iterator.hasNext(); arraylist.add(new PinImpression((PinImpression)iterator.next()))) { }
            pinImpressions = arraylist;
        }
        enforceSpamRules = eventdata.enforceSpamRules;
        adminOverride = eventdata.adminOverride;
        if (eventdata.isSetInterestImpressionData())
        {
            interestImpressionData = new InterestImpressionData(eventdata.interestImpressionData);
        }
        if (eventdata.isSetBrowserIdData())
        {
            browserIdData = new BrowserIdData(eventdata.browserIdData);
        }
        if (eventdata.isSetInsertion())
        {
            insertion = new InsertionData(eventdata.insertion);
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            __isset_bitfield = 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectinputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new IOException(objectinputstream.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            write(new TCompactProtocol(new TIOStreamTransport(objectoutputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            throw new IOException(objectoutputstream.getMessage());
        }
    }

    public void addToPinImpressions(PinImpression pinimpression)
    {
        if (pinImpressions == null)
        {
            pinImpressions = new ArrayList();
        }
        pinImpressions.add(pinimpression);
    }

    public void clear()
    {
        testData = null;
        email = null;
        json = null;
        spamRequest = null;
        push = null;
        signup = null;
        offsiteResult = null;
        phantomResult = null;
        completedCaptcha = false;
        tripwireData = null;
        pinImpressions = null;
        enforceSpamRules = true;
        adminOverride = false;
        interestImpressionData = null;
        browserIdData = null;
        insertion = null;
    }

    public int compareTo(EventData eventdata)
    {
        if (getClass().equals(eventdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(eventdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTestData()).compareTo(Boolean.valueOf(eventdata.isSetTestData()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTestData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(testData, eventdata.testData);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetEmail()).compareTo(Boolean.valueOf(eventdata.isSetEmail()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetEmail())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(email, eventdata.email);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetJson()).compareTo(Boolean.valueOf(eventdata.isSetJson()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetJson())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(json, eventdata.json);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetSpamRequest()).compareTo(Boolean.valueOf(eventdata.isSetSpamRequest()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetSpamRequest())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(spamRequest, eventdata.spamRequest);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetPush()).compareTo(Boolean.valueOf(eventdata.isSetPush()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetPush())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(push, eventdata.push);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetSignup()).compareTo(Boolean.valueOf(eventdata.isSetSignup()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetSignup())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(signup, eventdata.signup);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetOffsiteResult()).compareTo(Boolean.valueOf(eventdata.isSetOffsiteResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetOffsiteResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(offsiteResult, eventdata.offsiteResult);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetPhantomResult()).compareTo(Boolean.valueOf(eventdata.isSetPhantomResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetPhantomResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(phantomResult, eventdata.phantomResult);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        j = Boolean.valueOf(isSetCompletedCaptcha()).compareTo(Boolean.valueOf(eventdata.isSetCompletedCaptcha()));
        i = j;
        if (j != 0) goto _L4; else goto _L20
_L20:
        if (!isSetCompletedCaptcha())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(completedCaptcha, eventdata.completedCaptcha);
        i = j;
        if (j != 0) goto _L4; else goto _L21
_L21:
        j = Boolean.valueOf(isSetTripwireData()).compareTo(Boolean.valueOf(eventdata.isSetTripwireData()));
        i = j;
        if (j != 0) goto _L4; else goto _L22
_L22:
        if (!isSetTripwireData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(tripwireData, eventdata.tripwireData);
        i = j;
        if (j != 0) goto _L4; else goto _L23
_L23:
        j = Boolean.valueOf(isSetPinImpressions()).compareTo(Boolean.valueOf(eventdata.isSetPinImpressions()));
        i = j;
        if (j != 0) goto _L4; else goto _L24
_L24:
        if (!isSetPinImpressions())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pinImpressions, eventdata.pinImpressions);
        i = j;
        if (j != 0) goto _L4; else goto _L25
_L25:
        j = Boolean.valueOf(isSetEnforceSpamRules()).compareTo(Boolean.valueOf(eventdata.isSetEnforceSpamRules()));
        i = j;
        if (j != 0) goto _L4; else goto _L26
_L26:
        if (!isSetEnforceSpamRules())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(enforceSpamRules, eventdata.enforceSpamRules);
        i = j;
        if (j != 0) goto _L4; else goto _L27
_L27:
        j = Boolean.valueOf(isSetAdminOverride()).compareTo(Boolean.valueOf(eventdata.isSetAdminOverride()));
        i = j;
        if (j != 0) goto _L4; else goto _L28
_L28:
        if (!isSetAdminOverride())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(adminOverride, eventdata.adminOverride);
        i = j;
        if (j != 0) goto _L4; else goto _L29
_L29:
        j = Boolean.valueOf(isSetInterestImpressionData()).compareTo(Boolean.valueOf(eventdata.isSetInterestImpressionData()));
        i = j;
        if (j != 0) goto _L4; else goto _L30
_L30:
        if (!isSetInterestImpressionData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(interestImpressionData, eventdata.interestImpressionData);
        i = j;
        if (j != 0) goto _L4; else goto _L31
_L31:
        j = Boolean.valueOf(isSetBrowserIdData()).compareTo(Boolean.valueOf(eventdata.isSetBrowserIdData()));
        i = j;
        if (j != 0) goto _L4; else goto _L32
_L32:
        if (!isSetBrowserIdData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(browserIdData, eventdata.browserIdData);
        i = j;
        if (j != 0) goto _L4; else goto _L33
_L33:
        j = Boolean.valueOf(isSetInsertion()).compareTo(Boolean.valueOf(eventdata.isSetInsertion()));
        i = j;
        if (j != 0) goto _L4; else goto _L34
_L34:
        if (!isSetInsertion())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(insertion, eventdata.insertion);
        i = j;
        if (j != 0) goto _L4; else goto _L35
_L35:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EventData)obj);
    }

    public EventData deepCopy()
    {
        return new EventData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(EventData eventdata)
    {
        if (eventdata != null)
        {
            boolean flag = isSetTestData();
            boolean flag16 = eventdata.isSetTestData();
            if (!flag && !flag16 || flag && flag16 && testData.equals(eventdata.testData))
            {
                boolean flag1 = isSetEmail();
                boolean flag17 = eventdata.isSetEmail();
                if (!flag1 && !flag17 || flag1 && flag17 && email.equals(eventdata.email))
                {
                    boolean flag2 = isSetJson();
                    boolean flag18 = eventdata.isSetJson();
                    if (!flag2 && !flag18 || flag2 && flag18 && json.equals(eventdata.json))
                    {
                        boolean flag3 = isSetSpamRequest();
                        boolean flag19 = eventdata.isSetSpamRequest();
                        if (!flag3 && !flag19 || flag3 && flag19 && spamRequest.equals(eventdata.spamRequest))
                        {
                            boolean flag4 = isSetPush();
                            boolean flag20 = eventdata.isSetPush();
                            if (!flag4 && !flag20 || flag4 && flag20 && push.equals(eventdata.push))
                            {
                                boolean flag5 = isSetSignup();
                                boolean flag21 = eventdata.isSetSignup();
                                if (!flag5 && !flag21 || flag5 && flag21 && signup.equals(eventdata.signup))
                                {
                                    boolean flag6 = isSetOffsiteResult();
                                    boolean flag22 = eventdata.isSetOffsiteResult();
                                    if (!flag6 && !flag22 || flag6 && flag22 && offsiteResult.equals(eventdata.offsiteResult))
                                    {
                                        boolean flag7 = isSetPhantomResult();
                                        boolean flag23 = eventdata.isSetPhantomResult();
                                        if (!flag7 && !flag23 || flag7 && flag23 && phantomResult.equals(eventdata.phantomResult))
                                        {
                                            boolean flag8 = isSetCompletedCaptcha();
                                            boolean flag24 = eventdata.isSetCompletedCaptcha();
                                            if (!flag8 && !flag24 || flag8 && flag24 && completedCaptcha == eventdata.completedCaptcha)
                                            {
                                                boolean flag9 = isSetTripwireData();
                                                boolean flag25 = eventdata.isSetTripwireData();
                                                if (!flag9 && !flag25 || flag9 && flag25 && tripwireData.equals(eventdata.tripwireData))
                                                {
                                                    boolean flag10 = isSetPinImpressions();
                                                    boolean flag26 = eventdata.isSetPinImpressions();
                                                    if (!flag10 && !flag26 || flag10 && flag26 && pinImpressions.equals(eventdata.pinImpressions))
                                                    {
                                                        boolean flag11 = isSetEnforceSpamRules();
                                                        boolean flag27 = eventdata.isSetEnforceSpamRules();
                                                        if (!flag11 && !flag27 || flag11 && flag27 && enforceSpamRules == eventdata.enforceSpamRules)
                                                        {
                                                            boolean flag12 = isSetAdminOverride();
                                                            boolean flag28 = eventdata.isSetAdminOverride();
                                                            if (!flag12 && !flag28 || flag12 && flag28 && adminOverride == eventdata.adminOverride)
                                                            {
                                                                boolean flag13 = isSetInterestImpressionData();
                                                                boolean flag29 = eventdata.isSetInterestImpressionData();
                                                                if (!flag13 && !flag29 || flag13 && flag29 && interestImpressionData.equals(eventdata.interestImpressionData))
                                                                {
                                                                    boolean flag14 = isSetBrowserIdData();
                                                                    boolean flag30 = eventdata.isSetBrowserIdData();
                                                                    if (!flag14 && !flag30 || flag14 && flag30 && browserIdData.equals(eventdata.browserIdData))
                                                                    {
                                                                        boolean flag15 = isSetInsertion();
                                                                        boolean flag31 = eventdata.isSetInsertion();
                                                                        if (!flag15 && !flag31 || flag15 && flag31 && insertion.equals(eventdata.insertion))
                                                                        {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof EventData)) 
        {
            return false;
        }
        return equals((EventData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public BrowserIdData getBrowserIdData()
    {
        return browserIdData;
    }

    public QueuedEmailEvent getEmail()
    {
        return email;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getTestData();

        case 2: // '\002'
            return getEmail();

        case 3: // '\003'
            return getJson();

        case 4: // '\004'
            return getSpamRequest();

        case 5: // '\005'
            return getPush();

        case 6: // '\006'
            return getSignup();

        case 7: // '\007'
            return getOffsiteResult();

        case 8: // '\b'
            return getPhantomResult();

        case 9: // '\t'
            return Boolean.valueOf(isCompletedCaptcha());

        case 10: // '\n'
            return getTripwireData();

        case 11: // '\013'
            return getPinImpressions();

        case 12: // '\f'
            return Boolean.valueOf(isEnforceSpamRules());

        case 13: // '\r'
            return Boolean.valueOf(isAdminOverride());

        case 14: // '\016'
            return getInterestImpressionData();

        case 15: // '\017'
            return getBrowserIdData();

        case 16: // '\020'
            return getInsertion();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public InsertionData getInsertion()
    {
        return insertion;
    }

    public InterestImpressionData getInterestImpressionData()
    {
        return interestImpressionData;
    }

    public String getJson()
    {
        return json;
    }

    public OffsiteServiceResult getOffsiteResult()
    {
        return offsiteResult;
    }

    public PhantomServiceResult getPhantomResult()
    {
        return phantomResult;
    }

    public List getPinImpressions()
    {
        return pinImpressions;
    }

    public Iterator getPinImpressionsIterator()
    {
        if (pinImpressions == null)
        {
            return null;
        } else
        {
            return pinImpressions.iterator();
        }
    }

    public int getPinImpressionsSize()
    {
        if (pinImpressions == null)
        {
            return 0;
        } else
        {
            return pinImpressions.size();
        }
    }

    public PushNotificationEventData getPush()
    {
        return push;
    }

    public SignupData getSignup()
    {
        return signup;
    }

    public SpamServiceRequest getSpamRequest()
    {
        return spamRequest;
    }

    public TestData getTestData()
    {
        return testData;
    }

    public TripwireData getTripwireData()
    {
        return tripwireData;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetTestData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(testData);
        }
        flag = isSetEmail();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(email);
        }
        flag = isSetJson();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(json);
        }
        flag = isSetSpamRequest();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(spamRequest);
        }
        flag = isSetPush();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(push);
        }
        flag = isSetSignup();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(signup);
        }
        flag = isSetOffsiteResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(offsiteResult);
        }
        flag = isSetPhantomResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(phantomResult);
        }
        flag = isSetCompletedCaptcha();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(completedCaptcha));
        }
        flag = isSetTripwireData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(tripwireData);
        }
        flag = isSetPinImpressions();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(pinImpressions);
        }
        flag = isSetEnforceSpamRules();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(enforceSpamRules));
        }
        flag = isSetAdminOverride();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(adminOverride));
        }
        flag = isSetInterestImpressionData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(interestImpressionData);
        }
        flag = isSetBrowserIdData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(browserIdData);
        }
        flag = isSetInsertion();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(insertion);
        }
        return arraylist.hashCode();
    }

    public boolean isAdminOverride()
    {
        return adminOverride;
    }

    public boolean isCompletedCaptcha()
    {
        return completedCaptcha;
    }

    public boolean isEnforceSpamRules()
    {
        return enforceSpamRules;
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTestData();

        case 2: // '\002'
            return isSetEmail();

        case 3: // '\003'
            return isSetJson();

        case 4: // '\004'
            return isSetSpamRequest();

        case 5: // '\005'
            return isSetPush();

        case 6: // '\006'
            return isSetSignup();

        case 7: // '\007'
            return isSetOffsiteResult();

        case 8: // '\b'
            return isSetPhantomResult();

        case 9: // '\t'
            return isSetCompletedCaptcha();

        case 10: // '\n'
            return isSetTripwireData();

        case 11: // '\013'
            return isSetPinImpressions();

        case 12: // '\f'
            return isSetEnforceSpamRules();

        case 13: // '\r'
            return isSetAdminOverride();

        case 14: // '\016'
            return isSetInterestImpressionData();

        case 15: // '\017'
            return isSetBrowserIdData();

        case 16: // '\020'
            return isSetInsertion();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAdminOverride()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetBrowserIdData()
    {
        return browserIdData != null;
    }

    public boolean isSetCompletedCaptcha()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetEmail()
    {
        return email != null;
    }

    public boolean isSetEnforceSpamRules()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetInsertion()
    {
        return insertion != null;
    }

    public boolean isSetInterestImpressionData()
    {
        return interestImpressionData != null;
    }

    public boolean isSetJson()
    {
        return json != null;
    }

    public boolean isSetOffsiteResult()
    {
        return offsiteResult != null;
    }

    public boolean isSetPhantomResult()
    {
        return phantomResult != null;
    }

    public boolean isSetPinImpressions()
    {
        return pinImpressions != null;
    }

    public boolean isSetPush()
    {
        return push != null;
    }

    public boolean isSetSignup()
    {
        return signup != null;
    }

    public boolean isSetSpamRequest()
    {
        return spamRequest != null;
    }

    public boolean isSetTestData()
    {
        return testData != null;
    }

    public boolean isSetTripwireData()
    {
        return tripwireData != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public EventData setAdminOverride(boolean flag)
    {
        adminOverride = flag;
        setAdminOverrideIsSet(true);
        return this;
    }

    public void setAdminOverrideIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public EventData setBrowserIdData(BrowserIdData browseriddata)
    {
        browserIdData = browseriddata;
        return this;
    }

    public void setBrowserIdDataIsSet(boolean flag)
    {
        if (!flag)
        {
            browserIdData = null;
        }
    }

    public EventData setCompletedCaptcha(boolean flag)
    {
        completedCaptcha = flag;
        setCompletedCaptchaIsSet(true);
        return this;
    }

    public void setCompletedCaptchaIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public EventData setEmail(QueuedEmailEvent queuedemailevent)
    {
        email = queuedemailevent;
        return this;
    }

    public void setEmailIsSet(boolean flag)
    {
        if (!flag)
        {
            email = null;
        }
    }

    public EventData setEnforceSpamRules(boolean flag)
    {
        enforceSpamRules = flag;
        setEnforceSpamRulesIsSet(true);
        return this;
    }

    public void setEnforceSpamRulesIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTestData();
                return;
            } else
            {
                setTestData((TestData)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetEmail();
                return;
            } else
            {
                setEmail((QueuedEmailEvent)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetJson();
                return;
            } else
            {
                setJson((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetSpamRequest();
                return;
            } else
            {
                setSpamRequest((SpamServiceRequest)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetPush();
                return;
            } else
            {
                setPush((PushNotificationEventData)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetSignup();
                return;
            } else
            {
                setSignup((SignupData)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetOffsiteResult();
                return;
            } else
            {
                setOffsiteResult((OffsiteServiceResult)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetPhantomResult();
                return;
            } else
            {
                setPhantomResult((PhantomServiceResult)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetCompletedCaptcha();
                return;
            } else
            {
                setCompletedCaptcha(((Boolean)obj).booleanValue());
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetTripwireData();
                return;
            } else
            {
                setTripwireData((TripwireData)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetPinImpressions();
                return;
            } else
            {
                setPinImpressions((List)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetEnforceSpamRules();
                return;
            } else
            {
                setEnforceSpamRules(((Boolean)obj).booleanValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetAdminOverride();
                return;
            } else
            {
                setAdminOverride(((Boolean)obj).booleanValue());
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetInterestImpressionData();
                return;
            } else
            {
                setInterestImpressionData((InterestImpressionData)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetBrowserIdData();
                return;
            } else
            {
                setBrowserIdData((BrowserIdData)obj);
                return;
            }

        case 16: // '\020'
            break;
        }
        if (obj == null)
        {
            unsetInsertion();
            return;
        } else
        {
            setInsertion((InsertionData)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public EventData setInsertion(InsertionData insertiondata)
    {
        insertion = insertiondata;
        return this;
    }

    public void setInsertionIsSet(boolean flag)
    {
        if (!flag)
        {
            insertion = null;
        }
    }

    public EventData setInterestImpressionData(InterestImpressionData interestimpressiondata)
    {
        interestImpressionData = interestimpressiondata;
        return this;
    }

    public void setInterestImpressionDataIsSet(boolean flag)
    {
        if (!flag)
        {
            interestImpressionData = null;
        }
    }

    public EventData setJson(String s)
    {
        json = s;
        return this;
    }

    public void setJsonIsSet(boolean flag)
    {
        if (!flag)
        {
            json = null;
        }
    }

    public EventData setOffsiteResult(OffsiteServiceResult offsiteserviceresult)
    {
        offsiteResult = offsiteserviceresult;
        return this;
    }

    public void setOffsiteResultIsSet(boolean flag)
    {
        if (!flag)
        {
            offsiteResult = null;
        }
    }

    public EventData setPhantomResult(PhantomServiceResult phantomserviceresult)
    {
        phantomResult = phantomserviceresult;
        return this;
    }

    public void setPhantomResultIsSet(boolean flag)
    {
        if (!flag)
        {
            phantomResult = null;
        }
    }

    public EventData setPinImpressions(List list)
    {
        pinImpressions = list;
        return this;
    }

    public void setPinImpressionsIsSet(boolean flag)
    {
        if (!flag)
        {
            pinImpressions = null;
        }
    }

    public EventData setPush(PushNotificationEventData pushnotificationeventdata)
    {
        push = pushnotificationeventdata;
        return this;
    }

    public void setPushIsSet(boolean flag)
    {
        if (!flag)
        {
            push = null;
        }
    }

    public EventData setSignup(SignupData signupdata)
    {
        signup = signupdata;
        return this;
    }

    public void setSignupIsSet(boolean flag)
    {
        if (!flag)
        {
            signup = null;
        }
    }

    public EventData setSpamRequest(SpamServiceRequest spamservicerequest)
    {
        spamRequest = spamservicerequest;
        return this;
    }

    public void setSpamRequestIsSet(boolean flag)
    {
        if (!flag)
        {
            spamRequest = null;
        }
    }

    public EventData setTestData(TestData testdata)
    {
        testData = testdata;
        return this;
    }

    public void setTestDataIsSet(boolean flag)
    {
        if (!flag)
        {
            testData = null;
        }
    }

    public EventData setTripwireData(TripwireData tripwiredata)
    {
        tripwireData = tripwiredata;
        return this;
    }

    public void setTripwireDataIsSet(boolean flag)
    {
        if (!flag)
        {
            tripwireData = null;
        }
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("EventData(");
        boolean flag1 = true;
        boolean flag;
        if (isSetTestData())
        {
            stringbuilder.append("testData:");
            if (testData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(testData);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetEmail())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("email:");
            if (email == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(email);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetJson())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("json:");
            if (json == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(json);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetSpamRequest())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("spamRequest:");
            if (spamRequest == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(spamRequest);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetPush())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("push:");
            if (push == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(push);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetSignup())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("signup:");
            if (signup == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(signup);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetOffsiteResult())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("offsiteResult:");
            if (offsiteResult == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(offsiteResult);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetPhantomResult())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("phantomResult:");
            if (phantomResult == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(phantomResult);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetCompletedCaptcha())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("completedCaptcha:");
            stringbuilder.append(completedCaptcha);
            flag1 = false;
        }
        flag = flag1;
        if (isSetTripwireData())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("tripwireData:");
            if (tripwireData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(tripwireData);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetPinImpressions())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("pinImpressions:");
            if (pinImpressions == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(pinImpressions);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetEnforceSpamRules())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("enforceSpamRules:");
            stringbuilder.append(enforceSpamRules);
            flag = false;
        }
        flag1 = flag;
        if (isSetAdminOverride())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("adminOverride:");
            stringbuilder.append(adminOverride);
            flag1 = false;
        }
        flag = flag1;
        if (isSetInterestImpressionData())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("interestImpressionData:");
            if (interestImpressionData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(interestImpressionData);
            }
            flag = false;
        }
        if (isSetBrowserIdData())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("browserIdData:");
            if (browserIdData == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(browserIdData);
                flag = flag2;
            }
        }
        if (isSetInsertion())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("insertion:");
            if (insertion == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(insertion);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdminOverride()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetBrowserIdData()
    {
        browserIdData = null;
    }

    public void unsetCompletedCaptcha()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetEmail()
    {
        email = null;
    }

    public void unsetEnforceSpamRules()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetInsertion()
    {
        insertion = null;
    }

    public void unsetInterestImpressionData()
    {
        interestImpressionData = null;
    }

    public void unsetJson()
    {
        json = null;
    }

    public void unsetOffsiteResult()
    {
        offsiteResult = null;
    }

    public void unsetPhantomResult()
    {
        phantomResult = null;
    }

    public void unsetPinImpressions()
    {
        pinImpressions = null;
    }

    public void unsetPush()
    {
        push = null;
    }

    public void unsetSignup()
    {
        signup = null;
    }

    public void unsetSpamRequest()
    {
        spamRequest = null;
    }

    public void unsetTestData()
    {
        testData = null;
    }

    public void unsetTripwireData()
    {
        tripwireData = null;
    }

    public void validate()
    {
        if (testData != null)
        {
            testData.validate();
        }
        if (email != null)
        {
            email.validate();
        }
        if (spamRequest != null)
        {
            spamRequest.validate();
        }
        if (push != null)
        {
            push.validate();
        }
        if (signup != null)
        {
            signup.validate();
        }
        if (offsiteResult != null)
        {
            offsiteResult.validate();
        }
        if (phantomResult != null)
        {
            phantomResult.validate();
        }
        if (tripwireData != null)
        {
            tripwireData.validate();
        }
        if (interestImpressionData != null)
        {
            interestImpressionData.validate();
        }
        if (browserIdData != null)
        {
            browserIdData.validate();
        }
        if (insertion != null)
        {
            insertion.validate();
        }
    }

    public void write(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().write(tprotocol, this);
    }

    static 
    {
        Object obj = new HashMap();
        schemes = ((Map) (obj));
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new EventDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new EventDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.TEST_DATA, _Fields.EMAIL, _Fields.JSON, _Fields.SPAM_REQUEST, _Fields.PUSH, _Fields.SIGNUP, _Fields.OFFSITE_RESULT, _Fields.PHANTOM_RESULT, _Fields.COMPLETED_CAPTCHA, _Fields.TRIPWIRE_DATA, 
            _Fields.PIN_IMPRESSIONS, _Fields.ENFORCE_SPAM_RULES, _Fields.ADMIN_OVERRIDE, _Fields.INTEREST_IMPRESSION_DATA, _Fields.BROWSER_ID_DATA, _Fields.INSERTION
        });
        obj = new EnumMap(com/pinterest/schemas/event/EventData$_Fields);
        ((Map) (obj)).put(_Fields.TEST_DATA, new FieldMetaData("testData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/TestData)));
        ((Map) (obj)).put(_Fields.EMAIL, new FieldMetaData("email", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/QueuedEmailEvent)));
        ((Map) (obj)).put(_Fields.JSON, new FieldMetaData("json", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SPAM_REQUEST, new FieldMetaData("spamRequest", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/SpamServiceRequest)));
        ((Map) (obj)).put(_Fields.PUSH, new FieldMetaData("push", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/push_notification/PushNotificationEventData)));
        ((Map) (obj)).put(_Fields.SIGNUP, new FieldMetaData("signup", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/SignupData)));
        ((Map) (obj)).put(_Fields.OFFSITE_RESULT, new FieldMetaData("offsiteResult", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/OffsiteServiceResult)));
        ((Map) (obj)).put(_Fields.PHANTOM_RESULT, new FieldMetaData("phantomResult", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomServiceResult)));
        ((Map) (obj)).put(_Fields.COMPLETED_CAPTCHA, new FieldMetaData("completedCaptcha", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.TRIPWIRE_DATA, new FieldMetaData("tripwireData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/TripwireData)));
        ((Map) (obj)).put(_Fields.PIN_IMPRESSIONS, new FieldMetaData("pinImpressions", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/PinImpression))));
        ((Map) (obj)).put(_Fields.ENFORCE_SPAM_RULES, new FieldMetaData("enforceSpamRules", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.ADMIN_OVERRIDE, new FieldMetaData("adminOverride", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.INTEREST_IMPRESSION_DATA, new FieldMetaData("interestImpressionData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/InterestImpressionData)));
        ((Map) (obj)).put(_Fields.BROWSER_ID_DATA, new FieldMetaData("browserIdData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/BrowserIdData)));
        ((Map) (obj)).put(_Fields.INSERTION, new FieldMetaData("insertion", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/InsertionData)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/EventData, metaDataMap);
    }


















    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ADMIN_OVERRIDE;
        public static final _Fields BROWSER_ID_DATA;
        public static final _Fields COMPLETED_CAPTCHA;
        public static final _Fields EMAIL;
        public static final _Fields ENFORCE_SPAM_RULES;
        public static final _Fields INSERTION;
        public static final _Fields INTEREST_IMPRESSION_DATA;
        public static final _Fields JSON;
        public static final _Fields OFFSITE_RESULT;
        public static final _Fields PHANTOM_RESULT;
        public static final _Fields PIN_IMPRESSIONS;
        public static final _Fields PUSH;
        public static final _Fields SIGNUP;
        public static final _Fields SPAM_REQUEST;
        public static final _Fields TEST_DATA;
        public static final _Fields TRIPWIRE_DATA;
        private static final Map byName;
        private final String _fieldName;
        private final short _thriftId;

        public static _Fields findByName(String s)
        {
            return (_Fields)byName.get(s);
        }

        public static _Fields findByThriftId(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1: // '\001'
                return TEST_DATA;

            case 2: // '\002'
                return EMAIL;

            case 3: // '\003'
                return JSON;

            case 4: // '\004'
                return SPAM_REQUEST;

            case 5: // '\005'
                return PUSH;

            case 6: // '\006'
                return SIGNUP;

            case 7: // '\007'
                return OFFSITE_RESULT;

            case 8: // '\b'
                return PHANTOM_RESULT;

            case 9: // '\t'
                return COMPLETED_CAPTCHA;

            case 10: // '\n'
                return TRIPWIRE_DATA;

            case 11: // '\013'
                return PIN_IMPRESSIONS;

            case 12: // '\f'
                return ENFORCE_SPAM_RULES;

            case 13: // '\r'
                return ADMIN_OVERRIDE;

            case 14: // '\016'
                return INTEREST_IMPRESSION_DATA;

            case 15: // '\017'
                return BROWSER_ID_DATA;

            case 16: // '\020'
                return INSERTION;
            }
        }

        public static _Fields findByThriftIdOrThrow(int i)
        {
            _Fields _lfields = findByThriftId(i);
            if (_lfields == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
            } else
            {
                return _lfields;
            }
        }

        public static _Fields valueOf(String s)
        {
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/EventData$_Fields, s);
        }

        public static _Fields[] values()
        {
            return (_Fields[])$VALUES.clone();
        }

        public final String getFieldName()
        {
            return _fieldName;
        }

        public final short getThriftFieldId()
        {
            return _thriftId;
        }

        static 
        {
            TEST_DATA = new _Fields("TEST_DATA", 0, (short)1, "testData");
            EMAIL = new _Fields("EMAIL", 1, (short)2, "email");
            JSON = new _Fields("JSON", 2, (short)3, "json");
            SPAM_REQUEST = new _Fields("SPAM_REQUEST", 3, (short)4, "spamRequest");
            PUSH = new _Fields("PUSH", 4, (short)5, "push");
            SIGNUP = new _Fields("SIGNUP", 5, (short)6, "signup");
            OFFSITE_RESULT = new _Fields("OFFSITE_RESULT", 6, (short)7, "offsiteResult");
            PHANTOM_RESULT = new _Fields("PHANTOM_RESULT", 7, (short)8, "phantomResult");
            COMPLETED_CAPTCHA = new _Fields("COMPLETED_CAPTCHA", 8, (short)9, "completedCaptcha");
            TRIPWIRE_DATA = new _Fields("TRIPWIRE_DATA", 9, (short)10, "tripwireData");
            PIN_IMPRESSIONS = new _Fields("PIN_IMPRESSIONS", 10, (short)11, "pinImpressions");
            ENFORCE_SPAM_RULES = new _Fields("ENFORCE_SPAM_RULES", 11, (short)12, "enforceSpamRules");
            ADMIN_OVERRIDE = new _Fields("ADMIN_OVERRIDE", 12, (short)13, "adminOverride");
            INTEREST_IMPRESSION_DATA = new _Fields("INTEREST_IMPRESSION_DATA", 13, (short)14, "interestImpressionData");
            BROWSER_ID_DATA = new _Fields("BROWSER_ID_DATA", 14, (short)15, "browserIdData");
            INSERTION = new _Fields("INSERTION", 15, (short)16, "insertion");
            $VALUES = (new _Fields[] {
                TEST_DATA, EMAIL, JSON, SPAM_REQUEST, PUSH, SIGNUP, OFFSITE_RESULT, PHANTOM_RESULT, COMPLETED_CAPTCHA, TRIPWIRE_DATA, 
                PIN_IMPRESSIONS, ENFORCE_SPAM_RULES, ADMIN_OVERRIDE, INTEREST_IMPRESSION_DATA, BROWSER_ID_DATA, INSERTION
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/EventData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
            {
                _lfields = (_Fields)iterator.next();
            }

        }

        private _Fields(String s, int i, short word0, String s1)
        {
            super(s, i);
            _thriftId = word0;
            _fieldName = s1;
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$EventData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.TEST_DATA.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror15) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.EMAIL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.JSON.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.SPAM_REQUEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.PUSH.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.SIGNUP.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.OFFSITE_RESULT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.PHANTOM_RESULT.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.COMPLETED_CAPTCHA.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.TRIPWIRE_DATA.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.PIN_IMPRESSIONS.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.ENFORCE_SPAM_RULES.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.ADMIN_OVERRIDE.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.INTEREST_IMPRESSION_DATA.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.BROWSER_ID_DATA.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventData$_Fields[_Fields.INSERTION.ordinal()] = 16;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class EventDataStandardSchemeFactory
        implements SchemeFactory
    {

        public EventDataStandardScheme getScheme()
        {
            return new EventDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventDataStandardSchemeFactory()
        {
        }

        EventDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventDataStandardScheme extends StandardScheme
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
            //                           1 115
            //                           2 162
            //                           3 209
            //                           4 245
            //                           5 292
            //                           6 339
            //                           7 386
            //                           8 433
            //                           9 480
            //                           10 515
            //                           11 562
            //                           12 662
            //                           13 697
            //                           14 732
            //                           15 779
            //                           16 826;
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
                tprotocol.writeStructBegin(EventData.STRUCT_DESC);
                if (eventdata.testData != null && eventdata.isSetTestData())
                {
                    tprotocol.writeFieldBegin(EventData.TEST_DATA_FIELD_DESC);
                    eventdata.testData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.email != null && eventdata.isSetEmail())
                {
                    tprotocol.writeFieldBegin(EventData.EMAIL_FIELD_DESC);
                    eventdata.email.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.json != null && eventdata.isSetJson())
                {
                    tprotocol.writeFieldBegin(EventData.JSON_FIELD_DESC);
                    tprotocol.writeString(eventdata.json);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.spamRequest != null && eventdata.isSetSpamRequest())
                {
                    tprotocol.writeFieldBegin(EventData.SPAM_REQUEST_FIELD_DESC);
                    eventdata.spamRequest.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.push != null && eventdata.isSetPush())
                {
                    tprotocol.writeFieldBegin(EventData.PUSH_FIELD_DESC);
                    eventdata.push.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.signup != null && eventdata.isSetSignup())
                {
                    tprotocol.writeFieldBegin(EventData.SIGNUP_FIELD_DESC);
                    eventdata.signup.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.offsiteResult != null && eventdata.isSetOffsiteResult())
                {
                    tprotocol.writeFieldBegin(EventData.OFFSITE_RESULT_FIELD_DESC);
                    eventdata.offsiteResult.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.phantomResult != null && eventdata.isSetPhantomResult())
                {
                    tprotocol.writeFieldBegin(EventData.PHANTOM_RESULT_FIELD_DESC);
                    eventdata.phantomResult.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.isSetCompletedCaptcha())
                {
                    tprotocol.writeFieldBegin(EventData.COMPLETED_CAPTCHA_FIELD_DESC);
                    tprotocol.writeBool(eventdata.completedCaptcha);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.tripwireData != null && eventdata.isSetTripwireData())
                {
                    tprotocol.writeFieldBegin(EventData.TRIPWIRE_DATA_FIELD_DESC);
                    eventdata.tripwireData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.pinImpressions != null && eventdata.isSetPinImpressions())
                {
                    tprotocol.writeFieldBegin(EventData.PIN_IMPRESSIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, eventdata.pinImpressions.size()));
                    for (Iterator iterator = eventdata.pinImpressions.iterator(); iterator.hasNext(); ((PinImpression)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.isSetEnforceSpamRules())
                {
                    tprotocol.writeFieldBegin(EventData.ENFORCE_SPAM_RULES_FIELD_DESC);
                    tprotocol.writeBool(eventdata.enforceSpamRules);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.isSetAdminOverride())
                {
                    tprotocol.writeFieldBegin(EventData.ADMIN_OVERRIDE_FIELD_DESC);
                    tprotocol.writeBool(eventdata.adminOverride);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.interestImpressionData != null && eventdata.isSetInterestImpressionData())
                {
                    tprotocol.writeFieldBegin(EventData.INTEREST_IMPRESSION_DATA_FIELD_DESC);
                    eventdata.interestImpressionData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.browserIdData != null && eventdata.isSetBrowserIdData())
                {
                    tprotocol.writeFieldBegin(EventData.BROWSER_ID_DATA_FIELD_DESC);
                    eventdata.browserIdData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (eventdata.insertion != null && eventdata.isSetInsertion())
                {
                    tprotocol.writeFieldBegin(EventData.INSERTION_FIELD_DESC);
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

            private EventDataStandardScheme()
            {
            }

            EventDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class EventDataTupleSchemeFactory
        implements SchemeFactory
    {

        public EventDataTupleScheme getScheme()
        {
            return new EventDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventDataTupleSchemeFactory()
        {
        }

        EventDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventDataTupleScheme extends TupleScheme
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

            private EventDataTupleScheme()
            {
            }

            EventDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
