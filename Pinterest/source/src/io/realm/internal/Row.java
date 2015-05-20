// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.Date;

// Referenced classes of package io.realm.internal:
//            Context, ColumnType, LinkView, Table, 
//            Mixed

public class Row
{

    private final Context context;
    protected long nativePtr;
    private final Table parent;

    Row(Context context1, Table table, long l)
    {
        context = context1;
        parent = table;
        nativePtr = l;
    }

    protected static native void nativeClose(long l);

    private native long nativeGetLinkView(long l, long l1);

    protected void finalize()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                context.asyncDisposeRow(nativePtr);
                nativePtr = 0L;
            }
        }
        nativeClose(nativePtr);
        nativePtr = 0L;
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public byte[] getBinaryByteArray(long l)
    {
        return nativeGetByteArray(nativePtr, l);
    }

    public boolean getBoolean(long l)
    {
        return nativeGetBoolean(nativePtr, l);
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

    public Date getDate(long l)
    {
        return new Date(nativeGetDateTime(nativePtr, l) * 1000L);
    }

    public double getDouble(long l)
    {
        return nativeGetDouble(nativePtr, l);
    }

    public float getFloat(long l)
    {
        return nativeGetFloat(nativePtr, l);
    }

    public long getIndex()
    {
        return nativeGetIndex(nativePtr);
    }

    public long getLink(long l)
    {
        return nativeGetLink(nativePtr, l);
    }

    public LinkView getLinkList(long l)
    {
        long l1 = nativeGetLinkView(nativePtr, l);
        return new LinkView(context, parent, l, l1);
    }

    public long getLong(long l)
    {
        return nativeGetLong(nativePtr, l);
    }

    public Mixed getMixed(long l)
    {
        return nativeGetMixed(nativePtr, l);
    }

    public ColumnType getMixedType(long l)
    {
        return ColumnType.fromNativeValue(nativeGetMixedType(nativePtr, l));
    }

    public String getString(long l)
    {
        return nativeGetString(nativePtr, l);
    }

    public Table getTable()
    {
        return parent;
    }

    public boolean isAttached()
    {
        return nativePtr != 0L && nativeIsAttached(nativePtr);
    }

    public boolean isNullLink(long l)
    {
        return nativeIsNullLink(nativePtr, l);
    }

    protected native boolean nativeGetBoolean(long l, long l1);

    protected native byte[] nativeGetByteArray(long l, long l1);

    protected native long nativeGetColumnCount(long l);

    protected native long nativeGetColumnIndex(long l, String s);

    protected native String nativeGetColumnName(long l, long l1);

    protected native int nativeGetColumnType(long l, long l1);

    protected native long nativeGetDateTime(long l, long l1);

    protected native double nativeGetDouble(long l, long l1);

    protected native float nativeGetFloat(long l, long l1);

    protected native long nativeGetIndex(long l);

    protected native long nativeGetLink(long l, long l1);

    protected native long nativeGetLong(long l, long l1);

    protected native Mixed nativeGetMixed(long l, long l1);

    protected native int nativeGetMixedType(long l, long l1);

    protected native String nativeGetString(long l, long l1);

    protected native boolean nativeIsAttached(long l);

    protected native boolean nativeIsNullLink(long l, long l1);

    protected native void nativeNullifyLink(long l, long l1);

    protected native void nativeSetBoolean(long l, long l1, boolean flag);

    protected native void nativeSetByteArray(long l, long l1, byte abyte0[]);

    protected native void nativeSetDate(long l, long l1, long l2);

    protected native void nativeSetDouble(long l, long l1, double d);

    protected native void nativeSetFloat(long l, long l1, float f);

    protected native void nativeSetLink(long l, long l1, long l2);

    protected native void nativeSetLong(long l, long l1, long l2);

    protected native void nativeSetMixed(long l, long l1, Mixed mixed);

    protected native void nativeSetString(long l, long l1, String s);

    public void nullifyLink(long l)
    {
        parent.checkImmutable();
        nativeNullifyLink(nativePtr, l);
    }

    public void setBinaryByteArray(long l, byte abyte0[])
    {
        parent.checkImmutable();
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Null array is not allowed");
        } else
        {
            nativeSetByteArray(nativePtr, l, abyte0);
            return;
        }
    }

    public void setBoolean(long l, boolean flag)
    {
        parent.checkImmutable();
        nativeSetBoolean(nativePtr, l, flag);
    }

    public void setDate(long l, Date date)
    {
        parent.checkImmutable();
        if (date == null)
        {
            throw new IllegalArgumentException("Null Date is not allowed.");
        }
        long l1 = date.getTime() / 1000L;
        if (l1 >= 0x7fffffffL || l1 <= 0xffffffff80000000L)
        {
            throw new IllegalArgumentException("Date/timestamp is outside valid range");
        } else
        {
            nativeSetDate(nativePtr, l, l1);
            return;
        }
    }

    public void setDouble(long l, double d)
    {
        parent.checkImmutable();
        nativeSetDouble(nativePtr, l, d);
    }

    public void setFloat(long l, float f)
    {
        parent.checkImmutable();
        nativeSetFloat(nativePtr, l, f);
    }

    public void setLink(long l, long l1)
    {
        parent.checkImmutable();
        nativeSetLink(nativePtr, l, l1);
    }

    public void setLong(long l, long l1)
    {
        parent.checkImmutable();
        getTable().checkIntValueIsLegal(l, getIndex(), l1);
        nativeSetLong(nativePtr, l, l1);
    }

    public void setMixed(long l, Mixed mixed)
    {
        parent.checkImmutable();
        if (mixed == null)
        {
            throw new IllegalArgumentException("Null data is not allowed");
        } else
        {
            nativeSetMixed(nativePtr, l, mixed);
            return;
        }
    }

    public void setString(long l, String s)
    {
        parent.checkImmutable();
        getTable().checkStringValueIsLegal(l, getIndex(), s);
        nativeSetString(nativePtr, l, s);
    }
}
