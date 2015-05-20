// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import de.greenrobot.dao.Property;
import java.util.Date;

public class 
{

    public static final Property AttrAuthorName = new Property(18, java/lang/String, "attrAuthorName", false, "ATTR_AUTHOR_NAME");
    public static final Property AttrAuthorUrl = new Property(19, java/lang/String, "attrAuthorUrl", false, "ATTR_AUTHOR_URL");
    public static final Property AttrProviderIconUrl = new Property(20, java/lang/String, "attrProviderIconUrl", false, "ATTR_PROVIDER_ICON_URL");
    public static final Property AttrProviderName = new Property(16, java/lang/String, "attrProviderName", false, "ATTR_PROVIDER_NAME");
    public static final Property AttrProviderUrl = new Property(17, java/lang/String, "attrProviderUrl", false, "ATTR_PROVIDER_URL");
    public static final Property AttrTitle = new Property(15, java/lang/String, "attrTitle", false, "ATTR_TITLE");
    public static final Property BoardUid = new Property(5, java/lang/String, "boardUid", false, "BOARD_UID");
    public static final Property CacheableId = new Property(54, java/lang/String, "cacheableId", false, "CACHEABLE_ID");
    public static final Property CleanDescription = new Property(11, java/lang/String, "cleanDescription", false, "CLEAN_DESCRIPTION");
    public static final Property CommentCount = new Property(36, java/lang/Integer, "commentCount", false, "COMMENT_COUNT");
    public static final Property CreatedAt = new Property(8, java/util/Date, "createdAt", false, "CREATED_AT");
    public static final Property Description = new Property(10, java/lang/String, "description", false, "DESCRIPTION");
    public static final Property Domain = new Property(9, java/lang/String, "domain", false, "DOMAIN");
    public static final Property DominantColor = new Property(40, java/lang/String, "dominantColor", false, "DOMINANT_COLOR");
    public static final Property EmbedHeight = new Property(33, java/lang/Integer, "embedHeight", false, "EMBED_HEIGHT");
    public static final Property EmbedType = new Property(25, java/lang/String, "embedType", false, "EMBED_TYPE");
    public static final Property EmbedUrl = new Property(24, java/lang/String, "embedUrl", false, "EMBED_URL");
    public static final Property EmbedWidth = new Property(32, java/lang/Integer, "embedWidth", false, "EMBED_WIDTH");
    public static final Property FeedbackType = new Property(52, java/lang/Integer, "feedbackType", false, "FEEDBACK_TYPE");
    public static final Property HasPlace = new Property(47, java/lang/Boolean, "hasPlace", false, "HAS_PLACE");
    public static final Property HiddenState = new Property(51, java/lang/Integer, "hiddenState", false, "HIDDEN_STATE");
    public static final Property Id = new Property(0, java/lang/Long, "id", true, "_id");
    public static final Property ImageLargeHeight = new Property(31, java/lang/Integer, "imageLargeHeight", false, "IMAGE_LARGE_HEIGHT");
    public static final Property ImageLargeUrl = new Property(23, java/lang/String, "imageLargeUrl", false, "IMAGE_LARGE_URL");
    public static final Property ImageLargeWidth = new Property(30, java/lang/Integer, "imageLargeWidth", false, "IMAGE_LARGE_WIDTH");
    public static final Property ImageMediumHeight = new Property(29, java/lang/Integer, "imageMediumHeight", false, "IMAGE_MEDIUM_HEIGHT");
    public static final Property ImageMediumUrl = new Property(22, java/lang/String, "imageMediumUrl", false, "IMAGE_MEDIUM_URL");
    public static final Property ImageMediumWidth = new Property(28, java/lang/Integer, "imageMediumWidth", false, "IMAGE_MEDIUM_WIDTH");
    public static final Property ImageSquareHeight = new Property(27, java/lang/Integer, "imageSquareHeight", false, "IMAGE_SQUARE_HEIGHT");
    public static final Property ImageSquareUrl = new Property(21, java/lang/String, "imageSquareUrl", false, "IMAGE_SQUARE_URL");
    public static final Property ImageSquareWidth = new Property(26, java/lang/Integer, "imageSquareWidth", false, "IMAGE_SQUARE_WIDTH");
    public static final Property InsertionId = new Property(2, java/lang/String, "insertionId", false, "INSERTION_ID");
    public static final Property InterestUid = new Property(6, java/lang/String, "interestUid", false, "INTEREST_UID");
    public static final Property LikeCount = new Property(35, java/lang/Integer, "likeCount", false, "LIKE_COUNT");
    public static final Property Liked = new Property(38, java/lang/Boolean, "liked", false, "LIKED");
    public static final Property Link = new Property(12, java/lang/String, "link", false, "LINK");
    public static final Property MetadataJson = new Property(45, java/lang/String, "metadataJson", false, "METADATA_JSON");
    public static final Property PinnedToBoardUid = new Property(7, java/lang/String, "pinnedToBoardUid", false, "PINNED_TO_BOARD_UID");
    public static final Property PlaceUid = new Property(46, java/lang/String, "placeUid", false, "PLACE_UID");
    public static final Property PromoterUid = new Property(4, java/lang/String, "promoterUid", false, "PROMOTER_UID");
    public static final Property RecommendationBlob = new Property(48, java/lang/String, "recommendationBlob", false, "RECOMMENDATION_BLOB");
    public static final Property RecommendationBoardUid = new Property(50, java/lang/String, "recommendationBoardUid", false, "RECOMMENDATION_BOARD_UID");
    public static final Property RecommendationReason = new Property(49, java/lang/String, "recommendationReason", false, "RECOMMENDATION_REASON");
    public static final Property RepinCount = new Property(34, java/lang/Integer, "repinCount", false, "REPIN_COUNT");
    public static final Property Repinned = new Property(37, java/lang/Boolean, "repinned", false, "REPINNED");
    public static final Property RichIcon = new Property(44, java/lang/String, "richIcon", false, "RICH_ICON");
    public static final Property RichSiteName = new Property(42, java/lang/String, "richSiteName", false, "RICH_SITE_NAME");
    public static final Property RichTitle = new Property(41, java/lang/String, "richTitle", false, "RICH_TITLE");
    public static final Property RichTypeName = new Property(43, java/lang/String, "richTypeName", false, "RICH_TYPE_NAME");
    public static final Property Source = new Property(13, java/lang/String, "source", false, "SOURCE");
    public static final Property Uid = new Property(1, java/lang/String, "uid", false, "UID");
    public static final Property UserUid = new Property(3, java/lang/String, "userUid", false, "USER_UID");
    public static final Property ViaUserUid = new Property(14, java/lang/String, "viaUserUid", false, "VIA_USER_UID");
    public static final Property Video = new Property(39, java/lang/Boolean, "video", false, "VIDEO");
    public static final Property ViewTags = new Property(53, java/lang/String, "viewTags", false, "VIEW_TAGS");


    public ()
    {
    }
}
