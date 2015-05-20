// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.pinterest.api.model.Interest;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.FontUtils;
import com.pinterest.ui.imageview.ProportionalImageView;
import com.pinterest.ui.text.PTextView;
import org.apache.commons.lang3.StringUtils;

public class InterestGridCell extends FrameLayout
{

    private static final float CORNER_PADDING = Resources.dimension(0x7f0a0069);
    private boolean _bounceOnTouch;
    private boolean _dimOnTouch;
    private int _dominantColor;
    protected boolean _hideImage;
    protected ProportionalImageView _image;
    private Integer _imageBackground;
    private int _imageCornerRadius;
    private Interest _interest;
    private boolean _isSelected;
    protected View _overlay;
    protected PTextView _title;
    private FrameLayout _wrapperLayout;
    android.view.View.OnTouchListener touchListener;

    public InterestGridCell(Context context)
    {
        this(context, null);
    }

    public InterestGridCell(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public InterestGridCell(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        touchListener = new _cls1();
        init();
    }

    public static InterestGridCell from(View view, Context context)
    {
        if (view instanceof InterestGridCell)
        {
            return (InterestGridCell)view;
        } else
        {
            return new InterestGridCell(context);
        }
    }

    private void init()
    {
        inflate(getContext(), 0x7f0300bd, this);
        setForegroundVisibility(0);
        _image = (ProportionalImageView)findViewById(0x7f0b0039);
        setImageCornerRadius(0);
        _title = (PTextView)findViewById(0x7f0b003d);
        FontUtils.setFont(com.pinterest.kit.utils.FontUtils.TypefaceId.BOLD, _title);
        _wrapperLayout = (FrameLayout)findViewById(0x7f0b01b7);
        _overlay = findViewById(0x7f0b01b8);
        setOnTouchListener(touchListener);
    }

    public void enableTransparentOverlay()
    {
        float f;
        ShapeDrawable shapedrawable;
        if (_imageCornerRadius > 0)
        {
            f = _imageCornerRadius;
        } else
        {
            f = CORNER_PADDING;
        }
        shapedrawable = new ShapeDrawable(new RoundRectShape(new float[] {
            f, f, f, f, f, f, f, f
        }, null, null));
        shapedrawable.getPaint().setColor(getResources().getColor(0x7f090048));
        _overlay.setBackgroundDrawable(shapedrawable);
    }

    public Interest getInterest()
    {
        return _interest;
    }

    public PTextView getTitleTV()
    {
        return _title;
    }

    public void loadImageUrl(String s)
    {
        if (s != null && s.equals(_image.getUrl()))
        {
            return;
        } else
        {
            _image.loadUrl(s);
            return;
        }
    }

    public void setBounceOnTouch(boolean flag)
    {
        _bounceOnTouch = flag;
    }

    public void setDimOnTouch(boolean flag)
    {
        _dimOnTouch = flag;
    }

    public void setForegroundVisibility(int i)
    {
        switch (i)
        {
        default:
            setForeground(null);
            return;

        case 0: // '\0'
            setForeground(Resources.drawable(0x7f020069));
            break;
        }
    }

    public void setHideImage(boolean flag)
    {
        _hideImage = flag;
    }

    public void setImageBackgroundResource(Integer integer)
    {
        _imageBackground = integer;
        if (integer == null)
        {
            _image.setImageDrawable(null);
            return;
        } else
        {
            _image.setImageDrawable(Resources.drawable(_imageBackground.intValue()));
            return;
        }
    }

    public void setImageCornerRadius(int i)
    {
        _imageCornerRadius = i;
        _image.setCornerRadius(i);
    }

    public void setImageDimensions(int i, int j)
    {
        _image.setDisableResize(true);
        _image.getLayoutParams().width = i;
        _image.getLayoutParams().height = j;
    }

    public void setImageTag(Object obj)
    {
        if (_image != null)
        {
            _image.setImageTag(obj);
        }
    }

    public void setInterest(Interest interest, Integer integer, boolean flag)
    {
label0:
        {
label1:
            {
                if (interest == null)
                {
                    return;
                }
                _interest = interest;
                if (flag)
                {
                    break label0;
                }
                String s = interest.getDominantColor();
                if (!StringUtils.isEmpty(s))
                {
                    integer = s;
                    if (s.compareToIgnoreCase("#eeeeee") <= 0)
                    {
                        break label1;
                    }
                }
                integer = "#55000000";
            }
            _dominantColor = Color.parseColor(integer);
        }
        if (!flag)
        {
            if (_imageBackground != null)
            {
                _image.setImageDrawable(Resources.drawable(_imageBackground.intValue()));
            } else
            {
                float f;
                if (_imageCornerRadius > 0)
                {
                    f = _imageCornerRadius;
                } else
                {
                    f = CORNER_PADDING;
                }
                integer = new ShapeDrawable(new RoundRectShape(new float[] {
                    f, f, f, f, f, f, f, f
                }, null, null));
                integer.getPaint().setColor(_dominantColor);
                _image.setBackgroundDrawable(integer);
            }
            if (_hideImage)
            {
                loadImageUrl(null);
            } else
            {
                loadImageUrl(interest.getBestImageUrl(_title.getLineCount()));
            }
        }
        setTitleText(interest.getName());
    }

    public void setTitleText(String s)
    {
        _title.setText(s);
    }

    public void setTitleTextSize(float f)
    {
        _title.setTextSize(0, f);
    }

    public void setWrapperLayoutParams(android.widget.FrameLayout.LayoutParams layoutparams)
    {
        _wrapperLayout.setLayoutParams(layoutparams);
    }





/*
    static boolean access$102(InterestGridCell interestgridcell, boolean flag)
    {
        interestgridcell._isSelected = flag;
        return flag;
    }

*/


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final InterestGridCell this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (_bounceOnTouch)
            {
                view = new AnimatorSet();
                if (motionevent.getAction() == 0 && !_isSelected)
                {
                    view.playTogether(new Animator[] {
                        AnimationUtils.springAnimate(InterestGridCell.this, "scaleX", 1.0F, 0.85F, 1.0F, 1.25F), AnimationUtils.springAnimate(InterestGridCell.this, "scaleY", 1.0F, 0.85F, 1.0F, 1.25F)
                    });
                    view.start();
                } else
                if ((motionevent.getAction() == 1 || motionevent.getAction() == 3) && _isSelected)
                {
                    view.playTogether(new Animator[] {
                        AnimationUtils.springAnimate(InterestGridCell.this, "scaleX", 0.85F, 1.0F, 1.0F, 1.25F), AnimationUtils.springAnimate(InterestGridCell.this, "scaleY", 0.85F, 1.0F, 1.0F, 1.25F)
                    });
                    view.start();
                }
            }
            if (_dimOnTouch)
            {
                if (motionevent.getAction() == 0 && !_isSelected)
                {
                    _image.setColorFilter(getResources().getColor(0x7f090049));
                    _isSelected = true;
                    return true;
                }
                if (motionevent.getAction() == 1 && _isSelected)
                {
                    _image.setColorFilter(0);
                    _isSelected = false;
                    callOnClick();
                    return true;
                }
                if (motionevent.getAction() == 3 && _isSelected)
                {
                    _image.setColorFilter(0);
                    _isSelected = false;
                    return true;
                }
            }
            return false;
        }

        _cls1()
        {
            this$0 = InterestGridCell.this;
            super();
        }
    }

}
