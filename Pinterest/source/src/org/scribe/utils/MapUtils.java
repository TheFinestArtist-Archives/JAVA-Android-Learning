// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtils
{

    private MapUtils()
    {
    }

    public static String toString(Map map)
    {
        if (map == null)
        {
            return "";
        }
        if (map.isEmpty())
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append(String.format(", %s -> %s ", new Object[] {
    entry.getKey().toString(), entry.getValue().toString()
})))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return (new StringBuilder("{")).append(stringbuilder.substring(1)).append("}").toString();
    }
}
