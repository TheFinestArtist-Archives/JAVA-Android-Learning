// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.mutable;


// Referenced classes of package org.apache.commons.lang3.mutable:
//            Mutable

public class MutableFloat extends Number
    implements Comparable, Mutable
{

    private static final long serialVersionUID = 0x158f131a2L;
    private float value;

    public MutableFloat()
    {
    }

    public MutableFloat(float f)
    {
        value = f;
    }

    public MutableFloat(Number number)
    {
        value = number.floatValue();
    }

    public MutableFloat(String s)
    {
        value = Float.parseFloat(s);
    }

    public void add(float f)
    {
        value = value + f;
    }

    public void add(Number number)
    {
        value = value + number.floatValue();
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MutableFloat)obj);
    }

    public int compareTo(MutableFloat mutablefloat)
    {
        float f = mutablefloat.value;
        return Float.compare(value, f);
    }

    public void decrement()
    {
        value = value - 1.0F;
    }

    public double doubleValue()
    {
        return (double)value;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat)obj).value) == Float.floatToIntBits(value);
    }

    public float floatValue()
    {
        return value;
    }

    public Float getValue()
    {
        return Float.valueOf(value);
    }

    public volatile Object getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        return Float.floatToIntBits(value);
    }

    public void increment()
    {
        value = value + 1.0F;
    }

    public int intValue()
    {
        return (int)value;
    }

    public boolean isInfinite()
    {
        return Float.isInfinite(value);
    }

    public boolean isNaN()
    {
        return Float.isNaN(value);
    }

    public long longValue()
    {
        return (long)value;
    }

    public void setValue(float f)
    {
        value = f;
    }

    public void setValue(Number number)
    {
        value = number.floatValue();
    }

    public volatile void setValue(Object obj)
    {
        setValue((Number)obj);
    }

    public void subtract(float f)
    {
        value = value - f;
    }

    public void subtract(Number number)
    {
        value = value - number.floatValue();
    }

    public Float toFloat()
    {
        return Float.valueOf(floatValue());
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
