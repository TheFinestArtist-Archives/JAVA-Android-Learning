// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import android.widget.ListAdapter;

public interface SearchableListAdapter
    extends ListAdapter
{

    public abstract void onSearchQueryChanged(String s);

    public abstract void refresh();
}
