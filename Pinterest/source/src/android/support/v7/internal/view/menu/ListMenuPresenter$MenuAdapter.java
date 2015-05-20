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
//            ListMenuPresenter, MenuBuilder, MenuItemImpl

class a extends BaseAdapter
{

    final ListMenuPresenter a;
    private int b;

    private void a()
    {
        MenuItemImpl menuitemimpl = a.c.q();
        if (menuitemimpl != null)
        {
            ArrayList arraylist = a.c.n();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((MenuItemImpl)arraylist.get(i) == menuitemimpl)
                {
                    b = i;
                    return;
                }
            }

        }
        b = -1;
    }

    public final MenuItemImpl a(int i)
    {
        ArrayList arraylist = a.c.n();
        int j = ListMenuPresenter.a(a) + i;
        i = j;
        if (b >= 0)
        {
            i = j;
            if (j >= b)
            {
                i = j + 1;
            }
        }
        return (MenuItemImpl)arraylist.get(i);
    }

    public int getCount()
    {
        int i = a.c.n().size() - ListMenuPresenter.a(a);
        if (b < 0)
        {
            return i;
        } else
        {
            return i - 1;
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
            view = a.b.inflate(a.f, viewgroup, false);
        }
        ((a)view).a(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }

    public I(ListMenuPresenter listmenupresenter)
    {
        a = listmenupresenter;
        super();
        b = -1;
        a();
    }
}
