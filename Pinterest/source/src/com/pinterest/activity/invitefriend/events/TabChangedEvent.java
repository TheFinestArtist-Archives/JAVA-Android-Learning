// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend.events;

import android.text.Editable;
import com.pinterest.base.Events;

public class TabChangedEvent extends Events
{

    private final String searchQuery;

    public TabChangedEvent(Editable editable)
    {
        searchQuery = editable.toString();
    }

    public String getSearchQuery()
    {
        return searchQuery;
    }
}
