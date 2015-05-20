// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import android.view.ViewGroup;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.ui.grid.PinGridCell;

public class PinvitationalPinSummaryAdapter extends PinGridAdapter
{

    public PinvitationalPinSummaryAdapter()
    {
    }

    public View getView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        view = (PinGridCell)super.getView(i, view, viewgroup, flag);
        view.setEnabled(false);
        view.setRenderDescription(false);
        view.setRenderCompactUser(false);
        view.setRenderUser(false);
        view.setRenderSource(false);
        view.setRenderOnto(false);
        view.setRenderThrough(false);
        view.setRenderDomain(false);
        view.setOverrideClicks(false);
        view.setCropPinImage(false);
        view.setIsRelatedPin(false);
        return view;
    }
}
