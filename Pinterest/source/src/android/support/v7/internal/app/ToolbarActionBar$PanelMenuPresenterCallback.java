// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.Window;

// Referenced classes of package android.support.v7.internal.app:
//            ToolbarActionBar, WindowCallback

final class <init>
    implements android.support.v7.internal.view.menu.
{

    final ToolbarActionBar this$0;

    public final void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if (ToolbarActionBar.access$000(ToolbarActionBar.this) != null)
        {
            ToolbarActionBar.access$000(ToolbarActionBar.this).onPanelClosed(0, menubuilder);
        }
        ToolbarActionBar.access$1000(ToolbarActionBar.this).closePanel(0);
    }

    public final boolean onOpenSubMenu(MenuBuilder menubuilder)
    {
        if (menubuilder == null && ToolbarActionBar.access$000(ToolbarActionBar.this) != null)
        {
            ToolbarActionBar.access$000(ToolbarActionBar.this).onMenuOpened(0, menubuilder);
        }
        return true;
    }

    private Q()
    {
        this$0 = ToolbarActionBar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
