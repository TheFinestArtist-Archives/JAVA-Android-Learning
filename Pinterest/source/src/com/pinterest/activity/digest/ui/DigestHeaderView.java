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
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.pinterest.activity.interest.view.FollowInterestButton;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.ui.imageview.GrayWebImageView;
import com.pinterest.ui.text.IconView;
import com.pinterest.ui.text.PTextView;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class DigestHeaderView extends RelativeLayout
{

    GrayWebImageView _coverImage;
    FollowInterestButton _followBtn;
    private List _includedItems;
    private DigestItem _item;
    IconView _removeBtn;
    View _separator;
    PTextView _titleVw;

    public DigestHeaderView(Context context)
    {
        super(context);
    }

    public DigestHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void setTitleDisplay(String s, String s1, String s2)
    {
        if (StringUtils.isEmpty(s) || StringUtils.isEmpty(s1))
        {
            return;
        }
        int j = Math.max(s.indexOf("{0}"), 0);
        String s3 = s.replace("{0}", s1);
        int i = -1;
        s = s3;
        if (StringUtils.isNotEmpty(s2))
        {
            i = Math.max(s3.indexOf("{1}"), 0);
            s = s3.replace("{1}", s2);
        }
        s = new SpannableString(s);
        s.setSpan(new StyleSpan(1), j, s1.length() + j, 33);
        if (StringUtils.isNotEmpty(s2))
        {
            s.setSpan(new StyleSpan(1), i, s2.length() + i, 33);
        }
        _titleVw.setText(s);
    }

    private void updateUI()
    {
        String s;
        PinterestJsonArray pinterestjsonarray;
        s = _item.getDescription();
        pinterestjsonarray = new PinterestJsonArray(_item.getDescriptionArgs());
        _followBtn.setVisibility(8);
        _removeBtn.setVisibility(0);
        _cls2..SwitchMap.com.pinterest.api.model.DigestItem.DigestMode[com.pinterest.api.model.DigestItem.DigestMode.withName(_item.getContainerType()).ordinal()];
        JVM INSTR tableswitch 1 6: default 96
    //                   1 105
    //                   2 176
    //                   3 258
    //                   4 258
    //                   5 389
    //                   6 389;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L5
_L1:
        _titleVw.setText(s);
        return;
_L2:
        Board board = ModelHelper.getBoard(_item.getBoardUid());
        if (board != null)
        {
            _coverImage.loadUri(Uri.parse(board.getImageCoverUrl()));
            _coverImage.setOval(false);
            setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), null);
        }
_L7:
        _removeBtn.setOnClickListener(new _cls1());
        return;
_L3:
        Board board1 = ModelHelper.getBoard(_item.getBoardUid());
        User user1 = ModelHelper.getUser(_item.getUserUid());
        if (board1 != null)
        {
            _coverImage.loadUri(Uri.parse(user1.getImageMediumUrl()));
            _coverImage.setOval(true);
            setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), pinterestjsonarray.b(1).a("render", ""));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Interest interest = ModelHelper.getInterest(_item.getInterestUid());
        if (interest != null)
        {
            _coverImage.loadUri(Uri.parse(interest.getImageGridLg2LineUrl()));
            _coverImage.setOval(false);
            if (com.pinterest.api.model.DigestItem.DigestMode.withName(_item.getContainerType()) == com.pinterest.api.model.DigestItem.DigestMode.INTEREST)
            {
                setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), null);
            } else
            {
                _followBtn.setVisibility(0);
                _followBtn.setInterest(interest);
                _removeBtn.setVisibility(8);
                setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), pinterestjsonarray.b(1).a("render", ""));
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        User user = ModelHelper.getUser(_item.getUserUid());
        if (user != null)
        {
            _coverImage.loadUri(Uri.parse(user.getImageMediumUrl()));
            _coverImage.setOval(true);
            if (com.pinterest.api.model.DigestItem.DigestMode.withName(_item.getContainerType()) == com.pinterest.api.model.DigestItem.DigestMode.USER)
            {
                setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), null);
            } else
            {
                setTitleDisplay(s, pinterestjsonarray.b(0).a("render", ""), pinterestjsonarray.b(1).a("render", ""));
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public DigestItem getItem()
    {
        return _item;
    }

    protected void onFinishInflate()
    {
        ButterKnife.a(this);
        super.onFinishInflate();
    }

    public void setDigestPin(DigestItem digestitem)
    {
        _item = digestitem;
        updateUI();
    }

    public void setIncludedItems(List list)
    {
        _includedItems = list;
    }

    public void showTopSeparator(boolean flag)
    {
        View view = _separator;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }



    private class _cls2
    {

        static final int $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[];

        static 
        {
            $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode = new int[com.pinterest.api.model.DigestItem.DigestMode.values().length];
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_BOARD.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.BOARD.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.INTEREST.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.REC_THROUGH_INTEREST.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$api$model$DigestItem$DigestMode[com.pinterest.api.model.DigestItem.DigestMode.USER_CATEGORY.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final DigestHeaderView this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.DIGEST_STORY_FEEDBACK_BUTTON, ComponentType.DIGEST_STORY_HEADER);
            view = new DigestFeedbackDialog(_item);
            view.setFirstIncludedPin(ModelHelper.getPin(((DigestItem)_includedItems.get(0)).getUid()));
            Events.post(new DialogEvent(view));
        }

        _cls1()
        {
            this$0 = DigestHeaderView.this;
            super();
        }
    }

}
