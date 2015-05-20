// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.pool;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.concurrent.FutureCallback;

// Referenced classes of package org.apache.http.pool:
//            ConnPool, ConnPoolControl, RouteSpecificPool, PoolEntry, 
//            ConnFactory, PoolEntryFuture, PoolStats

public abstract class AbstractConnPool
    implements ConnPool, ConnPoolControl
{

    private final LinkedList available;
    private final ConnFactory connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set leased;
    private final Lock lock;
    private final Map maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList pending;
    private final Map routeToPool;

    public AbstractConnPool(ConnFactory connfactory, int i, int j)
    {
        if (connfactory == null)
        {
            throw new IllegalArgumentException("Connection factory may not null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max per route value may not be negative or zero");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("Max total value may not be negative or zero");
        } else
        {
            lock = new ReentrantLock();
            connFactory = connfactory;
            routeToPool = new HashMap();
            leased = new HashSet();
            available = new LinkedList();
            pending = new LinkedList();
            maxPerRoute = new HashMap();
            defaultMaxPerRoute = i;
            maxTotal = j;
            return;
        }
    }

    private int getMax(Object obj)
    {
        obj = (Integer)maxPerRoute.get(obj);
        if (obj != null)
        {
            return ((Integer) (obj)).intValue();
        } else
        {
            return defaultMaxPerRoute;
        }
    }

    private RouteSpecificPool getPool(final Object final_obj)
    {
        RouteSpecificPool routespecificpool = (RouteSpecificPool)routeToPool.get(final_obj);
        Object obj = routespecificpool;
        if (routespecificpool == null)
        {
            obj = new _cls1(final_obj);
            routeToPool.put(final_obj, obj);
        }
        return ((RouteSpecificPool) (obj));
    }

    private PoolEntry getPoolEntryBlocking(Object obj, Object obj1, long l, TimeUnit timeunit, PoolEntryFuture poolentryfuture)
    {
        Date date;
        date = null;
        if (l > 0L)
        {
            date = new Date(System.currentTimeMillis() + timeunit.toMillis(l));
        }
        lock.lock();
        RouteSpecificPool routespecificpool = getPool(obj);
        timeunit = null;
_L7:
        if (timeunit != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (isShutDown)
        {
            throw new IllegalStateException("Connection pool shut down");
        }
        break MISSING_BLOCK_LABEL_81;
        obj;
        lock.unlock();
        throw obj;
_L2:
        PoolEntry poolentry = routespecificpool.getFree(obj1);
        if (poolentry == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!poolentry.isClosed() && !poolentry.isExpired(System.currentTimeMillis()))
        {
            break; /* Loop/switch isn't completed */
        }
        poolentry.close();
        available.remove(poolentry);
        routespecificpool.free(poolentry, false);
        if (true) goto _L2; else goto _L1
_L1:
        if (poolentry == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        available.remove(poolentry);
        leased.add(poolentry);
        lock.unlock();
        return poolentry;
        int j;
        int k;
        j = getMax(obj);
        k = Math.max(0, (routespecificpool.getAllocatedCount() + 1) - j);
        if (k <= 0) goto _L4; else goto _L3
_L3:
        int i = 0;
_L5:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        timeunit = routespecificpool.getLastUsed();
        if (timeunit == null)
        {
            break; /* Loop/switch isn't completed */
        }
        timeunit.close();
        available.remove(timeunit);
        routespecificpool.remove(timeunit);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (routespecificpool.getAllocatedCount() >= j)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        i = leased.size();
        i = Math.max(maxTotal - i, 0);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        if (available.size() > i - 1 && !available.isEmpty())
        {
            obj1 = (PoolEntry)available.removeLast();
            ((PoolEntry) (obj1)).close();
            getPool(((PoolEntry) (obj1)).getRoute()).remove(((PoolEntry) (obj1)));
        }
        obj = routespecificpool.add(connFactory.create(obj));
        leased.add(obj);
        lock.unlock();
        return ((PoolEntry) (obj));
        boolean flag;
        routespecificpool.queue(poolentryfuture);
        pending.add(poolentryfuture);
        flag = poolentryfuture.await(date);
        routespecificpool.unqueue(poolentryfuture);
        pending.remove(poolentryfuture);
        timeunit = poolentry;
        if (flag) goto _L7; else goto _L6
_L6:
        timeunit = poolentry;
        if (date == null) goto _L7; else goto _L8
_L8:
        timeunit = poolentry;
        if (date.getTime() > System.currentTimeMillis()) goto _L7; else goto _L9
_L9:
        throw new TimeoutException("Timeout waiting for connection");
        obj;
        routespecificpool.unqueue(poolentryfuture);
        pending.remove(poolentryfuture);
        throw obj;
    }

    private void notifyPending(RouteSpecificPool routespecificpool)
    {
        routespecificpool = routespecificpool.nextPending();
        if (routespecificpool != null)
        {
            pending.remove(routespecificpool);
        } else
        {
            routespecificpool = (PoolEntryFuture)pending.poll();
        }
        if (routespecificpool != null)
        {
            routespecificpool.wakeup();
        }
    }

    public void closeExpired()
    {
        long l;
        l = System.currentTimeMillis();
        lock.lock();
        Iterator iterator = available.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PoolEntry poolentry = (PoolEntry)iterator.next();
            if (poolentry.isExpired(l))
            {
                poolentry.close();
                RouteSpecificPool routespecificpool = getPool(poolentry.getRoute());
                routespecificpool.remove(poolentry);
                iterator.remove();
                notifyPending(routespecificpool);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_95;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
        lock.unlock();
        return;
    }

    public void closeIdle(long l, TimeUnit timeunit)
    {
        long l1;
        l1 = 0L;
        if (timeunit == null)
        {
            throw new IllegalArgumentException("Time unit must not be null.");
        }
        l = timeunit.toMillis(l);
        if (l < 0L)
        {
            l = l1;
        }
        l1 = System.currentTimeMillis();
        lock.lock();
        timeunit = available.iterator();
        do
        {
            if (!timeunit.hasNext())
            {
                break;
            }
            PoolEntry poolentry = (PoolEntry)timeunit.next();
            if (poolentry.getUpdated() <= l1 - l)
            {
                poolentry.close();
                RouteSpecificPool routespecificpool = getPool(poolentry.getRoute());
                routespecificpool.remove(poolentry);
                timeunit.remove();
                notifyPending(routespecificpool);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_139;
        timeunit;
        lock.unlock();
        throw timeunit;
        lock.unlock();
        return;
    }

    protected abstract PoolEntry createEntry(Object obj, Object obj1);

    public int getDefaultMaxPerRoute()
    {
        lock.lock();
        int i = defaultMaxPerRoute;
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public int getMaxPerRoute(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Route may not be null");
        }
        lock.lock();
        int i = getMax(obj);
        lock.unlock();
        return i;
        obj;
        lock.unlock();
        throw obj;
    }

    public int getMaxTotal()
    {
        lock.lock();
        int i = maxTotal;
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public PoolStats getStats(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Route may not be null");
        }
        lock.lock();
        RouteSpecificPool routespecificpool = getPool(obj);
        obj = new PoolStats(routespecificpool.getLeasedCount(), routespecificpool.getPendingCount(), routespecificpool.getAvailableCount(), getMax(obj));
        lock.unlock();
        return ((PoolStats) (obj));
        obj;
        lock.unlock();
        throw obj;
    }

    public PoolStats getTotalStats()
    {
        lock.lock();
        PoolStats poolstats = new PoolStats(leased.size(), pending.size(), available.size(), maxTotal);
        lock.unlock();
        return poolstats;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public boolean isShutdown()
    {
        return isShutDown;
    }

    public Future lease(Object obj, Object obj1)
    {
        return lease(obj, obj1, null);
    }

    public Future lease(Object obj, Object obj1, FutureCallback futurecallback)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (isShutDown)
        {
            throw new IllegalStateException("Connection pool shut down");
        } else
        {
            return new _cls2(obj, obj1);
        }
    }

    public volatile void release(Object obj, boolean flag)
    {
        release((PoolEntry)obj, flag);
    }

    public void release(PoolEntry poolentry, boolean flag)
    {
        lock.lock();
        if (!leased.remove(poolentry)) goto _L2; else goto _L1
_L1:
        RouteSpecificPool routespecificpool;
        routespecificpool = getPool(poolentry.getRoute());
        routespecificpool.free(poolentry, flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (isShutDown)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        available.addFirst(poolentry);
_L3:
        notifyPending(routespecificpool);
_L2:
        lock.unlock();
        return;
        poolentry.close();
          goto _L3
        poolentry;
        lock.unlock();
        throw poolentry;
    }

    public void setDefaultMaxPerRoute(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        lock.lock();
        defaultMaxPerRoute = i;
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public void setMaxPerRoute(Object obj, int i)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        lock.lock();
        maxPerRoute.put(obj, Integer.valueOf(i));
        lock.unlock();
        return;
        obj;
        lock.unlock();
        throw obj;
    }

    public void setMaxTotal(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        lock.lock();
        maxTotal = i;
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public void shutdown()
    {
        if (isShutDown)
        {
            return;
        }
        isShutDown = true;
        lock.lock();
        for (Iterator iterator = available.iterator(); iterator.hasNext(); ((PoolEntry)iterator.next()).close()) { }
        break MISSING_BLOCK_LABEL_66;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
        for (Iterator iterator1 = leased.iterator(); iterator1.hasNext(); ((PoolEntry)iterator1.next()).close()) { }
        for (Iterator iterator2 = routeToPool.values().iterator(); iterator2.hasNext(); ((RouteSpecificPool)iterator2.next()).shutdown()) { }
        routeToPool.clear();
        leased.clear();
        available.clear();
        lock.unlock();
        return;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[leased: ");
        stringbuilder.append(leased);
        stringbuilder.append("][available: ");
        stringbuilder.append(available);
        stringbuilder.append("][pending: ");
        stringbuilder.append(pending);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }


    private class _cls1 extends RouteSpecificPool
    {

        final AbstractConnPool this$0;
        final Object val$route;

        protected PoolEntry createEntry(Object obj)
        {
            return AbstractConnPool.this.createEntry(route, obj);
        }

        _cls1(Object obj1)
        {
            this$0 = AbstractConnPool.this;
            route = obj1;
            super(final_obj);
        }
    }


    private class _cls2 extends PoolEntryFuture
    {

        final AbstractConnPool this$0;
        final Object val$route;
        final Object val$state;

        public volatile Object getPoolEntry(long l, TimeUnit timeunit)
        {
            return getPoolEntry(l, timeunit);
        }

        public PoolEntry getPoolEntry(long l, TimeUnit timeunit)
        {
            return getPoolEntryBlocking(route, state, l, timeunit, this);
        }

        _cls2(Object obj, Object obj1)
        {
            this$0 = AbstractConnPool.this;
            route = obj;
            state = obj1;
            super(final_lock1, final_futurecallback);
        }
    }

}
