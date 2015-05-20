// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.Collections;
import java.util.Map;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift:
//            TProcessor, ProcessFunction, TApplicationException

public abstract class TBaseProcessor
    implements TProcessor
{

    private final Object iface;
    private final Map processMap;

    protected TBaseProcessor(Object obj, Map map)
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
        TMessage tmessage = tprotocol.readMessageBegin();
        ProcessFunction processfunction = (ProcessFunction)processMap.get(tmessage.name);
        if (processfunction == null)
        {
            TProtocolUtil.skip(tprotocol, (byte)12);
            tprotocol.readMessageEnd();
            tprotocol = new TApplicationException(1, (new StringBuilder("Invalid method name: '")).append(tmessage.name).append("'").toString());
            tprotocol1.writeMessageBegin(new TMessage(tmessage.name, (byte)3, tmessage.seqid));
            tprotocol.write(tprotocol1);
            tprotocol1.writeMessageEnd();
            tprotocol1.getTransport().flush();
            return true;
        } else
        {
            processfunction.process(tmessage.seqid, tprotocol, tprotocol1, iface);
            return true;
        }
    }
}
