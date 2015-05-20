// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport

public abstract class TNonblockingTransport extends TTransport
{

    public TNonblockingTransport()
    {
    }

    public abstract boolean finishConnect();

    public abstract int read(ByteBuffer bytebuffer);

    public abstract SelectionKey registerSelector(Selector selector, int i);

    public abstract boolean startConnect();

    public abstract int write(ByteBuffer bytebuffer);
}
