// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.ViewTagRequest;
import com.pinterest.base.Colors;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.PinImpression;
import com.pinterest.ui.BetterGestureDetector;
import com.pinterest.ui.grid.dialog.PromotedPinFeedbackDialog;
import com.pinterest.ui.grid.dialog.RecommendedPinCompactFeedbackDialog;
import com.pinterest.ui.grid.dialog.RecommendedPinFeedbackDialog;
import com.pinterest.ui.grid.pin.PinBackgroundDrawable;
import com.pinterest.ui.grid.pin.PinCellDrawable;
import com.pinterest.ui.grid.pin.PinDividerDrawable;
import com.pinterest.ui.grid.pin.PinIconTextDrawable;
import com.pinterest.ui.grid.pin.PinImageDrawable;
import com.pinterest.ui.grid.pin.PinImageTransformation;
import com.pinterest.ui.grid.pin.PinInfoDrawable;
import com.pinterest.ui.grid.pin.PinTextDrawable;
import org.apache.commons.lang3.StringUtils;

public class PinGridCell extends View
{

    private static final int IMAGE_NOT_LOADED = -1;
    protected static final int MAX_PIN_HEIGHT_CROP = Math.round(Device.dpToPixel(420F));
    protected static final int MAX_PIN_HEIGHT_SYSTEM = 2048;
    protected static final int PADDING_ITEM = (int)Resources.dimension(0x7f0a00b2);
    protected static final int PADDING_SIDE = (int)Resources.dimension(0x7f0a00b7);
    protected static final String STR_ONTO = Resources.string(0x7f0e033e);
    protected static final String STR_PICKED_FOR_YOU = Resources.string(0x7f0e0356);
    protected static final String STR_POPULAR_IN = Resources.string(0x7f0e03b1);
    protected static final String STR_PROMOTED_BY = Resources.string(0x7f0e03b9);
    protected static final String STR_REPINNED_BY = Resources.string(0x7f0e03e4);
    protected static final String STR_SOURCE = Resources.string(0x7f0e0343);
    protected int LONG_PRESS_TIMEOUT;
    protected int MAX_PIN_HEIGHT;
    private PinBackgroundDrawable _backgroundDrawable;
    private boolean _cached;
    private Rect _cellPadding;
    private PinDividerDrawable _dividerDrawable;
    private PinTextDrawable _domainDrawable;
    private BetterGestureDetector _gestureDetector;
    private String _imageUrl;
    private long _impressionStart;
    private PinInfoDrawable _infoDrawable;
    private boolean _isRelatedPin;
    private int _measuredHeight;
    private int _measuredWidth;
    private PinIconTextDrawable _ontoDrawable;
    private boolean _overrideClicks;
    private Pin _pin;
    private PinImageDrawable _pinDrawable;
    private CachableRoundedBitmap.ImageListener _pinDrawableListener;
    private NinePatchDrawable _pinMask;
    private int _pinPosition;
    private String _popularInTitle;
    private boolean _renderCompactUser;
    private boolean _renderDescription;
    private boolean _renderDomain;
    private long _renderDuration;
    private boolean _renderInterest;
    private boolean _renderLargePin;
    private boolean _renderOnto;
    private boolean _renderSocial;
    private boolean _renderSource;
    private long _renderStart;
    private boolean _renderThrough;
    private boolean _renderUser;
    private PinIconTextDrawable _sourceDrawable;
    private PinIconTextDrawable _throughDrawable;
    private PinTextDrawable _typeDrawable;
    private PinIconTextDrawable _userDrawable;
    com.pinterest.ui.BetterGestureDetector.SimpleOnGestureListener onGestureListener;

    public PinGridCell(Context context)
    {
        this(context, null);
    }

    public PinGridCell(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PinGridCell(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        MAX_PIN_HEIGHT = MAX_PIN_HEIGHT_CROP;
        LONG_PRESS_TIMEOUT = 200;
        _renderCompactUser = false;
        _renderUser = true;
        _renderInterest = false;
        _renderDescription = true;
        _renderSource = true;
        _renderOnto = true;
        _renderDomain = false;
        _overrideClicks = false;
        _renderThrough = false;
        _renderSocial = true;
        _renderLargePin = false;
        _cellPadding = new Rect();
        _measuredHeight = 0;
        _measuredWidth = 0;
        _backgroundDrawable = new PinBackgroundDrawable();
        _pinDrawable = new PinImageDrawable(this);
        _infoDrawable = new PinInfoDrawable(this);
        _userDrawable = new PinIconTextDrawable(this);
        _ontoDrawable = new PinIconTextDrawable(this);
        _sourceDrawable = new PinIconTextDrawable(this);
        _throughDrawable = new PinIconTextDrawable(this);
        _domainDrawable = new PinTextDrawable();
        _typeDrawable = new PinTextDrawable();
        _dividerDrawable = new PinDividerDrawable();
        _pinDrawableListener = new _cls1();
        onGestureListener = new _cls2();
        init();
    }

    private void drawBackground(Canvas canvas)
    {
        _backgroundDrawable.setBounds(0, _pinDrawable.getHeight(), getMeasuredWidth(), getMeasuredHeight());
        _backgroundDrawable.draw(canvas);
    }

    private void drawDomain(Canvas canvas)
    {
        if (!_renderDomain)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_domainDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _domainDrawable.draw(canvas);
            return;
        }
    }

    private void drawInfo(Canvas canvas)
    {
        if (_renderDescription)
        {
            _infoDrawable.draw(canvas);
        }
    }

    private void drawOnto(Canvas canvas)
    {
        if (!_renderOnto)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_ontoDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _ontoDrawable.draw(canvas);
            return;
        }
    }

    private void drawOverlay(Canvas canvas)
    {
        _pinMask.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        _pinMask.draw(canvas);
    }

    private void drawPin(Canvas canvas)
    {
        _pinDrawable.draw(canvas);
    }

    private void drawPlacementInfo(Canvas canvas)
    {
        if (_pin.getPromoterUid() == null && _pin.getRecommendationMessage() == null)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_typeDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _typeDrawable.draw(canvas);
            return;
        }
    }

    private void drawSource(Canvas canvas)
    {
        if (!_renderSource)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_sourceDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _sourceDrawable.draw(canvas);
            return;
        }
    }

    private void drawThrough(Canvas canvas)
    {
        if (!_renderThrough)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_throughDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _throughDrawable.draw(canvas);
            return;
        }
    }

    private void drawUser(Canvas canvas)
    {
        if (!_renderUser && !_renderCompactUser)
        {
            return;
        } else
        {
            _dividerDrawable.setY(_userDrawable.getY() - PinCellDrawable.DIVIDER_HEIGHT);
            _dividerDrawable.draw(canvas);
            _userDrawable.draw(canvas);
            return;
        }
    }

    private void init()
    {
        _userDrawable.setOval(true);
        _pinMask = (NinePatchDrawable)Resources.drawable(0x7f020069);
        _pinMask.getPadding(_cellPadding);
        _gestureDetector = new BetterGestureDetector(getContext(), onGestureListener);
        _gestureDetector.setLongPressTimeout(LONG_PRESS_TIMEOUT);
        _pinDrawable.setImageListener(_pinDrawableListener);
    }

    private void showPromotedFeedbackDialog()
    {
        Events.post(new DialogEvent(new PromotedPinFeedbackDialog(_pin)));
    }

    private void showRecommendationCompactFeedbackDialog()
    {
        Events.post(new DialogEvent(new RecommendedPinCompactFeedbackDialog(_pin)));
    }

    private void showRecommendationFeedbackDialog()
    {
        Events.post(new DialogEvent(new RecommendedPinFeedbackDialog(_pin)));
    }

    private void unTouchAll()
    {
        _pinDrawable.setPressed(false);
        _infoDrawable.setPressed(false);
        _sourceDrawable.setPressed(false);
        _ontoDrawable.setPressed(false);
        _throughDrawable.setPressed(false);
        _userDrawable.setPressed(false);
        _typeDrawable.setPressed(false);
        _domainDrawable.setPressed(false);
        invalidate();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        boolean flag = super.dispatchTouchEvent(motionevent);
        if (motionevent.getAction() == 3)
        {
            onGestureListener.onScroll(null, null, 0.0F, 0.0F);
        }
        return flag | _gestureDetector.onTouchEvent(motionevent);
    }

    public PinImpression markImpressionEnd()
    {
        if (_impressionStart == 0L || _pin == null)
        {
            return null;
        }
        PinImpression pinimpression = new PinImpression();
        pinimpression.setPinIdStr(_pin.getUid());
        pinimpression.setTime(_impressionStart);
        pinimpression.setEndTime(System.currentTimeMillis() * 0xf4240L);
        pinimpression.setSlotIndex((short)_pinPosition);
        if (_imageUrl != null)
        {
            pinimpression.setRenderDuration(_renderDuration);
            pinimpression.setImageURL(_imageUrl);
            pinimpression.setCached(_cached);
        }
        if (ModelHelper.isValid(_pin.getViewTags()) && pinimpression.getEndTime() - pinimpression.getTime() > 0x3b9aca00L)
        {
            String as[] = _pin.getViewTags().split(",,");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (!StringUtils.isEmpty(s))
                {
                    String as1[] = s.split(",");
                    ApiHttpClient.addToRequestQueue(new ViewTagRequest(as1[1], as1[0]), null);
                }
            }

        }
        _impressionStart = 0L;
        return pinimpression;
    }

    public void markImpressionStart()
    {
        _impressionStart = System.currentTimeMillis() * 0xf4240L;
    }

    protected void onDraw(Canvas canvas)
    {
        if (_pin != null)
        {
            drawBackground(canvas);
            drawPin(canvas);
            drawInfo(canvas);
            drawUser(canvas);
            drawSource(canvas);
            drawThrough(canvas);
            drawOnto(canvas);
            drawDomain(canvas);
            drawPlacementInfo(canvas);
            drawOverlay(canvas);
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        _measuredWidth = android.view.View.MeasureSpec.getSize(i);
        if (_measuredWidth < 0)
        {
            _measuredWidth = 100;
        }
        if (_pin == null) goto _L2; else goto _L1
_L1:
        Interest interest;
        PinIconTextDrawable pinicontextdrawable;
        boolean flag;
        if (_pin.getPromoterUid() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _dividerDrawable.setWidth(_measuredWidth);
        _dividerDrawable.setHeight(PinCellDrawable.DIVIDER_HEIGHT);
        _measuredHeight = 0;
        _pinDrawable.setPin(_pin);
        _pinDrawable.setY(_measuredHeight);
        _pinDrawable.setWidth(_measuredWidth);
        _pinDrawable.setPadding(_cellPadding);
        _pinDrawable.setRenderLargePin(_renderLargePin);
        _pinDrawable.measure();
        _measuredHeight = _measuredHeight + _pinDrawable.getHeight();
        if (_renderDescription)
        {
            _infoDrawable.setRenderSocial(_renderSocial);
            _infoDrawable.setRenderLargePin(_renderLargePin);
            _infoDrawable.setY(_measuredHeight);
            _infoDrawable.setWidth(_measuredWidth);
            _infoDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _infoDrawable.setPin(_pin);
            _infoDrawable.measure();
            _measuredHeight = _measuredHeight + _infoDrawable.getHeight();
        }
        if (_renderSource && !_pin.hasAttribution())
        {
            _renderSource = false;
        }
        if (_renderDomain && (_pin.getDomain() == null || _pin.getDomain().length() <= 0))
        {
            _renderDomain = false;
        }
        if (!_renderCompactUser) goto _L4; else goto _L3
_L3:
        interest = _pin.getInterest();
        if (!_renderInterest || interest == null) goto _L6; else goto _L5
_L5:
        pinicontextdrawable = _userDrawable;
        Object obj;
        if (_popularInTitle != null)
        {
            obj = _popularInTitle;
        } else
        {
            obj = STR_POPULAR_IN;
        }
        pinicontextdrawable.setTitle(((String) (obj)));
        _userDrawable.setSubTitle(interest.getName());
_L8:
        if (flag)
        {
            _userDrawable.showFeedbackIcon(true);
            _userDrawable.setIcon(PinIconTextDrawable.FEEDBACK_ICON);
            obj = _pin.getUser();
            if (obj != null)
            {
                _userDrawable.setSubTitle(((User) (obj)).getFullName());
            }
            _userDrawable.setTitle(STR_PROMOTED_BY);
        }
        _userDrawable.setY(_measuredHeight);
        _userDrawable.setWidth(_measuredWidth);
        _userDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
        _userDrawable.measure();
        _measuredHeight = _measuredHeight + _userDrawable.getHeight();
_L4:
        if (_renderUser)
        {
            obj = _pin.getUser();
            if (obj != null)
            {
                _userDrawable.setTitle(((User) (obj)).getFullName());
            }
            _userDrawable.setSubTitle(STR_REPINNED_BY);
            _userDrawable.setReverseOrder(true);
            _userDrawable.setY(_measuredHeight);
            _userDrawable.setWidth(_measuredWidth);
            _userDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _userDrawable.measure();
            _measuredHeight = _measuredHeight + _userDrawable.getHeight();
        }
        if (_renderSource)
        {
            if (_pin.hasAttribution())
            {
                _sourceDrawable.setOval(false);
                _sourceDrawable.setSubTitle(STR_SOURCE);
                _sourceDrawable.setTitle(_pin.getAttribution());
            }
            _sourceDrawable.setReverseOrder(true);
            _sourceDrawable.setY(_measuredHeight);
            _sourceDrawable.setWidth(_measuredWidth);
            _sourceDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _sourceDrawable.measure();
            _measuredHeight = _measuredHeight + _sourceDrawable.getHeight();
        }
        if (_renderOnto)
        {
            obj = _pin.getBoard();
            if (obj != null)
            {
                _ontoDrawable.setTitle(((Board) (obj)).getName());
            }
            _ontoDrawable.setSubTitle(STR_ONTO);
            _ontoDrawable.setReverseOrder(true);
            _ontoDrawable.setY(_measuredHeight);
            _ontoDrawable.setWidth(_measuredWidth);
            _ontoDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _ontoDrawable.measure();
            _measuredHeight = _measuredHeight + _ontoDrawable.getHeight();
        }
        if (_renderThrough)
        {
            obj = _pin.getBoard();
            if (obj != null)
            {
                _throughDrawable.setSubTitle(((Board) (obj)).getName());
            }
            _throughDrawable.showFeedbackIcon(true);
            _throughDrawable.setIcon(PinIconTextDrawable.FEEDBACK_ICON);
            _throughDrawable.setTitle(STR_PICKED_FOR_YOU);
            _throughDrawable.setReverseOrder(false);
            _throughDrawable.setY(_measuredHeight);
            _throughDrawable.setWidth(_measuredWidth);
            _throughDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _throughDrawable.measure();
            _measuredHeight = _measuredHeight + _throughDrawable.getHeight();
        }
        if (_renderDomain)
        {
            _domainDrawable.setText(_pin.getDomain());
            _domainDrawable.setY(_measuredHeight);
            _domainDrawable.setWidth(_measuredWidth);
            _domainDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _domainDrawable.measure();
            _measuredHeight = _measuredHeight + _domainDrawable.getHeight();
        }
        if ((flag || _pin.getRecommendationMessage() != null) && !flag && !ModelHelper.isValid(_pin.getRecommendationBoardUid()))
        {
            _typeDrawable.setColor(Colors.TEXT_DARK);
            _typeDrawable.setTypeface(Typeface.DEFAULT);
            _typeDrawable.setText(STR_PICKED_FOR_YOU);
            _typeDrawable.showFeedbackIcon(true);
            _typeDrawable.setIcon(PinTextDrawable.FEEDBACK_ICON);
            _typeDrawable.setY(_measuredHeight);
            _typeDrawable.setWidth(_measuredWidth);
            _typeDrawable.setPadding(PADDING_SIDE, PADDING_ITEM, PADDING_SIDE, PADDING_ITEM);
            _typeDrawable.measure();
            _measuredHeight = _measuredHeight + _typeDrawable.getHeight();
        }
        _measuredHeight = _measuredHeight + _cellPadding.height();
_L2:
        super.onMeasure(i, j);
        setMeasuredDimension(_measuredWidth, _measuredHeight);
        return;
_L6:
        Object obj1 = _pin.getUser();
        if (obj1 != null)
        {
            _userDrawable.setTitle(((User) (obj1)).getFullName());
        }
        obj1 = _pin.getBoard();
        if (obj1 != null)
        {
            _userDrawable.setSubTitle(((Board) (obj1)).getName());
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void setCellPadding(Rect rect)
    {
        _cellPadding = rect;
    }

    public void setCropPinImage(boolean flag)
    {
        _pinDrawable.setAutoCrop(flag);
    }

    public void setIsRelatedPin(boolean flag)
    {
        _isRelatedPin = flag;
    }

    public void setOverrideClicks(boolean flag)
    {
        _overrideClicks = flag;
    }

    public void setPin(Pin pin, boolean flag)
    {
        if (pin == null)
        {
            return;
        }
        boolean flag1;
        if (_pin != null && _pin.getUid().equals(pin.getUid()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _pin = pin;
        if (!flag1)
        {
            _pinDrawable.prepareForReuse();
            _infoDrawable.prepareForReuse();
            _userDrawable.prepareForReuse();
            _ontoDrawable.prepareForReuse();
            _throughDrawable.prepareForReuse();
            _sourceDrawable.prepareForReuse();
            _typeDrawable.prepareForReuse();
            _domainDrawable.prepareForReuse();
        }
        unTouchAll();
        if (!flag && !flag1)
        {
            _renderStart = SystemClock.elapsedRealtime();
            _renderDuration = -1L;
            _cached = false;
            if (_renderLargePin)
            {
                pin = _pin.getImageLargeUrl();
            } else
            {
                pin = _pin.getImageMediumUrl();
            }
            _imageUrl = pin;
            _pinDrawable.setIsLarge(PinImageTransformation.shouldTransform(_pin.getImageMediumHeight().intValue()));
            _pinDrawable.loadImage(_imageUrl);
            if (_renderInterest)
            {
                pin = _pin.getInterest();
                if (pin != null && pin.getImageSmallUrl() != null)
                {
                    _userDrawable.loadImage(pin.getImageSmallUrl());
                    _userDrawable.setOval(false);
                }
            } else
            if (_renderUser || _renderCompactUser)
            {
                pin = _pin.getUser();
                if (pin != null)
                {
                    _userDrawable.loadImage(pin.getImageMediumUrl());
                    _userDrawable.setOval(true);
                }
            }
            if (_pin.hasRichPinGridData())
            {
                _infoDrawable.loadSiteIcon(_pin.getRichIcon());
            } else
            if (_pin.hasPlaceGridData())
            {
                _infoDrawable.loadSiteIcon(_pin.getPlace().getSourceIcon());
            }
            if (_renderSource)
            {
                if (_pin.hasAttribution())
                {
                    _sourceDrawable.loadImage(_pin.getAttrProviderIconUrl());
                } else
                {
                    _renderSource = false;
                }
            }
            if (_renderOnto)
            {
                pin = _pin.getBoard();
                if (pin != null)
                {
                    _ontoDrawable.loadImage(pin.getImagePreviewUrl());
                }
            }
            if (_renderThrough)
            {
                pin = _pin.getRecommendationBoard();
                if (pin != null)
                {
                    _throughDrawable.loadImage(pin.getImagePreviewUrl());
                }
            }
        }
        requestLayout();
    }

    public void setPinPosition(int i)
    {
        _pinPosition = i;
    }

    public void setPopularInTitle(String s)
    {
        _popularInTitle = s;
    }

    public void setPressed(boolean flag)
    {
        super.setPressed(flag);
        if (!flag)
        {
            unTouchAll();
        }
    }

    public void setRenderCompactUser(boolean flag)
    {
        _renderCompactUser = flag;
    }

    public void setRenderDescription(boolean flag)
    {
        _renderDescription = flag;
    }

    public void setRenderDomain(boolean flag)
    {
        _renderDomain = flag;
    }

    public void setRenderInterest(boolean flag)
    {
        if (flag)
        {
            _renderInterest = true;
            _renderCompactUser = true;
            return;
        } else
        {
            _renderInterest = false;
            return;
        }
    }

    public void setRenderLargePin(boolean flag)
    {
        _renderLargePin = flag;
    }

    public void setRenderOnto(boolean flag)
    {
        _renderOnto = flag;
    }

    public void setRenderSocial(boolean flag)
    {
        _renderSocial = flag;
    }

    public void setRenderSource(boolean flag)
    {
        _renderSource = flag;
    }

    public void setRenderThrough(boolean flag)
    {
        _renderThrough = flag;
    }

    public void setRenderUser(boolean flag)
    {
        _renderUser = flag;
    }



/*
    static long access$002(PinGridCell pingridcell, long l)
    {
        pingridcell._renderDuration = l;
        return l;
    }

*/














/*
    static boolean access$202(PinGridCell pingridcell, boolean flag)
    {
        pingridcell._cached = flag;
        return flag;
    }

*/








    private class _cls1 extends CachableRoundedBitmap.ImageListener
    {

        final PinGridCell this$0;

        public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
        {
            long l = 0L;
            long l1 = SystemClock.elapsedRealtime();
            bitmap = PinGridCell.this;
            if (_renderStart > 0L)
            {
                l = l1 - _renderStart;
            }
            bitmap._renderDuration = l;
            bitmap = PinGridCell.this;
            boolean flag;
            if (loadedfrom == com.squareup.picasso.Picasso.LoadedFrom.a || loadedfrom == com.squareup.picasso.Picasso.LoadedFrom.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bitmap._cached = flag;
            Events.post(new ImageLoadEvent());
        }

        _cls1()
        {
            this$0 = PinGridCell.this;
            super();
        }

        private class ImageLoadEvent
        {

            public ImageLoadEvent()
            {
            }
        }

    }


    private class _cls2 extends com.pinterest.ui.BetterGestureDetector.SimpleOnGestureListener
    {

        public boolean isDown;
        public final int minTouch = ViewConfiguration.getPressedStateDuration();
        final PinGridCell this$0;
        public final int touchDelay = ViewConfiguration.getTapTimeout();

        public boolean onDown(MotionEvent motionevent)
        {
            resolveTouch(motionevent, true, false);
            return true;
        }

        public void onLongPress(MotionEvent motionevent)
        {
            resolveTouch(null, false, true);
            while (_overrideClicks || !_pinDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY())) 
            {
                return;
            }
            if (_isRelatedPin)
            {
                motionevent = ComponentType.RELATED_PIN;
            } else
            {
                motionevent = ComponentType.FLOWED_PIN;
            }
            Pinalytics.a(EventType.LONG_PRESS, ElementType.PIN_SOURCE_IMAGE, motionevent, _pin.getUid(), _pin.getLoggingAuxData(_pinPosition));
            Events.post(new ShowPinContextMenuEvent(_pin));
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            resolveTouch(null, false, true);
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            ComponentType componenttype;
            boolean flag;
            int i = (int)(motionevent.getDownTime() - motionevent.getEventTime());
            class _cls1
                implements Runnable
            {

                final _cls2 this$1;

                public void run()
                {
                    unTouchAll();
                }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
            }

            if (i < touchDelay)
            {
                i = touchDelay - i;
            } else
            {
                i = minTouch;
            }
            resolveTouch(motionevent, true, true);
            postDelayed(new _cls1(), i);
            if (_isRelatedPin)
            {
                componenttype = ComponentType.RELATED_PIN;
            } else
            {
                componenttype = ComponentType.FLOWED_PIN;
            }
            if (!_pinDrawable.isPressed())
            {
                break MISSING_BLOCK_LABEL_1574;
            }
            Pinalytics.a(ElementType.PIN_SOURCE_IMAGE, componenttype, _pin.getUid(), _pin.getLoggingAuxData(_pinPosition));
            if (!_overrideClicks) goto _L2; else goto _L1
_L1:
            Events.post(new OverrideNavigationEvent(2, _pin.getUid()));
_L3:
            playSoundEffect(0);
            flag = true;
_L4:
            int j;
            i = ((flag) ? 1 : 0);
            if (_renderCompactUser)
            {
                i = ((flag) ? 1 : 0);
                if (_userDrawable.isPressed())
                {
                    i = ((flag) ? 1 : 0);
                    if (!flag)
                    {
                        if (_renderInterest)
                        {
                            Pinalytics.a(ElementType.PIN_INTEREST, componenttype, _pin.getInterestUid());
                            Object obj;
                            if (_overrideClicks)
                            {
                                Events.post(new OverrideNavigationEvent(7, _pin.getInterestUid()));
                            } else
                            {
                                motionevent = _pin.getInterest();
                                if (motionevent != null)
                                {
                                    if (motionevent.getFollowing() == null)
                                    {
                                        motionevent.setFollowing(Boolean.valueOf(true));
                                    }
                                    StopWatch.get().start("interest_ttrfp");
                                    Events.post(new Navigation(Location.INTEREST, motionevent));
                                }
                            }
                        } else
                        {
                            Pinalytics.a(ElementType.PIN_BOARD, componenttype, _pin.getBoardUid());
                            if (_overrideClicks)
                            {
                                Events.post(new OverrideNavigationEvent(4, _pin.getBoardUid()));
                            } else
                            {
                                motionevent = _pin.getBoard();
                                if (motionevent != null)
                                {
                                    Events.post(new Navigation(Location.BOARD, motionevent));
                                }
                            }
                        }
                        playSoundEffect(0);
                        i = 1;
                    }
                }
            }
            flag = i;
            if (_throughDrawable.isPressed())
            {
                flag = i;
                if (i == 0)
                {
                    motionevent = _pin.getBoard();
                    flag = i;
                    if (motionevent != null)
                    {
                        Pinalytics.a(ElementType.PIN_BOARD, componenttype, motionevent.getUid());
                        if (_overrideClicks)
                        {
                            Events.post(new OverrideNavigationEvent(4, _pin.getBoardUid()));
                        } else
                        {
                            Events.post(new Navigation(Location.BOARD, motionevent));
                        }
                        playSoundEffect(0);
                        flag = true;
                    }
                }
            }
            i = ((flag) ? 1 : 0);
            if (_throughDrawable.isIconPressed())
            {
                i = ((flag) ? 1 : 0);
                if (!flag)
                {
                    if (_pin.getRecommendationReason() != null)
                    {
                        Pinalytics.a(ElementType.PIN_FEEDBACK_BUTTON_PFY, componenttype);
                        if (!_overrideClicks)
                        {
                            showRecommendationFeedbackDialog();
                        }
                    }
                    playSoundEffect(0);
                    i = 1;
                }
            }
            flag = i;
            if (_userDrawable.isIconPressed())
            {
                flag = i;
                if (i == 0)
                {
                    if (_pin.getPromoterUid() != null)
                    {
                        Pinalytics.a(ElementType.PIN_FEEDBACK_BUTTON_PROMOTED, componenttype);
                        if (!_overrideClicks)
                        {
                            showPromotedFeedbackDialog();
                        }
                    }
                    playSoundEffect(0);
                    flag = true;
                }
            }
            i = ((flag) ? 1 : 0);
            if (_renderUser)
            {
                i = ((flag) ? 1 : 0);
                if (_userDrawable.isPressed())
                {
                    i = ((flag) ? 1 : 0);
                    if (!flag)
                    {
                        if (_overrideClicks)
                        {
                            Events.post(new OverrideNavigationEvent(3, _pin.getUserUid()));
                        } else
                        {
                            Pinalytics.a(ElementType.PIN_USER, componenttype, _pin.getUserUid());
                            Events.post(new Navigation(Location.USER, _pin.getUser()));
                        }
                        playSoundEffect(0);
                        i = 1;
                    }
                }
            }
            flag = i;
            if (_sourceDrawable.isPressed())
            {
                flag = i;
                if (i == 0)
                {
                    getContext();
                    if (_pin.hasAttribution())
                    {
                        Pinalytics.a(ElementType.PIN_ATTRIBUTION, componenttype);
                        if (_overrideClicks)
                        {
                            Events.post(new OverrideNavigationEvent(5, _pin.getAttrAuthorUrl()));
                        } else
                        {
                            motionevent = new Navigation(Location.BROWSER, _pin.getAttrAuthorUrl());
                            motionevent.putExtra("Referer", _pin.getPinterestLink());
                            Events.post(motionevent);
                        }
                    } else
                    if (_pin.getDomain() != null)
                    {
                        Pinalytics.a(ElementType.PIN_DOMAIN, componenttype);
                        if (_overrideClicks)
                        {
                            Events.post(new OverrideNavigationEvent(4, _pin.getDomain()));
                        } else
                        {
                            Events.post(new Navigation(Location.DOMAIN, _pin.getDomain()));
                        }
                    }
                    flag = i;
                    if (_overrideClicks)
                    {
                        playSoundEffect(0);
                        flag = true;
                    }
                }
            }
            i = ((flag) ? 1 : 0);
            if (_ontoDrawable.isPressed())
            {
                i = ((flag) ? 1 : 0);
                if (!flag)
                {
                    motionevent = _pin.getBoard();
                    i = ((flag) ? 1 : 0);
                    if (motionevent != null)
                    {
                        Pinalytics.a(ElementType.PIN_BOARD, componenttype, motionevent.getUid());
                        if (_overrideClicks)
                        {
                            Events.post(new OverrideNavigationEvent(4, _pin.getBoardUid()));
                        } else
                        {
                            Events.post(new Navigation(Location.BOARD, motionevent));
                        }
                        playSoundEffect(0);
                        i = 1;
                    }
                }
            }
            flag = i;
            if (_domainDrawable.isPressed())
            {
                flag = i;
                if (i == 0)
                {
                    Pinalytics.a(ElementType.PIN_DOMAIN, componenttype);
                    if (_overrideClicks)
                    {
                        Events.post(new OverrideNavigationEvent(4, _pin.getDomain()));
                    } else
                    {
                        Events.post(new Navigation(Location.DOMAIN, _pin.getDomain()));
                    }
                    playSoundEffect(0);
                    flag = true;
                }
            }
            i = ((flag) ? 1 : 0);
            if (_typeDrawable.isPressed())
            {
                i = ((flag) ? 1 : 0);
                if (!flag)
                {
                    playSoundEffect(0);
                    i = 1;
                }
            }
            if (_typeDrawable.isIconPressed() && i == 0)
            {
                if (_pin.getRecommendationReason() != null && !_overrideClicks)
                {
                    showRecommendationCompactFeedbackDialog();
                }
                playSoundEffect(0);
            }
            return true;
_L2:
            if (!(getParent() instanceof PinterestAdapterView))
            {
                break MISSING_BLOCK_LABEL_1563;
            }
            motionevent = (PinterestAdapterView)getParent();
            j = _pinPosition;
            if (motionevent.getAdapter() instanceof PinGridAdapter)
            {
                motionevent = (PinFeed)((PinGridAdapter)motionevent.getAdapter()).getDataSource();
            } else
            if (motionevent.getAdapter() instanceof DigestGridAdapter)
            {
                obj = ((DigestGridAdapter)motionevent.getAdapter()).getPinFeed(_pin);
                j = ((PinFeed) (obj)).getItemIndex(_pin);
                motionevent = ((MotionEvent) (obj));
                if (obj != null)
                {
                    j = ((PinFeed) (obj)).getItemIndex(_pin);
                    motionevent = ((MotionEvent) (obj));
                }
            } else
            {
                motionevent = null;
            }
            if (motionevent == null)
            {
                break MISSING_BLOCK_LABEL_1563;
            }
            StopWatch.get().start("pin_closeup");
            obj = new Navigation(Location.PIN_PAGER);
            ((Navigation) (obj)).putExtra("com.pinterest.EXTRA_FEED", motionevent);
            ((Navigation) (obj)).putIntParcelable("com.pinterest.EXTRA_PIN_POSITION", j);
            Events.post(obj);
            j = 1;
            if (j == 0)
            {
                Events.post(new Navigation(Location.PIN, _pin));
            }
              goto _L3
            j = 0;
            break MISSING_BLOCK_LABEL_1100;
            flag = false;
              goto _L4
        }

        public void resolveTouch(MotionEvent motionevent, boolean flag, boolean flag1)
        {
            unTouchAll();
            if (isEnabled() && (isDown != flag || flag1) && motionevent != null)
            {
                if (_pinDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    _pinDrawable.setPressed(true);
                }
                if (_userDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    if (_userDrawable.getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                    {
                        _userDrawable.setIconPressed(true);
                    } else
                    {
                        _userDrawable.setPressed(true);
                    }
                }
                if (_sourceDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    _sourceDrawable.setPressed(true);
                }
                if (_ontoDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    _ontoDrawable.setPressed(true);
                }
                if (_throughDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    if (_throughDrawable.getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                    {
                        _throughDrawable.setIconPressed(true);
                    } else
                    {
                        _throughDrawable.setPressed(true);
                    }
                }
                if (_domainDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    _domainDrawable.setPressed(true);
                }
                if (_typeDrawable.getBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    if (_typeDrawable.getRenderFeedbackIcon() && _typeDrawable.getIconBounds().contains((int)motionevent.getX(), (int)motionevent.getY()))
                    {
                        _typeDrawable.setIconPressed(true);
                    } else
                    {
                        _typeDrawable.setPressed(true);
                    }
                }
            }
            isDown = flag;
            if (flag1)
            {
                invalidate();
                return;
            } else
            {
                postInvalidateDelayed(touchDelay);
                return;
            }
        }

        _cls2()
        {
            this$0 = PinGridCell.this;
            super();
            isDown = false;
        }
    }

}
