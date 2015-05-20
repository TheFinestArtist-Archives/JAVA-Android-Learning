// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.board;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.User;
import com.pinterest.ui.imageview.WebImageView;

public class BoardGridCellTitleUserView extends LinearLayout
{

    private WebImageView _image;
    private TextView boardTv;
    private TextView userTv;

    public BoardGridCellTitleUserView(Context context)
    {
        this(context, null);
    }

    public BoardGridCellTitleUserView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f0300d1, this);
        _image = (WebImageView)findViewById(0x7f0b01d8);
        boardTv = (TextView)findViewById(0x7f0b0065);
        userTv = (TextView)findViewById(0x7f0b01e8);
    }

    public void setBoard(Board board)
    {
        if (board != null)
        {
            boardTv.setText(board.getName());
            board = board.getUser();
            if (board != null)
            {
                _image.loadUrl(board.getImageMediumUrl());
                userTv.setText(board.getFullName());
                return;
            }
        }
    }
}
