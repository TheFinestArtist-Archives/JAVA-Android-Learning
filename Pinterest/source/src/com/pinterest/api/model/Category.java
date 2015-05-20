// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class Category extends Model
{

    public static final String CATEGORY_ALL = "everything";
    public static final String CATEGORY_ALL_COLOR = "#23326C";
    public static final String CATEGORY_ALL_ID = "2";
    public static final String CATEGORY_FEATURED = "featured";
    public static final String CATEGORY_FEATURED_ID = "1002";
    public static final String CATEGORY_OTHER_ID = "1000";
    public static final String CATEGORY_POPULAR = "popular";
    public static final String CATEGORY_POPULAR_ID = "3";
    public static final String CATEGORY_TRAVEL = "travel";
    private static final String DELIM = "  &#183;  ";
    public static final String LOCAL_CATEGORIES[] = {
        "everything", "popular", "featured"
    };
    public static final String LOCAL_CATEGORY_IDS[] = {
        "2", "3", "1002"
    };
    public static final int LOCAL_CATEGORY_STRINGS[] = {
        0x7f0e002d, 0x7f0e03b0, 0x7f0e04b4
    };
    private static final boolean SHOW_PIN_PICKS = false;
    public static final int TYPE_CATEGORY = 0;
    public static final int TYPE_INTEREST = 1;
    private List _subCategories;
    private Boolean browsable;
    private String hash;
    private Long id;
    private String imageFullUrl;
    private String imageLargeUrl;
    private String imageMediumUrl;
    private String imageSmallUrl;
    private String key;
    private String name;
    private String pinImages;
    private String subCatString;
    private String subKeys;
    public int type;
    private String uid;

    public Category()
    {
        type = 0;
    }

    public Category(Long long1)
    {
        type = 0;
        id = long1;
    }

    public Category(Long long1, String s, String s1, Boolean boolean1, String s2, String s3, String s4, 
            String s5, String s6, String s7, String s8, String s9, String s10)
    {
        type = 0;
        id = long1;
        uid = s;
        key = s1;
        browsable = boolean1;
        name = s2;
        hash = s3;
        imageSmallUrl = s4;
        imageMediumUrl = s5;
        imageLargeUrl = s6;
        imageFullUrl = s7;
        pinImages = s8;
        subKeys = s9;
        subCatString = s10;
    }

    private static void addLocalCategories(List list)
    {
        for (int i = 0; i < 2; i++)
        {
            Category category = new Category();
            category.setName(Resources.string(LOCAL_CATEGORY_STRINGS[i]));
            category.setKey(LOCAL_CATEGORIES[i]);
            category.setId(Long.valueOf(LOCAL_CATEGORY_IDS[i]));
            category.setUid(LOCAL_CATEGORY_IDS[i]);
            category.setBrowsable(Boolean.valueOf(true));
            list.add(category);
        }

    }

    private static String getImageUrl(PinterestJsonObject pinterestjsonobject, String s)
    {
        pinterestjsonobject = pinterestjsonobject.c(s);
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return pinterestjsonobject.a("url", "");
        }
    }

    public static Category make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        Category category = new Category();
        if (pinterestjsonobject == null)
        {
            return category;
        }
        long l1 = pinterestjsonobject.a("enum_type", -1L);
        if (l1 != -1L)
        {
            category.setId(Long.valueOf(l1));
        }
        Object obj = pinterestjsonobject.a("enum_type", "");
        if (obj != null)
        {
            category.setUid(((String) (obj)));
        }
        category.setHash(pinterestjsonobject.a("id", ""));
        category.setBrowsable(pinterestjsonobject.a("browsable", Boolean.valueOf(true)));
        category.setName(pinterestjsonobject.a("name", ""));
        category.setKey(pinterestjsonobject.a("key", ""));
        obj = pinterestjsonobject.c("images");
        String s1;
        PinterestJsonArray pinterestjsonarray;
        if (obj != null)
        {
            String s = getImageUrl(((PinterestJsonObject) (obj)), "45x");
            category.setImageSmallUrl(s);
            category.setImageMediumUrl(s);
            category.setImageLargeUrl(s);
            category.setImageFullUrl(getImageUrl(((PinterestJsonObject) (obj)), "200x"));
        } else
        {
            category.setImageSmallUrl(pinterestjsonobject.a("icon_small_url", ""));
            category.setImageMediumUrl(pinterestjsonobject.a("icon_medium_url", ""));
            category.setImageLargeUrl(pinterestjsonobject.a("icon_large_url", ""));
            category.setImageFullUrl(pinterestjsonobject.a("icon_large_url", ""));
        }
        obj = "";
        pinterestjsonarray = pinterestjsonobject.e("pin_images");
        s1 = ((String) (obj));
        if (pinterestjsonarray.a() > 0)
        {
            int k = pinterestjsonarray.a();
            int i = 0;
            do
            {
                s1 = ((String) (obj));
                if (i >= k)
                {
                    break;
                }
                s1 = ((String) (obj));
                if (((String) (obj)).length() > 0)
                {
                    s1 = (new StringBuilder()).append(((String) (obj))).append(",").toString();
                }
                obj = (new StringBuilder()).append(s1).append(pinterestjsonarray.a(i)).toString();
                i++;
            } while (true);
        }
        category.setPinImages(s1);
        pinterestjsonobject = pinterestjsonobject.e("subcategories");
        if (pinterestjsonobject.a() > 0)
        {
            ArrayList arraylist = new ArrayList();
            int l = pinterestjsonobject.a();
            for (int j = 0; j < l; j++)
            {
                arraylist.add(make(pinterestjsonobject.c(j), false));
            }

            category.cacheSubCategories(arraylist);
            ModelHelper.setCategories(arraylist);
            pinterestjsonobject = "";
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
            {
                Category category1 = (Category)iterator.next();
                Object obj1 = pinterestjsonobject;
                if (pinterestjsonobject.length() > 0)
                {
                    obj1 = (new StringBuilder()).append(pinterestjsonobject).append(",").toString();
                }
                pinterestjsonobject = (new StringBuilder()).append(((String) (obj1))).append(category1.getKey()).toString();
            }

            category.setSubKeys(pinterestjsonobject);
        }
        makeSubCatText(category);
        if (flag)
        {
            ModelHelper.setCategory(category);
        }
        return category;
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        return makeAll(pinterestjsonarray, false, true, true);
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray, boolean flag)
    {
        return makeAll(pinterestjsonarray, false, true, flag);
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray, boolean flag, boolean flag1, boolean flag2)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (flag1)
        {
            addLocalCategories(arraylist);
        }
        if (pinterestjsonarray != null)
        {
            int j = pinterestjsonarray.a();
            int i = 0;
            while (i < j) 
            {
                Category category = make(pinterestjsonarray.c(i), false);
                if (category.getBrowsable().booleanValue())
                {
                    arraylist.add(category);
                } else
                {
                    arraylist1.add(category);
                    if (category.getName().equalsIgnoreCase("other"))
                    {
                        category.setId(Long.valueOf("1000"));
                        category.setUid("1000");
                    }
                }
                i++;
            }
        }
        pinterestjsonarray = new ArrayList(arraylist);
        pinterestjsonarray.addAll(arraylist1);
        if (flag2)
        {
            ModelHelper.setCategories(pinterestjsonarray);
            Preferences.user().set("PREF_CATEGORIES_LOCALE", Locale.getDefault().toString());
        }
        if (flag)
        {
            return arraylist;
        } else
        {
            return pinterestjsonarray;
        }
    }

    private static void makeSubCatText(Category category)
    {
        List list = category.getSubCategories();
        if (list == null || list.size() == 0)
        {
            return;
        }
        int j = list.size();
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(((Category)list.get(i)).getName());
            if (i != j - 1)
            {
                stringbuilder.append("  &#183;  ");
            }
        }

        category.setSubCatString(stringbuilder.toString());
    }

    public void cacheSubCategories(List list)
    {
        _subCategories = list;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Category)obj;
            if (key == null || !key.equals(((Category) (obj)).key))
            {
                return false;
            }
        }
        return true;
    }

    public Boolean getBrowsable()
    {
        return browsable;
    }

    public String getHash()
    {
        return hash;
    }

    public Long getId()
    {
        return id;
    }

    public String getImageFullUrl()
    {
        return imageFullUrl;
    }

    public String getImageLargeUrl()
    {
        return imageLargeUrl;
    }

    public String getImageMediumUrl()
    {
        return imageMediumUrl;
    }

    public String getImageSmallUrl()
    {
        return imageSmallUrl;
    }

    public String getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public String getPinImages()
    {
        return pinImages;
    }

    public List getPreviewImageUrls()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = arraylist;
        if (pinImages != null)
        {
            obj = arraylist;
            if (pinImages.length() > 0)
            {
                obj = Arrays.asList(StringUtils.split(pinImages, ","));
            }
        }
        return ((List) (obj));
    }

    public String getSubCatString()
    {
        return subCatString;
    }

    public List getSubCategories()
    {
        if (_subCategories == null && StringUtils.isNotEmpty(subKeys))
        {
            _subCategories = ModelHelper.getCategories(Arrays.asList(subKeys.split(",")));
        }
        return _subCategories;
    }

    public String getSubKeys()
    {
        return subKeys;
    }

    public int getType()
    {
        return type;
    }

    public String getUid()
    {
        return uid;
    }

    public void setBrowsable(Boolean boolean1)
    {
        browsable = boolean1;
    }

    public void setHash(String s)
    {
        hash = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setImageFullUrl(String s)
    {
        imageFullUrl = s;
    }

    public void setImageLargeUrl(String s)
    {
        imageLargeUrl = s;
    }

    public void setImageMediumUrl(String s)
    {
        imageMediumUrl = s;
    }

    public void setImageSmallUrl(String s)
    {
        imageSmallUrl = s;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPinImages(String s)
    {
        pinImages = s;
    }

    public void setSubCatString(String s)
    {
        subCatString = s;
    }

    public void setSubKeys(String s)
    {
        subKeys = s;
    }

    public void setTypeInterest()
    {
        type = 1;
    }

    public void setUid(String s)
    {
        uid = s;
    }

}
