// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import org.apache.http.client.HttpClient;

// Referenced classes of package org.apache.thrift.transport:
//            TTransportFactory, TTransportException, THttpClient, TTransport

public class client extends TTransportFactory
{

    private final HttpClient client;
    private final String url;

    public TTransport getTransport(TTransport ttransport)
    {
        try
        {
            if (client != null)
            {
                return new THttpClient(url, client);
            }
            ttransport = new THttpClient(url);
        }
        // Misplaced declaration of an exception variable
        catch (TTransport ttransport)
        {
            return null;
        }
        return ttransport;
    }

    public (String s)
    {
        url = s;
        client = null;
    }

    public client(String s, HttpClient httpclient)
    {
        url = s;
        client = httpclient;
    }
}
