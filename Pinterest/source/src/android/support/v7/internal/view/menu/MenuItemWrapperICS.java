// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v7.internal.view.menu:
//            BaseMenuWrapper

public class MenuItemWrapperICS extends BaseMenuWrapper
    implements MenuItem
{

    private Method c;

    MenuItemWrapperICS(Context context, SupportMenuItem supportmenuitem)
    {
        super(context, supportmenuitem);
    }

    ActionProviderWrapper a(ActionProvider actionprovider)
    {
        return new ActionProviderWrapper(a, actionprovider);
    }

    public final void b()
    {
        try
        {
            if (c == null)
            {
                c = ((SupportMenuItem)b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] {
                    Boolean.TYPE
                });
            }
            c.invoke(b, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        }
        catch (Exception exception)
        {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception);
        }
    }

    public boolean collapseActionView()
    {
        return ((SupportMenuItem)b).collapseActionView();
    }

    public boolean expandActionView()
    {
        return ((SupportMenuItem)b).expandActionView();
    }

    public ActionProvider getActionProvider()
    {
        android.support.v4.view.ActionProvider actionprovider = ((SupportMenuItem)b).getSupportActionProvider();
        if (actionprovider instanceof ActionProviderWrapper)
        {
            return ((ActionProviderWrapper)actionprovider).a;
        } else
        {
            return null;
        }
    }

    public View getActionView()
    {
        View view1 = ((SupportMenuItem)b).getActionView();
        View view = view1;
        if (view1 instanceof CollapsibleActionViewWrapper)
        {
            view = (View)((CollapsibleActionViewWrapper)view1).a;
        }
        return view;
    }

    public char getAlphabeticShortcut()
    {
        return ((SupportMenuItem)b).getAlphabeticShortcut();
    }

    public int getGroupId()
    {
        return ((SupportMenuItem)b).getGroupId();
    }

    public Drawable getIcon()
    {
        return ((SupportMenuItem)b).getIcon();
    }

    public Intent getIntent()
    {
        return ((SupportMenuItem)b).getIntent();
    }

    public int getItemId()
    {
        return ((SupportMenuItem)b).getItemId();
    }

    public android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return ((SupportMenuItem)b).getMenuInfo();
    }

    public char getNumericShortcut()
    {
        return ((SupportMenuItem)b).getNumericShortcut();
    }

    public int getOrder()
    {
        return ((SupportMenuItem)b).getOrder();
    }

    public SubMenu getSubMenu()
    {
        return a(((SupportMenuItem)b).getSubMenu());
    }

    public CharSequence getTitle()
    {
        return ((SupportMenuItem)b).getTitle();
    }

    public CharSequence getTitleCondensed()
    {
        return ((SupportMenuItem)b).getTitleCondensed();
    }

    public boolean hasSubMenu()
    {
        return ((SupportMenuItem)b).hasSubMenu();
    }

    public boolean isActionViewExpanded()
    {
        return ((SupportMenuItem)b).isActionViewExpanded();
    }

    public boolean isCheckable()
    {
        return ((SupportMenuItem)b).isCheckable();
    }

    public boolean isChecked()
    {
        return ((SupportMenuItem)b).isChecked();
    }

    public boolean isEnabled()
    {
        return ((SupportMenuItem)b).isEnabled();
    }

    public boolean isVisible()
    {
        return ((SupportMenuItem)b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionprovider)
    {
        SupportMenuItem supportmenuitem = (SupportMenuItem)b;
        if (actionprovider != null)
        {
            actionprovider = a(actionprovider);
        } else
        {
            actionprovider = null;
        }
        supportmenuitem.setSupportActionProvider(actionprovider);
        return this;
    }

    public MenuItem setActionView(int i)
    {
        ((SupportMenuItem)b).setActionView(i);
        View view = ((SupportMenuItem)b).getActionView();
        if (view instanceof CollapsibleActionView)
        {
            ((SupportMenuItem)b).setActionView(new CollapsibleActionViewWrapper(view));
        }
        return this;
    }

    public MenuItem setActionView(View view)
    {
        Object obj = view;
        if (view instanceof CollapsibleActionView)
        {
            obj = new CollapsibleActionViewWrapper(view);
        }
        ((SupportMenuItem)b).setActionView(((View) (obj)));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c1)
    {
        ((SupportMenuItem)b).setAlphabeticShortcut(c1);
        return this;
    }

    public MenuItem setCheckable(boolean flag)
    {
        ((SupportMenuItem)b).setCheckable(flag);
        return this;
    }

    public MenuItem setChecked(boolean flag)
    {
        ((SupportMenuItem)b).setChecked(flag);
        return this;
    }

    public MenuItem setEnabled(boolean flag)
    {
        ((SupportMenuItem)b).setEnabled(flag);
        return this;
    }

    public MenuItem setIcon(int i)
    {
        ((SupportMenuItem)b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable)
    {
        ((SupportMenuItem)b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent)
    {
        ((SupportMenuItem)b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c1)
    {
        ((SupportMenuItem)b).setNumericShortcut(c1);
        return this;
    }

    public MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        SupportMenuItem supportmenuitem = (SupportMenuItem)b;
        if (onactionexpandlistener != null)
        {
            onactionexpandlistener = new OnActionExpandListenerWrapper(onactionexpandlistener);
        } else
        {
            onactionexpandlistener = null;
        }
        supportmenuitem.setSupportOnActionExpandListener(onactionexpandlistener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        SupportMenuItem supportmenuitem = (SupportMenuItem)b;
        if (onmenuitemclicklistener != null)
        {
            onmenuitemclicklistener = new OnMenuItemClickListenerWrapper(onmenuitemclicklistener);
        } else
        {
            onmenuitemclicklistener = null;
        }
        supportmenuitem.setOnMenuItemClickListener(onmenuitemclicklistener);
        return this;
    }

    public MenuItem setShortcut(char c1, char c2)
    {
        ((SupportMenuItem)b).setShortcut(c1, c2);
        return this;
    }

    public void setShowAsAction(int i)
    {
        ((SupportMenuItem)b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i)
    {
        ((SupportMenuItem)b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i)
    {
        ((SupportMenuItem)b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charsequence)
    {
        ((SupportMenuItem)b).setTitle(charsequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charsequence)
    {
        ((SupportMenuItem)b).setTitleCondensed(charsequence);
        return this;
    }

    public MenuItem setVisible(boolean flag)
    {
        return ((SupportMenuItem)b).setVisible(flag);
    }

    private class ActionProviderWrapper extends android.support.v4.view.ActionProvider
    {

        final ActionProvider a;
        final MenuItemWrapperICS b;

        public boolean hasSubMenu()
        {
            return a.hasSubMenu();
        }

        public View onCreateActionView()
        {
            return a.onCreateActionView();
        }

        public boolean onPerformDefaultAction()
        {
            return a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu submenu)
        {
            a.onPrepareSubMenu(b.a(submenu));
        }

        public ActionProviderWrapper(Context context, ActionProvider actionprovider)
        {
            b = MenuItemWrapperICS.this;
            super(context);
            a = actionprovider;
        }
    }


    private class CollapsibleActionViewWrapper extends FrameLayout
        implements android.support.v7.view.CollapsibleActionView
    {

        final CollapsibleActionView a;

        public void onActionViewCollapsed()
        {
            a.onActionViewCollapsed();
        }

        public void onActionViewExpanded()
        {
            a.onActionViewExpanded();
        }

        CollapsibleActionViewWrapper(View view)
        {
            super(view.getContext());
            a = (CollapsibleActionView)view;
            addView(view);
        }
    }


    private class OnActionExpandListenerWrapper extends BaseWrapper
        implements android.support.v4.view.MenuItemCompat.OnActionExpandListener
    {

        final MenuItemWrapperICS a;

        public boolean onMenuItemActionCollapse(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionCollapse(a.a(menuitem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionExpand(a.a(menuitem));
        }

        OnActionExpandListenerWrapper(android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
        {
            a = MenuItemWrapperICS.this;
            super(onactionexpandlistener);
        }
    }


    private class OnMenuItemClickListenerWrapper extends BaseWrapper
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        final MenuItemWrapperICS a;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            return ((android.view.MenuItem.OnMenuItemClickListener)b).onMenuItemClick(a.a(menuitem));
        }

        OnMenuItemClickListenerWrapper(android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
        {
            a = MenuItemWrapperICS.this;
            super(onmenuitemclicklistener);
        }
    }

}
