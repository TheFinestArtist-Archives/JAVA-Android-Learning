// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import org.apache.thrift.TByteArrayOutputStream;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport

public class TMemoryBuffer extends TTransport
{

    private TByteArrayOutputStream arr_;
    private int pos_;

    public TMemoryBuffer(int i)
    {
        arr_ = new TByteArrayOutputStream(i);
    }

    public void close()
    {
    }

    public byte[] getArray()
    {
        return arr_.get();
    }

    public String inspect()
    {
        String s = "";
        byte abyte0[] = arr_.toByteArray();
        int i = 0;
        while (i < abyte0.length) 
        {
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if (pos_ == i)
            {
                s = "==>";
            } else
            {
                s = "";
            }
            s = stringbuilder.append(s).append(Integer.toHexString(abyte0[i] & 0xff)).append(" ").toString();
            i++;
        }
        return s;
    }

    public boolean isOpen()
    {
        return true;
    }

    public int length()
    {
        return arr_.size();
    }

    public void open()
    {
    }

    public int read(byte abyte0[], int i, int j)
    {
        byte abyte1[] = arr_.get();
        int k = j;
        if (j > arr_.len() - pos_)
        {
            k = arr_.len() - pos_;
        }
        if (k > 0)
        {
            System.arraycopy(abyte1, pos_, abyte0, i, k);
            pos_ = pos_ + k;
        }
        return k;
    }

    public String toString(String s)
    {
        return arr_.toString(s);
    }

    public void write(byte abyte0[], int i, int j)
    {
        arr_.write(abyte0, i, j);
    }
}
