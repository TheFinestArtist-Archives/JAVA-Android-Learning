// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.imageview.WebImageView;
import com.pinterest.ui.text.PButton;
import com.pinterest.ui.text.PTextView;

public class PersonListCell extends LinearLayout
{

    private PButton _actionBtn;
    private CheckBox _actionCheckBox;
    private Context _context;
    private PTextView _descView;
    protected boolean _grayOut;
    private WebImageView _imageView;
    private LinearLayout _personContainer;
    private TextView _titleView;
    private User _user;
    private String _userId;

    public PersonListCell(Context context)
    {
        this(context, null);
    }

    public PersonListCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _context = context;
    }

    private void inflateActionButton()
    {
        if (_actionBtn == null)
        {
            _actionBtn = (PButton)LayoutInflater.from(_context).inflate(0x7f030137, null);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.setMargins(Constants.MARGIN, 0, 0, 0);
            _actionBtn.setLayoutParams(layoutparams);
            _personContainer.addView(_actionBtn);
        }
    }

    private void inflateActionCheckBox()
    {
        if (_actionCheckBox == null)
        {
            _actionCheckBox = (CheckBox)LayoutInflater.from(_context).inflate(0x7f03011d, null);
            _personContainer.addView(_actionCheckBox);
        }
    }

    public User getUser()
    {
        return _user;
    }

    public String getUserId()
    {
        return _userId;
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        _personContainer = (LinearLayout)findViewById(0x7f0b0220);
        _imageView = (WebImageView)findViewById(0x7f0b0221);
        _imageView.setOval(true);
        _titleView = (TextView)findViewById(0x7f0b0222);
        _descView = (PTextView)findViewById(0x7f0b0223);
        _descView.setIconTint(Colors.RED);
    }

    public void reset()
    {
        setTitle(null);
        setDesc(null);
        setImage(((String) (null)));
        setActionButton(null, null);
        setActionButtonStyle(com.pinterest.ui.text.PButton.ButtonStyle.PLAIN);
    }

    public void setActionButton(String s, android.view.View.OnClickListener onclicklistener)
    {
        inflateActionButton();
        if (_actionBtn != null)
        {
            _actionBtn.setText(s);
            _actionBtn.setOnClickListener(onclicklistener);
            onclicklistener = _actionBtn;
            int i;
            if (s != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            onclicklistener.setVisibility(i);
        }
    }

    public void setActionButtonStyle(com.pinterest.ui.text.PButton.ButtonStyle buttonstyle)
    {
        inflateActionButton();
        if (_actionBtn != null)
        {
            _actionBtn.setStyle(buttonstyle);
        }
    }

    public void setActionButtonTag(Object obj)
    {
        inflateActionButton();
        if (_actionBtn != null)
        {
            _actionBtn.setTag(obj);
        }
    }

    public void setActionCheckBox(boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        inflateActionCheckBox();
        if (_actionCheckBox != null)
        {
            _actionCheckBox.setOnClickListener(onclicklistener);
            _actionCheckBox.setChecked(flag);
            CheckBox checkbox = _actionCheckBox;
            int i;
            if (onclicklistener != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            checkbox.setVisibility(i);
        }
    }

    public void setActionCheckBoxTag(Object obj)
    {
        inflateActionCheckBox();
        if (_actionCheckBox != null)
        {
            _actionCheckBox.setTag(obj);
        }
    }

    public void setDesc(String s)
    {
        _descView.setText(s);
        _descView.setCompoundDrawables(null, null, null, null);
        PTextView ptextview = _descView;
        int i;
        if (s != null)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ptextview.setVisibility(i);
    }

    public void setDesc(String s, int i)
    {
        setDesc(s);
        if (i != 0)
        {
            s = _descView.getCompoundDrawables();
            android.graphics.drawable.Drawable drawable = Resources.drawable(i);
            _descView.setCompoundDrawablesWithIntrinsicBounds(drawable, s[1], s[2], s[3]);
        }
    }

    public void setDesc(String s, Boolean boolean1, String s1)
    {
        if (ModelHelper.isValid(s))
        {
            int i;
            if (boolean1 == Boolean.TRUE)
            {
                i = 0x7f020155;
            } else
            {
                i = 0;
            }
            setDesc(s, i);
            return;
        }
        if (!ModelHelper.isValid(s1))
        {
            s1 = null;
        }
        setDesc(s1);
    }

    public void setGrayOut(boolean flag)
    {
        _grayOut = flag;
    }

    public void setImage(int i)
    {
        _imageView.setImageResource(i);
        _imageView.setVisibility(0);
    }

    public void setImage(String s)
    {
        if (s != null)
        {
            _imageView.loadUri(Uri.parse(s));
            _imageView.setVisibility(0);
            return;
        } else
        {
            _imageView.loadUri(null);
            _imageView.setVisibility(8);
            return;
        }
    }

    public void setTitle(String s)
    {
        _titleView.setText(s);
        if (_grayOut)
        {
            _titleView.setTextColor(Colors.TEXT_LIGHT);
        }
    }

    public void setUser(User user)
    {
        _user = user;
        if (user == null)
        {
            return;
        } else
        {
            setTitle(user.getFullName());
            setImage(user.getImageMediumUrl());
            setUserId(user.getUid());
            return;
        }
    }

    public void setUserId(String s)
    {
        _userId = s;
    }
}
