// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


// Referenced classes of package io.realm.internal:
//            ColumnType

public interface TableSchema
{

    public abstract long addColumn(ColumnType columntype, String s);

    public abstract TableSchema getSubtableSchema(long l);

    public abstract void removeColumn(long l);

    public abstract void renameColumn(long l, String s);
}
