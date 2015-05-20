// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemWrapperJB

class init> extends init>
    implements android.view.S.ActionProviderWrapper
{

    android.support.v4.view.iderWrapperJB.a c;
    final MenuItemWrapperJB d;

    public boolean isVisible()
    {
        return a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean flag)
    {
        if (c != null)
        {
            c.ProviderVisibilityChanged(flag);
        }
    }

    public View onCreateActionView(MenuItem menuitem)
    {
        return a.onCreateActionView(menuitem);
    }

    public boolean overridesItemVisibility()
    {
        return a.overridesItemVisibility();
    }

    public void refreshVisibility()
    {
        a.refreshVisibility();
    }

    public void setVisibilityListener(android.support.v4.view.iderWrapperJB iderwrapperjb)
    {
        c = iderwrapperjb;
        ActionProvider actionprovider = a;
        if (iderwrapperjb != null)
        {
            iderwrapperjb = this;
        } else
        {
            iderwrapperjb = null;
        }
        actionprovider.setVisibilityListener(iderwrapperjb);
    }

    public (MenuItemWrapperJB menuitemwrapperjb, Context context, ActionProvider actionprovider)
    {
        d = menuitemwrapperjb;
        super(menuitemwrapperjb, context, actionprovider);
    }
}
