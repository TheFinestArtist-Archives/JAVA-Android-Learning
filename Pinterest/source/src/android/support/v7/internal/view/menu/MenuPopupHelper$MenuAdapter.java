// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuPopupHelper, MenuBuilder, MenuItemImpl, ListMenuItemView

class a extends BaseAdapter
{

    final MenuPopupHelper a;
    private MenuBuilder b;
    private int c;

    static MenuBuilder a(a a1)
    {
        return a1.b;
    }

    private void a()
    {
        MenuItemImpl menuitemimpl = MenuPopupHelper.access$300(a).q();
        if (menuitemimpl != null)
        {
            ArrayList arraylist = MenuPopupHelper.access$300(a).n();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((MenuItemImpl)arraylist.get(i) == menuitemimpl)
                {
                    c = i;
                    return;
                }
            }

        }
        c = -1;
    }

    public final MenuItemImpl a(int i)
    {
        ArrayList arraylist;
        int j;
        if (MenuPopupHelper.access$100(a))
        {
            arraylist = b.n();
        } else
        {
            arraylist = b.k();
        }
        j = i;
        if (c >= 0)
        {
            j = i;
            if (i >= c)
            {
                j = i + 1;
            }
        }
        return (MenuItemImpl)arraylist.get(j);
    }

    public int getCount()
    {
        ArrayList arraylist;
        if (MenuPopupHelper.access$100(a))
        {
            arraylist = b.n();
        } else
        {
            arraylist = b.k();
        }
        if (c < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
        }
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = MenuPopupHelper.access$200(a).inflate(MenuPopupHelper.ITEM_LAYOUT, viewgroup, false);
        }
        viewgroup = (a)view;
        if (a.mForceShowIcon)
        {
            ((ListMenuItemView)view).a();
        }
        viewgroup.(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }

    public (MenuPopupHelper menupopuphelper, MenuBuilder menubuilder)
    {
        a = menupopuphelper;
        super();
        c = -1;
        b = menubuilder;
        a();
    }
}
