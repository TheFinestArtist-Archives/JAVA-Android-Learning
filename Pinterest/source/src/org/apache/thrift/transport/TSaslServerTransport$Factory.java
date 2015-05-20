// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import javax.security.auth.callback.CallbackHandler;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.transport:
//            TTransportFactory, TTransportException, TSaslServerTransport, TTransport

public class addServerDefinition extends TTransportFactory
{

    private static Map transportMap = Collections.synchronizedMap(new WeakHashMap());
    private Map serverDefinitionMap;

    public void addServerDefinition(String s, String s1, String s2, Map map, CallbackHandler callbackhandler)
    {
        serverDefinitionMap.put(s, new verDefinition(s, s1, s2, map, callbackhandler));
    }

    public TTransport getTransport(TTransport ttransport)
    {
        WeakReference weakreference = (WeakReference)transportMap.get(ttransport);
        if (weakreference == null || weakreference.get() == null)
        {
            TSaslServerTransport.access$000().debug("transport map does not contain key", ttransport);
            weakreference = new WeakReference(new TSaslServerTransport(serverDefinitionMap, ttransport, null));
            try
            {
                ((TSaslServerTransport)weakreference.get()).open();
            }
            // Misplaced declaration of an exception variable
            catch (TTransport ttransport)
            {
                TSaslServerTransport.access$000().debug("failed to open server transport", ttransport);
                throw new RuntimeException(ttransport);
            }
            transportMap.put(ttransport, weakreference);
            ttransport = weakreference;
        } else
        {
            TSaslServerTransport.access$000().debug("transport map does contain key {}", ttransport);
            ttransport = weakreference;
        }
        return (TTransport)ttransport.get();
    }


    public verDefinition()
    {
        serverDefinitionMap = new HashMap();
    }

    public serverDefinitionMap(String s, String s1, String s2, Map map, CallbackHandler callbackhandler)
    {
        serverDefinitionMap = new HashMap();
        addServerDefinition(s, s1, s2, map, callbackhandler);
    }
}
