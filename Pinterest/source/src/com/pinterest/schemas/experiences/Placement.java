// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class Placement extends Enum
    implements TEnum
{

    private static final Placement $VALUES[];
    public static final Placement ANALYTICS_AUDIENCE_DASHBOARD_TAKEOVER;
    public static final Placement ANALYTICS_HOME_TAKEOVER;
    public static final Placement ANALYTICS_NOOP;
    public static final Placement ANDROID_APPLAUNCH_AUTO_COMPLETE;
    public static final Placement ANDROID_BOARD_TAKEOVER;
    public static final Placement ANDROID_CONVERSATION_NAG;
    public static final Placement ANDROID_GLOBAL_NAG;
    public static final Placement ANDROID_GLOBAL_SURVEY;
    public static final Placement ANDROID_HOME_FEED_TAKEOVER;
    public static final Placement ANDROID_HOME_HEADER;
    public static final Placement ANDROID_MAIN_USER_ED;
    public static final Placement ANDROID_NETWORK_STORY_NAG;
    public static final Placement ANDROID_NOOP;
    public static final Placement ANDROID_PINVITATIONAL_CONFIRM_BOARD;
    public static final Placement ANDROID_PIN_CLOSEUP_TAKEOVER;
    public static final Placement ANDROID_USER_PROFILE_TAKEOVER;
    public static final Placement ANDROID_YOUR_STORY_NAG;
    public static final Placement BATCH_NETWORK_STORY;
    public static final Placement BATCH_NOOP;
    public static final Placement BATCH_NUX_EMAILS;
    public static final Placement BATCH_NUX_PUSH_NOTIFICATIONS;
    public static final Placement BATCH_PUSH_NOTIFICATONS;
    public static final Placement BATCH_RECOMMENDATION_EMAILS;
    public static final Placement EMAIL_NOOP;
    public static final Placement EMAIL_NUX;
    public static final Placement EMAIL_USER_ED_TIP;
    public static final Placement IOS_APPLAUNCH_AUTO_COMPLETE;
    public static final Placement IOS_BOARD_TAKEOVER;
    public static final Placement IOS_GLOBAL_NAG;
    public static final Placement IOS_HOMEFEED_TAKEOVER;
    public static final Placement IOS_HOME_PR_NAG;
    public static final Placement IOS_MAIN_USER_ED;
    public static final Placement IOS_MESSAGES_LIST_VIEW_TAKEOVER;
    public static final Placement IOS_MESSAGE_SPLIT_VIEW_TAKEOVER;
    public static final Placement IOS_MESSAGE_VIEW_TAKEOVER;
    public static final Placement IOS_NOOP;
    public static final Placement IOS_NOTIFICATIONS_TAKEOVER;
    public static final Placement IOS_PERMISSIONS_TAKEOVER;
    public static final Placement IOS_PIN_CLOSEUP_TAKEOVER;
    public static final Placement IOS_PUSH_NOTIFICATION_PERMISSION;
    public static final Placement IOS_REPIN_DIALOG_TAKEOVER;
    public static final Placement IOS_SEARCH_RESULTS_TAKEOVER;
    public static final Placement IOS_SEARCH_TAB_TAKEOVER;
    public static final Placement IOS_USER_PROFILE_TAKEOVER;
    public static final Placement NOOP;
    public static final Placement PUSH_NOTIFICATION_AUTH;
    public static final Placement PUSH_NOTIFICATION_NONAUTH;
    public static final Placement PUSH_NOTIFICATION_NOOP;
    public static final Placement WEB_BOARD_HERO;
    public static final Placement WEB_BOARD_TAKEOVER;
    public static final Placement WEB_CATEGORY_HERO;
    public static final Placement WEB_EMPTY_PLACES_BOARD_TAKEOVER;
    public static final Placement WEB_EXPLORE_TAKEOVER;
    public static final Placement WEB_FILLED_PLACES_BOARD_TAKEOVER;
    public static final Placement WEB_HERO;
    public static final Placement WEB_HOMEFEED_FIRST_PIN;
    public static final Placement WEB_HOME_HERO;
    public static final Placement WEB_HOME_TAKEOVER;
    public static final Placement WEB_MOBILE_EVERYTHING_FEED_TAKEOVER;
    public static final Placement WEB_MOBILE_NOOP;
    public static final Placement WEB_NAG;
    public static final Placement WEB_NOOP;
    public static final Placement WEB_ONLOAD_AUTO_COMPLETE;
    public static final Placement WEB_PIN_CLOSEUP;
    public static final Placement WEB_PIN_CLOSEUP_TAKEOVER;
    public static final Placement WEB_PIN_SUCCESS;
    public static final Placement WEB_PROFILE_HERO;
    public static final Placement WEB_SEARCH_HERO;
    public static final Placement WEB_SEARCH_PAGE_TAKEOVER;
    public static final Placement WEB_TOOLTIP;
    public static final Placement WEB_USER_NEWS;
    public static final Placement WEB_USER_PROFILE_TAKEOVER;
    private final int value;

    private Placement(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static Placement findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return NOOP;

        case 10: // '\n'
            return WEB_NOOP;

        case 11: // '\013'
            return WEB_HOME_TAKEOVER;

        case 12: // '\f'
            return WEB_PIN_CLOSEUP;

        case 13: // '\r'
            return WEB_HERO;

        case 14: // '\016'
            return WEB_PIN_SUCCESS;

        case 15: // '\017'
            return WEB_HOME_HERO;

        case 16: // '\020'
            return WEB_TOOLTIP;

        case 17: // '\021'
            return WEB_BOARD_HERO;

        case 18: // '\022'
            return WEB_BOARD_TAKEOVER;

        case 19: // '\023'
            return WEB_USER_PROFILE_TAKEOVER;

        case 20: // '\024'
            return WEB_EMPTY_PLACES_BOARD_TAKEOVER;

        case 21: // '\025'
            return WEB_FILLED_PLACES_BOARD_TAKEOVER;

        case 22: // '\026'
            return WEB_EXPLORE_TAKEOVER;

        case 23: // '\027'
            return WEB_CATEGORY_HERO;

        case 24: // '\030'
            return WEB_PIN_CLOSEUP_TAKEOVER;

        case 25: // '\031'
            return WEB_SEARCH_HERO;

        case 26: // '\032'
            return WEB_ONLOAD_AUTO_COMPLETE;

        case 27: // '\033'
            return WEB_PROFILE_HERO;

        case 28: // '\034'
            return WEB_USER_NEWS;

        case 29: // '\035'
            return WEB_SEARCH_PAGE_TAKEOVER;

        case 30: // '\036'
            return WEB_NAG;

        case 31: // '\037'
            return WEB_HOMEFEED_FIRST_PIN;

        case 10000: 
            return IOS_NOOP;

        case 10001: 
            return IOS_GLOBAL_NAG;

        case 10002: 
            return IOS_HOME_PR_NAG;

        case 10003: 
            return IOS_HOMEFEED_TAKEOVER;

        case 10004: 
            return IOS_PIN_CLOSEUP_TAKEOVER;

        case 10005: 
            return IOS_REPIN_DIALOG_TAKEOVER;

        case 10006: 
            return IOS_MAIN_USER_ED;

        case 10007: 
            return IOS_PERMISSIONS_TAKEOVER;

        case 10008: 
            return IOS_BOARD_TAKEOVER;

        case 10009: 
            return IOS_USER_PROFILE_TAKEOVER;

        case 10010: 
            return IOS_NOTIFICATIONS_TAKEOVER;

        case 10011: 
            return IOS_MESSAGES_LIST_VIEW_TAKEOVER;

        case 10012: 
            return IOS_MESSAGE_VIEW_TAKEOVER;

        case 10013: 
            return IOS_MESSAGE_SPLIT_VIEW_TAKEOVER;

        case 10014: 
            return IOS_PUSH_NOTIFICATION_PERMISSION;

        case 10015: 
            return IOS_SEARCH_TAB_TAKEOVER;

        case 10016: 
            return IOS_APPLAUNCH_AUTO_COMPLETE;

        case 10017: 
            return IOS_SEARCH_RESULTS_TAKEOVER;

        case 20000: 
            return ANDROID_NOOP;

        case 20001: 
            return ANDROID_HOME_HEADER;

        case 20002: 
            return ANDROID_GLOBAL_NAG;

        case 20003: 
            return ANDROID_BOARD_TAKEOVER;

        case 20004: 
            return ANDROID_USER_PROFILE_TAKEOVER;

        case 20005: 
            return ANDROID_PIN_CLOSEUP_TAKEOVER;

        case 20006: 
            return ANDROID_MAIN_USER_ED;

        case 20007: 
            return ANDROID_APPLAUNCH_AUTO_COMPLETE;

        case 20008: 
            return ANDROID_HOME_FEED_TAKEOVER;

        case 20009: 
            return ANDROID_NETWORK_STORY_NAG;

        case 20010: 
            return ANDROID_CONVERSATION_NAG;

        case 20011: 
            return ANDROID_GLOBAL_SURVEY;

        case 20012: 
            return ANDROID_PINVITATIONAL_CONFIRM_BOARD;

        case 20013: 
            return ANDROID_YOUR_STORY_NAG;

        case 40000: 
            return WEB_MOBILE_NOOP;

        case 40001: 
            return WEB_MOBILE_EVERYTHING_FEED_TAKEOVER;

        case 50000: 
            return PUSH_NOTIFICATION_NOOP;

        case 50001: 
            return PUSH_NOTIFICATION_AUTH;

        case 50002: 
            return PUSH_NOTIFICATION_NONAUTH;

        case 60000: 
            return ANALYTICS_NOOP;

        case 60001: 
            return ANALYTICS_HOME_TAKEOVER;

        case 60002: 
            return ANALYTICS_AUDIENCE_DASHBOARD_TAKEOVER;

        case 70000: 
            return EMAIL_NOOP;

        case 70001: 
            return EMAIL_USER_ED_TIP;

        case 70002: 
            return EMAIL_NUX;

        case 80000: 
            return BATCH_NOOP;

        case 80001: 
            return BATCH_NUX_EMAILS;

        case 80002: 
            return BATCH_RECOMMENDATION_EMAILS;

        case 80003: 
            return BATCH_PUSH_NOTIFICATONS;

        case 80004: 
            return BATCH_NUX_PUSH_NOTIFICATIONS;

        case 80005: 
            return BATCH_NETWORK_STORY;
        }
    }

    public static Placement valueOf(String s)
    {
        return (Placement)Enum.valueOf(com/pinterest/schemas/experiences/Placement, s);
    }

    public static Placement[] values()
    {
        return (Placement[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NOOP = new Placement("NOOP", 0, 1);
        WEB_NOOP = new Placement("WEB_NOOP", 1, 10);
        WEB_HOME_TAKEOVER = new Placement("WEB_HOME_TAKEOVER", 2, 11);
        WEB_PIN_CLOSEUP = new Placement("WEB_PIN_CLOSEUP", 3, 12);
        WEB_HERO = new Placement("WEB_HERO", 4, 13);
        WEB_PIN_SUCCESS = new Placement("WEB_PIN_SUCCESS", 5, 14);
        WEB_HOME_HERO = new Placement("WEB_HOME_HERO", 6, 15);
        WEB_TOOLTIP = new Placement("WEB_TOOLTIP", 7, 16);
        WEB_BOARD_HERO = new Placement("WEB_BOARD_HERO", 8, 17);
        WEB_BOARD_TAKEOVER = new Placement("WEB_BOARD_TAKEOVER", 9, 18);
        WEB_USER_PROFILE_TAKEOVER = new Placement("WEB_USER_PROFILE_TAKEOVER", 10, 19);
        WEB_EMPTY_PLACES_BOARD_TAKEOVER = new Placement("WEB_EMPTY_PLACES_BOARD_TAKEOVER", 11, 20);
        WEB_FILLED_PLACES_BOARD_TAKEOVER = new Placement("WEB_FILLED_PLACES_BOARD_TAKEOVER", 12, 21);
        WEB_EXPLORE_TAKEOVER = new Placement("WEB_EXPLORE_TAKEOVER", 13, 22);
        WEB_CATEGORY_HERO = new Placement("WEB_CATEGORY_HERO", 14, 23);
        WEB_PIN_CLOSEUP_TAKEOVER = new Placement("WEB_PIN_CLOSEUP_TAKEOVER", 15, 24);
        WEB_SEARCH_HERO = new Placement("WEB_SEARCH_HERO", 16, 25);
        WEB_ONLOAD_AUTO_COMPLETE = new Placement("WEB_ONLOAD_AUTO_COMPLETE", 17, 26);
        WEB_PROFILE_HERO = new Placement("WEB_PROFILE_HERO", 18, 27);
        WEB_USER_NEWS = new Placement("WEB_USER_NEWS", 19, 28);
        WEB_SEARCH_PAGE_TAKEOVER = new Placement("WEB_SEARCH_PAGE_TAKEOVER", 20, 29);
        WEB_NAG = new Placement("WEB_NAG", 21, 30);
        WEB_HOMEFEED_FIRST_PIN = new Placement("WEB_HOMEFEED_FIRST_PIN", 22, 31);
        IOS_NOOP = new Placement("IOS_NOOP", 23, 10000);
        IOS_GLOBAL_NAG = new Placement("IOS_GLOBAL_NAG", 24, 10001);
        IOS_HOME_PR_NAG = new Placement("IOS_HOME_PR_NAG", 25, 10002);
        IOS_HOMEFEED_TAKEOVER = new Placement("IOS_HOMEFEED_TAKEOVER", 26, 10003);
        IOS_PIN_CLOSEUP_TAKEOVER = new Placement("IOS_PIN_CLOSEUP_TAKEOVER", 27, 10004);
        IOS_REPIN_DIALOG_TAKEOVER = new Placement("IOS_REPIN_DIALOG_TAKEOVER", 28, 10005);
        IOS_MAIN_USER_ED = new Placement("IOS_MAIN_USER_ED", 29, 10006);
        IOS_PERMISSIONS_TAKEOVER = new Placement("IOS_PERMISSIONS_TAKEOVER", 30, 10007);
        IOS_BOARD_TAKEOVER = new Placement("IOS_BOARD_TAKEOVER", 31, 10008);
        IOS_USER_PROFILE_TAKEOVER = new Placement("IOS_USER_PROFILE_TAKEOVER", 32, 10009);
        IOS_NOTIFICATIONS_TAKEOVER = new Placement("IOS_NOTIFICATIONS_TAKEOVER", 33, 10010);
        IOS_MESSAGES_LIST_VIEW_TAKEOVER = new Placement("IOS_MESSAGES_LIST_VIEW_TAKEOVER", 34, 10011);
        IOS_MESSAGE_VIEW_TAKEOVER = new Placement("IOS_MESSAGE_VIEW_TAKEOVER", 35, 10012);
        IOS_MESSAGE_SPLIT_VIEW_TAKEOVER = new Placement("IOS_MESSAGE_SPLIT_VIEW_TAKEOVER", 36, 10013);
        IOS_PUSH_NOTIFICATION_PERMISSION = new Placement("IOS_PUSH_NOTIFICATION_PERMISSION", 37, 10014);
        IOS_SEARCH_TAB_TAKEOVER = new Placement("IOS_SEARCH_TAB_TAKEOVER", 38, 10015);
        IOS_APPLAUNCH_AUTO_COMPLETE = new Placement("IOS_APPLAUNCH_AUTO_COMPLETE", 39, 10016);
        IOS_SEARCH_RESULTS_TAKEOVER = new Placement("IOS_SEARCH_RESULTS_TAKEOVER", 40, 10017);
        ANDROID_NOOP = new Placement("ANDROID_NOOP", 41, 20000);
        ANDROID_HOME_HEADER = new Placement("ANDROID_HOME_HEADER", 42, 20001);
        ANDROID_GLOBAL_NAG = new Placement("ANDROID_GLOBAL_NAG", 43, 20002);
        ANDROID_BOARD_TAKEOVER = new Placement("ANDROID_BOARD_TAKEOVER", 44, 20003);
        ANDROID_USER_PROFILE_TAKEOVER = new Placement("ANDROID_USER_PROFILE_TAKEOVER", 45, 20004);
        ANDROID_PIN_CLOSEUP_TAKEOVER = new Placement("ANDROID_PIN_CLOSEUP_TAKEOVER", 46, 20005);
        ANDROID_MAIN_USER_ED = new Placement("ANDROID_MAIN_USER_ED", 47, 20006);
        ANDROID_APPLAUNCH_AUTO_COMPLETE = new Placement("ANDROID_APPLAUNCH_AUTO_COMPLETE", 48, 20007);
        ANDROID_HOME_FEED_TAKEOVER = new Placement("ANDROID_HOME_FEED_TAKEOVER", 49, 20008);
        ANDROID_NETWORK_STORY_NAG = new Placement("ANDROID_NETWORK_STORY_NAG", 50, 20009);
        ANDROID_CONVERSATION_NAG = new Placement("ANDROID_CONVERSATION_NAG", 51, 20010);
        ANDROID_GLOBAL_SURVEY = new Placement("ANDROID_GLOBAL_SURVEY", 52, 20011);
        ANDROID_PINVITATIONAL_CONFIRM_BOARD = new Placement("ANDROID_PINVITATIONAL_CONFIRM_BOARD", 53, 20012);
        ANDROID_YOUR_STORY_NAG = new Placement("ANDROID_YOUR_STORY_NAG", 54, 20013);
        WEB_MOBILE_NOOP = new Placement("WEB_MOBILE_NOOP", 55, 40000);
        WEB_MOBILE_EVERYTHING_FEED_TAKEOVER = new Placement("WEB_MOBILE_EVERYTHING_FEED_TAKEOVER", 56, 40001);
        PUSH_NOTIFICATION_NOOP = new Placement("PUSH_NOTIFICATION_NOOP", 57, 50000);
        PUSH_NOTIFICATION_AUTH = new Placement("PUSH_NOTIFICATION_AUTH", 58, 50001);
        PUSH_NOTIFICATION_NONAUTH = new Placement("PUSH_NOTIFICATION_NONAUTH", 59, 50002);
        ANALYTICS_NOOP = new Placement("ANALYTICS_NOOP", 60, 60000);
        ANALYTICS_HOME_TAKEOVER = new Placement("ANALYTICS_HOME_TAKEOVER", 61, 60001);
        ANALYTICS_AUDIENCE_DASHBOARD_TAKEOVER = new Placement("ANALYTICS_AUDIENCE_DASHBOARD_TAKEOVER", 62, 60002);
        EMAIL_NOOP = new Placement("EMAIL_NOOP", 63, 0x11170);
        EMAIL_USER_ED_TIP = new Placement("EMAIL_USER_ED_TIP", 64, 0x11171);
        EMAIL_NUX = new Placement("EMAIL_NUX", 65, 0x11172);
        BATCH_NOOP = new Placement("BATCH_NOOP", 66, 0x13880);
        BATCH_NUX_EMAILS = new Placement("BATCH_NUX_EMAILS", 67, 0x13881);
        BATCH_RECOMMENDATION_EMAILS = new Placement("BATCH_RECOMMENDATION_EMAILS", 68, 0x13882);
        BATCH_PUSH_NOTIFICATONS = new Placement("BATCH_PUSH_NOTIFICATONS", 69, 0x13883);
        BATCH_NUX_PUSH_NOTIFICATIONS = new Placement("BATCH_NUX_PUSH_NOTIFICATIONS", 70, 0x13884);
        BATCH_NETWORK_STORY = new Placement("BATCH_NETWORK_STORY", 71, 0x13885);
        $VALUES = (new Placement[] {
            NOOP, WEB_NOOP, WEB_HOME_TAKEOVER, WEB_PIN_CLOSEUP, WEB_HERO, WEB_PIN_SUCCESS, WEB_HOME_HERO, WEB_TOOLTIP, WEB_BOARD_HERO, WEB_BOARD_TAKEOVER, 
            WEB_USER_PROFILE_TAKEOVER, WEB_EMPTY_PLACES_BOARD_TAKEOVER, WEB_FILLED_PLACES_BOARD_TAKEOVER, WEB_EXPLORE_TAKEOVER, WEB_CATEGORY_HERO, WEB_PIN_CLOSEUP_TAKEOVER, WEB_SEARCH_HERO, WEB_ONLOAD_AUTO_COMPLETE, WEB_PROFILE_HERO, WEB_USER_NEWS, 
            WEB_SEARCH_PAGE_TAKEOVER, WEB_NAG, WEB_HOMEFEED_FIRST_PIN, IOS_NOOP, IOS_GLOBAL_NAG, IOS_HOME_PR_NAG, IOS_HOMEFEED_TAKEOVER, IOS_PIN_CLOSEUP_TAKEOVER, IOS_REPIN_DIALOG_TAKEOVER, IOS_MAIN_USER_ED, 
            IOS_PERMISSIONS_TAKEOVER, IOS_BOARD_TAKEOVER, IOS_USER_PROFILE_TAKEOVER, IOS_NOTIFICATIONS_TAKEOVER, IOS_MESSAGES_LIST_VIEW_TAKEOVER, IOS_MESSAGE_VIEW_TAKEOVER, IOS_MESSAGE_SPLIT_VIEW_TAKEOVER, IOS_PUSH_NOTIFICATION_PERMISSION, IOS_SEARCH_TAB_TAKEOVER, IOS_APPLAUNCH_AUTO_COMPLETE, 
            IOS_SEARCH_RESULTS_TAKEOVER, ANDROID_NOOP, ANDROID_HOME_HEADER, ANDROID_GLOBAL_NAG, ANDROID_BOARD_TAKEOVER, ANDROID_USER_PROFILE_TAKEOVER, ANDROID_PIN_CLOSEUP_TAKEOVER, ANDROID_MAIN_USER_ED, ANDROID_APPLAUNCH_AUTO_COMPLETE, ANDROID_HOME_FEED_TAKEOVER, 
            ANDROID_NETWORK_STORY_NAG, ANDROID_CONVERSATION_NAG, ANDROID_GLOBAL_SURVEY, ANDROID_PINVITATIONAL_CONFIRM_BOARD, ANDROID_YOUR_STORY_NAG, WEB_MOBILE_NOOP, WEB_MOBILE_EVERYTHING_FEED_TAKEOVER, PUSH_NOTIFICATION_NOOP, PUSH_NOTIFICATION_AUTH, PUSH_NOTIFICATION_NONAUTH, 
            ANALYTICS_NOOP, ANALYTICS_HOME_TAKEOVER, ANALYTICS_AUDIENCE_DASHBOARD_TAKEOVER, EMAIL_NOOP, EMAIL_USER_ED_TIP, EMAIL_NUX, BATCH_NOOP, BATCH_NUX_EMAILS, BATCH_RECOMMENDATION_EMAILS, BATCH_PUSH_NOTIFICATONS, 
            BATCH_NUX_PUSH_NOTIFICATIONS, BATCH_NETWORK_STORY
        });
    }
}
