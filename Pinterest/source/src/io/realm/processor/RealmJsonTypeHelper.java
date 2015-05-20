// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import com.squareup.javawriter.JavaWriter;
import java.util.HashMap;
import java.util.Map;

public class RealmJsonTypeHelper
{

    private static final Map JAVA_TO_JSON_TYPES;

    public RealmJsonTypeHelper()
    {
    }

    public static void emitFillJavaTypeFromStream(String s, String s1, String s2, JavaWriter javawriter)
    {
        if (JAVA_TO_JSON_TYPES.containsKey(s2))
        {
            ((JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2)).emitStreamTypeConversion(s, s1, s2, javawriter);
        }
    }

    public static void emitFillJavaTypeWithJsonValue(String s, String s1, String s2, JavaWriter javawriter)
    {
        JsonToRealmTypeConverter jsontorealmtypeconverter = (JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2);
        if (jsontorealmtypeconverter != null)
        {
            jsontorealmtypeconverter.emitTypeConversion(s, s1, s2, javawriter);
        }
    }

    public static void emitFillRealmListFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
    {
        javawriter.a("reader.beginArray()", new Object[0]).b("if (standalone)", new Object[0]).a("obj.%s(new RealmList<%s>())", new Object[] {
            s1, s2
        }).c().b("while (reader.hasNext())", new Object[0]).a("%s item = standalone ? new %s() : obj.realm.createObject(%s.class)", new Object[] {
            s2, s2, s2
        }).a("%s.populateUsingJsonStream(item, reader)", new Object[] {
            s3
        }).a("obj.%s().add(item)", new Object[] {
            s
        }).c().a("reader.endArray()", new Object[0]);
    }

    public static void emitFillRealmListWithJsonValue(String s, String s1, String s2, String s3, String s4, JavaWriter javawriter)
    {
        javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
            s2
        }).b("if (standalone)", new Object[0]).a("obj.%s(new RealmList<%s>())", new Object[] {
            s1, s3
        }).c().a("JSONArray array = json.getJSONArray(\"%s\")", new Object[] {
            s2
        }).b("for (int i = 0; i < array.length(); i++)", new Object[0]).a("%s item = standalone ? new %s() : obj.realm.createObject(%s.class)", new Object[] {
            s3, s3, s3
        }).a("%s.populateUsingJsonObject(item, array.getJSONObject(i))", new Object[] {
            s4
        }).a("obj.%s().add(item)", new Object[] {
            s
        }).c().c();
    }

    public static void emitFillRealmObjectFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
    {
        javawriter.a("%s %sObj = standalone ? new %s() : obj.realm.createObject(%s.class)", new Object[] {
            s2, s1, s2, s2
        }).a("%s.populateUsingJsonStream(%sObj, reader)", new Object[] {
            s3, s1
        }).a("obj.%s(%sObj)", new Object[] {
            s, s1
        });
    }

    public static void emitFillRealmObjectWithJsonValue(String s, String s1, String s2, String s3, JavaWriter javawriter)
    {
        javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).a("%s %s = standalone ? new %s() : obj.realm.createObject(%s.class)", new Object[] {
            s2, s1, s2, s2
        }).a("%s.populateUsingJsonObject(%s, json.getJSONObject(\"%s\"))", new Object[] {
            s3, s1, s1
        }).a("obj.%s(%s)", new Object[] {
            s, s1
        }).c();
    }

    static 
    {
        HashMap hashmap = new HashMap();
        JAVA_TO_JSON_TYPES = hashmap;
        hashmap.put("byte", new SimpleTypeConverter("byte", "Int", null));
        JAVA_TO_JSON_TYPES.put("short", new SimpleTypeConverter("short", "Int", null));
        JAVA_TO_JSON_TYPES.put("int", new SimpleTypeConverter("int", "Int", null));
        JAVA_TO_JSON_TYPES.put("long", new SimpleTypeConverter("long", "Long", null));
        JAVA_TO_JSON_TYPES.put("float", new SimpleTypeConverter("float", "Double", null));
        JAVA_TO_JSON_TYPES.put("double", new SimpleTypeConverter("double", "Double", null));
        JAVA_TO_JSON_TYPES.put("boolean", new SimpleTypeConverter("boolean", "Boolean", null));
        JAVA_TO_JSON_TYPES.put("Byte", new SimpleTypeConverter("Byte", "Int", null));
        JAVA_TO_JSON_TYPES.put("Short", new SimpleTypeConverter("Short", "Int", null));
        JAVA_TO_JSON_TYPES.put("Integer", new SimpleTypeConverter("Integer", "Int", null));
        JAVA_TO_JSON_TYPES.put("Long", new SimpleTypeConverter("Long", "Long", null));
        JAVA_TO_JSON_TYPES.put("Float", new SimpleTypeConverter("Float", "Double", null));
        JAVA_TO_JSON_TYPES.put("Double", new SimpleTypeConverter("Double", "Double", null));
        JAVA_TO_JSON_TYPES.put("Boolean", new SimpleTypeConverter("Boolean", "Boolean", null));
        JAVA_TO_JSON_TYPES.put("java.lang.String", new SimpleTypeConverter("String", "String", null));
        JAVA_TO_JSON_TYPES.put("java.util.Date", new _cls1());
        JAVA_TO_JSON_TYPES.put("byte[]", new _cls2());
    }

    private class JsonToRealmTypeConverter
    {

        public abstract void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter);

        public abstract void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter);
    }


    private class SimpleTypeConverter
        implements JsonToRealmTypeConverter
    {

        private final String castType;
        private final String jsonType;

        public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.a("obj.%s((%s) reader.next%s())", new Object[] {
                s, castType, jsonType
            });
        }

        public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
                s1
            }).a("obj.%s((%s) json.get%s(\"%s\"))", new Object[] {
                s, castType, jsonType, s1
            }).c();
        }

        private SimpleTypeConverter(String s, String s1)
        {
            castType = s;
            jsonType = s1;
        }

        SimpleTypeConverter(String s, String s1, _cls1 _pcls1)
        {
            this(s, s1);
        }
    }


    private class _cls1
        implements JsonToRealmTypeConverter
    {

        public final void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.b("if (reader.peek() == JsonToken.NUMBER)", new Object[0]).a("long timestamp = reader.nextLong()", new Object[] {
                s1
            }).b("if (timestamp > -1)", new Object[0]).a("obj.%s(new Date(timestamp))", new Object[] {
                s
            }).c().c("else", new Object[0]).a("obj.%s(JsonUtils.stringToDate(reader.nextString()))", new Object[] {
                s
            }).c();
        }

        public final void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.b("if (!json.isNull(\"%s\"))", new Object[] {
                s1
            }).a("Object timestamp = json.get(\"%s\")", new Object[] {
                s1
            }).b("if (timestamp instanceof String)", new Object[0]).a("obj.%s(JsonUtils.stringToDate((String) timestamp))", new Object[] {
                s
            }).c("else", new Object[0]).a("obj.%s(new Date(json.getLong(\"%s\")))", new Object[] {
                s, s1
            }).c().c("else", new Object[0]).a("obj.%s(new Date(0))", new Object[] {
                s
            }).c();
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements JsonToRealmTypeConverter
    {

        public final void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.a("obj.%s(JsonUtils.stringToBytes(reader.nextString()))", new Object[] {
                s
            });
        }

        public final void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
        {
            javawriter.a("obj.%s(JsonUtils.stringToBytes(json.isNull(\"%s\") ? null : json.getString(\"%s\")))", new Object[] {
                s, s1, s1
            });
        }

        _cls2()
        {
        }
    }

}
