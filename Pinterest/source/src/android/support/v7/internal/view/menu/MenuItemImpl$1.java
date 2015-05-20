// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;


// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemImpl, MenuBuilder

class a
    implements android.support.v4.view.VisibilityListener
{

    final MenuItemImpl a;

    public void onActionProviderVisibilityChanged(boolean flag)
    {
        MenuItemImpl.a(a).i();
    }

    ener(MenuItemImpl menuitemimpl)
    {
        a = menuitemimpl;
        super();
    }
}
