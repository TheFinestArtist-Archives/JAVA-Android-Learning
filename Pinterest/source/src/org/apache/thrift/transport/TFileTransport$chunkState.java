// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


public class chunk_size_
{

    public static final int DEFAULT_CHUNK_SIZE = 0x1000000;
    private int chunk_size_;
    private long offset_;

    public int getChunkNum()
    {
        return (int)(offset_ / (long)chunk_size_);
    }

    public int getChunkSize()
    {
        return chunk_size_;
    }

    public long getOffset()
    {
        return offset_;
    }

    public int getRemaining()
    {
        return chunk_size_ - (int)(offset_ % (long)chunk_size_);
    }

    public void seek(long l)
    {
        offset_ = l;
    }

    public void skip(int i)
    {
        offset_ = offset_ + (long)i;
    }

    public ()
    {
        chunk_size_ = 0x1000000;
        offset_ = 0L;
    }

    public offset_(int i)
    {
        chunk_size_ = 0x1000000;
        offset_ = 0L;
        chunk_size_ = i;
    }
}
