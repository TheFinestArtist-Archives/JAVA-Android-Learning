// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;

// Referenced classes of package org.apache.thrift:
//            TNonblockingMultiFetchClient, TNonblockingMultiFetchStats

class <init>
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
                TNonblockingMultiFetchClient.access$400().error((new StringBuilder("free resource error: ")).append(ioexception.toString()).toString());
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
        k = TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).size();
        TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).setNumTotalServers(k);
        TNonblockingMultiFetchClient.access$302(TNonblockingMultiFetchClient.this, new ByteBuffer[k]);
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
        abytebuffer[i] = TNonblockingMultiFetchClient.access$500(TNonblockingMultiFetchClient.this).duplicate();
        TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[i] = ByteBuffer.allocate(4);
        TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incTotalRecvBufBytes(4);
        inetsocketaddress = (InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(i);
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
            TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incNumConnectErrorServers();
            String s = String.format("set up socket to server %s error: %s", new Object[] {
                inetsocketaddress.toString(), exception2.toString()
            });
            TNonblockingMultiFetchClient.access$400().error(s);
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
        TNonblockingMultiFetchClient.access$400().error((new StringBuilder("selector opens error: ")).append(((IOException) (obj)).toString()).toString());
_L12:
        return;
        exception;
        TNonblockingMultiFetchClient.access$400().error((new StringBuilder("selector selects error: ")).append(exception.toString()).toString());
_L2:
        if (TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).getNumReadCompletedServers() + TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).getNumConnectErrorServers() >= TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).getNumTotalServers() || Thread.currentThread().isInterrupted())
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
                    TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incNumConnectErrorServers();
                    s = String.format("socket %d connects to server %s error: %s", new Object[] {
                        Integer.valueOf(j), ((InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(j)).toString(), s.toString()
                    });
                    TNonblockingMultiFetchClient.access$400().error(s);
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
                        Integer.valueOf(j), ((InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(j)).toString(), s.toString()
                    });
                    TNonblockingMultiFetchClient.access$400().error(s);
                }
            }
        } while (!((SelectionKey) (obj1)).isValid() || !((SelectionKey) (obj1)).isReadable());
        obj1 = (SocketChannel)((SelectionKey) (obj1)).channel();
        l = ((SocketChannel) (obj1)).read(TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[j]);
        if (l <= 0) goto _L5; else goto _L4
_L4:
        al[j] = al[j] + (long)l;
        if (aflag[j]) goto _L7; else goto _L6
_L6:
        if (TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[j].remaining() != 0) goto _L7; else goto _L8
_L8:
        ai[j] = TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[j].getInt(0);
label0:
        {
            if (ai[j] > 0)
            {
                break label0;
            }
            try
            {
                TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incNumInvalidFrameSize();
                s = String.format("Read an invalid frame size %d from %s. Does the server use TFramedTransport? ", new Object[] {
                    Integer.valueOf(ai[j]), ((InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(j)).toString()
                });
                TNonblockingMultiFetchClient.access$400().error(s);
                ((SocketChannel) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj1 = String.format("socket %d reads from server %s error: %s", new Object[] {
                    Integer.valueOf(j), ((InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(j)).toString(), ((Exception) (obj1)).toString()
                });
                TNonblockingMultiFetchClient.access$400().error(obj1);
            }
        }
          goto _L5
label1:
        {
            if (ai[j] + 4 > TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).getMaxResponseBytes())
            {
                TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).setMaxResponseBytes(ai[j] + 4);
            }
            if (ai[j] + 4 <= TNonblockingMultiFetchClient.access$600(TNonblockingMultiFetchClient.this))
            {
                break label1;
            }
            TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incNumOverflowedRecvBuf();
            s = String.format("Read frame size %d from %s, total buffer size would exceed limit %d", new Object[] {
                Integer.valueOf(ai[j]), ((InetSocketAddress)TNonblockingMultiFetchClient.access$100(TNonblockingMultiFetchClient.this).get(j)).toString(), Integer.valueOf(TNonblockingMultiFetchClient.access$600(TNonblockingMultiFetchClient.this))
            });
            TNonblockingMultiFetchClient.access$400().error(s);
            ((SocketChannel) (obj1)).close();
        }
          goto _L5
        TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[j] = ByteBuffer.allocate(ai[j] + 4);
        TNonblockingMultiFetchClient.access$300(TNonblockingMultiFetchClient.this)[j].putInt(ai[j]);
        TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incTotalRecvBufBytes(ai[j]);
        aflag[j] = true;
_L7:
        if (!aflag[j] || al[j] < (long)(ai[j] + 4)) goto _L5; else goto _L9
_L9:
        ((SocketChannel) (obj1)).close();
        TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).incNumReadCompletedServers();
        l2 = System.currentTimeMillis();
        TNonblockingMultiFetchClient.access$200(TNonblockingMultiFetchClient.this).setReadTime(l2 - l1);
          goto _L5
        if (true) goto _L2; else goto _L10
_L10:
        if (true) goto _L12; else goto _L11
_L11:
    }

    private ()
    {
        this$0 = TNonblockingMultiFetchClient.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
