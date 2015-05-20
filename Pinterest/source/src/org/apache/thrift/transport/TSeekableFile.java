// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.InputStream;
import java.io.OutputStream;

public interface TSeekableFile
{

    public abstract void close();

    public abstract InputStream getInputStream();

    public abstract OutputStream getOutputStream();

    public abstract long length();

    public abstract void seek(long l);
}
