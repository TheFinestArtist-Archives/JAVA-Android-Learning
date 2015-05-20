// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class ViewType extends Enum
    implements TEnum
{

    private static final ViewType $VALUES[];
    public static final ViewType ABOUT;
    public static final ViewType ACTION_SHEET;
    public static final ViewType ANALYTICS_DOMAIN;
    public static final ViewType ANALYTICS_PROFILE;
    public static final ViewType ANDROID_WIDGET;
    public static final ViewType ANDROID_WIDGET_FEED;
    public static final ViewType BOARD;
    public static final ViewType BOARD_PICKER;
    public static final ViewType BOOKMARKLET;
    public static final ViewType BROWSER;
    public static final ViewType CAMERA;
    public static final ViewType CATEGORY_GRID;
    public static final ViewType CONVERSATION;
    public static final ViewType DEEP_LINKING;
    public static final ViewType DISCOVER;
    public static final ViewType EDUCATION;
    public static final ViewType EMAIL;
    public static final ViewType ERROR;
    public static final ViewType EXPLORE_FEED;
    public static final ViewType EXPLORE_PAGE;
    public static final ViewType FEED;
    public static final ViewType FEED_EDITOR;
    public static final ViewType FIND_FRIENDS;
    public static final ViewType FRIEND_INVITER;
    public static final ViewType FRIEND_MULTI_INVITER;
    public static final ViewType LOGIN;
    public static final ViewType NEWS;
    public static final ViewType ORIENTATION;
    public static final ViewType OTHER_EXTERNAL;
    public static final ViewType PIN;
    public static final ViewType PINPICKS;
    public static final ViewType PINVITATIONAL;
    public static final ViewType PINVITATIONAL_UNAUTH_CONFIRM;
    public static final ViewType PINVITATIONAL_UNAUTH_EMAIL;
    public static final ViewType REGISTRATION;
    public static final ViewType REPORT;
    public static final ViewType SEARCH;
    public static final ViewType SERVICE_ENTRY_SEO;
    public static final ViewType SERVICE_ENTRY_SOCIAL;
    public static final ViewType SETTINGS;
    public static final ViewType SHARE_EXTENSION;
    public static final ViewType SPLASH;
    public static final ViewType STERLING_ADVERTISER;
    public static final ViewType STERLING_CAMPAIGN;
    public static final ViewType STERLING_CREATION_FLOW;
    public static final ViewType STERLING_PIN_PROMOTION;
    public static final ViewType STORIES;
    public static final ViewType USER;
    public static final ViewType VISUAL_SEARCH;
    private final int value;

    private ViewType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ViewType findByValue(int i)
    {
        switch (i)
        {
        case 49: // '1'
        default:
            return null;

        case 1: // '\001'
            return FEED;

        case 2: // '\002'
            return SEARCH;

        case 3: // '\003'
            return PIN;

        case 4: // '\004'
            return USER;

        case 5: // '\005'
            return BOARD;

        case 6: // '\006'
            return ABOUT;

        case 7: // '\007'
            return SETTINGS;

        case 8: // '\b'
            return FRIEND_INVITER;

        case 9: // '\t'
            return LOGIN;

        case 10: // '\n'
            return REGISTRATION;

        case 11: // '\013'
            return BROWSER;

        case 12: // '\f'
            return BOOKMARKLET;

        case 13: // '\r'
            return ANDROID_WIDGET;

        case 14: // '\016'
            return SPLASH;

        case 15: // '\017'
            return CAMERA;

        case 16: // '\020'
            return REPORT;

        case 17: // '\021'
            return ERROR;

        case 18: // '\022'
            return NEWS;

        case 41: // ')'
            return STORIES;

        case 19: // '\023'
            return CATEGORY_GRID;

        case 20: // '\024'
            return DEEP_LINKING;

        case 21: // '\025'
            return BOARD_PICKER;

        case 22: // '\026'
            return DISCOVER;

        case 23: // '\027'
            return EDUCATION;

        case 24: // '\030'
            return ORIENTATION;

        case 25: // '\031'
            return FEED_EDITOR;

        case 26: // '\032'
            return ANDROID_WIDGET_FEED;

        case 27: // '\033'
            return EXPLORE_PAGE;

        case 28: // '\034'
            return EXPLORE_FEED;

        case 29: // '\035'
            return FRIEND_MULTI_INVITER;

        case 30: // '\036'
            return FIND_FRIENDS;

        case 31: // '\037'
            return EMAIL;

        case 32: // ' '
            return OTHER_EXTERNAL;

        case 33: // '!'
            return SERVICE_ENTRY_SOCIAL;

        case 34: // '"'
            return SERVICE_ENTRY_SEO;

        case 35: // '#'
            return STERLING_CREATION_FLOW;

        case 36: // '$'
            return STERLING_ADVERTISER;

        case 37: // '%'
            return STERLING_CAMPAIGN;

        case 38: // '&'
            return STERLING_PIN_PROMOTION;

        case 39: // '\''
            return ANALYTICS_PROFILE;

        case 40: // '('
            return ANALYTICS_DOMAIN;

        case 42: // '*'
            return CONVERSATION;

        case 43: // '+'
            return VISUAL_SEARCH;

        case 44: // ','
            return PINPICKS;

        case 45: // '-'
            return PINVITATIONAL_UNAUTH_EMAIL;

        case 46: // '.'
            return PINVITATIONAL_UNAUTH_CONFIRM;

        case 47: // '/'
            return PINVITATIONAL;

        case 48: // '0'
            return ACTION_SHEET;

        case 50: // '2'
            return SHARE_EXTENSION;
        }
    }

    public static ViewType valueOf(String s)
    {
        return (ViewType)Enum.valueOf(com/pinterest/schemas/event/ViewType, s);
    }

    public static ViewType[] values()
    {
        return (ViewType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        FEED = new ViewType("FEED", 0, 1);
        SEARCH = new ViewType("SEARCH", 1, 2);
        PIN = new ViewType("PIN", 2, 3);
        USER = new ViewType("USER", 3, 4);
        BOARD = new ViewType("BOARD", 4, 5);
        ABOUT = new ViewType("ABOUT", 5, 6);
        SETTINGS = new ViewType("SETTINGS", 6, 7);
        FRIEND_INVITER = new ViewType("FRIEND_INVITER", 7, 8);
        LOGIN = new ViewType("LOGIN", 8, 9);
        REGISTRATION = new ViewType("REGISTRATION", 9, 10);
        BROWSER = new ViewType("BROWSER", 10, 11);
        BOOKMARKLET = new ViewType("BOOKMARKLET", 11, 12);
        ANDROID_WIDGET = new ViewType("ANDROID_WIDGET", 12, 13);
        SPLASH = new ViewType("SPLASH", 13, 14);
        CAMERA = new ViewType("CAMERA", 14, 15);
        REPORT = new ViewType("REPORT", 15, 16);
        ERROR = new ViewType("ERROR", 16, 17);
        NEWS = new ViewType("NEWS", 17, 18);
        STORIES = new ViewType("STORIES", 18, 41);
        CATEGORY_GRID = new ViewType("CATEGORY_GRID", 19, 19);
        DEEP_LINKING = new ViewType("DEEP_LINKING", 20, 20);
        BOARD_PICKER = new ViewType("BOARD_PICKER", 21, 21);
        DISCOVER = new ViewType("DISCOVER", 22, 22);
        EDUCATION = new ViewType("EDUCATION", 23, 23);
        ORIENTATION = new ViewType("ORIENTATION", 24, 24);
        FEED_EDITOR = new ViewType("FEED_EDITOR", 25, 25);
        ANDROID_WIDGET_FEED = new ViewType("ANDROID_WIDGET_FEED", 26, 26);
        EXPLORE_PAGE = new ViewType("EXPLORE_PAGE", 27, 27);
        EXPLORE_FEED = new ViewType("EXPLORE_FEED", 28, 28);
        FRIEND_MULTI_INVITER = new ViewType("FRIEND_MULTI_INVITER", 29, 29);
        FIND_FRIENDS = new ViewType("FIND_FRIENDS", 30, 30);
        EMAIL = new ViewType("EMAIL", 31, 31);
        OTHER_EXTERNAL = new ViewType("OTHER_EXTERNAL", 32, 32);
        SERVICE_ENTRY_SOCIAL = new ViewType("SERVICE_ENTRY_SOCIAL", 33, 33);
        SERVICE_ENTRY_SEO = new ViewType("SERVICE_ENTRY_SEO", 34, 34);
        STERLING_CREATION_FLOW = new ViewType("STERLING_CREATION_FLOW", 35, 35);
        STERLING_ADVERTISER = new ViewType("STERLING_ADVERTISER", 36, 36);
        STERLING_CAMPAIGN = new ViewType("STERLING_CAMPAIGN", 37, 37);
        STERLING_PIN_PROMOTION = new ViewType("STERLING_PIN_PROMOTION", 38, 38);
        ANALYTICS_PROFILE = new ViewType("ANALYTICS_PROFILE", 39, 39);
        ANALYTICS_DOMAIN = new ViewType("ANALYTICS_DOMAIN", 40, 40);
        CONVERSATION = new ViewType("CONVERSATION", 41, 42);
        VISUAL_SEARCH = new ViewType("VISUAL_SEARCH", 42, 43);
        PINPICKS = new ViewType("PINPICKS", 43, 44);
        PINVITATIONAL_UNAUTH_EMAIL = new ViewType("PINVITATIONAL_UNAUTH_EMAIL", 44, 45);
        PINVITATIONAL_UNAUTH_CONFIRM = new ViewType("PINVITATIONAL_UNAUTH_CONFIRM", 45, 46);
        PINVITATIONAL = new ViewType("PINVITATIONAL", 46, 47);
        ACTION_SHEET = new ViewType("ACTION_SHEET", 47, 48);
        SHARE_EXTENSION = new ViewType("SHARE_EXTENSION", 48, 50);
        $VALUES = (new ViewType[] {
            FEED, SEARCH, PIN, USER, BOARD, ABOUT, SETTINGS, FRIEND_INVITER, LOGIN, REGISTRATION, 
            BROWSER, BOOKMARKLET, ANDROID_WIDGET, SPLASH, CAMERA, REPORT, ERROR, NEWS, STORIES, CATEGORY_GRID, 
            DEEP_LINKING, BOARD_PICKER, DISCOVER, EDUCATION, ORIENTATION, FEED_EDITOR, ANDROID_WIDGET_FEED, EXPLORE_PAGE, EXPLORE_FEED, FRIEND_MULTI_INVITER, 
            FIND_FRIENDS, EMAIL, OTHER_EXTERNAL, SERVICE_ENTRY_SOCIAL, SERVICE_ENTRY_SEO, STERLING_CREATION_FLOW, STERLING_ADVERTISER, STERLING_CAMPAIGN, STERLING_PIN_PROMOTION, ANALYTICS_PROFILE, 
            ANALYTICS_DOMAIN, CONVERSATION, VISUAL_SEARCH, PINPICKS, PINVITATIONAL_UNAUTH_EMAIL, PINVITATIONAL_UNAUTH_CONFIRM, PINVITATIONAL, ACTION_SHEET, SHARE_EXTENSION
        });
    }
}
