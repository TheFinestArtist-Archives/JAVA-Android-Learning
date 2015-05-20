// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.internal.VersionUtils;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v7.internal.widget:
//            DecorContentParent, DecorToolbar, ActionBarContainer, ViewUtils, 
//            ContentFrameLayout

public class ActionBarOverlayLayout extends ViewGroup
    implements DecorContentParent
{

    static final int ATTRS[];
    private static final String TAG = "ActionBarOverlayLayout";
    private final int ACTION_BAR_ANIMATE_DELAY;
    private ActionBarContainer mActionBarBottom;
    private int mActionBarHeight;
    private ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    private boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private final Rect mBaseInnerInsets;
    private final ViewPropertyAnimatorListener mBottomAnimatorListener;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    private ViewPropertyAnimatorCompat mCurrentActionBarBottomAnimator;
    private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private ScrollerCompat mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private final Rect mInnerInsets;
    private final Rect mLastBaseContentInsets;
    private final Rect mLastInnerInsets;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final Runnable mRemoveActionBarHideOffset;
    private final ViewPropertyAnimatorListener mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    public ActionBarOverlayLayout(Context context)
    {
        super(context);
        mWindowVisibility = 0;
        mBaseContentInsets = new Rect();
        mLastBaseContentInsets = new Rect();
        mContentInsets = new Rect();
        mBaseInnerInsets = new Rect();
        mInnerInsets = new Rect();
        mLastInnerInsets = new Rect();
        ACTION_BAR_ANIMATE_DELAY = 600;
        mTopAnimatorListener = new _cls1();
        mBottomAnimatorListener = new _cls2();
        mRemoveActionBarHideOffset = new _cls3();
        mAddActionBarHideOffset = new _cls4();
        init(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mWindowVisibility = 0;
        mBaseContentInsets = new Rect();
        mLastBaseContentInsets = new Rect();
        mContentInsets = new Rect();
        mBaseInnerInsets = new Rect();
        mInnerInsets = new Rect();
        mLastInnerInsets = new Rect();
        ACTION_BAR_ANIMATE_DELAY = 600;
        mTopAnimatorListener = new _cls1();
        mBottomAnimatorListener = new _cls2();
        mRemoveActionBarHideOffset = new _cls3();
        mAddActionBarHideOffset = new _cls4();
        init(context);
    }

    private void addActionBarHideOffset()
    {
        haltActionBarHideOffsetAnimations();
        mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(View view, Rect rect, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        boolean flag5 = false;
        view = (LayoutParams)view.getLayoutParams();
        boolean flag4 = flag5;
        if (flag)
        {
            flag4 = flag5;
            if (((LayoutParams) (view)).leftMargin != rect.left)
            {
                view.leftMargin = rect.left;
                flag4 = true;
            }
        }
        flag = flag4;
        if (flag1)
        {
            flag = flag4;
            if (((LayoutParams) (view)).topMargin != rect.top)
            {
                view.topMargin = rect.top;
                flag = true;
            }
        }
        flag1 = flag;
        if (flag3)
        {
            flag1 = flag;
            if (((LayoutParams) (view)).rightMargin != rect.right)
            {
                view.rightMargin = rect.right;
                flag1 = true;
            }
        }
        if (flag2 && ((LayoutParams) (view)).bottomMargin != rect.bottom)
        {
            view.bottomMargin = rect.bottom;
            return true;
        } else
        {
            return flag1;
        }
    }

    private DecorToolbar getDecorToolbar(View view)
    {
        if (view instanceof DecorToolbar)
        {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar)
        {
            return ((Toolbar)view).getWrapper();
        } else
        {
            throw new IllegalStateException((new StringBuilder("Can't make a decor toolbar out of ")).append(view.getClass().getSimpleName()).toString());
        }
    }

    private void haltActionBarHideOffsetAnimations()
    {
        removeCallbacks(mRemoveActionBarHideOffset);
        removeCallbacks(mAddActionBarHideOffset);
        if (mCurrentActionBarTopAnimator != null)
        {
            mCurrentActionBarTopAnimator.cancel();
        }
        if (mCurrentActionBarBottomAnimator != null)
        {
            mCurrentActionBarBottomAnimator.cancel();
        }
    }

    private void init(Context context)
    {
        boolean flag1 = true;
        TypedArray typedarray = getContext().getTheme().obtainStyledAttributes(ATTRS);
        mActionBarHeight = typedarray.getDimensionPixelSize(0, 0);
        mWindowContentOverlay = typedarray.getDrawable(1);
        boolean flag;
        if (mWindowContentOverlay == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        typedarray.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIgnoreWindowContentOverlay = flag;
        mFlingEstimator = ScrollerCompat.create(context);
    }

    private void postAddActionBarHideOffset()
    {
        haltActionBarHideOffsetAnimations();
        postDelayed(mAddActionBarHideOffset, 600L);
    }

    private void postRemoveActionBarHideOffset()
    {
        haltActionBarHideOffsetAnimations();
        postDelayed(mRemoveActionBarHideOffset, 600L);
    }

    private void removeActionBarHideOffset()
    {
        haltActionBarHideOffsetAnimations();
        mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float f, float f1)
    {
        boolean flag = false;
        mFlingEstimator.fling(0, 0, 0, (int)f1, 0, 0, 0x80000000, 0x7fffffff);
        if (mFlingEstimator.getFinalY() > mActionBarTop.getHeight())
        {
            flag = true;
        }
        return flag;
    }

    public boolean canShowOverflowMenu()
    {
        pullChildren();
        return mDecorToolbar.canShowOverflowMenu();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    public void dismissPopups()
    {
        pullChildren();
        mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mWindowContentOverlay != null && !mIgnoreWindowContentOverlay)
        {
            int i;
            if (mActionBarTop.getVisibility() == 0)
            {
                i = (int)((float)mActionBarTop.getBottom() + ViewCompat.getTranslationY(mActionBarTop) + 0.5F);
            } else
            {
                i = 0;
            }
            mWindowContentOverlay.setBounds(0, i, getWidth(), mWindowContentOverlay.getIntrinsicHeight() + i);
            mWindowContentOverlay.draw(canvas);
        }
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        pullChildren();
        ViewCompat.getWindowSystemUiVisibility(this);
        boolean flag1 = applyInsets(mActionBarTop, rect, true, true, false, true);
        boolean flag = flag1;
        if (mActionBarBottom != null)
        {
            flag = flag1 | applyInsets(mActionBarBottom, rect, true, false, true, true);
        }
        mBaseInnerInsets.set(rect);
        ViewUtils.computeFitSystemWindows(this, mBaseInnerInsets, mBaseContentInsets);
        if (!mLastBaseContentInsets.equals(mBaseContentInsets))
        {
            mLastBaseContentInsets.set(mBaseContentInsets);
            flag = true;
        }
        if (flag)
        {
            requestLayout();
        }
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-1, -1);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new LayoutParams(layoutparams);
    }

    public int getActionBarHideOffset()
    {
        if (mActionBarTop != null)
        {
            return -(int)ViewCompat.getTranslationY(mActionBarTop);
        } else
        {
            return 0;
        }
    }

    public CharSequence getTitle()
    {
        pullChildren();
        return mDecorToolbar.getTitle();
    }

    public boolean hasIcon()
    {
        pullChildren();
        return mDecorToolbar.hasIcon();
    }

    public boolean hasLogo()
    {
        pullChildren();
        return mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu()
    {
        pullChildren();
        return mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int i)
    {
        pullChildren();
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            mDecorToolbar.initProgress();
            return;

        case 5: // '\005'
            mDecorToolbar.initIndeterminateProgress();
            return;

        case 9: // '\t'
            setOverlayMode(true);
            break;
        }
    }

    public boolean isHideOnContentScrollEnabled()
    {
        return mHideOnContentScroll;
    }

    public boolean isInOverlayMode()
    {
        return mOverlayMode;
    }

    public boolean isOverflowMenuShowPending()
    {
        pullChildren();
        return mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing()
    {
        pullChildren();
        return mDecorToolbar.isOverflowMenuShowing();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1 = getChildCount();
        int j1 = getPaddingLeft();
        getPaddingRight();
        int k1 = getPaddingTop();
        int l1 = getPaddingBottom();
        i = 0;
        while (i < i1) 
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 8)
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                int i2 = view.getMeasuredWidth();
                int j2 = view.getMeasuredHeight();
                int k2 = layoutparams.leftMargin + j1;
                if (view == mActionBarBottom)
                {
                    k = l - j - l1 - j2 - layoutparams.bottomMargin;
                } else
                {
                    k = layoutparams.topMargin + k1;
                }
                view.layout(k2, k, i2 + k2, j2 + k);
            }
            i++;
        }
    }

    protected void onMeasure(int i, int j)
    {
        pullChildren();
        measureChildWithMargins(mActionBarTop, i, 0, j, 0);
        Object obj = (LayoutParams)mActionBarTop.getLayoutParams();
        int k1 = Math.max(0, mActionBarTop.getMeasuredWidth() + ((LayoutParams) (obj)).leftMargin + ((LayoutParams) (obj)).rightMargin);
        int k = mActionBarTop.getMeasuredHeight();
        int l = ((LayoutParams) (obj)).topMargin;
        int j1 = Math.max(0, ((LayoutParams) (obj)).bottomMargin + (k + l));
        int i1 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(mActionBarTop));
        if (mActionBarBottom != null)
        {
            measureChildWithMargins(mActionBarBottom, i, 0, j, 0);
            obj = (LayoutParams)mActionBarBottom.getLayoutParams();
            k1 = Math.max(k1, mActionBarBottom.getMeasuredWidth() + ((LayoutParams) (obj)).leftMargin + ((LayoutParams) (obj)).rightMargin);
            k = mActionBarBottom.getMeasuredHeight();
            l = ((LayoutParams) (obj)).topMargin;
            j1 = Math.max(j1, ((LayoutParams) (obj)).bottomMargin + (k + l));
            i1 = ViewUtils.combineMeasuredStates(i1, ViewCompat.getMeasuredState(mActionBarBottom));
        }
        boolean flag;
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l = mActionBarHeight;
            k = l;
            if (mHasNonEmbeddedTabs)
            {
                k = l;
                if (mActionBarTop.getTabContainer() != null)
                {
                    k = l + mActionBarHeight;
                }
            }
        } else
        if (mActionBarTop.getVisibility() != 8)
        {
            k = mActionBarTop.getMeasuredHeight();
        } else
        {
            k = 0;
        }
        if (mDecorToolbar.isSplit() && mActionBarBottom != null)
        {
            if (flag)
            {
                l = mActionBarHeight;
            } else
            {
                l = mActionBarBottom.getMeasuredHeight();
            }
        } else
        {
            l = 0;
        }
        mContentInsets.set(mBaseContentInsets);
        mInnerInsets.set(mBaseInnerInsets);
        if (!mOverlayMode && !flag)
        {
            obj = mContentInsets;
            obj.top = k + ((Rect) (obj)).top;
            obj = mContentInsets;
            obj.bottom = l + ((Rect) (obj)).bottom;
        } else
        {
            Rect rect = mInnerInsets;
            rect.top = k + rect.top;
            rect = mInnerInsets;
            rect.bottom = l + rect.bottom;
        }
        applyInsets(mContent, mContentInsets, true, true, true, true);
        if (!mLastInnerInsets.equals(mInnerInsets))
        {
            mLastInnerInsets.set(mInnerInsets);
            mContent.dispatchFitSystemWindows(mInnerInsets);
        }
        measureChildWithMargins(mContent, i, 0, j, 0);
        obj = (LayoutParams)mContent.getLayoutParams();
        k = Math.max(k1, mContent.getMeasuredWidth() + ((LayoutParams) (obj)).leftMargin + ((LayoutParams) (obj)).rightMargin);
        l = mContent.getMeasuredHeight();
        k1 = ((LayoutParams) (obj)).topMargin;
        l = Math.max(j1, ((LayoutParams) (obj)).bottomMargin + (l + k1));
        i1 = ViewUtils.combineMeasuredStates(i1, ViewCompat.getMeasuredState(mContent));
        j1 = getPaddingLeft();
        k1 = getPaddingRight();
        l = Math.max(l + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(k + (j1 + k1), getSuggestedMinimumWidth()), i, i1), ViewCompat.resolveSizeAndState(l, j, i1 << 16));
    }

    public boolean onNestedFling(View view, float f, float f1, boolean flag)
    {
        if (!mHideOnContentScroll || !flag)
        {
            return false;
        }
        if (shouldHideActionBarOnFling(f, f1))
        {
            addActionBarHideOffset();
        } else
        {
            removeActionBarHideOffset();
        }
        mAnimatingForFling = true;
        return true;
    }

    public void onNestedScroll(View view, int i, int j, int k, int l)
    {
        mHideOnContentScrollReference = mHideOnContentScrollReference + j;
        setActionBarHideOffset(mHideOnContentScrollReference);
    }

    public void onNestedScrollAccepted(View view, View view1, int i)
    {
        super.onNestedScrollAccepted(view, view1, i);
        mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        if (mActionBarVisibilityCallback != null)
        {
            mActionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view1, int i)
    {
        if ((i & 2) == 0 || mActionBarTop.getVisibility() != 0)
        {
            return false;
        } else
        {
            return mHideOnContentScroll;
        }
    }

    public void onStopNestedScroll(View view)
    {
        super.onStopNestedScroll(view);
        if (mHideOnContentScroll && !mAnimatingForFling)
        {
            if (mHideOnContentScrollReference <= mActionBarTop.getHeight())
            {
                postRemoveActionBarHideOffset();
            } else
            {
                postAddActionBarHideOffset();
            }
        }
        if (mActionBarVisibilityCallback != null)
        {
            mActionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i)
    {
        boolean flag2 = true;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        pullChildren();
        int j = mLastSystemUiVisibility;
        mLastSystemUiVisibility = i;
        boolean flag;
        boolean flag1;
        if ((i & 4) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (mActionBarVisibilityCallback != null)
        {
            ActionBarVisibilityCallback actionbarvisibilitycallback = mActionBarVisibilityCallback;
            if (flag1)
            {
                flag2 = false;
            }
            actionbarvisibilitycallback.enableContentAnimations(flag2);
            if (flag || !flag1)
            {
                mActionBarVisibilityCallback.showForSystem();
            } else
            {
                mActionBarVisibilityCallback.hideForSystem();
            }
        }
        if (((j ^ i) & 0x100) != 0 && mActionBarVisibilityCallback != null)
        {
            ViewCompat.requestApplyInsets(this);
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        mWindowVisibility = i;
        if (mActionBarVisibilityCallback != null)
        {
            mActionBarVisibilityCallback.onWindowVisibilityChanged(i);
        }
    }

    void pullChildren()
    {
        if (mContent == null)
        {
            mContent = (ContentFrameLayout)findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
            mActionBarTop = (ActionBarContainer)findViewById(android.support.v7.appcompat.R.id.action_bar_container);
            mDecorToolbar = getDecorToolbar(findViewById(android.support.v7.appcompat.R.id.action_bar));
            mActionBarBottom = (ActionBarContainer)findViewById(android.support.v7.appcompat.R.id.split_action_bar);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray sparsearray)
    {
        pullChildren();
        mDecorToolbar.restoreHierarchyState(sparsearray);
    }

    public void saveToolbarHierarchyState(SparseArray sparsearray)
    {
        pullChildren();
        mDecorToolbar.saveHierarchyState(sparsearray);
    }

    public void setActionBarHideOffset(int i)
    {
        haltActionBarHideOffsetAnimations();
        int j = mActionBarTop.getHeight();
        i = Math.max(0, Math.min(i, j));
        ViewCompat.setTranslationY(mActionBarTop, -i);
        if (mActionBarBottom != null && mActionBarBottom.getVisibility() != 8)
        {
            i = (int)(((float)i / (float)j) * (float)mActionBarBottom.getHeight());
            ViewCompat.setTranslationY(mActionBarBottom, i);
        }
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionbarvisibilitycallback)
    {
        mActionBarVisibilityCallback = actionbarvisibilitycallback;
        if (getWindowToken() != null)
        {
            mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
            if (mLastSystemUiVisibility != 0)
            {
                onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean flag)
    {
        mHasNonEmbeddedTabs = flag;
    }

    public void setHideOnContentScrollEnabled(boolean flag)
    {
        if (flag != mHideOnContentScroll)
        {
            mHideOnContentScroll = flag;
            if (!flag)
            {
                if (VersionUtils.isAtLeastL())
                {
                    stopNestedScroll();
                }
                haltActionBarHideOffsetAnimations();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i)
    {
        pullChildren();
        mDecorToolbar.setIcon(i);
    }

    public void setIcon(Drawable drawable)
    {
        pullChildren();
        mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(int i)
    {
        pullChildren();
        mDecorToolbar.setLogo(i);
    }

    public void setMenu(Menu menu, android.support.v7.internal.view.menu.MenuPresenter.Callback callback)
    {
        pullChildren();
        mDecorToolbar.setMenu(menu, callback);
    }

    public void setMenuPrepared()
    {
        pullChildren();
        mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean flag)
    {
        mOverlayMode = flag;
        if (flag && getContext().getApplicationInfo().targetSdkVersion < 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIgnoreWindowContentOverlay = flag;
    }

    public void setShowingForActionMode(boolean flag)
    {
    }

    public void setUiOptions(int i)
    {
    }

    public void setWindowCallback(WindowCallback windowcallback)
    {
        pullChildren();
        mDecorToolbar.setWindowCallback(windowcallback);
    }

    public void setWindowTitle(CharSequence charsequence)
    {
        pullChildren();
        mDecorToolbar.setWindowTitle(charsequence);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public boolean showOverflowMenu()
    {
        pullChildren();
        return mDecorToolbar.showOverflowMenu();
    }

    static 
    {
        ATTRS = (new int[] {
            android.support.v7.appcompat.R.attr.actionBarSize, 0x1010059
        });
    }


/*
    static ViewPropertyAnimatorCompat access$002(ActionBarOverlayLayout actionbaroverlaylayout, ViewPropertyAnimatorCompat viewpropertyanimatorcompat)
    {
        actionbaroverlaylayout.mCurrentActionBarTopAnimator = viewpropertyanimatorcompat;
        return viewpropertyanimatorcompat;
    }

*/


/*
    static boolean access$102(ActionBarOverlayLayout actionbaroverlaylayout, boolean flag)
    {
        actionbaroverlaylayout.mAnimatingForFling = flag;
        return flag;
    }

*/


/*
    static ViewPropertyAnimatorCompat access$202(ActionBarOverlayLayout actionbaroverlaylayout, ViewPropertyAnimatorCompat viewpropertyanimatorcompat)
    {
        actionbaroverlaylayout.mCurrentActionBarBottomAnimator = viewpropertyanimatorcompat;
        return viewpropertyanimatorcompat;
    }

*/






    private class _cls1 extends ViewPropertyAnimatorListenerAdapter
    {

        final ActionBarOverlayLayout this$0;

        public void onAnimationCancel(View view)
        {
            mCurrentActionBarTopAnimator = null;
            mAnimatingForFling = false;
        }

        public void onAnimationEnd(View view)
        {
            mCurrentActionBarTopAnimator = null;
            mAnimatingForFling = false;
        }

        _cls1()
        {
            this$0 = ActionBarOverlayLayout.this;
            super();
        }
    }


    private class _cls2 extends ViewPropertyAnimatorListenerAdapter
    {

        final ActionBarOverlayLayout this$0;

        public void onAnimationCancel(View view)
        {
            mCurrentActionBarBottomAnimator = null;
            mAnimatingForFling = false;
        }

        public void onAnimationEnd(View view)
        {
            mCurrentActionBarBottomAnimator = null;
            mAnimatingForFling = false;
        }

        _cls2()
        {
            this$0 = ActionBarOverlayLayout.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final ActionBarOverlayLayout this$0;

        public void run()
        {
            haltActionBarHideOffsetAnimations();
            mCurrentActionBarTopAnimator = ViewCompat.animate(mActionBarTop).translationY(0.0F).setListener(mTopAnimatorListener);
            if (mActionBarBottom != null && mActionBarBottom.getVisibility() != 8)
            {
                mCurrentActionBarBottomAnimator = ViewCompat.animate(mActionBarBottom).translationY(0.0F).setListener(mBottomAnimatorListener);
            }
        }

        _cls3()
        {
            this$0 = ActionBarOverlayLayout.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final ActionBarOverlayLayout this$0;

        public void run()
        {
            haltActionBarHideOffsetAnimations();
            mCurrentActionBarTopAnimator = ViewCompat.animate(mActionBarTop).translationY(-mActionBarTop.getHeight()).setListener(mTopAnimatorListener);
            if (mActionBarBottom != null && mActionBarBottom.getVisibility() != 8)
            {
                mCurrentActionBarBottomAnimator = ViewCompat.animate(mActionBarBottom).translationY(mActionBarBottom.getHeight()).setListener(mBottomAnimatorListener);
            }
        }

        _cls4()
        {
            this$0 = ActionBarOverlayLayout.this;
            super();
        }
    }


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        public LayoutParams(int i, int j)
        {
            super(i, j);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
        }
    }


    private class ActionBarVisibilityCallback
    {

        public abstract void enableContentAnimations(boolean flag);

        public abstract void hideForSystem();

        public abstract void onContentScrollStarted();

        public abstract void onContentScrollStopped();

        public abstract void onWindowVisibilityChanged(int i);

        public abstract void showForSystem();
    }

}
