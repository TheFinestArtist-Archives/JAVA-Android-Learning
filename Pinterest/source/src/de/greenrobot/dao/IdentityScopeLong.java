// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package de.greenrobot.dao:
//            IdentityScope, LongHashMap

public class IdentityScopeLong
    implements IdentityScope
{

    private final ReentrantLock lock = new ReentrantLock();
    private final LongHashMap map = new LongHashMap();

    public IdentityScopeLong()
    {
    }

    public void clear()
    {
        lock.lock();
        map.clear();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public boolean detach(Long long1, Object obj)
    {
        lock.lock();
        if (get(long1) != obj || obj == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        remove(long1);
        lock.unlock();
        return true;
        lock.unlock();
        return false;
        long1;
        lock.unlock();
        throw long1;
    }

    public volatile boolean detach(Object obj, Object obj1)
    {
        return detach((Long)obj, (Object)obj1);
    }

    public Object get(Long long1)
    {
        return get2(long1.longValue());
    }

    public volatile Object get(Object obj)
    {
        return get((Long)obj);
    }

    public Object get2(long l)
    {
        lock.lock();
        Reference reference = (Reference)map.get(l);
        lock.unlock();
        Exception exception;
        if (reference != null)
        {
            return reference.get();
        } else
        {
            return null;
        }
        exception;
        lock.unlock();
        throw exception;
    }

    public Object get2NoLock(long l)
    {
        Reference reference = (Reference)map.get(l);
        if (reference != null)
        {
            return reference.get();
        } else
        {
            return null;
        }
    }

    public Object getNoLock(Long long1)
    {
        return get2NoLock(long1.longValue());
    }

    public volatile Object getNoLock(Object obj)
    {
        return getNoLock((Long)obj);
    }

    public void lock()
    {
        lock.lock();
    }

    public void put(Long long1, Object obj)
    {
        put2(long1.longValue(), obj);
    }

    public volatile void put(Object obj, Object obj1)
    {
        put((Long)obj, (Object)obj1);
    }

    public void put2(long l, Object obj)
    {
        lock.lock();
        map.put(l, new WeakReference(obj));
        lock.unlock();
        return;
        obj;
        lock.unlock();
        throw obj;
    }

    public void put2NoLock(long l, Object obj)
    {
        map.put(l, new WeakReference(obj));
    }

    public void putNoLock(Long long1, Object obj)
    {
        put2NoLock(long1.longValue(), obj);
    }

    public volatile void putNoLock(Object obj, Object obj1)
    {
        putNoLock((Long)obj, (Object)obj1);
    }

    public void remove(Iterable iterable)
    {
        lock.lock();
        iterable = iterable.iterator();
_L1:
        boolean flag = iterable.hasNext();
        if (!flag)
        {
            lock.unlock();
            return;
        }
        Long long1 = (Long)iterable.next();
        map.remove(long1.longValue());
          goto _L1
        iterable;
        lock.unlock();
        throw iterable;
    }

    public void remove(Long long1)
    {
        lock.lock();
        map.remove(long1.longValue());
        lock.unlock();
        return;
        long1;
        lock.unlock();
        throw long1;
    }

    public volatile void remove(Object obj)
    {
        remove((Long)obj);
    }

    public void reserveRoom(int i)
    {
        map.reserveRoom(i);
    }

    public void unlock()
    {
        lock.unlock();
    }
}
