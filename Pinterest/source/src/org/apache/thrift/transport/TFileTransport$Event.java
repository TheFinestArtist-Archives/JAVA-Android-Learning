// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


public class nread_
{

    private byte buf_[];
    private int navailable_;
    private int nread_;

    public int emit(byte abyte0[], int i, int j)
    {
        if (j == 0 || j > getRemaining())
        {
            j = getRemaining();
        }
        if (j <= 0)
        {
            return j;
        } else
        {
            System.arraycopy(buf_, nread_, abyte0, i, j);
            nread_ = nread_ + j;
            return j;
        }
    }

    public byte[] getBuf()
    {
        return buf_;
    }

    public int getRemaining()
    {
        return navailable_ - nread_;
    }

    public int getSize()
    {
        return buf_.length;
    }

    public void setAvailable(int i)
    {
        nread_ = 0;
        navailable_ = i;
    }

    public (byte abyte0[])
    {
        buf_ = abyte0;
        navailable_ = 0;
        nread_ = 0;
    }
}
