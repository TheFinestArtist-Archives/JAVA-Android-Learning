// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.model;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Model;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Place;

public class PinnableImage extends Model
{

    private String description;
    private int height;
    private String imageUrl;
    private Place place;
    private String placeUid;
    private String sourceUrl;
    private String uid;
    private int width;

    public PinnableImage()
    {
    }

    public static PinnableImage make(String s, PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        PinnableImage pinnableimage;
        pinnableimage = new PinnableImage();
        pinnableimage.setUid(s);
        pinnableimage.setImageUrl(pinterestjsonobject.a("src", pinterestjsonobject.a("media", null)));
        pinnableimage.setWidth(pinterestjsonobject.a("width", 0));
        pinnableimage.setHeight(pinterestjsonobject.a("height", 0));
        pinnableimage.setDescription(pinterestjsonobject.a("description", null));
        pinnableimage.setSourceUrl(pinterestjsonobject.a("url", null));
        return pinnableimage;
        s;
        return null;
    }

    public static PinnableImage make(String s, String s1, String s2)
    {
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        PinnableImage pinnableimage;
        pinnableimage = new PinnableImage();
        pinnableimage.setUid(s);
        pinnableimage.setImageUrl(s2);
        pinnableimage.setSourceUrl(s1);
        pinnableimage.setWidth(200);
        pinnableimage.setHeight(200);
        return pinnableimage;
        s;
        return null;
    }

    public String getDescription()
    {
        return description;
    }

    public int getHeight()
    {
        return height;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public Place getPlace()
    {
        if (place == null)
        {
            place = ModelHelper.getPlace(placeUid);
        }
        return place;
    }

    public String getPlaceUid()
    {
        return placeUid;
    }

    public String getSourceUrl()
    {
        return sourceUrl;
    }

    public String getUid()
    {
        return uid;
    }

    public int getWidth()
    {
        return width;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setPlace(Place place1)
    {
        place = place1;
    }

    public void setPlaceUid(String s)
    {
        placeUid = s;
    }

    public void setSourceUrl(String s)
    {
        sourceUrl = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setWidth(int i)
    {
        width = i;
    }

    public String toString()
    {
        return (new StringBuilder("PinnableImage{imageUrl='")).append(imageUrl).append('\'').append(", width=").append(width).append(", height=").append(height).append('}').toString();
    }
}
