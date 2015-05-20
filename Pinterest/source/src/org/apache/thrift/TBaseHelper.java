// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class TBaseHelper
{

    private static final Comparator comparator = new NestedStructureComparator(null);

    private TBaseHelper()
    {
    }

    public static int byteBufferToByteArray(ByteBuffer bytebuffer, byte abyte0[], int i)
    {
        int j = bytebuffer.remaining();
        System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), abyte0, i, j);
        return j;
    }

    public static byte[] byteBufferToByteArray(ByteBuffer bytebuffer)
    {
        if (wrapsFullArray(bytebuffer))
        {
            return bytebuffer.array();
        } else
        {
            byte abyte0[] = new byte[bytebuffer.remaining()];
            byteBufferToByteArray(bytebuffer, abyte0, 0);
            return abyte0;
        }
    }

    public static int compareTo(byte byte0, byte byte1)
    {
        if (byte0 < byte1)
        {
            return -1;
        }
        return byte1 >= byte0 ? 0 : 1;
    }

    public static int compareTo(double d, double d1)
    {
        if (d < d1)
        {
            return -1;
        }
        return d1 >= d ? 0 : 1;
    }

    public static int compareTo(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return j >= i ? 0 : 1;
    }

    public static int compareTo(long l, long l1)
    {
        if (l < l1)
        {
            return -1;
        }
        return l1 >= l ? 0 : 1;
    }

    public static int compareTo(Comparable comparable, Comparable comparable1)
    {
        return comparable.compareTo(comparable1);
    }

    public static int compareTo(Object obj, Object obj1)
    {
        if (obj instanceof Comparable)
        {
            return compareTo((Comparable)obj, (Comparable)obj1);
        }
        if (obj instanceof List)
        {
            return compareTo((List)obj, (List)obj1);
        }
        if (obj instanceof Set)
        {
            return compareTo((Set)obj, (Set)obj1);
        }
        if (obj instanceof Map)
        {
            return compareTo((Map)obj, (Map)obj1);
        }
        if (obj instanceof byte[])
        {
            return compareTo((byte[])obj, (byte[])obj1);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot compare objects of type ")).append(obj.getClass()).toString());
        }
    }

    public static int compareTo(String s, String s1)
    {
        return s.compareTo(s1);
    }

    public static int compareTo(List list, List list1)
    {
        int j;
        boolean flag;
        flag = false;
        j = compareTo(list.size(), list1.size());
        if (j == 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int i = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= list.size())
            {
                continue;
            }
            j = comparator.compare(list.get(i), list1.get(i));
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int compareTo(Map map, Map map1)
    {
        int i = compareTo(map.size(), map1.size());
        if (i != 0)
        {
            return i;
        }
        TreeMap treemap = new TreeMap(comparator);
        treemap.putAll(map);
        map = treemap.entrySet().iterator();
        treemap = new TreeMap(comparator);
        treemap.putAll(map1);
        for (map1 = treemap.entrySet().iterator(); map.hasNext() && map1.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            java.util.Map.Entry entry1 = (java.util.Map.Entry)map1.next();
            int j = comparator.compare(entry.getKey(), entry1.getKey());
            if (j != 0)
            {
                return j;
            }
            j = comparator.compare(entry.getValue(), entry1.getValue());
            if (j != 0)
            {
                return j;
            }
        }

        return 0;
    }

    public static int compareTo(Set set, Set set1)
    {
        int i = compareTo(set.size(), set1.size());
        if (i != 0)
        {
            return i;
        }
        TreeSet treeset = new TreeSet(comparator);
        treeset.addAll(set);
        set = new TreeSet(comparator);
        set.addAll(set1);
        set1 = treeset.iterator();
        for (set = set.iterator(); set1.hasNext() && set.hasNext();)
        {
            int j = comparator.compare(set1.next(), set.next());
            if (j != 0)
            {
                return j;
            }
        }

        return 0;
    }

    public static int compareTo(short word0, short word1)
    {
        if (word0 < word1)
        {
            return -1;
        }
        return word1 >= word0 ? 0 : 1;
    }

    public static int compareTo(boolean flag, boolean flag1)
    {
        return Boolean.valueOf(flag).compareTo(Boolean.valueOf(flag1));
    }

    public static int compareTo(byte abyte0[], byte abyte1[])
    {
        int j;
        boolean flag;
        flag = false;
        j = compareTo(abyte0.length, abyte1.length);
        if (j == 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int i = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= abyte0.length)
            {
                continue;
            }
            j = compareTo(abyte0[i], abyte1[i]);
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static ByteBuffer copyBinary(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            return null;
        }
        ByteBuffer bytebuffer1 = ByteBuffer.wrap(new byte[bytebuffer.remaining()]);
        if (bytebuffer.hasArray())
        {
            System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer1.array(), 0, bytebuffer.remaining());
            return bytebuffer1;
        } else
        {
            bytebuffer.slice().get(bytebuffer1.array());
            return bytebuffer1;
        }
    }

    public static byte[] copyBinary(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static String paddedByteString(byte byte0)
    {
        return Integer.toHexString((byte0 | 0x100) & 0x1ff).toUpperCase().substring(1);
    }

    public static ByteBuffer rightSize(ByteBuffer bytebuffer)
    {
        ByteBuffer bytebuffer1;
        if (bytebuffer == null)
        {
            bytebuffer1 = null;
        } else
        {
            bytebuffer1 = bytebuffer;
            if (!wrapsFullArray(bytebuffer))
            {
                return ByteBuffer.wrap(byteBufferToByteArray(bytebuffer));
            }
        }
        return bytebuffer1;
    }

    public static void toString(ByteBuffer bytebuffer, StringBuilder stringbuilder)
    {
        byte abyte0[] = bytebuffer.array();
        int i = bytebuffer.arrayOffset();
        int k = i + bytebuffer.position();
        int l = bytebuffer.limit() + i;
        int j;
        if (l - k > 128)
        {
            i = k + 128;
        } else
        {
            i = l;
        }
        for (j = k; j < i; j++)
        {
            if (j > k)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(paddedByteString(abyte0[j]));
        }

        if (l != i)
        {
            stringbuilder.append("...");
        }
    }

    public static boolean wrapsFullArray(ByteBuffer bytebuffer)
    {
        return bytebuffer.hasArray() && bytebuffer.position() == 0 && bytebuffer.arrayOffset() == 0 && bytebuffer.remaining() == bytebuffer.capacity();
    }


    private class NestedStructureComparator
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            if (obj == null && obj1 == null)
            {
                return 0;
            }
            if (obj == null)
            {
                return -1;
            }
            if (obj1 == null)
            {
                return 1;
            }
            if (obj instanceof List)
            {
                return TBaseHelper.compareTo((List)obj, (List)obj1);
            }
            if (obj instanceof Set)
            {
                return TBaseHelper.compareTo((Set)obj, (Set)obj1);
            }
            if (obj instanceof Map)
            {
                return TBaseHelper.compareTo((Map)obj, (Map)obj1);
            }
            if (obj instanceof byte[])
            {
                return TBaseHelper.compareTo((byte[])obj, (byte[])obj1);
            } else
            {
                return TBaseHelper.compareTo((Comparable)obj, (Comparable)obj1);
            }
        }

        private NestedStructureComparator()
        {
        }

        NestedStructureComparator(_cls1 _pcls1)
        {
            this();
        }
    }

}
