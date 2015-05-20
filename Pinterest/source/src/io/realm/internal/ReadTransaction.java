// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            Group, SharedGroup, Context

public class ReadTransaction extends Group
{

    private final SharedGroup db;

    ReadTransaction(Context context, SharedGroup sharedgroup, long l)
    {
        super(context, l, true);
        db = sharedgroup;
    }

    public void close()
    {
        db.endRead();
    }

    public void endRead()
    {
        db.endRead();
    }

    protected void finalize()
    {
    }
}
