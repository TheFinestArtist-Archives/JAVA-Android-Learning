// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.scribe.exceptions.OAuthException;
import org.scribe.utils.StreamUtils;

public class Response
{

    private static final String EMPTY = "";
    private String body;
    private int code;
    private Map headers;
    private String message;
    private InputStream stream;

    Response(HttpURLConnection httpurlconnection)
    {
        httpurlconnection.connect();
        code = httpurlconnection.getResponseCode();
        message = httpurlconnection.getResponseMessage();
        headers = parseHeaders(httpurlconnection);
        if (!isSuccessful())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        httpurlconnection = httpurlconnection.getInputStream();
_L1:
        stream = httpurlconnection;
        return;
        try
        {
            httpurlconnection = httpurlconnection.getErrorStream();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            throw new OAuthException("The IP address of a host could not be determined.", httpurlconnection);
        }
          goto _L1
    }

    private String parseBodyContents()
    {
        body = StreamUtils.getStreamContents(getStream());
        return body;
    }

    private Map parseHeaders(HttpURLConnection httpurlconnection)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = httpurlconnection.getHeaderFields().keySet().iterator(); iterator.hasNext(); hashmap.put(s, ((List)httpurlconnection.getHeaderFields().get(s)).get(0)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public String getBody()
    {
        if (body != null)
        {
            return body;
        } else
        {
            return parseBodyContents();
        }
    }

    public int getCode()
    {
        return code;
    }

    public String getHeader(String s)
    {
        return (String)headers.get(s);
    }

    public Map getHeaders()
    {
        return headers;
    }

    public String getMessage()
    {
        return message;
    }

    public InputStream getStream()
    {
        return stream;
    }

    public boolean isSuccessful()
    {
        return getCode() >= 200 && getCode() < 400;
    }
}
