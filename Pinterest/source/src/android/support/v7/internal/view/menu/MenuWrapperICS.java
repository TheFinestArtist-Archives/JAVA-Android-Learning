// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

// Referenced classes of package android.support.v7.internal.view.menu:
//            BaseMenuWrapper

class MenuWrapperICS extends BaseMenuWrapper
    implements Menu
{

    MenuWrapperICS(Context context, SupportMenu supportmenu)
    {
        super(context, supportmenu);
    }

    public MenuItem add(int i)
    {
        return a(((SupportMenu)b).add(i));
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        return a(((SupportMenu)b).add(i, j, k, l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        return a(((SupportMenu)b).add(i, j, k, charsequence));
    }

    public MenuItem add(CharSequence charsequence)
    {
        return a(((SupportMenu)b).add(charsequence));
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[])
    {
        MenuItem amenuitem1[] = null;
        if (amenuitem != null)
        {
            amenuitem1 = new MenuItem[amenuitem.length];
        }
        j = ((SupportMenu)b).addIntentOptions(i, j, k, componentname, aintent, intent, l, amenuitem1);
        if (amenuitem1 != null)
        {
            i = 0;
            for (k = amenuitem1.length; i < k; i++)
            {
                amenuitem[i] = a(amenuitem1[i]);
            }

        }
        return j;
    }

    public SubMenu addSubMenu(int i)
    {
        return a(((SupportMenu)b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int j, int k, int l)
    {
        return a(((SupportMenu)b).addSubMenu(i, j, k, l));
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence)
    {
        return a(((SupportMenu)b).addSubMenu(i, j, k, charsequence));
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return a(((SupportMenu)b).addSubMenu(charsequence));
    }

    public void clear()
    {
        a();
        ((SupportMenu)b).clear();
    }

    public void close()
    {
        ((SupportMenu)b).close();
    }

    public MenuItem findItem(int i)
    {
        return a(((SupportMenu)b).findItem(i));
    }

    public MenuItem getItem(int i)
    {
        return a(((SupportMenu)b).getItem(i));
    }

    public boolean hasVisibleItems()
    {
        return ((SupportMenu)b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent)
    {
        return ((SupportMenu)b).isShortcutKey(i, keyevent);
    }

    public boolean performIdentifierAction(int i, int j)
    {
        return ((SupportMenu)b).performIdentifierAction(i, j);
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j)
    {
        return ((SupportMenu)b).performShortcut(i, keyevent, j);
    }

    public void removeGroup(int i)
    {
        a(i);
        ((SupportMenu)b).removeGroup(i);
    }

    public void removeItem(int i)
    {
        b(i);
        ((SupportMenu)b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1)
    {
        ((SupportMenu)b).setGroupCheckable(i, flag, flag1);
    }

    public void setGroupEnabled(int i, boolean flag)
    {
        ((SupportMenu)b).setGroupEnabled(i, flag);
    }

    public void setGroupVisible(int i, boolean flag)
    {
        ((SupportMenu)b).setGroupVisible(i, flag);
    }

    public void setQwertyMode(boolean flag)
    {
        ((SupportMenu)b).setQwertyMode(flag);
    }

    public int size()
    {
        return ((SupportMenu)b).size();
    }
}
