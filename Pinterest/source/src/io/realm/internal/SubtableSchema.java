// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            TableSchema, ColumnType

public class SubtableSchema
    implements TableSchema
{

    private long parentNativePtr;
    private long path[];

    SubtableSchema(long l, long al[])
    {
        parentNativePtr = l;
        path = al;
    }

    private void verifyColumnName(String s)
    {
        if (s.length() > 63)
        {
            throw new IllegalArgumentException("Column names are currently limited to max 63 characters.");
        } else
        {
            return;
        }
    }

    public long addColumn(ColumnType columntype, String s)
    {
        verifyColumnName(s);
        return nativeAddColumn(parentNativePtr, path, columntype.getValue(), s);
    }

    public SubtableSchema getSubtableSchema(long l)
    {
        long al[] = new long[path.length + 1];
        for (int i = 0; i < path.length; i++)
        {
            al[i] = path[i];
        }

        al[path.length] = l;
        return new SubtableSchema(parentNativePtr, al);
    }

    public volatile TableSchema getSubtableSchema(long l)
    {
        return getSubtableSchema(l);
    }

    protected native long nativeAddColumn(long l, long al[], int i, String s);

    protected native void nativeRemoveColumn(long l, long al[], long l1);

    protected native void nativeRenameColumn(long l, long al[], long l1, String s);

    public void removeColumn(long l)
    {
        nativeRemoveColumn(parentNativePtr, path, l);
    }

    public void renameColumn(long l, String s)
    {
        verifyColumnName(s);
        nativeRenameColumn(parentNativePtr, path, l, s);
    }
}
