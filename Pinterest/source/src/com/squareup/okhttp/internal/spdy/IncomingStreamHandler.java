// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;


// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream

public interface IncomingStreamHandler
{

    public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new _cls1();

    public abstract void receive(SpdyStream spdystream);


    private class _cls1
        implements IncomingStreamHandler
    {

        public final void receive(SpdyStream spdystream)
        {
            spdystream.a(ErrorCode.k);
        }

        _cls1()
        {
        }
    }

}
