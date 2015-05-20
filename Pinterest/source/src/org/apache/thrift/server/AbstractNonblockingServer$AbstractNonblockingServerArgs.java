// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.transport.TNonblockingServerTransport;

public abstract class transportFactory extends transportFactory
{

    public long maxReadBufferBytes;

    public (TNonblockingServerTransport tnonblockingservertransport)
    {
        super(tnonblockingservertransport);
        maxReadBufferBytes = 0x7fffffffffffffffL;
        transportFactory(new org.apache.thrift.transport.nsportFactory());
    }
}
