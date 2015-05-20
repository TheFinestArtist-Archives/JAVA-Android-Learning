// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemWrapperICS

class MenuItemWrapperJB extends MenuItemWrapperICS
{

    MenuItemWrapperJB(Context context, SupportMenuItem supportmenuitem)
    {
        super(context, supportmenuitem);
    }

    final MenuItemWrapperICS.ActionProviderWrapper a(ActionProvider actionprovider)
    {
        return new ActionProviderWrapperJB(a, actionprovider);
    }

    private class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper
        implements android.view.ActionProvider.VisibilityListener
    {

        android.support.v4.view.ActionProvider.VisibilityListener c;
        final MenuItemWrapperJB d;

        public boolean isVisible()
        {
            return a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean flag)
        {
            if (c != null)
            {
                c.onActionProviderVisibilityChanged(flag);
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

        public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener visibilitylistener)
        {
            c = visibilitylistener;
            ActionProvider actionprovider = a;
            if (visibilitylistener != null)
            {
                visibilitylistener = this;
            } else
            {
                visibilitylistener = null;
            }
            actionprovider.setVisibilityListener(visibilitylistener);
        }

        public ActionProviderWrapperJB(Context context, ActionProvider actionprovider)
        {
            d = MenuItemWrapperJB.this;
            super(MenuItemWrapperJB.this, context, actionprovider);
        }
    }

}
