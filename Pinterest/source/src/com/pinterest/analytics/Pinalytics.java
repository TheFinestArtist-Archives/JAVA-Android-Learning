// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.pinterest.activity.search.GuidedSearchFragment;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.fragment.ViewPagerFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Category;
import com.pinterest.api.model.MyUser;
import com.pinterest.appwidget.MccMnc;
import com.pinterest.appwidget.SwitcherActivity;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Device;
import com.pinterest.developer.DeveloperHelper;
import com.pinterest.kit.activity.BaseActivity;
import com.pinterest.kit.tasks.IntervalRunner;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.Context;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.event.Event;
import com.pinterest.schemas.event.EventBatch;
import com.pinterest.schemas.event.EventData;
import com.pinterest.schemas.event.EventType;
import com.pinterest.schemas.event.ViewData;
import com.pinterest.schemas.event.ViewParameterType;
import com.pinterest.schemas.event.ViewType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.analytics:
//            ViewTypeResolver, ViewParameterTypeResolver, ExternalAnalytics

public class Pinalytics
{

    private static com.pinterest.kit.tasks.IntervalRunner.IntervalCallback a;
    private static EventBatch b = new EventBatch();
    private static Context c;

    public static Event a(Activity activity)
    {
        return a(activity, ((Class) (null)));
    }

    public static Event a(Activity activity, Class class1)
    {
        ViewType viewtype1 = ViewTypeResolver.a(activity.getClass());
        Object obj = null;
        if (!(activity instanceof BaseActivity)) goto _L2; else goto _L1
_L1:
        if (!(activity instanceof SwitcherActivity)) goto _L4; else goto _L3
_L3:
        if (!MyUser.hasAccessToken()) goto _L6; else goto _L5
_L5:
        obj = ViewParameterType.FEED_HOME;
        ViewType viewtype = viewtype1;
_L13:
        class1 = new Context();
        c = class1;
        class1.setViewType(viewtype);
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!(obj instanceof ViewParameterType)) goto _L10; else goto _L9
_L9:
        c.setViewParameter((ViewParameterType)obj);
_L8:
        c(activity.getClass());
          goto _L11
_L6:
        obj = ViewParameterType.FEED_WELCOME;
        viewtype = viewtype1;
        continue; /* Loop/switch isn't completed */
_L4:
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        viewtype = viewtype1;
        if (viewtype1 != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        viewtype = ViewTypeResolver.a(class1);
        obj = ViewParameterTypeResolver.a(class1);
        continue; /* Loop/switch isn't completed */
        class1 = ((BaseActivity)activity).getActiveFragment();
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj = ViewParameterTypeResolver.a(class1.getClass());
        viewtype = viewtype1;
        continue; /* Loop/switch isn't completed */
        obj = ViewParameterTypeResolver.a(activity.getClass());
        viewtype = viewtype1;
        continue; /* Loop/switch isn't completed */
_L2:
        viewtype = viewtype1;
        if (class1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ViewParameterTypeResolver.a(class1);
        viewtype = viewtype1;
        continue; /* Loop/switch isn't completed */
_L10:
        c.setViewType((ViewType)obj);
          goto _L8
        activity;
_L11:
        if (c == null)
        {
            return new Event();
        }
        class1 = new Event();
        class1.setApp(Device.getAppType());
        class1.setAppState(ApplicationInfo.getState().getContextEnum());
        class1.setTime(System.currentTimeMillis() * 0xf4240L);
        class1.setEventType(EventType.VIEW);
        if (MyUser.getUid() != null)
        {
            class1.setUserIdStr(MyUser.getUid());
        }
        class1.setUnauthId(ApplicationInfo.getInstallId());
        class1.setContext(c.deepCopy());
        synchronized (b)
        {
            b.addToEvents(class1);
        }
        ExternalAnalytics.a(c.getViewType(), c.getViewParameter());
        if (ApplicationInfo.isNonProduction() && DeveloperHelper.a())
        {
            b(class1);
        }
        a(((Event) (class1)));
        return class1;
          goto _L8
        class1;
        activity;
        JVM INSTR monitorexit ;
        throw class1;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static Event a(Fragment fragment)
    {
        Object obj3;
        obj3 = null;
        if (fragment instanceof GuidedSearchFragment)
        {
            return null;
        }
        if (!(fragment instanceof BaseFragment))
        {
            break MISSING_BLOCK_LABEL_617;
        }
        obj = ((BaseFragment)fragment).getNavigation();
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        Location location;
        location = ((Navigation) (obj)).getLocation();
        obj1 = ((Navigation) (obj)).getId();
_L27:
        ViewType viewtype1 = ViewTypeResolver.a(fragment.getClass());
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (location != Location.CATEGORY) goto _L4; else goto _L5
_L5:
        obj = ((Navigation) (obj)).getCachedModel();
        if (!(obj instanceof Category)) goto _L7; else goto _L6
_L6:
        obj = ViewParameterType.findByValue(((Category)obj).getId().intValue());
        ViewType viewtype;
        Object obj2;
        obj2 = obj1;
        viewtype = viewtype1;
_L26:
        obj1 = new Context();
        c = ((Context) (obj1));
        ((Context) (obj1)).setViewType(viewtype);
        if (obj == null) goto _L9; else goto _L8
_L8:
        if (!(obj instanceof ViewParameterType)) goto _L11; else goto _L10
_L10:
        c.setViewParameter((ViewParameterType)obj);
_L9:
        if (location == Location.BROWSER || location == Location.CATEGORY || !StringUtils.isNotBlank(((CharSequence) (obj2)))) goto _L13; else goto _L12
_L12:
        obj = new ViewData();
        ((ViewData) (obj)).setViewObjectIdStr(((String) (obj2)));
_L25:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        c.setViewData(((ViewData) (obj)));
        c(fragment.getClass());
_L19:
        if (c == null)
        {
            return new Event();
        }
          goto _L14
_L4:
        if (!(fragment instanceof ViewPagerFragment)) goto _L16; else goto _L15
_L15:
        obj = ((ViewPagerFragment)fragment).getActiveFragment();
        if (obj == null) goto _L18; else goto _L17
_L17:
        org.apache.thrift.TEnum tenum;
        Navigation navigation;
        viewtype1 = ViewTypeResolver.a(obj.getClass());
        tenum = ViewParameterTypeResolver.a(obj.getClass());
        navigation = ((BaseFragment) (obj)).getNavigation();
        obj = tenum;
        viewtype = viewtype1;
        obj2 = obj1;
        if (navigation == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = navigation.getId();
        obj = tenum;
        viewtype = viewtype1;
        continue; /* Loop/switch isn't completed */
_L16:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        if (((Navigation) (obj)).getFragmentClass() == com/pinterest/activity/search/GuidedSearchFragment)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        obj = ViewParameterTypeResolver.a(((Navigation) (obj)).getFragmentClass());
        viewtype = viewtype1;
        obj2 = obj1;
        continue; /* Loop/switch isn't completed */
        tenum = ViewParameterTypeResolver.a(fragment.getClass());
        obj = tenum;
        viewtype = viewtype1;
        obj2 = obj1;
        if (!(tenum instanceof ViewParameterType))
        {
            obj = null;
            viewtype = viewtype1;
            obj2 = obj1;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        c.setViewType((ViewType)obj);
          goto _L9
        obj;
        CrashReporting.logHandledException(((Throwable) (obj)));
          goto _L19
_L14:
        if (!(fragment instanceof ViewPagerFragment)) goto _L21; else goto _L20
_L20:
        fragment = ((ViewPagerFragment)fragment).getActiveFragment();
        if (fragment == null) goto _L23; else goto _L22
_L22:
        fragment = fragment.getNavigation();
_L24:
        obj = obj3;
        if (fragment != null)
        {
            obj = fragment.getId();
        }
        fragment = new Event();
        fragment.setApp(Device.getAppType());
        fragment.setAppState(ApplicationInfo.getState().getContextEnum());
        fragment.setTime(System.currentTimeMillis() * 0xf4240L);
        fragment.setEventType(EventType.VIEW);
        if (StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            fragment.setObjectIdStr(((String) (obj)));
        }
        if (MyUser.getUid() != null)
        {
            fragment.setUserIdStr(MyUser.getUid());
        }
        fragment.setUnauthId(ApplicationInfo.getInstallId());
        fragment.setContext(c.deepCopy());
        synchronized (b)
        {
            b.addToEvents(fragment);
        }
        ExternalAnalytics.a(c.getViewType(), c.getViewParameter());
        if (ApplicationInfo.isNonProduction() && DeveloperHelper.a())
        {
            b(fragment);
        }
        a(((Event) (fragment)));
        return fragment;
_L21:
        if (fragment instanceof BaseFragment)
        {
            fragment = ((BaseFragment)fragment).getNavigation();
            continue; /* Loop/switch isn't completed */
        }
          goto _L23
        fragment;
        obj;
        JVM INSTR monitorexit ;
        throw fragment;
_L23:
        fragment = null;
        if (true) goto _L24; else goto _L13
_L13:
        obj = null;
          goto _L25
_L18:
        obj = null;
        viewtype = viewtype1;
        obj2 = obj1;
        continue; /* Loop/switch isn't completed */
_L7:
        obj = null;
        viewtype = viewtype1;
        obj2 = obj1;
        if (true) goto _L26; else goto _L2
_L2:
        obj1 = null;
        location = null;
          goto _L27
        obj1 = null;
        location = null;
        obj = null;
          goto _L27
    }

    public static Event a(ElementType elementtype, ComponentType componenttype, String s)
    {
        return b(EventType.TAP, elementtype, componenttype, s);
    }

    public static Event a(EventType eventtype, ElementType elementtype, ComponentType componenttype, String s)
    {
        return b(eventtype, elementtype, componenttype, s);
    }

    public static Event a(EventType eventtype, ElementType elementtype, ComponentType componenttype, String s, HashMap hashmap)
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        eventtype = null;
_L4:
        return eventtype;
_L2:
        if (c != null)
        {
            c.unsetElement();
            c.unsetElementData();
            c.unsetComponent();
            if (elementtype != null)
            {
                c.setElement(elementtype);
            }
            if (componenttype != null)
            {
                c.setComponent(componenttype);
            }
        }
        elementtype = new Event();
        elementtype.setApp(Device.getAppType());
        elementtype.setAppState(ApplicationInfo.getState().getContextEnum());
        elementtype.setTime(System.currentTimeMillis() * 0xf4240L);
        elementtype.setEventType(eventtype);
        if (s != null)
        {
            elementtype.setObjectIdStr(s);
        }
        if (MyUser.getUid() != null)
        {
            elementtype.setUserIdStr(MyUser.getUid());
        }
        elementtype.setUnauthId(ApplicationInfo.getInstallId());
        elementtype.setContext(c.deepCopy());
        if (hashmap != null)
        {
            elementtype.setAuxData(hashmap);
        }
        synchronized (b)
        {
            b.addToEvents(elementtype);
        }
        ExternalAnalytics.a(elementtype.getEventType(), c.getElement(), c.getComponent());
        eventtype = elementtype;
        if (!ApplicationInfo.isNonProduction()) goto _L4; else goto _L3
_L3:
        a(((Event) (elementtype)));
        eventtype = elementtype;
        if (!DeveloperHelper.a()) goto _L4; else goto _L5
_L5:
        b(elementtype);
        return elementtype;
        elementtype;
        eventtype;
        JVM INSTR monitorexit ;
        throw elementtype;
    }

    public static Event a(EventType eventtype, String s)
    {
        return a(eventtype, s, ((EventData) (null)), ((HashMap) (null)));
    }

    public static Event a(EventType eventtype, String s, EventData eventdata, HashMap hashmap)
    {
        Event event = new Event();
        event.setApp(Device.getAppType());
        event.setAppState(ApplicationInfo.getState().getContextEnum());
        event.setTime(System.currentTimeMillis() * 0xf4240L);
        event.setEventType(eventtype);
        if (c != null)
        {
            event.setContext(c.deepCopy());
        }
        if (s != null)
        {
            event.setObjectIdStr(s);
        }
        if (eventdata != null)
        {
            event.setEventData(eventdata);
        }
        if (MyUser.getUid() != null)
        {
            event.setUserIdStr(MyUser.getUid());
        }
        event.setUnauthId(ApplicationInfo.getInstallId());
        if (hashmap != null)
        {
            event.setAuxData(new HashMap(hashmap));
        }
        synchronized (b)
        {
            b.addToEvents(event);
        }
        ExternalAnalytics.a(eventtype);
        if (ApplicationInfo.isNonProduction())
        {
            a(event);
            if (DeveloperHelper.a())
            {
                b(event);
            }
        }
        return event;
        eventtype;
        s;
        JVM INSTR monitorexit ;
        throw eventtype;
    }

    public static Event a(EventType eventtype, String s, ViewType viewtype, ViewParameterType viewparametertype, HashMap hashmap)
    {
        if (c != null)
        {
            Context context = new Context();
            c = context;
            context.setViewType(viewtype);
            if (viewparametertype != null)
            {
                c.setViewParameter(viewparametertype);
            }
        }
        return a(eventtype, s, ((EventData) (null)), hashmap);
    }

    public static Event a(EventType eventtype, String s, HashMap hashmap)
    {
        return a(eventtype, s, ((EventData) (null)), hashmap);
    }

    public static Event a(EventType eventtype, List list)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (list != null)
        {
            obj = obj1;
            if (!list.isEmpty())
            {
                obj = new EventData();
                ((EventData) (obj)).setPinImpressions(list);
                obj = a(eventtype, ((String) (null)), ((EventData) (obj)), ((HashMap) (null)));
            }
        }
        return ((Event) (obj));
    }

    public static ViewType a(Class class1)
    {
        ViewType viewtype = ViewTypeResolver.a(class1);
        class1 = ViewParameterTypeResolver.a(class1);
        if (class1 instanceof ViewType)
        {
            return (ViewType)class1;
        } else
        {
            return viewtype;
        }
    }

    public static HashMap a()
    {
        HashMap hashmap = new HashMap(3);
        hashmap.put("android_preinstall", String.valueOf(ApplicationInfo.isPreinstalled()));
        MccMnc mccmnc = Device.getNetworkOperatorFromConfig();
        hashmap.put("device_mcc", String.valueOf(mccmnc.mcc));
        hashmap.put("device_mnc", String.valueOf(mccmnc.mnc));
        return hashmap;
    }

    public static void a(ElementType elementtype)
    {
        a(EventType.TAP, elementtype, ((ComponentType) (null)), ((String) (null)), null);
    }

    public static void a(ElementType elementtype, ComponentType componenttype)
    {
        a(EventType.TAP, elementtype, componenttype, ((String) (null)), null);
    }

    public static void a(ElementType elementtype, ComponentType componenttype, String s, HashMap hashmap)
    {
        a(EventType.TAP, elementtype, componenttype, s, hashmap);
    }

    public static void a(ElementType elementtype, ComponentType componenttype, HashMap hashmap)
    {
        a(EventType.TAP, elementtype, componenttype, ((String) (null)), hashmap);
    }

    public static void a(ElementType elementtype, HashMap hashmap)
    {
        a(EventType.TAP, elementtype, ((ComponentType) (null)), ((String) (null)), hashmap);
    }

    private static void a(Event event)
    {
        if (!ApplicationInfo.isNonProduction())
        {
            break MISSING_BLOCK_LABEL_192;
        }
        StringBuilder stringbuilder;
        Object obj;
        try
        {
            stringbuilder = new StringBuilder("Event {\n\t");
            stringbuilder.append("EventType: ").append(event.getEventType()).append("\n\t");
            obj = event.getObjectIdStr();
        }
        // Misplaced declaration of an exception variable
        catch (Event event)
        {
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        stringbuilder.append("ObjectId: ").append(((String) (obj))).append("\n\t");
        obj = event.getAuxData();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (((Map) (obj)).values().size() > 0)
        {
            stringbuilder.append("AuxData: ").append(obj).append("\n\t");
        }
        obj = event.getContext();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        stringbuilder.append("Context: ").append(obj).append("\n\t");
        obj = event.getEventData();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        stringbuilder.append("PinImpressions: ").append(((EventData) (obj)).getPinImpressions()).append("\n\t");
        stringbuilder.append("AppState: ").append(event.getAppState()).append("\n\t");
        stringbuilder.append("}");
    }

    public static Event b()
    {
        return null;
    }

    private static Event b(EventType eventtype, ElementType elementtype, ComponentType componenttype, String s)
    {
        return a(eventtype, elementtype, componenttype, s, null);
    }

    public static ViewParameterType b(Class class1)
    {
        org.apache.thrift.TEnum tenum = ViewParameterTypeResolver.a(class1);
        class1 = tenum;
        if (tenum instanceof ViewType)
        {
            class1 = null;
        }
        return (ViewParameterType)class1;
    }

    private static void b(Event event)
    {
        boolean flag = false;
        StringBuilder stringbuilder;
        Context context;
        int i;
        if (event.eventType == EventType.DRAG || event.eventType == EventType.SWIPE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append(String.format("%-15s:", new Object[] {
            event.getEventType()
        }));
        context = event.getContext();
        if (context != null)
        {
            if (context.getElement() != null)
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    context.getElement()
                }));
            } else
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    " "
                }));
            }
            if (context.getComponent() != null)
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    context.getComponent()
                }));
            } else
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    " "
                }));
            }
        } else
        {
            stringbuilder.append(String.format("%-15s:", new Object[] {
                " "
            })).append(String.format("%-15s:", new Object[] {
                " "
            }));
        }
        if (context != null)
        {
            if (context.getViewType() != null)
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    context.getViewType()
                }));
            } else
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    " "
                }));
            }
            if (context.getViewParameter() != null)
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    context.getViewParameter()
                }));
            } else
            {
                stringbuilder.append(String.format("%-15s:", new Object[] {
                    " "
                }));
            }
        }
        if (event.getObjectIdStr() != null)
        {
            stringbuilder.append(String.format("%-15s:", new Object[] {
                event.getObjectIdStr()
            }));
        } else
        {
            stringbuilder.append(String.format("%-15s:", new Object[] {
                " "
            }));
        }
        stringbuilder.append(String.format("%-15s:", new Object[] {
            event.getUnauthId()
        }));
        event = stringbuilder.toString();
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 1;
        }
        Application.showDebugToast(event, i);
    }

    public static Event c()
    {
        return null;
    }

    private static void c(Class class1)
    {
        if (!ApplicationInfo.isNonProduction()) goto _L2; else goto _L1
_L1:
        Object obj;
        ViewType viewtype;
        ViewParameterType viewparametertype;
        obj = null;
        viewtype = c.getViewType();
        viewparametertype = c.getViewParameter();
        if (viewtype != null) goto _L4; else goto _L3
_L3:
        String s = (new StringBuilder("Context: View for ")).append(class1.getSimpleName()).append(" is missing!").toString();
_L6:
        if (s != null)
        {
            Application.showDebugErrorToast(s);
            (new StringBuilder()).append(s).append("\nPlease see Pinalytics.java for View and ViewParameter context logging.");
        }
_L2:
        return;
_L4:
        s = obj;
        if (viewtype.equals(ViewType.FEED))
        {
            s = obj;
            if (viewparametertype == null)
            {
                s = (new StringBuilder("Context: ViewParameter for ")).append(class1.getSimpleName()).append(" is missing!").toString();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void d()
    {
        b(EventType.DRAG, null, ComponentType.NAVIGATION, null);
    }

    public static void e()
    {
        b(EventType.SWIPE, null, ComponentType.NAVIGATION, null);
    }

    public static void f()
    {
        a(ElementType.BACK_BUTTON, ComponentType.NAVIGATION);
    }

    static EventBatch g()
    {
        return b;
    }

    static com.pinterest.kit.tasks.IntervalRunner.IntervalCallback h()
    {
        return a;
    }

    static 
    {
        a = new _cls1();
        IntervalRunner.instance().addCallback(a);
    }

    private class _cls1 extends com.pinterest.kit.tasks.IntervalRunner.IntervalCallback
    {

        private EventBatch a;
        private final BaseApiResponseHandler b = new _cls1();

        static EventBatch a(_cls1 _pcls1)
        {
            return _pcls1.a;
        }

        private void a()
        {
            EventBatch eventbatch = Pinalytics.g();
            eventbatch;
            JVM INSTR monitorenter ;
            if (Pinalytics.g().events != null && Pinalytics.g().events.size() != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            TByteArrayOutputStream tbytearrayoutputstream;
            TBinaryProtocol tbinaryprotocol;
            a = Pinalytics.g().deepCopy();
            tbytearrayoutputstream = new TByteArrayOutputStream();
            tbinaryprotocol = new TBinaryProtocol(new TIOStreamTransport(tbytearrayoutputstream));
            a.setReportTime(System.currentTimeMillis() * 0xf4240L);
            a.write(tbinaryprotocol);
            byte abyte0[] = tbytearrayoutputstream.toByteArray();
            AnalyticsApi.a(abyte0, b);
            IntervalRunner.instance().removeCallback(Pinalytics.h());
            int i = abyte0.length / 1000;
              goto _L1
            Object obj;
            obj;
            ((Exception) (obj)).printStackTrace();
              goto _L1
            obj;
            eventbatch;
            JVM INSTR monitorexit ;
            throw obj;
        }

        public final void onInterval()
        {
            a();
        }

        public final void onStop()
        {
            a();
        }

        _cls1()
        {
            class _cls1 extends BaseApiResponseHandler
            {

                final _cls1 a;

                public void onFailure(Throwable throwable, ApiResponse apiresponse)
                {
                    if (apiresponse.getCode() != 15) goto _L2; else goto _L1
_L1:
                    String.valueOf(apiresponse);
                    if (Pinalytics.g() == null) goto _L4; else goto _L3
_L3:
                    throwable = Pinalytics.g();
                    throwable;
                    JVM INSTR monitorenter ;
                    List list;
                    if (_cls1.a(a) == null)
                    {
                        break MISSING_BLOCK_LABEL_74;
                    }
                    list = _cls1.a(a).getEvents();
                    if (list == null)
                    {
                        break MISSING_BLOCK_LABEL_64;
                    }
                    Pinalytics.g().getEvents().removeAll(list);
                    _cls1.a(a).clear();
                    throwable;
                    JVM INSTR monitorexit ;
_L4:
                    if (ApplicationInfo.isNonProduction())
                    {
                        PinterestJsonObject pinterestjsonobject = apiresponse.getDeveloperError();
                        if (pinterestjsonobject != null)
                        {
                            apiresponse = pinterestjsonobject.a("message", "");
                            throwable = apiresponse;
                            if (StringUtils.isBlank(apiresponse))
                            {
                                throwable = String.valueOf(pinterestjsonobject);
                            }
                            throwable = (new StringBuilder()).append("ContextAPI: ").append(String.valueOf(throwable)).toString();
                        } else
                        {
                            throwable = (new StringBuilder()).append("ContextAPI: ").append("Failure! See logs for details.").toString();
                        }
                        Application.showDebugErrorToast(throwable);
                    }
_L6:
                    IntervalRunner.instance().addCallback(Pinalytics.h());
                    return;
                    apiresponse;
                    throwable;
                    JVM INSTR monitorexit ;
                    throw apiresponse;
_L2:
                    apiresponse.getMessageDisplay();
                    if (true) goto _L6; else goto _L5
_L5:
                }

                public void onSuccess(ApiResponse apiresponse)
                {
                    super.onSuccess(apiresponse);
                    if (Pinalytics.g() == null) goto _L2; else goto _L1
_L1:
                    apiresponse = Pinalytics.g();
                    apiresponse;
                    JVM INSTR monitorenter ;
                    List list;
                    if (_cls1.a(a) == null)
                    {
                        break MISSING_BLOCK_LABEL_65;
                    }
                    list = _cls1.a(a).getEvents();
                    if (list == null)
                    {
                        break MISSING_BLOCK_LABEL_55;
                    }
                    Pinalytics.g().getEvents().removeAll(list);
                    _cls1.a(a).clear();
                    apiresponse;
                    JVM INSTR monitorexit ;
_L2:
                    IntervalRunner.instance().addCallback(Pinalytics.h());
                    return;
                    Exception exception;
                    exception;
                    apiresponse;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                _cls1()
                {
                    a = _cls1.this;
                    super();
                }
            }

        }
    }

}
