// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.server:
//            ServerContext

public interface TServerEventHandler
{

    public abstract ServerContext createContext(TProtocol tprotocol, TProtocol tprotocol1);

    public abstract void deleteContext(ServerContext servercontext, TProtocol tprotocol, TProtocol tprotocol1);

    public abstract void preServe();

    public abstract void processContext(ServerContext servercontext, TTransport ttransport, TTransport ttransport1);
}
