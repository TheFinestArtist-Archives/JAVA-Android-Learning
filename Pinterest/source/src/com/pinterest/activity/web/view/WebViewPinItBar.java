// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.text.PButton;

public class WebViewPinItBar extends RelativeLayout
{

    private PButton _openButton;
    private View _pinItButton;
    private String _url;

    public WebViewPinItBar(Context context)
    {
        this(context, null);
    }

    public WebViewPinItBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public WebViewPinItBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        _openButton = (PButton)findViewById(0x7f0b01c9);
        _openButton.setIconTint(0x7f090043);
        _openButton.setCompoundDrawablesWithIntrinsicBounds(Resources.drawable(0x7f020159), null, null, null);
        _pinItButton = findViewById(0x7f0b01c8);
        _pinItButton.setOnClickListener(new _cls1());
        _openButton.setOnClickListener(new _cls2());
    }

    public void setUrl(String s)
    {
        _url = s;
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final WebViewPinItBar this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PIN_REPIN_BUTTON, ComponentType.MODAL_PIN);
            view = new Intent(getContext(), com/pinterest/activity/create/PinItActivity);
            view.putExtra("android.intent.extra.TEXT", _url);
            getContext().startActivity(view);
        }

        _cls1()
        {
            this$0 = WebViewPinItBar.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final WebViewPinItBar this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.LINK_OUT_BUTTON, ComponentType.NAVIGATION);
            if (StringUtils.isNotEmpty(_url))
            {
                ActivityHelper.goIntentView(getContext(), _url);
            }
        }

        _cls2()
        {
            this$0 = WebViewPinItBar.this;
            super();
        }
    }

}
