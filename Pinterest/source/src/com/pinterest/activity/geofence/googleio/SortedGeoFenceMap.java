// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.google.android.gms.location.Geofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortedGeoFenceMap extends TreeMap
{

    private static final int MAX_GEOFENCES = 90;

    public SortedGeoFenceMap()
    {
    }

    public List getValuesAsList()
    {
        java.util.Collection collection = values();
        if (!(collection instanceof List))
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(collection);
            return arraylist;
        } else
        {
            return (List)collection;
        }
    }

    public Geofence put(Float float1, Geofence geofence)
    {
        float1 = (Geofence)super.put(float1, geofence);
        if (size() > 90)
        {
            remove(lastKey());
        }
        return float1;
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((Float)obj, (Geofence)obj1);
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put((Float)entry.getKey(), (Geofence)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }
}
