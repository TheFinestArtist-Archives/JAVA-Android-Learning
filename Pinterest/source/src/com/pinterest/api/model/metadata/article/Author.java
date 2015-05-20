// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata.article;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.metadata.Person;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person
{

    public Author(PinterestJsonObject pinterestjsonobject)
    {
        super(pinterestjsonobject);
    }

    public static List getAuthors(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (pinterestjsonarray != null)
        {
            int i = 0;
            int j = pinterestjsonarray.a();
            while (i < j) 
            {
                arraylist.add(new Author(pinterestjsonarray.b(i)));
                i++;
            }
        }
        return arraylist;
    }
}
