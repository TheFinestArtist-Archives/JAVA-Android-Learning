// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.log4j.Logger;

// Referenced classes of package org.apache.thrift:
//            TNonblockingMultiFetchStats

public class TNonblockingMultiFetchClient
{

    private static final Logger LOG = Logger.getLogger(org/apache/thrift/TNonblockingMultiFetchClient);
    private int fetchTimeoutSeconds;
    private int maxRecvBufBytesPerServer;
    private ByteBuffer recvBuf[];
    private ByteBuffer requestBuf;
    private ByteBuffer requestBufDuplication;
    private List servers;
    private TNonblockingMultiFetchStats stats;

    public TNonblockingMultiFetchClient(int i, int j, ByteBuffer bytebuffer, List list)
    {
        maxRecvBufBytesPerServer = i;
        fetchTimeoutSeconds = j;
        requestBuf = bytebuffer;
        servers = list;
        stats = new TNonblockingMultiFetchStats();
        recvBuf = null;
    }

    public ByteBuffer[] fetch()
    {
        this;
        JVM INSTR monitorenter ;
        recvBuf = null;
        stats.clear();
        if (servers != null && servers.size() != 0 && requestBuf != null && fetchTimeoutSeconds > 0) goto _L2; else goto _L1
_L1:
        Object obj = recvBuf;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((ByteBuffer []) (obj));
_L2:
        MultiFetch multifetch;
        FutureTask futuretask;
        obj = Executors.newSingleThreadExecutor();
        multifetch = new MultiFetch(null);
        futuretask = new FutureTask(multifetch, null);
        ((ExecutorService) (obj)).execute(futuretask);
        futuretask.get(fetchTimeoutSeconds, TimeUnit.SECONDS);
_L5:
        ((ExecutorService) (obj)).shutdownNow();
        multifetch.close();
        obj = recvBuf;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        futuretask.cancel(true);
        LOG.error((new StringBuilder("interrupted during fetch: ")).append(((InterruptedException) (obj1)).toString()).toString());
          goto _L5
        Exception exception;
        exception;
        throw exception;
        obj1;
        futuretask.cancel(true);
        LOG.error((new StringBuilder("exception during fetch: ")).append(((ExecutionException) (obj1)).toString()).toString());
          goto _L5
        obj1;
        futuretask.cancel(true);
        LOG.error((new StringBuilder("timeout for fetch: ")).append(((TimeoutException) (obj1)).toString()).toString());
          goto _L5
    }

    public TNonblockingMultiFetchStats getFetchStats()
    {
        this;
        JVM INSTR monitorenter ;
        TNonblockingMultiFetchStats tnonblockingmultifetchstats = stats;
        this;
        JVM INSTR monitorexit ;
        return tnonblockingmultifetchstats;
        Exception exception;
        exception;
        throw exception;
    }

    public int getFetchTimeoutSeconds()
    {
        this;
        JVM INSTR monitorenter ;
        int i = fetchTimeoutSeconds;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getMaxRecvBufBytesPerServer()
    {
        this;
        JVM INSTR monitorenter ;
        int i = maxRecvBufBytesPerServer;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public ByteBuffer getRequestBuf()
    {
        this;
        JVM INSTR monitorenter ;
        ByteBuffer bytebuffer = requestBuf;
        if (bytebuffer != null) goto _L2; else goto _L1
_L1:
        bytebuffer = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return bytebuffer;
_L2:
        if (requestBufDuplication == null)
        {
            requestBufDuplication = requestBuf.duplicate();
        }
        bytebuffer = requestBufDuplication;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public List getServerList()
    {
        this;
        JVM INSTR monitorenter ;
        List list = servers;
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return list;
_L2:
        list = Collections.unmodifiableList(servers);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }






/*
    static ByteBuffer[] access$302(TNonblockingMultiFetchClient tnonblockingmultifetchclient, ByteBuffer abytebuffer[])
    {
        tnonblockingmultifetchclient.recvBuf = abytebuffer;
        return abytebuffer;
    }

*/




    private class MultiFetch
        implements Runnable
    {

        private Selector selector;
        final TNonblockingMultiFetchClient this$0;

        public void close()
        {
label0:
            {
                try
                {
                    if (selector.isOpen())
                    {
                        for (Iterator iterator = selector.keys().iterator(); iterator.hasNext(); ((SocketChannel)((SelectionKey)iterator.next()).channel()).close()) { }
                        break label0;
                    }
                }
                catch (IOException ioexception)
                {
                    TNonblockingMultiFetchClient.LOG.error((new StringBuilder("free resource error: ")).append(ioexception.toString()).toString());
                }
                return;
            }
            selector.close();
            return;
        }

        public void run()
        {
            ByteBuffer abytebuffer[];
            long al[];
            int ai[];
            boolean aflag[];
            int k;
            long l1;
            l1 = System.currentTimeMillis();
            k = servers.size();
            stats.setNumTotalServers(k);
            recvBuf = new ByteBuffer[k];
            abytebuffer = new ByteBuffer[k];
            al = new long[k];
            ai = new int[k];
            aflag = new boolean[k];
            selector = Selector.open();
            int i = 0;
_L3:
            if (i >= k) goto _L2; else goto _L1
_L1:
            Object obj;
            Object obj1;
            SelectionKey selectionkey;
            InetSocketAddress inetsocketaddress;
            abytebuffer[i] = requestBuf.duplicate();
            recvBuf[i] = ByteBuffer.allocate(4);
            stats.incTotalRecvBufBytes(4);
            inetsocketaddress = (InetSocketAddress)servers.get(i);
            obj1 = null;
            selectionkey = null;
            obj = selectionkey;
            SocketChannel socketchannel = SocketChannel.open();
            obj = selectionkey;
            obj1 = socketchannel;
            socketchannel.configureBlocking(false);
            obj = selectionkey;
            obj1 = socketchannel;
            socketchannel.connect(inetsocketaddress);
            obj = selectionkey;
            obj1 = socketchannel;
            selectionkey = socketchannel.register(selector, socketchannel.validOps());
            obj = selectionkey;
            obj1 = socketchannel;
            try
            {
                selectionkey.attach(Integer.valueOf(i));
            }
            catch (Exception exception2)
            {
                stats.incNumConnectErrorServers();
                String s = String.format("set up socket to server %s error: %s", new Object[] {
                    inetsocketaddress.toString(), exception2.toString()
                });
                TNonblockingMultiFetchClient.LOG.error(s);
                Exception exception;
                int j;
                int l;
                long l2;
                if (obj1 != null)
                {
                    try
                    {
                        ((SocketChannel) (obj1)).close();
                    }
                    catch (Exception exception1) { }
                }
                if (obj != null)
                {
                    ((SelectionKey) (obj)).cancel();
                }
            }
            i++;
            if (true) goto _L3; else goto _L2
            obj;
            TNonblockingMultiFetchClient.LOG.error((new StringBuilder("selector opens error: ")).append(((IOException) (obj)).toString()).toString());
_L12:
            return;
            exception;
            TNonblockingMultiFetchClient.LOG.error((new StringBuilder("selector selects error: ")).append(exception.toString()).toString());
_L2:
            if (stats.getNumReadCompletedServers() + stats.getNumConnectErrorServers() >= stats.getNumTotalServers() || Thread.currentThread().isInterrupted())
            {
                continue; /* Loop/switch isn't completed */
            }
            selector.select();
            exception = selector.selectedKeys().iterator();
_L5:
            do
            {
                if (!exception.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                obj1 = (SelectionKey)exception.next();
                exception.remove();
                j = ((Integer)((SelectionKey) (obj1)).attachment()).intValue();
                if (((SelectionKey) (obj1)).isValid() && ((SelectionKey) (obj1)).isConnectable())
                {
                    try
                    {
                        ((SocketChannel)((SelectionKey) (obj1)).channel()).finishConnect();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        stats.incNumConnectErrorServers();
                        s = String.format("socket %d connects to server %s error: %s", new Object[] {
                            Integer.valueOf(j), ((InetSocketAddress)servers.get(j)).toString(), s.toString()
                        });
                        TNonblockingMultiFetchClient.LOG.error(s);
                    }
                }
                if (((SelectionKey) (obj1)).isValid() && ((SelectionKey) (obj1)).isWritable() && abytebuffer[j].hasRemaining())
                {
                    try
                    {
                        ((SocketChannel)((SelectionKey) (obj1)).channel()).write(abytebuffer[j]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s = String.format("socket %d writes to server %s error: %s", new Object[] {
                            Integer.valueOf(j), ((InetSocketAddress)servers.get(j)).toString(), s.toString()
                        });
                        TNonblockingMultiFetchClient.LOG.error(s);
                    }
                }
            } while (!((SelectionKey) (obj1)).isValid() || !((SelectionKey) (obj1)).isReadable());
            obj1 = (SocketChannel)((SelectionKey) (obj1)).channel();
            l = ((SocketChannel) (obj1)).read(recvBuf[j]);
            if (l <= 0) goto _L5; else goto _L4
_L4:
            al[j] = al[j] + (long)l;
            if (aflag[j]) goto _L7; else goto _L6
_L6:
            if (recvBuf[j].remaining() != 0) goto _L7; else goto _L8
_L8:
            ai[j] = recvBuf[j].getInt(0);
label0:
            {
                if (ai[j] > 0)
                {
                    break label0;
                }
                try
                {
                    stats.incNumInvalidFrameSize();
                    s = String.format("Read an invalid frame size %d from %s. Does the server use TFramedTransport? ", new Object[] {
                        Integer.valueOf(ai[j]), ((InetSocketAddress)servers.get(j)).toString()
                    });
                    TNonblockingMultiFetchClient.LOG.error(s);
                    ((SocketChannel) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    obj1 = String.format("socket %d reads from server %s error: %s", new Object[] {
                        Integer.valueOf(j), ((InetSocketAddress)servers.get(j)).toString(), ((Exception) (obj1)).toString()
                    });
                    TNonblockingMultiFetchClient.LOG.error(obj1);
                }
            }
              goto _L5
label1:
            {
                if (ai[j] + 4 > stats.getMaxResponseBytes())
                {
                    stats.setMaxResponseBytes(ai[j] + 4);
                }
                if (ai[j] + 4 <= maxRecvBufBytesPerServer)
                {
                    break label1;
                }
                stats.incNumOverflowedRecvBuf();
                s = String.format("Read frame size %d from %s, total buffer size would exceed limit %d", new Object[] {
                    Integer.valueOf(ai[j]), ((InetSocketAddress)servers.get(j)).toString(), Integer.valueOf(maxRecvBufBytesPerServer)
                });
                TNonblockingMultiFetchClient.LOG.error(s);
                ((SocketChannel) (obj1)).close();
            }
              goto _L5
            recvBuf[j] = ByteBuffer.allocate(ai[j] + 4);
            recvBuf[j].putInt(ai[j]);
            stats.incTotalRecvBufBytes(ai[j]);
            aflag[j] = true;
_L7:
            if (!aflag[j] || al[j] < (long)(ai[j] + 4)) goto _L5; else goto _L9
_L9:
            ((SocketChannel) (obj1)).close();
            stats.incNumReadCompletedServers();
            l2 = System.currentTimeMillis();
            stats.setReadTime(l2 - l1);
              goto _L5
            if (true) goto _L2; else goto _L10
_L10:
            if (true) goto _L12; else goto _L11
_L11:
        }

        private MultiFetch()
        {
            this$0 = TNonblockingMultiFetchClient.this;
            super();
        }

        MultiFetch(_cls1 _pcls1)
        {
            this();
        }
    }

}
