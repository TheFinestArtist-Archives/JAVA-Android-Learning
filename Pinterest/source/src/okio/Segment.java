// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;


final class Segment
{

    final byte a[] = new byte[2048];
    int b;
    int c;
    Segment d;
    Segment e;

    Segment()
    {
    }

    public final Segment a()
    {
        Segment segment;
        if (d != this)
        {
            segment = d;
        } else
        {
            segment = null;
        }
        e.d = d;
        d.e = e;
        d = null;
        e = null;
        return segment;
    }

    public final Segment a(Segment segment)
    {
        segment.e = this;
        segment.d = d;
        d.e = segment;
        d = segment;
        return segment;
    }

    public final void a(Segment segment, int i)
    {
        if ((segment.c - segment.b) + i > 2048)
        {
            throw new IllegalArgumentException();
        }
        if (segment.c + i > 2048)
        {
            System.arraycopy(segment.a, segment.b, segment.a, 0, segment.c - segment.b);
            segment.c = segment.c - segment.b;
            segment.b = 0;
        }
        System.arraycopy(a, b, segment.a, segment.c, i);
        segment.c = segment.c + i;
        b = b + i;
    }
}
