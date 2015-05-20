// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.api.PinterestJsonObject;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper

public class Partner extends Model
{

    private String accountType;
    private Boolean autoFollowAllowed;
    private String businessName;
    private String contactName;
    private Long id;
    private String type;
    private String uid;

    public Partner()
    {
    }

    public Partner(Long long1)
    {
        id = long1;
    }

    public Partner(Long long1, String s, String s1, Boolean boolean1, String s2, String s3, String s4)
    {
        id = long1;
        uid = s;
        accountType = s1;
        autoFollowAllowed = boolean1;
        businessName = s2;
        contactName = s3;
        type = s4;
    }

    public static Partner make(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return make(pinterestjsonobject, true);
        }
    }

    public static Partner make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        if (pinterestjsonobject == null)
        {
            pinterestjsonobject = null;
        } else
        {
            Partner partner = new Partner();
            partner.setUid(pinterestjsonobject.a("id", "0"));
            partner.setAccountType(pinterestjsonobject.a("account_type", ""));
            partner.setAutoFollowAllowed(pinterestjsonobject.a("auto_follow_allowed", Boolean.valueOf(false)));
            partner.setBusinessName(pinterestjsonobject.a("business_name", ""));
            partner.setContactName(pinterestjsonobject.a("contact_name", ""));
            partner.setType(pinterestjsonobject.a("type", ""));
            pinterestjsonobject = partner;
            if (flag)
            {
                ModelHelper.setPartner(partner);
                return partner;
            }
        }
        return pinterestjsonobject;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public Boolean getAutoFollowAllowed()
    {
        return autoFollowAllowed;
    }

    public String getBusinessName()
    {
        return businessName;
    }

    public String getContactName()
    {
        return contactName;
    }

    public Long getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public String getUid()
    {
        return uid;
    }

    public void setAccountType(String s)
    {
        accountType = s;
    }

    public void setAutoFollowAllowed(Boolean boolean1)
    {
        autoFollowAllowed = boolean1;
    }

    public void setBusinessName(String s)
    {
        businessName = s;
    }

    public void setContactName(String s)
    {
        contactName = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }
}
