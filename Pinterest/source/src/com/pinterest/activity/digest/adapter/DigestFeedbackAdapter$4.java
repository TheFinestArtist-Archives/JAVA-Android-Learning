// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;


class FollowItemType
{

    static final int $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[];
    static final int $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[];

    static 
    {
        $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType = new int[FollowItemType.values().length];
        try
        {
            $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[FollowItemType.INTEREST.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[FollowItemType.USER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[FollowItemType.MY_BOARD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$pinterest$activity$digest$adapter$DigestFeedbackAdapter$UnFollowItemType[FollowItemType.OTHER_BOARD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode = new int[com.pinterest.api.model.lues().length];
        try
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.C_BOARD.dinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.ER.dinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.ER_CATEGORY.dinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.TEREST.dinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.ARD.dinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
