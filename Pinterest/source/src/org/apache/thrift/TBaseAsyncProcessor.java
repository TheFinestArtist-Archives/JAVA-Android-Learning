// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.Collections;
import java.util.Map;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift:
//            TProcessor, AsyncProcessFunction, TApplicationException, TBase

public class TBaseAsyncProcessor
    implements TProcessor
{

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
    final Object iface;
    final Map processMap;

    public TBaseAsyncProcessor(Object obj, Map map)
    {
        iface = obj;
        processMap = map;
    }

    public Map getProcessMapView()
    {
        return Collections.unmodifiableMap(processMap);
    }

    public boolean process(TProtocol tprotocol, TProtocol tprotocol1)
    {
        return false;
    }

    public boolean process(org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer asyncframebuffer)
    {
        Object obj = asyncframebuffer.getInputProtocol();
        TProtocol tprotocol = asyncframebuffer.getOutputProtocol();
        TMessage tmessage = ((TProtocol) (obj)).readMessageBegin();
        AsyncProcessFunction asyncprocessfunction = (AsyncProcessFunction)processMap.get(tmessage.name);
        if (asyncprocessfunction == null)
        {
            TProtocolUtil.skip(((TProtocol) (obj)), (byte)12);
            ((TProtocol) (obj)).readMessageEnd();
            obj = new TApplicationException(1, (new StringBuilder("Invalid method name: '")).append(tmessage.name).append("'").toString());
            tprotocol.writeMessageBegin(new TMessage(tmessage.name, (byte)3, tmessage.seqid));
            ((TApplicationException) (obj)).write(tprotocol);
            tprotocol.writeMessageEnd();
            tprotocol.getTransport().flush();
            asyncframebuffer.responseReady();
            return true;
        }
        TBase tbase = (TBase)asyncprocessfunction.getEmptyArgsInstance();
        try
        {
            tbase.read(((TProtocol) (obj)));
        }
        catch (TProtocolException tprotocolexception)
        {
            ((TProtocol) (obj)).readMessageEnd();
            obj = new TApplicationException(7, tprotocolexception.getMessage());
            tprotocol.writeMessageBegin(new TMessage(tmessage.name, (byte)3, tmessage.seqid));
            ((TApplicationException) (obj)).write(tprotocol);
            tprotocol.writeMessageEnd();
            tprotocol.getTransport().flush();
            asyncframebuffer.responseReady();
            return true;
        }
        ((TProtocol) (obj)).readMessageEnd();
        asyncprocessfunction.start(iface, tbase, asyncprocessfunction.getResultHandler(asyncframebuffer, tmessage.seqid));
        return true;
    }
}
