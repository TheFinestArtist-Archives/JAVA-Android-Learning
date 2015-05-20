// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import java.util.Collection;

public class CollectionUtils
{

    public CollectionUtils()
    {
    }

    public static boolean isEmpty(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection collection)
    {
        return !isEmpty(collection);
    }
}
