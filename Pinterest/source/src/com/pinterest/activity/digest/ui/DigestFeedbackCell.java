// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.imageview.GrayWebImageView;
import com.pinterest.ui.text.PTextView;

public class DigestFeedbackCell extends RelativeLayout
{

    GrayWebImageView _coverImage;
    PTextView _titleVw;

    public DigestFeedbackCell(Context context)
    {
        this(context, null);
    }

    public DigestFeedbackCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public static DigestFeedbackCell get(View view, ViewGroup viewgroup)
    {
        if (view == null || !(view instanceof DigestFeedbackCell))
        {
            return new DigestFeedbackCell(viewgroup.getContext());
        } else
        {
            return (DigestFeedbackCell)view;
        }
    }

    private void init()
    {
        inflate(getContext(), 0x7f0300e2, this);
        ButterKnife.a(this);
    }

    public void setFeedbackItem(com.pinterest.activity.digest.adapter.DigestFeedbackAdapter.FeedbackItem feedbackitem)
    {
        _coverImage.loadUri(Uri.parse(feedbackitem.getCoverUrl()));
        String s;
        int i;
        if (feedbackitem.getUnFollowItemType() == com.pinterest.activity.digest.adapter.DigestFeedbackAdapter.UnFollowItemType.USER)
        {
            _coverImage.setOval(true);
        } else
        {
            _coverImage.setOval(false);
        }
        if (feedbackitem.getUnFollowItemType() == com.pinterest.activity.digest.adapter.DigestFeedbackAdapter.UnFollowItemType.MY_BOARD)
        {
            i = 0x7f0e04cd;
        } else
        {
            i = 0x7f0e04cc;
        }
        s = Resources.string(i, new Object[] {
            feedbackitem.getDisplay()
        });
        i = s.indexOf(feedbackitem.getDisplay());
        feedbackitem = new SpannableString(s);
        feedbackitem.setSpan(new StyleSpan(1), i, s.length(), 33);
        _titleVw.setText(feedbackitem);
    }
}
