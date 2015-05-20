// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.nio.ByteBuffer;
import java.util.Date;

// Referenced classes of package io.realm.internal:
//            Mixed

public final class ColumnType extends Enum
{

    private static final ColumnType $VALUES[];
    public static final ColumnType BINARY;
    public static final ColumnType BOOLEAN;
    public static final ColumnType DATE;
    public static final ColumnType DOUBLE;
    public static final ColumnType FLOAT;
    public static final ColumnType INTEGER;
    public static final ColumnType LINK;
    public static final ColumnType LINK_LIST;
    public static final ColumnType MIXED;
    public static final ColumnType STRING;
    public static final ColumnType TABLE;
    private static ColumnType byNativeValue[];
    private final int nativeValue;

    private ColumnType(String s, int i, int j)
    {
        super(s, i);
        nativeValue = j;
    }

    static ColumnType fromNativeValue(int i)
    {
        if (i >= 0 && i < byNativeValue.length)
        {
            ColumnType columntype = byNativeValue[i];
            if (columntype != null)
            {
                return columntype;
            }
        }
        throw new IllegalArgumentException("Invalid native column type");
    }

    public static ColumnType valueOf(String s)
    {
        return (ColumnType)Enum.valueOf(io/realm/internal/ColumnType, s);
    }

    public static ColumnType[] values()
    {
        return (ColumnType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return nativeValue;
    }

    public final boolean matchObject(Object obj)
    {
        boolean flag = false;
        nativeValue;
        JVM INSTR tableswitch 0 10: default 64
    //                   0 91
    //                   1 123
    //                   2 128
    //                   3 64
    //                   4 133
    //                   5 149
    //                   6 162
    //                   7 259
    //                   8 64
    //                   9 264
    //                   10 269;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L1 _L9 _L10
_L1:
        throw new RuntimeException(String.format("Invalid index (%d) in ColumnType.", new Object[] {
            Integer.valueOf(nativeValue)
        }));
_L2:
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte))
        {
            flag = true;
        }
_L12:
        return flag;
_L3:
        return obj instanceof Boolean;
_L4:
        return obj instanceof String;
_L5:
        if (!(obj instanceof byte[]) && !(obj instanceof ByteBuffer)) goto _L12; else goto _L11
_L11:
        return true;
_L6:
        if (obj != null && !(obj instanceof Object[][])) goto _L12; else goto _L13
_L13:
        return true;
_L7:
        if (!(obj instanceof Mixed) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof byte[]) && !(obj instanceof ByteBuffer) && obj != null && !(obj instanceof Object[][]) && !(obj instanceof Date)) goto _L12; else goto _L14
_L14:
        return true;
_L8:
        return obj instanceof Date;
_L9:
        return obj instanceof Float;
_L10:
        return obj instanceof Double;
    }

    static 
    {
        int i = 0;
        BOOLEAN = new ColumnType("BOOLEAN", 0, 1);
        INTEGER = new ColumnType("INTEGER", 1, 0);
        FLOAT = new ColumnType("FLOAT", 2, 9);
        DOUBLE = new ColumnType("DOUBLE", 3, 10);
        STRING = new ColumnType("STRING", 4, 2);
        BINARY = new ColumnType("BINARY", 5, 4);
        DATE = new ColumnType("DATE", 6, 7);
        TABLE = new ColumnType("TABLE", 7, 5);
        MIXED = new ColumnType("MIXED", 8, 6);
        LINK = new ColumnType("LINK", 9, 12);
        LINK_LIST = new ColumnType("LINK_LIST", 10, 13);
        $VALUES = (new ColumnType[] {
            BOOLEAN, INTEGER, FLOAT, DOUBLE, STRING, BINARY, DATE, TABLE, MIXED, LINK, 
            LINK_LIST
        });
        byNativeValue = new ColumnType[14];
        for (ColumnType acolumntype[] = values(); i < acolumntype.length; i++)
        {
            int j = acolumntype[i].nativeValue;
            byNativeValue[j] = acolumntype[i];
        }

    }
}
