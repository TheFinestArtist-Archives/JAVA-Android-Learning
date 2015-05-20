// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class EventType extends Enum
    implements TEnum
{

    private static final EventType $VALUES[];
    public static final EventType ADDRESS_BOOK_UPLOAD;
    public static final EventType ADVERTISER_CREATE;
    public static final EventType ADVERTISER_UPDATE;
    public static final EventType ANDROID_REQUEST;
    public static final EventType ANDROID_WIDGET_DISABLE;
    public static final EventType ANDROID_WIDGET_ENABLE;
    public static final EventType ANDROID_WIDGET_UPDATE;
    public static final EventType ANSWER_CREATE;
    public static final EventType ANSWER_DELETE;
    public static final EventType ANSWER_EDIT;
    public static final EventType ANSWER_LIKE;
    public static final EventType ANSWER_REPORT;
    public static final EventType ANSWER_UNLIKE;
    public static final EventType ANSWER_VIEW;
    public static final EventType API_PAGEVIEW;
    public static final EventType APP_BACKGROUND;
    public static final EventType APP_CRASH;
    public static final EventType APP_INSTALL;
    public static final EventType APP_PIN_INSTALLATION_CONFIRMATION;
    public static final EventType APP_START;
    public static final EventType APP_TIMING;
    public static final EventType AUTOTUNE_EMAIL_OPEN;
    public static final EventType AUTOTUNE_REWARD;
    public static final EventType BILLING_FAILURE;
    public static final EventType BILLING_SUCCESS;
    public static final EventType BOARD_ACCEPT_INVITE_COLLABORATOR;
    public static final EventType BOARD_ADD_COLLABORATOR;
    public static final EventType BOARD_CREATE;
    public static final EventType BOARD_DECLINE_INVITE_COLLABORATOR;
    public static final EventType BOARD_DELETE;
    public static final EventType BOARD_EDIT;
    public static final EventType BOARD_FOLLOW;
    public static final EventType BOARD_INVITE_COLLABORATOR;
    public static final EventType BOARD_REMOVE_COLLABORATOR;
    public static final EventType BOARD_REORDER_PINS;
    public static final EventType BOARD_REQUEST_APPROVAL_INVITE_COLLABORATOR;
    public static final EventType BOARD_REQUEST_INVITE_COLLABORATOR;
    public static final EventType BOARD_SEND;
    public static final EventType BOARD_SET_PRIVATE;
    public static final EventType BOARD_SET_PUBLIC;
    public static final EventType BOARD_UNFOLLOW;
    public static final EventType BOARD_VIEW;
    public static final EventType BROWSER;
    public static final EventType BULK_PIN_DELETE;
    public static final EventType BULK_PIN_MOVE;
    public static final EventType BULK_PIN_REPIN;
    public static final EventType CAMPAIGN_CREATE;
    public static final EventType CAMPAIGN_UPDATE;
    public static final EventType CART_CALCULATE_PRICE;
    public static final EventType CART_CREATE;
    public static final EventType CART_DELETE;
    public static final EventType CART_DELETE_ITEMS;
    public static final EventType CART_GET_PAYMENT_STATUS;
    public static final EventType CART_PAY;
    public static final EventType CART_UPDATE;
    public static final EventType CART_UPDATE_ITEMS;
    public static final EventType CART_VIEW;
    public static final EventType CLICK;
    public static final EventType CLIENT_NOTIFICATION_OPENED_BY;
    public static final EventType CLIENT_NOTIFICATION_RECEIVED_BY;
    public static final EventType CLOSEUP_MODAL_SIGNUP;
    public static final EventType CLOSEUP_MODAL_SIGNUP_VIEW;
    public static final EventType CONTEXTUAL_MENU_CLOSE;
    public static final EventType CONTEXTUAL_MENU_OPEN;
    public static final EventType CONVERSATION_CREATE;
    public static final EventType CONVERSATION_HIDE;
    public static final EventType CONVERSATION_MESSAGE_SEND;
    public static final EventType CONVERSATION_REPORT;
    public static final EventType CONVERSATION_UPGRADE_EXTERNAL_USER;
    public static final EventType CONVERSION_TAG_CREATE;
    public static final EventType CONVERSION_TAG_UPDATE;
    public static final EventType DEEP_LINK_GOOGLE_APP_INDEXING;
    public static final EventType DEEP_LINK_HTTP;
    public static final EventType DEEP_LINK_OTHER;
    public static final EventType DEEP_LINK_PINTEREST;
    public static final EventType DEVICE_START;
    public static final EventType DOMAIN_VERIFIED;
    public static final EventType DRAG;
    public static final EventType EMAIL_CLICKTHROUGH_DEPRECATED;
    public static final EventType EMAIL_CLICK_API_DEPRECATED;
    public static final EventType EMAIL_CLICK_DEPRECATED;
    public static final EventType EMAIL_OPEN_API_DEPRECATED;
    public static final EventType EMAIL_OPEN_DEPRECATED;
    public static final EventType EMAIL_RECEIVE;
    public static final EventType EMAIL_SUBSCRIBE_SETTINGS_CHANGE;
    public static final EventType EMAIL_UNIQUE_BOUNCE;
    public static final EventType EMAIL_UNIQUE_CLICK;
    public static final EventType EMAIL_UNIQUE_DELIVER;
    public static final EventType EMAIL_UNIQUE_OPEN;
    public static final EventType EMAIL_UNIQUE_SPAMREPORT;
    public static final EventType EMAIL_UNIQUE_UNSUBSCRIBE;
    public static final EventType EMAIL_UNSUBSCRIBE_SETTINGS_CHANGE;
    public static final EventType EXPLAIN_CREATE;
    public static final EventType EXPLAIN_DELETE;
    public static final EventType EXPLAIN_EDIT;
    public static final EventType EXPLAIN_VIEW;
    public static final EventType EXP_SERVERSIDE_IMPRESSION_EVENT;
    public static final EventType FEED_SUBCATEGORY;
    public static final EventType FEED_VIEW;
    public static final EventType GOT_BOARD_FOLLOW;
    public static final EventType GOT_BOARD_INVITE_COLLABORATOR;
    public static final EventType GOT_CLICKTHROUGH;
    public static final EventType GOT_IMPRESSION;
    public static final EventType GOT_PIN_COMMENT;
    public static final EventType GOT_PIN_LIKE;
    public static final EventType GOT_PIN_REPIN;
    public static final EventType GOT_PIN_VIEW;
    public static final EventType GOT_USER_FOLLOW;
    public static final EventType HOME_PAGE_SIGNUP;
    public static final EventType HOME_PAGE_SIGNUP_VIEW;
    public static final EventType HOVER;
    public static final EventType INTEREST_FEED_FRESHNESS;
    public static final EventType INTEREST_FOLLOW;
    public static final EventType INTEREST_IMPRESSION_SERVER_SIDE;
    public static final EventType INTEREST_PIN_DOWNVOTE;
    public static final EventType INTEREST_PIN_UPVOTE;
    public static final EventType INTEREST_REMOVE;
    public static final EventType INTEREST_UNFOLLOW;
    public static final EventType INTEREST_UNREMOVE;
    public static final EventType INTERSTITIAL_LOADED;
    public static final EventType INTERSTITIAL_OPEN_IN_APP;
    public static final EventType INTERSTITIAL_OPEN_IN_BROWSER;
    public static final EventType IPAD_REQUEST;
    public static final EventType IPHONE_REQUEST;
    public static final EventType IPOD_REQUEST;
    public static final EventType LINK_EXTRACT;
    public static final EventType LONG_PRESS;
    public static final EventType MAC_REQUEST;
    public static final EventType MINUTE_WITH_REQUEST;
    public static final EventType MOBILE_BADGE_RECEIEVED;
    public static final EventType MOBILE_BADGE_SHOWN;
    public static final EventType NOTIFICATION;
    public static final EventType NOTIFICATION_SUBSCRIBE_SETTINGS_CHANGE;
    public static final EventType NOTIFICATION_UNSUBSCRIBE_SETTINGS_CHANGE;
    public static final EventType OTHER_REQUEST;
    public static final EventType OWN_BOARD_VIEW;
    public static final EventType OWN_PIN_CLICK;
    public static final EventType OWN_PIN_VIEW;
    public static final EventType OWN_PROFILE_VIEW;
    public static final EventType PAGEVIEW;
    public static final EventType PAYMENT_METHOD_CREATE;
    public static final EventType PAYMENT_METHOD_DELETE;
    public static final EventType PAYMENT_METHOD_UPDATE;
    public static final EventType PAYMENT_METHOD_VIEW;
    public static final EventType PFY_PIN_THROUGH_BOARD_HIDE;
    public static final EventType PFY_PIN_THROUGH_PIN_HIDE;
    public static final EventType PINCH;
    public static final EventType PIN_CLICKTHROUGH;
    public static final EventType PIN_CLOSEUP;
    public static final EventType PIN_COMMENT;
    public static final EventType PIN_COMMENT_FLAG;
    public static final EventType PIN_CREATE;
    public static final EventType PIN_DEACTIVATE;
    public static final EventType PIN_DELETE;
    public static final EventType PIN_DELETE_COMMENT;
    public static final EventType PIN_EDIT;
    public static final EventType PIN_FEEDBACK;
    public static final EventType PIN_FLAG;
    public static final EventType PIN_HIDE;
    public static final EventType PIN_IMPRESSION_ONE_PIXEL;
    public static final EventType PIN_IMPRESSION_SERVER_SIDE;
    public static final EventType PIN_INSERTION;
    public static final EventType PIN_INSERT_TO_HOME_FEED;
    public static final EventType PIN_INSERT_TO_INTEREST_FEED;
    public static final EventType PIN_INSERT_TO_PUBLIC_FEED;
    public static final EventType PIN_IT_BUTTON_LANDING_SIGNUP;
    public static final EventType PIN_IT_BUTTON_LANDING_SIGNUP_VIEW;
    public static final EventType PIN_LIKE;
    public static final EventType PIN_LONG_CLICKTHROUGH;
    public static final EventType PIN_PROMOTION_CREATE;
    public static final EventType PIN_PROMOTION_UPDATE;
    public static final EventType PIN_REACTIVATE;
    public static final EventType PIN_REPIN;
    public static final EventType PIN_REPIN_OR_CLICKTHROUGH;
    public static final EventType PIN_REPORT;
    public static final EventType PIN_SAVE_TO_DEVICE;
    public static final EventType PIN_SCREENSHOT;
    public static final EventType PIN_SEND;
    public static final EventType PIN_SHARE;
    public static final EventType PIN_SHARE_FACEBOOK;
    public static final EventType PIN_SHORT_CLICKTHROUGH;
    public static final EventType PIN_UNLIKE;
    public static final EventType PIN_UPVOTE;
    public static final EventType PIN_VIEW;
    public static final EventType PIN_VIEW_ON_HOME_FEED;
    public static final EventType PLACE_CREATE;
    public static final EventType PLAIN_MODAL_SIGNUP;
    public static final EventType PLAIN_MODAL_SIGNUP_VIEW;
    public static final EventType POPULAR_PINS_EMAIL;
    public static final EventType PROMOTED_PIN_FLAG;
    public static final EventType PROMOTED_PIN_HIDE;
    public static final EventType PULL_NOTIFICATION_OPENED_BY;
    public static final EventType PULL_NOTIFICATION_RECEIVED_BY;
    public static final EventType PULL_TO_REFRESH;
    public static final EventType PUSH_NOTIFICATION_DEVICE_ASSOCIATED;
    public static final EventType PUSH_NOTIFICATION_DEVICE_DISABLED;
    public static final EventType PUSH_NOTIFICATION_DEVICE_DISASSOCIATED;
    public static final EventType PUSH_NOTIFICATION_DEVICE_ENABLED;
    public static final EventType PUSH_NOTIFICATION_OPENED_BY;
    public static final EventType PUSH_NOTIFICATION_RECEIVED_BY;
    public static final EventType PUSH_NOTIFICATION_REGISTRATION_FAILED;
    public static final EventType PUSH_NOTIFICATION_SENT_TO;
    public static final EventType QUESTION_ANSWERED;
    public static final EventType QUESTION_CREATE;
    public static final EventType QUESTION_DELETE;
    public static final EventType QUESTION_EDIT;
    public static final EventType QUESTION_LIKE;
    public static final EventType QUESTION_REPORT;
    public static final EventType QUESTION_UNLIKE;
    public static final EventType QUESTION_VIEW;
    public static final EventType REFERRER_APP_INSTALL;
    public static final EventType REFERRER_APP_INSTALL_ATTEMPT;
    public static final EventType REFRESH;
    public static final EventType RENDER;
    public static final EventType REPLY_CREATE;
    public static final EventType REPLY_DELETE;
    public static final EventType REPLY_EDIT;
    public static final EventType REPLY_REPORT;
    public static final EventType REPLY_VIEW;
    public static final EventType SAFARI_KEYCHAIN_SUCCESSFUL_LOGIN;
    public static final EventType SCROLL;
    public static final EventType SEARCH_BOARDS;
    public static final EventType SEARCH_INTERESTS;
    public static final EventType SEARCH_MY_PINS;
    public static final EventType SEARCH_PINS;
    public static final EventType SEARCH_PLACE_BOARDS;
    public static final EventType SEARCH_RECIPES;
    public static final EventType SEARCH_RESULT_IMPRESSION_ONE_PIXEL;
    public static final EventType SEARCH_USERS;
    public static final EventType SEARCH_VIDEOS;
    public static final EventType SEND_PIN_RECOMMENDATION;
    public static final EventType SERVICE_ENTRY;
    public static final EventType SHIPPING_DETAIL_CREATE;
    public static final EventType SHIPPING_DETAIL_DELETE;
    public static final EventType SHIPPING_DETAIL_UPDATE;
    public static final EventType SHIPPING_DETAIL_VIEW;
    public static final EventType SWIPE;
    public static final EventType TAP;
    public static final EventType TOGGLE_OFF;
    public static final EventType TOGGLE_ON;
    public static final EventType TOP_NOTIFICATION_CLICKED;
    public static final EventType TRANSLATION_DETECTION;
    public static final EventType TRANSLATION_TRIGGERED;
    public static final EventType UNKNOWN_PLACEMENT_SIGNUP;
    public static final EventType URL_CHECK;
    public static final EventType URL_CLICKTHROUGH;
    public static final EventType URL_IMAGE;
    public static final EventType USER_BLOCK;
    public static final EventType USER_CREATE;
    public static final EventType USER_DEACTIVATED;
    public static final EventType USER_DELETE;
    public static final EventType USER_DELETED_APP;
    public static final EventType USER_DISABLE_ANALYTICS;
    public static final EventType USER_DISABLE_FACBOOK;
    public static final EventType USER_DISABLE_FACEBOOK_TIMELINE;
    public static final EventType USER_DISABLE_GPLUS;
    public static final EventType USER_DISABLE_RAKUTEN;
    public static final EventType USER_DISABLE_TWITTER;
    public static final EventType USER_EDIT;
    public static final EventType USER_ENABLE_ANALYTICS;
    public static final EventType USER_ENABLE_FACEBOOK;
    public static final EventType USER_ENABLE_FACEBOOK_TIMELINE;
    public static final EventType USER_ENABLE_GPLUS;
    public static final EventType USER_ENABLE_RAKUTEN;
    public static final EventType USER_ENABLE_TWITTER;
    public static final EventType USER_FOLLOW;
    public static final EventType USER_GENDER_CHANGED;
    public static final EventType USER_INVITE;
    public static final EventType USER_INVITE_CREATE;
    public static final EventType USER_INVITE_CREATE_DEPRECATED;
    public static final EventType USER_INVITE_EMAIL_SENT;
    public static final EventType USER_INVITE_FACEBOOK_CREATE;
    public static final EventType USER_INVITE_FACEBOOK_SENT;
    public static final EventType USER_INVITE_FB_MESSENGER_SENT;
    public static final EventType USER_INVITE_LINE_SENT;
    public static final EventType USER_INVITE_SMS_SENT;
    public static final EventType USER_INVITE_WHATSAPP_SENT;
    public static final EventType USER_LOGIN_ATTEMPT;
    public static final EventType USER_LOGIN_FAILED;
    public static final EventType USER_LOGIN_SUCCESS;
    public static final EventType USER_PARTNER_CONVERT;
    public static final EventType USER_PARTNER_CREATE;
    public static final EventType USER_PASSWORD_RESET_COMPLETED;
    public static final EventType USER_PASSWORD_RESET_REQUEST;
    public static final EventType USER_PERSONALIZED_RECOMMENDATIONS_CHANGED;
    public static final EventType USER_PUBLISH_TO_SOCIAL_NETWORK;
    public static final EventType USER_REACTIVATED;
    public static final EventType USER_REORDER_BOARDS;
    public static final EventType USER_REPORT;
    public static final EventType USER_SEARCH_PRIVACY_CHANGED;
    public static final EventType USER_SEND;
    public static final EventType USER_SUSPICIOUS_LOGIN;
    public static final EventType USER_UNBLOCK;
    public static final EventType USER_UNFOLLOW;
    public static final EventType USER_VIEW;
    public static final EventType VIEW;
    public static final EventType VIEW_TAG_PINGED;
    public static final EventType VISUAL_OBJECT_IMPRESSION_SERVER_SIDE;
    public static final EventType VISUAL_RESULTS_IMPRESSION_SERVER_SIDE;
    public static final EventType WEB_OR_API_REQUEST;
    public static final EventType WEB_PICKER_ENTER;
    public static final EventType WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN;
    public static final EventType WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_DOWN;
    public static final EventType WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_UP;
    public static final EventType WEB_PIN_CREATE_CLOSE_MODAL_BEFORE_PINNING;
    public static final EventType WEB_PIN_CREATE_ENTER_TO_SELECT_BOARD;
    public static final EventType WIDESCREEN_MODAL_SIGNUP;
    public static final EventType WIDESCREEN_MODAL_SIGNUP_VIEW;
    public static final EventType WINDOWS_REQUEST;
    private final int value;

    private EventType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EventType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 13: // '\r'
            return VIEW;

        case 1: // '\001'
            return PIN_CREATE;

        case 2: // '\002'
            return PIN_EDIT;

        case 3: // '\003'
            return PIN_DELETE;

        case 4: // '\004'
            return PIN_VIEW;

        case 5: // '\005'
            return PIN_REPIN;

        case 6: // '\006'
            return PIN_LIKE;

        case 7: // '\007'
            return PIN_COMMENT;

        case 8: // '\b'
            return PIN_SHARE;

        case 9: // '\t'
            return PIN_UNLIKE;

        case 10: // '\n'
            return PIN_DELETE_COMMENT;

        case 11: // '\013'
            return PIN_FLAG;

        case 12: // '\f'
            return PIN_CLICKTHROUGH;

        case 14: // '\016'
            return PIN_SEND;

        case 15: // '\017'
            return PIN_INSERTION;

        case 16: // '\020'
            return PIN_CLOSEUP;

        case 17: // '\021'
            return PIN_HIDE;

        case 18: // '\022'
            return PIN_IMPRESSION_ONE_PIXEL;

        case 19: // '\023'
            return PIN_IMPRESSION_SERVER_SIDE;

        case 20: // '\024'
            return BOARD_CREATE;

        case 21: // '\025'
            return BOARD_EDIT;

        case 22: // '\026'
            return BOARD_DELETE;

        case 23: // '\027'
            return BOARD_VIEW;

        case 26: // '\032'
            return BOARD_FOLLOW;

        case 27: // '\033'
            return BOARD_UNFOLLOW;

        case 30: // '\036'
            return BOARD_SET_PRIVATE;

        case 31: // '\037'
            return BOARD_SET_PUBLIC;

        case 24: // '\030'
            return BOARD_ADD_COLLABORATOR;

        case 25: // '\031'
            return BOARD_REMOVE_COLLABORATOR;

        case 28: // '\034'
            return BOARD_INVITE_COLLABORATOR;

        case 29: // '\035'
            return BOARD_DECLINE_INVITE_COLLABORATOR;

        case 32: // ' '
            return BOARD_ACCEPT_INVITE_COLLABORATOR;

        case 33: // '!'
            return BOARD_REQUEST_INVITE_COLLABORATOR;

        case 34: // '"'
            return BOARD_REQUEST_APPROVAL_INVITE_COLLABORATOR;

        case 35: // '#'
            return BOARD_SEND;

        case 36: // '$'
            return BOARD_REORDER_PINS;

        case 38: // '&'
            return USER_LOGIN_SUCCESS;

        case 39: // '\''
            return USER_LOGIN_FAILED;

        case 40: // '('
            return USER_CREATE;

        case 41: // ')'
            return USER_EDIT;

        case 42: // '*'
            return USER_DELETE;

        case 43: // '+'
            return USER_VIEW;

        case 44: // ','
            return USER_REORDER_BOARDS;

        case 45: // '-'
            return USER_FOLLOW;

        case 46: // '.'
            return USER_UNFOLLOW;

        case 47: // '/'
            return USER_INVITE;

        case 48: // '0'
            return USER_DEACTIVATED;

        case 49: // '1'
            return USER_REACTIVATED;

        case 50: // '2'
            return USER_LOGIN_ATTEMPT;

        case 51: // '3'
            return USER_PASSWORD_RESET_REQUEST;

        case 52: // '4'
            return USER_PASSWORD_RESET_COMPLETED;

        case 53: // '5'
            return USER_SUSPICIOUS_LOGIN;

        case 54: // '6'
            return USER_BLOCK;

        case 55: // '7'
            return USER_UNBLOCK;

        case 56: // '8'
            return USER_REPORT;

        case 57: // '9'
            return USER_PARTNER_CREATE;

        case 58: // ':'
            return USER_PARTNER_CONVERT;

        case 59: // ';'
            return PIN_REPORT;

        case 75: // 'K'
            return USER_PUBLISH_TO_SOCIAL_NETWORK;

        case 76: // 'L'
            return PIN_COMMENT_FLAG;

        case 60: // '<'
            return SEARCH_PINS;

        case 61: // '='
            return SEARCH_BOARDS;

        case 62: // '>'
            return SEARCH_USERS;

        case 63: // '?'
            return SEARCH_MY_PINS;

        case 64: // '@'
            return SEARCH_VIDEOS;

        case 65: // 'A'
            return SEARCH_RECIPES;

        case 66: // 'B'
            return SEARCH_PLACE_BOARDS;

        case 67: // 'C'
            return SEARCH_INTERESTS;

        case 69: // 'E'
            return FEED_SUBCATEGORY;

        case 70: // 'F'
            return EMAIL_RECEIVE;

        case 71: // 'G'
            return EMAIL_OPEN_DEPRECATED;

        case 72: // 'H'
            return EMAIL_OPEN_API_DEPRECATED;

        case 73: // 'I'
            return EMAIL_CLICK_DEPRECATED;

        case 74: // 'J'
            return EMAIL_CLICK_API_DEPRECATED;

        case 80: // 'P'
            return FEED_VIEW;

        case 81: // 'Q'
            return REFRESH;

        case 82: // 'R'
            return PIN_SAVE_TO_DEVICE;

        case 83: // 'S'
            return BROWSER;

        case 84: // 'T'
            return USER_ENABLE_ANALYTICS;

        case 85: // 'U'
            return USER_DISABLE_ANALYTICS;

        case 86: // 'V'
            return USER_ENABLE_FACEBOOK;

        case 87: // 'W'
            return USER_DISABLE_FACBOOK;

        case 88: // 'X'
            return USER_ENABLE_FACEBOOK_TIMELINE;

        case 89: // 'Y'
            return USER_DISABLE_FACEBOOK_TIMELINE;

        case 90: // 'Z'
            return USER_ENABLE_TWITTER;

        case 91: // '['
            return USER_DISABLE_TWITTER;

        case 92: // '\\'
            return USER_ENABLE_GPLUS;

        case 93: // ']'
            return USER_DISABLE_GPLUS;

        case 94: // '^'
            return USER_ENABLE_RAKUTEN;

        case 95: // '_'
            return USER_DISABLE_RAKUTEN;

        case 96: // '`'
            return USER_DELETED_APP;

        case 101: // 'e'
            return CLICK;

        case 102: // 'f'
            return TAP;

        case 103: // 'g'
            return LONG_PRESS;

        case 104: // 'h'
            return DRAG;

        case 105: // 'i'
            return HOVER;

        case 106: // 'j'
            return TOGGLE_ON;

        case 107: // 'k'
            return TOGGLE_OFF;

        case 108: // 'l'
            return SWIPE;

        case 109: // 'm'
            return PINCH;

        case 110: // 'n'
            return SCROLL;

        case 111: // 'o'
            return PUSH_NOTIFICATION_SENT_TO;

        case 112: // 'p'
            return PUSH_NOTIFICATION_RECEIVED_BY;

        case 113: // 'q'
            return PUSH_NOTIFICATION_OPENED_BY;

        case 114: // 'r'
            return PUSH_NOTIFICATION_DEVICE_ASSOCIATED;

        case 115: // 's'
            return PUSH_NOTIFICATION_DEVICE_DISASSOCIATED;

        case 116: // 't'
            return PUSH_NOTIFICATION_DEVICE_ENABLED;

        case 117: // 'u'
            return PUSH_NOTIFICATION_DEVICE_DISABLED;

        case 121: // 'y'
            return PUSH_NOTIFICATION_REGISTRATION_FAILED;

        case 118: // 'v'
            return CONTEXTUAL_MENU_OPEN;

        case 119: // 'w'
            return CONTEXTUAL_MENU_CLOSE;

        case 120: // 'x'
            return RENDER;

        case 130: 
            return PIN_UPVOTE;

        case 131: 
            return PROMOTED_PIN_FLAG;

        case 132: 
            return PROMOTED_PIN_HIDE;

        case 133: 
            return PIN_DEACTIVATE;

        case 134: 
            return PIN_REACTIVATE;

        case 135: 
            return PIN_FEEDBACK;

        case 136: 
            return PFY_PIN_THROUGH_BOARD_HIDE;

        case 137: 
            return PIN_SCREENSHOT;

        case 138: 
            return PIN_REPIN_OR_CLICKTHROUGH;

        case 139: 
            return APP_PIN_INSTALLATION_CONFIRMATION;

        case 150: 
            return USER_SEND;

        case 151: 
            return USER_INVITE_CREATE;

        case 152: 
            return USER_INVITE_FACEBOOK_CREATE;

        case 153: 
            return USER_INVITE_FACEBOOK_SENT;

        case 154: 
            return USER_INVITE_EMAIL_SENT;

        case 155: 
            return USER_GENDER_CHANGED;

        case 156: 
            return USER_SEARCH_PRIVACY_CHANGED;

        case 157: 
            return USER_PERSONALIZED_RECOMMENDATIONS_CHANGED;

        case 158: 
            return PULL_TO_REFRESH;

        case 159: 
            return USER_INVITE_SMS_SENT;

        case 160: 
            return USER_INVITE_FB_MESSENGER_SENT;

        case 161: 
            return USER_INVITE_WHATSAPP_SENT;

        case 162: 
            return USER_INVITE_LINE_SENT;

        case 180: 
            return CONVERSATION_MESSAGE_SEND;

        case 181: 
            return CONVERSATION_CREATE;

        case 182: 
            return CONVERSATION_HIDE;

        case 183: 
            return CONVERSATION_REPORT;

        case 184: 
            return CONVERSATION_UPGRADE_EXTERNAL_USER;

        case 200: 
            return DOMAIN_VERIFIED;

        case 201: 
            return URL_CHECK;

        case 202: 
            return URL_IMAGE;

        case 203: 
            return URL_CLICKTHROUGH;

        case 220: 
            return QUESTION_CREATE;

        case 221: 
            return QUESTION_VIEW;

        case 222: 
            return QUESTION_EDIT;

        case 223: 
            return QUESTION_DELETE;

        case 224: 
            return QUESTION_LIKE;

        case 225: 
            return QUESTION_UNLIKE;

        case 226: 
            return QUESTION_REPORT;

        case 240: 
            return ANSWER_CREATE;

        case 241: 
            return ANSWER_VIEW;

        case 242: 
            return ANSWER_EDIT;

        case 243: 
            return ANSWER_DELETE;

        case 244: 
            return ANSWER_LIKE;

        case 245: 
            return ANSWER_UNLIKE;

        case 246: 
            return ANSWER_REPORT;

        case 247: 
            return REPLY_CREATE;

        case 248: 
            return REPLY_DELETE;

        case 249: 
            return REPLY_REPORT;

        case 250: 
            return REPLY_EDIT;

        case 251: 
            return LINK_EXTRACT;

        case 252: 
            return REPLY_VIEW;

        case 253: 
            return QUESTION_ANSWERED;

        case 260: 
            return EXPLAIN_CREATE;

        case 261: 
            return EXPLAIN_VIEW;

        case 262: 
            return EXPLAIN_EDIT;

        case 263: 
            return EXPLAIN_DELETE;

        case 300: 
            return TOP_NOTIFICATION_CLICKED;

        case 310: 
            return SHIPPING_DETAIL_CREATE;

        case 311: 
            return SHIPPING_DETAIL_VIEW;

        case 314: 
            return SHIPPING_DETAIL_UPDATE;

        case 315: 
            return SHIPPING_DETAIL_DELETE;

        case 312: 
            return PAYMENT_METHOD_CREATE;

        case 313: 
            return PAYMENT_METHOD_VIEW;

        case 316: 
            return PAYMENT_METHOD_UPDATE;

        case 317: 
            return PAYMENT_METHOD_DELETE;

        case 318: 
            return CART_CREATE;

        case 319: 
            return CART_VIEW;

        case 320: 
            return CART_DELETE;

        case 321: 
            return CART_UPDATE;

        case 322: 
            return CART_UPDATE_ITEMS;

        case 323: 
            return CART_DELETE_ITEMS;

        case 324: 
            return CART_CALCULATE_PRICE;

        case 325: 
            return CART_PAY;

        case 326: 
            return CART_GET_PAYMENT_STATUS;

        case 361: 
            return PFY_PIN_THROUGH_PIN_HIDE;

        case 400: 
            return ANDROID_WIDGET_ENABLE;

        case 401: 
            return ANDROID_WIDGET_DISABLE;

        case 402: 
            return ANDROID_WIDGET_UPDATE;

        case 404: 
            return APP_TIMING;

        case 405: 
            return DEVICE_START;

        case 406: 
            return APP_START;

        case 422: 
            return APP_BACKGROUND;

        case 407: 
            return PULL_NOTIFICATION_RECEIVED_BY;

        case 408: 
            return PULL_NOTIFICATION_OPENED_BY;

        case 410: 
            return SEND_PIN_RECOMMENDATION;

        case 420: 
            return MOBILE_BADGE_RECEIEVED;

        case 421: 
            return MOBILE_BADGE_SHOWN;

        case 500: 
            return NOTIFICATION_SUBSCRIBE_SETTINGS_CHANGE;

        case 501: 
            return NOTIFICATION_UNSUBSCRIBE_SETTINGS_CHANGE;

        case 502: 
            return EMAIL_SUBSCRIBE_SETTINGS_CHANGE;

        case 503: 
            return EMAIL_UNSUBSCRIBE_SETTINGS_CHANGE;

        case 510: 
            return CLIENT_NOTIFICATION_RECEIVED_BY;

        case 511: 
            return CLIENT_NOTIFICATION_OPENED_BY;

        case 600: 
            return INTEREST_IMPRESSION_SERVER_SIDE;

        case 601: 
            return INTEREST_FOLLOW;

        case 602: 
            return INTEREST_UNFOLLOW;

        case 603: 
            return INTEREST_REMOVE;

        case 604: 
            return INTEREST_UNREMOVE;

        case 605: 
            return INTEREST_PIN_UPVOTE;

        case 606: 
            return INTEREST_PIN_DOWNVOTE;

        case 607: 
            return INTEREST_FEED_FRESHNESS;

        case 640: 
            return SEARCH_RESULT_IMPRESSION_ONE_PIXEL;

        case 670: 
            return VISUAL_OBJECT_IMPRESSION_SERVER_SIDE;

        case 671: 
            return VISUAL_RESULTS_IMPRESSION_SERVER_SIDE;

        case 672: 
            return EXP_SERVERSIDE_IMPRESSION_EVENT;

        case 700: 
            return DEEP_LINK_PINTEREST;

        case 701: 
            return DEEP_LINK_HTTP;

        case 702: 
            return DEEP_LINK_OTHER;

        case 703: 
            return DEEP_LINK_GOOGLE_APP_INDEXING;

        case 800: 
            return EMAIL_CLICKTHROUGH_DEPRECATED;

        case 801: 
            return SERVICE_ENTRY;

        case 900: 
            return BULK_PIN_DELETE;

        case 901: 
            return BULK_PIN_MOVE;

        case 902: 
            return BULK_PIN_REPIN;

        case 0: // '\0'
            return PAGEVIEW;

        case 100: // 'd'
            return API_PAGEVIEW;

        case 1000: 
            return WEB_OR_API_REQUEST;

        case 1001: 
            return ANDROID_REQUEST;

        case 1002: 
            return IPAD_REQUEST;

        case 1003: 
            return IPHONE_REQUEST;

        case 1004: 
            return IPOD_REQUEST;

        case 1005: 
            return MAC_REQUEST;

        case 1006: 
            return WINDOWS_REQUEST;

        case 1007: 
            return OTHER_REQUEST;

        case 1008: 
            return APP_INSTALL;

        case 1009: 
            return REFERRER_APP_INSTALL;

        case 1010: 
            return REFERRER_APP_INSTALL_ATTEMPT;

        case 1011: 
            return MINUTE_WITH_REQUEST;

        case 1100: 
            return GOT_PIN_VIEW;

        case 1101: 
            return GOT_PIN_COMMENT;

        case 1102: 
            return GOT_PIN_REPIN;

        case 1103: 
            return GOT_PIN_LIKE;

        case 1104: 
            return GOT_BOARD_FOLLOW;

        case 1105: 
            return GOT_BOARD_INVITE_COLLABORATOR;

        case 1106: 
            return GOT_USER_FOLLOW;

        case 1107: 
            return GOT_CLICKTHROUGH;

        case 1108: 
            return GOT_IMPRESSION;

        case 1200: 
            return PLACE_CREATE;

        case 1201: 
            return USER_INVITE_CREATE_DEPRECATED;

        case 1300: 
            return PIN_SHARE_FACEBOOK;

        case 1400: 
            return PIN_INSERT_TO_PUBLIC_FEED;

        case 1401: 
            return PIN_INSERT_TO_HOME_FEED;

        case 1402: 
            return PIN_INSERT_TO_INTEREST_FEED;

        case 1403: 
            return PIN_VIEW_ON_HOME_FEED;

        case 1500: 
            return NOTIFICATION;

        case 1600: 
            return PIN_LONG_CLICKTHROUGH;

        case 1601: 
            return PIN_SHORT_CLICKTHROUGH;

        case 1700: 
            return INTERSTITIAL_LOADED;

        case 1701: 
            return INTERSTITIAL_OPEN_IN_APP;

        case 1702: 
            return INTERSTITIAL_OPEN_IN_BROWSER;

        case 1750: 
            return HOME_PAGE_SIGNUP;

        case 1751: 
            return PLAIN_MODAL_SIGNUP;

        case 1752: 
            return CLOSEUP_MODAL_SIGNUP;

        case 1753: 
            return WIDESCREEN_MODAL_SIGNUP;

        case 1754: 
            return UNKNOWN_PLACEMENT_SIGNUP;

        case 1755: 
            return PIN_IT_BUTTON_LANDING_SIGNUP;

        case 1770: 
            return HOME_PAGE_SIGNUP_VIEW;

        case 1771: 
            return PLAIN_MODAL_SIGNUP_VIEW;

        case 1772: 
            return CLOSEUP_MODAL_SIGNUP_VIEW;

        case 1773: 
            return WIDESCREEN_MODAL_SIGNUP_VIEW;

        case 1775: 
            return PIN_IT_BUTTON_LANDING_SIGNUP_VIEW;

        case 1800: 
            return ADDRESS_BOOK_UPLOAD;

        case 1900: 
            return TRANSLATION_DETECTION;

        case 1901: 
            return TRANSLATION_TRIGGERED;

        case 2000: 
            return PIN_PROMOTION_CREATE;

        case 2001: 
            return PIN_PROMOTION_UPDATE;

        case 2002: 
            return CAMPAIGN_CREATE;

        case 2003: 
            return CAMPAIGN_UPDATE;

        case 2004: 
            return ADVERTISER_CREATE;

        case 2005: 
            return ADVERTISER_UPDATE;

        case 2006: 
            return CONVERSION_TAG_CREATE;

        case 2007: 
            return CONVERSION_TAG_UPDATE;

        case 2008: 
            return BILLING_FAILURE;

        case 2009: 
            return VIEW_TAG_PINGED;

        case 2010: 
            return BILLING_SUCCESS;

        case 2100: 
            return OWN_PROFILE_VIEW;

        case 2101: 
            return OWN_BOARD_VIEW;

        case 2102: 
            return OWN_PIN_VIEW;

        case 2103: 
            return OWN_PIN_CLICK;

        case 2200: 
            return SAFARI_KEYCHAIN_SUCCESSFUL_LOGIN;

        case 2300: 
            return POPULAR_PINS_EMAIL;

        case 2400: 
            return AUTOTUNE_REWARD;

        case 2401: 
            return AUTOTUNE_EMAIL_OPEN;

        case 2501: 
            return WEB_PIN_CREATE_ENTER_TO_SELECT_BOARD;

        case 2502: 
            return WEB_PIN_CREATE_CLOSE_MODAL_BEFORE_PINNING;

        case 2503: 
            return WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN;

        case 2504: 
            return WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_UP;

        case 2505: 
            return WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_DOWN;

        case 2506: 
            return WEB_PICKER_ENTER;

        case 2600: 
            return EMAIL_UNIQUE_BOUNCE;

        case 2601: 
            return EMAIL_UNIQUE_DELIVER;

        case 2602: 
            return EMAIL_UNIQUE_OPEN;

        case 2603: 
            return EMAIL_UNIQUE_CLICK;

        case 2604: 
            return EMAIL_UNIQUE_SPAMREPORT;

        case 2605: 
            return EMAIL_UNIQUE_UNSUBSCRIBE;

        case 2700: 
            return APP_CRASH;
        }
    }

    public static EventType valueOf(String s)
    {
        return (EventType)Enum.valueOf(com/pinterest/schemas/event/EventType, s);
    }

    public static EventType[] values()
    {
        return (EventType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        VIEW = new EventType("VIEW", 0, 13);
        PIN_CREATE = new EventType("PIN_CREATE", 1, 1);
        PIN_EDIT = new EventType("PIN_EDIT", 2, 2);
        PIN_DELETE = new EventType("PIN_DELETE", 3, 3);
        PIN_VIEW = new EventType("PIN_VIEW", 4, 4);
        PIN_REPIN = new EventType("PIN_REPIN", 5, 5);
        PIN_LIKE = new EventType("PIN_LIKE", 6, 6);
        PIN_COMMENT = new EventType("PIN_COMMENT", 7, 7);
        PIN_SHARE = new EventType("PIN_SHARE", 8, 8);
        PIN_UNLIKE = new EventType("PIN_UNLIKE", 9, 9);
        PIN_DELETE_COMMENT = new EventType("PIN_DELETE_COMMENT", 10, 10);
        PIN_FLAG = new EventType("PIN_FLAG", 11, 11);
        PIN_CLICKTHROUGH = new EventType("PIN_CLICKTHROUGH", 12, 12);
        PIN_SEND = new EventType("PIN_SEND", 13, 14);
        PIN_INSERTION = new EventType("PIN_INSERTION", 14, 15);
        PIN_CLOSEUP = new EventType("PIN_CLOSEUP", 15, 16);
        PIN_HIDE = new EventType("PIN_HIDE", 16, 17);
        PIN_IMPRESSION_ONE_PIXEL = new EventType("PIN_IMPRESSION_ONE_PIXEL", 17, 18);
        PIN_IMPRESSION_SERVER_SIDE = new EventType("PIN_IMPRESSION_SERVER_SIDE", 18, 19);
        BOARD_CREATE = new EventType("BOARD_CREATE", 19, 20);
        BOARD_EDIT = new EventType("BOARD_EDIT", 20, 21);
        BOARD_DELETE = new EventType("BOARD_DELETE", 21, 22);
        BOARD_VIEW = new EventType("BOARD_VIEW", 22, 23);
        BOARD_FOLLOW = new EventType("BOARD_FOLLOW", 23, 26);
        BOARD_UNFOLLOW = new EventType("BOARD_UNFOLLOW", 24, 27);
        BOARD_SET_PRIVATE = new EventType("BOARD_SET_PRIVATE", 25, 30);
        BOARD_SET_PUBLIC = new EventType("BOARD_SET_PUBLIC", 26, 31);
        BOARD_ADD_COLLABORATOR = new EventType("BOARD_ADD_COLLABORATOR", 27, 24);
        BOARD_REMOVE_COLLABORATOR = new EventType("BOARD_REMOVE_COLLABORATOR", 28, 25);
        BOARD_INVITE_COLLABORATOR = new EventType("BOARD_INVITE_COLLABORATOR", 29, 28);
        BOARD_DECLINE_INVITE_COLLABORATOR = new EventType("BOARD_DECLINE_INVITE_COLLABORATOR", 30, 29);
        BOARD_ACCEPT_INVITE_COLLABORATOR = new EventType("BOARD_ACCEPT_INVITE_COLLABORATOR", 31, 32);
        BOARD_REQUEST_INVITE_COLLABORATOR = new EventType("BOARD_REQUEST_INVITE_COLLABORATOR", 32, 33);
        BOARD_REQUEST_APPROVAL_INVITE_COLLABORATOR = new EventType("BOARD_REQUEST_APPROVAL_INVITE_COLLABORATOR", 33, 34);
        BOARD_SEND = new EventType("BOARD_SEND", 34, 35);
        BOARD_REORDER_PINS = new EventType("BOARD_REORDER_PINS", 35, 36);
        USER_LOGIN_SUCCESS = new EventType("USER_LOGIN_SUCCESS", 36, 38);
        USER_LOGIN_FAILED = new EventType("USER_LOGIN_FAILED", 37, 39);
        USER_CREATE = new EventType("USER_CREATE", 38, 40);
        USER_EDIT = new EventType("USER_EDIT", 39, 41);
        USER_DELETE = new EventType("USER_DELETE", 40, 42);
        USER_VIEW = new EventType("USER_VIEW", 41, 43);
        USER_REORDER_BOARDS = new EventType("USER_REORDER_BOARDS", 42, 44);
        USER_FOLLOW = new EventType("USER_FOLLOW", 43, 45);
        USER_UNFOLLOW = new EventType("USER_UNFOLLOW", 44, 46);
        USER_INVITE = new EventType("USER_INVITE", 45, 47);
        USER_DEACTIVATED = new EventType("USER_DEACTIVATED", 46, 48);
        USER_REACTIVATED = new EventType("USER_REACTIVATED", 47, 49);
        USER_LOGIN_ATTEMPT = new EventType("USER_LOGIN_ATTEMPT", 48, 50);
        USER_PASSWORD_RESET_REQUEST = new EventType("USER_PASSWORD_RESET_REQUEST", 49, 51);
        USER_PASSWORD_RESET_COMPLETED = new EventType("USER_PASSWORD_RESET_COMPLETED", 50, 52);
        USER_SUSPICIOUS_LOGIN = new EventType("USER_SUSPICIOUS_LOGIN", 51, 53);
        USER_BLOCK = new EventType("USER_BLOCK", 52, 54);
        USER_UNBLOCK = new EventType("USER_UNBLOCK", 53, 55);
        USER_REPORT = new EventType("USER_REPORT", 54, 56);
        USER_PARTNER_CREATE = new EventType("USER_PARTNER_CREATE", 55, 57);
        USER_PARTNER_CONVERT = new EventType("USER_PARTNER_CONVERT", 56, 58);
        PIN_REPORT = new EventType("PIN_REPORT", 57, 59);
        USER_PUBLISH_TO_SOCIAL_NETWORK = new EventType("USER_PUBLISH_TO_SOCIAL_NETWORK", 58, 75);
        PIN_COMMENT_FLAG = new EventType("PIN_COMMENT_FLAG", 59, 76);
        SEARCH_PINS = new EventType("SEARCH_PINS", 60, 60);
        SEARCH_BOARDS = new EventType("SEARCH_BOARDS", 61, 61);
        SEARCH_USERS = new EventType("SEARCH_USERS", 62, 62);
        SEARCH_MY_PINS = new EventType("SEARCH_MY_PINS", 63, 63);
        SEARCH_VIDEOS = new EventType("SEARCH_VIDEOS", 64, 64);
        SEARCH_RECIPES = new EventType("SEARCH_RECIPES", 65, 65);
        SEARCH_PLACE_BOARDS = new EventType("SEARCH_PLACE_BOARDS", 66, 66);
        SEARCH_INTERESTS = new EventType("SEARCH_INTERESTS", 67, 67);
        FEED_SUBCATEGORY = new EventType("FEED_SUBCATEGORY", 68, 69);
        EMAIL_RECEIVE = new EventType("EMAIL_RECEIVE", 69, 70);
        EMAIL_OPEN_DEPRECATED = new EventType("EMAIL_OPEN_DEPRECATED", 70, 71);
        EMAIL_OPEN_API_DEPRECATED = new EventType("EMAIL_OPEN_API_DEPRECATED", 71, 72);
        EMAIL_CLICK_DEPRECATED = new EventType("EMAIL_CLICK_DEPRECATED", 72, 73);
        EMAIL_CLICK_API_DEPRECATED = new EventType("EMAIL_CLICK_API_DEPRECATED", 73, 74);
        FEED_VIEW = new EventType("FEED_VIEW", 74, 80);
        REFRESH = new EventType("REFRESH", 75, 81);
        PIN_SAVE_TO_DEVICE = new EventType("PIN_SAVE_TO_DEVICE", 76, 82);
        BROWSER = new EventType("BROWSER", 77, 83);
        USER_ENABLE_ANALYTICS = new EventType("USER_ENABLE_ANALYTICS", 78, 84);
        USER_DISABLE_ANALYTICS = new EventType("USER_DISABLE_ANALYTICS", 79, 85);
        USER_ENABLE_FACEBOOK = new EventType("USER_ENABLE_FACEBOOK", 80, 86);
        USER_DISABLE_FACBOOK = new EventType("USER_DISABLE_FACBOOK", 81, 87);
        USER_ENABLE_FACEBOOK_TIMELINE = new EventType("USER_ENABLE_FACEBOOK_TIMELINE", 82, 88);
        USER_DISABLE_FACEBOOK_TIMELINE = new EventType("USER_DISABLE_FACEBOOK_TIMELINE", 83, 89);
        USER_ENABLE_TWITTER = new EventType("USER_ENABLE_TWITTER", 84, 90);
        USER_DISABLE_TWITTER = new EventType("USER_DISABLE_TWITTER", 85, 91);
        USER_ENABLE_GPLUS = new EventType("USER_ENABLE_GPLUS", 86, 92);
        USER_DISABLE_GPLUS = new EventType("USER_DISABLE_GPLUS", 87, 93);
        USER_ENABLE_RAKUTEN = new EventType("USER_ENABLE_RAKUTEN", 88, 94);
        USER_DISABLE_RAKUTEN = new EventType("USER_DISABLE_RAKUTEN", 89, 95);
        USER_DELETED_APP = new EventType("USER_DELETED_APP", 90, 96);
        CLICK = new EventType("CLICK", 91, 101);
        TAP = new EventType("TAP", 92, 102);
        LONG_PRESS = new EventType("LONG_PRESS", 93, 103);
        DRAG = new EventType("DRAG", 94, 104);
        HOVER = new EventType("HOVER", 95, 105);
        TOGGLE_ON = new EventType("TOGGLE_ON", 96, 106);
        TOGGLE_OFF = new EventType("TOGGLE_OFF", 97, 107);
        SWIPE = new EventType("SWIPE", 98, 108);
        PINCH = new EventType("PINCH", 99, 109);
        SCROLL = new EventType("SCROLL", 100, 110);
        PUSH_NOTIFICATION_SENT_TO = new EventType("PUSH_NOTIFICATION_SENT_TO", 101, 111);
        PUSH_NOTIFICATION_RECEIVED_BY = new EventType("PUSH_NOTIFICATION_RECEIVED_BY", 102, 112);
        PUSH_NOTIFICATION_OPENED_BY = new EventType("PUSH_NOTIFICATION_OPENED_BY", 103, 113);
        PUSH_NOTIFICATION_DEVICE_ASSOCIATED = new EventType("PUSH_NOTIFICATION_DEVICE_ASSOCIATED", 104, 114);
        PUSH_NOTIFICATION_DEVICE_DISASSOCIATED = new EventType("PUSH_NOTIFICATION_DEVICE_DISASSOCIATED", 105, 115);
        PUSH_NOTIFICATION_DEVICE_ENABLED = new EventType("PUSH_NOTIFICATION_DEVICE_ENABLED", 106, 116);
        PUSH_NOTIFICATION_DEVICE_DISABLED = new EventType("PUSH_NOTIFICATION_DEVICE_DISABLED", 107, 117);
        PUSH_NOTIFICATION_REGISTRATION_FAILED = new EventType("PUSH_NOTIFICATION_REGISTRATION_FAILED", 108, 121);
        CONTEXTUAL_MENU_OPEN = new EventType("CONTEXTUAL_MENU_OPEN", 109, 118);
        CONTEXTUAL_MENU_CLOSE = new EventType("CONTEXTUAL_MENU_CLOSE", 110, 119);
        RENDER = new EventType("RENDER", 111, 120);
        PIN_UPVOTE = new EventType("PIN_UPVOTE", 112, 130);
        PROMOTED_PIN_FLAG = new EventType("PROMOTED_PIN_FLAG", 113, 131);
        PROMOTED_PIN_HIDE = new EventType("PROMOTED_PIN_HIDE", 114, 132);
        PIN_DEACTIVATE = new EventType("PIN_DEACTIVATE", 115, 133);
        PIN_REACTIVATE = new EventType("PIN_REACTIVATE", 116, 134);
        PIN_FEEDBACK = new EventType("PIN_FEEDBACK", 117, 135);
        PFY_PIN_THROUGH_BOARD_HIDE = new EventType("PFY_PIN_THROUGH_BOARD_HIDE", 118, 136);
        PIN_SCREENSHOT = new EventType("PIN_SCREENSHOT", 119, 137);
        PIN_REPIN_OR_CLICKTHROUGH = new EventType("PIN_REPIN_OR_CLICKTHROUGH", 120, 138);
        APP_PIN_INSTALLATION_CONFIRMATION = new EventType("APP_PIN_INSTALLATION_CONFIRMATION", 121, 139);
        USER_SEND = new EventType("USER_SEND", 122, 150);
        USER_INVITE_CREATE = new EventType("USER_INVITE_CREATE", 123, 151);
        USER_INVITE_FACEBOOK_CREATE = new EventType("USER_INVITE_FACEBOOK_CREATE", 124, 152);
        USER_INVITE_FACEBOOK_SENT = new EventType("USER_INVITE_FACEBOOK_SENT", 125, 153);
        USER_INVITE_EMAIL_SENT = new EventType("USER_INVITE_EMAIL_SENT", 126, 154);
        USER_GENDER_CHANGED = new EventType("USER_GENDER_CHANGED", 127, 155);
        USER_SEARCH_PRIVACY_CHANGED = new EventType("USER_SEARCH_PRIVACY_CHANGED", 128, 156);
        USER_PERSONALIZED_RECOMMENDATIONS_CHANGED = new EventType("USER_PERSONALIZED_RECOMMENDATIONS_CHANGED", 129, 157);
        PULL_TO_REFRESH = new EventType("PULL_TO_REFRESH", 130, 158);
        USER_INVITE_SMS_SENT = new EventType("USER_INVITE_SMS_SENT", 131, 159);
        USER_INVITE_FB_MESSENGER_SENT = new EventType("USER_INVITE_FB_MESSENGER_SENT", 132, 160);
        USER_INVITE_WHATSAPP_SENT = new EventType("USER_INVITE_WHATSAPP_SENT", 133, 161);
        USER_INVITE_LINE_SENT = new EventType("USER_INVITE_LINE_SENT", 134, 162);
        CONVERSATION_MESSAGE_SEND = new EventType("CONVERSATION_MESSAGE_SEND", 135, 180);
        CONVERSATION_CREATE = new EventType("CONVERSATION_CREATE", 136, 181);
        CONVERSATION_HIDE = new EventType("CONVERSATION_HIDE", 137, 182);
        CONVERSATION_REPORT = new EventType("CONVERSATION_REPORT", 138, 183);
        CONVERSATION_UPGRADE_EXTERNAL_USER = new EventType("CONVERSATION_UPGRADE_EXTERNAL_USER", 139, 184);
        DOMAIN_VERIFIED = new EventType("DOMAIN_VERIFIED", 140, 200);
        URL_CHECK = new EventType("URL_CHECK", 141, 201);
        URL_IMAGE = new EventType("URL_IMAGE", 142, 202);
        URL_CLICKTHROUGH = new EventType("URL_CLICKTHROUGH", 143, 203);
        QUESTION_CREATE = new EventType("QUESTION_CREATE", 144, 220);
        QUESTION_VIEW = new EventType("QUESTION_VIEW", 145, 221);
        QUESTION_EDIT = new EventType("QUESTION_EDIT", 146, 222);
        QUESTION_DELETE = new EventType("QUESTION_DELETE", 147, 223);
        QUESTION_LIKE = new EventType("QUESTION_LIKE", 148, 224);
        QUESTION_UNLIKE = new EventType("QUESTION_UNLIKE", 149, 225);
        QUESTION_REPORT = new EventType("QUESTION_REPORT", 150, 226);
        ANSWER_CREATE = new EventType("ANSWER_CREATE", 151, 240);
        ANSWER_VIEW = new EventType("ANSWER_VIEW", 152, 241);
        ANSWER_EDIT = new EventType("ANSWER_EDIT", 153, 242);
        ANSWER_DELETE = new EventType("ANSWER_DELETE", 154, 243);
        ANSWER_LIKE = new EventType("ANSWER_LIKE", 155, 244);
        ANSWER_UNLIKE = new EventType("ANSWER_UNLIKE", 156, 245);
        ANSWER_REPORT = new EventType("ANSWER_REPORT", 157, 246);
        REPLY_CREATE = new EventType("REPLY_CREATE", 158, 247);
        REPLY_DELETE = new EventType("REPLY_DELETE", 159, 248);
        REPLY_REPORT = new EventType("REPLY_REPORT", 160, 249);
        REPLY_EDIT = new EventType("REPLY_EDIT", 161, 250);
        LINK_EXTRACT = new EventType("LINK_EXTRACT", 162, 251);
        REPLY_VIEW = new EventType("REPLY_VIEW", 163, 252);
        QUESTION_ANSWERED = new EventType("QUESTION_ANSWERED", 164, 253);
        EXPLAIN_CREATE = new EventType("EXPLAIN_CREATE", 165, 260);
        EXPLAIN_VIEW = new EventType("EXPLAIN_VIEW", 166, 261);
        EXPLAIN_EDIT = new EventType("EXPLAIN_EDIT", 167, 262);
        EXPLAIN_DELETE = new EventType("EXPLAIN_DELETE", 168, 263);
        TOP_NOTIFICATION_CLICKED = new EventType("TOP_NOTIFICATION_CLICKED", 169, 300);
        SHIPPING_DETAIL_CREATE = new EventType("SHIPPING_DETAIL_CREATE", 170, 310);
        SHIPPING_DETAIL_VIEW = new EventType("SHIPPING_DETAIL_VIEW", 171, 311);
        SHIPPING_DETAIL_UPDATE = new EventType("SHIPPING_DETAIL_UPDATE", 172, 314);
        SHIPPING_DETAIL_DELETE = new EventType("SHIPPING_DETAIL_DELETE", 173, 315);
        PAYMENT_METHOD_CREATE = new EventType("PAYMENT_METHOD_CREATE", 174, 312);
        PAYMENT_METHOD_VIEW = new EventType("PAYMENT_METHOD_VIEW", 175, 313);
        PAYMENT_METHOD_UPDATE = new EventType("PAYMENT_METHOD_UPDATE", 176, 316);
        PAYMENT_METHOD_DELETE = new EventType("PAYMENT_METHOD_DELETE", 177, 317);
        CART_CREATE = new EventType("CART_CREATE", 178, 318);
        CART_VIEW = new EventType("CART_VIEW", 179, 319);
        CART_DELETE = new EventType("CART_DELETE", 180, 320);
        CART_UPDATE = new EventType("CART_UPDATE", 181, 321);
        CART_UPDATE_ITEMS = new EventType("CART_UPDATE_ITEMS", 182, 322);
        CART_DELETE_ITEMS = new EventType("CART_DELETE_ITEMS", 183, 323);
        CART_CALCULATE_PRICE = new EventType("CART_CALCULATE_PRICE", 184, 324);
        CART_PAY = new EventType("CART_PAY", 185, 325);
        CART_GET_PAYMENT_STATUS = new EventType("CART_GET_PAYMENT_STATUS", 186, 326);
        PFY_PIN_THROUGH_PIN_HIDE = new EventType("PFY_PIN_THROUGH_PIN_HIDE", 187, 361);
        ANDROID_WIDGET_ENABLE = new EventType("ANDROID_WIDGET_ENABLE", 188, 400);
        ANDROID_WIDGET_DISABLE = new EventType("ANDROID_WIDGET_DISABLE", 189, 401);
        ANDROID_WIDGET_UPDATE = new EventType("ANDROID_WIDGET_UPDATE", 190, 402);
        APP_TIMING = new EventType("APP_TIMING", 191, 404);
        DEVICE_START = new EventType("DEVICE_START", 192, 405);
        APP_START = new EventType("APP_START", 193, 406);
        APP_BACKGROUND = new EventType("APP_BACKGROUND", 194, 422);
        PULL_NOTIFICATION_RECEIVED_BY = new EventType("PULL_NOTIFICATION_RECEIVED_BY", 195, 407);
        PULL_NOTIFICATION_OPENED_BY = new EventType("PULL_NOTIFICATION_OPENED_BY", 196, 408);
        SEND_PIN_RECOMMENDATION = new EventType("SEND_PIN_RECOMMENDATION", 197, 410);
        MOBILE_BADGE_RECEIEVED = new EventType("MOBILE_BADGE_RECEIEVED", 198, 420);
        MOBILE_BADGE_SHOWN = new EventType("MOBILE_BADGE_SHOWN", 199, 421);
        NOTIFICATION_SUBSCRIBE_SETTINGS_CHANGE = new EventType("NOTIFICATION_SUBSCRIBE_SETTINGS_CHANGE", 200, 500);
        NOTIFICATION_UNSUBSCRIBE_SETTINGS_CHANGE = new EventType("NOTIFICATION_UNSUBSCRIBE_SETTINGS_CHANGE", 201, 501);
        EMAIL_SUBSCRIBE_SETTINGS_CHANGE = new EventType("EMAIL_SUBSCRIBE_SETTINGS_CHANGE", 202, 502);
        EMAIL_UNSUBSCRIBE_SETTINGS_CHANGE = new EventType("EMAIL_UNSUBSCRIBE_SETTINGS_CHANGE", 203, 503);
        CLIENT_NOTIFICATION_RECEIVED_BY = new EventType("CLIENT_NOTIFICATION_RECEIVED_BY", 204, 510);
        CLIENT_NOTIFICATION_OPENED_BY = new EventType("CLIENT_NOTIFICATION_OPENED_BY", 205, 511);
        INTEREST_IMPRESSION_SERVER_SIDE = new EventType("INTEREST_IMPRESSION_SERVER_SIDE", 206, 600);
        INTEREST_FOLLOW = new EventType("INTEREST_FOLLOW", 207, 601);
        INTEREST_UNFOLLOW = new EventType("INTEREST_UNFOLLOW", 208, 602);
        INTEREST_REMOVE = new EventType("INTEREST_REMOVE", 209, 603);
        INTEREST_UNREMOVE = new EventType("INTEREST_UNREMOVE", 210, 604);
        INTEREST_PIN_UPVOTE = new EventType("INTEREST_PIN_UPVOTE", 211, 605);
        INTEREST_PIN_DOWNVOTE = new EventType("INTEREST_PIN_DOWNVOTE", 212, 606);
        INTEREST_FEED_FRESHNESS = new EventType("INTEREST_FEED_FRESHNESS", 213, 607);
        SEARCH_RESULT_IMPRESSION_ONE_PIXEL = new EventType("SEARCH_RESULT_IMPRESSION_ONE_PIXEL", 214, 640);
        VISUAL_OBJECT_IMPRESSION_SERVER_SIDE = new EventType("VISUAL_OBJECT_IMPRESSION_SERVER_SIDE", 215, 670);
        VISUAL_RESULTS_IMPRESSION_SERVER_SIDE = new EventType("VISUAL_RESULTS_IMPRESSION_SERVER_SIDE", 216, 671);
        EXP_SERVERSIDE_IMPRESSION_EVENT = new EventType("EXP_SERVERSIDE_IMPRESSION_EVENT", 217, 672);
        DEEP_LINK_PINTEREST = new EventType("DEEP_LINK_PINTEREST", 218, 700);
        DEEP_LINK_HTTP = new EventType("DEEP_LINK_HTTP", 219, 701);
        DEEP_LINK_OTHER = new EventType("DEEP_LINK_OTHER", 220, 702);
        DEEP_LINK_GOOGLE_APP_INDEXING = new EventType("DEEP_LINK_GOOGLE_APP_INDEXING", 221, 703);
        EMAIL_CLICKTHROUGH_DEPRECATED = new EventType("EMAIL_CLICKTHROUGH_DEPRECATED", 222, 800);
        SERVICE_ENTRY = new EventType("SERVICE_ENTRY", 223, 801);
        BULK_PIN_DELETE = new EventType("BULK_PIN_DELETE", 224, 900);
        BULK_PIN_MOVE = new EventType("BULK_PIN_MOVE", 225, 901);
        BULK_PIN_REPIN = new EventType("BULK_PIN_REPIN", 226, 902);
        PAGEVIEW = new EventType("PAGEVIEW", 227, 0);
        API_PAGEVIEW = new EventType("API_PAGEVIEW", 228, 100);
        WEB_OR_API_REQUEST = new EventType("WEB_OR_API_REQUEST", 229, 1000);
        ANDROID_REQUEST = new EventType("ANDROID_REQUEST", 230, 1001);
        IPAD_REQUEST = new EventType("IPAD_REQUEST", 231, 1002);
        IPHONE_REQUEST = new EventType("IPHONE_REQUEST", 232, 1003);
        IPOD_REQUEST = new EventType("IPOD_REQUEST", 233, 1004);
        MAC_REQUEST = new EventType("MAC_REQUEST", 234, 1005);
        WINDOWS_REQUEST = new EventType("WINDOWS_REQUEST", 235, 1006);
        OTHER_REQUEST = new EventType("OTHER_REQUEST", 236, 1007);
        APP_INSTALL = new EventType("APP_INSTALL", 237, 1008);
        REFERRER_APP_INSTALL = new EventType("REFERRER_APP_INSTALL", 238, 1009);
        REFERRER_APP_INSTALL_ATTEMPT = new EventType("REFERRER_APP_INSTALL_ATTEMPT", 239, 1010);
        MINUTE_WITH_REQUEST = new EventType("MINUTE_WITH_REQUEST", 240, 1011);
        GOT_PIN_VIEW = new EventType("GOT_PIN_VIEW", 241, 1100);
        GOT_PIN_COMMENT = new EventType("GOT_PIN_COMMENT", 242, 1101);
        GOT_PIN_REPIN = new EventType("GOT_PIN_REPIN", 243, 1102);
        GOT_PIN_LIKE = new EventType("GOT_PIN_LIKE", 244, 1103);
        GOT_BOARD_FOLLOW = new EventType("GOT_BOARD_FOLLOW", 245, 1104);
        GOT_BOARD_INVITE_COLLABORATOR = new EventType("GOT_BOARD_INVITE_COLLABORATOR", 246, 1105);
        GOT_USER_FOLLOW = new EventType("GOT_USER_FOLLOW", 247, 1106);
        GOT_CLICKTHROUGH = new EventType("GOT_CLICKTHROUGH", 248, 1107);
        GOT_IMPRESSION = new EventType("GOT_IMPRESSION", 249, 1108);
        PLACE_CREATE = new EventType("PLACE_CREATE", 250, 1200);
        USER_INVITE_CREATE_DEPRECATED = new EventType("USER_INVITE_CREATE_DEPRECATED", 251, 1201);
        PIN_SHARE_FACEBOOK = new EventType("PIN_SHARE_FACEBOOK", 252, 1300);
        PIN_INSERT_TO_PUBLIC_FEED = new EventType("PIN_INSERT_TO_PUBLIC_FEED", 253, 1400);
        PIN_INSERT_TO_HOME_FEED = new EventType("PIN_INSERT_TO_HOME_FEED", 254, 1401);
        PIN_INSERT_TO_INTEREST_FEED = new EventType("PIN_INSERT_TO_INTEREST_FEED", 255, 1402);
        PIN_VIEW_ON_HOME_FEED = new EventType("PIN_VIEW_ON_HOME_FEED", 256, 1403);
        NOTIFICATION = new EventType("NOTIFICATION", 257, 1500);
        PIN_LONG_CLICKTHROUGH = new EventType("PIN_LONG_CLICKTHROUGH", 258, 1600);
        PIN_SHORT_CLICKTHROUGH = new EventType("PIN_SHORT_CLICKTHROUGH", 259, 1601);
        INTERSTITIAL_LOADED = new EventType("INTERSTITIAL_LOADED", 260, 1700);
        INTERSTITIAL_OPEN_IN_APP = new EventType("INTERSTITIAL_OPEN_IN_APP", 261, 1701);
        INTERSTITIAL_OPEN_IN_BROWSER = new EventType("INTERSTITIAL_OPEN_IN_BROWSER", 262, 1702);
        HOME_PAGE_SIGNUP = new EventType("HOME_PAGE_SIGNUP", 263, 1750);
        PLAIN_MODAL_SIGNUP = new EventType("PLAIN_MODAL_SIGNUP", 264, 1751);
        CLOSEUP_MODAL_SIGNUP = new EventType("CLOSEUP_MODAL_SIGNUP", 265, 1752);
        WIDESCREEN_MODAL_SIGNUP = new EventType("WIDESCREEN_MODAL_SIGNUP", 266, 1753);
        UNKNOWN_PLACEMENT_SIGNUP = new EventType("UNKNOWN_PLACEMENT_SIGNUP", 267, 1754);
        PIN_IT_BUTTON_LANDING_SIGNUP = new EventType("PIN_IT_BUTTON_LANDING_SIGNUP", 268, 1755);
        HOME_PAGE_SIGNUP_VIEW = new EventType("HOME_PAGE_SIGNUP_VIEW", 269, 1770);
        PLAIN_MODAL_SIGNUP_VIEW = new EventType("PLAIN_MODAL_SIGNUP_VIEW", 270, 1771);
        CLOSEUP_MODAL_SIGNUP_VIEW = new EventType("CLOSEUP_MODAL_SIGNUP_VIEW", 271, 1772);
        WIDESCREEN_MODAL_SIGNUP_VIEW = new EventType("WIDESCREEN_MODAL_SIGNUP_VIEW", 272, 1773);
        PIN_IT_BUTTON_LANDING_SIGNUP_VIEW = new EventType("PIN_IT_BUTTON_LANDING_SIGNUP_VIEW", 273, 1775);
        ADDRESS_BOOK_UPLOAD = new EventType("ADDRESS_BOOK_UPLOAD", 274, 1800);
        TRANSLATION_DETECTION = new EventType("TRANSLATION_DETECTION", 275, 1900);
        TRANSLATION_TRIGGERED = new EventType("TRANSLATION_TRIGGERED", 276, 1901);
        PIN_PROMOTION_CREATE = new EventType("PIN_PROMOTION_CREATE", 277, 2000);
        PIN_PROMOTION_UPDATE = new EventType("PIN_PROMOTION_UPDATE", 278, 2001);
        CAMPAIGN_CREATE = new EventType("CAMPAIGN_CREATE", 279, 2002);
        CAMPAIGN_UPDATE = new EventType("CAMPAIGN_UPDATE", 280, 2003);
        ADVERTISER_CREATE = new EventType("ADVERTISER_CREATE", 281, 2004);
        ADVERTISER_UPDATE = new EventType("ADVERTISER_UPDATE", 282, 2005);
        CONVERSION_TAG_CREATE = new EventType("CONVERSION_TAG_CREATE", 283, 2006);
        CONVERSION_TAG_UPDATE = new EventType("CONVERSION_TAG_UPDATE", 284, 2007);
        BILLING_FAILURE = new EventType("BILLING_FAILURE", 285, 2008);
        VIEW_TAG_PINGED = new EventType("VIEW_TAG_PINGED", 286, 2009);
        BILLING_SUCCESS = new EventType("BILLING_SUCCESS", 287, 2010);
        OWN_PROFILE_VIEW = new EventType("OWN_PROFILE_VIEW", 288, 2100);
        OWN_BOARD_VIEW = new EventType("OWN_BOARD_VIEW", 289, 2101);
        OWN_PIN_VIEW = new EventType("OWN_PIN_VIEW", 290, 2102);
        OWN_PIN_CLICK = new EventType("OWN_PIN_CLICK", 291, 2103);
        SAFARI_KEYCHAIN_SUCCESSFUL_LOGIN = new EventType("SAFARI_KEYCHAIN_SUCCESSFUL_LOGIN", 292, 2200);
        POPULAR_PINS_EMAIL = new EventType("POPULAR_PINS_EMAIL", 293, 2300);
        AUTOTUNE_REWARD = new EventType("AUTOTUNE_REWARD", 294, 2400);
        AUTOTUNE_EMAIL_OPEN = new EventType("AUTOTUNE_EMAIL_OPEN", 295, 2401);
        WEB_PIN_CREATE_ENTER_TO_SELECT_BOARD = new EventType("WEB_PIN_CREATE_ENTER_TO_SELECT_BOARD", 296, 2501);
        WEB_PIN_CREATE_CLOSE_MODAL_BEFORE_PINNING = new EventType("WEB_PIN_CREATE_CLOSE_MODAL_BEFORE_PINNING", 297, 2502);
        WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN = new EventType("WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN", 298, 2503);
        WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_UP = new EventType("WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_UP", 299, 2504);
        WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_DOWN = new EventType("WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_DOWN", 300, 2505);
        WEB_PICKER_ENTER = new EventType("WEB_PICKER_ENTER", 301, 2506);
        EMAIL_UNIQUE_BOUNCE = new EventType("EMAIL_UNIQUE_BOUNCE", 302, 2600);
        EMAIL_UNIQUE_DELIVER = new EventType("EMAIL_UNIQUE_DELIVER", 303, 2601);
        EMAIL_UNIQUE_OPEN = new EventType("EMAIL_UNIQUE_OPEN", 304, 2602);
        EMAIL_UNIQUE_CLICK = new EventType("EMAIL_UNIQUE_CLICK", 305, 2603);
        EMAIL_UNIQUE_SPAMREPORT = new EventType("EMAIL_UNIQUE_SPAMREPORT", 306, 2604);
        EMAIL_UNIQUE_UNSUBSCRIBE = new EventType("EMAIL_UNIQUE_UNSUBSCRIBE", 307, 2605);
        APP_CRASH = new EventType("APP_CRASH", 308, 2700);
        $VALUES = (new EventType[] {
            VIEW, PIN_CREATE, PIN_EDIT, PIN_DELETE, PIN_VIEW, PIN_REPIN, PIN_LIKE, PIN_COMMENT, PIN_SHARE, PIN_UNLIKE, 
            PIN_DELETE_COMMENT, PIN_FLAG, PIN_CLICKTHROUGH, PIN_SEND, PIN_INSERTION, PIN_CLOSEUP, PIN_HIDE, PIN_IMPRESSION_ONE_PIXEL, PIN_IMPRESSION_SERVER_SIDE, BOARD_CREATE, 
            BOARD_EDIT, BOARD_DELETE, BOARD_VIEW, BOARD_FOLLOW, BOARD_UNFOLLOW, BOARD_SET_PRIVATE, BOARD_SET_PUBLIC, BOARD_ADD_COLLABORATOR, BOARD_REMOVE_COLLABORATOR, BOARD_INVITE_COLLABORATOR, 
            BOARD_DECLINE_INVITE_COLLABORATOR, BOARD_ACCEPT_INVITE_COLLABORATOR, BOARD_REQUEST_INVITE_COLLABORATOR, BOARD_REQUEST_APPROVAL_INVITE_COLLABORATOR, BOARD_SEND, BOARD_REORDER_PINS, USER_LOGIN_SUCCESS, USER_LOGIN_FAILED, USER_CREATE, USER_EDIT, 
            USER_DELETE, USER_VIEW, USER_REORDER_BOARDS, USER_FOLLOW, USER_UNFOLLOW, USER_INVITE, USER_DEACTIVATED, USER_REACTIVATED, USER_LOGIN_ATTEMPT, USER_PASSWORD_RESET_REQUEST, 
            USER_PASSWORD_RESET_COMPLETED, USER_SUSPICIOUS_LOGIN, USER_BLOCK, USER_UNBLOCK, USER_REPORT, USER_PARTNER_CREATE, USER_PARTNER_CONVERT, PIN_REPORT, USER_PUBLISH_TO_SOCIAL_NETWORK, PIN_COMMENT_FLAG, 
            SEARCH_PINS, SEARCH_BOARDS, SEARCH_USERS, SEARCH_MY_PINS, SEARCH_VIDEOS, SEARCH_RECIPES, SEARCH_PLACE_BOARDS, SEARCH_INTERESTS, FEED_SUBCATEGORY, EMAIL_RECEIVE, 
            EMAIL_OPEN_DEPRECATED, EMAIL_OPEN_API_DEPRECATED, EMAIL_CLICK_DEPRECATED, EMAIL_CLICK_API_DEPRECATED, FEED_VIEW, REFRESH, PIN_SAVE_TO_DEVICE, BROWSER, USER_ENABLE_ANALYTICS, USER_DISABLE_ANALYTICS, 
            USER_ENABLE_FACEBOOK, USER_DISABLE_FACBOOK, USER_ENABLE_FACEBOOK_TIMELINE, USER_DISABLE_FACEBOOK_TIMELINE, USER_ENABLE_TWITTER, USER_DISABLE_TWITTER, USER_ENABLE_GPLUS, USER_DISABLE_GPLUS, USER_ENABLE_RAKUTEN, USER_DISABLE_RAKUTEN, 
            USER_DELETED_APP, CLICK, TAP, LONG_PRESS, DRAG, HOVER, TOGGLE_ON, TOGGLE_OFF, SWIPE, PINCH, 
            SCROLL, PUSH_NOTIFICATION_SENT_TO, PUSH_NOTIFICATION_RECEIVED_BY, PUSH_NOTIFICATION_OPENED_BY, PUSH_NOTIFICATION_DEVICE_ASSOCIATED, PUSH_NOTIFICATION_DEVICE_DISASSOCIATED, PUSH_NOTIFICATION_DEVICE_ENABLED, PUSH_NOTIFICATION_DEVICE_DISABLED, PUSH_NOTIFICATION_REGISTRATION_FAILED, CONTEXTUAL_MENU_OPEN, 
            CONTEXTUAL_MENU_CLOSE, RENDER, PIN_UPVOTE, PROMOTED_PIN_FLAG, PROMOTED_PIN_HIDE, PIN_DEACTIVATE, PIN_REACTIVATE, PIN_FEEDBACK, PFY_PIN_THROUGH_BOARD_HIDE, PIN_SCREENSHOT, 
            PIN_REPIN_OR_CLICKTHROUGH, APP_PIN_INSTALLATION_CONFIRMATION, USER_SEND, USER_INVITE_CREATE, USER_INVITE_FACEBOOK_CREATE, USER_INVITE_FACEBOOK_SENT, USER_INVITE_EMAIL_SENT, USER_GENDER_CHANGED, USER_SEARCH_PRIVACY_CHANGED, USER_PERSONALIZED_RECOMMENDATIONS_CHANGED, 
            PULL_TO_REFRESH, USER_INVITE_SMS_SENT, USER_INVITE_FB_MESSENGER_SENT, USER_INVITE_WHATSAPP_SENT, USER_INVITE_LINE_SENT, CONVERSATION_MESSAGE_SEND, CONVERSATION_CREATE, CONVERSATION_HIDE, CONVERSATION_REPORT, CONVERSATION_UPGRADE_EXTERNAL_USER, 
            DOMAIN_VERIFIED, URL_CHECK, URL_IMAGE, URL_CLICKTHROUGH, QUESTION_CREATE, QUESTION_VIEW, QUESTION_EDIT, QUESTION_DELETE, QUESTION_LIKE, QUESTION_UNLIKE, 
            QUESTION_REPORT, ANSWER_CREATE, ANSWER_VIEW, ANSWER_EDIT, ANSWER_DELETE, ANSWER_LIKE, ANSWER_UNLIKE, ANSWER_REPORT, REPLY_CREATE, REPLY_DELETE, 
            REPLY_REPORT, REPLY_EDIT, LINK_EXTRACT, REPLY_VIEW, QUESTION_ANSWERED, EXPLAIN_CREATE, EXPLAIN_VIEW, EXPLAIN_EDIT, EXPLAIN_DELETE, TOP_NOTIFICATION_CLICKED, 
            SHIPPING_DETAIL_CREATE, SHIPPING_DETAIL_VIEW, SHIPPING_DETAIL_UPDATE, SHIPPING_DETAIL_DELETE, PAYMENT_METHOD_CREATE, PAYMENT_METHOD_VIEW, PAYMENT_METHOD_UPDATE, PAYMENT_METHOD_DELETE, CART_CREATE, CART_VIEW, 
            CART_DELETE, CART_UPDATE, CART_UPDATE_ITEMS, CART_DELETE_ITEMS, CART_CALCULATE_PRICE, CART_PAY, CART_GET_PAYMENT_STATUS, PFY_PIN_THROUGH_PIN_HIDE, ANDROID_WIDGET_ENABLE, ANDROID_WIDGET_DISABLE, 
            ANDROID_WIDGET_UPDATE, APP_TIMING, DEVICE_START, APP_START, APP_BACKGROUND, PULL_NOTIFICATION_RECEIVED_BY, PULL_NOTIFICATION_OPENED_BY, SEND_PIN_RECOMMENDATION, MOBILE_BADGE_RECEIEVED, MOBILE_BADGE_SHOWN, 
            NOTIFICATION_SUBSCRIBE_SETTINGS_CHANGE, NOTIFICATION_UNSUBSCRIBE_SETTINGS_CHANGE, EMAIL_SUBSCRIBE_SETTINGS_CHANGE, EMAIL_UNSUBSCRIBE_SETTINGS_CHANGE, CLIENT_NOTIFICATION_RECEIVED_BY, CLIENT_NOTIFICATION_OPENED_BY, INTEREST_IMPRESSION_SERVER_SIDE, INTEREST_FOLLOW, INTEREST_UNFOLLOW, INTEREST_REMOVE, 
            INTEREST_UNREMOVE, INTEREST_PIN_UPVOTE, INTEREST_PIN_DOWNVOTE, INTEREST_FEED_FRESHNESS, SEARCH_RESULT_IMPRESSION_ONE_PIXEL, VISUAL_OBJECT_IMPRESSION_SERVER_SIDE, VISUAL_RESULTS_IMPRESSION_SERVER_SIDE, EXP_SERVERSIDE_IMPRESSION_EVENT, DEEP_LINK_PINTEREST, DEEP_LINK_HTTP, 
            DEEP_LINK_OTHER, DEEP_LINK_GOOGLE_APP_INDEXING, EMAIL_CLICKTHROUGH_DEPRECATED, SERVICE_ENTRY, BULK_PIN_DELETE, BULK_PIN_MOVE, BULK_PIN_REPIN, PAGEVIEW, API_PAGEVIEW, WEB_OR_API_REQUEST, 
            ANDROID_REQUEST, IPAD_REQUEST, IPHONE_REQUEST, IPOD_REQUEST, MAC_REQUEST, WINDOWS_REQUEST, OTHER_REQUEST, APP_INSTALL, REFERRER_APP_INSTALL, REFERRER_APP_INSTALL_ATTEMPT, 
            MINUTE_WITH_REQUEST, GOT_PIN_VIEW, GOT_PIN_COMMENT, GOT_PIN_REPIN, GOT_PIN_LIKE, GOT_BOARD_FOLLOW, GOT_BOARD_INVITE_COLLABORATOR, GOT_USER_FOLLOW, GOT_CLICKTHROUGH, GOT_IMPRESSION, 
            PLACE_CREATE, USER_INVITE_CREATE_DEPRECATED, PIN_SHARE_FACEBOOK, PIN_INSERT_TO_PUBLIC_FEED, PIN_INSERT_TO_HOME_FEED, PIN_INSERT_TO_INTEREST_FEED, PIN_VIEW_ON_HOME_FEED, NOTIFICATION, PIN_LONG_CLICKTHROUGH, PIN_SHORT_CLICKTHROUGH, 
            INTERSTITIAL_LOADED, INTERSTITIAL_OPEN_IN_APP, INTERSTITIAL_OPEN_IN_BROWSER, HOME_PAGE_SIGNUP, PLAIN_MODAL_SIGNUP, CLOSEUP_MODAL_SIGNUP, WIDESCREEN_MODAL_SIGNUP, UNKNOWN_PLACEMENT_SIGNUP, PIN_IT_BUTTON_LANDING_SIGNUP, HOME_PAGE_SIGNUP_VIEW, 
            PLAIN_MODAL_SIGNUP_VIEW, CLOSEUP_MODAL_SIGNUP_VIEW, WIDESCREEN_MODAL_SIGNUP_VIEW, PIN_IT_BUTTON_LANDING_SIGNUP_VIEW, ADDRESS_BOOK_UPLOAD, TRANSLATION_DETECTION, TRANSLATION_TRIGGERED, PIN_PROMOTION_CREATE, PIN_PROMOTION_UPDATE, CAMPAIGN_CREATE, 
            CAMPAIGN_UPDATE, ADVERTISER_CREATE, ADVERTISER_UPDATE, CONVERSION_TAG_CREATE, CONVERSION_TAG_UPDATE, BILLING_FAILURE, VIEW_TAG_PINGED, BILLING_SUCCESS, OWN_PROFILE_VIEW, OWN_BOARD_VIEW, 
            OWN_PIN_VIEW, OWN_PIN_CLICK, SAFARI_KEYCHAIN_SUCCESSFUL_LOGIN, POPULAR_PINS_EMAIL, AUTOTUNE_REWARD, AUTOTUNE_EMAIL_OPEN, WEB_PIN_CREATE_ENTER_TO_SELECT_BOARD, WEB_PIN_CREATE_CLOSE_MODAL_BEFORE_PINNING, WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN, WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_UP, 
            WEB_PIN_CREATE_BOARD_FILTER_KEYDOWN_ARROW_DOWN, WEB_PICKER_ENTER, EMAIL_UNIQUE_BOUNCE, EMAIL_UNIQUE_DELIVER, EMAIL_UNIQUE_OPEN, EMAIL_UNIQUE_CLICK, EMAIL_UNIQUE_SPAMREPORT, EMAIL_UNIQUE_UNSUBSCRIBE, APP_CRASH
        });
    }
}
