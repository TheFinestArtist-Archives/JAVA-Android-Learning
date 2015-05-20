// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServerEventHandler

public abstract class TServer
{

    protected TServerEventHandler eventHandler_;
    protected TProtocolFactory inputProtocolFactory_;
    protected TTransportFactory inputTransportFactory_;
    private boolean isServing;
    protected TProtocolFactory outputProtocolFactory_;
    protected TTransportFactory outputTransportFactory_;
    protected TProcessorFactory processorFactory_;
    protected TServerTransport serverTransport_;

    protected TServer(AbstractServerArgs abstractserverargs)
    {
        processorFactory_ = abstractserverargs.processorFactory;
        serverTransport_ = abstractserverargs.serverTransport;
        inputTransportFactory_ = abstractserverargs.inputTransportFactory;
        outputTransportFactory_ = abstractserverargs.outputTransportFactory;
        inputProtocolFactory_ = abstractserverargs.inputProtocolFactory;
        outputProtocolFactory_ = abstractserverargs.outputProtocolFactory;
    }

    public TServerEventHandler getEventHandler()
    {
        return eventHandler_;
    }

    public boolean isServing()
    {
        return isServing;
    }

    public abstract void serve();

    public void setServerEventHandler(TServerEventHandler tservereventhandler)
    {
        eventHandler_ = tservereventhandler;
    }

    protected void setServing(boolean flag)
    {
        isServing = flag;
    }

    public void stop()
    {
    }

    private class AbstractServerArgs
    {

        TProtocolFactory inputProtocolFactory;
        TTransportFactory inputTransportFactory;
        TProtocolFactory outputProtocolFactory;
        TTransportFactory outputTransportFactory;
        TProcessorFactory processorFactory;
        final TServerTransport serverTransport;

        public AbstractServerArgs inputProtocolFactory(TProtocolFactory tprotocolfactory)
        {
            inputProtocolFactory = tprotocolfactory;
            return this;
        }

        public AbstractServerArgs inputTransportFactory(TTransportFactory ttransportfactory)
        {
            inputTransportFactory = ttransportfactory;
            return this;
        }

        public AbstractServerArgs outputProtocolFactory(TProtocolFactory tprotocolfactory)
        {
            outputProtocolFactory = tprotocolfactory;
            return this;
        }

        public AbstractServerArgs outputTransportFactory(TTransportFactory ttransportfactory)
        {
            outputTransportFactory = ttransportfactory;
            return this;
        }

        public AbstractServerArgs processor(TProcessor tprocessor)
        {
            processorFactory = new TProcessorFactory(tprocessor);
            return this;
        }

        public AbstractServerArgs processorFactory(TProcessorFactory tprocessorfactory)
        {
            processorFactory = tprocessorfactory;
            return this;
        }

        public AbstractServerArgs protocolFactory(TProtocolFactory tprotocolfactory)
        {
            inputProtocolFactory = tprotocolfactory;
            outputProtocolFactory = tprotocolfactory;
            return this;
        }

        public AbstractServerArgs transportFactory(TTransportFactory ttransportfactory)
        {
            inputTransportFactory = ttransportfactory;
            outputTransportFactory = ttransportfactory;
            return this;
        }

        public AbstractServerArgs(TServerTransport tservertransport)
        {
            inputTransportFactory = new TTransportFactory();
            outputTransportFactory = new TTransportFactory();
            inputProtocolFactory = new org.apache.thrift.protocol.TBinaryProtocol.Factory();
            outputProtocolFactory = new org.apache.thrift.protocol.TBinaryProtocol.Factory();
            serverTransport = tservertransport;
        }
    }

}
