// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class FilterOption extends Model
{

    private Integer count;
    private String displayCount;
    private String displayName;
    private String dominantColor;
    private Long id;
    private String largeIconUrl;
    private String smallIconUrl;
    private String typeValue;

    public FilterOption()
    {
    }

    public FilterOption(Long long1)
    {
        id = long1;
    }

    public FilterOption(Long long1, Integer integer, String s, String s1, String s2, String s3, String s4, 
            String s5)
    {
        id = long1;
        count = integer;
        typeValue = s;
        displayCount = s1;
        displayName = s2;
        largeIconUrl = s3;
        smallIconUrl = s4;
        dominantColor = s5;
    }

    public static FilterOption make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true);
    }

    public static FilterOption make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        if (pinterestjsonobject == null)
        {
            pinterestjsonobject = null;
        } else
        {
            FilterOption filteroption = new FilterOption();
            filteroption.setCount(Integer.valueOf(pinterestjsonobject.a("count", 0)));
            filteroption.setDisplayCount(pinterestjsonobject.a("display_count", ""));
            filteroption.setTypeValue(pinterestjsonobject.a("type_value", ""));
            filteroption.setDisplayName(pinterestjsonobject.a("display_name", ""));
            filteroption.setSmallIconUrl(pinterestjsonobject.a("small_icon_url", ""));
            filteroption.setLargeIconUrl(pinterestjsonobject.a("large_icon_url", ""));
            filteroption.setDominantColor(pinterestjsonobject.a("color_hex", ""));
            pinterestjsonobject = filteroption;
            if (flag)
            {
                ModelHelper.setFilterOption(filteroption);
                return filteroption;
            }
        }
        return pinterestjsonobject;
    }

    public static ArrayList makeAll(PinterestJsonArray pinterestjsonarray)
    {
        if (pinterestjsonarray == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            arraylist.add(make(pinterestjsonarray.c(i), false));
        }

        ModelHelper.setFilterOptions(arraylist);
        return arraylist;
    }

    public Integer getCount()
    {
        return count;
    }

    public String getDisplayCount()
    {
        return displayCount;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getDominantColor()
    {
        return dominantColor;
    }

    public String getDominantColorWithDefault()
    {
        if (StringUtils.isNotEmpty(dominantColor))
        {
            return dominantColor;
        } else
        {
            return "#32CD32";
        }
    }

    public Long getId()
    {
        return id;
    }

    public String getLargeIconUrl()
    {
        return largeIconUrl;
    }

    public String getSmallIconUrl()
    {
        return smallIconUrl;
    }

    public String getTypeValue()
    {
        return typeValue;
    }

    public String getUid()
    {
        return null;
    }

    public void setCount(Integer integer)
    {
        count = integer;
    }

    public void setDisplayCount(String s)
    {
        displayCount = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setDominantColor(String s)
    {
        dominantColor = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setLargeIconUrl(String s)
    {
        largeIconUrl = s;
    }

    public void setSmallIconUrl(String s)
    {
        smallIconUrl = s;
    }

    public void setTypeValue(String s)
    {
        typeValue = s;
    }
}
