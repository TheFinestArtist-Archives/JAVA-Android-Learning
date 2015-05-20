// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.scheme;

import org.apache.thrift.TBase;
import org.apache.thrift.protocol.TProtocol;

public interface IScheme
{

    public abstract void read(TProtocol tprotocol, TBase tbase);

    public abstract void write(TProtocol tprotocol, TBase tbase);
}
