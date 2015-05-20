// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import android.text.Html;
import android.text.Spanned;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.metadata.article.Article;
import com.pinterest.api.model.metadata.movie.Movie;
import com.pinterest.api.model.metadata.product.Product;
import com.pinterest.api.model.metadata.recipe.Recipe;
import com.pinterest.base.Constants;
import com.pinterest.base.GooglePlayServices;
import com.pinterest.kit.application.Resources;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.api.model:
//            Model, ModelHelper, PinMetadataFactory, Place, 
//            Board, Interest, User, PinMetadata

public class Pin extends Model
{

    private static final String ADD_BOLD_TAG = "<b>%s</b>";
    public static final Map LAUNCHED_RICH_PIN_TYPES = new _cls1();
    public static final int PIN_FEEDBACK_TYPE_HIDE_SINGLE_PIN = 1;
    public static final int PIN_FEEDBACK_TYPE_HIDE_THROUGH_BOARD = 2;
    public static final int PIN_HIDDEN_STATE_COMPLETE_HIDDEN = 2;
    public static final int PIN_HIDDEN_STATE_NOT_HIDDEN = 0;
    public static final int PIN_HIDDEN_STATE_PARTIAL_HIDDEN = 1;
    public static final String STR_FOLLOWED_INTEREST = "FOLLOWED_INTEREST";
    protected static final String STR_PROMOTED = Resources.string(0x7f0e03ba);
    public static final String STR_REALTIME_P2B = "REALTIME_P2B";
    public static final String STR_RECOMMENDED_INTEREST = "RECOMMENDED_INTEREST";
    protected static final String STR_RELATED = Resources.string(0x7f0e03da);
    private static final String bannedDescriptions[] = {
        ".", ","
    };
    private String attrAuthorName;
    private String attrAuthorUrl;
    private String attrProviderIconUrl;
    private String attrProviderName;
    private String attrProviderUrl;
    private String attrTitle;
    private Board board;
    private String boardUid;
    private String cacheableId;
    private String cleanDescription;
    private Integer commentCount;
    private Date createdAt;
    private String description;
    private String domain;
    private String dominantColor;
    private Integer embedHeight;
    private String embedType;
    private String embedUrl;
    private Integer embedWidth;
    private Integer feedbackType;
    private Boolean hasPlace;
    private Integer hiddenState;
    private Long id;
    private Integer imageLargeHeight;
    private String imageLargeUrl;
    private Integer imageLargeWidth;
    private Integer imageMediumHeight;
    private String imageMediumUrl;
    private Integer imageMediumWidth;
    private Integer imageSquareHeight;
    private String imageSquareUrl;
    private Integer imageSquareWidth;
    private String insertionId;
    private Interest interest;
    private String interestUid;
    private Integer likeCount;
    private Boolean liked;
    private String link;
    private PinMetadata metadata;
    private String metadataJson;
    private Board pinnedToBoard;
    private String pinnedToBoardUid;
    private Place place;
    private String placeUid;
    private String promoterUid;
    private User promoterUser;
    private String recommendationBlob;
    private Board recommendationBoard;
    private String recommendationBoardUid;
    private String recommendationReason;
    private Integer repinCount;
    private Boolean repinned;
    private String richIcon;
    private String richSiteName;
    private String richTitle;
    private String richTypeName;
    private String source;
    private String uid;
    private User user;
    private String userUid;
    private User viaUser;
    private String viaUserUid;
    private Boolean video;
    private String viewTags;

    public Pin()
    {
    }

    public Pin(Long long1)
    {
        id = long1;
    }

    public Pin(Long long1, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, Date date, String s7, String s8, String s9, String s10, String s11, 
            String s12, String s13, String s14, String s15, String s16, String s17, String s18, 
            String s19, String s20, String s21, String s22, String s23, Integer integer, Integer integer1, 
            Integer integer2, Integer integer3, Integer integer4, Integer integer5, Integer integer6, Integer integer7, Integer integer8, 
            Integer integer9, Integer integer10, Boolean boolean1, Boolean boolean2, Boolean boolean3, String s24, String s25, 
            String s26, String s27, String s28, String s29, String s30, Boolean boolean4, String s31, 
            String s32, String s33, Integer integer11, Integer integer12, String s34, String s35)
    {
        id = long1;
        uid = s;
        insertionId = s1;
        userUid = s2;
        promoterUid = s3;
        boardUid = s4;
        interestUid = s5;
        pinnedToBoardUid = s6;
        createdAt = date;
        domain = s7;
        description = s8;
        cleanDescription = s9;
        link = s10;
        source = s11;
        viaUserUid = s12;
        attrTitle = s13;
        attrProviderName = s14;
        attrProviderUrl = s15;
        attrAuthorName = s16;
        attrAuthorUrl = s17;
        attrProviderIconUrl = s18;
        imageSquareUrl = s19;
        imageMediumUrl = s20;
        imageLargeUrl = s21;
        embedUrl = s22;
        embedType = s23;
        imageSquareWidth = integer;
        imageSquareHeight = integer1;
        imageMediumWidth = integer2;
        imageMediumHeight = integer3;
        imageLargeWidth = integer4;
        imageLargeHeight = integer5;
        embedWidth = integer6;
        embedHeight = integer7;
        repinCount = integer8;
        likeCount = integer9;
        commentCount = integer10;
        repinned = boolean1;
        liked = boolean2;
        video = boolean3;
        dominantColor = s24;
        richTitle = s25;
        richSiteName = s26;
        richTypeName = s27;
        richIcon = s28;
        metadataJson = s29;
        placeUid = s30;
        hasPlace = boolean4;
        recommendationBlob = s31;
        recommendationReason = s32;
        recommendationBoardUid = s33;
        hiddenState = integer11;
        feedbackType = integer12;
        viewTags = s34;
        cacheableId = s35;
    }

    public static final String cleanDescription(String s)
    {
        String s1;
        if (s != null)
        {
            s = s.replaceAll("\\s", "");
            String as[] = bannedDescriptions;
            int j = as.length;
            int i = 0;
            do
            {
                s1 = s;
                if (i >= j)
                {
                    break;
                }
                s = s.replace(as[i], "");
                i++;
            } while (true);
        } else
        {
            s1 = "";
        }
        return s1;
    }

    public static int getRecommendationUid(String s)
    {
        if (s.equals("REPIN_BOARD"))
        {
            return 1;
        }
        if (s.equals("RECOMMENDED_CATEGORY"))
        {
            return 2;
        }
        if (s.equals("COOKIE_MONSTER"))
        {
            return 3;
        }
        if (s.equals("USER_ACTIVITY"))
        {
            return 4;
        }
        if (s.equals("FOLLOWED_INTEREST"))
        {
            return 5;
        }
        if (s.equals("REALTIME_P2B"))
        {
            return 6;
        }
        if (s.equals("RECOMMENDED_INTEREST"))
        {
            return 7;
        }
        return !s.equals("VISUALLY_SIMILAR") ? 0 : 8;
    }

    public static PinArtifact make(PinterestJsonObject pinterestjsonobject, boolean flag)
    {
        return make(pinterestjsonobject, flag, true);
    }

    public static PinArtifact make(PinterestJsonObject pinterestjsonobject, boolean flag, boolean flag1)
    {
        PinArtifact pinartifact = new PinArtifact();
        Object obj = pinterestjsonobject.c("data");
        if (obj != null)
        {
            pinterestjsonobject = ((PinterestJsonObject) (obj));
        }
        Object obj3 = pinterestjsonobject.c("rich_metadata");
        obj = pinterestjsonobject.c("place");
        Object obj1 = pinterestjsonobject.c("place_summary");
        PinterestJsonObject pinterestjsonobject1 = pinterestjsonobject.c("pinner");
        Object obj2 = pinterestjsonobject.c("promoter");
        Object obj6 = pinterestjsonobject.c("via_pinner");
        PinterestJsonObject pinterestjsonobject3 = pinterestjsonobject.c("board");
        PinterestJsonObject pinterestjsonobject2 = pinterestjsonobject.c("pinned_to_board");
        PinterestJsonObject pinterestjsonobject7 = pinterestjsonobject.c("attribution");
        PinterestJsonObject pinterestjsonobject5 = pinterestjsonobject.c("rich_summary");
        PinterestJsonObject pinterestjsonobject6 = pinterestjsonobject.c("images");
        PinterestJsonObject pinterestjsonobject9 = pinterestjsonobject.c("image_square_size_pixels");
        PinterestJsonObject pinterestjsonobject10 = pinterestjsonobject.c("image_medium_size_pixels");
        PinterestJsonObject pinterestjsonobject11 = pinterestjsonobject.c("image_large_size_pixels");
        PinterestJsonObject pinterestjsonobject12 = pinterestjsonobject.c("embed");
        PinterestJsonObject pinterestjsonobject4 = pinterestjsonobject.c("recommendation_reason");
        Object obj4 = pinterestjsonobject.c("source_interest");
        PinterestJsonArray pinterestjsonarray = pinterestjsonobject.e("view_tags");
        Object obj5 = new Pin();
        ((Pin) (obj5)).setUid(pinterestjsonobject.a("id", "0"));
        ((Pin) (obj5)).setCacheableId(pinterestjsonobject.a("cacheable_id", "0"));
        ((Pin) (obj5)).setInsertionId(pinterestjsonobject.a("insertion_id", null));
        if ("null".equalsIgnoreCase(((Pin) (obj5)).getInsertionId()))
        {
            ((Pin) (obj5)).setInsertionId(null);
        }
        ((Pin) (obj5)).setCreatedAt(ModelHelper.stringToDate(pinterestjsonobject.a("created_at", null)));
        ((Pin) (obj5)).setDomain(pinterestjsonobject.a("domain", null));
        ((Pin) (obj5)).setDescription(pinterestjsonobject.a("description", null));
        ((Pin) (obj5)).setCleanDescription(cleanDescription(((Pin) (obj5)).getDescription()));
        ((Pin) (obj5)).setLink(pinterestjsonobject.a("tracked_link", null));
        if (((Pin) (obj5)).getLink() == null)
        {
            ((Pin) (obj5)).setLink(pinterestjsonobject.a("link", null));
        }
        if (pinterestjsonobject7 != null)
        {
            ((Pin) (obj5)).setAttrAuthorName(pinterestjsonobject7.a("author_name", null));
            ((Pin) (obj5)).setAttrAuthorUrl(pinterestjsonobject7.a("author_url", null));
            ((Pin) (obj5)).setAttrProviderIconUrl(pinterestjsonobject7.a("provider_icon_url", null));
            ((Pin) (obj5)).setAttrProviderName(pinterestjsonobject7.a("provider_name", null));
            ((Pin) (obj5)).setAttrProviderUrl(pinterestjsonobject7.a("url", null));
            ((Pin) (obj5)).setAttrTitle(pinterestjsonobject7.a("title", null));
        }
        ((Pin) (obj5)).setImageSquareUrl(pinterestjsonobject.a("image_square_url", null));
        ((Pin) (obj5)).setImageMediumUrl(pinterestjsonobject.a("image_medium_url", null));
        ((Pin) (obj5)).setImageLargeUrl(pinterestjsonobject.a("image_large_url", null));
        if (pinterestjsonobject9 != null)
        {
            ((Pin) (obj5)).setImageSquareWidth(Integer.valueOf(pinterestjsonobject9.a("width", 0)));
            ((Pin) (obj5)).setImageSquareHeight(Integer.valueOf(pinterestjsonobject9.a("height", 0)));
        }
        if (pinterestjsonobject10 != null)
        {
            ((Pin) (obj5)).setImageMediumWidth(Integer.valueOf(pinterestjsonobject10.a("width", 0)));
            ((Pin) (obj5)).setImageMediumHeight(Integer.valueOf(pinterestjsonobject10.a("height", 0)));
            if (((Pin) (obj5)).getImageMediumHeight().intValue() > 2048)
            {
                ((Pin) (obj5)).setImageMediumWidth(Integer.valueOf(Math.round((2048F / (float)((Pin) (obj5)).getImageMediumHeight().intValue()) * (float)((Pin) (obj5)).getImageMediumWidth().intValue())));
                ((Pin) (obj5)).setImageMediumHeight(Integer.valueOf(2048));
            }
        }
        if (pinterestjsonobject11 != null)
        {
            ((Pin) (obj5)).setImageLargeWidth(Integer.valueOf(pinterestjsonobject11.a("width", 0)));
            ((Pin) (obj5)).setImageLargeHeight(Integer.valueOf(pinterestjsonobject11.a("height", 0)));
        }
        if (pinterestjsonobject12 != null)
        {
            ((Pin) (obj5)).setEmbedType(pinterestjsonobject12.a("type", ""));
            ((Pin) (obj5)).setEmbedUrl(pinterestjsonobject12.a("src", ""));
            ((Pin) (obj5)).setEmbedWidth(Integer.valueOf(pinterestjsonobject12.a("width", 0)));
            ((Pin) (obj5)).setEmbedHeight(Integer.valueOf(pinterestjsonobject12.a("height", 0)));
        }
        if (pinterestjsonobject6 != null)
        {
            PinterestJsonObject pinterestjsonobject8 = pinterestjsonobject6.c("90x90");
            if (pinterestjsonobject8 != null)
            {
                ((Pin) (obj5)).setImageSquareUrl(pinterestjsonobject8.a("url", ""));
                ((Pin) (obj5)).setImageSquareWidth(Integer.valueOf(pinterestjsonobject8.a("width", 0)));
                ((Pin) (obj5)).setImageSquareHeight(Integer.valueOf(pinterestjsonobject8.a("height", 0)));
            }
            pinterestjsonobject8 = pinterestjsonobject6.c("136x136");
            if (pinterestjsonobject8 != null)
            {
                ((Pin) (obj5)).setImageSquareUrl(pinterestjsonobject8.a("url", ""));
                ((Pin) (obj5)).setImageSquareWidth(Integer.valueOf(pinterestjsonobject8.a("width", 0)));
                ((Pin) (obj5)).setImageSquareHeight(Integer.valueOf(pinterestjsonobject8.a("height", 0)));
            }
            pinterestjsonobject8 = pinterestjsonobject6.c("200x");
            if (pinterestjsonobject8 != null)
            {
                ((Pin) (obj5)).setImageMediumUrl(pinterestjsonobject8.a("url", ""));
                ((Pin) (obj5)).setImageMediumWidth(Integer.valueOf(pinterestjsonobject8.a("width", 0)));
                ((Pin) (obj5)).setImageMediumHeight(Integer.valueOf(pinterestjsonobject8.a("height", 0)));
            }
            pinterestjsonobject8 = pinterestjsonobject6.c("236x");
            if (pinterestjsonobject8 != null)
            {
                ((Pin) (obj5)).setImageMediumUrl(pinterestjsonobject8.a("url", ""));
                ((Pin) (obj5)).setImageMediumWidth(Integer.valueOf(pinterestjsonobject8.a("width", 0)));
                ((Pin) (obj5)).setImageMediumHeight(Integer.valueOf(pinterestjsonobject8.a("height", 0)));
            }
            pinterestjsonobject8 = pinterestjsonobject6.c("550x");
            if (pinterestjsonobject8 != null)
            {
                ((Pin) (obj5)).setImageLargeUrl(pinterestjsonobject8.a("url", ""));
                ((Pin) (obj5)).setImageLargeWidth(Integer.valueOf(pinterestjsonobject8.a("width", 0)));
                ((Pin) (obj5)).setImageLargeHeight(Integer.valueOf(pinterestjsonobject8.a("height", 0)));
            }
            pinterestjsonobject6 = pinterestjsonobject6.c("736x");
            if (pinterestjsonobject6 != null)
            {
                ((Pin) (obj5)).setImageLargeUrl(pinterestjsonobject6.a("url", ""));
                ((Pin) (obj5)).setImageLargeWidth(Integer.valueOf(pinterestjsonobject6.a("width", 0)));
                ((Pin) (obj5)).setImageLargeHeight(Integer.valueOf(pinterestjsonobject6.a("height", 0)));
            }
        }
        if (pinterestjsonobject.f("repin_count"))
        {
            ((Pin) (obj5)).setRepinCount(Integer.valueOf(pinterestjsonobject.a("repin_count", 0)));
        }
        if (pinterestjsonobject.f("like_count"))
        {
            ((Pin) (obj5)).setLikeCount(Integer.valueOf(pinterestjsonobject.a("like_count", 0)));
        }
        if (pinterestjsonobject.f("comment_count"))
        {
            ((Pin) (obj5)).setCommentCount(Integer.valueOf(pinterestjsonobject.a("comment_count", 0)));
        }
        if (pinterestjsonobject.f("is_repin"))
        {
            ((Pin) (obj5)).setRepinned(pinterestjsonobject.a("is_repin", Boolean.valueOf(false)));
        }
        if (pinterestjsonobject.f("liked_by_me"))
        {
            ((Pin) (obj5)).setLiked(pinterestjsonobject.a("liked_by_me", Boolean.valueOf(false)));
        }
        if (pinterestjsonobject.f("is_video"))
        {
            ((Pin) (obj5)).setVideo(pinterestjsonobject.a("is_video", Boolean.valueOf(false)));
        }
        ((Pin) (obj5)).setDominantColor(pinterestjsonobject.a("dominant_color", "").replace("null", ""));
        if (pinterestjsonobject5 != null)
        {
            ((Pin) (obj5)).setRichTitle(pinterestjsonobject5.a("display_name", null));
            ((Pin) (obj5)).setRichSiteName(pinterestjsonobject5.a("site_name", null));
            ((Pin) (obj5)).setRichTypeName(pinterestjsonobject5.a("type_name", null));
            int i;
            if (pinterestjsonobject5.f("favicon_link"))
            {
                ((Pin) (obj5)).setRichIcon(pinterestjsonobject5.a("favicon_link", null));
            } else
            {
                ((Pin) (obj5)).setRichIcon(pinterestjsonobject5.a("apple_touch_icon_link", null));
            }
        }
        if (obj3 != null)
        {
            ((Pin) (obj5)).setMetadataJson(((PinterestJsonObject) (obj3)).toString());
            ((Pin) (obj5)).cacheMetadata(PinMetadataFactory.make(((Pin) (obj5)), ((PinterestJsonObject) (obj3))));
        }
        if (obj != null || obj1 != null)
        {
            if (obj != null)
            {
                pinterestjsonobject = ((PinterestJsonObject) (obj));
            } else
            {
                pinterestjsonobject = ((PinterestJsonObject) (obj1));
            }
            obj3 = Place.make(pinterestjsonobject);
            ((Pin) (obj5)).setPlaceUid(((Place) (obj3)).getUid());
            ((Pin) (obj5)).setHasPlace(Boolean.valueOf(true));
            ((Pin) (obj5)).cachePlace(((Place) (obj3)));
        } else
        {
            ((Pin) (obj5)).setHasPlace(Boolean.valueOf(false));
            obj3 = null;
        }
        if (pinterestjsonobject4 != null)
        {
            ((Pin) (obj5)).setRecommendationBlob(pinterestjsonobject4.toString());
            ((Pin) (obj5)).setRecommendationReason(pinterestjsonobject4.a("reason", ""));
            if (!ModelHelper.isValid(((Pin) (obj5)).getRecommendationReason()))
            {
                ((Pin) (obj5)).setRecommendationReason(null);
            }
            pinterestjsonobject = pinterestjsonobject4.c("board");
            if (pinterestjsonobject != null)
            {
                pinterestjsonobject = Board.make(pinterestjsonobject, false, flag1).getBoard();
                ((Pin) (obj5)).setRecommendationBoardUid(pinterestjsonobject.getUid());
                ((Pin) (obj5)).cacheRecommendationBoard(pinterestjsonobject);
            }
        }
        if (obj4 != null)
        {
            obj4 = Interest.make(((PinterestJsonObject) (obj4)), false);
            ((Pin) (obj5)).setInterestUid(((Interest) (obj4)).getUid());
            ((Pin) (obj5)).cacheInterest(((Interest) (obj4)));
        } else
        {
            obj4 = null;
        }
        obj = null;
        if (pinterestjsonobject3 != null)
        {
            obj = Board.make(pinterestjsonobject3, false, flag1).getBoard();
            ((Pin) (obj5)).setBoardUid(((Board) (obj)).getUid());
            ((Pin) (obj5)).cacheBoard(((Board) (obj)));
        }
        if (pinterestjsonobject2 != null)
        {
            pinterestjsonobject = Board.make(pinterestjsonobject2, false, flag1).getBoard();
            ((Pin) (obj5)).setPinnedToBoardUid(pinterestjsonobject.getUid());
            ((Pin) (obj5)).cachePinnedToBoard(pinterestjsonobject);
        }
        pinterestjsonobject = null;
        if (pinterestjsonobject1 != null)
        {
            pinterestjsonobject = User.make(pinterestjsonobject1, false, flag1);
            ((Pin) (obj5)).setUserUid(pinterestjsonobject.getUid());
            ((Pin) (obj5)).cacheUser(pinterestjsonobject);
        }
        obj1 = null;
        if (obj2 != null)
        {
            obj2 = User.make(((PinterestJsonObject) (obj2)), false, flag1);
            obj1 = obj2;
            if (((User) (obj2)).getFullName() == null)
            {
                obj1 = pinterestjsonobject;
            }
            ((Pin) (obj5)).setPromoterUid(((User) (obj1)).getUid());
            ((Pin) (obj5)).cachePromoterUser(((User) (obj1)));
        }
        obj2 = null;
        if (obj6 != null)
        {
            obj2 = User.make(((PinterestJsonObject) (obj6)), false, flag1);
            ((Pin) (obj5)).setViaUserUid(((User) (obj2)).getUid());
            ((Pin) (obj5)).cacheViaUser(((User) (obj2)));
        }
        if (flag1)
        {
            obj6 = merge(((Pin) (obj5)));
            obj = Board.merge(((Board) (obj)));
            pinterestjsonobject = User.merge(pinterestjsonobject);
            obj5 = User.merge(((User) (obj1)));
            obj2 = User.merge(((User) (obj2)));
            obj1 = obj;
            obj = obj6;
        } else
        {
            Object obj8 = obj;
            Object obj7 = obj1;
            obj = obj5;
            obj1 = obj8;
            obj5 = obj7;
        }
        obj6 = new StringBuilder();
        for (i = 0; i < pinterestjsonarray.a(); i++)
        {
            ((StringBuilder) (obj6)).append(pinterestjsonarray.b(i).a("id", ""));
            ((StringBuilder) (obj6)).append(",");
            ((StringBuilder) (obj6)).append(pinterestjsonarray.b(i).a("url", ""));
            ((StringBuilder) (obj6)).append(",,");
        }

        if (((StringBuilder) (obj6)).length() > 0)
        {
            ((StringBuilder) (obj6)).setLength(((StringBuilder) (obj6)).length() - 1);
            ((Pin) (obj)).setViewTags(((StringBuilder) (obj6)).toString());
        }
        pinartifact.setPin(((Pin) (obj)));
        pinartifact.setBoard(((Board) (obj1)));
        pinartifact.setUser(pinterestjsonobject);
        pinartifact.setPromoterUser(((User) (obj5)));
        pinartifact.setViaUser(((User) (obj2)));
        pinartifact.setPlace(((Place) (obj3)));
        pinartifact.setSourceInterest(((Interest) (obj4)));
        if (flag)
        {
            if (pinartifact.getPin() != null)
            {
                ModelHelper.setPin(pinartifact.getPin());
            }
            if (pinartifact.getBoard() != null)
            {
                ModelHelper.setBoard(pinartifact.getBoard());
            }
            if (pinartifact.getRecommendationBoard() != null)
            {
                ModelHelper.setBoard(pinartifact.getRecommendationBoard());
            }
            if (pinartifact.getUser() != null)
            {
                ModelHelper.setUser(pinartifact.getUser());
                if (pinartifact.getUser().getPartner() != null)
                {
                    ModelHelper.setPartner(pinartifact.getUser().getPartner());
                }
            }
            if (pinartifact.getPromoterUser() != null)
            {
                ModelHelper.setUser(pinartifact.getPromoterUser());
                if (pinartifact.getPromoterUser().getPartner() != null)
                {
                    ModelHelper.setPartner(pinartifact.getPromoterUser().getPartner());
                }
            }
            if (pinartifact.getViaUser() != null)
            {
                ModelHelper.setUser(pinartifact.getViaUser());
                if (pinartifact.getViaUser().getPartner() != null)
                {
                    ModelHelper.setPartner(pinartifact.getViaUser().getPartner());
                }
            }
            if (pinartifact.getPlace() != null)
            {
                ModelHelper.setPlace(pinartifact.getPlace());
            }
        }
        return pinartifact;
    }

    public static Pin make(PinterestJsonObject pinterestjsonobject)
    {
        return make(pinterestjsonobject, true).getPin();
    }

    public static List makeAll(PinterestJsonArray pinterestjsonarray)
    {
        ArrayList arraylist4 = new ArrayList();
        Object obj3 = new ArrayList();
        Object obj2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        Object obj1 = new ArrayList();
        Object obj = new ArrayList();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        int j = pinterestjsonarray.a();
        for (int i = 0; i < j; i++)
        {
            PinArtifact pinartifact = make(pinterestjsonarray.c(i), false, false);
            arraylist3.add(pinartifact.getPin());
            arraylist4.add(pinartifact.getPin().getUid());
            if (pinartifact.getBoard() != null)
            {
                ((List) (obj1)).add(pinartifact.getBoard());
                ((List) (obj3)).add(pinartifact.getBoard().getUid());
            }
            if (pinartifact.getRecommendationBoard() != null)
            {
                ((List) (obj1)).add(pinartifact.getRecommendationBoard());
                ((List) (obj3)).add(pinartifact.getRecommendationBoard().getUid());
            }
            if (pinartifact.getUser() != null)
            {
                ((List) (obj)).add(pinartifact.getUser());
                ((List) (obj2)).add(pinartifact.getUser().getUid());
                if (pinartifact.getUser().getPartner() != null)
                {
                    arraylist.add(pinartifact.getUser().getPartner());
                }
            }
            if (pinartifact.getPromoterUser() != null)
            {
                ((List) (obj)).add(pinartifact.getPromoterUser());
                ((List) (obj2)).add(pinartifact.getPromoterUser().getUid());
                if (pinartifact.getPromoterUser().getPartner() != null)
                {
                    arraylist.add(pinartifact.getPromoterUser().getPartner());
                }
            }
            if (pinartifact.getViaUser() != null)
            {
                ((List) (obj)).add(pinartifact.getViaUser());
                ((List) (obj2)).add(pinartifact.getViaUser().getUid());
                if (pinartifact.getViaUser().getPartner() != null)
                {
                    arraylist.add(pinartifact.getViaUser().getPartner());
                }
            }
            if (pinartifact.getPlace() != null)
            {
                arraylist1.add(pinartifact.getPlace());
            }
            if (pinartifact.getSourceInterest() != null)
            {
                arraylist2.add(pinartifact.getSourceInterest());
            }
        }

        pinterestjsonarray = ModelHelper.getPins(arraylist4);
        obj3 = ModelHelper.getBoards(((List) (obj3)));
        obj2 = ModelHelper.getUsers(((List) (obj2)));
        pinterestjsonarray = mergeAll(arraylist3, pinterestjsonarray);
        obj1 = Board.mergeAll(((List) (obj1)), ((List) (obj3)));
        obj = User.mergeAll(((List) (obj)), ((List) (obj2)));
        ModelHelper.setPins(pinterestjsonarray);
        ModelHelper.setBoards(((List) (obj1)));
        ModelHelper.setPartners(arraylist);
        ModelHelper.setUsers(((List) (obj)));
        ModelHelper.setPlaces(arraylist1);
        ModelHelper.setInterests(arraylist2);
        return pinterestjsonarray;
    }

    public static Pin merge(Pin pin)
    {
        if (pin == null)
        {
            return null;
        } else
        {
            return merge(pin, ModelHelper.getPin(pin.getUid()));
        }
    }

    public static Pin merge(Pin pin, Pin pin1)
    {
        Pin pin2;
        if (pin == null)
        {
            pin2 = null;
        } else
        {
            pin2 = pin;
            if (pin1 != null)
            {
                if (pin.insertionId != null)
                {
                    pin1.insertionId = pin.insertionId;
                }
                if (pin.userUid != null)
                {
                    pin1.userUid = pin.userUid;
                    if (pin.user != null)
                    {
                        pin1.cacheUser(pin.user);
                    }
                }
                if (pin.boardUid != null)
                {
                    pin1.boardUid = pin.boardUid;
                    if (pin.board != null)
                    {
                        pin1.cacheBoard(pin.board);
                    }
                }
                if (pin.interestUid != null)
                {
                    pin1.interestUid = pin.interestUid;
                    if (pin.interest != null)
                    {
                        pin1.cacheInterest(pin.interest);
                    }
                }
                if (pin.promoterUid != null)
                {
                    pin1.promoterUid = pin.promoterUid;
                    if (pin.promoterUser != null)
                    {
                        pin1.cachePromoterUser(pin.promoterUser);
                    }
                }
                if (pin.pinnedToBoardUid != null)
                {
                    pin1.pinnedToBoardUid = pin.pinnedToBoardUid;
                    if (pin.pinnedToBoard != null)
                    {
                        pin1.cachePinnedToBoard(pin.pinnedToBoard);
                    }
                }
                if (pin.createdAt != null)
                {
                    pin1.createdAt = pin.createdAt;
                }
                if (pin.domain != null)
                {
                    pin1.domain = pin.domain;
                }
                if (pin.description != null)
                {
                    pin1.description = pin.description;
                }
                if (pin.cleanDescription != null)
                {
                    pin1.cleanDescription = pin.cleanDescription;
                }
                if (pin.link != null)
                {
                    pin1.link = pin.link;
                }
                if (pin.recommendationBoardUid != null)
                {
                    pin1.recommendationBoardUid = pin.recommendationBoardUid;
                    if (pin.recommendationBoard != null)
                    {
                        pin1.cacheRecommendationBoard(pin.recommendationBoard);
                    }
                }
                if (pin.recommendationBlob != null)
                {
                    pin1.recommendationBlob = pin.recommendationBlob;
                }
                if (pin.recommendationReason != null)
                {
                    pin1.recommendationReason = pin.recommendationReason;
                }
                if (pin.source != null)
                {
                    pin1.source = pin.source;
                }
                if (pin.viaUserUid != null)
                {
                    pin1.viaUserUid = pin.viaUserUid;
                    if (pin.viaUser != null)
                    {
                        pin1.cacheViaUser(pin.viaUser);
                    }
                }
                if (pin.attrTitle != null)
                {
                    pin1.attrTitle = pin.attrTitle;
                }
                if (pin.attrProviderName != null)
                {
                    pin1.attrProviderName = pin.attrProviderName;
                }
                if (pin.attrProviderUrl != null)
                {
                    pin1.attrProviderUrl = pin.attrProviderUrl;
                }
                if (pin.attrAuthorName != null)
                {
                    pin1.attrAuthorName = pin.attrAuthorName;
                }
                if (pin.attrAuthorUrl != null)
                {
                    pin1.attrAuthorUrl = pin.attrAuthorUrl;
                }
                if (pin.attrProviderIconUrl != null)
                {
                    pin1.attrProviderIconUrl = pin.attrProviderIconUrl;
                }
                if (pin.imageSquareUrl != null)
                {
                    pin1.imageSquareUrl = pin.imageSquareUrl;
                }
                if (pin.imageMediumUrl != null)
                {
                    pin1.imageMediumUrl = pin.imageMediumUrl;
                }
                if (pin.imageLargeUrl != null)
                {
                    pin1.imageLargeUrl = pin.imageLargeUrl;
                }
                if (pin.embedType != null)
                {
                    pin1.embedType = pin.embedType;
                }
                if (pin.embedUrl != null)
                {
                    pin1.embedUrl = pin.embedUrl;
                }
                if (pin.imageSquareWidth != null)
                {
                    pin1.imageSquareWidth = pin.imageSquareWidth;
                }
                if (pin.imageSquareHeight != null)
                {
                    pin1.imageSquareHeight = pin.imageSquareHeight;
                }
                if (pin.imageMediumWidth != null)
                {
                    pin1.imageMediumWidth = pin.imageMediumWidth;
                }
                if (pin.imageMediumHeight != null)
                {
                    pin1.imageMediumHeight = pin.imageMediumHeight;
                }
                if (pin.imageLargeWidth != null)
                {
                    pin1.imageLargeWidth = pin.imageLargeWidth;
                }
                if (pin.imageLargeHeight != null)
                {
                    pin1.imageLargeHeight = pin.imageLargeHeight;
                }
                if (pin.embedWidth != null)
                {
                    pin1.embedWidth = pin.embedWidth;
                }
                if (pin.embedHeight != null)
                {
                    pin1.embedHeight = pin.embedHeight;
                }
                if (pin.repinCount != null)
                {
                    pin1.repinCount = pin.repinCount;
                }
                if (pin.likeCount != null)
                {
                    pin1.likeCount = pin.likeCount;
                }
                if (pin.commentCount != null)
                {
                    pin1.commentCount = pin.commentCount;
                }
                if (pin.repinned != null)
                {
                    pin1.repinned = pin.repinned;
                }
                if (pin.liked != null)
                {
                    pin1.liked = pin.liked;
                }
                if (pin.video != null)
                {
                    pin1.video = pin.video;
                }
                if (pin.dominantColor != null)
                {
                    pin1.dominantColor = pin.dominantColor;
                }
                if (pin.richTitle != null)
                {
                    pin1.richTitle = pin.richTitle;
                }
                if (pin.richSiteName != null)
                {
                    pin1.richSiteName = pin.richSiteName;
                }
                if (pin.richTypeName != null)
                {
                    pin1.richTypeName = pin.richTypeName;
                }
                if (pin.richIcon != null)
                {
                    pin1.richIcon = pin.richIcon;
                }
                if (pin.metadataJson != null)
                {
                    pin1.metadataJson = pin.metadataJson;
                    if (pin.metadata != null)
                    {
                        pin1.cacheMetadata(pin.metadata);
                    }
                }
                if (pin.hasPlace != null)
                {
                    pin1.placeUid = pin.placeUid;
                    pin1.hasPlace = pin.hasPlace;
                    if (pin.place != null)
                    {
                        pin1.cachePlace(pin.place);
                    }
                }
                if (pin.hiddenState != null)
                {
                    pin1.hiddenState = pin.hiddenState;
                }
                if (pin.feedbackType != null)
                {
                    pin1.feedbackType = pin.feedbackType;
                }
                if (pin.viewTags != null)
                {
                    pin1.viewTags = pin.viewTags;
                }
                if (pin.cacheableId != null)
                {
                    pin1.cacheableId = pin.cacheableId;
                }
                return pin1;
            }
        }
        return pin2;
    }

    public static List mergeAll(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Pin pin = (Pin)iterator.next();
            int i = list1.indexOf(pin);
            if (i != -1)
            {
                list = (Pin)list1.get(i);
            } else
            {
                list = null;
            }
            arraylist.add(merge(pin, list));
        }
        return arraylist;
    }

    public void cacheBoard(Board board1)
    {
        board = board1;
    }

    public void cacheInterest(Interest interest1)
    {
        interest = interest1;
    }

    public void cacheMetadata(PinMetadata pinmetadata)
    {
        metadata = pinmetadata;
    }

    public void cachePinnedToBoard(Board board1)
    {
        pinnedToBoard = board1;
    }

    public void cachePlace(Place place1)
    {
        place = place1;
    }

    public void cachePromoterUser(User user1)
    {
        promoterUser = user1;
    }

    public void cacheRecommendationBoard(Board board1)
    {
        recommendationBoard = board1;
    }

    public void cacheUser(User user1)
    {
        user = user1;
    }

    public void cacheViaUser(User user1)
    {
        viaUser = user1;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Pin) || !((Pin)obj).getUid().equals(getUid())) 
        {
            return false;
        }
        return true;
    }

    public String getAttrAuthorName()
    {
        return attrAuthorName;
    }

    public String getAttrAuthorUrl()
    {
        return attrAuthorUrl;
    }

    public String getAttrProviderIconUrl()
    {
        return attrProviderIconUrl;
    }

    public String getAttrProviderName()
    {
        return attrProviderName;
    }

    public String getAttrProviderUrl()
    {
        return attrProviderUrl;
    }

    public String getAttrTitle()
    {
        return attrTitle;
    }

    public String getAttrUrl()
    {
        if (ModelHelper.isValid(attrAuthorUrl))
        {
            return attrAuthorUrl;
        } else
        {
            return attrProviderUrl;
        }
    }

    public String getAttribution()
    {
        return getAttributionHtml().toString();
    }

    public Spanned getAttributionHtml()
    {
        if (hasAttribution())
        {
            if (ModelHelper.isValid(getAttrAuthorName()))
            {
                return Html.fromHtml(String.format(Resources.string(0x7f0e035e, new Object[] {
                    "<b>%s</b>", "<b>%s</b>"
                }), new Object[] {
                    getAttrAuthorName(), getAttrProviderName()
                }));
            } else
            {
                return Html.fromHtml(String.format(Resources.string(0x7f0e0360, new Object[] {
                    "<b>%s</b>"
                }), new Object[] {
                    getAttrProviderName()
                }));
            }
        } else
        {
            return Html.fromHtml("");
        }
    }

    public Board getBoard()
    {
        if (board == null || !board.getUid().equals(getBoardUid()))
        {
            board = ModelHelper.getBoard(getBoardUid());
        }
        return board;
    }

    public String getBoardUid()
    {
        return boardUid;
    }

    public String getCacheableId()
    {
        return cacheableId;
    }

    public String getCleanDescription()
    {
        return cleanDescription;
    }

    public String getClickThroughUrl()
    {
        String s1 = getLink();
        String s = s1;
        if (StringUtils.isBlank(s1))
        {
            String s2 = getImageLargeUrl();
            s = s2;
            if (StringUtils.isBlank(s2))
            {
                s = getImageMediumUrl();
            }
        }
        return s;
    }

    public int getCloseUpImageHeight()
    {
        if (getImageLargeHeight().intValue() > 2048)
        {
            return getImageMediumHeight().intValue();
        } else
        {
            return getImageLargeHeight().intValue();
        }
    }

    public String getCloseUpImageUrl()
    {
        if (getImageLargeHeight().intValue() > 2048)
        {
            return getImageMediumUrl();
        } else
        {
            return getImageLargeUrl();
        }
    }

    public int getCloseUpImageWidth()
    {
        if (getImageLargeHeight().intValue() > 2048)
        {
            return getImageMediumWidth().intValue();
        } else
        {
            return getImageLargeWidth().intValue();
        }
    }

    public Integer getCommentCount()
    {
        return commentCount;
    }

    public int getCommentCountDisplay()
    {
        if (commentCount == null || commentCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return commentCount.intValue();
        }
    }

    public List getComments()
    {
        return ModelHelper.getPinComments(id);
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDomain()
    {
        return domain;
    }

    public String getDominantColor()
    {
        return dominantColor;
    }

    public Integer getEmbedHeight()
    {
        return embedHeight;
    }

    public String getEmbedType()
    {
        return embedType;
    }

    public String getEmbedUrl()
    {
        return embedUrl;
    }

    public Integer getEmbedWidth()
    {
        return embedWidth;
    }

    public Integer getFeedbackType()
    {
        return feedbackType;
    }

    public Boolean getHasPlace()
    {
        return hasPlace;
    }

    public Integer getHiddenState()
    {
        return hiddenState;
    }

    public Long getId()
    {
        return id;
    }

    public Integer getImageLargeHeight()
    {
        return imageLargeHeight;
    }

    public String getImageLargeUrl()
    {
        return imageLargeUrl;
    }

    public Integer getImageLargeWidth()
    {
        return imageLargeWidth;
    }

    public Integer getImageMediumHeight()
    {
        return imageMediumHeight;
    }

    public String getImageMediumUrl()
    {
        return imageMediumUrl;
    }

    public Integer getImageMediumWidth()
    {
        return imageMediumWidth;
    }

    public Integer getImageSquareHeight()
    {
        return imageSquareHeight;
    }

    public String getImageSquareUrl()
    {
        return imageSquareUrl;
    }

    public Integer getImageSquareWidth()
    {
        return imageSquareWidth;
    }

    public String getInsertionId()
    {
        return insertionId;
    }

    public Interest getInterest()
    {
        if (interest == null || !interest.getUid().equals(getInterestUid()))
        {
            interest = ModelHelper.getInterest(getInterestUid());
        }
        return interest;
    }

    public String getInterestUid()
    {
        return interestUid;
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

    public Boolean getLiked()
    {
        return liked;
    }

    public String getLink()
    {
        return link;
    }

    public HashMap getLoggingAuxData()
    {
        return getLoggingAuxData(-1);
    }

    public HashMap getLoggingAuxData(int i)
    {
        HashMap hashmap1 = new HashMap(2);
        if (ModelHelper.isValid(getInterestUid()))
        {
            hashmap1.put("interest_id", getInterestUid());
        }
        if (i >= 0)
        {
            hashmap1.put("grid_index", String.valueOf(i));
        }
        HashMap hashmap = hashmap1;
        if (hashmap1.isEmpty())
        {
            hashmap = null;
        }
        return hashmap;
    }

    public PinMetadata getMetadata()
    {
        if (metadata == null && metadataJson != null)
        {
            metadata = PinMetadataFactory.make(this, new PinterestJsonObject(metadataJson));
        }
        return metadata;
    }

    public String getMetadataJson()
    {
        return metadataJson;
    }

    public Board getPinnedToBoard()
    {
        if (pinnedToBoard == null && ModelHelper.isValid(getPinnedToBoardUid()))
        {
            pinnedToBoard = ModelHelper.getBoard(getPinnedToBoardUid());
        }
        return pinnedToBoard;
    }

    public String getPinnedToBoardUid()
    {
        return pinnedToBoardUid;
    }

    public String getPinterestLink()
    {
        return String.format("https://pinterest.com/pin/%s/?source_app=android", new Object[] {
            getUid()
        });
    }

    public Place getPlace()
    {
        if (hasPlace == Boolean.TRUE && place == null)
        {
            place = ModelHelper.getPlace(getPlaceUid());
        }
        return place;
    }

    public String getPlaceUid()
    {
        return placeUid;
    }

    public String getPromoterUid()
    {
        return promoterUid;
    }

    public User getPromoterUser()
    {
        if (promoterUser == null)
        {
            promoterUser = ModelHelper.getUser(getPromoterUid());
        }
        return promoterUser;
    }

    public String getRecommendationBlob()
    {
        return recommendationBlob;
    }

    public Board getRecommendationBoard()
    {
        if (recommendationBoard == null || !recommendationBoard.getUid().equals(getRecommendationBoardUid()))
        {
            recommendationBoard = ModelHelper.getBoard(getRecommendationBoardUid());
        }
        return recommendationBoard;
    }

    public String getRecommendationBoardUid()
    {
        return recommendationBoardUid;
    }

    public String getRecommendationMessage()
    {
        if (promoterUid != null)
        {
            return STR_PROMOTED;
        }
        if (recommendationReason == null || "FOLLOWED_INTEREST".equals(recommendationReason))
        {
            return null;
        } else
        {
            return STR_RELATED;
        }
    }

    public String getRecommendationReason()
    {
        return recommendationReason;
    }

    public Integer getRepinCount()
    {
        return repinCount;
    }

    public int getRepinCountDisplay()
    {
        if (repinCount == null || repinCount.intValue() <= 0)
        {
            return 0;
        } else
        {
            return repinCount.intValue();
        }
    }

    public Boolean getRepinned()
    {
        return repinned;
    }

    public String getRichIcon()
    {
        return richIcon;
    }

    public String getRichSiteName()
    {
        return richSiteName;
    }

    public String getRichTitle()
    {
        return richTitle;
    }

    public String getRichTypeName()
    {
        return richTypeName;
    }

    public String getSource()
    {
        return source;
    }

    public String getUid()
    {
        return uid;
    }

    public User getUser()
    {
        if (user == null)
        {
            user = ModelHelper.getUser(getUserUid());
        }
        return user;
    }

    public String getUserUid()
    {
        return userUid;
    }

    public User getViaUser()
    {
        if (viaUser == null)
        {
            viaUser = ModelHelper.getUser(getViaUserUid());
        }
        return viaUser;
    }

    public String getViaUserUid()
    {
        return viaUserUid;
    }

    public Boolean getVideo()
    {
        return video;
    }

    public String getViewTags()
    {
        return viewTags;
    }

    public boolean hasArticleMetadata()
    {
        return getMetadata() != null && (getMetadata() instanceof Article);
    }

    public boolean hasAttribution()
    {
        return getAttrTitle() != null || getAttrAuthorName() != null || getAttrAuthorUrl() != null || getAttrProviderName() != null || getAttrProviderUrl() != null;
    }

    public boolean hasMetadata()
    {
        return hasMovieMetadata() || hasProductMetadata() || hasRecipeMetadata() || hasArticleMetadata();
    }

    public boolean hasMovieMetadata()
    {
        return getMetadata() != null && (getMetadata() instanceof Movie);
    }

    public boolean hasPlaceGridData()
    {
        Place place1 = getPlace();
        return place1 != null && ModelHelper.isValid(place1.getSourceName());
    }

    public boolean hasProductMetadata()
    {
        return getMetadata() != null && (getMetadata() instanceof Product);
    }

    public boolean hasRecipeMetadata()
    {
        return getMetadata() != null && (getMetadata() instanceof Recipe);
    }

    public boolean hasRichPinGridData()
    {
        return StringUtils.isNotEmpty(getRichTypeName()) && LAUNCHED_RICH_PIN_TYPES.containsKey(getRichTypeName()) && ModelHelper.isValid(getRichIcon()) && ModelHelper.isValid(getRichSiteName());
    }

    public boolean isGif()
    {
        return getEmbedType() != null && getEmbedType().equals("gif");
    }

    public boolean isSecret()
    {
        if (getBoard() != null)
        {
            return Constants.isTrue(getBoard().getSecret());
        } else
        {
            return false;
        }
    }

    public void setAttrAuthorName(String s)
    {
        attrAuthorName = s;
    }

    public void setAttrAuthorUrl(String s)
    {
        attrAuthorUrl = s;
    }

    public void setAttrProviderIconUrl(String s)
    {
        attrProviderIconUrl = s;
    }

    public void setAttrProviderName(String s)
    {
        attrProviderName = s;
    }

    public void setAttrProviderUrl(String s)
    {
        attrProviderUrl = s;
    }

    public void setAttrTitle(String s)
    {
        attrTitle = s;
    }

    public void setBoardUid(String s)
    {
        boardUid = s;
    }

    public void setCacheableId(String s)
    {
        cacheableId = s;
    }

    public void setCleanDescription(String s)
    {
        cleanDescription = s;
    }

    public void setCommentCount(Integer integer)
    {
        commentCount = integer;
    }

    public void setCreatedAt(Date date)
    {
        createdAt = date;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setDomain(String s)
    {
        domain = s;
    }

    public void setDominantColor(String s)
    {
        dominantColor = s;
    }

    public void setEmbedHeight(Integer integer)
    {
        embedHeight = integer;
    }

    public void setEmbedType(String s)
    {
        embedType = s;
    }

    public void setEmbedUrl(String s)
    {
        embedUrl = s;
    }

    public void setEmbedWidth(Integer integer)
    {
        embedWidth = integer;
    }

    public void setFeedbackType(Integer integer)
    {
        feedbackType = integer;
    }

    public void setHasPlace(Boolean boolean1)
    {
        hasPlace = boolean1;
    }

    public void setHiddenState(Integer integer)
    {
        hiddenState = integer;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setImageLargeHeight(Integer integer)
    {
        imageLargeHeight = integer;
    }

    public void setImageLargeUrl(String s)
    {
        imageLargeUrl = s;
    }

    public void setImageLargeWidth(Integer integer)
    {
        imageLargeWidth = integer;
    }

    public void setImageMediumHeight(Integer integer)
    {
        imageMediumHeight = integer;
    }

    public void setImageMediumUrl(String s)
    {
        imageMediumUrl = s;
    }

    public void setImageMediumWidth(Integer integer)
    {
        imageMediumWidth = integer;
    }

    public void setImageSquareHeight(Integer integer)
    {
        imageSquareHeight = integer;
    }

    public void setImageSquareUrl(String s)
    {
        imageSquareUrl = s;
    }

    public void setImageSquareWidth(Integer integer)
    {
        imageSquareWidth = integer;
    }

    public void setInsertionId(String s)
    {
        insertionId = s;
    }

    public void setInterestUid(String s)
    {
        interestUid = s;
    }

    public void setLikeCount(Integer integer)
    {
        likeCount = integer;
    }

    public void setLiked(Boolean boolean1)
    {
        liked = boolean1;
    }

    public void setLink(String s)
    {
        link = s;
    }

    public void setMetadataJson(String s)
    {
        metadataJson = s;
    }

    public void setPinnedToBoardUid(String s)
    {
        pinnedToBoardUid = s;
    }

    public void setPlaceUid(String s)
    {
        placeUid = s;
    }

    public void setPromoterUid(String s)
    {
        promoterUid = s;
    }

    public void setRecommendationBlob(String s)
    {
        recommendationBlob = s;
    }

    public void setRecommendationBoardUid(String s)
    {
        recommendationBoardUid = s;
    }

    public void setRecommendationReason(String s)
    {
        recommendationReason = s;
    }

    public void setRepinCount(Integer integer)
    {
        repinCount = integer;
    }

    public void setRepinned(Boolean boolean1)
    {
        repinned = boolean1;
    }

    public void setRichIcon(String s)
    {
        richIcon = s;
    }

    public void setRichSiteName(String s)
    {
        richSiteName = s;
    }

    public void setRichTitle(String s)
    {
        richTitle = s;
    }

    public void setRichTypeName(String s)
    {
        richTypeName = s;
    }

    public void setSource(String s)
    {
        source = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }

    public void setUserUid(String s)
    {
        userUid = s;
    }

    public void setViaUserUid(String s)
    {
        viaUserUid = s;
    }

    public void setVideo(Boolean boolean1)
    {
        video = boolean1;
    }

    public void setViewTags(String s)
    {
        viewTags = s;
    }

    public Boolean showMap()
    {
        boolean flag;
        if (hasPlace != null && hasPlace.booleanValue() && GooglePlayServices.isAvailable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }


    private class PinArtifact
    {

        private Board board;
        private Pin pin;
        private Place place;
        private User promoterUser;
        private Board recommendationBoard;
        private Interest sourceInterest;
        private User user;
        private User viaUser;

        public final Board getBoard()
        {
            return board;
        }

        public final Pin getPin()
        {
            return pin;
        }

        public final Place getPlace()
        {
            return place;
        }

        public final User getPromoterUser()
        {
            return promoterUser;
        }

        public final Board getRecommendationBoard()
        {
            return recommendationBoard;
        }

        public final Interest getSourceInterest()
        {
            return sourceInterest;
        }

        public final User getUser()
        {
            return user;
        }

        public final User getViaUser()
        {
            return viaUser;
        }

        public final void setBoard(Board board1)
        {
            board = board1;
        }

        public final void setPin(Pin pin1)
        {
            pin = pin1;
        }

        public final void setPlace(Place place1)
        {
            place = place1;
        }

        public final void setPromoterUser(User user1)
        {
            promoterUser = user1;
        }

        public final void setRecommendationBoard(Board board1)
        {
            recommendationBoard = board1;
        }

        public final void setSourceInterest(Interest interest1)
        {
            sourceInterest = interest1;
        }

        public final void setUser(User user1)
        {
            user = user1;
        }

        public final void setViaUser(User user1)
        {
            viaUser = user1;
        }

        public PinArtifact()
        {
        }
    }


    private class _cls1 extends HashMap
    {

        _cls1()
        {
            put("article", "");
            put("recipe", "");
            put("product", "");
            put("movie", "");
        }
    }

}
