// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response;
import java.net.ProtocolException;

public final class StatusLine
{

    public final Protocol a;
    public final int b;
    public final String c;

    public StatusLine(Protocol protocol, int i, String s)
    {
        a = protocol;
        b = i;
        c = s;
    }

    public static StatusLine a(Response response)
    {
        return new StatusLine(response.b(), response.c(), response.d());
    }

    public static StatusLine a(String s)
    {
        byte byte0 = 9;
        Object obj;
        if (s.startsWith("HTTP/1."))
        {
            if (s.length() < 9 || s.charAt(8) != ' ')
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
            }
            int i = s.charAt(7) - 48;
            if (i == 0)
            {
                obj = Protocol.a;
            } else
            if (i == 1)
            {
                obj = Protocol.b;
            } else
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
            }
        } else
        if (s.startsWith("ICY "))
        {
            obj = Protocol.a;
            byte0 = 4;
        } else
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        if (s.length() < byte0 + 3)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        int j;
        try
        {
            j = Integer.parseInt(s.substring(byte0, byte0 + 3));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
        }
        if (s.length() > byte0 + 3)
        {
            if (s.charAt(byte0 + 3) != ' ')
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s).toString());
            }
            s = s.substring(byte0 + 4);
        } else
        {
            s = "";
        }
        return new StatusLine(((Protocol) (obj)), j, s);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (a == Protocol.a)
        {
            s = "HTTP/1.0";
        } else
        {
            s = "HTTP/1.1";
        }
        stringbuilder.append(s);
        stringbuilder.append(' ').append(b);
        if (c != null)
        {
            stringbuilder.append(' ').append(c);
        }
        return stringbuilder.toString();
    }
}
