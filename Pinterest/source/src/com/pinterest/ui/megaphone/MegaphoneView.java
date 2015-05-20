// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.megaphone;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.Device;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.anim.SlideUpDownAnimation;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.AnimationUtils;
import com.pinterest.schemas.experiences.NagDisplayType;
import com.pinterest.ui.ViewHelper;
import org.apache.commons.lang3.StringUtils;

public class MegaphoneView extends FrameLayout
{

    private static final int HORIZONTAL_PADDING = (int)Resources.dimension(0x7f0a00a0);
    private static final int MAX_WIDTH = (int)Resources.dimension(0x7f0a00a1);
    private static final int VERTICAL_PADDING = (int)Resources.dimension(0x7f0a00a2);
    private ViewGroup _content;
    protected Context _context;
    private TextView _descTv;
    private boolean _dismissable;
    private View _divider;
    private boolean _enableAnimation;
    private Button _negativeBtn;
    private ListView _parentLv;
    private Button _positiveBtn;
    private ImageView _svgIv;
    private TextView _titleTv;
    private boolean isBackgroundSvg;
    private boolean isShown;
    private boolean isSvgLoaded;
    private boolean isViewed;
    private boolean showWithoutSvg;

    public MegaphoneView(Context context)
    {
        this(context, null, 0);
    }

    public MegaphoneView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MegaphoneView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _dismissable = true;
        _context = context;
    }

    private void slideUpAnimate()
    {
        int i = -(getMeasuredHeight() + (int)getY() + VERTICAL_PADDING);
        AnimationUtils.springAnimate(_content, "translationY", _content.getTranslationY(), i, 0.65F, 0.32F).start();
        SlideUpDownAnimation slideupdownanimation = new SlideUpDownAnimation(this, false, getMeasuredHeight());
        slideupdownanimation.setDuration(200L);
        slideupdownanimation.setAnimationListener(new _cls4());
        startAnimation(slideupdownanimation);
    }

    public void addSvgBackground(final int resId)
    {
        if (isSvgLoaded)
        {
            return;
        } else
        {
            (new _cls2()).execute();
            return;
        }
    }

    public void hide()
    {
        isShown = false;
        if (!isBackgroundSvg || isSvgLoaded)
        {
            slideUpAnimate();
        }
        if (isSvgLoaded)
        {
            _svgIv.setImageBitmap(null);
            isSvgLoaded = false;
        }
        showWithoutSvg = false;
    }

    public void hideAndUpdate(boolean flag)
    {
        isShown = false;
        if (!flag)
        {
            hide();
        }
    }

    public boolean isShown()
    {
        return super.isShown() && isShown;
    }

    public boolean isViewed()
    {
        return isViewed;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        measure(-1, -2);
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        _content = (ViewGroup)findViewById(0x7f0b016a);
        _svgIv = (ImageView)findViewById(0x7f0b0241);
        _titleTv = (TextView)findViewById(0x7f0b0242);
        _descTv = (TextView)findViewById(0x7f0b0243);
        _positiveBtn = (Button)findViewById(0x7f0b0247);
        _negativeBtn = (Button)findViewById(0x7f0b0246);
        _divider = findViewById(0x7f0b0244);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (getLayoutParams() == null)
        {
            return;
        }
        i = (int)Device.getScreenWidth();
        j = Math.min(MAX_WIDTH, i - HORIZONTAL_PADDING * 2);
        android.view.ViewGroup.LayoutParams layoutparams = _content.getLayoutParams();
        layoutparams.width = Math.min(_content.getMeasuredWidth(), j);
        _content.setLayoutParams(layoutparams);
        if (Experiments.l())
        {
            android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)getLayoutParams();
            layoutparams1.topMargin = HORIZONTAL_PADDING;
            setLayoutParams(layoutparams1);
            return;
        } else
        {
            android.view.ViewGroup.LayoutParams layoutparams2 = _svgIv.getLayoutParams();
            layoutparams2.width = i;
            layoutparams2.height = _content.getMeasuredHeight() + VERTICAL_PADDING * 2;
            _svgIv.setLayoutParams(layoutparams2);
            android.view.ViewGroup.LayoutParams layoutparams3 = getLayoutParams();
            layoutparams3.width = layoutparams2.width;
            layoutparams3.height = layoutparams2.height;
            setLayoutParams(layoutparams3);
            return;
        }
    }

    public void setBackgroundType(int i)
    {
        if (i != NagDisplayType.STANDARD.getValue()) goto _L2; else goto _L1
_L1:
        if (!Experiments.l()) goto _L4; else goto _L3
_L3:
        isBackgroundSvg = false;
_L6:
        return;
_L4:
        isBackgroundSvg = true;
        addSvgBackground(0x7f06000a);
        return;
_L2:
        if (i == NagDisplayType.BANNER.getValue())
        {
            isBackgroundSvg = false;
            _svgIv.setImageResource(0x7f0201a9);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setDesc(String s)
    {
        _descTv.setText(s);
    }

    public void setDismissable(boolean flag)
    {
        _dismissable = flag;
    }

    public void setEnableAnimation(boolean flag)
    {
        _enableAnimation = flag;
    }

    public void setListViewParent(ListView listview)
    {
        _parentLv = listview;
    }

    public void setNegativeButton(String s, final android.view.View.OnClickListener onClick)
    {
        if (StringUtils.isNotEmpty(s))
        {
            _negativeBtn.setVisibility(0);
            _negativeBtn.setText(s);
            _negativeBtn.setOnClickListener(new _cls1());
            return;
        } else
        {
            _negativeBtn.setVisibility(8);
            return;
        }
    }

    public void setPositiveButton(String s, android.view.View.OnClickListener onclicklistener)
    {
        _positiveBtn.setText(s);
        _positiveBtn.setOnClickListener(onclicklistener);
    }

    public void setStyleByDisplayType(int i)
    {
        if (i == NagDisplayType.BANNER.getValue())
        {
            _titleTv.setSingleLine(false);
            _titleTv.setMaxLines(2);
            _titleTv.setTextSize(0, getResources().getDimension(0x7f0a00fd));
            ViewHelper.setVisibility(_descTv, false);
            ViewHelper.setVisibility(_divider, false);
        }
    }

    public void setTitle(String s)
    {
        _titleTv.setText(s);
    }

    public void setViewed(String s)
    {
        isViewed = true;
        AnalyticsApi.b((new StringBuilder("NAG_")).append(s).toString());
    }

    public void show()
    {
        boolean flag = true;
        isShown = true;
        if (isBackgroundSvg && !isSvgLoaded && !showWithoutSvg)
        {
            return;
        }
        int i;
        if (_negativeBtn.getVisibility() != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        _titleTv.setGravity(i);
        _descTv.setGravity(i);
        setTranslationY(0.0F);
        measure(-1, -2);
        if (_parentLv != null)
        {
            _parentLv.removeHeaderView(this);
            _parentLv.addHeaderView(this);
        }
        post(new _cls3());
        if (_enableAnimation)
        {
            i = -(getMeasuredHeight() + (int)getY() + VERTICAL_PADDING);
            _content.setTranslationY(i);
            AnimationUtils.springAnimate(_content, "translationY", i, 0, 0.65F, 0.32F).start();
        }
        Experiments.a("android_clean_nag");
    }






/*
    static boolean access$302(MegaphoneView megaphoneview, boolean flag)
    {
        megaphoneview.isSvgLoaded = flag;
        return flag;
    }

*/



/*
    static boolean access$502(MegaphoneView megaphoneview, boolean flag)
    {
        megaphoneview.showWithoutSvg = flag;
        return flag;
    }

*/


    private class _cls4
        implements android.view.animation.Animation.AnimationListener
    {

        final MegaphoneView this$0;

        public void onAnimationEnd(Animation animation)
        {
            setVisibility(8);
            if (_parentLv != null)
            {
                _parentLv.removeHeaderView(MegaphoneView.this);
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        _cls4()
        {
            this$0 = MegaphoneView.this;
            super();
        }
    }


    private class _cls2 extends BackgroundTask
    {

        private SVG _svg;
        final MegaphoneView this$0;
        final int val$resId;

        public void onFinish()
        {
            Picture picture = _svg.a();
            Bitmap bitmap;
            try
            {
                bitmap = Bitmap.createBitmap(picture.getWidth(), picture.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                CrashReporting.logHandledException(outofmemoryerror);
                outofmemoryerror = null;
            }
            if (bitmap != null)
            {
                picture.draw(new Canvas(bitmap));
                if (_svgIv != null)
                {
                    _svgIv.setImageBitmap(bitmap);
                    isSvgLoaded = true;
                    if (isShown)
                    {
                        show();
                    }
                }
            } else
            {
                showWithoutSvg = true;
            }
            _svg = null;
        }

        public void run()
        {
            _svg = (new SVGBuilder()).a(getResources(), resId).a();
        }

        _cls2()
        {
            this$0 = MegaphoneView.this;
            resId = i;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final MegaphoneView this$0;
        final android.view.View.OnClickListener val$onClick;

        public void onClick(View view)
        {
            if (onClick != null)
            {
                onClick.onClick(view);
            }
            if (_dismissable)
            {
                slideUpAnimate();
            }
        }

        _cls1()
        {
            this$0 = MegaphoneView.this;
            onClick = onclicklistener;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MegaphoneView this$0;

        public void run()
        {
            if (getParent() != null)
            {
                setVisibility(0);
            }
        }

        _cls3()
        {
            this$0 = MegaphoneView.this;
            super();
        }
    }

}
