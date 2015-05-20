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
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
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

// Referenced classes of package com.pinterest.schemas.event:
//            EventType, EventData, Context, AppType, 
//            DeviceType, BrowserType, OSType, EventAppState, 
//            SiteType, Diagnostics

public class Event
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField APP_FIELD_DESC = new TField("app", (byte)8, (short)9);
    private static final TField APP_STATE_FIELD_DESC = new TField("appState", (byte)8, (short)20);
    private static final TField APP_VERSION_FIELD_DESC = new TField("appVersion", (byte)11, (short)11);
    private static final TField AUX_DATA_FIELD_DESC = new TField("auxData", (byte)13, (short)5);
    private static final TField BROWSER_FIELD_DESC = new TField("browser", (byte)8, (short)13);
    private static final TField CONTEXT_FIELD_DESC = new TField("context", (byte)12, (short)8);
    private static final TField DEVICE_FIELD_DESC = new TField("device", (byte)8, (short)12);
    private static final TField DEVICE_NAME_FIELD_DESC = new TField("deviceName", (byte)11, (short)15);
    private static final TField DIAGNOSTICS_FIELD_DESC = new TField("diagnostics", (byte)12, (short)22);
    private static final TField EVENT_DATA_FIELD_DESC = new TField("eventData", (byte)12, (short)6);
    private static final TField EVENT_TYPE_FIELD_DESC = new TField("eventType", (byte)8, (short)2);
    private static final TField INSERTION_ID_FIELD_DESC = new TField("insertionId", (byte)11, (short)19);
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", (byte)10, (short)4);
    private static final TField OBJECT_ID_STR_FIELD_DESC = new TField("objectIdStr", (byte)11, (short)18);
    private static final TField OS_FIELD_DESC = new TField("os", (byte)8, (short)14);
    private static final TField PREVIOUS_CONTEXT_FIELD_DESC = new TField("previousContext", (byte)12, (short)7);
    private static final TField P_DATA_FIELD_DESC = new TField("pData", (byte)13, (short)24);
    private static final TField REQUEST_FIELD_DESC = new TField("request", (byte)11, (short)10);
    private static final TField SITE_FIELD_DESC = new TField("site", (byte)8, (short)21);
    private static final TStruct STRUCT_DESC = new TStruct("Event");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)1);
    private static final TField UNAUTH_ID_FIELD_DESC = new TField("unauthId", (byte)11, (short)16);
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)3);
    private static final TField USER_ID_STR_FIELD_DESC = new TField("userIdStr", (byte)11, (short)17);
    private static final TField UUID_FIELD_DESC = new TField("uuid", (byte)11, (short)23);
    private static final int __OBJECTID_ISSET_ID = 2;
    private static final int __TIME_ISSET_ID = 0;
    private static final int __USERID_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public AppType app;
    public EventAppState appState;
    public String appVersion;
    public Map auxData;
    public BrowserType browser;
    public Context context;
    public DeviceType device;
    public String deviceName;
    public Diagnostics diagnostics;
    public EventData eventData;
    public EventType eventType;
    public String insertionId;
    public long objectId;
    public String objectIdStr;
    public OSType os;
    public Map pData;
    public Context previousContext;
    public String request;
    public SiteType site;
    public long time;
    public String unauthId;
    public long userId;
    public String userIdStr;
    public String uuid;

    public Event()
    {
        __isset_bitfield = 0;
        auxData = new HashMap();
    }

    public Event(long l, EventType eventtype, long l1, long l2, 
            Map map)
    {
        this();
        time = l;
        setTimeIsSet(true);
        eventType = eventtype;
        userId = l1;
        setUserIdIsSet(true);
        objectId = l2;
        setObjectIdIsSet(true);
        auxData = map;
    }

    public Event(Event event)
    {
        __isset_bitfield = 0;
        __isset_bitfield = event.__isset_bitfield;
        time = event.time;
        if (event.isSetEventType())
        {
            eventType = event.eventType;
        }
        userId = event.userId;
        objectId = event.objectId;
        if (event.isSetAuxData())
        {
            auxData = new HashMap(event.auxData);
        }
        if (event.isSetEventData())
        {
            eventData = new EventData(event.eventData);
        }
        if (event.isSetPreviousContext())
        {
            previousContext = new Context(event.previousContext);
        }
        if (event.isSetContext())
        {
            context = new Context(event.context);
        }
        if (event.isSetApp())
        {
            app = event.app;
        }
        if (event.isSetRequest())
        {
            request = event.request;
        }
        if (event.isSetAppVersion())
        {
            appVersion = event.appVersion;
        }
        if (event.isSetDevice())
        {
            device = event.device;
        }
        if (event.isSetBrowser())
        {
            browser = event.browser;
        }
        if (event.isSetOs())
        {
            os = event.os;
        }
        if (event.isSetDeviceName())
        {
            deviceName = event.deviceName;
        }
        if (event.isSetUnauthId())
        {
            unauthId = event.unauthId;
        }
        if (event.isSetUserIdStr())
        {
            userIdStr = event.userIdStr;
        }
        if (event.isSetObjectIdStr())
        {
            objectIdStr = event.objectIdStr;
        }
        if (event.isSetInsertionId())
        {
            insertionId = event.insertionId;
        }
        if (event.isSetAppState())
        {
            appState = event.appState;
        }
        if (event.isSetSite())
        {
            site = event.site;
        }
        if (event.isSetDiagnostics())
        {
            diagnostics = new Diagnostics(event.diagnostics);
        }
        if (event.isSetUuid())
        {
            uuid = event.uuid;
        }
        if (event.isSetPData())
        {
            pData = new HashMap(event.pData);
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
        setTimeIsSet(false);
        time = 0L;
        eventType = null;
        setUserIdIsSet(false);
        userId = 0L;
        setObjectIdIsSet(false);
        objectId = 0L;
        auxData = new HashMap();
        eventData = null;
        previousContext = null;
        context = null;
        app = null;
        request = null;
        appVersion = null;
        device = null;
        browser = null;
        os = null;
        deviceName = null;
        unauthId = null;
        userIdStr = null;
        objectIdStr = null;
        insertionId = null;
        appState = null;
        site = null;
        diagnostics = null;
        uuid = null;
        pData = null;
    }

    public int compareTo(Event event)
    {
        if (getClass().equals(event.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(event.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(event.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, event.time);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetEventType()).compareTo(Boolean.valueOf(event.isSetEventType()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetEventType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(eventType, event.eventType);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(event.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, event.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetObjectId()).compareTo(Boolean.valueOf(event.isSetObjectId()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetObjectId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectId, event.objectId);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetAuxData()).compareTo(Boolean.valueOf(event.isSetAuxData()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetAuxData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(auxData, event.auxData);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetEventData()).compareTo(Boolean.valueOf(event.isSetEventData()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetEventData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(eventData, event.eventData);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetPreviousContext()).compareTo(Boolean.valueOf(event.isSetPreviousContext()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetPreviousContext())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(previousContext, event.previousContext);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetContext()).compareTo(Boolean.valueOf(event.isSetContext()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetContext())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(context, event.context);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        j = Boolean.valueOf(isSetApp()).compareTo(Boolean.valueOf(event.isSetApp()));
        i = j;
        if (j != 0) goto _L4; else goto _L20
_L20:
        if (!isSetApp())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(app, event.app);
        i = j;
        if (j != 0) goto _L4; else goto _L21
_L21:
        j = Boolean.valueOf(isSetRequest()).compareTo(Boolean.valueOf(event.isSetRequest()));
        i = j;
        if (j != 0) goto _L4; else goto _L22
_L22:
        if (!isSetRequest())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(request, event.request);
        i = j;
        if (j != 0) goto _L4; else goto _L23
_L23:
        j = Boolean.valueOf(isSetAppVersion()).compareTo(Boolean.valueOf(event.isSetAppVersion()));
        i = j;
        if (j != 0) goto _L4; else goto _L24
_L24:
        if (!isSetAppVersion())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(appVersion, event.appVersion);
        i = j;
        if (j != 0) goto _L4; else goto _L25
_L25:
        j = Boolean.valueOf(isSetDevice()).compareTo(Boolean.valueOf(event.isSetDevice()));
        i = j;
        if (j != 0) goto _L4; else goto _L26
_L26:
        if (!isSetDevice())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(device, event.device);
        i = j;
        if (j != 0) goto _L4; else goto _L27
_L27:
        j = Boolean.valueOf(isSetBrowser()).compareTo(Boolean.valueOf(event.isSetBrowser()));
        i = j;
        if (j != 0) goto _L4; else goto _L28
_L28:
        if (!isSetBrowser())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(browser, event.browser);
        i = j;
        if (j != 0) goto _L4; else goto _L29
_L29:
        j = Boolean.valueOf(isSetOs()).compareTo(Boolean.valueOf(event.isSetOs()));
        i = j;
        if (j != 0) goto _L4; else goto _L30
_L30:
        if (!isSetOs())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(os, event.os);
        i = j;
        if (j != 0) goto _L4; else goto _L31
_L31:
        j = Boolean.valueOf(isSetDeviceName()).compareTo(Boolean.valueOf(event.isSetDeviceName()));
        i = j;
        if (j != 0) goto _L4; else goto _L32
_L32:
        if (!isSetDeviceName())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(deviceName, event.deviceName);
        i = j;
        if (j != 0) goto _L4; else goto _L33
_L33:
        j = Boolean.valueOf(isSetUnauthId()).compareTo(Boolean.valueOf(event.isSetUnauthId()));
        i = j;
        if (j != 0) goto _L4; else goto _L34
_L34:
        if (!isSetUnauthId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(unauthId, event.unauthId);
        i = j;
        if (j != 0) goto _L4; else goto _L35
_L35:
        j = Boolean.valueOf(isSetUserIdStr()).compareTo(Boolean.valueOf(event.isSetUserIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L36
_L36:
        if (!isSetUserIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userIdStr, event.userIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L37
_L37:
        j = Boolean.valueOf(isSetObjectIdStr()).compareTo(Boolean.valueOf(event.isSetObjectIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L38
_L38:
        if (!isSetObjectIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectIdStr, event.objectIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L39
_L39:
        j = Boolean.valueOf(isSetInsertionId()).compareTo(Boolean.valueOf(event.isSetInsertionId()));
        i = j;
        if (j != 0) goto _L4; else goto _L40
_L40:
        if (!isSetInsertionId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(insertionId, event.insertionId);
        i = j;
        if (j != 0) goto _L4; else goto _L41
_L41:
        j = Boolean.valueOf(isSetAppState()).compareTo(Boolean.valueOf(event.isSetAppState()));
        i = j;
        if (j != 0) goto _L4; else goto _L42
_L42:
        if (!isSetAppState())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(appState, event.appState);
        i = j;
        if (j != 0) goto _L4; else goto _L43
_L43:
        j = Boolean.valueOf(isSetSite()).compareTo(Boolean.valueOf(event.isSetSite()));
        i = j;
        if (j != 0) goto _L4; else goto _L44
_L44:
        if (!isSetSite())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(site, event.site);
        i = j;
        if (j != 0) goto _L4; else goto _L45
_L45:
        j = Boolean.valueOf(isSetDiagnostics()).compareTo(Boolean.valueOf(event.isSetDiagnostics()));
        i = j;
        if (j != 0) goto _L4; else goto _L46
_L46:
        if (!isSetDiagnostics())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(diagnostics, event.diagnostics);
        i = j;
        if (j != 0) goto _L4; else goto _L47
_L47:
        j = Boolean.valueOf(isSetUuid()).compareTo(Boolean.valueOf(event.isSetUuid()));
        i = j;
        if (j != 0) goto _L4; else goto _L48
_L48:
        if (!isSetUuid())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(uuid, event.uuid);
        i = j;
        if (j != 0) goto _L4; else goto _L49
_L49:
        j = Boolean.valueOf(isSetPData()).compareTo(Boolean.valueOf(event.isSetPData()));
        i = j;
        if (j != 0) goto _L4; else goto _L50
_L50:
        if (!isSetPData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pData, event.pData);
        i = j;
        if (j != 0) goto _L4; else goto _L51
_L51:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Event)obj);
    }

    public Event deepCopy()
    {
        return new Event(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(Event event)
    {
        if (event != null && time == event.time)
        {
            boolean flag = isSetEventType();
            boolean flag21 = event.isSetEventType();
            if ((!flag && !flag21 || flag && flag21 && eventType.equals(event.eventType)) && userId == event.userId && objectId == event.objectId)
            {
                boolean flag1 = isSetAuxData();
                boolean flag22 = event.isSetAuxData();
                if (!flag1 && !flag22 || flag1 && flag22 && auxData.equals(event.auxData))
                {
                    boolean flag2 = isSetEventData();
                    boolean flag23 = event.isSetEventData();
                    if (!flag2 && !flag23 || flag2 && flag23 && eventData.equals(event.eventData))
                    {
                        boolean flag3 = isSetPreviousContext();
                        boolean flag24 = event.isSetPreviousContext();
                        if (!flag3 && !flag24 || flag3 && flag24 && previousContext.equals(event.previousContext))
                        {
                            boolean flag4 = isSetContext();
                            boolean flag25 = event.isSetContext();
                            if (!flag4 && !flag25 || flag4 && flag25 && context.equals(event.context))
                            {
                                boolean flag5 = isSetApp();
                                boolean flag26 = event.isSetApp();
                                if (!flag5 && !flag26 || flag5 && flag26 && app.equals(event.app))
                                {
                                    boolean flag6 = isSetRequest();
                                    boolean flag27 = event.isSetRequest();
                                    if (!flag6 && !flag27 || flag6 && flag27 && request.equals(event.request))
                                    {
                                        boolean flag7 = isSetAppVersion();
                                        boolean flag28 = event.isSetAppVersion();
                                        if (!flag7 && !flag28 || flag7 && flag28 && appVersion.equals(event.appVersion))
                                        {
                                            boolean flag8 = isSetDevice();
                                            boolean flag29 = event.isSetDevice();
                                            if (!flag8 && !flag29 || flag8 && flag29 && device.equals(event.device))
                                            {
                                                boolean flag9 = isSetBrowser();
                                                boolean flag30 = event.isSetBrowser();
                                                if (!flag9 && !flag30 || flag9 && flag30 && browser.equals(event.browser))
                                                {
                                                    boolean flag10 = isSetOs();
                                                    boolean flag31 = event.isSetOs();
                                                    if (!flag10 && !flag31 || flag10 && flag31 && os.equals(event.os))
                                                    {
                                                        boolean flag11 = isSetDeviceName();
                                                        boolean flag32 = event.isSetDeviceName();
                                                        if (!flag11 && !flag32 || flag11 && flag32 && deviceName.equals(event.deviceName))
                                                        {
                                                            boolean flag12 = isSetUnauthId();
                                                            boolean flag33 = event.isSetUnauthId();
                                                            if (!flag12 && !flag33 || flag12 && flag33 && unauthId.equals(event.unauthId))
                                                            {
                                                                boolean flag13 = isSetUserIdStr();
                                                                boolean flag34 = event.isSetUserIdStr();
                                                                if (!flag13 && !flag34 || flag13 && flag34 && userIdStr.equals(event.userIdStr))
                                                                {
                                                                    boolean flag14 = isSetObjectIdStr();
                                                                    boolean flag35 = event.isSetObjectIdStr();
                                                                    if (!flag14 && !flag35 || flag14 && flag35 && objectIdStr.equals(event.objectIdStr))
                                                                    {
                                                                        boolean flag15 = isSetInsertionId();
                                                                        boolean flag36 = event.isSetInsertionId();
                                                                        if (!flag15 && !flag36 || flag15 && flag36 && insertionId.equals(event.insertionId))
                                                                        {
                                                                            boolean flag16 = isSetAppState();
                                                                            boolean flag37 = event.isSetAppState();
                                                                            if (!flag16 && !flag37 || flag16 && flag37 && appState.equals(event.appState))
                                                                            {
                                                                                boolean flag17 = isSetSite();
                                                                                boolean flag38 = event.isSetSite();
                                                                                if (!flag17 && !flag38 || flag17 && flag38 && site.equals(event.site))
                                                                                {
                                                                                    boolean flag18 = isSetDiagnostics();
                                                                                    boolean flag39 = event.isSetDiagnostics();
                                                                                    if (!flag18 && !flag39 || flag18 && flag39 && diagnostics.equals(event.diagnostics))
                                                                                    {
                                                                                        boolean flag19 = isSetUuid();
                                                                                        boolean flag40 = event.isSetUuid();
                                                                                        if (!flag19 && !flag40 || flag19 && flag40 && uuid.equals(event.uuid))
                                                                                        {
                                                                                            boolean flag20 = isSetPData();
                                                                                            boolean flag41 = event.isSetPData();
                                                                                            if (!flag20 && !flag41 || flag20 && flag41 && pData.equals(event.pData))
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
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Event)) 
        {
            return false;
        }
        return equals((Event)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public AppType getApp()
    {
        return app;
    }

    public EventAppState getAppState()
    {
        return appState;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public Map getAuxData()
    {
        return auxData;
    }

    public int getAuxDataSize()
    {
        if (auxData == null)
        {
            return 0;
        } else
        {
            return auxData.size();
        }
    }

    public BrowserType getBrowser()
    {
        return browser;
    }

    public Context getContext()
    {
        return context;
    }

    public DeviceType getDevice()
    {
        return device;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public Diagnostics getDiagnostics()
    {
        return diagnostics;
    }

    public EventData getEventData()
    {
        return eventData;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Event._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getTime());

        case 2: // '\002'
            return getEventType();

        case 3: // '\003'
            return Long.valueOf(getUserId());

        case 4: // '\004'
            return Long.valueOf(getObjectId());

        case 5: // '\005'
            return getAuxData();

        case 6: // '\006'
            return getEventData();

        case 7: // '\007'
            return getPreviousContext();

        case 8: // '\b'
            return getContext();

        case 9: // '\t'
            return getApp();

        case 10: // '\n'
            return getRequest();

        case 11: // '\013'
            return getAppVersion();

        case 12: // '\f'
            return getDevice();

        case 13: // '\r'
            return getBrowser();

        case 14: // '\016'
            return getOs();

        case 15: // '\017'
            return getDeviceName();

        case 16: // '\020'
            return getUnauthId();

        case 17: // '\021'
            return getUserIdStr();

        case 18: // '\022'
            return getObjectIdStr();

        case 19: // '\023'
            return getInsertionId();

        case 20: // '\024'
            return getAppState();

        case 21: // '\025'
            return getSite();

        case 22: // '\026'
            return getDiagnostics();

        case 23: // '\027'
            return getUuid();

        case 24: // '\030'
            return getPData();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getInsertionId()
    {
        return insertionId;
    }

    public long getObjectId()
    {
        return objectId;
    }

    public String getObjectIdStr()
    {
        return objectIdStr;
    }

    public OSType getOs()
    {
        return os;
    }

    public Map getPData()
    {
        return pData;
    }

    public int getPDataSize()
    {
        if (pData == null)
        {
            return 0;
        } else
        {
            return pData.size();
        }
    }

    public Context getPreviousContext()
    {
        return previousContext;
    }

    public String getRequest()
    {
        return request;
    }

    public SiteType getSite()
    {
        return site;
    }

    public long getTime()
    {
        return time;
    }

    public String getUnauthId()
    {
        return unauthId;
    }

    public long getUserId()
    {
        return userId;
    }

    public String getUserIdStr()
    {
        return userIdStr;
    }

    public String getUuid()
    {
        return uuid;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        boolean flag = isSetEventType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(eventType.getValue()));
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(userId));
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(objectId));
        flag = isSetAuxData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(auxData);
        }
        flag = isSetEventData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(eventData);
        }
        flag = isSetPreviousContext();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(previousContext);
        }
        flag = isSetContext();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(context);
        }
        flag = isSetApp();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(app.getValue()));
        }
        flag = isSetRequest();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(request);
        }
        flag = isSetAppVersion();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(appVersion);
        }
        flag = isSetDevice();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(device.getValue()));
        }
        flag = isSetBrowser();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(browser.getValue()));
        }
        flag = isSetOs();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(os.getValue()));
        }
        flag = isSetDeviceName();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(deviceName);
        }
        flag = isSetUnauthId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(unauthId);
        }
        flag = isSetUserIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(userIdStr);
        }
        flag = isSetObjectIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(objectIdStr);
        }
        flag = isSetInsertionId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(insertionId);
        }
        flag = isSetAppState();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(appState.getValue()));
        }
        flag = isSetSite();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(site.getValue()));
        }
        flag = isSetDiagnostics();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(diagnostics);
        }
        flag = isSetUuid();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(uuid);
        }
        flag = isSetPData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(pData);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Event._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTime();

        case 2: // '\002'
            return isSetEventType();

        case 3: // '\003'
            return isSetUserId();

        case 4: // '\004'
            return isSetObjectId();

        case 5: // '\005'
            return isSetAuxData();

        case 6: // '\006'
            return isSetEventData();

        case 7: // '\007'
            return isSetPreviousContext();

        case 8: // '\b'
            return isSetContext();

        case 9: // '\t'
            return isSetApp();

        case 10: // '\n'
            return isSetRequest();

        case 11: // '\013'
            return isSetAppVersion();

        case 12: // '\f'
            return isSetDevice();

        case 13: // '\r'
            return isSetBrowser();

        case 14: // '\016'
            return isSetOs();

        case 15: // '\017'
            return isSetDeviceName();

        case 16: // '\020'
            return isSetUnauthId();

        case 17: // '\021'
            return isSetUserIdStr();

        case 18: // '\022'
            return isSetObjectIdStr();

        case 19: // '\023'
            return isSetInsertionId();

        case 20: // '\024'
            return isSetAppState();

        case 21: // '\025'
            return isSetSite();

        case 22: // '\026'
            return isSetDiagnostics();

        case 23: // '\027'
            return isSetUuid();

        case 24: // '\030'
            return isSetPData();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetApp()
    {
        return app != null;
    }

    public boolean isSetAppState()
    {
        return appState != null;
    }

    public boolean isSetAppVersion()
    {
        return appVersion != null;
    }

    public boolean isSetAuxData()
    {
        return auxData != null;
    }

    public boolean isSetBrowser()
    {
        return browser != null;
    }

    public boolean isSetContext()
    {
        return context != null;
    }

    public boolean isSetDevice()
    {
        return device != null;
    }

    public boolean isSetDeviceName()
    {
        return deviceName != null;
    }

    public boolean isSetDiagnostics()
    {
        return diagnostics != null;
    }

    public boolean isSetEventData()
    {
        return eventData != null;
    }

    public boolean isSetEventType()
    {
        return eventType != null;
    }

    public boolean isSetInsertionId()
    {
        return insertionId != null;
    }

    public boolean isSetObjectId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetObjectIdStr()
    {
        return objectIdStr != null;
    }

    public boolean isSetOs()
    {
        return os != null;
    }

    public boolean isSetPData()
    {
        return pData != null;
    }

    public boolean isSetPreviousContext()
    {
        return previousContext != null;
    }

    public boolean isSetRequest()
    {
        return request != null;
    }

    public boolean isSetSite()
    {
        return site != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetUnauthId()
    {
        return unauthId != null;
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetUserIdStr()
    {
        return userIdStr != null;
    }

    public boolean isSetUuid()
    {
        return uuid != null;
    }

    public void putToAuxData(String s, String s1)
    {
        if (auxData == null)
        {
            auxData = new HashMap();
        }
        auxData.put(s, s1);
    }

    public void putToPData(String s, String s1)
    {
        if (pData == null)
        {
            pData = new HashMap();
        }
        pData.put(s, s1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public Event setApp(AppType apptype)
    {
        app = apptype;
        return this;
    }

    public void setAppIsSet(boolean flag)
    {
        if (!flag)
        {
            app = null;
        }
    }

    public Event setAppState(EventAppState eventappstate)
    {
        appState = eventappstate;
        return this;
    }

    public void setAppStateIsSet(boolean flag)
    {
        if (!flag)
        {
            appState = null;
        }
    }

    public Event setAppVersion(String s)
    {
        appVersion = s;
        return this;
    }

    public void setAppVersionIsSet(boolean flag)
    {
        if (!flag)
        {
            appVersion = null;
        }
    }

    public Event setAuxData(Map map)
    {
        auxData = map;
        return this;
    }

    public void setAuxDataIsSet(boolean flag)
    {
        if (!flag)
        {
            auxData = null;
        }
    }

    public Event setBrowser(BrowserType browsertype)
    {
        browser = browsertype;
        return this;
    }

    public void setBrowserIsSet(boolean flag)
    {
        if (!flag)
        {
            browser = null;
        }
    }

    public Event setContext(Context context1)
    {
        context = context1;
        return this;
    }

    public void setContextIsSet(boolean flag)
    {
        if (!flag)
        {
            context = null;
        }
    }

    public Event setDevice(DeviceType devicetype)
    {
        device = devicetype;
        return this;
    }

    public void setDeviceIsSet(boolean flag)
    {
        if (!flag)
        {
            device = null;
        }
    }

    public Event setDeviceName(String s)
    {
        deviceName = s;
        return this;
    }

    public void setDeviceNameIsSet(boolean flag)
    {
        if (!flag)
        {
            deviceName = null;
        }
    }

    public Event setDiagnostics(Diagnostics diagnostics1)
    {
        diagnostics = diagnostics1;
        return this;
    }

    public void setDiagnosticsIsSet(boolean flag)
    {
        if (!flag)
        {
            diagnostics = null;
        }
    }

    public Event setEventData(EventData eventdata)
    {
        eventData = eventdata;
        return this;
    }

    public void setEventDataIsSet(boolean flag)
    {
        if (!flag)
        {
            eventData = null;
        }
    }

    public Event setEventType(EventType eventtype)
    {
        eventType = eventtype;
        return this;
    }

    public void setEventTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            eventType = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Event._Fields[_pfields.ordinal()])
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
                unsetEventType();
                return;
            } else
            {
                setEventType((EventType)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetUserId();
                return;
            } else
            {
                setUserId(((Long)obj).longValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetObjectId();
                return;
            } else
            {
                setObjectId(((Long)obj).longValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetAuxData();
                return;
            } else
            {
                setAuxData((Map)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetEventData();
                return;
            } else
            {
                setEventData((EventData)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetPreviousContext();
                return;
            } else
            {
                setPreviousContext((Context)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetContext();
                return;
            } else
            {
                setContext((Context)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetApp();
                return;
            } else
            {
                setApp((AppType)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetRequest();
                return;
            } else
            {
                setRequest((String)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetAppVersion();
                return;
            } else
            {
                setAppVersion((String)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetDevice();
                return;
            } else
            {
                setDevice((DeviceType)obj);
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetBrowser();
                return;
            } else
            {
                setBrowser((BrowserType)obj);
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetOs();
                return;
            } else
            {
                setOs((OSType)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetDeviceName();
                return;
            } else
            {
                setDeviceName((String)obj);
                return;
            }

        case 16: // '\020'
            if (obj == null)
            {
                unsetUnauthId();
                return;
            } else
            {
                setUnauthId((String)obj);
                return;
            }

        case 17: // '\021'
            if (obj == null)
            {
                unsetUserIdStr();
                return;
            } else
            {
                setUserIdStr((String)obj);
                return;
            }

        case 18: // '\022'
            if (obj == null)
            {
                unsetObjectIdStr();
                return;
            } else
            {
                setObjectIdStr((String)obj);
                return;
            }

        case 19: // '\023'
            if (obj == null)
            {
                unsetInsertionId();
                return;
            } else
            {
                setInsertionId((String)obj);
                return;
            }

        case 20: // '\024'
            if (obj == null)
            {
                unsetAppState();
                return;
            } else
            {
                setAppState((EventAppState)obj);
                return;
            }

        case 21: // '\025'
            if (obj == null)
            {
                unsetSite();
                return;
            } else
            {
                setSite((SiteType)obj);
                return;
            }

        case 22: // '\026'
            if (obj == null)
            {
                unsetDiagnostics();
                return;
            } else
            {
                setDiagnostics((Diagnostics)obj);
                return;
            }

        case 23: // '\027'
            if (obj == null)
            {
                unsetUuid();
                return;
            } else
            {
                setUuid((String)obj);
                return;
            }

        case 24: // '\030'
            break;
        }
        if (obj == null)
        {
            unsetPData();
            return;
        } else
        {
            setPData((Map)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public Event setInsertionId(String s)
    {
        insertionId = s;
        return this;
    }

    public void setInsertionIdIsSet(boolean flag)
    {
        if (!flag)
        {
            insertionId = null;
        }
    }

    public Event setObjectId(long l)
    {
        objectId = l;
        setObjectIdIsSet(true);
        return this;
    }

    public void setObjectIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public Event setObjectIdStr(String s)
    {
        objectIdStr = s;
        return this;
    }

    public void setObjectIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            objectIdStr = null;
        }
    }

    public Event setOs(OSType ostype)
    {
        os = ostype;
        return this;
    }

    public void setOsIsSet(boolean flag)
    {
        if (!flag)
        {
            os = null;
        }
    }

    public Event setPData(Map map)
    {
        pData = map;
        return this;
    }

    public void setPDataIsSet(boolean flag)
    {
        if (!flag)
        {
            pData = null;
        }
    }

    public Event setPreviousContext(Context context1)
    {
        previousContext = context1;
        return this;
    }

    public void setPreviousContextIsSet(boolean flag)
    {
        if (!flag)
        {
            previousContext = null;
        }
    }

    public Event setRequest(String s)
    {
        request = s;
        return this;
    }

    public void setRequestIsSet(boolean flag)
    {
        if (!flag)
        {
            request = null;
        }
    }

    public Event setSite(SiteType sitetype)
    {
        site = sitetype;
        return this;
    }

    public void setSiteIsSet(boolean flag)
    {
        if (!flag)
        {
            site = null;
        }
    }

    public Event setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public Event setUnauthId(String s)
    {
        unauthId = s;
        return this;
    }

    public void setUnauthIdIsSet(boolean flag)
    {
        if (!flag)
        {
            unauthId = null;
        }
    }

    public Event setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public Event setUserIdStr(String s)
    {
        userIdStr = s;
        return this;
    }

    public void setUserIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            userIdStr = null;
        }
    }

    public Event setUuid(String s)
    {
        uuid = s;
        return this;
    }

    public void setUuidIsSet(boolean flag)
    {
        if (!flag)
        {
            uuid = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Event(");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        stringbuilder.append(", ");
        stringbuilder.append("eventType:");
        if (eventType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(eventType);
        }
        stringbuilder.append(", ");
        stringbuilder.append("userId:");
        stringbuilder.append(userId);
        stringbuilder.append(", ");
        stringbuilder.append("objectId:");
        stringbuilder.append(objectId);
        stringbuilder.append(", ");
        stringbuilder.append("auxData:");
        if (auxData == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(auxData);
        }
        if (isSetEventData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("eventData:");
            if (eventData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(eventData);
            }
        }
        if (isSetPreviousContext())
        {
            stringbuilder.append(", ");
            stringbuilder.append("previousContext:");
            if (previousContext == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(previousContext);
            }
        }
        if (isSetContext())
        {
            stringbuilder.append(", ");
            stringbuilder.append("context:");
            if (context == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(context);
            }
        }
        if (isSetApp())
        {
            stringbuilder.append(", ");
            stringbuilder.append("app:");
            if (app == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(app);
            }
        }
        if (isSetRequest())
        {
            stringbuilder.append(", ");
            stringbuilder.append("request:");
            if (request == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(request);
            }
        }
        if (isSetAppVersion())
        {
            stringbuilder.append(", ");
            stringbuilder.append("appVersion:");
            if (appVersion == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(appVersion);
            }
        }
        if (isSetDevice())
        {
            stringbuilder.append(", ");
            stringbuilder.append("device:");
            if (device == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(device);
            }
        }
        if (isSetBrowser())
        {
            stringbuilder.append(", ");
            stringbuilder.append("browser:");
            if (browser == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(browser);
            }
        }
        if (isSetOs())
        {
            stringbuilder.append(", ");
            stringbuilder.append("os:");
            if (os == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(os);
            }
        }
        if (isSetDeviceName())
        {
            stringbuilder.append(", ");
            stringbuilder.append("deviceName:");
            if (deviceName == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(deviceName);
            }
        }
        if (isSetUnauthId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("unauthId:");
            if (unauthId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(unauthId);
            }
        }
        if (isSetUserIdStr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userIdStr:");
            if (userIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(userIdStr);
            }
        }
        if (isSetObjectIdStr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("objectIdStr:");
            if (objectIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objectIdStr);
            }
        }
        if (isSetInsertionId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("insertionId:");
            if (insertionId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(insertionId);
            }
        }
        if (isSetAppState())
        {
            stringbuilder.append(", ");
            stringbuilder.append("appState:");
            if (appState == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(appState);
            }
        }
        if (isSetSite())
        {
            stringbuilder.append(", ");
            stringbuilder.append("site:");
            if (site == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(site);
            }
        }
        if (isSetDiagnostics())
        {
            stringbuilder.append(", ");
            stringbuilder.append("diagnostics:");
            if (diagnostics == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(diagnostics);
            }
        }
        if (isSetUuid())
        {
            stringbuilder.append(", ");
            stringbuilder.append("uuid:");
            if (uuid == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(uuid);
            }
        }
        if (isSetPData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("pData:");
            if (pData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(pData);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetApp()
    {
        app = null;
    }

    public void unsetAppState()
    {
        appState = null;
    }

    public void unsetAppVersion()
    {
        appVersion = null;
    }

    public void unsetAuxData()
    {
        auxData = null;
    }

    public void unsetBrowser()
    {
        browser = null;
    }

    public void unsetContext()
    {
        context = null;
    }

    public void unsetDevice()
    {
        device = null;
    }

    public void unsetDeviceName()
    {
        deviceName = null;
    }

    public void unsetDiagnostics()
    {
        diagnostics = null;
    }

    public void unsetEventData()
    {
        eventData = null;
    }

    public void unsetEventType()
    {
        eventType = null;
    }

    public void unsetInsertionId()
    {
        insertionId = null;
    }

    public void unsetObjectId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetObjectIdStr()
    {
        objectIdStr = null;
    }

    public void unsetOs()
    {
        os = null;
    }

    public void unsetPData()
    {
        pData = null;
    }

    public void unsetPreviousContext()
    {
        previousContext = null;
    }

    public void unsetRequest()
    {
        request = null;
    }

    public void unsetSite()
    {
        site = null;
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUnauthId()
    {
        unauthId = null;
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetUserIdStr()
    {
        userIdStr = null;
    }

    public void unsetUuid()
    {
        uuid = null;
    }

    public void validate()
    {
        if (eventData != null)
        {
            eventData.validate();
        }
        if (previousContext != null)
        {
            previousContext.validate();
        }
        if (context != null)
        {
            context.validate();
        }
        if (diagnostics != null)
        {
            diagnostics.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new EventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new EventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.EVENT_DATA, _Fields.PREVIOUS_CONTEXT, _Fields.CONTEXT, _Fields.APP, _Fields.REQUEST, _Fields.APP_VERSION, _Fields.DEVICE, _Fields.BROWSER, _Fields.OS, _Fields.DEVICE_NAME, 
            _Fields.UNAUTH_ID, _Fields.USER_ID_STR, _Fields.OBJECT_ID_STR, _Fields.INSERTION_ID, _Fields.APP_STATE, _Fields.SITE, _Fields.DIAGNOSTICS, _Fields.UUID, _Fields.P_DATA
        });
        obj = new EnumMap(com/pinterest/schemas/event/Event$_Fields);
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.EVENT_TYPE, new FieldMetaData("eventType", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/EventType)));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.OBJECT_ID, new FieldMetaData("objectId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.AUX_DATA, new FieldMetaData("auxData", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.EVENT_DATA, new FieldMetaData("eventData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/EventData)));
        ((Map) (obj)).put(_Fields.PREVIOUS_CONTEXT, new FieldMetaData("previousContext", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/Context)));
        ((Map) (obj)).put(_Fields.CONTEXT, new FieldMetaData("context", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/Context)));
        ((Map) (obj)).put(_Fields.APP, new FieldMetaData("app", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/AppType)));
        ((Map) (obj)).put(_Fields.REQUEST, new FieldMetaData("request", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.APP_VERSION, new FieldMetaData("appVersion", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.DEVICE, new FieldMetaData("device", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/DeviceType)));
        ((Map) (obj)).put(_Fields.BROWSER, new FieldMetaData("browser", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/BrowserType)));
        ((Map) (obj)).put(_Fields.OS, new FieldMetaData("os", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/OSType)));
        ((Map) (obj)).put(_Fields.DEVICE_NAME, new FieldMetaData("deviceName", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.UNAUTH_ID, new FieldMetaData("unauthId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.USER_ID_STR, new FieldMetaData("userIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.OBJECT_ID_STR, new FieldMetaData("objectIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.INSERTION_ID, new FieldMetaData("insertionId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.APP_STATE, new FieldMetaData("appState", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/EventAppState)));
        ((Map) (obj)).put(_Fields.SITE, new FieldMetaData("site", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/SiteType)));
        ((Map) (obj)).put(_Fields.DIAGNOSTICS, new FieldMetaData("diagnostics", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/Diagnostics)));
        ((Map) (obj)).put(_Fields.UUID, new FieldMetaData("uuid", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.P_DATA, new FieldMetaData("pData", (byte)2, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/Event, metaDataMap);
    }


























    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields APP;
        public static final _Fields APP_STATE;
        public static final _Fields APP_VERSION;
        public static final _Fields AUX_DATA;
        public static final _Fields BROWSER;
        public static final _Fields CONTEXT;
        public static final _Fields DEVICE;
        public static final _Fields DEVICE_NAME;
        public static final _Fields DIAGNOSTICS;
        public static final _Fields EVENT_DATA;
        public static final _Fields EVENT_TYPE;
        public static final _Fields INSERTION_ID;
        public static final _Fields OBJECT_ID;
        public static final _Fields OBJECT_ID_STR;
        public static final _Fields OS;
        public static final _Fields PREVIOUS_CONTEXT;
        public static final _Fields P_DATA;
        public static final _Fields REQUEST;
        public static final _Fields SITE;
        public static final _Fields TIME;
        public static final _Fields UNAUTH_ID;
        public static final _Fields USER_ID;
        public static final _Fields USER_ID_STR;
        public static final _Fields UUID;
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
                return EVENT_TYPE;

            case 3: // '\003'
                return USER_ID;

            case 4: // '\004'
                return OBJECT_ID;

            case 5: // '\005'
                return AUX_DATA;

            case 6: // '\006'
                return EVENT_DATA;

            case 7: // '\007'
                return PREVIOUS_CONTEXT;

            case 8: // '\b'
                return CONTEXT;

            case 9: // '\t'
                return APP;

            case 10: // '\n'
                return REQUEST;

            case 11: // '\013'
                return APP_VERSION;

            case 12: // '\f'
                return DEVICE;

            case 13: // '\r'
                return BROWSER;

            case 14: // '\016'
                return OS;

            case 15: // '\017'
                return DEVICE_NAME;

            case 16: // '\020'
                return UNAUTH_ID;

            case 17: // '\021'
                return USER_ID_STR;

            case 18: // '\022'
                return OBJECT_ID_STR;

            case 19: // '\023'
                return INSERTION_ID;

            case 20: // '\024'
                return APP_STATE;

            case 21: // '\025'
                return SITE;

            case 22: // '\026'
                return DIAGNOSTICS;

            case 23: // '\027'
                return UUID;

            case 24: // '\030'
                return P_DATA;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/Event$_Fields, s);
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
            EVENT_TYPE = new _Fields("EVENT_TYPE", 1, (short)2, "eventType");
            USER_ID = new _Fields("USER_ID", 2, (short)3, "userId");
            OBJECT_ID = new _Fields("OBJECT_ID", 3, (short)4, "objectId");
            AUX_DATA = new _Fields("AUX_DATA", 4, (short)5, "auxData");
            EVENT_DATA = new _Fields("EVENT_DATA", 5, (short)6, "eventData");
            PREVIOUS_CONTEXT = new _Fields("PREVIOUS_CONTEXT", 6, (short)7, "previousContext");
            CONTEXT = new _Fields("CONTEXT", 7, (short)8, "context");
            APP = new _Fields("APP", 8, (short)9, "app");
            REQUEST = new _Fields("REQUEST", 9, (short)10, "request");
            APP_VERSION = new _Fields("APP_VERSION", 10, (short)11, "appVersion");
            DEVICE = new _Fields("DEVICE", 11, (short)12, "device");
            BROWSER = new _Fields("BROWSER", 12, (short)13, "browser");
            OS = new _Fields("OS", 13, (short)14, "os");
            DEVICE_NAME = new _Fields("DEVICE_NAME", 14, (short)15, "deviceName");
            UNAUTH_ID = new _Fields("UNAUTH_ID", 15, (short)16, "unauthId");
            USER_ID_STR = new _Fields("USER_ID_STR", 16, (short)17, "userIdStr");
            OBJECT_ID_STR = new _Fields("OBJECT_ID_STR", 17, (short)18, "objectIdStr");
            INSERTION_ID = new _Fields("INSERTION_ID", 18, (short)19, "insertionId");
            APP_STATE = new _Fields("APP_STATE", 19, (short)20, "appState");
            SITE = new _Fields("SITE", 20, (short)21, "site");
            DIAGNOSTICS = new _Fields("DIAGNOSTICS", 21, (short)22, "diagnostics");
            UUID = new _Fields("UUID", 22, (short)23, "uuid");
            P_DATA = new _Fields("P_DATA", 23, (short)24, "pData");
            $VALUES = (new _Fields[] {
                TIME, EVENT_TYPE, USER_ID, OBJECT_ID, AUX_DATA, EVENT_DATA, PREVIOUS_CONTEXT, CONTEXT, APP, REQUEST, 
                APP_VERSION, DEVICE, BROWSER, OS, DEVICE_NAME, UNAUTH_ID, USER_ID_STR, OBJECT_ID_STR, INSERTION_ID, APP_STATE, 
                SITE, DIAGNOSTICS, UUID, P_DATA
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/Event$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$Event$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$Event$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.TIME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror23) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.EVENT_TYPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror22) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.USER_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror21) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.OBJECT_ID.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror20) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.AUX_DATA.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror19) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.EVENT_DATA.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror18) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.PREVIOUS_CONTEXT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror17) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.CONTEXT.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror16) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.APP.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror15) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.REQUEST.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.APP_VERSION.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.DEVICE.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.BROWSER.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.OS.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.DEVICE_NAME.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.UNAUTH_ID.ordinal()] = 16;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.USER_ID_STR.ordinal()] = 17;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.OBJECT_ID_STR.ordinal()] = 18;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.INSERTION_ID.ordinal()] = 19;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.APP_STATE.ordinal()] = 20;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.SITE.ordinal()] = 21;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.DIAGNOSTICS.ordinal()] = 22;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.UUID.ordinal()] = 23;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Event$_Fields[_Fields.P_DATA.ordinal()] = 24;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class EventStandardSchemeFactory
        implements SchemeFactory
    {

        public EventStandardScheme getScheme()
        {
            return new EventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventStandardSchemeFactory()
        {
        }

        EventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, Event event)
            {
                tprotocol.readStructBegin();
_L27:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_1206;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 24: default 132
            //                           1 147
            //                           2 183
            //                           3 222
            //                           4 258
            //                           5 294
            //                           6 395
            //                           7 442
            //                           8 489
            //                           9 536
            //                           10 575
            //                           11 611
            //                           12 647
            //                           13 686
            //                           14 725
            //                           15 764
            //                           16 800
            //                           17 836
            //                           18 872
            //                           19 908
            //                           20 944
            //                           21 983
            //                           22 1022
            //                           23 1069
            //                           24 1105;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L25:
                break MISSING_BLOCK_LABEL_1105;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L28:
                tprotocol.readFieldEnd();
                if (true) goto _L27; else goto _L26
_L26:
                if (((TField) (obj)).type == 10)
                {
                    event.time = tprotocol.readI64();
                    event.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L3:
                if (((TField) (obj)).type == 8)
                {
                    event.eventType = EventType.findByValue(tprotocol.readI32());
                    event.setEventTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L4:
                if (((TField) (obj)).type == 10)
                {
                    event.userId = tprotocol.readI64();
                    event.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L5:
                if (((TField) (obj)).type == 10)
                {
                    event.objectId = tprotocol.readI64();
                    event.setObjectIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L6:
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    event.auxData = new HashMap(((TMap) (obj)).size * 2);
                    for (int i = 0; i < ((TMap) (obj)).size; i++)
                    {
                        String s = tprotocol.readString();
                        String s2 = tprotocol.readString();
                        event.auxData.put(s, s2);
                    }

                    tprotocol.readMapEnd();
                    event.setAuxDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L7:
                if (((TField) (obj)).type == 12)
                {
                    event.eventData = new EventData();
                    event.eventData.read(tprotocol);
                    event.setEventDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L8:
                if (((TField) (obj)).type == 12)
                {
                    event.previousContext = new Context();
                    event.previousContext.read(tprotocol);
                    event.setPreviousContextIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L9:
                if (((TField) (obj)).type == 12)
                {
                    event.context = new Context();
                    event.context.read(tprotocol);
                    event.setContextIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L10:
                if (((TField) (obj)).type == 8)
                {
                    event.app = AppType.findByValue(tprotocol.readI32());
                    event.setAppIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L11:
                if (((TField) (obj)).type == 11)
                {
                    event.request = tprotocol.readString();
                    event.setRequestIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L12:
                if (((TField) (obj)).type == 11)
                {
                    event.appVersion = tprotocol.readString();
                    event.setAppVersionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L13:
                if (((TField) (obj)).type == 8)
                {
                    event.device = DeviceType.findByValue(tprotocol.readI32());
                    event.setDeviceIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L14:
                if (((TField) (obj)).type == 8)
                {
                    event.browser = BrowserType.findByValue(tprotocol.readI32());
                    event.setBrowserIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L15:
                if (((TField) (obj)).type == 8)
                {
                    event.os = OSType.findByValue(tprotocol.readI32());
                    event.setOsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L16:
                if (((TField) (obj)).type == 11)
                {
                    event.deviceName = tprotocol.readString();
                    event.setDeviceNameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L17:
                if (((TField) (obj)).type == 11)
                {
                    event.unauthId = tprotocol.readString();
                    event.setUnauthIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L18:
                if (((TField) (obj)).type == 11)
                {
                    event.userIdStr = tprotocol.readString();
                    event.setUserIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L19:
                if (((TField) (obj)).type == 11)
                {
                    event.objectIdStr = tprotocol.readString();
                    event.setObjectIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L20:
                if (((TField) (obj)).type == 11)
                {
                    event.insertionId = tprotocol.readString();
                    event.setInsertionIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L21:
                if (((TField) (obj)).type == 8)
                {
                    event.appState = EventAppState.findByValue(tprotocol.readI32());
                    event.setAppStateIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L22:
                if (((TField) (obj)).type == 8)
                {
                    event.site = SiteType.findByValue(tprotocol.readI32());
                    event.setSiteIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L23:
                if (((TField) (obj)).type == 12)
                {
                    event.diagnostics = new Diagnostics();
                    event.diagnostics.read(tprotocol);
                    event.setDiagnosticsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
_L24:
                if (((TField) (obj)).type == 11)
                {
                    event.uuid = tprotocol.readString();
                    event.setUuidIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    event.pData = new HashMap(((TMap) (obj)).size * 2);
                    for (int j = 0; j < ((TMap) (obj)).size; j++)
                    {
                        String s1 = tprotocol.readString();
                        String s3 = tprotocol.readString();
                        event.pData.put(s1, s3);
                    }

                    tprotocol.readMapEnd();
                    event.setPDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L28
                tprotocol.readStructEnd();
                event.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Event)tbase);
            }

            public void write(TProtocol tprotocol, Event event)
            {
                event.validate();
                tprotocol.writeStructBegin(Event.STRUCT_DESC);
                tprotocol.writeFieldBegin(Event.TIME_FIELD_DESC);
                tprotocol.writeI64(event.time);
                tprotocol.writeFieldEnd();
                if (event.eventType != null)
                {
                    tprotocol.writeFieldBegin(Event.EVENT_TYPE_FIELD_DESC);
                    tprotocol.writeI32(event.eventType.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(Event.USER_ID_FIELD_DESC);
                tprotocol.writeI64(event.userId);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldBegin(Event.OBJECT_ID_FIELD_DESC);
                tprotocol.writeI64(event.objectId);
                tprotocol.writeFieldEnd();
                if (event.auxData != null)
                {
                    tprotocol.writeFieldBegin(Event.AUX_DATA_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, event.auxData.size()));
                    java.util.Map.Entry entry1;
                    for (Iterator iterator = event.auxData.entrySet().iterator(); iterator.hasNext(); tprotocol.writeString((String)entry1.getValue()))
                    {
                        entry1 = (java.util.Map.Entry)iterator.next();
                        tprotocol.writeString((String)entry1.getKey());
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                if (event.eventData != null && event.isSetEventData())
                {
                    tprotocol.writeFieldBegin(Event.EVENT_DATA_FIELD_DESC);
                    event.eventData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (event.previousContext != null && event.isSetPreviousContext())
                {
                    tprotocol.writeFieldBegin(Event.PREVIOUS_CONTEXT_FIELD_DESC);
                    event.previousContext.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (event.context != null && event.isSetContext())
                {
                    tprotocol.writeFieldBegin(Event.CONTEXT_FIELD_DESC);
                    event.context.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (event.app != null && event.isSetApp())
                {
                    tprotocol.writeFieldBegin(Event.APP_FIELD_DESC);
                    tprotocol.writeI32(event.app.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.request != null && event.isSetRequest())
                {
                    tprotocol.writeFieldBegin(Event.REQUEST_FIELD_DESC);
                    tprotocol.writeString(event.request);
                    tprotocol.writeFieldEnd();
                }
                if (event.appVersion != null && event.isSetAppVersion())
                {
                    tprotocol.writeFieldBegin(Event.APP_VERSION_FIELD_DESC);
                    tprotocol.writeString(event.appVersion);
                    tprotocol.writeFieldEnd();
                }
                if (event.device != null && event.isSetDevice())
                {
                    tprotocol.writeFieldBegin(Event.DEVICE_FIELD_DESC);
                    tprotocol.writeI32(event.device.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.browser != null && event.isSetBrowser())
                {
                    tprotocol.writeFieldBegin(Event.BROWSER_FIELD_DESC);
                    tprotocol.writeI32(event.browser.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.os != null && event.isSetOs())
                {
                    tprotocol.writeFieldBegin(Event.OS_FIELD_DESC);
                    tprotocol.writeI32(event.os.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.deviceName != null && event.isSetDeviceName())
                {
                    tprotocol.writeFieldBegin(Event.DEVICE_NAME_FIELD_DESC);
                    tprotocol.writeString(event.deviceName);
                    tprotocol.writeFieldEnd();
                }
                if (event.unauthId != null && event.isSetUnauthId())
                {
                    tprotocol.writeFieldBegin(Event.UNAUTH_ID_FIELD_DESC);
                    tprotocol.writeString(event.unauthId);
                    tprotocol.writeFieldEnd();
                }
                if (event.userIdStr != null && event.isSetUserIdStr())
                {
                    tprotocol.writeFieldBegin(Event.USER_ID_STR_FIELD_DESC);
                    tprotocol.writeString(event.userIdStr);
                    tprotocol.writeFieldEnd();
                }
                if (event.objectIdStr != null && event.isSetObjectIdStr())
                {
                    tprotocol.writeFieldBegin(Event.OBJECT_ID_STR_FIELD_DESC);
                    tprotocol.writeString(event.objectIdStr);
                    tprotocol.writeFieldEnd();
                }
                if (event.insertionId != null && event.isSetInsertionId())
                {
                    tprotocol.writeFieldBegin(Event.INSERTION_ID_FIELD_DESC);
                    tprotocol.writeString(event.insertionId);
                    tprotocol.writeFieldEnd();
                }
                if (event.appState != null && event.isSetAppState())
                {
                    tprotocol.writeFieldBegin(Event.APP_STATE_FIELD_DESC);
                    tprotocol.writeI32(event.appState.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.site != null && event.isSetSite())
                {
                    tprotocol.writeFieldBegin(Event.SITE_FIELD_DESC);
                    tprotocol.writeI32(event.site.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (event.diagnostics != null && event.isSetDiagnostics())
                {
                    tprotocol.writeFieldBegin(Event.DIAGNOSTICS_FIELD_DESC);
                    event.diagnostics.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (event.uuid != null && event.isSetUuid())
                {
                    tprotocol.writeFieldBegin(Event.UUID_FIELD_DESC);
                    tprotocol.writeString(event.uuid);
                    tprotocol.writeFieldEnd();
                }
                if (event.pData != null && event.isSetPData())
                {
                    tprotocol.writeFieldBegin(Event.P_DATA_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, event.pData.size()));
                    java.util.Map.Entry entry;
                    for (event = event.pData.entrySet().iterator(); event.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)event.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Event)tbase);
            }

            private EventStandardScheme()
            {
            }

            EventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class EventTupleSchemeFactory
        implements SchemeFactory
    {

        public EventTupleScheme getScheme()
        {
            return new EventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventTupleSchemeFactory()
        {
        }

        EventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, Event event)
            {
                boolean flag = false;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(24);
                if (bitset.get(0))
                {
                    event.time = tprotocol.readI64();
                    event.setTimeIsSet(true);
                }
                if (bitset.get(1))
                {
                    event.eventType = EventType.findByValue(tprotocol.readI32());
                    event.setEventTypeIsSet(true);
                }
                if (bitset.get(2))
                {
                    event.userId = tprotocol.readI64();
                    event.setUserIdIsSet(true);
                }
                if (bitset.get(3))
                {
                    event.objectId = tprotocol.readI64();
                    event.setObjectIdIsSet(true);
                }
                if (bitset.get(4))
                {
                    TMap tmap1 = new TMap((byte)11, (byte)11, tprotocol.readI32());
                    event.auxData = new HashMap(tmap1.size * 2);
                    for (int i = 0; i < tmap1.size; i++)
                    {
                        String s1 = tprotocol.readString();
                        String s3 = tprotocol.readString();
                        event.auxData.put(s1, s3);
                    }

                    event.setAuxDataIsSet(true);
                }
                if (bitset.get(5))
                {
                    event.eventData = new EventData();
                    event.eventData.read(tprotocol);
                    event.setEventDataIsSet(true);
                }
                if (bitset.get(6))
                {
                    event.previousContext = new Context();
                    event.previousContext.read(tprotocol);
                    event.setPreviousContextIsSet(true);
                }
                if (bitset.get(7))
                {
                    event.context = new Context();
                    event.context.read(tprotocol);
                    event.setContextIsSet(true);
                }
                if (bitset.get(8))
                {
                    event.app = AppType.findByValue(tprotocol.readI32());
                    event.setAppIsSet(true);
                }
                if (bitset.get(9))
                {
                    event.request = tprotocol.readString();
                    event.setRequestIsSet(true);
                }
                if (bitset.get(10))
                {
                    event.appVersion = tprotocol.readString();
                    event.setAppVersionIsSet(true);
                }
                if (bitset.get(11))
                {
                    event.device = DeviceType.findByValue(tprotocol.readI32());
                    event.setDeviceIsSet(true);
                }
                if (bitset.get(12))
                {
                    event.browser = BrowserType.findByValue(tprotocol.readI32());
                    event.setBrowserIsSet(true);
                }
                if (bitset.get(13))
                {
                    event.os = OSType.findByValue(tprotocol.readI32());
                    event.setOsIsSet(true);
                }
                if (bitset.get(14))
                {
                    event.deviceName = tprotocol.readString();
                    event.setDeviceNameIsSet(true);
                }
                if (bitset.get(15))
                {
                    event.unauthId = tprotocol.readString();
                    event.setUnauthIdIsSet(true);
                }
                if (bitset.get(16))
                {
                    event.userIdStr = tprotocol.readString();
                    event.setUserIdStrIsSet(true);
                }
                if (bitset.get(17))
                {
                    event.objectIdStr = tprotocol.readString();
                    event.setObjectIdStrIsSet(true);
                }
                if (bitset.get(18))
                {
                    event.insertionId = tprotocol.readString();
                    event.setInsertionIdIsSet(true);
                }
                if (bitset.get(19))
                {
                    event.appState = EventAppState.findByValue(tprotocol.readI32());
                    event.setAppStateIsSet(true);
                }
                if (bitset.get(20))
                {
                    event.site = SiteType.findByValue(tprotocol.readI32());
                    event.setSiteIsSet(true);
                }
                if (bitset.get(21))
                {
                    event.diagnostics = new Diagnostics();
                    event.diagnostics.read(tprotocol);
                    event.setDiagnosticsIsSet(true);
                }
                if (bitset.get(22))
                {
                    event.uuid = tprotocol.readString();
                    event.setUuidIsSet(true);
                }
                if (bitset.get(23))
                {
                    TMap tmap = new TMap((byte)11, (byte)11, tprotocol.readI32());
                    event.pData = new HashMap(tmap.size * 2);
                    for (int j = ((flag) ? 1 : 0); j < tmap.size; j++)
                    {
                        String s = tprotocol.readString();
                        String s2 = tprotocol.readString();
                        event.pData.put(s, s2);
                    }

                    event.setPDataIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Event)tbase);
            }

            public void write(TProtocol tprotocol, Event event)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (event.isSetTime())
                {
                    bitset.set(0);
                }
                if (event.isSetEventType())
                {
                    bitset.set(1);
                }
                if (event.isSetUserId())
                {
                    bitset.set(2);
                }
                if (event.isSetObjectId())
                {
                    bitset.set(3);
                }
                if (event.isSetAuxData())
                {
                    bitset.set(4);
                }
                if (event.isSetEventData())
                {
                    bitset.set(5);
                }
                if (event.isSetPreviousContext())
                {
                    bitset.set(6);
                }
                if (event.isSetContext())
                {
                    bitset.set(7);
                }
                if (event.isSetApp())
                {
                    bitset.set(8);
                }
                if (event.isSetRequest())
                {
                    bitset.set(9);
                }
                if (event.isSetAppVersion())
                {
                    bitset.set(10);
                }
                if (event.isSetDevice())
                {
                    bitset.set(11);
                }
                if (event.isSetBrowser())
                {
                    bitset.set(12);
                }
                if (event.isSetOs())
                {
                    bitset.set(13);
                }
                if (event.isSetDeviceName())
                {
                    bitset.set(14);
                }
                if (event.isSetUnauthId())
                {
                    bitset.set(15);
                }
                if (event.isSetUserIdStr())
                {
                    bitset.set(16);
                }
                if (event.isSetObjectIdStr())
                {
                    bitset.set(17);
                }
                if (event.isSetInsertionId())
                {
                    bitset.set(18);
                }
                if (event.isSetAppState())
                {
                    bitset.set(19);
                }
                if (event.isSetSite())
                {
                    bitset.set(20);
                }
                if (event.isSetDiagnostics())
                {
                    bitset.set(21);
                }
                if (event.isSetUuid())
                {
                    bitset.set(22);
                }
                if (event.isSetPData())
                {
                    bitset.set(23);
                }
                tprotocol.writeBitSet(bitset, 24);
                if (event.isSetTime())
                {
                    tprotocol.writeI64(event.time);
                }
                if (event.isSetEventType())
                {
                    tprotocol.writeI32(event.eventType.getValue());
                }
                if (event.isSetUserId())
                {
                    tprotocol.writeI64(event.userId);
                }
                if (event.isSetObjectId())
                {
                    tprotocol.writeI64(event.objectId);
                }
                if (event.isSetAuxData())
                {
                    tprotocol.writeI32(event.auxData.size());
                    java.util.Map.Entry entry1;
                    for (Iterator iterator = event.auxData.entrySet().iterator(); iterator.hasNext(); tprotocol.writeString((String)entry1.getValue()))
                    {
                        entry1 = (java.util.Map.Entry)iterator.next();
                        tprotocol.writeString((String)entry1.getKey());
                    }

                }
                if (event.isSetEventData())
                {
                    event.eventData.write(tprotocol);
                }
                if (event.isSetPreviousContext())
                {
                    event.previousContext.write(tprotocol);
                }
                if (event.isSetContext())
                {
                    event.context.write(tprotocol);
                }
                if (event.isSetApp())
                {
                    tprotocol.writeI32(event.app.getValue());
                }
                if (event.isSetRequest())
                {
                    tprotocol.writeString(event.request);
                }
                if (event.isSetAppVersion())
                {
                    tprotocol.writeString(event.appVersion);
                }
                if (event.isSetDevice())
                {
                    tprotocol.writeI32(event.device.getValue());
                }
                if (event.isSetBrowser())
                {
                    tprotocol.writeI32(event.browser.getValue());
                }
                if (event.isSetOs())
                {
                    tprotocol.writeI32(event.os.getValue());
                }
                if (event.isSetDeviceName())
                {
                    tprotocol.writeString(event.deviceName);
                }
                if (event.isSetUnauthId())
                {
                    tprotocol.writeString(event.unauthId);
                }
                if (event.isSetUserIdStr())
                {
                    tprotocol.writeString(event.userIdStr);
                }
                if (event.isSetObjectIdStr())
                {
                    tprotocol.writeString(event.objectIdStr);
                }
                if (event.isSetInsertionId())
                {
                    tprotocol.writeString(event.insertionId);
                }
                if (event.isSetAppState())
                {
                    tprotocol.writeI32(event.appState.getValue());
                }
                if (event.isSetSite())
                {
                    tprotocol.writeI32(event.site.getValue());
                }
                if (event.isSetDiagnostics())
                {
                    event.diagnostics.write(tprotocol);
                }
                if (event.isSetUuid())
                {
                    tprotocol.writeString(event.uuid);
                }
                if (event.isSetPData())
                {
                    tprotocol.writeI32(event.pData.size());
                    java.util.Map.Entry entry;
                    for (event = event.pData.entrySet().iterator(); event.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)event.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Event)tbase);
            }

            private EventTupleScheme()
            {
            }

            EventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
