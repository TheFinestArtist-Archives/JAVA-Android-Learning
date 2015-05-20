// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslServer;

class saslServer
{

    public SaslClient saslClient;
    public SaslServer saslServer;

    public void dispose()
    {
        if (saslClient != null)
        {
            saslClient.dispose();
            return;
        } else
        {
            saslServer.dispose();
            return;
        }
    }

    public byte[] evaluateChallengeOrResponse(byte abyte0[])
    {
        if (saslClient != null)
        {
            return saslClient.evaluateChallenge(abyte0);
        } else
        {
            return saslServer.evaluateResponse(abyte0);
        }
    }

    public Object getNegotiatedProperty(String s)
    {
        if (saslClient != null)
        {
            return saslClient.getNegotiatedProperty(s);
        } else
        {
            return saslServer.getNegotiatedProperty(s);
        }
    }

    public boolean isComplete()
    {
        if (saslClient != null)
        {
            return saslClient.isComplete();
        } else
        {
            return saslServer.isComplete();
        }
    }

    public byte[] unwrap(byte abyte0[], int i, int j)
    {
        if (saslClient != null)
        {
            return saslClient.unwrap(abyte0, i, j);
        } else
        {
            return saslServer.unwrap(abyte0, i, j);
        }
    }

    public byte[] wrap(byte abyte0[], int i, int j)
    {
        if (saslClient != null)
        {
            return saslClient.wrap(abyte0, i, j);
        } else
        {
            return saslServer.wrap(abyte0, i, j);
        }
    }

    public (SaslClient saslclient)
    {
        saslClient = saslclient;
    }

    public saslClient(SaslServer saslserver)
    {
        saslServer = saslserver;
    }
}
