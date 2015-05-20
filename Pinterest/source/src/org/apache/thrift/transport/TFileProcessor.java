// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocolFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TTransportException, TFileTransport, TTransport

public class TFileProcessor
{

    private TProtocolFactory inputProtocolFactory_;
    private TFileTransport inputTransport_;
    private TProtocolFactory outputProtocolFactory_;
    private TTransport outputTransport_;
    private TProcessor processor_;

    public TFileProcessor(TProcessor tprocessor, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1, TFileTransport tfiletransport, TTransport ttransport)
    {
        processor_ = tprocessor;
        inputProtocolFactory_ = tprotocolfactory;
        outputProtocolFactory_ = tprotocolfactory1;
        inputTransport_ = tfiletransport;
        outputTransport_ = ttransport;
    }

    public TFileProcessor(TProcessor tprocessor, TProtocolFactory tprotocolfactory, TFileTransport tfiletransport, TTransport ttransport)
    {
        processor_ = tprocessor;
        outputProtocolFactory_ = tprotocolfactory;
        inputProtocolFactory_ = tprotocolfactory;
        inputTransport_ = tfiletransport;
        outputTransport_ = ttransport;
    }

    private void processUntil(int i)
    {
        org.apache.thrift.protocol.TProtocol tprotocol;
        org.apache.thrift.protocol.TProtocol tprotocol1;
        int j;
        tprotocol = inputProtocolFactory_.getProtocol(inputTransport_);
        tprotocol1 = outputProtocolFactory_.getProtocol(outputTransport_);
        j = inputTransport_.getCurChunk();
_L2:
        if (i < j)
        {
            break; /* Loop/switch isn't completed */
        }
        processor_.process(tprotocol, tprotocol1);
        j = inputTransport_.getCurChunk();
        if (true) goto _L2; else goto _L1
        TTransportException ttransportexception;
        ttransportexception;
        if (ttransportexception.getType() != 4)
        {
            throw ttransportexception;
        }
_L1:
    }

    public void processChunk()
    {
        processChunk(inputTransport_.getCurChunk());
    }

    public void processChunk(int i)
    {
        processChunk(i, i);
    }

    public void processChunk(int i, int j)
    {
        int l = inputTransport_.getNumChunks();
        int k = j;
        if (j < 0)
        {
            k = j + l;
        }
        j = i;
        if (i < 0)
        {
            j = i + l;
        }
        if (k < j)
        {
            throw new TException((new StringBuilder("endChunkNum ")).append(k).append(" is less than ").append(j).toString());
        } else
        {
            inputTransport_.seekToChunk(j);
            processUntil(k);
            return;
        }
    }
}
