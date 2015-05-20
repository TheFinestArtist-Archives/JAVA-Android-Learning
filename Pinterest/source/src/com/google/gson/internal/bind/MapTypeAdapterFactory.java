// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

// Referenced classes of package com.google.gson.internal.bind:
//            TypeAdapters

public final class MapTypeAdapterFactory
    implements TypeAdapterFactory
{

    private final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(ConstructorConstructor constructorconstructor, boolean flag)
    {
        constructorConstructor = constructorconstructor;
        complexMapKeySerialization = flag;
    }

    private TypeAdapter getKeyAdapter(Gson gson, Type type)
    {
        if (type == Boolean.TYPE || type == java/lang/Boolean)
        {
            return TypeAdapters.BOOLEAN_AS_STRING;
        } else
        {
            return gson.getAdapter(TypeToken.get(type));
        }
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Type type = typetoken.getType();
        if (!java/util/Map.isAssignableFrom(typetoken.getRawType()))
        {
            return null;
        } else
        {
            Type atype[] = com.google.gson.internal..Gson.Types.getMapKeyAndValueTypes(type, com.google.gson.internal..Gson.Types.getRawType(type));
            TypeAdapter typeadapter = getKeyAdapter(gson, atype[0]);
            TypeAdapter typeadapter1 = gson.getAdapter(TypeToken.get(atype[1]));
            typetoken = constructorConstructor.get(typetoken);
            return new Adapter(gson, atype[0], typeadapter, atype[1], typeadapter1, typetoken);
        }
    }


    private class Adapter extends TypeAdapter
    {

        private final ObjectConstructor constructor;
        private final TypeAdapter keyTypeAdapter;
        final MapTypeAdapterFactory this$0;
        private final TypeAdapter valueTypeAdapter;

        private String keyToString(JsonElement jsonelement)
        {
            if (jsonelement.isJsonPrimitive())
            {
                jsonelement = jsonelement.getAsJsonPrimitive();
                if (jsonelement.isNumber())
                {
                    return String.valueOf(jsonelement.getAsNumber());
                }
                if (jsonelement.isBoolean())
                {
                    return Boolean.toString(jsonelement.getAsBoolean());
                }
                if (jsonelement.isString())
                {
                    return jsonelement.getAsString();
                } else
                {
                    throw new AssertionError();
                }
            }
            if (jsonelement.isJsonNull())
            {
                return "null";
            } else
            {
                throw new AssertionError();
            }
        }

        public final volatile Object read(JsonReader jsonreader)
        {
            return read(jsonreader);
        }

        public final Map read(JsonReader jsonreader)
        {
            JsonToken jsontoken = jsonreader.peek();
            if (jsontoken == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            Map map = (Map)constructor.construct();
            if (jsontoken == JsonToken.BEGIN_ARRAY)
            {
                jsonreader.beginArray();
                for (; jsonreader.hasNext(); jsonreader.endArray())
                {
                    jsonreader.beginArray();
                    Object obj = keyTypeAdapter.read(jsonreader);
                    if (map.put(obj, valueTypeAdapter.read(jsonreader)) != null)
                    {
                        throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj).toString());
                    }
                }

                jsonreader.endArray();
                return map;
            }
            jsonreader.beginObject();
            while (jsonreader.hasNext()) 
            {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonreader);
                Object obj1 = keyTypeAdapter.read(jsonreader);
                if (map.put(obj1, valueTypeAdapter.read(jsonreader)) != null)
                {
                    throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj1).toString());
                }
            }
            jsonreader.endObject();
            return map;
        }

        public final volatile void write(JsonWriter jsonwriter, Object obj)
        {
            write(jsonwriter, (Map)obj);
        }

        public final void write(JsonWriter jsonwriter, Map map)
        {
            boolean flag3 = false;
            boolean flag2 = false;
            if (map == null)
            {
                jsonwriter.nullValue();
                return;
            }
            if (!complexMapKeySerialization)
            {
                jsonwriter.beginObject();
                java.util.Map.Entry entry;
                for (map = map.entrySet().iterator(); map.hasNext(); valueTypeAdapter.write(jsonwriter, entry.getValue()))
                {
                    entry = (java.util.Map.Entry)map.next();
                    jsonwriter.name(String.valueOf(entry.getKey()));
                }

                jsonwriter.endObject();
                return;
            }
            ArrayList arraylist = new ArrayList(map.size());
            ArrayList arraylist1 = new ArrayList(map.size());
            map = map.entrySet().iterator();
            boolean flag = false;
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)map.next();
                JsonElement jsonelement = keyTypeAdapter.toJsonTree(entry1.getKey());
                arraylist.add(jsonelement);
                arraylist1.add(entry1.getValue());
                boolean flag1;
                if (jsonelement.isJsonArray() || jsonelement.isJsonObject())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag1 | flag;
            }
            if (flag)
            {
                jsonwriter.beginArray();
                for (int i = ((flag2) ? 1 : 0); i < arraylist.size(); i++)
                {
                    jsonwriter.beginArray();
                    Streams.write((JsonElement)arraylist.get(i), jsonwriter);
                    valueTypeAdapter.write(jsonwriter, arraylist1.get(i));
                    jsonwriter.endArray();
                }

                jsonwriter.endArray();
                return;
            }
            jsonwriter.beginObject();
            for (int j = ((flag3) ? 1 : 0); j < arraylist.size(); j++)
            {
                jsonwriter.name(keyToString((JsonElement)arraylist.get(j)));
                valueTypeAdapter.write(jsonwriter, arraylist1.get(j));
            }

            jsonwriter.endObject();
        }

        public Adapter(Gson gson, Type type, TypeAdapter typeadapter, Type type1, TypeAdapter typeadapter1, ObjectConstructor objectconstructor)
        {
            this$0 = MapTypeAdapterFactory.this;
            super();
            keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeadapter, type);
            valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeadapter1, type1);
            constructor = objectconstructor;
        }
    }

}
