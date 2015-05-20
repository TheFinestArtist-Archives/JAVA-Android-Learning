// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.api.model:
//            Model, FilterOption, ModelHelper

public class SearchFilter extends Model
{

    private int _selectedOption;
    private String displayImageUrl;
    private String displayName;
    private Long id;
    private String mainOptionsTitle;
    private ArrayList options;
    private ArrayList topOptions;
    private String topOptionsTitle;
    private String type;
    private String typeValue;

    public SearchFilter()
    {
        _selectedOption = 0;
    }

    public SearchFilter(Long long1)
    {
        _selectedOption = 0;
        id = long1;
    }

    public SearchFilter(Long long1, String s, String s1, String s2, String s3, String s4, String s5)
    {
        _selectedOption = 0;
        id = long1;
        type = s;
        displayName = s1;
        typeValue = s2;
        mainOptionsTitle = s3;
        topOptionsTitle = s4;
        displayImageUrl = s5;
    }

    public static SearchFilter make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true);
    }

    public static SearchFilter make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        if (pinterestjsonobject == null)
        {
            pinterestjsonobject = null;
        } else
        {
            SearchFilter searchfilter = new SearchFilter();
            searchfilter.setType(pinterestjsonobject.a("type", ""));
            searchfilter.setDisplayName(pinterestjsonobject.a("display_name", ""));
            searchfilter.setTypeValue(pinterestjsonobject.a("type_value", ""));
            searchfilter.setMainOptionsTitle(pinterestjsonobject.a("main_options_title", ""));
            searchfilter.setTopOptionsTitle(pinterestjsonobject.a("top_options_title", ""));
            PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("display_image");
            if (pinterestjsonobject1 != null)
            {
                searchfilter.setDisplayImageUrl(pinterestjsonobject1.a("android_phone_blurred_url", ""));
            }
            searchfilter.options = FilterOption.makeAll(pinterestjsonobject.e("options"));
            searchfilter.topOptions = FilterOption.makeAll(pinterestjsonobject.e("top_options"));
            pinterestjsonobject = searchfilter;
            if (flag)
            {
                ModelHelper.setSearchFilter(searchfilter);
                return searchfilter;
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

        ModelHelper.setSearchFilters(arraylist);
        return arraylist;
    }

    public String getDisplayImageUrl()
    {
        return displayImageUrl;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getDominantColorWithDefault()
    {
        return "#bd081c";
    }

    public ArrayList getFilterOptions()
    {
        return options;
    }

    public Long getId()
    {
        return id;
    }

    public String getMainOptionsTitle()
    {
        return mainOptionsTitle;
    }

    public ArrayList getTopFilterOptions()
    {
        return topOptions;
    }

    public String getTopOptionsTitle()
    {
        return topOptionsTitle;
    }

    public String getType()
    {
        return type;
    }

    public String getTypeValue()
    {
        return typeValue;
    }

    public String getTypeValueOrOption()
    {
        if (typeValue != null)
        {
            return typeValue;
        }
        if (options.size() > _selectedOption)
        {
            return ((FilterOption)options.get(_selectedOption)).getTypeValue();
        } else
        {
            return "";
        }
    }

    public String getUid()
    {
        return null;
    }

    public void setDisplayImageUrl(String s)
    {
        displayImageUrl = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setMainOptionsTitle(String s)
    {
        mainOptionsTitle = s;
    }

    public void setTopOptionsTitle(String s)
    {
        topOptionsTitle = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setTypeValue(String s)
    {
        typeValue = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(getDisplayName());
        stringbuilder.append((new StringBuilder(" type:")).append(getType()).toString());
        if (options != null)
        {
            stringbuilder.append((new StringBuilder(" options:")).append(options.size()).toString());
        }
        if (topOptions != null)
        {
            stringbuilder.append((new StringBuilder(" top_options:")).append(topOptions.size()).toString());
        }
        return stringbuilder.toString();
    }
}
