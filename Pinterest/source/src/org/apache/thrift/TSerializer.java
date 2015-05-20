// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package org.apache.thrift:
//            TBase, TException

public class TSerializer
{

    private final ByteArrayOutputStream baos_;
    private TProtocol protocol_;
    private final TIOStreamTransport transport_;

    public TSerializer()
    {
        this(((TProtocolFactory) (new org.apache.thrift.protocol.TBinaryProtocol.Factory())));
    }

    public TSerializer(TProtocolFactory tprotocolfactory)
    {
        baos_ = new ByteArrayOutputStream();
        transport_ = new TIOStreamTransport(baos_);
        protocol_ = tprotocolfactory.getProtocol(transport_);
    }

    public byte[] serialize(TBase tbase)
    {
        baos_.reset();
        tbase.write(protocol_);
        return baos_.toByteArray();
    }

    public String toString(TBase tbase)
    {
        return new String(serialize(tbase));
    }

    public String toString(TBase tbase, String s)
    {
        try
        {
            tbase = new String(serialize(tbase), s);
        }
        // Misplaced declaration of an exception variable
        catch (TBase tbase)
        {
            throw new TException((new StringBuilder("JVM DOES NOT SUPPORT ENCODING: ")).append(s).toString());
        }
        return tbase;
    }
}
