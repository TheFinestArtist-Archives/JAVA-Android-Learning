// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class SpamServiceResponseContext extends Enum
    implements TEnum
{

    private static final SpamServiceResponseContext $VALUES[];
    public static final SpamServiceResponseContext ANSWER_CREATES;
    public static final SpamServiceResponseContext ANSWER_EDITS;
    public static final SpamServiceResponseContext ANSWER_LIKES;
    public static final SpamServiceResponseContext BOARD_CREATES;
    public static final SpamServiceResponseContext BOARD_FOLLOWS;
    public static final SpamServiceResponseContext BOARD_INVITES;
    public static final SpamServiceResponseContext BOARD_UNFOLLOWS;
    public static final SpamServiceResponseContext BULK_ACTIONS;
    public static final SpamServiceResponseContext CONVERSATION_CREATES;
    public static final SpamServiceResponseContext MENTIONS;
    public static final SpamServiceResponseContext NONE;
    public static final SpamServiceResponseContext PIN_COMMENTS;
    public static final SpamServiceResponseContext PIN_CREATES;
    public static final SpamServiceResponseContext PIN_LIKES;
    public static final SpamServiceResponseContext PIN_REPINS;
    public static final SpamServiceResponseContext QUESTION_CREATES;
    public static final SpamServiceResponseContext QUESTION_EDITS;
    public static final SpamServiceResponseContext QUESTION_LIKES;
    public static final SpamServiceResponseContext REPLY_CREATES;
    public static final SpamServiceResponseContext REPLY_EDITS;
    public static final SpamServiceResponseContext USER_FOLLOWS;
    public static final SpamServiceResponseContext USER_LOGINS;
    public static final SpamServiceResponseContext USER_REPORTS;
    public static final SpamServiceResponseContext USER_UNFOLLOWS;
    private final int value;

    private SpamServiceResponseContext(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static SpamServiceResponseContext findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return NONE;

        case 1: // '\001'
            return ANSWER_CREATES;

        case 2: // '\002'
            return ANSWER_EDITS;

        case 3: // '\003'
            return ANSWER_LIKES;

        case 4: // '\004'
            return BOARD_CREATES;

        case 5: // '\005'
            return BOARD_FOLLOWS;

        case 6: // '\006'
            return BOARD_UNFOLLOWS;

        case 7: // '\007'
            return CONVERSATION_CREATES;

        case 8: // '\b'
            return PIN_COMMENTS;

        case 9: // '\t'
            return PIN_CREATES;

        case 10: // '\n'
            return PIN_LIKES;

        case 11: // '\013'
            return PIN_REPINS;

        case 12: // '\f'
            return QUESTION_CREATES;

        case 13: // '\r'
            return QUESTION_EDITS;

        case 14: // '\016'
            return QUESTION_LIKES;

        case 15: // '\017'
            return REPLY_CREATES;

        case 16: // '\020'
            return REPLY_EDITS;

        case 17: // '\021'
            return USER_FOLLOWS;

        case 18: // '\022'
            return USER_REPORTS;

        case 19: // '\023'
            return USER_UNFOLLOWS;

        case 20: // '\024'
            return MENTIONS;

        case 21: // '\025'
            return USER_LOGINS;

        case 22: // '\026'
            return BOARD_INVITES;

        case 23: // '\027'
            return BULK_ACTIONS;
        }
    }

    public static SpamServiceResponseContext valueOf(String s)
    {
        return (SpamServiceResponseContext)Enum.valueOf(com/pinterest/schemas/event/SpamServiceResponseContext, s);
    }

    public static SpamServiceResponseContext[] values()
    {
        return (SpamServiceResponseContext[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NONE = new SpamServiceResponseContext("NONE", 0, 0);
        ANSWER_CREATES = new SpamServiceResponseContext("ANSWER_CREATES", 1, 1);
        ANSWER_EDITS = new SpamServiceResponseContext("ANSWER_EDITS", 2, 2);
        ANSWER_LIKES = new SpamServiceResponseContext("ANSWER_LIKES", 3, 3);
        BOARD_CREATES = new SpamServiceResponseContext("BOARD_CREATES", 4, 4);
        BOARD_FOLLOWS = new SpamServiceResponseContext("BOARD_FOLLOWS", 5, 5);
        BOARD_UNFOLLOWS = new SpamServiceResponseContext("BOARD_UNFOLLOWS", 6, 6);
        CONVERSATION_CREATES = new SpamServiceResponseContext("CONVERSATION_CREATES", 7, 7);
        PIN_COMMENTS = new SpamServiceResponseContext("PIN_COMMENTS", 8, 8);
        PIN_CREATES = new SpamServiceResponseContext("PIN_CREATES", 9, 9);
        PIN_LIKES = new SpamServiceResponseContext("PIN_LIKES", 10, 10);
        PIN_REPINS = new SpamServiceResponseContext("PIN_REPINS", 11, 11);
        QUESTION_CREATES = new SpamServiceResponseContext("QUESTION_CREATES", 12, 12);
        QUESTION_EDITS = new SpamServiceResponseContext("QUESTION_EDITS", 13, 13);
        QUESTION_LIKES = new SpamServiceResponseContext("QUESTION_LIKES", 14, 14);
        REPLY_CREATES = new SpamServiceResponseContext("REPLY_CREATES", 15, 15);
        REPLY_EDITS = new SpamServiceResponseContext("REPLY_EDITS", 16, 16);
        USER_FOLLOWS = new SpamServiceResponseContext("USER_FOLLOWS", 17, 17);
        USER_REPORTS = new SpamServiceResponseContext("USER_REPORTS", 18, 18);
        USER_UNFOLLOWS = new SpamServiceResponseContext("USER_UNFOLLOWS", 19, 19);
        MENTIONS = new SpamServiceResponseContext("MENTIONS", 20, 20);
        USER_LOGINS = new SpamServiceResponseContext("USER_LOGINS", 21, 21);
        BOARD_INVITES = new SpamServiceResponseContext("BOARD_INVITES", 22, 22);
        BULK_ACTIONS = new SpamServiceResponseContext("BULK_ACTIONS", 23, 23);
        $VALUES = (new SpamServiceResponseContext[] {
            NONE, ANSWER_CREATES, ANSWER_EDITS, ANSWER_LIKES, BOARD_CREATES, BOARD_FOLLOWS, BOARD_UNFOLLOWS, CONVERSATION_CREATES, PIN_COMMENTS, PIN_CREATES, 
            PIN_LIKES, PIN_REPINS, QUESTION_CREATES, QUESTION_EDITS, QUESTION_LIKES, REPLY_CREATES, REPLY_EDITS, USER_FOLLOWS, USER_REPORTS, USER_UNFOLLOWS, 
            MENTIONS, USER_LOGINS, BOARD_INVITES, BULK_ACTIONS
        });
    }
}
