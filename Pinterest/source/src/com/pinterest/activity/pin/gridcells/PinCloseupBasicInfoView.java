// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.User;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.text.HashTag;
import com.pinterest.ui.text.HashTagUtils;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView

public class PinCloseupBasicInfoView extends PinCloseupSubView
    implements android.view.View.OnClickListener
{

    private IconTextCellView _boardVw;
    private TextView _descriptionTv;
    private IconTextCellView _pinnerVw;

    public PinCloseupBasicInfoView(Context context)
    {
        super(context);
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        setOrientation(1);
        View view = new View(getContext());
        view.setBackgroundColor(Colors.LIGHT_GRAY_SOLID);
        addView(view, -1, Constants.HAIRLINE);
        _descriptionTv = new TextView(getContext(), null, 0x7f0f01a9);
        _descriptionTv.setPadding(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, 0);
        _descriptionTv.setMaxLines(20);
        addView(_descriptionTv, -1, -2);
        _pinnerVw = new IconTextCellView(getContext());
        _pinnerVw.setImageOval(true);
        _pinnerVw.setOnClickListener(this);
        _pinnerVw.setPadding(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, Constants.MARGIN);
        _pinnerVw.setBackgroundResource(0x7f0201c1);
        addView(_pinnerVw, -1, -2);
        view = new View(getContext());
        view.setBackgroundColor(Colors.LIGHT_GRAY_SOLID);
        addView(view, -1, Constants.HAIRLINE);
        _boardVw = new IconTextCellView(getContext());
        _boardVw.setImageRounded(true);
        _boardVw.setOnClickListener(this);
        _boardVw.setBackgroundResource(0x7f0201c1);
        _boardVw.setPadding(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, Constants.MARGIN);
        addView(_boardVw, -1, -2);
        view = new View(getContext());
        view.setBackgroundColor(Colors.LIGHT_GRAY_SOLID);
        addView(view, -1, Constants.HAIRLINE);
    }

    public void onClick(View view)
    {
        if (view == _pinnerVw)
        {
            Pinalytics.a(ElementType.PIN_USER, ComponentType.MODAL_PIN, _pin.getUserUid());
            Events.post(new Navigation(Location.USER, _pin.getUser()));
        } else
        if (view == _boardVw)
        {
            Pinalytics.a(ElementType.PIN_BOARD, ComponentType.MODAL_PIN, _pin.getBoardUid());
            if (_pin.getBoard() != null)
            {
                Events.post(new Navigation(Location.BOARD, _pin.getBoard()));
                return;
            } else
            {
                Events.post(new Navigation(Location.BOARD, _pin.getBoardUid()));
                return;
            }
        }
    }

    protected boolean shouldUpdateView()
    {
        return true;
    }

    protected void updateView()
    {
        if (StringUtils.isNotEmpty(_pin.getCleanDescription()))
        {
            Object obj1 = _pin.getDescription();
            Object obj = HashTagUtils.getSpans(((String) (obj1)), '#');
            if (((ArrayList) (obj)).size() > 0)
            {
                obj1 = new SpannableString(((CharSequence) (obj1)));
                for (int i = 0; i < ((ArrayList) (obj)).size(); i++)
                {
                    int ai[] = (int[])((ArrayList) (obj)).get(i);
                    ((SpannableString) (obj1)).setSpan(new HashTag(), ai[0], ai[1], 0);
                }

                _descriptionTv.setText(((CharSequence) (obj1)));
                _descriptionTv.setMovementMethod(LinkMovementMethod.getInstance());
            } else
            {
                _descriptionTv.setText(((CharSequence) (obj1)));
            }
            _descriptionTv.setVisibility(0);
        } else
        {
            _descriptionTv.setVisibility(8);
        }
        obj = _pin.getUser();
        if (obj != null)
        {
            _pinnerVw.setImageUrl(((User) (obj)).getImageMediumUrl());
            if (StringUtils.isNotBlank(((User) (obj)).getFullName()))
            {
                _pinnerVw.setTitle(Resources.string(0x7f0e0378, new Object[] {
                    (new StringBuilder("<b>")).append(((User) (obj)).getFullName()).append("</b>").toString()
                }));
            }
        }
        obj = _pin.getBoard();
        if (obj != null)
        {
            _boardVw.setImageUrl(((Board) (obj)).getImagePreviewUrl());
            if (StringUtils.isNotBlank(((Board) (obj)).getName()))
            {
                _boardVw.setTitle(Resources.string(0x7f0e033f, new Object[] {
                    (new StringBuilder("<b>")).append(((Board) (obj)).getName()).append("</b>").toString()
                }));
            }
        }
    }

    private class IconTextCellView extends LinearLayout
    {

        private static int ICON_MARGIN;
        private static int ICON_SIZE = (int)Resources.dimension(0x7f0a0105);
        private static int OVAL_ICON_MARGIN;
        private static int OVAL_ICON_SIZE = (int)Resources.dimension(0x7f0a0104);
        private WebImageView _iconIv;
        private TextView _titleTv;

        private void init()
        {
            setOrientation(0);
            setGravity(16);
            _iconIv = new WebImageView(getContext());
            addView(_iconIv, ICON_SIZE, ICON_SIZE);
            _titleTv = new TextView(getContext(), null, 0x7f0f01a7);
            _titleTv.setPadding(Constants.MARGIN_HALF, 0, 0, 0);
            _titleTv.setMaxLines(1);
            addView(_titleTv, -1, -2);
        }

        public void setImageOval(boolean flag)
        {
            _iconIv.setOval(flag);
            Object obj = _iconIv.getLayoutParams();
            int i;
            if (flag)
            {
                i = OVAL_ICON_SIZE;
            } else
            {
                i = ICON_SIZE;
            }
            obj.width = i;
            if (flag)
            {
                i = OVAL_ICON_SIZE;
            } else
            {
                i = ICON_SIZE;
            }
            obj.height = i;
            _iconIv.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = _titleTv;
            if (flag)
            {
                i = OVAL_ICON_MARGIN;
            } else
            {
                i = ICON_MARGIN;
            }
            ((TextView) (obj)).setPadding(i, 0, 0, 0);
        }

        public void setImageRounded(boolean flag)
        {
            WebImageView webimageview = _iconIv;
            int i;
            if (flag)
            {
                i = Constants.CORNER_RADIUS;
            } else
            {
                i = 0;
            }
            webimageview.setCornerRadius(i);
        }

        public void setImageUrl(String s)
        {
            _iconIv.loadUrl(s);
        }

        public void setTitle(String s)
        {
            _titleTv.setText(Html.fromHtml(s));
        }

        static 
        {
            ICON_MARGIN = Constants.MARGIN_HALF;
            OVAL_ICON_MARGIN = (int)((float)Constants.MARGIN_HALF - Device.dpToPixel(2.0F));
        }

        public IconTextCellView(Context context)
        {
            super(context);
            init();
        }
    }

}
