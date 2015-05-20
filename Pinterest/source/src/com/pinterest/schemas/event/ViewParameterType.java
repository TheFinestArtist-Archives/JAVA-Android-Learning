// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class ViewParameterType extends Enum
    implements TEnum
{

    private static final ViewParameterType $VALUES[];
    public static final ViewParameterType ABOUT_ABOUT;
    public static final ViewParameterType ABOUT_BOOKMARKLET;
    public static final ViewParameterType ABOUT_CAREERS;
    public static final ViewParameterType ABOUT_COPYRIGHT;
    public static final ViewParameterType ABOUT_ETIQUETTE;
    public static final ViewParameterType ABOUT_GOODIES;
    public static final ViewParameterType ABOUT_PRESS;
    public static final ViewParameterType ABOUT_PRIVACY;
    public static final ViewParameterType ABOUT_SUPPORT;
    public static final ViewParameterType ABOUT_TEAM;
    public static final ViewParameterType ABOUT_TERMS;
    public static final ViewParameterType ABOUT_USE;
    public static final ViewParameterType ACTIVITY_V2;
    public static final ViewParameterType ANALYTICS_DOMAIN_ALL_TIME;
    public static final ViewParameterType ANALYTICS_DOMAIN_CLICKS;
    public static final ViewParameterType ANALYTICS_DOMAIN_IMPRESSIONS;
    public static final ViewParameterType ANALYTICS_DOMAIN_ORIGINAL_PINS;
    public static final ViewParameterType ANALYTICS_DOMAIN_REPINS;
    public static final ViewParameterType ANALYTICS_PROFILE_ALL_TIME;
    public static final ViewParameterType ANALYTICS_PROFILE_CLICKS;
    public static final ViewParameterType ANALYTICS_PROFILE_IMPRESSIONS;
    public static final ViewParameterType ANALYTICS_PROFILE_REPINS;
    public static final ViewParameterType BOARD_COLLABORATORS;
    public static final ViewParameterType BOARD_CREATE;
    public static final ViewParameterType BOARD_EDIT;
    public static final ViewParameterType BOARD_EDIT_COLLABORATORS;
    public static final ViewParameterType BOARD_FOLLOWERS;
    public static final ViewParameterType BOARD_MAP;
    public static final ViewParameterType BOARD_PLACE;
    public static final ViewParameterType BOARD_SETTINGS;
    public static final ViewParameterType BROWSER;
    public static final ViewParameterType CATEGORY_DISCOVER;
    public static final ViewParameterType CONVERSATION_ADD_PIN;
    public static final ViewParameterType CONVERSATION_CREATE;
    public static final ViewParameterType CONVERSATION_INBOX;
    public static final ViewParameterType CONVERSATION_THREAD;
    public static final ViewParameterType CONVERSATION_USERS;
    public static final ViewParameterType DEEP_LINKING_APP;
    public static final ViewParameterType DEEP_LINKING_FACEBOOK;
    public static final ViewParameterType DEPRECATED_DEEP_LINKING_EMAIL;
    public static final ViewParameterType DEPRECATED_DEEP_LINKING_WEB;
    public static final ViewParameterType DISCOVER_CATEGORY;
    public static final ViewParameterType DISCOVER_INTEREST;
    public static final ViewParameterType DISCOVER_SEARCH_INTERESTS;
    public static final ViewParameterType EDUCATION_CONTEXTUAL_MENU;
    public static final ViewParameterType EDUCATION_FLYOUT;
    public static final ViewParameterType EDUCATION_GUIDED_SEARCH;
    public static final ViewParameterType EDUCATION_LONGPRESS;
    public static final ViewParameterType EDUCATION_RELATED_PINS;
    public static final ViewParameterType EDUCATION_SECRET_BOARD;
    public static final ViewParameterType EMAIL_ACTIVITY_AGGREGATION;
    public static final ViewParameterType EMAIL_ANSWER_CREATE;
    public static final ViewParameterType EMAIL_ANSWER_LIKE;
    public static final ViewParameterType EMAIL_BOARD_RECOMMENDATIONS;
    public static final ViewParameterType EMAIL_COMMENT_AND_MENTION;
    public static final ViewParameterType EMAIL_EDITORIAL;
    public static final ViewParameterType EMAIL_FIREHOSE_ANSWER_CREATE;
    public static final ViewParameterType EMAIL_FIREHOSE_QUESTION_CREATE;
    public static final ViewParameterType EMAIL_FIREHOSE_REPLY_CREATE;
    public static final ViewParameterType EMAIL_FRIEND_JOINED;
    public static final ViewParameterType EMAIL_HOMEFEED_NEW_PINS;
    public static final ViewParameterType EMAIL_INTEREST_RECOMMENDATIONS;
    public static final ViewParameterType EMAIL_NETWORK_STORY_DIGEST;
    public static final ViewParameterType EMAIL_PARTNER;
    public static final ViewParameterType EMAIL_PINVITATIONAL_ACCESS;
    public static final ViewParameterType EMAIL_PINVITATIONAL_RALLYING_CALL;
    public static final ViewParameterType EMAIL_PIN_RECOMMENDATIONS;
    public static final ViewParameterType EMAIL_QUESTION_CREATE;
    public static final ViewParameterType EMAIL_QUESTION_LIKE;
    public static final ViewParameterType EMAIL_RECOMMENDATIONS_DIGEST;
    public static final ViewParameterType EMAIL_REPLY_CREATE;
    public static final ViewParameterType EMAIL_RESTART_FEED;
    public static final ViewParameterType EMAIL_SEND_BOARD;
    public static final ViewParameterType EMAIL_SEND_PIN;
    public static final ViewParameterType EMAIL_SEND_PINNER;
    public static final ViewParameterType EMAIL_SOCIAL_DIGEST;
    public static final ViewParameterType EMAIL_TRANSACTIONAL;
    public static final ViewParameterType EMAIL_UNKNOWN;
    public static final ViewParameterType EMAIL_USECASES;
    public static final ViewParameterType EMAIL_WEEK_IN_REVIEW;
    public static final ViewParameterType EMAIL_WELCOME;
    public static final ViewParameterType ERROR_NO_ACTIVITY;
    public static final ViewParameterType ERROR_NO_BOARD;
    public static final ViewParameterType ERROR_NO_INTERNET;
    public static final ViewParameterType ERROR_NO_PIN;
    public static final ViewParameterType ERROR_NO_USER;
    public static final ViewParameterType EXTERNAL_SOURCE_OTHER;
    public static final ViewParameterType FEED_CATEGORY;
    public static final ViewParameterType FEED_CATEGORY_ANIMALS;
    public static final ViewParameterType FEED_CATEGORY_ARCHITECTURE;
    public static final ViewParameterType FEED_CATEGORY_ART;
    public static final ViewParameterType FEED_CATEGORY_CARS_MOTORCYCLES;
    public static final ViewParameterType FEED_CATEGORY_CELEBRITIES;
    public static final ViewParameterType FEED_CATEGORY_CHRISTMAS_SWEATER;
    public static final ViewParameterType FEED_CATEGORY_DESIGN;
    public static final ViewParameterType FEED_CATEGORY_DIY_CRAFTS;
    public static final ViewParameterType FEED_CATEGORY_EDUCATION;
    public static final ViewParameterType FEED_CATEGORY_FILM_MUSIC_BOOKS;
    public static final ViewParameterType FEED_CATEGORY_FOOD_DRINK;
    public static final ViewParameterType FEED_CATEGORY_GARDENING;
    public static final ViewParameterType FEED_CATEGORY_GEEK;
    public static final ViewParameterType FEED_CATEGORY_HAIR_BEAUTY;
    public static final ViewParameterType FEED_CATEGORY_HEALTH_FITNESS;
    public static final ViewParameterType FEED_CATEGORY_HISTORY;
    public static final ViewParameterType FEED_CATEGORY_HOLIDAYS_EVENTS;
    public static final ViewParameterType FEED_CATEGORY_HOLIDAY_FOR_ALL;
    public static final ViewParameterType FEED_CATEGORY_HOLIDAY_FOR_HER;
    public static final ViewParameterType FEED_CATEGORY_HOLIDAY_FOR_HIM;
    public static final ViewParameterType FEED_CATEGORY_HOLIDAY_FOR_KIDS;
    public static final ViewParameterType FEED_CATEGORY_HOME_DECOR;
    public static final ViewParameterType FEED_CATEGORY_HUMOR;
    public static final ViewParameterType FEED_CATEGORY_ILLUSTRATIONS_POSTERS;
    public static final ViewParameterType FEED_CATEGORY_KIDS;
    public static final ViewParameterType FEED_CATEGORY_MENS_FASHION;
    public static final ViewParameterType FEED_CATEGORY_OUTDOORS;
    public static final ViewParameterType FEED_CATEGORY_PHOTOGRAPHY;
    public static final ViewParameterType FEED_CATEGORY_PRODUCTS;
    public static final ViewParameterType FEED_CATEGORY_QUOTES;
    public static final ViewParameterType FEED_CATEGORY_SCIENCE_NATURE;
    public static final ViewParameterType FEED_CATEGORY_SPORTS;
    public static final ViewParameterType FEED_CATEGORY_TATTOOS;
    public static final ViewParameterType FEED_CATEGORY_TECHNOLOGY;
    public static final ViewParameterType FEED_CATEGORY_TRAVEL;
    public static final ViewParameterType FEED_CATEGORY_WEDDINGS;
    public static final ViewParameterType FEED_CATEGORY_WOMENS_FASHION;
    public static final ViewParameterType FEED_COMMERCE;
    public static final ViewParameterType FEED_DIGEST;
    public static final ViewParameterType FEED_DIGEST_STORY;
    public static final ViewParameterType FEED_DOMAIN;
    public static final ViewParameterType FEED_EDITOR_FOLLOW_BOARDS;
    public static final ViewParameterType FEED_EDITOR_UNFOLLOW_BOARDS;
    public static final ViewParameterType FEED_EVERYTHING;
    public static final ViewParameterType FEED_FOLLOWING;
    public static final ViewParameterType FEED_FRIENDS;
    public static final ViewParameterType FEED_GIFTS;
    public static final ViewParameterType FEED_GIFTS_100_200;
    public static final ViewParameterType FEED_GIFTS_20;
    public static final ViewParameterType FEED_GIFTS_200_500;
    public static final ViewParameterType FEED_GIFTS_20_50;
    public static final ViewParameterType FEED_GIFTS_500;
    public static final ViewParameterType FEED_GIFTS_50_100;
    public static final ViewParameterType FEED_HOME;
    public static final ViewParameterType FEED_INTEREST;
    public static final ViewParameterType FEED_PLACES;
    public static final ViewParameterType FEED_POPULAR;
    public static final ViewParameterType FEED_RELATED_BOARD;
    public static final ViewParameterType FEED_RELATED_INTEREST;
    public static final ViewParameterType FEED_SOURCE;
    public static final ViewParameterType FEED_SUBCATEGORY;
    public static final ViewParameterType FEED_TOP_PICKS;
    public static final ViewParameterType FEED_VIDEOS;
    public static final ViewParameterType FEED_WELCOME;
    public static final ViewParameterType FIND_FRIENDS;
    public static final ViewParameterType FRIEND_INVITER_EMAIL;
    public static final ViewParameterType FRIEND_INVITER_FACEBOOK;
    public static final ViewParameterType FRIEND_INVITER_FIND_FRIENDS;
    public static final ViewParameterType FRIEND_INVITER_GMAIL;
    public static final ViewParameterType FRIEND_INVITER_INVITE;
    public static final ViewParameterType FRIEND_INVITER_TWITTER;
    public static final ViewParameterType FRIEND_INVITER_YAHOO;
    public static final ViewParameterType LOGIN_EMAIL;
    public static final ViewParameterType LOGIN_FACEBOOK;
    public static final ViewParameterType LOGIN_TWITTER;
    public static final ViewParameterType MOBILE_ORIENTATION_COLLECT;
    public static final ViewParameterType MOBILE_ORIENTATION_DISCOVER;
    public static final ViewParameterType MOBILE_ORIENTATION_FUNCTIONAL;
    public static final ViewParameterType MOBILE_ORIENTATION_STORY;
    public static final ViewParameterType NEWS_NETWORK_STORY;
    public static final ViewParameterType NEWS_YOUR_STORY;
    public static final ViewParameterType ORIENTATION_END;
    public static final ViewParameterType ORIENTATION_FAST_FOLLOW;
    public static final ViewParameterType ORIENTATION_INTEREST_PICKER;
    public static final ViewParameterType ORIENTATION_START;
    public static final ViewParameterType ORIENTATION_USER_PICKER;
    public static final ViewParameterType PICKED_FOR_YOU_FEED;
    public static final ViewParameterType PINVITATIONAL_AUTH_CONFIRM;
    public static final ViewParameterType PINVITATIONAL_HOME_FEED_MODAL;
    public static final ViewParameterType PINVITATIONAL_PIN_SUMMARY;
    public static final ViewParameterType PINVITATIONAL_SIGNUP_REDEMPTION;
    public static final ViewParameterType PINVITATIONAL_UNAUTH_CONFIRM;
    public static final ViewParameterType PINVITATIONAL_UNAUTH_EMAIL;
    public static final ViewParameterType PIN_ANSWERS;
    public static final ViewParameterType PIN_ARTICLE;
    public static final ViewParameterType PIN_COMMENTS;
    public static final ViewParameterType PIN_CREATE;
    public static final ViewParameterType PIN_CREATE_PINMARKLET;
    public static final ViewParameterType PIN_CREATE_PLACES;
    public static final ViewParameterType PIN_CREATE_REPIN;
    public static final ViewParameterType PIN_CREATE_SDK;
    public static final ViewParameterType PIN_EDIT;
    public static final ViewParameterType PIN_LIKES;
    public static final ViewParameterType PIN_LOOKBOOK;
    public static final ViewParameterType PIN_MOVIE;
    public static final ViewParameterType PIN_OTHER;
    public static final ViewParameterType PIN_PLACE;
    public static final ViewParameterType PIN_PRODUCT;
    public static final ViewParameterType PIN_QUESTIONS;
    public static final ViewParameterType PIN_RECIPE;
    public static final ViewParameterType PIN_REGULAR;
    public static final ViewParameterType PIN_REPIN_BOARDS;
    public static final ViewParameterType PIN_REPLIES;
    public static final ViewParameterType PIN_SEND_TO;
    public static final ViewParameterType PIN_TWINS;
    public static final ViewParameterType REBUILD_FEED_END;
    public static final ViewParameterType REBUILD_FEED_INTEREST_PICKER;
    public static final ViewParameterType REGISTRATION_AGE_GENDER;
    public static final ViewParameterType REGISTRATION_BOARDS;
    public static final ViewParameterType REGISTRATION_LANDING;
    public static final ViewParameterType REGISTRATION_LOCAL_INFO;
    public static final ViewParameterType REGISTRATION_SIGNUP;
    public static final ViewParameterType REGISTRATION_SIGNUP_BUSINESS;
    public static final ViewParameterType REPORT_PIN;
    public static final ViewParameterType REPORT_USER;
    public static final ViewParameterType SEARCH_AUTOCOMPLETE;
    public static final ViewParameterType SEARCH_BOARDS;
    public static final ViewParameterType SEARCH_INTERESTS;
    public static final ViewParameterType SEARCH_MY_PINS;
    public static final ViewParameterType SEARCH_PINS;
    public static final ViewParameterType SEARCH_PLACES;
    public static final ViewParameterType SEARCH_PLACE_BOARDS;
    public static final ViewParameterType SEARCH_USERS;
    public static final ViewParameterType SERVICE_ENTRY_SEO_BING;
    public static final ViewParameterType SERVICE_ENTRY_SEO_GOOGLE;
    public static final ViewParameterType SERVICE_ENTRY_SEO_YAHOO;
    public static final ViewParameterType SERVICE_ENTRY_SOCIAL_FACEBOOK;
    public static final ViewParameterType SERVICE_ENTRY_SOCIAL_TWITTER;
    public static final ViewParameterType SETTINGS_SEARCH_PRIVACY;
    public static final ViewParameterType SHARE_EXTENSION;
    public static final ViewParameterType SPLASH_INSPIRED_WALL;
    public static final ViewParameterType SPLASH_LOADING;
    public static final ViewParameterType STERLING_ADVERTISER_DASHBOARD;
    public static final ViewParameterType STERLING_ADVERTISER_EDIT;
    public static final ViewParameterType STERLING_ADVERTISER_EDIT_BILLING;
    public static final ViewParameterType STERLING_ADVERTISER_SEARCH;
    public static final ViewParameterType STERLING_CAMPAIGN_DASHBOARD;
    public static final ViewParameterType STERLING_CAMPAIGN_EDIT;
    public static final ViewParameterType STERLING_CREATION_FLOW_BILLING;
    public static final ViewParameterType STERLING_CREATION_FLOW_PICK_A_PIN;
    public static final ViewParameterType STERLING_CREATION_FLOW_SETUP_DETAILS;
    public static final ViewParameterType STERLING_PIN_PROMOTION_DASHBOARD;
    public static final ViewParameterType STERLING_PIN_PROMOTION_EDIT;
    public static final ViewParameterType STORIES_RELATED_BOARDS;
    public static final ViewParameterType STORIES_RELATED_PINS;
    public static final ViewParameterType STORIES_RELATED_USERS;
    public static final ViewParameterType USER_ABOUT;
    public static final ViewParameterType USER_ACTIVITY;
    public static final ViewParameterType USER_BOARDS;
    public static final ViewParameterType USER_EDIT;
    public static final ViewParameterType USER_FOLLOWERS;
    public static final ViewParameterType USER_FOLLOWING;
    public static final ViewParameterType USER_FYP;
    public static final ViewParameterType USER_INTERESTS;
    public static final ViewParameterType USER_LIKES;
    public static final ViewParameterType USER_PINS;
    private final int value;

    private ViewParameterType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ViewParameterType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return FEED_FOLLOWING;

        case 1: // '\001'
            return FEED_FRIENDS;

        case 2: // '\002'
            return FEED_EVERYTHING;

        case 3: // '\003'
            return FEED_POPULAR;

        case 4: // '\004'
            return FEED_SOURCE;

        case 92: // '\\'
            return FEED_HOME;

        case 111: // 'o'
            return FEED_TOP_PICKS;

        case 118: // 'v'
            return FEED_WELCOME;

        case 119: // 'w'
            return PIN_CREATE_PINMARKLET;

        case 120: // 'x'
            return FEED_SUBCATEGORY;

        case 136: 
            return FEED_INTEREST;

        case 207: 
            return FEED_DIGEST;

        case 208: 
            return FEED_DIGEST_STORY;

        case 91: // '['
            return CATEGORY_DISCOVER;

        case 5: // '\005'
            return FEED_CATEGORY_ANIMALS;

        case 6: // '\006'
            return FEED_CATEGORY_ARCHITECTURE;

        case 7: // '\007'
            return FEED_CATEGORY_ART;

        case 8: // '\b'
            return FEED_CATEGORY_CARS_MOTORCYCLES;

        case 9: // '\t'
            return FEED_CATEGORY_CELEBRITIES;

        case 10: // '\n'
            return FEED_CATEGORY_DESIGN;

        case 11: // '\013'
            return FEED_CATEGORY_DIY_CRAFTS;

        case 12: // '\f'
            return FEED_CATEGORY_EDUCATION;

        case 13: // '\r'
            return FEED_CATEGORY_FILM_MUSIC_BOOKS;

        case 14: // '\016'
            return FEED_CATEGORY_FOOD_DRINK;

        case 15: // '\017'
            return FEED_CATEGORY_GARDENING;

        case 16: // '\020'
            return FEED_CATEGORY_GEEK;

        case 17: // '\021'
            return FEED_CATEGORY_HAIR_BEAUTY;

        case 18: // '\022'
            return FEED_CATEGORY_HEALTH_FITNESS;

        case 19: // '\023'
            return FEED_CATEGORY_HISTORY;

        case 20: // '\024'
            return FEED_CATEGORY_HOLIDAYS_EVENTS;

        case 21: // '\025'
            return FEED_CATEGORY_HOME_DECOR;

        case 22: // '\026'
            return FEED_CATEGORY_HUMOR;

        case 23: // '\027'
            return FEED_CATEGORY_ILLUSTRATIONS_POSTERS;

        case 24: // '\030'
            return FEED_CATEGORY_KIDS;

        case 25: // '\031'
            return FEED_CATEGORY_MENS_FASHION;

        case 26: // '\032'
            return FEED_CATEGORY_OUTDOORS;

        case 27: // '\033'
            return FEED_CATEGORY_PHOTOGRAPHY;

        case 28: // '\034'
            return FEED_CATEGORY_PRODUCTS;

        case 29: // '\035'
            return FEED_CATEGORY_QUOTES;

        case 30: // '\036'
            return FEED_CATEGORY_SCIENCE_NATURE;

        case 31: // '\037'
            return FEED_CATEGORY_SPORTS;

        case 32: // ' '
            return FEED_CATEGORY_TATTOOS;

        case 33: // '!'
            return FEED_CATEGORY_TECHNOLOGY;

        case 34: // '"'
            return FEED_CATEGORY_TRAVEL;

        case 35: // '#'
            return FEED_CATEGORY_WEDDINGS;

        case 36: // '$'
            return FEED_CATEGORY_WOMENS_FASHION;

        case 124: // '|'
            return FEED_CATEGORY_HOLIDAY_FOR_HIM;

        case 125: // '}'
            return FEED_CATEGORY_HOLIDAY_FOR_HER;

        case 126: // '~'
            return FEED_CATEGORY_HOLIDAY_FOR_KIDS;

        case 127: // '\177'
            return FEED_CATEGORY_HOLIDAY_FOR_ALL;

        case 130: 
            return FEED_CATEGORY_CHRISTMAS_SWEATER;

        case 400: 
            return FEED_CATEGORY;

        case 85: // 'U'
            return FEED_GIFTS;

        case 37: // '%'
            return FEED_GIFTS_20;

        case 38: // '&'
            return FEED_GIFTS_20_50;

        case 39: // '\''
            return FEED_GIFTS_50_100;

        case 40: // '('
            return FEED_GIFTS_100_200;

        case 41: // ')'
            return FEED_GIFTS_200_500;

        case 42: // '*'
            return FEED_GIFTS_500;

        case 128: 
            return FEED_VIDEOS;

        case 129: 
            return FEED_DOMAIN;

        case 200: 
            return FEED_PLACES;

        case 226: 
            return FEED_COMMERCE;

        case 137: 
            return DISCOVER_CATEGORY;

        case 138: 
            return DISCOVER_INTEREST;

        case 185: 
            return DISCOVER_SEARCH_INTERESTS;

        case 43: // '+'
            return SEARCH_PINS;

        case 44: // ','
            return SEARCH_BOARDS;

        case 45: // '-'
            return SEARCH_USERS;

        case 103: // 'g'
            return SEARCH_AUTOCOMPLETE;

        case 107: // 'k'
            return SEARCH_MY_PINS;

        case 123: // '{'
            return SEARCH_PLACES;

        case 181: 
            return SEARCH_PLACE_BOARDS;

        case 182: 
            return SEARCH_INTERESTS;

        case 46: // '.'
            return REGISTRATION_LANDING;

        case 47: // '/'
            return REGISTRATION_SIGNUP;

        case 48: // '0'
            return REGISTRATION_BOARDS;

        case 300: 
            return REGISTRATION_SIGNUP_BUSINESS;

        case 301: 
            return REGISTRATION_LOCAL_INFO;

        case 302: 
            return REGISTRATION_AGE_GENDER;

        case 49: // '1'
            return USER_BOARDS;

        case 50: // '2'
            return USER_FOLLOWERS;

        case 51: // '3'
            return USER_FOLLOWING;

        case 52: // '4'
            return USER_LIKES;

        case 53: // '5'
            return USER_ACTIVITY;

        case 74: // 'J'
            return USER_PINS;

        case 93: // ']'
            return USER_EDIT;

        case 183: 
            return USER_INTERESTS;

        case 189: 
            return USER_FYP;

        case 54: // '6'
            return BOARD_FOLLOWERS;

        case 55: // '7'
            return BOARD_SETTINGS;

        case 87: // 'W'
            return BOARD_CREATE;

        case 88: // 'X'
            return BOARD_EDIT;

        case 104: // 'h'
            return BOARD_EDIT_COLLABORATORS;

        case 121: // 'y'
            return BOARD_PLACE;

        case 122: // 'z'
            return BOARD_MAP;

        case 56: // '8'
            return FRIEND_INVITER_EMAIL;

        case 57: // '9'
            return FRIEND_INVITER_FACEBOOK;

        case 131: 
            return FRIEND_INVITER_FIND_FRIENDS;

        case 58: // ':'
            return FRIEND_INVITER_GMAIL;

        case 132: 
            return FRIEND_INVITER_INVITE;

        case 133: 
            return FRIEND_INVITER_TWITTER;

        case 59: // ';'
            return FRIEND_INVITER_YAHOO;

        case 60: // '<'
            return ABOUT_TERMS;

        case 61: // '='
            return ABOUT_SUPPORT;

        case 62: // '>'
            return ABOUT_BOOKMARKLET;

        case 76: // 'L'
            return ABOUT_ETIQUETTE;

        case 77: // 'M'
            return ABOUT_ABOUT;

        case 78: // 'N'
            return ABOUT_GOODIES;

        case 79: // 'O'
            return ABOUT_CAREERS;

        case 80: // 'P'
            return ABOUT_TEAM;

        case 81: // 'Q'
            return ABOUT_PRESS;

        case 82: // 'R'
            return ABOUT_PRIVACY;

        case 83: // 'S'
            return ABOUT_USE;

        case 84: // 'T'
            return ABOUT_COPYRIGHT;

        case 63: // '?'
            return LOGIN_EMAIL;

        case 64: // '@'
            return LOGIN_FACEBOOK;

        case 65: // 'A'
            return LOGIN_TWITTER;

        case 66: // 'B'
            return ERROR_NO_INTERNET;

        case 67: // 'C'
            return ERROR_NO_PIN;

        case 68: // 'D'
            return ERROR_NO_BOARD;

        case 69: // 'E'
            return ERROR_NO_USER;

        case 70: // 'F'
            return ERROR_NO_ACTIVITY;

        case 71: // 'G'
            return REPORT_PIN;

        case 86: // 'V'
            return REPORT_USER;

        case 72: // 'H'
            return PIN_CREATE_REPIN;

        case 73: // 'I'
            return PIN_CREATE;

        case 100: // 'd'
            return PIN_CREATE_SDK;

        case 89: // 'Y'
            return PIN_EDIT;

        case 105: // 'i'
            return PIN_SEND_TO;

        case 75: // 'K'
            return USER_ABOUT;

        case 90: // 'Z'
            return BOARD_COLLABORATORS;

        case 94: // '^'
            return EDUCATION_LONGPRESS;

        case 101: // 'e'
            return EDUCATION_RELATED_PINS;

        case 95: // '_'
            return EDUCATION_SECRET_BOARD;

        case 108: // 'l'
            return EDUCATION_CONTEXTUAL_MENU;

        case 184: 
            return EDUCATION_GUIDED_SEARCH;

        case 221: 
            return EDUCATION_FLYOUT;

        case 96: // '`'
            return MOBILE_ORIENTATION_DISCOVER;

        case 97: // 'a'
            return MOBILE_ORIENTATION_COLLECT;

        case 98: // 'b'
            return MOBILE_ORIENTATION_FUNCTIONAL;

        case 99: // 'c'
            return MOBILE_ORIENTATION_STORY;

        case 102: // 'f'
            return ORIENTATION_FAST_FOLLOW;

        case 106: // 'j'
            return PICKED_FOR_YOU_FEED;

        case 109: // 'm'
            return FEED_EDITOR_FOLLOW_BOARDS;

        case 110: // 'n'
            return FEED_EDITOR_UNFOLLOW_BOARDS;

        case 112: // 'p'
            return DEPRECATED_DEEP_LINKING_EMAIL;

        case 113: // 'q'
            return DEPRECATED_DEEP_LINKING_WEB;

        case 114: // 'r'
            return DEEP_LINKING_FACEBOOK;

        case 115: // 's'
            return DEEP_LINKING_APP;

        case 116: // 't'
            return FEED_RELATED_BOARD;

        case 117: // 'u'
            return FEED_RELATED_INTEREST;

        case 135: 
            return FIND_FRIENDS;

        case 139: 
            return PIN_OTHER;

        case 140: 
            return PIN_REGULAR;

        case 141: 
            return PIN_ARTICLE;

        case 142: 
            return PIN_MOVIE;

        case 143: 
            return PIN_PLACE;

        case 144: 
            return PIN_PRODUCT;

        case 145: 
            return PIN_RECIPE;

        case 146: 
            return PIN_LOOKBOOK;

        case 150: 
            return PIN_CREATE_PLACES;

        case 151: 
            return PIN_LIKES;

        case 152: 
            return PIN_COMMENTS;

        case 153: 
            return PIN_REPIN_BOARDS;

        case 186: 
            return PIN_QUESTIONS;

        case 187: 
            return PIN_ANSWERS;

        case 188: 
            return PIN_REPLIES;

        case 160: 
            return SPLASH_LOADING;

        case 161: 
            return SPLASH_INSPIRED_WALL;

        case 170: 
            return ORIENTATION_START;

        case 171: 
            return ORIENTATION_END;

        case 172: 
            return ORIENTATION_INTEREST_PICKER;

        case 173: 
            return ORIENTATION_USER_PICKER;

        case 222: 
            return REBUILD_FEED_INTEREST_PICKER;

        case 223: 
            return REBUILD_FEED_END;

        case 190: 
            return STORIES_RELATED_PINS;

        case 191: 
            return STORIES_RELATED_USERS;

        case 192: 
            return STORIES_RELATED_BOARDS;

        case 195: 
            return BROWSER;

        case 201: 
            return CONVERSATION_CREATE;

        case 202: 
            return CONVERSATION_THREAD;

        case 203: 
            return CONVERSATION_INBOX;

        case 204: 
            return CONVERSATION_ADD_PIN;

        case 205: 
            return CONVERSATION_USERS;

        case 210: 
            return NEWS_NETWORK_STORY;

        case 211: 
            return NEWS_YOUR_STORY;

        case 224: 
            return PIN_TWINS;

        case 225: 
            return ACTIVITY_V2;

        case 1900: 
            return EXTERNAL_SOURCE_OTHER;

        case 2000: 
            return EMAIL_UNKNOWN;

        case 2001: 
            return EMAIL_TRANSACTIONAL;

        case 2002: 
            return EMAIL_EDITORIAL;

        case 2003: 
            return EMAIL_ACTIVITY_AGGREGATION;

        case 2004: 
            return EMAIL_RECOMMENDATIONS_DIGEST;

        case 2005: 
            return EMAIL_SOCIAL_DIGEST;

        case 2006: 
            return EMAIL_SEND_PIN;

        case 2007: 
            return EMAIL_SEND_BOARD;

        case 2008: 
            return EMAIL_SEND_PINNER;

        case 2009: 
            return EMAIL_FRIEND_JOINED;

        case 2010: 
            return EMAIL_WELCOME;

        case 2011: 
            return EMAIL_BOARD_RECOMMENDATIONS;

        case 2012: 
            return EMAIL_PIN_RECOMMENDATIONS;

        case 2013: 
            return EMAIL_COMMENT_AND_MENTION;

        case 2014: 
            return EMAIL_USECASES;

        case 2015: 
            return EMAIL_FIREHOSE_QUESTION_CREATE;

        case 2016: 
            return EMAIL_FIREHOSE_ANSWER_CREATE;

        case 2017: 
            return EMAIL_FIREHOSE_REPLY_CREATE;

        case 2018: 
            return EMAIL_QUESTION_CREATE;

        case 2019: 
            return EMAIL_ANSWER_CREATE;

        case 2020: 
            return EMAIL_QUESTION_LIKE;

        case 2021: 
            return EMAIL_ANSWER_LIKE;

        case 2022: 
            return EMAIL_REPLY_CREATE;

        case 2023: 
            return EMAIL_PARTNER;

        case 2024: 
            return EMAIL_INTEREST_RECOMMENDATIONS;

        case 2025: 
            return EMAIL_HOMEFEED_NEW_PINS;

        case 2026: 
            return EMAIL_NETWORK_STORY_DIGEST;

        case 2027: 
            return EMAIL_PINVITATIONAL_ACCESS;

        case 2028: 
            return EMAIL_RESTART_FEED;

        case 2029: 
            return EMAIL_PINVITATIONAL_RALLYING_CALL;

        case 2030: 
            return EMAIL_WEEK_IN_REVIEW;

        case 2101: 
            return SERVICE_ENTRY_SOCIAL_FACEBOOK;

        case 2102: 
            return SERVICE_ENTRY_SOCIAL_TWITTER;

        case 2110: 
            return SERVICE_ENTRY_SEO_GOOGLE;

        case 2111: 
            return SERVICE_ENTRY_SEO_YAHOO;

        case 2112: 
            return SERVICE_ENTRY_SEO_BING;

        case 2201: 
            return STERLING_CREATION_FLOW_PICK_A_PIN;

        case 2202: 
            return STERLING_CREATION_FLOW_SETUP_DETAILS;

        case 2203: 
            return STERLING_CREATION_FLOW_BILLING;

        case 2204: 
            return STERLING_PIN_PROMOTION_DASHBOARD;

        case 2205: 
            return STERLING_PIN_PROMOTION_EDIT;

        case 2206: 
            return STERLING_CAMPAIGN_DASHBOARD;

        case 2207: 
            return STERLING_CAMPAIGN_EDIT;

        case 2208: 
            return STERLING_ADVERTISER_DASHBOARD;

        case 2209: 
            return STERLING_ADVERTISER_EDIT;

        case 2210: 
            return STERLING_ADVERTISER_SEARCH;

        case 2211: 
            return STERLING_ADVERTISER_EDIT_BILLING;

        case 2301: 
            return ANALYTICS_PROFILE_IMPRESSIONS;

        case 2302: 
            return ANALYTICS_PROFILE_REPINS;

        case 2303: 
            return ANALYTICS_PROFILE_CLICKS;

        case 2304: 
            return ANALYTICS_PROFILE_ALL_TIME;

        case 2311: 
            return ANALYTICS_DOMAIN_IMPRESSIONS;

        case 2312: 
            return ANALYTICS_DOMAIN_REPINS;

        case 2313: 
            return ANALYTICS_DOMAIN_CLICKS;

        case 2314: 
            return ANALYTICS_DOMAIN_ORIGINAL_PINS;

        case 2315: 
            return ANALYTICS_DOMAIN_ALL_TIME;

        case 2401: 
            return PINVITATIONAL_UNAUTH_EMAIL;

        case 2402: 
            return PINVITATIONAL_UNAUTH_CONFIRM;

        case 2403: 
            return PINVITATIONAL_AUTH_CONFIRM;

        case 2404: 
            return PINVITATIONAL_SIGNUP_REDEMPTION;

        case 2405: 
            return PINVITATIONAL_HOME_FEED_MODAL;

        case 2406: 
            return PINVITATIONAL_PIN_SUMMARY;

        case 227: 
            return SETTINGS_SEARCH_PRIVACY;

        case 2500: 
            return SHARE_EXTENSION;
        }
    }

    public static ViewParameterType valueOf(String s)
    {
        return (ViewParameterType)Enum.valueOf(com/pinterest/schemas/event/ViewParameterType, s);
    }

    public static ViewParameterType[] values()
    {
        return (ViewParameterType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        FEED_FOLLOWING = new ViewParameterType("FEED_FOLLOWING", 0, 0);
        FEED_FRIENDS = new ViewParameterType("FEED_FRIENDS", 1, 1);
        FEED_EVERYTHING = new ViewParameterType("FEED_EVERYTHING", 2, 2);
        FEED_POPULAR = new ViewParameterType("FEED_POPULAR", 3, 3);
        FEED_SOURCE = new ViewParameterType("FEED_SOURCE", 4, 4);
        FEED_HOME = new ViewParameterType("FEED_HOME", 5, 92);
        FEED_TOP_PICKS = new ViewParameterType("FEED_TOP_PICKS", 6, 111);
        FEED_WELCOME = new ViewParameterType("FEED_WELCOME", 7, 118);
        PIN_CREATE_PINMARKLET = new ViewParameterType("PIN_CREATE_PINMARKLET", 8, 119);
        FEED_SUBCATEGORY = new ViewParameterType("FEED_SUBCATEGORY", 9, 120);
        FEED_INTEREST = new ViewParameterType("FEED_INTEREST", 10, 136);
        FEED_DIGEST = new ViewParameterType("FEED_DIGEST", 11, 207);
        FEED_DIGEST_STORY = new ViewParameterType("FEED_DIGEST_STORY", 12, 208);
        CATEGORY_DISCOVER = new ViewParameterType("CATEGORY_DISCOVER", 13, 91);
        FEED_CATEGORY_ANIMALS = new ViewParameterType("FEED_CATEGORY_ANIMALS", 14, 5);
        FEED_CATEGORY_ARCHITECTURE = new ViewParameterType("FEED_CATEGORY_ARCHITECTURE", 15, 6);
        FEED_CATEGORY_ART = new ViewParameterType("FEED_CATEGORY_ART", 16, 7);
        FEED_CATEGORY_CARS_MOTORCYCLES = new ViewParameterType("FEED_CATEGORY_CARS_MOTORCYCLES", 17, 8);
        FEED_CATEGORY_CELEBRITIES = new ViewParameterType("FEED_CATEGORY_CELEBRITIES", 18, 9);
        FEED_CATEGORY_DESIGN = new ViewParameterType("FEED_CATEGORY_DESIGN", 19, 10);
        FEED_CATEGORY_DIY_CRAFTS = new ViewParameterType("FEED_CATEGORY_DIY_CRAFTS", 20, 11);
        FEED_CATEGORY_EDUCATION = new ViewParameterType("FEED_CATEGORY_EDUCATION", 21, 12);
        FEED_CATEGORY_FILM_MUSIC_BOOKS = new ViewParameterType("FEED_CATEGORY_FILM_MUSIC_BOOKS", 22, 13);
        FEED_CATEGORY_FOOD_DRINK = new ViewParameterType("FEED_CATEGORY_FOOD_DRINK", 23, 14);
        FEED_CATEGORY_GARDENING = new ViewParameterType("FEED_CATEGORY_GARDENING", 24, 15);
        FEED_CATEGORY_GEEK = new ViewParameterType("FEED_CATEGORY_GEEK", 25, 16);
        FEED_CATEGORY_HAIR_BEAUTY = new ViewParameterType("FEED_CATEGORY_HAIR_BEAUTY", 26, 17);
        FEED_CATEGORY_HEALTH_FITNESS = new ViewParameterType("FEED_CATEGORY_HEALTH_FITNESS", 27, 18);
        FEED_CATEGORY_HISTORY = new ViewParameterType("FEED_CATEGORY_HISTORY", 28, 19);
        FEED_CATEGORY_HOLIDAYS_EVENTS = new ViewParameterType("FEED_CATEGORY_HOLIDAYS_EVENTS", 29, 20);
        FEED_CATEGORY_HOME_DECOR = new ViewParameterType("FEED_CATEGORY_HOME_DECOR", 30, 21);
        FEED_CATEGORY_HUMOR = new ViewParameterType("FEED_CATEGORY_HUMOR", 31, 22);
        FEED_CATEGORY_ILLUSTRATIONS_POSTERS = new ViewParameterType("FEED_CATEGORY_ILLUSTRATIONS_POSTERS", 32, 23);
        FEED_CATEGORY_KIDS = new ViewParameterType("FEED_CATEGORY_KIDS", 33, 24);
        FEED_CATEGORY_MENS_FASHION = new ViewParameterType("FEED_CATEGORY_MENS_FASHION", 34, 25);
        FEED_CATEGORY_OUTDOORS = new ViewParameterType("FEED_CATEGORY_OUTDOORS", 35, 26);
        FEED_CATEGORY_PHOTOGRAPHY = new ViewParameterType("FEED_CATEGORY_PHOTOGRAPHY", 36, 27);
        FEED_CATEGORY_PRODUCTS = new ViewParameterType("FEED_CATEGORY_PRODUCTS", 37, 28);
        FEED_CATEGORY_QUOTES = new ViewParameterType("FEED_CATEGORY_QUOTES", 38, 29);
        FEED_CATEGORY_SCIENCE_NATURE = new ViewParameterType("FEED_CATEGORY_SCIENCE_NATURE", 39, 30);
        FEED_CATEGORY_SPORTS = new ViewParameterType("FEED_CATEGORY_SPORTS", 40, 31);
        FEED_CATEGORY_TATTOOS = new ViewParameterType("FEED_CATEGORY_TATTOOS", 41, 32);
        FEED_CATEGORY_TECHNOLOGY = new ViewParameterType("FEED_CATEGORY_TECHNOLOGY", 42, 33);
        FEED_CATEGORY_TRAVEL = new ViewParameterType("FEED_CATEGORY_TRAVEL", 43, 34);
        FEED_CATEGORY_WEDDINGS = new ViewParameterType("FEED_CATEGORY_WEDDINGS", 44, 35);
        FEED_CATEGORY_WOMENS_FASHION = new ViewParameterType("FEED_CATEGORY_WOMENS_FASHION", 45, 36);
        FEED_CATEGORY_HOLIDAY_FOR_HIM = new ViewParameterType("FEED_CATEGORY_HOLIDAY_FOR_HIM", 46, 124);
        FEED_CATEGORY_HOLIDAY_FOR_HER = new ViewParameterType("FEED_CATEGORY_HOLIDAY_FOR_HER", 47, 125);
        FEED_CATEGORY_HOLIDAY_FOR_KIDS = new ViewParameterType("FEED_CATEGORY_HOLIDAY_FOR_KIDS", 48, 126);
        FEED_CATEGORY_HOLIDAY_FOR_ALL = new ViewParameterType("FEED_CATEGORY_HOLIDAY_FOR_ALL", 49, 127);
        FEED_CATEGORY_CHRISTMAS_SWEATER = new ViewParameterType("FEED_CATEGORY_CHRISTMAS_SWEATER", 50, 130);
        FEED_CATEGORY = new ViewParameterType("FEED_CATEGORY", 51, 400);
        FEED_GIFTS = new ViewParameterType("FEED_GIFTS", 52, 85);
        FEED_GIFTS_20 = new ViewParameterType("FEED_GIFTS_20", 53, 37);
        FEED_GIFTS_20_50 = new ViewParameterType("FEED_GIFTS_20_50", 54, 38);
        FEED_GIFTS_50_100 = new ViewParameterType("FEED_GIFTS_50_100", 55, 39);
        FEED_GIFTS_100_200 = new ViewParameterType("FEED_GIFTS_100_200", 56, 40);
        FEED_GIFTS_200_500 = new ViewParameterType("FEED_GIFTS_200_500", 57, 41);
        FEED_GIFTS_500 = new ViewParameterType("FEED_GIFTS_500", 58, 42);
        FEED_VIDEOS = new ViewParameterType("FEED_VIDEOS", 59, 128);
        FEED_DOMAIN = new ViewParameterType("FEED_DOMAIN", 60, 129);
        FEED_PLACES = new ViewParameterType("FEED_PLACES", 61, 200);
        FEED_COMMERCE = new ViewParameterType("FEED_COMMERCE", 62, 226);
        DISCOVER_CATEGORY = new ViewParameterType("DISCOVER_CATEGORY", 63, 137);
        DISCOVER_INTEREST = new ViewParameterType("DISCOVER_INTEREST", 64, 138);
        DISCOVER_SEARCH_INTERESTS = new ViewParameterType("DISCOVER_SEARCH_INTERESTS", 65, 185);
        SEARCH_PINS = new ViewParameterType("SEARCH_PINS", 66, 43);
        SEARCH_BOARDS = new ViewParameterType("SEARCH_BOARDS", 67, 44);
        SEARCH_USERS = new ViewParameterType("SEARCH_USERS", 68, 45);
        SEARCH_AUTOCOMPLETE = new ViewParameterType("SEARCH_AUTOCOMPLETE", 69, 103);
        SEARCH_MY_PINS = new ViewParameterType("SEARCH_MY_PINS", 70, 107);
        SEARCH_PLACES = new ViewParameterType("SEARCH_PLACES", 71, 123);
        SEARCH_PLACE_BOARDS = new ViewParameterType("SEARCH_PLACE_BOARDS", 72, 181);
        SEARCH_INTERESTS = new ViewParameterType("SEARCH_INTERESTS", 73, 182);
        REGISTRATION_LANDING = new ViewParameterType("REGISTRATION_LANDING", 74, 46);
        REGISTRATION_SIGNUP = new ViewParameterType("REGISTRATION_SIGNUP", 75, 47);
        REGISTRATION_BOARDS = new ViewParameterType("REGISTRATION_BOARDS", 76, 48);
        REGISTRATION_SIGNUP_BUSINESS = new ViewParameterType("REGISTRATION_SIGNUP_BUSINESS", 77, 300);
        REGISTRATION_LOCAL_INFO = new ViewParameterType("REGISTRATION_LOCAL_INFO", 78, 301);
        REGISTRATION_AGE_GENDER = new ViewParameterType("REGISTRATION_AGE_GENDER", 79, 302);
        USER_BOARDS = new ViewParameterType("USER_BOARDS", 80, 49);
        USER_FOLLOWERS = new ViewParameterType("USER_FOLLOWERS", 81, 50);
        USER_FOLLOWING = new ViewParameterType("USER_FOLLOWING", 82, 51);
        USER_LIKES = new ViewParameterType("USER_LIKES", 83, 52);
        USER_ACTIVITY = new ViewParameterType("USER_ACTIVITY", 84, 53);
        USER_PINS = new ViewParameterType("USER_PINS", 85, 74);
        USER_EDIT = new ViewParameterType("USER_EDIT", 86, 93);
        USER_INTERESTS = new ViewParameterType("USER_INTERESTS", 87, 183);
        USER_FYP = new ViewParameterType("USER_FYP", 88, 189);
        BOARD_FOLLOWERS = new ViewParameterType("BOARD_FOLLOWERS", 89, 54);
        BOARD_SETTINGS = new ViewParameterType("BOARD_SETTINGS", 90, 55);
        BOARD_CREATE = new ViewParameterType("BOARD_CREATE", 91, 87);
        BOARD_EDIT = new ViewParameterType("BOARD_EDIT", 92, 88);
        BOARD_EDIT_COLLABORATORS = new ViewParameterType("BOARD_EDIT_COLLABORATORS", 93, 104);
        BOARD_PLACE = new ViewParameterType("BOARD_PLACE", 94, 121);
        BOARD_MAP = new ViewParameterType("BOARD_MAP", 95, 122);
        FRIEND_INVITER_EMAIL = new ViewParameterType("FRIEND_INVITER_EMAIL", 96, 56);
        FRIEND_INVITER_FACEBOOK = new ViewParameterType("FRIEND_INVITER_FACEBOOK", 97, 57);
        FRIEND_INVITER_FIND_FRIENDS = new ViewParameterType("FRIEND_INVITER_FIND_FRIENDS", 98, 131);
        FRIEND_INVITER_GMAIL = new ViewParameterType("FRIEND_INVITER_GMAIL", 99, 58);
        FRIEND_INVITER_INVITE = new ViewParameterType("FRIEND_INVITER_INVITE", 100, 132);
        FRIEND_INVITER_TWITTER = new ViewParameterType("FRIEND_INVITER_TWITTER", 101, 133);
        FRIEND_INVITER_YAHOO = new ViewParameterType("FRIEND_INVITER_YAHOO", 102, 59);
        ABOUT_TERMS = new ViewParameterType("ABOUT_TERMS", 103, 60);
        ABOUT_SUPPORT = new ViewParameterType("ABOUT_SUPPORT", 104, 61);
        ABOUT_BOOKMARKLET = new ViewParameterType("ABOUT_BOOKMARKLET", 105, 62);
        ABOUT_ETIQUETTE = new ViewParameterType("ABOUT_ETIQUETTE", 106, 76);
        ABOUT_ABOUT = new ViewParameterType("ABOUT_ABOUT", 107, 77);
        ABOUT_GOODIES = new ViewParameterType("ABOUT_GOODIES", 108, 78);
        ABOUT_CAREERS = new ViewParameterType("ABOUT_CAREERS", 109, 79);
        ABOUT_TEAM = new ViewParameterType("ABOUT_TEAM", 110, 80);
        ABOUT_PRESS = new ViewParameterType("ABOUT_PRESS", 111, 81);
        ABOUT_PRIVACY = new ViewParameterType("ABOUT_PRIVACY", 112, 82);
        ABOUT_USE = new ViewParameterType("ABOUT_USE", 113, 83);
        ABOUT_COPYRIGHT = new ViewParameterType("ABOUT_COPYRIGHT", 114, 84);
        LOGIN_EMAIL = new ViewParameterType("LOGIN_EMAIL", 115, 63);
        LOGIN_FACEBOOK = new ViewParameterType("LOGIN_FACEBOOK", 116, 64);
        LOGIN_TWITTER = new ViewParameterType("LOGIN_TWITTER", 117, 65);
        ERROR_NO_INTERNET = new ViewParameterType("ERROR_NO_INTERNET", 118, 66);
        ERROR_NO_PIN = new ViewParameterType("ERROR_NO_PIN", 119, 67);
        ERROR_NO_BOARD = new ViewParameterType("ERROR_NO_BOARD", 120, 68);
        ERROR_NO_USER = new ViewParameterType("ERROR_NO_USER", 121, 69);
        ERROR_NO_ACTIVITY = new ViewParameterType("ERROR_NO_ACTIVITY", 122, 70);
        REPORT_PIN = new ViewParameterType("REPORT_PIN", 123, 71);
        REPORT_USER = new ViewParameterType("REPORT_USER", 124, 86);
        PIN_CREATE_REPIN = new ViewParameterType("PIN_CREATE_REPIN", 125, 72);
        PIN_CREATE = new ViewParameterType("PIN_CREATE", 126, 73);
        PIN_CREATE_SDK = new ViewParameterType("PIN_CREATE_SDK", 127, 100);
        PIN_EDIT = new ViewParameterType("PIN_EDIT", 128, 89);
        PIN_SEND_TO = new ViewParameterType("PIN_SEND_TO", 129, 105);
        USER_ABOUT = new ViewParameterType("USER_ABOUT", 130, 75);
        BOARD_COLLABORATORS = new ViewParameterType("BOARD_COLLABORATORS", 131, 90);
        EDUCATION_LONGPRESS = new ViewParameterType("EDUCATION_LONGPRESS", 132, 94);
        EDUCATION_RELATED_PINS = new ViewParameterType("EDUCATION_RELATED_PINS", 133, 101);
        EDUCATION_SECRET_BOARD = new ViewParameterType("EDUCATION_SECRET_BOARD", 134, 95);
        EDUCATION_CONTEXTUAL_MENU = new ViewParameterType("EDUCATION_CONTEXTUAL_MENU", 135, 108);
        EDUCATION_GUIDED_SEARCH = new ViewParameterType("EDUCATION_GUIDED_SEARCH", 136, 184);
        EDUCATION_FLYOUT = new ViewParameterType("EDUCATION_FLYOUT", 137, 221);
        MOBILE_ORIENTATION_DISCOVER = new ViewParameterType("MOBILE_ORIENTATION_DISCOVER", 138, 96);
        MOBILE_ORIENTATION_COLLECT = new ViewParameterType("MOBILE_ORIENTATION_COLLECT", 139, 97);
        MOBILE_ORIENTATION_FUNCTIONAL = new ViewParameterType("MOBILE_ORIENTATION_FUNCTIONAL", 140, 98);
        MOBILE_ORIENTATION_STORY = new ViewParameterType("MOBILE_ORIENTATION_STORY", 141, 99);
        ORIENTATION_FAST_FOLLOW = new ViewParameterType("ORIENTATION_FAST_FOLLOW", 142, 102);
        PICKED_FOR_YOU_FEED = new ViewParameterType("PICKED_FOR_YOU_FEED", 143, 106);
        FEED_EDITOR_FOLLOW_BOARDS = new ViewParameterType("FEED_EDITOR_FOLLOW_BOARDS", 144, 109);
        FEED_EDITOR_UNFOLLOW_BOARDS = new ViewParameterType("FEED_EDITOR_UNFOLLOW_BOARDS", 145, 110);
        DEPRECATED_DEEP_LINKING_EMAIL = new ViewParameterType("DEPRECATED_DEEP_LINKING_EMAIL", 146, 112);
        DEPRECATED_DEEP_LINKING_WEB = new ViewParameterType("DEPRECATED_DEEP_LINKING_WEB", 147, 113);
        DEEP_LINKING_FACEBOOK = new ViewParameterType("DEEP_LINKING_FACEBOOK", 148, 114);
        DEEP_LINKING_APP = new ViewParameterType("DEEP_LINKING_APP", 149, 115);
        FEED_RELATED_BOARD = new ViewParameterType("FEED_RELATED_BOARD", 150, 116);
        FEED_RELATED_INTEREST = new ViewParameterType("FEED_RELATED_INTEREST", 151, 117);
        FIND_FRIENDS = new ViewParameterType("FIND_FRIENDS", 152, 135);
        PIN_OTHER = new ViewParameterType("PIN_OTHER", 153, 139);
        PIN_REGULAR = new ViewParameterType("PIN_REGULAR", 154, 140);
        PIN_ARTICLE = new ViewParameterType("PIN_ARTICLE", 155, 141);
        PIN_MOVIE = new ViewParameterType("PIN_MOVIE", 156, 142);
        PIN_PLACE = new ViewParameterType("PIN_PLACE", 157, 143);
        PIN_PRODUCT = new ViewParameterType("PIN_PRODUCT", 158, 144);
        PIN_RECIPE = new ViewParameterType("PIN_RECIPE", 159, 145);
        PIN_LOOKBOOK = new ViewParameterType("PIN_LOOKBOOK", 160, 146);
        PIN_CREATE_PLACES = new ViewParameterType("PIN_CREATE_PLACES", 161, 150);
        PIN_LIKES = new ViewParameterType("PIN_LIKES", 162, 151);
        PIN_COMMENTS = new ViewParameterType("PIN_COMMENTS", 163, 152);
        PIN_REPIN_BOARDS = new ViewParameterType("PIN_REPIN_BOARDS", 164, 153);
        PIN_QUESTIONS = new ViewParameterType("PIN_QUESTIONS", 165, 186);
        PIN_ANSWERS = new ViewParameterType("PIN_ANSWERS", 166, 187);
        PIN_REPLIES = new ViewParameterType("PIN_REPLIES", 167, 188);
        SPLASH_LOADING = new ViewParameterType("SPLASH_LOADING", 168, 160);
        SPLASH_INSPIRED_WALL = new ViewParameterType("SPLASH_INSPIRED_WALL", 169, 161);
        ORIENTATION_START = new ViewParameterType("ORIENTATION_START", 170, 170);
        ORIENTATION_END = new ViewParameterType("ORIENTATION_END", 171, 171);
        ORIENTATION_INTEREST_PICKER = new ViewParameterType("ORIENTATION_INTEREST_PICKER", 172, 172);
        ORIENTATION_USER_PICKER = new ViewParameterType("ORIENTATION_USER_PICKER", 173, 173);
        REBUILD_FEED_INTEREST_PICKER = new ViewParameterType("REBUILD_FEED_INTEREST_PICKER", 174, 222);
        REBUILD_FEED_END = new ViewParameterType("REBUILD_FEED_END", 175, 223);
        STORIES_RELATED_PINS = new ViewParameterType("STORIES_RELATED_PINS", 176, 190);
        STORIES_RELATED_USERS = new ViewParameterType("STORIES_RELATED_USERS", 177, 191);
        STORIES_RELATED_BOARDS = new ViewParameterType("STORIES_RELATED_BOARDS", 178, 192);
        BROWSER = new ViewParameterType("BROWSER", 179, 195);
        CONVERSATION_CREATE = new ViewParameterType("CONVERSATION_CREATE", 180, 201);
        CONVERSATION_THREAD = new ViewParameterType("CONVERSATION_THREAD", 181, 202);
        CONVERSATION_INBOX = new ViewParameterType("CONVERSATION_INBOX", 182, 203);
        CONVERSATION_ADD_PIN = new ViewParameterType("CONVERSATION_ADD_PIN", 183, 204);
        CONVERSATION_USERS = new ViewParameterType("CONVERSATION_USERS", 184, 205);
        NEWS_NETWORK_STORY = new ViewParameterType("NEWS_NETWORK_STORY", 185, 210);
        NEWS_YOUR_STORY = new ViewParameterType("NEWS_YOUR_STORY", 186, 211);
        PIN_TWINS = new ViewParameterType("PIN_TWINS", 187, 224);
        ACTIVITY_V2 = new ViewParameterType("ACTIVITY_V2", 188, 225);
        EXTERNAL_SOURCE_OTHER = new ViewParameterType("EXTERNAL_SOURCE_OTHER", 189, 1900);
        EMAIL_UNKNOWN = new ViewParameterType("EMAIL_UNKNOWN", 190, 2000);
        EMAIL_TRANSACTIONAL = new ViewParameterType("EMAIL_TRANSACTIONAL", 191, 2001);
        EMAIL_EDITORIAL = new ViewParameterType("EMAIL_EDITORIAL", 192, 2002);
        EMAIL_ACTIVITY_AGGREGATION = new ViewParameterType("EMAIL_ACTIVITY_AGGREGATION", 193, 2003);
        EMAIL_RECOMMENDATIONS_DIGEST = new ViewParameterType("EMAIL_RECOMMENDATIONS_DIGEST", 194, 2004);
        EMAIL_SOCIAL_DIGEST = new ViewParameterType("EMAIL_SOCIAL_DIGEST", 195, 2005);
        EMAIL_SEND_PIN = new ViewParameterType("EMAIL_SEND_PIN", 196, 2006);
        EMAIL_SEND_BOARD = new ViewParameterType("EMAIL_SEND_BOARD", 197, 2007);
        EMAIL_SEND_PINNER = new ViewParameterType("EMAIL_SEND_PINNER", 198, 2008);
        EMAIL_FRIEND_JOINED = new ViewParameterType("EMAIL_FRIEND_JOINED", 199, 2009);
        EMAIL_WELCOME = new ViewParameterType("EMAIL_WELCOME", 200, 2010);
        EMAIL_BOARD_RECOMMENDATIONS = new ViewParameterType("EMAIL_BOARD_RECOMMENDATIONS", 201, 2011);
        EMAIL_PIN_RECOMMENDATIONS = new ViewParameterType("EMAIL_PIN_RECOMMENDATIONS", 202, 2012);
        EMAIL_COMMENT_AND_MENTION = new ViewParameterType("EMAIL_COMMENT_AND_MENTION", 203, 2013);
        EMAIL_USECASES = new ViewParameterType("EMAIL_USECASES", 204, 2014);
        EMAIL_FIREHOSE_QUESTION_CREATE = new ViewParameterType("EMAIL_FIREHOSE_QUESTION_CREATE", 205, 2015);
        EMAIL_FIREHOSE_ANSWER_CREATE = new ViewParameterType("EMAIL_FIREHOSE_ANSWER_CREATE", 206, 2016);
        EMAIL_FIREHOSE_REPLY_CREATE = new ViewParameterType("EMAIL_FIREHOSE_REPLY_CREATE", 207, 2017);
        EMAIL_QUESTION_CREATE = new ViewParameterType("EMAIL_QUESTION_CREATE", 208, 2018);
        EMAIL_ANSWER_CREATE = new ViewParameterType("EMAIL_ANSWER_CREATE", 209, 2019);
        EMAIL_QUESTION_LIKE = new ViewParameterType("EMAIL_QUESTION_LIKE", 210, 2020);
        EMAIL_ANSWER_LIKE = new ViewParameterType("EMAIL_ANSWER_LIKE", 211, 2021);
        EMAIL_REPLY_CREATE = new ViewParameterType("EMAIL_REPLY_CREATE", 212, 2022);
        EMAIL_PARTNER = new ViewParameterType("EMAIL_PARTNER", 213, 2023);
        EMAIL_INTEREST_RECOMMENDATIONS = new ViewParameterType("EMAIL_INTEREST_RECOMMENDATIONS", 214, 2024);
        EMAIL_HOMEFEED_NEW_PINS = new ViewParameterType("EMAIL_HOMEFEED_NEW_PINS", 215, 2025);
        EMAIL_NETWORK_STORY_DIGEST = new ViewParameterType("EMAIL_NETWORK_STORY_DIGEST", 216, 2026);
        EMAIL_PINVITATIONAL_ACCESS = new ViewParameterType("EMAIL_PINVITATIONAL_ACCESS", 217, 2027);
        EMAIL_RESTART_FEED = new ViewParameterType("EMAIL_RESTART_FEED", 218, 2028);
        EMAIL_PINVITATIONAL_RALLYING_CALL = new ViewParameterType("EMAIL_PINVITATIONAL_RALLYING_CALL", 219, 2029);
        EMAIL_WEEK_IN_REVIEW = new ViewParameterType("EMAIL_WEEK_IN_REVIEW", 220, 2030);
        SERVICE_ENTRY_SOCIAL_FACEBOOK = new ViewParameterType("SERVICE_ENTRY_SOCIAL_FACEBOOK", 221, 2101);
        SERVICE_ENTRY_SOCIAL_TWITTER = new ViewParameterType("SERVICE_ENTRY_SOCIAL_TWITTER", 222, 2102);
        SERVICE_ENTRY_SEO_GOOGLE = new ViewParameterType("SERVICE_ENTRY_SEO_GOOGLE", 223, 2110);
        SERVICE_ENTRY_SEO_YAHOO = new ViewParameterType("SERVICE_ENTRY_SEO_YAHOO", 224, 2111);
        SERVICE_ENTRY_SEO_BING = new ViewParameterType("SERVICE_ENTRY_SEO_BING", 225, 2112);
        STERLING_CREATION_FLOW_PICK_A_PIN = new ViewParameterType("STERLING_CREATION_FLOW_PICK_A_PIN", 226, 2201);
        STERLING_CREATION_FLOW_SETUP_DETAILS = new ViewParameterType("STERLING_CREATION_FLOW_SETUP_DETAILS", 227, 2202);
        STERLING_CREATION_FLOW_BILLING = new ViewParameterType("STERLING_CREATION_FLOW_BILLING", 228, 2203);
        STERLING_PIN_PROMOTION_DASHBOARD = new ViewParameterType("STERLING_PIN_PROMOTION_DASHBOARD", 229, 2204);
        STERLING_PIN_PROMOTION_EDIT = new ViewParameterType("STERLING_PIN_PROMOTION_EDIT", 230, 2205);
        STERLING_CAMPAIGN_DASHBOARD = new ViewParameterType("STERLING_CAMPAIGN_DASHBOARD", 231, 2206);
        STERLING_CAMPAIGN_EDIT = new ViewParameterType("STERLING_CAMPAIGN_EDIT", 232, 2207);
        STERLING_ADVERTISER_DASHBOARD = new ViewParameterType("STERLING_ADVERTISER_DASHBOARD", 233, 2208);
        STERLING_ADVERTISER_EDIT = new ViewParameterType("STERLING_ADVERTISER_EDIT", 234, 2209);
        STERLING_ADVERTISER_SEARCH = new ViewParameterType("STERLING_ADVERTISER_SEARCH", 235, 2210);
        STERLING_ADVERTISER_EDIT_BILLING = new ViewParameterType("STERLING_ADVERTISER_EDIT_BILLING", 236, 2211);
        ANALYTICS_PROFILE_IMPRESSIONS = new ViewParameterType("ANALYTICS_PROFILE_IMPRESSIONS", 237, 2301);
        ANALYTICS_PROFILE_REPINS = new ViewParameterType("ANALYTICS_PROFILE_REPINS", 238, 2302);
        ANALYTICS_PROFILE_CLICKS = new ViewParameterType("ANALYTICS_PROFILE_CLICKS", 239, 2303);
        ANALYTICS_PROFILE_ALL_TIME = new ViewParameterType("ANALYTICS_PROFILE_ALL_TIME", 240, 2304);
        ANALYTICS_DOMAIN_IMPRESSIONS = new ViewParameterType("ANALYTICS_DOMAIN_IMPRESSIONS", 241, 2311);
        ANALYTICS_DOMAIN_REPINS = new ViewParameterType("ANALYTICS_DOMAIN_REPINS", 242, 2312);
        ANALYTICS_DOMAIN_CLICKS = new ViewParameterType("ANALYTICS_DOMAIN_CLICKS", 243, 2313);
        ANALYTICS_DOMAIN_ORIGINAL_PINS = new ViewParameterType("ANALYTICS_DOMAIN_ORIGINAL_PINS", 244, 2314);
        ANALYTICS_DOMAIN_ALL_TIME = new ViewParameterType("ANALYTICS_DOMAIN_ALL_TIME", 245, 2315);
        PINVITATIONAL_UNAUTH_EMAIL = new ViewParameterType("PINVITATIONAL_UNAUTH_EMAIL", 246, 2401);
        PINVITATIONAL_UNAUTH_CONFIRM = new ViewParameterType("PINVITATIONAL_UNAUTH_CONFIRM", 247, 2402);
        PINVITATIONAL_AUTH_CONFIRM = new ViewParameterType("PINVITATIONAL_AUTH_CONFIRM", 248, 2403);
        PINVITATIONAL_SIGNUP_REDEMPTION = new ViewParameterType("PINVITATIONAL_SIGNUP_REDEMPTION", 249, 2404);
        PINVITATIONAL_HOME_FEED_MODAL = new ViewParameterType("PINVITATIONAL_HOME_FEED_MODAL", 250, 2405);
        PINVITATIONAL_PIN_SUMMARY = new ViewParameterType("PINVITATIONAL_PIN_SUMMARY", 251, 2406);
        SETTINGS_SEARCH_PRIVACY = new ViewParameterType("SETTINGS_SEARCH_PRIVACY", 252, 227);
        SHARE_EXTENSION = new ViewParameterType("SHARE_EXTENSION", 253, 2500);
        $VALUES = (new ViewParameterType[] {
            FEED_FOLLOWING, FEED_FRIENDS, FEED_EVERYTHING, FEED_POPULAR, FEED_SOURCE, FEED_HOME, FEED_TOP_PICKS, FEED_WELCOME, PIN_CREATE_PINMARKLET, FEED_SUBCATEGORY, 
            FEED_INTEREST, FEED_DIGEST, FEED_DIGEST_STORY, CATEGORY_DISCOVER, FEED_CATEGORY_ANIMALS, FEED_CATEGORY_ARCHITECTURE, FEED_CATEGORY_ART, FEED_CATEGORY_CARS_MOTORCYCLES, FEED_CATEGORY_CELEBRITIES, FEED_CATEGORY_DESIGN, 
            FEED_CATEGORY_DIY_CRAFTS, FEED_CATEGORY_EDUCATION, FEED_CATEGORY_FILM_MUSIC_BOOKS, FEED_CATEGORY_FOOD_DRINK, FEED_CATEGORY_GARDENING, FEED_CATEGORY_GEEK, FEED_CATEGORY_HAIR_BEAUTY, FEED_CATEGORY_HEALTH_FITNESS, FEED_CATEGORY_HISTORY, FEED_CATEGORY_HOLIDAYS_EVENTS, 
            FEED_CATEGORY_HOME_DECOR, FEED_CATEGORY_HUMOR, FEED_CATEGORY_ILLUSTRATIONS_POSTERS, FEED_CATEGORY_KIDS, FEED_CATEGORY_MENS_FASHION, FEED_CATEGORY_OUTDOORS, FEED_CATEGORY_PHOTOGRAPHY, FEED_CATEGORY_PRODUCTS, FEED_CATEGORY_QUOTES, FEED_CATEGORY_SCIENCE_NATURE, 
            FEED_CATEGORY_SPORTS, FEED_CATEGORY_TATTOOS, FEED_CATEGORY_TECHNOLOGY, FEED_CATEGORY_TRAVEL, FEED_CATEGORY_WEDDINGS, FEED_CATEGORY_WOMENS_FASHION, FEED_CATEGORY_HOLIDAY_FOR_HIM, FEED_CATEGORY_HOLIDAY_FOR_HER, FEED_CATEGORY_HOLIDAY_FOR_KIDS, FEED_CATEGORY_HOLIDAY_FOR_ALL, 
            FEED_CATEGORY_CHRISTMAS_SWEATER, FEED_CATEGORY, FEED_GIFTS, FEED_GIFTS_20, FEED_GIFTS_20_50, FEED_GIFTS_50_100, FEED_GIFTS_100_200, FEED_GIFTS_200_500, FEED_GIFTS_500, FEED_VIDEOS, 
            FEED_DOMAIN, FEED_PLACES, FEED_COMMERCE, DISCOVER_CATEGORY, DISCOVER_INTEREST, DISCOVER_SEARCH_INTERESTS, SEARCH_PINS, SEARCH_BOARDS, SEARCH_USERS, SEARCH_AUTOCOMPLETE, 
            SEARCH_MY_PINS, SEARCH_PLACES, SEARCH_PLACE_BOARDS, SEARCH_INTERESTS, REGISTRATION_LANDING, REGISTRATION_SIGNUP, REGISTRATION_BOARDS, REGISTRATION_SIGNUP_BUSINESS, REGISTRATION_LOCAL_INFO, REGISTRATION_AGE_GENDER, 
            USER_BOARDS, USER_FOLLOWERS, USER_FOLLOWING, USER_LIKES, USER_ACTIVITY, USER_PINS, USER_EDIT, USER_INTERESTS, USER_FYP, BOARD_FOLLOWERS, 
            BOARD_SETTINGS, BOARD_CREATE, BOARD_EDIT, BOARD_EDIT_COLLABORATORS, BOARD_PLACE, BOARD_MAP, FRIEND_INVITER_EMAIL, FRIEND_INVITER_FACEBOOK, FRIEND_INVITER_FIND_FRIENDS, FRIEND_INVITER_GMAIL, 
            FRIEND_INVITER_INVITE, FRIEND_INVITER_TWITTER, FRIEND_INVITER_YAHOO, ABOUT_TERMS, ABOUT_SUPPORT, ABOUT_BOOKMARKLET, ABOUT_ETIQUETTE, ABOUT_ABOUT, ABOUT_GOODIES, ABOUT_CAREERS, 
            ABOUT_TEAM, ABOUT_PRESS, ABOUT_PRIVACY, ABOUT_USE, ABOUT_COPYRIGHT, LOGIN_EMAIL, LOGIN_FACEBOOK, LOGIN_TWITTER, ERROR_NO_INTERNET, ERROR_NO_PIN, 
            ERROR_NO_BOARD, ERROR_NO_USER, ERROR_NO_ACTIVITY, REPORT_PIN, REPORT_USER, PIN_CREATE_REPIN, PIN_CREATE, PIN_CREATE_SDK, PIN_EDIT, PIN_SEND_TO, 
            USER_ABOUT, BOARD_COLLABORATORS, EDUCATION_LONGPRESS, EDUCATION_RELATED_PINS, EDUCATION_SECRET_BOARD, EDUCATION_CONTEXTUAL_MENU, EDUCATION_GUIDED_SEARCH, EDUCATION_FLYOUT, MOBILE_ORIENTATION_DISCOVER, MOBILE_ORIENTATION_COLLECT, 
            MOBILE_ORIENTATION_FUNCTIONAL, MOBILE_ORIENTATION_STORY, ORIENTATION_FAST_FOLLOW, PICKED_FOR_YOU_FEED, FEED_EDITOR_FOLLOW_BOARDS, FEED_EDITOR_UNFOLLOW_BOARDS, DEPRECATED_DEEP_LINKING_EMAIL, DEPRECATED_DEEP_LINKING_WEB, DEEP_LINKING_FACEBOOK, DEEP_LINKING_APP, 
            FEED_RELATED_BOARD, FEED_RELATED_INTEREST, FIND_FRIENDS, PIN_OTHER, PIN_REGULAR, PIN_ARTICLE, PIN_MOVIE, PIN_PLACE, PIN_PRODUCT, PIN_RECIPE, 
            PIN_LOOKBOOK, PIN_CREATE_PLACES, PIN_LIKES, PIN_COMMENTS, PIN_REPIN_BOARDS, PIN_QUESTIONS, PIN_ANSWERS, PIN_REPLIES, SPLASH_LOADING, SPLASH_INSPIRED_WALL, 
            ORIENTATION_START, ORIENTATION_END, ORIENTATION_INTEREST_PICKER, ORIENTATION_USER_PICKER, REBUILD_FEED_INTEREST_PICKER, REBUILD_FEED_END, STORIES_RELATED_PINS, STORIES_RELATED_USERS, STORIES_RELATED_BOARDS, BROWSER, 
            CONVERSATION_CREATE, CONVERSATION_THREAD, CONVERSATION_INBOX, CONVERSATION_ADD_PIN, CONVERSATION_USERS, NEWS_NETWORK_STORY, NEWS_YOUR_STORY, PIN_TWINS, ACTIVITY_V2, EXTERNAL_SOURCE_OTHER, 
            EMAIL_UNKNOWN, EMAIL_TRANSACTIONAL, EMAIL_EDITORIAL, EMAIL_ACTIVITY_AGGREGATION, EMAIL_RECOMMENDATIONS_DIGEST, EMAIL_SOCIAL_DIGEST, EMAIL_SEND_PIN, EMAIL_SEND_BOARD, EMAIL_SEND_PINNER, EMAIL_FRIEND_JOINED, 
            EMAIL_WELCOME, EMAIL_BOARD_RECOMMENDATIONS, EMAIL_PIN_RECOMMENDATIONS, EMAIL_COMMENT_AND_MENTION, EMAIL_USECASES, EMAIL_FIREHOSE_QUESTION_CREATE, EMAIL_FIREHOSE_ANSWER_CREATE, EMAIL_FIREHOSE_REPLY_CREATE, EMAIL_QUESTION_CREATE, EMAIL_ANSWER_CREATE, 
            EMAIL_QUESTION_LIKE, EMAIL_ANSWER_LIKE, EMAIL_REPLY_CREATE, EMAIL_PARTNER, EMAIL_INTEREST_RECOMMENDATIONS, EMAIL_HOMEFEED_NEW_PINS, EMAIL_NETWORK_STORY_DIGEST, EMAIL_PINVITATIONAL_ACCESS, EMAIL_RESTART_FEED, EMAIL_PINVITATIONAL_RALLYING_CALL, 
            EMAIL_WEEK_IN_REVIEW, SERVICE_ENTRY_SOCIAL_FACEBOOK, SERVICE_ENTRY_SOCIAL_TWITTER, SERVICE_ENTRY_SEO_GOOGLE, SERVICE_ENTRY_SEO_YAHOO, SERVICE_ENTRY_SEO_BING, STERLING_CREATION_FLOW_PICK_A_PIN, STERLING_CREATION_FLOW_SETUP_DETAILS, STERLING_CREATION_FLOW_BILLING, STERLING_PIN_PROMOTION_DASHBOARD, 
            STERLING_PIN_PROMOTION_EDIT, STERLING_CAMPAIGN_DASHBOARD, STERLING_CAMPAIGN_EDIT, STERLING_ADVERTISER_DASHBOARD, STERLING_ADVERTISER_EDIT, STERLING_ADVERTISER_SEARCH, STERLING_ADVERTISER_EDIT_BILLING, ANALYTICS_PROFILE_IMPRESSIONS, ANALYTICS_PROFILE_REPINS, ANALYTICS_PROFILE_CLICKS, 
            ANALYTICS_PROFILE_ALL_TIME, ANALYTICS_DOMAIN_IMPRESSIONS, ANALYTICS_DOMAIN_REPINS, ANALYTICS_DOMAIN_CLICKS, ANALYTICS_DOMAIN_ORIGINAL_PINS, ANALYTICS_DOMAIN_ALL_TIME, PINVITATIONAL_UNAUTH_EMAIL, PINVITATIONAL_UNAUTH_CONFIRM, PINVITATIONAL_AUTH_CONFIRM, PINVITATIONAL_SIGNUP_REDEMPTION, 
            PINVITATIONAL_HOME_FEED_MODAL, PINVITATIONAL_PIN_SUMMARY, SETTINGS_SEARCH_PRIVACY, SHARE_EXTENSION
        });
    }
}
