// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServer, TServerEventHandler

public class TSimpleServer extends TServer
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/server/TSimpleServer.getName());
    private volatile boolean stopped_;

    public TSimpleServer(TServer.AbstractServerArgs abstractserverargs)
    {
        super(abstractserverargs);
        stopped_ = false;
    }

    public void serve()
    {
        Object obj;
        org.apache.thrift.protocol.TProtocol tprotocol;
        org.apache.thrift.protocol.TProtocol tprotocol1;
        TTransport ttransport;
        TTransport ttransport1;
        TProcessor tprocessor;
        boolean flag;
        try
        {
            serverTransport_.listen();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LOGGER.error("Error occurred during listening.", ((Throwable) (obj)));
            return;
        }
        if (eventHandler_ != null)
        {
            eventHandler_.preServe();
        }
        setServing(true);
        if (stopped_) goto _L2; else goto _L1
_L1:
        obj = serverTransport_.accept();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_645;
        }
        tprocessor = processorFactory_.getProcessor(((TTransport) (obj)));
        ttransport1 = inputTransportFactory_.getTransport(((TTransport) (obj)));
        ttransport = outputTransportFactory_.getTransport(((TTransport) (obj)));
        tprotocol1 = inputProtocolFactory_.getProtocol(ttransport1);
        tprotocol = outputProtocolFactory_.getProtocol(ttransport);
        if (eventHandler_ == null) goto _L4; else goto _L3
_L3:
        obj = eventHandler_.createContext(tprotocol1, tprotocol);
_L8:
        do
        {
            if (eventHandler_ != null)
            {
                eventHandler_.processContext(((ServerContext) (obj)), ttransport1, ttransport);
            }
            flag = tprocessor.process(tprotocol1, tprotocol);
        } while (flag);
_L5:
        if (eventHandler_ != null)
        {
            eventHandler_.deleteContext(((ServerContext) (obj)), tprotocol1, tprotocol);
        }
        if (ttransport1 != null)
        {
            ttransport1.close();
        }
        if (ttransport != null)
        {
            ttransport.close();
        }
        break MISSING_BLOCK_LABEL_28;
        Object obj2;
        obj2;
        Object obj1;
        org.apache.thrift.protocol.TProtocol tprotocol2;
        org.apache.thrift.protocol.TProtocol tprotocol3;
        TTransport ttransport2;
        TTransport ttransport3;
        tprotocol2 = null;
        tprotocol3 = null;
        ttransport2 = null;
        ttransport3 = null;
        obj1 = null;
_L7:
        obj = obj1;
        tprotocol = tprotocol2;
        tprotocol1 = tprotocol3;
        ttransport = ttransport2;
        ttransport1 = ttransport3;
        if (!stopped_)
        {
            LOGGER.error("Thrift error occurred during processing of message.", ((Throwable) (obj2)));
            obj = obj1;
            tprotocol = tprotocol2;
            tprotocol1 = tprotocol3;
            ttransport = ttransport2;
            ttransport1 = ttransport3;
        }
          goto _L5
        obj2;
        tprotocol2 = null;
        tprotocol3 = null;
        ttransport2 = null;
        ttransport3 = null;
        obj1 = null;
_L6:
        obj = obj1;
        tprotocol = tprotocol2;
        tprotocol1 = tprotocol3;
        ttransport = ttransport2;
        ttransport1 = ttransport3;
        if (!stopped_)
        {
            LOGGER.error("Error occurred during processing of message.", ((Throwable) (obj2)));
            obj = obj1;
            tprotocol = tprotocol2;
            tprotocol1 = tprotocol3;
            ttransport = ttransport2;
            ttransport1 = ttransport3;
        }
          goto _L5
_L2:
        setServing(false);
        return;
        obj2;
        tprotocol2 = null;
        tprotocol3 = null;
        ttransport2 = null;
        obj1 = null;
        ttransport3 = ttransport1;
          goto _L6
        obj2;
        tprotocol2 = null;
        tprotocol3 = null;
        obj1 = null;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L6
        obj2;
        tprotocol2 = null;
        obj1 = null;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L6
        obj2;
        obj1 = null;
        tprotocol2 = tprotocol;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L6
        obj2;
        obj1 = obj;
        tprotocol2 = tprotocol;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L6
        obj2;
        tprotocol2 = null;
        tprotocol3 = null;
        ttransport2 = null;
        obj1 = null;
        ttransport3 = ttransport1;
          goto _L7
        obj2;
        tprotocol2 = null;
        tprotocol3 = null;
        obj1 = null;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L7
        obj2;
        tprotocol2 = null;
        obj1 = null;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L7
        obj2;
        obj1 = null;
        tprotocol2 = tprotocol;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L7
        obj2;
        obj1 = obj;
        tprotocol2 = tprotocol;
        tprotocol3 = tprotocol1;
        ttransport2 = ttransport;
        ttransport3 = ttransport1;
          goto _L7
        obj;
        obj = null;
        tprotocol = null;
        tprotocol1 = null;
        ttransport = null;
        ttransport1 = null;
          goto _L5
        obj;
        obj = null;
        tprotocol = null;
        tprotocol1 = null;
        ttransport = null;
          goto _L5
        obj;
        obj = null;
        tprotocol = null;
        tprotocol1 = null;
          goto _L5
        obj;
        obj = null;
        tprotocol = null;
          goto _L5
        obj;
        obj = null;
          goto _L5
        TTransportException ttransportexception;
        ttransportexception;
          goto _L5
_L4:
        obj = null;
          goto _L8
        obj = null;
        tprotocol = null;
        tprotocol1 = null;
        ttransport = null;
        ttransport1 = null;
          goto _L5
    }

    public void stop()
    {
        stopped_ = true;
        serverTransport_.interrupt();
    }

}
