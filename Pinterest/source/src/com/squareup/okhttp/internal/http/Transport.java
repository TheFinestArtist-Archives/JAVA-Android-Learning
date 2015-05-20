// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import java.net.CacheRequest;
import okio.Sink;
import okio.Source;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine, RetryableSink

public interface Transport
{

    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    public abstract boolean canReuseConnection();

    public abstract Sink createRequestBody(Request request);

    public abstract void disconnect(HttpEngine httpengine);

    public abstract void emptyTransferStream();

    public abstract void flushRequest();

    public abstract Source getTransferStream(CacheRequest cacherequest);

    public abstract com.squareup.okhttp.Response.Builder readResponseHeaders();

    public abstract void releaseConnectionOnIdle();

    public abstract void writeRequestBody(RetryableSink retryablesink);

    public abstract void writeRequestHeaders(Request request);
}
