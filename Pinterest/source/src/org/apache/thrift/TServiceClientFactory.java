// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TProtocol;

// Referenced classes of package org.apache.thrift:
//            TServiceClient

public interface TServiceClientFactory
{

    public abstract TServiceClient getClient(TProtocol tprotocol);

    public abstract TServiceClient getClient(TProtocol tprotocol, TProtocol tprotocol1);
}
