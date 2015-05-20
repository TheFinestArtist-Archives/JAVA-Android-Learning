// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.nio.channels.Selector;

// Referenced classes of package org.apache.thrift.transport:
//            TServerTransport

public abstract class TNonblockingServerTransport extends TServerTransport
{

    public TNonblockingServerTransport()
    {
    }

    public abstract void registerSelector(Selector selector);
}
