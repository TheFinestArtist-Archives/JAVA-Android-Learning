// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;

public class TServlet extends HttpServlet
{

    private final Collection customHeaders;
    private final TProtocolFactory inProtocolFactory;
    private final TProtocolFactory outProtocolFactory;
    private final TProcessor processor;

    public TServlet(TProcessor tprocessor, TProtocolFactory tprotocolfactory)
    {
        this(tprocessor, tprotocolfactory, tprotocolfactory);
    }

    public TServlet(TProcessor tprocessor, TProtocolFactory tprotocolfactory, TProtocolFactory tprotocolfactory1)
    {
        processor = tprocessor;
        inProtocolFactory = tprotocolfactory;
        outProtocolFactory = tprotocolfactory1;
        customHeaders = new ArrayList();
    }

    public void addCustomHeader(final String key, final String value)
    {
        customHeaders.add(new _cls1());
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        doPost(httpservletrequest, httpservletresponse);
    }

    protected void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            httpservletresponse.setContentType("application/x-thrift");
            if (customHeaders != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = customHeaders.iterator(); iterator.hasNext(); httpservletresponse.addHeader((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpServletRequest httpservletrequest)
        {
            throw new ServletException(httpservletrequest);
        }
        Object obj = httpservletrequest.getInputStream();
        httpservletrequest = httpservletresponse.getOutputStream();
        obj = new TIOStreamTransport(((java.io.InputStream) (obj)), httpservletrequest);
        httpservletresponse = inProtocolFactory.getProtocol(((org.apache.thrift.transport.TTransport) (obj)));
        obj = outProtocolFactory.getProtocol(((org.apache.thrift.transport.TTransport) (obj)));
        processor.process(httpservletresponse, ((org.apache.thrift.protocol.TProtocol) (obj)));
        httpservletrequest.flush();
        return;
    }

    public void setCustomHeaders(Collection collection)
    {
        customHeaders.clear();
        customHeaders.addAll(collection);
    }

    private class _cls1
        implements java.util.Map.Entry
    {

        final TServlet this$0;
        final String val$key;
        final String val$value;

        public volatile Object getKey()
        {
            return getKey();
        }

        public String getKey()
        {
            return key;
        }

        public volatile Object getValue()
        {
            return getValue();
        }

        public String getValue()
        {
            return value;
        }

        public volatile Object setValue(Object obj)
        {
            return setValue((String)obj);
        }

        public String setValue(String s)
        {
            return null;
        }

        _cls1()
        {
            this$0 = TServlet.this;
            key = s;
            value = s1;
            super();
        }
    }

}
