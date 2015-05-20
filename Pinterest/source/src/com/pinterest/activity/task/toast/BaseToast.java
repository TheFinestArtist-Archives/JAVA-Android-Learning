// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.pinterest.activity.task.toast.view.BaseToastView;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.imageview.WebImageView;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public abstract class BaseToast
{

    public static final int LONG = 7000;
    public static final int MEDIUM = 3000;
    public static final int SHORT = 1500;
    private int _arrowRes;
    private int _buttonDrawable;
    private String _buttonText;
    private boolean _buttonVis;
    private int _duration;
    private int _gravity;
    private boolean _imageOval;
    private int _imageResId;
    private Uri _imageUri;
    private String _imageUrl;
    private boolean _isDismissed;
    private String _message;
    private android.view.View.OnClickListener _onButtonClickListener;
    private android.view.View.OnClickListener _onToastClickListener;
    private String _secondaryMessage;
    private String _topTitle;

    public BaseToast()
    {
        _duration = 3000;
        _gravity = 0;
        _buttonDrawable = 0;
        _arrowRes = 0;
        _imageOval = true;
        _imageResId = -1;
    }

    protected BaseToast(String s)
    {
        _duration = 3000;
        _gravity = 0;
        _buttonDrawable = 0;
        _arrowRes = 0;
        _imageOval = true;
        _imageResId = -1;
        _message = s;
    }

    public int getDuration()
    {
        return _duration;
    }

    public int getGravity()
    {
        return _gravity;
    }

    public View getView(final ToastContainer container)
    {
        byte byte0 = 8;
        final BaseToastView toastVw = new BaseToastView(container.getContext());
        toastVw.setId((new Random()).nextInt());
        toastVw.setOnClickListener(new _cls1());
        toastVw.messageIc.setOval(_imageOval);
        if (StringUtils.isNotEmpty(_imageUrl))
        {
            toastVw.messageIc.loadUrl(_imageUrl);
        } else
        if (_imageUri != null)
        {
            toastVw.messageIc.loadUri(_imageUri);
        } else
        if (_imageResId != -1)
        {
            toastVw.messageIc.setImageResource(_imageResId);
        } else
        {
            toastVw.messageIc.setVisibility(8);
        }
        if (!StringUtils.isEmpty(_topTitle))
        {
            toastVw.topTv.setText(_topTitle);
            ViewHelper.setVisibility(toastVw.topTv, 0);
            ViewHelper.setVisibility(toastVw.divider, 0);
        }
        toastVw.titleTv.setText(_message);
        if (StringUtils.isEmpty(_secondaryMessage))
        {
            toastVw.subtitleTv.setVisibility(8);
        } else
        {
            toastVw.subtitleTv.setText(_secondaryMessage);
        }
        if (!_buttonVis)
        {
            toastVw.actionBt.setVisibility(8);
            if (_arrowRes != 0)
            {
                toastVw.arrow.setImageResource(_arrowRes);
            }
            container = toastVw.arrow;
            if (_onToastClickListener != null)
            {
                byte0 = 0;
            }
            container.setVisibility(byte0);
            return toastVw;
        }
        toastVw.actionBt.setText(_buttonText);
        toastVw.actionBt.setOnClickListener(new _cls2());
        if (_buttonDrawable != 0)
        {
            ViewHelper.setLeftDrawable(toastVw.actionBt, _buttonDrawable);
            if (TextUtils.isEmpty(_buttonText))
            {
                toastVw.actionBt.setCompoundDrawablePadding(0);
            }
        }
        toastVw.arrow.setVisibility(8);
        return toastVw;
    }

    public boolean isDismissed()
    {
        return _isDismissed;
    }

    public void onToastCancelled(Context context)
    {
    }

    public void onToastCompleted(Context context)
    {
    }

    public void setArrowDrawable(int i)
    {
        _arrowRes = i;
    }

    public void setButtonDrawable(int i)
    {
        _buttonDrawable = i;
    }

    public void setButtonText(String s)
    {
        _buttonText = s;
        setButtonVis(true);
    }

    public void setButtonVis(boolean flag)
    {
        _buttonVis = flag;
    }

    public void setDismissed(boolean flag)
    {
        _isDismissed = flag;
    }

    public void setDuration(int i)
    {
        _duration = i;
    }

    public void setGravity(int i)
    {
        _gravity = i;
    }

    public void setImageOval(boolean flag)
    {
        _imageOval = flag;
    }

    public void setImageResource(int i)
    {
        _imageResId = i;
    }

    public void setImageUri(Uri uri)
    {
        _imageUri = uri;
    }

    public void setImageUrl(String s)
    {
        _imageUrl = s;
    }

    public void setLayoutGravity(int i)
    {
        _gravity = i;
    }

    public void setMessage(int i)
    {
        _message = Resources.string(i);
    }

    public void setMessage(String s)
    {
        _message = s;
    }

    public void setOnButtonClickListener(android.view.View.OnClickListener onclicklistener)
    {
        _onButtonClickListener = onclicklistener;
    }

    public void setSecondaryMessage(int i)
    {
        _secondaryMessage = Resources.string(i);
    }

    public void setSecondaryMessage(String s)
    {
        _secondaryMessage = s;
    }

    public void setToastOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        _onToastClickListener = onclicklistener;
    }

    public void setTopTitle(int i)
    {
        _topTitle = Resources.string(i);
    }

    public void setTopTitle(String s)
    {
        _topTitle = s;
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BaseToast this$0;
        final ToastContainer val$container;
        final BaseToastView val$toastVw;

        public void onClick(View view)
        {
            if (_onToastClickListener != null)
            {
                _onToastClickListener.onClick(view);
                container.dismiss(toastVw);
            }
        }

        _cls1()
        {
            this$0 = BaseToast.this;
            container = toastcontainer;
            toastVw = basetoastview;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final BaseToast this$0;
        final ToastContainer val$container;
        final BaseToastView val$toastVw;

        public void onClick(View view)
        {
            container.dismiss(toastVw);
            if (_onButtonClickListener != null)
            {
                _onButtonClickListener.onClick(toastVw);
                return;
            } else
            {
                onToastCancelled(container.getContext());
                return;
            }
        }

        _cls2()
        {
            this$0 = BaseToast.this;
            container = toastcontainer;
            toastVw = basetoastview;
            super();
        }
    }

}
