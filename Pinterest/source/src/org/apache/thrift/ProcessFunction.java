// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift:
//            TException, TBase, TApplicationException

public abstract class ProcessFunction
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/ProcessFunction.getName());
    private final String methodName;

    public ProcessFunction(String s)
    {
        methodName = s;
    }

    public abstract TBase getEmptyArgsInstance();

    public String getMethodName()
    {
        return methodName;
    }

    public abstract TBase getResult(Object obj, TBase tbase);

    protected abstract boolean isOneway();

    public final void process(int i, TProtocol tprotocol, TProtocol tprotocol1, Object obj)
    {
        TBase tbase = getEmptyArgsInstance();
        try
        {
            tbase.read(tprotocol);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            tprotocol.readMessageEnd();
            tprotocol = new TApplicationException(7, ((TProtocolException) (obj)).getMessage());
            tprotocol1.writeMessageBegin(new TMessage(getMethodName(), (byte)3, i));
            tprotocol.write(tprotocol1);
            tprotocol1.writeMessageEnd();
            tprotocol1.getTransport().flush();
            return;
        }
        tprotocol.readMessageEnd();
        try
        {
            tprotocol = getResult(obj, tbase);
        }
        // Misplaced declaration of an exception variable
        catch (TProtocol tprotocol)
        {
            LOGGER.error((new StringBuilder("Internal error processing ")).append(getMethodName()).toString(), tprotocol);
            tprotocol = new TApplicationException(6, (new StringBuilder("Internal error processing ")).append(getMethodName()).toString());
            tprotocol1.writeMessageBegin(new TMessage(getMethodName(), (byte)3, i));
            tprotocol.write(tprotocol1);
            tprotocol1.writeMessageEnd();
            tprotocol1.getTransport().flush();
            return;
        }
        if (!isOneway())
        {
            tprotocol1.writeMessageBegin(new TMessage(getMethodName(), (byte)2, i));
            tprotocol.write(tprotocol1);
            tprotocol1.writeMessageEnd();
            tprotocol1.getTransport().flush();
        }
    }

}
