// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

// Referenced classes of package org.apache.thrift:
//            TBase, TBaseHelper, TFieldIdEnum

public abstract class TUnion
    implements TBase
{

    private static final Map schemes;
    protected TFieldIdEnum setField_;
    protected Object value_;

    protected TUnion()
    {
        setField_ = null;
        value_ = null;
    }

    protected TUnion(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue(tfieldidenum, obj);
    }

    protected TUnion(TUnion tunion)
    {
        if (!tunion.getClass().equals(getClass()))
        {
            throw new ClassCastException();
        } else
        {
            setField_ = tunion.setField_;
            value_ = deepCopyObject(tunion.value_);
            return;
        }
    }

    private static List deepCopyList(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(deepCopyObject(list.next()))) { }
        return arraylist;
    }

    private static Map deepCopyMap(Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(deepCopyObject(entry.getKey()), deepCopyObject(entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    private static Object deepCopyObject(Object obj)
    {
        Object obj1;
        if (obj instanceof TBase)
        {
            obj1 = ((TBase)obj).deepCopy();
        } else
        {
            if (obj instanceof ByteBuffer)
            {
                return TBaseHelper.copyBinary((ByteBuffer)obj);
            }
            if (obj instanceof List)
            {
                return deepCopyList((List)obj);
            }
            if (obj instanceof Set)
            {
                return deepCopySet((Set)obj);
            }
            obj1 = obj;
            if (obj instanceof Map)
            {
                return deepCopyMap((Map)obj);
            }
        }
        return obj1;
    }

    private static Set deepCopySet(Set set)
    {
        HashSet hashset = new HashSet();
        for (set = set.iterator(); set.hasNext(); hashset.add(deepCopyObject(set.next()))) { }
        return hashset;
    }

    protected abstract void checkType(TFieldIdEnum tfieldidenum, Object obj);

    public final void clear()
    {
        setField_ = null;
        value_ = null;
    }

    protected abstract TFieldIdEnum enumForId(short word0);

    protected abstract TField getFieldDesc(TFieldIdEnum tfieldidenum);

    public Object getFieldValue()
    {
        return value_;
    }

    public Object getFieldValue(int i)
    {
        return getFieldValue(enumForId((short)i));
    }

    public Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        if (tfieldidenum != setField_)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot get the value of field ")).append(tfieldidenum).append(" because union's set field is ").append(setField_).toString());
        } else
        {
            return getFieldValue();
        }
    }

    public TFieldIdEnum getSetField()
    {
        return setField_;
    }

    protected abstract TStruct getStructDesc();

    public boolean isSet()
    {
        return setField_ != null;
    }

    public boolean isSet(int i)
    {
        return isSet(enumForId((short)i));
    }

    public boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return setField_ == tfieldidenum;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(int i, Object obj)
    {
        setFieldValue(enumForId((short)i), obj);
    }

    public void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        checkType(tfieldidenum, obj);
        setField_ = tfieldidenum;
        value_ = obj;
    }

    protected abstract Object standardSchemeReadValue(TProtocol tprotocol, TField tfield);

    protected abstract void standardSchemeWriteValue(TProtocol tprotocol);

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<");
        stringbuilder.append(getClass().getSimpleName());
        stringbuilder.append(" ");
        if (getSetField() != null)
        {
            Object obj = getFieldValue();
            stringbuilder.append(getFieldDesc(getSetField()).name);
            stringbuilder.append(":");
            if (obj instanceof ByteBuffer)
            {
                TBaseHelper.toString((ByteBuffer)obj, stringbuilder);
            } else
            {
                stringbuilder.append(obj.toString());
            }
        }
        stringbuilder.append(">");
        return stringbuilder.toString();
    }

    protected abstract Object tupleSchemeReadValue(TProtocol tprotocol, short word0);

    protected abstract void tupleSchemeWriteValue(TProtocol tprotocol);

    public void write(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().write(tprotocol, this);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        schemes = hashmap;
        hashmap.put(org/apache/thrift/scheme/StandardScheme, new TUnionStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new TUnionTupleSchemeFactory(null));
    }

    private class TUnionStandardSchemeFactory
        implements SchemeFactory
    {

        public TUnionStandardScheme getScheme()
        {
            return new TUnionStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TUnionStandardSchemeFactory()
        {
        }

        TUnionStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TUnionStandardScheme extends StandardScheme
        {

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TUnion)tbase);
            }

            public void read(TProtocol tprotocol, TUnion tunion)
            {
                tunion.setField_ = null;
                tunion.value_ = null;
                tprotocol.readStructBegin();
                TField tfield = tprotocol.readFieldBegin();
                tunion.value_ = tunion.standardSchemeReadValue(tprotocol, tfield);
                if (tunion.value_ != null)
                {
                    tunion.setField_ = tunion.enumForId(tfield.id);
                }
                tprotocol.readFieldEnd();
                tprotocol.readFieldBegin();
                tprotocol.readStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TUnion)tbase);
            }

            public void write(TProtocol tprotocol, TUnion tunion)
            {
                if (tunion.getSetField() == null || tunion.getFieldValue() == null)
                {
                    throw new TProtocolException("Cannot write a TUnion with no set value!");
                } else
                {
                    tprotocol.writeStructBegin(tunion.getStructDesc());
                    tprotocol.writeFieldBegin(tunion.getFieldDesc(tunion.setField_));
                    tunion.standardSchemeWriteValue(tprotocol);
                    tprotocol.writeFieldEnd();
                    tprotocol.writeFieldStop();
                    tprotocol.writeStructEnd();
                    return;
                }
            }

            private TUnionStandardScheme()
            {
            }

            TUnionStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class TUnionTupleSchemeFactory
        implements SchemeFactory
    {

        public TUnionTupleScheme getScheme()
        {
            return new TUnionTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TUnionTupleSchemeFactory()
        {
        }

        TUnionTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TUnionTupleScheme extends TupleScheme
        {

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TUnion)tbase);
            }

            public void read(TProtocol tprotocol, TUnion tunion)
            {
                tunion.setField_ = null;
                tunion.value_ = null;
                short word0 = tprotocol.readI16();
                tunion.value_ = tunion.tupleSchemeReadValue(tprotocol, word0);
                if (tunion.value_ != null)
                {
                    tunion.setField_ = tunion.enumForId(word0);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TUnion)tbase);
            }

            public void write(TProtocol tprotocol, TUnion tunion)
            {
                if (tunion.getSetField() == null || tunion.getFieldValue() == null)
                {
                    throw new TProtocolException("Cannot write a TUnion with no set value!");
                } else
                {
                    tprotocol.writeI16(tunion.setField_.getThriftFieldId());
                    tunion.tupleSchemeWriteValue(tprotocol);
                    return;
                }
            }

            private TUnionTupleScheme()
            {
            }

            TUnionTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
