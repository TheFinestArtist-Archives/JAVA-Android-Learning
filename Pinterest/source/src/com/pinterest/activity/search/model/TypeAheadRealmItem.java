// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.model;

import io.realm.RealmObject;

public class TypeAheadRealmItem extends RealmObject
{

    private String query;
    private float score;

    public TypeAheadRealmItem()
    {
    }

    public String getQuery()
    {
        return query;
    }

    public float getScore()
    {
        return score;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setScore(float f)
    {
        score = f;
    }
}
