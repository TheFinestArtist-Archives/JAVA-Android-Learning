// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.apache.thrift:
//            TBaseHelper

class <init>
    implements Comparator
{

    public int compare(Object obj, Object obj1)
    {
        if (obj == null && obj1 == null)
        {
            return 0;
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (obj instanceof List)
        {
            return TBaseHelper.compareTo((List)obj, (List)obj1);
        }
        if (obj instanceof Set)
        {
            return TBaseHelper.compareTo((Set)obj, (Set)obj1);
        }
        if (obj instanceof Map)
        {
            return TBaseHelper.compareTo((Map)obj, (Map)obj1);
        }
        if (obj instanceof byte[])
        {
            return TBaseHelper.compareTo((byte[])obj, (byte[])obj1);
        } else
        {
            return TBaseHelper.compareTo((Comparable)obj, (Comparable)obj1);
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
