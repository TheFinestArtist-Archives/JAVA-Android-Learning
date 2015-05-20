// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;

public class PlaceBoardLayout extends ViewGroup
{

    private final ViewDragHelper _dragHelper;
    private android.support.v4.widget.ViewDragHelper.Callback _dragHelperCallBack;
    private View _gridVw;
    private View _headerVw;
    private float _initialTouchX;
    private float _initialTouchY;
    private boolean _isMapShown;
    private boolean _isUserTouchingMap;
    private View _mapContainer;
    private boolean _minimizePinGrid;
    private int _top;
    private int _verticalDragRange;

    public PlaceBoardLayout(Context context)
    {
        this(context, null, 0);
    }

    public PlaceBoardLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PlaceBoardLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _isMapShown = false;
        _isUserTouchingMap = false;
        _dragHelperCallBack = new _cls2();
        _dragHelper = ViewDragHelper.create(this, 1.0F, _dragHelperCallBack);
    }

    private void animateTopMargin()
    {
        final int targetMargin = getDefaultPinGridTopPosition();
        final android.widget.LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams)_headerVw.getLayoutParams();
        final int currentTopMargin = lp.topMargin;
        if (currentTopMargin != targetMargin)
        {
            lp = new _cls1();
            lp.setDuration(300L);
            _headerVw.startAnimation(lp);
        }
    }

    private int getDefaultPinGridTopPosition()
    {
        if (_isMapShown)
        {
            return (int)(0.25D * (double)_verticalDragRange);
        } else
        {
            return 0;
        }
    }

    private MotionEvent getVerticalOffsetMotionEvent(MotionEvent motionevent)
    {
        motionevent.setLocation(motionevent.getX(), motionevent.getY() - (float)_top);
        return motionevent;
    }

    private boolean isUserTouchingMap(float f)
    {
        return f < (float)(_gridVw.getTop() + _gridVw.getPaddingTop() + _headerVw.getTop()) && _gridVw.getScrollY() < _gridVw.getTop() + _headerVw.getTop();
    }

    private void smoothScroll(int i)
    {
        if (_dragHelper.smoothSlideViewTo(_gridVw, 0, i))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void smoothScrollPinGridBottom()
    {
        _gridVw.scrollBy(0, -_gridVw.getScrollY());
        smoothScroll(_verticalDragRange);
        Events.post(com.pinterest.activity.board.fragment.BoardFragment.BoardMapState.OPEN);
    }

    private void smoothScrollPinGridTop()
    {
        smoothScroll(0);
        Events.post(com.pinterest.activity.board.fragment.BoardFragment.BoardMapState.CLOSED);
    }

    public boolean actualonTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i;
        boolean flag2;
        boolean flag4;
        flag2 = false;
        flag4 = true;
        i = motionevent.getAction();
        f = motionevent.getY();
        f1 = f - _initialTouchY;
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 72
    //                   0 78
    //                   1 246
    //                   2 172
    //                   3 72
    //                   4 72
    //                   5 228
    //                   6 228;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L5
_L1:
        boolean flag3 = false;
_L7:
        return flag3;
_L2:
        _isUserTouchingMap = isUserTouchingMap(f);
        boolean flag;
        if (!_isUserTouchingMap)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _dragHelper.processTouchEvent(motionevent);
        if (_isUserTouchingMap)
        {
            smoothScrollPinGridBottom();
            _mapContainer.dispatchTouchEvent(motionevent);
        } else
        {
            _gridVw.dispatchTouchEvent(getVerticalOffsetMotionEvent(motionevent));
        }
        flag3 = flag4;
        if (!flag) goto _L7; else goto _L6
_L6:
        flag3 = flag4;
        if (_gridVw.getTop() >= 0) goto _L7; else goto _L8
_L8:
        return false;
_L4:
        if (_isUserTouchingMap)
        {
            _mapContainer.dispatchTouchEvent(motionevent);
        } else
        if (_gridVw.getTop() <= 0)
        {
            _gridVw.dispatchTouchEvent(getVerticalOffsetMotionEvent(motionevent));
        } else
        {
            _dragHelper.processTouchEvent(motionevent);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (_isUserTouchingMap)
        {
            _mapContainer.dispatchTouchEvent(motionevent);
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag1;
        if (_isUserTouchingMap)
        {
            _mapContainer.dispatchTouchEvent(motionevent);
            flag1 = true;
        } else
        {
            flag1 = flag2;
            if (_gridVw.getScrollY() == 0)
            {
                _dragHelper.processTouchEvent(motionevent);
                if (f1 < 0.0F)
                {
                    if (_gridVw.getTop() >= getDefaultPinGridTopPosition())
                    {
                        smoothScrollPinGridTop();
                        flag1 = true;
                    } else
                    {
                        flag1 = true;
                    }
                } else
                if (f1 > (float)_dragHelper.getTouchSlop())
                {
                    smoothScrollPinGridBottom();
                    flag1 = true;
                } else
                {
                    flag1 = flag2;
                    if (f1 > 0.0F)
                    {
                        flag1 = flag2;
                        if (f1 < (float)_dragHelper.getTouchSlop())
                        {
                            smoothScrollPinGridTop();
                            flag1 = flag2;
                        }
                    }
                }
            }
        }
        if (!flag1)
        {
            _gridVw.dispatchTouchEvent(getVerticalOffsetMotionEvent(motionevent));
            return true;
        } else
        {
            motionevent.setAction(3);
            _gridVw.dispatchTouchEvent(motionevent);
            return true;
        }
    }

    public void computeScroll()
    {
        if (_dragHelper.continueSettling(true))
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        _mapContainer = findViewById(0x7f0b0126);
        _gridVw = findViewById(0x7f0b0127);
        _headerVw = _gridVw.findViewById(0x7f0b015d);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        (new StringBuilder("#onInterceptTouchEvent ")).append(motionevent);
        int i = MotionEventCompat.getActionMasked(motionevent);
        if (!_isMapShown)
        {
            _dragHelper.cancel();
            return false;
        }
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        boolean flag = isUserTouchingMap(f1);
        try
        {
            _dragHelper.shouldInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            CrashReporting.logHandledException(motionevent);
        }
        if (i == 0)
        {
            _initialTouchX = f;
            _initialTouchY = f1;
            if (flag)
            {
                smoothScrollPinGridBottom();
            }
        }
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (_gridVw == null)
        {
            return;
        }
        if (_headerVw == null)
        {
            _headerVw = _gridVw.findViewById(0x7f0b015d);
        }
        _verticalDragRange = getHeight() - _headerVw.getBottom() - _gridVw.getPaddingTop();
        if (_isMapShown)
        {
            _mapContainer.layout(i, 0, k, l);
        }
        _gridVw.layout(0, _top, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        measureChildren(i, j);
        setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), android.view.View.MeasureSpec.getSize(j));
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        (new StringBuilder("#onTouchEvent ")).append(motionevent);
        boolean flag;
        try
        {
            flag = actualonTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        return flag;
    }

    public void setMapShown(boolean flag)
    {
        if (_isMapShown != flag && _verticalDragRange != 0)
        {
            _isMapShown = flag;
            animateTopMargin();
            if (!_minimizePinGrid)
            {
                smoothScrollPinGridTop();
            }
        }
    }

    public void switchMapState(boolean flag)
    {
        _minimizePinGrid = flag;
        if (flag)
        {
            smoothScrollPinGridBottom();
            return;
        } else
        {
            smoothScrollPinGridTop();
            return;
        }
    }



/*
    static int access$102(PlaceBoardLayout placeboardlayout, int i)
    {
        placeboardlayout._top = i;
        return i;
    }

*/



    private class _cls2 extends android.support.v4.widget.ViewDragHelper.Callback
    {

        final PlaceBoardLayout this$0;

        public int clampViewPositionVertical(View view, int i, int j)
        {
            j = getPaddingTop();
            int k = getHeight();
            int l = _headerVw.getHeight();
            int i1 = _headerVw.getPaddingBottom();
            return Math.min(Math.max(i, j), k - l - i1);
        }

        public int getViewVerticalDragRange(View view)
        {
            if (view == _gridVw)
            {
                return _verticalDragRange;
            } else
            {
                return 0;
            }
        }

        public void onViewPositionChanged(View view, int i, int j, int k, int l)
        {
            _top = j;
            requestLayout();
        }

        public boolean tryCaptureView(View view, int i)
        {
            return view == _gridVw;
        }

        _cls2()
        {
            this$0 = PlaceBoardLayout.this;
            super();
        }
    }


    private class _cls1 extends Animation
    {

        final PlaceBoardLayout this$0;
        final int val$currentTopMargin;
        final android.widget.LinearLayout.LayoutParams val$lp;
        final int val$targetMargin;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = targetMargin;
            int j = currentTopMargin;
            transformation = lp;
            float f1 = currentTopMargin;
            transformation.topMargin = (int)((float)(i - j) * f + f1);
            _headerVw.setLayoutParams(lp);
        }

        _cls1()
        {
            this$0 = PlaceBoardLayout.this;
            targetMargin = i;
            currentTopMargin = j;
            lp = layoutparams;
            super();
        }
    }

}
