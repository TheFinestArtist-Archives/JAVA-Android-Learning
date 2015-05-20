// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.transport.TNonblockingTransport;

class val.client
    implements Runnable
{

    final val.client this$1;
    final TNonblockingTransport val$client;
    final val.client val$targetThread;

    public void run()
    {
        cess._mth1000(this._cls1.this, val$targetThread, val$client);
    }

    ()
    {
        this$1 = final_;
        val$targetThread = 1;
        val$client = TNonblockingTransport.this;
        super();
    }
}
