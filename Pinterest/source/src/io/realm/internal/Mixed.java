// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.nio.ByteBuffer;
import java.util.Date;

// Referenced classes of package io.realm.internal:
//            ColumnType, IllegalMixedTypeException

public class Mixed
{

    static final boolean $assertionsDisabled;
    public static final int BINARY_TYPE_BYTE_ARRAY = 0;
    public static final int BINARY_TYPE_BYTE_BUFFER = 1;
    private Object value;

    public Mixed(double d)
    {
        value = Double.valueOf(d);
    }

    public Mixed(float f)
    {
        value = Float.valueOf(f);
    }

    public Mixed(long l)
    {
        value = Long.valueOf(l);
    }

    public Mixed(ColumnType columntype)
    {
        if (columntype == null || columntype == ColumnType.TABLE)
        {
            throw new AssertionError();
        } else
        {
            value = null;
            return;
        }
    }

    public Mixed(String s)
    {
        if (!$assertionsDisabled && s == null)
        {
            throw new AssertionError();
        } else
        {
            value = s;
            return;
        }
    }

    public Mixed(ByteBuffer bytebuffer)
    {
        if (!$assertionsDisabled && bytebuffer == null)
        {
            throw new AssertionError();
        } else
        {
            value = bytebuffer;
            return;
        }
    }

    public Mixed(Date date)
    {
        if (!$assertionsDisabled && date == null)
        {
            throw new AssertionError();
        } else
        {
            value = date;
            return;
        }
    }

    public Mixed(boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        value = boolean1;
    }

    public Mixed(byte abyte0[])
    {
        if (!$assertionsDisabled && abyte0 == null)
        {
            throw new AssertionError();
        } else
        {
            value = abyte0;
            return;
        }
    }

    public static Mixed mixedValue(Object obj)
    {
        if (obj instanceof String)
        {
            return new Mixed((String)obj);
        }
        if (obj instanceof Long)
        {
            return new Mixed(((Long)obj).longValue());
        }
        if (obj instanceof Integer)
        {
            return new Mixed(((Integer)obj).longValue());
        }
        if (obj instanceof Boolean)
        {
            return new Mixed(((Boolean)obj).booleanValue());
        }
        if (obj instanceof Float)
        {
            return new Mixed(((Float)obj).floatValue());
        }
        if (obj instanceof Double)
        {
            return new Mixed(((Double)obj).doubleValue());
        }
        if (obj instanceof Date)
        {
            return new Mixed((Date)obj);
        }
        if (obj instanceof ByteBuffer)
        {
            return new Mixed((ByteBuffer)obj);
        }
        if (obj instanceof byte[])
        {
            return new Mixed((byte[])obj);
        }
        if (obj instanceof Mixed)
        {
            return (Mixed)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("The value is of unsupported type: ")).append(obj.getClass()).toString());
        }
    }

    public boolean equals(Object obj)
    {
_L2:
        return false;
        if (obj == null || !(obj instanceof Mixed)) goto _L2; else goto _L1
_L1:
        obj = (Mixed)obj;
        if (value != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Mixed) (obj)).value == null)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
        if (!getType().equals(((Mixed) (obj)).getType())) goto _L2; else goto _L3
_L3:
        if (value instanceof byte[])
        {
            if (!(((Mixed) (obj)).value instanceof byte[]))
            {
                continue; /* Loop/switch isn't completed */
            }
            byte abyte0[] = (byte[])value;
            obj = (byte[])((Mixed) (obj)).value;
            if (abyte0.length != obj.length)
            {
                continue; /* Loop/switch isn't completed */
            }
            for (int i = 0; i < abyte0.length; i++)
            {
                if (abyte0[i] != obj[i])
                {
                    continue; /* Loop/switch isn't completed */
                }
            }

            return true;
        }
        if (!(value instanceof ByteBuffer))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        ByteBuffer bytebuffer = (ByteBuffer)value;
        obj = (ByteBuffer)((Mixed) (obj)).value;
        if (bytebuffer.capacity() != ((ByteBuffer) (obj)).capacity())
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = 0;
        do
        {
            if (j >= bytebuffer.capacity())
            {
                break; /* Loop/switch isn't completed */
            }
            if (bytebuffer.get(j) != ((ByteBuffer) (obj)).get(j))
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        if (true) goto _L2; else goto _L4
_L4:
        return true;
        return value.equals(((Mixed) (obj)).value);
    }

    public byte[] getBinaryByteArray()
    {
        if (!(value instanceof byte[]))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a byte[] from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return (byte[])value;
        }
    }

    public int getBinaryType()
    {
        if (value instanceof byte[])
        {
            return 0;
        }
        return !(value instanceof ByteBuffer) ? -1 : 1;
    }

    public ByteBuffer getBinaryValue()
    {
        if (!(value instanceof ByteBuffer))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a ByteBuffer from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return (ByteBuffer)value;
        }
    }

    public boolean getBooleanValue()
    {
        if (!(value instanceof Boolean))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a boolean from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return ((Boolean)value).booleanValue();
        }
    }

    protected long getDateTimeValue()
    {
        return getDateValue().getTime();
    }

    public Date getDateValue()
    {
        if (!(value instanceof Date))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a Date from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return (Date)value;
        }
    }

    public double getDoubleValue()
    {
        if (!(value instanceof Double))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a double from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return ((Double)value).doubleValue();
        }
    }

    public float getFloatValue()
    {
        if (!(value instanceof Float))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a float from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return ((Float)value).floatValue();
        }
    }

    public long getLongValue()
    {
        if (!(value instanceof Long))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a long from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return ((Long)value).longValue();
        }
    }

    public String getReadableValue()
    {
        Object obj = getType();
        int i = _cls1..SwitchMap.io.realm.internal.ColumnType[((ColumnType) (obj)).ordinal()];
        i;
        JVM INSTR tableswitch 1 8: default 60
    //                   1 63
    //                   2 66
    //                   3 74
    //                   4 82
    //                   5 90
    //                   6 98
    //                   7 106
    //                   8 116;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return "ERROR";
_L2:
        return "Binary";
_L3:
        return String.valueOf(getBooleanValue());
_L4:
        return String.valueOf(getDateValue());
_L5:
        return String.valueOf(getDoubleValue());
_L6:
        return String.valueOf(getFloatValue());
_L7:
        return String.valueOf(getLongValue());
_L8:
        obj = String.valueOf(getStringValue());
        return ((String) (obj));
_L9:
        return "Subtable";
        Exception exception;
        exception;
        if (true) goto _L1; else goto _L10
_L10:
    }

    public String getStringValue()
    {
        if (!(value instanceof String))
        {
            throw new IllegalMixedTypeException((new StringBuilder("Can't get a String from a Mixed containg a ")).append(getType()).toString());
        } else
        {
            return (String)value;
        }
    }

    public ColumnType getType()
    {
        if (value == null)
        {
            return ColumnType.TABLE;
        }
        if (value instanceof String)
        {
            return ColumnType.STRING;
        }
        if (value instanceof Long)
        {
            return ColumnType.INTEGER;
        }
        if (value instanceof Float)
        {
            return ColumnType.FLOAT;
        }
        if (value instanceof Double)
        {
            return ColumnType.DOUBLE;
        }
        if (value instanceof Date)
        {
            return ColumnType.DATE;
        }
        if (value instanceof Boolean)
        {
            return ColumnType.BOOLEAN;
        }
        if ((value instanceof ByteBuffer) || (value instanceof byte[]))
        {
            return ColumnType.BINARY;
        } else
        {
            throw new IllegalStateException("Unknown column type!");
        }
    }

    public Object getValue()
    {
        return value;
    }

    static 
    {
        boolean flag;
        if (!io/realm/internal/Mixed.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class _cls1
    {

        static final int $SwitchMap$io$realm$internal$ColumnType[];

        static 
        {
            $SwitchMap$io$realm$internal$ColumnType = new int[ColumnType.values().length];
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.BINARY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.BOOLEAN.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.DATE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.DOUBLE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.FLOAT.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.INTEGER.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.STRING.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.TABLE.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$io$realm$internal$ColumnType[ColumnType.MIXED.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
