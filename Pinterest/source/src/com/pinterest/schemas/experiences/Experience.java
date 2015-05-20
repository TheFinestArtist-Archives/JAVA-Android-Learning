// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class Experience extends Enum
    implements TEnum
{

    private static final Experience $VALUES[];
    public static final Experience ANALYTICS_AUDIENCE_SELECTOR_USER_ED;
    public static final Experience ANALYTICS_HOME_USER_ED;
    public static final Experience ANALYTICS_NOOP;
    public static final Experience ANDROID_BOARD_FOLLOW_ED;
    public static final Experience ANDROID_BOARD_FOLLOW_ED_HELPER;
    public static final Experience ANDROID_BOARD_FOLLOW_ED_HELPER_TABLET;
    public static final Experience ANDROID_BOARD_FOLLOW_ED_TABLET;
    public static final Experience ANDROID_CLICKTHROUGH_ED;
    public static final Experience ANDROID_CLICKTHROUGH_ED_HELPER;
    public static final Experience ANDROID_CLICKTHROUGH_ED_HELPER_TABLET;
    public static final Experience ANDROID_CLICKTHROUGH_ED_TABLET;
    public static final Experience ANDROID_EMMY_AWARDS;
    public static final Experience ANDROID_EMPTY_BOARD_ED;
    public static final Experience ANDROID_EMPTY_BOARD_ED_HELPER;
    public static final Experience ANDROID_EMPTY_BOARD_ED_HELPER_TABLET;
    public static final Experience ANDROID_EMPTY_BOARD_ED_TABLET;
    public static final Experience ANDROID_EMPTY_USER_PROFILE_ED;
    public static final Experience ANDROID_EMPTY_USER_PROFILE_ED_HELPER;
    public static final Experience ANDROID_EMPTY_USER_PROFILE_ED_HELPER_TABLET;
    public static final Experience ANDROID_EMPTY_USER_PROFILE_ED_TABLET;
    public static final Experience ANDROID_HERO_EMPTY_HOMEFEED;
    public static final Experience ANDROID_HERO_PROMPT_REBUILD_FEED;
    public static final Experience ANDROID_HERO_UNDO_REBUILD_FEED;
    public static final Experience ANDROID_HOME_FEED_ED;
    public static final Experience ANDROID_HOME_FEED_ED_HELPER;
    public static final Experience ANDROID_HOME_FEED_ED_HELPER_TABLET;
    public static final Experience ANDROID_HOME_FEED_ED_TABLET;
    public static final Experience ANDROID_HOME_FEED_ED_V2;
    public static final Experience ANDROID_HOME_FEED_ED_V2_HELPER;
    public static final Experience ANDROID_MSGS_WELCOME_MESSAGE;
    public static final Experience ANDROID_NAG_ADS_PRIVACY_UPDATE;
    public static final Experience ANDROID_NAG_CONFIRM_EMAIL;
    public static final Experience ANDROID_NAG_CONNECT_FACEBOOK;
    public static final Experience ANDROID_NAG_INVITER;
    public static final Experience ANDROID_NAG_PINVITATIONAL;
    public static final Experience ANDROID_NAG_UPLOAD_CONTACTS;
    public static final Experience ANDROID_NAG_WRITE_BANNED;
    public static final Experience ANDROID_NOOP;
    public static final Experience ANDROID_NUX_MANDATORY_MEN;
    public static final Experience ANDROID_NUX_MANDATORY_WOMEN;
    public static final Experience ANDROID_NUX_REBUILD_FEED;
    public static final Experience ANDROID_PINVITATIONAL_CONFIRM_BOARD;
    public static final Experience ANDROID_PINVITATIONAL_HOME_FEED_MODAL;
    public static final Experience ANDROID_PROFILE_FOLLOW_ED;
    public static final Experience ANDROID_PROFILE_FOLLOW_ED_HELPER;
    public static final Experience ANDROID_PROFILE_FOLLOW_ED_HELPER_TABLET;
    public static final Experience ANDROID_PROFILE_FOLLOW_ED_TABLET;
    public static final Experience ANDROID_QA_EDUCATION;
    public static final Experience ANDROID_QA_NOTIFICATION_EDUCATION;
    public static final Experience ANDROID_REPIN_ED;
    public static final Experience ANDROID_REPIN_ED_HELPER;
    public static final Experience ANDROID_REPIN_ED_HELPER_TABLET;
    public static final Experience ANDROID_REPIN_ED_TABLET;
    public static final Experience ANDROID_REPIN_ED_V2;
    public static final Experience ANDROID_REPIN_ED_V2_HELPER;
    public static final Experience ANDROID_SURVEY_201501;
    public static final Experience BATCH_EMAIL_EMPTY_BOARD;
    public static final Experience BATCH_EMAIL_FIRST_BOARD_CREATE;
    public static final Experience BATCH_EMAIL_FIRST_CLICKTHROUGH;
    public static final Experience BATCH_EMAIL_FIRST_PIN_CREATE;
    public static final Experience BATCH_EMAIL_GUIDED_SEARCH;
    public static final Experience BATCH_EMAIL_HOMEFEED_NEW_PINS;
    public static final Experience BATCH_EMAIL_INTEREST_RECOMMENDATIONS;
    public static final Experience BATCH_EMAIL_MOBILE_APP_DOWNLOAD;
    public static final Experience BATCH_EMAIL_POPULAR_PINS;
    public static final Experience BATCH_NETWORK_STORY_VALENTINE;
    public static final Experience BATCH_NOOP;
    public static final Experience BATCH_PUSH_NOTIFICATION_ATHELETES_OUTDOORS;
    public static final Experience BATCH_PUSH_NOTIFICATION_CREATE_RESOLUTION_BOARD;
    public static final Experience BATCH_PUSH_NOTIFICATION_FOOD;
    public static final Experience BATCH_PUSH_NOTIFICATION_GARDENING;
    public static final Experience BATCH_PUSH_NOTIFICATION_HOLIDAY_GUIDE;
    public static final Experience BATCH_PUSH_NOTIFICATION_KIDS;
    public static final Experience BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_1;
    public static final Experience BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_2;
    public static final Experience BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_3;
    public static final Experience BATCH_PUSH_NOTIFICATION_RESOLUTION_IDEAS;
    public static final Experience BATCH_PUSH_NOTIFICATION_SHARE_BOARD;
    public static final Experience CONFIRM_EMAIL;
    public static final Experience EMAIL_NOOP;
    public static final Experience EMAIL_USER_ED_TIP_CLICKTHROUGH;
    public static final Experience EMAIL_USER_ED_TIP_EMAIL_VERIFY;
    public static final Experience EMAIL_USER_ED_TIP_EMPTY_BOARD;
    public static final Experience EMAIL_USER_ED_TIP_PINIT_BUTTON;
    public static final Experience EMAIL_USER_ED_TIP_PIN_CREATE;
    public static final Experience EMAIL_USER_ED_TIP_REPIN;
    public static final Experience EMAIL_USER_ED_TIP_SEARCH;
    public static final Experience IOS_BOARD_FOLLOW_ED;
    public static final Experience IOS_BOARD_FOLLOW_ED_HELPER;
    public static final Experience IOS_CLICKTHROUGH_ED;
    public static final Experience IOS_CLICKTHROUGH_ED_HELPER;
    public static final Experience IOS_COMBINED_SEARCH_ED;
    public static final Experience IOS_COMBINED_SEARCH_ED_HELPER;
    public static final Experience IOS_CONTACTS_AND_FACEBOOK_PERMISSIONS;
    public static final Experience IOS_CONTACTS_PERMISSIONS;
    public static final Experience IOS_CONTEXTUAL_MENU_ED;
    public static final Experience IOS_CREATE_BUTTON_ED;
    public static final Experience IOS_EMMY_AWARDS;
    public static final Experience IOS_EMPTY_BOARD_ED;
    public static final Experience IOS_EMPTY_BOARD_ED_HELPER;
    public static final Experience IOS_EMPTY_USER_PROFILE_ED;
    public static final Experience IOS_EMPTY_USER_PROFILE_ED_HELPER;
    public static final Experience IOS_GUIDED_SEARCH_ED;
    public static final Experience IOS_GUIDED_SEARCH_ED_HELPER;
    public static final Experience IOS_HOME_FEED_ED;
    public static final Experience IOS_HOME_FEED_ED_HELPER;
    public static final Experience IOS_HOME_WELCOME_HELPER;
    public static final Experience IOS_MSGS_MESSAGE_LIST_USER_ED;
    public static final Experience IOS_MSGS_MESSAGE_USER_ED;
    public static final Experience IOS_MSGS_MESSAGE_USER_ED_IPAD;
    public static final Experience IOS_MSGS_NOTIFICATIONS_USER_ED;
    public static final Experience IOS_MSGS_NOTIFICATIONS_USER_ED_IPAD;
    public static final Experience IOS_MSGS_SEND_PIN_ED;
    public static final Experience IOS_MSGS_SEND_PIN_ED_HELPER;
    public static final Experience IOS_MSGS_WELCOME_MESSAGE;
    public static final Experience IOS_NAG_ADS_PRIVACY_UPDATE;
    public static final Experience IOS_NAG_CONFIRM_EMAIL;
    public static final Experience IOS_NAG_CONFIRM_EMAIL_V3_5_1;
    public static final Experience IOS_NAG_INVITER;
    public static final Experience IOS_NAG_PINVITATIONAL;
    public static final Experience IOS_NAG_PINVITATIONAL_REFRESH;
    public static final Experience IOS_NAG_PLACE_PINS;
    public static final Experience IOS_NAG_REBUILD_FEED;
    public static final Experience IOS_NAG_UNDO_REBUILD_FEED;
    public static final Experience IOS_NAG_WRITE_BANNED;
    public static final Experience IOS_NOOP;
    public static final Experience IOS_NUX_BUILD_HOMEFEED;
    public static final Experience IOS_NUX_FIRST_BOARD;
    public static final Experience IOS_NUX_FIRST_PIN;
    public static final Experience IOS_NUX_INTEREST_PICKER;
    public static final Experience IOS_NUX_MANDATORY;
    public static final Experience IOS_NUX_MANDATORY_MEN;
    public static final Experience IOS_NUX_MANDATORY_WOMEN;
    public static final Experience IOS_NUX_REBUILD_FEED;
    public static final Experience IOS_NUX_SEARCH_LIVE_PROFILE_HELPER;
    public static final Experience IOS_NUX_SEARCH_WELCOME_HELPER;
    public static final Experience IOS_PINS_LIVE_PROFILE_HELPER;
    public static final Experience IOS_PINVITATIONAL_HOME_FEED_MODAL;
    public static final Experience IOS_PROFILE_FOLLOW_ED;
    public static final Experience IOS_PROFILE_FOLLOW_ED_HELPER;
    public static final Experience IOS_PUSH_NOTIFICATION_PERMISSION_PROMPT;
    public static final Experience IOS_QA_EDUCATION;
    public static final Experience IOS_QA_NOTIFICATION_EDUCATION;
    public static final Experience IOS_REPIN_ED;
    public static final Experience IOS_REPIN_ED_HELPER;
    public static final Experience IOS_REPIN_ED_HELPER_IPAD;
    public static final Experience IOS_REPIN_ED_IPAD;
    public static final Experience IOS_TEST;
    public static final Experience IOS_UPDATE_APP_HELPER;
    public static final Experience NOOP;
    public static final Experience PUSH_NOTIFICATION_FRIEND_PIN;
    public static final Experience PUSH_NOTIFICATION_NOOP;
    public static final Experience PUSH_NOTIFICATION_PIN_TWINS;
    public static final Experience PUSH_NOTIFICATION_SIMILAR_REPINS;
    public static final Experience WEB_BLANK_SESSION;
    public static final Experience WEB_BOARD_BULK_EDIT_ED;
    public static final Experience WEB_CATEGORY_SEARCH_USER_ED;
    public static final Experience WEB_CLICKTHROUGH_ED;
    public static final Experience WEB_CLICKTHROUGH_ED_MANUAL;
    public static final Experience WEB_EMPTY_BOARD_ED;
    public static final Experience WEB_EMPTY_BOARD_ED_MANUAL;
    public static final Experience WEB_EMPTY_PLACES_BOARD_USER_ED;
    public static final Experience WEB_EMPTY_PROFILE_ED;
    public static final Experience WEB_EMPTY_PROFILE_ED_MANUAL;
    public static final Experience WEB_EXPLORE_BUTTON_USER_ED;
    public static final Experience WEB_EXPLORE_HEADER_USER_ED;
    public static final Experience WEB_EXPLORE_PAGE_USER_ED;
    public static final Experience WEB_FACEBOOK_CONNECT_HERO;
    public static final Experience WEB_FACEBOOK_PUBLISH_HERO;
    public static final Experience WEB_FAST_FOLLOW_USER_ED;
    public static final Experience WEB_FEED_EDITOR_USER_ED;
    public static final Experience WEB_FILLED_PLACES_BOARD_USER_ED;
    public static final Experience WEB_FIND_FRIENDS_USER_ED;
    public static final Experience WEB_FIRST_BOARD_USER_ED;
    public static final Experience WEB_FIRST_FOLLOW;
    public static final Experience WEB_FIRST_PIN_SUCCESS;
    public static final Experience WEB_FIRST_PIN_USER_ED;
    public static final Experience WEB_FLEXIBLE_SET_UP;
    public static final Experience WEB_GUIDED_SEARCH_HEADER_USER_ED;
    public static final Experience WEB_GUIDED_SEARCH_USER_ED;
    public static final Experience WEB_HERO_ADS_PRIVACY_UPDATE;
    public static final Experience WEB_HERO_APP_UPSELL;
    public static final Experience WEB_HERO_BUSINESS_HOLIDAY_BOARD_NAG;
    public static final Experience WEB_HERO_CONVERT_TO_BUSINESS;
    public static final Experience WEB_HERO_EMMY_AWARDS;
    public static final Experience WEB_HERO_EMPTY_HOMEFEED;
    public static final Experience WEB_HERO_HOLIDAY_GUIDE;
    public static final Experience WEB_HERO_INSTALL_APP;
    public static final Experience WEB_HERO_INSTALL_EXTENSION;
    public static final Experience WEB_HERO_INVITE_FRIENDS;
    public static final Experience WEB_HERO_LANGUAGE;
    public static final Experience WEB_HERO_LANGUAGE_BROWSER_SAFE;
    public static final Experience WEB_HERO_NEW_ANALYTICS_CONVERT_TO_BIZ_NAG;
    public static final Experience WEB_HERO_NEW_ANALYTICS_NAG;
    public static final Experience WEB_HERO_PINIT_BUTTON;
    public static final Experience WEB_HERO_PINIT_BUTTON_INTERNATIONAL;
    public static final Experience WEB_HERO_PINIT_WEBMASTER;
    public static final Experience WEB_HERO_PINNER_HOLIDAY_BOARD_NAG;
    public static final Experience WEB_HERO_PINVITATIONAL_INVITE_NAG;
    public static final Experience WEB_HERO_PLACE_PINS;
    public static final Experience WEB_HERO_PLACE_PINS_BOARD;
    public static final Experience WEB_HERO_PROMOTED_PINS_BETA_REMINDER;
    public static final Experience WEB_HERO_PROMOTE_A_PIN;
    public static final Experience WEB_HERO_PROMPT_REBUILD_FEED;
    public static final Experience WEB_HERO_SCOOTER_PINNER_STORY;
    public static final Experience WEB_HERO_UNDO_REBUILD_FEED;
    public static final Experience WEB_HERO_VALENTINES;
    public static final Experience WEB_HERO_WORLD_CUP;
    public static final Experience WEB_HOMEFEED_CAROUSEL;
    public static final Experience WEB_HOME_FEED_ED;
    public static final Experience WEB_HOME_FEED_ED_MANUAL;
    public static final Experience WEB_HOME_HERO_PROMOTED_PINS_BETA_REMINDER;
    public static final Experience WEB_INTL_PIN_USER_ED;
    public static final Experience WEB_MANDATORY_AUTOBAHN;
    public static final Experience WEB_MOBILE_NOOP;
    public static final Experience WEB_MOBILE_NUX_INTERESTS;
    public static final Experience WEB_MOBILE_NUX_MANDATORY;
    public static final Experience WEB_MODERN_HEADER_USER_ED;
    public static final Experience WEB_MSGS_WELCOME_MESSAGE;
    public static final Experience WEB_NAG_ADS_PRIVACY_UPDATE;
    public static final Experience WEB_NAG_LIMITED_LOGIN;
    public static final Experience WEB_NOOP;
    public static final Experience WEB_PINIT_BOOKMARKLET;
    public static final Experience WEB_PINVITATIONAL_HOMEFEED_MODAL;
    public static final Experience WEB_PIN_CLOSEUP_AUTOBAHN;
    public static final Experience WEB_PIN_CLOSEUP_LITE;
    public static final Experience WEB_PIN_SUCCESS_EXTENSION_ED_BOARD_BOXED;
    public static final Experience WEB_PIN_SUCCESS_EXTENSION_ED_CATEGORY_BOXED;
    public static final Experience WEB_PIN_SUCCESS_EXTENSION_ED_DOMAIN;
    public static final Experience WEB_PIN_SUCCESS_EXTENSION_ED_ODD_CONTENTS;
    public static final Experience WEB_PIN_SUCCESS_EXTENSION_UPSELL;
    public static final Experience WEB_PIN_SUCCESS_NEW_EXTENSION_UPSELL;
    public static final Experience WEB_PLACE_PINS_TOOLTIP;
    public static final Experience WEB_QA_CLOSEUP_NOTIFICATION_USER_ED;
    public static final Experience WEB_QA_CLOSEUP_USER_ED;
    public static final Experience WEB_REBUILD_FEED;
    public static final Experience WEB_REPIN_ED;
    public static final Experience WEB_REPIN_ED_MANUAL;
    public static final Experience WEB_SEARCH_DISCOVER_TOOLTIP;
    public static final Experience WEB_SURVEY_201501;
    public static final Experience WEB_TEST;
    public static final Experience WEB_UNAUTH_PIN_CLOSEUP;
    public static final Experience WEB_USER_NEWS_APP_UPSELL;
    public static final Experience WEB_VISUAL_OBJECT_SEARCH_CLOSEUP_USER_ED;
    public static final Experience WEB_YOUR_BOARDS_USER_ED;
    private final int value;

    private Experience(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static Experience findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return NOOP;

        case 2: // '\002'
            return CONFIRM_EMAIL;

        case 10000: 
            return WEB_NOOP;

        case 10001: 
            return WEB_FEED_EDITOR_USER_ED;

        case 10002: 
            return WEB_PIN_CLOSEUP_LITE;

        case 10003: 
            return WEB_PIN_CLOSEUP_AUTOBAHN;

        case 10004: 
            return WEB_MANDATORY_AUTOBAHN;

        case 10005: 
            return WEB_FIRST_PIN_SUCCESS;

        case 10006: 
            return WEB_SEARCH_DISCOVER_TOOLTIP;

        case 10007: 
            return WEB_FIRST_FOLLOW;

        case 10008: 
            return WEB_PINIT_BOOKMARKLET;

        case 10009: 
            return WEB_BLANK_SESSION;

        case 10010: 
            return WEB_FIRST_PIN_USER_ED;

        case 10011: 
            return WEB_YOUR_BOARDS_USER_ED;

        case 10012: 
            return WEB_FAST_FOLLOW_USER_ED;

        case 10013: 
            return WEB_FIND_FRIENDS_USER_ED;

        case 10014: 
            return WEB_CATEGORY_SEARCH_USER_ED;

        case 10015: 
            return WEB_PLACE_PINS_TOOLTIP;

        case 10016: 
            return WEB_EMPTY_PLACES_BOARD_USER_ED;

        case 10017: 
            return WEB_FILLED_PLACES_BOARD_USER_ED;

        case 10018: 
            return WEB_FIRST_BOARD_USER_ED;

        case 10019: 
            return WEB_EXPLORE_BUTTON_USER_ED;

        case 10020: 
            return WEB_EXPLORE_PAGE_USER_ED;

        case 10021: 
            return WEB_MODERN_HEADER_USER_ED;

        case 10022: 
            return WEB_PIN_SUCCESS_EXTENSION_UPSELL;

        case 10023: 
            return WEB_EXPLORE_HEADER_USER_ED;

        case 10024: 
            return WEB_VISUAL_OBJECT_SEARCH_CLOSEUP_USER_ED;

        case 10025: 
            return WEB_MSGS_WELCOME_MESSAGE;

        case 10026: 
            return WEB_USER_NEWS_APP_UPSELL;

        case 10027: 
            return WEB_INTL_PIN_USER_ED;

        case 10028: 
            return WEB_FACEBOOK_CONNECT_HERO;

        case 10029: 
            return WEB_FACEBOOK_PUBLISH_HERO;

        case 10030: 
            return WEB_HOMEFEED_CAROUSEL;

        case 10031: 
            return WEB_REBUILD_FEED;

        case 10032: 
            return WEB_GUIDED_SEARCH_HEADER_USER_ED;

        case 10033: 
            return WEB_GUIDED_SEARCH_USER_ED;

        case 10034: 
            return WEB_BOARD_BULK_EDIT_ED;

        case 10035: 
            return WEB_FLEXIBLE_SET_UP;

        case 10036: 
            return WEB_SURVEY_201501;

        case 10037: 
            return WEB_PINVITATIONAL_HOMEFEED_MODAL;

        case 10050: 
            return WEB_HERO_INVITE_FRIENDS;

        case 10051: 
            return WEB_HERO_EMPTY_HOMEFEED;

        case 10052: 
            return WEB_HERO_INSTALL_APP;

        case 10053: 
            return WEB_HERO_PINIT_BUTTON;

        case 10054: 
            return WEB_HERO_LANGUAGE;

        case 10055: 
            return WEB_HERO_PINIT_WEBMASTER;

        case 10056: 
            return WEB_HERO_PLACE_PINS;

        case 10057: 
            return WEB_HERO_PLACE_PINS_BOARD;

        case 10058: 
            return WEB_HERO_HOLIDAY_GUIDE;

        case 10059: 
            return WEB_HERO_VALENTINES;

        case 10060: 
            return WEB_HERO_INSTALL_EXTENSION;

        case 10061: 
            return WEB_HERO_LANGUAGE_BROWSER_SAFE;

        case 10062: 
            return WEB_HERO_PINIT_BUTTON_INTERNATIONAL;

        case 10063: 
            return WEB_HERO_CONVERT_TO_BUSINESS;

        case 10064: 
            return WEB_HERO_PROMOTE_A_PIN;

        case 10065: 
            return WEB_HERO_WORLD_CUP;

        case 10066: 
            return WEB_HERO_SCOOTER_PINNER_STORY;

        case 10067: 
            return WEB_HERO_PROMOTED_PINS_BETA_REMINDER;

        case 10068: 
            return WEB_HERO_NEW_ANALYTICS_NAG;

        case 10069: 
            return WEB_HERO_APP_UPSELL;

        case 10070: 
            return WEB_HERO_NEW_ANALYTICS_CONVERT_TO_BIZ_NAG;

        case 10071: 
            return WEB_HERO_EMMY_AWARDS;

        case 10072: 
            return WEB_HERO_PROMPT_REBUILD_FEED;

        case 10073: 
            return WEB_HERO_UNDO_REBUILD_FEED;

        case 10074: 
            return WEB_HERO_ADS_PRIVACY_UPDATE;

        case 10075: 
            return WEB_HERO_BUSINESS_HOLIDAY_BOARD_NAG;

        case 10076: 
            return WEB_HERO_PINNER_HOLIDAY_BOARD_NAG;

        case 10077: 
            return WEB_HOME_HERO_PROMOTED_PINS_BETA_REMINDER;

        case 10078: 
            return WEB_HERO_PINVITATIONAL_INVITE_NAG;

        case 10100: 
            return WEB_PIN_SUCCESS_NEW_EXTENSION_UPSELL;

        case 10101: 
            return WEB_PIN_SUCCESS_EXTENSION_ED_DOMAIN;

        case 10102: 
            return WEB_PIN_SUCCESS_EXTENSION_ED_ODD_CONTENTS;

        case 10103: 
            return WEB_PIN_SUCCESS_EXTENSION_ED_CATEGORY_BOXED;

        case 10104: 
            return WEB_PIN_SUCCESS_EXTENSION_ED_BOARD_BOXED;

        case 10200: 
            return WEB_NAG_ADS_PRIVACY_UPDATE;

        case 10201: 
            return WEB_NAG_LIMITED_LOGIN;

        case 11000: 
            return WEB_QA_CLOSEUP_USER_ED;

        case 11001: 
            return WEB_QA_CLOSEUP_NOTIFICATION_USER_ED;

        case 11002: 
            return WEB_EMPTY_BOARD_ED;

        case 11003: 
            return WEB_EMPTY_PROFILE_ED;

        case 11004: 
            return WEB_EMPTY_BOARD_ED_MANUAL;

        case 11005: 
            return WEB_EMPTY_PROFILE_ED_MANUAL;

        case 11006: 
            return WEB_HOME_FEED_ED;

        case 11007: 
            return WEB_REPIN_ED;

        case 11008: 
            return WEB_HOME_FEED_ED_MANUAL;

        case 11009: 
            return WEB_REPIN_ED_MANUAL;

        case 11010: 
            return WEB_CLICKTHROUGH_ED;

        case 11011: 
            return WEB_CLICKTHROUGH_ED_MANUAL;

        case 12000: 
            return WEB_UNAUTH_PIN_CLOSEUP;

        case 19999: 
            return WEB_TEST;

        case 20000: 
            return IOS_NOOP;

        case 20001: 
            return IOS_NAG_CONFIRM_EMAIL;

        case 20002: 
            return IOS_NAG_PLACE_PINS;

        case 20003: 
            return IOS_NAG_INVITER;

        case 20004: 
            return IOS_NUX_FIRST_PIN;

        case 20005: 
            return IOS_NUX_MANDATORY;

        case 20006: 
            return IOS_HOME_WELCOME_HELPER;

        case 20007: 
            return IOS_PINS_LIVE_PROFILE_HELPER;

        case 20008: 
            return IOS_NAG_WRITE_BANNED;

        case 20009: 
            return IOS_NAG_CONFIRM_EMAIL_V3_5_1;

        case 20010: 
            return IOS_QA_EDUCATION;

        case 20011: 
            return IOS_CONTACTS_PERMISSIONS;

        case 20012: 
            return IOS_CONTACTS_AND_FACEBOOK_PERMISSIONS;

        case 20013: 
            return IOS_UPDATE_APP_HELPER;

        case 20014: 
            return IOS_EMPTY_BOARD_ED;

        case 20015: 
            return IOS_EMPTY_USER_PROFILE_ED;

        case 20016: 
            return IOS_EMPTY_BOARD_ED_HELPER;

        case 20017: 
            return IOS_EMPTY_USER_PROFILE_ED_HELPER;

        case 20018: 
            return IOS_QA_NOTIFICATION_EDUCATION;

        case 20019: 
            return IOS_NUX_MANDATORY_MEN;

        case 20020: 
            return IOS_NUX_MANDATORY_WOMEN;

        case 20021: 
            return IOS_MSGS_NOTIFICATIONS_USER_ED;

        case 20022: 
            return IOS_MSGS_MESSAGE_LIST_USER_ED;

        case 20023: 
            return IOS_MSGS_MESSAGE_USER_ED;

        case 20024: 
            return IOS_MSGS_NOTIFICATIONS_USER_ED_IPAD;

        case 20025: 
            return IOS_MSGS_MESSAGE_USER_ED_IPAD;

        case 20026: 
            return IOS_MSGS_WELCOME_MESSAGE;

        case 20027: 
            return IOS_EMMY_AWARDS;

        case 20028: 
            return IOS_NAG_ADS_PRIVACY_UPDATE;

        case 20029: 
            return IOS_REPIN_ED;

        case 20030: 
            return IOS_REPIN_ED_HELPER;

        case 20031: 
            return IOS_REPIN_ED_IPAD;

        case 20032: 
            return IOS_REPIN_ED_HELPER_IPAD;

        case 20033: 
            return IOS_HOME_FEED_ED;

        case 20034: 
            return IOS_HOME_FEED_ED_HELPER;

        case 20035: 
            return IOS_NAG_REBUILD_FEED;

        case 20036: 
            return IOS_NAG_UNDO_REBUILD_FEED;

        case 20037: 
            return IOS_NUX_REBUILD_FEED;

        case 20038: 
            return IOS_CREATE_BUTTON_ED;

        case 20039: 
            return IOS_PUSH_NOTIFICATION_PERMISSION_PROMPT;

        case 20040: 
            return IOS_BOARD_FOLLOW_ED;

        case 20041: 
            return IOS_BOARD_FOLLOW_ED_HELPER;

        case 20042: 
            return IOS_PROFILE_FOLLOW_ED;

        case 20043: 
            return IOS_PROFILE_FOLLOW_ED_HELPER;

        case 20044: 
            return IOS_CLICKTHROUGH_ED;

        case 20045: 
            return IOS_CLICKTHROUGH_ED_HELPER;

        case 20046: 
            return IOS_COMBINED_SEARCH_ED;

        case 20047: 
            return IOS_COMBINED_SEARCH_ED_HELPER;

        case 20048: 
            return IOS_GUIDED_SEARCH_ED;

        case 20049: 
            return IOS_GUIDED_SEARCH_ED_HELPER;

        case 20050: 
            return IOS_CONTEXTUAL_MENU_ED;

        case 20051: 
            return IOS_MSGS_SEND_PIN_ED;

        case 20052: 
            return IOS_MSGS_SEND_PIN_ED_HELPER;

        case 20053: 
            return IOS_NAG_PINVITATIONAL;

        case 20054: 
            return IOS_NAG_PINVITATIONAL_REFRESH;

        case 20055: 
            return IOS_PINVITATIONAL_HOME_FEED_MODAL;

        case 20056: 
            return IOS_NUX_FIRST_BOARD;

        case 20057: 
            return IOS_NUX_BUILD_HOMEFEED;

        case 20058: 
            return IOS_NUX_SEARCH_WELCOME_HELPER;

        case 20059: 
            return IOS_NUX_SEARCH_LIVE_PROFILE_HELPER;

        case 20060: 
            return IOS_NUX_INTEREST_PICKER;

        case 29999: 
            return IOS_TEST;

        case 30000: 
            return ANDROID_NOOP;

        case 30001: 
            return ANDROID_HERO_EMPTY_HOMEFEED;

        case 30002: 
            return ANDROID_NAG_CONFIRM_EMAIL;

        case 30003: 
            return ANDROID_NAG_WRITE_BANNED;

        case 30004: 
            return ANDROID_NAG_INVITER;

        case 30005: 
            return ANDROID_EMPTY_BOARD_ED;

        case 30006: 
            return ANDROID_EMPTY_USER_PROFILE_ED;

        case 30007: 
            return ANDROID_QA_EDUCATION;

        case 30008: 
            return ANDROID_QA_NOTIFICATION_EDUCATION;

        case 30009: 
            return ANDROID_EMPTY_BOARD_ED_HELPER;

        case 30010: 
            return ANDROID_EMPTY_USER_PROFILE_ED_HELPER;

        case 30011: 
            return ANDROID_NUX_MANDATORY_MEN;

        case 30012: 
            return ANDROID_NUX_MANDATORY_WOMEN;

        case 30013: 
            return ANDROID_EMPTY_BOARD_ED_TABLET;

        case 30014: 
            return ANDROID_EMPTY_BOARD_ED_HELPER_TABLET;

        case 30015: 
            return ANDROID_EMPTY_USER_PROFILE_ED_TABLET;

        case 30016: 
            return ANDROID_EMPTY_USER_PROFILE_ED_HELPER_TABLET;

        case 30017: 
            return ANDROID_CLICKTHROUGH_ED;

        case 30018: 
            return ANDROID_MSGS_WELCOME_MESSAGE;

        case 30019: 
            return ANDROID_EMMY_AWARDS;

        case 30020: 
            return ANDROID_HOME_FEED_ED;

        case 30021: 
            return ANDROID_REPIN_ED;

        case 30022: 
            return ANDROID_NAG_ADS_PRIVACY_UPDATE;

        case 30023: 
            return ANDROID_HOME_FEED_ED_HELPER;

        case 30024: 
            return ANDROID_HOME_FEED_ED_TABLET;

        case 30025: 
            return ANDROID_HOME_FEED_ED_HELPER_TABLET;

        case 30026: 
            return ANDROID_REPIN_ED_HELPER;

        case 30027: 
            return ANDROID_REPIN_ED_TABLET;

        case 30028: 
            return ANDROID_REPIN_ED_HELPER_TABLET;

        case 30029: 
            return ANDROID_CLICKTHROUGH_ED_HELPER;

        case 30030: 
            return ANDROID_CLICKTHROUGH_ED_TABLET;

        case 30031: 
            return ANDROID_CLICKTHROUGH_ED_HELPER_TABLET;

        case 30032: 
            return ANDROID_NAG_CONNECT_FACEBOOK;

        case 30033: 
            return ANDROID_NAG_UPLOAD_CONTACTS;

        case 30034: 
            return ANDROID_BOARD_FOLLOW_ED;

        case 30035: 
            return ANDROID_BOARD_FOLLOW_ED_HELPER;

        case 30036: 
            return ANDROID_BOARD_FOLLOW_ED_TABLET;

        case 30037: 
            return ANDROID_BOARD_FOLLOW_ED_HELPER_TABLET;

        case 30038: 
            return ANDROID_PROFILE_FOLLOW_ED;

        case 30039: 
            return ANDROID_PROFILE_FOLLOW_ED_HELPER;

        case 30040: 
            return ANDROID_PROFILE_FOLLOW_ED_TABLET;

        case 30041: 
            return ANDROID_PROFILE_FOLLOW_ED_HELPER_TABLET;

        case 30042: 
            return ANDROID_HERO_PROMPT_REBUILD_FEED;

        case 30043: 
            return ANDROID_HERO_UNDO_REBUILD_FEED;

        case 30044: 
            return ANDROID_NUX_REBUILD_FEED;

        case 30045: 
            return ANDROID_SURVEY_201501;

        case 30046: 
            return ANDROID_NAG_PINVITATIONAL;

        case 30047: 
            return ANDROID_PINVITATIONAL_CONFIRM_BOARD;

        case 30048: 
            return ANDROID_REPIN_ED_V2;

        case 30049: 
            return ANDROID_REPIN_ED_V2_HELPER;

        case 30050: 
            return ANDROID_PINVITATIONAL_HOME_FEED_MODAL;

        case 30051: 
            return ANDROID_HOME_FEED_ED_V2;

        case 30052: 
            return ANDROID_HOME_FEED_ED_V2_HELPER;

        case 40000: 
            return WEB_MOBILE_NOOP;

        case 40001: 
            return WEB_MOBILE_NUX_MANDATORY;

        case 40002: 
            return WEB_MOBILE_NUX_INTERESTS;

        case 50000: 
            return PUSH_NOTIFICATION_NOOP;

        case 50001: 
            return PUSH_NOTIFICATION_SIMILAR_REPINS;

        case 50002: 
            return PUSH_NOTIFICATION_PIN_TWINS;

        case 50003: 
            return PUSH_NOTIFICATION_FRIEND_PIN;

        case 60000: 
            return ANALYTICS_NOOP;

        case 60001: 
            return ANALYTICS_HOME_USER_ED;

        case 60002: 
            return ANALYTICS_AUDIENCE_SELECTOR_USER_ED;

        case 70000: 
            return EMAIL_NOOP;

        case 70001: 
            return EMAIL_USER_ED_TIP_EMPTY_BOARD;

        case 70002: 
            return EMAIL_USER_ED_TIP_REPIN;

        case 70003: 
            return EMAIL_USER_ED_TIP_CLICKTHROUGH;

        case 70004: 
            return EMAIL_USER_ED_TIP_SEARCH;

        case 70005: 
            return EMAIL_USER_ED_TIP_EMAIL_VERIFY;

        case 70006: 
            return EMAIL_USER_ED_TIP_PIN_CREATE;

        case 70007: 
            return EMAIL_USER_ED_TIP_PINIT_BUTTON;

        case 80000: 
            return BATCH_NOOP;

        case 80001: 
            return BATCH_EMAIL_FIRST_BOARD_CREATE;

        case 80002: 
            return BATCH_EMAIL_INTEREST_RECOMMENDATIONS;

        case 80003: 
            return BATCH_EMAIL_EMPTY_BOARD;

        case 80004: 
            return BATCH_EMAIL_GUIDED_SEARCH;

        case 80005: 
            return BATCH_EMAIL_FIRST_PIN_CREATE;

        case 80006: 
            return BATCH_EMAIL_FIRST_CLICKTHROUGH;

        case 80007: 
            return BATCH_EMAIL_MOBILE_APP_DOWNLOAD;

        case 80008: 
            return BATCH_EMAIL_POPULAR_PINS;

        case 80009: 
            return BATCH_PUSH_NOTIFICATION_HOLIDAY_GUIDE;

        case 80010: 
            return BATCH_PUSH_NOTIFICATION_ATHELETES_OUTDOORS;

        case 80011: 
            return BATCH_PUSH_NOTIFICATION_GARDENING;

        case 80012: 
            return BATCH_PUSH_NOTIFICATION_FOOD;

        case 80013: 
            return BATCH_PUSH_NOTIFICATION_KIDS;

        case 80014: 
            return BATCH_PUSH_NOTIFICATION_CREATE_RESOLUTION_BOARD;

        case 80015: 
            return BATCH_PUSH_NOTIFICATION_RESOLUTION_IDEAS;

        case 80016: 
            return BATCH_PUSH_NOTIFICATION_SHARE_BOARD;

        case 80017: 
            return BATCH_EMAIL_HOMEFEED_NEW_PINS;

        case 80018: 
            return BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_1;

        case 80019: 
            return BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_2;

        case 80020: 
            return BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_3;

        case 80021: 
            return BATCH_NETWORK_STORY_VALENTINE;
        }
    }

    public static Experience valueOf(String s)
    {
        return (Experience)Enum.valueOf(com/pinterest/schemas/experiences/Experience, s);
    }

    public static Experience[] values()
    {
        return (Experience[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NOOP = new Experience("NOOP", 0, 1);
        CONFIRM_EMAIL = new Experience("CONFIRM_EMAIL", 1, 2);
        WEB_NOOP = new Experience("WEB_NOOP", 2, 10000);
        WEB_FEED_EDITOR_USER_ED = new Experience("WEB_FEED_EDITOR_USER_ED", 3, 10001);
        WEB_PIN_CLOSEUP_LITE = new Experience("WEB_PIN_CLOSEUP_LITE", 4, 10002);
        WEB_PIN_CLOSEUP_AUTOBAHN = new Experience("WEB_PIN_CLOSEUP_AUTOBAHN", 5, 10003);
        WEB_MANDATORY_AUTOBAHN = new Experience("WEB_MANDATORY_AUTOBAHN", 6, 10004);
        WEB_FIRST_PIN_SUCCESS = new Experience("WEB_FIRST_PIN_SUCCESS", 7, 10005);
        WEB_SEARCH_DISCOVER_TOOLTIP = new Experience("WEB_SEARCH_DISCOVER_TOOLTIP", 8, 10006);
        WEB_FIRST_FOLLOW = new Experience("WEB_FIRST_FOLLOW", 9, 10007);
        WEB_PINIT_BOOKMARKLET = new Experience("WEB_PINIT_BOOKMARKLET", 10, 10008);
        WEB_BLANK_SESSION = new Experience("WEB_BLANK_SESSION", 11, 10009);
        WEB_FIRST_PIN_USER_ED = new Experience("WEB_FIRST_PIN_USER_ED", 12, 10010);
        WEB_YOUR_BOARDS_USER_ED = new Experience("WEB_YOUR_BOARDS_USER_ED", 13, 10011);
        WEB_FAST_FOLLOW_USER_ED = new Experience("WEB_FAST_FOLLOW_USER_ED", 14, 10012);
        WEB_FIND_FRIENDS_USER_ED = new Experience("WEB_FIND_FRIENDS_USER_ED", 15, 10013);
        WEB_CATEGORY_SEARCH_USER_ED = new Experience("WEB_CATEGORY_SEARCH_USER_ED", 16, 10014);
        WEB_PLACE_PINS_TOOLTIP = new Experience("WEB_PLACE_PINS_TOOLTIP", 17, 10015);
        WEB_EMPTY_PLACES_BOARD_USER_ED = new Experience("WEB_EMPTY_PLACES_BOARD_USER_ED", 18, 10016);
        WEB_FILLED_PLACES_BOARD_USER_ED = new Experience("WEB_FILLED_PLACES_BOARD_USER_ED", 19, 10017);
        WEB_FIRST_BOARD_USER_ED = new Experience("WEB_FIRST_BOARD_USER_ED", 20, 10018);
        WEB_EXPLORE_BUTTON_USER_ED = new Experience("WEB_EXPLORE_BUTTON_USER_ED", 21, 10019);
        WEB_EXPLORE_PAGE_USER_ED = new Experience("WEB_EXPLORE_PAGE_USER_ED", 22, 10020);
        WEB_MODERN_HEADER_USER_ED = new Experience("WEB_MODERN_HEADER_USER_ED", 23, 10021);
        WEB_PIN_SUCCESS_EXTENSION_UPSELL = new Experience("WEB_PIN_SUCCESS_EXTENSION_UPSELL", 24, 10022);
        WEB_EXPLORE_HEADER_USER_ED = new Experience("WEB_EXPLORE_HEADER_USER_ED", 25, 10023);
        WEB_VISUAL_OBJECT_SEARCH_CLOSEUP_USER_ED = new Experience("WEB_VISUAL_OBJECT_SEARCH_CLOSEUP_USER_ED", 26, 10024);
        WEB_MSGS_WELCOME_MESSAGE = new Experience("WEB_MSGS_WELCOME_MESSAGE", 27, 10025);
        WEB_USER_NEWS_APP_UPSELL = new Experience("WEB_USER_NEWS_APP_UPSELL", 28, 10026);
        WEB_INTL_PIN_USER_ED = new Experience("WEB_INTL_PIN_USER_ED", 29, 10027);
        WEB_FACEBOOK_CONNECT_HERO = new Experience("WEB_FACEBOOK_CONNECT_HERO", 30, 10028);
        WEB_FACEBOOK_PUBLISH_HERO = new Experience("WEB_FACEBOOK_PUBLISH_HERO", 31, 10029);
        WEB_HOMEFEED_CAROUSEL = new Experience("WEB_HOMEFEED_CAROUSEL", 32, 10030);
        WEB_REBUILD_FEED = new Experience("WEB_REBUILD_FEED", 33, 10031);
        WEB_GUIDED_SEARCH_HEADER_USER_ED = new Experience("WEB_GUIDED_SEARCH_HEADER_USER_ED", 34, 10032);
        WEB_GUIDED_SEARCH_USER_ED = new Experience("WEB_GUIDED_SEARCH_USER_ED", 35, 10033);
        WEB_BOARD_BULK_EDIT_ED = new Experience("WEB_BOARD_BULK_EDIT_ED", 36, 10034);
        WEB_FLEXIBLE_SET_UP = new Experience("WEB_FLEXIBLE_SET_UP", 37, 10035);
        WEB_SURVEY_201501 = new Experience("WEB_SURVEY_201501", 38, 10036);
        WEB_PINVITATIONAL_HOMEFEED_MODAL = new Experience("WEB_PINVITATIONAL_HOMEFEED_MODAL", 39, 10037);
        WEB_HERO_INVITE_FRIENDS = new Experience("WEB_HERO_INVITE_FRIENDS", 40, 10050);
        WEB_HERO_EMPTY_HOMEFEED = new Experience("WEB_HERO_EMPTY_HOMEFEED", 41, 10051);
        WEB_HERO_INSTALL_APP = new Experience("WEB_HERO_INSTALL_APP", 42, 10052);
        WEB_HERO_PINIT_BUTTON = new Experience("WEB_HERO_PINIT_BUTTON", 43, 10053);
        WEB_HERO_LANGUAGE = new Experience("WEB_HERO_LANGUAGE", 44, 10054);
        WEB_HERO_PINIT_WEBMASTER = new Experience("WEB_HERO_PINIT_WEBMASTER", 45, 10055);
        WEB_HERO_PLACE_PINS = new Experience("WEB_HERO_PLACE_PINS", 46, 10056);
        WEB_HERO_PLACE_PINS_BOARD = new Experience("WEB_HERO_PLACE_PINS_BOARD", 47, 10057);
        WEB_HERO_HOLIDAY_GUIDE = new Experience("WEB_HERO_HOLIDAY_GUIDE", 48, 10058);
        WEB_HERO_VALENTINES = new Experience("WEB_HERO_VALENTINES", 49, 10059);
        WEB_HERO_INSTALL_EXTENSION = new Experience("WEB_HERO_INSTALL_EXTENSION", 50, 10060);
        WEB_HERO_LANGUAGE_BROWSER_SAFE = new Experience("WEB_HERO_LANGUAGE_BROWSER_SAFE", 51, 10061);
        WEB_HERO_PINIT_BUTTON_INTERNATIONAL = new Experience("WEB_HERO_PINIT_BUTTON_INTERNATIONAL", 52, 10062);
        WEB_HERO_CONVERT_TO_BUSINESS = new Experience("WEB_HERO_CONVERT_TO_BUSINESS", 53, 10063);
        WEB_HERO_PROMOTE_A_PIN = new Experience("WEB_HERO_PROMOTE_A_PIN", 54, 10064);
        WEB_HERO_WORLD_CUP = new Experience("WEB_HERO_WORLD_CUP", 55, 10065);
        WEB_HERO_SCOOTER_PINNER_STORY = new Experience("WEB_HERO_SCOOTER_PINNER_STORY", 56, 10066);
        WEB_HERO_PROMOTED_PINS_BETA_REMINDER = new Experience("WEB_HERO_PROMOTED_PINS_BETA_REMINDER", 57, 10067);
        WEB_HERO_NEW_ANALYTICS_NAG = new Experience("WEB_HERO_NEW_ANALYTICS_NAG", 58, 10068);
        WEB_HERO_APP_UPSELL = new Experience("WEB_HERO_APP_UPSELL", 59, 10069);
        WEB_HERO_NEW_ANALYTICS_CONVERT_TO_BIZ_NAG = new Experience("WEB_HERO_NEW_ANALYTICS_CONVERT_TO_BIZ_NAG", 60, 10070);
        WEB_HERO_EMMY_AWARDS = new Experience("WEB_HERO_EMMY_AWARDS", 61, 10071);
        WEB_HERO_PROMPT_REBUILD_FEED = new Experience("WEB_HERO_PROMPT_REBUILD_FEED", 62, 10072);
        WEB_HERO_UNDO_REBUILD_FEED = new Experience("WEB_HERO_UNDO_REBUILD_FEED", 63, 10073);
        WEB_HERO_ADS_PRIVACY_UPDATE = new Experience("WEB_HERO_ADS_PRIVACY_UPDATE", 64, 10074);
        WEB_HERO_BUSINESS_HOLIDAY_BOARD_NAG = new Experience("WEB_HERO_BUSINESS_HOLIDAY_BOARD_NAG", 65, 10075);
        WEB_HERO_PINNER_HOLIDAY_BOARD_NAG = new Experience("WEB_HERO_PINNER_HOLIDAY_BOARD_NAG", 66, 10076);
        WEB_HOME_HERO_PROMOTED_PINS_BETA_REMINDER = new Experience("WEB_HOME_HERO_PROMOTED_PINS_BETA_REMINDER", 67, 10077);
        WEB_HERO_PINVITATIONAL_INVITE_NAG = new Experience("WEB_HERO_PINVITATIONAL_INVITE_NAG", 68, 10078);
        WEB_PIN_SUCCESS_NEW_EXTENSION_UPSELL = new Experience("WEB_PIN_SUCCESS_NEW_EXTENSION_UPSELL", 69, 10100);
        WEB_PIN_SUCCESS_EXTENSION_ED_DOMAIN = new Experience("WEB_PIN_SUCCESS_EXTENSION_ED_DOMAIN", 70, 10101);
        WEB_PIN_SUCCESS_EXTENSION_ED_ODD_CONTENTS = new Experience("WEB_PIN_SUCCESS_EXTENSION_ED_ODD_CONTENTS", 71, 10102);
        WEB_PIN_SUCCESS_EXTENSION_ED_CATEGORY_BOXED = new Experience("WEB_PIN_SUCCESS_EXTENSION_ED_CATEGORY_BOXED", 72, 10103);
        WEB_PIN_SUCCESS_EXTENSION_ED_BOARD_BOXED = new Experience("WEB_PIN_SUCCESS_EXTENSION_ED_BOARD_BOXED", 73, 10104);
        WEB_NAG_ADS_PRIVACY_UPDATE = new Experience("WEB_NAG_ADS_PRIVACY_UPDATE", 74, 10200);
        WEB_NAG_LIMITED_LOGIN = new Experience("WEB_NAG_LIMITED_LOGIN", 75, 10201);
        WEB_QA_CLOSEUP_USER_ED = new Experience("WEB_QA_CLOSEUP_USER_ED", 76, 11000);
        WEB_QA_CLOSEUP_NOTIFICATION_USER_ED = new Experience("WEB_QA_CLOSEUP_NOTIFICATION_USER_ED", 77, 11001);
        WEB_EMPTY_BOARD_ED = new Experience("WEB_EMPTY_BOARD_ED", 78, 11002);
        WEB_EMPTY_PROFILE_ED = new Experience("WEB_EMPTY_PROFILE_ED", 79, 11003);
        WEB_EMPTY_BOARD_ED_MANUAL = new Experience("WEB_EMPTY_BOARD_ED_MANUAL", 80, 11004);
        WEB_EMPTY_PROFILE_ED_MANUAL = new Experience("WEB_EMPTY_PROFILE_ED_MANUAL", 81, 11005);
        WEB_HOME_FEED_ED = new Experience("WEB_HOME_FEED_ED", 82, 11006);
        WEB_REPIN_ED = new Experience("WEB_REPIN_ED", 83, 11007);
        WEB_HOME_FEED_ED_MANUAL = new Experience("WEB_HOME_FEED_ED_MANUAL", 84, 11008);
        WEB_REPIN_ED_MANUAL = new Experience("WEB_REPIN_ED_MANUAL", 85, 11009);
        WEB_CLICKTHROUGH_ED = new Experience("WEB_CLICKTHROUGH_ED", 86, 11010);
        WEB_CLICKTHROUGH_ED_MANUAL = new Experience("WEB_CLICKTHROUGH_ED_MANUAL", 87, 11011);
        WEB_UNAUTH_PIN_CLOSEUP = new Experience("WEB_UNAUTH_PIN_CLOSEUP", 88, 12000);
        WEB_TEST = new Experience("WEB_TEST", 89, 19999);
        IOS_NOOP = new Experience("IOS_NOOP", 90, 20000);
        IOS_NAG_CONFIRM_EMAIL = new Experience("IOS_NAG_CONFIRM_EMAIL", 91, 20001);
        IOS_NAG_PLACE_PINS = new Experience("IOS_NAG_PLACE_PINS", 92, 20002);
        IOS_NAG_INVITER = new Experience("IOS_NAG_INVITER", 93, 20003);
        IOS_NUX_FIRST_PIN = new Experience("IOS_NUX_FIRST_PIN", 94, 20004);
        IOS_NUX_MANDATORY = new Experience("IOS_NUX_MANDATORY", 95, 20005);
        IOS_HOME_WELCOME_HELPER = new Experience("IOS_HOME_WELCOME_HELPER", 96, 20006);
        IOS_PINS_LIVE_PROFILE_HELPER = new Experience("IOS_PINS_LIVE_PROFILE_HELPER", 97, 20007);
        IOS_NAG_WRITE_BANNED = new Experience("IOS_NAG_WRITE_BANNED", 98, 20008);
        IOS_NAG_CONFIRM_EMAIL_V3_5_1 = new Experience("IOS_NAG_CONFIRM_EMAIL_V3_5_1", 99, 20009);
        IOS_QA_EDUCATION = new Experience("IOS_QA_EDUCATION", 100, 20010);
        IOS_CONTACTS_PERMISSIONS = new Experience("IOS_CONTACTS_PERMISSIONS", 101, 20011);
        IOS_CONTACTS_AND_FACEBOOK_PERMISSIONS = new Experience("IOS_CONTACTS_AND_FACEBOOK_PERMISSIONS", 102, 20012);
        IOS_UPDATE_APP_HELPER = new Experience("IOS_UPDATE_APP_HELPER", 103, 20013);
        IOS_EMPTY_BOARD_ED = new Experience("IOS_EMPTY_BOARD_ED", 104, 20014);
        IOS_EMPTY_USER_PROFILE_ED = new Experience("IOS_EMPTY_USER_PROFILE_ED", 105, 20015);
        IOS_EMPTY_BOARD_ED_HELPER = new Experience("IOS_EMPTY_BOARD_ED_HELPER", 106, 20016);
        IOS_EMPTY_USER_PROFILE_ED_HELPER = new Experience("IOS_EMPTY_USER_PROFILE_ED_HELPER", 107, 20017);
        IOS_QA_NOTIFICATION_EDUCATION = new Experience("IOS_QA_NOTIFICATION_EDUCATION", 108, 20018);
        IOS_NUX_MANDATORY_MEN = new Experience("IOS_NUX_MANDATORY_MEN", 109, 20019);
        IOS_NUX_MANDATORY_WOMEN = new Experience("IOS_NUX_MANDATORY_WOMEN", 110, 20020);
        IOS_MSGS_NOTIFICATIONS_USER_ED = new Experience("IOS_MSGS_NOTIFICATIONS_USER_ED", 111, 20021);
        IOS_MSGS_MESSAGE_LIST_USER_ED = new Experience("IOS_MSGS_MESSAGE_LIST_USER_ED", 112, 20022);
        IOS_MSGS_MESSAGE_USER_ED = new Experience("IOS_MSGS_MESSAGE_USER_ED", 113, 20023);
        IOS_MSGS_NOTIFICATIONS_USER_ED_IPAD = new Experience("IOS_MSGS_NOTIFICATIONS_USER_ED_IPAD", 114, 20024);
        IOS_MSGS_MESSAGE_USER_ED_IPAD = new Experience("IOS_MSGS_MESSAGE_USER_ED_IPAD", 115, 20025);
        IOS_MSGS_WELCOME_MESSAGE = new Experience("IOS_MSGS_WELCOME_MESSAGE", 116, 20026);
        IOS_EMMY_AWARDS = new Experience("IOS_EMMY_AWARDS", 117, 20027);
        IOS_NAG_ADS_PRIVACY_UPDATE = new Experience("IOS_NAG_ADS_PRIVACY_UPDATE", 118, 20028);
        IOS_REPIN_ED = new Experience("IOS_REPIN_ED", 119, 20029);
        IOS_REPIN_ED_HELPER = new Experience("IOS_REPIN_ED_HELPER", 120, 20030);
        IOS_REPIN_ED_IPAD = new Experience("IOS_REPIN_ED_IPAD", 121, 20031);
        IOS_REPIN_ED_HELPER_IPAD = new Experience("IOS_REPIN_ED_HELPER_IPAD", 122, 20032);
        IOS_HOME_FEED_ED = new Experience("IOS_HOME_FEED_ED", 123, 20033);
        IOS_HOME_FEED_ED_HELPER = new Experience("IOS_HOME_FEED_ED_HELPER", 124, 20034);
        IOS_NAG_REBUILD_FEED = new Experience("IOS_NAG_REBUILD_FEED", 125, 20035);
        IOS_NAG_UNDO_REBUILD_FEED = new Experience("IOS_NAG_UNDO_REBUILD_FEED", 126, 20036);
        IOS_NUX_REBUILD_FEED = new Experience("IOS_NUX_REBUILD_FEED", 127, 20037);
        IOS_CREATE_BUTTON_ED = new Experience("IOS_CREATE_BUTTON_ED", 128, 20038);
        IOS_PUSH_NOTIFICATION_PERMISSION_PROMPT = new Experience("IOS_PUSH_NOTIFICATION_PERMISSION_PROMPT", 129, 20039);
        IOS_BOARD_FOLLOW_ED = new Experience("IOS_BOARD_FOLLOW_ED", 130, 20040);
        IOS_BOARD_FOLLOW_ED_HELPER = new Experience("IOS_BOARD_FOLLOW_ED_HELPER", 131, 20041);
        IOS_PROFILE_FOLLOW_ED = new Experience("IOS_PROFILE_FOLLOW_ED", 132, 20042);
        IOS_PROFILE_FOLLOW_ED_HELPER = new Experience("IOS_PROFILE_FOLLOW_ED_HELPER", 133, 20043);
        IOS_CLICKTHROUGH_ED = new Experience("IOS_CLICKTHROUGH_ED", 134, 20044);
        IOS_CLICKTHROUGH_ED_HELPER = new Experience("IOS_CLICKTHROUGH_ED_HELPER", 135, 20045);
        IOS_COMBINED_SEARCH_ED = new Experience("IOS_COMBINED_SEARCH_ED", 136, 20046);
        IOS_COMBINED_SEARCH_ED_HELPER = new Experience("IOS_COMBINED_SEARCH_ED_HELPER", 137, 20047);
        IOS_GUIDED_SEARCH_ED = new Experience("IOS_GUIDED_SEARCH_ED", 138, 20048);
        IOS_GUIDED_SEARCH_ED_HELPER = new Experience("IOS_GUIDED_SEARCH_ED_HELPER", 139, 20049);
        IOS_CONTEXTUAL_MENU_ED = new Experience("IOS_CONTEXTUAL_MENU_ED", 140, 20050);
        IOS_MSGS_SEND_PIN_ED = new Experience("IOS_MSGS_SEND_PIN_ED", 141, 20051);
        IOS_MSGS_SEND_PIN_ED_HELPER = new Experience("IOS_MSGS_SEND_PIN_ED_HELPER", 142, 20052);
        IOS_NAG_PINVITATIONAL = new Experience("IOS_NAG_PINVITATIONAL", 143, 20053);
        IOS_NAG_PINVITATIONAL_REFRESH = new Experience("IOS_NAG_PINVITATIONAL_REFRESH", 144, 20054);
        IOS_PINVITATIONAL_HOME_FEED_MODAL = new Experience("IOS_PINVITATIONAL_HOME_FEED_MODAL", 145, 20055);
        IOS_NUX_FIRST_BOARD = new Experience("IOS_NUX_FIRST_BOARD", 146, 20056);
        IOS_NUX_BUILD_HOMEFEED = new Experience("IOS_NUX_BUILD_HOMEFEED", 147, 20057);
        IOS_NUX_SEARCH_WELCOME_HELPER = new Experience("IOS_NUX_SEARCH_WELCOME_HELPER", 148, 20058);
        IOS_NUX_SEARCH_LIVE_PROFILE_HELPER = new Experience("IOS_NUX_SEARCH_LIVE_PROFILE_HELPER", 149, 20059);
        IOS_NUX_INTEREST_PICKER = new Experience("IOS_NUX_INTEREST_PICKER", 150, 20060);
        IOS_TEST = new Experience("IOS_TEST", 151, 29999);
        ANDROID_NOOP = new Experience("ANDROID_NOOP", 152, 30000);
        ANDROID_HERO_EMPTY_HOMEFEED = new Experience("ANDROID_HERO_EMPTY_HOMEFEED", 153, 30001);
        ANDROID_NAG_CONFIRM_EMAIL = new Experience("ANDROID_NAG_CONFIRM_EMAIL", 154, 30002);
        ANDROID_NAG_WRITE_BANNED = new Experience("ANDROID_NAG_WRITE_BANNED", 155, 30003);
        ANDROID_NAG_INVITER = new Experience("ANDROID_NAG_INVITER", 156, 30004);
        ANDROID_EMPTY_BOARD_ED = new Experience("ANDROID_EMPTY_BOARD_ED", 157, 30005);
        ANDROID_EMPTY_USER_PROFILE_ED = new Experience("ANDROID_EMPTY_USER_PROFILE_ED", 158, 30006);
        ANDROID_QA_EDUCATION = new Experience("ANDROID_QA_EDUCATION", 159, 30007);
        ANDROID_QA_NOTIFICATION_EDUCATION = new Experience("ANDROID_QA_NOTIFICATION_EDUCATION", 160, 30008);
        ANDROID_EMPTY_BOARD_ED_HELPER = new Experience("ANDROID_EMPTY_BOARD_ED_HELPER", 161, 30009);
        ANDROID_EMPTY_USER_PROFILE_ED_HELPER = new Experience("ANDROID_EMPTY_USER_PROFILE_ED_HELPER", 162, 30010);
        ANDROID_NUX_MANDATORY_MEN = new Experience("ANDROID_NUX_MANDATORY_MEN", 163, 30011);
        ANDROID_NUX_MANDATORY_WOMEN = new Experience("ANDROID_NUX_MANDATORY_WOMEN", 164, 30012);
        ANDROID_EMPTY_BOARD_ED_TABLET = new Experience("ANDROID_EMPTY_BOARD_ED_TABLET", 165, 30013);
        ANDROID_EMPTY_BOARD_ED_HELPER_TABLET = new Experience("ANDROID_EMPTY_BOARD_ED_HELPER_TABLET", 166, 30014);
        ANDROID_EMPTY_USER_PROFILE_ED_TABLET = new Experience("ANDROID_EMPTY_USER_PROFILE_ED_TABLET", 167, 30015);
        ANDROID_EMPTY_USER_PROFILE_ED_HELPER_TABLET = new Experience("ANDROID_EMPTY_USER_PROFILE_ED_HELPER_TABLET", 168, 30016);
        ANDROID_CLICKTHROUGH_ED = new Experience("ANDROID_CLICKTHROUGH_ED", 169, 30017);
        ANDROID_MSGS_WELCOME_MESSAGE = new Experience("ANDROID_MSGS_WELCOME_MESSAGE", 170, 30018);
        ANDROID_EMMY_AWARDS = new Experience("ANDROID_EMMY_AWARDS", 171, 30019);
        ANDROID_HOME_FEED_ED = new Experience("ANDROID_HOME_FEED_ED", 172, 30020);
        ANDROID_REPIN_ED = new Experience("ANDROID_REPIN_ED", 173, 30021);
        ANDROID_NAG_ADS_PRIVACY_UPDATE = new Experience("ANDROID_NAG_ADS_PRIVACY_UPDATE", 174, 30022);
        ANDROID_HOME_FEED_ED_HELPER = new Experience("ANDROID_HOME_FEED_ED_HELPER", 175, 30023);
        ANDROID_HOME_FEED_ED_TABLET = new Experience("ANDROID_HOME_FEED_ED_TABLET", 176, 30024);
        ANDROID_HOME_FEED_ED_HELPER_TABLET = new Experience("ANDROID_HOME_FEED_ED_HELPER_TABLET", 177, 30025);
        ANDROID_REPIN_ED_HELPER = new Experience("ANDROID_REPIN_ED_HELPER", 178, 30026);
        ANDROID_REPIN_ED_TABLET = new Experience("ANDROID_REPIN_ED_TABLET", 179, 30027);
        ANDROID_REPIN_ED_HELPER_TABLET = new Experience("ANDROID_REPIN_ED_HELPER_TABLET", 180, 30028);
        ANDROID_CLICKTHROUGH_ED_HELPER = new Experience("ANDROID_CLICKTHROUGH_ED_HELPER", 181, 30029);
        ANDROID_CLICKTHROUGH_ED_TABLET = new Experience("ANDROID_CLICKTHROUGH_ED_TABLET", 182, 30030);
        ANDROID_CLICKTHROUGH_ED_HELPER_TABLET = new Experience("ANDROID_CLICKTHROUGH_ED_HELPER_TABLET", 183, 30031);
        ANDROID_NAG_CONNECT_FACEBOOK = new Experience("ANDROID_NAG_CONNECT_FACEBOOK", 184, 30032);
        ANDROID_NAG_UPLOAD_CONTACTS = new Experience("ANDROID_NAG_UPLOAD_CONTACTS", 185, 30033);
        ANDROID_BOARD_FOLLOW_ED = new Experience("ANDROID_BOARD_FOLLOW_ED", 186, 30034);
        ANDROID_BOARD_FOLLOW_ED_HELPER = new Experience("ANDROID_BOARD_FOLLOW_ED_HELPER", 187, 30035);
        ANDROID_BOARD_FOLLOW_ED_TABLET = new Experience("ANDROID_BOARD_FOLLOW_ED_TABLET", 188, 30036);
        ANDROID_BOARD_FOLLOW_ED_HELPER_TABLET = new Experience("ANDROID_BOARD_FOLLOW_ED_HELPER_TABLET", 189, 30037);
        ANDROID_PROFILE_FOLLOW_ED = new Experience("ANDROID_PROFILE_FOLLOW_ED", 190, 30038);
        ANDROID_PROFILE_FOLLOW_ED_HELPER = new Experience("ANDROID_PROFILE_FOLLOW_ED_HELPER", 191, 30039);
        ANDROID_PROFILE_FOLLOW_ED_TABLET = new Experience("ANDROID_PROFILE_FOLLOW_ED_TABLET", 192, 30040);
        ANDROID_PROFILE_FOLLOW_ED_HELPER_TABLET = new Experience("ANDROID_PROFILE_FOLLOW_ED_HELPER_TABLET", 193, 30041);
        ANDROID_HERO_PROMPT_REBUILD_FEED = new Experience("ANDROID_HERO_PROMPT_REBUILD_FEED", 194, 30042);
        ANDROID_HERO_UNDO_REBUILD_FEED = new Experience("ANDROID_HERO_UNDO_REBUILD_FEED", 195, 30043);
        ANDROID_NUX_REBUILD_FEED = new Experience("ANDROID_NUX_REBUILD_FEED", 196, 30044);
        ANDROID_SURVEY_201501 = new Experience("ANDROID_SURVEY_201501", 197, 30045);
        ANDROID_NAG_PINVITATIONAL = new Experience("ANDROID_NAG_PINVITATIONAL", 198, 30046);
        ANDROID_PINVITATIONAL_CONFIRM_BOARD = new Experience("ANDROID_PINVITATIONAL_CONFIRM_BOARD", 199, 30047);
        ANDROID_REPIN_ED_V2 = new Experience("ANDROID_REPIN_ED_V2", 200, 30048);
        ANDROID_REPIN_ED_V2_HELPER = new Experience("ANDROID_REPIN_ED_V2_HELPER", 201, 30049);
        ANDROID_PINVITATIONAL_HOME_FEED_MODAL = new Experience("ANDROID_PINVITATIONAL_HOME_FEED_MODAL", 202, 30050);
        ANDROID_HOME_FEED_ED_V2 = new Experience("ANDROID_HOME_FEED_ED_V2", 203, 30051);
        ANDROID_HOME_FEED_ED_V2_HELPER = new Experience("ANDROID_HOME_FEED_ED_V2_HELPER", 204, 30052);
        WEB_MOBILE_NOOP = new Experience("WEB_MOBILE_NOOP", 205, 40000);
        WEB_MOBILE_NUX_MANDATORY = new Experience("WEB_MOBILE_NUX_MANDATORY", 206, 40001);
        WEB_MOBILE_NUX_INTERESTS = new Experience("WEB_MOBILE_NUX_INTERESTS", 207, 40002);
        PUSH_NOTIFICATION_NOOP = new Experience("PUSH_NOTIFICATION_NOOP", 208, 50000);
        PUSH_NOTIFICATION_SIMILAR_REPINS = new Experience("PUSH_NOTIFICATION_SIMILAR_REPINS", 209, 50001);
        PUSH_NOTIFICATION_PIN_TWINS = new Experience("PUSH_NOTIFICATION_PIN_TWINS", 210, 50002);
        PUSH_NOTIFICATION_FRIEND_PIN = new Experience("PUSH_NOTIFICATION_FRIEND_PIN", 211, 50003);
        ANALYTICS_NOOP = new Experience("ANALYTICS_NOOP", 212, 60000);
        ANALYTICS_HOME_USER_ED = new Experience("ANALYTICS_HOME_USER_ED", 213, 60001);
        ANALYTICS_AUDIENCE_SELECTOR_USER_ED = new Experience("ANALYTICS_AUDIENCE_SELECTOR_USER_ED", 214, 60002);
        EMAIL_NOOP = new Experience("EMAIL_NOOP", 215, 0x11170);
        EMAIL_USER_ED_TIP_EMPTY_BOARD = new Experience("EMAIL_USER_ED_TIP_EMPTY_BOARD", 216, 0x11171);
        EMAIL_USER_ED_TIP_REPIN = new Experience("EMAIL_USER_ED_TIP_REPIN", 217, 0x11172);
        EMAIL_USER_ED_TIP_CLICKTHROUGH = new Experience("EMAIL_USER_ED_TIP_CLICKTHROUGH", 218, 0x11173);
        EMAIL_USER_ED_TIP_SEARCH = new Experience("EMAIL_USER_ED_TIP_SEARCH", 219, 0x11174);
        EMAIL_USER_ED_TIP_EMAIL_VERIFY = new Experience("EMAIL_USER_ED_TIP_EMAIL_VERIFY", 220, 0x11175);
        EMAIL_USER_ED_TIP_PIN_CREATE = new Experience("EMAIL_USER_ED_TIP_PIN_CREATE", 221, 0x11176);
        EMAIL_USER_ED_TIP_PINIT_BUTTON = new Experience("EMAIL_USER_ED_TIP_PINIT_BUTTON", 222, 0x11177);
        BATCH_NOOP = new Experience("BATCH_NOOP", 223, 0x13880);
        BATCH_EMAIL_FIRST_BOARD_CREATE = new Experience("BATCH_EMAIL_FIRST_BOARD_CREATE", 224, 0x13881);
        BATCH_EMAIL_INTEREST_RECOMMENDATIONS = new Experience("BATCH_EMAIL_INTEREST_RECOMMENDATIONS", 225, 0x13882);
        BATCH_EMAIL_EMPTY_BOARD = new Experience("BATCH_EMAIL_EMPTY_BOARD", 226, 0x13883);
        BATCH_EMAIL_GUIDED_SEARCH = new Experience("BATCH_EMAIL_GUIDED_SEARCH", 227, 0x13884);
        BATCH_EMAIL_FIRST_PIN_CREATE = new Experience("BATCH_EMAIL_FIRST_PIN_CREATE", 228, 0x13885);
        BATCH_EMAIL_FIRST_CLICKTHROUGH = new Experience("BATCH_EMAIL_FIRST_CLICKTHROUGH", 229, 0x13886);
        BATCH_EMAIL_MOBILE_APP_DOWNLOAD = new Experience("BATCH_EMAIL_MOBILE_APP_DOWNLOAD", 230, 0x13887);
        BATCH_EMAIL_POPULAR_PINS = new Experience("BATCH_EMAIL_POPULAR_PINS", 231, 0x13888);
        BATCH_PUSH_NOTIFICATION_HOLIDAY_GUIDE = new Experience("BATCH_PUSH_NOTIFICATION_HOLIDAY_GUIDE", 232, 0x13889);
        BATCH_PUSH_NOTIFICATION_ATHELETES_OUTDOORS = new Experience("BATCH_PUSH_NOTIFICATION_ATHELETES_OUTDOORS", 233, 0x1388a);
        BATCH_PUSH_NOTIFICATION_GARDENING = new Experience("BATCH_PUSH_NOTIFICATION_GARDENING", 234, 0x1388b);
        BATCH_PUSH_NOTIFICATION_FOOD = new Experience("BATCH_PUSH_NOTIFICATION_FOOD", 235, 0x1388c);
        BATCH_PUSH_NOTIFICATION_KIDS = new Experience("BATCH_PUSH_NOTIFICATION_KIDS", 236, 0x1388d);
        BATCH_PUSH_NOTIFICATION_CREATE_RESOLUTION_BOARD = new Experience("BATCH_PUSH_NOTIFICATION_CREATE_RESOLUTION_BOARD", 237, 0x1388e);
        BATCH_PUSH_NOTIFICATION_RESOLUTION_IDEAS = new Experience("BATCH_PUSH_NOTIFICATION_RESOLUTION_IDEAS", 238, 0x1388f);
        BATCH_PUSH_NOTIFICATION_SHARE_BOARD = new Experience("BATCH_PUSH_NOTIFICATION_SHARE_BOARD", 239, 0x13890);
        BATCH_EMAIL_HOMEFEED_NEW_PINS = new Experience("BATCH_EMAIL_HOMEFEED_NEW_PINS", 240, 0x13891);
        BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_1 = new Experience("BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_1", 241, 0x13892);
        BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_2 = new Experience("BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_2", 242, 0x13893);
        BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_3 = new Experience("BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_3", 243, 0x13894);
        BATCH_NETWORK_STORY_VALENTINE = new Experience("BATCH_NETWORK_STORY_VALENTINE", 244, 0x13895);
        $VALUES = (new Experience[] {
            NOOP, CONFIRM_EMAIL, WEB_NOOP, WEB_FEED_EDITOR_USER_ED, WEB_PIN_CLOSEUP_LITE, WEB_PIN_CLOSEUP_AUTOBAHN, WEB_MANDATORY_AUTOBAHN, WEB_FIRST_PIN_SUCCESS, WEB_SEARCH_DISCOVER_TOOLTIP, WEB_FIRST_FOLLOW, 
            WEB_PINIT_BOOKMARKLET, WEB_BLANK_SESSION, WEB_FIRST_PIN_USER_ED, WEB_YOUR_BOARDS_USER_ED, WEB_FAST_FOLLOW_USER_ED, WEB_FIND_FRIENDS_USER_ED, WEB_CATEGORY_SEARCH_USER_ED, WEB_PLACE_PINS_TOOLTIP, WEB_EMPTY_PLACES_BOARD_USER_ED, WEB_FILLED_PLACES_BOARD_USER_ED, 
            WEB_FIRST_BOARD_USER_ED, WEB_EXPLORE_BUTTON_USER_ED, WEB_EXPLORE_PAGE_USER_ED, WEB_MODERN_HEADER_USER_ED, WEB_PIN_SUCCESS_EXTENSION_UPSELL, WEB_EXPLORE_HEADER_USER_ED, WEB_VISUAL_OBJECT_SEARCH_CLOSEUP_USER_ED, WEB_MSGS_WELCOME_MESSAGE, WEB_USER_NEWS_APP_UPSELL, WEB_INTL_PIN_USER_ED, 
            WEB_FACEBOOK_CONNECT_HERO, WEB_FACEBOOK_PUBLISH_HERO, WEB_HOMEFEED_CAROUSEL, WEB_REBUILD_FEED, WEB_GUIDED_SEARCH_HEADER_USER_ED, WEB_GUIDED_SEARCH_USER_ED, WEB_BOARD_BULK_EDIT_ED, WEB_FLEXIBLE_SET_UP, WEB_SURVEY_201501, WEB_PINVITATIONAL_HOMEFEED_MODAL, 
            WEB_HERO_INVITE_FRIENDS, WEB_HERO_EMPTY_HOMEFEED, WEB_HERO_INSTALL_APP, WEB_HERO_PINIT_BUTTON, WEB_HERO_LANGUAGE, WEB_HERO_PINIT_WEBMASTER, WEB_HERO_PLACE_PINS, WEB_HERO_PLACE_PINS_BOARD, WEB_HERO_HOLIDAY_GUIDE, WEB_HERO_VALENTINES, 
            WEB_HERO_INSTALL_EXTENSION, WEB_HERO_LANGUAGE_BROWSER_SAFE, WEB_HERO_PINIT_BUTTON_INTERNATIONAL, WEB_HERO_CONVERT_TO_BUSINESS, WEB_HERO_PROMOTE_A_PIN, WEB_HERO_WORLD_CUP, WEB_HERO_SCOOTER_PINNER_STORY, WEB_HERO_PROMOTED_PINS_BETA_REMINDER, WEB_HERO_NEW_ANALYTICS_NAG, WEB_HERO_APP_UPSELL, 
            WEB_HERO_NEW_ANALYTICS_CONVERT_TO_BIZ_NAG, WEB_HERO_EMMY_AWARDS, WEB_HERO_PROMPT_REBUILD_FEED, WEB_HERO_UNDO_REBUILD_FEED, WEB_HERO_ADS_PRIVACY_UPDATE, WEB_HERO_BUSINESS_HOLIDAY_BOARD_NAG, WEB_HERO_PINNER_HOLIDAY_BOARD_NAG, WEB_HOME_HERO_PROMOTED_PINS_BETA_REMINDER, WEB_HERO_PINVITATIONAL_INVITE_NAG, WEB_PIN_SUCCESS_NEW_EXTENSION_UPSELL, 
            WEB_PIN_SUCCESS_EXTENSION_ED_DOMAIN, WEB_PIN_SUCCESS_EXTENSION_ED_ODD_CONTENTS, WEB_PIN_SUCCESS_EXTENSION_ED_CATEGORY_BOXED, WEB_PIN_SUCCESS_EXTENSION_ED_BOARD_BOXED, WEB_NAG_ADS_PRIVACY_UPDATE, WEB_NAG_LIMITED_LOGIN, WEB_QA_CLOSEUP_USER_ED, WEB_QA_CLOSEUP_NOTIFICATION_USER_ED, WEB_EMPTY_BOARD_ED, WEB_EMPTY_PROFILE_ED, 
            WEB_EMPTY_BOARD_ED_MANUAL, WEB_EMPTY_PROFILE_ED_MANUAL, WEB_HOME_FEED_ED, WEB_REPIN_ED, WEB_HOME_FEED_ED_MANUAL, WEB_REPIN_ED_MANUAL, WEB_CLICKTHROUGH_ED, WEB_CLICKTHROUGH_ED_MANUAL, WEB_UNAUTH_PIN_CLOSEUP, WEB_TEST, 
            IOS_NOOP, IOS_NAG_CONFIRM_EMAIL, IOS_NAG_PLACE_PINS, IOS_NAG_INVITER, IOS_NUX_FIRST_PIN, IOS_NUX_MANDATORY, IOS_HOME_WELCOME_HELPER, IOS_PINS_LIVE_PROFILE_HELPER, IOS_NAG_WRITE_BANNED, IOS_NAG_CONFIRM_EMAIL_V3_5_1, 
            IOS_QA_EDUCATION, IOS_CONTACTS_PERMISSIONS, IOS_CONTACTS_AND_FACEBOOK_PERMISSIONS, IOS_UPDATE_APP_HELPER, IOS_EMPTY_BOARD_ED, IOS_EMPTY_USER_PROFILE_ED, IOS_EMPTY_BOARD_ED_HELPER, IOS_EMPTY_USER_PROFILE_ED_HELPER, IOS_QA_NOTIFICATION_EDUCATION, IOS_NUX_MANDATORY_MEN, 
            IOS_NUX_MANDATORY_WOMEN, IOS_MSGS_NOTIFICATIONS_USER_ED, IOS_MSGS_MESSAGE_LIST_USER_ED, IOS_MSGS_MESSAGE_USER_ED, IOS_MSGS_NOTIFICATIONS_USER_ED_IPAD, IOS_MSGS_MESSAGE_USER_ED_IPAD, IOS_MSGS_WELCOME_MESSAGE, IOS_EMMY_AWARDS, IOS_NAG_ADS_PRIVACY_UPDATE, IOS_REPIN_ED, 
            IOS_REPIN_ED_HELPER, IOS_REPIN_ED_IPAD, IOS_REPIN_ED_HELPER_IPAD, IOS_HOME_FEED_ED, IOS_HOME_FEED_ED_HELPER, IOS_NAG_REBUILD_FEED, IOS_NAG_UNDO_REBUILD_FEED, IOS_NUX_REBUILD_FEED, IOS_CREATE_BUTTON_ED, IOS_PUSH_NOTIFICATION_PERMISSION_PROMPT, 
            IOS_BOARD_FOLLOW_ED, IOS_BOARD_FOLLOW_ED_HELPER, IOS_PROFILE_FOLLOW_ED, IOS_PROFILE_FOLLOW_ED_HELPER, IOS_CLICKTHROUGH_ED, IOS_CLICKTHROUGH_ED_HELPER, IOS_COMBINED_SEARCH_ED, IOS_COMBINED_SEARCH_ED_HELPER, IOS_GUIDED_SEARCH_ED, IOS_GUIDED_SEARCH_ED_HELPER, 
            IOS_CONTEXTUAL_MENU_ED, IOS_MSGS_SEND_PIN_ED, IOS_MSGS_SEND_PIN_ED_HELPER, IOS_NAG_PINVITATIONAL, IOS_NAG_PINVITATIONAL_REFRESH, IOS_PINVITATIONAL_HOME_FEED_MODAL, IOS_NUX_FIRST_BOARD, IOS_NUX_BUILD_HOMEFEED, IOS_NUX_SEARCH_WELCOME_HELPER, IOS_NUX_SEARCH_LIVE_PROFILE_HELPER, 
            IOS_NUX_INTEREST_PICKER, IOS_TEST, ANDROID_NOOP, ANDROID_HERO_EMPTY_HOMEFEED, ANDROID_NAG_CONFIRM_EMAIL, ANDROID_NAG_WRITE_BANNED, ANDROID_NAG_INVITER, ANDROID_EMPTY_BOARD_ED, ANDROID_EMPTY_USER_PROFILE_ED, ANDROID_QA_EDUCATION, 
            ANDROID_QA_NOTIFICATION_EDUCATION, ANDROID_EMPTY_BOARD_ED_HELPER, ANDROID_EMPTY_USER_PROFILE_ED_HELPER, ANDROID_NUX_MANDATORY_MEN, ANDROID_NUX_MANDATORY_WOMEN, ANDROID_EMPTY_BOARD_ED_TABLET, ANDROID_EMPTY_BOARD_ED_HELPER_TABLET, ANDROID_EMPTY_USER_PROFILE_ED_TABLET, ANDROID_EMPTY_USER_PROFILE_ED_HELPER_TABLET, ANDROID_CLICKTHROUGH_ED, 
            ANDROID_MSGS_WELCOME_MESSAGE, ANDROID_EMMY_AWARDS, ANDROID_HOME_FEED_ED, ANDROID_REPIN_ED, ANDROID_NAG_ADS_PRIVACY_UPDATE, ANDROID_HOME_FEED_ED_HELPER, ANDROID_HOME_FEED_ED_TABLET, ANDROID_HOME_FEED_ED_HELPER_TABLET, ANDROID_REPIN_ED_HELPER, ANDROID_REPIN_ED_TABLET, 
            ANDROID_REPIN_ED_HELPER_TABLET, ANDROID_CLICKTHROUGH_ED_HELPER, ANDROID_CLICKTHROUGH_ED_TABLET, ANDROID_CLICKTHROUGH_ED_HELPER_TABLET, ANDROID_NAG_CONNECT_FACEBOOK, ANDROID_NAG_UPLOAD_CONTACTS, ANDROID_BOARD_FOLLOW_ED, ANDROID_BOARD_FOLLOW_ED_HELPER, ANDROID_BOARD_FOLLOW_ED_TABLET, ANDROID_BOARD_FOLLOW_ED_HELPER_TABLET, 
            ANDROID_PROFILE_FOLLOW_ED, ANDROID_PROFILE_FOLLOW_ED_HELPER, ANDROID_PROFILE_FOLLOW_ED_TABLET, ANDROID_PROFILE_FOLLOW_ED_HELPER_TABLET, ANDROID_HERO_PROMPT_REBUILD_FEED, ANDROID_HERO_UNDO_REBUILD_FEED, ANDROID_NUX_REBUILD_FEED, ANDROID_SURVEY_201501, ANDROID_NAG_PINVITATIONAL, ANDROID_PINVITATIONAL_CONFIRM_BOARD, 
            ANDROID_REPIN_ED_V2, ANDROID_REPIN_ED_V2_HELPER, ANDROID_PINVITATIONAL_HOME_FEED_MODAL, ANDROID_HOME_FEED_ED_V2, ANDROID_HOME_FEED_ED_V2_HELPER, WEB_MOBILE_NOOP, WEB_MOBILE_NUX_MANDATORY, WEB_MOBILE_NUX_INTERESTS, PUSH_NOTIFICATION_NOOP, PUSH_NOTIFICATION_SIMILAR_REPINS, 
            PUSH_NOTIFICATION_PIN_TWINS, PUSH_NOTIFICATION_FRIEND_PIN, ANALYTICS_NOOP, ANALYTICS_HOME_USER_ED, ANALYTICS_AUDIENCE_SELECTOR_USER_ED, EMAIL_NOOP, EMAIL_USER_ED_TIP_EMPTY_BOARD, EMAIL_USER_ED_TIP_REPIN, EMAIL_USER_ED_TIP_CLICKTHROUGH, EMAIL_USER_ED_TIP_SEARCH, 
            EMAIL_USER_ED_TIP_EMAIL_VERIFY, EMAIL_USER_ED_TIP_PIN_CREATE, EMAIL_USER_ED_TIP_PINIT_BUTTON, BATCH_NOOP, BATCH_EMAIL_FIRST_BOARD_CREATE, BATCH_EMAIL_INTEREST_RECOMMENDATIONS, BATCH_EMAIL_EMPTY_BOARD, BATCH_EMAIL_GUIDED_SEARCH, BATCH_EMAIL_FIRST_PIN_CREATE, BATCH_EMAIL_FIRST_CLICKTHROUGH, 
            BATCH_EMAIL_MOBILE_APP_DOWNLOAD, BATCH_EMAIL_POPULAR_PINS, BATCH_PUSH_NOTIFICATION_HOLIDAY_GUIDE, BATCH_PUSH_NOTIFICATION_ATHELETES_OUTDOORS, BATCH_PUSH_NOTIFICATION_GARDENING, BATCH_PUSH_NOTIFICATION_FOOD, BATCH_PUSH_NOTIFICATION_KIDS, BATCH_PUSH_NOTIFICATION_CREATE_RESOLUTION_BOARD, BATCH_PUSH_NOTIFICATION_RESOLUTION_IDEAS, BATCH_PUSH_NOTIFICATION_SHARE_BOARD, 
            BATCH_EMAIL_HOMEFEED_NEW_PINS, BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_1, BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_2, BATCH_PUSH_NOTIFICATION_NEW_USER_DAY_3, BATCH_NETWORK_STORY_VALENTINE
        });
    }
}
