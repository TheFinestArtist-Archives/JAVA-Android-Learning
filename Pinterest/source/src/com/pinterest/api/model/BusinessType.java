// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Model

public class BusinessType extends Model
{

    private String help;
    private String helpClean;
    private Long id;
    private String key;
    private String name;
    private String uid;

    public BusinessType()
    {
    }

    public BusinessType(Long long1)
    {
        id = long1;
    }

    public BusinessType(Long long1, String s, String s1, String s2, String s3)
    {
        id = long1;
        uid = s;
        key = s1;
        name = s2;
        help = s3;
    }

    public static BusinessType make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        BusinessType businesstype = new BusinessType();
        if (pinterestjsonobject == null)
        {
            return businesstype;
        } else
        {
            businesstype.setKey(pinterestjsonobject.a("key", ""));
            businesstype.setName(pinterestjsonobject.a("name", ""));
            businesstype.setHelp(pinterestjsonobject.a("help", ""));
            return businesstype;
        }
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        return makeAll(pinterestjsonarray, false);
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (pinterestjsonarray != null)
        {
            int j = pinterestjsonarray.a();
            for (int i = 0; i < j; i++)
            {
                arraylist.add(make(pinterestjsonarray.c(i), false));
            }

        }
        return arraylist;
    }

    public String getHelp()
    {
        return help;
    }

    public String getHelpClean()
    {
        if (helpClean == null)
        {
            String s;
            if (help == null)
            {
                s = "";
            } else
            {
                s = help.replaceAll("\\(", "").replaceAll("\\)", "");
            }
            helpClean = s;
        }
        return helpClean;
    }

    public Long getId()
    {
        return id;
    }

    public String getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public String getUid()
    {
        return uid;
    }

    public void setHelp(String s)
    {
        help = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }
}
