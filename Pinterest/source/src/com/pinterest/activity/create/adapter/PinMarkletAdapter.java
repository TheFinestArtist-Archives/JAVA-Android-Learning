// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pinterest.activity.create.model.PinnableImage;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Device;
import com.pinterest.ui.grid.PinGridCell;

public class PinMarkletAdapter extends PinterestBaseAdapter
{

    private Context _context;

    public PinMarkletAdapter(Context context)
    {
        _context = context;
    }

    private String getPinDescription(int i, int j)
    {
        return (new StringBuilder()).append(i).append(" x ").append(j).toString();
    }

    private boolean isImageGif(String s)
    {
        return s != null && s.endsWith("gif");
    }

    public int getItemSpan(int i)
    {
        PinnableImage pinnableimage = (PinnableImage)getItem(i);
        return pinnableimage == null || (float)pinnableimage.getWidth() <= Device.getScreenWidth() || pinnableimage.getWidth() / pinnableimage.getHeight() <= 1 ? 1 : 2;
    }

    public View getView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        if (view == null)
        {
            view = new PinGridCell(_context);
        } else
        {
            view = (PinGridCell)view;
        }
        viewgroup = (PinnableImage)getItem(i);
        if (viewgroup != null)
        {
            Pin pin = new Pin();
            pin.setUid(viewgroup.getUid());
            pin.setDescription(getPinDescription(viewgroup.getWidth(), viewgroup.getHeight()));
            pin.setCleanDescription(Pin.cleanDescription(pin.getDescription()));
            pin.setImageMediumUrl(viewgroup.getImageUrl());
            pin.setImageMediumWidth(Integer.valueOf(viewgroup.getWidth()));
            pin.setImageMediumHeight(Integer.valueOf(viewgroup.getHeight()));
            if (isImageGif(viewgroup.getImageUrl()))
            {
                pin.setEmbedType("gif");
            }
            view.setPin(pin, flag);
            view.setRenderUser(false);
            view.setRenderOnto(false);
            view.setOverrideClicks(true);
        }
        return view;
    }

    protected void loadMore(int i)
    {
    }
}
