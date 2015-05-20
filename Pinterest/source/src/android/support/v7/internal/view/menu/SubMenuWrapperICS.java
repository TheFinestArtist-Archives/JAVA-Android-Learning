// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuWrapperICS

class SubMenuWrapperICS extends MenuWrapperICS
    implements SubMenu
{

    SubMenuWrapperICS(Context context, SupportSubMenu supportsubmenu)
    {
        super(context, supportsubmenu);
    }

    public void clearHeader()
    {
        ((SupportSubMenu)b).clearHeader();
    }

    public MenuItem getItem()
    {
        return a(((SupportSubMenu)b).getItem());
    }

    public SubMenu setHeaderIcon(int i)
    {
        ((SupportSubMenu)b).setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable)
    {
        ((SupportSubMenu)b).setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i)
    {
        ((SupportSubMenu)b).setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charsequence)
    {
        ((SupportSubMenu)b).setHeaderTitle(charsequence);
        return this;
    }

    public SubMenu setHeaderView(View view)
    {
        ((SupportSubMenu)b).setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i)
    {
        ((SupportSubMenu)b).setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable)
    {
        ((SupportSubMenu)b).setIcon(drawable);
        return this;
    }
}
