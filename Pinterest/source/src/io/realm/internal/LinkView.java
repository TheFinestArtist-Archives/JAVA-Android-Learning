// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            Row, Table, Context, TableQuery

public class LinkView
{

    private final long columnIndexInParent;
    private final Context context;
    private final long nativeLinkViewPtr;
    private final Table parent;

    public LinkView(Context context1, Table table, long l, long l1)
    {
        context = context1;
        parent = table;
        columnIndexInParent = l;
        nativeLinkViewPtr = l1;
    }

    private native void nativeAdd(long l, long l1);

    private native void nativeClear(long l);

    protected static native void nativeClose(long l);

    private native long nativeGetRow(long l, long l1);

    private native long nativeGetTargetRowIndex(long l, long l1);

    private native void nativeInsert(long l, long l1, long l2);

    private native boolean nativeIsEmpty(long l);

    private native void nativeMove(long l, long l1, long l2);

    private native void nativeRemove(long l, long l1);

    private native void nativeSet(long l, long l1, long l2);

    private native long nativeSize(long l);

    public void add(long l)
    {
        nativeAdd(nativeLinkViewPtr, l);
    }

    public void clear()
    {
        nativeClear(nativeLinkViewPtr);
    }

    public Row get(long l)
    {
        l = nativeGetRow(nativeLinkViewPtr, l);
        return new Row(context, parent.getLinkTarget(columnIndexInParent), l);
    }

    public long getTargetRowIndex(long l)
    {
        return nativeGetTargetRowIndex(nativeLinkViewPtr, l);
    }

    public void insert(long l, long l1)
    {
        nativeInsert(nativeLinkViewPtr, l, l1);
    }

    public boolean isEmpty()
    {
        return nativeIsEmpty(nativeLinkViewPtr);
    }

    public void move(long l, long l1)
    {
        nativeMove(nativeLinkViewPtr, l, l1);
    }

    protected native long nativeWhere(long l);

    public void remove(long l)
    {
        nativeRemove(nativeLinkViewPtr, l);
    }

    public void set(long l, long l1)
    {
        nativeSet(nativeLinkViewPtr, l, l1);
    }

    public long size()
    {
        return nativeSize(nativeLinkViewPtr);
    }

    public TableQuery where()
    {
        context.executeDelayedDisposal();
        long l = nativeWhere(nativeLinkViewPtr);
        TableQuery tablequery;
        try
        {
            tablequery = new TableQuery(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableQuery.nativeClose(l);
            throw runtimeexception;
        }
        return tablequery;
    }
}
