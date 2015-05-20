// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package org.apache.thrift.meta_data:
//            FieldValueMetaData

public class FieldMetaData
    implements Serializable
{

    private static Map structMap = new HashMap();
    public final String fieldName;
    public final byte requirementType;
    public final FieldValueMetaData valueMetaData;

    public FieldMetaData(String s, byte byte0, FieldValueMetaData fieldvaluemetadata)
    {
        fieldName = s;
        requirementType = byte0;
        valueMetaData = fieldvaluemetadata;
    }

    public static void addStructMetaDataMap(Class class1, Map map)
    {
        structMap.put(class1, map);
    }

    public static Map getStructMetaDataMap(Class class1)
    {
        if (!structMap.containsKey(class1))
        {
            try
            {
                class1.newInstance();
            }
            catch (InstantiationException instantiationexception)
            {
                throw new RuntimeException((new StringBuilder("InstantiationException for TBase class: ")).append(class1.getName()).append(", message: ").append(instantiationexception.getMessage()).toString());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new RuntimeException((new StringBuilder("IllegalAccessException for TBase class: ")).append(class1.getName()).append(", message: ").append(illegalaccessexception.getMessage()).toString());
            }
        }
        return (Map)structMap.get(class1);
    }

}
