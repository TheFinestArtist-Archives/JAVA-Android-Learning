// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TThreadPoolServer, TServerEventHandler

class <init>
    implements Runnable
{

    private TTransport client_;
    final TThreadPoolServer this$0;

    public void run()
    {
        Object obj7;
        Object obj9;
        Object obj12;
        obj9 = null;
        obj12 = null;
        obj7 = null;
        Object obj;
        TProcessor tprocessor;
        tprocessor = processorFactory_.getProcessor(client_);
        obj = inputTransportFactory_.getTransport(client_);
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj8;
        Object obj10;
        Object obj11;
        boolean flag;
        try
        {
            obj1 = outputTransportFactory_.getTransport(client_);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj4 = null;
            obj5 = null;
            obj8 = null;
            obj10 = null;
            obj11 = obj;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj5 = obj;
            obj4 = null;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj5 = obj;
            obj4 = null;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
_L3:
            obj2 = inputProtocolFactory_.getProtocol(((TTransport) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj4 = null;
            obj5 = null;
            obj8 = null;
            obj10 = obj1;
            obj11 = obj;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj3 = null;
            obj2 = null;
            obj5 = obj;
            obj4 = obj1;
            obj7 = null;
            obj = null;
            obj1 = obj3;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj3 = null;
            obj2 = null;
            obj5 = obj;
            obj4 = obj1;
            obj7 = null;
            obj = null;
            obj1 = obj3;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj3 = outputProtocolFactory_.getProtocol(((TTransport) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3)
        {
            obj4 = null;
            obj5 = null;
            obj8 = obj2;
            obj10 = obj1;
            obj11 = obj;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj7 = null;
            obj5 = obj;
            obj4 = obj1;
            obj3 = obj2;
            obj2 = null;
            obj = null;
            obj1 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj7 = null;
            obj5 = obj;
            obj4 = obj1;
            obj3 = obj2;
            obj2 = null;
            obj = null;
            obj1 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj6 = getEventHandler();
        }
        catch (TTransportException ttransportexception)
        {
            ttransportexception = null;
            obj5 = obj3;
            obj8 = obj2;
            obj10 = obj1;
            obj11 = obj;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj5 = obj;
            obj4 = obj1;
            obj7 = obj2;
            obj2 = obj3;
            obj1 = null;
            obj = null;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj6)
        {
            obj5 = obj;
            obj4 = obj1;
            obj7 = obj2;
            obj2 = obj3;
            obj1 = null;
            obj = null;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
        }
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        obj7 = ((TServerEventHandler) (obj6)).createContext(((org.apache.thrift.protocol.TProtocol) (obj2)), ((org.apache.thrift.protocol.TProtocol) (obj3)));
_L2:
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj12 = obj7;
        ((TServerEventHandler) (obj6)).processContext(((ServerContext) (obj7)), ((TTransport) (obj)), ((TTransport) (obj1)));
        obj9 = obj7;
        obj4 = obj6;
        obj5 = obj3;
        obj8 = obj2;
        obj10 = obj1;
        obj11 = obj;
        obj12 = obj7;
        if (TThreadPoolServer.access$100(TThreadPoolServer.this))
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj12 = obj7;
        flag = tprocessor.process(((org.apache.thrift.protocol.TProtocol) (obj2)), ((org.apache.thrift.protocol.TProtocol) (obj3)));
        if (flag) goto _L2; else goto _L1
_L1:
        obj11 = obj;
        obj10 = obj1;
        obj8 = obj2;
        obj5 = obj3;
        obj4 = obj6;
        obj9 = obj7;
_L8:
        if (obj4 != null)
        {
            ((TServerEventHandler) (obj4)).deleteContext(((ServerContext) (obj9)), ((org.apache.thrift.protocol.TProtocol) (obj8)), ((org.apache.thrift.protocol.TProtocol) (obj5)));
        }
        if (obj11 != null)
        {
            ((TTransport) (obj11)).close();
        }
        if (obj10 != null)
        {
            ((TTransport) (obj10)).close();
        }
        return;
        obj6;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        obj = null;
_L6:
        TThreadPoolServer.access$200().error("Thrift error occurred during processing of message.", ((Throwable) (obj6)));
        obj10 = obj4;
        obj11 = obj5;
        obj9 = obj;
        obj4 = obj1;
        obj5 = obj2;
        obj8 = obj3;
        continue; /* Loop/switch isn't completed */
        obj6;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        obj = null;
_L4:
        TThreadPoolServer.access$200().error("Error occurred during processing of message.", ((Throwable) (obj6)));
        obj10 = obj4;
        obj11 = obj5;
        obj9 = obj;
        obj4 = obj1;
        obj5 = obj2;
        obj8 = obj3;
        continue; /* Loop/switch isn't completed */
        obj8;
        obj5 = obj;
        obj4 = obj1;
        obj7 = obj2;
        obj2 = obj3;
        obj1 = obj6;
        obj = null;
        obj6 = obj8;
        obj3 = obj7;
        continue; /* Loop/switch isn't completed */
        obj9;
        obj5 = obj;
        obj4 = obj1;
        obj8 = obj2;
        obj2 = obj3;
        obj1 = obj6;
        obj = obj7;
        obj6 = obj9;
        obj3 = obj8;
        if (true) goto _L4; else goto _L3
        obj8;
        obj5 = obj;
        obj4 = obj1;
        obj7 = obj2;
        obj2 = obj3;
        obj1 = obj6;
        obj = null;
        obj6 = obj8;
        obj3 = obj7;
        continue; /* Loop/switch isn't completed */
        obj9;
        obj5 = obj;
        obj4 = obj1;
        obj8 = obj2;
        obj2 = obj3;
        obj1 = obj6;
        obj = obj7;
        obj6 = obj9;
        obj3 = obj8;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        obj4 = null;
        obj5 = null;
        obj8 = null;
        obj10 = null;
        obj11 = null;
        continue; /* Loop/switch isn't completed */
        TTransportException ttransportexception1;
        ttransportexception1;
        obj9 = obj12;
        ttransportexception1 = ((TTransportException) (obj6));
        obj5 = obj3;
        obj8 = obj2;
        obj10 = obj1;
        obj11 = obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private (TTransport ttransport)
    {
        this$0 = TThreadPoolServer.this;
        super();
        client_ = ttransport;
    }

    client_(TTransport ttransport, client_ client_1)
    {
        this(ttransport);
    }
}
