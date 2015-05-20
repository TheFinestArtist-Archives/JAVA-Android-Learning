// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

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
import org.apache.thrift.meta_data.MapMetaData;
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

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationObject, RecommendationEvent

public class QueuedEmailEvent
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BCC_FIELD_DESC = new TField("bcc", (byte)15, (short)9);
    private static final TField CATEGORIES_FIELD_DESC = new TField("categories", (byte)15, (short)8);
    private static final TField CONTEXT_JSON_FIELD_DESC = new TField("contextJson", (byte)11, (short)11);
    private static final TField EXPERIMENTS_FIELD_DESC = new TField("experiments", (byte)13, (short)10);
    private static final TField FROM_USER_ID_FIELD_DESC = new TField("fromUserId", (byte)10, (short)12);
    private static final TField MAIN_CATEGORY_FIELD_DESC = new TField("mainCategory", (byte)11, (short)7);
    private static final TField RECOMMENDATIONS_FIELD_DESC = new TField("recommendations", (byte)15, (short)13);
    private static final TField RECOMMENDATION_EVENT_FIELD_DESC = new TField("recommendationEvent", (byte)12, (short)14);
    private static final TStruct STRUCT_DESC = new TStruct("QueuedEmailEvent");
    private static final TField SUBJECT_FIELD_DESC = new TField("subject", (byte)11, (short)3);
    private static final TField TEMPLATE_FIELD_DESC = new TField("template", (byte)11, (short)4);
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)1);
    private static final TField TO_ADDRESS_FIELD_DESC = new TField("toAddress", (byte)11, (short)2);
    private static final TField TRACKING_ID_FIELD_DESC = new TField("trackingId", (byte)11, (short)6);
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)5);
    private static final int __FROMUSERID_ISSET_ID = 2;
    private static final int __TIME_ISSET_ID = 0;
    private static final int __USERID_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public List bcc;
    public List categories;
    public String contextJson;
    public Map experiments;
    public long fromUserId;
    public String mainCategory;
    public RecommendationEvent recommendationEvent;
    public List recommendations;
    public String subject;
    public String template;
    public long time;
    public String toAddress;
    public String trackingId;
    public long userId;

    public QueuedEmailEvent()
    {
        __isset_bitfield = 0;
    }

    public QueuedEmailEvent(long l, String s, String s1, String s2, long l1, 
            String s3, String s4, List list, List list1, Map map, String s5, long l2)
    {
        this();
        time = l;
        setTimeIsSet(true);
        toAddress = s;
        subject = s1;
        template = s2;
        userId = l1;
        setUserIdIsSet(true);
        trackingId = s3;
        mainCategory = s4;
        categories = list;
        bcc = list1;
        experiments = map;
        contextJson = s5;
        fromUserId = l2;
        setFromUserIdIsSet(true);
    }

    public QueuedEmailEvent(QueuedEmailEvent queuedemailevent)
    {
        __isset_bitfield = 0;
        __isset_bitfield = queuedemailevent.__isset_bitfield;
        time = queuedemailevent.time;
        if (queuedemailevent.isSetToAddress())
        {
            toAddress = queuedemailevent.toAddress;
        }
        if (queuedemailevent.isSetSubject())
        {
            subject = queuedemailevent.subject;
        }
        if (queuedemailevent.isSetTemplate())
        {
            template = queuedemailevent.template;
        }
        userId = queuedemailevent.userId;
        if (queuedemailevent.isSetTrackingId())
        {
            trackingId = queuedemailevent.trackingId;
        }
        if (queuedemailevent.isSetMainCategory())
        {
            mainCategory = queuedemailevent.mainCategory;
        }
        if (queuedemailevent.isSetCategories())
        {
            categories = new ArrayList(queuedemailevent.categories);
        }
        if (queuedemailevent.isSetBcc())
        {
            bcc = new ArrayList(queuedemailevent.bcc);
        }
        if (queuedemailevent.isSetExperiments())
        {
            experiments = new HashMap(queuedemailevent.experiments);
        }
        if (queuedemailevent.isSetContextJson())
        {
            contextJson = queuedemailevent.contextJson;
        }
        fromUserId = queuedemailevent.fromUserId;
        if (queuedemailevent.isSetRecommendations())
        {
            ArrayList arraylist = new ArrayList(queuedemailevent.recommendations.size());
            for (Iterator iterator = queuedemailevent.recommendations.iterator(); iterator.hasNext(); arraylist.add(new RecommendationObject((RecommendationObject)iterator.next()))) { }
            recommendations = arraylist;
        }
        if (queuedemailevent.isSetRecommendationEvent())
        {
            recommendationEvent = new RecommendationEvent(queuedemailevent.recommendationEvent);
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

    public void addToBcc(String s)
    {
        if (bcc == null)
        {
            bcc = new ArrayList();
        }
        bcc.add(s);
    }

    public void addToCategories(String s)
    {
        if (categories == null)
        {
            categories = new ArrayList();
        }
        categories.add(s);
    }

    public void addToRecommendations(RecommendationObject recommendationobject)
    {
        if (recommendations == null)
        {
            recommendations = new ArrayList();
        }
        recommendations.add(recommendationobject);
    }

    public void clear()
    {
        setTimeIsSet(false);
        time = 0L;
        toAddress = null;
        subject = null;
        template = null;
        setUserIdIsSet(false);
        userId = 0L;
        trackingId = null;
        mainCategory = null;
        categories = null;
        bcc = null;
        experiments = null;
        contextJson = null;
        setFromUserIdIsSet(false);
        fromUserId = 0L;
        recommendations = null;
        recommendationEvent = null;
    }

    public int compareTo(QueuedEmailEvent queuedemailevent)
    {
        if (getClass().equals(queuedemailevent.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(queuedemailevent.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(queuedemailevent.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, queuedemailevent.time);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetToAddress()).compareTo(Boolean.valueOf(queuedemailevent.isSetToAddress()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetToAddress())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(toAddress, queuedemailevent.toAddress);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetSubject()).compareTo(Boolean.valueOf(queuedemailevent.isSetSubject()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetSubject())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(subject, queuedemailevent.subject);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetTemplate()).compareTo(Boolean.valueOf(queuedemailevent.isSetTemplate()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetTemplate())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(template, queuedemailevent.template);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(queuedemailevent.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, queuedemailevent.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetTrackingId()).compareTo(Boolean.valueOf(queuedemailevent.isSetTrackingId()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetTrackingId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(trackingId, queuedemailevent.trackingId);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetMainCategory()).compareTo(Boolean.valueOf(queuedemailevent.isSetMainCategory()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetMainCategory())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(mainCategory, queuedemailevent.mainCategory);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetCategories()).compareTo(Boolean.valueOf(queuedemailevent.isSetCategories()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetCategories())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(categories, queuedemailevent.categories);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        j = Boolean.valueOf(isSetBcc()).compareTo(Boolean.valueOf(queuedemailevent.isSetBcc()));
        i = j;
        if (j != 0) goto _L4; else goto _L20
_L20:
        if (!isSetBcc())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(bcc, queuedemailevent.bcc);
        i = j;
        if (j != 0) goto _L4; else goto _L21
_L21:
        j = Boolean.valueOf(isSetExperiments()).compareTo(Boolean.valueOf(queuedemailevent.isSetExperiments()));
        i = j;
        if (j != 0) goto _L4; else goto _L22
_L22:
        if (!isSetExperiments())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experiments, queuedemailevent.experiments);
        i = j;
        if (j != 0) goto _L4; else goto _L23
_L23:
        j = Boolean.valueOf(isSetContextJson()).compareTo(Boolean.valueOf(queuedemailevent.isSetContextJson()));
        i = j;
        if (j != 0) goto _L4; else goto _L24
_L24:
        if (!isSetContextJson())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(contextJson, queuedemailevent.contextJson);
        i = j;
        if (j != 0) goto _L4; else goto _L25
_L25:
        j = Boolean.valueOf(isSetFromUserId()).compareTo(Boolean.valueOf(queuedemailevent.isSetFromUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L26
_L26:
        if (!isSetFromUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(fromUserId, queuedemailevent.fromUserId);
        i = j;
        if (j != 0) goto _L4; else goto _L27
_L27:
        j = Boolean.valueOf(isSetRecommendations()).compareTo(Boolean.valueOf(queuedemailevent.isSetRecommendations()));
        i = j;
        if (j != 0) goto _L4; else goto _L28
_L28:
        if (!isSetRecommendations())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendations, queuedemailevent.recommendations);
        i = j;
        if (j != 0) goto _L4; else goto _L29
_L29:
        j = Boolean.valueOf(isSetRecommendationEvent()).compareTo(Boolean.valueOf(queuedemailevent.isSetRecommendationEvent()));
        i = j;
        if (j != 0) goto _L4; else goto _L30
_L30:
        if (!isSetRecommendationEvent())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendationEvent, queuedemailevent.recommendationEvent);
        i = j;
        if (j != 0) goto _L4; else goto _L31
_L31:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((QueuedEmailEvent)obj);
    }

    public QueuedEmailEvent deepCopy()
    {
        return new QueuedEmailEvent(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(QueuedEmailEvent queuedemailevent)
    {
        if (queuedemailevent != null && time == queuedemailevent.time)
        {
            boolean flag = isSetToAddress();
            boolean flag11 = queuedemailevent.isSetToAddress();
            if (!flag && !flag11 || flag && flag11 && toAddress.equals(queuedemailevent.toAddress))
            {
                boolean flag1 = isSetSubject();
                boolean flag12 = queuedemailevent.isSetSubject();
                if (!flag1 && !flag12 || flag1 && flag12 && subject.equals(queuedemailevent.subject))
                {
                    boolean flag2 = isSetTemplate();
                    boolean flag13 = queuedemailevent.isSetTemplate();
                    if ((!flag2 && !flag13 || flag2 && flag13 && template.equals(queuedemailevent.template)) && userId == queuedemailevent.userId)
                    {
                        boolean flag3 = isSetTrackingId();
                        boolean flag14 = queuedemailevent.isSetTrackingId();
                        if (!flag3 && !flag14 || flag3 && flag14 && trackingId.equals(queuedemailevent.trackingId))
                        {
                            boolean flag4 = isSetMainCategory();
                            boolean flag15 = queuedemailevent.isSetMainCategory();
                            if (!flag4 && !flag15 || flag4 && flag15 && mainCategory.equals(queuedemailevent.mainCategory))
                            {
                                boolean flag5 = isSetCategories();
                                boolean flag16 = queuedemailevent.isSetCategories();
                                if (!flag5 && !flag16 || flag5 && flag16 && categories.equals(queuedemailevent.categories))
                                {
                                    boolean flag6 = isSetBcc();
                                    boolean flag17 = queuedemailevent.isSetBcc();
                                    if (!flag6 && !flag17 || flag6 && flag17 && bcc.equals(queuedemailevent.bcc))
                                    {
                                        boolean flag7 = isSetExperiments();
                                        boolean flag18 = queuedemailevent.isSetExperiments();
                                        if (!flag7 && !flag18 || flag7 && flag18 && experiments.equals(queuedemailevent.experiments))
                                        {
                                            boolean flag8 = isSetContextJson();
                                            boolean flag19 = queuedemailevent.isSetContextJson();
                                            if ((!flag8 && !flag19 || flag8 && flag19 && contextJson.equals(queuedemailevent.contextJson)) && fromUserId == queuedemailevent.fromUserId)
                                            {
                                                boolean flag9 = isSetRecommendations();
                                                boolean flag20 = queuedemailevent.isSetRecommendations();
                                                if (!flag9 && !flag20 || flag9 && flag20 && recommendations.equals(queuedemailevent.recommendations))
                                                {
                                                    boolean flag10 = isSetRecommendationEvent();
                                                    boolean flag21 = queuedemailevent.isSetRecommendationEvent();
                                                    if (!flag10 && !flag21 || flag10 && flag21 && recommendationEvent.equals(queuedemailevent.recommendationEvent))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof QueuedEmailEvent)) 
        {
            return false;
        }
        return equals((QueuedEmailEvent)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public List getBcc()
    {
        return bcc;
    }

    public Iterator getBccIterator()
    {
        if (bcc == null)
        {
            return null;
        } else
        {
            return bcc.iterator();
        }
    }

    public int getBccSize()
    {
        if (bcc == null)
        {
            return 0;
        } else
        {
            return bcc.size();
        }
    }

    public List getCategories()
    {
        return categories;
    }

    public Iterator getCategoriesIterator()
    {
        if (categories == null)
        {
            return null;
        } else
        {
            return categories.iterator();
        }
    }

    public int getCategoriesSize()
    {
        if (categories == null)
        {
            return 0;
        } else
        {
            return categories.size();
        }
    }

    public String getContextJson()
    {
        return contextJson;
    }

    public Map getExperiments()
    {
        return experiments;
    }

    public int getExperimentsSize()
    {
        if (experiments == null)
        {
            return 0;
        } else
        {
            return experiments.size();
        }
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.QueuedEmailEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getTime());

        case 2: // '\002'
            return getToAddress();

        case 3: // '\003'
            return getSubject();

        case 4: // '\004'
            return getTemplate();

        case 5: // '\005'
            return Long.valueOf(getUserId());

        case 6: // '\006'
            return getTrackingId();

        case 7: // '\007'
            return getMainCategory();

        case 8: // '\b'
            return getCategories();

        case 9: // '\t'
            return getBcc();

        case 10: // '\n'
            return getExperiments();

        case 11: // '\013'
            return getContextJson();

        case 12: // '\f'
            return Long.valueOf(getFromUserId());

        case 13: // '\r'
            return getRecommendations();

        case 14: // '\016'
            return getRecommendationEvent();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public long getFromUserId()
    {
        return fromUserId;
    }

    public String getMainCategory()
    {
        return mainCategory;
    }

    public RecommendationEvent getRecommendationEvent()
    {
        return recommendationEvent;
    }

    public List getRecommendations()
    {
        return recommendations;
    }

    public Iterator getRecommendationsIterator()
    {
        if (recommendations == null)
        {
            return null;
        } else
        {
            return recommendations.iterator();
        }
    }

    public int getRecommendationsSize()
    {
        if (recommendations == null)
        {
            return 0;
        } else
        {
            return recommendations.size();
        }
    }

    public String getSubject()
    {
        return subject;
    }

    public String getTemplate()
    {
        return template;
    }

    public long getTime()
    {
        return time;
    }

    public String getToAddress()
    {
        return toAddress;
    }

    public String getTrackingId()
    {
        return trackingId;
    }

    public long getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        boolean flag = isSetToAddress();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(toAddress);
        }
        flag = isSetSubject();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(subject);
        }
        flag = isSetTemplate();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(template);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(userId));
        flag = isSetTrackingId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(trackingId);
        }
        flag = isSetMainCategory();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(mainCategory);
        }
        flag = isSetCategories();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(categories);
        }
        flag = isSetBcc();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(bcc);
        }
        flag = isSetExperiments();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(experiments);
        }
        flag = isSetContextJson();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(contextJson);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(fromUserId));
        flag = isSetRecommendations();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendations);
        }
        flag = isSetRecommendationEvent();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendationEvent);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.QueuedEmailEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTime();

        case 2: // '\002'
            return isSetToAddress();

        case 3: // '\003'
            return isSetSubject();

        case 4: // '\004'
            return isSetTemplate();

        case 5: // '\005'
            return isSetUserId();

        case 6: // '\006'
            return isSetTrackingId();

        case 7: // '\007'
            return isSetMainCategory();

        case 8: // '\b'
            return isSetCategories();

        case 9: // '\t'
            return isSetBcc();

        case 10: // '\n'
            return isSetExperiments();

        case 11: // '\013'
            return isSetContextJson();

        case 12: // '\f'
            return isSetFromUserId();

        case 13: // '\r'
            return isSetRecommendations();

        case 14: // '\016'
            return isSetRecommendationEvent();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBcc()
    {
        return bcc != null;
    }

    public boolean isSetCategories()
    {
        return categories != null;
    }

    public boolean isSetContextJson()
    {
        return contextJson != null;
    }

    public boolean isSetExperiments()
    {
        return experiments != null;
    }

    public boolean isSetFromUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetMainCategory()
    {
        return mainCategory != null;
    }

    public boolean isSetRecommendationEvent()
    {
        return recommendationEvent != null;
    }

    public boolean isSetRecommendations()
    {
        return recommendations != null;
    }

    public boolean isSetSubject()
    {
        return subject != null;
    }

    public boolean isSetTemplate()
    {
        return template != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetToAddress()
    {
        return toAddress != null;
    }

    public boolean isSetTrackingId()
    {
        return trackingId != null;
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public void putToExperiments(String s, String s1)
    {
        if (experiments == null)
        {
            experiments = new HashMap();
        }
        experiments.put(s, s1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public QueuedEmailEvent setBcc(List list)
    {
        bcc = list;
        return this;
    }

    public void setBccIsSet(boolean flag)
    {
        if (!flag)
        {
            bcc = null;
        }
    }

    public QueuedEmailEvent setCategories(List list)
    {
        categories = list;
        return this;
    }

    public void setCategoriesIsSet(boolean flag)
    {
        if (!flag)
        {
            categories = null;
        }
    }

    public QueuedEmailEvent setContextJson(String s)
    {
        contextJson = s;
        return this;
    }

    public void setContextJsonIsSet(boolean flag)
    {
        if (!flag)
        {
            contextJson = null;
        }
    }

    public QueuedEmailEvent setExperiments(Map map)
    {
        experiments = map;
        return this;
    }

    public void setExperimentsIsSet(boolean flag)
    {
        if (!flag)
        {
            experiments = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.QueuedEmailEvent._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetToAddress();
                return;
            } else
            {
                setToAddress((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetSubject();
                return;
            } else
            {
                setSubject((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetTemplate();
                return;
            } else
            {
                setTemplate((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetUserId();
                return;
            } else
            {
                setUserId(((Long)obj).longValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetTrackingId();
                return;
            } else
            {
                setTrackingId((String)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetMainCategory();
                return;
            } else
            {
                setMainCategory((String)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetCategories();
                return;
            } else
            {
                setCategories((List)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetBcc();
                return;
            } else
            {
                setBcc((List)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetExperiments();
                return;
            } else
            {
                setExperiments((Map)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetContextJson();
                return;
            } else
            {
                setContextJson((String)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetFromUserId();
                return;
            } else
            {
                setFromUserId(((Long)obj).longValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetRecommendations();
                return;
            } else
            {
                setRecommendations((List)obj);
                return;
            }

        case 14: // '\016'
            break;
        }
        if (obj == null)
        {
            unsetRecommendationEvent();
            return;
        } else
        {
            setRecommendationEvent((RecommendationEvent)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public QueuedEmailEvent setFromUserId(long l)
    {
        fromUserId = l;
        setFromUserIdIsSet(true);
        return this;
    }

    public void setFromUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public QueuedEmailEvent setMainCategory(String s)
    {
        mainCategory = s;
        return this;
    }

    public void setMainCategoryIsSet(boolean flag)
    {
        if (!flag)
        {
            mainCategory = null;
        }
    }

    public QueuedEmailEvent setRecommendationEvent(RecommendationEvent recommendationevent)
    {
        recommendationEvent = recommendationevent;
        return this;
    }

    public void setRecommendationEventIsSet(boolean flag)
    {
        if (!flag)
        {
            recommendationEvent = null;
        }
    }

    public QueuedEmailEvent setRecommendations(List list)
    {
        recommendations = list;
        return this;
    }

    public void setRecommendationsIsSet(boolean flag)
    {
        if (!flag)
        {
            recommendations = null;
        }
    }

    public QueuedEmailEvent setSubject(String s)
    {
        subject = s;
        return this;
    }

    public void setSubjectIsSet(boolean flag)
    {
        if (!flag)
        {
            subject = null;
        }
    }

    public QueuedEmailEvent setTemplate(String s)
    {
        template = s;
        return this;
    }

    public void setTemplateIsSet(boolean flag)
    {
        if (!flag)
        {
            template = null;
        }
    }

    public QueuedEmailEvent setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public QueuedEmailEvent setToAddress(String s)
    {
        toAddress = s;
        return this;
    }

    public void setToAddressIsSet(boolean flag)
    {
        if (!flag)
        {
            toAddress = null;
        }
    }

    public QueuedEmailEvent setTrackingId(String s)
    {
        trackingId = s;
        return this;
    }

    public void setTrackingIdIsSet(boolean flag)
    {
        if (!flag)
        {
            trackingId = null;
        }
    }

    public QueuedEmailEvent setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("QueuedEmailEvent(");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        stringbuilder.append(", ");
        stringbuilder.append("toAddress:");
        if (toAddress == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(toAddress);
        }
        stringbuilder.append(", ");
        stringbuilder.append("subject:");
        if (subject == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(subject);
        }
        stringbuilder.append(", ");
        stringbuilder.append("template:");
        if (template == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(template);
        }
        stringbuilder.append(", ");
        stringbuilder.append("userId:");
        stringbuilder.append(userId);
        stringbuilder.append(", ");
        stringbuilder.append("trackingId:");
        if (trackingId == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(trackingId);
        }
        stringbuilder.append(", ");
        stringbuilder.append("mainCategory:");
        if (mainCategory == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(mainCategory);
        }
        stringbuilder.append(", ");
        stringbuilder.append("categories:");
        if (categories == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(categories);
        }
        stringbuilder.append(", ");
        stringbuilder.append("bcc:");
        if (bcc == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(bcc);
        }
        stringbuilder.append(", ");
        stringbuilder.append("experiments:");
        if (experiments == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(experiments);
        }
        stringbuilder.append(", ");
        stringbuilder.append("contextJson:");
        if (contextJson == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(contextJson);
        }
        stringbuilder.append(", ");
        stringbuilder.append("fromUserId:");
        stringbuilder.append(fromUserId);
        if (isSetRecommendations())
        {
            stringbuilder.append(", ");
            stringbuilder.append("recommendations:");
            if (recommendations == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(recommendations);
            }
        }
        if (isSetRecommendationEvent())
        {
            stringbuilder.append(", ");
            stringbuilder.append("recommendationEvent:");
            if (recommendationEvent == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(recommendationEvent);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBcc()
    {
        bcc = null;
    }

    public void unsetCategories()
    {
        categories = null;
    }

    public void unsetContextJson()
    {
        contextJson = null;
    }

    public void unsetExperiments()
    {
        experiments = null;
    }

    public void unsetFromUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetMainCategory()
    {
        mainCategory = null;
    }

    public void unsetRecommendationEvent()
    {
        recommendationEvent = null;
    }

    public void unsetRecommendations()
    {
        recommendations = null;
    }

    public void unsetSubject()
    {
        subject = null;
    }

    public void unsetTemplate()
    {
        template = null;
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetToAddress()
    {
        toAddress = null;
    }

    public void unsetTrackingId()
    {
        trackingId = null;
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void validate()
    {
        if (recommendationEvent != null)
        {
            recommendationEvent.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new QueuedEmailEventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new QueuedEmailEventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.RECOMMENDATIONS, _Fields.RECOMMENDATION_EVENT
        });
        obj = new EnumMap(com/pinterest/schemas/email_queued/QueuedEmailEvent$_Fields);
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.TO_ADDRESS, new FieldMetaData("toAddress", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SUBJECT, new FieldMetaData("subject", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TEMPLATE, new FieldMetaData("template", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.TRACKING_ID, new FieldMetaData("trackingId", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.MAIN_CATEGORY, new FieldMetaData("mainCategory", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.CATEGORIES, new FieldMetaData("categories", (byte)3, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.BCC, new FieldMetaData("bcc", (byte)3, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.EXPERIMENTS, new FieldMetaData("experiments", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.CONTEXT_JSON, new FieldMetaData("contextJson", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.FROM_USER_ID, new FieldMetaData("fromUserId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.RECOMMENDATIONS, new FieldMetaData("recommendations", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/RecommendationObject))));
        ((Map) (obj)).put(_Fields.RECOMMENDATION_EVENT, new FieldMetaData("recommendationEvent", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/RecommendationEvent)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/QueuedEmailEvent, metaDataMap);
    }
















    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BCC;
        public static final _Fields CATEGORIES;
        public static final _Fields CONTEXT_JSON;
        public static final _Fields EXPERIMENTS;
        public static final _Fields FROM_USER_ID;
        public static final _Fields MAIN_CATEGORY;
        public static final _Fields RECOMMENDATIONS;
        public static final _Fields RECOMMENDATION_EVENT;
        public static final _Fields SUBJECT;
        public static final _Fields TEMPLATE;
        public static final _Fields TIME;
        public static final _Fields TO_ADDRESS;
        public static final _Fields TRACKING_ID;
        public static final _Fields USER_ID;
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
                return TIME;

            case 2: // '\002'
                return TO_ADDRESS;

            case 3: // '\003'
                return SUBJECT;

            case 4: // '\004'
                return TEMPLATE;

            case 5: // '\005'
                return USER_ID;

            case 6: // '\006'
                return TRACKING_ID;

            case 7: // '\007'
                return MAIN_CATEGORY;

            case 8: // '\b'
                return CATEGORIES;

            case 9: // '\t'
                return BCC;

            case 10: // '\n'
                return EXPERIMENTS;

            case 11: // '\013'
                return CONTEXT_JSON;

            case 12: // '\f'
                return FROM_USER_ID;

            case 13: // '\r'
                return RECOMMENDATIONS;

            case 14: // '\016'
                return RECOMMENDATION_EVENT;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/QueuedEmailEvent$_Fields, s);
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
            TIME = new _Fields("TIME", 0, (short)1, "time");
            TO_ADDRESS = new _Fields("TO_ADDRESS", 1, (short)2, "toAddress");
            SUBJECT = new _Fields("SUBJECT", 2, (short)3, "subject");
            TEMPLATE = new _Fields("TEMPLATE", 3, (short)4, "template");
            USER_ID = new _Fields("USER_ID", 4, (short)5, "userId");
            TRACKING_ID = new _Fields("TRACKING_ID", 5, (short)6, "trackingId");
            MAIN_CATEGORY = new _Fields("MAIN_CATEGORY", 6, (short)7, "mainCategory");
            CATEGORIES = new _Fields("CATEGORIES", 7, (short)8, "categories");
            BCC = new _Fields("BCC", 8, (short)9, "bcc");
            EXPERIMENTS = new _Fields("EXPERIMENTS", 9, (short)10, "experiments");
            CONTEXT_JSON = new _Fields("CONTEXT_JSON", 10, (short)11, "contextJson");
            FROM_USER_ID = new _Fields("FROM_USER_ID", 11, (short)12, "fromUserId");
            RECOMMENDATIONS = new _Fields("RECOMMENDATIONS", 12, (short)13, "recommendations");
            RECOMMENDATION_EVENT = new _Fields("RECOMMENDATION_EVENT", 13, (short)14, "recommendationEvent");
            $VALUES = (new _Fields[] {
                TIME, TO_ADDRESS, SUBJECT, TEMPLATE, USER_ID, TRACKING_ID, MAIN_CATEGORY, CATEGORIES, BCC, EXPERIMENTS, 
                CONTEXT_JSON, FROM_USER_ID, RECOMMENDATIONS, RECOMMENDATION_EVENT
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/QueuedEmailEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.TIME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.TO_ADDRESS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.SUBJECT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.TEMPLATE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.USER_ID.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.TRACKING_ID.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.MAIN_CATEGORY.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.CATEGORIES.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.BCC.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.EXPERIMENTS.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.CONTEXT_JSON.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.FROM_USER_ID.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.RECOMMENDATIONS.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$QueuedEmailEvent$_Fields[_Fields.RECOMMENDATION_EVENT.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class QueuedEmailEventStandardSchemeFactory
        implements SchemeFactory
    {

        public QueuedEmailEventStandardScheme getScheme()
        {
            return new QueuedEmailEventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private QueuedEmailEventStandardSchemeFactory()
        {
        }

        QueuedEmailEventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class QueuedEmailEventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, QueuedEmailEvent queuedemailevent)
            {
                tprotocol.readStructBegin();
_L17:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_861;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 14: default 92
            //                           1 107
            //                           2 143
            //                           3 179
            //                           4 215
            //                           5 251
            //                           6 287
            //                           7 323
            //                           8 359
            //                           9 450
            //                           10 541
            //                           11 642
            //                           12 678
            //                           13 714
            //                           14 814;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L15:
                break MISSING_BLOCK_LABEL_814;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L18:
                tprotocol.readFieldEnd();
                if (true) goto _L17; else goto _L16
_L16:
                if (((TField) (obj)).type == 10)
                {
                    queuedemailevent.time = tprotocol.readI64();
                    queuedemailevent.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L3:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.toAddress = tprotocol.readString();
                    queuedemailevent.setToAddressIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L4:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.subject = tprotocol.readString();
                    queuedemailevent.setSubjectIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L5:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.template = tprotocol.readString();
                    queuedemailevent.setTemplateIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L6:
                if (((TField) (obj)).type == 10)
                {
                    queuedemailevent.userId = tprotocol.readI64();
                    queuedemailevent.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L7:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.trackingId = tprotocol.readString();
                    queuedemailevent.setTrackingIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L8:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.mainCategory = tprotocol.readString();
                    queuedemailevent.setMainCategoryIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L9:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    queuedemailevent.categories = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        String s = tprotocol.readString();
                        queuedemailevent.categories.add(s);
                    }

                    tprotocol.readListEnd();
                    queuedemailevent.setCategoriesIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L10:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    queuedemailevent.bcc = new ArrayList(((TList) (obj)).size);
                    for (int j = 0; j < ((TList) (obj)).size; j++)
                    {
                        String s1 = tprotocol.readString();
                        queuedemailevent.bcc.add(s1);
                    }

                    tprotocol.readListEnd();
                    queuedemailevent.setBccIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L11:
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    queuedemailevent.experiments = new HashMap(((TMap) (obj)).size * 2);
                    for (int k = 0; k < ((TMap) (obj)).size; k++)
                    {
                        String s2 = tprotocol.readString();
                        String s3 = tprotocol.readString();
                        queuedemailevent.experiments.put(s2, s3);
                    }

                    tprotocol.readMapEnd();
                    queuedemailevent.setExperimentsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L12:
                if (((TField) (obj)).type == 11)
                {
                    queuedemailevent.contextJson = tprotocol.readString();
                    queuedemailevent.setContextJsonIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L13:
                if (((TField) (obj)).type == 10)
                {
                    queuedemailevent.fromUserId = tprotocol.readI64();
                    queuedemailevent.setFromUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
_L14:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    queuedemailevent.recommendations = new ArrayList(((TList) (obj)).size);
                    for (int l = 0; l < ((TList) (obj)).size; l++)
                    {
                        RecommendationObject recommendationobject = new RecommendationObject();
                        recommendationobject.read(tprotocol);
                        queuedemailevent.recommendations.add(recommendationobject);
                    }

                    tprotocol.readListEnd();
                    queuedemailevent.setRecommendationsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
                if (((TField) (obj)).type == 12)
                {
                    queuedemailevent.recommendationEvent = new RecommendationEvent();
                    queuedemailevent.recommendationEvent.read(tprotocol);
                    queuedemailevent.setRecommendationEventIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L18
                tprotocol.readStructEnd();
                queuedemailevent.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (QueuedEmailEvent)tbase);
            }

            public void write(TProtocol tprotocol, QueuedEmailEvent queuedemailevent)
            {
                queuedemailevent.validate();
                tprotocol.writeStructBegin(QueuedEmailEvent.STRUCT_DESC);
                tprotocol.writeFieldBegin(QueuedEmailEvent.TIME_FIELD_DESC);
                tprotocol.writeI64(queuedemailevent.time);
                tprotocol.writeFieldEnd();
                if (queuedemailevent.toAddress != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.TO_ADDRESS_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.toAddress);
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.subject != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.SUBJECT_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.subject);
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.template != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.TEMPLATE_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.template);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(QueuedEmailEvent.USER_ID_FIELD_DESC);
                tprotocol.writeI64(queuedemailevent.userId);
                tprotocol.writeFieldEnd();
                if (queuedemailevent.trackingId != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.TRACKING_ID_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.trackingId);
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.mainCategory != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.MAIN_CATEGORY_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.mainCategory);
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.categories != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.CATEGORIES_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)11, queuedemailevent.categories.size()));
                    for (Iterator iterator = queuedemailevent.categories.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.bcc != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.BCC_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)11, queuedemailevent.bcc.size()));
                    for (Iterator iterator1 = queuedemailevent.bcc.iterator(); iterator1.hasNext(); tprotocol.writeString((String)iterator1.next())) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.experiments != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.EXPERIMENTS_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, queuedemailevent.experiments.size()));
                    java.util.Map.Entry entry;
                    for (Iterator iterator2 = queuedemailevent.experiments.entrySet().iterator(); iterator2.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator2.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.contextJson != null)
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.CONTEXT_JSON_FIELD_DESC);
                    tprotocol.writeString(queuedemailevent.contextJson);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(QueuedEmailEvent.FROM_USER_ID_FIELD_DESC);
                tprotocol.writeI64(queuedemailevent.fromUserId);
                tprotocol.writeFieldEnd();
                if (queuedemailevent.recommendations != null && queuedemailevent.isSetRecommendations())
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.RECOMMENDATIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, queuedemailevent.recommendations.size()));
                    for (Iterator iterator3 = queuedemailevent.recommendations.iterator(); iterator3.hasNext(); ((RecommendationObject)iterator3.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (queuedemailevent.recommendationEvent != null && queuedemailevent.isSetRecommendationEvent())
                {
                    tprotocol.writeFieldBegin(QueuedEmailEvent.RECOMMENDATION_EVENT_FIELD_DESC);
                    queuedemailevent.recommendationEvent.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (QueuedEmailEvent)tbase);
            }

            private QueuedEmailEventStandardScheme()
            {
            }

            QueuedEmailEventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class QueuedEmailEventTupleSchemeFactory
        implements SchemeFactory
    {

        public QueuedEmailEventTupleScheme getScheme()
        {
            return new QueuedEmailEventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private QueuedEmailEventTupleSchemeFactory()
        {
        }

        QueuedEmailEventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class QueuedEmailEventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, QueuedEmailEvent queuedemailevent)
            {
                boolean flag = false;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(14);
                if (bitset.get(0))
                {
                    queuedemailevent.time = tprotocol.readI64();
                    queuedemailevent.setTimeIsSet(true);
                }
                if (bitset.get(1))
                {
                    queuedemailevent.toAddress = tprotocol.readString();
                    queuedemailevent.setToAddressIsSet(true);
                }
                if (bitset.get(2))
                {
                    queuedemailevent.subject = tprotocol.readString();
                    queuedemailevent.setSubjectIsSet(true);
                }
                if (bitset.get(3))
                {
                    queuedemailevent.template = tprotocol.readString();
                    queuedemailevent.setTemplateIsSet(true);
                }
                if (bitset.get(4))
                {
                    queuedemailevent.userId = tprotocol.readI64();
                    queuedemailevent.setUserIdIsSet(true);
                }
                if (bitset.get(5))
                {
                    queuedemailevent.trackingId = tprotocol.readString();
                    queuedemailevent.setTrackingIdIsSet(true);
                }
                if (bitset.get(6))
                {
                    queuedemailevent.mainCategory = tprotocol.readString();
                    queuedemailevent.setMainCategoryIsSet(true);
                }
                if (bitset.get(7))
                {
                    TList tlist = new TList((byte)11, tprotocol.readI32());
                    queuedemailevent.categories = new ArrayList(tlist.size);
                    for (int i = 0; i < tlist.size; i++)
                    {
                        String s = tprotocol.readString();
                        queuedemailevent.categories.add(s);
                    }

                    queuedemailevent.setCategoriesIsSet(true);
                }
                if (bitset.get(8))
                {
                    TList tlist1 = new TList((byte)11, tprotocol.readI32());
                    queuedemailevent.bcc = new ArrayList(tlist1.size);
                    for (int j = 0; j < tlist1.size; j++)
                    {
                        String s1 = tprotocol.readString();
                        queuedemailevent.bcc.add(s1);
                    }

                    queuedemailevent.setBccIsSet(true);
                }
                if (bitset.get(9))
                {
                    TMap tmap = new TMap((byte)11, (byte)11, tprotocol.readI32());
                    queuedemailevent.experiments = new HashMap(tmap.size * 2);
                    for (int k = 0; k < tmap.size; k++)
                    {
                        String s2 = tprotocol.readString();
                        String s3 = tprotocol.readString();
                        queuedemailevent.experiments.put(s2, s3);
                    }

                    queuedemailevent.setExperimentsIsSet(true);
                }
                if (bitset.get(10))
                {
                    queuedemailevent.contextJson = tprotocol.readString();
                    queuedemailevent.setContextJsonIsSet(true);
                }
                if (bitset.get(11))
                {
                    queuedemailevent.fromUserId = tprotocol.readI64();
                    queuedemailevent.setFromUserIdIsSet(true);
                }
                if (bitset.get(12))
                {
                    TList tlist2 = new TList((byte)12, tprotocol.readI32());
                    queuedemailevent.recommendations = new ArrayList(tlist2.size);
                    for (int l = ((flag) ? 1 : 0); l < tlist2.size; l++)
                    {
                        RecommendationObject recommendationobject = new RecommendationObject();
                        recommendationobject.read(tprotocol);
                        queuedemailevent.recommendations.add(recommendationobject);
                    }

                    queuedemailevent.setRecommendationsIsSet(true);
                }
                if (bitset.get(13))
                {
                    queuedemailevent.recommendationEvent = new RecommendationEvent();
                    queuedemailevent.recommendationEvent.read(tprotocol);
                    queuedemailevent.setRecommendationEventIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (QueuedEmailEvent)tbase);
            }

            public void write(TProtocol tprotocol, QueuedEmailEvent queuedemailevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (queuedemailevent.isSetTime())
                {
                    bitset.set(0);
                }
                if (queuedemailevent.isSetToAddress())
                {
                    bitset.set(1);
                }
                if (queuedemailevent.isSetSubject())
                {
                    bitset.set(2);
                }
                if (queuedemailevent.isSetTemplate())
                {
                    bitset.set(3);
                }
                if (queuedemailevent.isSetUserId())
                {
                    bitset.set(4);
                }
                if (queuedemailevent.isSetTrackingId())
                {
                    bitset.set(5);
                }
                if (queuedemailevent.isSetMainCategory())
                {
                    bitset.set(6);
                }
                if (queuedemailevent.isSetCategories())
                {
                    bitset.set(7);
                }
                if (queuedemailevent.isSetBcc())
                {
                    bitset.set(8);
                }
                if (queuedemailevent.isSetExperiments())
                {
                    bitset.set(9);
                }
                if (queuedemailevent.isSetContextJson())
                {
                    bitset.set(10);
                }
                if (queuedemailevent.isSetFromUserId())
                {
                    bitset.set(11);
                }
                if (queuedemailevent.isSetRecommendations())
                {
                    bitset.set(12);
                }
                if (queuedemailevent.isSetRecommendationEvent())
                {
                    bitset.set(13);
                }
                tprotocol.writeBitSet(bitset, 14);
                if (queuedemailevent.isSetTime())
                {
                    tprotocol.writeI64(queuedemailevent.time);
                }
                if (queuedemailevent.isSetToAddress())
                {
                    tprotocol.writeString(queuedemailevent.toAddress);
                }
                if (queuedemailevent.isSetSubject())
                {
                    tprotocol.writeString(queuedemailevent.subject);
                }
                if (queuedemailevent.isSetTemplate())
                {
                    tprotocol.writeString(queuedemailevent.template);
                }
                if (queuedemailevent.isSetUserId())
                {
                    tprotocol.writeI64(queuedemailevent.userId);
                }
                if (queuedemailevent.isSetTrackingId())
                {
                    tprotocol.writeString(queuedemailevent.trackingId);
                }
                if (queuedemailevent.isSetMainCategory())
                {
                    tprotocol.writeString(queuedemailevent.mainCategory);
                }
                if (queuedemailevent.isSetCategories())
                {
                    tprotocol.writeI32(queuedemailevent.categories.size());
                    for (Iterator iterator = queuedemailevent.categories.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                }
                if (queuedemailevent.isSetBcc())
                {
                    tprotocol.writeI32(queuedemailevent.bcc.size());
                    for (Iterator iterator1 = queuedemailevent.bcc.iterator(); iterator1.hasNext(); tprotocol.writeString((String)iterator1.next())) { }
                }
                if (queuedemailevent.isSetExperiments())
                {
                    tprotocol.writeI32(queuedemailevent.experiments.size());
                    java.util.Map.Entry entry;
                    for (Iterator iterator2 = queuedemailevent.experiments.entrySet().iterator(); iterator2.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator2.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                }
                if (queuedemailevent.isSetContextJson())
                {
                    tprotocol.writeString(queuedemailevent.contextJson);
                }
                if (queuedemailevent.isSetFromUserId())
                {
                    tprotocol.writeI64(queuedemailevent.fromUserId);
                }
                if (queuedemailevent.isSetRecommendations())
                {
                    tprotocol.writeI32(queuedemailevent.recommendations.size());
                    for (Iterator iterator3 = queuedemailevent.recommendations.iterator(); iterator3.hasNext(); ((RecommendationObject)iterator3.next()).write(tprotocol)) { }
                }
                if (queuedemailevent.isSetRecommendationEvent())
                {
                    queuedemailevent.recommendationEvent.write(tprotocol);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (QueuedEmailEvent)tbase);
            }

            private QueuedEmailEventTupleScheme()
            {
            }

            QueuedEmailEventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
