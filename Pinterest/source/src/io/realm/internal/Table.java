// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import io.realm.exceptions.RealmException;
import java.io.Closeable;
import java.io.PrintStream;
import java.util.Date;

// Referenced classes of package io.realm.internal:
//            TableOrView, TableSchema, TightDB, Context, 
//            Group, ColumnType, Mixed, TableView, 
//            Row, SubtableSchema, TableQuery, TableSpec

public class Table
    implements TableOrView, TableSchema, Closeable
{

    public static final long INFINITE = -1L;
    public static final long INTEGER_DEFAULT_VALUE = 0L;
    private static final long NO_PRIMARY_KEY = -2L;
    private static final long PRIMARY_KEY_CLASS_COLUMN_INDEX = 0L;
    private static final String PRIMARY_KEY_CLASS_COLUMN_NAME = "pk_table";
    private static final long PRIMARY_KEY_FIELD_COLUMN_INDEX = 1L;
    private static final String PRIMARY_KEY_FIELD_COLUMN_NAME = "pk_property";
    private static final String PRIMARY_KEY_TABLE_NAME = "pk";
    public static final String STRING_DEFAULT_VALUE = "";
    protected static int TableCount = 0;
    protected boolean DEBUG;
    private long cachedPrimaryKeyColumnIndex;
    private final Context context;
    private InternalMethods internal;
    protected long nativePtr;
    protected final Object parent;
    protected int tableNo;

    public Table()
    {
        cachedPrimaryKeyColumnIndex = -1L;
        DEBUG = false;
        internal = new InternalMethods();
        parent = null;
        context = new Context();
        nativePtr = createNative();
        if (nativePtr == 0L)
        {
            throw new OutOfMemoryError("Out of native memory.");
        }
        if (DEBUG)
        {
            int i = TableCount + 1;
            TableCount = i;
            tableNo = i;
            System.err.println((new StringBuilder("====== New Tablebase ")).append(tableNo).append(" : ptr = ").append(nativePtr).toString());
        }
    }

    Table(Context context1, Object obj, long l)
    {
        cachedPrimaryKeyColumnIndex = -1L;
        DEBUG = false;
        internal = new InternalMethods();
        context = context1;
        parent = obj;
        nativePtr = l;
        if (DEBUG)
        {
            int i = TableCount + 1;
            TableCount = i;
            tableNo = i;
            System.err.println((new StringBuilder("===== New Tablebase(ptr) ")).append(tableNo).append(" : ptr = ").append(nativePtr).toString());
        }
    }

    private Table getPrimaryKeyTable()
    {
        Object obj = getTableGroup();
        if (obj == null)
        {
            obj = null;
        } else
        {
            Table table = ((Group) (obj)).getTable("pk");
            obj = table;
            if (table.getColumnCount() == 0L)
            {
                table.addColumn(ColumnType.STRING, "pk_table");
                table.addColumn(ColumnType.INTEGER, "pk_property");
                return table;
            }
        }
        return ((Table) (obj));
    }

    private Table getSubtableDuringInsert(long l, long l1)
    {
        context.executeDelayedDisposal();
        l = nativeGetSubtableDuringInsert(nativePtr, l, l1);
        Table table;
        try
        {
            table = new Table(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return table;
    }

    private void insertSubtableValues(long l, long l1, Object obj)
    {
        if (obj != null)
        {
            Table table = getSubtableDuringInsert(l1, l);
            int j = ((Object[])obj).length;
            for (int i = 0; i < j; i++)
            {
                Object obj1 = ((Object[])obj)[i];
                table.addAt(i, (Object[])obj1);
            }

        }
    }

    private boolean isPrimaryKeyColumn(long l)
    {
        return l == getPrimaryKey();
    }

    protected static native void nativeClose(long l);

    private native long nativeGetSubtableDuringInsert(long l, long l1, long l2);

    private native void nativeInsertLinkList(long l, long l1, long l2);

    private native long nativeSetPrimaryKey(long l, long l1, String s);

    private void throwDuplicatePrimaryKeyException(Object obj)
    {
        throw new RealmException((new StringBuilder("Primary key constraint broken. Value already exists: ")).append(obj).toString());
    }

    private void throwImmutable()
    {
        throw new IllegalStateException("Mutable method call during read transaction.");
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

    public transient long add(Object aobj[])
    {
        long l = size();
        addAt(l, aobj);
        return l;
    }

    public transient void addAt(long l, Object aobj[])
    {
        ColumnType acolumntype[];
        int j;
        long l1;
        checkImmutable();
        l1 = size();
        if (l > l1)
        {
            throw new IllegalArgumentException((new StringBuilder("rowIndex ")).append(String.valueOf(l)).append(" must be <= table.size() ").append(String.valueOf(l1)).append(".").toString());
        }
        j = (int)getColumnCount();
        if (j != aobj.length)
        {
            throw new IllegalArgumentException((new StringBuilder("The number of value parameters (")).append(String.valueOf(aobj.length)).append(") does not match the number of columns in the table (").append(String.valueOf(j)).append(").").toString());
        }
        acolumntype = new ColumnType[j];
        for (int i = 0; i < j; i++)
        {
            Object obj1 = aobj[i];
            ColumnType columntype = getColumnType(i);
            acolumntype[i] = columntype;
            if (!columntype.matchObject(obj1))
            {
                if (obj1 == null)
                {
                    aobj = "null";
                } else
                {
                    aobj = obj1.getClass().toString();
                }
                throw new IllegalArgumentException((new StringBuilder("Invalid argument no ")).append(String.valueOf(i + 1)).append(". Expected a value compatible with column type ").append(columntype).append(", but got ").append(((String) (aobj))).append(".").toString());
            }
        }

        l1 = 0L;
_L12:
        Object obj;
        if (l1 >= (long)j)
        {
            break MISSING_BLOCK_LABEL_598;
        }
        obj = aobj[(int)l1];
        _cls1..SwitchMap.io.realm.internal.ColumnType[acolumntype[(int)l1].ordinal()];
        JVM INSTR tableswitch 1 9: default 340
    //                   1 480
    //                   2 401
    //                   3 373
    //                   4 436
    //                   5 458
    //                   6 511
    //                   7 537
    //                   8 556
    //                   9 575;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_575;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new RuntimeException((new StringBuilder("Unexpected columnType: ")).append(String.valueOf(acolumntype[(int)l1])).toString());
_L4:
        nativeInsertBoolean(nativePtr, l1, l, ((Boolean)obj).booleanValue());
_L13:
        l1++;
        if (true) goto _L12; else goto _L11
_L11:
        long l2 = ((Number)obj).longValue();
        checkIntValueIsLegal(l1, l, l2);
        nativeInsertLong(nativePtr, l1, l, l2);
          goto _L13
_L5:
        nativeInsertFloat(nativePtr, l1, l, ((Float)obj).floatValue());
          goto _L13
_L6:
        nativeInsertDouble(nativePtr, l1, l, ((Double)obj).doubleValue());
          goto _L13
_L2:
        checkStringValueIsLegal(l1, l, (String)obj);
        nativeInsertString(nativePtr, l1, l, (String)obj);
          goto _L13
_L7:
        nativeInsertDate(nativePtr, l1, l, ((Date)obj).getTime() / 1000L);
          goto _L13
_L8:
        nativeInsertMixed(nativePtr, l1, l, Mixed.mixedValue(obj));
          goto _L13
_L9:
        nativeInsertByteArray(nativePtr, l1, l, (byte[])obj);
          goto _L13
        nativeInsertSubtable(nativePtr, l1, l);
        insertSubtableValues(l, l1, obj);
          goto _L13
        nativeInsertDone(nativePtr);
        return;
    }

    public long addColumn(ColumnType columntype, String s)
    {
        verifyColumnName(s);
        return nativeAddColumn(nativePtr, columntype.getValue(), s);
    }

    public long addColumnLink(ColumnType columntype, String s, Table table)
    {
        verifyColumnName(s);
        return nativeAddColumnLink(nativePtr, columntype.getValue(), s, table.nativePtr);
    }

    public long addEmptyRow()
    {
        checkImmutable();
        if (!hasPrimaryKey()) goto _L2; else goto _L1
_L1:
        ColumnType columntype;
        long l;
        l = getPrimaryKey();
        columntype = getColumnType(l);
        _cls1..SwitchMap.io.realm.internal.ColumnType[columntype.ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 77
    //                   2 107;
           goto _L3 _L4 _L5
_L3:
        throw new RealmException((new StringBuilder("Cannot check for duplicate rows for unsupported primary key type: ")).append(columntype).toString());
_L4:
        if (findFirstString(l, "") != -1L)
        {
            throwDuplicatePrimaryKeyException("");
        }
_L2:
        return nativeAddEmptyRow(nativePtr, 1L);
_L5:
        if (findFirstLong(l, 0L) != -1L)
        {
            throwDuplicatePrimaryKeyException(Long.valueOf(0L));
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public long addEmptyRows(long l)
    {
        checkImmutable();
        if (l < 1L)
        {
            throw new IllegalArgumentException("'rows' must be > 0.");
        }
        if (hasPrimaryKey())
        {
            if (l > 1L)
            {
                throw new RealmException("Multiple empty rows cannot be created if a primary key is defined for the table.");
            } else
            {
                return addEmptyRow();
            }
        } else
        {
            return nativeAddEmptyRow(nativePtr, l);
        }
    }

    public void adjust(long l, long l1)
    {
        checkImmutable();
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

    void checkImmutable()
    {
        if (isImmutable())
        {
            throwImmutable();
        }
    }

    void checkIntValueIsLegal(long l, long l1, long l2)
    {
        if (isPrimaryKeyColumn(l))
        {
            l = findFirstLong(l, l2);
            if (l != l1 && l != -1L)
            {
                throwDuplicatePrimaryKeyException(Long.valueOf(l2));
            }
        }
    }

    void checkStringValueIsLegal(long l, long l1, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Null String is not allowed.");
        }
        if (isPrimaryKey(l))
        {
            l = findFirstString(l, s);
            if (l != l1 && l != -1L)
            {
                throwDuplicatePrimaryKeyException(s);
            }
        }
    }

    public void clear()
    {
        checkImmutable();
        nativeClear(nativePtr);
    }

    public void clearSubtable(long l, long l1)
    {
        checkImmutable();
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
                    TableCount--;
                    System.err.println((new StringBuilder("==== CLOSE ")).append(tableNo).append(" ptr= ").append(nativePtr).append(" remaining ").append(TableCount).toString());
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

    public long count(long l, double d)
    {
        return nativeCountDouble(nativePtr, l, d);
    }

    public long count(long l, float f)
    {
        return nativeCountFloat(nativePtr, l, f);
    }

    public long count(long l, long l1)
    {
        return nativeCountLong(nativePtr, l, l1);
    }

    public long count(long l, String s)
    {
        return nativeCountString(nativePtr, l, s);
    }

    protected native long createNative();

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof Table)
                {
                    obj = (Table)obj;
                    return nativeEquals(nativePtr, ((Table) (obj)).nativePtr);
                }
            }
        }
        return flag;
    }

    protected void finalize()
    {
        Context context1 = context;
        context1;
        JVM INSTR monitorenter ;
        if (nativePtr == 0L)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        boolean flag;
        if (parent == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context.asyncDisposeTable(nativePtr, flag);
        nativePtr = 0L;
        context1;
        JVM INSTR monitorexit ;
        if (DEBUG)
        {
            System.err.println((new StringBuilder("==== FINALIZE ")).append(tableNo).append("...").toString());
        }
        return;
        Exception exception;
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
            tableview = new TableView(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
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
            date = new TableView(context, this, l);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            TableView.nativeClose(l);
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
            tableview = new TableView(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
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
            tableview = new TableView(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
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
            tableview = new TableView(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
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
            s = new TableView(context, this, l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TableView.nativeClose(l);
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
        return new Date(nativeGetDateTime(nativePtr, l, l1) * 1000L);
    }

    public TableView getDistinctView(long l)
    {
        context.executeDelayedDisposal();
        l = nativeGetDistinctView(nativePtr, l);
        TableView tableview;
        try
        {
            tableview = new TableView(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
            throw runtimeexception;
        }
        return tableview;
    }

    public double getDouble(long l, long l1)
    {
        return nativeGetDouble(nativePtr, l, l1);
    }

    public float getFloat(long l, long l1)
    {
        return nativeGetFloat(nativePtr, l, l1);
    }

    public InternalMethods getInternalMethods()
    {
        return internal;
    }

    public long getLink(long l, long l1)
    {
        return nativeGetLink(nativePtr, l, l1);
    }

    public Table getLinkTarget(long l)
    {
        context.executeDelayedDisposal();
        l = nativeGetLinkTarget(nativePtr, l);
        Table table;
        try
        {
            table = new Table(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return table;
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

    public String getName()
    {
        return nativeGetName(nativePtr);
    }

    public long getPrimaryKey()
    {
        long l = -2L;
        if (cachedPrimaryKeyColumnIndex >= 0L || cachedPrimaryKeyColumnIndex == -2L)
        {
            l = cachedPrimaryKeyColumnIndex;
        } else
        {
            Table table = getPrimaryKeyTable();
            if (table != null)
            {
                long l1 = table.findFirstString(0L, getName());
                if (l1 != -1L)
                {
                    cachedPrimaryKeyColumnIndex = table.getRow(l1).getLong(1L);
                } else
                {
                    cachedPrimaryKeyColumnIndex = -2L;
                }
                return cachedPrimaryKeyColumnIndex;
            }
        }
        return l;
    }

    public Row getRow(long l)
    {
        l = nativeGetRowPtr(nativePtr, l);
        return new Row(context, this, l);
    }

    public TableView getSortedView(long l)
    {
        context.executeDelayedDisposal();
        l = nativeGetSortedView(nativePtr, l, true);
        return new TableView(context, this, l);
    }

    public TableView getSortedView(long l, TableView.Order order)
    {
        context.executeDelayedDisposal();
        long l1 = nativePtr;
        boolean flag;
        if (order == TableView.Order.ascending)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = nativeGetSortedView(l1, l, flag);
        try
        {
            order = new TableView(context, this, l);
        }
        // Misplaced declaration of an exception variable
        catch (TableView.Order order)
        {
            TableView.nativeClose(l);
            throw order;
        }
        return order;
    }

    public TableView getSortedView(long al[], boolean aflag[])
    {
        context.executeDelayedDisposal();
        long l = nativeGetSortedViewMulti(nativePtr, al, aflag);
        return new TableView(context, this, l);
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
            table = new Table(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            nativeClose(l);
            throw runtimeexception;
        }
        return table;
    }

    public TableSchema getSubtableSchema(long l)
    {
        if (!nativeIsRootTable(nativePtr))
        {
            throw new UnsupportedOperationException("This is a subtable. Can only be called on root table.");
        } else
        {
            return new SubtableSchema(nativePtr, new long[] {
                l
            });
        }
    }

    public long getSubtableSize(long l, long l1)
    {
        return nativeGetSubtableSize(nativePtr, l, l1);
    }

    public Table getTable()
    {
        return this;
    }

    Group getTableGroup()
    {
        if (parent instanceof Group)
        {
            return (Group)parent;
        }
        if (parent instanceof Table)
        {
            return ((Table)parent).getTableGroup();
        } else
        {
            return null;
        }
    }

    public TableSpec getTableSpec()
    {
        return nativeGetTableSpec(nativePtr);
    }

    public boolean hasIndex(long l)
    {
        return nativeHasIndex(nativePtr, l);
    }

    public boolean hasPrimaryKey()
    {
        return getPrimaryKey() >= 0L;
    }

    public void insertLinkList(long l, long l1)
    {
        nativeInsertLinkList(nativePtr, l, l1);
        getInternalMethods().insertDone();
    }

    public boolean isEmpty()
    {
        return size() == 0L;
    }

    boolean isImmutable()
    {
        if (!(parent instanceof Table))
        {
            return parent != null && ((Group)parent).immutable;
        } else
        {
            return ((Table)parent).isImmutable();
        }
    }

    public boolean isNullLink(long l, long l1)
    {
        return nativeIsNullLink(nativePtr, l, l1);
    }

    public boolean isPrimaryKey(long l)
    {
        while (l < 0L || l != getPrimaryKey()) 
        {
            return false;
        }
        return true;
    }

    public boolean isValid()
    {
        if (nativePtr == 0L)
        {
            return false;
        } else
        {
            return nativeIsValid(nativePtr);
        }
    }

    public long lowerBoundLong(long l, long l1)
    {
        return nativeLowerBoundInt(nativePtr, l, l1);
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

    public void moveLastOver(long l)
    {
        checkImmutable();
        nativeMoveLastOver(nativePtr, l);
    }

    protected native long nativeAddColumn(long l, int i, String s);

    protected native long nativeAddColumnLink(long l, int i, String s, long l1);

    protected native long nativeAddEmptyRow(long l, long l1);

    protected native void nativeAddInt(long l, long l1, long l2);

    protected native double nativeAverageDouble(long l, long l1);

    protected native double nativeAverageFloat(long l, long l1);

    protected native double nativeAverageInt(long l, long l1);

    protected native void nativeClear(long l);

    protected native void nativeClearSubtable(long l, long l1, long l2);

    protected native long nativeCountDouble(long l, long l1, double d);

    protected native long nativeCountFloat(long l, long l1, float f);

    protected native long nativeCountLong(long l, long l1, long l2);

    protected native long nativeCountString(long l, long l1, String s);

    protected native boolean nativeEquals(long l, long l1);

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

    protected native long nativeGetDateTime(long l, long l1, long l2);

    protected native long nativeGetDistinctView(long l, long l1);

    protected native double nativeGetDouble(long l, long l1, long l2);

    protected native float nativeGetFloat(long l, long l1, long l2);

    protected native long nativeGetLink(long l, long l1, long l2);

    protected native long nativeGetLinkTarget(long l, long l1);

    protected native long nativeGetLong(long l, long l1, long l2);

    protected native Mixed nativeGetMixed(long l, long l1, long l2);

    protected native int nativeGetMixedType(long l, long l1, long l2);

    protected native String nativeGetName(long l);

    protected native long nativeGetRowPtr(long l, long l1);

    protected native long nativeGetSortedView(long l, long l1, boolean flag);

    protected native long nativeGetSortedViewMulti(long l, long al[], boolean aflag[]);

    protected native String nativeGetString(long l, long l1, long l2);

    protected native long nativeGetSubtable(long l, long l1, long l2);

    protected native long nativeGetSubtableSize(long l, long l1, long l2);

    protected native TableSpec nativeGetTableSpec(long l);

    protected native boolean nativeHasIndex(long l, long l1);

    protected native void nativeInsertBoolean(long l, long l1, long l2, boolean flag);

    protected native void nativeInsertByteArray(long l, long l1, long l2, byte abyte0[]);

    protected native void nativeInsertDate(long l, long l1, long l2, long l3);

    protected native void nativeInsertDone(long l);

    protected native void nativeInsertDouble(long l, long l1, long l2, double d);

    protected native void nativeInsertFloat(long l, long l1, long l2, float f);

    protected native void nativeInsertLong(long l, long l1, long l2, long l3);

    protected native void nativeInsertMixed(long l, long l1, long l2, Mixed mixed);

    protected native void nativeInsertString(long l, long l1, long l2, String s);

    protected native void nativeInsertSubtable(long l, long l1, long l2);

    protected native boolean nativeIsNullLink(long l, long l1, long l2);

    protected native boolean nativeIsRootTable(long l);

    protected native boolean nativeIsValid(long l);

    protected native long nativeLowerBoundInt(long l, long l1, long l2);

    protected native long nativeMaximumDate(long l, long l1);

    protected native double nativeMaximumDouble(long l, long l1);

    protected native float nativeMaximumFloat(long l, long l1);

    protected native long nativeMaximumInt(long l, long l1);

    protected native long nativeMinimumDate(long l, long l1);

    protected native double nativeMinimumDouble(long l, long l1);

    protected native float nativeMinimumFloat(long l, long l1);

    protected native long nativeMinimumInt(long l, long l1);

    protected native void nativeMoveLastOver(long l, long l1);

    protected native void nativeNullifyLink(long l, long l1, long l2);

    protected native void nativeOptimize(long l);

    protected native void nativePivot(long l, long l1, long l2, int i, 
            long l3);

    protected native void nativeRemove(long l, long l1);

    protected native void nativeRemoveColumn(long l, long l1);

    protected native void nativeRemoveLast(long l);

    protected native void nativeRenameColumn(long l, long l1, String s);

    protected native String nativeRowToString(long l, long l1);

    protected native void nativeSetBoolean(long l, long l1, long l2, boolean flag);

    protected native void nativeSetByteArray(long l, long l1, long l2, byte abyte0[]);

    protected native void nativeSetDate(long l, long l1, long l2, long l3);

    protected native void nativeSetDouble(long l, long l1, long l2, double d);

    protected native void nativeSetFloat(long l, long l1, long l2, float f);

    protected native void nativeSetIndex(long l, long l1);

    protected native void nativeSetLink(long l, long l1, long l2, long l3);

    protected native void nativeSetLong(long l, long l1, long l2, long l3);

    protected native void nativeSetMixed(long l, long l1, long l2, Mixed mixed);

    protected native void nativeSetString(long l, long l1, long l2, String s);

    protected native long nativeSize(long l);

    protected native double nativeSumDouble(long l, long l1);

    protected native double nativeSumFloat(long l, long l1);

    protected native long nativeSumInt(long l, long l1);

    protected native String nativeToJson(long l);

    protected native String nativeToString(long l, long l1);

    protected native void nativeUpdateFromSpec(long l, TableSpec tablespec);

    protected native long nativeUpperBoundInt(long l, long l1, long l2);

    protected native long nativeWhere(long l);

    public void nullifyLink(long l, long l1)
    {
        nativeNullifyLink(nativePtr, l, l1);
    }

    public void optimize()
    {
        checkImmutable();
        nativeOptimize(nativePtr);
    }

    public Table pivot(long l, long l1, TableOrView.PivotType pivottype)
    {
        if (!getColumnType(l).equals(ColumnType.STRING))
        {
            throw new UnsupportedOperationException("Group by column must be of type String");
        }
        if (!getColumnType(l1).equals(ColumnType.INTEGER))
        {
            throw new UnsupportedOperationException("Aggregation column must be of type Int");
        } else
        {
            Table table = new Table();
            nativePivot(nativePtr, l, l1, pivottype.value, table.nativePtr);
            return table;
        }
    }

    public void remove(long l)
    {
        checkImmutable();
        nativeRemove(nativePtr, l);
    }

    public void removeColumn(long l)
    {
        nativeRemoveColumn(nativePtr, l);
    }

    public void removeLast()
    {
        checkImmutable();
        nativeRemoveLast(nativePtr);
    }

    public void renameColumn(long l, String s)
    {
        verifyColumnName(s);
        nativeRenameColumn(nativePtr, l, s);
    }

    public String rowToString(long l)
    {
        return nativeRowToString(nativePtr, l);
    }

    public transient void set(long l, Object aobj[])
    {
        checkImmutable();
        long l1 = size();
        if (l >= l1)
        {
            throw new IllegalArgumentException((new StringBuilder("rowIndex ")).append(String.valueOf(l)).append(" must be < table.size() ").append(String.valueOf(l1)).append(".").toString());
        }
        int j = (int)getColumnCount();
        if (j != aobj.length)
        {
            throw new IllegalArgumentException((new StringBuilder("The number of value parameters (")).append(String.valueOf(aobj.length)).append(") does not match the number of columns in the table (").append(String.valueOf(j)).append(").").toString());
        }
        ColumnType acolumntype[] = new ColumnType[j];
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            ColumnType columntype = getColumnType(i);
            acolumntype[i] = columntype;
            if (!columntype.matchObject(obj))
            {
                throw new IllegalArgumentException((new StringBuilder("Invalid argument no ")).append(String.valueOf(i + 1)).append(". Expected a value compatible with column type ").append(columntype).append(", but got ").append(obj.getClass()).append(".").toString());
            }
        }

        remove(l);
        addAt(l, aobj);
    }

    public void setBinaryByteArray(long l, long l1, byte abyte0[])
    {
        checkImmutable();
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Null Array");
        } else
        {
            nativeSetByteArray(nativePtr, l, l1, abyte0);
            return;
        }
    }

    public void setBoolean(long l, long l1, boolean flag)
    {
        checkImmutable();
        nativeSetBoolean(nativePtr, l, l1, flag);
    }

    public void setDate(long l, long l1, Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Null Date is not allowed.");
        } else
        {
            checkImmutable();
            nativeSetDate(nativePtr, l, l1, date.getTime() / 1000L);
            return;
        }
    }

    public void setDouble(long l, long l1, double d)
    {
        checkImmutable();
        nativeSetDouble(nativePtr, l, l1, d);
    }

    public void setFloat(long l, long l1, float f)
    {
        checkImmutable();
        nativeSetFloat(nativePtr, l, l1, f);
    }

    public void setIndex(long l)
    {
        checkImmutable();
        if (getColumnType(l) != ColumnType.STRING)
        {
            throw new IllegalArgumentException("Index is only supported on string columns.");
        } else
        {
            nativeSetIndex(nativePtr, l);
            return;
        }
    }

    public void setLink(long l, long l1, long l2)
    {
        checkImmutable();
        nativeSetLink(nativePtr, l, l1, l2);
    }

    public void setLong(long l, long l1, long l2)
    {
        checkImmutable();
        checkIntValueIsLegal(l, l1, l2);
        nativeSetLong(nativePtr, l, l1, l2);
    }

    public void setMixed(long l, long l1, Mixed mixed)
    {
        checkImmutable();
        if (mixed == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            nativeSetMixed(nativePtr, l, l1, mixed);
            return;
        }
    }

    public void setPrimaryKey(String s)
    {
        Table table = getPrimaryKeyTable();
        if (table == null)
        {
            throw new RealmException("Primary keys are only supported if Table is part of a Group");
        } else
        {
            cachedPrimaryKeyColumnIndex = nativeSetPrimaryKey(table.nativePtr, nativePtr, s);
            return;
        }
    }

    public void setString(long l, long l1, String s)
    {
        checkImmutable();
        checkStringValueIsLegal(l, l1, s);
        nativeSetString(nativePtr, l, l1, s);
    }

    public long size()
    {
        return nativeSize(nativePtr);
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
        throw new RuntimeException("Not supported for tables");
    }

    public String toJson()
    {
        return nativeToJson(nativePtr);
    }

    public String toString()
    {
        return nativeToString(nativePtr, -1L);
    }

    public String toString(long l)
    {
        return nativeToString(nativePtr, l);
    }

    public void updateFromSpec(TableSpec tablespec)
    {
        checkImmutable();
        nativeUpdateFromSpec(nativePtr, tablespec);
    }

    public long upperBoundLong(long l, long l1)
    {
        return nativeUpperBoundInt(nativePtr, l, l1);
    }

    public TableQuery where()
    {
        context.executeDelayedDisposal();
        long l = nativeWhere(nativePtr);
        TableQuery tablequery;
        try
        {
            tablequery = new TableQuery(context, this, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableQuery.nativeClose(l);
            throw runtimeexception;
        }
        return tablequery;
    }

    static 
    {
        TightDB.loadLibrary();
    }


    private class InternalMethods
    {

        final Table this$0;

        public void insertBinary(long l, long l1, byte abyte0[])
        {
            checkImmutable();
            if (abyte0 != null)
            {
                nativeInsertByteArray(nativePtr, l, l1, abyte0);
                return;
            } else
            {
                throw new IllegalArgumentException("byte[] must not be null. Alternatively insert empty array.");
            }
        }

        public void insertBoolean(long l, long l1, boolean flag)
        {
            checkImmutable();
            nativeInsertBoolean(nativePtr, l, l1, flag);
        }

        public void insertDate(long l, long l1, Date date)
        {
            checkImmutable();
            nativeInsertDate(nativePtr, l, l1, date.getTime() / 1000L);
        }

        public void insertDone()
        {
            checkImmutable();
            nativeInsertDone(nativePtr);
        }

        public void insertDouble(long l, long l1, double d)
        {
            checkImmutable();
            nativeInsertDouble(nativePtr, l, l1, d);
        }

        public void insertFloat(long l, long l1, float f)
        {
            checkImmutable();
            nativeInsertFloat(nativePtr, l, l1, f);
        }

        public void insertLong(long l, long l1, long l2)
        {
            checkImmutable();
            nativeInsertLong(nativePtr, l, l1, l2);
        }

        public void insertMixed(long l, long l1, Mixed mixed)
        {
            checkImmutable();
            nativeInsertMixed(nativePtr, l, l1, mixed);
        }

        public void insertString(long l, long l1, String s)
        {
            checkImmutable();
            nativeInsertString(nativePtr, l, l1, s);
        }

        public void insertSubtable(long l, long l1, Object aobj[][])
        {
            checkImmutable();
            nativeInsertSubtable(nativePtr, l, l1);
            insertSubtableValues(l1, l, ((Object) (aobj)));
        }

        public InternalMethods()
        {
            this$0 = Table.this;
            super();
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$io$realm$internal$ColumnType[];

        static 
        {
            $SwitchMap$io$realm$internal$ColumnType = new int[ColumnType.values().length];
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.STRING.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.INTEGER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.BOOLEAN.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.FLOAT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.DOUBLE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.DATE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.MIXED.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.BINARY.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.TABLE.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
