// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.pinterest.ui.listview.ListCellDialog;
import com.pinterest.ui.listview.ListCellHeader;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.pin.adapter:
//            BaseListAdapter

public class CreateBoardPinAdapter extends BaseListAdapter
{

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 0;
    private ArrayList _boardPinItems;

    public CreateBoardPinAdapter(ArrayList arraylist)
    {
        _boardPinItems = arraylist;
    }

    public int getCount()
    {
        return _boardPinItems.size();
    }

    public Object getItem(int i)
    {
        return _boardPinItems.get(i);
    }

    public int getItemViewType(int i)
    {
        return i != 0 && i != 2 ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        BoardPinItem boardpinitem = (BoardPinItem)getItem(i);
        if (getItemViewType(i) == 0)
        {
            view = ListCellDialog.get(view, viewgroup);
            view.setImageBorderStyle(com.pinterest.ui.imageview.GrayWebImageView.BorderStyle.TRANSPARENT);
            if (i == 1 || i == getCount() - 1)
            {
                view.setDividerVisibility(8);
            } else
            {
                view.setDividerVisibility(0);
            }
            setItemView(view, boardpinitem);
            return view;
        }
        if (getItemViewType(i) == 1)
        {
            view = ListCellHeader.get(view, viewgroup);
            view.setText(boardpinitem.text);
            view.setDividerVisibility(0);
            return view;
        } else
        {
            return null;
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isEnabled(int i)
    {
        return getItemViewType(i) != 1;
    }

    public void setItemView(ListCellDialog listcelldialog, BoardPinItem boardpinitem)
    {
        listcelldialog.setText(boardpinitem.text);
        listcelldialog.setImage(boardpinitem.icon);
    }

    private class BoardPinItem
    {

        public Drawable icon;
        public String text;

        public BoardPinItem(Drawable drawable, String s)
        {
            icon = drawable;
            text = s;
        }
    }

}
