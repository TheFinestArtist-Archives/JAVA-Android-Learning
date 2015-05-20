// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.graphics.Color;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.Colors;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class Interest extends Model
{

    private ArrayList childInterests;
    private String dominantColor;
    private Date feedUpdatedTime;
    private Boolean following;
    private Long id;
    private Integer imageGridLg2LineHeight;
    private String imageGridLg2LineUrl;
    private Integer imageGridLg2LineWidth;
    private Integer imageGridLg4LineHeight;
    private String imageGridLg4LineUrl;
    private Integer imageGridLg4LineWidth;
    private Integer imageGridMed1LineHeight;
    private String imageGridMed1LineUrl;
    private Integer imageGridMed1LineWidth;
    private Integer imageGridMed2LineHeight;
    private String imageGridMed2LineUrl;
    private Integer imageGridMed2LineWidth;
    private Integer imageGridMed4LineHeight;
    private String imageGridMed4LineUrl;
    private Integer imageGridMed4LineWidth;
    private Integer imageHeaderHeight;
    private String imageHeaderUrl;
    private Integer imageHeaderWidth;
    private String imageSignature;
    private Integer imageSmallHeight;
    private String imageSmallUrl;
    private Integer imageSmallWidth;
    private String key;
    private String name;
    private Integer pinnerCount;
    private String uid;
    private String urlName;

    public Interest()
    {
    }

    public Interest(Long long1)
    {
        id = long1;
    }

    public Interest(Long long1, String s, String s1, String s2, String s3, String s4, String s5, 
            Boolean boolean1, Date date, Integer integer, String s6, Integer integer1, Integer integer2, String s7, 
            Integer integer3, Integer integer4, String s8, Integer integer5, Integer integer6, String s9, Integer integer7, 
            Integer integer8, String s10, Integer integer9, Integer integer10, String s11, Integer integer11, Integer integer12, 
            String s12, Integer integer13, Integer integer14)
    {
        id = long1;
        uid = s;
        key = s1;
        name = s2;
        urlName = s3;
        imageSignature = s4;
        dominantColor = s5;
        following = boolean1;
        feedUpdatedTime = date;
        pinnerCount = integer;
        imageSmallUrl = s6;
        imageSmallWidth = integer1;
        imageSmallHeight = integer2;
        imageHeaderUrl = s7;
        imageHeaderWidth = integer3;
        imageHeaderHeight = integer4;
        imageGridMed1LineUrl = s8;
        imageGridMed1LineWidth = integer5;
        imageGridMed1LineHeight = integer6;
        imageGridMed2LineUrl = s9;
        imageGridMed2LineWidth = integer7;
        imageGridMed2LineHeight = integer8;
        imageGridMed4LineUrl = s10;
        imageGridMed4LineWidth = integer9;
        imageGridMed4LineHeight = integer10;
        imageGridLg2LineUrl = s11;
        imageGridLg2LineWidth = integer11;
        imageGridLg2LineHeight = integer12;
        imageGridLg4LineUrl = s12;
        imageGridLg4LineWidth = integer13;
        imageGridLg4LineHeight = integer14;
    }

    public static Interest make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true);
    }

    public static Interest make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        Interest interest = new Interest();
        if (pinterestjsonobject != null)
        {
            interest.setUid(pinterestjsonobject.a("id", null));
            if (pinterestjsonobject.f("is_followed"))
            {
                interest.setFollowing(pinterestjsonobject.a("is_followed"));
            }
            interest.setName(pinterestjsonobject.a("name", ""));
            interest.setImageSignature(pinterestjsonobject.a("image_signature", null));
            interest.setKey(pinterestjsonobject.a("key", null));
            interest.setDominantColor(pinterestjsonobject.a("background_color", "").replace("null", "").replace("[", "").replace("]", ""));
            interest.setUrlName(pinterestjsonobject.a("url_name", null));
            interest.setPinnerCount(Integer.valueOf(pinterestjsonobject.a("follower_count", -1)));
            interest.setFeedUpdatedTime(ModelHelper.stringToDate(pinterestjsonobject.a("feed_update_time", null)));
            PinterestJsonObject pinterestjsonobject2 = pinterestjsonobject.c("images");
            if (pinterestjsonobject2 != null)
            {
                pinterestjsonobject = pinterestjsonobject2.c("75x75");
                if (pinterestjsonobject != null)
                {
                    interest.setImageSmallUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageSmallWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageSmallHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject2.c("474x");
                pinterestjsonobject = pinterestjsonobject1;
                if (pinterestjsonobject1 == null)
                {
                    pinterestjsonobject = pinterestjsonobject2.c("600x");
                }
                if (pinterestjsonobject != null)
                {
                    interest.setImageHeaderUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageHeaderWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageHeaderHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                pinterestjsonobject = pinterestjsonobject2.c("300x300(ir.48)");
                if (pinterestjsonobject != null)
                {
                    interest.setImageGridLg4LineUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageGridLg4LineWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageGridLg4LineHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                pinterestjsonobject = pinterestjsonobject2.c("300x300(ir.24)");
                if (pinterestjsonobject != null)
                {
                    interest.setImageGridLg2LineUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageGridLg2LineWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageGridLg2LineHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                pinterestjsonobject = pinterestjsonobject2.c("150x150(ir.48)");
                if (pinterestjsonobject != null)
                {
                    interest.setImageGridMed4LineUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageGridMed4LineWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageGridMed4LineHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                pinterestjsonobject = pinterestjsonobject2.c("150x150(ir.24)");
                if (pinterestjsonobject != null)
                {
                    interest.setImageGridMed2LineUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageGridMed2LineWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageGridMed2LineHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
                pinterestjsonobject = pinterestjsonobject2.c("150x150(ir.12)");
                if (pinterestjsonobject != null)
                {
                    interest.setImageGridMed1LineUrl(pinterestjsonobject.a("url", ""));
                    interest.setImageGridMed1LineWidth(Integer.valueOf(pinterestjsonobject.a("width", 0)));
                    interest.setImageGridMed1LineHeight(Integer.valueOf(pinterestjsonobject.a("height", 0)));
                }
            }
            if (flag)
            {
                ModelHelper.setInterest(interest);
                return interest;
            }
        }
        return interest;
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        return makeAll(pinterestjsonarray, true);
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            arraylist.add(make(pinterestjsonarray.c(i), false));
        }

        if (flag)
        {
            ModelHelper.setInterests(arraylist);
        }
        return arraylist;
    }

    public static ArrayList makeAllFromExploreData(PinterestJsonArray pinterestjsonarray, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < pinterestjsonarray.a(); i++)
        {
            Interest interest = makeFromExploreData(pinterestjsonarray.b(i), false);
            arraylist1.addAll(interest.getChildInterests());
            arraylist.add(interest);
        }

        if (flag)
        {
            ModelHelper.setInterests(arraylist1);
        }
        return arraylist;
    }

    public static Interest makeFromExploreData(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        ArrayList arraylist = (ArrayList)makeAll(pinterestjsonobject.d("child_interests"), flag);
        pinterestjsonobject = make(pinterestjsonobject.c("l1_interest"), flag);
        arraylist.add(pinterestjsonobject);
        pinterestjsonobject.setChildInterests(arraylist);
        return pinterestjsonobject;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Interest)obj;
            if (uid == null ? ((Interest) (obj)).uid != null : !uid.equals(((Interest) (obj)).uid))
            {
                return false;
            }
        }
        return true;
    }

    public int getBackgroundColor()
    {
        return Colors.from(dominantColor, Color.argb(255, 238, 238, 238)).intValue();
    }

    public String getBestImageUrl(int i)
    {
        if (i > 1)
        {
            return StringUtils.defaultString(getImageGridMed2LineUrl(), getImageGridLg4LineUrl());
        } else
        {
            return StringUtils.defaultString(getImageGridMed1LineUrl(), getImageGridLg2LineUrl());
        }
    }

    public ArrayList getChildInterests()
    {
        return childInterests;
    }

    public String getDominantColor()
    {
        return dominantColor;
    }

    public Date getFeedUpdatedTime()
    {
        return feedUpdatedTime;
    }

    public Boolean getFollowing()
    {
        return following;
    }

    public Long getId()
    {
        return id;
    }

    public Integer getImageGridLg2LineHeight()
    {
        return imageGridLg2LineHeight;
    }

    public String getImageGridLg2LineUrl()
    {
        return imageGridLg2LineUrl;
    }

    public Integer getImageGridLg2LineWidth()
    {
        return imageGridLg2LineWidth;
    }

    public Integer getImageGridLg4LineHeight()
    {
        return imageGridLg4LineHeight;
    }

    public String getImageGridLg4LineUrl()
    {
        return imageGridLg4LineUrl;
    }

    public Integer getImageGridLg4LineWidth()
    {
        return imageGridLg4LineWidth;
    }

    public Integer getImageGridMed1LineHeight()
    {
        return imageGridMed1LineHeight;
    }

    public String getImageGridMed1LineUrl()
    {
        return imageGridMed1LineUrl;
    }

    public Integer getImageGridMed1LineWidth()
    {
        return imageGridMed1LineWidth;
    }

    public Integer getImageGridMed2LineHeight()
    {
        return imageGridMed2LineHeight;
    }

    public String getImageGridMed2LineUrl()
    {
        return imageGridMed2LineUrl;
    }

    public Integer getImageGridMed2LineWidth()
    {
        return imageGridMed2LineWidth;
    }

    public Integer getImageGridMed4LineHeight()
    {
        return imageGridMed4LineHeight;
    }

    public String getImageGridMed4LineUrl()
    {
        return imageGridMed4LineUrl;
    }

    public Integer getImageGridMed4LineWidth()
    {
        return imageGridMed4LineWidth;
    }

    public Integer getImageHeaderHeight()
    {
        return imageHeaderHeight;
    }

    public String getImageHeaderUrl()
    {
        return imageHeaderUrl;
    }

    public Integer getImageHeaderWidth()
    {
        return imageHeaderWidth;
    }

    public String getImageSignature()
    {
        return imageSignature;
    }

    public Integer getImageSmallHeight()
    {
        return imageSmallHeight;
    }

    public String getImageSmallUrl()
    {
        return imageSmallUrl;
    }

    public Integer getImageSmallWidth()
    {
        return imageSmallWidth;
    }

    public String getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public Integer getPinnerCount()
    {
        return pinnerCount;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUrlName()
    {
        return urlName;
    }

    public void setChildInterests(ArrayList arraylist)
    {
        childInterests = arraylist;
    }

    public void setDominantColor(String s)
    {
        dominantColor = s;
    }

    public void setFeedUpdatedTime(Date date)
    {
        feedUpdatedTime = date;
    }

    public void setFollowing(Boolean boolean1)
    {
        following = boolean1;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setImageGridLg2LineHeight(Integer integer)
    {
        imageGridLg2LineHeight = integer;
    }

    public void setImageGridLg2LineUrl(String s)
    {
        imageGridLg2LineUrl = s;
    }

    public void setImageGridLg2LineWidth(Integer integer)
    {
        imageGridLg2LineWidth = integer;
    }

    public void setImageGridLg4LineHeight(Integer integer)
    {
        imageGridLg4LineHeight = integer;
    }

    public void setImageGridLg4LineUrl(String s)
    {
        imageGridLg4LineUrl = s;
    }

    public void setImageGridLg4LineWidth(Integer integer)
    {
        imageGridLg4LineWidth = integer;
    }

    public void setImageGridMed1LineHeight(Integer integer)
    {
        imageGridMed1LineHeight = integer;
    }

    public void setImageGridMed1LineUrl(String s)
    {
        imageGridMed1LineUrl = s;
    }

    public void setImageGridMed1LineWidth(Integer integer)
    {
        imageGridMed1LineWidth = integer;
    }

    public void setImageGridMed2LineHeight(Integer integer)
    {
        imageGridMed2LineHeight = integer;
    }

    public void setImageGridMed2LineUrl(String s)
    {
        imageGridMed2LineUrl = s;
    }

    public void setImageGridMed2LineWidth(Integer integer)
    {
        imageGridMed2LineWidth = integer;
    }

    public void setImageGridMed4LineHeight(Integer integer)
    {
        imageGridMed4LineHeight = integer;
    }

    public void setImageGridMed4LineUrl(String s)
    {
        imageGridMed4LineUrl = s;
    }

    public void setImageGridMed4LineWidth(Integer integer)
    {
        imageGridMed4LineWidth = integer;
    }

    public void setImageHeaderHeight(Integer integer)
    {
        imageHeaderHeight = integer;
    }

    public void setImageHeaderUrl(String s)
    {
        imageHeaderUrl = s;
    }

    public void setImageHeaderWidth(Integer integer)
    {
        imageHeaderWidth = integer;
    }

    public void setImageSignature(String s)
    {
        imageSignature = s;
    }

    public void setImageSmallHeight(Integer integer)
    {
        imageSmallHeight = integer;
    }

    public void setImageSmallUrl(String s)
    {
        imageSmallUrl = s;
    }

    public void setImageSmallWidth(Integer integer)
    {
        imageSmallWidth = integer;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPinnerCount(Integer integer)
    {
        pinnerCount = integer;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUrlName(String s)
    {
        urlName = s;
    }
}
