// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata.movie;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.metadata.Person;
import java.util.ArrayList;
import java.util.List;

public class Writer extends Person
{

    public Writer(PinterestJsonObject pinterestjsonobject)
    {
        super(pinterestjsonobject);
    }

    public static List getWriters(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (pinterestjsonarray != null)
        {
            int i = 0;
            int j = pinterestjsonarray.a();
            while (i < j) 
            {
                arraylist.add(new Writer(pinterestjsonarray.b(i)));
                i++;
            }
        }
        return arraylist;
    }
}
