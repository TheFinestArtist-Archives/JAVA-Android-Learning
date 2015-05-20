// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift:
//            TBaseAsyncProcessor, TProcessor

public class TProcessorFactory
{

    private final TProcessor processor_;

    public TProcessorFactory(TProcessor tprocessor)
    {
        processor_ = tprocessor;
    }

    public TProcessor getProcessor(TTransport ttransport)
    {
        return processor_;
    }

    public boolean isAsyncProcessor()
    {
        return processor_ instanceof TBaseAsyncProcessor;
    }
}
