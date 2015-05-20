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
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
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
//            ViewType, ViewParameterType, ViewData, ComponentType, 
//            ComponentData, ElementType, ElementData

public class Context
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField COMPONENT_DATA_FIELD_DESC = new TField("componentData", (byte)12, (short)5);
    private static final TField COMPONENT_FIELD_DESC = new TField("component", (byte)8, (short)4);
    private static final TField ELEMENT_DATA_FIELD_DESC = new TField("elementData", (byte)12, (short)7);
    private static final TField ELEMENT_FIELD_DESC = new TField("element", (byte)8, (short)6);
    private static final TStruct STRUCT_DESC = new TStruct("Context");
    private static final TField VIEW_DATA_FIELD_DESC = new TField("viewData", (byte)12, (short)3);
    private static final TField VIEW_PARAMETER_FIELD_DESC = new TField("viewParameter", (byte)8, (short)2);
    private static final TField VIEW_TYPE_FIELD_DESC = new TField("viewType", (byte)8, (short)1);
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public ComponentType component;
    public ComponentData componentData;
    public ElementType element;
    public ElementData elementData;
    public ViewData viewData;
    public ViewParameterType viewParameter;
    public ViewType viewType;

    public Context()
    {
    }

    public Context(Context context)
    {
        if (context.isSetViewType())
        {
            viewType = context.viewType;
        }
        if (context.isSetViewParameter())
        {
            viewParameter = context.viewParameter;
        }
        if (context.isSetViewData())
        {
            viewData = new ViewData(context.viewData);
        }
        if (context.isSetComponent())
        {
            component = context.component;
        }
        if (context.isSetComponentData())
        {
            componentData = new ComponentData(context.componentData);
        }
        if (context.isSetElement())
        {
            element = context.element;
        }
        if (context.isSetElementData())
        {
            elementData = new ElementData(context.elementData);
        }
    }

    public Context(ViewType viewtype)
    {
        this();
        viewType = viewtype;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
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
        viewType = null;
        viewParameter = null;
        viewData = null;
        component = null;
        componentData = null;
        element = null;
        elementData = null;
    }

    public int compareTo(Context context)
    {
        if (getClass().equals(context.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(context.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetViewType()).compareTo(Boolean.valueOf(context.isSetViewType()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetViewType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewType, context.viewType);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetViewParameter()).compareTo(Boolean.valueOf(context.isSetViewParameter()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetViewParameter())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewParameter, context.viewParameter);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetViewData()).compareTo(Boolean.valueOf(context.isSetViewData()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetViewData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewData, context.viewData);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetComponent()).compareTo(Boolean.valueOf(context.isSetComponent()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetComponent())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(component, context.component);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetComponentData()).compareTo(Boolean.valueOf(context.isSetComponentData()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetComponentData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(componentData, context.componentData);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetElement()).compareTo(Boolean.valueOf(context.isSetElement()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetElement())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(element, context.element);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetElementData()).compareTo(Boolean.valueOf(context.isSetElementData()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetElementData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(elementData, context.elementData);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Context)obj);
    }

    public Context deepCopy()
    {
        return new Context(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(Context context)
    {
        if (context != null)
        {
            boolean flag = isSetViewType();
            boolean flag7 = context.isSetViewType();
            if (!flag && !flag7 || flag && flag7 && viewType.equals(context.viewType))
            {
                boolean flag1 = isSetViewParameter();
                boolean flag8 = context.isSetViewParameter();
                if (!flag1 && !flag8 || flag1 && flag8 && viewParameter.equals(context.viewParameter))
                {
                    boolean flag2 = isSetViewData();
                    boolean flag9 = context.isSetViewData();
                    if (!flag2 && !flag9 || flag2 && flag9 && viewData.equals(context.viewData))
                    {
                        boolean flag3 = isSetComponent();
                        boolean flag10 = context.isSetComponent();
                        if (!flag3 && !flag10 || flag3 && flag10 && component.equals(context.component))
                        {
                            boolean flag4 = isSetComponentData();
                            boolean flag11 = context.isSetComponentData();
                            if (!flag4 && !flag11 || flag4 && flag11 && componentData.equals(context.componentData))
                            {
                                boolean flag5 = isSetElement();
                                boolean flag12 = context.isSetElement();
                                if (!flag5 && !flag12 || flag5 && flag12 && element.equals(context.element))
                                {
                                    boolean flag6 = isSetElementData();
                                    boolean flag13 = context.isSetElementData();
                                    if (!flag6 && !flag13 || flag6 && flag13 && elementData.equals(context.elementData))
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
        while (obj == null || !(obj instanceof Context)) 
        {
            return false;
        }
        return equals((Context)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public ComponentType getComponent()
    {
        return component;
    }

    public ComponentData getComponentData()
    {
        return componentData;
    }

    public ElementType getElement()
    {
        return element;
    }

    public ElementData getElementData()
    {
        return elementData;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Context._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getViewType();

        case 2: // '\002'
            return getViewParameter();

        case 3: // '\003'
            return getViewData();

        case 4: // '\004'
            return getComponent();

        case 5: // '\005'
            return getComponentData();

        case 6: // '\006'
            return getElement();

        case 7: // '\007'
            return getElementData();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public ViewData getViewData()
    {
        return viewData;
    }

    public ViewParameterType getViewParameter()
    {
        return viewParameter;
    }

    public ViewType getViewType()
    {
        return viewType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetViewType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(viewType.getValue()));
        }
        flag = isSetViewParameter();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(viewParameter.getValue()));
        }
        flag = isSetViewData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(viewData);
        }
        flag = isSetComponent();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(component.getValue()));
        }
        flag = isSetComponentData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(componentData);
        }
        flag = isSetElement();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(element.getValue()));
        }
        flag = isSetElementData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(elementData);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Context._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetViewType();

        case 2: // '\002'
            return isSetViewParameter();

        case 3: // '\003'
            return isSetViewData();

        case 4: // '\004'
            return isSetComponent();

        case 5: // '\005'
            return isSetComponentData();

        case 6: // '\006'
            return isSetElement();

        case 7: // '\007'
            return isSetElementData();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetComponent()
    {
        return component != null;
    }

    public boolean isSetComponentData()
    {
        return componentData != null;
    }

    public boolean isSetElement()
    {
        return element != null;
    }

    public boolean isSetElementData()
    {
        return elementData != null;
    }

    public boolean isSetViewData()
    {
        return viewData != null;
    }

    public boolean isSetViewParameter()
    {
        return viewParameter != null;
    }

    public boolean isSetViewType()
    {
        return viewType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public Context setComponent(ComponentType componenttype)
    {
        component = componenttype;
        return this;
    }

    public Context setComponentData(ComponentData componentdata)
    {
        componentData = componentdata;
        return this;
    }

    public void setComponentDataIsSet(boolean flag)
    {
        if (!flag)
        {
            componentData = null;
        }
    }

    public void setComponentIsSet(boolean flag)
    {
        if (!flag)
        {
            component = null;
        }
    }

    public Context setElement(ElementType elementtype)
    {
        element = elementtype;
        return this;
    }

    public Context setElementData(ElementData elementdata)
    {
        elementData = elementdata;
        return this;
    }

    public void setElementDataIsSet(boolean flag)
    {
        if (!flag)
        {
            elementData = null;
        }
    }

    public void setElementIsSet(boolean flag)
    {
        if (!flag)
        {
            element = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Context._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetViewType();
                return;
            } else
            {
                setViewType((ViewType)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetViewParameter();
                return;
            } else
            {
                setViewParameter((ViewParameterType)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetViewData();
                return;
            } else
            {
                setViewData((ViewData)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetComponent();
                return;
            } else
            {
                setComponent((ComponentType)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetComponentData();
                return;
            } else
            {
                setComponentData((ComponentData)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetElement();
                return;
            } else
            {
                setElement((ElementType)obj);
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetElementData();
            return;
        } else
        {
            setElementData((ElementData)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public Context setViewData(ViewData viewdata)
    {
        viewData = viewdata;
        return this;
    }

    public void setViewDataIsSet(boolean flag)
    {
        if (!flag)
        {
            viewData = null;
        }
    }

    public Context setViewParameter(ViewParameterType viewparametertype)
    {
        viewParameter = viewparametertype;
        return this;
    }

    public void setViewParameterIsSet(boolean flag)
    {
        if (!flag)
        {
            viewParameter = null;
        }
    }

    public Context setViewType(ViewType viewtype)
    {
        viewType = viewtype;
        return this;
    }

    public void setViewTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            viewType = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Context(");
        stringbuilder.append("viewType:");
        if (viewType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(viewType);
        }
        if (isSetViewParameter())
        {
            stringbuilder.append(", ");
            stringbuilder.append("viewParameter:");
            if (viewParameter == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(viewParameter);
            }
        }
        if (isSetViewData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("viewData:");
            if (viewData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(viewData);
            }
        }
        if (isSetComponent())
        {
            stringbuilder.append(", ");
            stringbuilder.append("component:");
            if (component == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(component);
            }
        }
        if (isSetComponentData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("componentData:");
            if (componentData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(componentData);
            }
        }
        if (isSetElement())
        {
            stringbuilder.append(", ");
            stringbuilder.append("element:");
            if (element == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(element);
            }
        }
        if (isSetElementData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("elementData:");
            if (elementData == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(elementData);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetComponent()
    {
        component = null;
    }

    public void unsetComponentData()
    {
        componentData = null;
    }

    public void unsetElement()
    {
        element = null;
    }

    public void unsetElementData()
    {
        elementData = null;
    }

    public void unsetViewData()
    {
        viewData = null;
    }

    public void unsetViewParameter()
    {
        viewParameter = null;
    }

    public void unsetViewType()
    {
        viewType = null;
    }

    public void validate()
    {
        if (viewData != null)
        {
            viewData.validate();
        }
        if (componentData != null)
        {
            componentData.validate();
        }
        if (elementData != null)
        {
            elementData.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new ContextStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new ContextTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.VIEW_PARAMETER, _Fields.VIEW_DATA, _Fields.COMPONENT, _Fields.COMPONENT_DATA, _Fields.ELEMENT, _Fields.ELEMENT_DATA
        });
        obj = new EnumMap(com/pinterest/schemas/event/Context$_Fields);
        ((Map) (obj)).put(_Fields.VIEW_TYPE, new FieldMetaData("viewType", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/ViewType)));
        ((Map) (obj)).put(_Fields.VIEW_PARAMETER, new FieldMetaData("viewParameter", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/ViewParameterType)));
        ((Map) (obj)).put(_Fields.VIEW_DATA, new FieldMetaData("viewData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/ViewData)));
        ((Map) (obj)).put(_Fields.COMPONENT, new FieldMetaData("component", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/ComponentType)));
        ((Map) (obj)).put(_Fields.COMPONENT_DATA, new FieldMetaData("componentData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/ComponentData)));
        ((Map) (obj)).put(_Fields.ELEMENT, new FieldMetaData("element", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/ElementType)));
        ((Map) (obj)).put(_Fields.ELEMENT_DATA, new FieldMetaData("elementData", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/ElementData)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/Context, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields COMPONENT;
        public static final _Fields COMPONENT_DATA;
        public static final _Fields ELEMENT;
        public static final _Fields ELEMENT_DATA;
        public static final _Fields VIEW_DATA;
        public static final _Fields VIEW_PARAMETER;
        public static final _Fields VIEW_TYPE;
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
                return VIEW_TYPE;

            case 2: // '\002'
                return VIEW_PARAMETER;

            case 3: // '\003'
                return VIEW_DATA;

            case 4: // '\004'
                return COMPONENT;

            case 5: // '\005'
                return COMPONENT_DATA;

            case 6: // '\006'
                return ELEMENT;

            case 7: // '\007'
                return ELEMENT_DATA;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/Context$_Fields, s);
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
            VIEW_TYPE = new _Fields("VIEW_TYPE", 0, (short)1, "viewType");
            VIEW_PARAMETER = new _Fields("VIEW_PARAMETER", 1, (short)2, "viewParameter");
            VIEW_DATA = new _Fields("VIEW_DATA", 2, (short)3, "viewData");
            COMPONENT = new _Fields("COMPONENT", 3, (short)4, "component");
            COMPONENT_DATA = new _Fields("COMPONENT_DATA", 4, (short)5, "componentData");
            ELEMENT = new _Fields("ELEMENT", 5, (short)6, "element");
            ELEMENT_DATA = new _Fields("ELEMENT_DATA", 6, (short)7, "elementData");
            $VALUES = (new _Fields[] {
                VIEW_TYPE, VIEW_PARAMETER, VIEW_DATA, COMPONENT, COMPONENT_DATA, ELEMENT, ELEMENT_DATA
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/Context$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$Context$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$Context$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.VIEW_TYPE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.VIEW_PARAMETER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.VIEW_DATA.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.COMPONENT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.COMPONENT_DATA.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.ELEMENT.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Context$_Fields[_Fields.ELEMENT_DATA.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ContextStandardSchemeFactory
        implements SchemeFactory
    {

        public ContextStandardScheme getScheme()
        {
            return new ContextStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ContextStandardSchemeFactory()
        {
        }

        ContextStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ContextStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, Context context)
            {
                tprotocol.readStructBegin();
_L10:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_376;
                }
                tfield.id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 118
            //                           3 157
            //                           4 204
            //                           5 243
            //                           6 290
            //                           7 329;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_329;
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
                    context.viewType = ViewType.findByValue(tprotocol.readI32());
                    context.setViewTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L3:
                if (tfield.type == 8)
                {
                    context.viewParameter = ViewParameterType.findByValue(tprotocol.readI32());
                    context.setViewParameterIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L4:
                if (tfield.type == 12)
                {
                    context.viewData = new ViewData();
                    context.viewData.read(tprotocol);
                    context.setViewDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L5:
                if (tfield.type == 8)
                {
                    context.component = ComponentType.findByValue(tprotocol.readI32());
                    context.setComponentIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L6:
                if (tfield.type == 12)
                {
                    context.componentData = new ComponentData();
                    context.componentData.read(tprotocol);
                    context.setComponentDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L7:
                if (tfield.type == 8)
                {
                    context.element = ElementType.findByValue(tprotocol.readI32());
                    context.setElementIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                if (tfield.type == 12)
                {
                    context.elementData = new ElementData();
                    context.elementData.read(tprotocol);
                    context.setElementDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                context.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Context)tbase);
            }

            public void write(TProtocol tprotocol, Context context)
            {
                context.validate();
                tprotocol.writeStructBegin(Context.STRUCT_DESC);
                if (context.viewType != null)
                {
                    tprotocol.writeFieldBegin(Context.VIEW_TYPE_FIELD_DESC);
                    tprotocol.writeI32(context.viewType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (context.viewParameter != null && context.isSetViewParameter())
                {
                    tprotocol.writeFieldBegin(Context.VIEW_PARAMETER_FIELD_DESC);
                    tprotocol.writeI32(context.viewParameter.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (context.viewData != null && context.isSetViewData())
                {
                    tprotocol.writeFieldBegin(Context.VIEW_DATA_FIELD_DESC);
                    context.viewData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (context.component != null && context.isSetComponent())
                {
                    tprotocol.writeFieldBegin(Context.COMPONENT_FIELD_DESC);
                    tprotocol.writeI32(context.component.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (context.componentData != null && context.isSetComponentData())
                {
                    tprotocol.writeFieldBegin(Context.COMPONENT_DATA_FIELD_DESC);
                    context.componentData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (context.element != null && context.isSetElement())
                {
                    tprotocol.writeFieldBegin(Context.ELEMENT_FIELD_DESC);
                    tprotocol.writeI32(context.element.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (context.elementData != null && context.isSetElementData())
                {
                    tprotocol.writeFieldBegin(Context.ELEMENT_DATA_FIELD_DESC);
                    context.elementData.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Context)tbase);
            }

            private ContextStandardScheme()
            {
            }

            ContextStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class ContextTupleSchemeFactory
        implements SchemeFactory
    {

        public ContextTupleScheme getScheme()
        {
            return new ContextTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ContextTupleSchemeFactory()
        {
        }

        ContextTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ContextTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, Context context)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    context.viewType = ViewType.findByValue(tprotocol.readI32());
                    context.setViewTypeIsSet(true);
                }
                if (bitset.get(1))
                {
                    context.viewParameter = ViewParameterType.findByValue(tprotocol.readI32());
                    context.setViewParameterIsSet(true);
                }
                if (bitset.get(2))
                {
                    context.viewData = new ViewData();
                    context.viewData.read(tprotocol);
                    context.setViewDataIsSet(true);
                }
                if (bitset.get(3))
                {
                    context.component = ComponentType.findByValue(tprotocol.readI32());
                    context.setComponentIsSet(true);
                }
                if (bitset.get(4))
                {
                    context.componentData = new ComponentData();
                    context.componentData.read(tprotocol);
                    context.setComponentDataIsSet(true);
                }
                if (bitset.get(5))
                {
                    context.element = ElementType.findByValue(tprotocol.readI32());
                    context.setElementIsSet(true);
                }
                if (bitset.get(6))
                {
                    context.elementData = new ElementData();
                    context.elementData.read(tprotocol);
                    context.setElementDataIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Context)tbase);
            }

            public void write(TProtocol tprotocol, Context context)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (context.isSetViewType())
                {
                    bitset.set(0);
                }
                if (context.isSetViewParameter())
                {
                    bitset.set(1);
                }
                if (context.isSetViewData())
                {
                    bitset.set(2);
                }
                if (context.isSetComponent())
                {
                    bitset.set(3);
                }
                if (context.isSetComponentData())
                {
                    bitset.set(4);
                }
                if (context.isSetElement())
                {
                    bitset.set(5);
                }
                if (context.isSetElementData())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (context.isSetViewType())
                {
                    tprotocol.writeI32(context.viewType.getValue());
                }
                if (context.isSetViewParameter())
                {
                    tprotocol.writeI32(context.viewParameter.getValue());
                }
                if (context.isSetViewData())
                {
                    context.viewData.write(tprotocol);
                }
                if (context.isSetComponent())
                {
                    tprotocol.writeI32(context.component.getValue());
                }
                if (context.isSetComponentData())
                {
                    context.componentData.write(tprotocol);
                }
                if (context.isSetElement())
                {
                    tprotocol.writeI32(context.element.getValue());
                }
                if (context.isSetElementData())
                {
                    context.elementData.write(tprotocol);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Context)tbase);
            }

            private ContextTupleScheme()
            {
            }

            ContextTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
