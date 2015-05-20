// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.model;

import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class TypeAheadItem
    implements Serializable, Comparable
{

    private List emails;
    private boolean followedByMe;
    private String identifier;
    private String imageUri;
    private boolean isVerified;
    private ItemType itemType;
    private String location;
    private List phoneNumbers;
    private String title;
    private String uid;
    private String website;

    public TypeAheadItem()
    {
        itemType = ItemType.NONE;
        emails = new LinkedList();
        phoneNumbers = new LinkedList();
    }

    public static List parseData(Object obj)
    {
        List list = Collections.emptyList();
        Object obj1 = list;
        if (obj != null)
        {
            obj1 = list;
            if (obj instanceof PinterestJsonArray)
            {
                obj = (PinterestJsonArray)obj;
                obj1 = new ArrayList();
                int i = 0;
                while (i < ((PinterestJsonArray) (obj)).a()) 
                {
                    try
                    {
                        PinterestJsonObject pinterestjsonobject = ((PinterestJsonArray) (obj)).c(i);
                        TypeAheadItem typeaheaditem = new TypeAheadItem();
                        typeaheaditem.setItem(pinterestjsonobject);
                        ((List) (obj1)).add(typeaheaditem);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    i++;
                }
            }
        }
        return ((List) (obj1));
    }

    public void addEmail(String s)
    {
        emails.add(s);
    }

    public void addPhoneNumber(String s)
    {
        phoneNumbers.add(s);
    }

    public int compareTo(Object obj)
    {
        if (obj instanceof TypeAheadItem)
        {
            obj = (TypeAheadItem)obj;
            if (getTitle() != null && ((TypeAheadItem) (obj)).getTitle() != null)
            {
                return getTitle().compareToIgnoreCase(((TypeAheadItem) (obj)).getTitle());
            }
        }
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof TypeAheadItem))
            {
                return false;
            }
            obj = (TypeAheadItem)obj;
            if (uid == null ? ((TypeAheadItem) (obj)).uid != null : !uid.equals(((TypeAheadItem) (obj)).getUid()))
            {
                return false;
            }
            if (identifier == null ? ((TypeAheadItem) (obj)).identifier != null : !identifier.equals(((TypeAheadItem) (obj)).identifier))
            {
                return false;
            }
            if (imageUri == null ? ((TypeAheadItem) (obj)).imageUri != null : !imageUri.equals(((TypeAheadItem) (obj)).imageUri))
            {
                return false;
            }
            if (title == null ? ((TypeAheadItem) (obj)).title != null : !title.equals(((TypeAheadItem) (obj)).title))
            {
                return false;
            }
            if (emails == null ? ((TypeAheadItem) (obj)).emails != null : !emails.equals(((TypeAheadItem) (obj)).emails))
            {
                return false;
            }
            if (phoneNumbers == null ? ((TypeAheadItem) (obj)).phoneNumbers != null : !phoneNumbers.equals(((TypeAheadItem) (obj)).phoneNumbers))
            {
                return false;
            }
        }
        return true;
    }

    public List getEmails()
    {
        return emails;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getImageUri()
    {
        return imageUri;
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public String getLocation()
    {
        return location;
    }

    public List getPhoneNumbers()
    {
        return phoneNumbers;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUid()
    {
        return uid;
    }

    public String getWebsite()
    {
        return website;
    }

    public int hashCode()
    {
        if (uid != null)
        {
            return uid.hashCode();
        } else
        {
            return 0;
        }
    }

    public boolean isFollowedByMe()
    {
        return followedByMe;
    }

    public boolean isPlaceHolder()
    {
        return itemType == ItemType.CONNECT_FB_PLACEHOLDER || itemType == ItemType.SEARCH_PLACEHOLDER || itemType == ItemType.EMAIL_PLACEHOLDER || itemType == ItemType.EMPTY_PLACEHOLDER;
    }

    public boolean isWebsiteVerified()
    {
        return isVerified;
    }

    public void setFollowedByMe(boolean flag)
    {
        followedByMe = flag;
    }

    public void setIdentifier(String s)
    {
        identifier = s;
    }

    public void setImageUri(String s)
    {
        imageUri = s;
    }

    public void setItem(PinterestJsonObject pinterestjsonobject)
    {
        setItemType(pinterestjsonobject.a("type", ""), pinterestjsonobject.a("tag", ""));
        setUid(pinterestjsonobject.a("id", ""));
        _cls1..SwitchMap.com.pinterest.activity.search.model.TypeAheadItem.ItemType[getItemType().ordinal()];
        JVM INSTR tableswitch 1 10: default 342
    //                   1 96
    //                   2 96
    //                   3 127
    //                   4 164
    //                   5 164
    //                   6 164
    //                   7 263
    //                   8 263
    //                   9 263
    //                   10 263;
           goto _L1 _L2 _L2 _L3 _L4 _L4 _L4 _L5 _L5 _L5 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        setTitle(pinterestjsonobject.a("query", ""));
        setIdentifier(pinterestjsonobject.a("link", ""));
        return;
_L3:
        try
        {
            setTitle(pinterestjsonobject.a("name", ""));
            setIdentifier(pinterestjsonobject.a("url", ""));
            setImageUri(pinterestjsonobject.a("image_thumbnail_url", ""));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PinterestJsonObject pinterestjsonobject)
        {
            pinterestjsonobject.printStackTrace();
            return;
        }
_L4:
        setIdentifier(pinterestjsonobject.a("username", ""));
        setTitle(pinterestjsonobject.a("full_name", ""));
        setImageUri(pinterestjsonobject.a("image_medium_url", ""));
        setFollowedByMe(pinterestjsonobject.a("followed_by_me").booleanValue());
        if (pinterestjsonobject.f("website_url"))
        {
            setWebsite(pinterestjsonobject.a("website_url", null), pinterestjsonobject.a("domain_verified").booleanValue());
        }
        if (pinterestjsonobject.f("location"))
        {
            setLocation(pinterestjsonobject.a("location", null));
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        setUid(pinterestjsonobject.a("id", ""));
        setTitle(pinterestjsonobject.a("name", ""));
        setUid(pinterestjsonobject.a("id", ""));
        setTitle(pinterestjsonobject.a("name", ""));
        if (pinterestjsonobject.f("picture"))
        {
            setImageUri(pinterestjsonobject.c("picture").c("data").a("url", null));
            return;
        }
    }

    public void setItemType(ItemType itemtype)
    {
        itemType = itemtype;
    }

    public void setItemType(String s, String s1)
    {
        if (s.equals("board"))
        {
            itemType = ItemType.BOARD;
            return;
        }
        if (s1.equals("pin_suggestion") || s1.equals("board_suggestion"))
        {
            itemType = ItemType.AUTO_COMPLETE;
            return;
        }
        if (s1.equals("facebook_non_pinner"))
        {
            itemType = ItemType.FACEBOOK_CONTACT;
            return;
        }
        if (s1.equals("mutual_follow"))
        {
            itemType = ItemType.MUTUAL_FOLLOW;
            return;
        }
        if (s1.equals("followee"))
        {
            itemType = ItemType.FOLLOWEE;
            return;
        }
        if (s1.equals("twitter_non_pinner"))
        {
            itemType = ItemType.TWITTER_CONTACT;
            return;
        }
        if (s.equals("yahoo_non_pinner"))
        {
            itemType = ItemType.YAHOO_CONTACT;
            return;
        }
        if (s.equals("google_non_pinner"))
        {
            itemType = ItemType.GOOGLE_CONTACT;
            return;
        }
        if (s1.equals("recent_queries"))
        {
            itemType = ItemType.RECENT_QUERY;
            return;
        }
        if (s1.equals("conversation"))
        {
            itemType = ItemType.CONVERSATION;
            return;
        } else
        {
            itemType = ItemType.PINNER;
            return;
        }
    }

    public void setLocation(String s)
    {
        if (!StringUtils.isEmpty(s))
        {
            location = s;
        }
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setWebsite(String s, boolean flag)
    {
        if (!StringUtils.isEmpty(s))
        {
            website = s;
            isVerified = flag;
        }
    }

    public String toString()
    {
        return title;
    }

    private class ItemType extends Enum
    {

        private static final ItemType $VALUES[];
        public static final ItemType AUTO_COMPLETE;
        public static final ItemType BOARD;
        public static final ItemType CONNECT_FB_PLACEHOLDER;
        public static final ItemType CONVERSATION;
        public static final ItemType EMAIL_CONTACT;
        public static final ItemType EMAIL_PLACEHOLDER;
        public static final ItemType EMPTY_PLACEHOLDER;
        public static final ItemType FACEBOOK_CONTACT;
        public static final ItemType FOLLOWEE;
        public static final ItemType GOOGLE_CONTACT;
        public static final ItemType MUTUAL_FOLLOW;
        public static final ItemType NONE;
        public static final ItemType PHONE_CONTACT;
        public static final ItemType PINNER;
        public static final ItemType RECENT_QUERY;
        public static final ItemType SEARCH_PLACEHOLDER;
        public static final ItemType TWITTER_CONTACT;
        public static final ItemType YAHOO_CONTACT;

        public static ItemType valueOf(String s)
        {
            return (ItemType)Enum.valueOf(com/pinterest/activity/search/model/TypeAheadItem$ItemType, s);
        }

        public static ItemType[] values()
        {
            return (ItemType[])$VALUES.clone();
        }

        static 
        {
            EMPTY_PLACEHOLDER = new ItemType("EMPTY_PLACEHOLDER", 0);
            SEARCH_PLACEHOLDER = new ItemType("SEARCH_PLACEHOLDER", 1);
            CONNECT_FB_PLACEHOLDER = new ItemType("CONNECT_FB_PLACEHOLDER", 2);
            EMAIL_PLACEHOLDER = new ItemType("EMAIL_PLACEHOLDER", 3);
            RECENT_QUERY = new ItemType("RECENT_QUERY", 4);
            AUTO_COMPLETE = new ItemType("AUTO_COMPLETE", 5);
            FACEBOOK_CONTACT = new ItemType("FACEBOOK_CONTACT", 6);
            TWITTER_CONTACT = new ItemType("TWITTER_CONTACT", 7);
            YAHOO_CONTACT = new ItemType("YAHOO_CONTACT", 8);
            GOOGLE_CONTACT = new ItemType("GOOGLE_CONTACT", 9);
            EMAIL_CONTACT = new ItemType("EMAIL_CONTACT", 10);
            PHONE_CONTACT = new ItemType("PHONE_CONTACT", 11);
            PINNER = new ItemType("PINNER", 12);
            MUTUAL_FOLLOW = new ItemType("MUTUAL_FOLLOW", 13);
            FOLLOWEE = new ItemType("FOLLOWEE", 14);
            BOARD = new ItemType("BOARD", 15);
            CONVERSATION = new ItemType("CONVERSATION", 16);
            NONE = new ItemType("NONE", 17);
            $VALUES = (new ItemType[] {
                EMPTY_PLACEHOLDER, SEARCH_PLACEHOLDER, CONNECT_FB_PLACEHOLDER, EMAIL_PLACEHOLDER, RECENT_QUERY, AUTO_COMPLETE, FACEBOOK_CONTACT, TWITTER_CONTACT, YAHOO_CONTACT, GOOGLE_CONTACT, 
                EMAIL_CONTACT, PHONE_CONTACT, PINNER, MUTUAL_FOLLOW, FOLLOWEE, BOARD, CONVERSATION, NONE
            });
        }

        private ItemType(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType = new int[ItemType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.AUTO_COMPLETE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.RECENT_QUERY.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.BOARD.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.PINNER.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.MUTUAL_FOLLOW.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.FOLLOWEE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.FACEBOOK_CONTACT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.TWITTER_CONTACT.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.YAHOO_CONTACT.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[ItemType.GOOGLE_CONTACT.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
