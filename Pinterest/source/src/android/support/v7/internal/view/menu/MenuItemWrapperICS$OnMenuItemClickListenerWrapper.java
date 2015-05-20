// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.view.menu:
//            BaseWrapper, MenuItemWrapperICS

class a extends BaseWrapper
    implements android.view.ItemClickListenerWrapper
{

    final MenuItemWrapperICS a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        return ((android.view.ItemClickListenerWrapper)b).b(a.a(menuitem));
    }

    (MenuItemWrapperICS menuitemwrapperics, android.view.ItemClickListenerWrapper itemclicklistenerwrapper)
    {
        a = menuitemwrapperics;
        super(itemclicklistenerwrapper);
    }
}
