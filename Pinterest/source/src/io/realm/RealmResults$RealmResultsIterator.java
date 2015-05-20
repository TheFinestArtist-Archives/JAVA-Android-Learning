// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.TableOrView;
import java.util.Iterator;

// Referenced classes of package io.realm:
//            RealmResults, RealmObject

class removeUsed
    implements Iterator
{

    int pos;
    boolean removeUsed;
    final RealmResults this$0;

    public boolean hasNext()
    {
        RealmResults.access$200(RealmResults.this);
        return pos + 1 < size();
    }

    public RealmObject next()
    {
        RealmResults.access$200(RealmResults.this);
        pos = pos + 1;
        removeUsed = false;
        if (pos >= size())
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Cannot access index ")).append(pos).append(" when size is ").append(size()).append(". Remember to check hasNext() before using next().").toString());
        } else
        {
            return get(pos);
        }
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new RealmException("Removing is not supported.");
    }

    ()
    {
        this$0 = RealmResults.this;
        super();
        pos = -1;
        removeUsed = false;
        RealmResults.access$002(RealmResults.this, RealmResults.access$100(RealmResults.this).sync());
    }
}
