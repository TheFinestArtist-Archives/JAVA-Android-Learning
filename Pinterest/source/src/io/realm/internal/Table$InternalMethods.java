// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.Date;

// Referenced classes of package io.realm.internal:
//            Table, Mixed

public class this._cls0
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
        Table.access$000(Table.this, l1, l, ((Object) (aobj)));
    }

    public ()
    {
        this$0 = Table.this;
        super();
    }
}
