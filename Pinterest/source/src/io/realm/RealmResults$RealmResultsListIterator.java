// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.exceptions.RealmException;
import java.util.ListIterator;

// Referenced classes of package io.realm:
//            RealmResults, RealmObject

class pos extends pos
    implements ListIterator
{

    final RealmResults this$0;

    public void add(RealmObject realmobject)
    {
        throw new RealmException("Adding elements not supported. Use Realm.createObject() instead.");
    }

    public volatile void add(Object obj)
    {
        add((RealmObject)obj);
    }

    public boolean hasPrevious()
    {
        RealmResults.access$200(RealmResults.this);
        return pos > 0;
    }

    public int nextIndex()
    {
        RealmResults.access$200(RealmResults.this);
        return pos + 1;
    }

    public RealmObject previous()
    {
        RealmResults.access$200(RealmResults.this);
        pos = pos - 1;
        if (pos < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Cannot access index less than zero. This was ")).append(pos).append(". Remember to check hasPrevious() before using previous().").toString());
        } else
        {
            return get(pos);
        }
    }

    public volatile Object previous()
    {
        return previous();
    }

    public int previousIndex()
    {
        RealmResults.access$200(RealmResults.this);
        return pos;
    }

    public void remove()
    {
        throw new RealmException("Removing elements not supported.");
    }

    public void set(RealmObject realmobject)
    {
        throw new RealmException("Replacing elements not supported.");
    }

    public volatile void set(Object obj)
    {
        set((RealmObject)obj);
    }

    (int i)
    {
        this$0 = RealmResults.this;
        super(RealmResults.this);
        if (i >= 0 && i <= size())
        {
            pos = i - 1;
            return;
        } else
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Starting location must be a valid index: [0, ")).append(size() - 1).append("]. Yours was ").append(i).toString());
        }
    }
}
