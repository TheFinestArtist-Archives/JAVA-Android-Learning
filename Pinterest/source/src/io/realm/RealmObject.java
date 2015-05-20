// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import io.realm.internal.Row;
import io.realm.internal.Table;

// Referenced classes of package io.realm:
//            Realm

public abstract class RealmObject
{

    protected Realm realm;
    protected Row row;

    public RealmObject()
    {
    }

    public boolean isValid()
    {
        return row != null && row.isAttached();
    }

    public void removeFromRealm()
    {
        if (row == null)
        {
            throw new IllegalStateException("Object malformed: missing object in Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
        }
        if (realm == null)
        {
            throw new IllegalStateException("Object malformed: missing Realm. Make sure to instantiate RealmObjects with Realm.createObject()");
        } else
        {
            row.getTable().moveLastOver(row.getIndex());
            return;
        }
    }
}
