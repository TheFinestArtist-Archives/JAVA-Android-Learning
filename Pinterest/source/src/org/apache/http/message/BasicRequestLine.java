// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package org.apache.http.message:
//            BasicLineFormatter

public class BasicRequestLine
    implements Serializable, Cloneable, RequestLine
{

    private static final long serialVersionUID = 0x2701312e8d8938a9L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public BasicRequestLine(String s, String s1, ProtocolVersion protocolversion)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Method must not be null.");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("URI must not be null.");
        }
        if (protocolversion == null)
        {
            throw new IllegalArgumentException("Protocol version must not be null.");
        } else
        {
            method = s;
            uri = s1;
            protoversion = protocolversion;
            return;
        }
    }

    public Object clone()
    {
        return super.clone();
    }

    public String getMethod()
    {
        return method;
    }

    public ProtocolVersion getProtocolVersion()
    {
        return protoversion;
    }

    public String getUri()
    {
        return uri;
    }

    public String toString()
    {
        return BasicLineFormatter.DEFAULT.formatRequestLine(null, this).toString();
    }
}
