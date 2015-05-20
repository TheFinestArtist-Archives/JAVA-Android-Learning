// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.search.model.GuidedSearchTypeAheadItem;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.imageview.WebImageView;
import com.pinterest.ui.text.IconView;
import org.apache.commons.lang3.StringUtils;

public class GuidedSearchDropDownCell extends LinearLayout
{

    RelativeLayout _autocompleteHeader;
    TextView _autocompleteText;
    TextView _desc;
    TextView _desc2;
    View _dividerView;
    TextView _historyHeader;
    IconView _iconImage;
    WebImageView _imageView;
    protected GuidedSearchTypeAheadItem _item;
    ImageView _overlayImage;
    IconView _rightIcon;
    View _rightImageLayout;
    View _sectionBody;
    LinearLayout _sectionHeader;
    TextView _titleTextView;

    public GuidedSearchDropDownCell(Context context)
    {
        super(context);
    }

    public GuidedSearchDropDownCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void adjustTitleTypeface()
    {
        if (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN || _item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER || _item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD || _item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_MY_PIN)
        {
            _titleTextView.setTypeface(Typeface.DEFAULT);
            return;
        } else
        {
            _titleTextView.setTypeface(Typeface.DEFAULT_BOLD);
            return;
        }
    }

    private void loadRightImage()
    {
label0:
        {
            if (_rightImageLayout != null)
            {
                if (_item.getItemType() != com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN && _item.getItemType() != com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER && _item.getItemType() != com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD && _item.getItemType() != com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_MY_PIN)
                {
                    break label0;
                }
                _rightImageLayout.setVisibility(0);
            }
            return;
        }
        _rightImageLayout.setVisibility(8);
    }

    private void resetCells()
    {
        _imageView.clear();
        _titleTextView.setText(null);
        _desc.setText(null);
        _desc.setCompoundDrawables(null, null, null, null);
    }

    private void setBackground()
    {
        switch (_cls1..SwitchMap.com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType[_item.getItemType().ordinal()])
        {
        default:
            setBackgroundResource(0x7f02003b);
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            setBackgroundColor(Resources.color(0x7f090045));
            break;
        }
    }

    private void setSectionBody()
    {
        switch (_cls1..SwitchMap.com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType[_item.getItemType().ordinal()])
        {
        default:
            _sectionBody.setVisibility(8);
            return;

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
            _sectionBody.setVisibility(0);
            break;
        }
        loadLeftImage();
        loadRightImage();
        setTitle();
        setDesc();
    }

    private void setSectionHeader()
    {
        switch (_cls1..SwitchMap.com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType[_item.getItemType().ordinal()])
        {
        default:
            _sectionHeader.setVisibility(8);
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            _sectionHeader.setVisibility(0);
            _historyHeader.setVisibility(0);
            _dividerView.setVisibility(8);
            _historyHeader.setText(_item.getTitle());
            _autocompleteHeader.setVisibility(8);
            return;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            _sectionHeader.setVisibility(0);
            _historyHeader.setVisibility(8);
            _dividerView.setVisibility(8);
            _autocompleteHeader.setVisibility(0);
            _autocompleteText.setText(_item.getTitle());
            return;

        case 1: // '\001'
            _sectionHeader.setVisibility(0);
            _historyHeader.setVisibility(8);
            _dividerView.setVisibility(0);
            _autocompleteHeader.setVisibility(8);
            return;
        }
    }

    private void updateUi()
    {
        if (_titleTextView == null || _item == null)
        {
            return;
        } else
        {
            resetCells();
            setBackground();
            setSectionHeader();
            setSectionBody();
            return;
        }
    }

    protected void loadLeftImage()
    {
        byte byte1;
        byte1 = 8;
        if (Experiments.p() && (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN || _item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_LOCAL_CACHE))
        {
            _imageView.setVisibility(8);
            _overlayImage.setVisibility(8);
            _iconImage.setVisibility(0);
            return;
        }
        if (_item.getImageUri() == null) goto _L2; else goto _L1
_L1:
        Uri uri = Uri.parse(_item.getImageUri());
        if (uri == null) goto _L2; else goto _L3
_L3:
        byte byte0;
        _imageView.loadUri(uri);
        byte0 = 1;
_L5:
        Object obj;
        int i;
        if (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER)
        {
            _imageView.setOval(true);
        } else
        {
            _imageView.setOval(false);
        }
        obj = _imageView;
        if (byte0 != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((WebImageView) (obj)).setVisibility(i);
        obj = _overlayImage;
        if (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ImageView) (obj)).setVisibility(i);
        obj = _iconImage;
        if (byte0 != 0)
        {
            byte0 = byte1;
        } else
        {
            byte0 = 0;
        }
        ((IconView) (obj)).setVisibility(byte0);
        return;
_L2:
        byte0 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onFinishInflate()
    {
        ButterKnife.a(this);
        _iconImage.setTint(0x7f090073);
        super.onFinishInflate();
    }

    protected void setDesc()
    {
        if (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER)
        {
            _desc.setVisibility(0);
            _desc2.setVisibility(0);
            String s = Resources.stringPlural(0x7f0d0007, Integer.valueOf(_item.getFollowersCount()));
            _desc.setText(s);
            s = Resources.stringPlural(0x7f0d0015, Integer.valueOf(_item.getPinCount()));
            _desc2.setText(s);
            return;
        }
        if (_item.getItemType() == com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD)
        {
            if (StringUtils.isNotEmpty(_item.getOwner()))
            {
                _desc.setVisibility(0);
                _desc.setText(Resources.string(0x7f0e004f, new Object[] {
                    _item.getOwner()
                }));
                _desc2.setVisibility(0);
                String s1 = Resources.stringPlural(0x7f0d0015, Integer.valueOf(_item.getPinCount()));
                _desc2.setText(s1);
                return;
            } else
            {
                _desc.setVisibility(8);
                _desc2.setVisibility(8);
                return;
            }
        } else
        {
            _desc.setVisibility(8);
            _desc2.setVisibility(8);
            return;
        }
    }

    public void setItem(GuidedSearchTypeAheadItem guidedsearchtypeaheaditem)
    {
        _item = guidedsearchtypeaheaditem;
        if (_rightImageLayout != null)
        {
            _rightImageLayout.setTag(_item);
        }
        updateUi();
    }

    public void setRightIvOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (_rightImageLayout != null)
        {
            _rightImageLayout.setOnClickListener(onclicklistener);
        }
    }

    protected void setTitle()
    {
        _titleTextView.setText(_item.getTitle());
        adjustTitleTypeface();
    }

    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[];

        static 
        {
            $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType = new int[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.values().length];
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.HEADER_DIVIDER.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN_HEADER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD_HEADER.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER_HEADER.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_SEARCH_ALL.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER_SEARCH_ALL.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD_SEARCH_ALL.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PINNER.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.BOARD.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PIN.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_PINNER.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_BOARD.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.RECENT_HISTORY_MY_PIN.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN_LOCAL_CACHE.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$activity$search$model$GuidedSearchTypeAheadItem$ItemType[com.pinterest.activity.search.model.GuidedSearchTypeAheadItem.ItemType.PIN.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
