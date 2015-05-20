// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;

public final class Range
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final Comparator comparator;
    private transient int hashCode;
    private final Object maximum;
    private final Object minimum;
    private transient String toString;

    private Range(Object obj, Object obj1, Comparator comparator1)
    {
        if (obj == null || obj1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Elements in a range must not be null: element1=")).append(obj).append(", element2=").append(obj1).toString());
        }
        Object obj2 = comparator1;
        if (comparator1 == null)
        {
            obj2 = ComparableComparator.INSTANCE;
        }
        if (((Comparator) (obj2)).compare(obj, obj1) <= 0)
        {
            minimum = obj;
            maximum = obj1;
        } else
        {
            minimum = obj1;
            maximum = obj;
        }
        comparator = ((Comparator) (obj2));
    }

    public static Range between(Comparable comparable, Comparable comparable1)
    {
        return between(comparable, comparable1, null);
    }

    public static Range between(Object obj, Object obj1, Comparator comparator1)
    {
        return new Range(obj, obj1, comparator1);
    }

    public static Range is(Comparable comparable)
    {
        return between(comparable, comparable, null);
    }

    public static Range is(Object obj, Comparator comparator1)
    {
        return between(obj, obj, comparator1);
    }

    public final boolean contains(Object obj)
    {
        while (obj == null || comparator.compare(obj, minimum) < 0 || comparator.compare(obj, maximum) > 0) 
        {
            return false;
        }
        return true;
    }

    public final boolean containsRange(Range range)
    {
        while (range == null || !contains(range.minimum) || !contains(range.maximum)) 
        {
            return false;
        }
        return true;
    }

    public final int elementCompareTo(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Element is null");
        }
        if (isAfter(obj))
        {
            return -1;
        }
        return !isBefore(obj) ? 0 : 1;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            }
            obj = (Range)obj;
            if (!minimum.equals(((Range) (obj)).minimum) || !maximum.equals(((Range) (obj)).maximum))
            {
                return false;
            }
        }
        return true;
    }

    public final Comparator getComparator()
    {
        return comparator;
    }

    public final Object getMaximum()
    {
        return maximum;
    }

    public final Object getMinimum()
    {
        return minimum;
    }

    public final int hashCode()
    {
        int i = hashCode;
        if (hashCode == 0)
        {
            i = ((getClass().hashCode() + 629) * 37 + minimum.hashCode()) * 37 + maximum.hashCode();
            hashCode = i;
        }
        return i;
    }

    public final Range intersectionWith(Range range)
    {
        if (!isOverlappedBy(range))
        {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[] {
                range
            }));
        }
        if (equals(range))
        {
            return this;
        }
        Object obj;
        if (getComparator().compare(minimum, range.minimum) < 0)
        {
            obj = range.minimum;
        } else
        {
            obj = minimum;
        }
        if (getComparator().compare(maximum, range.maximum) < 0)
        {
            range = ((Range) (maximum));
        } else
        {
            range = ((Range) (range.maximum));
        }
        return between(obj, range, getComparator());
    }

    public final boolean isAfter(Object obj)
    {
        while (obj == null || comparator.compare(obj, minimum) >= 0) 
        {
            return false;
        }
        return true;
    }

    public final boolean isAfterRange(Range range)
    {
        if (range == null)
        {
            return false;
        } else
        {
            return isAfter(range.maximum);
        }
    }

    public final boolean isBefore(Object obj)
    {
        while (obj == null || comparator.compare(obj, maximum) <= 0) 
        {
            return false;
        }
        return true;
    }

    public final boolean isBeforeRange(Range range)
    {
        if (range == null)
        {
            return false;
        } else
        {
            return isBefore(range.minimum);
        }
    }

    public final boolean isEndedBy(Object obj)
    {
        while (obj == null || comparator.compare(obj, maximum) != 0) 
        {
            return false;
        }
        return true;
    }

    public final boolean isNaturalOrdering()
    {
        return comparator == ComparableComparator.INSTANCE;
    }

    public final boolean isOverlappedBy(Range range)
    {
        while (range == null || !range.contains(minimum) && !range.contains(maximum) && !contains(range.minimum)) 
        {
            return false;
        }
        return true;
    }

    public final boolean isStartedBy(Object obj)
    {
        while (obj == null || comparator.compare(obj, minimum) != 0) 
        {
            return false;
        }
        return true;
    }

    public final String toString()
    {
        String s = toString;
        Object obj = s;
        if (s == null)
        {
            obj = new StringBuilder(32);
            ((StringBuilder) (obj)).append('[');
            ((StringBuilder) (obj)).append(minimum);
            ((StringBuilder) (obj)).append("..");
            ((StringBuilder) (obj)).append(maximum);
            ((StringBuilder) (obj)).append(']');
            obj = ((StringBuilder) (obj)).toString();
            toString = ((String) (obj));
        }
        return ((String) (obj));
    }

    public final String toString(String s)
    {
        return String.format(s, new Object[] {
            minimum, maximum, comparator
        });
    }

    private class ComparableComparator extends Enum
        implements Comparator
    {

        private static final ComparableComparator $VALUES[];
        public static final ComparableComparator INSTANCE;

        public static ComparableComparator valueOf(String s)
        {
            return (ComparableComparator)Enum.valueOf(org/apache/commons/lang3/Range$ComparableComparator, s);
        }

        public static final ComparableComparator[] values()
        {
            return (ComparableComparator[])$VALUES.clone();
        }

        public final int compare(Object obj, Object obj1)
        {
            return ((Comparable)obj).compareTo(obj1);
        }

        static 
        {
            INSTANCE = new ComparableComparator("INSTANCE", 0);
            $VALUES = (new ComparableComparator[] {
                INSTANCE
            });
        }

        private ComparableComparator(String s, int i)
        {
            super(s, i);
        }
    }

}
