// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.Closeable;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

// Referenced classes of package io.realm.internal:
//            TableOrView, Table, Context, ColumnType, 
//            TableQuery, Mixed

public class TableView
    implements TableOrView, Closeable
{

    protected boolean DEBUG;
    private final Context context;
    protected long nativePtr;
    protected final Table parent;

    protected TableView(Context context1, Table table, long l)
    {
        DEBUG = false;
        context = context1;
        parent = table;
        nativePtr = l;
    }

    protected static native void nativeClose(long l);

    private void throwImmutable()
    {
        throw new IllegalStateException("Mutable method call during read transaction.");
    }

    public void adjust(long l, long l1)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeAddInt(nativePtr, l, l1);
    }

    public double averageDouble(long l)
    {
        return nativeAverageDouble(nativePtr, l);
    }

    public double averageFloat(long l)
    {
        return nativeAverageFloat(nativePtr, l);
    }

    public double averageLong(long l)
    {
        return nativeAverageInt(nativePtr, l);
    }

    public void clear()
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeClear(nativePtr);
    }

    public void clearSubtable(long l, long l1)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeClearSubtable(nativePtr, l, l1);
    }

    public void close()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                nativeClose(nativePtr);
                if (DEBUG)
                {
                    System.err.println((new StringBuilder("==== TableView CLOSE, ptr= ")).append(nativePtr).toString());
                }
                nativePtr = 0L;
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long count(long l, String s)
    {
        throw new RuntimeException("Not implemented yet.");
    }

    protected native long createNativeTableView(Table table, long l);

    protected void finalize()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                context.asyncDisposeTableView(nativePtr);
                nativePtr = 0L;
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TableView findAllBoolean(long l, boolean flag)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllBool(nativePtr, l, flag);
        TableView tableview;
        try
        {
            tableview = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return tableview;
    }

    public TableView findAllDate(long l, Date date)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllDate(nativePtr, l, date.getTime() / 1000L);
        try
        {
            date = new TableView(context, parent, l);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            nativeClose(l);
            throw date;
        }
        return date;
    }

    public TableView findAllDouble(long l, double d)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllDouble(nativePtr, l, d);
        TableView tableview;
        try
        {
            tableview = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return tableview;
    }

    public TableView findAllFloat(long l, float f)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllFloat(nativePtr, l, f);
        TableView tableview;
        try
        {
            tableview = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return tableview;
    }

    public TableView findAllLong(long l, long l1)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllInt(nativePtr, l, l1);
        TableView tableview;
        try
        {
            tableview = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return tableview;
    }

    public TableView findAllString(long l, String s)
    {
        context.executeDelayedDisposal();
        l = nativeFindAllString(nativePtr, l, s);
        try
        {
            s = new TableView(context, parent, l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            nativeClose(l);
            throw s;
        }
        return s;
    }

    public long findFirstBoolean(long l, boolean flag)
    {
        return nativeFindFirstBool(nativePtr, l, flag);
    }

    public long findFirstDate(long l, Date date)
    {
        return nativeFindFirstDate(nativePtr, l, date.getTime() / 1000L);
    }

    public long findFirstDouble(long l, double d)
    {
        return nativeFindFirstDouble(nativePtr, l, d);
    }

    public long findFirstFloat(long l, float f)
    {
        return nativeFindFirstFloat(nativePtr, l, f);
    }

    public long findFirstLong(long l, long l1)
    {
        return nativeFindFirstInt(nativePtr, l, l1);
    }

    public long findFirstString(long l, String s)
    {
        return nativeFindFirstString(nativePtr, l, s);
    }

    public byte[] getBinaryByteArray(long l, long l1)
    {
        return nativeGetByteArray(nativePtr, l, l1);
    }

    public boolean getBoolean(long l, long l1)
    {
        return nativeGetBoolean(nativePtr, l, l1);
    }

    public long getColumnCount()
    {
        return nativeGetColumnCount(nativePtr);
    }

    public long getColumnIndex(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Column name can not be null.");
        } else
        {
            return nativeGetColumnIndex(nativePtr, s);
        }
    }

    public String getColumnName(long l)
    {
        return nativeGetColumnName(nativePtr, l);
    }

    public ColumnType getColumnType(long l)
    {
        return ColumnType.fromNativeValue(nativeGetColumnType(nativePtr, l));
    }

    public Date getDate(long l, long l1)
    {
        return new Date(nativeGetDateTimeValue(nativePtr, l, l1) * 1000L);
    }

    public double getDouble(long l, long l1)
    {
        return nativeGetDouble(nativePtr, l, l1);
    }

    public float getFloat(long l, long l1)
    {
        return nativeGetFloat(nativePtr, l, l1);
    }

    public long getLink(long l, long l1)
    {
        return nativeGetLink(nativePtr, l, l1);
    }

    public long getLong(long l, long l1)
    {
        return nativeGetLong(nativePtr, l, l1);
    }

    public Mixed getMixed(long l, long l1)
    {
        return nativeGetMixed(nativePtr, l, l1);
    }

    public ColumnType getMixedType(long l, long l1)
    {
        return ColumnType.fromNativeValue(nativeGetMixedType(nativePtr, l, l1));
    }

    public long getSourceRowIndex(long l)
    {
        return nativeGetSourceRowIndex(nativePtr, l);
    }

    public String getString(long l, long l1)
    {
        return nativeGetString(nativePtr, l, l1);
    }

    public Table getSubtable(long l, long l1)
    {
        context.executeDelayedDisposal();
        l = nativeGetSubtable(nativePtr, l, l1);
        Table table;
        try
        {
            table = new Table(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            Table.nativeClose(l);
            throw runtimeexception;
        }
        return table;
    }

    public long getSubtableSize(long l, long l1)
    {
        return nativeGetSubtableSize(nativePtr, l, l1);
    }

    public Table getTable()
    {
        return parent;
    }

    public boolean isEmpty()
    {
        return size() == 0L;
    }

    public boolean isNullLink(long l, long l1)
    {
        return nativeIsNullLink(nativePtr, l, l1);
    }

    public long lowerBoundLong(long l, long l1)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public Date maximumDate(long l)
    {
        return new Date(nativeMaximumDate(nativePtr, l) * 1000L);
    }

    public double maximumDouble(long l)
    {
        return nativeMaximumDouble(nativePtr, l);
    }

    public float maximumFloat(long l)
    {
        return nativeMaximumFloat(nativePtr, l);
    }

    public long maximumLong(long l)
    {
        return nativeMaximumInt(nativePtr, l);
    }

    public Date minimumDate(long l)
    {
        return new Date(nativeMinimumDate(nativePtr, l) * 1000L);
    }

    public double minimumDouble(long l)
    {
        return nativeMinimumDouble(nativePtr, l);
    }

    public float minimumFloat(long l)
    {
        return nativeMinimumFloat(nativePtr, l);
    }

    public long minimumLong(long l)
    {
        return nativeMinimumInt(nativePtr, l);
    }

    protected native void nativeAddInt(long l, long l1, long l2);

    protected native double nativeAverageDouble(long l, long l1);

    protected native double nativeAverageFloat(long l, long l1);

    protected native double nativeAverageInt(long l, long l1);

    protected native void nativeClear(long l);

    protected native void nativeClearSubtable(long l, long l1, long l2);

    protected native long nativeFindAllBool(long l, long l1, boolean flag);

    protected native long nativeFindAllDate(long l, long l1, long l2);

    protected native long nativeFindAllDouble(long l, long l1, double d);

    protected native long nativeFindAllFloat(long l, long l1, float f);

    protected native long nativeFindAllInt(long l, long l1, long l2);

    protected native long nativeFindAllString(long l, long l1, String s);

    protected native long nativeFindFirstBool(long l, long l1, boolean flag);

    protected native long nativeFindFirstDate(long l, long l1, long l2);

    protected native long nativeFindFirstDouble(long l, long l1, double d);

    protected native long nativeFindFirstFloat(long l, long l1, float f);

    protected native long nativeFindFirstInt(long l, long l1, long l2);

    protected native long nativeFindFirstString(long l, long l1, String s);

    protected native boolean nativeGetBoolean(long l, long l1, long l2);

    protected native byte[] nativeGetByteArray(long l, long l1, long l2);

    protected native long nativeGetColumnCount(long l);

    protected native long nativeGetColumnIndex(long l, String s);

    protected native String nativeGetColumnName(long l, long l1);

    protected native int nativeGetColumnType(long l, long l1);

    protected native long nativeGetDateTimeValue(long l, long l1, long l2);

    protected native double nativeGetDouble(long l, long l1, long l2);

    protected native float nativeGetFloat(long l, long l1, long l2);

    protected native long nativeGetLink(long l, long l1, long l2);

    protected native long nativeGetLong(long l, long l1, long l2);

    protected native Mixed nativeGetMixed(long l, long l1, long l2);

    protected native int nativeGetMixedType(long l, long l1, long l2);

    protected native long nativeGetSourceRowIndex(long l, long l1);

    protected native String nativeGetString(long l, long l1, long l2);

    protected native long nativeGetSubtable(long l, long l1, long l2);

    protected native long nativeGetSubtableSize(long l, long l1, long l2);

    protected native boolean nativeIsNullLink(long l, long l1, long l2);

    protected native long nativeMaximumDate(long l, long l1);

    protected native double nativeMaximumDouble(long l, long l1);

    protected native float nativeMaximumFloat(long l, long l1);

    protected native long nativeMaximumInt(long l, long l1);

    protected native long nativeMinimumDate(long l, long l1);

    protected native double nativeMinimumDouble(long l, long l1);

    protected native float nativeMinimumFloat(long l, long l1);

    protected native long nativeMinimumInt(long l, long l1);

    protected native void nativeNullifyLink(long l, long l1, long l2);

    protected native void nativePivot(long l, long l1, long l2, int i, 
            long l3);

    protected native void nativeRemoveRow(long l, long l1);

    protected native String nativeRowToString(long l, long l1);

    protected native void nativeSetBoolean(long l, long l1, long l2, boolean flag);

    protected native void nativeSetByteArray(long l, long l1, long l2, byte abyte0[]);

    protected native void nativeSetDateTimeValue(long l, long l1, long l2, long l3);

    protected native void nativeSetDouble(long l, long l1, long l2, double d);

    protected native void nativeSetFloat(long l, long l1, long l2, float f);

    protected native void nativeSetLink(long l, long l1, long l2, long l3);

    protected native void nativeSetLong(long l, long l1, long l2, long l3);

    protected native void nativeSetMixed(long l, long l1, long l2, Mixed mixed);

    protected native void nativeSetString(long l, long l1, long l2, String s);

    protected native long nativeSize(long l);

    protected native void nativeSort(long l, long l1, boolean flag);

    protected native void nativeSortMulti(long l, long al[], boolean aflag[]);

    protected native double nativeSumDouble(long l, long l1);

    protected native double nativeSumFloat(long l, long l1);

    protected native long nativeSumInt(long l, long l1);

    protected native long nativeSync(long l);

    protected native String nativeToJson(long l);

    protected native String nativeToString(long l, long l1);

    protected native long nativeWhere(long l);

    public void nullifyLink(long l, long l1)
    {
        nativeNullifyLink(nativePtr, l, l1);
    }

    public Table pivot(long l, long l1, TableOrView.PivotType pivottype)
    {
        if (!getColumnType(l).equals(ColumnType.STRING))
        {
            throw new UnsupportedOperationException("Group by column must be of type String");
        }
        if (!getColumnType(l1).equals(ColumnType.INTEGER))
        {
            throw new UnsupportedOperationException("Aggregeation column must be of type Int");
        } else
        {
            Table table = new Table();
            nativePivot(nativePtr, l, l1, pivottype.value, table.nativePtr);
            return table;
        }
    }

    public void remove(long l)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeRemoveRow(nativePtr, l);
    }

    public void removeLast()
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        if (!isEmpty())
        {
            nativeRemoveRow(nativePtr, size() - 1L);
        }
    }

    public String rowToString(long l)
    {
        return nativeRowToString(nativePtr, l);
    }

    public void setBinaryByteArray(long l, long l1, byte abyte0[])
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetByteArray(nativePtr, l, l1, abyte0);
    }

    public void setBoolean(long l, long l1, boolean flag)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetBoolean(nativePtr, l, l1, flag);
    }

    public void setDate(long l, long l1, Date date)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetDateTimeValue(nativePtr, l, l1, date.getTime() / 1000L);
    }

    public void setDouble(long l, long l1, double d)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetDouble(nativePtr, l, l1, d);
    }

    public void setFloat(long l, long l1, float f)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetFloat(nativePtr, l, l1, f);
    }

    public void setLink(long l, long l1, long l2)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetLink(nativePtr, l, l1, l2);
    }

    public void setLong(long l, long l1, long l2)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetLong(nativePtr, l, l1, l2);
    }

    public void setMixed(long l, long l1, Mixed mixed)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetMixed(nativePtr, l, l1, mixed);
    }

    public void setString(long l, long l1, String s)
    {
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        nativeSetString(nativePtr, l, l1, s);
    }

    public long size()
    {
        return nativeSize(nativePtr);
    }

    public void sort(long l)
    {
        nativeSort(nativePtr, l, true);
    }

    public void sort(long l, Order order)
    {
        long l1 = nativePtr;
        boolean flag;
        if (order == Order.ascending)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        nativeSort(l1, l, flag);
    }

    public void sort(List list, List list1)
    {
        long al[] = new long[list.size()];
        boolean aflag[] = new boolean[list1.size()];
        for (int i = 0; i < list.size(); i++)
        {
            al[i] = ((Long)list.get(i)).longValue();
        }

        int j = 0;
        while (j < list1.size()) 
        {
            boolean flag;
            if (list1.get(j) == Order.ascending)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aflag[j] = flag;
            j++;
        }
        nativeSortMulti(nativePtr, al, aflag);
    }

    public double sumDouble(long l)
    {
        return nativeSumDouble(nativePtr, l);
    }

    public double sumFloat(long l)
    {
        return nativeSumFloat(nativePtr, l);
    }

    public long sumLong(long l)
    {
        return nativeSumInt(nativePtr, l);
    }

    public long sync()
    {
        return nativeSync(nativePtr);
    }

    public String toJson()
    {
        return nativeToJson(nativePtr);
    }

    public String toString()
    {
        return nativeToString(nativePtr, 500L);
    }

    public String toString(long l)
    {
        return nativeToString(nativePtr, l);
    }

    public long upperBoundLong(long l, long l1)
    {
        throw new RuntimeException("Not implemented yet");
    }

    public TableQuery where()
    {
        context.executeDelayedDisposal();
        long l = nativeWhere(nativePtr);
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

    private class Order extends Enum
    {

        private static final Order $VALUES[];
        public static final Order ascending;
        public static final Order descending;

        public static Order valueOf(String s)
        {
            return (Order)Enum.valueOf(io/realm/internal/TableView$Order, s);
        }

        public static Order[] values()
        {
            return (Order[])$VALUES.clone();
        }

        static 
        {
            ascending = new Order("ascending", 0);
            descending = new Order("descending", 1);
            $VALUES = (new Order[] {
                ascending, descending
            });
        }

        private Order(String s, int i)
        {
            super(s, i);
        }
    }

}
