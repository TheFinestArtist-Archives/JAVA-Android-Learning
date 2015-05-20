// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.http.RetryableSink;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

public final class Util
{

    public static final byte a[] = new byte[0];
    public static final String b[] = new String[0];
    public static final Charset c = Charset.forName("US-ASCII");
    public static final Charset d = Charset.forName("UTF-8");
    private static final RetryableSink e = new RetryableSink(0);

    public static int a(String s)
    {
        if ("http".equals(s))
        {
            return 80;
        }
        return !"https".equals(s) ? -1 : 443;
    }

    private static int a(String s, int i)
    {
        if (i != -1)
        {
            return i;
        } else
        {
            return a(s);
        }
    }

    public static int a(URI uri)
    {
        return a(uri.getScheme(), uri.getPort());
    }

    public static int a(URL url)
    {
        return a(url.getProtocol(), url.getPort());
    }

    public static RetryableSink a()
    {
        return e;
    }

    public static List a(List list)
    {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static transient List a(Object aobj[])
    {
        return Collections.unmodifiableList(Arrays.asList((Object[])((Object []) (aobj)).clone()));
    }

    public static void a(long l, long l1)
    {
        if ((0L | l1) < 0L || 0L > l || l - 0L < l1)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
    }

    public static void a(Closeable closeable, Closeable closeable1)
    {
        Object obj = null;
        closeable.close();
        closeable = obj;
_L4:
        closeable1.close();
        closeable1 = closeable;
_L2:
        if (closeable1 == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        closeable1 = closeable;
        if (closeable == null)
        {
            closeable1 = throwable;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (closeable1 instanceof IOException)
        {
            throw (IOException)closeable1;
        }
        if (closeable1 instanceof RuntimeException)
        {
            throw (RuntimeException)closeable1;
        }
        if (closeable1 instanceof Error)
        {
            throw (Error)closeable1;
        } else
        {
            throw new AssertionError(closeable1);
        }
        closeable;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder("not a readable directory: ")).append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                a(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder("failed to delete file: ")).append(file).toString());
            }
        }

    }

    public static void a(Socket socket)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
        return;
        socket;
        throw socket;
        socket;
    }

    public static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static boolean a(Source source)
    {
        long l = System.nanoTime();
        Buffer buffer = new Buffer();
        for (; TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < 100L; buffer.o())
        {
            if (source.b(buffer, 2048L) == -1L)
            {
                return true;
            }
        }

        return false;
    }

    public static String b(String s)
    {
        try
        {
            s = ByteString.a(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"))).c();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public static ThreadFactory c(String s)
    {
        return new _cls1(s);
    }


    private class _cls1
        implements ThreadFactory
    {

        final String a;
        final boolean b = true;

        public final Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable, a);
            runnable.setDaemon(b);
            return runnable;
        }

        _cls1(String s)
        {
            a = s;
            super();
        }
    }

}
