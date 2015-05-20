// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class ComponentType extends Enum
    implements TEnum
{

    private static final ComponentType $VALUES[];
    public static final ComponentType BOARD_INFO_BAR;
    public static final ComponentType BOARD_PINS_GRID;
    public static final ComponentType BRAND_SURVEY_DIALOG;
    public static final ComponentType BROWSER;
    public static final ComponentType BULK_INVITE;
    public static final ComponentType CATEGORIES_CAROUSEL;
    public static final ComponentType CONTEXTUAL_MENU;
    public static final ComponentType CONTEXTUAL_USER_EDUCATION;
    public static final ComponentType CONVERSATION_MESSAGES;
    public static final ComponentType DIGEST_STORY;
    public static final ComponentType DIGEST_STORY_CELL;
    public static final ComponentType DIGEST_STORY_CELL_CAROUSEL;
    public static final ComponentType DIGEST_STORY_FEEDBACK_DIALOG;
    public static final ComponentType DIGEST_STORY_HEADER;
    public static final ComponentType DISCOVER_FEATURED_CAROUSEL;
    public static final ComponentType DOMAIN;
    public static final ComponentType EDUCATION;
    public static final ComponentType FIND_FRIENDS_SOURCE_HEADER;
    public static final ComponentType FLOWED_BOARD;
    public static final ComponentType FLOWED_CATEGORY;
    public static final ComponentType FLOWED_PIN;
    public static final ComponentType HOMEFEED_INVITE_MODULE;
    public static final ComponentType INTEREST_CAROUSEL;
    public static final ComponentType INTEREST_GRID;
    public static final ComponentType INTEREST_PICKER;
    public static final ComponentType INTEREST_RELATED_CAROUSEL;
    public static final ComponentType LIST_HEADER;
    public static final ComponentType LOOKBOOK_ACTION_BAR;
    public static final ComponentType LOOKBOOK_FRAME;
    public static final ComponentType MAP;
    public static final ComponentType MODAL_ADD_PIN;
    public static final ComponentType MODAL_CREATE_BOARD;
    public static final ComponentType MODAL_DIALOG;
    public static final ComponentType MODAL_PIN;
    public static final ComponentType MODAL_POST_REPIN;
    public static final ComponentType MODAL_REPIN;
    public static final ComponentType MODAL_SEARCH_PRIVACY;
    public static final ComponentType NAG;
    public static final ComponentType NAG_CLIPBOARD_URL;
    public static final ComponentType NAVIGATION;
    public static final ComponentType NEWS_FEED;
    public static final ComponentType NOTIFICATIONS_CONVERSATIONS_DROPDOWN;
    public static final ComponentType ORIENTATION;
    public static final ComponentType PINNER_CAROUSEL;
    public static final ComponentType PIN_FEEDBACK_DIALOG_PFY;
    public static final ComponentType PIN_FEEDBACK_DIALOG_PFY_REASON;
    public static final ComponentType PIN_FEEDBACK_DIALOG_PROMOTED;
    public static final ComponentType PIN_FEEDBACK_DIALOG_PROMOTED_REASON;
    public static final ComponentType PIN_FEEDBACK_PIN_CELL_HIDDEN_NO_REASON;
    public static final ComponentType REGISTRATION;
    public static final ComponentType RELATED_BOARDS;
    public static final ComponentType RELATED_INTERESTS;
    public static final ComponentType RELATED_PIN;
    public static final ComponentType RELATED_PINS_GRID_ITEM;
    public static final ComponentType SAFARI_KEYCHAIN_USE_PROMPT;
    public static final ComponentType SEARCH_BOX;
    public static final ComponentType SEARCH_GUIDES_CONTAINER;
    public static final ComponentType SEARCH_INTEREST_RESULTS_GRID;
    public static final ComponentType SEARCH_RELATED_CATEGORIES;
    public static final ComponentType SEARCH_RELATED_QUERIES;
    public static final ComponentType SEGMENTED_CONTROL;
    public static final ComponentType SEND_OBJECT;
    public static final ComponentType SHARE_EXTENSION_PICK_BOARD;
    public static final ComponentType SHEET;
    public static final ComponentType STORIES_FEED;
    public static final ComponentType SUGGESTED_USERS;
    public static final ComponentType TOAST;
    public static final ComponentType TRENDING_CATEGORIES;
    public static final ComponentType TYPEAHEAD_SUGGESTIONS;
    public static final ComponentType USER_EDUCATION_DROPDOWN;
    public static final ComponentType USER_FEED;
    public static final ComponentType USER_MENU_DROPDOWN;
    public static final ComponentType USER_NEWS;
    public static final ComponentType USER_REPINS_FROM;
    public static final ComponentType USER_SELECT_SEARCH_BOX;
    public static final ComponentType VISUAL_SEARCH_GRID;
    public static final ComponentType WIDGET_ACTION_BAR;
    public static final ComponentType WIDGET_FOOTER;
    public static final ComponentType WIDGET_HEADER;
    private final int value;

    private ComponentType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ComponentType findByValue(int i)
    {
        switch (i)
        {
        case 76: // 'L'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 82: // 'R'
        case 83: // 'S'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        default:
            return null;

        case 0: // '\0'
            return FLOWED_PIN;

        case 1: // '\001'
            return FLOWED_BOARD;

        case 2: // '\002'
            return SUGGESTED_USERS;

        case 3: // '\003'
            return NEWS_FEED;

        case 4: // '\004'
            return MODAL_PIN;

        case 5: // '\005'
            return MODAL_REPIN;

        case 6: // '\006'
            return MODAL_POST_REPIN;

        case 7: // '\007'
            return MODAL_ADD_PIN;

        case 12: // '\f'
            return MODAL_CREATE_BOARD;

        case 74: // 'J'
            return MODAL_SEARCH_PRIVACY;

        case 8: // '\b'
            return NAVIGATION;

        case 9: // '\t'
            return MODAL_DIALOG;

        case 10: // '\n'
            return USER_FEED;

        case 11: // '\013'
            return FLOWED_CATEGORY;

        case 13: // '\r'
            return SHEET;

        case 14: // '\016'
            return EDUCATION;

        case 15: // '\017'
            return REGISTRATION;

        case 16: // '\020'
            return ORIENTATION;

        case 17: // '\021'
            return BROWSER;

        case 18: // '\022'
            return CONTEXTUAL_MENU;

        case 19: // '\023'
            return NAG;

        case 20: // '\024'
            return TOAST;

        case 21: // '\025'
            return WIDGET_ACTION_BAR;

        case 22: // '\026'
            return WIDGET_HEADER;

        case 23: // '\027'
            return WIDGET_FOOTER;

        case 24: // '\030'
            return HOMEFEED_INVITE_MODULE;

        case 25: // '\031'
            return TRENDING_CATEGORIES;

        case 26: // '\032'
            return MAP;

        case 27: // '\033'
            return LIST_HEADER;

        case 28: // '\034'
            return USER_REPINS_FROM;

        case 29: // '\035'
            return BOARD_PINS_GRID;

        case 30: // '\036'
            return DOMAIN;

        case 31: // '\037'
            return RELATED_BOARDS;

        case 32: // ' '
            return SEARCH_RELATED_QUERIES;

        case 33: // '!'
            return SEARCH_RELATED_CATEGORIES;

        case 34: // '"'
            return USER_SELECT_SEARCH_BOX;

        case 35: // '#'
            return TYPEAHEAD_SUGGESTIONS;

        case 36: // '$'
            return INTEREST_GRID;

        case 40: // '('
            return INTEREST_CAROUSEL;

        case 41: // ')'
            return INTEREST_RELATED_CAROUSEL;

        case 42: // '*'
            return CATEGORIES_CAROUSEL;

        case 43: // '+'
            return SEARCH_BOX;

        case 44: // ','
            return SEARCH_INTEREST_RESULTS_GRID;

        case 37: // '%'
            return BULK_INVITE;

        case 38: // '&'
            return USER_NEWS;

        case 39: // '\''
            return RELATED_INTERESTS;

        case 45: // '-'
            return VISUAL_SEARCH_GRID;

        case 46: // '.'
            return USER_MENU_DROPDOWN;

        case 47: // '/'
            return SEARCH_GUIDES_CONTAINER;

        case 48: // '0'
            return STORIES_FEED;

        case 49: // '1'
            return DISCOVER_FEATURED_CAROUSEL;

        case 50: // '2'
            return PINNER_CAROUSEL;

        case 51: // '3'
            return SEGMENTED_CONTROL;

        case 52: // '4'
            return CONTEXTUAL_USER_EDUCATION;

        case 53: // '5'
            return NAG_CLIPBOARD_URL;

        case 54: // '6'
            return NOTIFICATIONS_CONVERSATIONS_DROPDOWN;

        case 55: // '7'
            return CONVERSATION_MESSAGES;

        case 56: // '8'
            return SEND_OBJECT;

        case 57: // '9'
            return USER_EDUCATION_DROPDOWN;

        case 58: // ':'
            return PIN_FEEDBACK_DIALOG_PFY;

        case 59: // ';'
            return PIN_FEEDBACK_DIALOG_PFY_REASON;

        case 60: // '<'
            return PIN_FEEDBACK_DIALOG_PROMOTED;

        case 61: // '='
            return PIN_FEEDBACK_DIALOG_PROMOTED_REASON;

        case 62: // '>'
            return PIN_FEEDBACK_PIN_CELL_HIDDEN_NO_REASON;

        case 63: // '?'
            return DIGEST_STORY;

        case 71: // 'G'
            return DIGEST_STORY_FEEDBACK_DIALOG;

        case 72: // 'H'
            return DIGEST_STORY_HEADER;

        case 73: // 'I'
            return DIGEST_STORY_CELL;

        case 75: // 'K'
            return DIGEST_STORY_CELL_CAROUSEL;

        case 64: // '@'
            return LOOKBOOK_FRAME;

        case 65: // 'A'
            return LOOKBOOK_ACTION_BAR;

        case 66: // 'B'
            return INTEREST_PICKER;

        case 67: // 'C'
            return SAFARI_KEYCHAIN_USE_PROMPT;

        case 68: // 'D'
            return RELATED_PINS_GRID_ITEM;

        case 69: // 'E'
            return BOARD_INFO_BAR;

        case 70: // 'F'
            return RELATED_PIN;

        case 80: // 'P'
            return FIND_FRIENDS_SOURCE_HEADER;

        case 81: // 'Q'
            return BRAND_SURVEY_DIALOG;

        case 90: // 'Z'
            return SHARE_EXTENSION_PICK_BOARD;
        }
    }

    public static ComponentType valueOf(String s)
    {
        return (ComponentType)Enum.valueOf(com/pinterest/schemas/event/ComponentType, s);
    }

    public static ComponentType[] values()
    {
        return (ComponentType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        FLOWED_PIN = new ComponentType("FLOWED_PIN", 0, 0);
        FLOWED_BOARD = new ComponentType("FLOWED_BOARD", 1, 1);
        SUGGESTED_USERS = new ComponentType("SUGGESTED_USERS", 2, 2);
        NEWS_FEED = new ComponentType("NEWS_FEED", 3, 3);
        MODAL_PIN = new ComponentType("MODAL_PIN", 4, 4);
        MODAL_REPIN = new ComponentType("MODAL_REPIN", 5, 5);
        MODAL_POST_REPIN = new ComponentType("MODAL_POST_REPIN", 6, 6);
        MODAL_ADD_PIN = new ComponentType("MODAL_ADD_PIN", 7, 7);
        MODAL_CREATE_BOARD = new ComponentType("MODAL_CREATE_BOARD", 8, 12);
        MODAL_SEARCH_PRIVACY = new ComponentType("MODAL_SEARCH_PRIVACY", 9, 74);
        NAVIGATION = new ComponentType("NAVIGATION", 10, 8);
        MODAL_DIALOG = new ComponentType("MODAL_DIALOG", 11, 9);
        USER_FEED = new ComponentType("USER_FEED", 12, 10);
        FLOWED_CATEGORY = new ComponentType("FLOWED_CATEGORY", 13, 11);
        SHEET = new ComponentType("SHEET", 14, 13);
        EDUCATION = new ComponentType("EDUCATION", 15, 14);
        REGISTRATION = new ComponentType("REGISTRATION", 16, 15);
        ORIENTATION = new ComponentType("ORIENTATION", 17, 16);
        BROWSER = new ComponentType("BROWSER", 18, 17);
        CONTEXTUAL_MENU = new ComponentType("CONTEXTUAL_MENU", 19, 18);
        NAG = new ComponentType("NAG", 20, 19);
        TOAST = new ComponentType("TOAST", 21, 20);
        WIDGET_ACTION_BAR = new ComponentType("WIDGET_ACTION_BAR", 22, 21);
        WIDGET_HEADER = new ComponentType("WIDGET_HEADER", 23, 22);
        WIDGET_FOOTER = new ComponentType("WIDGET_FOOTER", 24, 23);
        HOMEFEED_INVITE_MODULE = new ComponentType("HOMEFEED_INVITE_MODULE", 25, 24);
        TRENDING_CATEGORIES = new ComponentType("TRENDING_CATEGORIES", 26, 25);
        MAP = new ComponentType("MAP", 27, 26);
        LIST_HEADER = new ComponentType("LIST_HEADER", 28, 27);
        USER_REPINS_FROM = new ComponentType("USER_REPINS_FROM", 29, 28);
        BOARD_PINS_GRID = new ComponentType("BOARD_PINS_GRID", 30, 29);
        DOMAIN = new ComponentType("DOMAIN", 31, 30);
        RELATED_BOARDS = new ComponentType("RELATED_BOARDS", 32, 31);
        SEARCH_RELATED_QUERIES = new ComponentType("SEARCH_RELATED_QUERIES", 33, 32);
        SEARCH_RELATED_CATEGORIES = new ComponentType("SEARCH_RELATED_CATEGORIES", 34, 33);
        USER_SELECT_SEARCH_BOX = new ComponentType("USER_SELECT_SEARCH_BOX", 35, 34);
        TYPEAHEAD_SUGGESTIONS = new ComponentType("TYPEAHEAD_SUGGESTIONS", 36, 35);
        INTEREST_GRID = new ComponentType("INTEREST_GRID", 37, 36);
        INTEREST_CAROUSEL = new ComponentType("INTEREST_CAROUSEL", 38, 40);
        INTEREST_RELATED_CAROUSEL = new ComponentType("INTEREST_RELATED_CAROUSEL", 39, 41);
        CATEGORIES_CAROUSEL = new ComponentType("CATEGORIES_CAROUSEL", 40, 42);
        SEARCH_BOX = new ComponentType("SEARCH_BOX", 41, 43);
        SEARCH_INTEREST_RESULTS_GRID = new ComponentType("SEARCH_INTEREST_RESULTS_GRID", 42, 44);
        BULK_INVITE = new ComponentType("BULK_INVITE", 43, 37);
        USER_NEWS = new ComponentType("USER_NEWS", 44, 38);
        RELATED_INTERESTS = new ComponentType("RELATED_INTERESTS", 45, 39);
        VISUAL_SEARCH_GRID = new ComponentType("VISUAL_SEARCH_GRID", 46, 45);
        USER_MENU_DROPDOWN = new ComponentType("USER_MENU_DROPDOWN", 47, 46);
        SEARCH_GUIDES_CONTAINER = new ComponentType("SEARCH_GUIDES_CONTAINER", 48, 47);
        STORIES_FEED = new ComponentType("STORIES_FEED", 49, 48);
        DISCOVER_FEATURED_CAROUSEL = new ComponentType("DISCOVER_FEATURED_CAROUSEL", 50, 49);
        PINNER_CAROUSEL = new ComponentType("PINNER_CAROUSEL", 51, 50);
        SEGMENTED_CONTROL = new ComponentType("SEGMENTED_CONTROL", 52, 51);
        CONTEXTUAL_USER_EDUCATION = new ComponentType("CONTEXTUAL_USER_EDUCATION", 53, 52);
        NAG_CLIPBOARD_URL = new ComponentType("NAG_CLIPBOARD_URL", 54, 53);
        NOTIFICATIONS_CONVERSATIONS_DROPDOWN = new ComponentType("NOTIFICATIONS_CONVERSATIONS_DROPDOWN", 55, 54);
        CONVERSATION_MESSAGES = new ComponentType("CONVERSATION_MESSAGES", 56, 55);
        SEND_OBJECT = new ComponentType("SEND_OBJECT", 57, 56);
        USER_EDUCATION_DROPDOWN = new ComponentType("USER_EDUCATION_DROPDOWN", 58, 57);
        PIN_FEEDBACK_DIALOG_PFY = new ComponentType("PIN_FEEDBACK_DIALOG_PFY", 59, 58);
        PIN_FEEDBACK_DIALOG_PFY_REASON = new ComponentType("PIN_FEEDBACK_DIALOG_PFY_REASON", 60, 59);
        PIN_FEEDBACK_DIALOG_PROMOTED = new ComponentType("PIN_FEEDBACK_DIALOG_PROMOTED", 61, 60);
        PIN_FEEDBACK_DIALOG_PROMOTED_REASON = new ComponentType("PIN_FEEDBACK_DIALOG_PROMOTED_REASON", 62, 61);
        PIN_FEEDBACK_PIN_CELL_HIDDEN_NO_REASON = new ComponentType("PIN_FEEDBACK_PIN_CELL_HIDDEN_NO_REASON", 63, 62);
        DIGEST_STORY = new ComponentType("DIGEST_STORY", 64, 63);
        DIGEST_STORY_FEEDBACK_DIALOG = new ComponentType("DIGEST_STORY_FEEDBACK_DIALOG", 65, 71);
        DIGEST_STORY_HEADER = new ComponentType("DIGEST_STORY_HEADER", 66, 72);
        DIGEST_STORY_CELL = new ComponentType("DIGEST_STORY_CELL", 67, 73);
        DIGEST_STORY_CELL_CAROUSEL = new ComponentType("DIGEST_STORY_CELL_CAROUSEL", 68, 75);
        LOOKBOOK_FRAME = new ComponentType("LOOKBOOK_FRAME", 69, 64);
        LOOKBOOK_ACTION_BAR = new ComponentType("LOOKBOOK_ACTION_BAR", 70, 65);
        INTEREST_PICKER = new ComponentType("INTEREST_PICKER", 71, 66);
        SAFARI_KEYCHAIN_USE_PROMPT = new ComponentType("SAFARI_KEYCHAIN_USE_PROMPT", 72, 67);
        RELATED_PINS_GRID_ITEM = new ComponentType("RELATED_PINS_GRID_ITEM", 73, 68);
        BOARD_INFO_BAR = new ComponentType("BOARD_INFO_BAR", 74, 69);
        RELATED_PIN = new ComponentType("RELATED_PIN", 75, 70);
        FIND_FRIENDS_SOURCE_HEADER = new ComponentType("FIND_FRIENDS_SOURCE_HEADER", 76, 80);
        BRAND_SURVEY_DIALOG = new ComponentType("BRAND_SURVEY_DIALOG", 77, 81);
        SHARE_EXTENSION_PICK_BOARD = new ComponentType("SHARE_EXTENSION_PICK_BOARD", 78, 90);
        $VALUES = (new ComponentType[] {
            FLOWED_PIN, FLOWED_BOARD, SUGGESTED_USERS, NEWS_FEED, MODAL_PIN, MODAL_REPIN, MODAL_POST_REPIN, MODAL_ADD_PIN, MODAL_CREATE_BOARD, MODAL_SEARCH_PRIVACY, 
            NAVIGATION, MODAL_DIALOG, USER_FEED, FLOWED_CATEGORY, SHEET, EDUCATION, REGISTRATION, ORIENTATION, BROWSER, CONTEXTUAL_MENU, 
            NAG, TOAST, WIDGET_ACTION_BAR, WIDGET_HEADER, WIDGET_FOOTER, HOMEFEED_INVITE_MODULE, TRENDING_CATEGORIES, MAP, LIST_HEADER, USER_REPINS_FROM, 
            BOARD_PINS_GRID, DOMAIN, RELATED_BOARDS, SEARCH_RELATED_QUERIES, SEARCH_RELATED_CATEGORIES, USER_SELECT_SEARCH_BOX, TYPEAHEAD_SUGGESTIONS, INTEREST_GRID, INTEREST_CAROUSEL, INTEREST_RELATED_CAROUSEL, 
            CATEGORIES_CAROUSEL, SEARCH_BOX, SEARCH_INTEREST_RESULTS_GRID, BULK_INVITE, USER_NEWS, RELATED_INTERESTS, VISUAL_SEARCH_GRID, USER_MENU_DROPDOWN, SEARCH_GUIDES_CONTAINER, STORIES_FEED, 
            DISCOVER_FEATURED_CAROUSEL, PINNER_CAROUSEL, SEGMENTED_CONTROL, CONTEXTUAL_USER_EDUCATION, NAG_CLIPBOARD_URL, NOTIFICATIONS_CONVERSATIONS_DROPDOWN, CONVERSATION_MESSAGES, SEND_OBJECT, USER_EDUCATION_DROPDOWN, PIN_FEEDBACK_DIALOG_PFY, 
            PIN_FEEDBACK_DIALOG_PFY_REASON, PIN_FEEDBACK_DIALOG_PROMOTED, PIN_FEEDBACK_DIALOG_PROMOTED_REASON, PIN_FEEDBACK_PIN_CELL_HIDDEN_NO_REASON, DIGEST_STORY, DIGEST_STORY_FEEDBACK_DIALOG, DIGEST_STORY_HEADER, DIGEST_STORY_CELL, DIGEST_STORY_CELL_CAROUSEL, LOOKBOOK_FRAME, 
            LOOKBOOK_ACTION_BAR, INTEREST_PICKER, SAFARI_KEYCHAIN_USE_PROMPT, RELATED_PINS_GRID_ITEM, BOARD_INFO_BAR, RELATED_PIN, FIND_FRIENDS_SOURCE_HEADER, BRAND_SURVEY_DIALOG, SHARE_EXTENSION_PICK_BOARD
        });
    }
}
