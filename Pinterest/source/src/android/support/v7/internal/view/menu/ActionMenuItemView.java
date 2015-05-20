// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.CompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemImpl

public class ActionMenuItemView extends CompatTextView
    implements MenuView.ItemView, android.support.v7.widget.ActionMenuView.ActionMenuChildView, android.view.View.OnClickListener, android.view.View.OnLongClickListener
{

    private MenuItemImpl a;
    private CharSequence b;
    private Drawable c;
    private MenuBuilder.ItemInvoker d;
    private android.support.v7.widget.ListPopupWindow.ForwardingListener e;
    private PopupCallback f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    public ActionMenuItemView(Context context)
    {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        Resources resources = context.getResources();
        g = resources.getBoolean(android.support.v7.appcompat.R.bool.abc_config_allowActionMenuItemTextWithIcon);
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.appcompat.R.styleable.ActionMenuItemView, l, 0);
        i = attributeset.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionMenuItemView_android_minWidth, 0);
        attributeset.recycle();
        k = (int)(resources.getDisplayMetrics().density * 32F + 0.5F);
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new AllCapsTransformationMethod(context));
        j = -1;
    }

    static PopupCallback a(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.f;
    }

    static MenuBuilder.ItemInvoker b(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.d;
    }

    private void b()
    {
        CharSequence charsequence;
label0:
        {
            boolean flag2 = false;
            boolean flag;
            boolean flag1;
            if (!TextUtils.isEmpty(b))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c != null)
            {
                flag1 = flag2;
                if (!a.k())
                {
                    break label0;
                }
                if (!g)
                {
                    flag1 = flag2;
                    if (!h)
                    {
                        break label0;
                    }
                }
            }
            flag1 = true;
        }
        if (flag & flag1)
        {
            charsequence = b;
        } else
        {
            charsequence = null;
        }
        setText(charsequence);
    }

    static MenuItemImpl c(ActionMenuItemView actionmenuitemview)
    {
        return actionmenuitemview.a;
    }

    public final void a(PopupCallback popupcallback)
    {
        f = popupcallback;
    }

    public final void a(MenuBuilder.ItemInvoker iteminvoker)
    {
        d = iteminvoker;
    }

    public final boolean a()
    {
        return !TextUtils.isEmpty(getText());
    }

    public MenuItemImpl getItemData()
    {
        return a;
    }

    public void initialize(MenuItemImpl menuitemimpl, int l)
    {
        a = menuitemimpl;
        setIcon(menuitemimpl.getIcon());
        setTitle(menuitemimpl.a(this));
        setId(menuitemimpl.getItemId());
        if (menuitemimpl.isVisible())
        {
            l = 0;
        } else
        {
            l = 8;
        }
        setVisibility(l);
        setEnabled(menuitemimpl.isEnabled());
        if (menuitemimpl.hasSubMenu() && e == null)
        {
            e = new ActionMenuItemForwardingListener();
        }
    }

    public boolean needsDividerAfter()
    {
        return a();
    }

    public boolean needsDividerBefore()
    {
        return a() && a.getIcon() == null;
    }

    public void onClick(View view)
    {
        if (d != null)
        {
            d.invokeItem(a);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        g = getContext().getResources().getBoolean(android.support.v7.appcompat.R.bool.abc_config_allowActionMenuItemTextWithIcon);
        b();
    }

    public boolean onLongClick(View view)
    {
        if (a())
        {
            return false;
        }
        int ai[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int l = getWidth();
        int j1 = getHeight();
        int k1 = ai[1];
        int l1 = j1 / 2;
        int i1 = ai[0] + l / 2;
        l = i1;
        if (ViewCompat.getLayoutDirection(view) == 0)
        {
            l = context.getResources().getDisplayMetrics().widthPixels - i1;
        }
        view = Toast.makeText(context, a.getTitle(), 0);
        if (k1 + l1 < rect.height())
        {
            view.setGravity(0x800035, l, j1);
        } else
        {
            view.setGravity(81, 0, j1);
        }
        view.show();
        return true;
    }

    protected void onMeasure(int l, int i1)
    {
        boolean flag = a();
        if (flag && j >= 0)
        {
            super.setPadding(j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(l, i1);
        int j1 = android.view.View.MeasureSpec.getMode(l);
        l = android.view.View.MeasureSpec.getSize(l);
        int k1 = getMeasuredWidth();
        if (j1 == 0x80000000)
        {
            l = Math.min(l, i);
        } else
        {
            l = i;
        }
        if (j1 != 0x40000000 && i > 0 && k1 < l)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000), i1);
        }
        if (!flag && c != null)
        {
            super.setPadding((getMeasuredWidth() - c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a.hasSubMenu() && e != null && e.onTouch(this, motionevent))
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public boolean prefersCondensedTitle()
    {
        return true;
    }

    public void setCheckable(boolean flag)
    {
    }

    public void setChecked(boolean flag)
    {
    }

    public void setIcon(Drawable drawable)
    {
        c = drawable;
        if (drawable != null)
        {
            int k1 = drawable.getIntrinsicWidth();
            int j1 = drawable.getIntrinsicHeight();
            int i1 = j1;
            int l = k1;
            if (k1 > k)
            {
                float f1 = (float)k / (float)k1;
                l = k;
                i1 = (int)((float)j1 * f1);
            }
            k1 = i1;
            j1 = l;
            if (i1 > k)
            {
                float f2 = (float)k / (float)i1;
                k1 = k;
                j1 = (int)((float)l * f2);
            }
            drawable.setBounds(0, 0, j1, k1);
        }
        setCompoundDrawables(drawable, null, null, null);
        b();
    }

    public void setPadding(int l, int i1, int j1, int k1)
    {
        j = l;
        super.setPadding(l, i1, j1, k1);
    }

    public void setShortcut(boolean flag, char c1)
    {
    }

    public void setTitle(CharSequence charsequence)
    {
        b = charsequence;
        setContentDescription(b);
        b();
    }

    public boolean showsIcon()
    {
        return true;
    }

    private class ActionMenuItemForwardingListener extends android.support.v7.widget.ListPopupWindow.ForwardingListener
    {

        final ActionMenuItemView a;

        public ListPopupWindow getPopup()
        {
            if (ActionMenuItemView.a(a) != null)
            {
                return ActionMenuItemView.a(a).getPopup();
            } else
            {
                return null;
            }
        }

        protected boolean onForwardingStarted()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (ActionMenuItemView.b(a) != null)
            {
                flag = flag1;
                if (ActionMenuItemView.b(a).invokeItem(ActionMenuItemView.c(a)))
                {
                    ListPopupWindow listpopupwindow = getPopup();
                    flag = flag1;
                    if (listpopupwindow != null)
                    {
                        flag = flag1;
                        if (listpopupwindow.isShowing())
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        protected boolean onForwardingStopped()
        {
            ListPopupWindow listpopupwindow = getPopup();
            if (listpopupwindow != null)
            {
                listpopupwindow.dismiss();
                return true;
            } else
            {
                return false;
            }
        }

        public ActionMenuItemForwardingListener()
        {
            a = ActionMenuItemView.this;
            super(ActionMenuItemView.this);
        }

        private class PopupCallback
        {

            public abstract ListPopupWindow getPopup();

            public PopupCallback()
            {
            }
        }

    }

}
