// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuPresenter, ExpandedMenuView, MenuBuilder, SubMenuBuilder, 
//            MenuDialogHelper, MenuItemImpl, MenuView

public class ListMenuPresenter
    implements MenuPresenter, android.widget.AdapterView.OnItemClickListener
{

    Context a;
    LayoutInflater b;
    MenuBuilder c;
    ExpandedMenuView d;
    int e;
    int f;
    MenuAdapter g;
    private int h;
    private MenuPresenter.Callback i;
    private int j;

    public ListMenuPresenter(int k, int l)
    {
        f = k;
        e = l;
    }

    public ListMenuPresenter(Context context, int k)
    {
        this(k, 0);
        a = context;
        b = LayoutInflater.from(a);
    }

    static int a(ListMenuPresenter listmenupresenter)
    {
        return listmenupresenter.h;
    }

    public final ListAdapter a()
    {
        if (g == null)
        {
            g = new MenuAdapter();
        }
        return g;
    }

    public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return j;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        if (d == null)
        {
            d = (ExpandedMenuView)b.inflate(android.support.v7.appcompat.R.layout.abc_expanded_menu_layout, viewgroup, false);
            if (g == null)
            {
                g = new MenuAdapter();
            }
            d.setAdapter(g);
            d.setOnItemClickListener(this);
        }
        return d;
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
        if (e == 0) goto _L2; else goto _L1
_L1:
        a = new ContextThemeWrapper(context, e);
        b = LayoutInflater.from(a);
_L4:
        c = menubuilder;
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
        return;
_L2:
        if (a != null)
        {
            a = context;
            if (b == null)
            {
                b = LayoutInflater.from(a);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if (i != null)
        {
            i.onCloseMenu(menubuilder, flag);
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int k, long l)
    {
        c.a(g.a(k), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = ((Bundle)parcelable).getSparseParcelableArray("android:menu:list");
        if (parcelable != null)
        {
            d.restoreHierarchyState(parcelable);
        }
    }

    public Parcelable onSaveInstanceState()
    {
        if (d == null)
        {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparsearray = new SparseArray();
        if (d != null)
        {
            d.saveHierarchyState(sparsearray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparsearray);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems())
        {
            return false;
        }
        (new MenuDialogHelper(submenubuilder)).a();
        if (i != null)
        {
            i.onOpenSubMenu(submenubuilder);
        }
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback)
    {
        i = callback;
    }

    public void updateMenuView(boolean flag)
    {
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
    }

    private class MenuAdapter extends BaseAdapter
    {

        final ListMenuPresenter a;
        private int b;

        private void a()
        {
            MenuItemImpl menuitemimpl = a.c.q();
            if (menuitemimpl != null)
            {
                ArrayList arraylist = a.c.n();
                int l = arraylist.size();
                for (int k = 0; k < l; k++)
                {
                    if ((MenuItemImpl)arraylist.get(k) == menuitemimpl)
                    {
                        b = k;
                        return;
                    }
                }

            }
            b = -1;
        }

        public final MenuItemImpl a(int k)
        {
            ArrayList arraylist = a.c.n();
            int l = ListMenuPresenter.a(a) + k;
            k = l;
            if (b >= 0)
            {
                k = l;
                if (l >= b)
                {
                    k = l + 1;
                }
            }
            return (MenuItemImpl)arraylist.get(k);
        }

        public int getCount()
        {
            int k = a.c.n().size() - ListMenuPresenter.a(a);
            if (b < 0)
            {
                return k;
            } else
            {
                return k - 1;
            }
        }

        public Object getItem(int k)
        {
            return a(k);
        }

        public long getItemId(int k)
        {
            return (long)k;
        }

        public View getView(int k, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = a.b.inflate(a.f, viewgroup, false);
            }
            ((MenuView.ItemView)view).initialize(a(k), 0);
            return view;
        }

        public void notifyDataSetChanged()
        {
            a();
            super.notifyDataSetChanged();
        }

        public MenuAdapter()
        {
            a = ListMenuPresenter.this;
            super();
            b = -1;
            a();
        }
    }

}
