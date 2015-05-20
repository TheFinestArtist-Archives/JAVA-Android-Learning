// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
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
//            VisualObjectData

public class ViewData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ANALYTICS_SELECTED_APPLICATION_FIELD_DESC = new TField("analyticsSelectedApplication", (byte)11, (short)6);
    private static final TField INTEREST_NAME_FIELD_DESC = new TField("interestName", (byte)11, (short)2);
    private static final TField OBJECT_DATA_FIELD_DESC = new TField("objectData", (byte)12, (short)4);
    private static final TField SEARCH_QUERY_FIELD_DESC = new TField("searchQuery", (byte)11, (short)5);
    private static final TStruct STRUCT_DESC = new TStruct("ViewData");
    private static final TField STUB_FIELD_DESC = new TField("stub", (byte)8, (short)1);
    private static final TField VIEW_OBJECT_ID_FIELD_DESC = new TField("viewObjectId", (byte)10, (short)3);
    private static final TField VIEW_OBJECT_ID_STR_FIELD_DESC = new TField("viewObjectIdStr", (byte)11, (short)7);
    private static final int __STUB_ISSET_ID = 0;
    private static final int __VIEWOBJECTID_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String analyticsSelectedApplication;
    public String interestName;
    public VisualObjectData objectData;
    public String searchQuery;
    public int stub;
    public long viewObjectId;
    public String viewObjectIdStr;

    public ViewData()
    {
        __isset_bitfield = 0;
    }

    public ViewData(ViewData viewdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = viewdata.__isset_bitfield;
        stub = viewdata.stub;
        if (viewdata.isSetInterestName())
        {
            interestName = viewdata.interestName;
        }
        viewObjectId = viewdata.viewObjectId;
        if (viewdata.isSetObjectData())
        {
            objectData = new VisualObjectData(viewdata.objectData);
        }
        if (viewdata.isSetSearchQuery())
        {
            searchQuery = viewdata.searchQuery;
        }
        if (viewdata.isSetAnalyticsSelectedApplication())
        {
            analyticsSelectedApplication = viewdata.analyticsSelectedApplication;
        }
        if (viewdata.isSetViewObjectIdStr())
        {
            viewObjectIdStr = viewdata.viewObjectIdStr;
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

    public void clear()
    {
        setStubIsSet(false);
        stub = 0;
        interestName = null;
        setViewObjectIdIsSet(false);
        viewObjectId = 0L;
        objectData = null;
        searchQuery = null;
        analyticsSelectedApplication = null;
        viewObjectIdStr = null;
    }

    public int compareTo(ViewData viewdata)
    {
        if (getClass().equals(viewdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(viewdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetStub()).compareTo(Boolean.valueOf(viewdata.isSetStub()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetStub())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(stub, viewdata.stub);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetInterestName()).compareTo(Boolean.valueOf(viewdata.isSetInterestName()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetInterestName())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(interestName, viewdata.interestName);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetViewObjectId()).compareTo(Boolean.valueOf(viewdata.isSetViewObjectId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetViewObjectId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewObjectId, viewdata.viewObjectId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetObjectData()).compareTo(Boolean.valueOf(viewdata.isSetObjectData()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetObjectData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectData, viewdata.objectData);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetSearchQuery()).compareTo(Boolean.valueOf(viewdata.isSetSearchQuery()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetSearchQuery())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(searchQuery, viewdata.searchQuery);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetAnalyticsSelectedApplication()).compareTo(Boolean.valueOf(viewdata.isSetAnalyticsSelectedApplication()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetAnalyticsSelectedApplication())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(analyticsSelectedApplication, viewdata.analyticsSelectedApplication);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetViewObjectIdStr()).compareTo(Boolean.valueOf(viewdata.isSetViewObjectIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetViewObjectIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewObjectIdStr, viewdata.viewObjectIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ViewData)obj);
    }

    public ViewData deepCopy()
    {
        return new ViewData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(ViewData viewdata)
    {
        if (viewdata != null)
        {
            boolean flag = isSetStub();
            boolean flag7 = viewdata.isSetStub();
            if (!flag && !flag7 || flag && flag7 && stub == viewdata.stub)
            {
                boolean flag1 = isSetInterestName();
                boolean flag8 = viewdata.isSetInterestName();
                if (!flag1 && !flag8 || flag1 && flag8 && interestName.equals(viewdata.interestName))
                {
                    boolean flag2 = isSetViewObjectId();
                    boolean flag9 = viewdata.isSetViewObjectId();
                    if (!flag2 && !flag9 || flag2 && flag9 && viewObjectId == viewdata.viewObjectId)
                    {
                        boolean flag3 = isSetObjectData();
                        boolean flag10 = viewdata.isSetObjectData();
                        if (!flag3 && !flag10 || flag3 && flag10 && objectData.equals(viewdata.objectData))
                        {
                            boolean flag4 = isSetSearchQuery();
                            boolean flag11 = viewdata.isSetSearchQuery();
                            if (!flag4 && !flag11 || flag4 && flag11 && searchQuery.equals(viewdata.searchQuery))
                            {
                                boolean flag5 = isSetAnalyticsSelectedApplication();
                                boolean flag12 = viewdata.isSetAnalyticsSelectedApplication();
                                if (!flag5 && !flag12 || flag5 && flag12 && analyticsSelectedApplication.equals(viewdata.analyticsSelectedApplication))
                                {
                                    boolean flag6 = isSetViewObjectIdStr();
                                    boolean flag13 = viewdata.isSetViewObjectIdStr();
                                    if (!flag6 && !flag13 || flag6 && flag13 && viewObjectIdStr.equals(viewdata.viewObjectIdStr))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof ViewData)) 
        {
            return false;
        }
        return equals((ViewData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getAnalyticsSelectedApplication()
    {
        return analyticsSelectedApplication;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ViewData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Integer.valueOf(getStub());

        case 2: // '\002'
            return getInterestName();

        case 3: // '\003'
            return Long.valueOf(getViewObjectId());

        case 4: // '\004'
            return getObjectData();

        case 5: // '\005'
            return getSearchQuery();

        case 6: // '\006'
            return getAnalyticsSelectedApplication();

        case 7: // '\007'
            return getViewObjectIdStr();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getInterestName()
    {
        return interestName;
    }

    public VisualObjectData getObjectData()
    {
        return objectData;
    }

    public String getSearchQuery()
    {
        return searchQuery;
    }

    public int getStub()
    {
        return stub;
    }

    public long getViewObjectId()
    {
        return viewObjectId;
    }

    public String getViewObjectIdStr()
    {
        return viewObjectIdStr;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetStub();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(stub));
        }
        flag = isSetInterestName();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(interestName);
        }
        flag = isSetViewObjectId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Long.valueOf(viewObjectId));
        }
        flag = isSetObjectData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(objectData);
        }
        flag = isSetSearchQuery();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(searchQuery);
        }
        flag = isSetAnalyticsSelectedApplication();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(analyticsSelectedApplication);
        }
        flag = isSetViewObjectIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(viewObjectIdStr);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ViewData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetStub();

        case 2: // '\002'
            return isSetInterestName();

        case 3: // '\003'
            return isSetViewObjectId();

        case 4: // '\004'
            return isSetObjectData();

        case 5: // '\005'
            return isSetSearchQuery();

        case 6: // '\006'
            return isSetAnalyticsSelectedApplication();

        case 7: // '\007'
            return isSetViewObjectIdStr();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAnalyticsSelectedApplication()
    {
        return analyticsSelectedApplication != null;
    }

    public boolean isSetInterestName()
    {
        return interestName != null;
    }

    public boolean isSetObjectData()
    {
        return objectData != null;
    }

    public boolean isSetSearchQuery()
    {
        return searchQuery != null;
    }

    public boolean isSetStub()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetViewObjectId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetViewObjectIdStr()
    {
        return viewObjectIdStr != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public ViewData setAnalyticsSelectedApplication(String s)
    {
        analyticsSelectedApplication = s;
        return this;
    }

    public void setAnalyticsSelectedApplicationIsSet(boolean flag)
    {
        if (!flag)
        {
            analyticsSelectedApplication = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ViewData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetStub();
                return;
            } else
            {
                setStub(((Integer)obj).intValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetInterestName();
                return;
            } else
            {
                setInterestName((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetViewObjectId();
                return;
            } else
            {
                setViewObjectId(((Long)obj).longValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetObjectData();
                return;
            } else
            {
                setObjectData((VisualObjectData)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetSearchQuery();
                return;
            } else
            {
                setSearchQuery((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAnalyticsSelectedApplication();
                return;
            } else
            {
                setAnalyticsSelectedApplication((String)obj);
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetViewObjectIdStr();
            return;
        } else
        {
            setViewObjectIdStr((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public ViewData setInterestName(String s)
    {
        interestName = s;
        return this;
    }

    public void setInterestNameIsSet(boolean flag)
    {
        if (!flag)
        {
            interestName = null;
        }
    }

    public ViewData setObjectData(VisualObjectData visualobjectdata)
    {
        objectData = visualobjectdata;
        return this;
    }

    public void setObjectDataIsSet(boolean flag)
    {
        if (!flag)
        {
            objectData = null;
        }
    }

    public ViewData setSearchQuery(String s)
    {
        searchQuery = s;
        return this;
    }

    public void setSearchQueryIsSet(boolean flag)
    {
        if (!flag)
        {
            searchQuery = null;
        }
    }

    public ViewData setStub(int i)
    {
        stub = i;
        setStubIsSet(true);
        return this;
    }

    public void setStubIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public ViewData setViewObjectId(long l)
    {
        viewObjectId = l;
        setViewObjectIdIsSet(true);
        return this;
    }

    public void setViewObjectIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public ViewData setViewObjectIdStr(String s)
    {
        viewObjectIdStr = s;
        return this;
    }

    public void setViewObjectIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            viewObjectIdStr = null;
        }
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("ViewData(");
        boolean flag1 = true;
        if (isSetStub())
        {
            stringbuilder.append("stub:");
            stringbuilder.append(stub);
            flag1 = false;
        }
        boolean flag = flag1;
        if (isSetInterestName())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("interestName:");
            if (interestName == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(interestName);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetViewObjectId())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("viewObjectId:");
            stringbuilder.append(viewObjectId);
            flag1 = false;
        }
        flag = flag1;
        if (isSetObjectData())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("objectData:");
            if (objectData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objectData);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetSearchQuery())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("searchQuery:");
            if (searchQuery == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(searchQuery);
            }
            flag1 = false;
        }
        if (isSetAnalyticsSelectedApplication())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("analyticsSelectedApplication:");
            if (analyticsSelectedApplication == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(analyticsSelectedApplication);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetViewObjectIdStr())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("viewObjectIdStr:");
            if (viewObjectIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(viewObjectIdStr);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAnalyticsSelectedApplication()
    {
        analyticsSelectedApplication = null;
    }

    public void unsetInterestName()
    {
        interestName = null;
    }

    public void unsetObjectData()
    {
        objectData = null;
    }

    public void unsetSearchQuery()
    {
        searchQuery = null;
    }

    public void unsetStub()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetViewObjectId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetViewObjectIdStr()
    {
        viewObjectIdStr = null;
    }

    public void validate()
    {
        if (objectData != null)
        {
            objectData.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new ViewDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new ViewDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.STUB, _Fields.INTEREST_NAME, _Fields.VIEW_OBJECT_ID, _Fields.OBJECT_DATA, _Fields.SEARCH_QUERY, _Fields.ANALYTICS_SELECTED_APPLICATION, _Fields.VIEW_OBJECT_ID_STR
        });
        obj = new EnumMap(com/pinterest/schemas/event/ViewData$_Fields);
        ((Map) (obj)).put(_Fields.STUB, new FieldMetaData("stub", (byte)2, new FieldValueMetaData((byte)8)));
        ((Map) (obj)).put(_Fields.INTEREST_NAME, new FieldMetaData("interestName", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.VIEW_OBJECT_ID, new FieldMetaData("viewObjectId", (byte)2, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.OBJECT_DATA, new FieldMetaData("objectData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/VisualObjectData)));
        ((Map) (obj)).put(_Fields.SEARCH_QUERY, new FieldMetaData("searchQuery", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ANALYTICS_SELECTED_APPLICATION, new FieldMetaData("analyticsSelectedApplication", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.VIEW_OBJECT_ID_STR, new FieldMetaData("viewObjectIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/ViewData, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ANALYTICS_SELECTED_APPLICATION;
        public static final _Fields INTEREST_NAME;
        public static final _Fields OBJECT_DATA;
        public static final _Fields SEARCH_QUERY;
        public static final _Fields STUB;
        public static final _Fields VIEW_OBJECT_ID;
        public static final _Fields VIEW_OBJECT_ID_STR;
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
                return STUB;

            case 2: // '\002'
                return INTEREST_NAME;

            case 3: // '\003'
                return VIEW_OBJECT_ID;

            case 4: // '\004'
                return OBJECT_DATA;

            case 5: // '\005'
                return SEARCH_QUERY;

            case 6: // '\006'
                return ANALYTICS_SELECTED_APPLICATION;

            case 7: // '\007'
                return VIEW_OBJECT_ID_STR;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/ViewData$_Fields, s);
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
            STUB = new _Fields("STUB", 0, (short)1, "stub");
            INTEREST_NAME = new _Fields("INTEREST_NAME", 1, (short)2, "interestName");
            VIEW_OBJECT_ID = new _Fields("VIEW_OBJECT_ID", 2, (short)3, "viewObjectId");
            OBJECT_DATA = new _Fields("OBJECT_DATA", 3, (short)4, "objectData");
            SEARCH_QUERY = new _Fields("SEARCH_QUERY", 4, (short)5, "searchQuery");
            ANALYTICS_SELECTED_APPLICATION = new _Fields("ANALYTICS_SELECTED_APPLICATION", 5, (short)6, "analyticsSelectedApplication");
            VIEW_OBJECT_ID_STR = new _Fields("VIEW_OBJECT_ID_STR", 6, (short)7, "viewObjectIdStr");
            $VALUES = (new _Fields[] {
                STUB, INTEREST_NAME, VIEW_OBJECT_ID, OBJECT_DATA, SEARCH_QUERY, ANALYTICS_SELECTED_APPLICATION, VIEW_OBJECT_ID_STR
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ViewData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.STUB.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.INTEREST_NAME.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.VIEW_OBJECT_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.OBJECT_DATA.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.SEARCH_QUERY.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.ANALYTICS_SELECTED_APPLICATION.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ViewData$_Fields[_Fields.VIEW_OBJECT_ID_STR.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ViewDataStandardSchemeFactory
        implements SchemeFactory
    {

        public ViewDataStandardScheme getScheme()
        {
            return new ViewDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ViewDataStandardSchemeFactory()
        {
        }

        ViewDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ViewDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, ViewData viewdata)
            {
                tprotocol.readStructBegin();
_L10:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_342;
                }
                tfield.id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 115
            //                           3 151
            //                           4 187
            //                           5 234
            //                           6 270
            //                           7 306;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_306;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L11:
                tprotocol.readFieldEnd();
                if (true) goto _L10; else goto _L9
_L9:
                if (tfield.type == 8)
                {
                    viewdata.stub = tprotocol.readI32();
                    viewdata.setStubIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L3:
                if (tfield.type == 11)
                {
                    viewdata.interestName = tprotocol.readString();
                    viewdata.setInterestNameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L4:
                if (tfield.type == 10)
                {
                    viewdata.viewObjectId = tprotocol.readI64();
                    viewdata.setViewObjectIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L5:
                if (tfield.type == 12)
                {
                    viewdata.objectData = new VisualObjectData();
                    viewdata.objectData.read(tprotocol);
                    viewdata.setObjectDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L6:
                if (tfield.type == 11)
                {
                    viewdata.searchQuery = tprotocol.readString();
                    viewdata.setSearchQueryIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L7:
                if (tfield.type == 11)
                {
                    viewdata.analyticsSelectedApplication = tprotocol.readString();
                    viewdata.setAnalyticsSelectedApplicationIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                if (tfield.type == 11)
                {
                    viewdata.viewObjectIdStr = tprotocol.readString();
                    viewdata.setViewObjectIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                viewdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ViewData)tbase);
            }

            public void write(TProtocol tprotocol, ViewData viewdata)
            {
                viewdata.validate();
                tprotocol.writeStructBegin(ViewData.STRUCT_DESC);
                if (viewdata.isSetStub())
                {
                    tprotocol.writeFieldBegin(ViewData.STUB_FIELD_DESC);
                    tprotocol.writeI32(viewdata.stub);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.interestName != null && viewdata.isSetInterestName())
                {
                    tprotocol.writeFieldBegin(ViewData.INTEREST_NAME_FIELD_DESC);
                    tprotocol.writeString(viewdata.interestName);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.isSetViewObjectId())
                {
                    tprotocol.writeFieldBegin(ViewData.VIEW_OBJECT_ID_FIELD_DESC);
                    tprotocol.writeI64(viewdata.viewObjectId);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.objectData != null && viewdata.isSetObjectData())
                {
                    tprotocol.writeFieldBegin(ViewData.OBJECT_DATA_FIELD_DESC);
                    viewdata.objectData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.searchQuery != null && viewdata.isSetSearchQuery())
                {
                    tprotocol.writeFieldBegin(ViewData.SEARCH_QUERY_FIELD_DESC);
                    tprotocol.writeString(viewdata.searchQuery);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.analyticsSelectedApplication != null && viewdata.isSetAnalyticsSelectedApplication())
                {
                    tprotocol.writeFieldBegin(ViewData.ANALYTICS_SELECTED_APPLICATION_FIELD_DESC);
                    tprotocol.writeString(viewdata.analyticsSelectedApplication);
                    tprotocol.writeFieldEnd();
                }
                if (viewdata.viewObjectIdStr != null && viewdata.isSetViewObjectIdStr())
                {
                    tprotocol.writeFieldBegin(ViewData.VIEW_OBJECT_ID_STR_FIELD_DESC);
                    tprotocol.writeString(viewdata.viewObjectIdStr);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ViewData)tbase);
            }

            private ViewDataStandardScheme()
            {
            }

            ViewDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class ViewDataTupleSchemeFactory
        implements SchemeFactory
    {

        public ViewDataTupleScheme getScheme()
        {
            return new ViewDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ViewDataTupleSchemeFactory()
        {
        }

        ViewDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ViewDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, ViewData viewdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    viewdata.stub = tprotocol.readI32();
                    viewdata.setStubIsSet(true);
                }
                if (bitset.get(1))
                {
                    viewdata.interestName = tprotocol.readString();
                    viewdata.setInterestNameIsSet(true);
                }
                if (bitset.get(2))
                {
                    viewdata.viewObjectId = tprotocol.readI64();
                    viewdata.setViewObjectIdIsSet(true);
                }
                if (bitset.get(3))
                {
                    viewdata.objectData = new VisualObjectData();
                    viewdata.objectData.read(tprotocol);
                    viewdata.setObjectDataIsSet(true);
                }
                if (bitset.get(4))
                {
                    viewdata.searchQuery = tprotocol.readString();
                    viewdata.setSearchQueryIsSet(true);
                }
                if (bitset.get(5))
                {
                    viewdata.analyticsSelectedApplication = tprotocol.readString();
                    viewdata.setAnalyticsSelectedApplicationIsSet(true);
                }
                if (bitset.get(6))
                {
                    viewdata.viewObjectIdStr = tprotocol.readString();
                    viewdata.setViewObjectIdStrIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ViewData)tbase);
            }

            public void write(TProtocol tprotocol, ViewData viewdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (viewdata.isSetStub())
                {
                    bitset.set(0);
                }
                if (viewdata.isSetInterestName())
                {
                    bitset.set(1);
                }
                if (viewdata.isSetViewObjectId())
                {
                    bitset.set(2);
                }
                if (viewdata.isSetObjectData())
                {
                    bitset.set(3);
                }
                if (viewdata.isSetSearchQuery())
                {
                    bitset.set(4);
                }
                if (viewdata.isSetAnalyticsSelectedApplication())
                {
                    bitset.set(5);
                }
                if (viewdata.isSetViewObjectIdStr())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (viewdata.isSetStub())
                {
                    tprotocol.writeI32(viewdata.stub);
                }
                if (viewdata.isSetInterestName())
                {
                    tprotocol.writeString(viewdata.interestName);
                }
                if (viewdata.isSetViewObjectId())
                {
                    tprotocol.writeI64(viewdata.viewObjectId);
                }
                if (viewdata.isSetObjectData())
                {
                    viewdata.objectData.write(tprotocol);
                }
                if (viewdata.isSetSearchQuery())
                {
                    tprotocol.writeString(viewdata.searchQuery);
                }
                if (viewdata.isSetAnalyticsSelectedApplication())
                {
                    tprotocol.writeString(viewdata.analyticsSelectedApplication);
                }
                if (viewdata.isSetViewObjectIdStr())
                {
                    tprotocol.writeString(viewdata.viewObjectIdStr);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ViewData)tbase);
            }

            private ViewDataTupleScheme()
            {
            }

            ViewDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
