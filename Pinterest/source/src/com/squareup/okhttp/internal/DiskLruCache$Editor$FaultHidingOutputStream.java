// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class <init> extends FilterOutputStream
{

    final a a;

    public void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            out(a);
        }
    }

    public void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            out(a);
        }
    }

    public void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            out(a);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            out(a);
        }
    }

    private ( , OutputStream outputstream)
    {
        a = ;
        super(outputstream);
    }

    a(a a1, OutputStream outputstream, byte byte0)
    {
        this(a1, outputstream);
    }
}
