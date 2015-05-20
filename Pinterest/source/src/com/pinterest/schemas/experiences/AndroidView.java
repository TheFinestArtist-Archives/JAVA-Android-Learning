// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class AndroidView extends Enum
    implements TEnum
{

    private static final AndroidView $VALUES[];
    public static final AndroidView BOARD_FOLLOW_EDUCATION_BASE;
    public static final AndroidView BOARD_FOLLOW_EDUCATION_EXAMPLE_1;
    public static final AndroidView BOARD_FOLLOW_EDUCATION_EXAMPLE_2;
    public static final AndroidView BOARD_FOLLOW_EDUCATION_FOLLOW;
    public static final AndroidView EMPTY_BOARD_EDUCATION_BASE;
    public static final AndroidView EMPTY_BOARD_EDUCATION_FIND_PINS;
    public static final AndroidView EMPTY_BOARD_EDUCATION_GREENHOUSE_EXAMPLE;
    public static final AndroidView EMPTY_BOARD_EDUCATION_PROMPT_TO_FIND_PINS;
    public static final AndroidView EMPTY_BOARD_EDUCATION_RECIPE_EXAMPLE;
    public static final AndroidView EMPTY_PROFILE_EDUCATION_BASE;
    public static final AndroidView EMPTY_PROFILE_EDUCATION_BOARD_EDUCATION;
    public static final AndroidView EMPTY_PROFILE_EDUCATION_EXAMPLE_1;
    public static final AndroidView EMPTY_PROFILE_EDUCATION_EXAMPLE_2;
    public static final AndroidView EMPTY_PROFILE_EDUCATION_MAKE_BOARD;
    public static final AndroidView HOME_FEED_EDUCATION_BASE;
    public static final AndroidView HOME_FEED_EDUCATION_END;
    public static final AndroidView HOME_FEED_EDUCATION_EXAMPLE_1;
    public static final AndroidView HOME_FEED_EDUCATION_EXAMPLE_2;
    public static final AndroidView NUX_FRIEND_SELECTOR;
    public static final AndroidView NUX_INTEREST_SELECTOR;
    public static final AndroidView NUX_INTRO;
    public static final AndroidView PINVITATIONAL_HOME_FEED_MODAL_STEP_1;
    public static final AndroidView PINVITATIONAL_HOME_FEED_MODAL_STEP_2;
    public static final AndroidView PINVITATIONAL_HOME_FEED_MODAL_STEP_3;
    public static final AndroidView PIN_CLICKTHROUGH_EDUCATION_BASE;
    public static final AndroidView PIN_CLICKTHROUGH_EDUCATION_END;
    public static final AndroidView PIN_CLICKTHROUGH_EDUCATION_EXAMPLE;
    public static final AndroidView PIN_CLICKTHROUGH_EDUCATION_TIP;
    public static final AndroidView PROFILE_FOLLOW_EDUCATION_BASE;
    public static final AndroidView PROFILE_FOLLOW_EDUCATION_END;
    public static final AndroidView PROFILE_FOLLOW_EDUCATION_EXAMPLE_1;
    public static final AndroidView PROFILE_FOLLOW_EDUCATION_EXAMPLE_2;
    public static final AndroidView REPIN_EDUCATION_BASE;
    public static final AndroidView REPIN_EDUCATION_EXAMPLE_1;
    public static final AndroidView REPIN_EDUCATION_EXAMPLE_2;
    public static final AndroidView REPIN_EDUCATION_PIN_IT;
    private final int value;

    private AndroidView(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static AndroidView findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return EMPTY_BOARD_EDUCATION_BASE;

        case 2: // '\002'
            return EMPTY_BOARD_EDUCATION_GREENHOUSE_EXAMPLE;

        case 3: // '\003'
            return EMPTY_BOARD_EDUCATION_RECIPE_EXAMPLE;

        case 4: // '\004'
            return EMPTY_BOARD_EDUCATION_FIND_PINS;

        case 5: // '\005'
            return EMPTY_BOARD_EDUCATION_PROMPT_TO_FIND_PINS;

        case 6: // '\006'
            return EMPTY_PROFILE_EDUCATION_BASE;

        case 7: // '\007'
            return EMPTY_PROFILE_EDUCATION_BOARD_EDUCATION;

        case 8: // '\b'
            return EMPTY_PROFILE_EDUCATION_EXAMPLE_1;

        case 9: // '\t'
            return EMPTY_PROFILE_EDUCATION_EXAMPLE_2;

        case 10: // '\n'
            return EMPTY_PROFILE_EDUCATION_MAKE_BOARD;

        case 11: // '\013'
            return NUX_INTRO;

        case 12: // '\f'
            return NUX_FRIEND_SELECTOR;

        case 13: // '\r'
            return NUX_INTEREST_SELECTOR;

        case 14: // '\016'
            return PIN_CLICKTHROUGH_EDUCATION_BASE;

        case 15: // '\017'
            return PIN_CLICKTHROUGH_EDUCATION_TIP;

        case 16: // '\020'
            return PIN_CLICKTHROUGH_EDUCATION_END;

        case 17: // '\021'
            return PIN_CLICKTHROUGH_EDUCATION_EXAMPLE;

        case 18: // '\022'
            return HOME_FEED_EDUCATION_BASE;

        case 19: // '\023'
            return HOME_FEED_EDUCATION_EXAMPLE_1;

        case 20: // '\024'
            return HOME_FEED_EDUCATION_EXAMPLE_2;

        case 21: // '\025'
            return HOME_FEED_EDUCATION_END;

        case 22: // '\026'
            return REPIN_EDUCATION_BASE;

        case 23: // '\027'
            return REPIN_EDUCATION_EXAMPLE_1;

        case 24: // '\030'
            return REPIN_EDUCATION_EXAMPLE_2;

        case 25: // '\031'
            return REPIN_EDUCATION_PIN_IT;

        case 26: // '\032'
            return BOARD_FOLLOW_EDUCATION_BASE;

        case 27: // '\033'
            return BOARD_FOLLOW_EDUCATION_EXAMPLE_1;

        case 28: // '\034'
            return BOARD_FOLLOW_EDUCATION_EXAMPLE_2;

        case 29: // '\035'
            return BOARD_FOLLOW_EDUCATION_FOLLOW;

        case 30: // '\036'
            return PROFILE_FOLLOW_EDUCATION_BASE;

        case 31: // '\037'
            return PROFILE_FOLLOW_EDUCATION_EXAMPLE_1;

        case 32: // ' '
            return PROFILE_FOLLOW_EDUCATION_EXAMPLE_2;

        case 33: // '!'
            return PROFILE_FOLLOW_EDUCATION_END;

        case 34: // '"'
            return PINVITATIONAL_HOME_FEED_MODAL_STEP_1;

        case 35: // '#'
            return PINVITATIONAL_HOME_FEED_MODAL_STEP_2;

        case 36: // '$'
            return PINVITATIONAL_HOME_FEED_MODAL_STEP_3;
        }
    }

    public static AndroidView valueOf(String s)
    {
        return (AndroidView)Enum.valueOf(com/pinterest/schemas/experiences/AndroidView, s);
    }

    public static AndroidView[] values()
    {
        return (AndroidView[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        EMPTY_BOARD_EDUCATION_BASE = new AndroidView("EMPTY_BOARD_EDUCATION_BASE", 0, 1);
        EMPTY_BOARD_EDUCATION_GREENHOUSE_EXAMPLE = new AndroidView("EMPTY_BOARD_EDUCATION_GREENHOUSE_EXAMPLE", 1, 2);
        EMPTY_BOARD_EDUCATION_RECIPE_EXAMPLE = new AndroidView("EMPTY_BOARD_EDUCATION_RECIPE_EXAMPLE", 2, 3);
        EMPTY_BOARD_EDUCATION_FIND_PINS = new AndroidView("EMPTY_BOARD_EDUCATION_FIND_PINS", 3, 4);
        EMPTY_BOARD_EDUCATION_PROMPT_TO_FIND_PINS = new AndroidView("EMPTY_BOARD_EDUCATION_PROMPT_TO_FIND_PINS", 4, 5);
        EMPTY_PROFILE_EDUCATION_BASE = new AndroidView("EMPTY_PROFILE_EDUCATION_BASE", 5, 6);
        EMPTY_PROFILE_EDUCATION_BOARD_EDUCATION = new AndroidView("EMPTY_PROFILE_EDUCATION_BOARD_EDUCATION", 6, 7);
        EMPTY_PROFILE_EDUCATION_EXAMPLE_1 = new AndroidView("EMPTY_PROFILE_EDUCATION_EXAMPLE_1", 7, 8);
        EMPTY_PROFILE_EDUCATION_EXAMPLE_2 = new AndroidView("EMPTY_PROFILE_EDUCATION_EXAMPLE_2", 8, 9);
        EMPTY_PROFILE_EDUCATION_MAKE_BOARD = new AndroidView("EMPTY_PROFILE_EDUCATION_MAKE_BOARD", 9, 10);
        NUX_INTRO = new AndroidView("NUX_INTRO", 10, 11);
        NUX_FRIEND_SELECTOR = new AndroidView("NUX_FRIEND_SELECTOR", 11, 12);
        NUX_INTEREST_SELECTOR = new AndroidView("NUX_INTEREST_SELECTOR", 12, 13);
        PIN_CLICKTHROUGH_EDUCATION_BASE = new AndroidView("PIN_CLICKTHROUGH_EDUCATION_BASE", 13, 14);
        PIN_CLICKTHROUGH_EDUCATION_TIP = new AndroidView("PIN_CLICKTHROUGH_EDUCATION_TIP", 14, 15);
        PIN_CLICKTHROUGH_EDUCATION_END = new AndroidView("PIN_CLICKTHROUGH_EDUCATION_END", 15, 16);
        PIN_CLICKTHROUGH_EDUCATION_EXAMPLE = new AndroidView("PIN_CLICKTHROUGH_EDUCATION_EXAMPLE", 16, 17);
        HOME_FEED_EDUCATION_BASE = new AndroidView("HOME_FEED_EDUCATION_BASE", 17, 18);
        HOME_FEED_EDUCATION_EXAMPLE_1 = new AndroidView("HOME_FEED_EDUCATION_EXAMPLE_1", 18, 19);
        HOME_FEED_EDUCATION_EXAMPLE_2 = new AndroidView("HOME_FEED_EDUCATION_EXAMPLE_2", 19, 20);
        HOME_FEED_EDUCATION_END = new AndroidView("HOME_FEED_EDUCATION_END", 20, 21);
        REPIN_EDUCATION_BASE = new AndroidView("REPIN_EDUCATION_BASE", 21, 22);
        REPIN_EDUCATION_EXAMPLE_1 = new AndroidView("REPIN_EDUCATION_EXAMPLE_1", 22, 23);
        REPIN_EDUCATION_EXAMPLE_2 = new AndroidView("REPIN_EDUCATION_EXAMPLE_2", 23, 24);
        REPIN_EDUCATION_PIN_IT = new AndroidView("REPIN_EDUCATION_PIN_IT", 24, 25);
        BOARD_FOLLOW_EDUCATION_BASE = new AndroidView("BOARD_FOLLOW_EDUCATION_BASE", 25, 26);
        BOARD_FOLLOW_EDUCATION_EXAMPLE_1 = new AndroidView("BOARD_FOLLOW_EDUCATION_EXAMPLE_1", 26, 27);
        BOARD_FOLLOW_EDUCATION_EXAMPLE_2 = new AndroidView("BOARD_FOLLOW_EDUCATION_EXAMPLE_2", 27, 28);
        BOARD_FOLLOW_EDUCATION_FOLLOW = new AndroidView("BOARD_FOLLOW_EDUCATION_FOLLOW", 28, 29);
        PROFILE_FOLLOW_EDUCATION_BASE = new AndroidView("PROFILE_FOLLOW_EDUCATION_BASE", 29, 30);
        PROFILE_FOLLOW_EDUCATION_EXAMPLE_1 = new AndroidView("PROFILE_FOLLOW_EDUCATION_EXAMPLE_1", 30, 31);
        PROFILE_FOLLOW_EDUCATION_EXAMPLE_2 = new AndroidView("PROFILE_FOLLOW_EDUCATION_EXAMPLE_2", 31, 32);
        PROFILE_FOLLOW_EDUCATION_END = new AndroidView("PROFILE_FOLLOW_EDUCATION_END", 32, 33);
        PINVITATIONAL_HOME_FEED_MODAL_STEP_1 = new AndroidView("PINVITATIONAL_HOME_FEED_MODAL_STEP_1", 33, 34);
        PINVITATIONAL_HOME_FEED_MODAL_STEP_2 = new AndroidView("PINVITATIONAL_HOME_FEED_MODAL_STEP_2", 34, 35);
        PINVITATIONAL_HOME_FEED_MODAL_STEP_3 = new AndroidView("PINVITATIONAL_HOME_FEED_MODAL_STEP_3", 35, 36);
        $VALUES = (new AndroidView[] {
            EMPTY_BOARD_EDUCATION_BASE, EMPTY_BOARD_EDUCATION_GREENHOUSE_EXAMPLE, EMPTY_BOARD_EDUCATION_RECIPE_EXAMPLE, EMPTY_BOARD_EDUCATION_FIND_PINS, EMPTY_BOARD_EDUCATION_PROMPT_TO_FIND_PINS, EMPTY_PROFILE_EDUCATION_BASE, EMPTY_PROFILE_EDUCATION_BOARD_EDUCATION, EMPTY_PROFILE_EDUCATION_EXAMPLE_1, EMPTY_PROFILE_EDUCATION_EXAMPLE_2, EMPTY_PROFILE_EDUCATION_MAKE_BOARD, 
            NUX_INTRO, NUX_FRIEND_SELECTOR, NUX_INTEREST_SELECTOR, PIN_CLICKTHROUGH_EDUCATION_BASE, PIN_CLICKTHROUGH_EDUCATION_TIP, PIN_CLICKTHROUGH_EDUCATION_END, PIN_CLICKTHROUGH_EDUCATION_EXAMPLE, HOME_FEED_EDUCATION_BASE, HOME_FEED_EDUCATION_EXAMPLE_1, HOME_FEED_EDUCATION_EXAMPLE_2, 
            HOME_FEED_EDUCATION_END, REPIN_EDUCATION_BASE, REPIN_EDUCATION_EXAMPLE_1, REPIN_EDUCATION_EXAMPLE_2, REPIN_EDUCATION_PIN_IT, BOARD_FOLLOW_EDUCATION_BASE, BOARD_FOLLOW_EDUCATION_EXAMPLE_1, BOARD_FOLLOW_EDUCATION_EXAMPLE_2, BOARD_FOLLOW_EDUCATION_FOLLOW, PROFILE_FOLLOW_EDUCATION_BASE, 
            PROFILE_FOLLOW_EDUCATION_EXAMPLE_1, PROFILE_FOLLOW_EDUCATION_EXAMPLE_2, PROFILE_FOLLOW_EDUCATION_END, PINVITATIONAL_HOME_FEED_MODAL_STEP_1, PINVITATIONAL_HOME_FEED_MODAL_STEP_2, PINVITATIONAL_HOME_FEED_MODAL_STEP_3
        });
    }
}
