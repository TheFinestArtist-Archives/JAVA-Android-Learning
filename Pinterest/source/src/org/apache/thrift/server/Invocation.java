// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;


class Invocation
    implements Runnable
{

    private final AbstractNonblockingServer.FrameBuffer frameBuffer;

    public Invocation(AbstractNonblockingServer.FrameBuffer framebuffer)
    {
        frameBuffer = framebuffer;
    }

    public void run()
    {
        frameBuffer.invoke();
    }
}
