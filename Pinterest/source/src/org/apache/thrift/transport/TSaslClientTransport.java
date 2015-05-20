// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.util.Map;
import javax.security.auth.callback.CallbackHandler;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TSaslTransport, TTransport

public class TSaslClientTransport extends TSaslTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TSaslClientTransport);
    private final String mechanism;

    public TSaslClientTransport(String s, String s1, String s2, String s3, Map map, CallbackHandler callbackhandler, TTransport ttransport)
    {
        super(Sasl.createSaslClient(new String[] {
            s
        }, s1, s2, s3, map, callbackhandler), ttransport);
        mechanism = s;
    }

    public TSaslClientTransport(SaslClient saslclient, TTransport ttransport)
    {
        super(saslclient, ttransport);
        mechanism = saslclient.getMechanismName();
    }

    public volatile void close()
    {
        super.close();
    }

    public volatile void flush()
    {
        super.flush();
    }

    protected TSaslTransport.SaslRole getRole()
    {
        return TSaslTransport.SaslRole.CLIENT;
    }

    public volatile SaslClient getSaslClient()
    {
        return super.getSaslClient();
    }

    public volatile SaslServer getSaslServer()
    {
        return super.getSaslServer();
    }

    public volatile TTransport getUnderlyingTransport()
    {
        return super.getUnderlyingTransport();
    }

    protected void handleSaslStartMessage()
    {
        SaslClient saslclient = getSaslClient();
        byte abyte1[] = new byte[0];
        byte abyte0[] = abyte1;
        if (saslclient.hasInitialResponse())
        {
            abyte0 = saslclient.evaluateChallenge(abyte1);
        }
        LOGGER.debug("Sending mechanism name {} and initial response of length {}", mechanism, Integer.valueOf(abyte0.length));
        abyte1 = mechanism.getBytes();
        sendSaslMessage(TSaslTransport.NegotiationStatus.START, abyte1);
        TSaslTransport.NegotiationStatus negotiationstatus;
        if (saslclient.isComplete())
        {
            negotiationstatus = TSaslTransport.NegotiationStatus.COMPLETE;
        } else
        {
            negotiationstatus = TSaslTransport.NegotiationStatus.OK;
        }
        sendSaslMessage(negotiationstatus, abyte0);
        underlyingTransport.flush();
    }

    public volatile boolean isOpen()
    {
        return super.isOpen();
    }

    public volatile void open()
    {
        super.open();
    }

    public volatile int read(byte abyte0[], int i, int j)
    {
        return super.read(abyte0, i, j);
    }

    public volatile void write(byte abyte0[], int i, int j)
    {
        super.write(abyte0, i, j);
    }

}
