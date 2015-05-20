// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, NameValueBlockReader, Settings, HeadersMode, 
//            ErrorCode

final class b
    implements FrameReader
{

    private final BufferedSource a;
    private final boolean b;
    private final NameValueBlockReader c;

    private static transient IOException a(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    private void a(andler andler, int i, int j)
    {
        boolean flag = true;
        int k = a.j();
        if (j != k * 8 + 4)
        {
            throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(k)
            });
        }
        Settings settings = new Settings();
        for (j = 0; j < k; j++)
        {
            int l = a.j();
            settings.a(l & 0xffffff, (0xff000000 & l) >>> 24, a.j());
        }

        if ((i & 1) == 0)
        {
            flag = false;
        }
        andler.settings(flag, settings);
    }

    public final void close()
    {
        c.a();
    }

    public final boolean nextFrame(andler andler)
    {
        boolean flag = false;
        boolean flag1 = false;
        int i;
        int j;
        int k;
        int l;
        try
        {
            k = a.j();
            l = a.j();
        }
        // Misplaced declaration of an exception variable
        catch (andler andler)
        {
            return false;
        }
        if ((0x80000000 & k) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = (0xff000000 & l) >>> 24;
        l = 0xffffff & l;
        if (i != 0)
        {
            i = (0x7fff0000 & k) >>> 16;
            if (i != 3)
            {
                throw new ProtocolException((new StringBuilder("version != 3: ")).append(i).toString());
            }
            switch (k & 0xffff)
            {
            case 5: // '\005'
            default:
                a.g(l);
                return true;

            case 1: // '\001'
                i = a.j();
                k = a.j();
                a.i();
                java.util.List list = c.a(l - 10);
                if ((j & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if ((j & 2) != 0)
                {
                    flag1 = true;
                }
                andler.headers(flag1, flag, i & 0x7fffffff, k & 0x7fffffff, list, HeadersMode.a);
                return true;

            case 2: // '\002'
                i = a.j();
                java.util.List list1 = c.a(l - 4);
                if ((j & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                andler.headers(false, flag, i & 0x7fffffff, -1, list1, HeadersMode.b);
                return true;

            case 3: // '\003'
                if (l != 8)
                {
                    throw a("TYPE_RST_STREAM length: %d != 8", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.j();
                j = a.j();
                ErrorCode errorcode = ErrorCode.a(j);
                if (errorcode == null)
                {
                    throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                } else
                {
                    andler.rstStream(i & 0x7fffffff, errorcode);
                    return true;
                }

            case 4: // '\004'
                a(andler, j, l);
                return true;

            case 6: // '\006'
                if (l != 4)
                {
                    throw a("TYPE_PING length: %d != 4", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.j();
                boolean flag2 = b;
                if ((i & 1) == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag2 == flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                andler.ping(flag, i, 0);
                return true;

            case 7: // '\007'
                if (l != 8)
                {
                    throw a("TYPE_GOAWAY length: %d != 8", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.j();
                j = a.j();
                ErrorCode errorcode1 = ErrorCode.c(j);
                if (errorcode1 == null)
                {
                    throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                } else
                {
                    andler.goAway(i & 0x7fffffff, errorcode1, ByteString.a);
                    return true;
                }

            case 8: // '\b'
                andler.headers(false, false, a.j() & 0x7fffffff, -1, c.a(l - 4), HeadersMode.c);
                return true;

            case 9: // '\t'
                break;
            }
            if (l != 8)
            {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                    Integer.valueOf(l)
                });
            }
            i = a.j();
            long l1 = a.j() & 0x7fffffff;
            if (l1 == 0L)
            {
                throw a("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l1)
                });
            } else
            {
                andler.windowUpdate(i & 0x7fffffff, l1);
                return true;
            }
        }
        if ((j & 1) != 0)
        {
            flag = true;
        }
        andler.data(flag, k & 0x7fffffff, a, l);
        return true;
    }

    public final void readConnectionPreface()
    {
    }

    andler(BufferedSource bufferedsource, boolean flag)
    {
        a = bufferedsource;
        c = new NameValueBlockReader(a);
        b = flag;
    }
}
