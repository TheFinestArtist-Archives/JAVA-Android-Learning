// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.CallbackHandler;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TSaslTransport, TTransport

public class TSaslServerTransport extends TSaslTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TSaslServerTransport);
    private Map serverDefinitionMap;

    public TSaslServerTransport(String s, String s1, String s2, Map map, CallbackHandler callbackhandler, TTransport ttransport)
    {
        super(ttransport);
        serverDefinitionMap = new HashMap();
        addServerDefinition(s, s1, s2, map, callbackhandler);
    }

    private TSaslServerTransport(Map map, TTransport ttransport)
    {
        super(ttransport);
        serverDefinitionMap = new HashMap();
        serverDefinitionMap.putAll(map);
    }

    TSaslServerTransport(Map map, TTransport ttransport, _cls1 _pcls1)
    {
        this(map, ttransport);
    }

    public TSaslServerTransport(TTransport ttransport)
    {
        super(ttransport);
        serverDefinitionMap = new HashMap();
    }

    public void addServerDefinition(String s, String s1, String s2, Map map, CallbackHandler callbackhandler)
    {
        serverDefinitionMap.put(s, new TSaslServerDefinition(s, s1, s2, map, callbackhandler));
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
        return TSaslTransport.SaslRole.SERVER;
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
        Object obj = receiveSaslMessage();
        LOGGER.debug("Received start message with status {}", ((TSaslTransport.SaslResponse) (obj)).status);
        if (((TSaslTransport.SaslResponse) (obj)).status != TSaslTransport.NegotiationStatus.START)
        {
            sendAndThrowMessage(TSaslTransport.NegotiationStatus.ERROR, (new StringBuilder("Expecting START status, received ")).append(((TSaslTransport.SaslResponse) (obj)).status).toString());
        }
        obj = new String(((TSaslTransport.SaslResponse) (obj)).payload);
        TSaslServerDefinition tsaslserverdefinition = (TSaslServerDefinition)serverDefinitionMap.get(obj);
        LOGGER.debug("Received mechanism name '{}'", obj);
        if (tsaslserverdefinition == null)
        {
            sendAndThrowMessage(TSaslTransport.NegotiationStatus.BAD, (new StringBuilder("Unsupported mechanism type ")).append(((String) (obj))).toString());
        }
        setSaslServer(Sasl.createSaslServer(tsaslserverdefinition.mechanism, tsaslserverdefinition.protocol, tsaslserverdefinition.serverName, tsaslserverdefinition.props, tsaslserverdefinition.cbh));
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



    private class TSaslServerDefinition
    {

        public CallbackHandler cbh;
        public String mechanism;
        public Map props;
        public String protocol;
        public String serverName;

        public TSaslServerDefinition(String s, String s1, String s2, Map map, CallbackHandler callbackhandler)
        {
            mechanism = s;
            protocol = s1;
            serverName = s2;
            props = map;
            cbh = callbackhandler;
        }
    }

}
