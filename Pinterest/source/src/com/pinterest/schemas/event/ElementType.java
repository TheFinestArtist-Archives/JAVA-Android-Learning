// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class ElementType extends Enum
    implements TEnum
{

    private static final ElementType $VALUES[];
    public static final ElementType ADD_INTEREST_BUTTON;
    public static final ElementType ADD_MESSAGE_BUTTON;
    public static final ElementType ADD_PIN_BUTTON_BOOKMARKLET;
    public static final ElementType ADD_PIN_BUTTON_SCRAPE;
    public static final ElementType ADD_PIN_BUTTON_UPLOAD;
    public static final ElementType ADD_PIN_CANCEL_INSTALL_BOOKMARKLET;
    public static final ElementType ADD_PIN_FROM_WEBSITE_BUTTON;
    public static final ElementType ADD_PIN_INSTALL_BOOKMARKLET;
    public static final ElementType ADD_PIN_REP;
    public static final ElementType ADD_PIN_REP_BOOKMARKLET;
    public static final ElementType ADD_PIN_REP_SCRAPE;
    public static final ElementType ADD_PIN_REP_UPLOAD;
    public static final ElementType ADD_PLACE_BUTTON;
    public static final ElementType ANALYTICS_BUTTON;
    public static final ElementType APP_ICON;
    public static final ElementType APP_RATING_ATTEMPT_BUTTON;
    public static final ElementType APP_RATING_DECLINE_BUTTON;
    public static final ElementType APP_RATING_REMIND_BUTTON;
    public static final ElementType AUTOCOMPLETE_SUGGESTION;
    public static final ElementType AUTOCOMPLETE_SUGGESTION_LC1;
    public static final ElementType AUTOCOMPLETE_SUGGESTION_LC2;
    public static final ElementType BACK_BUTTON;
    public static final ElementType BOARD_CATEGORY;
    public static final ElementType BOARD_COVER;
    public static final ElementType BOARD_CREATE;
    public static final ElementType BOARD_CREATE_SECRET;
    public static final ElementType BOARD_CREATE_SUGGESTED;
    public static final ElementType BOARD_DELETE_BUTTON;
    public static final ElementType BOARD_DESCRIPTION;
    public static final ElementType BOARD_EDIT_BUTTON;
    public static final ElementType BOARD_FOLLOW;
    public static final ElementType BOARD_LEAVE_BUTTON;
    public static final ElementType BOARD_NAME;
    public static final ElementType BOARD_PICKER;
    public static final ElementType BOARD_RELATED_BOARD;
    public static final ElementType BOARD_SECRET;
    public static final ElementType BOARD_SHARE_BUTTON;
    public static final ElementType BOARD_SHARE_COPY_LINK_BUTTON;
    public static final ElementType BOARD_SHARE_EMAIL_BUTTON;
    public static final ElementType BOARD_SHARE_FACEBOOK_BUTTON;
    public static final ElementType BOARD_SHARE_OTHER_BUTTON;
    public static final ElementType BRAND_SURVEY_DIALOG_BACKGROUND_DISMISS;
    public static final ElementType BRAND_SURVEY_DIALOG_LATER_BUTTON;
    public static final ElementType BRAND_SURVEY_DIALOG_NEVER_BUTTON;
    public static final ElementType BRAND_SURVEY_DIALOG_YES_BUTTON;
    public static final ElementType BROWSER_BUTTON;
    public static final ElementType BROWSER_WEB_IMAGE;
    public static final ElementType BULK_CANCEL_BUTTON;
    public static final ElementType BULK_COPY_PINS_BUTTON;
    public static final ElementType BULK_DELETE_PINS_BUTTON;
    public static final ElementType BULK_INVITER_BUTTON;
    public static final ElementType BULK_MOVE_PINS_BUTTON;
    public static final ElementType BUY_BUTTON;
    public static final ElementType CAMERA_BUTTON;
    public static final ElementType CANCEL_BUTTON;
    public static final ElementType CATEGORY_ICON;
    public static final ElementType CATEGORY_RECENT;
    public static final ElementType CHANGE_PASSWORD_BUTTON;
    public static final ElementType CLEAR_CONTACTS_BUTTON;
    public static final ElementType CLEAR_HISTORY_BUTTON;
    public static final ElementType CLEAR_SEARCHES_BUTTON;
    public static final ElementType CLIPBOARD_BUTTON;
    public static final ElementType CLOSE_BUTTON;
    public static final ElementType COLLABORATOR_TEXT;
    public static final ElementType COMMENTS_BUTTON;
    public static final ElementType COMPOSE_EMAIL_INVITE_BUTTON;
    public static final ElementType COMPOSE_SMS_INVITE_BUTTON;
    public static final ElementType CONVERSATION_CREATE_BUTTON;
    public static final ElementType CONVERSATION_INBOX_BUTTON;
    public static final ElementType CONVERSATION_LIST_ITEM;
    public static final ElementType CONVERSATION_NEW_BUTTON;
    public static final ElementType COPY_LINK_BUTTON;
    public static final ElementType COUNTRY_BUTTON;
    public static final ElementType CREATE_BOARD_BUTTON;
    public static final ElementType CREATE_BUTTON;
    public static final ElementType DECLINE_BUTTON;
    public static final ElementType DIGEST_CAROUSEL_CONTENT_REP;
    public static final ElementType DIGEST_FEEDBACK_DIALOG_BUTTON_HIDE_THROUGH_BOARD_REC;
    public static final ElementType DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD;
    public static final ElementType DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST;
    public static final ElementType DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER;
    public static final ElementType DIGEST_PIN;
    public static final ElementType DIGEST_STORY_CUSTOM_ACTION_BUTTON;
    public static final ElementType DIGEST_STORY_EXPAND_BUTTON;
    public static final ElementType DIGEST_STORY_FEEDBACK_BUTTON;
    public static final ElementType DIGEST_STORY_FOLLOW_BUTTON;
    public static final ElementType DIGEST_STORY_HEADER_BUTTON;
    public static final ElementType DISCOVER_FEATURED_ITEM;
    public static final ElementType DISCOVER_TRENDING_CATEGORY;
    public static final ElementType DOMAIN_URL;
    public static final ElementType DONE_BUTTON;
    public static final ElementType DUPLICATE_PIN_WARNING;
    public static final ElementType EDIT_HOME_FEED_BUTTON;
    public static final ElementType EDUCATION_GUIDED_SEARCH_COMPLETE_BUTTON;
    public static final ElementType EDUCATION_GUIDED_SEARCH_SUGGESTION;
    public static final ElementType EDUCATION_TARGET;
    public static final ElementType EMAIL_BUTTON;
    public static final ElementType EXPLORE_BUTTON;
    public static final ElementType FACEBOOK_CONNECT;
    public static final ElementType FACEBOOK_INVITE_BUTTON;
    public static final ElementType FACEBOOK_TIMELINE_CONNECT;
    public static final ElementType FEED_SUBCATEGORY;
    public static final ElementType FINDFRIENDS_BUTTON;
    public static final ElementType FIND_FRIENDS_BUTTON;
    public static final ElementType FIND_FRIENDS_BUTTON_ADDRESS_BOOK;
    public static final ElementType FIND_FRIENDS_BUTTON_FACEBOOK;
    public static final ElementType FIND_FRIENDS_BUTTON_FB_MESSENGER;
    public static final ElementType FIND_FRIENDS_BUTTON_LINE;
    public static final ElementType FIND_FRIENDS_BUTTON_MORE;
    public static final ElementType FIND_FRIENDS_BUTTON_TWITTER;
    public static final ElementType FIND_FRIENDS_BUTTON_WHATSAPP;
    public static final ElementType FIND_IMAGES_BUTTON;
    public static final ElementType FIND_MORE_BOARDS_BUTTON;
    public static final ElementType FLEXIBLE_NUX_LAUNCHER;
    public static final ElementType FLOWED_INTEREST;
    public static final ElementType FOLLOWERS_BUTTON;
    public static final ElementType FOLLOWING_BOARDS_BUTTON;
    public static final ElementType FOLLOWING_BUTTON;
    public static final ElementType FOLLOWING_INTERESTS_BUTTON;
    public static final ElementType FOLLOWING_PINNERS_BUTTON;
    public static final ElementType FOLLOW_ALL_USERS_BUTTON;
    public static final ElementType FOLLOW_BOARDS_BUTTON;
    public static final ElementType GALLERY_BUTTON;
    public static final ElementType GENDER_BUTTON;
    public static final ElementType GET_STARTED_BUTTON;
    public static final ElementType GPLUS_CONNECT;
    public static final ElementType GPLUS_INVITE_BUTTON;
    public static final ElementType HASH_TAG;
    public static final ElementType HELP_BUTTON;
    public static final ElementType HELP_CENTER_BUTTON;
    public static final ElementType HELP_FLYOUT_BUTTON;
    public static final ElementType HELP_PULSE;
    public static final ElementType INSTALL_EXTENSION_BUTTON;
    public static final ElementType INTEREST_PIN_ANNOTATION;
    public static final ElementType INTEREST_SUGGESTION;
    public static final ElementType INVITE_ALL_TOGGLE;
    public static final ElementType INVITE_BUTTON;
    public static final ElementType INVITE_DELETE_BUTTON;
    public static final ElementType LANGUAGE_BUTTON;
    public static final ElementType LIKES_BUTTON;
    public static final ElementType LINK_OUT_BUTTON;
    public static final ElementType LOCATION_BUTTON;
    public static final ElementType LOGIN_BUTTON;
    public static final ElementType LOGO;
    public static final ElementType LOGOUT_BUTTON;
    public static final ElementType LOOKBOOK_PROFILE_IMAGE;
    public static final ElementType LOOKBOOK_TAG;
    public static final ElementType MAP_ADD_BUTTON;
    public static final ElementType MAP_ANNOTATION;
    public static final ElementType MAP_DIRECTIONS_BUTTON;
    public static final ElementType MAP_PIN_ICON;
    public static final ElementType MAP_SEE_ON_MAP_BUTTON;
    public static final ElementType MAP_TOGGLE_BUTTON;
    public static final ElementType MENU_BUTTON;
    public static final ElementType MORE_INFO_BUTTON;
    public static final ElementType MORE_PINS_BUTTON;
    public static final ElementType MOVE_PINS_BUTTON;
    public static final ElementType NAME_BUTTON;
    public static final ElementType NAVIGATION_DISCOVER_BUTTON;
    public static final ElementType NAVIGATION_HOME_BUTTON;
    public static final ElementType NAVIGATION_LOGO_BUTTON;
    public static final ElementType NEWS_BUTTON;
    public static final ElementType NEWS_FEED_ACTOR_IMAGE;
    public static final ElementType NEWS_FEED_ACTOR_LABEL;
    public static final ElementType NEWS_FEED_ANSWER;
    public static final ElementType NEWS_FEED_BOARD;
    public static final ElementType NEWS_FEED_PIN;
    public static final ElementType NEWS_FEED_QUESTION;
    public static final ElementType NEWS_FEED_REPLY;
    public static final ElementType NEWS_FEED_USER;
    public static final ElementType NEXT_BUTTON;
    public static final ElementType NOTIFICATIONS_ICON;
    public static final ElementType PERSONALIZED_RECOMMENDATIONS_BUTTON;
    public static final ElementType PFY_REASON_BUTTON;
    public static final ElementType PHONE_BUTTON;
    public static final ElementType PHOTOS_BUTTON;
    public static final ElementType PINPICKS_ICON;
    public static final ElementType PINVITATIONAL_REQUEST_INVITE_SUBMITTED;
    public static final ElementType PIN_ATTRIBUTION;
    public static final ElementType PIN_BOARD;
    public static final ElementType PIN_BOARD_FOLLOW;
    public static final ElementType PIN_BOARD_PIN;
    public static final ElementType PIN_CAPTION_COMMENT;
    public static final ElementType PIN_CELL_BUTTON_PFY_PIN_SOURCE;
    public static final ElementType PIN_CELL_BUTTON_PROMOTED_PIN_SOURCE;
    public static final ElementType PIN_COMMENT_BUTTON;
    public static final ElementType PIN_DELETE_BUTTON;
    public static final ElementType PIN_DESCRIPTION;
    public static final ElementType PIN_DOMAIN;
    public static final ElementType PIN_EDIT_BUTTON;
    public static final ElementType PIN_FEEDBACK_BUTTON_PFY;
    public static final ElementType PIN_FEEDBACK_BUTTON_PROMOTED;
    public static final ElementType PIN_FEEDBACK_BUTTON_STATE_REASON_PFY;
    public static final ElementType PIN_FEEDBACK_BUTTON_STATE_REASON_PROMOTED;
    public static final ElementType PIN_FEEDBACK_DIALOG_BUTTON_DISMISS;
    public static final ElementType PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY;
    public static final ElementType PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED;
    public static final ElementType PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED;
    public static final ElementType PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD;
    public static final ElementType PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED;
    public static final ElementType PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE;
    public static final ElementType PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE;
    public static final ElementType PIN_FLAG_BUTTON;
    public static final ElementType PIN_INTEREST;
    public static final ElementType PIN_LIKER;
    public static final ElementType PIN_LIKE_BUTTON;
    public static final ElementType PIN_ORIGINAL_BOARD;
    public static final ElementType PIN_ORIGINAL_BOARD_FOLLOW;
    public static final ElementType PIN_ORIGINAL_BOARD_PIN;
    public static final ElementType PIN_PINNED_TO;
    public static final ElementType PIN_PROMOTED_INFO;
    public static final ElementType PIN_READING_LIST_BUTTON;
    public static final ElementType PIN_RELATED_PIN;
    public static final ElementType PIN_REPIN_BUTTON;
    public static final ElementType PIN_REPORT_BUTTON;
    public static final ElementType PIN_RICH_PIN_ACTION_BUTTON;
    public static final ElementType PIN_SAVE_BUTTON;
    public static final ElementType PIN_SEND_BUTTON;
    public static final ElementType PIN_SHARE;
    public static final ElementType PIN_SHARE_BUTTON;
    public static final ElementType PIN_SHARE_EMAIL_BUTTON;
    public static final ElementType PIN_SHARE_FACEBOOK_BUTTON;
    public static final ElementType PIN_SHARE_FB_MESSENGER;
    public static final ElementType PIN_SHARE_MESSAGE;
    public static final ElementType PIN_SHARE_THIRD_PARTY_EXTENSION;
    public static final ElementType PIN_SHARE_TWITTER_BUTTON;
    public static final ElementType PIN_SHARE_WHATSAPP;
    public static final ElementType PIN_SOURCE_IMAGE;
    public static final ElementType PIN_SUBMIT;
    public static final ElementType PIN_UPLOAD_BUTTON;
    public static final ElementType PIN_USER;
    public static final ElementType PIN_VIA;
    public static final ElementType PIN_VIA_PIN;
    public static final ElementType PLACES_BUTTON;
    public static final ElementType PLACES_LIST_PLACE;
    public static final ElementType PLACE_IMAGE;
    public static final ElementType PLACE_PICKER_CREATE;
    public static final ElementType PLACE_PICKER_IMAGE;
    public static final ElementType PROFILE_BUTTON;
    public static final ElementType PROFILE_FACEBOOK;
    public static final ElementType PROFILE_IMAGE;
    public static final ElementType PROFILE_TWITTER;
    public static final ElementType PROFILE_URL;
    public static final ElementType PROMOTED_OK_BUTTON;
    public static final ElementType PUSH_NOTIFICATIONS_BUTTON;
    public static final ElementType RAKUTEN_CONNECT;
    public static final ElementType RECENT_SEARCH_SUGGESTION;
    public static final ElementType REFRESH_BUTTON;
    public static final ElementType RELATED_INTEREST;
    public static final ElementType RELATED_RICH_PIN_BUTTON;
    public static final ElementType REMOVE_BUTTON;
    public static final ElementType REMOVE_PLACE_BUTTON;
    public static final ElementType REMOVE_SUGGESTED_USER_BUTTON;
    public static final ElementType REPINS_BUTTON;
    public static final ElementType REPIN_ADD_PLACE_BUTTON;
    public static final ElementType REPIN_EDIT_PLACE_BUTTON;
    public static final ElementType REPIN_SUGGESTED_BOARD;
    public static final ElementType RESET_BUTTON;
    public static final ElementType RETRY_BUTTON;
    public static final ElementType RIBBON_BUTTON;
    public static final ElementType RICH_ACTION_BUTTON;
    public static final ElementType SAFARI_KEYCHAIN_NOT_NOW_BUTTON;
    public static final ElementType SAFARI_KEYCHAIN_USE_PASSWORD_BUTTON;
    public static final ElementType SAVE_USER_SETTINGS_BUTTON;
    public static final ElementType SEARCH_ACTION_SUGGESTION;
    public static final ElementType SEARCH_ALL_WITH_QUERY;
    public static final ElementType SEARCH_BOARDS_BUTTON;
    public static final ElementType SEARCH_BOX_ADD_TOKEN_BUTTON;
    public static final ElementType SEARCH_BOX_TEXT_INPUT;
    public static final ElementType SEARCH_BUTTON;
    public static final ElementType SEARCH_FILTER_DROPDOWNBUTTON;
    public static final ElementType SEARCH_FILTER_SUGGESTION;
    public static final ElementType SEARCH_GUIDE_SUGGESTION;
    public static final ElementType SEARCH_MY_PINS_BUTTON;
    public static final ElementType SEARCH_PINNERS_BUTTON;
    public static final ElementType SEARCH_PINS_BUTTON;
    public static final ElementType SEARCH_PLACES_BUTTON;
    public static final ElementType SEARCH_PRIVACY_BUTTON;
    public static final ElementType SEARCH_PRIVACY_LINK;
    public static final ElementType SEARCH_RELATED_CATEGORY;
    public static final ElementType SEARCH_RELATED_QUERY;
    public static final ElementType SEARCH_TOKEN;
    public static final ElementType SEE_MORE_BUTTON;
    public static final ElementType SEE_OTHER_PINS_BUTTON;
    public static final ElementType SEND_BUTTON;
    public static final ElementType SEND_INVITE_BUTTON;
    public static final ElementType SEND_SMS_INVITE_BUTTON;
    public static final ElementType SEND_SOCIAL_BUTTON;
    public static final ElementType SEND_TO_PINNER_BUTTON;
    public static final ElementType SETTINGS_BUTTON;
    public static final ElementType SHARE_EXTENSION_BOARD_CELL;
    public static final ElementType SHARE_EXTENSION_IMAGE;
    public static final ElementType SHARE_EXTENSION_PICK_BOARD_CELL;
    public static final ElementType SHARE_EXTENSION_PIN_IT_BUTTON;
    public static final ElementType SHARE_SOCIAL_BUTTON;
    public static final ElementType SHOW_PASSWORD_BUTTON;
    public static final ElementType SIGNUP_BUTTON;
    public static final ElementType SIGNUP_TRENDING_PREVIEW_BUTTON;
    public static final ElementType SINGLE_PIN_POPOVER;
    public static final ElementType STORIES_FEED_ACTOR;
    public static final ElementType STORIES_FEED_ACTOR_IMAGE;
    public static final ElementType STORIES_FEED_LARGE_STORY;
    public static final ElementType STORIES_FEED_RELATED_MORE_CELL;
    public static final ElementType STORIES_FEED_RELATED_OBJECT;
    public static final ElementType STORIES_FEED_SMALL_STORY;
    public static final ElementType SUGGESTED_EMAIL;
    public static final ElementType SUGGESTED_USER;
    public static final ElementType SUGGEST_INTEREST_BUTTON;
    public static final ElementType SUPPORT_BUTTON;
    public static final ElementType TOS_BUTTON;
    public static final ElementType TWITTER_CONNECT;
    public static final ElementType UNDO_BUTTON;
    public static final ElementType UNFOLLOW_BOARDS_BUTTON;
    public static final ElementType UPDATE_BUTTON;
    public static final ElementType UPLOAD_PIN_BUTTON;
    public static final ElementType USERNAME_BUTTON;
    public static final ElementType USER_ABOUT_BUTTON;
    public static final ElementType USER_ABOUT_EDIT_BUTTON;
    public static final ElementType USER_BLOCK_BUTTON;
    public static final ElementType USER_BOARDS_BUTTON;
    public static final ElementType USER_EDIT_BUTTON;
    public static final ElementType USER_FEED_FOLLOW;
    public static final ElementType USER_FEED_INVITE_CUSTOM_EMAIL;
    public static final ElementType USER_FEED_INVITE_EMAIL;
    public static final ElementType USER_FEED_INVITE_SMS;
    public static final ElementType USER_FLAG_BUTTON;
    public static final ElementType USER_FOLLOW;
    public static final ElementType USER_ICON;
    public static final ElementType USER_LIKES_BUTTON;
    public static final ElementType USER_LIST_CONTACT;
    public static final ElementType USER_LIST_USER;
    public static final ElementType USER_PINS_BUTTON;
    public static final ElementType USER_RECENT_CONTACT;
    public static final ElementType USER_REPORT_BUTTON;
    public static final ElementType USER_UNBLOCK_BUTTON;
    public static final ElementType USER_URL_EDIT_BUTTON;
    public static final ElementType VISUAL_OBJECT_BUTTON;
    public static final ElementType VISUAL_SEARCH_BUTTON;
    public static final ElementType WEBSITE_BUTTON;
    public static final ElementType WEB_PIN_CREATE_BOARD_FILTER;
    public static final ElementType WEB_PIN_CREATE_CREATE_BOARD_NAME;
    public static final ElementType WEB_PIN_CREATE_CREATE_BOARD_NO_NAME;
    public static final ElementType WEB_PIN_CREATE_EDIT_DESCRIPTION;
    public static final ElementType WEB_PIN_CREATE_FILTER_BOARDS_VIA_SEARCH;
    public static final ElementType WHO_CAN_PIN_BUTTON;
    public static final ElementType YOUR_PROFILE_BUTTON;
    public static final ElementType YOUR_SETTINGS_BUTTON;
    private final int value;

    private ElementType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ElementType findByValue(int i)
    {
        switch (i)
        {
        case 169: 
        case 182: 
        case 183: 
        case 184: 
        case 185: 
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
        case 198: 
        case 199: 
        case 200: 
        case 235: 
        case 236: 
        case 237: 
        case 238: 
        case 239: 
        case 279: 
        case 312: 
        case 313: 
        case 315: 
        case 320: 
        case 321: 
        case 322: 
        case 323: 
        case 324: 
        case 325: 
        case 326: 
        case 327: 
        case 328: 
        case 329: 
        case 330: 
        case 358: 
        case 359: 
        case 360: 
        case 361: 
        case 362: 
        case 363: 
        case 364: 
        case 365: 
        case 366: 
        case 367: 
        case 368: 
        case 369: 
        case 370: 
        case 371: 
        case 372: 
        case 373: 
        case 374: 
        case 375: 
        case 376: 
        case 377: 
        case 378: 
        case 379: 
        case 380: 
        case 381: 
        case 382: 
        case 383: 
        case 384: 
        case 385: 
        case 386: 
        case 387: 
        case 388: 
        case 389: 
        case 390: 
        case 391: 
        case 392: 
        case 393: 
        case 394: 
        case 395: 
        case 396: 
        case 397: 
        case 398: 
        case 399: 
        case 405: 
        case 406: 
        case 407: 
        case 408: 
        case 409: 
        case 410: 
        case 411: 
        case 412: 
        case 413: 
        case 414: 
        case 415: 
        case 416: 
        case 417: 
        case 418: 
        case 419: 
        case 420: 
        case 421: 
        case 422: 
        case 423: 
        case 424: 
        case 425: 
        case 426: 
        case 427: 
        case 428: 
        case 429: 
        case 430: 
        case 431: 
        case 432: 
        case 433: 
        case 434: 
        case 435: 
        case 436: 
        case 437: 
        case 438: 
        case 439: 
        case 440: 
        case 441: 
        case 442: 
        case 443: 
        case 444: 
        case 445: 
        case 446: 
        case 447: 
        case 448: 
        case 449: 
        case 459: 
        case 460: 
        case 461: 
        case 462: 
        case 463: 
        case 464: 
        case 465: 
        case 466: 
        case 467: 
        case 468: 
        case 469: 
        case 470: 
        case 471: 
        case 472: 
        case 473: 
        case 474: 
        case 475: 
        case 476: 
        case 477: 
        case 478: 
        case 479: 
        case 480: 
        case 481: 
        case 482: 
        case 483: 
        case 484: 
        case 485: 
        case 486: 
        case 487: 
        case 488: 
        case 489: 
        case 490: 
        case 491: 
        case 492: 
        case 493: 
        case 494: 
        case 495: 
        case 496: 
        case 497: 
        case 498: 
        case 499: 
        case 501: 
        case 502: 
        case 503: 
        case 504: 
        case 505: 
        case 506: 
        case 507: 
        case 508: 
        case 509: 
        case 510: 
        case 511: 
        case 512: 
        case 513: 
        case 514: 
        case 515: 
        case 516: 
        case 517: 
        case 518: 
        case 519: 
        case 520: 
        case 521: 
        case 522: 
        case 523: 
        case 524: 
        case 525: 
        case 526: 
        case 527: 
        case 528: 
        case 529: 
        case 530: 
        case 531: 
        case 532: 
        case 533: 
        case 534: 
        case 535: 
        case 536: 
        case 537: 
        case 538: 
        case 539: 
        case 540: 
        case 541: 
        case 542: 
        case 543: 
        case 544: 
        case 545: 
        case 546: 
        case 547: 
        case 548: 
        case 549: 
        case 550: 
        case 551: 
        case 552: 
        case 553: 
        case 554: 
        case 555: 
        case 556: 
        case 557: 
        case 558: 
        case 559: 
        case 560: 
        case 561: 
        case 562: 
        case 563: 
        case 564: 
        case 565: 
        case 566: 
        case 567: 
        case 568: 
        case 569: 
        case 570: 
        case 571: 
        case 572: 
        case 573: 
        case 574: 
        case 575: 
        case 576: 
        case 577: 
        case 578: 
        case 579: 
        case 580: 
        case 581: 
        case 582: 
        case 583: 
        case 584: 
        case 585: 
        case 586: 
        case 587: 
        case 588: 
        case 589: 
        case 590: 
        case 591: 
        case 592: 
        case 593: 
        case 594: 
        case 595: 
        case 596: 
        case 597: 
        case 598: 
        case 599: 
        case 601: 
        case 602: 
        case 607: 
        case 608: 
        case 609: 
        case 611: 
        case 612: 
        case 613: 
        case 614: 
        case 615: 
        case 616: 
        case 617: 
        case 618: 
        case 619: 
        case 620: 
        case 621: 
        case 622: 
        case 623: 
        case 624: 
        case 625: 
        case 626: 
        case 627: 
        case 628: 
        case 629: 
        case 630: 
        case 631: 
        case 632: 
        case 633: 
        case 634: 
        case 635: 
        case 636: 
        case 637: 
        case 638: 
        case 639: 
        case 640: 
        case 641: 
        case 642: 
        case 643: 
        case 644: 
        case 645: 
        case 646: 
        case 647: 
        case 648: 
        case 649: 
        case 650: 
        case 651: 
        case 652: 
        case 653: 
        case 654: 
        case 655: 
        case 656: 
        case 657: 
        case 658: 
        case 659: 
        case 660: 
        case 661: 
        case 662: 
        case 663: 
        case 664: 
        case 665: 
        case 666: 
        case 667: 
        case 668: 
        case 669: 
        case 670: 
        case 671: 
        case 672: 
        case 673: 
        case 674: 
        case 675: 
        case 676: 
        case 677: 
        case 678: 
        case 679: 
        case 680: 
        case 681: 
        case 682: 
        case 683: 
        case 684: 
        case 685: 
        case 686: 
        case 687: 
        case 688: 
        case 689: 
        case 690: 
        case 691: 
        case 692: 
        case 693: 
        case 694: 
        case 695: 
        case 696: 
        case 697: 
        case 698: 
        case 699: 
        case 704: 
        default:
            return null;

        case 0: // '\0'
            return PIN_REPIN_BUTTON;

        case 1: // '\001'
            return PIN_LIKE_BUTTON;

        case 2: // '\002'
            return PIN_COMMENT_BUTTON;

        case 3: // '\003'
            return PIN_EDIT_BUTTON;

        case 72: // 'H'
            return PIN_SHARE_BUTTON;

        case 4: // '\004'
            return PIN_CAPTION_COMMENT;

        case 5: // '\005'
            return PIN_BOARD;

        case 6: // '\006'
            return PIN_BOARD_FOLLOW;

        case 7: // '\007'
            return PIN_BOARD_PIN;

        case 8: // '\b'
            return PIN_ORIGINAL_BOARD;

        case 9: // '\t'
            return PIN_ORIGINAL_BOARD_FOLLOW;

        case 10: // '\n'
            return PIN_ORIGINAL_BOARD_PIN;

        case 11: // '\013'
            return PIN_VIA_PIN;

        case 12: // '\f'
            return PIN_VIA;

        case 148: 
            return PIN_RELATED_PIN;

        case 255: 
            return PIN_INTEREST;

        case 13: // '\r'
            return SUGGESTED_USER;

        case 14: // '\016'
            return REMOVE_SUGGESTED_USER_BUTTON;

        case 15: // '\017'
            return NEWS_FEED_PIN;

        case 16: // '\020'
            return NEWS_FEED_USER;

        case 17: // '\021'
            return REPIN_SUGGESTED_BOARD;

        case 18: // '\022'
            return PIN_UPLOAD_BUTTON;

        case 19: // '\023'
            return LOGOUT_BUTTON;

        case 20: // '\024'
            return FOLLOW_ALL_USERS_BUTTON;

        case 21: // '\025'
            return FACEBOOK_TIMELINE_CONNECT;

        case 22: // '\026'
            return BOARD_CREATE;

        case 23: // '\027'
            return BOARD_CREATE_SUGGESTED;

        case 24: // '\030'
            return ANALYTICS_BUTTON;

        case 25: // '\031'
            return PIN_DOMAIN;

        case 26: // '\032'
            return PIN_USER;

        case 27: // '\033'
            return PIN_ATTRIBUTION;

        case 28: // '\034'
            return PIN_LIKER;

        case 29: // '\035'
            return PIN_PINNED_TO;

        case 30: // '\036'
            return LOGIN_BUTTON;

        case 31: // '\037'
            return SIGNUP_BUTTON;

        case 32: // ' '
            return RETRY_BUTTON;

        case 33: // '!'
            return RESET_BUTTON;

        case 34: // '"'
            return BACK_BUTTON;

        case 35: // '#'
            return PIN_SOURCE_IMAGE;

        case 36: // '$'
            return BOARD_COVER;

        case 37: // '%'
            return BOARD_FOLLOW;

        case 38: // '&'
            return CATEGORY_ICON;

        case 341: 
            return PINPICKS_ICON;

        case 39: // '\''
            return NEWS_FEED_BOARD;

        case 40: // '('
            return PROFILE_BUTTON;

        case 41: // ')'
            return FOLLOWING_BUTTON;

        case 42: // '*'
            return FOLLOWERS_BUTTON;

        case 43: // '+'
            return SEARCH_BUTTON;

        case 44: // ','
            return CREATE_BUTTON;

        case 45: // '-'
            return REFRESH_BUTTON;

        case 46: // '.'
            return PIN_SHARE;

        case 47: // '/'
            return PIN_REPORT_BUTTON;

        case 256: 
            return PIN_SHARE_TWITTER_BUTTON;

        case 257: 
            return PIN_SHARE_FACEBOOK_BUTTON;

        case 258: 
            return PIN_SHARE_EMAIL_BUTTON;

        case 259: 
            return PIN_READING_LIST_BUTTON;

        case 48: // '0'
            return PIN_SAVE_BUTTON;

        case 49: // '1'
            return PIN_DELETE_BUTTON;

        case 98: // 'b'
            return PIN_SEND_BUTTON;

        case 50: // '2'
            return BOARD_DELETE_BUTTON;

        case 97: // 'a'
            return BOARD_LEAVE_BUTTON;

        case 81: // 'Q'
            return BOARD_EDIT_BUTTON;

        case 51: // '3'
            return BOARD_CATEGORY;

        case 52: // '4'
            return BOARD_NAME;

        case 53: // '5'
            return BOARD_SECRET;

        case 54: // '6'
            return CAMERA_BUTTON;

        case 55: // '7'
            return GALLERY_BUTTON;

        case 56: // '8'
            return FIND_IMAGES_BUTTON;

        case 57: // '9'
            return SETTINGS_BUTTON;

        case 58: // ':'
            return FINDFRIENDS_BUTTON;

        case 59: // ';'
            return INVITE_BUTTON;

        case 60: // '<'
            return SUPPORT_BUTTON;

        case 61: // '='
            return TOS_BUTTON;

        case 62: // '>'
            return USER_FOLLOW;

        case 63: // '?'
            return PROFILE_IMAGE;

        case 64: // '@'
            return PROFILE_URL;

        case 65: // 'A'
            return PROFILE_FACEBOOK;

        case 66: // 'B'
            return PROFILE_TWITTER;

        case 67: // 'C'
            return BOARD_PICKER;

        case 68: // 'D'
            return FACEBOOK_CONNECT;

        case 69: // 'E'
            return TWITTER_CONNECT;

        case 151: 
            return RAKUTEN_CONNECT;

        case 208: 
            return GPLUS_CONNECT;

        case 70: // 'F'
            return PIN_SUBMIT;

        case 71: // 'G'
            return USER_FEED_FOLLOW;

        case 73: // 'I'
            return CANCEL_BUTTON;

        case 74: // 'J'
            return MENU_BUTTON;

        case 75: // 'K'
            return CLOSE_BUTTON;

        case 76: // 'L'
            return DONE_BUTTON;

        case 77: // 'M'
            return NEWS_BUTTON;

        case 78: // 'N'
            return EXPLORE_BUTTON;

        case 79: // 'O'
            return BROWSER_BUTTON;

        case 80: // 'P'
            return USER_FLAG_BUTTON;

        case 82: // 'R'
            return USER_LIKES_BUTTON;

        case 83: // 'S'
            return USER_PINS_BUTTON;

        case 84: // 'T'
            return USER_BOARDS_BUTTON;

        case 85: // 'U'
            return USER_ABOUT_BUTTON;

        case 94: // '^'
            return USER_EDIT_BUTTON;

        case 96: // '`'
            return NEXT_BUTTON;

        case 99: // 'c'
            return ADD_MESSAGE_BUTTON;

        case 100: // 'd'
            return COPY_LINK_BUTTON;

        case 101: // 'e'
            return CLIPBOARD_BUTTON;

        case 102: // 'f'
            return CLEAR_HISTORY_BUTTON;

        case 103: // 'g'
            return SEND_BUTTON;

        case 146: 
            return NAVIGATION_HOME_BUTTON;

        case 147: 
            return NAVIGATION_DISCOVER_BUTTON;

        case 149: 
            return PHOTOS_BUTTON;

        case 86: // 'V'
            return DECLINE_BUTTON;

        case 87: // 'W'
            return USER_BLOCK_BUTTON;

        case 88: // 'X'
            return USER_UNBLOCK_BUTTON;

        case 89: // 'Y'
            return USER_REPORT_BUTTON;

        case 90: // 'Z'
            return BOARD_CREATE_SECRET;

        case 91: // '['
            return USER_ABOUT_EDIT_BUTTON;

        case 92: // '\\'
            return USER_URL_EDIT_BUTTON;

        case 93: // ']'
            return BOARD_DESCRIPTION;

        case 95: // '_'
            return EDUCATION_TARGET;

        case 109: // 'm'
            return BROWSER_WEB_IMAGE;

        case 104: // 'h'
            return AUTOCOMPLETE_SUGGESTION;

        case 105: // 'i'
            return FIND_MORE_BOARDS_BUTTON;

        case 106: // 'j'
            return GET_STARTED_BUTTON;

        case 107: // 'k'
            return REMOVE_BUTTON;

        case 108: // 'l'
            return WHO_CAN_PIN_BUTTON;

        case 110: // 'n'
            return PIN_RICH_PIN_ACTION_BUTTON;

        case 111: // 'o'
            return USER_RECENT_CONTACT;

        case 112: // 'p'
            return USER_LIST_USER;

        case 113: // 'q'
            return UNDO_BUTTON;

        case 114: // 'r'
            return CLEAR_SEARCHES_BUTTON;

        case 115: // 's'
            return CLEAR_CONTACTS_BUTTON;

        case 116: // 't'
            return PIN_DESCRIPTION;

        case 117: // 'u'
            return EDIT_HOME_FEED_BUTTON;

        case 118: // 'v'
            return FOLLOW_BOARDS_BUTTON;

        case 119: // 'w'
            return UNFOLLOW_BOARDS_BUTTON;

        case 120: // 'x'
            return DUPLICATE_PIN_WARNING;

        case 121: // 'y'
            return SUGGESTED_EMAIL;

        case 122: // 'z'
            return USERNAME_BUTTON;

        case 123: // '{'
            return EMAIL_BUTTON;

        case 124: // '|'
            return COUNTRY_BUTTON;

        case 125: // '}'
            return PUSH_NOTIFICATIONS_BUTTON;

        case 126: // '~'
            return UPDATE_BUTTON;

        case 127: // '\177'
            return CATEGORY_RECENT;

        case 240: 
            return LANGUAGE_BUTTON;

        case 241: 
            return GENDER_BUTTON;

        case 242: 
            return PERSONALIZED_RECOMMENDATIONS_BUTTON;

        case 243: 
            return SEARCH_PRIVACY_BUTTON;

        case 128: 
            return CHANGE_PASSWORD_BUTTON;

        case 129: 
            return SHOW_PASSWORD_BUTTON;

        case 130: 
            return SAVE_USER_SETTINGS_BUTTON;

        case 131: 
            return RIBBON_BUTTON;

        case 132: 
            return USER_LIST_CONTACT;

        case 133: 
            return USER_FEED_INVITE_EMAIL;

        case 134: 
            return USER_FEED_INVITE_SMS;

        case 135: 
            return USER_FEED_INVITE_CUSTOM_EMAIL;

        case 136: 
            return NAME_BUTTON;

        case 137: 
            return APP_ICON;

        case 138: 
            return USER_ICON;

        case 139: 
            return NOTIFICATIONS_ICON;

        case 140: 
            return SEE_OTHER_PINS_BUTTON;

        case 141: 
            return MORE_PINS_BUTTON;

        case 142: 
            return PIN_PROMOTED_INFO;

        case 143: 
            return PROMOTED_OK_BUTTON;

        case 144: 
            return LINK_OUT_BUTTON;

        case 145: 
            return PFY_REASON_BUTTON;

        case 150: 
            return INVITE_DELETE_BUTTON;

        case 152: 
            return FEED_SUBCATEGORY;

        case 153: 
            return DISCOVER_TRENDING_CATEGORY;

        case 154: 
            return MAP_ANNOTATION;

        case 155: 
            return MAP_SEE_ON_MAP_BUTTON;

        case 156: 
            return MAP_DIRECTIONS_BUTTON;

        case 157: 
            return MAP_ADD_BUTTON;

        case 158: 
            return PLACES_BUTTON;

        case 159: 
            return LOCATION_BUTTON;

        case 160: 
            return PLACES_LIST_PLACE;

        case 161: 
            return PHONE_BUTTON;

        case 162: 
            return WEBSITE_BUTTON;

        case 163: 
            return PLACE_IMAGE;

        case 164: 
            return MAP_PIN_ICON;

        case 165: 
            return ADD_PLACE_BUTTON;

        case 166: 
            return PLACE_PICKER_CREATE;

        case 167: 
            return PLACE_PICKER_IMAGE;

        case 168: 
            return REMOVE_PLACE_BUTTON;

        case 170: 
            return MAP_TOGGLE_BUTTON;

        case 171: 
            return COLLABORATOR_TEXT;

        case 172: 
            return SEND_INVITE_BUTTON;

        case 173: 
            return INVITE_ALL_TOGGLE;

        case 174: 
            return REPINS_BUTTON;

        case 175: 
            return LIKES_BUTTON;

        case 176: 
            return PIN_FLAG_BUTTON;

        case 177: 
            return DOMAIN_URL;

        case 178: 
            return LOGO;

        case 179: 
            return SEE_MORE_BUTTON;

        case 180: 
            return BOARD_RELATED_BOARD;

        case 181: 
            return COMMENTS_BUTTON;

        case 191: 
            return SEARCH_RELATED_QUERY;

        case 192: 
            return SEARCH_RELATED_CATEGORY;

        case 201: 
            return BUY_BUTTON;

        case 202: 
            return FACEBOOK_INVITE_BUTTON;

        case 203: 
            return GPLUS_INVITE_BUTTON;

        case 204: 
            return SEND_TO_PINNER_BUTTON;

        case 205: 
            return APP_RATING_ATTEMPT_BUTTON;

        case 206: 
            return APP_RATING_DECLINE_BUTTON;

        case 207: 
            return APP_RATING_REMIND_BUTTON;

        case 209: 
            return SEND_SMS_INVITE_BUTTON;

        case 210: 
            return COMPOSE_SMS_INVITE_BUTTON;

        case 211: 
            return FLOWED_INTEREST;

        case 212: 
            return REPIN_ADD_PLACE_BUTTON;

        case 213: 
            return REPIN_EDIT_PLACE_BUTTON;

        case 214: 
            return RELATED_RICH_PIN_BUTTON;

        case 215: 
            return BULK_INVITER_BUTTON;

        case 216: 
            return RELATED_INTEREST;

        case 217: 
            return SINGLE_PIN_POPOVER;

        case 218: 
            return NEWS_FEED_QUESTION;

        case 219: 
            return NEWS_FEED_ANSWER;

        case 220: 
            return SEARCH_PINS_BUTTON;

        case 221: 
            return SEARCH_BOARDS_BUTTON;

        case 222: 
            return SEARCH_PINNERS_BUTTON;

        case 223: 
            return SEARCH_MY_PINS_BUTTON;

        case 224: 
            return SEARCH_PLACES_BUTTON;

        case 225: 
            return SEARCH_TOKEN;

        case 226: 
            return SEARCH_GUIDE_SUGGESTION;

        case 227: 
            return SEARCH_BOX_TEXT_INPUT;

        case 228: 
            return SEARCH_BOX_ADD_TOKEN_BUTTON;

        case 229: 
            return ADD_INTEREST_BUTTON;

        case 230: 
            return SUGGEST_INTEREST_BUTTON;

        case 231: 
            return EDUCATION_GUIDED_SEARCH_SUGGESTION;

        case 232: 
            return EDUCATION_GUIDED_SEARCH_COMPLETE_BUTTON;

        case 233: 
            return VISUAL_OBJECT_BUTTON;

        case 234: 
            return VISUAL_SEARCH_BUTTON;

        case 244: 
            return NAVIGATION_LOGO_BUTTON;

        case 245: 
            return MORE_INFO_BUTTON;

        case 246: 
            return YOUR_PROFILE_BUTTON;

        case 247: 
            return YOUR_SETTINGS_BUTTON;

        case 248: 
            return FIND_FRIENDS_BUTTON;

        case 249: 
            return CREATE_BOARD_BUTTON;

        case 250: 
            return ADD_PIN_FROM_WEBSITE_BUTTON;

        case 251: 
            return UPLOAD_PIN_BUTTON;

        case 252: 
            return NEWS_FEED_REPLY;

        case 273: 
            return NEWS_FEED_ACTOR_IMAGE;

        case 274: 
            return NEWS_FEED_ACTOR_LABEL;

        case 253: 
            return RECENT_SEARCH_SUGGESTION;

        case 254: 
            return SEARCH_ALL_WITH_QUERY;

        case 260: 
            return INTEREST_SUGGESTION;

        case 261: 
            return STORIES_FEED_LARGE_STORY;

        case 262: 
            return STORIES_FEED_SMALL_STORY;

        case 263: 
            return STORIES_FEED_ACTOR;

        case 264: 
            return STORIES_FEED_RELATED_OBJECT;

        case 269: 
            return STORIES_FEED_RELATED_MORE_CELL;

        case 272: 
            return STORIES_FEED_ACTOR_IMAGE;

        case 265: 
            return DISCOVER_FEATURED_ITEM;

        case 266: 
            return FOLLOWING_INTERESTS_BUTTON;

        case 267: 
            return FOLLOWING_PINNERS_BUTTON;

        case 268: 
            return FOLLOWING_BOARDS_BUTTON;

        case 270: 
            return HELP_PULSE;

        case 271: 
            return HELP_BUTTON;

        case 299: 
            return HELP_FLYOUT_BUTTON;

        case 275: 
            return CONVERSATION_NEW_BUTTON;

        case 276: 
            return CONVERSATION_CREATE_BUTTON;

        case 277: 
            return CONVERSATION_LIST_ITEM;

        case 278: 
            return CONVERSATION_INBOX_BUTTON;

        case 280: 
            return INSTALL_EXTENSION_BUTTON;

        case 281: 
            return HELP_CENTER_BUTTON;

        case 282: 
            return PIN_CELL_BUTTON_PFY_PIN_SOURCE;

        case 283: 
            return PIN_CELL_BUTTON_PROMOTED_PIN_SOURCE;

        case 284: 
            return PIN_FEEDBACK_BUTTON_PFY;

        case 285: 
            return PIN_FEEDBACK_BUTTON_PROMOTED;

        case 286: 
            return PIN_FEEDBACK_BUTTON_STATE_REASON_PFY;

        case 287: 
            return PIN_FEEDBACK_BUTTON_STATE_REASON_PROMOTED;

        case 288: 
            return PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY;

        case 289: 
            return PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD;

        case 290: 
            return PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED;

        case 291: 
            return PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED;

        case 292: 
            return PIN_FEEDBACK_DIALOG_BUTTON_DISMISS;

        case 293: 
            return PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED;

        case 294: 
            return PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE;

        case 295: 
            return PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE;

        case 296: 
            return DIGEST_PIN;

        case 302: 
            return DIGEST_STORY_HEADER_BUTTON;

        case 303: 
            return DIGEST_STORY_EXPAND_BUTTON;

        case 308: 
            return DIGEST_STORY_FEEDBACK_BUTTON;

        case 309: 
            return DIGEST_STORY_FOLLOW_BUTTON;

        case 351: 
            return DIGEST_STORY_CUSTOM_ACTION_BUTTON;

        case 352: 
            return DIGEST_CAROUSEL_CONTENT_REP;

        case 304: 
            return DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD;

        case 305: 
            return DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST;

        case 306: 
            return DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER;

        case 307: 
            return DIGEST_FEEDBACK_DIALOG_BUTTON_HIDE_THROUGH_BOARD_REC;

        case 297: 
            return LOOKBOOK_TAG;

        case 298: 
            return LOOKBOOK_PROFILE_IMAGE;

        case 300: 
            return SEND_SOCIAL_BUTTON;

        case 301: 
            return SHARE_SOCIAL_BUTTON;

        case 310: 
            return SAFARI_KEYCHAIN_USE_PASSWORD_BUTTON;

        case 311: 
            return SAFARI_KEYCHAIN_NOT_NOW_BUTTON;

        case 314: 
            return SIGNUP_TRENDING_PREVIEW_BUTTON;

        case 316: 
            return PIN_SHARE_MESSAGE;

        case 317: 
            return PIN_SHARE_WHATSAPP;

        case 318: 
            return PIN_SHARE_FB_MESSENGER;

        case 319: 
            return PIN_SHARE_THIRD_PARTY_EXTENSION;

        case 331: 
            return BOARD_SHARE_BUTTON;

        case 332: 
            return BOARD_SHARE_FACEBOOK_BUTTON;

        case 333: 
            return BOARD_SHARE_EMAIL_BUTTON;

        case 334: 
            return BOARD_SHARE_COPY_LINK_BUTTON;

        case 335: 
            return BOARD_SHARE_OTHER_BUTTON;

        case 336: 
            return SEARCH_ACTION_SUGGESTION;

        case 337: 
            return SEARCH_FILTER_SUGGESTION;

        case 338: 
            return SEARCH_FILTER_DROPDOWNBUTTON;

        case 339: 
            return FLEXIBLE_NUX_LAUNCHER;

        case 340: 
            return INTEREST_PIN_ANNOTATION;

        case 400: 
            return MOVE_PINS_BUTTON;

        case 401: 
            return BULK_MOVE_PINS_BUTTON;

        case 402: 
            return BULK_COPY_PINS_BUTTON;

        case 403: 
            return BULK_DELETE_PINS_BUTTON;

        case 404: 
            return BULK_CANCEL_BUTTON;

        case 450: 
            return ADD_PIN_REP;

        case 451: 
            return ADD_PIN_REP_UPLOAD;

        case 452: 
            return ADD_PIN_REP_SCRAPE;

        case 453: 
            return ADD_PIN_REP_BOOKMARKLET;

        case 454: 
            return ADD_PIN_BUTTON_UPLOAD;

        case 455: 
            return ADD_PIN_BUTTON_SCRAPE;

        case 456: 
            return ADD_PIN_BUTTON_BOOKMARKLET;

        case 457: 
            return ADD_PIN_INSTALL_BOOKMARKLET;

        case 458: 
            return ADD_PIN_CANCEL_INSTALL_BOOKMARKLET;

        case 500: 
            return RICH_ACTION_BUTTON;

        case 600: 
            return WEB_PIN_CREATE_EDIT_DESCRIPTION;

        case 603: 
            return WEB_PIN_CREATE_CREATE_BOARD_NO_NAME;

        case 604: 
            return WEB_PIN_CREATE_CREATE_BOARD_NAME;

        case 605: 
            return WEB_PIN_CREATE_FILTER_BOARDS_VIA_SEARCH;

        case 610: 
            return WEB_PIN_CREATE_BOARD_FILTER;

        case 606: 
            return PINVITATIONAL_REQUEST_INVITE_SUBMITTED;

        case 342: 
            return SEARCH_PRIVACY_LINK;

        case 343: 
            return FIND_FRIENDS_BUTTON_ADDRESS_BOOK;

        case 344: 
            return FIND_FRIENDS_BUTTON_FACEBOOK;

        case 345: 
            return FIND_FRIENDS_BUTTON_TWITTER;

        case 346: 
            return FIND_FRIENDS_BUTTON_MORE;

        case 347: 
            return FIND_FRIENDS_BUTTON_WHATSAPP;

        case 348: 
            return FIND_FRIENDS_BUTTON_FB_MESSENGER;

        case 349: 
            return COMPOSE_EMAIL_INVITE_BUTTON;

        case 350: 
            return FIND_FRIENDS_BUTTON_LINE;

        case 353: 
            return BRAND_SURVEY_DIALOG_YES_BUTTON;

        case 354: 
            return BRAND_SURVEY_DIALOG_LATER_BUTTON;

        case 355: 
            return BRAND_SURVEY_DIALOG_NEVER_BUTTON;

        case 356: 
            return BRAND_SURVEY_DIALOG_BACKGROUND_DISMISS;

        case 357: 
            return HASH_TAG;

        case 700: 
            return SHARE_EXTENSION_PIN_IT_BUTTON;

        case 701: 
            return SHARE_EXTENSION_IMAGE;

        case 702: 
            return SHARE_EXTENSION_PICK_BOARD_CELL;

        case 703: 
            return SHARE_EXTENSION_BOARD_CELL;

        case 705: 
            return AUTOCOMPLETE_SUGGESTION_LC1;

        case 706: 
            return AUTOCOMPLETE_SUGGESTION_LC2;
        }
    }

    public static ElementType valueOf(String s)
    {
        return (ElementType)Enum.valueOf(com/pinterest/schemas/event/ElementType, s);
    }

    public static ElementType[] values()
    {
        return (ElementType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        PIN_REPIN_BUTTON = new ElementType("PIN_REPIN_BUTTON", 0, 0);
        PIN_LIKE_BUTTON = new ElementType("PIN_LIKE_BUTTON", 1, 1);
        PIN_COMMENT_BUTTON = new ElementType("PIN_COMMENT_BUTTON", 2, 2);
        PIN_EDIT_BUTTON = new ElementType("PIN_EDIT_BUTTON", 3, 3);
        PIN_SHARE_BUTTON = new ElementType("PIN_SHARE_BUTTON", 4, 72);
        PIN_CAPTION_COMMENT = new ElementType("PIN_CAPTION_COMMENT", 5, 4);
        PIN_BOARD = new ElementType("PIN_BOARD", 6, 5);
        PIN_BOARD_FOLLOW = new ElementType("PIN_BOARD_FOLLOW", 7, 6);
        PIN_BOARD_PIN = new ElementType("PIN_BOARD_PIN", 8, 7);
        PIN_ORIGINAL_BOARD = new ElementType("PIN_ORIGINAL_BOARD", 9, 8);
        PIN_ORIGINAL_BOARD_FOLLOW = new ElementType("PIN_ORIGINAL_BOARD_FOLLOW", 10, 9);
        PIN_ORIGINAL_BOARD_PIN = new ElementType("PIN_ORIGINAL_BOARD_PIN", 11, 10);
        PIN_VIA_PIN = new ElementType("PIN_VIA_PIN", 12, 11);
        PIN_VIA = new ElementType("PIN_VIA", 13, 12);
        PIN_RELATED_PIN = new ElementType("PIN_RELATED_PIN", 14, 148);
        PIN_INTEREST = new ElementType("PIN_INTEREST", 15, 255);
        SUGGESTED_USER = new ElementType("SUGGESTED_USER", 16, 13);
        REMOVE_SUGGESTED_USER_BUTTON = new ElementType("REMOVE_SUGGESTED_USER_BUTTON", 17, 14);
        NEWS_FEED_PIN = new ElementType("NEWS_FEED_PIN", 18, 15);
        NEWS_FEED_USER = new ElementType("NEWS_FEED_USER", 19, 16);
        REPIN_SUGGESTED_BOARD = new ElementType("REPIN_SUGGESTED_BOARD", 20, 17);
        PIN_UPLOAD_BUTTON = new ElementType("PIN_UPLOAD_BUTTON", 21, 18);
        LOGOUT_BUTTON = new ElementType("LOGOUT_BUTTON", 22, 19);
        FOLLOW_ALL_USERS_BUTTON = new ElementType("FOLLOW_ALL_USERS_BUTTON", 23, 20);
        FACEBOOK_TIMELINE_CONNECT = new ElementType("FACEBOOK_TIMELINE_CONNECT", 24, 21);
        BOARD_CREATE = new ElementType("BOARD_CREATE", 25, 22);
        BOARD_CREATE_SUGGESTED = new ElementType("BOARD_CREATE_SUGGESTED", 26, 23);
        ANALYTICS_BUTTON = new ElementType("ANALYTICS_BUTTON", 27, 24);
        PIN_DOMAIN = new ElementType("PIN_DOMAIN", 28, 25);
        PIN_USER = new ElementType("PIN_USER", 29, 26);
        PIN_ATTRIBUTION = new ElementType("PIN_ATTRIBUTION", 30, 27);
        PIN_LIKER = new ElementType("PIN_LIKER", 31, 28);
        PIN_PINNED_TO = new ElementType("PIN_PINNED_TO", 32, 29);
        LOGIN_BUTTON = new ElementType("LOGIN_BUTTON", 33, 30);
        SIGNUP_BUTTON = new ElementType("SIGNUP_BUTTON", 34, 31);
        RETRY_BUTTON = new ElementType("RETRY_BUTTON", 35, 32);
        RESET_BUTTON = new ElementType("RESET_BUTTON", 36, 33);
        BACK_BUTTON = new ElementType("BACK_BUTTON", 37, 34);
        PIN_SOURCE_IMAGE = new ElementType("PIN_SOURCE_IMAGE", 38, 35);
        BOARD_COVER = new ElementType("BOARD_COVER", 39, 36);
        BOARD_FOLLOW = new ElementType("BOARD_FOLLOW", 40, 37);
        CATEGORY_ICON = new ElementType("CATEGORY_ICON", 41, 38);
        PINPICKS_ICON = new ElementType("PINPICKS_ICON", 42, 341);
        NEWS_FEED_BOARD = new ElementType("NEWS_FEED_BOARD", 43, 39);
        PROFILE_BUTTON = new ElementType("PROFILE_BUTTON", 44, 40);
        FOLLOWING_BUTTON = new ElementType("FOLLOWING_BUTTON", 45, 41);
        FOLLOWERS_BUTTON = new ElementType("FOLLOWERS_BUTTON", 46, 42);
        SEARCH_BUTTON = new ElementType("SEARCH_BUTTON", 47, 43);
        CREATE_BUTTON = new ElementType("CREATE_BUTTON", 48, 44);
        REFRESH_BUTTON = new ElementType("REFRESH_BUTTON", 49, 45);
        PIN_SHARE = new ElementType("PIN_SHARE", 50, 46);
        PIN_REPORT_BUTTON = new ElementType("PIN_REPORT_BUTTON", 51, 47);
        PIN_SHARE_TWITTER_BUTTON = new ElementType("PIN_SHARE_TWITTER_BUTTON", 52, 256);
        PIN_SHARE_FACEBOOK_BUTTON = new ElementType("PIN_SHARE_FACEBOOK_BUTTON", 53, 257);
        PIN_SHARE_EMAIL_BUTTON = new ElementType("PIN_SHARE_EMAIL_BUTTON", 54, 258);
        PIN_READING_LIST_BUTTON = new ElementType("PIN_READING_LIST_BUTTON", 55, 259);
        PIN_SAVE_BUTTON = new ElementType("PIN_SAVE_BUTTON", 56, 48);
        PIN_DELETE_BUTTON = new ElementType("PIN_DELETE_BUTTON", 57, 49);
        PIN_SEND_BUTTON = new ElementType("PIN_SEND_BUTTON", 58, 98);
        BOARD_DELETE_BUTTON = new ElementType("BOARD_DELETE_BUTTON", 59, 50);
        BOARD_LEAVE_BUTTON = new ElementType("BOARD_LEAVE_BUTTON", 60, 97);
        BOARD_EDIT_BUTTON = new ElementType("BOARD_EDIT_BUTTON", 61, 81);
        BOARD_CATEGORY = new ElementType("BOARD_CATEGORY", 62, 51);
        BOARD_NAME = new ElementType("BOARD_NAME", 63, 52);
        BOARD_SECRET = new ElementType("BOARD_SECRET", 64, 53);
        CAMERA_BUTTON = new ElementType("CAMERA_BUTTON", 65, 54);
        GALLERY_BUTTON = new ElementType("GALLERY_BUTTON", 66, 55);
        FIND_IMAGES_BUTTON = new ElementType("FIND_IMAGES_BUTTON", 67, 56);
        SETTINGS_BUTTON = new ElementType("SETTINGS_BUTTON", 68, 57);
        FINDFRIENDS_BUTTON = new ElementType("FINDFRIENDS_BUTTON", 69, 58);
        INVITE_BUTTON = new ElementType("INVITE_BUTTON", 70, 59);
        SUPPORT_BUTTON = new ElementType("SUPPORT_BUTTON", 71, 60);
        TOS_BUTTON = new ElementType("TOS_BUTTON", 72, 61);
        USER_FOLLOW = new ElementType("USER_FOLLOW", 73, 62);
        PROFILE_IMAGE = new ElementType("PROFILE_IMAGE", 74, 63);
        PROFILE_URL = new ElementType("PROFILE_URL", 75, 64);
        PROFILE_FACEBOOK = new ElementType("PROFILE_FACEBOOK", 76, 65);
        PROFILE_TWITTER = new ElementType("PROFILE_TWITTER", 77, 66);
        BOARD_PICKER = new ElementType("BOARD_PICKER", 78, 67);
        FACEBOOK_CONNECT = new ElementType("FACEBOOK_CONNECT", 79, 68);
        TWITTER_CONNECT = new ElementType("TWITTER_CONNECT", 80, 69);
        RAKUTEN_CONNECT = new ElementType("RAKUTEN_CONNECT", 81, 151);
        GPLUS_CONNECT = new ElementType("GPLUS_CONNECT", 82, 208);
        PIN_SUBMIT = new ElementType("PIN_SUBMIT", 83, 70);
        USER_FEED_FOLLOW = new ElementType("USER_FEED_FOLLOW", 84, 71);
        CANCEL_BUTTON = new ElementType("CANCEL_BUTTON", 85, 73);
        MENU_BUTTON = new ElementType("MENU_BUTTON", 86, 74);
        CLOSE_BUTTON = new ElementType("CLOSE_BUTTON", 87, 75);
        DONE_BUTTON = new ElementType("DONE_BUTTON", 88, 76);
        NEWS_BUTTON = new ElementType("NEWS_BUTTON", 89, 77);
        EXPLORE_BUTTON = new ElementType("EXPLORE_BUTTON", 90, 78);
        BROWSER_BUTTON = new ElementType("BROWSER_BUTTON", 91, 79);
        USER_FLAG_BUTTON = new ElementType("USER_FLAG_BUTTON", 92, 80);
        USER_LIKES_BUTTON = new ElementType("USER_LIKES_BUTTON", 93, 82);
        USER_PINS_BUTTON = new ElementType("USER_PINS_BUTTON", 94, 83);
        USER_BOARDS_BUTTON = new ElementType("USER_BOARDS_BUTTON", 95, 84);
        USER_ABOUT_BUTTON = new ElementType("USER_ABOUT_BUTTON", 96, 85);
        USER_EDIT_BUTTON = new ElementType("USER_EDIT_BUTTON", 97, 94);
        NEXT_BUTTON = new ElementType("NEXT_BUTTON", 98, 96);
        ADD_MESSAGE_BUTTON = new ElementType("ADD_MESSAGE_BUTTON", 99, 99);
        COPY_LINK_BUTTON = new ElementType("COPY_LINK_BUTTON", 100, 100);
        CLIPBOARD_BUTTON = new ElementType("CLIPBOARD_BUTTON", 101, 101);
        CLEAR_HISTORY_BUTTON = new ElementType("CLEAR_HISTORY_BUTTON", 102, 102);
        SEND_BUTTON = new ElementType("SEND_BUTTON", 103, 103);
        NAVIGATION_HOME_BUTTON = new ElementType("NAVIGATION_HOME_BUTTON", 104, 146);
        NAVIGATION_DISCOVER_BUTTON = new ElementType("NAVIGATION_DISCOVER_BUTTON", 105, 147);
        PHOTOS_BUTTON = new ElementType("PHOTOS_BUTTON", 106, 149);
        DECLINE_BUTTON = new ElementType("DECLINE_BUTTON", 107, 86);
        USER_BLOCK_BUTTON = new ElementType("USER_BLOCK_BUTTON", 108, 87);
        USER_UNBLOCK_BUTTON = new ElementType("USER_UNBLOCK_BUTTON", 109, 88);
        USER_REPORT_BUTTON = new ElementType("USER_REPORT_BUTTON", 110, 89);
        BOARD_CREATE_SECRET = new ElementType("BOARD_CREATE_SECRET", 111, 90);
        USER_ABOUT_EDIT_BUTTON = new ElementType("USER_ABOUT_EDIT_BUTTON", 112, 91);
        USER_URL_EDIT_BUTTON = new ElementType("USER_URL_EDIT_BUTTON", 113, 92);
        BOARD_DESCRIPTION = new ElementType("BOARD_DESCRIPTION", 114, 93);
        EDUCATION_TARGET = new ElementType("EDUCATION_TARGET", 115, 95);
        BROWSER_WEB_IMAGE = new ElementType("BROWSER_WEB_IMAGE", 116, 109);
        AUTOCOMPLETE_SUGGESTION = new ElementType("AUTOCOMPLETE_SUGGESTION", 117, 104);
        FIND_MORE_BOARDS_BUTTON = new ElementType("FIND_MORE_BOARDS_BUTTON", 118, 105);
        GET_STARTED_BUTTON = new ElementType("GET_STARTED_BUTTON", 119, 106);
        REMOVE_BUTTON = new ElementType("REMOVE_BUTTON", 120, 107);
        WHO_CAN_PIN_BUTTON = new ElementType("WHO_CAN_PIN_BUTTON", 121, 108);
        PIN_RICH_PIN_ACTION_BUTTON = new ElementType("PIN_RICH_PIN_ACTION_BUTTON", 122, 110);
        USER_RECENT_CONTACT = new ElementType("USER_RECENT_CONTACT", 123, 111);
        USER_LIST_USER = new ElementType("USER_LIST_USER", 124, 112);
        UNDO_BUTTON = new ElementType("UNDO_BUTTON", 125, 113);
        CLEAR_SEARCHES_BUTTON = new ElementType("CLEAR_SEARCHES_BUTTON", 126, 114);
        CLEAR_CONTACTS_BUTTON = new ElementType("CLEAR_CONTACTS_BUTTON", 127, 115);
        PIN_DESCRIPTION = new ElementType("PIN_DESCRIPTION", 128, 116);
        EDIT_HOME_FEED_BUTTON = new ElementType("EDIT_HOME_FEED_BUTTON", 129, 117);
        FOLLOW_BOARDS_BUTTON = new ElementType("FOLLOW_BOARDS_BUTTON", 130, 118);
        UNFOLLOW_BOARDS_BUTTON = new ElementType("UNFOLLOW_BOARDS_BUTTON", 131, 119);
        DUPLICATE_PIN_WARNING = new ElementType("DUPLICATE_PIN_WARNING", 132, 120);
        SUGGESTED_EMAIL = new ElementType("SUGGESTED_EMAIL", 133, 121);
        USERNAME_BUTTON = new ElementType("USERNAME_BUTTON", 134, 122);
        EMAIL_BUTTON = new ElementType("EMAIL_BUTTON", 135, 123);
        COUNTRY_BUTTON = new ElementType("COUNTRY_BUTTON", 136, 124);
        PUSH_NOTIFICATIONS_BUTTON = new ElementType("PUSH_NOTIFICATIONS_BUTTON", 137, 125);
        UPDATE_BUTTON = new ElementType("UPDATE_BUTTON", 138, 126);
        CATEGORY_RECENT = new ElementType("CATEGORY_RECENT", 139, 127);
        LANGUAGE_BUTTON = new ElementType("LANGUAGE_BUTTON", 140, 240);
        GENDER_BUTTON = new ElementType("GENDER_BUTTON", 141, 241);
        PERSONALIZED_RECOMMENDATIONS_BUTTON = new ElementType("PERSONALIZED_RECOMMENDATIONS_BUTTON", 142, 242);
        SEARCH_PRIVACY_BUTTON = new ElementType("SEARCH_PRIVACY_BUTTON", 143, 243);
        CHANGE_PASSWORD_BUTTON = new ElementType("CHANGE_PASSWORD_BUTTON", 144, 128);
        SHOW_PASSWORD_BUTTON = new ElementType("SHOW_PASSWORD_BUTTON", 145, 129);
        SAVE_USER_SETTINGS_BUTTON = new ElementType("SAVE_USER_SETTINGS_BUTTON", 146, 130);
        RIBBON_BUTTON = new ElementType("RIBBON_BUTTON", 147, 131);
        USER_LIST_CONTACT = new ElementType("USER_LIST_CONTACT", 148, 132);
        USER_FEED_INVITE_EMAIL = new ElementType("USER_FEED_INVITE_EMAIL", 149, 133);
        USER_FEED_INVITE_SMS = new ElementType("USER_FEED_INVITE_SMS", 150, 134);
        USER_FEED_INVITE_CUSTOM_EMAIL = new ElementType("USER_FEED_INVITE_CUSTOM_EMAIL", 151, 135);
        NAME_BUTTON = new ElementType("NAME_BUTTON", 152, 136);
        APP_ICON = new ElementType("APP_ICON", 153, 137);
        USER_ICON = new ElementType("USER_ICON", 154, 138);
        NOTIFICATIONS_ICON = new ElementType("NOTIFICATIONS_ICON", 155, 139);
        SEE_OTHER_PINS_BUTTON = new ElementType("SEE_OTHER_PINS_BUTTON", 156, 140);
        MORE_PINS_BUTTON = new ElementType("MORE_PINS_BUTTON", 157, 141);
        PIN_PROMOTED_INFO = new ElementType("PIN_PROMOTED_INFO", 158, 142);
        PROMOTED_OK_BUTTON = new ElementType("PROMOTED_OK_BUTTON", 159, 143);
        LINK_OUT_BUTTON = new ElementType("LINK_OUT_BUTTON", 160, 144);
        PFY_REASON_BUTTON = new ElementType("PFY_REASON_BUTTON", 161, 145);
        INVITE_DELETE_BUTTON = new ElementType("INVITE_DELETE_BUTTON", 162, 150);
        FEED_SUBCATEGORY = new ElementType("FEED_SUBCATEGORY", 163, 152);
        DISCOVER_TRENDING_CATEGORY = new ElementType("DISCOVER_TRENDING_CATEGORY", 164, 153);
        MAP_ANNOTATION = new ElementType("MAP_ANNOTATION", 165, 154);
        MAP_SEE_ON_MAP_BUTTON = new ElementType("MAP_SEE_ON_MAP_BUTTON", 166, 155);
        MAP_DIRECTIONS_BUTTON = new ElementType("MAP_DIRECTIONS_BUTTON", 167, 156);
        MAP_ADD_BUTTON = new ElementType("MAP_ADD_BUTTON", 168, 157);
        PLACES_BUTTON = new ElementType("PLACES_BUTTON", 169, 158);
        LOCATION_BUTTON = new ElementType("LOCATION_BUTTON", 170, 159);
        PLACES_LIST_PLACE = new ElementType("PLACES_LIST_PLACE", 171, 160);
        PHONE_BUTTON = new ElementType("PHONE_BUTTON", 172, 161);
        WEBSITE_BUTTON = new ElementType("WEBSITE_BUTTON", 173, 162);
        PLACE_IMAGE = new ElementType("PLACE_IMAGE", 174, 163);
        MAP_PIN_ICON = new ElementType("MAP_PIN_ICON", 175, 164);
        ADD_PLACE_BUTTON = new ElementType("ADD_PLACE_BUTTON", 176, 165);
        PLACE_PICKER_CREATE = new ElementType("PLACE_PICKER_CREATE", 177, 166);
        PLACE_PICKER_IMAGE = new ElementType("PLACE_PICKER_IMAGE", 178, 167);
        REMOVE_PLACE_BUTTON = new ElementType("REMOVE_PLACE_BUTTON", 179, 168);
        MAP_TOGGLE_BUTTON = new ElementType("MAP_TOGGLE_BUTTON", 180, 170);
        COLLABORATOR_TEXT = new ElementType("COLLABORATOR_TEXT", 181, 171);
        SEND_INVITE_BUTTON = new ElementType("SEND_INVITE_BUTTON", 182, 172);
        INVITE_ALL_TOGGLE = new ElementType("INVITE_ALL_TOGGLE", 183, 173);
        REPINS_BUTTON = new ElementType("REPINS_BUTTON", 184, 174);
        LIKES_BUTTON = new ElementType("LIKES_BUTTON", 185, 175);
        PIN_FLAG_BUTTON = new ElementType("PIN_FLAG_BUTTON", 186, 176);
        DOMAIN_URL = new ElementType("DOMAIN_URL", 187, 177);
        LOGO = new ElementType("LOGO", 188, 178);
        SEE_MORE_BUTTON = new ElementType("SEE_MORE_BUTTON", 189, 179);
        BOARD_RELATED_BOARD = new ElementType("BOARD_RELATED_BOARD", 190, 180);
        COMMENTS_BUTTON = new ElementType("COMMENTS_BUTTON", 191, 181);
        SEARCH_RELATED_QUERY = new ElementType("SEARCH_RELATED_QUERY", 192, 191);
        SEARCH_RELATED_CATEGORY = new ElementType("SEARCH_RELATED_CATEGORY", 193, 192);
        BUY_BUTTON = new ElementType("BUY_BUTTON", 194, 201);
        FACEBOOK_INVITE_BUTTON = new ElementType("FACEBOOK_INVITE_BUTTON", 195, 202);
        GPLUS_INVITE_BUTTON = new ElementType("GPLUS_INVITE_BUTTON", 196, 203);
        SEND_TO_PINNER_BUTTON = new ElementType("SEND_TO_PINNER_BUTTON", 197, 204);
        APP_RATING_ATTEMPT_BUTTON = new ElementType("APP_RATING_ATTEMPT_BUTTON", 198, 205);
        APP_RATING_DECLINE_BUTTON = new ElementType("APP_RATING_DECLINE_BUTTON", 199, 206);
        APP_RATING_REMIND_BUTTON = new ElementType("APP_RATING_REMIND_BUTTON", 200, 207);
        SEND_SMS_INVITE_BUTTON = new ElementType("SEND_SMS_INVITE_BUTTON", 201, 209);
        COMPOSE_SMS_INVITE_BUTTON = new ElementType("COMPOSE_SMS_INVITE_BUTTON", 202, 210);
        FLOWED_INTEREST = new ElementType("FLOWED_INTEREST", 203, 211);
        REPIN_ADD_PLACE_BUTTON = new ElementType("REPIN_ADD_PLACE_BUTTON", 204, 212);
        REPIN_EDIT_PLACE_BUTTON = new ElementType("REPIN_EDIT_PLACE_BUTTON", 205, 213);
        RELATED_RICH_PIN_BUTTON = new ElementType("RELATED_RICH_PIN_BUTTON", 206, 214);
        BULK_INVITER_BUTTON = new ElementType("BULK_INVITER_BUTTON", 207, 215);
        RELATED_INTEREST = new ElementType("RELATED_INTEREST", 208, 216);
        SINGLE_PIN_POPOVER = new ElementType("SINGLE_PIN_POPOVER", 209, 217);
        NEWS_FEED_QUESTION = new ElementType("NEWS_FEED_QUESTION", 210, 218);
        NEWS_FEED_ANSWER = new ElementType("NEWS_FEED_ANSWER", 211, 219);
        SEARCH_PINS_BUTTON = new ElementType("SEARCH_PINS_BUTTON", 212, 220);
        SEARCH_BOARDS_BUTTON = new ElementType("SEARCH_BOARDS_BUTTON", 213, 221);
        SEARCH_PINNERS_BUTTON = new ElementType("SEARCH_PINNERS_BUTTON", 214, 222);
        SEARCH_MY_PINS_BUTTON = new ElementType("SEARCH_MY_PINS_BUTTON", 215, 223);
        SEARCH_PLACES_BUTTON = new ElementType("SEARCH_PLACES_BUTTON", 216, 224);
        SEARCH_TOKEN = new ElementType("SEARCH_TOKEN", 217, 225);
        SEARCH_GUIDE_SUGGESTION = new ElementType("SEARCH_GUIDE_SUGGESTION", 218, 226);
        SEARCH_BOX_TEXT_INPUT = new ElementType("SEARCH_BOX_TEXT_INPUT", 219, 227);
        SEARCH_BOX_ADD_TOKEN_BUTTON = new ElementType("SEARCH_BOX_ADD_TOKEN_BUTTON", 220, 228);
        ADD_INTEREST_BUTTON = new ElementType("ADD_INTEREST_BUTTON", 221, 229);
        SUGGEST_INTEREST_BUTTON = new ElementType("SUGGEST_INTEREST_BUTTON", 222, 230);
        EDUCATION_GUIDED_SEARCH_SUGGESTION = new ElementType("EDUCATION_GUIDED_SEARCH_SUGGESTION", 223, 231);
        EDUCATION_GUIDED_SEARCH_COMPLETE_BUTTON = new ElementType("EDUCATION_GUIDED_SEARCH_COMPLETE_BUTTON", 224, 232);
        VISUAL_OBJECT_BUTTON = new ElementType("VISUAL_OBJECT_BUTTON", 225, 233);
        VISUAL_SEARCH_BUTTON = new ElementType("VISUAL_SEARCH_BUTTON", 226, 234);
        NAVIGATION_LOGO_BUTTON = new ElementType("NAVIGATION_LOGO_BUTTON", 227, 244);
        MORE_INFO_BUTTON = new ElementType("MORE_INFO_BUTTON", 228, 245);
        YOUR_PROFILE_BUTTON = new ElementType("YOUR_PROFILE_BUTTON", 229, 246);
        YOUR_SETTINGS_BUTTON = new ElementType("YOUR_SETTINGS_BUTTON", 230, 247);
        FIND_FRIENDS_BUTTON = new ElementType("FIND_FRIENDS_BUTTON", 231, 248);
        CREATE_BOARD_BUTTON = new ElementType("CREATE_BOARD_BUTTON", 232, 249);
        ADD_PIN_FROM_WEBSITE_BUTTON = new ElementType("ADD_PIN_FROM_WEBSITE_BUTTON", 233, 250);
        UPLOAD_PIN_BUTTON = new ElementType("UPLOAD_PIN_BUTTON", 234, 251);
        NEWS_FEED_REPLY = new ElementType("NEWS_FEED_REPLY", 235, 252);
        NEWS_FEED_ACTOR_IMAGE = new ElementType("NEWS_FEED_ACTOR_IMAGE", 236, 273);
        NEWS_FEED_ACTOR_LABEL = new ElementType("NEWS_FEED_ACTOR_LABEL", 237, 274);
        RECENT_SEARCH_SUGGESTION = new ElementType("RECENT_SEARCH_SUGGESTION", 238, 253);
        SEARCH_ALL_WITH_QUERY = new ElementType("SEARCH_ALL_WITH_QUERY", 239, 254);
        INTEREST_SUGGESTION = new ElementType("INTEREST_SUGGESTION", 240, 260);
        STORIES_FEED_LARGE_STORY = new ElementType("STORIES_FEED_LARGE_STORY", 241, 261);
        STORIES_FEED_SMALL_STORY = new ElementType("STORIES_FEED_SMALL_STORY", 242, 262);
        STORIES_FEED_ACTOR = new ElementType("STORIES_FEED_ACTOR", 243, 263);
        STORIES_FEED_RELATED_OBJECT = new ElementType("STORIES_FEED_RELATED_OBJECT", 244, 264);
        STORIES_FEED_RELATED_MORE_CELL = new ElementType("STORIES_FEED_RELATED_MORE_CELL", 245, 269);
        STORIES_FEED_ACTOR_IMAGE = new ElementType("STORIES_FEED_ACTOR_IMAGE", 246, 272);
        DISCOVER_FEATURED_ITEM = new ElementType("DISCOVER_FEATURED_ITEM", 247, 265);
        FOLLOWING_INTERESTS_BUTTON = new ElementType("FOLLOWING_INTERESTS_BUTTON", 248, 266);
        FOLLOWING_PINNERS_BUTTON = new ElementType("FOLLOWING_PINNERS_BUTTON", 249, 267);
        FOLLOWING_BOARDS_BUTTON = new ElementType("FOLLOWING_BOARDS_BUTTON", 250, 268);
        HELP_PULSE = new ElementType("HELP_PULSE", 251, 270);
        HELP_BUTTON = new ElementType("HELP_BUTTON", 252, 271);
        HELP_FLYOUT_BUTTON = new ElementType("HELP_FLYOUT_BUTTON", 253, 299);
        CONVERSATION_NEW_BUTTON = new ElementType("CONVERSATION_NEW_BUTTON", 254, 275);
        CONVERSATION_CREATE_BUTTON = new ElementType("CONVERSATION_CREATE_BUTTON", 255, 276);
        CONVERSATION_LIST_ITEM = new ElementType("CONVERSATION_LIST_ITEM", 256, 277);
        CONVERSATION_INBOX_BUTTON = new ElementType("CONVERSATION_INBOX_BUTTON", 257, 278);
        INSTALL_EXTENSION_BUTTON = new ElementType("INSTALL_EXTENSION_BUTTON", 258, 280);
        HELP_CENTER_BUTTON = new ElementType("HELP_CENTER_BUTTON", 259, 281);
        PIN_CELL_BUTTON_PFY_PIN_SOURCE = new ElementType("PIN_CELL_BUTTON_PFY_PIN_SOURCE", 260, 282);
        PIN_CELL_BUTTON_PROMOTED_PIN_SOURCE = new ElementType("PIN_CELL_BUTTON_PROMOTED_PIN_SOURCE", 261, 283);
        PIN_FEEDBACK_BUTTON_PFY = new ElementType("PIN_FEEDBACK_BUTTON_PFY", 262, 284);
        PIN_FEEDBACK_BUTTON_PROMOTED = new ElementType("PIN_FEEDBACK_BUTTON_PROMOTED", 263, 285);
        PIN_FEEDBACK_BUTTON_STATE_REASON_PFY = new ElementType("PIN_FEEDBACK_BUTTON_STATE_REASON_PFY", 264, 286);
        PIN_FEEDBACK_BUTTON_STATE_REASON_PROMOTED = new ElementType("PIN_FEEDBACK_BUTTON_STATE_REASON_PROMOTED", 265, 287);
        PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY = new ElementType("PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY", 266, 288);
        PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD = new ElementType("PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD", 267, 289);
        PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED = new ElementType("PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED", 268, 290);
        PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED = new ElementType("PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED", 269, 291);
        PIN_FEEDBACK_DIALOG_BUTTON_DISMISS = new ElementType("PIN_FEEDBACK_DIALOG_BUTTON_DISMISS", 270, 292);
        PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED = new ElementType("PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED", 271, 293);
        PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE = new ElementType("PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE", 272, 294);
        PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE = new ElementType("PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE", 273, 295);
        DIGEST_PIN = new ElementType("DIGEST_PIN", 274, 296);
        DIGEST_STORY_HEADER_BUTTON = new ElementType("DIGEST_STORY_HEADER_BUTTON", 275, 302);
        DIGEST_STORY_EXPAND_BUTTON = new ElementType("DIGEST_STORY_EXPAND_BUTTON", 276, 303);
        DIGEST_STORY_FEEDBACK_BUTTON = new ElementType("DIGEST_STORY_FEEDBACK_BUTTON", 277, 308);
        DIGEST_STORY_FOLLOW_BUTTON = new ElementType("DIGEST_STORY_FOLLOW_BUTTON", 278, 309);
        DIGEST_STORY_CUSTOM_ACTION_BUTTON = new ElementType("DIGEST_STORY_CUSTOM_ACTION_BUTTON", 279, 351);
        DIGEST_CAROUSEL_CONTENT_REP = new ElementType("DIGEST_CAROUSEL_CONTENT_REP", 280, 352);
        DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD = new ElementType("DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD", 281, 304);
        DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST = new ElementType("DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST", 282, 305);
        DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER = new ElementType("DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER", 283, 306);
        DIGEST_FEEDBACK_DIALOG_BUTTON_HIDE_THROUGH_BOARD_REC = new ElementType("DIGEST_FEEDBACK_DIALOG_BUTTON_HIDE_THROUGH_BOARD_REC", 284, 307);
        LOOKBOOK_TAG = new ElementType("LOOKBOOK_TAG", 285, 297);
        LOOKBOOK_PROFILE_IMAGE = new ElementType("LOOKBOOK_PROFILE_IMAGE", 286, 298);
        SEND_SOCIAL_BUTTON = new ElementType("SEND_SOCIAL_BUTTON", 287, 300);
        SHARE_SOCIAL_BUTTON = new ElementType("SHARE_SOCIAL_BUTTON", 288, 301);
        SAFARI_KEYCHAIN_USE_PASSWORD_BUTTON = new ElementType("SAFARI_KEYCHAIN_USE_PASSWORD_BUTTON", 289, 310);
        SAFARI_KEYCHAIN_NOT_NOW_BUTTON = new ElementType("SAFARI_KEYCHAIN_NOT_NOW_BUTTON", 290, 311);
        SIGNUP_TRENDING_PREVIEW_BUTTON = new ElementType("SIGNUP_TRENDING_PREVIEW_BUTTON", 291, 314);
        PIN_SHARE_MESSAGE = new ElementType("PIN_SHARE_MESSAGE", 292, 316);
        PIN_SHARE_WHATSAPP = new ElementType("PIN_SHARE_WHATSAPP", 293, 317);
        PIN_SHARE_FB_MESSENGER = new ElementType("PIN_SHARE_FB_MESSENGER", 294, 318);
        PIN_SHARE_THIRD_PARTY_EXTENSION = new ElementType("PIN_SHARE_THIRD_PARTY_EXTENSION", 295, 319);
        BOARD_SHARE_BUTTON = new ElementType("BOARD_SHARE_BUTTON", 296, 331);
        BOARD_SHARE_FACEBOOK_BUTTON = new ElementType("BOARD_SHARE_FACEBOOK_BUTTON", 297, 332);
        BOARD_SHARE_EMAIL_BUTTON = new ElementType("BOARD_SHARE_EMAIL_BUTTON", 298, 333);
        BOARD_SHARE_COPY_LINK_BUTTON = new ElementType("BOARD_SHARE_COPY_LINK_BUTTON", 299, 334);
        BOARD_SHARE_OTHER_BUTTON = new ElementType("BOARD_SHARE_OTHER_BUTTON", 300, 335);
        SEARCH_ACTION_SUGGESTION = new ElementType("SEARCH_ACTION_SUGGESTION", 301, 336);
        SEARCH_FILTER_SUGGESTION = new ElementType("SEARCH_FILTER_SUGGESTION", 302, 337);
        SEARCH_FILTER_DROPDOWNBUTTON = new ElementType("SEARCH_FILTER_DROPDOWNBUTTON", 303, 338);
        FLEXIBLE_NUX_LAUNCHER = new ElementType("FLEXIBLE_NUX_LAUNCHER", 304, 339);
        INTEREST_PIN_ANNOTATION = new ElementType("INTEREST_PIN_ANNOTATION", 305, 340);
        MOVE_PINS_BUTTON = new ElementType("MOVE_PINS_BUTTON", 306, 400);
        BULK_MOVE_PINS_BUTTON = new ElementType("BULK_MOVE_PINS_BUTTON", 307, 401);
        BULK_COPY_PINS_BUTTON = new ElementType("BULK_COPY_PINS_BUTTON", 308, 402);
        BULK_DELETE_PINS_BUTTON = new ElementType("BULK_DELETE_PINS_BUTTON", 309, 403);
        BULK_CANCEL_BUTTON = new ElementType("BULK_CANCEL_BUTTON", 310, 404);
        ADD_PIN_REP = new ElementType("ADD_PIN_REP", 311, 450);
        ADD_PIN_REP_UPLOAD = new ElementType("ADD_PIN_REP_UPLOAD", 312, 451);
        ADD_PIN_REP_SCRAPE = new ElementType("ADD_PIN_REP_SCRAPE", 313, 452);
        ADD_PIN_REP_BOOKMARKLET = new ElementType("ADD_PIN_REP_BOOKMARKLET", 314, 453);
        ADD_PIN_BUTTON_UPLOAD = new ElementType("ADD_PIN_BUTTON_UPLOAD", 315, 454);
        ADD_PIN_BUTTON_SCRAPE = new ElementType("ADD_PIN_BUTTON_SCRAPE", 316, 455);
        ADD_PIN_BUTTON_BOOKMARKLET = new ElementType("ADD_PIN_BUTTON_BOOKMARKLET", 317, 456);
        ADD_PIN_INSTALL_BOOKMARKLET = new ElementType("ADD_PIN_INSTALL_BOOKMARKLET", 318, 457);
        ADD_PIN_CANCEL_INSTALL_BOOKMARKLET = new ElementType("ADD_PIN_CANCEL_INSTALL_BOOKMARKLET", 319, 458);
        RICH_ACTION_BUTTON = new ElementType("RICH_ACTION_BUTTON", 320, 500);
        WEB_PIN_CREATE_EDIT_DESCRIPTION = new ElementType("WEB_PIN_CREATE_EDIT_DESCRIPTION", 321, 600);
        WEB_PIN_CREATE_CREATE_BOARD_NO_NAME = new ElementType("WEB_PIN_CREATE_CREATE_BOARD_NO_NAME", 322, 603);
        WEB_PIN_CREATE_CREATE_BOARD_NAME = new ElementType("WEB_PIN_CREATE_CREATE_BOARD_NAME", 323, 604);
        WEB_PIN_CREATE_FILTER_BOARDS_VIA_SEARCH = new ElementType("WEB_PIN_CREATE_FILTER_BOARDS_VIA_SEARCH", 324, 605);
        WEB_PIN_CREATE_BOARD_FILTER = new ElementType("WEB_PIN_CREATE_BOARD_FILTER", 325, 610);
        PINVITATIONAL_REQUEST_INVITE_SUBMITTED = new ElementType("PINVITATIONAL_REQUEST_INVITE_SUBMITTED", 326, 606);
        SEARCH_PRIVACY_LINK = new ElementType("SEARCH_PRIVACY_LINK", 327, 342);
        FIND_FRIENDS_BUTTON_ADDRESS_BOOK = new ElementType("FIND_FRIENDS_BUTTON_ADDRESS_BOOK", 328, 343);
        FIND_FRIENDS_BUTTON_FACEBOOK = new ElementType("FIND_FRIENDS_BUTTON_FACEBOOK", 329, 344);
        FIND_FRIENDS_BUTTON_TWITTER = new ElementType("FIND_FRIENDS_BUTTON_TWITTER", 330, 345);
        FIND_FRIENDS_BUTTON_MORE = new ElementType("FIND_FRIENDS_BUTTON_MORE", 331, 346);
        FIND_FRIENDS_BUTTON_WHATSAPP = new ElementType("FIND_FRIENDS_BUTTON_WHATSAPP", 332, 347);
        FIND_FRIENDS_BUTTON_FB_MESSENGER = new ElementType("FIND_FRIENDS_BUTTON_FB_MESSENGER", 333, 348);
        COMPOSE_EMAIL_INVITE_BUTTON = new ElementType("COMPOSE_EMAIL_INVITE_BUTTON", 334, 349);
        FIND_FRIENDS_BUTTON_LINE = new ElementType("FIND_FRIENDS_BUTTON_LINE", 335, 350);
        BRAND_SURVEY_DIALOG_YES_BUTTON = new ElementType("BRAND_SURVEY_DIALOG_YES_BUTTON", 336, 353);
        BRAND_SURVEY_DIALOG_LATER_BUTTON = new ElementType("BRAND_SURVEY_DIALOG_LATER_BUTTON", 337, 354);
        BRAND_SURVEY_DIALOG_NEVER_BUTTON = new ElementType("BRAND_SURVEY_DIALOG_NEVER_BUTTON", 338, 355);
        BRAND_SURVEY_DIALOG_BACKGROUND_DISMISS = new ElementType("BRAND_SURVEY_DIALOG_BACKGROUND_DISMISS", 339, 356);
        HASH_TAG = new ElementType("HASH_TAG", 340, 357);
        SHARE_EXTENSION_PIN_IT_BUTTON = new ElementType("SHARE_EXTENSION_PIN_IT_BUTTON", 341, 700);
        SHARE_EXTENSION_IMAGE = new ElementType("SHARE_EXTENSION_IMAGE", 342, 701);
        SHARE_EXTENSION_PICK_BOARD_CELL = new ElementType("SHARE_EXTENSION_PICK_BOARD_CELL", 343, 702);
        SHARE_EXTENSION_BOARD_CELL = new ElementType("SHARE_EXTENSION_BOARD_CELL", 344, 703);
        AUTOCOMPLETE_SUGGESTION_LC1 = new ElementType("AUTOCOMPLETE_SUGGESTION_LC1", 345, 705);
        AUTOCOMPLETE_SUGGESTION_LC2 = new ElementType("AUTOCOMPLETE_SUGGESTION_LC2", 346, 706);
        $VALUES = (new ElementType[] {
            PIN_REPIN_BUTTON, PIN_LIKE_BUTTON, PIN_COMMENT_BUTTON, PIN_EDIT_BUTTON, PIN_SHARE_BUTTON, PIN_CAPTION_COMMENT, PIN_BOARD, PIN_BOARD_FOLLOW, PIN_BOARD_PIN, PIN_ORIGINAL_BOARD, 
            PIN_ORIGINAL_BOARD_FOLLOW, PIN_ORIGINAL_BOARD_PIN, PIN_VIA_PIN, PIN_VIA, PIN_RELATED_PIN, PIN_INTEREST, SUGGESTED_USER, REMOVE_SUGGESTED_USER_BUTTON, NEWS_FEED_PIN, NEWS_FEED_USER, 
            REPIN_SUGGESTED_BOARD, PIN_UPLOAD_BUTTON, LOGOUT_BUTTON, FOLLOW_ALL_USERS_BUTTON, FACEBOOK_TIMELINE_CONNECT, BOARD_CREATE, BOARD_CREATE_SUGGESTED, ANALYTICS_BUTTON, PIN_DOMAIN, PIN_USER, 
            PIN_ATTRIBUTION, PIN_LIKER, PIN_PINNED_TO, LOGIN_BUTTON, SIGNUP_BUTTON, RETRY_BUTTON, RESET_BUTTON, BACK_BUTTON, PIN_SOURCE_IMAGE, BOARD_COVER, 
            BOARD_FOLLOW, CATEGORY_ICON, PINPICKS_ICON, NEWS_FEED_BOARD, PROFILE_BUTTON, FOLLOWING_BUTTON, FOLLOWERS_BUTTON, SEARCH_BUTTON, CREATE_BUTTON, REFRESH_BUTTON, 
            PIN_SHARE, PIN_REPORT_BUTTON, PIN_SHARE_TWITTER_BUTTON, PIN_SHARE_FACEBOOK_BUTTON, PIN_SHARE_EMAIL_BUTTON, PIN_READING_LIST_BUTTON, PIN_SAVE_BUTTON, PIN_DELETE_BUTTON, PIN_SEND_BUTTON, BOARD_DELETE_BUTTON, 
            BOARD_LEAVE_BUTTON, BOARD_EDIT_BUTTON, BOARD_CATEGORY, BOARD_NAME, BOARD_SECRET, CAMERA_BUTTON, GALLERY_BUTTON, FIND_IMAGES_BUTTON, SETTINGS_BUTTON, FINDFRIENDS_BUTTON, 
            INVITE_BUTTON, SUPPORT_BUTTON, TOS_BUTTON, USER_FOLLOW, PROFILE_IMAGE, PROFILE_URL, PROFILE_FACEBOOK, PROFILE_TWITTER, BOARD_PICKER, FACEBOOK_CONNECT, 
            TWITTER_CONNECT, RAKUTEN_CONNECT, GPLUS_CONNECT, PIN_SUBMIT, USER_FEED_FOLLOW, CANCEL_BUTTON, MENU_BUTTON, CLOSE_BUTTON, DONE_BUTTON, NEWS_BUTTON, 
            EXPLORE_BUTTON, BROWSER_BUTTON, USER_FLAG_BUTTON, USER_LIKES_BUTTON, USER_PINS_BUTTON, USER_BOARDS_BUTTON, USER_ABOUT_BUTTON, USER_EDIT_BUTTON, NEXT_BUTTON, ADD_MESSAGE_BUTTON, 
            COPY_LINK_BUTTON, CLIPBOARD_BUTTON, CLEAR_HISTORY_BUTTON, SEND_BUTTON, NAVIGATION_HOME_BUTTON, NAVIGATION_DISCOVER_BUTTON, PHOTOS_BUTTON, DECLINE_BUTTON, USER_BLOCK_BUTTON, USER_UNBLOCK_BUTTON, 
            USER_REPORT_BUTTON, BOARD_CREATE_SECRET, USER_ABOUT_EDIT_BUTTON, USER_URL_EDIT_BUTTON, BOARD_DESCRIPTION, EDUCATION_TARGET, BROWSER_WEB_IMAGE, AUTOCOMPLETE_SUGGESTION, FIND_MORE_BOARDS_BUTTON, GET_STARTED_BUTTON, 
            REMOVE_BUTTON, WHO_CAN_PIN_BUTTON, PIN_RICH_PIN_ACTION_BUTTON, USER_RECENT_CONTACT, USER_LIST_USER, UNDO_BUTTON, CLEAR_SEARCHES_BUTTON, CLEAR_CONTACTS_BUTTON, PIN_DESCRIPTION, EDIT_HOME_FEED_BUTTON, 
            FOLLOW_BOARDS_BUTTON, UNFOLLOW_BOARDS_BUTTON, DUPLICATE_PIN_WARNING, SUGGESTED_EMAIL, USERNAME_BUTTON, EMAIL_BUTTON, COUNTRY_BUTTON, PUSH_NOTIFICATIONS_BUTTON, UPDATE_BUTTON, CATEGORY_RECENT, 
            LANGUAGE_BUTTON, GENDER_BUTTON, PERSONALIZED_RECOMMENDATIONS_BUTTON, SEARCH_PRIVACY_BUTTON, CHANGE_PASSWORD_BUTTON, SHOW_PASSWORD_BUTTON, SAVE_USER_SETTINGS_BUTTON, RIBBON_BUTTON, USER_LIST_CONTACT, USER_FEED_INVITE_EMAIL, 
            USER_FEED_INVITE_SMS, USER_FEED_INVITE_CUSTOM_EMAIL, NAME_BUTTON, APP_ICON, USER_ICON, NOTIFICATIONS_ICON, SEE_OTHER_PINS_BUTTON, MORE_PINS_BUTTON, PIN_PROMOTED_INFO, PROMOTED_OK_BUTTON, 
            LINK_OUT_BUTTON, PFY_REASON_BUTTON, INVITE_DELETE_BUTTON, FEED_SUBCATEGORY, DISCOVER_TRENDING_CATEGORY, MAP_ANNOTATION, MAP_SEE_ON_MAP_BUTTON, MAP_DIRECTIONS_BUTTON, MAP_ADD_BUTTON, PLACES_BUTTON, 
            LOCATION_BUTTON, PLACES_LIST_PLACE, PHONE_BUTTON, WEBSITE_BUTTON, PLACE_IMAGE, MAP_PIN_ICON, ADD_PLACE_BUTTON, PLACE_PICKER_CREATE, PLACE_PICKER_IMAGE, REMOVE_PLACE_BUTTON, 
            MAP_TOGGLE_BUTTON, COLLABORATOR_TEXT, SEND_INVITE_BUTTON, INVITE_ALL_TOGGLE, REPINS_BUTTON, LIKES_BUTTON, PIN_FLAG_BUTTON, DOMAIN_URL, LOGO, SEE_MORE_BUTTON, 
            BOARD_RELATED_BOARD, COMMENTS_BUTTON, SEARCH_RELATED_QUERY, SEARCH_RELATED_CATEGORY, BUY_BUTTON, FACEBOOK_INVITE_BUTTON, GPLUS_INVITE_BUTTON, SEND_TO_PINNER_BUTTON, APP_RATING_ATTEMPT_BUTTON, APP_RATING_DECLINE_BUTTON, 
            APP_RATING_REMIND_BUTTON, SEND_SMS_INVITE_BUTTON, COMPOSE_SMS_INVITE_BUTTON, FLOWED_INTEREST, REPIN_ADD_PLACE_BUTTON, REPIN_EDIT_PLACE_BUTTON, RELATED_RICH_PIN_BUTTON, BULK_INVITER_BUTTON, RELATED_INTEREST, SINGLE_PIN_POPOVER, 
            NEWS_FEED_QUESTION, NEWS_FEED_ANSWER, SEARCH_PINS_BUTTON, SEARCH_BOARDS_BUTTON, SEARCH_PINNERS_BUTTON, SEARCH_MY_PINS_BUTTON, SEARCH_PLACES_BUTTON, SEARCH_TOKEN, SEARCH_GUIDE_SUGGESTION, SEARCH_BOX_TEXT_INPUT, 
            SEARCH_BOX_ADD_TOKEN_BUTTON, ADD_INTEREST_BUTTON, SUGGEST_INTEREST_BUTTON, EDUCATION_GUIDED_SEARCH_SUGGESTION, EDUCATION_GUIDED_SEARCH_COMPLETE_BUTTON, VISUAL_OBJECT_BUTTON, VISUAL_SEARCH_BUTTON, NAVIGATION_LOGO_BUTTON, MORE_INFO_BUTTON, YOUR_PROFILE_BUTTON, 
            YOUR_SETTINGS_BUTTON, FIND_FRIENDS_BUTTON, CREATE_BOARD_BUTTON, ADD_PIN_FROM_WEBSITE_BUTTON, UPLOAD_PIN_BUTTON, NEWS_FEED_REPLY, NEWS_FEED_ACTOR_IMAGE, NEWS_FEED_ACTOR_LABEL, RECENT_SEARCH_SUGGESTION, SEARCH_ALL_WITH_QUERY, 
            INTEREST_SUGGESTION, STORIES_FEED_LARGE_STORY, STORIES_FEED_SMALL_STORY, STORIES_FEED_ACTOR, STORIES_FEED_RELATED_OBJECT, STORIES_FEED_RELATED_MORE_CELL, STORIES_FEED_ACTOR_IMAGE, DISCOVER_FEATURED_ITEM, FOLLOWING_INTERESTS_BUTTON, FOLLOWING_PINNERS_BUTTON, 
            FOLLOWING_BOARDS_BUTTON, HELP_PULSE, HELP_BUTTON, HELP_FLYOUT_BUTTON, CONVERSATION_NEW_BUTTON, CONVERSATION_CREATE_BUTTON, CONVERSATION_LIST_ITEM, CONVERSATION_INBOX_BUTTON, INSTALL_EXTENSION_BUTTON, HELP_CENTER_BUTTON, 
            PIN_CELL_BUTTON_PFY_PIN_SOURCE, PIN_CELL_BUTTON_PROMOTED_PIN_SOURCE, PIN_FEEDBACK_BUTTON_PFY, PIN_FEEDBACK_BUTTON_PROMOTED, PIN_FEEDBACK_BUTTON_STATE_REASON_PFY, PIN_FEEDBACK_BUTTON_STATE_REASON_PROMOTED, PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY, PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD, PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED, PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED, 
            PIN_FEEDBACK_DIALOG_BUTTON_DISMISS, PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED, PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE, PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE, DIGEST_PIN, DIGEST_STORY_HEADER_BUTTON, DIGEST_STORY_EXPAND_BUTTON, DIGEST_STORY_FEEDBACK_BUTTON, DIGEST_STORY_FOLLOW_BUTTON, DIGEST_STORY_CUSTOM_ACTION_BUTTON, 
            DIGEST_CAROUSEL_CONTENT_REP, DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_BOARD, DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_INTEREST, DIGEST_FEEDBACK_DIALOG_BUTTON_UNFOLLOW_USER, DIGEST_FEEDBACK_DIALOG_BUTTON_HIDE_THROUGH_BOARD_REC, LOOKBOOK_TAG, LOOKBOOK_PROFILE_IMAGE, SEND_SOCIAL_BUTTON, SHARE_SOCIAL_BUTTON, SAFARI_KEYCHAIN_USE_PASSWORD_BUTTON, 
            SAFARI_KEYCHAIN_NOT_NOW_BUTTON, SIGNUP_TRENDING_PREVIEW_BUTTON, PIN_SHARE_MESSAGE, PIN_SHARE_WHATSAPP, PIN_SHARE_FB_MESSENGER, PIN_SHARE_THIRD_PARTY_EXTENSION, BOARD_SHARE_BUTTON, BOARD_SHARE_FACEBOOK_BUTTON, BOARD_SHARE_EMAIL_BUTTON, BOARD_SHARE_COPY_LINK_BUTTON, 
            BOARD_SHARE_OTHER_BUTTON, SEARCH_ACTION_SUGGESTION, SEARCH_FILTER_SUGGESTION, SEARCH_FILTER_DROPDOWNBUTTON, FLEXIBLE_NUX_LAUNCHER, INTEREST_PIN_ANNOTATION, MOVE_PINS_BUTTON, BULK_MOVE_PINS_BUTTON, BULK_COPY_PINS_BUTTON, BULK_DELETE_PINS_BUTTON, 
            BULK_CANCEL_BUTTON, ADD_PIN_REP, ADD_PIN_REP_UPLOAD, ADD_PIN_REP_SCRAPE, ADD_PIN_REP_BOOKMARKLET, ADD_PIN_BUTTON_UPLOAD, ADD_PIN_BUTTON_SCRAPE, ADD_PIN_BUTTON_BOOKMARKLET, ADD_PIN_INSTALL_BOOKMARKLET, ADD_PIN_CANCEL_INSTALL_BOOKMARKLET, 
            RICH_ACTION_BUTTON, WEB_PIN_CREATE_EDIT_DESCRIPTION, WEB_PIN_CREATE_CREATE_BOARD_NO_NAME, WEB_PIN_CREATE_CREATE_BOARD_NAME, WEB_PIN_CREATE_FILTER_BOARDS_VIA_SEARCH, WEB_PIN_CREATE_BOARD_FILTER, PINVITATIONAL_REQUEST_INVITE_SUBMITTED, SEARCH_PRIVACY_LINK, FIND_FRIENDS_BUTTON_ADDRESS_BOOK, FIND_FRIENDS_BUTTON_FACEBOOK, 
            FIND_FRIENDS_BUTTON_TWITTER, FIND_FRIENDS_BUTTON_MORE, FIND_FRIENDS_BUTTON_WHATSAPP, FIND_FRIENDS_BUTTON_FB_MESSENGER, COMPOSE_EMAIL_INVITE_BUTTON, FIND_FRIENDS_BUTTON_LINE, BRAND_SURVEY_DIALOG_YES_BUTTON, BRAND_SURVEY_DIALOG_LATER_BUTTON, BRAND_SURVEY_DIALOG_NEVER_BUTTON, BRAND_SURVEY_DIALOG_BACKGROUND_DISMISS, 
            HASH_TAG, SHARE_EXTENSION_PIN_IT_BUTTON, SHARE_EXTENSION_IMAGE, SHARE_EXTENSION_PICK_BOARD_CELL, SHARE_EXTENSION_BOARD_CELL, AUTOCOMPLETE_SUGGESTION_LC1, AUTOCOMPLETE_SUGGESTION_LC2
        });
    }
}
