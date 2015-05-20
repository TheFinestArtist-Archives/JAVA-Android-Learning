// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.view.menu:
//            BaseWrapper, MenuItemWrapperICS

class a extends BaseWrapper
    implements android.support.v4.view.stenerWrapper
{

    final MenuItemWrapperICS a;

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return ((android.view.ionExpandListenerWrapper)b).ollapse(a.a(menuitem));
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return ((android.view.ionExpandListenerWrapper)b).xpand(a.a(menuitem));
    }

    (MenuItemWrapperICS menuitemwrapperics, android.view.ionExpandListenerWrapper ionexpandlistenerwrapper)
    {
        a = menuitemwrapperics;
        super(ionexpandlistenerwrapper);
    }
}
