// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import org.apache.thrift.transport.TNonblockingTransport;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncClient

public interface TAsyncClientFactory
{

    public abstract TAsyncClient getAsyncClient(TNonblockingTransport tnonblockingtransport);
}
