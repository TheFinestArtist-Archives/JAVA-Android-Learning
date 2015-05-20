// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class SpamServiceResponseCode extends Enum
    implements TEnum
{

    private static final SpamServiceResponseCode $VALUES[];
    public static final SpamServiceResponseCode BAD_URL;
    public static final SpamServiceResponseCode COPYRIGHT_IMAGE;
    public static final SpamServiceResponseCode IP_DISALLOWED;
    public static final SpamServiceResponseCode LIMIT_FOLLOW_RATIO;
    public static final SpamServiceResponseCode LIMIT_HARD;
    public static final SpamServiceResponseCode LIMIT_HARD_BOARD;
    public static final SpamServiceResponseCode LIMIT_HARD_PIN;
    public static final SpamServiceResponseCode LIMIT_HARD_PIN_COMMENT_AT_MENTION;
    public static final SpamServiceResponseCode LIMIT_HARD_PIN_LIKE;
    public static final SpamServiceResponseCode LIMIT_HARD_USER_FOLLOW;
    public static final SpamServiceResponseCode MESSAGE_ALREADY_TRANSLATED;
    public static final SpamServiceResponseCode OFFSITE_PORN;
    public static final SpamServiceResponseCode OFFSITE_REDIRECTOR;
    public static final SpamServiceResponseCode OFFSITE_SPAM;
    public static final SpamServiceResponseCode OFFSITE_URL_SHORTENER;
    public static final SpamServiceResponseCode OK;
    public static final SpamServiceResponseCode RATELIMIT_IP;
    public static final SpamServiceResponseCode RATELIMIT_USER;
    public static final SpamServiceResponseCode RATELIMIT_USER_EMAIL_CHANGE;
    public static final SpamServiceResponseCode REDIRECTOR;
    public static final SpamServiceResponseCode UNVERIFIED_EMAIL;
    public static final SpamServiceResponseCode WRITEBAN;
    private final int value;

    private SpamServiceResponseCode(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static SpamServiceResponseCode findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return OK;

        case 1: // '\001'
            return BAD_URL;

        case 2: // '\002'
            return IP_DISALLOWED;

        case 3: // '\003'
            return LIMIT_FOLLOW_RATIO;

        case 4: // '\004'
            return LIMIT_HARD;

        case 5: // '\005'
            return RATELIMIT_IP;

        case 6: // '\006'
            return RATELIMIT_USER;

        case 7: // '\007'
            return RATELIMIT_USER_EMAIL_CHANGE;

        case 8: // '\b'
            return REDIRECTOR;

        case 9: // '\t'
            return UNVERIFIED_EMAIL;

        case 10: // '\n'
            return WRITEBAN;

        case 11: // '\013'
            return MESSAGE_ALREADY_TRANSLATED;

        case 12: // '\f'
            return COPYRIGHT_IMAGE;

        case 13: // '\r'
            return LIMIT_HARD_BOARD;

        case 14: // '\016'
            return LIMIT_HARD_PIN;

        case 15: // '\017'
            return LIMIT_HARD_PIN_COMMENT_AT_MENTION;

        case 16: // '\020'
            return LIMIT_HARD_PIN_LIKE;

        case 17: // '\021'
            return LIMIT_HARD_USER_FOLLOW;

        case 18: // '\022'
            return OFFSITE_SPAM;

        case 19: // '\023'
            return OFFSITE_PORN;

        case 20: // '\024'
            return OFFSITE_REDIRECTOR;

        case 21: // '\025'
            return OFFSITE_URL_SHORTENER;
        }
    }

    public static SpamServiceResponseCode valueOf(String s)
    {
        return (SpamServiceResponseCode)Enum.valueOf(com/pinterest/schemas/event/SpamServiceResponseCode, s);
    }

    public static SpamServiceResponseCode[] values()
    {
        return (SpamServiceResponseCode[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        OK = new SpamServiceResponseCode("OK", 0, 0);
        BAD_URL = new SpamServiceResponseCode("BAD_URL", 1, 1);
        IP_DISALLOWED = new SpamServiceResponseCode("IP_DISALLOWED", 2, 2);
        LIMIT_FOLLOW_RATIO = new SpamServiceResponseCode("LIMIT_FOLLOW_RATIO", 3, 3);
        LIMIT_HARD = new SpamServiceResponseCode("LIMIT_HARD", 4, 4);
        RATELIMIT_IP = new SpamServiceResponseCode("RATELIMIT_IP", 5, 5);
        RATELIMIT_USER = new SpamServiceResponseCode("RATELIMIT_USER", 6, 6);
        RATELIMIT_USER_EMAIL_CHANGE = new SpamServiceResponseCode("RATELIMIT_USER_EMAIL_CHANGE", 7, 7);
        REDIRECTOR = new SpamServiceResponseCode("REDIRECTOR", 8, 8);
        UNVERIFIED_EMAIL = new SpamServiceResponseCode("UNVERIFIED_EMAIL", 9, 9);
        WRITEBAN = new SpamServiceResponseCode("WRITEBAN", 10, 10);
        MESSAGE_ALREADY_TRANSLATED = new SpamServiceResponseCode("MESSAGE_ALREADY_TRANSLATED", 11, 11);
        COPYRIGHT_IMAGE = new SpamServiceResponseCode("COPYRIGHT_IMAGE", 12, 12);
        LIMIT_HARD_BOARD = new SpamServiceResponseCode("LIMIT_HARD_BOARD", 13, 13);
        LIMIT_HARD_PIN = new SpamServiceResponseCode("LIMIT_HARD_PIN", 14, 14);
        LIMIT_HARD_PIN_COMMENT_AT_MENTION = new SpamServiceResponseCode("LIMIT_HARD_PIN_COMMENT_AT_MENTION", 15, 15);
        LIMIT_HARD_PIN_LIKE = new SpamServiceResponseCode("LIMIT_HARD_PIN_LIKE", 16, 16);
        LIMIT_HARD_USER_FOLLOW = new SpamServiceResponseCode("LIMIT_HARD_USER_FOLLOW", 17, 17);
        OFFSITE_SPAM = new SpamServiceResponseCode("OFFSITE_SPAM", 18, 18);
        OFFSITE_PORN = new SpamServiceResponseCode("OFFSITE_PORN", 19, 19);
        OFFSITE_REDIRECTOR = new SpamServiceResponseCode("OFFSITE_REDIRECTOR", 20, 20);
        OFFSITE_URL_SHORTENER = new SpamServiceResponseCode("OFFSITE_URL_SHORTENER", 21, 21);
        $VALUES = (new SpamServiceResponseCode[] {
            OK, BAD_URL, IP_DISALLOWED, LIMIT_FOLLOW_RATIO, LIMIT_HARD, RATELIMIT_IP, RATELIMIT_USER, RATELIMIT_USER_EMAIL_CHANGE, REDIRECTOR, UNVERIFIED_EMAIL, 
            WRITEBAN, MESSAGE_ALREADY_TRANSLATED, COPYRIGHT_IMAGE, LIMIT_HARD_BOARD, LIMIT_HARD_PIN, LIMIT_HARD_PIN_COMMENT_AT_MENTION, LIMIT_HARD_PIN_LIKE, LIMIT_HARD_USER_FOLLOW, OFFSITE_SPAM, OFFSITE_PORN, 
            OFFSITE_REDIRECTOR, OFFSITE_URL_SHORTENER
        });
    }
}
