// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.LinkView;
import io.realm.internal.Row;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package io.realm:
//            RealmObject, Realm, RealmQuery

public class RealmList extends AbstractList
{

    public static final String MANAGED_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmObjects already managed by Realm cannot be added to RealmList in non-managed mode.";
    private static final String NULL_OBJECTS_NOT_ALLOWED_MESSAGE = "RealmList does not accept null values";
    private static final String ONLY_IN_MANAGED_MODE_MESSAGE = "This method is only available in managed mode";
    private Class clazz;
    private final boolean managedMode;
    private List nonManagedList;
    private Realm realm;
    private LinkView view;

    public RealmList()
    {
        managedMode = false;
        nonManagedList = new ArrayList();
    }

    RealmList(Class class1, LinkView linkview, Realm realm1)
    {
        managedMode = true;
        clazz = class1;
        view = linkview;
        realm = realm1;
    }

    public transient RealmList(RealmObject arealmobject[])
    {
        boolean flag = false;
        super();
        managedMode = false;
        int i;
        if (arealmobject != null)
        {
            i = arealmobject.length;
        } else
        {
            i = 0;
        }
        nonManagedList = new ArrayList(i);
        for (i = ((flag) ? 1 : 0); i < arealmobject.length; i++)
        {
            nonManagedList.add(arealmobject[i]);
        }

    }

    private void checkIndex(int i)
    {
        int j = size();
        if (i < 0 || i >= j)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Invalid index ")).append(i).append(", size is ").append(j).toString());
        } else
        {
            return;
        }
    }

    private void checkValidObject(RealmObject realmobject)
    {
        if (realmobject == null)
        {
            throw new IllegalArgumentException("RealmList does not accept null values");
        } else
        {
            return;
        }
    }

    public void add(int i, RealmObject realmobject)
    {
        checkValidObject(realmobject);
        if (managedMode)
        {
            view.insert(i, realmobject.row.getIndex());
            return;
        } else
        {
            nonManagedList.add(i, realmobject);
            return;
        }
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (RealmObject)obj);
    }

    public boolean add(RealmObject realmobject)
    {
        checkValidObject(realmobject);
        if (managedMode)
        {
            view.add(realmobject.row.getIndex());
        } else
        {
            nonManagedList.add(realmobject);
        }
        return true;
    }

    public volatile boolean add(Object obj)
    {
        return add((RealmObject)obj);
    }

    public void clear()
    {
        if (managedMode)
        {
            view.clear();
            return;
        } else
        {
            nonManagedList.clear();
            return;
        }
    }

    public RealmObject first()
    {
        if (managedMode && !view.isEmpty())
        {
            return get(0);
        }
        if (nonManagedList != null && nonManagedList.size() > 0)
        {
            return (RealmObject)nonManagedList.get(0);
        } else
        {
            return null;
        }
    }

    public RealmObject get(int i)
    {
        if (managedMode)
        {
            return realm.get(clazz, view.getTargetRowIndex(i));
        } else
        {
            return (RealmObject)nonManagedList.get(i);
        }
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public RealmObject last()
    {
        if (managedMode && !view.isEmpty())
        {
            return get((int)view.size() - 1);
        }
        if (nonManagedList != null && nonManagedList.size() > 0)
        {
            return (RealmObject)nonManagedList.get(nonManagedList.size() - 1);
        } else
        {
            return null;
        }
    }

    public void move(int i, int j)
    {
        if (managedMode)
        {
            view.move(i, j);
            return;
        }
        checkIndex(i);
        checkIndex(j);
        RealmObject realmobject = (RealmObject)nonManagedList.remove(i);
        if (j > i)
        {
            nonManagedList.add(j - 1, realmobject);
            return;
        } else
        {
            nonManagedList.add(j, realmobject);
            return;
        }
    }

    public RealmObject remove(int i)
    {
        if (managedMode)
        {
            RealmObject realmobject = get(i);
            view.remove(i);
            return realmobject;
        } else
        {
            return (RealmObject)nonManagedList.remove(i);
        }
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public RealmObject set(int i, RealmObject realmobject)
    {
        checkValidObject(realmobject);
        if (managedMode)
        {
            if (realmobject.row == null)
            {
                throw new RealmException("This method is only available in managed mode");
            } else
            {
                view.set(i, realmobject.row.getIndex());
                return realmobject;
            }
        } else
        {
            nonManagedList.set(i, realmobject);
            return realmobject;
        }
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (RealmObject)obj);
    }

    public int size()
    {
        if (managedMode)
        {
            return Long.valueOf(view.size()).intValue();
        } else
        {
            return nonManagedList.size();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        int i;
        if (managedMode)
        {
            s = clazz.getSimpleName();
        } else
        {
            s = getClass().getSimpleName();
        }
        stringbuilder.append(s);
        stringbuilder.append("@[");
        i = 0;
        while (i < size()) 
        {
            if (managedMode)
            {
                stringbuilder.append(get(i).row.getIndex());
            } else
            {
                stringbuilder.append(System.identityHashCode(get(i)));
            }
            if (i < size() - 1)
            {
                stringbuilder.append(',');
            }
            i++;
        }
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public RealmQuery where()
    {
        if (managedMode)
        {
            return new RealmQuery(realm, view, clazz);
        } else
        {
            throw new RealmException("This method is only available in managed mode");
        }
    }
}
