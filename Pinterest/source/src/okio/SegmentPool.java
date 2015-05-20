// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;


// Referenced classes of package okio:
//            Segment

final class SegmentPool
{

    static final SegmentPool a = new SegmentPool();
    long b;
    private Segment c;

    private SegmentPool()
    {
    }

    final Segment a()
    {
        this;
        JVM INSTR monitorenter ;
        Segment segment;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        segment = c;
        c = segment.d;
        segment.d = null;
        b = b - 2048L;
        return segment;
        this;
        JVM INSTR monitorexit ;
        return new Segment();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void a(Segment segment)
    {
        if (segment.d != null || segment.e != null)
        {
            throw new IllegalArgumentException();
        }
        this;
        JVM INSTR monitorenter ;
        if (b + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        b = b + 2048L;
        segment.d = c;
        segment.c = 0;
        segment.b = 0;
        c = segment;
        this;
        JVM INSTR monitorexit ;
        return;
        segment;
        this;
        JVM INSTR monitorexit ;
        throw segment;
    }

}
