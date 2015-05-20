// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.application.Resources;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Person
{

    private static final String _separator = (new StringBuilder()).append(Resources.string(0x7f0e044f)).append(" ").toString();
    private String _id;
    private String _name;
    private String _type;

    public Person(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return;
        } else
        {
            _id = pinterestjsonobject.a("id", "");
            _name = pinterestjsonobject.a("name", "");
            _type = pinterestjsonobject.a("type", "");
            return;
        }
    }

    public static String makePeopleDataDisplay(List list)
    {
        if (list == null || list.size() == 0)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < Math.min(6, list.size()); i++)
        {
            stringbuilder.append(((Person)list.get(i)).getName()).append(_separator);
        }

        return StringUtils.removeEnd(stringbuilder.toString(), _separator);
    }

    public String getId()
    {
        return _id;
    }

    public String getName()
    {
        return _name;
    }

    public String getType()
    {
        return _type;
    }

    public void setId(String s)
    {
        _id = s;
    }

    public void setName(String s)
    {
        _name = s;
    }

    public void setType(String s)
    {
        _type = s;
    }

}
