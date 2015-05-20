// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yozio.android.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Json
{

    public Json()
    {
    }

    private static Object fromJson(Object obj)
    {
        Object obj1;
        if (obj == JSONObject.NULL)
        {
            obj1 = null;
        } else
        {
            if (obj instanceof JSONObject)
            {
                return toMap((JSONObject)obj);
            }
            obj1 = obj;
            if (obj instanceof JSONArray)
            {
                return toList((JSONArray)obj);
            }
        }
        return obj1;
    }

    public static Map getMap(JSONObject jsonobject, String s)
    {
        return toMap(jsonobject.getJSONObject(s));
    }

    public static boolean isEmptyObject(JSONObject jsonobject)
    {
        return jsonobject.names() == null;
    }

    public static Object toJSON(Object obj)
    {
        if (!(obj instanceof Map)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Iterator iterator;
        obj1 = new JSONObject();
        obj = (Map)obj;
        iterator = ((Map) (obj)).keySet().iterator();
_L7:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        return obj1;
_L4:
        Object obj2 = iterator.next();
        ((JSONObject) (obj1)).put(obj2.toString(), toJSON(((Map) (obj)).get(obj2)));
        continue; /* Loop/switch isn't completed */
_L2:
        obj1 = obj;
        if (!(obj instanceof Iterable)) goto _L3; else goto _L5
_L5:
        JSONArray jsonarray = new JSONArray();
        obj = ((Iterable)obj).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                return jsonarray;
            }
            jsonarray.put(((Iterator) (obj)).next());
        } while (true);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static List toList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            if (i >= jsonarray.length())
            {
                return arraylist;
            }
            arraylist.add(fromJson(jsonarray.get(i)));
            i++;
        } while (true);
    }

    public static Map toMap(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                return hashmap;
            }
            String s = (String)iterator.next();
            hashmap.put(s, fromJson(jsonobject.get(s)));
        } while (true);
    }
}
