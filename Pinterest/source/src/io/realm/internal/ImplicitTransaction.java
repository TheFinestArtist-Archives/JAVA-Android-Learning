// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            Group, SharedGroup, Context

public class ImplicitTransaction extends Group
{

    private final SharedGroup parent;

    public ImplicitTransaction(Context context, SharedGroup sharedgroup, long l)
    {
        super(context, l, true);
        parent = sharedgroup;
    }

    private void assertNotClosed()
    {
        if (isClosed() || parent.isClosed())
        {
            throw new IllegalStateException("Cannot use ImplicitTransaction after it or its parent has been closed.");
        } else
        {
            return;
        }
    }

    public void advanceRead()
    {
        assertNotClosed();
        parent.advanceRead();
    }

    public void commitAndContinueAsRead()
    {
        assertNotClosed();
        parent.commitAndContinueAsRead();
        immutable = true;
    }

    public void endRead()
    {
        assertNotClosed();
        parent.endRead();
    }

    protected void finalize()
    {
    }

    public void promoteToWrite()
    {
        assertNotClosed();
        if (immutable)
        {
            immutable = false;
            parent.promoteToWrite();
            return;
        } else
        {
            throw new IllegalStateException("Nested transactions are not allowed. Use commitTransaction() after each beginTransaction().");
        }
    }

    public void rollbackAndContinueAsRead()
    {
        assertNotClosed();
        if (!immutable)
        {
            parent.rollbackAndContinueAsRead();
            immutable = true;
            return;
        } else
        {
            throw new IllegalStateException("Cannot cancel a non-write transaction.");
        }
    }
}
