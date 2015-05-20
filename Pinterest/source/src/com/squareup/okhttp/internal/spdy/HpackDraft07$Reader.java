// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.BitArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, HpackDraft07, Huffman

final class h
{

    Header a[];
    int b;
    int c;
    BitArray d;
    BitArray e;
    int f;
    private final List g = new ArrayList();
    private final BufferedSource h;
    private int i;
    private int j;

    private int a(int k, int l)
    {
        k &= l;
        if (k < l)
        {
            return k;
        }
        k = 0;
        do
        {
            int i1 = g();
            if ((i1 & 0x80) != 0)
            {
                l += (i1 & 0x7f) << k;
                k += 7;
            } else
            {
                return (i1 << k) + l;
            }
        } while (true);
    }

    private void a(Header header)
    {
        int k = header.j;
        if (k > j)
        {
            e();
            g.add(header);
            return;
        }
        b((f + k) - j);
        if (c + 1 > a.length)
        {
            Header aheader[] = new Header[a.length * 2];
            System.arraycopy(a, 0, aheader, a.length, a.length);
            if (aheader.length == 64)
            {
                d = ((com.squareup.okhttp.internal.ty)d).a();
                e = ((com.squareup.okhttp.internal.ty)e).a();
            }
            d.shiftLeft(a.length);
            e.shiftLeft(a.length);
            b = a.length - 1;
            a = aheader;
        }
        int l = b;
        b = l - 1;
        d.set(l);
        a[l] = header;
        c = c + 1;
        f = f + k;
    }

    private int b(int k)
    {
        int l = 0;
        boolean flag = false;
        if (k > 0)
        {
            l = a.length - 1;
            int i1 = k;
            k = ((flag) ? 1 : 0);
            for (; l >= b && i1 > 0; l--)
            {
                i1 -= a[l].j;
                f = f - a[l].j;
                c = c - 1;
                k++;
            }

            d.shiftLeft(k);
            e.shiftLeft(k);
            System.arraycopy(a, b + 1, a, b + 1 + k, c);
            b = b + k;
            l = k;
        }
        return l;
    }

    private int c(int k)
    {
        return b + 1 + k;
    }

    private ByteString d(int k)
    {
        if (e(k))
        {
            return HpackDraft07.a()[k - c].h;
        } else
        {
            return a[c(k)].h;
        }
    }

    private void d()
    {
label0:
        {
            if (j < f)
            {
                if (j != 0)
                {
                    break label0;
                }
                e();
            }
            return;
        }
        b(f - j);
    }

    private void e()
    {
        f();
        Arrays.fill(a, null);
        b = a.length - 1;
        c = 0;
        f = 0;
    }

    private boolean e(int k)
    {
        return k >= c;
    }

    private void f()
    {
        d.clear();
        e.clear();
    }

    private int g()
    {
        return h.h() & 0xff;
    }

    private ByteString h()
    {
        int k = g();
        boolean flag;
        if ((k & 0x80) == 128)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = a(k, 127);
        if (flag)
        {
            return ByteString.a(Huffman.a().a(h.f(k)));
        } else
        {
            return h.c(k);
        }
    }

    final void a()
    {
        while (!h.f()) 
        {
            int k = h.h() & 0xff;
            if (k == 128)
            {
                throw new IOException("index == 0");
            }
            if ((k & 0x80) == 128)
            {
                k = a(k, 127) - 1;
                if (e(k))
                {
                    k -= c;
                    if (k > HpackDraft07.a().length - 1)
                    {
                        throw new IOException((new StringBuilder("Header index too large ")).append(k + 1).toString());
                    }
                    Header header = HpackDraft07.a()[k];
                    if (j == 0)
                    {
                        g.add(header);
                    } else
                    {
                        a(header);
                    }
                } else
                {
                    k = c(k);
                    if (!d.get(k))
                    {
                        g.add(a[k]);
                        e.set(k);
                    }
                    d.toggle(k);
                }
            } else
            if (k == 64)
            {
                a(new Header(HpackDraft07.a(h()), h()));
            } else
            if ((k & 0x40) == 64)
            {
                a(new Header(d(a(k, 63) - 1), h()));
            } else
            if ((k & 0x20) == 32)
            {
                if ((k & 0x10) == 16)
                {
                    if ((k & 0xf) != 0)
                    {
                        throw new IOException((new StringBuilder("Invalid header table state change ")).append(k).toString());
                    }
                    f();
                } else
                {
                    j = a(k, 15);
                    if (j < 0 || j > i)
                    {
                        throw new IOException((new StringBuilder("Invalid header table byte count ")).append(j).toString());
                    }
                    d();
                }
            } else
            if (k == 16 || k == 0)
            {
                ByteString bytestring = HpackDraft07.a(h());
                ByteString bytestring2 = h();
                g.add(new Header(bytestring, bytestring2));
            } else
            {
                ByteString bytestring1 = d(a(k, 15) - 1);
                ByteString bytestring3 = h();
                g.add(new Header(bytestring1, bytestring3));
            }
        }
    }

    final void a(int k)
    {
        i = k;
        j = i;
        d();
    }

    final void b()
    {
        for (int k = a.length - 1; k != b; k--)
        {
            if (d.get(k) && !e.get(k))
            {
                g.add(a[k]);
            }
        }

    }

    final List c()
    {
        ArrayList arraylist = new ArrayList(g);
        g.clear();
        e.clear();
        return arraylist;
    }

    (Source source)
    {
        a = new Header[8];
        b = a.length - 1;
        c = 0;
        d = new com.squareup.okhttp.internal.ty();
        e = new com.squareup.okhttp.internal.ty();
        f = 0;
        i = 4096;
        j = 4096;
        h = Okio.a(source);
    }
}
