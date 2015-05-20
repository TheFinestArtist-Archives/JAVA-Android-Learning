// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            Group, SharedGroup, Context

public class WriteTransaction extends Group
{

    private boolean committed;
    private final SharedGroup db;

    WriteTransaction(Context context, SharedGroup sharedgroup, long l)
    {
        super(context, l, false);
        db = sharedgroup;
        committed = false;
    }

    public void close()
    {
        if (!committed)
        {
            rollback();
        }
    }

    public void commit()
    {
        if (!committed)
        {
            db.commit();
            committed = true;
            return;
        } else
        {
            throw new IllegalStateException("You can only commit once after a WriteTransaction has been made.");
        }
    }

    protected void finalize()
    {
    }

    public void rollback()
    {
        db.rollback();
    }
}
