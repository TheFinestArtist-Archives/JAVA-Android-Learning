// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.text.Html;
import android.text.Spanned;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.application.Resources;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class Place extends Model
{

    private String access;
    private String address;
    private Spanned addressDisplay;
    private String category;
    private String cityState;
    private String country;
    private Long id;
    private Double latitude;
    private String locality;
    private Double longitude;
    private String name;
    private String phone;
    private String postalCode;
    private String region;
    private String searchId;
    private String sourceIcon;
    private String sourceName;
    private String sourceUrl;
    private String street;
    private String type;
    private String uid;
    private String url;

    public Place()
    {
    }

    public Place(Long long1)
    {
        id = long1;
    }

    public Place(Long long1, String s, String s1, Double double1, Double double2, String s2, String s3, 
            String s4, String s5, String s6, String s7, String s8, String s9, String s10, 
            String s11, String s12, String s13, String s14, String s15)
    {
        id = long1;
        uid = s;
        searchId = s1;
        latitude = double1;
        longitude = double2;
        category = s2;
        sourceIcon = s3;
        sourceName = s4;
        name = s5;
        locality = s6;
        url = s7;
        country = s8;
        region = s9;
        sourceUrl = s10;
        phone = s11;
        street = s12;
        postalCode = s13;
        type = s14;
        access = s15;
    }

    public static Place make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true);
    }

    public static Place make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        if (pinterestjsonobject == null)
        {
            pinterestjsonobject = null;
        } else
        {
            Place place = new Place();
            place.setUid(pinterestjsonobject.a("id", ""));
            place.setSearchId(pinterestjsonobject.a("search_id", ""));
            if (pinterestjsonobject.f("latitude"))
            {
                place.setLatitude(Double.valueOf(pinterestjsonobject.b("latitude")));
            }
            if (pinterestjsonobject.f("longitude"))
            {
                place.setLongitude(Double.valueOf(pinterestjsonobject.b("longitude")));
            }
            place.setCategory(pinterestjsonobject.a("category", ""));
            place.setSourceIcon(pinterestjsonobject.a("source_icon", ""));
            place.setSourceName(pinterestjsonobject.a("source_name", ""));
            place.setName(pinterestjsonobject.a("name", ""));
            place.setLocality(pinterestjsonobject.a("locality", ""));
            place.setUrl(pinterestjsonobject.a("url", ""));
            place.setCountry(pinterestjsonobject.a("country", ""));
            place.setRegion(pinterestjsonobject.a("region", ""));
            place.setSourceUrl(pinterestjsonobject.a("source_url", ""));
            place.setPhone(pinterestjsonobject.a("phone", ""));
            place.setStreet(pinterestjsonobject.a("street", ""));
            place.setPostalCode(pinterestjsonobject.a("postal_code", ""));
            place.setType(pinterestjsonobject.a("type", ""));
            place.setAccess(pinterestjsonobject.e("access").a(","));
            place = merge(place);
            pinterestjsonobject = place;
            if (flag)
            {
                ModelHelper.setPlace(place);
                return place;
            }
        }
        return pinterestjsonobject;
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            Place place = make(pinterestjsonarray.b(i), false);
            if (place != null)
            {
                arraylist.add(place);
            }
        }

        ModelHelper.setPlaces(arraylist);
        return arraylist;
    }

    public static Place merge(Place place)
    {
        if (place == null)
        {
            return null;
        } else
        {
            return merge(place, ModelHelper.getPlace(place.getUid()));
        }
    }

    public static Place merge(Place place, Place place1)
    {
        Place place2;
        if (place == null)
        {
            place2 = null;
        } else
        {
            place2 = place;
            if (place1 != null)
            {
                if (place.searchId != null)
                {
                    place1.searchId = place.searchId;
                }
                if (place.latitude != null)
                {
                    place1.latitude = place.latitude;
                }
                if (place.longitude != null)
                {
                    place1.longitude = place.longitude;
                }
                if (place.category != null)
                {
                    place1.category = place.category;
                }
                if (place.sourceIcon != null)
                {
                    place1.sourceIcon = place.sourceIcon;
                }
                if (place.sourceName != null)
                {
                    place1.sourceName = place.sourceName;
                }
                if (place.name != null)
                {
                    place1.name = place.name;
                }
                if (place.locality != null)
                {
                    place1.locality = place.locality;
                }
                if (place.url != null)
                {
                    place1.url = place.url;
                }
                if (place.country != null)
                {
                    place1.country = place.country;
                }
                if (place.region != null)
                {
                    place1.region = place.region;
                }
                if (place.sourceUrl != null)
                {
                    place1.sourceUrl = place.sourceUrl;
                }
                if (place.phone != null)
                {
                    place1.phone = place.phone;
                }
                if (place.street != null)
                {
                    place1.street = place.street;
                }
                if (place.postalCode != null)
                {
                    place1.postalCode = place.postalCode;
                }
                if (place.type != null)
                {
                    place1.type = place.type;
                }
                if (place.access != null)
                {
                    place1.access = place.access;
                }
                return place1;
            }
        }
        return place2;
    }

    public boolean canEdit()
    {
        return access != null && access.contains("write");
    }

    public String getAccess()
    {
        return access;
    }

    public String getAddress()
    {
        if (address == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (ModelHelper.isValidString(getStreet()))
            {
                stringbuilder.append(getStreet()).append(", ");
            }
            if (ModelHelper.isValidString(getLocality()))
            {
                stringbuilder.append(getLocality()).append(", ");
            }
            if (ModelHelper.isValidString(getRegion()))
            {
                stringbuilder.append(getRegion()).append(", ");
            }
            if (ModelHelper.isValidString(getCountry()))
            {
                stringbuilder.append(getCountry());
            }
            address = stringbuilder.toString();
        }
        return address;
    }

    public Spanned getAddressDisplay()
    {
        if (addressDisplay == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (ModelHelper.isValidString(getStreet()))
            {
                stringbuilder.append(getStreet());
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("<br/>");
            }
            if (ModelHelper.isValidString(getLocality()))
            {
                stringbuilder.append(getLocality()).append(", ");
            }
            if (ModelHelper.isValidString(getRegion()))
            {
                stringbuilder.append(getRegion()).append(", ");
            }
            if (ModelHelper.isValidString(getCountry()))
            {
                stringbuilder.append(getCountry());
            }
            addressDisplay = Html.fromHtml(stringbuilder.toString());
        }
        return addressDisplay;
    }

    public String getCategory()
    {
        return category;
    }

    public String getCityState()
    {
        if (cityState == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (ModelHelper.isValidString(getLocality()))
            {
                stringbuilder.append(getLocality());
            }
            if (ModelHelper.isValidString(getRegion()))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(getRegion());
            }
            cityState = stringbuilder.toString();
        }
        return cityState;
    }

    public String getCountry()
    {
        return country;
    }

    public Long getId()
    {
        return id;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public String getLocality()
    {
        return locality;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public CharSequence getMetadataDisplay()
    {
        if (ModelHelper.isValidString(getCategory()) && ModelHelper.isValid(getCityState()))
        {
            return Resources.string(0x7f0e0393, new Object[] {
                getCategory(), getCityState()
            });
        } else
        {
            return null;
        }
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getRegion()
    {
        return region;
    }

    public String getSearchId()
    {
        return searchId;
    }

    public String getSourceIcon()
    {
        return sourceIcon;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public String getSourceUrl()
    {
        return sourceUrl;
    }

    public String getStreet()
    {
        return street;
    }

    public String getType()
    {
        return type;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setAccess(String s)
    {
        access = s;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setCountry(String s)
    {
        country = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setLatitude(Double double1)
    {
        latitude = double1;
    }

    public void setLocality(String s)
    {
        locality = s;
    }

    public void setLongitude(Double double1)
    {
        longitude = double1;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPhone(String s)
    {
        phone = s;
    }

    public void setPostalCode(String s)
    {
        postalCode = s;
    }

    public void setRegion(String s)
    {
        region = s;
    }

    public void setSearchId(String s)
    {
        searchId = s;
    }

    public void setSourceIcon(String s)
    {
        sourceIcon = s;
    }

    public void setSourceName(String s)
    {
        sourceName = s;
    }

    public void setSourceUrl(String s)
    {
        sourceUrl = s;
    }

    public void setStreet(String s)
    {
        street = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
