// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.app:
//            ToolbarActionBar, WindowCallback

final class <init>
    implements android.support.v7.internal.view.menu.
{

    final ToolbarActionBar this$0;

    public final boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem)
    {
        return false;
    }

    public final void onMenuModeChange(MenuBuilder menubuilder)
    {
        if (ToolbarActionBar.access$000(ToolbarActionBar.this) != null)
        {
            if (ToolbarActionBar.access$400(ToolbarActionBar.this).isOverflowMenuShowing())
            {
                ToolbarActionBar.access$000(ToolbarActionBar.this).onPanelClosed(8, menubuilder);
            } else
            if (ToolbarActionBar.access$000(ToolbarActionBar.this).onPreparePanel(0, null, menubuilder))
            {
                ToolbarActionBar.access$000(ToolbarActionBar.this).onMenuOpened(8, menubuilder);
                return;
            }
        }
    }

    private ()
    {
        this$0 = ToolbarActionBar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
