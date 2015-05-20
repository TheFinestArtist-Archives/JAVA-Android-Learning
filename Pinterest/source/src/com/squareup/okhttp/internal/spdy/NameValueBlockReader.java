// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.InflaterSource;
import okio.Okio;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header

class NameValueBlockReader
{

    private final InflaterSource a;
    private int b;
    private final BufferedSource c;

    public NameValueBlockReader(BufferedSource bufferedsource)
    {
        a = new InflaterSource(new _cls1(bufferedsource), new _cls2());
        c = Okio.a(a);
    }

    static int a(NameValueBlockReader namevalueblockreader)
    {
        return namevalueblockreader.b;
    }

    static int a(NameValueBlockReader namevalueblockreader, long l)
    {
        int i = (int)((long)namevalueblockreader.b - l);
        namevalueblockreader.b = i;
        return i;
    }

    private ByteString b()
    {
        int i = c.j();
        return c.c(i);
    }

    public final List a(int i)
    {
        b = b + i;
        int j = c.j();
        if (j < 0)
        {
            throw new IOException((new StringBuilder("numberOfPairs < 0: ")).append(j).toString());
        }
        if (j > 1024)
        {
            throw new IOException((new StringBuilder("numberOfPairs > 1024: ")).append(j).toString());
        }
        ArrayList arraylist = new ArrayList(j);
        for (i = 0; i < j; i++)
        {
            ByteString bytestring = b().d();
            ByteString bytestring1 = b();
            if (bytestring.e() == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new Header(bytestring, bytestring1));
        }

        if (b > 0)
        {
            a.b();
            if (b != 0)
            {
                throw new IOException((new StringBuilder("compressedLimit > 0: ")).append(b).toString());
            }
        }
        return arraylist;
    }

    public final void a()
    {
        c.close();
    }

    private class _cls1 extends ForwardingSource
    {

        final NameValueBlockReader a;

        public final long b(Buffer buffer, long l)
        {
            if (NameValueBlockReader.a(a) != 0)
            {
                if ((l = super.b(buffer, Math.min(l, NameValueBlockReader.a(a)))) != -1L)
                {
                    NameValueBlockReader.a(a, l);
                    return l;
                }
            }
            return -1L;
        }

        _cls1(Source source)
        {
            a = NameValueBlockReader.this;
            super(source);
        }
    }


    private class _cls2 extends Inflater
    {

        final NameValueBlockReader a;

        public int inflate(byte abyte0[], int i, int j)
        {
            int l = super.inflate(abyte0, i, j);
            int k = l;
            if (l == 0)
            {
                k = l;
                if (needsDictionary())
                {
                    setDictionary(Spdy3.a);
                    k = super.inflate(abyte0, i, j);
                }
            }
            return k;
        }

        _cls2()
        {
            a = NameValueBlockReader.this;
            super();
        }
    }

}
