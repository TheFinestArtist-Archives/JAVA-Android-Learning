// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model.metadata.recipe;

import com.pinterest.api.PinterestJsonObject;

public class AggregateRating
{

    private String _bestRating;
    private String _id;
    private Object _name;
    private Integer _ratingCount;
    private String _ratingValue;
    private Integer _reviewCount;
    private String _type;
    private String _worstRating;

    public AggregateRating(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return;
        } else
        {
            _bestRating = pinterestjsonobject.a("best_rating", "");
            _worstRating = pinterestjsonobject.a("worst_rating", "");
            _id = pinterestjsonobject.a("id", "");
            _bestRating = pinterestjsonobject.a("name", "");
            _ratingCount = Integer.valueOf(pinterestjsonobject.a("rating_count", 0));
            _ratingValue = pinterestjsonobject.a("rating_value", "");
            _reviewCount = Integer.valueOf(pinterestjsonobject.a("review_count", 0));
            _type = pinterestjsonobject.a("type", "");
            return;
        }
    }

    public String getBestRating()
    {
        return _bestRating;
    }

    public String getId()
    {
        return _id;
    }

    public Object getName()
    {
        return _name;
    }

    public Integer getRatingCount()
    {
        return _ratingCount;
    }

    public String getRatingValue()
    {
        return _ratingValue;
    }

    public Integer getReviewCount()
    {
        return _reviewCount;
    }

    public String getType()
    {
        return _type;
    }

    public String getWorstRating()
    {
        return _worstRating;
    }

    public void setBestRating(String s)
    {
        _bestRating = s;
    }

    public void setId(String s)
    {
        _id = s;
    }

    public void setName(Object obj)
    {
        _name = obj;
    }

    public void setRatingCount(Integer integer)
    {
        _ratingCount = integer;
    }

    public void setRatingValue(String s)
    {
        _ratingValue = s;
    }

    public void setReviewCount(Integer integer)
    {
        _reviewCount = integer;
    }

    public void setType(String s)
    {
        _type = s;
    }

    public void setWorstRating(String s)
    {
        _worstRating = s;
    }
}
