// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.scribe.exceptions.OAuthConnectionException;
import org.scribe.exceptions.OAuthException;

// Referenced classes of package org.scribe.model:
//            ParameterList, Verb, RequestTuner, Response

public class Request
{

    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static RequestTuner NOOP = new _cls1();
    private ParameterList bodyParams;
    private byte bytePayload[];
    private String charset;
    private Long connectTimeout;
    private HttpURLConnection connection;
    private boolean connectionKeepAlive;
    private boolean followRedirects;
    private Map headers;
    private String payload;
    private ParameterList querystringParams;
    private Long readTimeout;
    private String url;
    private Verb verb;

    public Request(Verb verb1, String s)
    {
        payload = null;
        bytePayload = null;
        connectionKeepAlive = false;
        followRedirects = true;
        connectTimeout = null;
        readTimeout = null;
        verb = verb1;
        url = s;
        querystringParams = new ParameterList();
        bodyParams = new ParameterList();
        headers = new HashMap();
    }

    private void createConnection()
    {
        String s1 = getCompleteUrl();
        if (connection == null)
        {
            String s;
            if (connectionKeepAlive)
            {
                s = "true";
            } else
            {
                s = "false";
            }
            System.setProperty("http.keepAlive", s);
            connection = (HttpURLConnection)(new URL(s1)).openConnection();
            connection.setInstanceFollowRedirects(followRedirects);
        }
    }

    void addBody(HttpURLConnection httpurlconnection, byte abyte0[])
    {
        httpurlconnection.setRequestProperty("Content-Length", String.valueOf(abyte0.length));
        if (httpurlconnection.getRequestProperty("Content-Type") == null)
        {
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        httpurlconnection.setDoOutput(true);
        httpurlconnection.getOutputStream().write(abyte0);
    }

    public void addBodyParameter(String s, String s1)
    {
        bodyParams.add(s, s1);
    }

    public void addHeader(String s, String s1)
    {
        headers.put(s, s1);
    }

    void addHeaders(HttpURLConnection httpurlconnection)
    {
        String s;
        for (Iterator iterator = headers.keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s, (String)headers.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    public void addPayload(String s)
    {
        payload = s;
    }

    public void addPayload(byte abyte0[])
    {
        bytePayload = (byte[])abyte0.clone();
    }

    public void addQuerystringParameter(String s, String s1)
    {
        querystringParams.add(s, s1);
    }

    Response doSend(RequestTuner requesttuner)
    {
        connection.setRequestMethod(verb.name());
        if (connectTimeout != null)
        {
            connection.setConnectTimeout(connectTimeout.intValue());
        }
        if (readTimeout != null)
        {
            connection.setReadTimeout(readTimeout.intValue());
        }
        addHeaders(connection);
        if (verb.equals(Verb.PUT) || verb.equals(Verb.POST))
        {
            addBody(connection, getByteBodyContents());
        }
        requesttuner.tune(this);
        return new Response(connection);
    }

    public String getBodyContents()
    {
        String s;
        try
        {
            s = new String(getByteBodyContents(), getCharset());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new OAuthException((new StringBuilder("Unsupported Charset: ")).append(charset).toString(), unsupportedencodingexception);
        }
        return s;
    }

    public ParameterList getBodyParams()
    {
        return bodyParams;
    }

    byte[] getByteBodyContents()
    {
        if (bytePayload != null)
        {
            return bytePayload;
        }
        Object obj;
        if (payload != null)
        {
            obj = payload;
        } else
        {
            obj = bodyParams.asFormUrlEncodedString();
        }
        try
        {
            obj = ((String) (obj)).getBytes(getCharset());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new OAuthException((new StringBuilder("Unsupported Charset: ")).append(getCharset()).toString(), unsupportedencodingexception);
        }
        return ((byte []) (obj));
    }

    public String getCharset()
    {
        if (charset == null)
        {
            return Charset.defaultCharset().name();
        } else
        {
            return charset;
        }
    }

    public String getCompleteUrl()
    {
        return querystringParams.appendTo(url);
    }

    public Map getHeaders()
    {
        return headers;
    }

    public ParameterList getQueryStringParams()
    {
        ParameterList parameterlist;
        try
        {
            parameterlist = new ParameterList();
            parameterlist.addQuerystring((new URL(url)).getQuery());
            parameterlist.addAll(querystringParams);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new OAuthException("Malformed URL", malformedurlexception);
        }
        return parameterlist;
    }

    public String getSanitizedUrl()
    {
        if (url.startsWith("http://") && (url.endsWith(":80") || url.contains(":80/")))
        {
            return url.replaceAll("\\?.*", "").replaceAll(":80", "");
        }
        if (url.startsWith("https://") && (url.endsWith(":443") || url.contains(":443/")))
        {
            return url.replaceAll("\\?.*", "").replaceAll(":443", "");
        } else
        {
            return url.replaceAll("\\?.*", "");
        }
    }

    public String getUrl()
    {
        return url;
    }

    public Verb getVerb()
    {
        return verb;
    }

    public Response send()
    {
        return send(NOOP);
    }

    public Response send(RequestTuner requesttuner)
    {
        try
        {
            createConnection();
            requesttuner = doSend(requesttuner);
        }
        // Misplaced declaration of an exception variable
        catch (RequestTuner requesttuner)
        {
            throw new OAuthConnectionException(requesttuner);
        }
        return requesttuner;
    }

    public void setCharset(String s)
    {
        charset = s;
    }

    public void setConnectTimeout(int i, TimeUnit timeunit)
    {
        connectTimeout = Long.valueOf(timeunit.toMillis(i));
    }

    void setConnection(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }

    public void setConnectionKeepAlive(boolean flag)
    {
        connectionKeepAlive = flag;
    }

    public void setFollowRedirects(boolean flag)
    {
        followRedirects = flag;
    }

    public void setReadTimeout(int i, TimeUnit timeunit)
    {
        readTimeout = Long.valueOf(timeunit.toMillis(i));
    }

    public String toString()
    {
        return String.format("@Request(%s %s)", new Object[] {
            getVerb(), getUrl()
        });
    }


    private class _cls1 extends RequestTuner
    {

        public final void tune(Request request)
        {
        }

        _cls1()
        {
        }
    }

}
