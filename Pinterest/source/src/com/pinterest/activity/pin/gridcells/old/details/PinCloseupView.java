// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.ui.imageview.WebImageView;
import com.pinterest.ui.progress.SmallLoadingView;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseUpImageView

public class PinCloseupView extends FrameLayout
{

    private PinCloseUpImageView _bigPinIv;
    private View _clickVw;
    private android.view.View.OnClickListener _onClickListener;
    private android.view.View.OnLongClickListener _onLongClickListener;
    private Pin _pin;
    private com.pinterest.ui.imageview.WebImageView.ImageListener _pinImageListener;
    private WebImageView _pinIv;
    private SmallLoadingView _pinPs;
    private ImageView _videoIv;
    private WebViewClient pinWebClient;

    public PinCloseupView(Context context)
    {
        this(context, null);
    }

    public PinCloseupView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        pinWebClient = new _cls2();
        _pinImageListener = new _cls3();
        _onLongClickListener = new _cls4();
        init();
    }

    private void init()
    {
        _pinIv = new WebImageView(getContext());
        _pinIv.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        _pinIv.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        _pinIv.setImageListener(_pinImageListener);
        addView(_pinIv);
        _clickVw = new View(getContext());
        _clickVw.setId(0x7f0b0007);
        _clickVw.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        _clickVw.setOnClickListener(_onClickListener);
        _clickVw.setBackgroundResource(0x7f0201c1);
        addView(_clickVw);
        _clickVw.setOnLongClickListener(_onLongClickListener);
    }

    private void removeProgressSpinner()
    {
        if (_pinPs != null)
        {
            removeView(_pinPs);
            _pinPs = null;
        }
    }

    private void showBigImage()
    {
        if (_bigPinIv != null)
        {
            return;
        } else
        {
            _bigPinIv = new PinCloseUpImageView(getContext());
            _bigPinIv.setBackgroundColor(Resources.color(0x7f090011));
            _bigPinIv.setWebViewClient(pinWebClient);
            _bigPinIv.setOnLongClickListener(_onLongClickListener);
            addView(_bigPinIv);
            _pinIv.bringToFront();
            _clickVw.bringToFront();
            return;
        }
    }

    private void showProgressSpinner()
    {
        if (_pinIv == null || _pinPs != null)
        {
            return;
        }
        _pinPs = new SmallLoadingView(getContext());
        int i = (int)Resources.dimension(0x7f0a00d0);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i, i);
        layoutparams.gravity = 17;
        if ((float)_pinIv.getLayoutParams().height > Device.getScreenHeight())
        {
            layoutparams.gravity = 49;
            layoutparams.setMargins(0, (int)(Device.getScreenHeight() / 2.0F), 0, 0);
        }
        _pinPs.setLayoutParams(layoutparams);
        addView(_pinPs);
    }

    private void showVideoIcon()
    {
        if (_videoIv != null)
        {
            return;
        } else
        {
            _videoIv = new ImageView(getContext());
            _videoIv.setImageResource(0x7f020156);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = 17;
            _videoIv.setLayoutParams(layoutparams);
            addView(_videoIv);
            return;
        }
    }

    private void updatePinIvSize(Pin pin)
    {
        if (pin != null && _pinIv != null && pin.getImageLargeWidth() != null && pin.getImageLargeHeight() != null)
        {
            int i = (int)(Device.getScreenWidth() - (float)FragmentHelper.getCloseupWidth(this));
            i = (int)(((Device.getScreenWidth() - (float)i) / (float)pin.getImageLargeWidth().intValue()) * ((float)pin.getImageLargeHeight().intValue() / Device.getDensity()));
            pin = _pinIv.getLayoutParams();
            if (pin != null)
            {
                pin.height = (int)Device.dpToPixel(i);
                _pinIv.setLayoutParams(pin);
                _clickVw.setLayoutParams(new android.widget.FrameLayout.LayoutParams(_pinIv.getLayoutParams()));
                return;
            }
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updatePinIvSize(_pin);
    }

    protected void onDetachedFromWindow()
    {
        _clickVw.setOnClickListener(null);
        _clickVw.setOnLongClickListener(null);
        removeProgressSpinner();
        super.onDetachedFromWindow();
    }

    public boolean performClick()
    {
        if (_onClickListener != null)
        {
            _onClickListener.onClick(this);
            return true;
        } else
        {
            return false;
        }
    }

    public void setOnPinClickListener(android.view.View.OnClickListener onclicklistener)
    {
        _onClickListener = onclicklistener;
        if (_clickVw != null)
        {
            _clickVw.setOnClickListener(_onClickListener);
        }
    }

    public void setPin(Pin pin)
    {
        setPin(pin, false);
    }

    public void setPin(Pin pin, final boolean forMeasure)
    {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if (pin != null && _pinIv != null && !pin.equals(_pin))
        {
            updatePinIvSize(pin);
            if (!forMeasure)
            {
                _pin = pin;
                final boolean isBigImage;
                boolean flag1;
                boolean flag2;
                final boolean isGif;
                if (_pin.getImageLargeWidth() == null || _pin.getImageLargeHeight() == null || _pin.getImageLargeWidth().intValue() >= 2048 || _pin.getImageLargeHeight().intValue() >= 2048)
                {
                    isBigImage = true;
                } else
                {
                    isBigImage = false;
                }
                flag1 = ImageCache.contains(_pin.getImageMediumUrl());
                flag2 = ImageCache.contains(_pin.getImageLargeUrl());
                isGif = _pin.isGif();
                if (!isBigImage && flag2)
                {
                    _pinIv.loadUrl(_pin.getImageLargeUrl());
                    flag = true;
                } else
                if (flag1)
                {
                    _pinIv.loadUrl(_pin.getImageMediumUrl());
                } else
                {
                    showProgressSpinner();
                }
                if (!flag && !forMeasure)
                {
                    postDelayed(new _cls1(), 500L);
                }
                _clickVw.setLayoutParams(new android.widget.FrameLayout.LayoutParams(_pinIv.getLayoutParams()));
                if (_pin.getVideo() == Boolean.TRUE)
                {
                    showVideoIcon();
                    return;
                }
            }
        }
        return;
    }






/*
    static WebImageView access$302(PinCloseupView pincloseupview, WebImageView webimageview)
    {
        pincloseupview._pinIv = webimageview;
        return webimageview;
    }

*/


    private class _cls2 extends WebViewClient
    {

        final PinCloseupView this$0;

        public void onLoadResource(WebView webview, String s)
        {
            removeProgressSpinner();
        }

        public void onPageFinished(WebView webview, String s)
        {
            removeProgressSpinner();
            class _cls1
                implements Runnable
            {

                final _cls2 this$1;

                public void run()
                {
                    if (_pinIv != null)
                    {
                        removeView(_pinIv);
                        _pinIv.setBitmap(null, false);
                        _pinIv = null;
                    }
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
            }

            if (_pinIv != null)
            {
                _pinIv.postDelayed(new _cls1(), 500L);
            }
        }

        _cls2()
        {
            this$0 = PinCloseupView.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.ui.imageview.WebImageView.ImageListener
    {

        final PinCloseupView this$0;

        public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
        {
            Events.post(new ImageLoadEvent(_pin));
        }

        _cls3()
        {
            this$0 = PinCloseupView.this;
            super();
        }

        private class ImageLoadEvent
        {

            private Pin _pin;

            public final Pin getPin()
            {
                return _pin;
            }

            public ImageLoadEvent(Pin pin)
            {
                _pin = pin;
            }
        }

    }


    private class _cls4
        implements android.view.View.OnLongClickListener
    {

        final PinCloseupView this$0;

        public boolean onLongClick(View view)
        {
            Events.post(new ShowPinContextMenuEvent(_pin));
            return true;
        }

        _cls4()
        {
            this$0 = PinCloseupView.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final PinCloseupView this$0;
        final boolean val$forMeasure;
        final boolean val$isBigImage;
        final boolean val$isGif;

        public void run()
        {
            if (isBigImage || isGif)
            {
                showBigImage();
                _bigPinIv.setPin(_pin, forMeasure);
                _bigPinIv.setLayoutParams(new android.widget.FrameLayout.LayoutParams(_pinIv.getLayoutParams()));
                return;
            } else
            {
                _pinIv.loadUrl(_pin.getImageLargeUrl(), false);
                class _cls1 extends com.pinterest.ui.imageview.WebImageView.ImageListener
                {

                    final _cls1 this$1;

                    public void onBitmapSet()
                    {
                        removeProgressSpinner();
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
                }

                _pinIv.setImageListener(new _cls1());
                return;
            }
        }

        _cls1()
        {
            this$0 = PinCloseupView.this;
            isBigImage = flag;
            isGif = flag1;
            forMeasure = flag2;
            super();
        }
    }

}
