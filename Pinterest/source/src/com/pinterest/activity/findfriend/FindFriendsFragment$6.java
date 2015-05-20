// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;


class pe
{

    static final int $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[];

    static 
    {
        $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType = new int[com.pinterest.activity.search.model..values().length];
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..PINNER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..MUTUAL_FOLLOW.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..PHONE_CONTACT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..EMAIL_CONTACT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..EMAIL_PLACEHOLDER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model..CONNECT_FB_PLACEHOLDER.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
