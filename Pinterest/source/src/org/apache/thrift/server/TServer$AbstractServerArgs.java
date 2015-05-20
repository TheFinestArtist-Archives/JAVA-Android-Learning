// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;

public abstract class serverTransport
{

    TProtocolFactory inputProtocolFactory;
    TTransportFactory inputTransportFactory;
    TProtocolFactory outputProtocolFactory;
    TTransportFactory outputTransportFactory;
    TProcessorFactory processorFactory;
    final TServerTransport serverTransport;

    public serverTransport inputProtocolFactory(TProtocolFactory tprotocolfactory)
    {
        inputProtocolFactory = tprotocolfactory;
        return this;
    }

    public inputProtocolFactory inputTransportFactory(TTransportFactory ttransportfactory)
    {
        inputTransportFactory = ttransportfactory;
        return this;
    }

    public inputTransportFactory outputProtocolFactory(TProtocolFactory tprotocolfactory)
    {
        outputProtocolFactory = tprotocolfactory;
        return this;
    }

    public outputProtocolFactory outputTransportFactory(TTransportFactory ttransportfactory)
    {
        outputTransportFactory = ttransportfactory;
        return this;
    }

    public outputTransportFactory processor(TProcessor tprocessor)
    {
        processorFactory = new TProcessorFactory(tprocessor);
        return this;
    }

    public processorFactory processorFactory(TProcessorFactory tprocessorfactory)
    {
        processorFactory = tprocessorfactory;
        return this;
    }

    public processorFactory protocolFactory(TProtocolFactory tprotocolfactory)
    {
        inputProtocolFactory = tprotocolfactory;
        outputProtocolFactory = tprotocolfactory;
        return this;
    }

    public outputProtocolFactory transportFactory(TTransportFactory ttransportfactory)
    {
        inputTransportFactory = ttransportfactory;
        outputTransportFactory = ttransportfactory;
        return this;
    }

    public _cls9(TServerTransport tservertransport)
    {
        inputTransportFactory = new TTransportFactory();
        outputTransportFactory = new TTransportFactory();
        inputProtocolFactory = new org.apache.thrift.protocol.it>();
        outputProtocolFactory = new org.apache.thrift.protocol.it>();
        serverTransport = tservertransport;
    }
}
