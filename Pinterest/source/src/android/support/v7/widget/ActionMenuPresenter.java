// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView

public class ActionMenuPresenter extends BaseMenuPresenter
    implements android.support.v4.view.ActionProvider.SubUiVisibilityListener
{

    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(null);
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context context)
    {
        super(context, android.support.v7.appcompat.R.layout.abc_action_menu_layout, android.support.v7.appcompat.R.layout.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuitem)
    {
        ViewGroup viewgroup = (ViewGroup)mMenuView;
        if (viewgroup != null) goto _L2; else goto _L1
_L1:
        View view = null;
_L6:
        return view;
_L2:
        int i;
        int j;
        j = viewgroup.getChildCount();
        i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        View view1;
        view1 = viewgroup.getChildAt(i);
        if (!(view1 instanceof android.support.v7.internal.view.menu.MenuView.ItemView))
        {
            continue; /* Loop/switch isn't completed */
        }
        view = view1;
        if (((android.support.v7.internal.view.menu.MenuView.ItemView)view1).getItemData() == menuitem) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    public void bindItemView(MenuItemImpl menuitemimpl, android.support.v7.internal.view.menu.MenuView.ItemView itemview)
    {
        itemview.initialize(menuitemimpl, 0);
        menuitemimpl = (ActionMenuView)mMenuView;
        itemview = (ActionMenuItemView)itemview;
        itemview.a(menuitemimpl);
        if (mPopupCallback == null)
        {
            mPopupCallback = new ActionMenuPopupCallback(null);
        }
        itemview.a(mPopupCallback);
    }

    public boolean dismissPopupMenus()
    {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewgroup, int i)
    {
        if (viewgroup.getChildAt(i) == mOverflowButton)
        {
            return false;
        } else
        {
            return super.filterLeftoverView(viewgroup, i);
        }
    }

    public boolean flagActionItems()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int k;
        int l;
        int l3;
        int j5;
        int k5;
label0:
        {
            arraylist = mMenu.k();
            j5 = arraylist.size();
            int i = mMaxItems;
            l3 = mActionItemWidthLimit;
            k5 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)mMenuView;
            l = 0;
            int i1 = 0;
            boolean flag = false;
            k = 0;
            while (k < j5) 
            {
                MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(k);
                if (menuitemimpl.j())
                {
                    l++;
                } else
                if (menuitemimpl.i())
                {
                    i1++;
                } else
                {
                    flag = true;
                }
                if (mExpandedActionViewsExclusive && menuitemimpl.isActionViewExpanded())
                {
                    i = 0;
                }
                k++;
            }
            k = i;
            if (!mReserveOverflow)
            {
                break label0;
            }
            if (!flag)
            {
                k = i;
                if (l + i1 <= i)
                {
                    break label0;
                }
            }
            k = i - 1;
        }
        k -= l;
        SparseBooleanArray sparsebooleanarray = mActionButtonGroups;
        sparsebooleanarray.clear();
        int j;
        int k1;
        boolean flag1;
        int j3;
        int k3;
        if (mStrictWidthLimit)
        {
            j = l3 / mMinCellSize;
            l = mMinCellSize;
            int j1 = mMinCellSize;
            j3 = (l3 % l) / j + j1;
        } else
        {
            j3 = 0;
            j = 0;
        }
        flag1 = false;
        k3 = 0;
        l = j;
        j = k;
        k1 = l3;
        k = ((flag1) ? 1 : 0);
        while (k3 < j5) 
        {
            MenuItemImpl menuitemimpl1 = (MenuItemImpl)arraylist.get(k3);
            if (menuitemimpl1.j())
            {
                View view = getItemView(menuitemimpl1, mScrapActionButtonView, viewgroup);
                if (mScrapActionButtonView == null)
                {
                    mScrapActionButtonView = view;
                }
                int l1;
                int i4;
                if (mStrictWidthLimit)
                {
                    l1 = l - ActionMenuView.measureChildForCells(view, j3, l, k5, 0);
                } else
                {
                    view.measure(k5, k5);
                    l1 = l;
                }
                l = view.getMeasuredWidth();
                if (k == 0)
                {
                    k = l;
                }
                i4 = menuitemimpl1.getGroupId();
                if (i4 != 0)
                {
                    sparsebooleanarray.put(i4, true);
                }
                menuitemimpl1.d(true);
                l = k1 - l;
                k1 = j;
                j = l1;
            } else
            if (menuitemimpl1.i())
            {
                int l5 = menuitemimpl1.getGroupId();
                boolean flag3 = sparsebooleanarray.get(l5);
                boolean flag2;
                if ((j > 0 || flag3) && k1 > 0 && (!mStrictWidthLimit || l > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                int l2;
                if (flag2)
                {
                    View view1 = getItemView(menuitemimpl1, mScrapActionButtonView, viewgroup);
                    if (mScrapActionButtonView == null)
                    {
                        mScrapActionButtonView = view1;
                    }
                    int j2;
                    int k4;
                    if (mStrictWidthLimit)
                    {
                        int j4 = ActionMenuView.measureChildForCells(view1, j3, l, k5, 0);
                        int i2 = l - j4;
                        l = i2;
                        if (j4 == 0)
                        {
                            flag2 = false;
                            l = i2;
                        }
                    } else
                    {
                        view1.measure(k5, k5);
                    }
                    k4 = view1.getMeasuredWidth();
                    k1 -= k4;
                    j2 = k;
                    if (k == 0)
                    {
                        j2 = k4;
                    }
                    if (mStrictWidthLimit)
                    {
                        int l4;
                        if (k1 >= 0)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        flag2 &= k;
                        k = l;
                        l = j2;
                    } else
                    {
                        if (k1 + j2 > 0)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        flag2 &= k;
                        k = l;
                        l = j2;
                    }
                } else
                {
                    int i3 = l;
                    l = k;
                    k = i3;
                }
                if (flag2 && l5 != 0)
                {
                    sparsebooleanarray.put(l5, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(l5, false);
                    int i5 = 0;
                    while (i5 < k3) 
                    {
                        MenuItemImpl menuitemimpl2 = (MenuItemImpl)arraylist.get(i5);
                        int k2 = j;
                        if (menuitemimpl2.getGroupId() == l5)
                        {
                            k2 = j;
                            if (menuitemimpl2.h())
                            {
                                k2 = j + 1;
                            }
                            menuitemimpl2.d(false);
                        }
                        i5++;
                        j = k2;
                    }
                }
                j2 = j;
                if (flag2)
                {
                    j2 = j - 1;
                }
                menuitemimpl1.d(flag2);
                l4 = l;
                l = k1;
                k1 = j2;
                j = k;
                k = l4;
            } else
            {
                menuitemimpl1.d(false);
                l2 = j;
                j = l;
                l = k1;
                k1 = l2;
            }
            i4 = k3 + 1;
            l1 = l;
            k3 = k1;
            l = j;
            k1 = l1;
            j = k3;
            k3 = i4;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuitemimpl, View view, ViewGroup viewgroup)
    {
        View view1 = menuitemimpl.getActionView();
        if (view1 == null || menuitemimpl.l())
        {
            view1 = super.getItemView(menuitemimpl, view, viewgroup);
        }
        byte byte0;
        if (menuitemimpl.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        menuitemimpl = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!menuitemimpl.checkLayoutParams(view))
        {
            view1.setLayoutParams(menuitemimpl.generateLayoutParams(view));
        }
        return view1;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        viewgroup = super.getMenuView(viewgroup);
        ((ActionMenuView)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public boolean hideOverflowMenu()
    {
        if (mPostedOpenRunnable != null && mMenuView != null)
        {
            ((View)mMenuView).removeCallbacks(mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowpopup = mOverflowPopup;
        if (overflowpopup != null)
        {
            overflowpopup.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean hideSubMenus()
    {
        if (mActionButtonPopup != null)
        {
            mActionButtonPopup.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
        initForMenu(context, menubuilder);
        menubuilder = context.getResources();
        context = ActionBarPolicy.get(context);
        if (!mReserveOverflowSet)
        {
            mReserveOverflow = context.showsOverflowMenuButton();
        }
        if (!mWidthLimitSet)
        {
            mWidthLimit = context.getEmbeddedMenuWidthLimit();
        }
        if (!mMaxItemsSet)
        {
            mMaxItems = context.getMaxActionButtons();
        }
        int i = mWidthLimit;
        if (mReserveOverflow)
        {
            if (mOverflowButton == null)
            {
                mOverflowButton = new OverflowMenuButton(mSystemContext);
                int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(j, j);
            }
            i -= mOverflowButton.getMeasuredWidth();
        } else
        {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = i;
        mMinCellSize = (int)(56F * menubuilder.getDisplayMetrics().density);
        mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending()
    {
        return mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing()
    {
        return mOverflowPopup != null && mOverflowPopup.isShowing();
    }

    public boolean isOverflowReserved()
    {
        return mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        dismissPopupMenus();
        onCloseMenu(menubuilder, flag);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (!mMaxItemsSet)
        {
            mMaxItems = mContext.getResources().getInteger(android.support.v7.appcompat.R.integer.abc_max_action_buttons);
        }
        if (mMenu != null)
        {
            mMenu.b(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        if (((SavedState) (parcelable)).openSubMenuId > 0)
        {
            parcelable = mMenu.findItem(((SavedState) (parcelable)).openSubMenuId);
            if (parcelable != null)
            {
                onSubMenuSelected((SubMenuBuilder)parcelable.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState();
        savedstate.openSubMenuId = mOpenSubMenuId;
        return savedstate;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems())
        {
            return false;
        }
        Object obj;
        for (obj = submenubuilder; ((SubMenuBuilder) (obj)).r() != mMenu; obj = (SubMenuBuilder)((SubMenuBuilder) (obj)).r()) { }
        View view = findViewForItem(((SubMenuBuilder) (obj)).getItem());
        obj = view;
        if (view == null)
        {
            if (mOverflowButton == null)
            {
                return false;
            }
            obj = mOverflowButton;
        }
        mOpenSubMenuId = submenubuilder.getItem().getItemId();
        mActionButtonPopup = new ActionButtonSubmenu(mContext, submenubuilder);
        mActionButtonPopup.setAnchorView(((View) (obj)));
        mActionButtonPopup.show();
        onSubMenuSelected(submenubuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean flag)
    {
        if (flag)
        {
            onSubMenuSelected(null);
            return;
        } else
        {
            mMenu.a(false);
            return;
        }
    }

    public void setExpandedActionViewsExclusive(boolean flag)
    {
        mExpandedActionViewsExclusive = flag;
    }

    public void setItemLimit(int i)
    {
        mMaxItems = i;
        mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionmenuview)
    {
        mMenuView = actionmenuview;
        actionmenuview.initialize(mMenu);
    }

    public void setReserveOverflow(boolean flag)
    {
        mReserveOverflow = flag;
        mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean flag)
    {
        mWidthLimit = i;
        mStrictWidthLimit = flag;
        mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuitemimpl)
    {
        return menuitemimpl.h();
    }

    public boolean showOverflowMenu()
    {
        if (mReserveOverflow && !isOverflowMenuShowing() && mMenu != null && mMenuView != null && mPostedOpenRunnable == null && !mMenu.n().isEmpty())
        {
            mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(mContext, mMenu, mOverflowButton, true));
            ((View)mMenuView).post(mPostedOpenRunnable);
            onSubMenuSelected(null);
            return true;
        } else
        {
            return false;
        }
    }

    public void updateMenuView(boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = false;
        Object obj = (ViewGroup)((View)mMenuView).getParent();
        if (obj != null)
        {
            ActionBarTransition.beginDelayedTransition(((ViewGroup) (obj)));
        }
        updateMenuView(flag);
        ((View)mMenuView).requestLayout();
        if (mMenu != null)
        {
            obj = mMenu.m();
            int k = ((ArrayList) (obj)).size();
            for (int i = 0; i < k; i++)
            {
                ActionProvider actionprovider = ((MenuItemImpl)((ArrayList) (obj)).get(i)).getSupportActionProvider();
                if (actionprovider != null)
                {
                    actionprovider.setSubUiVisibilityListener(this);
                }
            }

        }
        int j;
        if (mMenu != null)
        {
            obj = mMenu.n();
        } else
        {
            obj = null;
        }
        j = ((flag2) ? 1 : 0);
        if (mReserveOverflow)
        {
            j = ((flag2) ? 1 : 0);
            if (obj != null)
            {
                j = ((ArrayList) (obj)).size();
                if (j == 1)
                {
                    if (!((MenuItemImpl)((ArrayList) (obj)).get(0)).isActionViewExpanded())
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                } else
                if (j > 0)
                {
                    j = ((flag1) ? 1 : 0);
                } else
                {
                    j = 0;
                }
            }
        }
        if (j == 0) goto _L2; else goto _L1
_L1:
        if (mOverflowButton == null)
        {
            mOverflowButton = new OverflowMenuButton(mSystemContext);
        }
        obj = (ViewGroup)mOverflowButton.getParent();
        if (obj != mMenuView)
        {
            if (obj != null)
            {
                ((ViewGroup) (obj)).removeView(mOverflowButton);
            }
            obj = (ActionMenuView)mMenuView;
            ((ActionMenuView) (obj)).addView(mOverflowButton, ((ActionMenuView) (obj)).generateOverflowButtonLayoutParams());
        }
_L4:
        ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
        return;
_L2:
        if (mOverflowButton != null && mOverflowButton.getParent() == mMenuView)
        {
            ((ViewGroup)mMenuView).removeView(mOverflowButton);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



/*
    static OverflowPopup access$202(ActionMenuPresenter actionmenupresenter, OverflowPopup overflowpopup)
    {
        actionmenupresenter.mOverflowPopup = overflowpopup;
        return overflowpopup;
    }

*/



/*
    static OpenOverflowRunnable access$302(ActionMenuPresenter actionmenupresenter, OpenOverflowRunnable openoverflowrunnable)
    {
        actionmenupresenter.mPostedOpenRunnable = openoverflowrunnable;
        return openoverflowrunnable;
    }

*/






/*
    static ActionButtonSubmenu access$702(ActionMenuPresenter actionmenupresenter, ActionButtonSubmenu actionbuttonsubmenu)
    {
        actionmenupresenter.mActionButtonPopup = actionbuttonsubmenu;
        return actionbuttonsubmenu;
    }

*/



    private class PopupPresenterCallback
        implements android.support.v7.internal.view.menu.MenuPresenter.Callback
    {

        final ActionMenuPresenter this$0;

        public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
        {
            if (menubuilder instanceof SubMenuBuilder)
            {
                ((SubMenuBuilder)menubuilder).o().a(false);
            }
            android.support.v7.internal.view.menu.MenuPresenter.Callback callback = getCallback();
            if (callback != null)
            {
                callback.onCloseMenu(menubuilder, flag);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menubuilder)
        {
            if (menubuilder == null)
            {
                return false;
            }
            mOpenSubMenuId = ((SubMenuBuilder)menubuilder).getItem().getItemId();
            android.support.v7.internal.view.menu.MenuPresenter.Callback callback = getCallback();
            if (callback != null)
            {
                return callback.onOpenSubMenu(menubuilder);
            } else
            {
                return false;
            }
        }

        private PopupPresenterCallback()
        {
            this$0 = ActionMenuPresenter.this;
            super();
        }

        PopupPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActionMenuPopupCallback extends android.support.v7.internal.view.menu.ActionMenuItemView.PopupCallback
    {

        final ActionMenuPresenter this$0;

        public ListPopupWindow getPopup()
        {
            if (mActionButtonPopup != null)
            {
                return mActionButtonPopup.getPopup();
            } else
            {
                return null;
            }
        }

        private ActionMenuPopupCallback()
        {
            this$0 = ActionMenuPresenter.this;
            super();
        }

        ActionMenuPopupCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    /* member class not found */
    class ActionButtonSubmenu {}


    private class OverflowMenuButton extends TintImageView
        implements ActionMenuView.ActionMenuChildView
    {

        private final float mTempPts[] = new float[2];
        final ActionMenuPresenter this$0;

        public boolean needsDividerAfter()
        {
            return false;
        }

        public boolean needsDividerBefore()
        {
            return false;
        }

        public boolean performClick()
        {
            if (performClick())
            {
                return true;
            } else
            {
                playSoundEffect(0);
                showOverflowMenu();
                return true;
            }
        }

        protected boolean setFrame(int i, int j, int k, int l)
        {
            boolean flag = setFrame(i, j, k, l);
            Drawable drawable = getDrawable();
            Drawable drawable1 = getBackground();
            if (drawable != null && drawable1 != null)
            {
                float af[] = mTempPts;
                af[0] = drawable.getBounds().centerX();
                getImageMatrix().mapPoints(af);
                i = (int)af[0] - getWidth() / 2;
                DrawableCompat.setHotspotBounds(drawable1, i, 0, getWidth() + i, getHeight());
            }
            return flag;
        }

        public OverflowMenuButton(Context context)
        {
            this$0 = ActionMenuPresenter.this;
            TintImageView(context, null, android.support.v7.appcompat.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            class _cls1 extends ListPopupWindow.ForwardingListener
            {

                final OverflowMenuButton this$1;
                final ActionMenuPresenter val$this$0;

                public ListPopupWindow getPopup()
                {
                    if (mOverflowPopup == null)
                    {
                        return null;
                    } else
                    {
                        return mOverflowPopup.getPopup();
                    }
                }

                public boolean onForwardingStarted()
                {
                    showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped()
                {
                    if (mPostedOpenRunnable != null)
                    {
                        return false;
                    } else
                    {
                        hideOverflowMenu();
                        return true;
                    }
                }

                _cls1(ActionMenuPresenter actionmenupresenter)
                {
                    this$1 = OverflowMenuButton.this;
                    this$0 = actionmenupresenter;
                    ForwardingListener(final_view);
                }

            }

            setOnTouchListener(new _cls1(ActionMenuPresenter.this));
        }
    }


    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        public int openSubMenuId;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(openSubMenuId);
        }


        SavedState()
        {
        }

        SavedState(Parcel parcel)
        {
            openSubMenuId = parcel.readInt();
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

                _cls1()
                {
                }
        }

    }


}
