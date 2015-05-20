// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuItemImpl, MenuPresenter, SubMenuBuilder

public class MenuBuilder
    implements SupportMenu
{

    private static final int d[] = {
        1, 4, 5, 3, 2, 0
    };
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private Callback i;
    private ArrayList j;
    private ArrayList k;
    private boolean l;
    private ArrayList m;
    private ArrayList n;
    private boolean o;
    private int p;
    private android.view.ContextMenu.ContextMenuInfo q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ArrayList v;
    private CopyOnWriteArrayList w;
    private MenuItemImpl x;

    public MenuBuilder(Context context)
    {
        boolean flag = true;
        super();
        p = 0;
        r = false;
        s = false;
        t = false;
        u = false;
        v = new ArrayList();
        w = new CopyOnWriteArrayList();
        e = context;
        f = context.getResources();
        j = new ArrayList();
        k = new ArrayList();
        l = true;
        m = new ArrayList();
        n = new ArrayList();
        o = true;
        if (f.getConfiguration().keyboard == 1 || !f.getBoolean(android.support.v7.appcompat.R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))
        {
            flag = false;
        }
        h = flag;
    }

    private static int a(ArrayList arraylist, int i1)
    {
        for (int j1 = arraylist.size() - 1; j1 >= 0; j1--)
        {
            if (((MenuItemImpl)arraylist.get(j1)).b() <= i1)
            {
                return j1 + 1;
            }
        }

        return 0;
    }

    private MenuItemImpl a(int i1, KeyEvent keyevent)
    {
        ArrayList arraylist;
        arraylist = v;
        arraylist.clear();
        a(((List) (arraylist)), i1, keyevent);
        if (!arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        keyevent = null;
_L6:
        return keyevent;
_L2:
        android.view.KeyCharacterMap.KeyData keydata;
        int j1;
        int k1;
        int l1;
        boolean flag;
        k1 = keyevent.getMetaState();
        keydata = new android.view.KeyCharacterMap.KeyData();
        keyevent.getKeyData(keydata);
        l1 = arraylist.size();
        if (l1 == 1)
        {
            return (MenuItemImpl)arraylist.get(0);
        }
        flag = c();
        j1 = 0;
_L9:
        if (j1 >= l1) goto _L4; else goto _L3
_L3:
        MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(j1);
        char c1;
        if (flag)
        {
            c1 = menuitemimpl.getAlphabeticShortcut();
        } else
        {
            c1 = menuitemimpl.getNumericShortcut();
        }
        if (c1 != keydata.meta[0])
        {
            break; /* Loop/switch isn't completed */
        }
        keyevent = menuitemimpl;
        if ((k1 & 2) == 0) goto _L6; else goto _L5
_L5:
        if (c1 != keydata.meta[2])
        {
            break; /* Loop/switch isn't completed */
        }
        keyevent = menuitemimpl;
        if ((k1 & 2) != 0) goto _L6; else goto _L7
_L7:
        if (!flag || c1 != '\b')
        {
            continue; /* Loop/switch isn't completed */
        }
        keyevent = menuitemimpl;
        if (i1 == 67) goto _L6; else goto _L8
_L8:
        j1++;
          goto _L9
_L4:
        return null;
    }

    private MenuItem a(int i1, int j1, int k1, CharSequence charsequence)
    {
        int l1 = (0xffff0000 & k1) >> 16;
        if (l1 < 0 || l1 >= d.length)
        {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        l1 = d[l1] << 16 | 0xffff & k1;
        charsequence = new MenuItemImpl(this, i1, j1, k1, l1, charsequence, p);
        if (q != null)
        {
            charsequence.a(q);
        }
        j.add(a(j, l1), charsequence);
        b(true);
        return charsequence;
    }

    private void a(int i1, boolean flag)
    {
        if (i1 >= 0 && i1 < j.size())
        {
            j.remove(i1);
            if (flag)
            {
                b(true);
                return;
            }
        }
    }

    private void a(CharSequence charsequence, Drawable drawable, View view)
    {
        if (view != null)
        {
            c = view;
            a = null;
            b = null;
        } else
        {
            if (charsequence != null)
            {
                a = charsequence;
            }
            if (drawable != null)
            {
                b = drawable;
            }
            c = null;
        }
        b(false);
    }

    private void a(List list, int i1, KeyEvent keyevent)
    {
        boolean flag = c();
        int k1 = keyevent.getMetaState();
        android.view.KeyCharacterMap.KeyData keydata = new android.view.KeyCharacterMap.KeyData();
        if (keyevent.getKeyData(keydata) || i1 == 67)
        {
            int l1 = j.size();
            int j1 = 0;
            while (j1 < l1) 
            {
                MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(j1);
                if (menuitemimpl.hasSubMenu())
                {
                    ((MenuBuilder)menuitemimpl.getSubMenu()).a(list, i1, keyevent);
                }
                char c1;
                if (flag)
                {
                    c1 = menuitemimpl.getAlphabeticShortcut();
                } else
                {
                    c1 = menuitemimpl.getNumericShortcut();
                }
                if ((k1 & 5) == 0 && c1 != 0 && (c1 == keydata.meta[0] || c1 == keydata.meta[2] || flag && c1 == '\b' && i1 == 67) && menuitemimpl.isEnabled())
                {
                    list.add(menuitemimpl);
                }
                j1++;
            }
        }
    }

    public final MenuBuilder a()
    {
        p = 1;
        return this;
    }

    protected final MenuBuilder a(Drawable drawable)
    {
        a(((CharSequence) (null)), drawable, ((View) (null)));
        return this;
    }

    protected final MenuBuilder a(View view)
    {
        a(((CharSequence) (null)), ((Drawable) (null)), view);
        return this;
    }

    protected final MenuBuilder a(CharSequence charsequence)
    {
        a(charsequence, ((Drawable) (null)), ((View) (null)));
        return this;
    }

    public final void a(Bundle bundle)
    {
        if (!w.isEmpty())
        {
            SparseArray sparsearray = new SparseArray();
            Iterator iterator = w.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if (menupresenter == null)
                {
                    w.remove(weakreference);
                } else
                {
                    int i1 = menupresenter.getId();
                    if (i1 > 0)
                    {
                        Parcelable parcelable = menupresenter.onSaveInstanceState();
                        if (parcelable != null)
                        {
                            sparsearray.put(i1, parcelable);
                        }
                    }
                }
            } while (true);
            bundle.putSparseParcelableArray("android:menu:presenters", sparsearray);
        }
    }

    public void a(Callback callback)
    {
        i = callback;
    }

    public final void a(MenuPresenter menupresenter)
    {
        a(menupresenter, e);
    }

    public final void a(MenuPresenter menupresenter, Context context)
    {
        w.add(new WeakReference(menupresenter));
        menupresenter.initForMenu(context, this);
        o = true;
    }

    final void a(MenuItem menuitem)
    {
        int j1 = menuitem.getGroupId();
        int k1 = j.size();
        int i1 = 0;
        while (i1 < k1) 
        {
            MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(i1);
            if (menuitemimpl.getGroupId() == j1 && menuitemimpl.f() && menuitemimpl.isCheckable())
            {
                boolean flag;
                if (menuitemimpl == menuitem)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                menuitemimpl.b(flag);
            }
            i1++;
        }
    }

    public final void a(boolean flag)
    {
        if (u)
        {
            return;
        }
        u = true;
        for (Iterator iterator = w.iterator(); iterator.hasNext();)
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
            if (menupresenter == null)
            {
                w.remove(weakreference);
            } else
            {
                menupresenter.onCloseMenu(this, flag);
            }
        }

        u = false;
    }

    boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        return i != null && i.onMenuItemSelected(menubuilder, menuitem);
    }

    public boolean a(MenuItemImpl menuitemimpl)
    {
        boolean flag1 = false;
        if (!w.isEmpty())
        {
            g();
            Iterator iterator = w.iterator();
            boolean flag = false;
label0:
            do
            {
                MenuPresenter menupresenter;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    WeakReference weakreference = (WeakReference)iterator.next();
                    menupresenter = (MenuPresenter)weakreference.get();
                    if (menupresenter != null)
                    {
                        break;
                    }
                    w.remove(weakreference);
                } while (true);
                flag = menupresenter.expandItemActionView(this, menuitemimpl);
            } while (!flag);
            h();
            flag1 = flag;
            if (flag)
            {
                x = menuitemimpl;
                return flag;
            }
        }
        return flag1;
    }

    public final boolean a(MenuItem menuitem, MenuPresenter menupresenter, int i1)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        menuitem = (MenuItemImpl)menuitem;
        if (menuitem != null && menuitem.isEnabled()) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L4:
        return flag1;
_L2:
        ActionProvider actionprovider;
        boolean flag;
        boolean flag3;
        flag3 = menuitem.a();
        actionprovider = menuitem.getSupportActionProvider();
        if (actionprovider != null && actionprovider.hasSubMenu())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!menuitem.l())
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = menuitem.expandActionView() | flag3;
        flag1 = flag2;
        if (flag2)
        {
            a(true);
            return flag2;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (menuitem.hasSubMenu() || flag)
        {
            a(false);
            if (!menuitem.hasSubMenu())
            {
                menuitem.a(new SubMenuBuilder(e, this, menuitem));
            }
            menuitem = (SubMenuBuilder)menuitem.getSubMenu();
            if (flag)
            {
                actionprovider.onPrepareSubMenu(menuitem);
            }
            if (!w.isEmpty())
            {
                flag1 = flag2;
                if (menupresenter != null)
                {
                    flag1 = menupresenter.onSubMenuSelected(menuitem);
                }
                menupresenter = w.iterator();
                while (menupresenter.hasNext()) 
                {
                    WeakReference weakreference = (WeakReference)menupresenter.next();
                    MenuPresenter menupresenter1 = (MenuPresenter)weakreference.get();
                    if (menupresenter1 == null)
                    {
                        w.remove(weakreference);
                    } else
                    if (!flag1)
                    {
                        flag1 = menupresenter1.onSubMenuSelected(menuitem);
                    }
                }
            }
            flag2 = flag3 | flag1;
            flag1 = flag2;
            if (!flag2)
            {
                a(true);
                return flag2;
            }
        } else
        {
            if ((i1 & 1) == 0)
            {
                a(true);
            }
            return flag3;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public MenuItem add(int i1)
    {
        return a(0, 0, 0, f.getString(i1));
    }

    public MenuItem add(int i1, int j1, int k1, int l1)
    {
        return a(i1, j1, k1, f.getString(l1));
    }

    public MenuItem add(int i1, int j1, int k1, CharSequence charsequence)
    {
        return a(i1, j1, k1, charsequence);
    }

    public MenuItem add(CharSequence charsequence)
    {
        return a(0, 0, 0, charsequence);
    }

    public int addIntentOptions(int i1, int j1, int k1, ComponentName componentname, Intent aintent[], Intent intent, int l1, 
            MenuItem amenuitem[])
    {
        PackageManager packagemanager = e.getPackageManager();
        List list = packagemanager.queryIntentActivityOptions(componentname, aintent, intent, 0);
        int i2;
        if (list != null)
        {
            i2 = list.size();
        } else
        {
            i2 = 0;
        }
        if ((l1 & 1) == 0)
        {
            removeGroup(i1);
        }
        l1 = 0;
        while (l1 < i2) 
        {
            ResolveInfo resolveinfo = (ResolveInfo)list.get(l1);
            if (resolveinfo.specificIndex < 0)
            {
                componentname = intent;
            } else
            {
                componentname = aintent[resolveinfo.specificIndex];
            }
            componentname = new Intent(componentname);
            componentname.setComponent(new ComponentName(resolveinfo.activityInfo.applicationInfo.packageName, resolveinfo.activityInfo.name));
            componentname = add(i1, j1, k1, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setIntent(componentname);
            if (amenuitem != null && resolveinfo.specificIndex >= 0)
            {
                amenuitem[resolveinfo.specificIndex] = componentname;
            }
            l1++;
        }
        return i2;
    }

    public SubMenu addSubMenu(int i1)
    {
        return addSubMenu(0, 0, 0, ((CharSequence) (f.getString(i1))));
    }

    public SubMenu addSubMenu(int i1, int j1, int k1, int l1)
    {
        return addSubMenu(i1, j1, k1, ((CharSequence) (f.getString(l1))));
    }

    public SubMenu addSubMenu(int i1, int j1, int k1, CharSequence charsequence)
    {
        charsequence = (MenuItemImpl)a(i1, j1, k1, charsequence);
        SubMenuBuilder submenubuilder = new SubMenuBuilder(e, this, charsequence);
        charsequence.a(submenubuilder);
        return submenubuilder;
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return addSubMenu(0, 0, 0, charsequence);
    }

    protected String b()
    {
        return "android:menu:actionviewstates";
    }

    public final void b(Bundle bundle)
    {
        bundle = bundle.getSparseParcelableArray("android:menu:presenters");
        if (bundle != null && !w.isEmpty())
        {
            Iterator iterator = w.iterator();
            while (iterator.hasNext()) 
            {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if (menupresenter == null)
                {
                    w.remove(weakreference);
                } else
                {
                    int i1 = menupresenter.getId();
                    if (i1 > 0)
                    {
                        Parcelable parcelable = (Parcelable)bundle.get(i1);
                        if (parcelable != null)
                        {
                            menupresenter.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public final void b(MenuPresenter menupresenter)
    {
        Iterator iterator = w.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            MenuPresenter menupresenter1 = (MenuPresenter)weakreference.get();
            if (menupresenter1 == null || menupresenter1 == menupresenter)
            {
                w.remove(weakreference);
            }
        } while (true);
    }

    public final void b(boolean flag)
    {
        if (!r)
        {
            if (flag)
            {
                l = true;
                o = true;
            }
            if (!w.isEmpty())
            {
                g();
                for (Iterator iterator = w.iterator(); iterator.hasNext();)
                {
                    WeakReference weakreference = (WeakReference)iterator.next();
                    MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                    if (menupresenter == null)
                    {
                        w.remove(weakreference);
                    } else
                    {
                        menupresenter.updateMenuView(flag);
                    }
                }

                h();
            }
            return;
        } else
        {
            s = true;
            return;
        }
    }

    public boolean b(MenuItemImpl menuitemimpl)
    {
        boolean flag = false;
        boolean flag2 = flag;
        if (!w.isEmpty())
        {
            if (x != menuitemimpl)
            {
                flag2 = flag;
            } else
            {
                g();
                Iterator iterator = w.iterator();
                boolean flag1 = false;
label0:
                do
                {
                    MenuPresenter menupresenter;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        WeakReference weakreference = (WeakReference)iterator.next();
                        menupresenter = (MenuPresenter)weakreference.get();
                        if (menupresenter != null)
                        {
                            break;
                        }
                        w.remove(weakreference);
                    } while (true);
                    flag1 = menupresenter.collapseItemActionView(this, menuitemimpl);
                } while (!flag1);
                h();
                flag2 = flag1;
                if (flag1)
                {
                    x = null;
                    return flag1;
                }
            }
        }
        return flag2;
    }

    public final boolean b(MenuItem menuitem)
    {
        return a(menuitem, ((MenuPresenter) (null)), 0);
    }

    public final void c(Bundle bundle)
    {
        int j1 = size();
        int i1 = 0;
        SparseArray sparsearray;
        SparseArray sparsearray2;
        for (sparsearray = null; i1 < j1; sparsearray = sparsearray2)
        {
            MenuItem menuitem = getItem(i1);
            View view = MenuItemCompat.getActionView(menuitem);
            sparsearray2 = sparsearray;
            if (view != null)
            {
                sparsearray2 = sparsearray;
                if (view.getId() != -1)
                {
                    SparseArray sparsearray1 = sparsearray;
                    if (sparsearray == null)
                    {
                        sparsearray1 = new SparseArray();
                    }
                    view.saveHierarchyState(sparsearray1);
                    sparsearray2 = sparsearray1;
                    if (MenuItemCompat.isActionViewExpanded(menuitem))
                    {
                        bundle.putInt("android:menu:expandedactionview", menuitem.getItemId());
                        sparsearray2 = sparsearray1;
                    }
                }
            }
            if (menuitem.hasSubMenu())
            {
                ((SubMenuBuilder)menuitem.getSubMenu()).c(bundle);
            }
            i1++;
        }

        if (sparsearray != null)
        {
            bundle.putSparseParcelableArray(b(), sparsearray);
        }
    }

    boolean c()
    {
        return g;
    }

    public void clear()
    {
        if (x != null)
        {
            b(x);
        }
        j.clear();
        b(true);
    }

    public void clearHeader()
    {
        b = null;
        a = null;
        c = null;
        b(false);
    }

    public void close()
    {
        a(true);
    }

    public final void d(Bundle bundle)
    {
        if (bundle != null)
        {
            SparseArray sparsearray = bundle.getSparseParcelableArray(b());
            int k1 = size();
            for (int i1 = 0; i1 < k1; i1++)
            {
                MenuItem menuitem = getItem(i1);
                View view = MenuItemCompat.getActionView(menuitem);
                if (view != null && view.getId() != -1)
                {
                    view.restoreHierarchyState(sparsearray);
                }
                if (menuitem.hasSubMenu())
                {
                    ((SubMenuBuilder)menuitem.getSubMenu()).d(bundle);
                }
            }

            int j1 = bundle.getInt("android:menu:expandedactionview");
            if (j1 > 0)
            {
                bundle = findItem(j1);
                if (bundle != null)
                {
                    MenuItemCompat.expandActionView(bundle);
                    return;
                }
            }
        }
    }

    public boolean d()
    {
        return h;
    }

    public final Context e()
    {
        return e;
    }

    public final void f()
    {
        if (i != null)
        {
            i.onMenuModeChange(this);
        }
    }

    public MenuItem findItem(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L6:
        if (j1 >= k1) goto _L2; else goto _L1
_L1:
        Object obj = (MenuItemImpl)j.get(j1);
        if (((MenuItemImpl) (obj)).getItemId() != i1) goto _L4; else goto _L3
_L3:
        return ((MenuItem) (obj));
_L4:
        MenuItem menuitem;
        if (!((MenuItemImpl) (obj)).hasSubMenu())
        {
            continue; /* Loop/switch isn't completed */
        }
        menuitem = ((MenuItemImpl) (obj)).getSubMenu().findItem(i1);
        obj = menuitem;
        if (menuitem != null) goto _L3; else goto _L5
_L5:
        j1++;
          goto _L6
_L2:
        return null;
    }

    public final void g()
    {
        if (!r)
        {
            r = true;
            s = false;
        }
    }

    public MenuItem getItem(int i1)
    {
        return (MenuItem)j.get(i1);
    }

    public final void h()
    {
        r = false;
        if (s)
        {
            s = false;
            b(true);
        }
    }

    public boolean hasVisibleItems()
    {
        int j1 = size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((MenuItemImpl)j.get(i1)).isVisible())
            {
                return true;
            }
        }

        return false;
    }

    final void i()
    {
        l = true;
        b(true);
    }

    public boolean isShortcutKey(int i1, KeyEvent keyevent)
    {
        return a(i1, keyevent) != null;
    }

    final void j()
    {
        o = true;
        b(true);
    }

    public final ArrayList k()
    {
        if (!l)
        {
            return k;
        }
        k.clear();
        int j1 = j.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(i1);
            if (menuitemimpl.isVisible())
            {
                k.add(menuitemimpl);
            }
        }

        l = false;
        o = true;
        return k;
    }

    public final void l()
    {
        ArrayList arraylist = k();
        if (!o)
        {
            return;
        }
        Iterator iterator = w.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
            if (menupresenter == null)
            {
                w.remove(weakreference);
            } else
            {
                flag = menupresenter.flagActionItems() | flag;
            }
        }
        if (flag)
        {
            m.clear();
            n.clear();
            int j1 = arraylist.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(i1);
                if (menuitemimpl.h())
                {
                    m.add(menuitemimpl);
                } else
                {
                    n.add(menuitemimpl);
                }
                i1++;
            }
        } else
        {
            m.clear();
            n.clear();
            n.addAll(k());
        }
        o = false;
    }

    public final ArrayList m()
    {
        l();
        return m;
    }

    public final ArrayList n()
    {
        l();
        return n;
    }

    public MenuBuilder o()
    {
        return this;
    }

    final boolean p()
    {
        return t;
    }

    public boolean performIdentifierAction(int i1, int j1)
    {
        return a(findItem(i1), ((MenuPresenter) (null)), j1);
    }

    public boolean performShortcut(int i1, KeyEvent keyevent, int j1)
    {
        keyevent = a(i1, keyevent);
        boolean flag = false;
        if (keyevent != null)
        {
            flag = a(keyevent, ((MenuPresenter) (null)), j1);
        }
        if ((j1 & 2) != 0)
        {
            a(true);
        }
        return flag;
    }

    public final MenuItemImpl q()
    {
        return x;
    }

    public void removeGroup(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L7:
        if (j1 >= k1) goto _L2; else goto _L1
_L1:
        if (((MenuItemImpl)j.get(j1)).getGroupId() != i1) goto _L4; else goto _L3
_L3:
        if (j1 < 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        int i2 = j.size();
        for (int l1 = 0; l1 < i2 - j1 && ((MenuItemImpl)j.get(j1)).getGroupId() == i1; l1++)
        {
            a(j1, false);
        }

        break; /* Loop/switch isn't completed */
_L4:
        j1++;
        continue; /* Loop/switch isn't completed */
_L2:
        j1 = -1;
        if (true) goto _L3; else goto _L5
_L5:
        b(true);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void removeItem(int i1)
    {
        int j1;
        int k1;
        k1 = size();
        j1 = 0;
_L3:
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (((MenuItemImpl)j.get(j1)).getItemId() != i1) goto _L2; else goto _L1
_L1:
        a(j1, true);
        return;
_L2:
        j1++;
          goto _L3
        j1 = -1;
          goto _L1
    }

    public void setGroupCheckable(int i1, boolean flag, boolean flag1)
    {
        int k1 = j.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(j1);
            if (menuitemimpl.getGroupId() == i1)
            {
                menuitemimpl.a(flag1);
                menuitemimpl.setCheckable(flag);
            }
        }

    }

    public void setGroupEnabled(int i1, boolean flag)
    {
        int k1 = j.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(j1);
            if (menuitemimpl.getGroupId() == i1)
            {
                menuitemimpl.setEnabled(flag);
            }
        }

    }

    public void setGroupVisible(int i1, boolean flag)
    {
        int k1 = j.size();
        int j1 = 0;
        boolean flag1 = false;
        for (; j1 < k1; j1++)
        {
            MenuItemImpl menuitemimpl = (MenuItemImpl)j.get(j1);
            if (menuitemimpl.getGroupId() == i1 && menuitemimpl.c(flag))
            {
                flag1 = true;
            }
        }

        if (flag1)
        {
            b(true);
        }
    }

    public void setQwertyMode(boolean flag)
    {
        g = flag;
        b(false);
    }

    public int size()
    {
        return j.size();
    }


    private class Callback
    {

        public abstract boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem);

        public abstract void onMenuModeChange(MenuBuilder menubuilder);
    }

}
