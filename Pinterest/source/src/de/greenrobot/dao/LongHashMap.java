// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import java.util.Arrays;

// Referenced classes of package de.greenrobot.dao:
//            DaoLog

public final class LongHashMap
{

    private int capacity;
    private int size;
    private Entry table[];
    private int threshold;

    public LongHashMap()
    {
        this(16);
    }

    public LongHashMap(int i)
    {
        capacity = i;
        threshold = (i * 4) / 3;
        table = new Entry[i];
    }

    public final void clear()
    {
        size = 0;
        Arrays.fill(table, null);
    }

    public final boolean containsKey(long l)
    {
        int i = (int)(l >>> 32);
        int j = (int)l;
        int k = capacity;
        Entry entry = table[((i ^ j) & 0x7fffffff) % k];
        do
        {
            if (entry == null)
            {
                return false;
            }
            if (entry.key == l)
            {
                return true;
            }
            entry = entry.next;
        } while (true);
    }

    public final Object get(long l)
    {
        int i = (int)(l >>> 32);
        int j = (int)l;
        int k = capacity;
        Entry entry = table[((i ^ j) & 0x7fffffff) % k];
        do
        {
            if (entry == null)
            {
                return null;
            }
            if (entry.key == l)
            {
                return entry.value;
            }
            entry = entry.next;
        } while (true);
    }

    public final void logStats()
    {
        Entry aentry[];
        int i;
        int j;
        int k;
        aentry = table;
        k = aentry.length;
        i = 0;
        j = 0;
_L2:
        if (i >= k)
        {
            DaoLog.d((new StringBuilder("load: ")).append((float)size / (float)capacity).append(", size: ").append(size).append(", capa: ").append(capacity).append(", collisions: ").append(j).append(", collision ratio: ").append((float)j / (float)size).toString());
            return;
        }
        Entry entry = aentry[i];
        do
        {
label0:
            {
                if (entry != null && entry.next != null)
                {
                    break label0;
                }
                i++;
            }
            if (true)
            {
                continue;
            }
            j++;
            entry = entry.next;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final Object put(long l, Object obj)
    {
        int i = (((int)(l >>> 32) ^ (int)l) & 0x7fffffff) % capacity;
        Entry entry1 = table[i];
        Entry entry = entry1;
        do
        {
            if (entry == null)
            {
                table[i] = new Entry(l, obj, entry1);
                size = size + 1;
                if (size > threshold)
                {
                    setCapacity(capacity * 2);
                }
                return null;
            }
            if (entry.key == l)
            {
                Object obj1 = entry.value;
                entry.value = obj;
                return obj1;
            }
            entry = entry.next;
        } while (true);
    }

    public final Object remove(long l)
    {
        int i = (((int)(l >>> 32) ^ (int)l) & 0x7fffffff) % capacity;
        Entry entry = table[i];
        Entry entry1 = null;
        do
        {
            if (entry == null)
            {
                return null;
            }
            Entry entry2 = entry.next;
            if (entry.key == l)
            {
                if (entry1 == null)
                {
                    table[i] = entry2;
                } else
                {
                    entry1.next = entry2;
                }
                size = size - 1;
                return entry.value;
            }
            entry1 = entry;
            entry = entry2;
        } while (true);
    }

    public final void reserveRoom(int i)
    {
        setCapacity((i * 5) / 3);
    }

    public final void setCapacity(int i)
    {
        Entry aentry[];
        int j;
        int k;
        aentry = new Entry[i];
        k = table.length;
        j = 0;
_L2:
        if (j >= k)
        {
            table = aentry;
            capacity = i;
            threshold = (i * 4) / 3;
            return;
        }
        Entry entry = table[j];
        do
        {
label0:
            {
                if (entry != null)
                {
                    break label0;
                }
                j++;
            }
            if (true)
            {
                continue;
            }
            long l1 = entry.key;
            int l = (((int)(l1 >>> 32) ^ (int)l1) & 0x7fffffff) % i;
            Entry entry1 = entry.next;
            entry.next = aentry[l];
            aentry[l] = entry;
            entry = entry1;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final int size()
    {
        return size;
    }

    private class Entry
    {

        final long key;
        Entry next;
        Object value;

        Entry(long l, Object obj, Entry entry)
        {
            key = l;
            value = obj;
            next = entry;
        }
    }

}
