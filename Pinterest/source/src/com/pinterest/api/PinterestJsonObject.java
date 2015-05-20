// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pinterest.api:
//            PinterestJsonArray

public class PinterestJsonObject
{

    private static Gson b = new Gson();
    public JsonObject a;

    public PinterestJsonObject()
    {
        a = new JsonObject();
    }

    public PinterestJsonObject(JsonObject jsonobject)
    {
        a = jsonobject;
    }

    public PinterestJsonObject(String s)
    {
        a = (new JsonParser()).parse(s).getAsJsonObject();
    }

    public PinterestJsonObject(Map map)
    {
        a = (JsonObject)b.toJsonTree(map);
    }

    public static Object a(Object obj)
    {
        if (!(obj instanceof JsonElement))
        {
            return null;
        }
        JsonElement jsonelement = (JsonElement)obj;
        if (jsonelement.isJsonArray())
        {
            obj = new PinterestJsonArray(jsonelement.getAsJsonArray());
        } else
        if (jsonelement.isJsonObject())
        {
            obj = new PinterestJsonObject(jsonelement.getAsJsonObject());
        } else
        if (obj instanceof JsonPrimitive)
        {
            obj = jsonelement.getAsString();
        } else
        {
            obj = null;
        }
        return obj;
    }

    private double g(String s)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonPrimitive())
        {
            return (0.0D / 0.0D);
        }
        double d1;
        try
        {
            d1 = a.get(s).getAsDouble();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return (0.0D / 0.0D);
        }
        return d1;
    }

    public final int a(String s, int i)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonPrimitive())
        {
            return i;
        }
        int j;
        try
        {
            j = a.get(s).getAsInt();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public final long a(String s, long l)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonPrimitive())
        {
            return l;
        }
        long l1;
        try
        {
            l1 = a.get(s).getAsLong();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }

    public final Boolean a(String s)
    {
        return a(s, Boolean.valueOf(false));
    }

    public final Boolean a(String s, Boolean boolean1)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonPrimitive())
        {
            return boolean1;
        }
        boolean flag;
        try
        {
            flag = a.get(s).getAsBoolean();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return boolean1;
        }
        return Boolean.valueOf(flag);
    }

    public final String a(String s, String s1)
    {
        if (a == null || a.get(s) == null)
        {
            return s1;
        }
        try
        {
            s = a.get(s).getAsString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        return s;
    }

    public final HashMap a()
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); hashmap.put((String)entry.getKey(), new PinterestJsonObject(((JsonElement)entry.getValue()).getAsJsonObject())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return hashmap;
    }

    public final void a(String s, PinterestJsonArray pinterestjsonarray)
    {
        a.add(s, pinterestjsonarray.a);
    }

    public final void a(String s, PinterestJsonObject pinterestjsonobject)
    {
        a.add(s, pinterestjsonobject.a);
    }

    public final double b(String s)
    {
        return g(s);
    }

    public final int b()
    {
        return a.entrySet().size();
    }

    public final void b(String s, String s1)
    {
        a.addProperty(s, s1);
    }

    public final PinterestJsonObject c(String s)
    {
        if (a != null)
        {
            s = a.get(s);
            if (s != null && s.isJsonObject())
            {
                return new PinterestJsonObject((JsonObject)s);
            }
        }
        return null;
    }

    public final Set c()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); hashset.add(((java.util.Map.Entry)iterator.next()).getKey())) { }
        return hashset;
    }

    public final PinterestJsonArray d(String s)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonArray())
        {
            return null;
        } else
        {
            return new PinterestJsonArray(a.getAsJsonArray(s));
        }
    }

    public final PinterestJsonArray e(String s)
    {
        if (a == null || a.get(s) == null || !a.get(s).isJsonArray())
        {
            return new PinterestJsonArray();
        } else
        {
            return new PinterestJsonArray(a.getAsJsonArray(s));
        }
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof PinterestJsonObject) && ((PinterestJsonObject)obj).a.equals(a);
    }

    public final boolean f(String s)
    {
        return a.has(s);
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public String toString()
    {
        return a.toString();
    }

}
