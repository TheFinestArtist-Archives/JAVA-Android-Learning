// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.ByteArrayOutputStream;

public class TByteArrayOutputStream extends ByteArrayOutputStream
{

    public TByteArrayOutputStream()
    {
    }

    public TByteArrayOutputStream(int i)
    {
        super(i);
    }

    public byte[] get()
    {
        return buf;
    }

    public int len()
    {
        return count;
    }
}
