// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.net.Uri;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.Device;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper, Partner

public class User extends Model
{

    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNSPECIFIED = "unspecified";
    public static final String PINTEREST_USER_UID = "424605208526455283";
    private String about;
    private Boolean adsCustomizeFromConversion;
    private Boolean blocked;
    private Integer boardCount;
    private Date createdAt;
    private String email;
    private Boolean emailVerified;
    private Boolean excludeFromSearch;
    private Boolean explicitFollowing;
    private String facebookUrl;
    private String firstName;
    private Integer followersCount;
    private Integer followingCount;
    private String fullName;
    private String gender;
    private Boolean hasPassword;
    private Boolean hideFromNews;
    private Long id;
    private String imageLargeUrl;
    private String imageMediumUrl;
    private String imageSmallUrl;
    private Boolean implicitFollowing;
    private String impressumUrl;
    private Boolean isEmployee;
    private String lastName;
    private Integer likeCount;
    private String location;
    private Partner partner;
    private String partnerUid;
    private Boolean personalizeFromOffsiteBrowsing;
    private Integer pinCount;
    private String pinThumbnailUrls;
    private Boolean publishStream;
    private Boolean publishTimeline;
    private Boolean showImpressum;
    private String twitterUrl;
    private String uid;
    private String username;
    private String website;
    private Boolean websiteVerified;

    public User()
    {
    }

    public User(Long long1)
    {
        id = long1;
    }

    public User(Long long1, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, Boolean boolean1, String s10, String s11, 
            String s12, String s13, String s14, Boolean boolean2, Boolean boolean3, Boolean boolean4, Boolean boolean5, 
            Boolean boolean6, Boolean boolean7, Boolean boolean8, Boolean boolean9, Integer integer, Integer integer1, Integer integer2, 
            Integer integer3, Integer integer4, Date date, Boolean boolean10, Boolean boolean11, Boolean boolean12, String s15, 
            String s16, Boolean boolean13, String s17, Boolean boolean14)
    {
        id = long1;
        uid = s;
        imageSmallUrl = s1;
        imageMediumUrl = s2;
        imageLargeUrl = s3;
        firstName = s4;
        lastName = s5;
        fullName = s6;
        username = s7;
        gender = s8;
        email = s9;
        emailVerified = boolean1;
        about = s10;
        facebookUrl = s11;
        location = s12;
        twitterUrl = s13;
        website = s14;
        websiteVerified = boolean2;
        explicitFollowing = boolean3;
        implicitFollowing = boolean4;
        blocked = boolean5;
        publishTimeline = boolean6;
        publishStream = boolean7;
        isEmployee = boolean8;
        hasPassword = boolean9;
        followingCount = integer;
        followersCount = integer1;
        likeCount = integer2;
        boardCount = integer3;
        pinCount = integer4;
        createdAt = date;
        excludeFromSearch = boolean10;
        hideFromNews = boolean11;
        personalizeFromOffsiteBrowsing = boolean12;
        partnerUid = s15;
        pinThumbnailUrls = s16;
        adsCustomizeFromConversion = boolean13;
        impressumUrl = s17;
        showImpressum = boolean14;
    }

    private static String getThumbnailUrlsEntry(PinterestJsonArray pinterestjsonarray)
    {
        return pinterestjsonarray.a(",");
    }

    public static User make(PinterestJsonObject pinterestjsonobject)
    {
        if (pinterestjsonobject == null)
        {
            return null;
        } else
        {
            return make(pinterestjsonobject, true);
        }
    }

    public static User make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        return make(pinterestjsonobject, flag, true);
    }

    public static User make(PinterestJsonObject pinterestjsonobject, boolean flag, boolean flag1)
    {
        Object obj = null;
        if (pinterestjsonobject != null)
        {
            obj = pinterestjsonobject.c("data");
            if (obj != null)
            {
                pinterestjsonobject = ((PinterestJsonObject) (obj));
            }
            obj = pinterestjsonobject.c("pinterest_user");
            if (obj != null)
            {
                pinterestjsonobject = ((PinterestJsonObject) (obj));
            }
            obj = new User();
            ((User) (obj)).setUid(pinterestjsonobject.a("id", "0"));
            ((User) (obj)).setUsername(pinterestjsonobject.a("username", null));
            ((User) (obj)).setEmail(pinterestjsonobject.a("email", null));
            ((User) (obj)).setFirstName(StringUtils.trimToNull(pinterestjsonobject.a("first_name", "")));
            ((User) (obj)).setLastName(StringUtils.trimToEmpty(pinterestjsonobject.a("last_name", "")));
            ((User) (obj)).setFullName(pinterestjsonobject.a("full_name", null));
            ((User) (obj)).setGender(pinterestjsonobject.a("gender", null));
            ((User) (obj)).setLocation(pinterestjsonobject.a("location", null));
            ((User) (obj)).setAbout(pinterestjsonobject.a("about", null));
            ((User) (obj)).setImageSmallUrl(pinterestjsonobject.a("image_small_url", null));
            ((User) (obj)).setImageMediumUrl(pinterestjsonobject.a("image_medium_url", null));
            ((User) (obj)).setImageLargeUrl(pinterestjsonobject.a("image_large_url", null));
            PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("partner");
            if (pinterestjsonobject.f("is_employee"))
            {
                ((User) (obj)).setIsEmployee(pinterestjsonobject.a("is_employee"));
            }
            if (pinterestjsonobject.f("has_password"))
            {
                ((User) (obj)).setHasPassword(pinterestjsonobject.a("has_password"));
            }
            if (pinterestjsonobject.f("email_verified"))
            {
                ((User) (obj)).setEmailVerified(pinterestjsonobject.a("email_verified"));
            }
            if (pinterestjsonobject.f("explicitly_followed_by_me"))
            {
                ((User) (obj)).setExplicitFollowing(pinterestjsonobject.a("explicitly_followed_by_me"));
            }
            if (pinterestjsonobject.f("implicitly_followed_by_me"))
            {
                ((User) (obj)).setImplicitFollowing(pinterestjsonobject.a("implicitly_followed_by_me"));
            }
            if (pinterestjsonobject.f("blocked_by_me"))
            {
                ((User) (obj)).setBlocked(pinterestjsonobject.a("blocked_by_me"));
            }
            if (pinterestjsonobject.f("domain_verified"))
            {
                ((User) (obj)).setWebsiteVerified(pinterestjsonobject.a("domain_verified"));
            }
            if (pinterestjsonobject.f("follower_count"))
            {
                ((User) (obj)).setFollowersCount(Integer.valueOf(pinterestjsonobject.a("follower_count", 0)));
            }
            if (pinterestjsonobject.f("following_count"))
            {
                ((User) (obj)).setFollowingCount(Integer.valueOf(pinterestjsonobject.a("following_count", 0)));
            }
            if (pinterestjsonobject.f("board_count"))
            {
                ((User) (obj)).setBoardCount(Integer.valueOf(pinterestjsonobject.a("board_count", 0)));
            }
            if (pinterestjsonobject.f("pin_count"))
            {
                ((User) (obj)).setPinCount(Integer.valueOf(pinterestjsonobject.a("pin_count", 0)));
            }
            if (pinterestjsonobject.f("like_count"))
            {
                ((User) (obj)).setLikeCount(Integer.valueOf(pinterestjsonobject.a("like_count", 0)));
            }
            if (pinterestjsonobject.f("created_at"))
            {
                ((User) (obj)).setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", "")));
            }
            if (pinterestjsonobject.f("facebook_url"))
            {
                ((User) (obj)).setFacebookUrl(pinterestjsonobject.a("facebook_url", ""));
            }
            if (pinterestjsonobject.f("twitter_url"))
            {
                ((User) (obj)).setTwitterUrl(pinterestjsonobject.a("twitter_url", ""));
            }
            if (pinterestjsonobject.f("website_url"))
            {
                ((User) (obj)).setWebsite(pinterestjsonobject.a("website_url", ""));
            }
            if (pinterestjsonobject.f("show_impressum"))
            {
                ((User) (obj)).setShowImpressum(pinterestjsonobject.a("show_impressum"));
            }
            if (pinterestjsonobject.f("impressum_url"))
            {
                ((User) (obj)).setImpressumUrl(pinterestjsonobject.a("impressum_url", ""));
            }
            ((User) (obj)).setPinThumbnailUrls(getThumbnailUrlsEntry(pinterestjsonobject.e("pin_thumbnail_urls")));
            if (pinterestjsonobject1 != null)
            {
                pinterestjsonobject = Partner.make(pinterestjsonobject1, flag);
                ((User) (obj)).setPartnerUid(pinterestjsonobject.getUid());
            } else
            {
                pinterestjsonobject = null;
            }
            ((User) (obj)).cachePartner(pinterestjsonobject);
            if (flag1)
            {
                pinterestjsonobject = merge(((User) (obj)));
            } else
            {
                pinterestjsonobject = ((PinterestJsonObject) (obj));
            }
            obj = pinterestjsonobject;
            if (flag)
            {
                ModelHelper.setUser(pinterestjsonobject);
                return pinterestjsonobject;
            }
        }
        return ((User) (obj));
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            User user = make(pinterestjsonarray.c(i), false, false);
            arraylist1.add(user);
            arraylist2.add(user.getUid());
            if (user.getPartner() != null)
            {
                arraylist.add(user.getPartner());
            }
        }

        pinterestjsonarray = mergeAll(arraylist1, ModelHelper.getUsers(arraylist2));
        ModelHelper.setPartners(arraylist);
        ModelHelper.setUsers(pinterestjsonarray);
        return pinterestjsonarray;
    }

    public static User merge(User user)
    {
        if (user == null)
        {
            return null;
        } else
        {
            return merge(user, ModelHelper.getUser(user.getUid()));
        }
    }

    public static User merge(User user, User user1)
    {
        User user2;
        if (user == null)
        {
            user2 = null;
        } else
        {
            user2 = user;
            if (user1 != null)
            {
                if (user.username != null)
                {
                    user1.username = user.username;
                }
                if (user.email != null)
                {
                    user1.email = user.email;
                }
                if (user.emailVerified != null)
                {
                    user1.emailVerified = user.emailVerified;
                }
                if (user.firstName != null)
                {
                    user1.firstName = user.firstName;
                }
                if (user.lastName != null)
                {
                    user1.lastName = user.lastName;
                }
                if (user.fullName != null)
                {
                    user1.fullName = user.fullName;
                }
                if (user.gender != null)
                {
                    user1.gender = user.gender;
                }
                if (user.location != null)
                {
                    user1.location = user.location;
                }
                if (user.about != null)
                {
                    user1.about = user.about;
                }
                if (user.website != null)
                {
                    user1.website = user.website;
                }
                if (user.facebookUrl != null)
                {
                    user1.facebookUrl = user.facebookUrl;
                }
                if (user.twitterUrl != null)
                {
                    user1.twitterUrl = user.twitterUrl;
                }
                if (user.imageSmallUrl != null)
                {
                    user1.imageSmallUrl = user.imageSmallUrl;
                }
                if (user.imageMediumUrl != null)
                {
                    user1.imageMediumUrl = user.imageMediumUrl;
                }
                if (user.imageLargeUrl != null)
                {
                    user1.imageLargeUrl = user.imageLargeUrl;
                }
                if (user.explicitFollowing != null)
                {
                    user1.explicitFollowing = user.explicitFollowing;
                }
                if (user.implicitFollowing != null)
                {
                    user1.implicitFollowing = user.implicitFollowing;
                }
                if (user.blocked != null)
                {
                    user1.blocked = user.blocked;
                }
                if (user.websiteVerified != null)
                {
                    user1.websiteVerified = user.websiteVerified;
                }
                if (user.followersCount != null)
                {
                    user1.followersCount = user.followersCount;
                }
                if (user.followingCount != null)
                {
                    user1.followingCount = user.followingCount;
                }
                if (user.boardCount != null)
                {
                    user1.boardCount = user.boardCount;
                }
                if (user.pinCount != null)
                {
                    user1.pinCount = user.pinCount;
                }
                if (user.likeCount != null)
                {
                    user1.likeCount = user.likeCount;
                }
                if (user.createdAt != null)
                {
                    user1.createdAt = user.createdAt;
                }
                if (user.isEmployee != null)
                {
                    user1.isEmployee = user.isEmployee;
                }
                if (user.hasPassword != null)
                {
                    user1.hasPassword = user.hasPassword;
                }
                if (user.pinThumbnailUrls != null)
                {
                    user1.pinThumbnailUrls = user.pinThumbnailUrls;
                }
                if (user.impressumUrl != null)
                {
                    user1.impressumUrl = user.impressumUrl;
                }
                if (user.showImpressum != null)
                {
                    user1.showImpressum = user.showImpressum;
                }
                if (user.partnerUid != null)
                {
                    user1.partnerUid = user.partnerUid;
                    if (user.partner != null)
                    {
                        user1.partner = user.partner;
                    }
                }
                if (user.publishTimeline != null)
                {
                    user1.publishTimeline = user.publishTimeline;
                }
                if (user.publishStream != null)
                {
                    user1.publishStream = user.publishStream;
                }
                if (user.excludeFromSearch != null)
                {
                    user1.excludeFromSearch = user.excludeFromSearch;
                }
                if (user.hideFromNews != null)
                {
                    user1.hideFromNews = user.hideFromNews;
                }
                if (user.personalizeFromOffsiteBrowsing != null)
                {
                    user1.personalizeFromOffsiteBrowsing = user.personalizeFromOffsiteBrowsing;
                }
                if (user.adsCustomizeFromConversion != null)
                {
                    user1.adsCustomizeFromConversion = user.adsCustomizeFromConversion;
                }
                return user1;
            }
        }
        return user2;
    }

    public static List mergeAll(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            User user = (User)iterator.next();
            int i = list1.indexOf(user);
            if (i != -1)
            {
                list = (User)list1.get(i);
            } else
            {
                list = null;
            }
            arraylist.add(merge(user, list));
        }
        return arraylist;
    }

    public void cachePartner(Partner partner1)
    {
        partner = partner1;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof User) || !((User)obj).getUid().equals(getUid())) 
        {
            return false;
        }
        return true;
    }

    public String getAbout()
    {
        return about;
    }

    public Boolean getAdsCustomizeFromConversion()
    {
        return adsCustomizeFromConversion;
    }

    public Boolean getBlocked()
    {
        return blocked;
    }

    public Integer getBoardCount()
    {
        return boardCount;
    }

    public int getBoardCountDisplay()
    {
        if (boardCount == null || boardCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return boardCount.intValue();
        }
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getEmail()
    {
        return email;
    }

    public Boolean getEmailVerified()
    {
        return emailVerified;
    }

    public Boolean getExcludeFromSearch()
    {
        return excludeFromSearch;
    }

    public Boolean getExplicitFollowing()
    {
        return explicitFollowing;
    }

    public String getFacebookUrl()
    {
        return facebookUrl;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public Integer getFollowersCount()
    {
        return followersCount;
    }

    public int getFollowersCountDisplay()
    {
        if (followersCount == null || followersCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return followersCount.intValue();
        }
    }

    public boolean getFollowing()
    {
        if (explicitFollowing != null && explicitFollowing.booleanValue())
        {
            return true;
        }
        if (implicitFollowing != null)
        {
            return implicitFollowing.booleanValue();
        } else
        {
            return false;
        }
    }

    public Integer getFollowingCount()
    {
        return followingCount;
    }

    public int getFollowingCountDisplay()
    {
        if (followingCount == null || followingCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return followingCount.intValue();
        }
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getGender()
    {
        return gender;
    }

    public Boolean getHasPassword()
    {
        return hasPassword;
    }

    public Boolean getHideFromNews()
    {
        return hideFromNews;
    }

    public Long getId()
    {
        return id;
    }

    public String getImageLargeUrl()
    {
        return imageLargeUrl;
    }

    public String getImageLargeUrlByDpi()
    {
        if (Device.hasBigScreen() && imageLargeUrl != null)
        {
            return imageLargeUrl;
        } else
        {
            return imageMediumUrl;
        }
    }

    public String getImageMediumUrl()
    {
        return imageMediumUrl;
    }

    public String getImageSmallUrl()
    {
        return imageSmallUrl;
    }

    public Boolean getImplicitFollowing()
    {
        return implicitFollowing;
    }

    public String getImpressumUrl()
    {
        return impressumUrl;
    }

    public Boolean getIsEmployee()
    {
        return isEmployee;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Integer getLikeCount()
    {
        return likeCount;
    }

    public int getLikeCountDisplay()
    {
        if (likeCount == null || likeCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return likeCount.intValue();
        }
    }

    public String getLocation()
    {
        return location;
    }

    public Partner getPartner()
    {
        if (partnerUid != null && partner == null)
        {
            partner = ModelHelper.getPartner(partnerUid);
        }
        return partner;
    }

    public String getPartnerUid()
    {
        return partnerUid;
    }

    public Boolean getPersonalizeFromOffsiteBrowsing()
    {
        return personalizeFromOffsiteBrowsing;
    }

    public Integer getPinCount()
    {
        return pinCount;
    }

    public int getPinCountDisplay()
    {
        if (pinCount == null || pinCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return pinCount.intValue();
        }
    }

    public String getPinThumbnailUrls()
    {
        return pinThumbnailUrls;
    }

    public List getPinThumbnailsList()
    {
        if (ModelHelper.isValid(pinThumbnailUrls))
        {
            return Arrays.asList(pinThumbnailUrls.split(","));
        } else
        {
            return new ArrayList();
        }
    }

    public String getPinterestLink()
    {
        return String.format("https://pinterest.com/%s/?source_app=android", new Object[] {
            getUsername()
        });
    }

    public Boolean getPublishStream()
    {
        return publishStream;
    }

    public Boolean getPublishTimeline()
    {
        return publishTimeline;
    }

    public Boolean getShowImpressum()
    {
        return showImpressum;
    }

    public String getTwitterUrl()
    {
        return twitterUrl;
    }

    public String getUid()
    {
        return uid;
    }

    public String getUsername()
    {
        return username;
    }

    public String getWebsite()
    {
        return website;
    }

    public String getWebsiteHost()
    {
        String s1 = getWebsite();
        String s;
        if (s1 == null)
        {
            s = null;
        } else
        {
            Uri uri = Uri.parse(s1);
            s = s1;
            if (uri != null)
            {
                s = s1;
                if (uri != null)
                {
                    s = s1;
                    if (uri.getHost() != null)
                    {
                        return uri.getHost();
                    }
                }
            }
        }
        return s;
    }

    public Boolean getWebsiteVerified()
    {
        return websiteVerified;
    }

    public void setAbout(String s)
    {
        about = s;
    }

    public void setAdsCustomizeFromConversion(Boolean boolean1)
    {
        adsCustomizeFromConversion = boolean1;
    }

    public void setBlocked(Boolean boolean1)
    {
        blocked = boolean1;
    }

    public void setBoardCount(Integer integer)
    {
        boardCount = integer;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setEmailVerified(Boolean boolean1)
    {
        emailVerified = boolean1;
    }

    public void setExcludeFromSearch(Boolean boolean1)
    {
        excludeFromSearch = boolean1;
    }

    public void setExplicitFollowing(Boolean boolean1)
    {
        explicitFollowing = boolean1;
    }

    public void setFacebookUrl(String s)
    {
        facebookUrl = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setFollowersCount(Integer integer)
    {
        followersCount = integer;
    }

    public void setFollowing(boolean flag)
    {
        setImplicitFollowing(Boolean.valueOf(flag));
        setExplicitFollowing(Boolean.valueOf(flag));
    }

    public void setFollowingCount(Integer integer)
    {
        followingCount = integer;
    }

    public void setFullName(String s)
    {
        fullName = s;
    }

    public void setGender(String s)
    {
        gender = s;
    }

    public void setHasPassword(Boolean boolean1)
    {
        hasPassword = boolean1;
    }

    public void setHideFromNews(Boolean boolean1)
    {
        hideFromNews = boolean1;
    }

    public void setId(Long long1)
    {
        id = long1;
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

    public void setImplicitFollowing(Boolean boolean1)
    {
        implicitFollowing = boolean1;
    }

    public void setImpressumUrl(String s)
    {
        impressumUrl = s;
    }

    public void setIsEmployee(Boolean boolean1)
    {
        isEmployee = boolean1;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setLikeCount(Integer integer)
    {
        likeCount = integer;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setPartnerUid(String s)
    {
        partnerUid = s;
    }

    public void setPersonalizeFromOffsiteBrowsing(Boolean boolean1)
    {
        personalizeFromOffsiteBrowsing = boolean1;
    }

    public void setPinCount(Integer integer)
    {
        pinCount = integer;
    }

    public void setPinThumbnailUrls(String s)
    {
        pinThumbnailUrls = s;
    }

    public void setPublishStream(Boolean boolean1)
    {
        publishStream = boolean1;
    }

    public void setPublishTimeline(Boolean boolean1)
    {
        publishTimeline = boolean1;
    }

    public void setShowImpressum(Boolean boolean1)
    {
        showImpressum = boolean1;
    }

    public void setTwitterUrl(String s)
    {
        twitterUrl = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }

    public void setWebsite(String s)
    {
        website = s;
    }

    public void setWebsiteVerified(Boolean boolean1)
    {
        websiteVerified = boolean1;
    }
}
