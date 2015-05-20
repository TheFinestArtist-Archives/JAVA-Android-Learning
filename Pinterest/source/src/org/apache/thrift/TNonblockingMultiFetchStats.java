// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;


public class TNonblockingMultiFetchStats
{

    private int maxResponseBytes;
    private int numConnectErrorServers;
    private int numInvalidFrameSize;
    private int numOverflowedRecvBuf;
    private int numReadCompletedServers;
    private int numTotalServers;
    private long readTime;
    private int totalRecvBufBytes;

    public TNonblockingMultiFetchStats()
    {
        clear();
    }

    public void clear()
    {
        numTotalServers = 0;
        numReadCompletedServers = 0;
        numConnectErrorServers = 0;
        totalRecvBufBytes = 0;
        maxResponseBytes = 0;
        numOverflowedRecvBuf = 0;
        numInvalidFrameSize = 0;
        readTime = 0L;
    }

    public int getMaxResponseBytes()
    {
        return maxResponseBytes;
    }

    public int getNumConnectErrorServers()
    {
        return numConnectErrorServers;
    }

    public int getNumInvalidFrameSize()
    {
        return numInvalidFrameSize;
    }

    public int getNumOverflowedRecvBuf()
    {
        return numOverflowedRecvBuf;
    }

    public int getNumReadCompletedServers()
    {
        return numReadCompletedServers;
    }

    public int getNumTotalServers()
    {
        return numTotalServers;
    }

    public long getReadTime()
    {
        return readTime;
    }

    public int getTotalRecvBufBytes()
    {
        return totalRecvBufBytes;
    }

    public void incNumConnectErrorServers()
    {
        numConnectErrorServers = numConnectErrorServers + 1;
    }

    public void incNumInvalidFrameSize()
    {
        numInvalidFrameSize = numInvalidFrameSize + 1;
    }

    public void incNumOverflowedRecvBuf()
    {
        numOverflowedRecvBuf = numOverflowedRecvBuf + 1;
    }

    public void incNumReadCompletedServers()
    {
        numReadCompletedServers = numReadCompletedServers + 1;
    }

    public void incTotalRecvBufBytes(int i)
    {
        totalRecvBufBytes = totalRecvBufBytes + i;
    }

    public void setMaxResponseBytes(int i)
    {
        maxResponseBytes = i;
    }

    public void setNumTotalServers(int i)
    {
        numTotalServers = i;
    }

    public void setReadTime(long l)
    {
        readTime = l;
    }

    public String toString()
    {
        return String.format("numTotalServers=%d, numReadCompletedServers=%d, numConnectErrorServers=%d, numUnresponsiveServers=%d, totalRecvBufBytes=%fM, maxResponseBytes=%d, numOverflowedRecvBuf=%d, numInvalidFrameSize=%d, readTime=%dms", new Object[] {
            Integer.valueOf(numTotalServers), Integer.valueOf(numReadCompletedServers), Integer.valueOf(numConnectErrorServers), Integer.valueOf(numTotalServers - numReadCompletedServers - numConnectErrorServers), Double.valueOf((double)totalRecvBufBytes / 1024D / 1024D), Integer.valueOf(maxResponseBytes), Integer.valueOf(numOverflowedRecvBuf), Integer.valueOf(numInvalidFrameSize), Long.valueOf(readTime)
        });
    }
}
