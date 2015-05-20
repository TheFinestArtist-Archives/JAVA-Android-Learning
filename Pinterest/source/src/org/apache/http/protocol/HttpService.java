// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.protocol;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

// Referenced classes of package org.apache.http.protocol:
//            HttpRequestHandlerResolver, HttpRequestHandler, HttpContext, HttpExpectationVerifier, 
//            HttpProcessor

public class HttpService
{

    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerResolver handlerResolver;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory)
    {
        params = null;
        processor = null;
        handlerResolver = null;
        connStrategy = null;
        responseFactory = null;
        expectationVerifier = null;
        setHttpProcessor(httpprocessor);
        setConnReuseStrategy(connectionreusestrategy);
        setResponseFactory(httpresponsefactory);
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerResolver httprequesthandlerresolver, HttpParams httpparams)
    {
        this(httpprocessor, connectionreusestrategy, httpresponsefactory, httprequesthandlerresolver, null, httpparams);
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerResolver httprequesthandlerresolver, HttpExpectationVerifier httpexpectationverifier, HttpParams httpparams)
    {
        params = null;
        processor = null;
        handlerResolver = null;
        connStrategy = null;
        responseFactory = null;
        expectationVerifier = null;
        if (httpprocessor == null)
        {
            throw new IllegalArgumentException("HTTP processor may not be null");
        }
        if (connectionreusestrategy == null)
        {
            throw new IllegalArgumentException("Connection reuse strategy may not be null");
        }
        if (httpresponsefactory == null)
        {
            throw new IllegalArgumentException("Response factory may not be null");
        }
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            processor = httpprocessor;
            connStrategy = connectionreusestrategy;
            responseFactory = httpresponsefactory;
            handlerResolver = httprequesthandlerresolver;
            expectationVerifier = httpexpectationverifier;
            params = httpparams;
            return;
        }
    }

    protected void doService(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
    {
        Object obj = null;
        if (handlerResolver != null)
        {
            obj = httprequest.getRequestLine().getUri();
            obj = handlerResolver.lookup(((String) (obj)));
        }
        if (obj != null)
        {
            ((HttpRequestHandler) (obj)).handle(httprequest, httpresponse, httpcontext);
            return;
        } else
        {
            httpresponse.setStatusCode(501);
            return;
        }
    }

    public HttpParams getParams()
    {
        return params;
    }

    protected void handleException(HttpException httpexception, HttpResponse httpresponse)
    {
        String s;
        String s1;
        if (httpexception instanceof MethodNotSupportedException)
        {
            httpresponse.setStatusCode(501);
        } else
        if (httpexception instanceof UnsupportedHttpVersionException)
        {
            httpresponse.setStatusCode(505);
        } else
        if (httpexception instanceof ProtocolException)
        {
            httpresponse.setStatusCode(400);
        } else
        {
            httpresponse.setStatusCode(500);
        }
        s1 = httpexception.getMessage();
        s = s1;
        if (s1 == null)
        {
            s = httpexception.toString();
        }
        httpexception = new ByteArrayEntity(EncodingUtils.getAsciiBytes(s));
        httpexception.setContentType("text/plain; charset=US-ASCII");
        httpresponse.setEntity(httpexception);
    }

    public void handleRequest(HttpServerConnection httpserverconnection, HttpContext httpcontext)
    {
        httpcontext.setAttribute("http.connection", httpserverconnection);
        HttpRequest httprequest;
        httprequest = httpserverconnection.receiveRequestHeader();
        httprequest.setParams(new DefaultedHttpParams(httprequest.getParams(), params));
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_460;
        }
        if (!((HttpEntityEnclosingRequest)httprequest).expectContinue()) goto _L2; else goto _L1
_L1:
        Object obj1;
        HttpExpectationVerifier httpexpectationverifier;
        obj1 = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpcontext);
        ((HttpResponse) (obj1)).setParams(new DefaultedHttpParams(((HttpResponse) (obj1)).getParams(), params));
        httpexpectationverifier = expectationVerifier;
        Object obj;
        obj = obj1;
        if (httpexpectationverifier == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        expectationVerifier.verify(httprequest, ((HttpResponse) (obj1)), httpcontext);
        obj = obj1;
_L5:
        obj1 = obj;
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() >= 200) goto _L4; else goto _L3
_L3:
        httpserverconnection.sendResponseHeader(((HttpResponse) (obj)));
        httpserverconnection.flush();
_L2:
        httpserverconnection.receiveRequestEntity((HttpEntityEnclosingRequest)httprequest);
        break MISSING_BLOCK_LABEL_460;
_L4:
        httpcontext.setAttribute("http.request", httprequest);
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        obj = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpcontext);
        ((HttpResponse) (obj)).setParams(new DefaultedHttpParams(((HttpResponse) (obj)).getParams(), params));
        processor.process(httprequest, httpcontext);
        doService(httprequest, ((HttpResponse) (obj)), httpcontext);
        obj1 = obj;
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_288;
        }
        EntityUtils.consume(((HttpEntityEnclosingRequest)httprequest).getEntity());
        obj1 = obj;
_L6:
        httpcontext.setAttribute("http.response", obj1);
        processor.process(((HttpResponse) (obj1)), httpcontext);
        httpserverconnection.sendResponseHeader(((HttpResponse) (obj1)));
        httpserverconnection.sendResponseEntity(((HttpResponse) (obj1)));
        httpserverconnection.flush();
        if (!connStrategy.keepAlive(((HttpResponse) (obj1)), httpcontext))
        {
            httpserverconnection.close();
        }
        return;
        obj1;
        obj = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpcontext);
        ((HttpResponse) (obj)).setParams(new DefaultedHttpParams(((HttpResponse) (obj)).getParams(), params));
        handleException(((HttpException) (obj1)), ((HttpResponse) (obj)));
          goto _L5
        HttpException httpexception;
        httpexception;
        obj1 = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpcontext);
        ((HttpResponse) (obj1)).setParams(new DefaultedHttpParams(((HttpResponse) (obj1)).getParams(), params));
        handleException(httpexception, ((HttpResponse) (obj1)));
          goto _L6
        obj1 = null;
          goto _L4
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connectionreusestrategy)
    {
        if (connectionreusestrategy == null)
        {
            throw new IllegalArgumentException("Connection reuse strategy may not be null");
        } else
        {
            connStrategy = connectionreusestrategy;
            return;
        }
    }

    public void setExpectationVerifier(HttpExpectationVerifier httpexpectationverifier)
    {
        expectationVerifier = httpexpectationverifier;
    }

    public void setHandlerResolver(HttpRequestHandlerResolver httprequesthandlerresolver)
    {
        handlerResolver = httprequesthandlerresolver;
    }

    public void setHttpProcessor(HttpProcessor httpprocessor)
    {
        if (httpprocessor == null)
        {
            throw new IllegalArgumentException("HTTP processor may not be null");
        } else
        {
            processor = httpprocessor;
            return;
        }
    }

    public void setParams(HttpParams httpparams)
    {
        params = httpparams;
    }

    public void setResponseFactory(HttpResponseFactory httpresponsefactory)
    {
        if (httpresponsefactory == null)
        {
            throw new IllegalArgumentException("Response factory may not be null");
        } else
        {
            responseFactory = httpresponsefactory;
            return;
        }
    }
}
