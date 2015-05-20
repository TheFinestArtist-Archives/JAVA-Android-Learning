// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.Date;

// Referenced classes of package io.realm.internal:
//            TableView, ColumnType, Mixed, Table, 
//            TableQuery

public interface TableOrView
{

    public static final int NO_MATCH = -1;

    public abstract void adjust(long l, long l1);

    public abstract double averageDouble(long l);

    public abstract double averageFloat(long l);

    public abstract double averageLong(long l);

    public abstract void clear();

    public abstract void clearSubtable(long l, long l1);

    public abstract void close();

    public abstract long count(long l, String s);

    public abstract TableView findAllBoolean(long l, boolean flag);

    public abstract TableView findAllDate(long l, Date date);

    public abstract TableView findAllDouble(long l, double d);

    public abstract TableView findAllFloat(long l, float f);

    public abstract TableView findAllLong(long l, long l1);

    public abstract TableView findAllString(long l, String s);

    public abstract long findFirstBoolean(long l, boolean flag);

    public abstract long findFirstDate(long l, Date date);

    public abstract long findFirstDouble(long l, double d);

    public abstract long findFirstFloat(long l, float f);

    public abstract long findFirstLong(long l, long l1);

    public abstract long findFirstString(long l, String s);

    public abstract byte[] getBinaryByteArray(long l, long l1);

    public abstract boolean getBoolean(long l, long l1);

    public abstract long getColumnCount();

    public abstract long getColumnIndex(String s);

    public abstract String getColumnName(long l);

    public abstract ColumnType getColumnType(long l);

    public abstract Date getDate(long l, long l1);

    public abstract double getDouble(long l, long l1);

    public abstract float getFloat(long l, long l1);

    public abstract long getLink(long l, long l1);

    public abstract long getLong(long l, long l1);

    public abstract Mixed getMixed(long l, long l1);

    public abstract ColumnType getMixedType(long l, long l1);

    public abstract String getString(long l, long l1);

    public abstract Table getSubtable(long l, long l1);

    public abstract long getSubtableSize(long l, long l1);

    public abstract Table getTable();

    public abstract boolean isEmpty();

    public abstract boolean isNullLink(long l, long l1);

    public abstract long lowerBoundLong(long l, long l1);

    public abstract Date maximumDate(long l);

    public abstract double maximumDouble(long l);

    public abstract float maximumFloat(long l);

    public abstract long maximumLong(long l);

    public abstract Date minimumDate(long l);

    public abstract double minimumDouble(long l);

    public abstract float minimumFloat(long l);

    public abstract long minimumLong(long l);

    public abstract void nullifyLink(long l, long l1);

    public abstract Table pivot(long l, long l1, PivotType pivottype);

    public abstract void remove(long l);

    public abstract void removeLast();

    public abstract String rowToString(long l);

    public abstract void setBinaryByteArray(long l, long l1, byte abyte0[]);

    public abstract void setBoolean(long l, long l1, boolean flag);

    public abstract void setDate(long l, long l1, Date date);

    public abstract void setDouble(long l, long l1, double d);

    public abstract void setFloat(long l, long l1, float f);

    public abstract void setLink(long l, long l1, long l2);

    public abstract void setLong(long l, long l1, long l2);

    public abstract void setMixed(long l, long l1, Mixed mixed);

    public abstract void setString(long l, long l1, String s);

    public abstract long size();

    public abstract double sumDouble(long l);

    public abstract double sumFloat(long l);

    public abstract long sumLong(long l);

    public abstract long sync();

    public abstract String toJson();

    public abstract String toString();

    public abstract String toString(long l);

    public abstract long upperBoundLong(long l, long l1);

    public abstract TableQuery where();
}
