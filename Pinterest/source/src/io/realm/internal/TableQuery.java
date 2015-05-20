// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.io.Closeable;
import java.io.PrintStream;
import java.util.Date;

// Referenced classes of package io.realm.internal:
//            Context, TableView, Table

public class TableQuery
    implements Closeable
{

    private static final String DATE_NULL_ERROR_MESSAGE = "Date value in query criteria must not be null.";
    private static final String STRING_NULL_ERROR_MESSAGE = "String value in query criteria must not be null.";
    protected boolean DEBUG;
    private final Context context;
    protected long nativePtr;
    protected final Table parent;
    private boolean queryValidated;

    public TableQuery(Context context1, Table table, long l)
    {
        DEBUG = false;
        queryValidated = true;
        if (DEBUG)
        {
            System.err.println((new StringBuilder("++++++ new TableQuery, ptr= ")).append(l).toString());
        }
        context = context1;
        parent = table;
        nativePtr = l;
    }

    protected static native void nativeClose(long l);

    private void throwImmutable()
    {
        throw new IllegalStateException("Mutable method call during read transaction.");
    }

    private void validateQuery()
    {
        String s;
label0:
        {
            if (!queryValidated)
            {
                s = nativeValidateQuery(nativePtr);
                if (!s.equals(""))
                {
                    break label0;
                }
                queryValidated = true;
            }
            return;
        }
        throw new UnsupportedOperationException(s);
    }

    public double averageDouble(long l)
    {
        validateQuery();
        return nativeAverageDouble(nativePtr, l, 0L, -1L, -1L);
    }

    public double averageDouble(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeAverageDouble(nativePtr, l, l1, l2, l3);
    }

    public double averageFloat(long l)
    {
        validateQuery();
        return nativeAverageFloat(nativePtr, l, 0L, -1L, -1L);
    }

    public double averageFloat(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeAverageFloat(nativePtr, l, l1, l2, l3);
    }

    public double averageInt(long l)
    {
        validateQuery();
        return nativeAverageInt(nativePtr, l, 0L, -1L, -1L);
    }

    public double averageInt(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeAverageInt(nativePtr, l, l1, l2, l3);
    }

    public TableQuery beginsWith(long al[], String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeBeginsWith(nativePtr, al, s, true);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery beginsWith(long al[], String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeBeginsWith(nativePtr, al, s, flag);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery between(long al[], double d, double d1)
    {
        nativeBetween(nativePtr, al, d, d1);
        queryValidated = false;
        return this;
    }

    public TableQuery between(long al[], float f, float f1)
    {
        nativeBetween(nativePtr, al, f, f1);
        queryValidated = false;
        return this;
    }

    public TableQuery between(long al[], long l, long l1)
    {
        nativeBetween(nativePtr, al, l, l1);
        queryValidated = false;
        return this;
    }

    public TableQuery between(long al[], Date date, Date date1)
    {
        if (date == null || date1 == null)
        {
            throw new IllegalArgumentException("Date values in query criteria must not be null.");
        } else
        {
            nativeBetweenDateTime(nativePtr, al, date.getTime() / 1000L, date1.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
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
                    System.err.println((new StringBuilder("++++ Query CLOSE, ptr= ")).append(nativePtr).toString());
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

    public TableQuery contains(long al[], String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeContains(nativePtr, al, s, true);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery contains(long al[], String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeContains(nativePtr, al, s, flag);
            queryValidated = false;
            return this;
        }
    }

    public long count()
    {
        validateQuery();
        return nativeCount(nativePtr, 0L, -1L, -1L);
    }

    public long count(long l, long l1, long l2)
    {
        validateQuery();
        return nativeCount(nativePtr, l, l1, l2);
    }

    public TableQuery endGroup()
    {
        nativeEndGroup(nativePtr);
        queryValidated = false;
        return this;
    }

    public TableQuery endSubtable()
    {
        nativeParent(nativePtr);
        queryValidated = false;
        return this;
    }

    public TableQuery endsWith(long al[], String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeEndsWith(nativePtr, al, s, true);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery endsWith(long al[], String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeEndsWith(nativePtr, al, s, flag);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery equalTo(long al[], double d)
    {
        nativeEqual(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long al[], float f)
    {
        nativeEqual(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long al[], long l)
    {
        nativeEqual(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long al[], String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeEqual(nativePtr, al, s, true);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery equalTo(long al[], String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeEqual(nativePtr, al, s, flag);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery equalTo(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeEqualDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery equalTo(long al[], boolean flag)
    {
        nativeEqual(nativePtr, al, flag);
        queryValidated = false;
        return this;
    }

    protected void finalize()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                context.asyncDisposeQuery(nativePtr);
                nativePtr = 0L;
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long find()
    {
        validateQuery();
        return nativeFind(nativePtr, 0L);
    }

    public long find(long l)
    {
        validateQuery();
        return nativeFind(nativePtr, l);
    }

    public TableView findAll()
    {
        validateQuery();
        context.executeDelayedDisposal();
        long l = nativeFindAll(nativePtr, 0L, -1L, -1L);
        TableView tableview1;
        try
        {
            tableview1 = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
            throw runtimeexception;
        }
        return tableview1;
    }

    public TableView findAll(long l, long l1, long l2)
    {
        validateQuery();
        context.executeDelayedDisposal();
        l = nativeFindAll(nativePtr, l, l1, l2);
        TableView tableview1;
        try
        {
            tableview1 = new TableView(context, parent, l);
        }
        catch (RuntimeException runtimeexception)
        {
            TableView.nativeClose(l);
            throw runtimeexception;
        }
        return tableview1;
    }

    public TableQuery greaterThan(long al[], double d)
    {
        nativeGreater(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long al[], float f)
    {
        nativeGreater(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long al[], long l)
    {
        nativeGreater(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeGreaterDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery greaterThanOrEqual(long al[], double d)
    {
        nativeGreaterEqual(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long al[], float f)
    {
        nativeGreaterEqual(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long al[], long l)
    {
        nativeGreaterEqual(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeGreaterEqualDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery group()
    {
        nativeGroup(nativePtr);
        return this;
    }

    public TableQuery lessThan(long al[], double d)
    {
        nativeLess(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long al[], float f)
    {
        nativeLess(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long al[], long l)
    {
        nativeLess(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeLessDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery lessThanOrEqual(long al[], double d)
    {
        nativeLessEqual(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long al[], float f)
    {
        nativeLessEqual(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long al[], long l)
    {
        nativeLessEqual(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeLessEqualDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public Date maximumDate(long l)
    {
        validateQuery();
        return new Date(nativeMaximumDate(nativePtr, l, 0L, -1L, -1L) * 1000L);
    }

    public Date maximumDate(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return new Date(nativeMaximumDate(nativePtr, l, l1, l2, l3) * 1000L);
    }

    public double maximumDouble(long l)
    {
        validateQuery();
        return nativeMaximumDouble(nativePtr, l, 0L, -1L, -1L);
    }

    public double maximumDouble(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMaximumDouble(nativePtr, l, l1, l2, l3);
    }

    public float maximumFloat(long l)
    {
        validateQuery();
        return nativeMaximumFloat(nativePtr, l, 0L, -1L, -1L);
    }

    public float maximumFloat(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMaximumFloat(nativePtr, l, l1, l2, l3);
    }

    public long maximumInt(long l)
    {
        validateQuery();
        return nativeMaximumInt(nativePtr, l, 0L, -1L, -1L);
    }

    public long maximumInt(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMaximumInt(nativePtr, l, l1, l2, l3);
    }

    public Date minimumDate(long l)
    {
        validateQuery();
        return new Date(nativeMinimumDate(nativePtr, l, 0L, -1L, -1L) * 1000L);
    }

    public Date minimumDate(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return new Date(nativeMinimumDate(nativePtr, l, l1, l2, l3) * 1000L);
    }

    public double minimumDouble(long l)
    {
        validateQuery();
        return nativeMinimumDouble(nativePtr, l, 0L, -1L, -1L);
    }

    public double minimumDouble(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMinimumDouble(nativePtr, l, l1, l2, l3);
    }

    public float minimumFloat(long l)
    {
        validateQuery();
        return nativeMinimumFloat(nativePtr, l, 0L, -1L, -1L);
    }

    public float minimumFloat(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMinimumFloat(nativePtr, l, l1, l2, l3);
    }

    public long minimumInt(long l)
    {
        validateQuery();
        return nativeMinimumInt(nativePtr, l, 0L, -1L, -1L);
    }

    public long minimumInt(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeMinimumInt(nativePtr, l, l1, l2, l3);
    }

    protected native double nativeAverageDouble(long l, long l1, long l2, long l3, long l4);

    protected native double nativeAverageFloat(long l, long l1, long l2, long l3, long l4);

    protected native double nativeAverageInt(long l, long l1, long l2, long l3, long l4);

    protected native void nativeBeginsWith(long l, long al[], String s, boolean flag);

    protected native void nativeBetween(long l, long al[], double d, double d1);

    protected native void nativeBetween(long l, long al[], float f, float f1);

    protected native void nativeBetween(long l, long al[], long l1, long l2);

    protected native void nativeBetweenDateTime(long l, long al[], long l1, long l2);

    protected native void nativeContains(long l, long al[], String s, boolean flag);

    protected native long nativeCount(long l, long l1, long l2, long l3);

    protected native void nativeEndGroup(long l);

    protected native void nativeEndsWith(long l, long al[], String s, boolean flag);

    protected native void nativeEqual(long l, long al[], double d);

    protected native void nativeEqual(long l, long al[], float f);

    protected native void nativeEqual(long l, long al[], long l1);

    protected native void nativeEqual(long l, long al[], String s, boolean flag);

    protected native void nativeEqual(long l, long al[], boolean flag);

    protected native void nativeEqualDateTime(long l, long al[], long l1);

    protected native long nativeFind(long l, long l1);

    protected native long nativeFindAll(long l, long l1, long l2, long l3);

    protected native void nativeGreater(long l, long al[], double d);

    protected native void nativeGreater(long l, long al[], float f);

    protected native void nativeGreater(long l, long al[], long l1);

    protected native void nativeGreaterDateTime(long l, long al[], long l1);

    protected native void nativeGreaterEqual(long l, long al[], double d);

    protected native void nativeGreaterEqual(long l, long al[], float f);

    protected native void nativeGreaterEqual(long l, long al[], long l1);

    protected native void nativeGreaterEqualDateTime(long l, long al[], long l1);

    protected native void nativeGroup(long l);

    protected native void nativeLess(long l, long al[], double d);

    protected native void nativeLess(long l, long al[], float f);

    protected native void nativeLess(long l, long al[], long l1);

    protected native void nativeLessDateTime(long l, long al[], long l1);

    protected native void nativeLessEqual(long l, long al[], double d);

    protected native void nativeLessEqual(long l, long al[], float f);

    protected native void nativeLessEqual(long l, long al[], long l1);

    protected native void nativeLessEqualDateTime(long l, long al[], long l1);

    protected native long nativeMaximumDate(long l, long l1, long l2, long l3, long l4);

    protected native double nativeMaximumDouble(long l, long l1, long l2, long l3, long l4);

    protected native float nativeMaximumFloat(long l, long l1, long l2, long l3, long l4);

    protected native long nativeMaximumInt(long l, long l1, long l2, long l3, long l4);

    protected native long nativeMinimumDate(long l, long l1, long l2, long l3, long l4);

    protected native double nativeMinimumDouble(long l, long l1, long l2, long l3, long l4);

    protected native float nativeMinimumFloat(long l, long l1, long l2, long l3, long l4);

    protected native long nativeMinimumInt(long l, long l1, long l2, long l3, long l4);

    protected native void nativeNot(long l);

    protected native void nativeNotEqual(long l, long al[], double d);

    protected native void nativeNotEqual(long l, long al[], float f);

    protected native void nativeNotEqual(long l, long al[], long l1);

    protected native void nativeNotEqual(long l, long al[], String s, boolean flag);

    protected native void nativeNotEqualDateTime(long l, long al[], long l1);

    protected native void nativeOr(long l);

    protected native void nativeParent(long l);

    protected native long nativeRemove(long l, long l1, long l2, long l3);

    protected native void nativeSubtable(long l, long l1);

    protected native double nativeSumDouble(long l, long l1, long l2, long l3, long l4);

    protected native double nativeSumFloat(long l, long l1, long l2, long l3, long l4);

    protected native long nativeSumInt(long l, long l1, long l2, long l3, long l4);

    protected native void nativeTableview(long l, long l1);

    protected native String nativeValidateQuery(long l);

    public TableQuery not()
    {
        nativeNot(nativePtr);
        queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long al[], double d)
    {
        nativeNotEqual(nativePtr, al, d);
        queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long al[], float f)
    {
        nativeNotEqual(nativePtr, al, f);
        queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long al[], long l)
    {
        nativeNotEqual(nativePtr, al, l);
        queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long al[], String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeNotEqual(nativePtr, al, s, true);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery notEqualTo(long al[], String s, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String value in query criteria must not be null.");
        } else
        {
            nativeNotEqual(nativePtr, al, s, flag);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery notEqualTo(long al[], Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        } else
        {
            nativeNotEqualDateTime(nativePtr, al, date.getTime() / 1000L);
            queryValidated = false;
            return this;
        }
    }

    public TableQuery or()
    {
        nativeOr(nativePtr);
        queryValidated = false;
        return this;
    }

    public long remove()
    {
        validateQuery();
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        return nativeRemove(nativePtr, 0L, -1L, -1L);
    }

    public long remove(long l, long l1)
    {
        validateQuery();
        if (parent.isImmutable())
        {
            throwImmutable();
        }
        return nativeRemove(nativePtr, l, l1, -1L);
    }

    public TableQuery subtable(long l)
    {
        nativeSubtable(nativePtr, l);
        queryValidated = false;
        return this;
    }

    public double sumDouble(long l)
    {
        validateQuery();
        return nativeSumDouble(nativePtr, l, 0L, -1L, -1L);
    }

    public double sumDouble(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeSumDouble(nativePtr, l, l1, l2, l3);
    }

    public double sumFloat(long l)
    {
        validateQuery();
        return nativeSumFloat(nativePtr, l, 0L, -1L, -1L);
    }

    public double sumFloat(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeSumFloat(nativePtr, l, l1, l2, l3);
    }

    public long sumInt(long l)
    {
        validateQuery();
        return nativeSumInt(nativePtr, l, 0L, -1L, -1L);
    }

    public long sumInt(long l, long l1, long l2, long l3)
    {
        validateQuery();
        return nativeSumInt(nativePtr, l, l1, l2, l3);
    }

    public TableQuery tableview(TableView tableview1)
    {
        nativeTableview(nativePtr, tableview1.nativePtr);
        return this;
    }
}
