// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

// Referenced classes of package org.apache.thrift.transport:
//            TSeekableFile

public class TStandardFile
    implements TSeekableFile
{

    protected RandomAccessFile inputFile_;
    protected String path_;

    public TStandardFile(String s)
    {
        path_ = null;
        inputFile_ = null;
        path_ = s;
        inputFile_ = new RandomAccessFile(path_, "r");
    }

    public void close()
    {
        if (inputFile_ != null)
        {
            inputFile_.close();
        }
    }

    public InputStream getInputStream()
    {
        return new FileInputStream(inputFile_.getFD());
    }

    public OutputStream getOutputStream()
    {
        return new FileOutputStream(path_);
    }

    public long length()
    {
        return inputFile_.length();
    }

    public void seek(long l)
    {
        inputFile_.seek(l);
    }
}
